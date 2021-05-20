/**
 * 
 */
package bean;

/**
 * @author 22364
 *
 */
public class book {
	private int book_id;
	private String book_name;
	private String book_author;
	private String book_type;
	private String book_updatetime;
	private String book_preview;
	private String book_img;
	private String book_latest;
	
	public book() {
		super();
		// TODO Auto-generated constructor stub
	}

	public book(int book_id, String book_name, String book_author, String book_type, String book_updatetime,
			String book_preview, String book_img, String book_latest) {
		super();
		this.book_id = book_id;
		this.book_name = book_name;
		this.book_author = book_author;
		this.book_type = book_type;
		this.book_updatetime = book_updatetime;
		this.book_preview = book_preview;
		this.book_img = book_img;
		this.book_latest = book_latest;
	}

	@Override
	public String toString() {
		return "book [book_id=" + book_id + ", book_name=" + book_name + ", book_author=" + book_author + ", book_type="
				+ book_type + ", book_updatetime=" + book_updatetime + ", book_preview=" + book_preview + ", book_img="
				+ book_img + ", book_latest=" + book_latest + "]";
	}

	public int getBook_id() {
		return book_id;
	}

	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}

	public String getBook_name() {
		return book_name;
	}

	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}

	public String getBook_author() {
		return book_author;
	}

	public void setBook_author(String book_author) {
		this.book_author = book_author;
	}

	public String getBook_type() {
		return book_type;
	}

	public void setBook_type(String book_type) {
		this.book_type = book_type;
	}

	public String getBook_updatetime() {
		return book_updatetime;
	}

	public void setBook_updatetime(String book_updatetime) {
		this.book_updatetime = book_updatetime;
	}

	public String getBook_preview() {
		return book_preview;
	}

	public void setBook_preview(String book_preview) {
		this.book_preview = book_preview;
	}

	public String getBook_img() {
		return book_img;
	}

	public void setBook_img(String book_img) {
		this.book_img = book_img;
	}

	public String getBook_latest() {
		return book_latest;
	}

	public void setBook_latest(String book_latest) {
		this.book_latest = book_latest;
	}
	
	
}
