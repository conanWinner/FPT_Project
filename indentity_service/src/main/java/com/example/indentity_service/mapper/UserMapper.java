package com.example.indentity_service.mapper;

import com.example.indentity_service.dto.request.UserCreationRequest;
import com.example.indentity_service.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toUser(UserCreationRequest request);

}
