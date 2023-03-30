package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.RentalDAO;
import dto.Account;
import dto.Book;
import dto.Rental;

/**
 * Servlet implementation class Detail2Servlet
 */
@WebServlet("/DetailConfirmServlet")
public class DetailConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetailConfirmServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		
		String strid = request.getParameter("leading");
		int    id  = Integer.parseInt(strid);
		
		Book bookname = RentalDAO.selectBook(id);
		  		  
		String book_name2 =  String.valueOf(bookname);
		
		
		Account s = (Account)session.getAttribute("detail");
		
		String mail = s.getMail();
		
		Rental teamRental = new Rental(-1, -1, mail,id, book_name2 , null, null);
		
		session.setAttribute("list3", teamRental);
		String view = "WEB-INF/view/detail-confirm.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
