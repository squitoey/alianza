package com.alianza.dallin.util;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

/**
 * User: Dallin
 * Date: 7/17/13
 * Time: 10:55 PM
 */
public class ParserTest {
    @Test(groups = {"fast"})
    public void parseFile() {
        ArrayList<String> lines = new ArrayList<String>();
        lines.add("6");
        lines.add("1");
        lines.add("54");
        lines.add("12");
        lines.add("1");
        lines.add("6");
        lines.add("1");
        Parser parser = new Parser();

        int[][] results = parser.sortStrings(lines);
        Assert.assertEquals(results.length, 5, "Sorted string is not the expected length");

        for (int[] i: results) {
            Assert.assertEquals(i.length, 2, "Each sub-array should be 2 and only 2 items long.");
        }

        Assert.assertEquals(results[0][0], 1);
        Assert.assertEquals(results[0][1], 3);
        Assert.assertEquals(results[1][0], 6);
        Assert.assertEquals(results[1][1], 2);
        Assert.assertEquals(results[2][0], 12);
        Assert.assertEquals(results[2][1], 1);
        Assert.assertEquals(results[3][0], 22);
        Assert.assertEquals(results[3][1], 1);
        Assert.assertEquals(results[4][0], 54);
        Assert.assertEquals(results[4][1], 1);
    }
}
