package com.andrew.sobersoldier.Service;

import com.andrew.sobersoldier.Entities.LocationRequestEntity;
import com.andrew.sobersoldier.Entities.UserEntity;
import com.andrew.sobersoldier.Repositories.LocationRequestRepository;
import com.andrew.sobersoldier.Repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LocationRequestService {

    private final LocationRequestRepository locationRequestRepository;
    private final UserRepository userRepository;

    public List<LocationRequestEntity> getAllLocationRequests() {
        return locationRequestRepository.findAll();
    }

    public Optional<LocationRequestEntity> getLocationRequestById(Long id) {
        return locationRequestRepository.findById(id);
    }

    public LocationRequestEntity createLocationRequest(Long userId, Double latitude, Double longitude) {
        UserEntity user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));

        LocationRequestEntity locationRequest = LocationRequestEntity.builder()
                .user(user)
                .latitude(latitude)
                .longitude(longitude)
                .status("PENDING")
                .build();

        return locationRequestRepository.save(locationRequest);
    }

    public LocationRequestEntity updateLocationRequestStatus(Long requestId, String newStatus) {
        LocationRequestEntity request = locationRequestRepository.findById(requestId)
                .orElseThrow(() -> new RuntimeException("Location request not found with id: " + requestId));

        request.setStatus(newStatus);
        return locationRequestRepository.save(request);
    }

    public void deleteLocationRequest(Long id) {
        locationRequestRepository.deleteById(id);
    }

    // Optionally, a method to get all requests by status
    public List<LocationRequestEntity> getRequestsByStatus(String status) {
        return locationRequestRepository.findByStatus(status);
    }
}
