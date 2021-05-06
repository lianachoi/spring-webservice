package com.liana.webservice.domain;

import com.liana.webservice.domain.posts.PostsRepository;
import com.liana.webservice.domain.posts.Posts;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.Assert.assertTrue;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.time.LocalDateTime;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @After
    public void cleanup(){
        postsRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기(){
        postsRepository.save(Posts.builder()
        .title("테스트 게시글")
        .content("테스트 본문")
        .author("liana")
        .build());

        List<Posts> postsList = postsRepository.findAll();

        Posts posts = postsList.get(0);
        assertThat(posts.getTitle(), is("테스트 게시글"));
        assertThat(posts.getContent(), is("테스트 본문"));
    }

    @Test
    public void BaseTimeEntity_등록(){
        LocalDateTime now = LocalDateTime.now();
        postsRepository.save(Posts.builder()
        .title("테스트 게시글")
        .content("테스트 본문")
        .author("liana")
        .build());

        List<Posts> postsList = postsRepository.findAll();
        Posts posts = postsList.get(0);
        assertTrue(posts.getCreatedDate().isAfter(now));
        assertTrue(posts.getModifiedDate().isAfter(now));
    }
}
