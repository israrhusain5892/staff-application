package com.israr.husain.StaffApplication.Repository;

import com.israr.husain.StaffApplication.Model.PersonalDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonalDetailRepository extends JpaRepository<PersonalDetail,Integer> {
}
