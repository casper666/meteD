package edu.dartmouth.cs.meterd;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.dartmouth.cs.meterd.data.ParkingSpot;
import edu.dartmouth.cs.meterd.data.ParkingSpotDatastore;

/**
 * Created by JaySha on 4/16/16.
 */
public class AddServlet extends HttpServlet{

    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {
        String longitude = req.getParameter("longitude");
        String latitude = req.getParameter("latitude");
        String streetName = req.getParameter("streetName");
        String dailyFreeParkingStartTime = req.getParameter("dailyFreeParkingStartTime");
        String dailyFreeParkingEndTime = req.getParameter("dailyFreeParkingEndTime");
        String hourlyFee = req.getParameter("hourlyFee");
        String freeDays = req.getParameter("freeDays");
        String isOccupied = req.getParameter("isOccupied");
        String occupiedStartTime = req.getParameter("occupiedStartTime");
        String occupiedEndTime = req.getParameter("occupiedEndTime");

        if (longitude == null || longitude.equals("") || latitude == null || latitude.equals("")) {
            req.setAttribute("_retStr", "invalid input");
            getServletContext().getRequestDispatcher("/query_result.jsp")
                    .forward(req, resp);
            return;
        }


        System.out.printf("\n\nlongitude is %s, latitude is %s\n\n", longitude, latitude);

        ParkingSpot parkingSpot = new ParkingSpot(Float.parseFloat(longitude), Float.parseFloat(latitude), streetName,
                Integer.parseInt(dailyFreeParkingStartTime), Integer.parseInt(dailyFreeParkingEndTime),
                Float.parseFloat(hourlyFee), freeDays, Boolean.parseBoolean(isOccupied),
                Integer.parseInt(occupiedStartTime), Integer.parseInt(occupiedEndTime));

        boolean ret = ParkingSpotDatastore.add(parkingSpot);

        if (ret) {
            req.setAttribute("_retStr", "Add parkingSpot " + longitude + "+" + latitude + " succ");
            MessagingEndpoint msg = new MessagingEndpoint();
            msg.sendMessage("Added");

            ArrayList<ParkingSpot> result = new ArrayList<ParkingSpot>();
            result.add(parkingSpot);
            req.setAttribute("result", result);
        } else {
            req.setAttribute("_retStr", longitude + "+" + latitude + " exists");
        }

        getServletContext().getRequestDispatcher("/query_result.jsp").forward(
                req, resp);
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {
        doGet(req, resp);
    }
}
