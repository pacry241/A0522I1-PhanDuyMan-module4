package com.codegym.blog_webservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BlogDto {
    private int idBlog;
    private String nameBlog;
    private String title;
    private String content;
}
