package codegym.repository;


import codegym.model.PetType;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PetTypeRepository extends PagingAndSortingRepository<PetType,Long> {
}
