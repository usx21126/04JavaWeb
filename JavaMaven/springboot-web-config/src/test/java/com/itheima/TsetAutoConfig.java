package com.itheima;

import com.example.HeaderParser;
import com.example.TokenParser;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;


@SpringBootTest
public class TsetAutoConfig {
    @Autowired
    private ApplicationContext context;
    @Test
    public void TestGetTokenParser(){
        TokenParser tokenParser = context.getBean(TokenParser.class);
        System.out.println("tokenParser="+tokenParser);
    }

    @Test
    public void TestGetHeaderParser(){
        HeaderParser HeaderParser = context.getBean(HeaderParser.class);
        System.out.println("HeaderParser="+HeaderParser);
    }
}
