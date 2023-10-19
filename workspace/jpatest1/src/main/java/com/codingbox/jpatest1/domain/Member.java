package com.codingbox.jpatest1.domain;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;

@Entity
@Getter @Setter
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "member_seq")
    @SequenceGenerator(name = "member_seq", sequenceName = "MEMBER_SEQ", allocationSize = 1)
    @Column(name = "MEMBER_ID")
    private Long id;
    
    @Column(name = "MEMBERID")
    private String memberid;
    
    @Column(name = "NAME")
    private String name;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "member")
    private List<Orders> ordersList;

    @Override
    public String toString() {
        return "Member [id=" + id + ", memberid=" + memberid + ", name=" + name + ", " +
               "address=" + address.getCity() + ", " + address.getStreet() + ", " + address.getZipcode() +
               ", ordersList=" + ordersList + "]";
    }


}
