/**
 * 
 */
/**
 * @author js4otto
 *
 */

package com.bitwise.magnolia.dao.common;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Response {

	private String message;
	private boolean success;
	private int showMax;
	private int currentPage;
	private int startRecord;
	private int totalRecord;
	private Object object;
	private Map<String, List<ValidationError>> errors;
	
	public Response(){
		this.showMax = 5;
		errors = new HashMap<String, List<ValidationError>>();
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Map<String, List<ValidationError>> getErrors() {
		return errors;
	}

	public void setErrors(Map<String, List<ValidationError>> errors) {
		this.errors = errors;
	}

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public int getShowMax() {
		return showMax;
	}

	public void setShowMax(int showMax) {
		this.showMax = showMax;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getStartRecord() {
		return startRecord;
	}

	public void setStartRecord(int startRecord) {
		this.startRecord = startRecord;
	}

	public int getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}
	
}
