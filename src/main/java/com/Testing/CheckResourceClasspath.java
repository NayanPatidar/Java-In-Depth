package com.Testing;

import java.io.InputStream;

public class CheckResourceClasspath {
    public static void main(String[] args) {
        // Try to load a resource file from the resources directory
        try {
            InputStream inputStream = CheckResourceClasspath.class.getClassLoader().getResourceAsStream("WebPage.html");
            if (inputStream != null) {
                System.out.println("Resources directory is included in the classpath.");
            } else {
                System.out.println("Resources directory is NOT included in the classpath.");
            }
        } catch (Exception e) {
            System.out.println("Error occurred while checking the classpath: " + e.getMessage());
        }
    }
}