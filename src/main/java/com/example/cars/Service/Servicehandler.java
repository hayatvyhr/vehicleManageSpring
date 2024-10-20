package com.example.cars.Service;

import com.example.cars.Dto.CarDto;
import com.example.cars.Entity.vehicle;
import com.example.cars.Repository.AdminRepo;
import com.example.cars.Repository.CarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
class Servicehandler implements ServiceBorkizi {
    @Autowired
    private AdminRepo adminRepository;
    @Autowired
    private CarRepo carRepository;
    String userDir = System.getProperty("user.dir");
    String uploadDir = userDir + File.separator + "Car";

    @Override
    public String verifyCredential(String username, String password) {
        if (adminRepository.existsByUsernameAndPassword(username, password)) {
            return "Login successful";
        } else {
            return "Invalid credentials";
        }
    }

    @Override
    public String addCar(CarDto carDTO) throws IOException {
        MultipartFile carPicture = carDTO.getCarPicture();

        vehicle car = new vehicle();
        car.setPrice(carDTO.getPrice());
        car.setType(carDTO.getType());
        car.setVin(carDTO.getVin());
        car.setColor(carDTO.getColor());
        car.setYear(carDTO.getYear());
        car.setModel(carDTO.getModel());
        car.setManufacturer(carDTO.getManufacturer());
        car.setEmail(carDTO.getEmail());
        car.setWhatsappNumber(carDTO.getWhatsappNumber());
        car.setOwnerPhoneNumber(carDTO.getOwnerPhoneNumber());
        car.setOwnerName(carDTO.getOwnerName());
        car.setCarName(carDTO.getCarName());
        car.setCarNumber(carDTO.getCarNumber());
        car.setIdCar(carDTO.getIdCar());

        // Check if the car image is not empty
        if (!carPicture.isEmpty()) {
            System.out.println(carPicture);

            String imagePath = saveImage(carPicture);
            car.setCarPicture(imagePath);
        }

        // Save the vehicle object to the repository
        carRepository.save(car);

        return "Car added successfully with ID: " + car.getIdCar();
    }

    private String saveImage(MultipartFile carImage) throws IOException {
        File uploadFolder = new File(uploadDir);
        if (!uploadFolder.exists()) {
            boolean dirCreated = uploadFolder.mkdirs();
            if (!dirCreated) {
                throw new IOException("Failed to create directory: " + uploadDir);
            } else {
                System.out.println("Directory created successfully: " + uploadDir);
            }
        }
        String originalFilename = carImage.getOriginalFilename();
        String fileExtension = originalFilename.substring(originalFilename.lastIndexOf("."));
        String newFileName = UUID.randomUUID().toString() + fileExtension;
        Path imagePath = Paths.get(uploadDir, newFileName);
        Files.copy(carImage.getInputStream(), imagePath, StandardCopyOption.REPLACE_EXISTING);
        return  newFileName;
    }

    @Override
    public String updateCar(CarDto carDTO) throws IOException {
        // Check if the car exists in the repository
        if (carRepository.existsById(carDTO.getIdCar())) {
            // Retrieve the existing car entity
            vehicle car = carRepository.findById(carDTO.getIdCar()).orElseThrow(() ->
                    new RuntimeException("Car not found with ID: " + carDTO.getIdCar())
            );

            // Update other fields unconditionally
            car.setCarName(carDTO.getCarName());
            car.setCarNumber(carDTO.getCarNumber());
            car.setOwnerPhoneNumber(carDTO.getOwnerPhoneNumber());
            car.setOwnerName(carDTO.getOwnerName());
            car.setManufacturer(carDTO.getManufacturer());
            car.setYear(carDTO.getYear());
            car.setModel(carDTO.getModel());
            car.setVin(carDTO.getVin());
            car.setColor(carDTO.getColor());
            car.setEmail(carDTO.getEmail());
            car.setWhatsappNumber(carDTO.getWhatsappNumber());
            car.setType(carDTO.getType());
            car.setPrice(carDTO.getPrice());

            // Check if the car picture is provided and not empty
            MultipartFile carPicture = carDTO.getCarPicture();
            if (carPicture != null && !carPicture.isEmpty()) {
                // Only update the car picture if a new one is uploaded
                String imagePath = saveImage(carPicture);
                car.setCarPicture(imagePath);
            }
            // If carPicture is null or empty, keep the existing car picture

            // Save the updated car entity back to the repository
            carRepository.save(car);
            return "Car info updated successfully with ID: " + car.getIdCar();
        } else {
            return "Car not found with ID: " + carDTO.getIdCar();
        }
    }



    @Override
    public List<CarDto> getallCars() {
        List<vehicle> cars = carRepository.findAll();
        System.out.println(cars);
        List<CarDto> carDtos = new ArrayList<>();
        String baseUrl = "http://localhost:8088/"; // Base URL for serving images

        for (vehicle car : cars) {
            // Check if carPicture is correctly retrieved from the entity
            String carPictureUrl = (car.getCarPicture() != null && !car.getCarPicture().isEmpty())
                    ? baseUrl + "Car/" + car.getCarPicture()
                    : null;

            CarDto carDto = new CarDto(
                    car.getIdCar(),
                    car.getCarNumber(),
                    car.getCarName(),
                    car.getOwnerName(),
                    car.getOwnerPhoneNumber(),
                    car.getWhatsappNumber(),
                    car.getEmail(),
                    car.getManufacturer(),
                    car.getModel(),
                    car.getYear(),
                    car.getColor(),
                    car.getVin(),
                    car.getType(),
                    car.getPrice(),
                    carPictureUrl // Here is the image URL

            );
            System.out.println(carPictureUrl);
            System.out.println(carDto);
            carDtos.add(carDto);
        }
        return carDtos;
    }


    @Override
    public boolean deletevehicle(int id) {
        if (carRepository.existsById(id)) {
            carRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
