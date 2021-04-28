package com.larissa.ers.pending;

public class Pending {

	private int reqId;
	private String employee;
	private int amount;
	
	public Pending() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Pending(int reqId, String employee, int amount) {
		super();
		this.reqId = reqId;
		this.employee = employee;
		this.amount = amount;
	}

	public int getReqId() {
		return reqId;
	}

	public void setReqId(int reqId) {
		this.reqId = reqId;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + amount;
		result = prime * result + ((employee == null) ? 0 : employee.hashCode());
		result = prime * result + reqId;
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
		Pending other = (Pending) obj;
		if (amount != other.amount)
			return false;
		if (employee == null) {
			if (other.employee != null)
				return false;
		} else if (!employee.equals(other.employee))
			return false;
		if (reqId != other.reqId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Pending [reqId=" + reqId + ", employee=" + employee + ", amount=" + amount + "]";
	}

	
	
}
