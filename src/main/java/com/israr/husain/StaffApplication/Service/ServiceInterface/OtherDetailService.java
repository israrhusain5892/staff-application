package com.israr.husain.StaffApplication.Service.ServiceInterface;

import com.israr.husain.StaffApplication.Dto.OtherDetailDto;
import com.israr.husain.StaffApplication.Dto.PersonalDetailDto;

import java.util.List;

public interface OtherDetailService {

    OtherDetailDto addOtherDetail(OtherDetailDto otherDetailDto, Integer personalId);
    public OtherDetailDto updateOtherDetail(OtherDetailDto otherDetailDto,Integer otherId,Integer personalId);

    public OtherDetailDto getOtherDetailById(Integer personalId);
    public String deleteOtherDetail(Integer personalId);

    List<OtherDetailDto> getAllOtherDetails();

}
