package com.byteandbolt.byteAndBolt.controllers;

import com.byteandbolt.byteAndBolt.DTOs.UserRegisterDTO;
import com.byteandbolt.byteAndBolt.DTOs.UserResponseDTO;
import com.byteandbolt.byteAndBolt.entity.UserEntity;
import com.byteandbolt.byteAndBolt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<UserResponseDTO> registerUser(@RequestBody UserRegisterDTO userDTO) {
        UserResponseDTO userResponseDTO = userService.createUser(userDTO);
        return new ResponseEntity<>(userResponseDTO, HttpStatus.OK);
    }
}
