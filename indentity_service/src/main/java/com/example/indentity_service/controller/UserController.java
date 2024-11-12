package com.example.indentity_service.controller;

import com.example.indentity_service.dto.request.UserCreationRequest;
import com.example.indentity_service.entity.User;
import com.example.indentity_service.service.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class UserController {

//    ==============  DEMO ================

    UserService userService;

    @PostMapping("/users")
    User createUser(@RequestBody UserCreationRequest request) {

        return userService.createRequest( request );

    }

    @GetMapping("/test")
    String test(){
        return "sssssssssssssss";
    }


}
