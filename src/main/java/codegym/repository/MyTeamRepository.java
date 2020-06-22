package codegym.repository;


import codegym.model.MyTeam;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface MyTeamRepository extends PagingAndSortingRepository<MyTeam,Long> {
}
