
/*JSTL- JSP Standard Tag Library
 * Required for using JSTL
 * 1. jar file -> add jstl 1.2 (jar is collection of packages)
 * 2. Iterate the contents using for loop-- for each loop, while, etc... if data is already indexed, we use for each loop. if not indexed, use others.
 * For each loop: Syntax: for( Class it belongs to variable name using which we want to print: what you want to iterate)--> Array is already indexed
 * 3. Tag Lib: <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 * 
 * 
 */
package loginServlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.UserDTO;

@WebServlet("/getAllRecords") // Logical name
public class FetchAllRecordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			Class.forName("com.mysql.jdbc.Driver");

			try {
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb", "root", "root");

				PreparedStatement ps = conn.prepareStatement("select * from profile"); // Query to fetch all records

				ResultSet rs = ps.executeQuery();

				List<UserDTO> listofRecords = new ArrayList<>();

				while (rs.next()) {
					System.out.println(rs.getString(1) + "  " + rs.getString(2) + "  " + rs.getString(3) + "  "
							+ rs.getString(4) + "  " + rs.getString(5));

					String username = rs.getString(1);
					String password = rs.getString(2);
					String fullname = rs.getString(3);
					String designation = rs.getString(4);
					int salary = rs.getInt(5);

					UserDTO userDTO = new UserDTO(username, password, fullname, designation, salary);
					listofRecords.add(userDTO); // in first iteration, first object/record will be added in blank arraylist.
					// In second iteration, second object will be added over here

					// request.getRequestDispatcher("congratulations2.jsp").forward(request, response);

				}
				System.out.println(listofRecords); // Collection of Records
//To print on client side
				request.setAttribute("listofRecords", listofRecords);
				request.getRequestDispatcher("showAll.jsp").forward(request, response);
			} catch (SQLException e) {

				e.printStackTrace();
			}

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
