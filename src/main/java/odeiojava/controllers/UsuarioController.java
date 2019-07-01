package odeiojava.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import odeiojava.models.Usuario;
import odeiojava.repository.UsuarioRepository;

@RestController
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository rep;
	
	@CrossOrigin(origins = "*")
    @RequestMapping(value="/usuarios/add",method=RequestMethod.POST)
    public Usuario Add(@RequestParam(value="nome") String nome, @RequestParam(value="senha") String senha) {
		List<Usuario> users = (List<Usuario>) rep.findAll();
		for(Usuario i : users)if(i.getNome().equals(nome)) throw new RuntimeException("usuario ja existe");
        Usuario alo = new Usuario(nome,senha);
        rep.save(alo);
        return alo;
    }
    
	@CrossOrigin(origins = "*")
	@RequestMapping(value="/usuarios/login",method=RequestMethod.POST)
    public Boolean Login(@RequestParam(value="nome") String nome, @RequestParam(value="senha") String senha) {
		Boolean isUser = false;
		List<Usuario> users = (List<Usuario>) rep.findAll();
		for(Usuario i : users) {
			if(i.getNome().equals(nome) && i.getPassword().equals(senha)){
				isUser = true;
			}
		}
        return isUser;
    }
	
	@CrossOrigin(origins = "*")
    @RequestMapping(value="/usuarios/count",method=RequestMethod.GET)
    public Long Count() {
        return rep.count();
    }
    
	@CrossOrigin(origins = "*")
    @RequestMapping(value="/usuarios/delete",method=RequestMethod.DELETE)
	 public void Delete(@RequestParam(value="id") long id) {      
        rep.delete(id);
    }
    
}
