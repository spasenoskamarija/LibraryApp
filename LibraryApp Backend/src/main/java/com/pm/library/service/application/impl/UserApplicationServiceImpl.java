package com.pm.library.service.application.impl;

import com.pm.library.dto.CreateUserDto;
import com.pm.library.dto.LoginResponseDto;
import com.pm.library.dto.LoginUserDto;
import com.pm.library.dto.UpdateUserDto;
import com.pm.library.model.domain.User;
import com.pm.library.security.JwtHelper;
import com.pm.library.service.application.UserApplicationService;
import com.pm.library.service.domain.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserApplicationServiceImpl implements UserApplicationService {

    private final UserService userService;
    private final JwtHelper jwtHelper;

    public UserApplicationServiceImpl(UserService userService, JwtHelper jwtHelper) {
        this.userService = userService;
        this.jwtHelper = jwtHelper;
    }

    @Override
    public Optional<UpdateUserDto> register(CreateUserDto createUserDto) {
        User user = userService.register(
                createUserDto.username(),
                createUserDto.password(),
                createUserDto.repeatPassword(),
                createUserDto.name(),
                createUserDto.surname(),
                createUserDto.role()
        );
        return Optional.of(UpdateUserDto.from(user));    }

    @Override
    public Optional<LoginResponseDto> login(LoginUserDto loginUserDto) {
        User user = userService.login(
                loginUserDto.username(),
                loginUserDto.password()

        );
        String token = jwtHelper.generateToken(user);
        return Optional.of(new LoginResponseDto(token));
    }

    @Override
    public Optional<UpdateUserDto> findByUsername(String username) {
        return Optional.of(UpdateUserDto.from(userService.findByUsername(username)));
    }

    @Override
    public List<UpdateUserDto> findAll() {
        return userService.findAll()
                .stream()
                .map(UpdateUserDto::from) // за секој User, направи UpdateUserDto
                .toList();
    }
}

