/*
 Copyright 2013 Dallin Jones

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
 */
package com.alianza.dallin.util;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class ParserTest {
    @Test(dependsOnMethods = {"parseString"}, groups ={"fast"})
    public void parseFile() {
        ArrayList<String> lines = new ArrayList<String>();
        lines.add("6");
        lines.add("1");
        lines.add("54");
        lines.add("12");
        lines.add("22");
        lines.add("1");
        lines.add("6");
        lines.add("1");
        Parser parser = new Parser();

        int[] results = parser.sortStrings(lines);
        Assert.assertEquals(results.length, 8, "Invalid number of elements in the sorted array.");

        Assert.assertEquals(results[0], 1);
        Assert.assertEquals(results[1], 1);
        Assert.assertEquals(results[2], 1);
        Assert.assertEquals(results[3], 6);
        Assert.assertEquals(results[4], 6);
        Assert.assertEquals(results[5], 12);
        Assert.assertEquals(results[6], 22);
        Assert.assertEquals(results[7], 54);
    }

    @Test(groups={"fast"})
    public void groupInt() {
        Parser parser = new Parser();
        int[] sortedArray = {1, 1, 1, 6, 6, 12, 22, 54};
        int[][] actual  = {
                {1, 6, 12, 22, 54},
                {3, 2,  1,  1,  1}
        };

        int[][] results = parser.groupInt(sortedArray);

        Assert.assertEquals(results.length, 2, "Invalid number of elements returned.");
        Assert.assertEquals(results[0].length, 5, "Invalid number of sub elements returned.");

        Assert.assertEquals(results[0][0], 1);
        Assert.assertEquals(results[0][1], 6);
        Assert.assertEquals(results[0][2], 12);
        Assert.assertEquals(results[0][3], 22);
        Assert.assertEquals(results[0][4], 54);

        Assert.assertEquals(results[1][0], 3);
        Assert.assertEquals(results[1][1], 2);
        Assert.assertEquals(results[1][2], 1);
        Assert.assertEquals(results[1][3], 1);
        Assert.assertEquals(results[1][4], 1);
    }

    @Test(groups={"fast"})
    public void parseString() {
        Parser parser = new Parser();

        int ret = parser.parseString("2");
        Assert.assertEquals(ret, 2);

        ret = parser.parseString("4.2");
        Assert.assertEquals(ret, 0); // Normally gives a parse error.

        ret = parser.parseString("4s"); //Normally gives a parse error.
        Assert.assertEquals(ret, 0);

        ret = parser.parseString("se"); //Normally gives a parse error.
        Assert.assertEquals(ret, 0);
    }
}
