package com.example.FavoriteImageApplication.service;

import com.example.FavoriteImageApplication.entity.FavoriteImage;
import com.example.FavoriteImageApplication.repository.FavoriteImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class FavoriteImageService {

    @Autowired
    private FavoriteImageRepository favoriteImageRepository;

    public FavoriteImage saveImage(FavoriteImage favoriteImage) {
        favoriteImage.setCreatedDate(LocalDateTime.now());
        return favoriteImageRepository.save(favoriteImage);
    }

    public List<FavoriteImage> getAllImages() {
        return favoriteImageRepository.findAll();
    }

    public Optional<FavoriteImage> getImageById(Long id) {
        return favoriteImageRepository.findById(id);
    }

    public void deleteImageById(Long id) {
        favoriteImageRepository.deleteById(id);
    }

    public List<FavoriteImage> getImagesFromLast10Years() {
        LocalDateTime tenYearsAgo = LocalDateTime.now().minusYears(10);
        return favoriteImageRepository.findAllByCreatedDateAfter(tenYearsAgo);
    }
}
