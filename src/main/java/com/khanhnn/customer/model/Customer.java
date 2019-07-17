package com.khanhnn.customer.model;


import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Size(max = 50)
    private String firstName;

    @NotEmpty
    @Size(max = 50)
    private String lastName;

    @NotEmpty
    @Pattern(regexp = "^0[0-9]{9,10}$")
    private String phoneNumber;

    @Email
    @NotEmpty
    private String email;

    @ManyToOne
    @JoinColumn(name = "province_Id")
    private Province province;

    public Customer(@NotEmpty @Size(max = 50) String firstName,
                    @NotEmpty @Size(max = 50) String lastName,
                    @NotEmpty @Pattern(regexp = "^0[0-9]{9,10}$") String phoneNumber,
                    @Email @NotEmpty String email, Province province) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.province = province;
    }

    public Customer() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }
}
