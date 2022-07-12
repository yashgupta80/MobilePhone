package challenges3.Mobile;

import java.util.ArrayList;

public class MobilePhone {
    private String MyNumber;
    private ArrayList<Contact> myContact;

    public MobilePhone(String MyNumber){
        this.MyNumber = MyNumber;
        this.myContact = new ArrayList<Contact>();
    }

    //Method.. for add number and name in contact list if it is not exist already..


    public boolean addContact(Contact contact){
        if (findContact(contact.getName()) >=0){
            System.out.println("contact is already in contact list ");
            return false;

        }
        myContact.add(contact);
        return true;
    }
    public boolean updateContact(Contact oldContact, Contact newContact) {
        int foundPosition = findContact(oldContact);
        if (foundPosition < 0) {
            System.out.println(oldContact.getName() + ", was not found ");
            return false;
        }
        this.myContact.set(foundPosition,newContact);
        System.out.println(oldContact.getName() + ", replace with " + newContact.getName());
        return true;
    }

    private int findContact(Contact contact){
        return this.myContact.indexOf(contact);
    }
    // overloaded findContactFunction..
    private int findContact(String contactName){
        for (int i= 0; i<this.myContact.size(); i++){
            Contact contact = this.myContact.get(i);
            if (contact.getName().equals(contactName)){
                return i;
            }
        }
        return -1;
    }

    public Contact queryContact(String name){
        int position = findContact(name);
        if (position>=0){
            return this.myContact.get(position);
        }
        return null;
    }

    // query Contact Method..|
    public String queryContact(Contact contact){
        if (findContact(contact) >=0){
            return contact.getName();// if number of contact it return name;
        }
        return null;
    }

    public boolean removeContact(Contact contact){
        int foundPosition = findContact(contact);
        if (foundPosition<0){
            System.out.println(contact.getName() + ", was not found ");
            return false;
        }
         this.myContact.remove(foundPosition);
        System.out.println(contact.getName() + ", was deleted");
        return true;
    }
    public void printContact(){
        System.out.println("contact List: ");
        for (int i =0; i<this.myContact.size(); i++){
            System.out.println((i+1) + "." + this.myContact.get(i).getName() + "-> " +
                    this.myContact.get(i).getPhoneNumber());
        }
    }
}
