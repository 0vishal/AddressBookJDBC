import addressbook.AddressBookData;
import addressbook.AddressBookDatabase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class AddressBookTest {

    AddressBookDatabase addressBookDatabase;

    @Test
    void readData() {

        addressBookDatabase=new AddressBookDatabase();
        List<AddressBookData> addressBookData1=addressBookDatabase.readData();
        System.out.println(addressBookData1.size());
        Assertions.assertEquals(11,addressBookData1.size());
    }


    @Test
    void UpdateTable(){
        addressBookDatabase=new AddressBookDatabase();
        addressBookDatabase.updateRecord();
        List<AddressBookData>payrollServiceDataList=addressBookDatabase.readData();
        Assertions.assertEquals(11,payrollServiceDataList.size());
    }

    @Test
    public void Date_range_test() throws SQLException, IllegalAccessException {
        String date="2019-10-15";
         addressBookDatabase= new AddressBookDatabase();
        List<AddressBookData> addressBookList=addressBookDatabase.DateRange(date);
        Assertions.assertEquals(3,addressBookList.size());
    }

    @Test
    public void recordsofstate() throws SQLException, IllegalAccessException {
        String state="Maharashtra";
        addressBookDatabase= new AddressBookDatabase();
        String result=addressBookDatabase.countbyState(state);
        Assertions.assertEquals("6",result);
    }

    @Test
    public void insertnewecord() throws SQLException, IllegalAccessException {
        String firstname="Rahul";
        String lastname="Vaidya";
        String address="pune";
        String city="pune";
        String state="Maharashtra";
        int phonenumber = 984248882;
        String email="rahul@gmail.com";
        String addressBookName="Addressbook3";
        String joiningDate="2020-02-11";

       addressBookDatabase= new AddressBookDatabase();
        addressBookDatabase.InserNewRecord(firstname,lastname,address,city,state,email,phonenumber,name,type,date_added);
        List<AddressBookData>addressBookData=addressBookDatabase.readData();
        Assertions.assertEquals(1,addressBookData.size());
    }

    @Test
    public void add_multiple_records() throws SQLException, IllegalAccessException,SQLException {
        addressBookDatabase=new AddressBookDatabase();
        List<AddressBookData> list=new ArrayList<>();
        list.add(new AddressBookData("Pramod","Tripathi","Gandhinagar","Mumbai","Maharashtra","Pramod@gmail.com",935266677,"Addressbook2","friend", "2020-10-23"));
        list.add(new AddressBookData("Roshan","Kadam","Devgad","Kokan","Maharashtra","Roshan@gmail.com",834466677,"Addressbook1","family", "2020-03-25"));
        Instant start =Instant.now();
        addressBookDatabase.insetRecordsUsingArrays(list);
        Instant end = Instant.now();
        System.out.println("Duration without thread "+ Duration.between(start,end));
        Instant threadstart =Instant.now();
        addressBookDatabase.insertContactUsingThread(list);
        Instant threadend = Instant.now();
        System.out.println("Duration using thread "+ Duration.between(threadstart,threadend));
        List<AddressBookData> addressBookData=addressBookDatabase.readData();
        Assertions.assertEquals(11,addressBookData.size());

    }

}
