package com.israr.husain.StaffApplication.Service.ServiceImpl;

import com.israr.husain.StaffApplication.Dto.OtherDetailDto;
import com.israr.husain.StaffApplication.Dto.PersonalDetailDto;
import com.israr.husain.StaffApplication.Exceptions.ResourceNotFoundException;
import com.israr.husain.StaffApplication.Model.OtherDetail;
import com.israr.husain.StaffApplication.Model.PersonalDetail;
import com.israr.husain.StaffApplication.Repository.OtherDetailRepository;
import com.israr.husain.StaffApplication.Repository.PersonalDetailRepository;
import com.israr.husain.StaffApplication.Service.ServiceInterface.OtherDetailService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OtherDetailServiceImpl implements OtherDetailService {

      @Autowired
      private PersonalDetailRepository personalDetailRepository;

      @Autowired
      private ModelMapper modelMapper;

      @Autowired
      private OtherDetailRepository otherDetailRepository;
    @Override
    public OtherDetailDto addOtherDetail(OtherDetailDto otherDetailDto, Integer personalId) {
        PersonalDetail personalDetail=personalDetailRepository.findById(personalId).
                orElseThrow(() -> new ResourceNotFoundException("staffDetail", "Id", personalId));
         OtherDetail otherDetail=modelMapper.map(otherDetailDto,OtherDetail.class) ;
         otherDetail.setPersonalDetail(personalDetail);
         OtherDetail saved=otherDetailRepository.save(otherDetail);
          OtherDetailDto otherDetailDto1=modelMapper.map(saved,OtherDetailDto.class);
          otherDetailDto1.setPersonalDetailDto(modelMapper.map(personalDetail,PersonalDetailDto.class));
         return otherDetailDto1;
    }

    @Override
    public OtherDetailDto updateOtherDetail(OtherDetailDto otherDetailDto, Integer otherId,Integer personalId) {
             OtherDetail otherDetail=otherDetailRepository.findById(otherId).get();
             PersonalDetail personalDetail=personalDetailRepository.findById(personalId).get();

             otherDetail.setPanNumber(otherDetailDto.getPanNumber());
             otherDetail.setResidentNumber(otherDetailDto.getResidentNumber());
             otherDetail.setAadhaarNumber(otherDetailDto.getAadhaarNumber());
             otherDetail.setSalaryPayType(otherDetailDto.getSalaryPayType());
             otherDetail.setDateOfJoining(otherDetailDto.getDateOfJoining());
             otherDetail.setCitizenShip(otherDetailDto.getCitizenShip());
             otherDetail.setStaffReferenceCode(otherDetailDto.getStaffReferenceCode());
             otherDetail.setPersonalDetail(personalDetail);
             OtherDetail saved=otherDetailRepository.save(otherDetail);
             OtherDetailDto otherDetailDto1=modelMapper.map(saved,OtherDetailDto.class);
             otherDetailDto1.setPersonalDetailDto(modelMapper.map(personalDetail, PersonalDetailDto.class));
             return otherDetailDto1;
    }

    @Override
    public OtherDetailDto getOtherDetailById(Integer otherId) {
           OtherDetail otherDetail=otherDetailRepository.findById(otherId).get();
        OtherDetailDto otherDetailDto1=modelMapper.map(otherDetail,OtherDetailDto.class);
         otherDetailDto1.setPersonalDetailDto(modelMapper.map(otherDetail.getPersonalDetail(),PersonalDetailDto.class));
          return otherDetailDto1 ;
    }

    @Override
    public String deleteOtherDetail(Integer personalId) {
            otherDetailRepository.deleteById(personalId);
            return "other detail deleted successfully";
    }

    @Override
    public List<OtherDetailDto> getAllOtherDetails() {

        List<OtherDetailDto> list=new ArrayList<>();
        List<OtherDetail> personalDetailList=otherDetailRepository.findAll();
        for(OtherDetail otherDetail:personalDetailList){
            OtherDetailDto OtherDetailDto=modelMapper.map(otherDetail,OtherDetailDto.class);
             OtherDetailDto.setPersonalDetailDto(modelMapper.map(otherDetail.getPersonalDetail(),PersonalDetailDto.class));
            list.add(OtherDetailDto);
        }
        return list;

    }
}
