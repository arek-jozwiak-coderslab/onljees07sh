package pl.coderslab.book;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

@Controller
@RequestMapping("/validate")
@Slf4j
public class ValidationController {

    private final Validator validation;

    public ValidationController(Validator validation) {
        this.validation = validation;
    }

    @RequestMapping("/book")
    @ResponseBody
    public String test() {
        Book book = new Book();
        book.setTitle("JA");
        book.setRating(22);

        Set<ConstraintViolation<Book>> validate = validation.validate(book);

        if (!validate.isEmpty()) {
            validate.forEach(cv -> log.info("path {} : {}", cv.getPropertyPath(), cv.getMessage()));
        }

        return "aaa";
    }
}
