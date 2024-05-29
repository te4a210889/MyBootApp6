package jp.te4a.spring.boot.myapp6.mybootapp6;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {
    private final ConcurrentMap<Integer, BookBean> bookMap
    = new ConcurrentHashMap<>();

    public BookBean save(BookBean bookBean) {//保存用メソッド
        return bookMap.put(bookBean.getId(), bookBean);
    }
    public void delete(Integer bookId) {//削除メソッド
        bookMap.remove(bookId);
    }
    public List<BookBean> findAll() {
        return new ArrayList<>(bookMap.values());//取得メソッド
    }
}