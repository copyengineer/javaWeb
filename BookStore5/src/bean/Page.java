/**
 * 
 */
package bean;

import java.util.Map;

/**
 * @author 22364
 *分页的业务bean
 */
public class Page {
	
	private String lastPage;
	private Map<String, Integer> pagechoice1;
	private String omit1;
	private Map<String, Integer> pagechoice2;
	private Map<String, Integer> pagechoice3;
	private Map<String, Integer> pagechoice4;
	private Map<String, Integer> pagechoice5;
	private Map<String, Integer> pagechoice6;
	private String omit2;
	private Map<String, Integer> pagechoice7;
	private String omit3;
	private Map<String, Integer> pagechoice8;
	
	public String getLastPage() {
		return lastPage;
	}
	public void setLastPage(String lastPage) {
		this.lastPage = lastPage;
	}
	public Map<String, Integer> getPagechoice1() {
		return pagechoice1;
	}
	public void setPagechoice1(Map<String, Integer> pagechoice1) {
		this.pagechoice1 = pagechoice1;
	}
	public String getOmit1() {
		return omit1;
	}
	public void setOmit1(String omit1) {
		this.omit1 = omit1;
	}
	public Map<String, Integer> getPagechoice2() {
		return pagechoice2;
	}
	public void setPagechoice2(Map<String, Integer> pagechoice2) {
		this.pagechoice2 = pagechoice2;
	}
	public Map<String, Integer> getPagechoice3() {
		return pagechoice3;
	}
	public void setPagechoice3(Map<String, Integer> pagechoice3) {
		this.pagechoice3 = pagechoice3;
	}
	public Map<String, Integer> getPagechoice4() {
		return pagechoice4;
	}
	public void setPagechoice4(Map<String, Integer> pagechoice4) {
		this.pagechoice4 = pagechoice4;
	}
	public Map<String, Integer> getPagechoice5() {
		return pagechoice5;
	}
	public void setPagechoice5(Map<String, Integer> pagechoice5) {
		this.pagechoice5 = pagechoice5;
	}
	public Map<String, Integer> getPagechoice6() {
		return pagechoice6;
	}
	public void setPagechoice6(Map<String, Integer> pagechoice6) {
		this.pagechoice6 = pagechoice6;
	}
	public String getOmit2() {
		return omit2;
	}
	public void setOmit2(String omit2) {
		this.omit2 = omit2;
	}
	public Map<String, Integer> getPagechoice7() {
		return pagechoice7;
	}
	public void setPagechoice7(Map<String, Integer> pagechoice7) {
		this.pagechoice7 = pagechoice7;
	}
	public String getOmit3() {
		return omit3;
	}
	public void setOmit3(String omit3) {
		this.omit3 = omit3;
	}
	public Map<String, Integer> getPagechoice8() {
		return pagechoice8;
	}
	public void setPagechoice8(Map<String, Integer> pagechoice8) {
		this.pagechoice8 = pagechoice8;
	}
	public Page(String lastPage, Map<String, Integer> pagechoice1, String omit1, Map<String, Integer> pagechoice2,
			Map<String, Integer> pagechoice3, Map<String, Integer> pagechoice4, Map<String, Integer> pagechoice5,
			Map<String, Integer> pagechoice6, String omit2, Map<String, Integer> pagechoice7, String omit3,
			Map<String, Integer> pagechoice8) {
		super();
		this.lastPage = lastPage;
		this.pagechoice1 = pagechoice1;
		this.omit1 = omit1;
		this.pagechoice2 = pagechoice2;
		this.pagechoice3 = pagechoice3;
		this.pagechoice4 = pagechoice4;
		this.pagechoice5 = pagechoice5;
		this.pagechoice6 = pagechoice6;
		this.omit2 = omit2;
		this.pagechoice7 = pagechoice7;
		this.omit3 = omit3;
		this.pagechoice8 = pagechoice8;
	}
	@Override
	public String toString() {
		return "Page [lastPage=" + lastPage + ", pagechoice1=" + pagechoice1 + ", omit1=" + omit1 + ", pagechoice2="
				+ pagechoice2 + ", pagechoice3=" + pagechoice3 + ", pagechoice4=" + pagechoice4 + ", pagechoice5="
				+ pagechoice5 + ", pagechoice6=" + pagechoice6 + ", omit2=" + omit2 + ", pagechoice7=" + pagechoice7
				+ ", omit3=" + omit3 + ", pagechoice8=" + pagechoice8 + "]";
	}
	public Page() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
