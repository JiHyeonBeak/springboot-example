package springboot.web.domain.posts;


import com.pigsheep.book.springboot.Application;
import com.pigsheep.book.springboot.domain.posts.Posts;
import com.pigsheep.book.springboot.domain.posts.PostsRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import java.util.List;

@ContextConfiguration(classes = Application.class)
public class PostRepositoryTest {

    @Autowired
    PostsRepository postRepository;

    @AfterEach
    public void cleanup() {
        postRepository.deleteAll();
    }

    @Test
    public void ocurred_postsave() {

        //given
        String title = "테스트 게시글";
        String content = "테스트 본문";

        postRepository.save(Posts.builder()
                .title(title)
                .content(content)
                .author("pigsheep")
                .build());

        //when
        List<Posts> postsList = postRepository.findAll();

        //then
        Posts posts = postsList.get(0);
        Assertions.assertThat(posts.getTitle()).isEqualTo(title);
        Assertions.assertThat(posts.getContent()).isEqualTo(content);
    }

}
