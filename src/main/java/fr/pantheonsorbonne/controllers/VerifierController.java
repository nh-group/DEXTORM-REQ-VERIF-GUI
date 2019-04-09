package fr.pantheonsorbonne.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import fr.pantheonsorbonne.repositories.VerifierRepository;
import fr.pantheonsorbonne.entities.Verifier;

@Controller
@RequestMapping(path = "/verifier")
public class VerifierController {
	
	 @Autowired
	 VerifierRepository verfierRepository;
	 
	 @GetMapping(path = "/addVerifier")
	 @ResponseBody
	 
	 public String addVerfiier(@RequestParam String VerifName) {

	        Verifier verifier = new Verifier(VerifName, 0, null);
	        

	        verfierRepository.save(verifier);

	        String ret = "Verifier has been added, name = " + VerifName;

	        return ret;

	    }

}
