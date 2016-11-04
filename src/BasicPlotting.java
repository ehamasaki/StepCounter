import java.util.Arrays;
import java.util.Random;
import javax.swing.JFrame;
import org.math.plot.Plot2DPanel;

public class BasicPlotting {
	public static void main(String[] args) {
		int size = 100;
		String names = "time (ms),  accel x,  accel y,  accel z,  gryo x,  gyro y,  gyro z, linear accel x,  linear accel y,  linear accel z,  orientation x,  orientation y,  orientation z";
		String[] columnNames = names.split(",");
		
		CSVData data = new CSVData ("data/walkingSampleData-out.txt", columnNames, 1);
	
		
		Plot2DPanel plot = new Plot2DPanel();
		plot.addLinePlot("data", data.getRow(0));
		
		
		// put the PlotPanel in a JFrame, as a JPanezl
		JFrame frame = new JFrame("Results");
		frame.setSize(800, 600);
		frame.setContentPane(plot);
		frame.setVisible(true);
		
	}
}
