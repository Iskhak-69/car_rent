package alatoo.car_rent.model.entity;

import alatoo.car_rent.model.enums.Roles;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@Table(name = "users")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String name;
    private String password;
    private String phone;
    private String email;
    @Enumerated(EnumType.STRING)
    private Roles role;

    @OneToMany(mappedBy = "tenant")
    private List<Booking> bookings;

    @OneToMany(mappedBy = "reviewer")
    private List<Review> reviews;

    public User(UUID id, String name, String password, String phone, String email, Roles role) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.phone = phone;
        this.email = email;
        this.role = role;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + role));
    }
}