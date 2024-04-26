package com.israr.husain.StaffApplication.Service.ServiceInterface;

import com.israr.husain.StaffApplication.Dto.PersonalDetailDto;
import com.israr.husain.StaffApplication.Dto.StaffDetailDto;

import java.util.List;
import java.util.UUID;

public interface PersonalDetailService {

    public PersonalDetailDto addPersonalDetail(PersonalDetailDto staffDetailDto, UUID staffId);
    public PersonalDetailDto updatePersonalDetail(PersonalDetailDto staffDetailDto,UUID personalId,UUID staffId);

    public PersonalDetailDto getPersonalDetailById(UUID personalId);
    public String deletePersonalDetail(UUID personalId);

    List<PersonalDetailDto> getAllPersonalDetails();

}
