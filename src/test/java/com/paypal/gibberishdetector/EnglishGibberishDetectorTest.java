package com.paypal.gibberishdetector;

import org.junit.Assert;
import org.junit.Test;

import com.paypal.gibberishdetector.GibberishDetector;
import com.paypal.gibberishdetector.GibberishDetectorExtended;
import com.paypal.gibberishdetector.GibberishDetectorFactory;

public class EnglishGibberishDetectorTest {
	
	private String[] goodEnglishSentences = {"John", "Kathy", "Jane", "Elizabeth"};
//	private String[] badEnglishSentences = {"2 chhsdfitoixcv", "fasdf asg ggd fhgkv", "qmdu poebc vuutkl jsupwre"};
	private static final String alphabet = "abcdefghijklmnopqrstuvwxyz ";

	private static GibberishDetectorFactory factory = new GibberishDetectorFactory(GibberishDetectorExtended.class);
	
	GibberishDetector gibberishDetector = factory.createGibberishDetectorFromLocalFile2("en-training-data.txt",
			"en-good-names.txt", "badEnglish.txt", "en-alphabet.txt");
		
	@Test
	public void gibberishDetectorGoodEnglishTest() {
		for (String line : goodEnglishSentences) {
			if(gibberishDetector.isGibberish(line)){
				System.out.println("FAILURE AT LINE: "+line);
			}
			Assert.assertEquals(false, gibberishDetector.isGibberish(line));
		}		
	}

//	@Test
//	public void gibberishDetectorBadEnglishTest() {
//		for (String line : badEnglishSentences) {
//			Assert.assertEquals(true, gibberishDetector.isGibberish(line));
//		}		
//	}

	@Test
	public void randomGibberishTest() {
		GibberishDetectorTestUtils.randomGibberishTest(alphabet, gibberishDetector);
	}
}
