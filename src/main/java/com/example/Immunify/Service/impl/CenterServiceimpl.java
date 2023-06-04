package com.example.Immunify.Service.impl;

import com.example.Immunify.Dto.RequestDto.CenterRequestDto;
import com.example.Immunify.Dto.ResponseDto.CenterResponseDto;
import com.example.Immunify.Model.Center;
import com.example.Immunify.Repository.CenterRepository;
import com.example.Immunify.Service.CenterService;
import com.example.Immunify.Transformer.CenterTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CenterServiceimpl implements CenterService {
    @Autowired
    CenterRepository centerRepository;
    @Override
    public CenterResponseDto addCenter(CenterRequestDto centerRequestDto) {
        Center center  = CenterTransformer.CenterRequestDtoToCenter(centerRequestDto);

        Center savedCenter = centerRepository.save(center);

        return CenterTransformer.CenterToCenterResponseDto(savedCenter);
    }
}
