package com.sid.hospital.web;


import com.sid.hospital.dao.PatientRepository;
import com.sid.hospital.entities.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class PatientController {

    @Autowired
    private PatientRepository patientRepository;
    @GetMapping(path="/index")
    public String index() {
        return "index";
    }

    @GetMapping(path ="/patientsView" )
    public String liste(Model model,
                        @RequestParam(name = "page",defaultValue = "0")int p,
                        @RequestParam(name = "size",defaultValue = "5")int s,
                        @RequestParam(name = "keyword",defaultValue = "")String kw) {
        Page<Patient> pagePatients = patientRepository.findByNameContains(kw ,PageRequest.of(p,s));
        model.addAttribute("listPatients",pagePatients.getContent());
        model.addAttribute("pages",new int[pagePatients.getTotalPages()]);
        model.addAttribute("currentPage",p);
        model.addAttribute("keyword",kw);
        return "patientsView";
    }
}

