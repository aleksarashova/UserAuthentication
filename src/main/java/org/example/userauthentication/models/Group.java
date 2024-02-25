package org.example.userauthentication.models;


import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;


    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "GroupPermissions",
        joinColumns = @JoinColumn(name = "GroupId"),
        inverseJoinColumns = @JoinColumn(name = "PermissionId"))
    private Set<Permission> permissions = new HashSet<>();

    @ManyToMany(mappedBy = "groups")
    private Set<User> users = new HashSet<>();

    //default
    public Group() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    private void addPermission(Permission perm){
        this.permissions.add(perm);
        perm.getGroups().add(this);
    }

    private void removePermission(Permission perm){
        this.permissions.remove(perm);
        perm.getGroups().remove(this);
    }

}
