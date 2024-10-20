package com.example.cars.Controller;

import com.example.cars.Dto.CarDto;
import com.example.cars.Dto.aDMINdTOa;
import com.example.cars.Service.ServiceBorkizi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/borkizi")
public class ControllerApp {
    @Autowired
    private ServiceBorkizi service;
    @PostMapping("/login")
    public String loginAdmin(@RequestBody aDMINdTOa adminDTO) {
        String username = adminDTO.getUsername();
        String password = adminDTO.getPassword();
        return service.verifyCredential(username, password);
    }
    @PostMapping("/addvehicle")
    public ResponseEntity<String> addVehicle(@ModelAttribute CarDto carDTO) {
        try {
            String result = service.addCar(carDTO);
            return ResponseEntity.ok(result);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error adding vehicle: " + e.getMessage());
        }
    }

    @PutMapping("/updatevehicle")
    public ResponseEntity<String> updatevehicle(@ModelAttribute CarDto carDTO) {
        System.out.println("Received CarDTO: " + carDTO.getCarName());
        try {
            String result = service.updateCar(carDTO);
            return ResponseEntity.ok(result);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error updating vehicle: " + e.getMessage());
        }
    }

    @GetMapping("/getvehicle")
    public List<CarDto> getAllvehicles() {
        List<CarDto> list = service.getallCars();
        return list ;
    }
    @DeleteMapping("/deletevehicle/{id}")
    public String deleteVehicle(@PathVariable int id) {
        boolean isDeleted = service.deletevehicle(id);
        if (isDeleted) {
            return "Vehicle with ID " + id + " deleted successfully";
        } else {
            return "Vehicle with ID " + id + " not found";
        }
    }


}
