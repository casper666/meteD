package edu.dartmouth.cs.meterd;

/**
 * Created by JaySha on 4/16/16.
 */

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.dartmouth.cs.meterd.data.ParkingSpot;
import edu.dartmouth.cs.meterd.data.ParkingSpotDatastore;

public class QueryServlet extends HttpServlet{

    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {
        String name = req.getParameter("name");
        ArrayList<ParkingSpot> result = ParkingSpotDatastore.query(1.0, 2.0);
        req.setAttribute("result", result);
        getServletContext().getRequestDispatcher("/query_result.jsp").forward(
                req, resp);
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {
        doGet(req, resp);
    }
}
