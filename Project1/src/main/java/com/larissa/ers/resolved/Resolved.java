package com.larissa.ers.resolved;

public class Resolved {

	private String status;
	private String employee;
	private int amount;
	private int reqId;
	
	public Resolved() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Resolved(String status, String employee, int amount, int reqId) {
		super();
		this.status = status;
		this.employee = employee;
		this.amount = amount;
		this.reqId = reqId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getEmployee() {
		return employee;
	}

	public void setEmployee(String employee) {
		this.employee = employee;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getReqId() {
		return reqId;
	}

	public void setReqId(int reqId) {
		this.reqId = reqId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + amount;
		result = prime * result + ((employee == null) ? 0 : employee.hashCode());
		result = prime * result + reqId;
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Resolved other = (Resolved) obj;
		if (amount != other.amount)
			return false;
		if (employee == null) {
			if (other.employee != null)
				return false;
		} else if (!employee.equals(other.employee))
			return false;
		if (reqId != other.reqId)
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Resolved [status=" + status + ", employee=" + employee + ", amount=" + amount + ", reqId=" + reqId
				+ "]";
	}
	
	
}
