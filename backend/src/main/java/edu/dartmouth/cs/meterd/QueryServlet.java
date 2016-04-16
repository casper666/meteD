package edu.dartmouth.cs.meterd;

/**
 * Created by JaySha on 4/16/16.
 */

import com.google.appengine.labs.repackaged.org.json.JSONArray;
import com.google.appengine.labs.repackaged.org.json.JSONException;
import com.google.appengine.labs.repackaged.org.json.JSONObject;

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
        String name = req.getParameter("data");
//        System.out.print("---------->" + name);
        ArrayList<ParkingSpot> result = ParkingSpotDatastore.query(1.0, 2.0);

        System.out.printf("Number is %d\n", result.size());

        req.setAttribute("result", result);
//        // creating the final JSON string
//        JSONArray finalResult = new JSONArray();
//        for (ParkingSpot p : result) {
//            JSONObject curSpot = new JSONObject();
//            try {
//                curSpot.put("lat", p.getmLatitude());
//                curSpot.put("long",p.getmLongitude());
//                curSpot.put("start",p.getmOccupiedStartTime());
//                curSpot.put("end",p.getmOccupiedEndTime());
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }
//            finalResult.put(curSpot);
//        }
//        resp.setContentType("text");
//        resp.setCharacterEncoding("UTF-8");
//        resp.getWriter().write("Grader li diao bao le");

        getServletContext().getRequestDispatcher("/display.jsp").forward(
                req, resp);

    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {
        doGet(req, resp);
    }
}
