package hosting.service;

import hosting.models.Tbl_data;
import hosting.repository.ITbl_dataRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class Tbl_dataService implements ITbl_dataService {
    @Autowired
    ITbl_dataRepo iTbl_dataRepo;


    @Override
    public Tbl_data save(Tbl_data tbl_data) {
        return iTbl_dataRepo.save(tbl_data);
    }

    @Override
    public Optional<Tbl_data> findById(long is_approve) {
        return iTbl_dataRepo.findById(is_approve);
    }

    @Override
    public void delete(Tbl_data tbl_data) {
        iTbl_dataRepo.delete(tbl_data);
    }

    @Override
    public void edit(Tbl_data tbl_data) {
        iTbl_dataRepo.save(tbl_data);
    }

    @Override
    public ArrayList<Tbl_data> findAll() {
        return (ArrayList<Tbl_data>) iTbl_dataRepo.findAll();
    }

    @Override
    public Long countData() {
        return iTbl_dataRepo.countData();
    }


}
