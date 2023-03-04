import java.util.*;
import java.io.*;

class Contact implements Serializable {
    private String name;
    private String email;
    private String phone;

    public Contact(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\n" +
               "Email: " + email + "\n" +
               "Phone: " + phone + "\n";
    }
}

public class ContactBook {
    private static List<Contact> contacts = new ArrayList<Contact>();
    private static Scanner sc = new Scanner(System.in);
    private static final String FILE_NAME = "contacts.ser";

    public static void main(String[] args) {
      

        while (true) {
            System.out.println("Contact Book Menu:");
            System.out.println("1. Add Contact");
            System.out.println("2. View Contacts");
            System.out.println("3. Update Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Exit");
            System.out.print("Enter your choice (1-5): ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    addContact();
                    break;
                case 2:
                    viewContacts();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    deleteContact();
                    break;
                case 5:
                    System.out.println("Exiting...");
                   
                    System.exit(0);
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static void addContact() {
        System.out.print("Enter name: ");
        String name = sc.nextLine();

        System.out.print("Enter email: ");
        String email = sc.nextLine();

        System.out.print("Enter phone number: ");
        String phone = sc.nextLine();

        Contact contact = new Contact(name, email, phone);
        contacts.add(contact);

        System.out.println("Contact added.");
    }

    private static void viewContacts() {
        if (contacts.size() == 0) {
            System.out.println("Contact book is empty.");
        } else {
            for (int i = 0; i < contacts.size(); i++) {
                System.out.println("Contact " + (i+1) + ":");
                System.out.println(contacts.get(i));
            }
        }
    }

    private static void updateContact() {
        System.out.print("Enter the name of the contact to update: ");
        String name = sc.nextLine();

        boolean found = false;
        for (Contact contact : contacts) {
            if (contact.getName().equals(name)) {
                System.out.print("Enter new email: ");
                String email = sc.nextLine();
                contact.setEmail(email);

                System.out.print("Enter new phone number: ");
                String phone = sc.nextLine();
                contact.setPhone(phone);

                System.out.println("Contact updated.");
                found = true;
                break;
            }
        }
    }
        private static void deleteContact() {
            System.out.print("Enter the name of the contact to delete: ");
            String name = sc.nextLine();
        
            boolean found = false;
            for (int i = 0; i < contacts.size(); i++) {
                if (contacts.get(i).getName().equals(name)) {
                    contacts.remove(i);
                    System.out.println("Contact deleted.");
                    found = true;
                    break;
                }
            }
      
        if (!found) {
            System.out.println("Contact not found.");
        }
    }
}

    
    
