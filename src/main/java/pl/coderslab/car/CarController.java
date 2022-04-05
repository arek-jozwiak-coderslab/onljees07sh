package pl.coderslab.car;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/car")
@Slf4j
public class CarController {

    @GetMapping("/add")
    public String carForm(Model model) {
        Car car = new Car();
        car.setBrand("VW");
        model.addAttribute("car", car);
        return "car/add";
    }

    @PostMapping("/add")
    @ResponseBody
    public String carAdd(Car car) {
        log.info("car :  {} ", car);
        return "car/add";
    }
}
