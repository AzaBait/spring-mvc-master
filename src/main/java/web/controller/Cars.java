package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/cars")
public class Cars {

    static List<Car> cars = List.of(new Car("Ford Raptor",2008,"Blue"),
                                    new Car("Dodge Ram", 2010,"Red"),
                                    new Car("Toyota Tundra", 2012,"Black"),
                                    new Car("Jeep Wrangler", 2010, "Green"),
                                    new Car("Land Rover", 2015, "White"));

    @GetMapping
    public String getCar(@RequestParam(value = "name", required = false) String name, Model model){
        model.addAttribute("cars", cars);
        return "cars";
    }

    @GetMapping("/cars")
    public String carsCount(@RequestParam(value = "count", required = false) int count,Model model){
        List<Car> carList = new ArrayList<>();
        if (count > 5){
            model.addAttribute("cars", cars);
        }else {
            for (int i = 0; i < count; i++) {
                carList.add(cars.get(i));
            }
            model.addAttribute("cars", carList);
        }return "cars";
    }

}
