package mobilephonechallenge;

import java.util.ArrayList;

public class MobilePhone {
    private String myNumber;
    private ArrayList<Contact> myContacts;

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<Contact>();
    }

    public boolean addNewContact(Contact newContact) {
        if (findContact(newContact) == -1) {
            myContacts.add(newContact);
            return true;
        }

        return false;
    }

    public boolean updateContact(Contact oldContact, Contact newContact) {
        int oldContactIndex = findContact(oldContact);

        if (oldContactIndex == -1) {
            return false;
        }

        if (findContact(newContact.getName()) != -1) {
            System.out.println("Contact with name " + newContact.getName() + " already exists. Update was not successful");
            return false;
        }

        myContacts.set(oldContactIndex, newContact);
        return true;
    }

    public boolean removeContact(Contact contact) {
        int index = findContact(contact);

        if (index == -1) {
            return false;
        }

        myContacts.remove(index);
        return true;
    }

    private int findContact(Contact contact) {
        return myContacts.indexOf(contact);
    }

    private int findContact(String name) {
        Contact temp = Contact.createContact(name, "0");
        return findContact(temp);
    }

    public Contact queryContact(String name) {
        int index = findContact(name);
        if (index == -1) {
            return null;
        }

        return myContacts.get(index);
    }

    public void printContacts() {
        if (myContacts.size() == 0) {
            System.out.println("Contact list is empty.");
        } else {
            System.out.println("Contact List:");
            for (int i = 0; i < myContacts.size(); i++) {
                System.out.println((i + 1) + ". " + myContacts.get(i).name + " -> " + myContacts.get(i).phoneNumber);
            } 
        }
        
    }
}
