package jp.te4a.spring.boot.myapp8.mybootapp8;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;
@Repository
public class BookRepository {
    private final ConcurrentMap<Integer, BookBean> bookMap = new 
ConcurrentHashMap<>();
    private int BOOK_ID = 1;
    public int getBookId() {//Dを発行する仕組み
    return BOOK_ID++;
}

public BookBean create(BookBean bookBean) {
    return bookMap.put(bookBean.getId(), bookBean);//作成
}
public BookBean update(BookBean updateBookBean) {
    BookBean bookBean = bookMap.get(updateBookBean.getId());//更新
    BeanUtils.copyProperties(updateBookBean, bookBean);
    return bookBean;
 }
public void delete(Integer bookId) {//削除
    bookMap.remove(bookId);
}
public List<BookBean> findAll() {
    return new ArrayList<>(bookMap.values());//取得1件
}
public BookBean findOne(Integer id) {
    return bookMap.get(id);//全件
}
}