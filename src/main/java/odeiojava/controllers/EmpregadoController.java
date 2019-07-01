package odeiojava.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import odeiojava.models.Empregado;
import odeiojava.repository.EmpregadoRepository;

@RestController
public class EmpregadoController {
	
	@Autowired
	private EmpregadoRepository rep;
	
	@CrossOrigin(origins = "*")
    @RequestMapping(value="/empregados/add",method=RequestMethod.POST)
    public Empregado Add(@RequestParam(value="nome") String nome,@RequestParam(value="idade") int idade, @RequestParam(value="cargo") String cargo, @RequestParam(value="empresa") String empresa, @RequestParam(value="salario") double salario) {
        Empregado alo = new Empregado(nome,cargo,empresa,salario);
        rep.save(alo);
        return alo;
    }
    
	@CrossOrigin(origins = "*")
    @RequestMapping(value="/empregados",method=RequestMethod.GET)
    public List<Empregado> List() {
        return (List<Empregado>) rep.findAll();
    }
    
	@CrossOrigin(origins = "*")
    @RequestMapping(value="/empregados/count",method=RequestMethod.GET)
    public Long Count() {
        return rep.count();
    }
    
	@CrossOrigin(origins = "*")
    @RequestMapping(value="/empregados/delete",method=RequestMethod.DELETE)
	 public void delete(@RequestParam(value="id") long id) {      
        rep.delete(id);
    }
    
}
