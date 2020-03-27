package com.example.social.controller;

import com.example.social.domain.Post;
import com.example.social.domain.User;
import com.example.social.repos.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

@Controller
public class MainController {
    @Autowired
    private PostRepository postRepository;

    @Value("${upload.path}")
    private String uploadPath;

    @GetMapping("/")
    public String greeting() {
        return "greeting";
    }

    @GetMapping("/main")
    public String main(@RequestParam(required = false, defaultValue = "") String title, Model model) {
        Iterable<Post> posts = postRepository.findAll();
        if (title != null && !title.isEmpty()) {
            posts = postRepository.findByTitle(title);
        } else {
            posts = postRepository.findAll();
        }
        model.addAttribute("posts", posts);
        model.addAttribute("title", title);
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
    @PostMapping("/main")
    public String add(
            @AuthenticationPrincipal User user,
            @RequestParam (required=false) Long id,
            @RequestParam String title,
            @RequestParam String body,
            @RequestParam String tag, Map<String, Object> model,
            @RequestParam("file") MultipartFile file
    ) throws IOException {
        Post post = new Post(id, title, body, tag, user);

        if (file != null && !file.getOriginalFilename().isEmpty()) {
            File uploadFolder = new File(uploadPath);

            if (!uploadFolder.exists()) {
                uploadFolder.mkdir();
            }

            String uuidFile = UUID.randomUUID().toString();
            String resultFilename = uuidFile + "." + file.getOriginalFilename();

            file.transferTo(new File(uploadPath + "/" + resultFilename));

            post.setFilename(resultFilename);
        }

        postRepository.save(post);

        Iterable<Post> posts = postRepository.findAll();

        model.put("posts", posts);

        return "main";
    }
}