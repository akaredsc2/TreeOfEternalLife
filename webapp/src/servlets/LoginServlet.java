package servlets;

import user.HardcodedUserList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginServlet extends javax.servlet.http.HttpServlet {
    private HardcodedUserList userList;

    @Override
    public void init() throws ServletException {
        super.init();
        this.userList = new HardcodedUserList();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }

    private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String command = request.getParameter("command");

        switch (command) {
            case "login": {
                String username = request.getParameter("username");
                String password = request.getParameter("password");

                if (userList.authenticate(username, password)) {
                    HttpSession session = request.getSession();

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