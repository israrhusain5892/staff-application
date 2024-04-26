package com.israr.husain.StaffApplication.Controller;

import com.israr.husain.StaffApplication.Dto.StaffDetailDto;
import com.israr.husain.StaffApplication.Service.ServiceImpl.StaffServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin
@RequestMapping("/staff")
public class StaffDetailController {

    @Autowired
    private StaffServiceImpl staffService;

    @PostMapping("/add")
    public ResponseEntity<StaffDetailDto> saveStaffDetail(@RequestBody StaffDetailDto staffDetailDto){
          StaffDetailDto staffDetailDto1=staffService.addStaffDetail(staffDetailDto);
          return new ResponseEntity<>(staffDetailDto1, HttpStatus.ACCEPTED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<StaffDetailDto> updateStaff(@RequestBody StaffDetailDto staffDetailDto,@PathVariable UUID id){
        StaffDetailDto staffDetailDto1=staffService.updateStaffDetail(staffDetailDto,id);
        return new ResponseEntity<>(staffDetailDto1, HttpStatus.ACCEPTED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<StaffDetailDto> getStaffDetailById(@PathVariable UUID id){
        StaffDetailDto staffDetailDto1=staffService.getStaffDetailById(id);
        return new ResponseEntity<>(staffDetailDto1, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStaffDetail(@PathVariable UUID id){
           String res=staffService.deleteStaffDetail(id);
           return new ResponseEntity<>(res,HttpStatus.MOVED_PERMANENTLY);
    }

    @GetMapping("/")
    public ResponseEntity<List<StaffDetailDto>> getAllDetails(){
          List<StaffDetailDto> res=staffService.getAllStaffDetails();
          return new ResponseEntity<>(res,HttpStatus.ACCEPTED);
    }
}
