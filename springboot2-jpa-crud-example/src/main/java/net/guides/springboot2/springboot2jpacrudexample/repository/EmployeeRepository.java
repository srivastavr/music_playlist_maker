package net.guides.springboot2.springboot2jpacrudexample.repository;

import javax.validation.Valid;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import net.guides.springboot2.springboot2jpacrudexample.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

	
	/*@Query("SELECT u FROM User u WHERE u.status = ?1 and u.name = ?2")
	User findUserByStatusAndName(Integer status, String name);*/
	//Employee checkuser(@Valid Employee employee);
	@Query(value = "SELECT * FROM employees u WHERE u.username = ?1 and u.password = ?2", nativeQuery = true)
	Employee checkuser(String username,String password);
	  //User findByEmailAddress(String emailAddress);
}
