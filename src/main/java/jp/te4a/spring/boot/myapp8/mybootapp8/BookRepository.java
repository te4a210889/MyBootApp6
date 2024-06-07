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
public int getBookId() {
    //IDを発行する仕組み
         return BOOK_ID++;
    }
    public BookBean create(BookBean bookBean) {
            return bookMap.put(bookBean.getId(), bookBean);//作成
        }
        public BookBean update(BookBean updateBookBean) {
            BookBean bookBean = bookMap.get(updateBookBean.getId());
            BeanUtils.copyProperties(updateBookBean, bookBean);
            return bookBean;//更新
        }
        public void delete(Integer bookId) {
            bookMap.remove(bookId);//削除
        }
        public List<BookBean> findAll() {
            return new ArrayList<>(bookMap.values());//1件取得
        }
        public BookBean findOne(Integer id) {
            return bookMap.get(id);//全件取得
        }
}