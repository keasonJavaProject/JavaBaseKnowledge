package com.gy.net;

import java.io.*;
import java.net.*;

/**
 * Created by KEASON on 2017/5/26.
 */
public class MyUrl {

    private void showResponseData(InputStream inputStream) throws IOException {
        ///////////////////////////////////////////////////////////
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String str;
        while((str = bufferedReader.readLine())!=null){
            System.out.println(str);
        }
    }
    public static void main(String[] args) throws IOException {
        MyUrl myUrl = new MyUrl();
        URL url = new URL("http://www.hao123.com");
/////////////////////////////////////////////////////
        URLConnection urlConnection = url.openConnection();
        for (int i = 0; ; i++) {
            String header=urlConnection.getHeaderField(i);
            if(header==null){
                break;
            }
            System.out.println(header+":"+urlConnection.getHeaderFieldKey(i));
        }
        System.out.println("urlConnection.getConnectTimeout()"+urlConnection.getConnectTimeout());
        System.out.println("urlConnection.getContentEncoding()"+urlConnection.getContentEncoding());
        System.out.println("urlConnection.getContentType()"+urlConnection.getContentType());
        System.out.println("urlConnection.getContentLength()"+urlConnection.getContentLength());
        System.out.println("urlConnection.getLastModified()"+urlConnection.getLastModified());


        HttpURLConnection httpURLConnection =(HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestMethod("DELETE");
        InputStream inputStream =httpURLConnection.getInputStream();
        myUrl.showResponseData(inputStream);
    }
}
