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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToMany
    @JoinTable(name = "favorites_products", joinColumns = @JoinColumn(name = "favorites_id"), inverseJoinColumns =
    @JoinColumn(name = "product_id"))
    private List<Product> favoriteProducts;

}
