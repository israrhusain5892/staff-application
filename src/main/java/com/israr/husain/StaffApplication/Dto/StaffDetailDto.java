package com.israr.husain.StaffApplication.Dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class StaffDetailDto {

    private UUID id;
    private String employment_Status;
    private String staffType;
    private String staffDepartment;
    private String employmentCategory;
    private String designation;
    private String qualificationType;
    private String educationQualification;
    private String accessLevel;
    private String trainedAs;
    private String ctet_Qualified;




}
