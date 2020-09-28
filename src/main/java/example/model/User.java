package example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue
    private Integer id;
    private String email;
    private String username;
    private String firstname;
    @Transient
    private String customString;
    @ManyToMany(targetEntity = Role.class, fetch = FetchType.LAZY)
    @JoinTable(name = "user_role",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")})
//    @JsonBackReference
    private Set<Role> roles = new HashSet<>();

    public String getCustomString() {
        return "my custom String";
    }

    public Map<String, String> getRoles() {
        Map<String, String> result = new HashMap<>();
        for (Role role : this.roles) {
            result.put(role.getId().toString(), role.getName());
        }
        return result;
    }
}
