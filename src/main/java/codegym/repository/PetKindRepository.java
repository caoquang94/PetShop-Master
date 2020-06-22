package codegym.repository;


import codegym.model.PetKind;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PetKindRepository extends PagingAndSortingRepository<PetKind,Long> {
}
