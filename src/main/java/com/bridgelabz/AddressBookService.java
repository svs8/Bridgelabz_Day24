package com.bridgelabz;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

    public class AddressBookService {
        HashMap<String, AddressBook> addressBookmap = new HashMap<>();
        Scanner scan = new Scanner(System.in);
        public AddressBook findAddressBook(String adBookName) {

            for (Map.Entry<String, AddressBook> entry : addressBookmap.entrySet()) {
                if (entry.getKey().equalsIgnoreCase(adBookName)) {
                    return entry.getValue();
                }
            }
            return null;
        }
        public void addAddressBook() {

            System.out.println(" Enter the name of the address book: ");
            String name = scan.next();

            if (addressBookmap.get(name) != null) {

                System.out.println("the Entered address book is already exists");
                return;
            }

            addressBookmap.put(name, new AddressBook());
        }
        public void addContact() {

            System.out.println(" Please enter the name of the address book: ");
            String name = scan.next();

            AddressBook adBook = findAddressBook(name);


//            Checking if the addressbook exists
            if (adBook == null) {
                System.out.println("Invalid  address book ");
                return;
            }
//            if exists adding contact to that addressbook
            adBook.addContact();
        }
        public void displayContacts() {

            System.out.println(" Enter the name of the address book : ");
            String name = scan.next();

            AddressBook addBook = findAddressBook(name);

            if (addBook == null) {
                System.out.println("Invalid address book , Please Enter the proper Address book name");
                return;
            }
            addBook.displayContacts();
        }
        public void editContact() {

            System.out.println(" Enter the name of the address book: ");
            String name = scan.next();

            AddressBook addBook = findAddressBook(name);

            if (addBook == null) {
                System.out.println("Invalid address book , Please Enter the proper Address book name");
                return;
            }
            addBook.editContact();
        }
        public void deleteContact() {

            System.out.println(" Enter the name of the address book: ");
            String name = scan.next();

            AddressBook addBook = findAddressBook(name);

            if (addBook == null) {
                System.out.println("Invalid address book , Please Enter the proper Address book name");
                return;
            }
            addBook.deleteContact();
        }

//        UC9
        public void viewByCityOrState(){
            System.out.print(" Enter to view by city or state(city/state): ");
            String viewChoice = scan.next();

            System.out.print(" Enter the location: ");
            String viewLocation = scan.next();

            viewCityState(viewLocation, viewChoice);
        }
        public void viewCityState(String location, String choice) {
            addressBookmap.values().stream().forEach((adBook) -> {
                adBook.addressBook.stream().filter(contact -> {

                            if (choice.equalsIgnoreCase("city"))
                                return contact.getCity().equalsIgnoreCase(location);
                            else
                                return contact.getState().equalsIgnoreCase(location);
                        })
                        .forEach(contact -> System.out.println(contact));
            });

        }
//        UC10
        public void countByContacts(){
            System.out.print(" Enter to count by city or state(city/state): ");
            String countChoice = scan.next();

            System.out.print(" Enter the location: ");
            String countLocation = scan.next();

            countContact(countLocation, countChoice);
        }
        public void countContact(String location, String choice) {

            int finalCount = 0;

            for (AddressBook addBook : addressBookmap.values()) {

                finalCount += addBook.addressBook.stream()
                        .filter(contact -> {
                            if (choice.equalsIgnoreCase("city"))
                                return contact.getCity().equalsIgnoreCase(location);
                            else
                                return contact.getState().equalsIgnoreCase(location);
                        })
                        .count();
            }

            System.out.println(" Total count: " + finalCount);
        }

    }

