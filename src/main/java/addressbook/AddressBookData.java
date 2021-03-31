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
        public String Date_added;



        public AddressBookData(String firstName, String lastName,String address, String city, String state,String email,int phonenumber,String name,String type,String date_added) {
            FirstName = firstName;
            LastName = lastName;
            Address = address;
            this.city = city;
            State = state;
            Email = email;
            Phonenumber = phonenumber;
            Name = name;
            Type = type;
            Date_added = date_added;
        }
    }
