package jp.te4a.spring.boot.myapp9.mybootapp9;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


//import java.util.ArrayList;

//import java.util.concurrent.ConcurrentHashMap;
//import java.util.concurrent.ConcurrentMap;
//import org.springframework.beans.BeanUtils;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;

public interface BookRepository extends JpaRepository<BookBean, Integer>{
     @Query("SELECT X FROM BookBean X ORDER BY X.title")
 List<BookBean> findAllOrderByTitle();

    
}

//@Repository
/*public class BookRepository {
    
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
}*/