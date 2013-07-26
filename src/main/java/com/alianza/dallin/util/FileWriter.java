package com.alianza.dallin.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.Path;

public class FileWriter {
    FileOutputStream fos;
    FileChannel fc;
    Path filePath;
    public FileWriter(String filename) {
        filePath = new File(filename).toPath();
    }

    public boolean write(StringBuffer buf) {
        try {
            fos = new FileOutputStream(filePath.toString());
            fc = fos.getChannel();
            fos.write(buf.toString().getBytes());
            fc.close();
            return true;
        } catch (IOException ioe) {
            System.out.println("FATAL ERROR: Unable to write the " + filePath.toString() + " file. " + ioe.getMessage());
        }
        return false;
    }
}
