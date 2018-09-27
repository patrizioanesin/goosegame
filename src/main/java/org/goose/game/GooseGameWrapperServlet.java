package org.goose.game;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * /players/add     name=pippo
 * /players/{name}/rolls    dice1=5   dice2=4       (opzionali)
 */
public class GooseGameWrapperServlet extends HttpServlet {
    private GooseGame goose = new GooseGame();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // names.add(req.getParameter("name"));
        System.out.println("requst - " + req.getPathInfo());
        String x = req.getPathInfo();

        if (req.getPathInfo().equals("/players/add")) {


            write(resp, goose.add(new Player(req.getParameter("name"))));
        } else {
            write(resp, goose.userWrite("move Pippo 5, 4"));
        }

    }

    private void write(HttpServletResponse resp, String message) throws IOException {
        resp.getWriter().write(message);
    }
}
