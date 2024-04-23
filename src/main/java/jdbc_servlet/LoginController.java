package jdbc_servlet;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/login")
public class LoginController extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		PersonCRUD crud = new PersonCRUD();
		try {
			String dbpassword = crud.loginPerson(email);
			if(dbpassword != null) {
				if(dbpassword.equals(dbpassword)) {
					res.getWriter().print("Login Successful!");
				}
				else {
					res.getWriter().print("Login Unsuccessful!");
				}
			}else {
				res.getWriter().print("person not register for the given mail "+email);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}