/**
 * 
 */
package bean;

/**
 * @author 22364
 *
 */
public class user {
	
	private int userid;
	private String jsessionid;
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getJsessionid() {
		return jsessionid;
	}
	public void setJsessionid(String jsessionid) {
		this.jsessionid = jsessionid;
	}
	public user(int userid, String jsessionid) {
		super();
		this.userid = userid;
		this.jsessionid = jsessionid;
	}
	public user() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "user [userid=" + userid + ", jsessionid=" + jsessionid + "]";
	}
	
	
	
	
}
