/**
 * 
 */
package dao;

import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.Test;

import bean.student;

/**
 * @author 22364
 *
 */
public class student_impl extends basicDao<student>{
	
	@Test
	public void insert() {
		String sql1 = "insert into student value(100,'xjb',21,'ÄÐ',99)";
		String sql2 = "insert into student value(101,'xyc',18,'ÄÐ',93)";
		try {
			update(sql1);
			update(sql2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void select() {
		
		String sql = "select * from student";
		try {
			List<student> beans = getbeans(sql);
			for (student s : beans) {
				System.out.println(s);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
