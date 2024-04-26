package com.israr.husain.StaffApplication.Model;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StaffDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID staffId;

    private String employment_Status;
    private String staffType;
    private String staffDepartment;
    private String employmentCategory;
    private String designation;
    private String qualificationType;
    private String educationQualification;
    private String accessLevel;
    private String trainedAs;
    private String CTET_Qualified;

    @OneToMany(mappedBy = "staffDetail",cascade = CascadeType.ALL)
    private List<PersonalDetail> personalDetailList=new ArrayList<>();


}
