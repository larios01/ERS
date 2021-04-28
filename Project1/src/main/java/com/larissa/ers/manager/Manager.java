package com.larissa.ers.manager;

public class Manager {

	private String username;
	private String pass;
	private String nam;
	
	public Manager() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Manager(String username, String pass, String nam) {
		super();
		this.username = username;
		this.pass = pass;
		this.nam = nam;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getNam() {
		return nam;
	}

	public void setNam(String nam) {
		this.nam = nam;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nam == null) ? 0 : nam.hashCode());
		result = prime * result + ((pass == null) ? 0 : pass.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		Manager other = (Manager) obj;
		if (nam == null) {
			if (other.nam != null)
				return false;
		} else if (!nam.equals(other.nam))
			return false;
		if (pass == null) {
			if (other.pass != null)
				return false;
		} else if (!pass.equals(other.pass))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Manager [username=" + username + ", pass=" + pass + ", nam=" + nam + "]";
	}
	
	
}
