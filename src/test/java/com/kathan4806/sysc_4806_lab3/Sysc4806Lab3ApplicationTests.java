package com.kathan4806.sysc_4806_lab3;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class Sysc4806Lab3ApplicationTests {

    @Autowired
    private ABController controller;

    @Test
    void contextLoads() throws Exception{
        assertThat(controller).isNotNull();
    }
}
