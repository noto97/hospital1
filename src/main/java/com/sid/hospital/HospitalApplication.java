package com.sid.hospital;

import ch.qos.logback.core.CoreConstants;
import com.sid.hospital.dao.PatientRepository;
import com.sid.hospital.entities.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class HospitalApplication implements CommandLineRunner {

	@Autowired
	private PatientRepository patientRepository;
	public static void main(String[] args) {
		SpringApplication.run(HospitalApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		patientRepository.save(new Patient(null,"Yassine",new Date(),false,55));
		patientRepository.save(new Patient(null,"Yasmine",new Date(),false,5));
		patientRepository.save(new Patient(null,"Tarik",new Date(),true,11));
		patientRepository.save(new Patient(null,"Hassan",new Date(),true,78));
		patientRepository.findAll().forEach(p ->{System.out.println(p.getName());});
	}
}
