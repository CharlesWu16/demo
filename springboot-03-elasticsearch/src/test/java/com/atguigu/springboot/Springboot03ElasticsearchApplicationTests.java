package com.atguigu.springboot;

import com.atguigu.springboot.bean.Article;
import com.atguigu.springboot.bean.Book;
import com.atguigu.springboot.repository.BookRepository;
import io.searchbox.client.JestClient;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot03ElasticsearchApplicationTests {
    @Autowired
    JestClient jestClient;
    @Autowired
    BookRepository bookRepository;

    @Test
    public void test02(){
//        Book book = new Book().setId(1).setBookName("背影").setAuthor("老舍");
//        bookRepository.index(book);
        List<Book> bookList = bookRepository.findByBookNameLike("背");
        for (Book book : bookList){
            System.out.println(book);
        }
    }

    @Test
    public void contextLoads() {
        //1.给ES索引(保存)一个文档
        Article article = new Article();
        article.setId(1).setAuthor("Kobe").setTitle("细节").setContent("詹姆斯的突破如何做到无往不利");
        //构建一个索引功能
        Index index = new Index.Builder(article).index("atguigu").type("news").build();
        try {
            //执行
            jestClient.execute(index);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //测试全文检索功能
    @Test
    public void search(){
        //查询表达式
        String json="{\n" +
                "    \"query\" : {\n" +
                "        \"match\" : {\n" +
                "            \"content\" : \"突破\"\n" +
                "        }\n" +
                "    }\n" +
                "}";
        //构建搜索功能
        Search search = new Search.Builder(json).addIndex("atguigu").addType("news").build();
        try {
            //执行
            SearchResult result = jestClient.execute(search);
            System.out.println(result.getJsonString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
