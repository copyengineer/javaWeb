/**
 * 
 */
package bean;

import java.io.Serializable;

/**
 * @author 22364
 *
 */
public class book implements Serializable{
	private String name;
	private int price;
	private int num;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	@Override
	public String toString() {
		return "book [name=" + name + ", price=" + price + ", num=" + num + "]";
	}
	public book() {
		super();
		// TODO Auto-generated constructor stub
	}
	public book(String name, int price, int num) {
		super();
		this.name = name;
		this.price = price;
		this.num = num;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		book other = (book) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
}
