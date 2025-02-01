package gr.aueb.cf.inspirecraft.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "creators")
public class Creator extends AbstractEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String uuid;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name ="user_id")
    private User user;

    @OneToMany(mappedBy = "creator", cascade = CascadeType.ALL)
    private List<Product> products;

    @PrePersist
    public void initializeUUID(){
        if (uuid == null) uuid = UUID.randomUUID().toString();
    }
}
