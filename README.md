![](https://img.shields.io/badge/version-6.2.0-blue.svg?style=for-the-badge)

# es-serbian-plugin

*Elasticsearch* plugin providing support for Serbian language.

## Version

Version of the plugin will follow version of the *Elasticsearch* it can be used with.

## Description

This plugin is used for preparing and analyzing text for indexing. It origins from [this repo][www:uddrepo] which was
written based on following dependencies:
- *Apache Lucene* **v4.9**
- *Elasticsearch* **v1.3.2**

Since these versions are outdated, plugin codebase was rewritten and adapted to use these dependencies:
- *Apache Lucene* **v7.2.1**
- *Elasticsearch* **v6.2.0**

Unused, deprecated and redundant code is removed. Several parts are optimized, mainly with the use of *Apache Commons Lang* library.

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

To install build plugin to *Elasticsearch* run the following command:
```
elasticsearch-plugin install file:///path/to/plugin.zip
```

Analyzer provided by this plugin can afterwards be used in *Elasticsearch* environment by invocation via
**serbian-analyzer** name.

## Additional notes

Original stemmer written in [Snowball][www:snowball] string processing language is provided in the
 `resources/serbian-stemmber.sbl`. However, with the latest *Snowball compiler* it can't be compiled without errors.
Because of that, already generated `SerbianStemmer` was just slightly adapted so it can be used with newer version of *Lucene* dependencies.
 

[www:uddrepo]: https://github.com/chenejac/udd06
[www:snowball]: http://snowballstem.org/