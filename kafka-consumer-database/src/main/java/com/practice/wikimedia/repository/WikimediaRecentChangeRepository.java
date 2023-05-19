package com.practice.wikimedia.repository;

import com.practice.wikimedia.entity.WikimediaRecentChange;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WikimediaRecentChangeRepository extends JpaRepository<WikimediaRecentChange, Long> {
}
