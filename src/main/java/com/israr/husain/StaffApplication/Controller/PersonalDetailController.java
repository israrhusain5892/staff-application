package com.israr.husain.StaffApplication.Controller;

import com.israr.husain.StaffApplication.Dto.PersonalDetailDto;
import com.israr.husain.StaffApplication.Model.PersonalDetail;
import com.israr.husain.StaffApplication.Service.ServiceImpl.PersonalDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.ResultSet;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/personal")
public class PersonalDetailController {

    @Autowired
    private PersonalDetailServiceImpl personalDetailService;

    @PostMapping("/add/{staffId}")
    public ResponseEntity<PersonalDetailDto> addPersonalDetail(@RequestBody PersonalDetailDto personalDetailDto,
                                                               @PathVariable UUID staffId) {
        PersonalDetailDto personalDetailDto1 = personalDetailService.addPersonalDetail(personalDetailDto, staffId);
        return new ResponseEntity<>(personalDetailDto1, HttpStatus.CREATED);
    }

    @PutMapping("/{personalId}/{staffId}")
    public ResponseEntity<PersonalDetailDto> updatePersonalDetail(@RequestBody PersonalDetailDto personalDetailDto
            , @PathVariable UUID personalId, @PathVariable UUID staffId) {
        PersonalDetailDto personalDetailDto1 = personalDetailService.updatePersonalDetail(personalDetailDto, personalId, staffId);
        return new ResponseEntity<>(personalDetailDto1, HttpStatus.CREATED);
    }


    @GetMapping("/{personalId}")
    public ResponseEntity<PersonalDetailDto> getPersonalDetail(@PathVariable UUID personalId) {
        PersonalDetailDto personalDetailDto1 = personalDetailService.getPersonalDetailById(personalId);
        return new ResponseEntity<>(personalDetailDto1, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{personalId}")
    public ResponseEntity<String> deletePersonalDetail(@PathVariable UUID personalId) {
        String res = personalDetailService.deletePersonalDetail(personalId);
        return new ResponseEntity<>(res, HttpStatus.ACCEPTED);
    }

    @GetMapping("/")
    public ResponseEntity<List<PersonalDetailDto>> getPersonalDetail() {
       List<PersonalDetailDto> personalDetailDto1 = personalDetailService.getAllPersonalDetails();
        return new ResponseEntity<>(personalDetailDto1, HttpStatus.ACCEPTED);
    }


}