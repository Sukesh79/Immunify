package com.example.Immunify.Transformer;

import com.example.Immunify.Dto.RequestDto.UserRequestDto;
import com.example.Immunify.Dto.ResponseDto.UserResponseDto;
import com.example.Immunify.Model.User;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserTransformer {
    public static User UserRequestDtoToUser(UserRequestDto userRequestDto){
        return User.builder()
                .age(userRequestDto.getAge())
                .name(userRequestDto.getName())
                .emailId(userRequestDto.getEmailId())
                .mobNo(userRequestDto.getMobNo())
                .gender(userRequestDto.getGender())
                .build();
    }
    public static UserResponseDto userToUserResponseDto(User user){
        return UserResponseDto.builder()
                .name(user.getName())
                .message("You have successfully reigisterd")
                .build();
    }

}
