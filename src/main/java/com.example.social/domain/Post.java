package com.example.social.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String title;
    private String body;
    private String tag;

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
            Integer id,
            String title,
            String body,
            String tag
    ) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.tag = tag;
    }

    /**
     * Get id
     *
     * @return int
     */
    public Integer getId() {
        return id;
    }

    /**
     * Set id
     *
     * @param id post id
     */
    public void setId(Integer id) {
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
}
