package com;
import java.util.Scanner;

public class AddressBookSystem {
    public static AddressBook addressBook = new AddressBook("addressBook");
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to Address Book program");
        boolean quit = false;
        while (!quit) {
            System.out.println("Enter 0 to quit the AddressBook system ");
            System.out.println("Enter 1 to Print contacts");
            System.out.println("Enter 2 to add New contacts");
            int action = scanner.nextInt();
            switch (action) {
                case 0:
                    System.out.println("exiting from Address book");
                    quit = true;
                    break;
                case 1:
                    addressBook.printContacts();
                    break;
                case 2:
                    addNewContact();
                    break;
                default:
                    System.out.println("Invalid entry");
            }
        }
    }

    private static void addNewContact() {
        System.out.println("Enter first Name:");
        String firstName = scanner.next();
        System.out.println("Enter last Name:");
        String lastName = scanner.next();
        System.out.println("Enter address:");
        String address = scanner.next();
        System.out.println("Enter city:");
        String city = scanner.next();
        System.out.println("Enter state:");
        String state = scanner.next();
        System.out.println("Enter zip:");
        int zip = scanner.nextInt();
        System.out.println("Enter phoneNumber:");
        long phoneNumber = scanner.nextLong();
        System.out.println("Enter email:");
        String email = scanner.next();
        ContactBook newContact = ContactBook.createContact(firstName, lastName, address, city, state, zip, phoneNumber, email);
        if (addressBook.addNewContact(newContact)) {
            System.out.println("New contact added Successfully..");
        } else {
            System.out.println("cannot add " + firstName + " already on contactBook list");
        }
    }
}
