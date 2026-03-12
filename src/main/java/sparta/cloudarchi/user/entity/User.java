package sparta.cloudarchi.user.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sparta.cloudarchi.user.dto.UserRequestDto;

@Getter
@Entity
@Table(name = "users")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String username;

    @Column
    private int age;

    @Column
    private String mbti;

    @Setter
    @Column
    private String profile_key;

    public User(UserRequestDto userRequestDto) {
        this.username = userRequestDto.getUsername();
        this.age = userRequestDto.getAge();
        this.mbti = userRequestDto.getMbti();
    }

}
