package hosting.repository;

import hosting.models.Tbl_data;
import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;

public interface ITbl_dataRepo extends CrudRepository<Tbl_data, Long> {
    @Query(value = "SELECT COUNT(article_id) FROM tbl_data", nativeQuery = true)
    Long countData();
}
