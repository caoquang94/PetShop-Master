package codegym.service;


import codegym.model.Pet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PetService {
    Page<Pet> findAll(Pageable pageable);

    Pet findById(Long id);

    void save(Pet pet);

    void remove(Long id);
}
