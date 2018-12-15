package org.elasticsearch.keky.io;


import org.apache.lucene.analysis.TokenFilter;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;

import java.io.IOException;

public class LatCyrFilter extends TokenFilter {
	
	private CharTermAttribute cta;
	
	public LatCyrFilter(TokenStream input) {
		super(input);
		this.cta = (CharTermAttribute) input.addAttribute(CharTermAttribute.class); 
	}

	@Override
	public boolean incrementToken() throws IOException {
		if(input.incrementToken()){
			String text = cta.toString();
			cta.setEmpty();
			cta.append(LatCyrUtils.toLatin(text));
			return true;
		}
		
		return false;
	}

}
