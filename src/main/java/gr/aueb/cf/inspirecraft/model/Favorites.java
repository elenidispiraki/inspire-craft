package gr.aueb.cf.inspirecraft.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "favorites")
public class Favorites extends AbstractEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @ManyToMany
//    @JoinTable(name = "favorites_products", joinColumns = @JoinColumn(name = "favorites_id"))
//    private List<Product> products;

    @OneToOne
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

}
