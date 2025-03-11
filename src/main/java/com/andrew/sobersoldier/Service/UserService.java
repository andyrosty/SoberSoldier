package com.andrew.sobersoldier.Service;

import com.andrew.sobersoldier.Entities.UserEntity;
import com.andrew.sobersoldier.Repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<UserEntity> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public UserEntity createUser(UserEntity user) {
        // Optionally add checks for email uniqueness, etc.
        return userRepository.save(user);
    }

    public UserEntity updateUser(Long id, UserEntity updatedUser) {
        return userRepository.findById(id)
                .map(existingUser -> {
                    existingUser.setName(updatedUser.getName());
                    existingUser.setEmail(updatedUser.getEmail());
                    existingUser.setPhone(updatedUser.getPhone());
                    // No need to update createdAt in most cases
                    return userRepository.save(existingUser);
                })
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
