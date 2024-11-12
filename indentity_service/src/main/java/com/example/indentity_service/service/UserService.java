package com.example.indentity_service.service;

import com.example.indentity_service.dto.request.UserCreationRequest;
import com.example.indentity_service.entity.User;
import com.example.indentity_service.mapper.UserMapper;
import com.example.indentity_service.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal=true)
@RequiredArgsConstructor
public class UserService {

    UserRepository userRepository;
    UserMapper userMapper;

    public User createRequest(UserCreationRequest request){

        User user = userMapper.toUser(request);

        return userRepository.save(user);

    }


}
