package phone.domain;
import phone.domain.PersonalInfo;

import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;
import java.util.List;

public class Person implements PersonalInfo {
    private String name;
    private Set<String> phoneNumber;
    private Set<String> address;

    public Person(String name, Set<String> address, Set<String> phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return this.name;
    }

    public Set<String> getPhoneNumber() {
        return this.phoneNumber;
    }

    public Set<String> getAddress() {
        return this.address;
    }

    public void addPhoneNumber(Set<String> numbers) {
        // merge new and old phone numbers
        Set<String> newPhoneBook = new HashSet<String>();
        newPhoneBook.addAll(this.phoneNumber);
        newPhoneBook.addAll(numbers);

        this.phoneNumber = newPhoneBook;
    }

    public void addAddress(Set<String> ad) {
        // merge new and old phone numbers
        Set<String> newAddress = new HashSet<String>();
        newAddress.addAll(this.address);
        newAddress.addAll(ad);

        this.address = newAddress;
    }
}