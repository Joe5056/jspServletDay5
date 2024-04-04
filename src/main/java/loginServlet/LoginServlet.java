//To create this Servlet page, right click on src/main/java -> New ->Servlet.
package loginServlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.UserDTO;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// read the data which are coming from
		String name = request.getParameter("username");
		String pass = request.getParameter("password");

		// write business logic to validate a user
		// To interact with database, we have to follow these steps:
		// Step 1: Load/Register Driver Class
		// Step 2: Create Connection
		// Step 3: Create Statement
		// Step 4: Execute query
		// Step 5: Close Connection

		try { // Step 1:
			Class.forName("com.mysql.jdbc.Driver");

			try { // Step 2:
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb", "root", "root");
				// enter username and password of workbench

				// Step 3:
				PreparedStatement ps = conn.prepareStatement("select * from profile where username=? and password=?");
				// If first column is Int type then use setInt();
				ps.setString(1, name); // to pass the value from db, use the variable name
				ps.setString(2, pass);

				// Step 4:
				ResultSet rs = ps.executeQuery();
				// executeQuery()-->used for retrieval. It returns the instance of ResultSet
				// executeUpdate(); --> used for insertion/deletion/updation such as for
				// registration. It returns integer value.

				if (rs.next()) {
					System.out.println(rs.getString(1) + "  " + rs.getString(2) + "  " + rs.getString(3) + "  "
							+ rs.getString(4) + "  " + rs.getString(5));
					// for seeing results on server side. 1,2,3,4,5 are column values.
					String username = rs.getString(1);  //raju
					String password = rs.getString(2);  //333
					String fullname = rs.getString(3);   //PO
					String designation = rs.getString(4);  //999
					int salary = rs.getInt(5);

					/*
					 * request.setAttribute("a", username);
					request.setAttribute("b", password);
					request.setAttribute("c", fullname);
					request.setAttribute("d", designation);
					request.setAttribute("e", salary);
					*/
					
					//We don't wanted to store these data by using setAttribute several time so we have created an object of UserDTO
					UserDTO userDTO=new UserDTO(username, password, fullname,designation,salary);
					request.setAttribute("userDTO", userDTO);  //Holds all the data
					// forward these data to client on congratulations page so that client can see
					// his/her record.
					//request.getRequestDispatcher("congratulations.jsp").forward(request, response);
					request.getRequestDispatcher("congratulations2.jsp").forward(request, response);


				} else {
					// invalid
					request.setAttribute("message", "Wrong credential...Re-try!!"); //we need to use ${message} in login.jsp
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}

				// closing of first try block
			} catch (SQLException e) {

				e.printStackTrace();
			}
			// closing of second try block
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
