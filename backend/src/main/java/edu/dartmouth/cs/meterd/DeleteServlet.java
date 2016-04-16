package edu.dartmouth.cs.meterd;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import edu.dartmouth.cs.meterd.data.ParkingSpotDatastore;

/**
 * Created by noel on 4/16/16.
 */
public class DeleteServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {
        Double lat = Double.parseDouble(req.getParameter("lat"));
        Double lng = Double.parseDouble(req.getParameter("long"));
        ParkingSpotDatastore.delete(lat, lng);
        resp.sendRedirect("/query.do");
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {
        doGet(req, resp);
    }
}