package com.jaewoo.springwebservice.web;

import com.jaewoo.springwebservice.domain.posts.PostsRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class WebRestController {
    private PostsRepository postsRepository;
    
    @GetMapping("/hello")
    public String hello(){
        return "HelloWorld"; // String을 json형태로 반
    }

    @PostMapping("/posts")
    public void savePosts(@RequestBody PostsSaveReqeustDto dto){
        postsRepository.save(dto.toEntity());
    }
}
