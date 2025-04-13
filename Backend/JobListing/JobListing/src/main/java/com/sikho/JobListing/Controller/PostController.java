package com.sikho.JobListing.Controller;

import com.sikho.JobListing.Repository.PostRepository;
import com.sikho.JobListing.Repository.SearchPost;
import com.sikho.JobListing.model.Post;
import io.swagger.v3.oas.annotations.Hidden;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin("*")
public class PostController {

    @Autowired
    PostRepository repo;

    @Autowired
    SearchPost srepo;

    @Hidden
    @RequestMapping("/")
    public void Redirect(HttpServletResponse response) throws IOException {
            response.sendRedirect("/swagger-ui.html");
    }
    @GetMapping("/allPosts")
    public List<Post> getAllPosts(){

            return repo.findAll();
    }
    @GetMapping("/posts/{text}")
    public List<Post> Search(@PathVariable String text){
        return  srepo.findBytext(text);
    }

    @PostMapping("/post")
    public Post addPost(@RequestBody Post post){
       return  repo.save(post);
    }

}
