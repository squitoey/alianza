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
