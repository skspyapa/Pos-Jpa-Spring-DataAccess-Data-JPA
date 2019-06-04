package lk.ijse.dep.dao.custom;

import lk.ijse.dep.entity.ItemDetail;
import lk.ijse.dep.entity.ItemDetailPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemDetailDAO extends JpaRepository<ItemDetail,ItemDetailPK> {

}
