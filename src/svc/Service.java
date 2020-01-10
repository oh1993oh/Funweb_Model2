package svc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.ActionForward;

public interface Service {
	ActionForward execute(HttpServletRequest request, HttpServletResponse response)throws Exception;
}
