package edu.dartmouth.cs.meterd;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.dartmouth.cs.meterd.data.ParkingSpot;
import edu.dartmouth.cs.meterd.data.ParkingSpotDatastore;

/**
 * Created by noel on 4/16/16.
 */
public class UpdateServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {
        Double lat = Double.parseDouble(req.getParameter("lat"));
        Double lng = Double.parseDouble(req.getParameter("long"));
        Long end = Long.parseLong(req.getParameter("end"));
        ParkingSpot pp = new ParkingSpot(lng,lat,"",(long)0,(long)0,(long)0,"",true,(long)0,end);
        ParkingSpotDatastore.update(pp);
        resp.sendRedirect("/query.do");
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {
        doGet(req, resp);
    }
}