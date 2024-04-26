package com.israr.husain.StaffApplication.Controller;

import com.israr.husain.StaffApplication.Dto.OtherDetailDto;
import com.israr.husain.StaffApplication.Dto.PersonalDetailDto;
import com.israr.husain.StaffApplication.Service.ServiceImpl.OtherDetailServiceImpl;
import com.israr.husain.StaffApplication.Service.ServiceImpl.PersonalDetailServiceImpl;
import com.israr.husain.StaffApplication.Service.ServiceInterface.OtherDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
    @RequestMapping("/other")
    public class OtherDetailController {

        @Autowired
        private OtherDetailServiceImpl otherDetailService;

        @PostMapping("/add/{personalId}")
        public ResponseEntity<OtherDetailDto> addPersonalDetail(@RequestBody OtherDetailDto personalDetailDto,
                                                                   @PathVariable UUID personalId) {
            OtherDetailDto personalDetailDto1 = otherDetailService.addOtherDetail(personalDetailDto, personalId);
            return new ResponseEntity<>(personalDetailDto1, HttpStatus.CREATED);
        }

        @PutMapping("/{otherId}/{personalId}")
        public ResponseEntity<OtherDetailDto> updatePersonalDetail(@RequestBody OtherDetailDto otherDetailDto
                , @PathVariable UUID otherId, @PathVariable UUID personalId) {
            OtherDetailDto personalDetailDto1 = otherDetailService.updateOtherDetail(otherDetailDto, otherId, personalId);
            return new ResponseEntity<>(personalDetailDto1, HttpStatus.CREATED);
        }


        @GetMapping("/{otherId}")
        public ResponseEntity<OtherDetailDto> getPersonalDetail(@PathVariable UUID otherId) {
            OtherDetailDto personalDetailDto1 = otherDetailService.getOtherDetailById(otherId);
            return new ResponseEntity<>(personalDetailDto1, HttpStatus.ACCEPTED);
        }

        @DeleteMapping("/{otherId}")
        public ResponseEntity<String> deletePersonalDetail(@PathVariable UUID otherId) {
            String res = otherDetailService.deleteOtherDetail(otherId);
            return new ResponseEntity<>(res, HttpStatus.ACCEPTED);
        }

        @GetMapping("/")
        public ResponseEntity<List<OtherDetailDto>> getPersonalDetail() {
            List<OtherDetailDto> personalDetailDto1=otherDetailService.getAllOtherDetails();
            return new ResponseEntity<>(personalDetailDto1, HttpStatus.ACCEPTED);
        }


    }

