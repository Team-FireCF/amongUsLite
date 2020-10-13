package teamFire.JavaMongUs.models.user;



import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;


@Entity
public class ApplicationUser implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    String username;
    String password;
    boolean deadOrAlive;
    boolean imposter;

    @ManyToMany(cascade = CascadeType.REMOVE)

    @JoinTable(
            name = "sharedLocations",
            joinColumns = {@JoinColumn(name = "locations")},
            inverseJoinColumns = {@JoinColumn(name = "players")}
    )

    public Set<ApplicationUser> playerLocations = new HashSet<>();

    @ManyToMany(mappedBy = "playerLocations")

    public Set<Location> locationOfPlayers = new HashSet<>(); //will create Location class later




    public ApplicationUser(){}

    public ApplicationUser(String username, String password){
        this.username = username;
        this.password = password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities(){
        return null;
    }

    @Override
    public String getPassword(){
        return password;
    }

    @Override
    public String getUsername(){
       return username;
    }

    @Override
    public boolean isAccountNonExpired(){
        return true;
    }

    @Override
    public boolean isAccountNonLocked(){
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired(){
        return true;
    }

    @Override
    public boolean isEnabled(){
        return true;
    }
}
