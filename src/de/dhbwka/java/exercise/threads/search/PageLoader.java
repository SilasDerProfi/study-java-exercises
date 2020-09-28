package de.dhbwka.java.exercise.threads.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * PageLoader
 */
public class PageLoader implements Runnable {

    private String url;
    private String content;

    PageLoader(String url) {
        this.url = url;
    }

    @Override
    public void run() {
        StringBuilder buffer = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new URL(url).openStream(), "UTF-8"))) {
            String line = "";
            while ((line = br.readLine()) != null) {
                buffer.append(line).append("##");
            }
        } catch (IOException ex) {
            ex.printStackTrace();}

        content = buffer.toString();
    }

    public boolean pageLoaded() {
        return content != null;
    }

    public String getPageContent() {
        return content;
    }

    public String getUrl() {
        return url;
    }
}