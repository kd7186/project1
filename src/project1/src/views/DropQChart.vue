<template>
  <div>
    <p>{{ this.index + 1 }}번 질문</p>
    <canvas ref="barChart" :height="'400px'" />
    <br />
  </div>
</template>

<script>
import { Chart, registerables } from "chart.js";
import { mapState } from "vuex";
Chart.register(...registerables);
let chart;
export default {
  props: ["index", "answers", "count"],
  data() {
    return {
      chartData: {
        labels: this.answers,
        datasets: [
          {
            label: "data",
            data: this.count,
            backgroundColor: ["rgba(255, 99, 132, 0.2)"],
            borderColor: ["rgba(255, 99, 132, 1)"],
            borderWidth: 1,
          },
        ],
      },
      options: {
        responsive: false,
        scales: {
          y: {
            beginAtZero: true,
          },
        },
      },
    };
  },
  async mounted() {
    this.$nextTick(function () {
      this.createChart();
    });
  },
  computed: {
    ...mapState(["Response"]),
  },
  methods: {
    createChart() {
      if (chart !== undefined) {
        chart.destroy();
      }
      chart = new Chart(this.$refs.barChart, {
        type: "line",
        data: this.chartData,
        options: this.options,
      });
    },
  },
};
</script>