package odeiojava.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import odeiojava.models.Projeto;
import odeiojava.repository.ProjetoRepository;

@RestController
public class ProjetoController {
	
	@Autowired
	private ProjetoRepository rep;
	
	@CrossOrigin(origins = "*")
    @RequestMapping(value="/projetos/add",method=RequestMethod.POST)
    public Projeto Add(@RequestParam(value="nome") String nome,@RequestParam(value="estagio") String estagio, @RequestParam(value="team") String team, @RequestParam(value="empresa") String empresa) {
        Projeto alo = new Projeto(nome,estagio,empresa,team);
        rep.save(alo);
        return alo;
    }
    
	@CrossOrigin(origins = "*")
    @RequestMapping(value="/projetos",method=RequestMethod.GET)
    public List<Projeto> List() {
        return (List<Projeto>) rep.findAll();
    }
    
	@CrossOrigin(origins = "*")
    @RequestMapping(value="/projetos/count",method=RequestMethod.GET)
    public Long Count() {
        return rep.count();
    }
    
	@CrossOrigin(origins = "*")
    @RequestMapping(value="/projetos/delete",method=RequestMethod.DELETE)
	 public void delete(@RequestParam(value="id") long id) {      
        rep.delete(id);
    }
    
}
