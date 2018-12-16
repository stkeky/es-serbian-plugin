package org.elasticsearch.keky.io;

import org.apache.lucene.analysis.TokenFilter;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;

import java.io.IOException;

public class RemoveAccentsFilter extends TokenFilter {

    private CharTermAttribute termAttribute;

    RemoveAccentsFilter(TokenStream input) {
        super(input);
        termAttribute = input.addAttribute(CharTermAttribute.class);
    }

    @Override
    public boolean incrementToken() throws IOException {
        if (input.incrementToken()) {
            final String text = termAttribute.toString();
            termAttribute.setEmpty();
            termAttribute.append(LatinUtils.removeAccents(text));
            return true;
        }
        return false;
    }

}
