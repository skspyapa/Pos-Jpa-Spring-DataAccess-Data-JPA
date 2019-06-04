package lk.ijse.dep.dao.custom;

import lk.ijse.dep.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OrdersDAO extends JpaRepository<Orders,String> {

    @Query(value = "SELECT o.id from Orders o ORDER BY o.id DESC limit 1",nativeQuery = true)
    String getTopOrdersId() throws Exception;
}
