package codegym.service;


import codegym.model.CareDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CareDetailService {
    Page<CareDetail> findAll(Pageable pageable);

    CareDetail findById(Long id);

    void save(CareDetail careDetail);

    void remove(Long id);
}
