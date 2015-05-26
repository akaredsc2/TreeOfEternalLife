package servlets;

import manage.PersonCreator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CreationServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }

    private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PersonCreator personCreator = new PersonCreator(request.getParameterMap());

        String result = personCreator.retrieve().toString();

        if (result != null) {
            request.setAttribute("username", result);
            getServletContext().getRequestDispatcher("/home.jsp").forward(request, response);
        } else {
            request.setAttribute("username", "failed");
            getServletContext().getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }
}