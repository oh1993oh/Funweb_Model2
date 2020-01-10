package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.corba.se.impl.protocol.RequestDispatcherRegistryImpl;

import action.Action;
import action.InsertCommentAction;
import vo.ActionForward;

public class BoardFrontController extends HttpServlet {

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTf-8"); // POST 방식에 대한 한글처리

		String command = request.getServletPath(); // 서블릿 주소 추출

		Action action = null;
		ActionForward forward = null;

		// 입력받은 서블릿 주소 매핑
		if (command.equals("/BoardMain.me")) {
			forward = new ActionForward();
			forward.setPath("/index.jsp");
		} else if (command.equals("/BoardWriteForm.me")) {
			forward = new ActionForward();
			forward.setPath("/board/board_write.jsp");
		} else if (command.equals("/BoardWritePro.me")) {
			action = new BoardWriteProAction();

			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				System.out.println("BoardFrontController - /board/board_write.jsp - 오류" + e.getMessage());
			}
		} else if (command.equals("/BoardList.me")) {
			action = new BoardListAction();

			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				System.out.println("BoardFrontController - BoardList.me - 오류" + e.getMessage());
			}
		} else if (command.equals("/BoardDetail.me")) {
			action = new BoardDetailAction();

			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				System.out.println("BoardFrontController - BoardDetail.me - 오류" + e.getMessage());
			}
		} else if (command.equals("/BoardModifyPro.me")) {
			action = new BoardModifyProAction();

			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				System.out.println("BoardFrontController - BoardModifyPro.me - 오류" + e.getMessage());
			}
		} else if (command.equals("/BoardDeleteForm.me")) {
			forward = new ActionForward();
			forward.setPath("/board/board_delete.jsp");
		} else if (command.equals("/BoardDeletePro.me")) {
			action = new BoardDeleteProAction();

			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				System.out.println("BoardFrontController - BoardDeletePro.me - 오류" + e.getMessage());
			}
		} else if (command.equals("/BoardReplyForm.me")) {
			action = new BoardReplyFormAction();

			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				System.out.println("BoardFrontController - BoardReplyForm.me - 오류" + e.getMessage());
			}
		} else if (command.equals("/BoardReplyPro.me")) {
			action = new BoardReplyProAction();

			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				System.out.println("BoardFrontController - BoardReplyPro.me - 오류" + e.getMessage());
			}

		} else if (command.equals("/InsertComment.me")) {
			// BoardReplyFormAction 클래스로 이동
			action = new InsertCommentAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				System.out.println("BoardFrontController - InsertComment.me - 오류" + e.getMessage());
			}
		}
		
		if(forward != null) {
			if(forward.isIsredirect()) {
				response.sendRedirect(forward.getPath());
			}else {
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath()); 
				dispatcher.forward(request, response);
			}
		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);
	}
	
	
}
