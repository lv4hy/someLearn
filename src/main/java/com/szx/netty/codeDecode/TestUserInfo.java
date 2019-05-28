package com.szx.netty.codeDecode;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.ByteBuffer;

public class TestUserInfo {

    public static void main(String[] args) throws IOException {
        UserInfo info = new UserInfo();
        info.setUserId(111);
        info.setUserName("szx");
        int loop = 1000000;
        long start = System.currentTimeMillis();
        for(int i = 0; i < loop; i++){
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream os = new ObjectOutputStream(bos);
            os.writeObject(info);
            os.flush();
            os.close();
            byte[] b = bos.toByteArray();
            bos.close();
        }

        long end = System.currentTimeMillis();
        System.out.println("jdk time : " + (end - start));
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        start = System.currentTimeMillis();
        for(int i = 0; i < loop; i++){
            byte[] b = info.codeC(buffer);
        }
        end = System.currentTimeMillis();
        System.out.println("byte time is: "+ (end -start));
    }
}
