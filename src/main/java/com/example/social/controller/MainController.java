package com.example.social.controller;

import com.example.social.domain.Post;
import com.example.social.domain.User;
import com.example.social.repos.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
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
     * @param user post user
     * @param post post
     * @param bindingResult errors
     * @param model model
     * @param file file
     * @return string
     * @throws IOException
     */
    @PostMapping("/main")
    public String add(
            @AuthenticationPrincipal User user,
            @Valid Post post,
            BindingResult bindingResult,
            Model model,
            @RequestParam("file") MultipartFile file
    ) throws IOException {
        post.setAuthor(user);

        if (bindingResult.hasErrors()) {
            Map<String, String> errorsMap = ControllerUtils.getErrors(bindingResult);
            model.mergeAttributes(errorsMap);
            model.addAttribute("message", post);
        } else {
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
            model.addAttribute("message", null);

            postRepository.save(post);
        }

        Iterable<Post> posts = postRepository.findAll();

        model.addAttribute("posts", posts);

        return "main";
    }
}