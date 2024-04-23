package jdbc_servlet;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/Signup")
public class SignupController extends GenericServlet {

	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

		String id = req.getParameter("id");
		int id1 = Integer.parseInt(id);
		String name = req.getParameter("name");
		String phone = req.getParameter("phone");
		long phone1 = Long.parseLong(phone);
		String address = req.getParameter("address");
		String email = req.getParameter("email");
		String password = req.getParameter("password");

		PersonCRUD crud = new PersonCRUD();
		Person person = new Person(id1, name, phone1, address, email, password);

		
		try {
			int result = crud.signUpUser(person);
			
			if(result>0)
				res.getWriter().print("signup successful!...");
			else
				res.getWriter().print("Sign up fail!..");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
