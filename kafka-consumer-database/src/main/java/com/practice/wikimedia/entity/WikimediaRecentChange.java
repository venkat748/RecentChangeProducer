package com.practice.wikimedia.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class WikimediaRecentChange {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Lob
    private String changeEventData;
}
