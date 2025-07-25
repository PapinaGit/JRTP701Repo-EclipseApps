package com.nt.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchInputs {
	private String courseCategory;
	private String trainingMode;
	private String facultyName;
	private LocalDateTime startsOn;
	

}
