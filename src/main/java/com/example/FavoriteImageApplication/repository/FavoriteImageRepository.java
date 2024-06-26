package com.example.FavoriteImageApplication.repository;

import com.example.FavoriteImageApplication.entity.FavoriteImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface FavoriteImageRepository extends JpaRepository<FavoriteImage, Long> {
    List<FavoriteImage> findAllByCreatedDateAfter(LocalDateTime date);
}
