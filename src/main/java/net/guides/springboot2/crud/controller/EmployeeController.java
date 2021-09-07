package net.guides.springboot2.crud.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.guides.springboot2.crud.exception.ResourceNotFoundException;
import net.guides.springboot2.crud.model.Employee;
import net.guides.springboot2.crud.repository.EmployeeRepository;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	@Autowired
	private EmployeeRepository employeeRepository;

	@PostMapping("/load")
	public Map<String, Boolean> createEmployee(@RequestBody Employee employee) {
		employeeRepository.save(employee);
		Map<String, Boolean> response1 = new HashMap<>();
		response1.put("Loads details added Successfully", Boolean.TRUE);
		return response1;
	}

	@GetMapping("/load/shipperId")
	public ResponseEntity<List<Employee>> getEmployeeByShipperId(@RequestParam Long shipperId) {
		return new ResponseEntity<List<Employee>>(employeeRepository.findByshipperId(shipperId), HttpStatus.OK);

	}

	@GetMapping("/load/{loadId}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "loadId") Long loadId)
			throws ResourceNotFoundException {
		Employee employee = employeeRepository.findById(loadId)
				.orElseThrow(() -> new ResourceNotFoundException("load not found for this loadId :: " + loadId));
		return ResponseEntity.ok().body(employee);
	}

	@PutMapping("/load/{loadId}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "loadId") Long loadId,
			@RequestBody Employee employeeDetails) throws ResourceNotFoundException {
		Employee employee = employeeRepository.findById(loadId)
				.orElseThrow(() -> new ResourceNotFoundException("load not found for this loadId :: " + loadId));

		employee.setShipperId(employeeDetails.getShipperId());
		employee.setLoadingPoint(employeeDetails.getLoadingPoint());
		employee.setUnloadingPoint(employeeDetails.getUnloadingPoint());
		employee.setProductType(employeeDetails.getProductType());
		employee.setTruckType(employeeDetails.getTruckType());
		employee.setNoOfTruck(employeeDetails.getNoOfTruck());
		employee.setWeight(employeeDetails.getWeight());
		employee.setComment(employeeDetails.getComment());
		employee.setDate(employeeDetails.getDate());
		final Employee updatedEmployee = employeeRepository.save(employee);
		return ResponseEntity.ok(updatedEmployee);
	}

	@DeleteMapping("/load/{loadId}")
	public Map<String, Boolean> deleteEmployee(@PathVariable(value = "loadId") Long loadId)
			throws ResourceNotFoundException {
		Employee employee = employeeRepository.findById(loadId)
				.orElseThrow(() -> new ResourceNotFoundException("load not found for this loadId :: " + loadId));

		employeeRepository.delete(employee);
		Map<String, Boolean> response = new HashMap<>();
		response.put("Details Deleted", Boolean.TRUE);
		return response;
	}
}