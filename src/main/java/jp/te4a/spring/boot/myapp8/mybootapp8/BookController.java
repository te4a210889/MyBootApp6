package jp.te4a.spring.boot.myapp8.mybootapp8;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.servlet.ModelAndView;


    @Controller
    @RequestMapping("books")///booksにアクセスされた時のコントローラ


    public class BookController {
        @Autowired
    BookService bookService;

    @ModelAttribute//@ModelAttributeの付与されたメソッド
    // 戻り値は、各コントローラ処理の前に自
    //動でModelに追加される
    //そのため、以下のようにBookFormが受
    //け渡しされる
    BookForm setUpForm() {
        return new BookForm();
    }

    @GetMapping
    String list(Model model) {// /booksにGET要求
        model.addAttribute("books", bookService.findAll());
        return "books/list";
    }

    @PostMapping(path="create")
    String create(BookForm form, Model mode) {//books/createにPOST要求
        bookService.create(form);
        return "redirect:/books";
    }

    @PostMapping(path = "edit", params = "form")
    ///books/ceditにパラメタformを含むPOST要求
    String editForm(@RequestParam Integer id, BookForm form) {
        BookForm bookForm = bookService.findOne(id);
        BeanUtils.copyProperties(bookForm, form);
        return "books/edit";
    }
    
    @PostMapping(path = "edit")
    String edit(@RequestParam Integer id, BookForm form) {
        ///books/editにPOST要求
        bookService.update(form);
        return "redirect:/books";
    }

    @PostMapping(path = "delete")
    String delete(@RequestParam Integer id) {
    // /books/deleteにPOST要求
        bookService.delete(id);
        return "redirect:/books";
    }

    @PostMapping(path = "edit", params = "goToTop")
    String goToTop() {
        ///books/editにパラメタgoToTopを含むPOST要求
    return "redirect:/books";
    }
}
