package com.aiguigu.springboot.message;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLConnection;

public class TestMessage {
    public static void main(String[] args) throws IOException {
        //https://itdage.com/kkb/kkbsms?key=xzk&number=13538160438&code=HeXingQuan
        URL url = new URL("https://itdage.com/kkb/kkbsms?key=xzk&number=13538160438&code=HeXingQuan");
        URLConnection conn = url.openConnection();
        InputStream is = conn.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
        String text = br.readLine();
        System.out.println(text);
        br.close();
    }
}
