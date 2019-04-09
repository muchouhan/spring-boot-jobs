package com.mukund.demo.jobs;

import java.util.Arrays;
import java.util.List;

public class Job1 extends BaseJob {
	
	@Override
	public List<String> getRequireParam() {
		return Arrays.asList("date", "time");
	}
	
	@Override
	public void reader() {
		System.out.println("Job1 reader"+param("date"));
		
	}

	@Override
	public void processer() {
		System.out.println("Job1 processer");
	}

	@Override
	public void writer() {
		System.out.println("Job1 writer");
	}
	
}
