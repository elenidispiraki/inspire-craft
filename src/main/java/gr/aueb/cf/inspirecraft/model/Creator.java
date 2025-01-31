package gr.aueb.cf.inspirecraft.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "creators")
public class Creator extends User{

    @OneToMany(mappedBy = "creator", cascade = CascadeType.ALL)
    private List<Product> products;
}
