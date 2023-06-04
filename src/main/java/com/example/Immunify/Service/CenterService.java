package com.example.Immunify.Service;

import com.example.Immunify.Dto.RequestDto.CenterRequestDto;
import com.example.Immunify.Dto.ResponseDto.CenterResponseDto;
import org.springframework.stereotype.Service;

@Service
public interface CenterService {
    public CenterResponseDto addCenter(CenterRequestDto centerRequestDto);
}
