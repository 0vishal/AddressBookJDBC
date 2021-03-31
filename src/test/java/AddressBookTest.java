import addressbook.AddressBookData;
import addressbook.AddressBookDatabase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
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
}
