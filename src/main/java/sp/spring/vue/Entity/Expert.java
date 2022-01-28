package sp.spring.vue.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Getter
@Setter
@Table(name = "sp_expert")
public class Expert extends User {

    @Lob
    @Column
    private char[] image;

    @Column
    private Double score;

    @ManyToMany
    @JoinTable(name = "s_expert_Service" , joinColumns = {
            @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "fk_expert_service"))},
            inverseJoinColumns = { @JoinColumn(name = "service_id", foreignKey = @ForeignKey(name = "fk_service_expert"))
    })
    private Set<Service> services = new HashSet<>();
}
