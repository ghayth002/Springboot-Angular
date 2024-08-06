package tn.barmegtech.workshopformationspring.servics;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import tn.barmegtech.workshopformationspring.dto.Employedto;
import tn.barmegtech.workshopformationspring.entites.Employee;

public interface EmployeSevice {
	Employedto ajouter(Employedto empdto);
	void deletbyid(Long id);
	Employedto metreajour(Employedto empdto);
	Employedto findbyid(Long id);

	List<Employedto> lister();

    List<Employee> employees();

    List<Employedto> chercherparnom(String key);
	List<Employedto> chercherparRespEmp(String key);
	Employee uploadImageEmployee(Long empId, MultipartFile image);

}
