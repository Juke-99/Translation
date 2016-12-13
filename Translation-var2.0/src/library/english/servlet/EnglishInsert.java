package library.english.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import library.english.dataconnect.EnglishPhraseWordDML;
import library.english.dataconnect.EnglishWordDML;

/**
 * Servlet implementation class EnglishInsert
 */
@WebServlet("/EnglishInsert")
public class EnglishInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnglishInsert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("utf-8");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		request.setCharacterEncoding("utf-8");
		
		String spell=request.getParameter("spell");
		String meaning=request.getParameter("imi");
		String pert=request.getParameter("pert_of");
		int pert_of=Integer.parseInt(pert);
		int count;
		
		EnglishWordDML insert1=new EnglishWordDML();
		EnglishPhraseWordDML insert2=new EnglishPhraseWordDML();
		
		if(pert_of==11)
		{
			count=insert2.insert(spell,meaning,0);
		}
		else
		{
			count=insert1.insert(spell,meaning,pert_of);
		}
		
		if(count==0)
		{
			request.setAttribute("insertError","どちらかの入力項目が間違っています");
		}
		
		request.getRequestDispatcher("Home.jsp").forward(request, response);
	}

}
