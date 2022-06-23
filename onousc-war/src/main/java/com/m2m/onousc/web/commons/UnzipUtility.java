package com.m2m.onousc.web.commons;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import com.google.common.io.Files;
 
/**
 * This utility extracts files and directories of a standard zip file to
 * a destination directory.
 * @author www.codejava.net
 *
 */
public class UnzipUtility {
    /**
     * Size of the buffer to read/write data
     */
    private static final int BUFFER_SIZE = 4096;
    /**
     * Extracts a zip file specified by the zipFilePath to a directory specified by
     * destDirectory (will be created if does not exists)
     * @param zipFilePath
     * @param destDirectory
     * @throws IOException
     */
    public String unzip(String zipFilePath, String destDirectoryCsv,String destDirectoryIMG) throws IOException {
        File destDirCSV = new File(destDirectoryCsv);
        File destDirIG = new File(destDirectoryIMG);
        String filePathCSV = "";
        String filePathIMG = "";
        if (!destDirCSV.exists()) {
        	destDirCSV.mkdir();
        }
        if (!destDirIG.exists()) {
        	destDirIG.mkdir();
        }
        
        ZipInputStream zipIn = new ZipInputStream(new FileInputStream(zipFilePath));
        ZipEntry entry = zipIn.getNextEntry();
        // iterates over entries in the zip file
        while (entry != null) {
         
            
            if (!entry.isDirectory()) {
                // if the entry is a file, extracts it
            	if (entry.getName().endsWith("csv") || entry.getName().endsWith("CSV") )
            		{              		        
	            		filePathCSV = destDirectoryCsv+File.separator+Paths.get(zipFilePath).getFileName().toString()+".csv";
	            		extractFile(zipIn, filePathCSV);
            		}else {
            			String filePath = destDirectoryIMG + File.separator + entry.getName();            			
            			filePathIMG = destDirectoryIMG+File.separator+ Paths.get(filePath).getFileName().toString();
	            		extractFile(zipIn, filePathIMG);
            		}
            		
            } 
            
             
            zipIn.closeEntry();
            entry = zipIn.getNextEntry();
        }
        zipIn.close();
        return filePathCSV;
    }
    /**
     * Extracts a zip entry (file entry)
     * @param zipIn
     * @param filePath
     * @throws IOException
     */
    private void extractFile(ZipInputStream zipIn, String filePath) throws IOException {
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filePath));
        byte[] bytesIn = new byte[BUFFER_SIZE];
        int read = 0;
        while ((read = zipIn.read(bytesIn)) != -1) {
            bos.write(bytesIn, 0, read);
        }
        bos.close();
    }
}