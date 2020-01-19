package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import memberaction.Action;
import memberaction.MemberCheckProAction;
import memberaction.MemberJoinProAction;
import memberaction.MemberLoginProAction;
import memberaction.MemberLogoutProAction;
import memberaction.MemberUpdateProAction;
import vo.ActionForward;

@WebServlet("*.me")
public class MemberFrontController extends HttpServlet {

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String command = request.getServletPath();
		Action action = null;
		ActionForward forward = null;

		if (command.equals("/MemberLoginForm.me")) {
			forward = new ActionForward();
			forward.setPath("/member/login.jsp");
		} else if (command.equals("/Memberloginpro.me")) {
			action = new MemberLoginProAction();

			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				System.out.println("MemberFrontController - MemberLoginProAction - 오류" + e.getMessage());
			}
		} else if (command.equals("/main.me")) {
			forward = new ActionForward();
			forward.setPath("/main/main.jsp");
		} else if (command.equals("/MemberJoinForm.me")) {
			forward = new ActionForward();
			forward.setPath("/member/join.jsp");
		} else if (command.equals("/LogoutPro.me")) {
			action = new MemberLogoutProAction();

			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				System.out.println("MemberFrontController - MemberLogoutProAction - 오류" + e.getMessage());
			}
		} else if (command.equals("/MemberJoinPro.me")) {
			action = new MemberJoinProAction();

			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				System.out.println("MemberFrontController - MemberJoinProAction - 오류" + e.getMessage());
			}
		}else if (command.equals("/MemberUpdateForm.me")) {
			forward = new ActionForward();
			forward.setPath("/member/memberUpdateForm.jsp");

		} else if(command.equals("/MemberUpdatePro.me")) {
			action = new MemberUpdateProAction();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				System.out.println("MemberUpdatePro.me - 오류"+e.getMessage());
			}
		}else if(command.equals("/MemberCheckPro.me")) {
			action = new MemberCheckProAction();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				System.out.println("MemberCheckPro.me - 오류"+e.getMessage());
			}
		}

		if (forward != null) {
			if (forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
		}

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}
}
