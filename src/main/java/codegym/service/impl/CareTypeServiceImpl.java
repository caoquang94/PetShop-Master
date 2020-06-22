package codegym.service.impl;


import codegym.model.CareType;
import codegym.repository.CareTypeRepository;
import codegym.service.CareTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class CareTypeServiceImpl implements CareTypeService {
    @Autowired
    private CareTypeRepository careTypeRepository;

    @Override
    public Page<CareType> findAll(Pageable pageable) {
        return careTypeRepository.findAll(pageable);
    }

    @Override
    public CareType findById(Long id) {
        return careTypeRepository.findById(id).get();
    }

    @Override
    public void save(CareType careType) {
        careTypeRepository.save(careType);
    }

    @Override
    public void remove(Long id) {
        careTypeRepository.deleteById(id);
    }
}
