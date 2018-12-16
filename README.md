# es-serbian-plugin

Elasticsearch plugin providing support for Serbian language.

## Description

This plugin is used for preparing and analyzing text for indexing. It origin from [this repo][www:uddrepo] which was
written based on following dependencies:
- Apache Lucene **v4.9**
- Elasticsearch **v1.3.2**

Since these versions are highly outdated and unusable with newer versions of *Elasticsearch*, 
plugin codebase was rewritten and adapted to use these dependencies:
- Apache Lucene **v7.2.1**
- Elasticsearch **v6.2.0**

Unused, deprecated and redundant code is removed. Several parts are optimized, mainly with the use of **Apache Commons Lang** library.

## Processing

**SerbianAnalyzer** uses following components during the analysis:
1. `StandardTokenizer`
2. `LowerCaseFilter`
3. `LatCyrFilter` (converts from cyrillic to latin letters)
4. `StopFilter`
5. `SnowballFilter` with SerbianStemmer (stems tokens, taking only root of the word)
6. `RemoveAccentsFilter` (remove accents from the letters)

## Build

To build plugin run the following command:
```
mvn clean install
```

## Install

To install build plugin to Elasticsearch run the following command:
```
elasticsearch-plugin install file:///path/to/plugin.zip
```

Analyzer provided by this plugin can afterwards be used in Elasticsearch environment by invocation via
**serbian-analyzer** name.

## Additional notes

Original stemmer written in [Snowball][www:snowball] string processing language is provided in the
 `resources/serbian-stemmber.sbl`. But, with the latest *Snowball compiler* is unable to compile it without errors.
 Because of that already generated `SerbianStemmer` (generated earlier) was just slightly adapted so
 it can be used with these newer version of *Lucene* dependencies.
 

[www:uddrepo]: https://github.com/chenejac/udd06
[www:snowball]: http://snowballstem.org/