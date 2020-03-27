package com.example.social.domain;

import javax.persistence.*;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String title;
    private String body;
    private String tag;
    private String filename;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User author;

    public Post() {
    }

    /**
     * Post constructor
     *
     * @param id post id
     * @param title post title
     * @param body post body
     * @param tag post tag
     */
    public Post(
            Long id,
            String title,
            String body,
            String tag,
            User user
    ) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.tag = tag;
        this.author = user;
    }

    /**
     * Get id
     *
     * @return int
     */
    public Long getId() {
        return id;
    }

    /**
     * Set id
     *
     * @param id post id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Get title
     *
     * @return string
     */
    public String getTitle() {
        return title;
    }

    /**
     * Set title
     *
     * @param title post title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Get post body
     *
     * @return string
     */
    public String getBody() {
        return body;
    }

    /**
     * Set body
     *
     * @param body post body
     */
    public void setBody(String body) {
        this.body = body;
    }

    /**
     * Get tag
     *
     * @return post tag
     */
    public String getTag() {
        return tag;
    }

    /**
     * Set tag
     *
     * @param tag post tag
     */
    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getAuthorName() {
        return author != null ? author.getUsername() : "<none>";
    }

    /**
     * Get author
     *
     * @return author
     */
    public User getAuthor() {
        return author;
    }

    /**
     * Set author
     *
     * @param author author
     */
    public void setAuthor(User author) {
        this.author = author;
    }

    /**
     * Get filename
     *
     * @return filename
     */
    public String getFilename() {
        return filename;
    }

    /**
     * Set filename
     *
     * @param filename post image url
     */
    public void setFilename(String filename) {
        this.filename = filename;
    }
}
