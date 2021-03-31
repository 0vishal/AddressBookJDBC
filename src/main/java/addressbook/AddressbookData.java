package addressbook;

public class AddressBookData {

        public String FirstName;
        public String LastName;
        public String Address;
        public String city;
        public String State;
        public String Email;
        public int Phonenumber;
        public String Name;
        public String Type;


        public AddressBookData(String firstName, String lastName,String address, String city, String state,String email,int phonenumber,String name,String type) {
            FirstName = firstName;
            LastName = lastName;
            Address = address;
            this.city = city;
            State = state;
            Email = email;
            Phonenumber = phonenumber;
            Name = name;
            Type = type;
        }
    }
