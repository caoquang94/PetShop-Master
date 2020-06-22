package codegym.repository;


import codegym.model.CareDetail;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CareDetailRepository extends PagingAndSortingRepository<CareDetail,Long> {
}
