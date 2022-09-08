package com.jpademo.jpademoexposicion;

import com.jpademo.jpademoexposicion.entity.Post;
import com.jpademo.jpademoexposicion.entity.Usuario;
import com.jpademo.jpademoexposicion.repository.PostRepository;
import com.jpademo.jpademoexposicion.repository.UsuarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class Application {

  @Autowired private UsuarioRepository usuarioRepository;
  @Autowired private PostRepository postRepository;

  @EventListener(ApplicationReadyEvent.class)
  public void run() {
    //Creamos un nuevo usuario
    Usuario user = Usuario.builder()
        .username("slbejaranom")
        .password("slbejaranom")
        .nombre("Sebastian")
        .apellido("Bejarano")
        .build();

    usuarioRepository.save(user);

    //Creamos un nuevo post y lo asignamos al mismo usuario y guardamos
    Post firstPost = Post.builder()
        .descripcion("Este es el primer post")
        .usuario(user)
        .build();
    //Creamos un segundo post y lo asignamos al mismo usuario y guardamos
    Post secondPost = Post.builder()
        .descripcion("Este es el segundo post")
        .usuario(user)
        .build();
    postRepository.saveAll(List.of(
        firstPost,
        secondPost
    ));
    //Verificamos que los posts estén en DB
    List<Post> posts = postRepository.findAll();
    assert posts.size() == 2;

    //Verificamos el usuario y sus posts en DB
    List<Usuario> usuarios = usuarioRepository.findAll();
    usuarios.forEach(System.out::println);
    assert usuarios.size() > 0;
  }
}
