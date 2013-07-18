package com.alianza.dallin.util;

import java.util.List;

/**
 * User: Dallin
 * Date: 7/17/13
 * Time: 10:54 PM
 */
public class Parser {
    /**
     * The instructions said not to use any prepackaged Arrays, or Lists, but that we could use a library for System I/O
     * since java.nio work in a collection of strings, we take that as input, but we do not do anything else with it,
     * other than iterate over the collection so that we can get the data.
     *
     * The idea.... input stream is as follow:
     * 6, 1, 54, 12, 22, 1, 6, 1
     *
     *
     * 6
     * 1, 6
     * 1, 6, 54
     * 1, 6, 12, 54
     * So we create an array that is 8 elements long (the length of the input)
     * -- -- -- -- -- -- -- --
     * -- -- -- -6 -- -- -- --
     * -- -1 -- -- -- -- -- --
     * -- -- -- -- -- 54 -- --
     * -- -- -- -- 12 -- -- --
     * -- -- -- -- -- 22 54 --
     * -1 -- -- -- -- -- -- --
     * -- -- -6 -- -- -- -- --
     * -- -- -- -- -- -- -- -1
     * Needed data? Middle, start, end
     * Find the middle of
     * @param strings
     * @return
     */
    public int[][] sortStrings(List<String> strings) {
        int length = strings.size();
        int [][] sortedIntegers = new int[length][2];

        for (String s: strings) {
            int i = Integer.parseInt(s);

        }
        return sortedIntegers;
    }

    protected int parseString(String string) {
        int i = Integer.parseInt(string);
        return i;
    }
}
