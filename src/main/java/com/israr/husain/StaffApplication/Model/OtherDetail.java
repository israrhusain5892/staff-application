package com.israr.husain.StaffApplication.Model;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OtherDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID otherId;
    private String aadhaarNumber;
    private String panNumber;
    @JsonFormat(pattern="dd-MM-yyyy")
    private Date dateOfJoining;
    private String staffReferenceCode;
    private String salaryPayType;
    private String residentNumber;
    private String citizenShip;

    @OneToOne
    @JoinColumn(name="personalId")
    private PersonalDetail personalDetail;
}
