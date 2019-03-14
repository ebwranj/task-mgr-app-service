package com.sample.task.domain;



import com.sample.task.config.ParseDeserializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name="Book")
public class Book  implements Serializable {
    @Id
    @Column(name = "bookId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String title;
    @Column
    private Double price;
    @Column
    private Integer volume;
//    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonFormat(pattern = "YYYY-MM-dd HH:mm")
    @JsonSerialize(using = ToStringSerializer.class)
    @JsonDeserialize(using = ParseDeserializer.class)
   // @JsonDeserialize(using = LocalDateDeserializer.class)
    @Column
    private LocalDateTime publishDate;


    public Book() {

    }

    public Book(String title, Double price, Integer volume, LocalDateTime publishDate) {
        this.title = title;
        this.price = price;
        this.volume = volume;
        this.publishDate = publishDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    public LocalDateTime getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(LocalDateTime publishDate) {
        this.publishDate = publishDate;
    }
}
