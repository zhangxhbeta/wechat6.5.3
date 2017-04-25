package com.tencent.mm.a;

import java.io.ByteArrayOutputStream;
import java.security.MessageDigest;

public final class m {
    public static String aZ(String str) {
        MessageDigest instance = MessageDigest.getInstance("SHA1");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byteArrayOutputStream.write(str.getBytes("UTF-8"));
        return bytesToHex(instance.digest(byteArrayOutputStream.toByteArray()));
    }

    private static String bytesToHex(byte[] bArr) {
        int i = 0;
        char[] cArr = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        int length = bArr.length;
        char[] cArr2 = new char[(length * 2)];
        int i2 = 0;
        while (i < length) {
            byte b = bArr[i];
            int i3 = i2 + 1;
            cArr2[i2] = cArr[(b >>> 4) & 15];
            i2 = i3 + 1;
            cArr2[i3] = cArr[b & 15];
            i++;
        }
        return new String(cArr2);
    }
}
