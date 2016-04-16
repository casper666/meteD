<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<%@ page import="edu.dartmouth.cs.meterd.data.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

    <title>Dashboard Template for Bootstrap</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
          integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7"
          crossorigin="anonymous">

    <link href="dashboard.css" rel="stylesheet">
</head>

<body>

<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">MeteD</a>
        </div>
        <!--<div id="navbar" class="navbar-collapse collapse">-->
            <!--<ul class="nav navbar-nav navbar-right">-->
                <!--<li><a href="#">Dashboard</a></li>-->
                <!--<li><a href="#">Settings</a></li>-->
                <!--<li><a href="#">Profile</a></li>-->
                <!--<li><a href="#">Help</a></li>-->
            <!--</ul>-->
            <!--<form class="navbar-form navbar-right">-->
                <!--<input type="text" class="form-control" placeholder="Search...">-->
            <!--</form>-->
        <!--</div>-->
    </div>
</nav>

<div class="container-fluid">
    <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
            <ul class="nav nav-sidebar">
                <li class="active"><a href="#">Overview <span class="sr-only">(current)</span></a></li>
                <li><a href="#">Download</a></li>
                <!--<li><a href="#">Analytics</a></li>-->
                <!--<li><a href="#">Export</a></li>-->
            </ul>
            <!--<ul class="nav nav-sidebar">-->
                <!--<li><a href="">Nav item</a></li>-->
                <!--<li><a href="">Nav item again</a></li>-->
                <!--<li><a href="">One more nav</a></li>-->
                <!--<li><a href="">Another nav item</a></li>-->
                <!--<li><a href="">More navigation</a></li>-->
            <!--</ul>-->
            <!--<ul class="nav nav-sidebar">-->
                <!--<li><a href="">Nav item again</a></li>-->
                <!--<li><a href="">One more nav</a></li>-->
                <!--<li><a href="">Another nav item</a></li>-->
            <!--</ul>-->
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <h1 class="page-header">Members</h1>
            <div class="row placeholders">
                <div class="col-xs-6 col-sm-3 placeholder">
                    <img src="/pic/BeitongZhang.jpg" width="200" height="200" class="img-responsive" alt="Generic placeholder thumbnail">
                    <h4>Beitong Zhang</h4>
                    <span class="text-muted">DB Design/Server Infrastructure</span>
                </div>
                <div class="col-xs-6 col-sm-3 placeholder">
                    <img src="/pic/BinjieLi.jpg" width="200" height="200" class="img-responsive" alt="Generic placeholder thumbnail">
                    <h4>Binjie Li</h4>
                    <span class="text-muted">App Implementation</span>
                </div>
                <div class="col-xs-6 col-sm-3 placeholder">
                    <img src="/pic/WeiHuang.jpg" width="200" height="200" class="img-responsive" alt="Generic placeholder thumbnail">
                    <h4>Wei Huang</h4>
                    <span class="text-muted">Niubi</span>
                </div>
                <div class="col-xs-6 col-sm-3 placeholder">
                    <img src="/pic/JinzhengSha.jpg" width="200" height="200" class="img-responsive" alt="Generic placeholder thumbnail">
                    <h4>Jinzheng Sha</h4>
                    <span class="text-muted">Niubi</span>
                </div>
            </div>

            <h2 class="sub-header">Parking Spots List</h2>
            <div class="table-responsive">
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <!--<th>#</th>-->
                        <th>Longitude</th>
                        <th>Latitude</th>
                        <!--<th>IsOccupied</th>-->
                        <!--<th>OccupiedStartTime</th>-->
                        <th>OccupiedEndTime</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <form name="input" action="/add.do" method="post">
                            <td><input type="text" name="longitude"></td>
                            <td><input type="text" name="latitude"></td>
                            <td><input type="text" name="occupiedEndTime"></td>
                            <td><input type="submit" value="Add"></td>
                        </form>
                    </tr>
                    <%
                    ArrayList<ParkingSpot> resultList = (ArrayList<ParkingSpot>) request.getAttribute("result");
                        if (resultList != null) {
                        for (ParkingSpot parkingSpot : resultList) {
                        %>
                        <tr>
                            <form name="input" action="/update.do" method="post">
                                <td><input type="text" name="long" value=<%=parkingSpot.mLongitude%>></td>
                                <td><input type="text" name="lat" value=<%=parkingSpot.mLatitude%>></td>
                                <td><input type="text" name="end" value=<%=parkingSpot.mOccupiedEndTime%>></td>
                                <td><input type="submit" value="Update"></td>
                            </form>
                            <td><button onclick="window.location.href='/delete.do?lat=<%=parkingSpot.getmLatitude()%>&long=<%=parkingSpot.getmLongitude()%>'">Delete</button></td>
                        </tr>
                        <%
                        }
                        }
                        %>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
</body>