package com.andyadc.marketing.test.algorithm;

import java.util.Arrays;
import java.util.Random;

public class AliasMethodByGrok {
	private final double[] probabilities;  // Normalized probabilities
	private final int[] alias;            // Alias table
	private final double[] prob;          // Probability table
	private final Random random;
	private final int n;                  // Number of outcomes

	public AliasMethodByGrok(double[] inputProbabilities) {
		this.n = inputProbabilities.length;
		this.random = new Random();

		// Initialize arrays
		this.probabilities = new double[n];
		this.alias = new int[n];
		this.prob = new double[n];

		// Normalize probabilities if they don't sum to 1
		double sum = 0;
		for (double p : inputProbabilities) {
			sum += p;
		}

		// Copy and normalize input probabilities
		for (int i = 0; i < n; i++) {
			probabilities[i] = inputProbabilities[i] * n / sum;
		}

		// Create work lists for small and large probabilities
		int[] small = new int[n];
		int[] large = new int[n];
		int smallCount = 0;
		int largeCount = 0;

		// Initialize probability and alias tables
		for (int i = 0; i < n; i++) {
			if (probabilities[i] < 1.0) {
				small[smallCount++] = i;
			} else {
				large[largeCount++] = i;
			}
			prob[i] = probabilities[i];
			alias[i] = -1;
		}

		// Construct alias table
		while (smallCount > 0 && largeCount > 0) {
			int less = small[--smallCount];
			int more = large[--largeCount];

			prob[less] = probabilities[less];
			alias[less] = more;

			probabilities[more] = probabilities[more] + probabilities[less] - 1.0;

			if (probabilities[more] < 1.0) {
				small[smallCount++] = more;
			} else {
				large[largeCount++] = more;
			}
		}

		// Handle remaining items
		while (smallCount > 0) {
			prob[small[--smallCount]] = 1.0;
		}
		while (largeCount > 0) {
			prob[large[--largeCount]] = 1.0;
		}
	}

	// Example usage
	public static void main(String[] args) {
		// Example probabilities (don't need to sum to 1)
		double[] probs = {0.1, 0.3, 0.2, 0.4};
		AliasMethodByGrok sampler = new AliasMethodByGrok(probs);

		// Generate some samples
		int[] counts = new int[probs.length];
		int numSamples = 10000;

		for (int i = 0; i < numSamples; i++) {
			counts[sampler.sample()]++;
		}

		// Print results
		System.out.println("Sampling results:");
		for (int i = 0; i < probs.length; i++) {
			System.out.printf("Outcome %d: %.3f (expected %.3f)\n",
				i,
				(double) counts[i] / numSamples,
				probs[i] / Arrays.stream(probs).sum());
		}
	}

	// Sample from the distribution
	public int sample() {
		int column = random.nextInt(n);
		boolean coinToss = random.nextDouble() < prob[column];
		return coinToss ? column : alias[column];
	}

}
