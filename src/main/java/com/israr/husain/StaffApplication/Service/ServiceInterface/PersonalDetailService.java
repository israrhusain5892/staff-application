package com.israr.husain.StaffApplication.Service.ServiceInterface;

import com.israr.husain.StaffApplication.Dto.PersonalDetailDto;
import com.israr.husain.StaffApplication.Dto.StaffDetailDto;

import java.util.List;

public interface PersonalDetailService {

    public PersonalDetailDto addPersonalDetail(PersonalDetailDto staffDetailDto,Integer staffId);
    public PersonalDetailDto updatePersonalDetail(PersonalDetailDto staffDetailDto,Integer personalId,Integer staffId);

    public PersonalDetailDto getPersonalDetailById(Integer personalId);
    public String deletePersonalDetail(Integer personalId);

    List<PersonalDetailDto> getAllPersonalDetails();

}
