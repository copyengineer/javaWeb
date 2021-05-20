package dao;

import bean.book;
import java.util.List;

public interface bookDao {
  List<book> dao_dofilter(String paramString);
  
  int getStartSize();
}


/* Location:              C:\Users\22364\Desktop\bookStore_spring2\WEB-INF\classes\!\dao\bookDao.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */