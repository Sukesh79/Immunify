package com.example.Immunify.Transformer;

import com.example.Immunify.Dto.RequestDto.CenterRequestDto;
import com.example.Immunify.Dto.ResponseDto.CenterResponseDto;
import com.example.Immunify.Model.Center;

public class CenterTransformer {
    public static Center CenterRequestDtoToCenter(CenterRequestDto centerRequestDto){

        return Center.builder()
                .name(centerRequestDto.getName())
                .location(centerRequestDto.getLocation())
                .centerType(centerRequestDto.getCenterType())
                .build();
    }

    public static CenterResponseDto CenterToCenterResponseDto(Center center){

        return CenterResponseDto.builder()
                .name(center.getName())
                .location(center.getLocation())
                .centerType(center.getCenterType())
                .build();
    }
}
