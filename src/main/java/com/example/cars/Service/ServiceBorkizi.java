package com.example.cars.Service;

import com.example.cars.Dto.CarDto;

import java.io.IOException;
import java.util.List;

public interface ServiceBorkizi {
    String verifyCredential(String username, String password);

    String addCar(CarDto carDTO) throws IOException;

    String updateCar(CarDto carDTO) throws IOException;

    List<CarDto> getallCars();

    boolean deletevehicle(int id);





}
