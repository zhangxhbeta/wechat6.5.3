package com.tencent.mm.plugin.ext.a;

import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;

public final class a {
    private static char[] enk = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static SecretKey fGK = null;

    private static void akR() {
        try {
            if (fGK == null) {
                ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(pt("aced00057372001f6a617661782e63727970746f2e737065632e5365637265744b6579537065635b470b66e230614d0200024c0009616c676f726974686d7400124c6a6176612f6c616e672f537472696e673b5b00036b65797400025b427870740003414553757200025b42acf317f8060854e0020000787000000010402a2173bd6f2542e5e71ee414b2e1e8")));
                fGK = (SecretKey) objectInputStream.readObject();
                objectInputStream.close();
            }
        } catch (Throwable e) {
            v.a("MicroMsg.AESUtil", e, SQLiteDatabase.KeyEmpty, new Object[0]);
        }
    }

    private static byte[] sG(String str) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        akR();
        Cipher instance = Cipher.getInstance("AES");
        instance.init(1, fGK);
        return instance.doFinal(str.getBytes("UTF8"));
    }

    public static String bv(long j) {
        byte[] sG = sG(String.valueOf(j));
        if (sG == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder(sG.length * 2);
        for (int i = 0; i < sG.length; i++) {
            stringBuilder.append(enk[(sG[i] & 240) >>> 4]);
            stringBuilder.append(enk[sG[i] & 15]);
        }
        return stringBuilder.toString();
    }

    private static String pn(String str) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        akR();
        Cipher instance = Cipher.getInstance("AES");
        instance.init(2, fGK);
        return new String(instance.doFinal(pt(str)), "UTF8");
    }

    public static long sH(String str) {
        return Long.valueOf(pn(str).trim()).longValue();
    }

    private static byte[] pt(String str) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        byte[] bArr = new byte[(str.length() / 2)];
        for (int i = 0; i < bArr.length; i++) {
            bArr[i] = (byte) Integer.parseInt(str.substring(i * 2, (i * 2) + 2), 16);
        }
        return bArr;
    }
}
