package fr.pantheonsorbonne.controllers;

import java.util.ArrayList;
import java.util.Deque;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import fr.pantheonsorbonne.cri.SpringBootWebApplication;
import fr.pantheonsorbonne.cri.requirements.Requirement;
import fr.pantheonsorbonne.entities.Exigence;
import fr.pantheonsorbonne.entities.Verifier;
import fr.pantheonsorbonne.repositories.ExigenceRepository;
import fr.pantheonsorbonne.repositories.VerifierRepository;



@Controller
@RequestMapping(path = "/exigence")
public class ExigenceController {


	 @Autowired
	 ExigenceRepository exigenceRepository;
	 
	 
	 public void Initilize_Exigence() {
		 Deque<Requirement> reqs = SpringBootWebApplication.req;
		 ArrayList <Exigence> exigences = new ArrayList<Exigence>();
		 for(Requirement r : reqs){
             Exigence e = new Exigence();
             e.setText(r.toString());
          }
	 }
	 
	 
	 
	 @GetMapping(path = "/addExigence")
	 @ResponseBody
	 
	 public String addExigence(@RequestParam String ExigenceName) {

	        String ret = "Exigence has been added, name = " + ExigenceName;

	        return ret;

	    }
	    
}
