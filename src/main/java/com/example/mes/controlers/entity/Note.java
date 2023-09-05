package com.example.mes.controlers.entity;

import lombok.*;

import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Note {

    private Long id;
    private String title;
    private String content;

}
