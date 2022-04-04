package pl.coderslab.book;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data

public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private int lastName;


}
