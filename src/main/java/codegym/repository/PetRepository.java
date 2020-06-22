package codegym.repository;


import codegym.model.Pet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PetRepository extends PagingAndSortingRepository<Pet,Long> {
    Page<Pet> findAllByName(String name, Pageable pageable);
}
