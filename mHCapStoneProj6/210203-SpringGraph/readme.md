### Spring Boot Google Pie Graph

210203SpringGraph.png <img src="210203SpringGraph.png">

---
## Just only Pie Chart
#### GoogleChartsController.java
``` java
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class GoogleChartsController {

    @GetMapping("/")
    public String getPieChart(Model model) {
        Map<String, Integer> graphData = new TreeMap<>();
        graphData.put("2016", 147);
        graphData.put("2017", 1256);

        model.addAttribute("chartData", graphData);
        return "google-charts";
    }
```
#### google-charts.html
``` html
<title>Google Charts Example - Spring Boot</title>
<script
    src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<link rel="stylesheet"
    href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script type="text/javascript"
    src="https://www.gstatic.com/charts/loader.js"></script>
</head>
<body>
    <div align="center" style="width: 1000px;">
        <h2>Spring Boot Google Pie Charts Example</h2>

        <div id="piechart" style="width: 450px; height: 250px;"></div>

    </div>
    <script th:inline="javascript">
        var real_data = /*[[${chartData}]]*/'noValue';
 
        $(document).ready(function() {
            google.charts.load('current', {
                packages : [ 'corechart', 'bar' ]
            });

            google.charts.setOnLoadCallback(drawPieChart);
        });
 
        function drawPieChart() {
            var data = new google.visualization.DataTable();
            data.addColumn('string', 'Year');
            data.addColumn('number', 'Views');
            Object.keys(real_data).forEach(function(key) {
                data.addRow([ key, real_data[key] ]);
            });
            var options = {
                title : 'Blog stats'
            };
            var chart = new google.visualization.PieChart(document
                    .getElementById('piechart'));
            chart.draw(data, options);
        }
        
```
