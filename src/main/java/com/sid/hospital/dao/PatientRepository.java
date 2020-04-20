package com.sid.hospital.dao;

import com.sid.hospital.entities.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
     Page<Patient> findByNameContains(String kw,Pageable pageable);
}
