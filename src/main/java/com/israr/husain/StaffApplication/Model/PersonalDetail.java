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
@AllArgsConstructor
@NoArgsConstructor
public class PersonalDetail {
     @Id
     @GeneratedValue(strategy = GenerationType.UUID)
     private UUID personalId;
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

    @ManyToOne
    @JoinColumn(name="staffId")
    private StaffDetail staffDetail;

    @OneToOne(mappedBy = "personalDetail",cascade = CascadeType.ALL)
    private OtherDetail otherDetail;
}
