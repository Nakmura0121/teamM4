package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.Book;

/**
 * Servlet implementation class BookRegisterConfirmServlet
 */
@WebServlet("/BookRegisterConfirmServlet")
public class BookRegisterConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookRegisterConfirmServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
		/*String id2 = request.getParameter("id");
		int id = Integer.parseInt(id2); */
		String book_name = request.getParameter("book_name");
		String author = request.getParameter("author");
		String publisher = request.getParameter("publisher");
		String isbn2 = request.getParameter("isbn");
		int isbn = Integer.parseInt(isbn2);
		String version = request.getParameter("version");
		String day = request.getParameter("day");
		


		Book teamlibrary = new Book(-1,book_name, author, publisher, isbn, version, day);
		
		HttpSession session = request.getSession();
		

		session.setAttribute("input_data", teamlibrary);
		
		String view = "WEB-INF/view/book-register-confirm.jsp";
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
