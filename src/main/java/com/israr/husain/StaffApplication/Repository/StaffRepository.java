package com.israr.husain.StaffApplication.Repository;

import com.israr.husain.StaffApplication.Model.StaffDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface StaffRepository extends JpaRepository<StaffDetail, UUID> {
}
