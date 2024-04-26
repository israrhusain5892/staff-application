package com.israr.husain.StaffApplication.Service.ServiceInterface;

import com.israr.husain.StaffApplication.Dto.StaffDetailDto;
import com.israr.husain.StaffApplication.Model.StaffDetail;

import java.util.List;
import java.util.UUID;

public interface StaffService {

      public StaffDetailDto addStaffDetail(StaffDetailDto staffDetailDto);
      public StaffDetailDto updateStaffDetail(StaffDetailDto staffDetailDto, UUID id);

      public StaffDetailDto getStaffDetailById(UUID id);
      public String deleteStaffDetail(UUID id);

      List<StaffDetailDto> getAllStaffDetails();
}
