package com.example.Immunify.Service;

import com.example.Immunify.Dto.RequestDto.UserRequestDto;
import com.example.Immunify.Dto.ResponseDto.UserResponseDto;
import com.example.Immunify.Model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    public UserResponseDto addUser(UserRequestDto userRequestDto);

    public String findByEmailId(String emailId);

    public String updateNameByMobile(String mobile, String name);

    public List<User> userNotTakenDose1();

    public List<User> userNotTakenOnlyDose2();

    public List<User> userFullyVaccinated();

    public List<User> MaleNotTakenDose1();

    public List<User> FemaleFullyVaccinated();
}
