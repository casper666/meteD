<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<%@ page import="edu.dartmouth.cs.meterd.data.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Query Result</title>
</head>
<body>
	<%
		String retStr = (String) request.getAttribute("_retStr");
		if (retStr != null) {
	%>
	<%=retStr%><br>
	<%
		}
	%>
	<center>
		<b>Query Result</b>
		<form name="input" action="/query.do" method="get">
			Name: <input type="text" name="name"> <input type="submit"
				value="OK">
		</form>
	</center>
	<b>
		---------------------------------------------------------------------<br>
		<%
			ArrayList<ParkingSpot> resultList = (ArrayList<ParkingSpot>) request
					.getAttribute("result");
			if (resultList != null) {
				for (ParkingSpot parkingSpot : resultList) {
		%> Longitude:<%=parkingSpot.mLongitude%>&nbsp; Latitude:<%=parkingSpot.mLatitude%>&nbsp;
		StreetName:<%=parkingSpot.mStreetName%>&nbsp; &nbsp;&nbsp; <a
		href="/delete.do?name=<%=parkingSpot.mLongitude%>">delete</a> <br> <%
 	}
 	}
 %>
		---------------------------------------------------------------------<br>
	</b> Add new ParkingSpot:
	<br>
	<form name="input" action="/add.do" method="post">
		Longitude: <input type="text" name="longitude">
		Latitude: <input type="text" name="latitude">
		StreetName: <input type="text" name="streetName">
		DailyFreeParkingStartTime: <input type="text" name="dailyFreeParkingStartTime">
		DailyFreeParkingEndTime: <input type="text" name="dailyFreeParkingEndTime">
		HourlyFee: <input type="text" name="hourlyFee">
		FreeDays: <input type="text" name="freeDays">
		IsOccupied: <input type="text" name="isOccupied">
		OccupiedStartTime: <input type="text" name="occupiedStartTime">
		OccupiedEndTime: <input type="text" name="occupiedEndTime">
		<input type="submit" value="Add">
	</form>
	---------------------------------------------------------------------
	<br>
	<form name="input" action="/update.do" method="post">
		Name: <input type="text" name="name">
		Address: <input type="text" name="addr">
		Phone: <input type="text" name="phone">
		<input type="submit" value="Update">
	</form>
</body>
</html>