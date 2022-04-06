package pl.coderslab.book;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

@Controller
@RequestMapping("/book")
public class BookController {

    private final BookDao bookDao;
    private final PublisherDao publisherDao;
    private final Validator validator;

    public BookController(BookDao bookDao, PublisherDao publisherDao, Validator validator) {
        this.bookDao = bookDao;
        this.publisherDao = publisherDao;
        this.validator = validator;
    }

    @ResponseBody
    @GetMapping("/save")
    public String save() {
        Book book = new Book();
        book.setTitle("Thinking in Java");

        Set<ConstraintViolation<Book>> constraintViolations = validator.validate(book);
        if(constraintViolations.isEmpty()){
            Publisher build =
                    Publisher.builder().name("Helion").city("Warszawa").zipCode("09-400").street("Płocka").number("11B").build();

            publisherDao.save(build);
            book.setPublisher(build);
            bookDao.save(book);
        }else {

            for (ConstraintViolation<Book> constraintViolation : constraintViolations) {
                System.out.println(constraintViolation.getPropertyPath());
                System.out.println(constraintViolation.getMessage());
            }

        }

        return "ok";
    }

    @GetMapping("/add")
    public String carForm(Model model) {
        model.addAttribute("publishers", publisherDao.findAll());
        model.addAttribute("book", new Book());
        return "book/add";
    }

    @PostMapping("/add")
    public String bookAdd(Book book) {
        bookDao.save(book);
        return "redirect:/book/list";
    }

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("books", bookDao.findAll());
        return "book/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable long id) {
        bookDao.delete(bookDao.findById(id));
        return "redirect:/book/list";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable long id, Model model) {
        model.addAttribute("book", bookDao.findById(id));
        model.addAttribute("publishers", publisherDao.findAll());
        return "book/edit";
    }

    @PostMapping("/update")
    public String updateAdd(Book book) {
        bookDao.update(book);
        return "redirect:/book/list";
    }

}
