package com.se.mycompany.homeware.model;

import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "boardnew")
public class Boardnew {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String content;
    private String image_link;
    private String author;
    private Date created;

    public Boardnew() {
        super();
    }

    public Boardnew(int id, String title, String content, String image_link, String author, Date created) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.image_link = image_link;
        this.author = author;
        this.created = created;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImage_link() {
        return image_link;
    }

    public void setImage_link(String image_link) {
        this.image_link = image_link;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    @Override
    public String toString() {
        return "Boardnew{" + "id=" + id + ", title=" + title + ", content=" + content + ", image_link=" + image_link + ", author=" + author + ", created=" + created + '}';
    }

    

}
