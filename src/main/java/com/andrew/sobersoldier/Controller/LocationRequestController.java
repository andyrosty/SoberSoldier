package com.andrew.sobersoldier.Controller;

import com.andrew.sobersoldier.Entities.LocationRequestEntity;
import com.andrew.sobersoldier.Service.LocationRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/requests")
@RequiredArgsConstructor
public class LocationRequestController {
    private final LocationRequestService locationRequestService;

    @GetMapping
    public ResponseEntity<List<LocationRequestEntity>> getAllLocationRequests() {
        List<LocationRequestEntity> allRequests = locationRequestService.getAllLocationRequests();
        return ResponseEntity.ok(allRequests);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LocationRequestEntity> getLocationRequestById(@PathVariable Long id) {
        return locationRequestService.getLocationRequestById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Creates a new location request for a given userId
     */
    @PostMapping
    public ResponseEntity<LocationRequestEntity> createLocationRequest(
            @RequestParam Long userId,
            @RequestParam Double latitude,
            @RequestParam Double longitude
    ) {
        LocationRequestEntity createdRequest = locationRequestService.createLocationRequest(userId, latitude, longitude);
        return ResponseEntity.ok(createdRequest);
    }

    /**
     * Updates the status of an existing location request.
     * This could be used by drivers to mark as "ACCEPTED", "COMPLETED", etc.
     */
    @PutMapping("/{id}/status")
    public ResponseEntity<LocationRequestEntity> updateLocationRequestStatus(
            @PathVariable Long id,
            @RequestParam String status
    ) {
        LocationRequestEntity updatedRequest = locationRequestService.updateLocationRequestStatus(id, status);
        return ResponseEntity.ok(updatedRequest);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLocationRequest(@PathVariable Long id) {
        locationRequestService.deleteLocationRequest(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * Example endpoint if you want to filter by status
     * GET /api/requests/by-status?status=PENDING
     */
    @GetMapping("/by-status")
    public ResponseEntity<List<LocationRequestEntity>> getRequestsByStatus(@RequestParam String status) {
        List<LocationRequestEntity> requests = locationRequestService.getRequestsByStatus(status);
        return ResponseEntity.ok(requests);
    }
}
