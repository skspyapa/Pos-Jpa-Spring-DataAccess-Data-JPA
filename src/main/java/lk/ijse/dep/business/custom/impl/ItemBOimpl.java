package lk.ijse.dep.business.custom.impl;

import lk.ijse.dep.business.custom.ItemBO;
import lk.ijse.dep.dao.custom.ItemDAO;
import lk.ijse.dep.dbpos.JpaUtil;
import lk.ijse.dep.dto.ItemDTO;
import lk.ijse.dep.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;
import java.util.stream.Collectors;
@Component
@Transactional
public class ItemBOimpl implements ItemBO {
    @Autowired
    private ItemDAO itemDAO;

public List<ItemDTO> getAll() throws Exception {

        List<ItemDTO> collect = itemDAO.findAll().stream().map(item -> new ItemDTO(item.getCode(), item.getDescription(), item.getUnitPrice(), item.getQtyOnHand())).collect(Collectors.toList());
        return collect;

}
    public boolean save(ItemDTO dto) throws Exception {
            itemDAO.save(new Item(dto.getCode(), dto.getDescription(), dto.getUnitPrice(), dto.getQtyOnHand()));
            return true;
    }

    public boolean remove(String  code) throws Exception {
            itemDAO.deleteById(code);
            return true;
    }

    public boolean update(ItemDTO dto) throws Exception {

            itemDAO.save(new Item(dto.getCode(), dto.getDescription(), dto.getUnitPrice(), dto.getQtyOnHand()));
            return true;
    }
    public ItemDTO get(String code) throws Exception {
            Item item = itemDAO.getOne(code);
            return new ItemDTO(item.getCode(),item.getDescription(),item.getUnitPrice(),item.getQtyOnHand());


    }

    public String getMaxItemCode() throws Exception {
            String maxItemCode = itemDAO.getTopItemCode();
         return maxItemCode;
    }
}
