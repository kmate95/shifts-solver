package com.mindforger.shiftsolver.shared.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class EmployeePreferences implements Serializable  {
	private static final long serialVersionUID = 7779646494294778098L;

	private String key;
	
	private int shiftsLimit;
	private List<DayPreference> preferences;
	
	public EmployeePreferences() {
		preferences=new ArrayList<DayPreference>();
	}

	public EmployeePreferences(int shiftsLimit) {
		this();
		this.shiftsLimit=shiftsLimit;
	}
	
	public void addPreference(DayPreference preference) {
		preferences.add(preference);
	}
	
	public List<DayPreference> getPreferences() {
		return preferences;
	}

	public void setPreferences(List<DayPreference> preferences) {
		this.preferences = preferences;
	}

	public int getShiftsLimit() {
		return shiftsLimit;
	}

	public void setShiftsLimit(int shiftsLimit) {
		this.shiftsLimit = shiftsLimit;
	}
	
	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public DayPreference getPreferencesForDay(int day) {
		for(DayPreference dayPreference:preferences) {
			if(day == dayPreference.getDay()) {
				return dayPreference;
			}
		}
		return null;
	}
}
