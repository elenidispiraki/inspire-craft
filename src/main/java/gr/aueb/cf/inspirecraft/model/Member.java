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
@Table(name = "members")
public class Member extends User{

    @OneToOne(mappedBy = "member", cascade = CascadeType.ALL)
    private Favorites favorites;

    @ManyToMany
    @JoinTable(name = "member_favorites", joinColumns = @JoinColumn(name = "member_id"), inverseJoinColumns =
        @JoinColumn(name = "product_id"))
    private List<Product> favoriteProducts;

}
