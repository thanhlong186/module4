package com.codegym.borrow_books.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Books {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Integer id;
    private String name;
    private String author; // tác giả
    private String manufacture; // nhà sản xuất
    private String releaseYear; // năm phát hành
    private Integer amount; //số lượng sách

    @OneToMany(mappedBy = "books", cascade = CascadeType.ALL )
    private Set<CodeBook> codeBooks;


    public Books() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(String releaseYear) {
        this.releaseYear = releaseYear;
    }

    public Set<CodeBook> getCodeBooks() {
        return codeBooks;
    }

    public void setCodeBooks(Set<CodeBook> codeBooks) {
        this.codeBooks = codeBooks;
    }
}
