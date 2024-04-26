package com.israr.husain.StaffApplication.Service.ServiceInterface;

import com.israr.husain.StaffApplication.Dto.OtherDetailDto;
import com.israr.husain.StaffApplication.Dto.PersonalDetailDto;

import java.util.List;
import java.util.UUID;

public interface OtherDetailService {

    OtherDetailDto addOtherDetail(OtherDetailDto otherDetailDto, UUID personalId);
    public OtherDetailDto updateOtherDetail(OtherDetailDto otherDetailDto, UUID otherId, UUID personalId);

    public OtherDetailDto getOtherDetailById(UUID personalId);
    public String deleteOtherDetail(UUID personalId);

    List<OtherDetailDto> getAllOtherDetails();

}
