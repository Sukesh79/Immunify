package com.example.Immunify.Dto.RequestDto;

import com.example.Immunify.Enum.CenterType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CenterRequestDto {
    String name;
    String location;
    CenterType centerType;
}
