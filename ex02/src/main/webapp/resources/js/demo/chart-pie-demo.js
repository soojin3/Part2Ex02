// Set new default font family and font color to mimic Bootstrap's default styling
Chart.defaults.global.defaultFontFamily = 'Nunito', '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
Chart.defaults.global.defaultFontColor = '#858796';

// Pie Chart Example
var ctx = document.getElementById("myPieChart");
//var mylabels=["관리자","글쓴이","3교시","테스트","홍길동"];
//var mydata=[100,200,300,400,500];
var myPieChart = new Chart(ctx, {
  type: 'doughnut',
  data: {
    labels: mylabels,
    datasets: [{
      data: mydata,
      backgroundColor: ['#079aff', '#50b0ff', '#8ccafa','#bfe5f8','#7f9de5'],
      hoverBackgroundColor: ['#553544', '#714556', '#9f616d','#da8e86','#dfb699'],
      hoverBorderColor: "rgba(234, 236, 244, 1)",
    }],
  },
  options: {
    maintainAspectRatio: false,
    tooltips: {
      backgroundColor: "rgb(255,255,255)",
      bodyFontColor: "#858796",
      borderColor: '#dddfeb',
      borderWidth: 1,
      xPadding: 15,
      yPadding: 15,
      displayColors: false,
      caretPadding: 10,
    },
    legend: {
      display: false
    },
    cutoutPercentage: 80,
  },
});
