package jp.te4a.springboot.myapp6.mybootapp6;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BookBean {
    Integer id ;
    String title;
    String writter;
    String publisher;
    Integer price;
}