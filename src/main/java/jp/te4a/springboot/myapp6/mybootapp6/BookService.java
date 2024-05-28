@Service
public class BookService {
 @Autowired
 BookRepository bookRepository;
 public BookBean save(BookBean bookBean) {
        return bookRepository.save(bookBean);
    }
 public List<BookBean> findAll() {
        return bookRepository.findAll();
    }

}