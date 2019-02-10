package org.elasticsearch.keky.io;


import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.Tokenizer;
import org.apache.lucene.analysis.core.LowerCaseFilter;
import org.apache.lucene.analysis.core.StopFilter;
import org.apache.lucene.analysis.snowball.SnowballFilter;
import org.apache.lucene.analysis.standard.StandardTokenizer;


public class SerbianAnalyzer extends Analyzer {

    private static final String[] SERBIAN_STOP_WORDS = {
            "biti", "ne",
            "jesam", "sam", "jesi", "si", "je", "jesmo", "smo", "jeste", "ste", "jesu", "su",
            "nijesam", "nisam", "nijesi", "nisi", "nije", "nijesmo", "nismo", "nijeste", "niste", "nijesu", "nisu",
            "budem", "budeš", "bude", "budemo", "budete", "budu", "budes",
            "bih", "bi", "bismo", "biste", "biše", "bise",
            "bio", "bili", "budimo", "budite", "bila", "bilo", "bile",
            "ću", "ćeš", "će", "ćemo", "ćete",
            "neću", "nećeš", "neće", "nećemo", "nećete",
            "cu", "ces", "ce", "cemo", "cete",
            "necu", "neces", "nece", "necemo", "necete",
            "mogu", "možeš", "može", "možemo", "možete",
            "mozes", "moze", "mozemo", "mozete"
    };


    SerbianAnalyzer() {
        super();
    }

    @Override
    protected TokenStreamComponents createComponents(String fieldName) {
        final Tokenizer source = new StandardTokenizer();

        TokenStream result = new LowerCaseFilter(source);

        result = new LatCyrFilter(result);

        result = new StopFilter(result, StopFilter.makeStopSet(SERBIAN_STOP_WORDS));

        result = new SnowballFilter(result, new SerbianStemmer());

        result = new RemoveAccentsFilter(result);

        return new TokenStreamComponents(source, result);
    }


}
