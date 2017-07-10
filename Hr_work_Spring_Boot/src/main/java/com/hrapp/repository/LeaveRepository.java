package com.hrapp.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.hrapp.domain.core.InUser;
import com.hrapp.domain.core.LeaveStatus;
import com.hrapp.domain.core.UserLeave;


public interface LeaveRepository extends JpaRepository<UserLeave, String> {

		
	@Query("Select s FROM InUser s WHERE s.id=:id")
	public InUser findById(@Param("id") Long id);

	@Query("Select s FROM UserLeave s WHERE s.id=:id")
	public UserLeave findLeaveById(@Param("id") Long id);

	
	@Modifying
	@Transactional
	
	public int deleteById(Long id);

	@Query("Select s FROM UserLeave s WHERE s.leaveAppliedBy.id=:leaveAppliedBy")
	public List<UserLeave> noOfLeaves(@Param("leaveAppliedBy") Long leaveAppliedBy);
	
	@Modifying
	@Transactional
	@Query("Update UserLeave s SET s.status=:status , s.leaveApprovedBy=:leaveApprovedBy WHERE s.id=:id")
	public int cancelLeave(@Param("status") LeaveStatus status, @Param("id") Long id,@Param("leaveApprovedBy") Long leaveApprovedBy);
	
	
	@Query("SELECT s FROM UserLeave s WHERE (leaveFromDate BETWEEN :tempdate AND :tempdate1) OR (leaveToDate BETWEEN :tempdate AND :tempdate1)")
	public List<UserLeave> leavelistByMonth(@Param("tempdate") Date tempdate,@Param("tempdate1")Date tempdate1);

	@Modifying
	@Transactional
	@Query("Update UserLeave s SET s.status=:status , s.leaveApprovedBy=:leaveApprovedBy WHERE s.id=:id")
	public int approveLeave(@Param("status") LeaveStatus status, @Param("id") Long id,@Param("leaveApprovedBy") Long leaveApprovedBy);
	
}
