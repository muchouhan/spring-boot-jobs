package com.mukund.demo.jobs;

import java.util.ArrayList;
import java.util.List;

public class Job4 extends BaseJob {

	@Override
	public List<String> getRequireParam() {
		return new ArrayList<>();
	}
	
	@Override
	public void reader() {
		System.out.println("Job4 reader");
		
	}

	@Override
	public void processer() {
		System.out.println("Job4 processer");
	}

	@Override
	public void writer() {
		System.out.println("Job4 writer");
	}
	
}
