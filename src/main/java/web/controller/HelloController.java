package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.Service.UserService;
import web.Service.UserServiceImpl;
import web.model.Car;
import web.model.User;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;



@Controller
public class HelloController {

	@GetMapping(value = "/")
	public String printWelcome(ModelMap model) {
		List<String> messages = new ArrayList<>();
		messages.add("Hello!");
		messages.add("I'm Spring MVC application");
		messages.add("5.2.0 version by sep'19 ");
		model.addAttribute("messages", messages);
		return "index";
	}

	@GetMapping(value = "/cars")
	public String carsCount(ModelMap model,
							@RequestParam(value = "count",
									defaultValue = "5")
							int count) {

		Car car1 = new Car("BMW", "E60", "2006");
		Car car2 = new Car("Toyota", "Corolla", "2008");
		Car car3 = new Car("KIA", "Optima", "2018");
		Car car4 = new Car("Hunday", "Sonata", "2010");
		Car car5 = new Car("Nissan", "Sentra", "2023");

		List<Car> carList = new ArrayList<>();
		carList.add(car1);
		carList.add(car2);
		carList.add(car3);
		carList.add(car4);
		carList.add(car5);


		if(count == 0 || count > 5) {
			model.addAttribute("carsCount", carList);
		} else {
			carList = carList.stream().limit(count).collect(Collectors.toList());
			model.addAttribute("carsCount", carList);
		}
		return "cars";
	}
}