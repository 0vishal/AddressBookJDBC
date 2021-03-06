package addressbook;

import java.sql.Connection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class AddressBookDatabase {

    private Connection getConnection() throws IllegalAccessException {
        String JDBCURL = "jdbc:mysql://localhost:3306/address_book_service?useSSL=false";
        String UserName = "root";
        String Password = "root";
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loaded");
        } catch (ClassNotFoundException e) {
            throw new IllegalAccessException(String.format("Driver not found in classpath%s", e));

        }
        try {
            System.out.println("Connecting to database" + JDBCURL);
            connection = DriverManager.getConnection(JDBCURL, UserName, Password);
            System.out.println("Connection success" + connection);
        } catch (Exception e) {
            e.printStackTrace();

        }
        return connection;
    }

    public List<AddressBookData> readData() {
        String Sql_Query = "Select * from address_book";
        List<AddressBookData> addressBookData = new ArrayList<>();
        try {
            Connection connection = this.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(Sql_Query);

            while (resultSet.next()) {
                String FirstName = resultSet.getString(1);
                String LastName = resultSet.getString(2);
                String Address = resultSet.getString(3);
                String city = resultSet.getString(4);
                String State = resultSet.getString(5);
                String Email = resultSet.getString(6);
                int Phonenumber = resultSet.getInt(7);
                String Name = resultSet.getString(8);
                String Type = resultSet.getString(9);


                System.out.println();
                System.out.println("FirstName=" + FirstName);
                System.out.println("LastName=" + LastName);
                System.out.println("address=" + Address);
                System.out.println("City=" + city);
                System.out.println("State=" + State);
                System.out.println("email=" + Email);
                System.out.println("phoneno" + Phonenumber);
                System.out.println("NAme=" + Name);
                System.out.println("Type" + Type);


                AddressBookData addressBookData1 = new AddressBookData(resultSet.getString(1), resultSet.getString(2),
                        resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6),
                        resultSet.getInt(7), resultSet.getString(8), resultSet.getString(9));

                addressBookData.add(addressBookData1);


            }
            statement.close();
            connection.close();


        } catch (SQLException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return addressBookData;
    }

    public void updateRecord() {
        String SqlQuery = "update address_book set phonenumber=92837465 where firstname=vishal; ";
        try {
            Connection connection = this.getConnection();
            Statement statement = connection.createStatement();
            long resultset = statement.executeUpdate(SqlQuery);
        } catch (SQLException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }


    public List<AddressBookData> DateRange(String date) throws SQLException, IllegalAccessException {
        List<AddressBookData> addressBookList=new ArrayList<>();
        Connection connection=this.getConnection();

        try {
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement= connection.prepareStatement("Select * from address_book where date_added>=? ; ");
            preparedStatement.setDate(1,Date.valueOf(date));
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                AddressBookData addressBookData=new AddressBookData(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),resultSet.getString(6),resultSet.getInt(7),resultSet.getString(8),resultSet.getString(9),resultSet.getDate(10));
                addressBookList.add(addressBookData);
                connection.commit();
            }
            System.out.println(addressBookList.toString());
        } catch (SQLException e) {
            e.printStackTrace();
            connection.rollback();
        }
        return addressBookList;
    }

    public String countbyState(String state) throws SQLException, IllegalAccessException {
        Connection connection=this.getConnection();
        String result=null;
        try {
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement= connection.prepareStatement("select count(*) from address_book where state=? ; ");
            preparedStatement.setString(1,state);
            ResultSet resultSet=preparedStatement.executeQuery();
            connection.commit();
            while (resultSet.next()){
                result=resultSet.getString(1);
                System.out.println(resultSet.getString(1));
            }
            return result;
        }catch (SQLException e){
            e.printStackTrace();
            connection.rollback();
        }
        return result;
    }

    public void InserNewRecord(String firstName, String lastName,String address, String city, String state,String email,int phonenumber,String name,String type,int date_added) throws SQLException, IllegalAccessException {
        Connection connection=this.getConnection();
        try {
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement=connection.prepareStatement("insert into address_book(firstname,lastname,address,city,state,email,phonenumber,name,type,date_added) values (?,?,?,?,?,?,?,?,?,?); ");
            preparedStatement.setString(1,firstName);
            preparedStatement.setString(2,lastName);
            preparedStatement.setString(3,address);
            preparedStatement.setString(4,city);
            preparedStatement.setString(5,state);
            preparedStatement.setString(6,email);
            preparedStatement.setInt(7,phonenumber);
            preparedStatement.setString(8,name);
            preparedStatement.setString(9,type);
            preparedStatement.setDate(10,  Date.valueOf(date_added));
            preparedStatement.executeUpdate();
            connection.commit();
        }catch (SQLException e){
            e.printStackTrace();
            connection.rollback();
        }
    }

}