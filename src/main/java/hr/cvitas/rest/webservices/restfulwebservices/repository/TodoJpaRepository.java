package hr.cvitas.rest.webservices.restfulwebservices.repository;

import java.util.List;

import hr.cvitas.rest.webservices.restfulwebservices.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoJpaRepository extends JpaRepository<Todo, Long>{
    List<Todo> findByUsername(String username);
}
