package com.mindforger.shiftsolver.shared.model;

import java.io.Serializable;

import com.mindforger.shiftsolver.shared.ShiftSolverConstants;
import com.mindforger.shiftsolver.shared.model.shifts.NightShift;
import com.mindforger.shiftsolver.shared.model.shifts.WeekendAfternoonShift;
import com.mindforger.shiftsolver.shared.model.shifts.WeekendMorningShift;
import com.mindforger.shiftsolver.shared.model.shifts.WorkdayAfternoonShift;
import com.mindforger.shiftsolver.shared.model.shifts.WorkdayMorningShift;

public class DaySolution implements Serializable  {
	private static final long serialVersionUID = -2908720137028791233L;

	int day;
	boolean isWorkday;
	WorkdayMorningShift workdayMorningShift;
	WorkdayAfternoonShift workdayAfternoonShift;
	WeekendMorningShift weekendMorningShift;
	WeekendAfternoonShift weekendAfternoonShift;
	NightShift nightShift;
		
	public DaySolution() {
	}
	
	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public boolean isWorkday() {
		return isWorkday;
	}

	public void setWorkday(boolean isWorkday) {
		this.isWorkday = isWorkday;
	}

	public WorkdayAfternoonShift getWorkdayAfternoonShift() {
		return workdayAfternoonShift;
	}

	public WorkdayMorningShift getWorkdayMorningShift() {
		return workdayMorningShift;
	}
	
	public void setWorkdayAfternoonShift(WorkdayAfternoonShift workdayAfternoonShift) {
		this.workdayAfternoonShift = workdayAfternoonShift;
	}

	public WeekendMorningShift getWeekendMorningShift() {
		return weekendMorningShift;
	}

	public void setWeekendMorningShift(WeekendMorningShift weekendMorningShift) {
		this.weekendMorningShift = weekendMorningShift;
	}

	public WeekendAfternoonShift getWeekendAfternoonShift() {
		return weekendAfternoonShift;
	}

	public void setWeekendAfternoonShift(WeekendAfternoonShift weekendAfternoonShift) {
		this.weekendAfternoonShift = weekendAfternoonShift;
	}

	public NightShift getNightShift() {
		return nightShift;
	}

	public void setNightShift(NightShift nightShift) {
		this.nightShift = nightShift;
	}

	public boolean isEmployeeAllocated(String key) {
		return getShiftTypeForEmployee(key)>0;
	}
	
	public int getShiftTypeForEmployee(String key) {
		int shift;
		
		if(nightShift!=null) {
			if((shift=nightShift.isEmployeeAllocated(key))>0) {
				return shift;
			}
		}
		
		if(isWorkday) {
			if(workdayMorningShift!=null) {
				if((shift=workdayMorningShift.isEmployeeAllocated(key))>0) {
					return shift;
				}
			}
			if(workdayAfternoonShift!=null) {
				if((shift=workdayAfternoonShift.isEmployeeAllocated(key))>0) {
					return shift;
				}
			}
		} else {
			if(weekendMorningShift!=null) {
				if((shift=weekendMorningShift.isEmployeeAllocated(key))>0) {
					return shift;
				}
			}
			if(weekendAfternoonShift!=null) {
				if((shift=weekendAfternoonShift.isEmployeeAllocated(key))>0) {
					return shift;
				}
			}
		}
		return ShiftSolverConstants.NO_SHIFT;
	}

	public void setWorkdayMorningShift(WorkdayMorningShift workdayMorningShift) {
		this.workdayMorningShift=workdayMorningShift;
	}
}
