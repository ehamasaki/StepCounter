import java.util.Arrays;

public class NaiveStepCountingAlgorithm {

	public static void main(String[] args) {
		String names = "time (ms),  accel x,  accel y,  accel z,  gryo x,  gyro y,  gyro z";
		String[] columnNames = names.split(",");
		CSVData data = new CSVData("data/walkingSampleData-out.csv", columnNames, 1);

		double[] xAccelData = data.getColumn(1);
		double[] yAccelData = data.getColumn(2);
		double[] zAccelData = data.getColumn(3);

		double[] mags = vectorMagnitude(xAccelData, yAccelData, zAccelData);
		double BIG_ENOUGH_THRESHOLD = standardDeviationCalculator(mags, mean(mags));

		System.out.println(StepCounter.peakCounter(mags));

		System.out.println(BIG_ENOUGH_THRESHOLD);

		System.out.println(mean(mags));

	}

	public static double[] vectorMagnitude(double[] xAccelData, double[] yAccelData, double[] zAccelData) {

		double[] output = new double[xAccelData.length];

		for (int i = 0; i < xAccelData.length; i++) {
			output[i] = Math.sqrt((xAccelData[i] * xAccelData[i]) + (yAccelData[i] * yAccelData[i])
					+ (zAccelData[i] * zAccelData[i]));
		}

		// System.out.println(Arrays.toString(output));
		// System.out.println(output.length);

		return output;
	}

	public static double standardDeviationCalculator(double[] mags, double avg) {

		double sum = 0;

		for (int i = 0; i < mags.length; i++) {
			double difference = mags[i] - avg;
			double squared = difference * difference;
			sum += squared;
		}
		// System.out.println("Sum 1 " + sum);
		double answer = Math.sqrt(sum / (mags.length - 1));
		return answer;
	}

	public static double mean(double[] mags, int startvalue, int endvalue) {
		double [] values = new double[endvalue];
		int nextcount =0;
		for(int i =startvalue; i < endvalue; i++){
			values[nextcount] = mags[i];
		nextcount++;
	}
		double sum = 0, avg = 0;

		for (int i = 0; i < values.length; i++) {
			sum += values[i];
		}

		avg = sum / values.length;

		return avg;
	}
}
