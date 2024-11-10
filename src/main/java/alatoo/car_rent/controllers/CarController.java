package alatoo.car_rent.controllers;

import alatoo.car_rent.model.dto.car.CarFilter;
import alatoo.car_rent.model.dto.car.CarRequest;
import alatoo.car_rent.model.dto.car.CarResponse;
import alatoo.car_rent.service.CarService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/cars")
public class CarController {
    private final CarService carService;

    @PostMapping("/register")
    public ResponseEntity<Void> registerCar(@RequestBody CarRequest request) {
        carService.register(request);
        // Возвращаем статус 204 No Content после успешной регистрации автомобиля
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    public String searchCars(
            @ModelAttribute CarFilter filter,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            Model model
    ) {
        // Получаем список автомобилей по фильтру с учетом пагинации
        List<CarResponse> carResponseList = carService.search(filter, page, size);
        // Добавляем список автомобилей в модель для отображения на странице
        model.addAttribute("carResponseList", carResponseList);
        // Возвращаем имя представления для отображения (например, index.html)
        return "index";
    }
}
