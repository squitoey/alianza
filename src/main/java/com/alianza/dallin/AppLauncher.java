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
package com.alianza.dallin;

import com.alianza.dallin.util.FileWriter;
import com.alianza.dallin.util.Parser;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.util.List;

public class AppLauncher {
    public static void main(String[] args) {
        Parser parser = new Parser();
        Path inputFilePath = new File("AlianzaInput.txt").toPath();
        Path sortedFilePath = new File("AlianzaAscending.txt").toPath();
        Path histogramFilePath = new File("AlianzaHistogram.txt").toPath();
        Charset charset = Charset.defaultCharset();
        // I know the instructions
        List<String> list = null;
        try {
            list = Files.readAllLines(inputFilePath, charset);
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
        if (list == null) {
            System.out.println("FATAL ERROR: Unable to open the AlianzaInput.txt file.");
            System.exit(1);
        }

        int results[] = parser.sortStrings(list);
        StringBuffer buf = new StringBuffer();
        for (int i: results) {
            buf.append(i);
            buf.append(System.getProperty("line.separator"));
        }
        FileWriter writer = new FileWriter("AlianzaAscending.txt");
        writer.write(buf);

        buf = new StringBuffer();
        int[][] histResults = parser.groupInt(results);
        for (int i = 0; i < histResults[0].length; i++) {
            buf.append(histResults[0][i]);
            buf.append(" - ");
            buf.append(histResults[1][i]);
            buf.append(System.getProperty("line.separator"));
        }
        writer = new FileWriter("AlianzaHistogram.txt");
        writer.write(buf);
    }
}
