package mk.ukim.finki.emt2025.lab1.service.application;

import mk.ukim.finki.emt2025.lab1.dto.CreateUserDto;
import mk.ukim.finki.emt2025.lab1.dto.LoginResponseDto;
import mk.ukim.finki.emt2025.lab1.dto.LoginUserDto;
import mk.ukim.finki.emt2025.lab1.dto.UpdateUserDto;

import java.util.List;
import java.util.Optional;

public interface UserApplicationService {
    Optional<UpdateUserDto> register(CreateUserDto createUserDto);
    Optional<LoginResponseDto> login(LoginUserDto loginUserDto);
    Optional<UpdateUserDto> findByUsername(String username);
    List<UpdateUserDto> findAll();
}
