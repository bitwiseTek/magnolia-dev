package com.bitwise.magnolia.util;
/**
 *  
 * @author Sika Kay
 * @date 27/02/17
 *
 */
import java.util.ArrayList;
import java.util.List;

import com.bitwise.magnolia.model.common.StudyProgramme;

public class ProgrammeList {

	public ProgrammeList(List<StudyProgramme> programmes) {
		this.programmes = programmes;
	}
	
	private List<StudyProgramme> programmes = new ArrayList<StudyProgramme>();

	public List<StudyProgramme> getProgrammes() {
		return programmes;
	}

	public void setProgrammes(List<StudyProgramme> programmes) {
		this.programmes = programmes;
	}
}
