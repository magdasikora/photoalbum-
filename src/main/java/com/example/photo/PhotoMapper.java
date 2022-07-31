package com.example.photo;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PhotoMapper {
    Photo map(PhotoCreateDto dto);
}
