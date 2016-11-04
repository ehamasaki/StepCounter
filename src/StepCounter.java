
public class StepCounter {
	public static void main(String[] args) {

	}

	public static int peakCounter(double[] peaks, double avg, double deviation) {
		double BIG_ENOUGH_THRESHOLD = avg + deviation;
		int peakCount = 0;
		for (int i = 1; i < peaks.length - 1; i++) {
			if (peaks[i] > BIG_ENOUGH_THRESHOLD)

				;
			peakCount++;
		}
		return peakCount;

	}

	public static double[] peakvalues(double[] mags) {
		double[] peaks = new double[mags.length];
		int nextcounter = 0;
		for (int i = 1; i < mags.length - 1; i++) {
			if (mags[i] > mags[i - 1] && mags[i] > mags[i + 1]) {
				peaks[nextcounter] = mags[i];
			}
			nextcounter++;
		}
		return peaks;
	}

	public static int[] splitArray(double[] peaks) {

		int[] splitSections = new int[peaks.length];
		int nextFree = 1;

		splitSections[0] = 0;

		for (int i = 1; i < peaks.length; i++) {
			if (peaks[i] < peaks[i - 1] + 2 || peaks[i] > peaks[i - 1] - 2) {
				splitSections[nextFree] = i;
				nextFree++;
			}
		}
		return splitSections;
	}

	public static int sectionArray(int[] splitSections, double[] peaks) {
		int allsteps = 0;
		for (int i = splitSections[0]; i < splitSections.length; i++) {
			double[] arraysplitvalues = new double[peaks.length];
			double avg = NaiveStepCountingAlgorithm.mean(peaks, splitSections[i], splitSections[i + 1]);
			double standarddeviation = NaiveStepCountingAlgorithm.standardDeviationCalculator(peaks, avg,
					splitSections[i], splitSections[i + 1]);
			int steps = peakCounter(peaks, avg, standarddeviation);
			allsteps = +steps;

		}
		return allsteps;

	}

}
