package codegym.service.impl;


import codegym.model.PetKind;
import codegym.repository.PetKindRepository;
import codegym.service.PetKindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class PetKindServiceImpl implements PetKindService {
    @Autowired
    private PetKindRepository petKindRepository;

    @Override
    public Page<PetKind> findAll(Pageable pageable) {
        return petKindRepository.findAll(pageable);
    }

    @Override
    public PetKind findById(Long id) {
        return petKindRepository.findById(id).get();
    }

    @Override
    public void save(PetKind petKind) {
        petKindRepository.save(petKind);
    }

    @Override
    public void remove(Long id) {
        petKindRepository.deleteById(id);
    }
}
