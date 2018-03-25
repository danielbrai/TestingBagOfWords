package app;

import model.BagOfWords;
import model.Corpus;
import model.Document;

import java.util.Arrays;

public class Main {
	
	public static void main (String[] args) {
		
		Document documentA = new Document( "Bag of Words (BoW) is a model used in natural language processing. One aim of BoW is to categorize documents. The idea is to analyse and classify different “bags of words” (corpus). And by matching the different categories, we identify which “bag” a certain block of text (model data) comes from." );
		Document documentB = new Document( "Bag of Words (BoW) is an algorithm that counts how many times a word appears in a document. Those word counts allow us to compare documents and gauge their similarities for applications like search, document classification and topic modeling. BoW is a method for preparing text for input in a deep-learning net. BoW lists words with their word counts per document. In the table where the words and documents effectively become vectors are stored, each row is a word, each column is a document and each cell is a word count. Each of the documents in the corpus is represented by columns of equal length. Those are wordcount vectors, an output stripped of context." );
		
		Corpus corpus = new Corpus( Arrays.asList( documentA, documentB ) );
		
		BagOfWords bagOfWords = BagOfWords.builder().corpus( corpus ).build();
		
		bagOfWords.runProcess();
		System.out.println(bagOfWords.printResult());
	}
}
