package com.israr.husain.StaffApplication.Dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OtherDetailDto {
     private int otherId;
    private String aadhaarNumber;
    private String panNumber;
    @JsonFormat(pattern="dd-MM-yyyy")
    private Date dateOfJoining;
    private String staffReferenceCode;
    private String salaryPayType;
    private String residentNumber;
    private String citizenShip;
    private PersonalDetailDto personalDetailDto;
}
