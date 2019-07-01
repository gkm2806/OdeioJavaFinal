package odeiojava.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import odeiojava.models.Empresa;
import odeiojava.repository.EmpresaRepository;

@RestController
public class EmpresaController {
	
	@Autowired
	private EmpresaRepository rep;
	
	@CrossOrigin(origins = "*")
    @RequestMapping(value="/empresas/add",method=RequestMethod.POST)
    public Empresa Add(@RequestParam(value="nome") String nome,@RequestParam(value="slogan") String slogan) {
    	Empresa alo = new Empresa(nome,slogan);
        rep.save(alo);
        return alo;
    }
    
	@CrossOrigin(origins = "*")
    @RequestMapping(value="/empresas",method=RequestMethod.GET)
    public List<Empresa> List() {
        return (List<Empresa>) rep.findAll();
    }
    
	@CrossOrigin(origins = "*")
    @RequestMapping(value="/empresas/count",method=RequestMethod.GET)
    public Long Count() {
        return rep.count();
    }
	
	@CrossOrigin(origins = "*")
    @RequestMapping(value="/empresas/delete",method=RequestMethod.DELETE)
	 public void delete(@RequestParam(value="id") long id) {      
        rep.delete(id);
    }
    
}
