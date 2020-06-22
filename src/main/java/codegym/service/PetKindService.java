package codegym.service;


import codegym.model.PetKind;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PetKindService {
    Page<PetKind> findAll(Pageable pageable);

    PetKind findById(Long id);

    void save(PetKind petKind);

    void remove(Long id);
}
