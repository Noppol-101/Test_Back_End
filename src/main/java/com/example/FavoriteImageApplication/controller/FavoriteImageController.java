package com.example.FavoriteImageApplication.controller;

import com.example.FavoriteImageApplication.entity.FavoriteImage;
import com.example.FavoriteImageApplication.service.FavoriteImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/favorite-images")
@CrossOrigin(origins = "https://test-front-end-zeta.vercel.app")
public class FavoriteImageController {

    @Autowired
    private FavoriteImageService favoriteImageService;

    @PostMapping
    public ResponseEntity<FavoriteImage> saveImage(@RequestBody FavoriteImage favoriteImage) {
        FavoriteImage savedImage = favoriteImageService.saveImage(favoriteImage);
        return ResponseEntity.ok(savedImage);
    }

    @GetMapping
    public ResponseEntity<List<FavoriteImage>> getAllImages() {
        List<FavoriteImage> images = favoriteImageService.getAllImages();
        return ResponseEntity.ok(images);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FavoriteImage> getImageById(@PathVariable Long id) {
        return favoriteImageService.getImageById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteImageById(@PathVariable Long id) {
        favoriteImageService.deleteImageById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/last-10-years")
    public ResponseEntity<List<FavoriteImage>> getImagesFromLast10Years() {
        List<FavoriteImage> images = favoriteImageService.getImagesFromLast10Years();
        return ResponseEntity.ok(images);
    }
}
