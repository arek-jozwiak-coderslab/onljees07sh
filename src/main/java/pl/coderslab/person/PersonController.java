package pl.coderslab.person;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/person")
public class PersonController {
    private final PersonDao personDao;

    public PersonController(PersonDao personDao) {
        this.personDao = personDao;
    }

    @GetMapping("/add")
    public String personForm(){

        return "person/add";
    }

    @PostMapping("/add")
    public String addPerson(
            @RequestParam String login,
            @RequestParam String password,
            @RequestParam String email
    ){

        Person person = new Person();
        person.setEmail(email);
        person.setLogin(login);
        person.setPassword(password);
        personDao.save(person);
        return "person/add";
    }

}
