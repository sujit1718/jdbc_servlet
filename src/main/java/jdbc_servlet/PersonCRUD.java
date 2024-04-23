package jdbc_servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PersonCRUD {

	public Connection getConnection() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/servletdb","root","root");
		return connection;
	}
	
	public int signUpUser(Person person) throws Exception
	{
		String sql = "insert into person(id,name,phone,address,email,password)values(?,?,?,?,?,?)";
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
	    preparedStatement.setInt(1, person.getId());
	    preparedStatement.setString(2, person.getName());
	    preparedStatement.setLong(3, person.getPhone());
	    preparedStatement.setString(4, person.getAddress());
	    preparedStatement.setString(5, person.getEmail());
	    preparedStatement.setString(6, person.getPassword());
	    
	    int result = preparedStatement.executeUpdate();
	    connection.close();
	    return result;
	}
	
		 public String loginPerson(String email) throws Exception
		 {
			String sql = "select password from person where email=?";
			Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, email);
			ResultSet resultSet  = preparedStatement.executeQuery();
			String password = null;
			while(resultSet.next()) {
				password = resultSet.getString("password");
			}
			connection.close();
			return password;
		 }
}
