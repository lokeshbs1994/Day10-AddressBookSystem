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
            System.out.println("Enter 3 to edit existing contact");
            System.out.println("Enter 4 to edit delete existing contact");
            System.out.println("Enter 5 to Add Multiple Contacts");
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
                case 3:
                    updateContact();
                    break;
                case 4:
                    deleteContact();
                    break;
                case 5:
                    addMultipleContact();
                    break;
                default:
                    System.out.println("Invalid entry");
            }
        }
    }

    private static void addMultipleContact() {
        System.out.println("Enter Number of Contacts to Add into Contact Book");
        int number = scanner.nextInt();
        for (int i = 0; i < number; i++) {
            addNewContact();
            System.out.println(i + 1 + " Contact added Successfully.. ");
        }
    }

    private static void deleteContact() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter existing contact firstName:");
        String searchName = scanner.nextLine();
        ContactBook existingContactRecord = addressBook.queryContact(searchName);
        if (existingContactRecord == null) {
            System.out.println("Contact Not Found");
            return;
        }
        if (addressBook.removeContact(existingContactRecord)) {
            System.out.println(searchName + " is deleted successfully");
        } else {
            System.out.println("Error in deleting the contact");
        }
    }

    private static void updateContact() {
        System.out.println("Enter existing contact firstName:");
        String name = scanner.next();
        ContactBook existingContactRecord = addressBook.queryContact(name);
        if (existingContactRecord == null) {
            System.out.println("Contact Not Found");
            return;
        }
        System.out.println("Enter new first Name:");
        String newFirstName = scanner.next();
        System.out.println("Enter new last Name:");
        String newLastName = scanner.next();
        System.out.println("Enter  new address:");
        String newAddress = scanner.next();
        System.out.println("Enter new city:");
        String newCity = scanner.next();
        System.out.println("Enter new state:");
        String newState = scanner.next();
        System.out.println("Enter  new zip:");
        int newZip = scanner.nextInt();
        System.out.println("Enter  new phone Number:");
        long newPhoneNumber = scanner.nextLong();
        System.out.println("Enter new email:");
        String newEmail = scanner.next();
        ContactBook newContact = ContactBook.createContact(newFirstName, newLastName, newAddress, newCity, newState, newZip, newPhoneNumber, newEmail);
        if (addressBook.updateContact(existingContactRecord, newContact)) {
            System.out.println("successfully updated the Contact");
        } else {
            System.out.println("Not updated");
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
