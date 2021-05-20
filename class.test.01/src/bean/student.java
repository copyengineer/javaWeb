/**
 * 
 */
package bean;

/**
 * @author 22364
 *
 */
public class student {
	
	private int id;
	private String name;
	private int age;
	private String sex;
	private int score;
	@Override
	public String toString() {
		return "student [id=" + id + ", name=" + name + ", age=" + age + ", sex=" + sex + ", score=" + score + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public student(int id, String name, int age, String sex, int score) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.score = score;
	}
	public student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
