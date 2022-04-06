package pl.coderslab.car;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {

    List<Car> findByBrand(String brand);

    List<Car> findByBrandAndModel(String brand, String model);

    List<Car> findByModelAndAgeGreaterThan(String model, int age);
}
