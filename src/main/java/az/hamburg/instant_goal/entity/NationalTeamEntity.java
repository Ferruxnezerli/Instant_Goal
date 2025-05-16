package az.hamburg.instant_goal.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.context.annotation.EnableMBeanExport;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static jakarta.persistence.FetchType.EAGER;
import static jakarta.persistence.FetchType.LAZY;
import static jakarta.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
@Table(name = "players")
@Builder
@Entity
public class NationalTeamEntity {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    Long id;
    String name;
    byte numberOfWorldCups;
    int rankingInFIFA;
    @OneToOne(fetch = EAGER)
    @JoinColumn(name = "manager_id")
    ManagerEntity manager;
    @OneToMany(mappedBy = "nationalTeam",fetch = LAZY)
    Set<PlayerEntity> players = new HashSet<>();
}
