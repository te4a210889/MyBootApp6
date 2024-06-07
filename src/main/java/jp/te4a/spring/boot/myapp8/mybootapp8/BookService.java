package jp.te4a.spring.boot.myapp8.mybootapp8;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;
    public BookForm create(BookForm bookForm) {
        //データはBookFormで扱い、Repositoryを使う時は
        //BookBeanに入れて渡す
        //
        bookForm.setId(bookRepository.getBookId());
        BookBean bookBean = new BookBean();
        BeanUtils.copyProperties(bookForm, bookBean);
        bookRepository.create(bookBean);
        return bookForm;
    }

        public BookForm update(BookForm bookForm) {//更新
            BookBean bookBean = new BookBean();
            BeanUtils.copyProperties(bookForm, bookBean);
            bookRepository.update(bookBean);
            return bookForm;
        }
public void delete(Integer id) { bookRepository.delete(id); }//削除

    public List<BookForm> findAll() {
        List<BookBean> beanList = bookRepository.findAll();//取得処理全て
        List<BookForm> formList = new ArrayList<BookForm>();
        for(BookBean bookBean: beanList) {
        BookForm bookForm = new BookForm();
        BeanUtils.copyProperties(bookBean, bookForm);
        formList.add(bookForm);
    }
    return formList;
}
        public BookForm findOne(Integer id) {
            BookBean bookBean = bookRepository.findOne(id);
            BookForm bookForm = new BookForm(); //1件
            BeanUtils.copyProperties(bookBean, bookForm);
            return bookForm;
        }
}