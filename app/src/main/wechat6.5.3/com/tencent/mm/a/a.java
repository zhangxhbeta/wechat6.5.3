package com.tencent.mm.a;

import android.util.Base64;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.security.InvalidParameterException;
import java.security.Key;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class a {
    public static boolean g(String str, String str2, String str3) {
        String str4 = "AES/CBC/PKCS7Padding";
        if (be.kS(str4)) {
            throw new InvalidParameterException("invalid cipherTransformation");
        }
        File file = new File(str2);
        File file2 = new File(str3);
        if (!file.exists() || !file.isFile()) {
            return false;
        }
        if (!file2.getParentFile().exists()) {
            file2.getParentFile().mkdirs();
        }
        file2.createNewFile();
        FileInputStream fileInputStream = new FileInputStream(file);
        OutputStream fileOutputStream = new FileOutputStream(file2);
        byte[] decode = Base64.decode(str.getBytes(), 0);
        Key secretKeySpec = new SecretKeySpec(decode, "AES");
        Cipher instance = Cipher.getInstance(str4);
        instance.init(2, secretKeySpec, new IvParameterSpec(Arrays.copyOf(decode, decode.length)));
        CipherOutputStream cipherOutputStream = new CipherOutputStream(fileOutputStream, instance);
        byte[] bArr = new byte[1024];
        while (true) {
            int read = fileInputStream.read(bArr);
            if (read != -1) {
                cipherOutputStream.write(bArr, 0, read);
                cipherOutputStream.flush();
            } else {
                cipherOutputStream.close();
                fileOutputStream.close();
                fileInputStream.close();
                return true;
            }
        }
    }

    private static byte[] aO(String str) {
        if (str.length() <= 0) {
            return null;
        }
        byte[] bArr = new byte[(str.length() / 2)];
        for (int i = 0; i < str.length() / 2; i++) {
            bArr[i] = (byte) ((Integer.parseInt(str.substring(i * 2, (i * 2) + 1), 16) * 16) + Integer.parseInt(str.substring((i * 2) + 1, (i * 2) + 2), 16));
        }
        return bArr;
    }

    public static String o(String str, String str2) {
        if (be.kS(str)) {
            return SQLiteDatabase.KeyEmpty;
        }
        try {
            return new String(a(aO(str), str2));
        } catch (Throwable e) {
            v.e("MicroMsg.AESUtils", be.e(e));
            return str;
        }
    }

    private static byte[] a(byte[] bArr, String str) {
        try {
            Key secretKeySpec = new SecretKeySpec(str.getBytes(), "AES");
            Cipher instance = Cipher.getInstance("AES/ECB/PKCS5Padding");
            instance.init(2, secretKeySpec);
            return instance.doFinal(bArr);
        } catch (Throwable e) {
            v.e("MicroMsg.AESUtils", be.e(e));
            return null;
        }
    }
}
