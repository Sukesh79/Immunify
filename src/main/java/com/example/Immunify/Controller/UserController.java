package com.example.Immunify.Controller;

import com.example.Immunify.Dto.RequestDto.UserRequestDto;
import com.example.Immunify.Dto.ResponseDto.UserResponseDto;
import com.example.Immunify.Model.User;
import com.example.Immunify.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/User")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/addUser")
    public ResponseEntity addUser(@RequestBody UserRequestDto userRequestDto){

        UserResponseDto userResponseDto = userService.addUser(userRequestDto);
        return new ResponseEntity(userResponseDto, HttpStatus.CREATED);
    }

    @GetMapping("/findByEmailId")
    public ResponseEntity findByEmailId(@RequestParam String emailId){
        String body = userService.findByEmailId(emailId);
        return new ResponseEntity(body, HttpStatus.FOUND);
    }

    @PutMapping("/updateNameByMobile")
    public ResponseEntity updateNameByMobile(@RequestParam String Mobile, @RequestParam String name){
        String body = userService.updateNameByMobile(Mobile, name);
        return new ResponseEntity(body, HttpStatus.OK);
    }

    @GetMapping("/userNotTakenDose1")
    public ResponseEntity userNotTakenDose1(){
        List<User> list = userService.userNotTakenDose1();
        return new ResponseEntity<>(list, HttpStatus.valueOf(201));
    }

    @GetMapping("/userNotTakenOnlyDose2")
    public ResponseEntity userNotTakenOnlyDose2(){
        List<User> list = userService.userNotTakenOnlyDose2();
        return new ResponseEntity<>(list, HttpStatus.valueOf(201));
    }

    @GetMapping("/userFullyVaccinated")
    public ResponseEntity userFullyVaccinated(){
        List<User> list = userService.userFullyVaccinated();
        return new ResponseEntity<>(list, HttpStatus.valueOf(201));
    }

    @GetMapping("/MaleNotTakenDose1")
    public ResponseEntity MaleNotTakenDose1(){
        List<User> list = userService.MaleNotTakenDose1();
        return new ResponseEntity<>(list, HttpStatus.valueOf(200));
    }

    @GetMapping("/FemaleFullyVaccinated")
    public ResponseEntity FemaleFullyVaccinated(){
        List<User> list = userService.FemaleFullyVaccinated();
        return new ResponseEntity<>(list, HttpStatus.valueOf(200));
    }
}
