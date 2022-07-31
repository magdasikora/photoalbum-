package com.example.photo;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
@Service
@AllArgsConstructor
public class PhotoService {
    private final Map<Photo, Long> photos;
    private final PhotoMapper photoMapper;
    private final PhotoRepo photoRepo;

    public void addPhoto(Photo photo) {
        this.photos.put(photo, photo.getId());
        photoRepo.save(photo);
    }

    public void deletePhoto(long id) {
        this.photos.remove(id);
        photoRepo.deleteById(id);
    }

    public void updatePhoto(Long id, Photo photo) {
        if (photoRepo.existsById(id)) {
            Photo updatedPhoto = photoRepo.findById(id).get();
            updatedPhoto.setName(photo.getName());
            updatedPhoto.setDescription(photo.getDescription());
            updatedPhoto.setViev(photo.getViev());
            photoRepo.save(updatedPhoto);
        }
    }

    public List<Photo> getPhotos(){
    return photoRepo.findAll();}
}