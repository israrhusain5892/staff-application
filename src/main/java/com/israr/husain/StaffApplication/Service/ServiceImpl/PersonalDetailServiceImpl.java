package com.israr.husain.StaffApplication.Service.ServiceImpl;

import com.israr.husain.StaffApplication.Dto.PersonalDetailDto;
import com.israr.husain.StaffApplication.Dto.StaffDetailDto;
import com.israr.husain.StaffApplication.Exceptions.ResourceNotFoundException;
import com.israr.husain.StaffApplication.Model.PersonalDetail;
import com.israr.husain.StaffApplication.Model.StaffDetail;
import com.israr.husain.StaffApplication.Repository.PersonalDetailRepository;
import com.israr.husain.StaffApplication.Repository.StaffRepository;
import com.israr.husain.StaffApplication.Service.ServiceInterface.PersonalDetailService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class PersonalDetailServiceImpl implements PersonalDetailService {

    @Autowired
    private StaffRepository staffRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PersonalDetailRepository personalDetailRepository;
    @Override
    public PersonalDetailDto addPersonalDetail(PersonalDetailDto personalDetailDto, UUID staffId) {
        StaffDetail staffDetail = staffRepository.findById(staffId).get();
//                orElseThrow(() -> new ResourceNotFoundException("staffDetail", "Id", staffId));

        PersonalDetail personalDetail = modelMapper.map(personalDetailDto, PersonalDetail.class);
        personalDetail.setStaffDetail(staffDetail);
        PersonalDetail saved = personalDetailRepository.save(personalDetail);
         PersonalDetailDto personalDetailDto1=modelMapper.map(saved,PersonalDetailDto.class);
        personalDetailDto1.setStaffDetailDto(modelMapper.map(staffDetail, StaffDetailDto.class));
;        return personalDetailDto1;
    }

    @Override
    public PersonalDetailDto updatePersonalDetail(PersonalDetailDto personalDetailDto, UUID personalId,UUID staffId) {
           PersonalDetail personalDetail=personalDetailRepository.findById(personalId).get();
//                   orElseThrow(() -> new ResourceNotFoundException("staffDetail", "Id", personalId));

           StaffDetail staffDetail=staffRepository.findById(staffId).get();
//                   orElseThrow(() -> new ResourceNotFoundException("staffDetail", "Id", staffId));

           personalDetail.setFirstName(personalDetailDto.getFirstName());
        personalDetail.setMiddleName(personalDetailDto.getMiddleName());
        personalDetail.setLastName(personalDetailDto.getLastName());
        personalDetail.setMobileNumber(personalDetailDto.getMobileNumber());
        personalDetail.setPermanentAddress(personalDetailDto.getPermanentAddress());
        personalDetail.setReligion(personalDetailDto.getReligion());
        personalDetail.setEmailId(personalDetailDto.getEmailId());
         personalDetail.setEmergencyContactNumber(personalDetailDto.getEmergencyContactNumber());
        personalDetail.setDob(personalDetailDto.getDob());
        personalDetail.setCorrespondingAddress(personalDetailDto.getCorrespondingAddress());
        personalDetail.setEmergencyContactNumber(personalDetailDto.getEmergencyContactNumber());
        personalDetail.setGender(personalDetailDto.getGender());
         personalDetail.setStaffDetail(staffDetail);
         PersonalDetailDto personalDetailDto1=modelMapper.map(personalDetailRepository.save(personalDetail),PersonalDetailDto.class);
         personalDetailDto1.setStaffDetailDto(modelMapper.map(staffDetail,StaffDetailDto.class));

         return personalDetailDto1;


    }

    @Override
    public PersonalDetailDto getPersonalDetailById(UUID personalId) {
             PersonalDetail personalDetail=personalDetailRepository.findById(personalId).get();
//                     orElseThrow(() -> new ResourceNotFoundException("staffDetail", "Id", personalId));
           PersonalDetailDto personalDetailDto= modelMapper.map(personalDetail,PersonalDetailDto.class);
            personalDetailDto.setStaffDetailDto(modelMapper.map(personalDetail.getStaffDetail(),StaffDetailDto.class));
             return personalDetailDto;
    }

    @Override
    public String deletePersonalDetail(UUID personalId) {
            personalDetailRepository.deleteById(personalId);
            return "personal detail deleted successfully";
    }

    @Override
    public List<PersonalDetailDto> getAllPersonalDetails() {
          List<PersonalDetailDto> list=new ArrayList<>();
          List<PersonalDetail> personalDetailList=personalDetailRepository.findAll();
          for(PersonalDetail personalDetail:personalDetailList){
                PersonalDetailDto personalDetailDto=modelMapper.map(personalDetail,PersonalDetailDto.class);
                personalDetailDto.setStaffDetailDto(modelMapper.map(personalDetail.getStaffDetail(),StaffDetailDto.class));
                list.add(personalDetailDto);
          }
          return list;
    }
}
