package bean;

public class users {
	
	private String username;
	private String phone;
	private String password;
	
	public users() {
		super();
		// TODO Auto-generated constructor stub
	}

	public users(String username, String phone, String password) {
		super();
		this.username = username;
		this.phone = phone;
		this.password = password;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "users [username=" + username + ", phone=" + phone + ", password=" + password + "]";
	}
	
	
}
