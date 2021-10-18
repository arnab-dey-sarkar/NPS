package com.capgemini.nps.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NPSScore {
	
	
	private int nps_score;
	private int promoter_pcnt;
	private int passive_pcnt;
	private int detractor_pcnt;
	private int promoter_count;
	private int passive_count;
	private int detractor_count;

	
}
