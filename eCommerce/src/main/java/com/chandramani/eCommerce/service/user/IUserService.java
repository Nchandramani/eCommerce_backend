package com.chandramani.eCommerce.service.user;

import com.chandramani.eCommerce.dto.UserDto;
import com.chandramani.eCommerce.model.User;
import com.chandramani.eCommerce.request.CreateUserRequest;
import com.chandramani.eCommerce.request.UserUpdateRequest;

public interface IUserService {

    User getUserById(Long userId);
    User createUser(CreateUserRequest request);
    User updateUser(UserUpdateRequest request, Long userId);
    void deleteUser(Long userId);

    UserDto convertUserToDto(User user);

    User getAuthenticatedUser();
}