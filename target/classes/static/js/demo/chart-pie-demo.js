// Set new default font family and font color to mimic Bootstrap's default styling
Chart.defaults.global.defaultFontFamily = 'Nunito', '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
Chart.defaults.global.defaultFontColor = '#858796';

// Pie Chart Example
var ctx = document.getElementById("myPieChart");
var myPieChart = new Chart(ctx, {
  type: 'doughnut',
  data: {
    labels: ["kcal", "Sugar", "Saturated_fat", "Caffeine", "Protein", "Sodium"],
    datasets: [{

      data: [perDay.drink_kcal, perDay.drink_sugar, perDay.drink_protein, perDay.drink_caffeine, perDay.drink_protein, perDay.drink_Sodium ],
      backgroundColor: ['#4e73df', '#1cc88a', '#36b9cc','#e74a3b','#f6c23e','#858796'],
      hoverBackgroundColor: ['#2e59d9', '#17a673', '#2c9faf','#e74a3b','#f6c23e','#858796'],
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
