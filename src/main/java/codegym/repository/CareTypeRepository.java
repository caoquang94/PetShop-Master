package codegym.repository;


import codegym.model.CareType;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CareTypeRepository extends PagingAndSortingRepository<CareType,Long> {
}
