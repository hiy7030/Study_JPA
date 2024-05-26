package hellojpa;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    private int age;

    @Enumerated(EnumType.STRING)
    private MemberType memberType;

    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime createAt;

    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime modifiedAt;

    @Lob
    private String description;

    @Transient // DB 반영 X
    private int temp;

}
