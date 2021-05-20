package service;

import bean.book;
import java.util.List;
import java.util.Map;

public interface bookService {
  List<book> service_dofilter(Map<String, String> paramMap, int paramInt);
}


/* Location:              C:\Users\22364\Desktop\bookStore_spring2\WEB-INF\classes\!\service\bookService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */