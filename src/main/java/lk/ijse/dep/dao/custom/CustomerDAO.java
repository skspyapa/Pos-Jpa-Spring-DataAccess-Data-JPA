package lk.ijse.dep.dao.custom;

import lk.ijse.dep.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerDAO extends JpaRepository<Customer,String> {

@Query(value = "SELECT c.id from Customer c ORDER BY c.id DESC limit 1",nativeQuery = true)
String getTopCustomerId() throws Exception;


@Query(value = "select * from Customer c where c.name LIKE :#{#name +'%'} AND  c.address LIKE :#{#address + '%'} ORDER By c.id DESC ",nativeQuery = true)
List<Customer> customQuery(@Param("name") String name,@Param("address") String address) throws Exception;
}
