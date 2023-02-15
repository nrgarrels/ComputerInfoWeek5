package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Computers;

/**
 * Servlet implementation class AddComputerServlet
 */
@WebServlet("/AddComputerServlet")
public class AddComputerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddComputerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String manufacturer = request.getParameter("manufacturer");
		String type = request.getParameter("type");
		String os = request.getParameter("os");
		Computers ci = new Computers(manufacturer, type, os);
		ComputerHelper dao = new ComputerHelper();
		dao.insertItem(ci);
		
		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
		
		
		
	}

}
