package com.alianza.dallin.util;

import java.util.List;

public class Parser {
    /**
     * The instructions said not to use any prepackaged Arrays, or Lists, but that we could use a library for System I/O
     * since java.nio work in a collection of strings, we take that as input, but we do not do anything else with it,
     * other than iterate over the collection so that we can get the data.
     *
     * @param strings
     * @return
     */
    public int[] sortStrings(List<String> strings) {
        int[] all = new int[strings.size()];
        for (int i = 0; i < strings.size(); i++) {
            int value = parseString(strings.get(i));
            all[i] = value;
        }

        for (int i = 0; i < all.length; i++){
            for (int j = (all.length - 1); j > i; j--) {
                if (all[i] > all[j]) {
                    int temp = all[i];
                    all[i] = all[j];
                    all[j] = temp;
                }
            }
        }
        return all;
    }

    public int[][] groupInt(int[] input) {
        int[] keys = null;
        int[] values = null;
        int currentPos = 0;

        for (int i = 0; i < input.length; i++) {
            if (keys == null || values == null) {
                keys = new int[]{input[i]};
                values = new int[]{0};
            }
            if (keys[currentPos] != input[i]) {
                currentPos++;
                int[] tempKey = new int[keys.length + 1];
                int[] tempVal = new int[keys.length + 1];
                System.arraycopy(keys, 0, tempKey, 0, keys.length);
                System.arraycopy(values, 0, tempVal, 0, values.length);
                keys = tempKey;
                keys[currentPos] = input[i];
                values = tempVal;
                values[currentPos] = 0;
            }
            values[currentPos]++;
        }
        int[][] toReturn = new int[2][keys.length];
        System.arraycopy(keys, 0, toReturn[0], 0, keys.length);
        System.arraycopy(values, 0, toReturn[1], 0, keys.length);

        return toReturn;
    }

    protected int parseString(String string) {
        try {
            int i = Integer.parseInt(string);
            return i;
        } catch (RuntimeException ex) {
            //We simply assume that if there is an exception thrown by parsing the string as an it, we just return 0.
            return 0;
        }
    }
}