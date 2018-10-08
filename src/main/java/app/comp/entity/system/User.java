package app.comp.entity.system;


import app.comp.util.validators.FieldMatch;
import app.comp.util.validators.Password;
import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@EntityListeners({AuditingEntityListener.class})
@Audited
@Table(name = "user")
@FieldMatch(first = "password", second = "matchingPassword", message = "{validation.user.create.field.matchingPassword}")
@Access(AccessType.PROPERTY)
public class User extends Audit implements Serializable {


    public User() {
        this.expired = true;
        this.locked = true;
    }


    private Long id;
    private String login;
    private String password;
    private Set<Role> roles = new HashSet<>();
    private String firstName;
    private String lastName;
    private String matchingPassword;
    private boolean locked;
    private boolean expired;


//    private DateTime createdDate;
//    private DateTime modifiedDate;
//    private String createdBy;
//    private String modifiedBy;

//    @Column(name = "created_date", updatable = false)
//    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
//    @CreatedDate
//    public DateTime getCreatedDate() {
//        return createdDate;
//    }
//
//    public void setCreatedDate(DateTime createdDate) {
//        this.createdDate = createdDate;
//    }
//
//    @Column(name = "modified_date")
//    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
//    @LastModifiedDate
//    public DateTime getModifiedDate() {
//        return modifiedDate;
//    }
//
//    public void setModifiedDate(DateTime modifiedDate) {
//        this.modifiedDate = modifiedDate;
//    }
//
//    @Column(name = "created_by")
//    @CreatedBy
//    public String getCreatedBy() {
//        return createdBy;
//    }
//
//    public void setCreatedBy(String createdBy) {
//        this.createdBy = createdBy;
//    }
//
//    @Column(name = "modified_by")
//    @LastModifiedBy
//    public String getModifiedBy() {
//        return modifiedBy;
//    }
//
//    public void setModifiedBy(String modifiedBy) {
//        this.modifiedBy = modifiedBy;
//    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    @Column(name = "login", unique = true, nullable = false)
    @NotNull
    @NotEmpty(message = "{validation.user.create.field.required}")
    @Email(message = "{validation.user.create.field.email}")
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @NotNull
    @NotEmpty(message = "{validation.user.create.field.required}")
    @Size(min = 8, message = "{validation.user.create.field.min}")
    @Password(message = "{validation.user.create.field.password}")
    @Column(name = "password", nullable = false, unique = true)
    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }


    @ManyToMany(fetch = FetchType.LAZY)
//    @Audited(targetAuditMode = NOT_AUDITED)
    @NotAudited
    @JoinTable(name = "user_role", joinColumns = {
            @JoinColumn(name = "user_id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "role_id",
                    nullable = false, updatable = false)})
    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @NotNull
    @NotEmpty(message = "{validation.user.create.field.required}")
    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @NotNull
    @Column(name = "last_name")
    @NotEmpty(message = "{validation.user.create.field.required}")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @NotEmpty(message = "{validation.user.create.field.required}")
    @Transient
    public String getMatchingPassword() {
        return matchingPassword;
    }

    public void setMatchingPassword(String matchingPassword) {
        this.matchingPassword = matchingPassword;
    }


    @Column(name = "locked", nullable = false)
    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }


    @Column(name = "expired", nullable = false)
    public boolean isExpired() {
        return expired;
    }

    public void setExpired(boolean expired) {
        this.expired = expired;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", roles=" + roles +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", matchingPassword='" + matchingPassword + '\'' +
                ", locked=" + locked +
                ", expired=" + expired +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(getId(), user.getId()) &&
                Objects.equals(getLogin(), user.getLogin()) &&
                Objects.equals(getPassword(), user.getPassword()) &&
                Objects.equals(getRoles(), user.getRoles());
    }

}
