package hosting.service;

import hosting.models.Tbl_data;

import java.util.ArrayList;
import java.util.Optional;

public interface ITbl_dataService {
    Tbl_data save(Tbl_data tbl_data);
    Optional<Tbl_data> findById(long is_approve);
    void delete(Tbl_data tbl_data);
    void edit(Tbl_data tbl_data);
    ArrayList<Tbl_data> findAll();

    Long countData();

}
