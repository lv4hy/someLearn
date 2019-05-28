package com.szx.netty.channel;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.FileChannel;

public class FileReadChannel {
    public static void main(String[] args) {
        Channel channelIn = null;
        Channel channelOut = null;

        try {
            String path = "a.txt";
            File file = new File(path);
            if(!file.exists()){
                file.createNewFile();
            }
            FileInputStream fileInputStream = new FileInputStream(file);
            channelIn = fileInputStream.getChannel();
            ByteBuffer bufferIn = ByteBuffer.allocate(1024);
            bufferIn.clear();
            String path2 = "b.txt";
            File file2 = new File(path2);
            if(!file2.exists()){
                file2.createNewFile();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            channelOut = fileOutputStream.getChannel();
            int t = 0;
            do {
               t = ((FileChannel) channelIn).read(bufferIn);
                bufferIn.flip();
               ((FileChannel) channelOut).write(bufferIn);
                bufferIn.clear();

            }while (t != -1);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(channelIn != null){
                try {
                    channelIn.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(channelOut != null){
                try {
                    channelOut.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
