package challenges3.Mobile;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static MobilePhone mobilePhone = new MobilePhone("0039 330 4404");
    public static void main(String[] args){
        boolean quit = false;
        startPhone();
        printAction();
        while (!quit) {
            System.out.println("Enter action : (6 action you can see)");
            int action = scanner.nextInt();
            scanner.nextLine();
            switch (action) {
                case 0:
                    System.out.println("\n shutting Down....");
                    quit = true;
                    break;
                case 1:
                    mobilePhone.printContact();
                    break;
                case 2:
                    addNewContact();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    querryContact();
                    break;
                case 6:
                    printAction();
                    break;

            }

        }

    }
    private static void addNewContact(){
        System.out.println("Enter new Contact Name: ");
        String names = scanner.nextLine();
        System.out.println("Enter the phone Number: ");
        String phoneNumber = scanner.nextLine();
        Contact newContact =  Contact.createContact(names, phoneNumber);
        if (mobilePhone.addContact(newContact)){
            System.out.println("new contact add: name = " + names + ", phone = " + phoneNumber);
        }else {
            System.out.println("contact cannot added " + names + " already on contact List");
        }
    }

    private static void updateContact(){
        System.out.println("Enter existing contact name: ");
        String name = scanner.nextLine();
        Contact existingContactRecord = mobilePhone.queryContact(name);
        if (existingContactRecord == null){
            System.out.println("contact not found");
            return;
        }
        System.out.println("Enter new contact Name: ");
        String newName = scanner.nextLine();
        System.out.println("Enter new contact phoneNumber: ");
        String phoneNumber = scanner.nextLine();
        Contact newContact = Contact.createContact(newName,phoneNumber);
        if (mobilePhone.updateContact(existingContactRecord, newContact)){
            System.out.println("successfully updated record");
        }else {
            System.out.println("error in updating contact: ");
        }

    }
    private static void removeContact(){
        System.out.println("Enter existing contact name: ");
        String name = scanner.nextLine();
        Contact existingContactRecord = mobilePhone.queryContact(name);
        if (existingContactRecord == null){
            System.out.println("contact not found");
            return;
        }
        if (mobilePhone.removeContact(existingContactRecord)){
            System.out.println("successfully deleted");
        }else {
            System.out.println("error in deleting");
        }

    }

    private static void querryContact(){
        System.out.println("Enter existing contact name: ");
        String name = scanner.nextLine();
        Contact existingContactRecord = mobilePhone.queryContact(name);
        if (existingContactRecord == null){
            System.out.println("contact not found");
            return;
        }

        System.out.println("Name: = " + existingContactRecord.getName() +
                ", phoneNumber: = " + existingContactRecord.getPhoneNumber());
    }
    private static void startPhone(){
        System.out.println("starting phone.....");
    }
    private static void printAction(){
        System.out.println("\nAvailable Action: \npress");
        System.out.println("0 - to shutDown\n" +
                           "1 - to print contact list\n" +
                           "2 - to add a new contact in contact list\n" +
                           "3 - to update existing an existing contact\n" +
                           "4 - to remove an existing contact\n" +
                           "5 - to query is existing contact is exist\n" +
                           "6 - to print a list of available action. ");
        System.out.println("Enter your choice: ");
    }



}
