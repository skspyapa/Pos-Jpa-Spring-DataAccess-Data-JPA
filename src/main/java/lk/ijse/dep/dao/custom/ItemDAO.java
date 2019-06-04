package lk.ijse.dep.dao.custom;

import lk.ijse.dep.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ItemDAO extends JpaRepository<Item,String> {

    @Query(value = "SELECT i.code from Item i ORDER BY i.code DESC limit 1",nativeQuery = true)
    String getTopItemCode() throws Exception;
}
