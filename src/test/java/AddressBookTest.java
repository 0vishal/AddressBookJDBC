import addressbook.AddressBookData;
import addressbook.AddressBookDatabase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
}
