package service;

import domain.BagOfWords;
import domain.Corpus;
import domain.Document;
import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

public class BagOfWordsService {

  public BagOfWords getCorpusFrom( List<String> entries ) {

    List<Document> documentList = new ArrayList<>();
    Corpus corpus = null;

    if( CollectionUtils.isNotEmpty( entries ) ) {
      entries.forEach( entry -> {
        Document document = new Document( entry );
        documentList.add( document );
      } );
    }

    if( CollectionUtils.isNotEmpty( documentList ) ) {
      corpus = new Corpus( documentList );
    }

    BagOfWords bagOfWords = BagOfWords.builder().corpus( corpus ).build();
    bagOfWords.runProcess();
    return bagOfWords;
  }
}
