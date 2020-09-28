package example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "roles")
public class Role {
    @GeneratedValue
    @Id
    private Integer id;
    private String name;
    @ManyToMany(mappedBy = "roles", targetEntity = User.class, fetch = FetchType.LAZY)
    private Set<User> users = new HashSet<>();

    public Integer getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getUsers() {
        return "";
    }
}
