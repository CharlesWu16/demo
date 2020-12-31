package com.atguigu.springboot.repository;

import com.atguigu.springboot.bean.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface BookRepository extends ElasticsearchRepository<Book,Integer> {
    //更多方法参考: https://docs.spring.io/spring-data/elasticsearch/docs/3.0.6.RELEASE/reference/html/
    public List<Book> findByBookNameLike(String bookName);
}
