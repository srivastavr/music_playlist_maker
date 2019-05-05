package net.guides.springboot2.springboot2jpacrudexample.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.guides.springboot2.springboot2jpacrudexample.model.Employee;
import net.guides.springboot2.springboot2jpacrudexample.model.Songs;
import net.guides.springboot2.springboot2jpacrudexample.model.playlistmodel;
import net.guides.springboot2.springboot2jpacrudexample.repository.EmployeeRepository;
import net.guides.springboot2.springboot2jpacrudexample.repository.playlistrepo;
import net.guides.springboot2.springboot2jpacrudexample.repository.songsRepository;


@RestController
@RequestMapping("/api/v1")
public class EmployeeController {
	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private songsRepository songsRepository;
	@Autowired
	private playlistrepo playlistrepository;

	@GetMapping("/employees")
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}
	@GetMapping("/songs")
	public List<Songs> getAllsongs() {
		return songsRepository.findAll();
	}
	//playlist_data
	@GetMapping("/getplaylist")
	public List<playlistmodel> getplaylistbyuser(@Valid @RequestParam String userid) {
		List<playlistmodel> employeebc = playlistrepository.findById(userid);
		return employeebc;
		//return playlistrepository.findAll();
	}
	@GetMapping("/songs1")
	public HashMap<String, Object> get1songs() {
		List<Songs> abc= songsRepository.findAll();
		HashMap<String, Object> one=new HashMap<String, Object>();
		one.put("title", "12");
		List<HashMap<String, Object>> two=new ArrayList<>();
		
		for(int i=0;i<abc.size();i++)
		{
			HashMap<String, Object> three=new HashMap<String, Object>();
			three.put("url", abc.get(i).getSong_data());
			
			two.add(three);
		}
		
		one.put("songs", two);
		return one;
		//return songsRepository.findAll();
	}

	@PostMapping("/loginuser")
	public Employee loginuser(@Valid @RequestBody Employee employee) {
		Employee employee123 = employeeRepository.checkuser(employee.getusername(),employee.getPassword());
		return employee123;
	}
	@PostMapping("/adduser")
	public Employee createEmployee(@Valid @RequestBody Employee employee) {
		return employeeRepository.save(employee);
	}


	/*@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") Long employeeId)
			throws ResourceNotFoundException {
		Employee employee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
		return ResponseEntity.ok().body(employee);
	}*/
	/*@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") Long employeeId,
			@Valid @RequestBody Employee employeeDetails) throws ResourceNotFoundException {
		Employee employee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));

		employee.setusername(employeeDetails.getusername());
		employee.setLastName(employeeDetails.getLastName());
		employee.setFirstName(employeeDetails.getFirstName());
		final Employee updatedEmployee = employeeRepository.save(employee);
		return ResponseEntity.ok(updatedEmployee);
	}
*/
	/*@DeleteMapping("/employees/{id}")
	public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long employeeId)
			throws ResourceNotFoundException {
		Employee employee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));

		employeeRepository.delete(employee);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}*/
}
