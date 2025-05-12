package mk.ukim.finki.emt2025.lab1.service.application.impl;

import mk.ukim.finki.emt2025.lab1.dto.CreateUserDto;
import mk.ukim.finki.emt2025.lab1.dto.LoginResponseDto;
import mk.ukim.finki.emt2025.lab1.dto.LoginUserDto;
import mk.ukim.finki.emt2025.lab1.dto.UpdateUserDto;
import mk.ukim.finki.emt2025.lab1.model.domain.User;
import mk.ukim.finki.emt2025.lab1.security.JwtHelper;
import mk.ukim.finki.emt2025.lab1.service.application.UserApplicationService;
import mk.ukim.finki.emt2025.lab1.service.domain.UserService;
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

