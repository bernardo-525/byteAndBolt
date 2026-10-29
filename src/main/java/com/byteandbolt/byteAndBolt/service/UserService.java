package com.byteandbolt.byteAndBolt.service;

import com.byteandbolt.byteAndBolt.DTOs.UserRegisterDTO;
import com.byteandbolt.byteAndBolt.DTOs.UserResponseDTO;
import com.byteandbolt.byteAndBolt.entity.UserEntity;
import com.byteandbolt.byteAndBolt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public UserResponseDTO createUser(UserRegisterDTO userDTO) {
        //Check if the user email already exist
        List<UserEntity> existingUsers = userRepository.findByEmail(userDTO.getEmail());
        if(!existingUsers.isEmpty()){
            throw new RuntimeException("User with email " + userDTO.getEmail() + " already exists");
        }
        UserEntity userEntity = new UserEntity();
        userEntity.setName(userDTO.getName());
        userEntity.setEmail(userDTO.getEmail());
        userEntity.setPassword(userDTO.getPassword());
        userEntity.setCreatedAt(userDTO.getCreatedAt());

        UserEntity savedUser = userRepository.save(userEntity);

        UserResponseDTO responseDTO = new UserResponseDTO();
        responseDTO.setName(savedUser.getName());
        responseDTO.setEmail(savedUser.getEmail());
        responseDTO.setCreatedAt(savedUser.getCreatedAt());

        return responseDTO;
    }


}
