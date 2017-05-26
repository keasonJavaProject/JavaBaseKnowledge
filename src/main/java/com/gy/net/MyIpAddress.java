package com.gy.net;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by KEASON on 2017/5/26.
 */
public class MyIpAddress {
    public static void main(String[] args) throws UnknownHostException {
        String spt ="\r\n";
        StringBuffer buffer= new StringBuffer();
        InetAddress inetAddress = InetAddress.getByName("wwww.hao123.com");
        buffer.append("inetAddress.getCanonicalHostName():"+inetAddress.getCanonicalHostName()+spt);
        buffer.append("inetAddress.getHostAddress():"+inetAddress.getHostAddress()+spt);
        buffer.append("inetAddress.getHostName():"+inetAddress.getHostName()+spt);
        buffer.append("inetAddress.getAddress():"+inetAddress.getAddress().toString()+spt);
        System.out.println(buffer.toString());

        InetAddress []  inetAddressLL = InetAddress.getAllByName("wwww.hao123.com");
        InetAddress  inetAddressLLocal = InetAddress.getLocalHost();

        byte byteAdd [] = new byte[4];
        byteAdd[0] = (byte)180;
        byteAdd[1] = (byte)149;
        byteAdd[2] = (byte)132;
        byteAdd[3] = (byte)3;
        InetAddress  byAddress = InetAddress.getByAddress(byteAdd);
    }
}
