package com.example.Immunify.Service.impl;

import com.example.Immunify.Dto.RequestDto.UserRequestDto;
import com.example.Immunify.Dto.ResponseDto.UserResponseDto;
import com.example.Immunify.Model.User;
import com.example.Immunify.Repository.UserRepository;
import com.example.Immunify.Service.UserService;
import com.example.Immunify.Transformer.UserTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceimpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Override
    public UserResponseDto addUser(UserRequestDto userRequestDto) {
        // convert request dto - entity
        User user = UserTransformer.UserRequestDtoToUser(userRequestDto);

        // save the object in db
        User savedUser = userRepository.save(user);

        //entity -> response dto
        return UserTransformer.userToUserResponseDto(savedUser);
    }

    @Override
    public String findByEmailId(String emailId) {
        User user =  userRepository.findByEmailId(emailId);
        return user.getName();
    }

    @Override
    public String updateNameByMobile(String mobile, String name) {
        User user = userRepository.findByMobNo(mobile);
        user.setName(name);
        userRepository.save(user);
        return "Updated";
    }

    @Override
    public List<User> userNotTakenDose1() {
        return userRepository.usersNotTakenDose1();
    }

    @Override
    public List<User> userNotTakenOnlyDose2() {
        return userRepository.userNotTakenOnlyDose2();
    }

    @Override
    public List<User> userFullyVaccinated() {
        return userRepository.userFullyVaccinated();
    }

    @Override
    public List<User> MaleNotTakenDose1() {
        return userRepository.MaleNotTakenDose1();
    }

    @Override
    public List<User> FemaleFullyVaccinated() {
        return userRepository.FemaleFullyVaccinated();
    }
}
