package pl.coderslab.book;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "publishers")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String street;
    private String number;
    private String zipCode;
    private String city;

}
