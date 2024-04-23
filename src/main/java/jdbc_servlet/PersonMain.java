package jdbc_servlet;

import java.util.Scanner;

public class PersonMain {

	 public static void main(String[] args) throws Exception {

			Scanner scanner = new Scanner(System.in);
			
	        while(true) {
			System.out.println("Welcome!!! \n1.SignUp \n2.LogIn \n3.Exit");
			int choise = scanner.nextInt();
			if(choise == 3) {
				System.out.println("Thank for Visit!");
				return;
			}
			PersonCRUD crud = new PersonCRUD();
			Person person = new Person();
			switch (choise) {
			case 1: {
				System.out.println("Enter the Id : ");
				int id = scanner.nextInt();
				System.out.println("Enter the Name : ");
				String name = scanner.next();
				System.out.println("Enter the Phone Number : ");
				long phone = scanner.nextLong();
				System.out.println("Enter the Email : ");
				String email = scanner.next();
				System.out.println("Enter the Password : ");
				String password = scanner.next();
				
				
				person.setId(id);
				person.setEmail(email);
				person.setName(name);
				person.setPhone(phone);
				person.setPassword(password);
           }
	     }
	    }
  }
}
