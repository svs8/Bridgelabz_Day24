package com.bridgelabz;

import java.util.Scanner;

    public class AddressBookMain {
        public static void main(String[] args) {
            System.out.println(" Welcome to the Address Book Program");
            Scanner scan = new Scanner(System.in);
            AddressBookService addressBookServiceBook = new AddressBookService();
            String choice;
            boolean loop =true;

            while (loop) {
                System.out.println(" 1.) Add contacts 2.) Display contacts 3.) Edit contacts 4.) Delete contact"
                        + " 5.) Add address book 6.) View contacts by city or state"
                        + " 7.) Count contacts by city or state 8.) Sort contacts by city/state 9.) Exit\n");
                System.out.print("\n Please enter your choice: ");

                choice = scan.next();

                switch (choice) {
                    case "1":
                        addressBookServiceBook.addContact();
                        break;
                    case "2":
                        addressBookServiceBook.displayContacts();
                        break;
                    case "3":
                        addressBookServiceBook.editContact();
                        break;
                    case "4":
                        addressBookServiceBook.deleteContact();
                        break;
                    case "5":
                        addressBookServiceBook.addAddressBook();
                        break;
                    case "6":
                        addressBookServiceBook.viewByCityOrState();
                        break;
                    case "7":
                        addressBookServiceBook.countByContacts();
                        break;

                    case "8":
//                        addressBookServiceBook.sortByContacts();
                        break;
                    case "9":
                        System.out.println(" EXIT ");
                        loop = false;
                        break;
                    default:
                        System.out.println("Invalid choice, please enter the valid choice");
                }
            }
        }
    }
