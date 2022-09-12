package com.healthcare.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.healthcare.models.DiagnosticCenter;
import com.healthcare.services.DiagnosticCenterService;
import com.healthcare.services.DiagnosticTestService;

@CrossOrigin
@RestController
@RequestMapping("/api/centers")
public class DiagnosticCenterController {

	@Autowired private DiagnosticCenterService dservice;
	@Autowired private DiagnosticTestService tservice;
	
	@PostMapping("")
	public ResponseEntity<?> addCenter(@RequestBody DiagnosticCenter center) {
		dservice.addDiagnosticCenter(center);
		return ResponseEntity.ok(center);
	}
	
	@PostMapping("/{centerId}/test/{testId}")
	public ResponseEntity<?> addTesttoCenter(@PathVariable("centerId") int centerId,@PathVariable("testId") int testId) {
		dservice.addTestToDiagnosticCenter(centerId, tservice.viewById(testId));
		Map<String,String> map=new HashMap<>();
		map.put("msg", "Test added successfully");
		return ResponseEntity.ok(map);
	}
	
	@GetMapping("test/{testId}")
	public ResponseEntity<?> getCentersForTest(@PathVariable("testId") int testId) {
		return ResponseEntity.ok(dservice.getDiagnosticCentersFromTest(testId));
	}
	
	@DeleteMapping("test/{centerId}/{testId}")
	public ResponseEntity<?> deleteTestFromCenter(@PathVariable("centerId") int centerId,@PathVariable("testId") int testId) {
		dservice.removeTestFromDiagnosticCenter(centerId, tservice.viewById(testId));
		Map<String,String> map=new HashMap<>();
		map.put("msg", "Test removed successfully");
		return ResponseEntity.ok(map);
	}
	
	@GetMapping
	public ResponseEntity<?> listAll(){
		return ResponseEntity.ok(dservice.getAllDiagnosticCenters());
	}
	
	@GetMapping("{id}")
	public ResponseEntity<?> findById(@PathVariable("id") int centerId){
		return ResponseEntity.ok(dservice.getDiagnosticCenter(centerId));
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<?> deleteCenter(@PathVariable("id") int centerId){
		DiagnosticCenter diagnosticCenter=dservice.getDiagnosticCenter(centerId);
		dservice.removeDiagnosticCenter(diagnosticCenter);
		Map<String,String> map=new HashMap<>();
		map.put("msg", "Center Deleted successfully");
		return ResponseEntity.ok(map);
	}
}
