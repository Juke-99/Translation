package library.english.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import library.english.dataconnect.EnglishWordDML;

/**
 * Servlet implementation class EnglishUpdate
 */
@WebServlet("/EnglishUpdate")
public class EnglishUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnglishUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf8");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf8");
		
		String spell=request.getParameter("spell");
		String imi=request.getParameter("imi");
		String pert=request.getParameter("pert_of");
		
		int pert_of=Integer.parseInt(pert);
		
		EnglishWordDML update=new EnglishWordDML();
		update.update(spell,imi,pert_of);
		
		request.getRequestDispatcher("Home.jsp").forward(request,response);
	}

}
