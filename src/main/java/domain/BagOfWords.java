package domain;

import lombok.Builder;
import lombok.Getter;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

@Getter
@Builder
public class BagOfWords {

  private Corpus corpus;

  public void runProcess() {

    if (Objects.nonNull(this.corpus) && CollectionUtils.isNotEmpty(corpus.getWordsOccurrences()) && CollectionUtils.isNotEmpty(corpus.getDocuments())) {

      corpus.getDocuments().forEach(document -> {

        document.setBagOfWords(new HashMap<>());

        corpus.getWordsOccurrences().forEach(wordKey -> {
          document.getBagOfWords().put(wordKey, 0L);
        });

        document.getWords().forEach(word -> {
          if (document.getBagOfWords().containsKey(word)) {
            document.getBagOfWords().put(word, document.getBagOfWords().get(word) + 1L);
          } else {
            document.getBagOfWords().put(word, 1L);
          }
        });

      });
    }
  }

  public String printResult() {

    List<String> resultList = getFormattedOccurrenceRatePerDocument();

    if (CollectionUtils.isNotEmpty(resultList)) {

      StringBuilder result = new StringBuilder();

      resultList.forEach(entry -> {
        result.append(entry).append("\n");
      });

      return result.toString();
    } else {
      return StringUtils.EMPTY;
    }

  }

  private List<String> getFormattedOccurrenceRatePerDocument() {
    List<String> resultList = new ArrayList<>();

    if (Objects.nonNull(this.corpus) && CollectionUtils.isNotEmpty(this.corpus.getDocuments())) {

      this.corpus.getDocuments().forEach(document -> {

        StringBuilder key = new StringBuilder();

        if (MapUtils.isNotEmpty(document.getBagOfWords())) {

          document.getBagOfWords().forEach((word, occurrence) -> {
            key.append("\t|\t").append(occurrence).append("\t-\t").append(word);
          });
        }

        resultList.add(key.toString());

      });
    }
    return resultList;
  }
}
