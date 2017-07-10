package com.hrapp.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hrapp.domain.core.InUser;
import com.hrapp.domain.core.UserLeave;
import com.hrapp.repository.LeaveRepository;
import com.hrapp.serviceimpl.LeaveService;

@Repository
public class LeaveDao {
	@Autowired
	private LeaveRepository leaverep;
	
	public UserLeave applyLeave(UserLeave leave) {	
		
		
		
		InUser leaveforid = leaverep.findById(leave.getLeaveAppliedBy().getId());
		
		
		String name = leaveforid.getUsername();
		leave.setLeaveAppliedBy(leaveforid); 
		System.out.println("user to apply leave  "+name);
		System.out.println(leave.getLeaveAppliedBy().getId());
		System.out.println(leave.getCreateOn());
		
		
		
		
		return this.leaverep.save(leave);
	}

	public InUser findById(Long id) {
		return leaverep.findById(id);

	}

	public List<UserLeave> listOfLeave() {
		return leaverep.findAll();
	}

	public UserLeave findLeaveById(Long id) {
		return leaverep.findLeaveById(id);
	}

	public int deleteLeave(Long id) {
		return leaverep.deleteById(id);
	}

	public int cancelLeave(UserLeave leave) {
		System.out.printf("   cancel DAO CLASS---",leave.getStatus());
		
		return leaverep.cancelLeave(leave.getStatus(), leave.getId(),leave.getLeaveApprovedBy());
	}

	public int approveLeave(UserLeave leave) {
		
		System.out.printf(" approve ~~~~~~  CLASS---\n"+leave.getStatus()); 
		System.out.printf(" approve id CLASS---\n"+leave.getId()); 
		System.out.printf(" approve getLeaveApprovedBy CLASS---"+leave.getLeaveApprovedBy()); 
		
		return leaverep.approveLeave(leave.getStatus(), leave.getId(),leave.getLeaveApprovedBy());
	}

	public List<UserLeave> noOfLeaves(Long id) {
		System.out.println("id in dao layer"+id); 		
		return leaverep.noOfLeaves(id);
	}

	public UserLeave updateLeave(UserLeave leave) {

		return leaverep.saveAndFlush(leave);
	}

	public List<UserLeave> leavelistByMonth(UserLeave user) {
		
		
		return leaverep.leavelistByMonth(user.getTempdate(),user.getTempdate1());
	}

}
