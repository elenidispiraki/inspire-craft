package gr.aueb.cf.inspirecraft.dto;

import gr.aueb.cf.inspirecraft.model.Creator;
import gr.aueb.cf.inspirecraft.model.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ProductReadOnlyDTO {
    private String name;
    private String description;
    private Creator creator;
    private List<Member> membersLiked;
}
