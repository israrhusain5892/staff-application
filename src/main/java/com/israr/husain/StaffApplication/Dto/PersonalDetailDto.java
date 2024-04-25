package com.israr.husain.StaffApplication.Dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonalDetailDto {

    private int personalId;
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
    private StaffDetailDto staffDetailDto;
}