package com.mukund.demo;

import java.lang.reflect.Method;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mukund.demo.jobs.BaseJob;

@SpringBootApplication
public class MultipleJobsApplication implements ApplicationRunner {

	public static void main(String[] args) {
		SpringApplication.run(MultipleJobsApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		if(!args.containsOption("job")) throw new Exception("Require parameter job not provided"); 
		BaseJob job = (BaseJob) Class.forName(args.getOptionValues("job").get(0)).newInstance();
		Method method = BaseJob.class.getDeclaredMethod("init", ApplicationArguments.class);
		method.invoke(job, args);
		job.execute();
	}

}
