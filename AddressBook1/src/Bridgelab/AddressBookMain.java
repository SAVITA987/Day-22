package Bridgelab;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AddressBookMain {

	   private List<Contact> contacts;

	    public AddressBookMain() {
	        contacts = new ArrayList<>();
	    }

	    public void addContact(Contact contact) {
	        contacts.add(contact);
	    }

	    public void deleteContact(String name) {
	        contacts = contacts.stream()
	                .filter(contact -> !contact.getName().equals(name))
	                .collect(Collectors.toList());
	    }

	    public void editContact(String name, String newPhoneNumber) {
	        contacts = contacts.stream()
	                .map(contact -> {
	                    if (contact.getName().equals(name)) {
	                        contact.setPhoneNumber(newPhoneNumber);
	                    }
	                    return contact;
	                })
	                .collect(Collectors.toList());
	    }

	    public void displayContacts() {
	        contacts.forEach(System.out::println);
	    }

	    public static void main(String[] args) {
	    	AddressBookMain addressBook = new AddressBookMain();

	    	addressBook.addContact(new Contact("Savita Tekale", "8709876543"));
	        addressBook.addContact(new Contact("disha patil", "9890076543"));

	        System.out.println("Initial Contacts:");
	        addressBook.displayContacts();

	        addressBook.deleteContact("disha patil");
	        System.out.println("\nAfter Deleting John Doe:");
	        addressBook.displayContacts();

	        addressBook.editContact("Savita Tekale", "8976543210");
	        System.out.println("\nAfter Editing Jane Doe's Phone Number:");
	        addressBook.displayContacts();
	    }
	}



