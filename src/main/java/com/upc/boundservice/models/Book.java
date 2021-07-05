package com.upc.boundservice.models;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "book")
@EntityListeners(AuditingEntityListener.class)
@Data
@NoArgsConstructor
public class Book implements Serializable {

    @Getter(AccessLevel.PRIVATE)
    //@Setter(AccessLevel.PRIVATE)
    private static final long  serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "author")
    private String author;

    @Column(name = "pages")
    private Integer pages;


}
