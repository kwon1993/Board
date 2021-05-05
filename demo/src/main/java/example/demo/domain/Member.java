package example.demo.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String loginId;
    private String password;
    private Grade grade;
    private String name;
    private String nickname;
    private String email;
    private LocalDateTime birth;
    private String phoneNumber;
    private String address;
    private LocalDateTime joinDate;
    private LocalDateTime latestLoginDate;

    public Member(String loginId, String password, String name, String nickname, String email, LocalDateTime birth, String phoneNumber, String address) {
        this.loginId = loginId;
        this.password = password;
        this.grade = Grade.USER;
        this.name = name;
        this.nickname = nickname;
        this.email = email;
        this.birth = birth;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.joinDate = LocalDateTime.now();
        this.latestLoginDate = LocalDateTime.now();
    }
}
