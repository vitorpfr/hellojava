package mobilephonechallenge;

public class Contact {
    String name;
    String phoneNumber;

    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    // factory method (to instantiate objects)
    public static Contact createContact(String name, String phoneNumber) {
        return new Contact(name, phoneNumber);
    }

    // overriding equals method to consider contacts equal if they have equal names
    @Override
    public boolean equals(Object obj) {
        if (obj.getClass() == Contact.class) {
            return ((Contact) obj).name.equals(this.name);
        } else {
            return super.equals(obj);
        }

    }
}
