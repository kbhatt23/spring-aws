package com.learning.aws.beanstalk.springebworker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringBatchController {
	private final static Logger logger = LoggerFactory.getLogger(SpringBatchController.class);

	// aws elastic beanstalk worker hits "/" endpoint with message queue data
	// method type shud be post
	@PostMapping("/")
	public ResponseEntity<Void> processTask(@RequestBody BatchTask batchTask) {
		logger.info("processTask():Starting processing of task " + batchTask);
		//making it 100 percent success
		if (Math.random() > 1) {
			logger.error("processTask():Processing failed for task " + batchTask);
			throw new RuntimeException("processTask():Processing failed for task " + batchTask);
		}

		logger.error("processTask():Processing success for task " + batchTask);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
