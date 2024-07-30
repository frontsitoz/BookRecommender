package com.backend.controller;


import com.backend.model.DTO.UserDto;
import com.backend.model.User;
import com.backend.service.IUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@Tag(name = "User", description = "Users API")
@RestController
@RequestMapping("api/users")

@RequiredArgsConstructor
public class UserController {

    private final IUserService userService;

    @Qualifier("defaultMapper")
    private final ModelMapper mapper;

    @Operation(
            summary = "Get users",
            description = "Get users of the BD"
    )
    @GetMapping("/findAll")
    public ResponseEntity<List<UserDto>> findAll() {

        List<User> users = userService.findAll();
        List<UserDto> dtos = users.stream().map(this::convertToDto).toList();
        return ResponseEntity.ok(dtos);
    }

    @Operation(
            summary = "Get users",
            description = "Get users of the DB by id"
    )
    @GetMapping("/findBy/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        User user = userService.findById(id);
        return ResponseEntity.ok(user);
    }

    @Operation(
            summary = "Save users",
            description = "save users of the DB by name"
    )
    @PostMapping("/save")
    public ResponseEntity<UserDto> save(@RequestBody UserDto user) {
        User savedUser = userService.save(convertToEntity(user));
        UserDto dto = convertToDto(savedUser);
        return ResponseEntity.ok(dto);
    }
//
//
//    @PostMapping("/favorite")
//    public ResponseEntity<User> saveFavoriteUser(@RequestBody User user) {
//        User savedUser = userService.save(user);
//        return ResponseEntity.ok(savedUser);
//    }

    @Operation(
            summary = "Update users",
            description = "Update users of the DB by id"
    )
    @PutMapping("/{id}")
    public ResponseEntity<User> update(@RequestBody User user, @PathVariable Long id) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        User updatedUser = userService.update(user, id);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        userService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    /////////////////////////////////////
    private UserDto convertToDto(User obj){
        return mapper.map(obj, UserDto.class);
    }

    private User convertToEntity(UserDto dto){
        return mapper.map(dto, User.class);
    }
}