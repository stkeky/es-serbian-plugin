package org.elasticsearch.keky.io;

import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.env.Environment;
import org.elasticsearch.index.IndexSettings;
import org.elasticsearch.index.analysis.AbstractIndexAnalyzerProvider;


public class SerbianAnalyzerProvider extends AbstractIndexAnalyzerProvider<SerbianAnalyzer> {

    private final SerbianAnalyzer analyzer;

    SerbianAnalyzerProvider(IndexSettings indexSettings, Environment environment, String name, Settings settings) {
        super(indexSettings, name, settings);

        analyzer = new SerbianAnalyzer();
    }

    public SerbianAnalyzer get() {
        return this.analyzer;
    }

}
