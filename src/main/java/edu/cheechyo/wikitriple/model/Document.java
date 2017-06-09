package edu.cheechyo.wikitriple.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Cheechyo on 2017. 6. 9..
 */
@Entity
@Table(name = "document")
public class Document implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String content;
    private int version;
    private int regUser;

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

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public int getRegUser() {
        return regUser;
    }

    public void setRegUser(int regUser) {
        this.regUser = regUser;
    }
}
