package com.sikorski.weatheraggregator.utils

import spock.lang.Specification

class StringFormatterTest extends Specification {

    def "should words with comma in one-liner be ignored"() {
        given:
            List<String> words = givenWordsWithCommas()

        when:
            String oneLiner = StringFormatter.formatListToSingleString(words)

        then:
            int numberOfCommas = thenGetNumberOfCommasInWord(oneLiner)
            numberOfCommas == words.size()-1
    }

    def "should well prepared #wordList return proper one-liner #size"() {
        when:
            String oneLiner = StringFormatter.formatListToSingleString(wordList)

        then:
            thenGetNumberOfWordsInOneLiner(oneLiner) == size

        where:
            wordList                |   size
            ["ala"]                 |   1
            ["ala ma", "kota"]      |   2
            ["ala", "ma", ""]       |   2
            ["ala", "ma", "kota"]   |   3
    }

    def "should empty list returns empty string"() {
        given:
            List<String> words = Collections.emptyList()

        when:
            String oneLiner = StringFormatter.formatListToSingleString(words)

        then:
            oneLiner == ""
    }

    private List<String> givenWordsWithCommas() {
        return Arrays.asList("ala", ",ma", "kotka,")
    }

    private List<String> givenWords() {
        return Arrays.asList("ala", "ma", "kotka")
    }

    private int thenGetNumberOfWordsInOneLiner(String oneLiner) {
        return oneLiner.split(",").size();
    }

    private int thenGetNumberOfCommasInWord(String word) {
        int counter = 0
        for (int i=0; i<word.length(); i++) {
            char c = word.charAt(i)
            if (c == ',') {
                counter++
            }
        }

        return counter
    }

}
