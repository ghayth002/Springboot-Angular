package tn.barmegtech.workshopformationspring.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.util.Date;
import java.util.List;
import java.util.Set;

public class Listemployedto {
    private Long id;

    private String fullname;
    private String img;
    private Long age;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dateRecrutement;
    private Departementdto dept;
    private AddresseDtO addrdto;
    private List<Competencesdto> competences;
}
