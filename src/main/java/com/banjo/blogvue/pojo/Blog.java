package com.banjo.blogvue.pojo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Data // 通过lombok设置getter和setter方法
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "blog")

@JsonIgnoreProperties({ "handler","hibernateLazyInitializer" })
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;

    private String picture;

    private String flag;

    private String views;

    private String content;

    private String description;

    @Temporal(TemporalType.DATE)
    private Date createTime;

    @Temporal(TemporalType.DATE)
    private Date updateTime;

    @ManyToOne
    private Category category;

    @ManyToOne
    private User user;

    @Transient
    private int category_id;

    @Transient
    private int user_id;

}
