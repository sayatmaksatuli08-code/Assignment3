package com.gameclub.model;

public class Customer {

    private long id;
    private String fullName;
    private String phone;
    private MembershipType membershipType;

    public Customer() {
    }

    public Customer(long id, String fullName, String phone, MembershipType membershipType) {
        this.id = id;
        this.fullName = fullName;
        this.phone = phone;
        this.membershipType = membershipType;
    }

    public Customer(String fullName, String phone, MembershipType membershipType) {
        this.fullName = fullName;
        this.phone = phone;
        this.membershipType = membershipType;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public MembershipType getMembershipType() {
        return membershipType;
    }

    public void setMembershipType(MembershipType membershipType) {
        this.membershipType = membershipType;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", phone='" + phone + '\'' +
                ", membershipType=" + membershipType +
                '}';
    }
}
