<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="kr">
<head>

  <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
      <script type="text/javascript">
      google.charts.load('current', {packages: ['corechart', 'bar']});
google.charts.setOnLoadCallback(drawBasic);

function drawBasic() {

      var data = google.visualization.arrayToDataTable([
        ['City', 'POST'],
        ['2015', 35],
        ['2016', ${rank.count}],
      ]);

      var options = {
        title: 'QnA POST 2015/2016',
        chartArea: {width: '50%'},
        hAxis: {
          title: 'POST',
          minValue: 0
        },
        vAxis: {
          title: 'Year'
        }
      };

      var chart = new google.visualization.BarChart(document.getElementById('chart_div'));

      chart.draw(data, options);
    }
      </script>
      <style>
      svg{
        top : 200px;
      }
      </style>
</head>
<body>

<div id="chart_div" style="width: 900px; height: 500px;"></div>
<center><ul>
<c:forEach items="${teamRank}" var="each">
<li>
  ${each.team_id}팀 / ${each.count}개 포스트 작성.
</li>
</c:forEach>
</ul></center>
<%@ include file="/include/footer.jspf" %>
</body>
</html>
