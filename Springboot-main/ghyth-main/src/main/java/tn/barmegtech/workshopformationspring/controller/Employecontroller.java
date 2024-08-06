package tn.barmegtech.workshopformationspring.controller;

import java.util.List;

import jakarta.validation.Valid;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import tn.barmegtech.workshopformationspring.configimage.ImageStorage;
import tn.barmegtech.workshopformationspring.dto.Employedto;
import tn.barmegtech.workshopformationspring.entites.Employee;
import tn.barmegtech.workshopformationspring.servics.EmployeSevice;



@RestController
@RequestMapping("/api/v1/employe")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:4200")
public class Employecontroller {
	private final EmployeSevice employeSevice;
	private final ImageStorage imageStorage;
	@PostMapping("/saveemp")
	public Employedto ajouter(@RequestBody @Valid Employedto empdto) {

		return employeSevice.ajouter(empdto);
	}

@DeleteMapping("/deleteemp/{id}")
	public void deletbyid(@PathVariable("id") Long id) {
		employeSevice.deletbyid(id);
	}
@PostMapping("/updateemp")
	public Employedto metreajour(@RequestBody Employedto empdto) {
		return employeSevice.metreajour(empdto);
	}
	@GetMapping("/findbyid/{id}")
	public Employedto findbyid(@PathVariable("id") Long id) {
		return employeSevice.findbyid(id);
	}
	@GetMapping("/lister")
	public List<Employedto> lister() {
		return employeSevice.lister();
	}
	@GetMapping("/lister/{key}")
	public List<Employedto> chercherparnom(@PathVariable("key") String key) {
		return employeSevice.chercherparnom(key);
	}
	@GetMapping("/listerbyresp/{key}")
	public List<Employedto> chercherparresponsable(@PathVariable("key") String key) {
		return employeSevice.chercherparRespEmp(key);
	}
	@PostMapping("/uploadImage/{id}")
	public Employee uploadImageEmployee(@PathVariable Long id, MultipartFile image) {
		return employeSevice.uploadImageEmployee(id, image);
	}
		

		@GetMapping("/downloadempltImage/{imageName}")
		public ResponseEntity<Resource> downloadTeacherImage(@PathVariable String imageName, HttpServletRequest request) {
			return this.imageStorage.downloadUserImage(imageName, request);
		}
		@GetMapping("/listallemp")
		public List<Employee> employeeList() {
			return employeSevice.employees();
		}

}
