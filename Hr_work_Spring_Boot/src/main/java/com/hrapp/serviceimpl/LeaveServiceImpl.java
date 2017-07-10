package com.hrapp.serviceimpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hrapp.dao.LeaveDao;
import com.hrapp.domain.core.UserLeave;


@Service
@Transactional
public class LeaveServiceImpl implements LeaveService {
	@Autowired
	LeaveDao leaveDao;
	Logger LOG = LoggerFactory.getLogger(LeaveServiceImpl.class);

	public UserLeave applyLeave(UserLeave leave) {

		LOG.debug("SERVICEimpl hitted for apply leave ");
		LOG.debug("id to fetch value from DB " + leave.getLeaveAppliedBy().getId());

		
		
		
		return leaveDao.applyLeave(leave);
	}

	public UserLeave findLeavebyId(Long id) {

		return leaveDao.findLeaveById(id);
	}

	public int deleteLeave(Long id) {

		return leaveDao.deleteLeave(id);
	}

	public int cancelLeave(UserLeave leave) {
		
		System.out.printf("cancel leave in service impl layer ----",leave.getStatus());

		return leaveDao.cancelLeave(leave);
	}

	public int approveLeave(UserLeave leave) {

		return leaveDao.approveLeave(leave);
	}

	public List<UserLeave> noOfLeaves(Long id) {

		return leaveDao.noOfLeaves(id);
	}

	public UserLeave updateLeave(UserLeave leave) {
		


		return leaveDao.updateLeave(leave);
	}

	public List<UserLeave> listOfleave() {

		List<UserLeave> j = leaveDao.listOfLeave();
		for (int i = 0; i <= j.size(); i++) {
			System.out.println(j);
		}

		return j;
	}

	public List<UserLeave> leavelistByMonth(UserLeave user) {

		List<UserLeave> j = leaveDao.leavelistByMonth(user);

		for (int i = 0; i <= j.size(); i++) {
			System.out.println(j);
		}
		return j;
	}

}