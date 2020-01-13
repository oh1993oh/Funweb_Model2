package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.corba.se.impl.protocol.RequestDispatcherRegistryImpl;

import boardaction.Action;
import boardaction.BoardDeleteProAction;
import boardaction.BoardDetailAction;
import boardaction.BoardListAction;
import boardaction.BoardModifyProAction;
import boardaction.BoardReplyFormAction;
import boardaction.BoardReplyProAction;
import boardaction.BoardWriteProAction;
import boardaction.InsertCommentAction;
import vo.ActionForward;

@WebServlet("*.bo")
public class BoardFrontController extends HttpServlet {

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTf-8"); // POST 방식에 대한 한글처리

		String command = request.getServletPath(); // 서블릿 주소 추출

		Action action = null;
		ActionForward forward = null;

		// 입력받은 서블릿 주소 매핑
		if (command.equals("/BoardMain.bo")) {
			forward = new ActionForward();
			forward.setPath("/index.jsp");
		} else if (command.equals("/BoardWriteForm.bo")) {
			forward = new ActionForward();
			forward.setPath("/board/board_write.jsp");
		} else if (command.equals("/BoardWritePro.bo")) {
			action = new BoardWriteProAction();

			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				System.out.println("BoardFrontController - /board/board_write.jsp - 오류" + e.getMessage());
			}
		} else if (command.equals("/BoardList.bo")) {
			action = new BoardListAction();

			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				System.out.println("BoardFrontController - BoardList.bo - 오류" + e.getMessage());
			}
		} else if (command.equals("/BoardDetail.bo")) {
			action = new BoardDetailAction();

			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				System.out.println("BoardFrontController - BoardDetail.bo - 오류" + e.getMessage());
			}
		} else if (command.equals("/BoardModifyPro.bo")) {
			action = new BoardModifyProAction();

			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				System.out.println("BoardFrontController - BoardModifyPro.bo - 오류" + e.getMessage());
			}
		} else if (command.equals("/BoardDeleteForm.bo")) {
			forward = new ActionForward();
			forward.setPath("/board/board_delete.jsp");
		} else if (command.equals("/BoardDeletePro.bo")) {
			action = new BoardDeleteProAction();

			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				System.out.println("BoardFrontController - BoardDeletePro.bo - 오류" + e.getMessage());
			}
		} else if (command.equals("/BoardReplyForm.bo")) {
			action = new BoardReplyFormAction();

			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				System.out.println("BoardFrontController - BoardReplyForm.bo - 오류" + e.getMessage());
			}
		} else if (command.equals("/BoardReplyPro.bo")) {
			action = new BoardReplyProAction();

			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				System.out.println("BoardFrontController - BoardReplyPro.bo - 오류" + e.getMessage());
			}

		} else if (command.equals("/InsertComment.bo")) {
			// BoardReplyFormAction 클래스로 이동
			action = new InsertCommentAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				System.out.println("BoardFrontController - InsertComment.bo - 오류" + e.getMessage());
			}
		}
		
		if(forward != null) {
			if(forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			}else {
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath()); 
				dispatcher.forward(request, response);
			}
		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	
}
