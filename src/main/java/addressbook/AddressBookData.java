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

    public AddressBookData(String firstName, String lastName, String address, String city, String state, String email, int phonenumber, String name, String type, String date_added) {
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



    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public int getPhonenumber() {
        return Phonenumber;
    }

    public void setPhonenumber(int phonenumber) {
        Phonenumber = phonenumber;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getDate_added() {
        return Date_added;
    }

    public void setDate_added(String date_added) {
        Date_added = date_added;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }
}

    @Override
    public String toString() {
        return "AddressBookData{" +
                "FirstName='" + FirstName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", Address='" + Address + '\'' +
                ", City='" + city + '\'' +
                ", State='" + State + '\'' +
                ", Email='" + Email + '\'' +
                ", Phoneno=" + Phonenumber +
                ", Name='" + Name + '\'' +
                ", Type='" + Type + '\'' +
                ", Date added=" + Date_added +
                '}';
    }
