package com.israr.husain.StaffApplication.Service.ServiceInterface;

import com.israr.husain.StaffApplication.Dto.StaffDetailDto;
import com.israr.husain.StaffApplication.Model.StaffDetail;

import java.util.List;

public interface StaffService {

      public StaffDetailDto addStaffDetail(StaffDetailDto staffDetailDto);
      public StaffDetailDto updateStaffDetail(StaffDetailDto staffDetailDto,Integer id);

      public StaffDetailDto getStaffDetailById(Integer id);
      public String deleteStaffDetail(Integer id);

      List<StaffDetailDto> getAllStaffDetails();
}
