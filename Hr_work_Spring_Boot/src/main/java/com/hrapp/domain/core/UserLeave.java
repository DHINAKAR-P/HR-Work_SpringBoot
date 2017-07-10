package com.hrapp.domain.core;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserLeave {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	

	//employee role user
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private InUser leaveAppliedBy;
	
	private long leaveApprovedBy;
	
	
	
	private Date createOn;

	private LeaveStatus status;

	private Date leaveFromDate;

	private Date leaveToDate;

	private float numberOfDays;

	private String Summary;
	

	@Transient
	private Date tempdate;

	@Transient
	private Date tempdate1;

	private LeaveType leaveType;

	public Date getTempdate() {
		return tempdate;
	}

	public void setTempdate(Date tempdate) {
		this.tempdate = tempdate;
	}

	public Date getTempdate1() {
		return tempdate1;
	}

	public void setTempdate1(Date tempdate1) {
		this.tempdate1 = tempdate1;
	}

	public LeaveStatus getStatus() {
		return status;
	}

	public void setStatus(LeaveStatus status) {
		this.status = status;
	}

	 
	

	public Date getCreateOn() {
		return createOn;
	}

	public void setCreateOn(Date createOn) {
		this.createOn = createOn;
	}

	

	public Date getLeaveFromDate() {
		return leaveFromDate;
	}

	public void setLeaveFromDate(Date leaveFromDate) {
		this.leaveFromDate = leaveFromDate;
	}

	public Date getLeaveToDate() {
		return leaveToDate;
	}

	public void setLeaveToDate(Date leaveToDate) {
		this.leaveToDate = leaveToDate;
	}

	public float getNumberOfDays() {
		return numberOfDays;
	}

	public void setNumberOfDays(float numberOfDays) {
		this.numberOfDays = numberOfDays;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSummary() {
		return Summary;
	}

	public void setSummary(String summary) {
		Summary = summary;
	}

	public LeaveType getLeaveType() {
		return leaveType;
	}

	public void setLeaveType(LeaveType leaveType) {
		this.leaveType = leaveType;
	}

	public InUser getLeaveAppliedBy() {
		return leaveAppliedBy;
	}

	public void setLeaveAppliedBy(InUser leaveAppliedBy) {
		this.leaveAppliedBy = leaveAppliedBy;
	}

	

	

	public long getLeaveApprovedBy() {
		return leaveApprovedBy;
	}

	public void setLeaveApprovedBy(long leaveApprovedBy) {
		this.leaveApprovedBy = leaveApprovedBy;
	}

	@Override
	public String toString() {
		return "UserLeave [id=" + id + ", leaveAppliedBy=" + leaveAppliedBy + ", leaveApprovedBy=" + leaveApprovedBy
				+ ", createOn=" + createOn + ", status=" + status + ", leaveFromDate=" + leaveFromDate
				+ ", leaveToDate=" + leaveToDate + ", numberOfDays=" + numberOfDays + ", Summary=" + Summary
				+ ", tempdate=" + tempdate + ", tempdate1=" + tempdate1 + ", leaveType=" + leaveType + "]";
	}

	

}
