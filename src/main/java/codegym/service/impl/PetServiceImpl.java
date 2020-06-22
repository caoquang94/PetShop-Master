package codegym.service.impl;


import codegym.model.Pet;
import codegym.repository.PetRepository;
import codegym.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class PetServiceImpl implements PetService {
    @Autowired
    private PetRepository petRepository;

    @Override
    public Page<Pet> findAll(Pageable pageable) {
        return petRepository.findAll(pageable);
    }

    @Override
    public Pet findById(Long id) {
        return petRepository.findById(id).get();
    }

    @Override
    public void save(Pet pet) {
        petRepository.save(pet);
    }

    @Override
    public void remove(Long id) {
        petRepository.deleteById(id);
    }
}
