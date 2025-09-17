package com.pm.library.service.application;

import com.pm.library.dto.CreateUserDto;
import com.pm.library.dto.LoginResponseDto;
import com.pm.library.dto.LoginUserDto;
import com.pm.library.dto.UpdateUserDto;

import java.util.List;
import java.util.Optional;

public interface UserApplicationService {
    Optional<UpdateUserDto> register(CreateUserDto createUserDto);
    Optional<LoginResponseDto> login(LoginUserDto loginUserDto);
    Optional<UpdateUserDto> findByUsername(String username);
    List<UpdateUserDto> findAll();
}
