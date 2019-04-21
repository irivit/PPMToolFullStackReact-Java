package ppmtool.pptmtool.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ppmtool.pptmtool.domain.Project;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long>{
    @Override
    Iterable<Project> findAllById(Iterable<Long> iterable);
}
