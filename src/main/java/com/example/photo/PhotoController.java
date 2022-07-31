package com.example.photo;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/photoalbum")
@RequiredArgsConstructor


public class PhotoController {

    private final PhotoService photoService;

    @PostMapping("/photo")
    public ResponseEntity<Void> addPhoto(@RequestBody @Valid Photo photo) {
        this.photoService.addPhoto(photo);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePhoto(@PathVariable long id){
        this.photoService.deletePhoto(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Photo> updatePhoto(@PathVariable long id, @RequestBody Photo photo){
        this.photoService.updatePhoto(id, photo);
        return ResponseEntity.status(HttpStatus.OK).body(photo);
    }

    @GetMapping("/photos")
    public ResponseEntity <List<Photo>> getPhotos(){
        List<Photo> photosList = this.photoService.getPhotos();
        return ResponseEntity.status(HttpStatus.OK).body(photosList);
    }

}
