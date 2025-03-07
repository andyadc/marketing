package com.andyadc.marketing.test.algorithm;

import java.util.Random;

public class AliasMethodByChatGPT {
	private final int[] alias;
	private final double[] probability;
	private final Random random;

	public AliasMethodByChatGPT(double[] probabilities) {
		int n = probabilities.length;
		this.alias = new int[n];
		this.probability = new double[n];
		this.random = new Random();

		double[] scaledProb = new double[n];
		int[] small = new int[n];
		int[] large = new int[n];
		int smallIdx = 0, largeIdx = 0;

		// Scale probabilities by n
		for (int i = 0; i < n; i++) {
			scaledProb[i] = probabilities[i] * n;
			if (scaledProb[i] < 1.0) {
				small[smallIdx++] = i;
			} else {
				large[largeIdx++] = i;
			}
		}

		// Create the alias table
		while (smallIdx > 0 && largeIdx > 0) {
			int smallIndex = small[--smallIdx];
			int largeIndex = large[--largeIdx];

			probability[smallIndex] = scaledProb[smallIndex];
			alias[smallIndex] = largeIndex;

			scaledProb[largeIndex] = (scaledProb[largeIndex] + scaledProb[smallIndex]) - 1.0;

			if (scaledProb[largeIndex] < 1.0) {
				small[smallIdx++] = largeIndex;
			} else {
				large[largeIdx++] = largeIndex;
			}
		}

		// Assign remaining probabilities
		while (largeIdx > 0) {
			probability[large[--largeIdx]] = 1.0;
		}
		while (smallIdx > 0) {
			probability[small[--smallIdx]] = 1.0;
		}
	}

	public static void main(String[] args) {
		double[] probabilities = {0.1, 0.2, 0.3, 0.4}; // Must sum to 1
		AliasMethodByChatGPT aliasMethod = new AliasMethodByChatGPT(probabilities);

		int trials = 1000000;
		int[] counts = new int[probabilities.length];

		for (int i = 0; i < trials; i++) {
			int sample = aliasMethod.sample();
			counts[sample]++;
		}

		// Print estimated probabilities
		for (int i = 0; i < counts.length; i++) {
			System.out.printf("Value %d: %.4f%n", i, (double) counts[i] / trials);
		}
	}

	public int sample() {
		int column = random.nextInt(probability.length);
		boolean coinToss = random.nextDouble() < probability[column];
		return coinToss ? column : alias[column];
	}

}
