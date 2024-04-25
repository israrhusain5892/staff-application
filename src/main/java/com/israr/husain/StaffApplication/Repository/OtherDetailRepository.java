package com.israr.husain.StaffApplication.Repository;

import com.israr.husain.StaffApplication.Model.OtherDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OtherDetailRepository extends JpaRepository<OtherDetail,Integer> {
}
