package com.liana.webservice.web;

import com.liana.webservice.domain.posts.PostsRepository;
import com.liana.webservice.service.PostsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class WebRestController {

    //private PostsRepository postsRepository;
    private PostsService postsService;


    @GetMapping("/hello")
    public String hello() {
        return "HelloWorld";
    }

//    @PostMapping("/posts")
//    public void savePosts(@RequestBody PostsSaveRequestDto dto){
//        postsRepository.save(dto.toEntity());
//    }

    @PostMapping("/posts")
    public Long savePosts(@RequestBody PostsSaveRequestDto dto){
    return postsService.save(dto);
}

}

