package com.mukund.demo.jobs;

import java.text.MessageFormat;
import java.util.List;

import org.springframework.boot.ApplicationArguments;

public abstract class BaseJob {

	protected ApplicationArguments args;
	protected List<String> require;

	public abstract List<String> getRequireParam();

	public void init(ApplicationArguments args) {
		this.args = args;
	}

	public void reader() {
		System.out.println("Reader task");
	}

	public void processer() {
		System.out.println("processer task");
	}

	public void writer() {
		System.out.println("writer task");
	}

	public void execute() throws Exception {
		require=getRequireParam();
		checkParameters();
		reader();
		processer();
		writer();
	}

	/**
	 * 
	 * @param param
	 * @return
	 */
	public String param(String param) {
		return args.getOptionValues(param).get(0);
	}

	private boolean checkParameters() throws Exception {
		
		if(args.getOptionNames().containsAll(require)){
			return true;
		}else{
			//find which parameter is not provided
			for (String param : require) {
				if(!args.containsOption(param))
					throw new Exception(MessageFormat.format("Require parameter \"{0}\" not provided",param));
			}
		}
		
		return false;
	}
}
