package com.liana.webservice.service;

import com.liana.webservice.domain.posts.PostsRepository;
import com.liana.webservice.web.PostsSaveRequestDto;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostServiceTest {

    @Autowired
    private PostsService postsService;

    @Autowired
    private PostsRepository postsRepository;

    @After
    public void cleanup() {
        postsRepository.deleteAll();
    }

    @Test
    public void Dto데이터_posts테이블에_저장() {
        //given
        PostsSaveRequestDto dto = PostsSaveRequestDto.builder()
                .author("liana")
                .content("Dto데이터 테스트")
                .title("테스트 제목")
                .build();
    }
}
