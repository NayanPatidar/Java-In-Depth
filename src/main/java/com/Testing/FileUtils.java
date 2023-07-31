package com.Testing;

import java.io.IOException;
import java.io.InputStream;

import java.util.Scanner;

public class FileUtils {
    public static String getHTMLContent(String fileName) throws IOException {
        InputStream inputStream = FileUtils.class.getClassLoader().getResourceAsStream(fileName);

        if (inputStream == null) {
            throw new IOException("File not found: " + fileName);
        }

        try (Scanner scanner = new Scanner(inputStream, "UTF-8")) {
            return scanner.useDelimiter("\\A").next();
        }
    }
}
