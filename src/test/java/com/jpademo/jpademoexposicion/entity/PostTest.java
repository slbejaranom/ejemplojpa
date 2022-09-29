package com.jpademo.jpademoexposicion.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PostTest {
    
    @Test
    void testPostCreation(){
        System.out.println("Soy un test de creación de un post");
        Post nuevoPost = Post.builder()
                            .descripcion("Soy una nueva descripción")
                            .build();
        Assertions.assertNotNull(nuevoPost);
    }
}