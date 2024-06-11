package jp.te4a.spring.boot.myapp9.mybootapp9;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;

    public BookForm create(BookForm bookForm) {
        //bookForm.setId(bookRepository.getBookId());
        BookBean bookBean = new BookBean();
        BeanUtils.copyProperties(bookForm, bookBean);
        bookRepository.save(bookBean);
        return bookForm;
        //【追加処理】データはBookFormで扱い、
        //Repositoryを使う時は
        //BookBeanに入れて渡す
        }
        /*public BookForm save(BookForm bookForm) {
            BookBean bookBean = new BookBean();
            BeanUtils.copyProperties(bookForm, bookBean);
            bookRepository.save(bookBean);
            return bookForm;
        }*/
        public BookForm update(BookForm bookForm) {
            BookBean bookBean = new BookBean();
            BeanUtils.copyProperties(bookForm, bookBean);
            bookRepository.save(bookBean);
            return bookForm;
        }
    public void delete(Integer id) { 
        bookRepository.deleteById(id); 
    }    //削除処理
    
    public List<BookForm> findAll() {
        List<BookBean> beanList = bookRepository.findAll();
        List<BookForm> formList = new ArrayList<BookForm>();
        for(BookBean bookBean: beanList) {
        BookForm bookForm = new BookForm();
        BeanUtils.copyProperties(bookBean, bookForm);
        formList.add(bookForm);
    }
    return formList;//【取得処理】（全件）
    }

    public BookForm findOne(Integer id) {
        Optional<BookBean> optionalBook = bookRepository.findById(id);
        if (optionalBook.isPresent()) {
            BookBean book = optionalBook.get();
            // BookBeanからBookFormへの変換処理
            BookForm bookForm = new BookForm();
            bookForm.setId(book.getId());
            bookForm.setTitle(book.getTitle());
            bookForm.setWritter(book.getWritter());
            bookForm.setPublisher(book.getPublisher());
            bookForm.setPrice(book.getPrice());
           // bookForm.setAuthor(book.getAuthor());
            return bookForm;
        } else {
            return null;
        }
    //public Optional<BookBean> findOne(Integer id) {
   /*  public BookForm findOne(Integer id) {
        
        Optional<BookBean> opt = bookRepository.findById(id);
        BookBean book = opt.get();
        BookForm bookForm = new BookForm();
        opt.ifPresent(book -> {


            // bookを使った処理
            bookForm.setId(book.getId());
            bookForm.setPrice(book.getPrice());
            bookForm.setPublisher(book.getPublisher());
            bookForm.setTitle(book.getTitle());
            bookForm.setWritter(book.getWritter());
            

           });
    
        //BeanUtils.copyProperties(bookBean, bookForm);
        return bookForm;//【取得処理】（１件）
        //return bookRepository.findById(id);
        
    }*/
    }
}

