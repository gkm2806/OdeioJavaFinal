package odeiojava.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import odeiojava.models.Team;
import odeiojava.repository.TeamRepository;

@RestController
public class TeamController {
	
	@Autowired
	private TeamRepository rep;
	
	@CrossOrigin(origins = "*")
    @RequestMapping(value="/teams/add",method=RequestMethod.POST)
    public Team Add(@RequestParam(value="nome") String nome, @RequestParam(value="empresa") String empresa) {
        Team alo = new Team(nome,empresa);
        rep.save(alo);
        return alo;
    }
    
	@CrossOrigin(origins = "*")
    @RequestMapping(value="/teams",method=RequestMethod.GET)
    public List<Team> List() {
        return (List<Team>) rep.findAll();
    }
    
	@CrossOrigin(origins = "*")
    @RequestMapping(value="/teams/count",method=RequestMethod.GET)
    public Long Count() {
        return rep.count();
    }
    
	@CrossOrigin(origins = "*")
    @RequestMapping(value="/teams/delete",method=RequestMethod.DELETE)
	 public void Delete(@RequestParam(value="id") long id) {      
        rep.delete(id);
    }
    
}
