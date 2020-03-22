package com.example.social;

import com.example.social.domain.Post;
import com.example.social.repos.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class GreetingController {
    @Autowired
    private PostRepository postRepository;

    @GetMapping
    public String main(Map<String, Object> model) {
        Iterable<Post> posts = postRepository.findAll();
        model.put("posts", posts);
        return "main";
    }

    /**
     * Post main url
     *
     * @param title post title
     * @param body post body
     * @param tag post tag
     * @param model model
     * @return main
     */
    @PostMapping
    public String add(
            @RequestParam (required=false) Integer id,
            @RequestParam String title,
            @RequestParam String body,
            @RequestParam String tag,
            Map<String, Object> model
    ) {
        Post post = new Post(id, title, body, tag);

        postRepository.save(post);

        Iterable<Post> posts = postRepository.findAll();

        model.put("posts", posts);

        return "main";
    }

    @PostMapping("filter")
    public String filter(@RequestParam String title,
                         Map<String, Object> model) {
        List<Post> posts = postRepository.findByTitle(title);

        model.put("posts", posts);

        return "main";
    }
}