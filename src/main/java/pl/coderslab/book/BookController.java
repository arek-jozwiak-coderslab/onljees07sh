package pl.coderslab.book;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/book")
public class BookController {

    private final BookDao bookDao;
    private final PublisherDao publisherDao;

    public BookController(BookDao bookDao, PublisherDao publisherDao) {
        this.bookDao = bookDao;
        this.publisherDao = publisherDao;
    }

    @ResponseBody
    @GetMapping("/save")
    public String save(){
        Book book = new Book();
        book.setTitle("Thinking in Java");

        Publisher build =
                Publisher.builder().name("Helion").city("Warszawa").zipCode("09-400").street("Płocka").number("11B").build();

        publisherDao.save(build);
        book.setPublisher(build);
        bookDao.save(book);
        return "ok";
    }


}
