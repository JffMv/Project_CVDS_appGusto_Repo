package co.edu.escuelaing.project.AppGusto.model;


import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
@Table(name = "session")
public class Session {
    @Id
    @Column(name = "token", nullable=false, unique=true)
    private UUID token;

    @Column(name = "firstName")
    private Instant timestamp;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_usuario", nullable = false)
    private Usuario user;
}
