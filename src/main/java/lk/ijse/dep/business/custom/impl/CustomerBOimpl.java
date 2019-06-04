package lk.ijse.dep.business.custom.impl;

import lk.ijse.dep.business.custom.CustomerBO;
import lk.ijse.dep.dao.custom.CustomerDAO;
import lk.ijse.dep.dbpos.JpaUtil;
import lk.ijse.dep.dto.CustomerDTO;
import lk.ijse.dep.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;
import java.util.stream.Collectors;
@Component
@Transactional
public class CustomerBOimpl implements CustomerBO {
    @Autowired
    private CustomerDAO customerDAO;

    public List<CustomerDTO> getAll() throws Exception {

            List<CustomerDTO> collect = customerDAO.findAll().stream().map(customer -> new CustomerDTO(customer.getId(),customer.getName(),customer.getAddress(),customer.getSalary())).collect(Collectors.toList());
            return collect;
        
}
            public boolean save(CustomerDTO dto) throws Exception {

                    customerDAO.save(new Customer(dto.getId(), dto.getName(), dto.getAddress(), dto.getSalary()));
                    return true;
            }

            public boolean remove(String  id) throws Exception {
                    customerDAO.deleteById(id);
                    return true;
            }

            public boolean update(CustomerDTO dto) throws Exception {
                    customerDAO.save(new Customer(dto.getId(), dto.getName(), dto.getAddress(), dto.getSalary()));

                    return true;
            }
            public CustomerDTO get(String id) throws Exception {
                    Customer customer = customerDAO.getOne(id);
                    return new CustomerDTO(customer.getId(),customer.getName(),customer.getAddress(),customer.getSalary());
            }
            public List<CustomerDTO> getCustomerId() throws Exception {
                    List<CustomerDTO> collect = customerDAO.findAll().stream().map(customer -> new CustomerDTO(customer.getId())).collect(Collectors.toList());
                    return collect;
            }
            public String getMaxCustId() throws Exception {
                    String maxCustId = customerDAO.getTopCustomerId();
                    return maxCustId;
            }
}
