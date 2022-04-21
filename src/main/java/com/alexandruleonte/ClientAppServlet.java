package com.alexandruleonte;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns={"/admin/*", "/login", "/register"})
public class ClientAppServlet  extends HttpServlet {

	private static final long serialVersionUID = -5029846353678666258L;

	@Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher rd = request.getRequestDispatcher("/client-app/index.html");
        rd.forward(request, response);
    }
}
