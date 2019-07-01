package odeiojava.repository;

import org.springframework.data.repository.CrudRepository;

import odeiojava.models.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long>{
	
}
