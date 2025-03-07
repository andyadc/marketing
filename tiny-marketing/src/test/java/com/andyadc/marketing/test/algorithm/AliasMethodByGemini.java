package com.andyadc.marketing.test.algorithm;

import java.util.Arrays;
import java.util.Random;

public class AliasMethodByGemini {

	private final int[] alias;
	private final double[] prob;
	private final Random random;

	public AliasMethodByGemini(double[] probabilities) {
		if (probabilities == null || probabilities.length == 0) {
			throw new IllegalArgumentException("Probabilities array cannot be null or empty.");
		}

		int n = probabilities.length;
		alias = new int[n];
		prob = new double[n];
		random = new Random();

		normalizeProbabilities(probabilities);
		initializeAliasTable(probabilities);
	}

	public static void main(String[] args) {
		double[] probabilities = {0.1, 0.5, 0.4};
		AliasMethodByGemini aliasMethod = new AliasMethodByGemini(probabilities);

		int[] counts = new int[probabilities.length];
		int numSamples = 100000;

		for (int i = 0; i < numSamples; i++) {
			int sample = aliasMethod.next();
			counts[sample]++;
		}

		System.out.println("Counts:");
		for (int i = 0; i < probabilities.length; i++) {
			System.out.println("Index " + i + ": " + counts[i]);
		}

		System.out.println("\nExpected Proportions:");
		for (double p : probabilities) {
			System.out.println(p);
		}

		System.out.println("\nCalculated Proportions:");
		for (int count : counts) {
			System.out.println((double) count / numSamples);
		}
	}

	private void normalizeProbabilities(double[] probabilities) {
		double sum = 0;
		for (double p : probabilities) {
			sum += p;
		}

		if (sum == 0) {
			Arrays.fill(probabilities, 1.0 / probabilities.length);
		} else {
			for (int i = 0; i < probabilities.length; i++) {
				probabilities[i] /= sum;
			}
		}
	}

	private void initializeAliasTable(double[] probabilities) {
		int n = probabilities.length;
		double[] scaledProbabilities = new double[n];
		int[] small = new int[n];
		int[] large = new int[n];

		for (int i = 0; i < n; i++) {
			scaledProbabilities[i] = probabilities[i] * n;
		}

		int smallPtr = 0;
		int largePtr = 0;

		for (int i = 0; i < n; i++) {
			if (scaledProbabilities[i] < 1.0) {
				small[smallPtr++] = i;
			} else {
				large[largePtr++] = i;
			}
		}

		while (smallPtr > 0 && largePtr > 0) {
			int smallIndex = small[--smallPtr];
			int largeIndex = large[--largePtr];

			prob[smallIndex] = scaledProbabilities[smallIndex];
			alias[smallIndex] = largeIndex;

			scaledProbabilities[largeIndex] = scaledProbabilities[largeIndex] + scaledProbabilities[smallIndex] - 1.0;

			if (scaledProbabilities[largeIndex] < 1.0) {
				small[smallPtr++] = largeIndex;
			} else {
				large[largePtr++] = largeIndex;
			}
		}

		while (smallPtr > 0) {
			prob[small[--smallPtr]] = 1.0;
		}

		while (largePtr > 0) {
			prob[large[--largePtr]] = 1.0;
		}
	}

	public int next() {
		int column = random.nextInt(alias.length);
		double coinToss = random.nextDouble();

		if (coinToss < prob[column]) {
			return column;
		} else {
			return alias[column];
		}
	}

}
