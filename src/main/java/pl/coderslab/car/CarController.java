package pl.coderslab.car;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@Controller
@RequestMapping("/car")
@Slf4j
public class CarController {
    private final CarRepository carRepository;

    public CarController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @GetMapping("/add")
    public String ecarForm(Model model) {
        Car car = new Car();
        car.setBrand("VW");
        model.addAttribute("car", car);
        return "car/add";
    }

    @PostMapping("/add")
    @ResponseBody
    public String carAdd(Car car) {
        carRepository.save(car);
        Car one = carRepository.getOne(1L);
        if(one!=null){
            
        }
        Optional<Car> byId = carRepository.findById(1L);

        if(byId.isPresent()){
            ///
        }

        log.info("car :  {} ", car);
        return "car/add";
    }
}
