package app;

import domain.BagOfWords;
import domain.Corpus;
import domain.Document;
import service.BagOfWordsService;

import java.util.Arrays;

public class Main {

  public static void main(String[] args) {

    BagOfWordsService bagOfWordsService = new BagOfWordsService();

    String entryA = "Bag of Words (BoW) is a domain used in natural language processing. One aim of BoW is to categorize documents. The idea is to analyse and classify different “bags of words” (corpus). And by matching the different categories, we identify which “bag” a certain block of text (domain data) comes from.";
    String entryB = "Bag of Words (BoW) is an algorithm that counts how many times a word appears in a document. Those word counts allow us to compare documents and gauge their similarities for applications like search, document classification and topic modeling. BoW is a method for preparing text for input in a deep-learning net. BoW lists words with their word counts per document. In the table where the words and documents effectively become vectors are stored, each row is a word, each column is a document and each cell is a word count. Each of the documents in the corpus is represented by columns of equal length. Those are wordcount vectors, an output stripped of context.";

    BagOfWords bagOfWords = bagOfWordsService.getCorpusFrom( Arrays.asList( entryA, entryB ) );

    System.out.println(bagOfWords.printResult());
  }
}
