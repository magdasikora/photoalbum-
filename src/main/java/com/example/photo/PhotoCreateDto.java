package com.example.photo;

import lombok.Data;

@Data
public class PhotoCreateDto {

    private String name;
    private String description;
    private String UploaderName;
    private String view;
}
