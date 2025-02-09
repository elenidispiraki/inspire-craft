package gr.aueb.cf.inspirecraft.dto;

import gr.aueb.cf.inspirecraft.model.Creator;
import gr.aueb.cf.inspirecraft.model.Member;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductReadOnlyDTO {
    private String name;
    private String description;
    private Creator creator;
    private String imageUrl;
    //private List<Member> membersLiked;
}
