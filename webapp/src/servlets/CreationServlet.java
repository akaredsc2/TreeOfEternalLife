package servlets;

import genealogyTree.Person;
import manage.PersonCreator;
import user.User;
import user.UserManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CreationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            process(request, response);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            process(request, response);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException {
        final String username = (String) request.getSession().getAttribute("username");

        PersonCreator personCreator = new PersonCreator(request.getParameterMap(), username);

        Person result = personCreator.parsePerson();

        if (result != null) {
            UserManager userManager = new UserManager();
            User user = userManager.getByName(username);

            request.getSession().setAttribute("tree", user.getTree().getLeafs());
            getServletContext().getRequestDispatcher("/home.jsp").forward(request, response);
        } else {
            getServletContext().getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }
}