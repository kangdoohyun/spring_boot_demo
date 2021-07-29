package com.example.demo.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

public class ScriptUtil {
	public static void init(HttpServletResponse response) {
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
	}

	public static void alert(HttpServletResponse response, String text) {
		init(response);
		try {
			PrintWriter out = response.getWriter();
			out.println("<script>alert('" + text + "');</script> ");
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void locationReplace(HttpServletResponse response, String text, String replace) {
		init(response);
		try {
			PrintWriter out = response.getWriter();
			out.println("<script>alert('" + text + "'); location.href='" + replace + "';</script> ");
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void historyBack(HttpServletResponse response, String text) {
		init(response);
		try {
			PrintWriter out = response.getWriter();
			out.println("<script>alert('" + text + "'); history.back();</script>");
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
