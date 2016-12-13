package trans.lang.en;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		request.setCharacterEncoding("utf-8");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		
		String spell=request.getParameter("spell");
		String imi=request.getParameter("imi");
		String pert=request.getParameter("pert_of");
		int pert_of=Integer.parseInt(pert);
		int count;
		
		EnglishDataAccess insert=new EnglishDataAccess();
		
		if(pert_of==11)
		{
			count=insert.insertPhrase(spell, imi);
		}
		else
		{
			count=insert.insert(spell,imi,pert_of);
		}
		
		if(count==0)
		{
			request.setAttribute("insertError","どちらかの入力項目が間違っています");
		}
		
		request.getRequestDispatcher("English.jsp").forward(request, response);
	}

}
