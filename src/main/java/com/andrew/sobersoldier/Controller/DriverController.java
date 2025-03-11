package com.andrew.sobersoldier.Controller;

import com.andrew.sobersoldier.Entities.DriverEntity;
import com.andrew.sobersoldier.Service.DriverService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/drivers")
@RequiredArgsConstructor
public class DriverController {
    private final DriverService driverService;

    @GetMapping
    public ResponseEntity<List<DriverEntity>> getAllDrivers() {
        List<DriverEntity> drivers = driverService.getAllDrivers();
        return ResponseEntity.ok(drivers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DriverEntity> getDriverById(@PathVariable Long id) {
        return driverService.getDriverById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<DriverEntity> createDriver(@RequestBody DriverEntity driver) {
        DriverEntity createdDriver = driverService.createDriver(driver);
        return ResponseEntity.ok(createdDriver);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DriverEntity> updateDriver(
            @PathVariable Long id,
            @RequestBody DriverEntity updatedDriver
    ) {
        DriverEntity driver = driverService.updateDriver(id, updatedDriver);
        return ResponseEntity.ok(driver);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDriver(@PathVariable Long id) {
        driverService.deleteDriver(id);
        return ResponseEntity.noContent().build();
    }
}
