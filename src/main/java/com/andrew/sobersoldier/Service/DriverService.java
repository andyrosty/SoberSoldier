package com.andrew.sobersoldier.Service;


import com.andrew.sobersoldier.Entities.DriverEntity;
import com.andrew.sobersoldier.Repositories.DriverRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DriverService {

    private final DriverRepository driverRepository;

    public List<DriverEntity> getAllDrivers() {
        return driverRepository.findAll();
    }

    public Optional<DriverEntity> getDriverById(Long id) {
        return driverRepository.findById(id);
    }

    public DriverEntity createDriver(DriverEntity driver) {
        // Optionally add checks for phone uniqueness, etc.
        return driverRepository.save(driver);
    }

    public DriverEntity updateDriver(Long id, DriverEntity updatedDriver) {
        return driverRepository.findById(id)
                .map(existingDriver -> {
                    existingDriver.setName(updatedDriver.getName());
                    existingDriver.setPhone(updatedDriver.getPhone());
                    return driverRepository.save(existingDriver);
                })
                .orElseThrow(() -> new RuntimeException("Driver not found with id: " + id));
    }

    public void deleteDriver(Long id) {
        driverRepository.deleteById(id);
    }
}
