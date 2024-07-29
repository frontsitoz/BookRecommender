package com.backend.controller;


import com.backend.model.DTO.UserDto;
import com.backend.model.User;
import com.backend.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RestController
@RequestMapping("api/users")

@RequiredArgsConstructor
public class UserController {

    private final IUserService userService;

    @Qualifier("defaultMapper")
    private final ModelMapper mapper;

    @GetMapping
    public ResponseEntity<List<UserDto>> findAll() {

        List<User> users = userService.findAll();
        List<UserDto> dtos = users.stream().map(this::convertToDto).toList();
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        User user = userService.findById(id);
        return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<UserDto> save(@RequestBody UserDto user) {
        User savedUser = userService.save(convertToEntity(user));
        UserDto dto = convertToDto(savedUser);
        return ResponseEntity.ok(dto);
    }

    @PostMapping("/favorite")
    public ResponseEntity<User> saveFavoriteUser(@RequestBody User user) {
        User savedUser = userService.save(user);
        return ResponseEntity.ok(savedUser);
    }

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