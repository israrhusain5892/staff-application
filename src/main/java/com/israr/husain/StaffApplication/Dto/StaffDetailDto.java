package com.israr.husain.StaffApplication.Dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class StaffDetailDto {

    private int id;
    //   staff details
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

    //    personal details
    private String firstName;
    private String middleName;
    private String lastName;
    private Long mobileNumber;
    private Long emergencyContactNumber;
    private String gender;
    @JsonFormat(pattern="dd-MM-yyyy")
    private Date dob;
    private String emailId;
    private String permanentAddress;
    private String correspondingAddress;
    private String religion;

//    other details

    private String aadhaarNumber;
    private String panNumber;
    @JsonFormat(pattern="dd-MM-yyyy")
    private Date dateOfJoining;
    private String staffReferenceCode;
    private String salaryPayType;
    private String residentNumber;
    private String citizenShip;
}
