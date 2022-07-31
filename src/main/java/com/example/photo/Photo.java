package com.example.photo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Columns;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Photo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

@NotEmpty
    private String name;
    private String description;
    private boolean privacy;
    private String UploaderName;
    @Length(min = 9, max=9)
    private String UploaderPhoneNumber;
    private String UploaderEmail;
    private String adres;
    private String viev;

    @OneToOne(mappedBy = "photo", cascade = CascadeType.ALL)
    private UploadHistory uploadHistory;

    @ManyToOne()
    private Album album;

    @ManyToOne
    private Location location;

    @OneToMany(mappedBy = "photo", cascade = CascadeType.ALL)
    private List<Comment> comments;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Tag> tag;


}
