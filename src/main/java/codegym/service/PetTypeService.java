package codegym.service;


import codegym.model.PetType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PetTypeService {
    Page<PetType> findAll(Pageable pageable);

    PetType findById(Long id);

    void save(PetType petType);

    void remove(Long id);
}
