/**
 * 
 */
package bean;

/**
 * @author 22364
 *
 */
public class user {
	
	private String username;
	private String password;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		user other = (user) obj;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	public user(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public user() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "user [username=" + username + ", password=" + password + "]";
	}
	
	

}
