package servlets;

import genealogyTree.Person;
import manage.PersonCreator;
import user.HardcodedUserList;
import user.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CreationServlet extends HttpServlet {
    private HardcodedUserList userList;//todo remove in lab 4. replace with dao

    @Override
    public void init() throws ServletException {
        super.init();
        this.userList = new HardcodedUserList();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }

    private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PersonCreator personCreator = new PersonCreator(request.getParameterMap());

        Person result = personCreator.retrieve();

        if (result != null) {
            final String username = (String) request.getSession().getAttribute("username");
            User user = userList.getByUsername(username);

            user.getTree().add(result);

            request.getSession().setAttribute("tree", user.getTree().getLeafs());//refactor mb? Definitely temp solution

            //todo remove it the fuck out!
            System.out.println(user.getTree());

            getServletContext().getRequestDispatcher("/home.jsp").forward(request, response);
        } else {
            getServletContext().getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }
}