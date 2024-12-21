import org.knowm.xchart.*;
import org.knowm.xchart.style.markers.SeriesMarkers;

import java.util.ArrayList;
import java.util.List;

public class RungeKuttagraph {

    // Function to calculate dy/dx = sin(2x) - y * tan(x)
    public static double f(double x, double y) {
        return Math.sin(2 * x) - y * Math.tan(x);
    }

    public static void main(String[] args) {
        // Initial conditions
        double x0 = 0;      // Initial x
        double y0 = 1;      // Initial y
        double h = 0.1;     // Step size
        int steps = 50;     // Number of steps

        // Lists to store x and y values
        List<Double> xValues = new ArrayList<>();
        List<Double> yValues = new ArrayList<>();

        // Add initial values
        xValues.add(x0);
        yValues.add(y0);

        // Runge-Kutta 4th Order Method
        for (int i = 0; i < steps; i++) {
            double k1 = h * f(x0, y0);
            double k2 = h * f(x0 + h / 2, y0 + k1 / 2);
            double k3 = h * f(x0 + h / 2, y0 + k2 / 2);
            double k4 = h * f(x0 + h, y0 + k3);

            // Update y and x
            y0 = y0 + (k1 + 2 * k2 + 2 * k3 + k4) / 6;
            x0 = x0 + h;

            // Store the new values
            xValues.add(x0);
            yValues.add(y0);
        }

        // Print output
        System.out.println("x-values\t y-values");
        for (int i = 0; i < xValues.size(); i++) {
            System.out.printf("%.2f\t\t %.5f\n", xValues.get(i), yValues.get(i));
        }

        // Plot the graph
        plotGraph(xValues, yValues);
    }

    // Function to plot the graph using XChart
    public static void plotGraph(List<Double> xData, List<Double> yData) {
        XYChart chart = new XYChartBuilder()
                .width(800)
                .height(600)
                .title("Runge-Kutta 4th Order Method")
                .xAxisTitle("x")
                .yAxisTitle("y")
                .build();

        // Customize the chart
        XYSeries series = chart.addSeries("y vs x", xData, yData);
        series.setMarker(SeriesMarkers.CIRCLE);

        // Show the chart
        new SwingWrapper<>(chart).displayChart();
    }
}