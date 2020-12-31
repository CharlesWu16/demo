package com.atguigu.springboot.bean;

import io.searchbox.annotations.JestId;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Article {
    //ES的主键id
    @JestId
    private Integer id;
    private String author;
    private String title;
    private String content;
}
