package library.english.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import library.english.dataconnect.UsedCounter;
import library.english.dataconnect.English;
import library.english.dataconnect.EnglishPhrase;
import library.english.dataconnect.EnglishPhraseWordDML;
import library.english.dataconnect.EnglishWordDML;

/**
 * Servlet implementation class EnglishSearch
 */
@WebServlet("/EnglishSearch")
public class EnglishSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnglishSearch() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("utf8");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		request.setCharacterEncoding("utf8");
		
		String spell = request.getParameter("spell");
		String pert = request.getParameter("pert_of");
		int pert_of = Integer.parseInt(pert);
		
		ArrayList<English> select1;
		ArrayList<EnglishPhrase> select2;
		EnglishWordDML search1 = new EnglishWordDML();
		EnglishPhraseWordDML search2 = new EnglishPhraseWordDML();
		UsedCounter countInstance = new UsedCounter();
		
		if(pert_of == 11) {	
			select2 = search2.selectPhrase(spell);
			countInstance.EnglishPhraseCounter(spell);
			
			if(select2.isEmpty()) {
				request.setAttribute("search_zero", "検索項目に引っかかりませんでした");
			}
			
			request.setAttribute("search_result_ph", select2);
		} else {		
			select1 = search1.select(spell);
			countInstance.EnglishPhraseCounter(spell);
			
			if(select1.isEmpty()) {
				request.setAttribute("search_zero", "検索項目に引っかかりませんでした");
			}
			
			request.setAttribute("search_result", select1);
		}
		
		request.getRequestDispatcher("Home.jsp").forward(request,response);
	}

}
