package com.example.demo.model.modelDto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class RatePlansDto {

    private String id;

    private String name;

    private LocalDateTime created;

    private LocalDateTime modified;

    private boolean deleted;
}