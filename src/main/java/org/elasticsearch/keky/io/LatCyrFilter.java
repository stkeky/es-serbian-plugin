package org.elasticsearch.keky.io;


import org.apache.lucene.analysis.TokenFilter;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;

import java.io.IOException;

public class LatCyrFilter extends TokenFilter {

    private CharTermAttribute cta;

    LatCyrFilter(TokenStream input) {
        super(input);
        this.cta = input.addAttribute(CharTermAttribute.class);
    }

    @Override
    public boolean incrementToken() throws IOException {
        if (input.incrementToken()) {
            final String text = cta.toString();
            cta.setEmpty();
            cta.append(LatinUtils.cyrToLatin(text));
            return true;
        }

        return false;
    }

}
