package mk.ukim.finki.emt2025.lab1.web;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import mk.ukim.finki.emt2025.lab1.dto.*;
import mk.ukim.finki.emt2025.lab1.model.domain.User;
import mk.ukim.finki.emt2025.lab1.model.exceptions.InvalidArgumentsException;
import mk.ukim.finki.emt2025.lab1.model.exceptions.PasswordsDoNotMatchException;
import mk.ukim.finki.emt2025.lab1.model.exceptions.InvalidUserCredentialsException;
import mk.ukim.finki.emt2025.lab1.service.application.UserApplicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@Tag(name = "User API", description = "Endpoints for user registration, login, and session management")
public class UserRestController {
    private final UserApplicationService userApplicationService;

    public UserRestController(UserApplicationService userApplicationService) {
        this.userApplicationService = userApplicationService;
    }


    @Operation(summary = "List all users", description = "Returns a list of all registered users")
    @ApiResponse(responseCode = "200", description = "Users listed successfully")
    @GetMapping("/all")
    public ResponseEntity<List<UpdateUserDto>> findAllUsers() {
        List<UpdateUserDto> user = userApplicationService.findAll();
        return ResponseEntity.ok(user);
    }

    @Operation(summary = "Register a new user", description = "Creates a new user account")
    @ApiResponses(
            value = {@ApiResponse(
                    responseCode = "200",
                    description = "User registered successfully"
            ), @ApiResponse(
                    responseCode = "400", description = "Invalid input or passwords do not match"
            )}
    )
    @PostMapping("/register")
    public ResponseEntity<UpdateUserDto> register(@RequestBody CreateUserDto createUserDto) {
        try {
            return userApplicationService.register(createUserDto)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
        } catch (InvalidArgumentsException | PasswordsDoNotMatchException exception) {
            return ResponseEntity.badRequest().build();
        }
    }

    @Operation(summary = "User login", description = "Authenticates a user and generates a JWT")
    @ApiResponses(
            value = {@ApiResponse(
                    responseCode = "200",
                    description = "User authenticated successfully"
            ), @ApiResponse(responseCode = "404", description = "Invalid username or password")}
    )
    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginUserDto loginUserDto) {
        try {
//            UpdateUserDto displayUserDto = userApplicationService.login(
//                    new LoginUserDto(request.getParameter("username"), request.getParameter("password"))
//            ).orElseThrow(InvalidUserCredentialsException::new);
//
//            request.getSession().setAttribute("user", displayUserDto.toUser());
//            return ResponseEntity.ok(displayUserDto);
            return userApplicationService.login(loginUserDto)
                    .map(ResponseEntity::ok)
                    .orElseThrow(InvalidUserCredentialsException::new);
        } catch (InvalidUserCredentialsException e) {
            return ResponseEntity.notFound().build();
        }
    }

//    @Operation(summary = "User logout", description = "Ends the user's session")
//    @ApiResponse(responseCode = "200", description = "User logged out successfully")
//    @GetMapping("/logout")
//    public void logout(HttpServletRequest request) {
//        request.getSession().invalidate();
//    }

}
