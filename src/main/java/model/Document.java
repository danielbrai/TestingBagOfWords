package model;

import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Getter
public class Document {
	
	private final String entry;
	private List<String> words;
	
	@Setter
	private Map<String, Long> bagOfWords;
	
	public Document (String entry) {
		this.entry = entry;
		this.words = this.prepareStatmentToProcess( this.entry );
	}
	
	/**
	 * Prepara uma cadeia de caracteres para o processamento, convertendo-a para capital e removendo caracteres
	 * especias, de forma a adequá-la ao trabalho com o procesimento de BoW.
	 *
	 * @param entry o texto a ser manipulado/analisado
	 * @return uma Lista contendo as palavras presentes no testo imputado, desconsiderando-se diferenças por
	 * capitalização e caracteres especiais, como sinais ortográficos ou números.
	 */
	private List<String> prepareStatmentToProcess (String entry) {
		String[] sampleVector = entry.toUpperCase().replaceAll( "[^A-Z a-z]+", "" ).split( " " );
		return Arrays.asList( sampleVector );
	}
}
