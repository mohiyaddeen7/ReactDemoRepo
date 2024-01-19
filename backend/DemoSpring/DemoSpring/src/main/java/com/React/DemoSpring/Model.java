package com.React.DemoSpring;


import jakarta.persistence.*;

@Entity
@Table(name="user")
public class Model {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String fullName;

    private String interest;

    public Model(long id, String fullName, String interest) {
        this.id = id;
        this.fullName = fullName;
        this.interest = interest;
    }

    public Model() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getInterest() {
        return interest;
    }

    public void setInterest(String interest) {
        this.interest = interest;
    }
}
