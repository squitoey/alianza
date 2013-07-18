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
    @Test(dependsOnMethods = {"parseString"})
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
        Assert.assertEquals(results.length, 5, "Invalid number of elements in the sorted array.");

        for (int[] i: results) {
            Assert.assertEquals(i.length, 2, "Invalid number of elements for each element.");
        }

        Assert.assertEquals(1, results[0][0]);
        Assert.assertEquals(3, results[0][1]);
        Assert.assertEquals(6, results[1][0]);
        Assert.assertEquals(2, results[1][1]);
        Assert.assertEquals(12, results[2][0]);
        Assert.assertEquals(1,results[2][1]);
        Assert.assertEquals(22, results[3][0]);
        Assert.assertEquals(2, results[3][1]);
        Assert.assertEquals(54, results[4][0]);
        Assert.assertEquals(1, results[4][1]);
    }

    @Test
    public void parseString() {
        Parser parser = new Parser();

        int ret = parser.parseString("2");
        Assert.assertEquals(ret, 2);

        ret = parser.parseString("4.2");
        Assert.assertEquals(ret, 4);

        ret = parser.parseString("4s");
        Assert.assertEquals(ret, 4);

        ret = parser.parseString("se");
        Assert.assertEquals(ret, 0);
    }
}
