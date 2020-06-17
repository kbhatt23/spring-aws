package com.learning.aws.beanstalk.springebworker;

public class BatchTask {

	private String taskId;

	private String message;

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "BatchTask [taskId=" + taskId + ", message=" + message + "]";
	}

}
