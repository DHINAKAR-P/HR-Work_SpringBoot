package com.hrapp.serviceimpl;

import java.util.List;

import com.hrapp.domain.core.UserLeave;

public interface LeaveService {

	public UserLeave applyLeave(UserLeave leave);

	public List<UserLeave> listOfleave();

	public UserLeave findLeavebyId(Long id);

	public int deleteLeave(Long id);

	public int cancelLeave(UserLeave leave);

	public int approveLeave(UserLeave leave);

	public List<UserLeave> noOfLeaves(Long id);

	public UserLeave updateLeave(UserLeave leave);

	public List<UserLeave> leavelistByMonth(UserLeave user);
}

