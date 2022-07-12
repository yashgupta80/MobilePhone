package challenges3.Mobile;

public class Contact {
    private String name;
    private String PhoneNumber;


     public Contact(String name, String PhoneNumber){// constructor.."
         this.name = name;
         this.PhoneNumber = PhoneNumber;
     }

     public String getName(){
         return name;
     }
     public String getPhoneNumber(){
         return PhoneNumber;
     }

     // CALL CONSTRUCTOR..
    public static Contact createContact(String name, String PhoneNumber){
         return new Contact(name,PhoneNumber);
    }

}
