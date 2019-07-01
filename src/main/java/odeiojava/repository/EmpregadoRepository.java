package odeiojava.repository;

import org.springframework.data.repository.CrudRepository;

import odeiojava.models.Empregado;

public interface EmpregadoRepository extends CrudRepository<Empregado, Long>{
	
}
