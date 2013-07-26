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
