package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Computers;

/**
 * Servlet implementation class NavigationServlet
 */
@WebServlet("/navigationServlet")
public class NavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NavigationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String act = request.getParameter("doThisToComputer");
		String path = "/viewAllComputersServlet";
		
		ComputerHelper dao = new ComputerHelper();
		
		if(act.equals("delete")) {
			
		try{
			Integer tempId = Integer.parseInt(request.getParameter("id"));
			Computers computerToDelete = dao.searchForItemById(tempId);
			dao.deleteItem(computerToDelete);
			
		}catch(NumberFormatException e){
			System.out.println("Forgot to select a Computer");
		}
			
			
		}else if (act.equals("edit")) {
			
		try {
			Integer tempId = Integer.parseInt(request.getParameter("Id"));
			Computers computerToEdit = dao.searchForItemById(tempId);
			request.setAttribute("computerToEdit", computerToEdit);
			path="/edit-computer.jsp";
			
		}catch(NumberFormatException e) {
				System.out.println("Forgot to select a Computer");
			}
		}else if (act.equals("add")) {
			path="/index.html";
		}
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

}
