package odeiojava.repository;

import org.springframework.data.repository.CrudRepository;

import odeiojava.models.Empresa;

public interface EmpresaRepository extends CrudRepository<Empresa, Long>{
	
}
