package com.trippylizard.tensixtysix.utils;

import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 
 * Represents the class with some methods related to a FileStream.
 * 
 * @author Trent
 *
 */

public class StreamUtils {
    public static File streamToFile (InputStream in) throws IOException {
        File tempfile = File.createTempFile("streamtofile", ".tmp");
        
        tempfile.deleteOnExit();
        
        try (FileOutputStream streamout = new FileOutputStream(tempfile)) {
            IOUtils.copy(in, streamout);
        }
        
        return tempfile;
    }

}