package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.Account;

/**
 * Servlet implementation class UserToroku
 */
@WebServlet("/UserToroku")
public class UserToroku extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserToroku() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		// フォーム入力内容の取得
		
		String name = request.getParameter("name");
		String mail = request.getParameter("mail");
		String pw = request.getParameter("pw");
		
		
		// 入力された情報を元にインスタンスを生成
		Account account = new Account(-1, name, mail, null, pw, null);
		
		// セッションスコープのインスタンス取得
				HttpSession session = request.getSession();
				
				// セッションスコープに値の保存
				// 第1引数：キー
				// 第2引数：保存する値
				session.setAttribute("input_data", account);
				
				String view = "WEB-INF/view/user-confilm.jsp";
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
