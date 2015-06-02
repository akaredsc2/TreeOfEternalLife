package servlets;

import user.User;
import user.UserManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginServlet extends javax.servlet.http.HttpServlet {
    private UserManager userManager;

    @Override
    public void init() throws ServletException {
        super.init();
        this.userManager = new UserManager();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            process(request, response);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            process(request, response);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException {
        String command = request.getParameter("command");

        switch (command) {
            case "login": {
                String username = request.getParameter("username");
                String password = request.getParameter("password");

                User potentialUser = new User(username, password);

                if (userManager.authenticate(potentialUser)) {
                    HttpSession session = request.getSession();

                    //todo put full user into session mb?
                    session.setAttribute("username", username);
                    getServletContext().getRequestDispatcher("/home.jsp").forward(request, response);
                } else {
                    getServletContext().getRequestDispatcher("/error.jsp").forward(request, response);
                }
                break;
            }
            case "logout": {
                request.getSession().invalidate();
                getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
                break;
            }
            default:{
                getServletContext().getRequestDispatcher("/error.jsp").forward(request, response);
                break;
            }
        }
    }
}