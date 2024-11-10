package alatoo.car_rent.service;

import alatoo.car_rent.model.dto.car.CarFilter;
import alatoo.car_rent.model.dto.car.CarRequest;
import alatoo.car_rent.model.dto.car.CarResponse;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface CarService {
    void register(CarRequest request);
    List<CarResponse> search(CarFilter filter, int page, int size);
}