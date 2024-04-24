package com.israr.husain.StaffApplication.Service.ServiceImpl;

import com.israr.husain.StaffApplication.Dto.StaffDetailDto;
import com.israr.husain.StaffApplication.Exceptions.ResourceNotFoundException;
import com.israr.husain.StaffApplication.Model.StaffDetail;
import com.israr.husain.StaffApplication.Repository.StaffRepository;
import com.israr.husain.StaffApplication.Service.ServiceInterface.StaffService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StaffServiceImpl implements StaffService {

    @Autowired
    private StaffRepository staffRepository;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public StaffDetailDto addStaffDetail(StaffDetailDto staffDetailDto) {

        StaffDetail staffDetail=modelMapper.map(staffDetailDto,StaffDetail.class);
        StaffDetail savedDetail=staffRepository.save(staffDetail);
        return modelMapper.map(savedDetail,StaffDetailDto.class);
    }

    @Override
    public StaffDetailDto updateStaffDetail(StaffDetailDto staffDetailDto, Integer id) {
           StaffDetail staffDetail=staffRepository.findById(id).
                   orElseThrow(()->new ResourceNotFoundException("staffDetail","Id",id));
           staffDetail.setAadhaarNumber(staffDetailDto.getAadhaarNumber());
           staffDetail.setStaffDepartment(staffDetailDto.getStaffDepartment());
           staffDetail.setStaffType(staffDetailDto.getStaffType());
           staffDetail.setDob(staffDetailDto.getDob());
           staffDetail.setCitizenShip(staffDetailDto.getCitizenShip());
           staffDetail.setAccessLevel(staffDetailDto.getAccessLevel());
           staffDetail.setCorrespondingAddress(staffDetailDto.getCorrespondingAddress());
           staffDetail.setCTET_Qualified(staffDetailDto.getCTET_Qualified());
           staffDetail.setDateOfJoining(staffDetailDto.getDateOfJoining());
           staffDetail.setDesignation(staffDetailDto.getDesignation());
           staffDetail.setEducationQualification(staffDetailDto.getEducationQualification());
           staffDetail.setEmailId(staffDetailDto.getEmailId());
           staffDetail.setEmergencyContactNumber(staffDetailDto.getEmergencyContactNumber());
           staffDetail.setEmployment_Status(staffDetailDto.getEmployment_Status());
           staffDetail.setEmploymentCategory(staffDetailDto.getEmploymentCategory());
           staffDetail.setFirstName(staffDetailDto.getFirstName());
           staffDetail.setMiddleName(staffDetailDto.getMiddleName());
           staffDetail.setLastName(staffDetailDto.getLastName());
           staffDetail.setMobileNumber(staffDetailDto.getMobileNumber());
           staffDetail.setPanNumber(staffDetailDto.getPanNumber());
           staffDetail.setPermanentAddress(staffDetailDto.getPermanentAddress());
           staffDetail.setReligion(staffDetailDto.getReligion());
           staffDetail.setQualificationType(staffDetailDto.getQualificationType());
           staffDetail.setResidentNumber(staffDetailDto.getResidentNumber());
           staffDetail.setSalaryPayType(staffDetailDto.getSalaryPayType());
           staffDetail.setStaffReferenceCode(staffDetailDto.getStaffReferenceCode());
           staffDetail.setTrainedAs(staffDetailDto.getTrainedAs());
           StaffDetail savedDetail=staffRepository.save(staffDetail);
           return modelMapper.map(savedDetail,StaffDetailDto.class);
    }

    @Override
    public StaffDetailDto getStaffDetailById(Integer id) {
          StaffDetail staffDetail=staffRepository.findById(id).
                  orElseThrow(()->new ResourceNotFoundException("staffDetail","Id",id));
          return modelMapper.map(staffDetail,StaffDetailDto.class);
    }

    @Override
    public String deleteStaffDetail(Integer id) {
          staffRepository.deleteById(id);
          return "staff detail deleted successfully";
    }

    @Override
    public List<StaffDetailDto> getAllStaffDetails() {
          List<StaffDetailDto> list=new ArrayList<>();
          List<StaffDetail>staffDetailList=staffRepository.findAll();
          for(StaffDetail staffDetail:staffDetailList){
                  StaffDetailDto staffDetailDto=modelMapper.map(staffDetail,StaffDetailDto.class);
                  list.add(staffDetailDto);
          }
          return list;
    }
}
