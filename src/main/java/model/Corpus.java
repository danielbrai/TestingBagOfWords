package model;

import lombok.Getter;
import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

@Getter
public class Corpus {
	
	private List<Document> documents;
	private Collection<List<String>> wordsIn;
	private Collection<String> wordsOccurrences;
	
	public Corpus (List<Document> documents) {
		
		this.documents = documents;
		
		if (CollectionUtils.isNotEmpty( this.documents )) {
			
			this.wordsIn = new ArrayList<>();
			this.documents.forEach( document -> this.wordsIn.add( document.getWords() ) );
		} else {
			this.wordsIn = CollectionUtils.EMPTY_COLLECTION;
		}
		
		if (CollectionUtils.isNotEmpty( this.wordsIn )) {
			
			this.wordsOccurrences = new HashSet<>();
			
			this.wordsIn.forEach( wordsInDocument -> {
				this.wordsOccurrences.addAll( wordsInDocument );
			} );
		} else {
			this.wordsOccurrences = CollectionUtils.EMPTY_COLLECTION;
		}
	}
}
