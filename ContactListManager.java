
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

// Contact Class
class Contact {
    String name;
    String phone;

    // Constructor
    Contact(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    // Display Contact
    void display() {
        System.out.println("Name: " + name);
        System.out.println("Phone: " + phone);
    }
}

// Main Class
public class ContactListManager {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Contact> contacts = new ArrayList<>();

        int choice;

        do {
            System.out.println("\n--- CONTACT LIST MANAGER ---");
            System.out.println("1. Add Contact");
            System.out.println("2. View Contacts");
            System.out.println("3. Search Contact");
            System.out.println("4. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter phone: ");
                    String phone = sc.nextLine();

                    contacts.add(new Contact(name, phone));

                    System.out.println("Contact Added Successfully!");
                    break;

                case 2:
                    if (contacts.isEmpty()) {
                        System.out.println("No Contacts Found!");
                    } else {
                        System.out.println("\n--- CONTACT DETAILS ---");

                        for (Contact c : contacts) {
                            c.display();
                            System.out.println("----------------");
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter name to search: ");
                    String search = sc.nextLine();

                    LinkedList<Contact> result = new LinkedList<>();

                    for (Contact c : contacts) {
                        if (c.name.equalsIgnoreCase(search)) {
                            result.add(c);
                        }
                    }

                    if (result.isEmpty()) {
                        System.out.println("Contact Not Found!");
                    } else {
                        System.out.println("Contact Found!");

                        for (Contact c : result) {
                            c.display();
                        }
                    }
                    break;

                case 4:
                    System.out.println("Thank You!");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 4);

        sc.close();
    }
}
