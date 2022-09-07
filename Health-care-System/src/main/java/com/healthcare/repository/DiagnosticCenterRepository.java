package com.healthcare.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.healthcare.models.DiagnosticCenter;
import org.springframework.stereotype.Repository;


@Repository
public interface DiagnosticCenterRepository extends JpaRepository<DiagnosticCenter, Integer> {

	List<DiagnosticCenter> findByTests_id(int testId);
	
}
