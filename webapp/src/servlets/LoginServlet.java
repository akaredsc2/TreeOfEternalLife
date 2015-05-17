package servlets;

import user.HardcodedUserList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
        final String username = request.getParameter("username");
        final String password = request.getParameter("password");

        if(userList.authentiticate(username, password)) {
            request.setAttribute("username", username);
            getServletContext().getRequestDispatcher("/mypage.jsp").forward(request, response);
        } else {
            getServletContext().getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }
}