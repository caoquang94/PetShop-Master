package codegym.service.impl;


import codegym.model.CareDetail;
import codegym.repository.CareDetailRepository;
import codegym.service.CareDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class CareDetailServiceImpl implements CareDetailService {
    @Autowired
    private CareDetailRepository careDetailRepository;

    @Override
    public Page<CareDetail> findAll(Pageable pageable) {
        return careDetailRepository.findAll(pageable);
    }

    @Override
    public CareDetail findById(Long id) {
        return careDetailRepository.findById(id).get();
    }

    @Override
    public void save(CareDetail careDetail) {
        careDetailRepository.save(careDetail);
    }

    @Override
    public void remove(Long id) {
        careDetailRepository.deleteById(id);
    }
}
