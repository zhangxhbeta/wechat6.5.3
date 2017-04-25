package com.tencent.smtt.utils;

import android.util.Base64;
import com.tencent.smtt.sdk.WebView;
import java.security.KeyFactory;
import java.security.Provider;
import java.security.Security;
import java.security.spec.X509EncodedKeySpec;
import java.util.Random;
import javax.crypto.Cipher;

public final class j {
    private static final char[] pzb = "0123456789abcdef".toCharArray();
    private static j pzc;
    private String pzd;
    private String pze;
    String pzf = String.valueOf(new Random().nextInt(89999999) + 10000000);

    private j() {
        int nextInt = new Random().nextInt(89999999) + 10000000;
        this.pzd = this.pzf + String.valueOf(nextInt);
    }

    public static String Qq(String str) {
        byte[] bytes = str.getBytes();
        Cipher cipher = null;
        try {
            cipher = Cipher.getInstance("RSA/ECB/NoPadding");
        } catch (Exception e) {
            try {
                bOa();
                cipher = Cipher.getInstance("RSA/ECB/NoPadding");
            } catch (Exception e2) {
            }
        }
        cipher.init(1, KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode("MCwwDQYJKoZIhvcNAQEBBQADGwAwGAIRAMRB/Q0hTCD+XtnQhpQJefUCAwEAAQ==".getBytes(), 0))));
        return bytesToHex(cipher.doFinal(bytes));
    }

    public static synchronized j bNZ() {
        j jVar;
        synchronized (j.class) {
            if (pzc == null) {
                pzc = new j();
            }
            jVar = pzc;
        }
        return jVar;
    }

    private static void bOa() {
        Security.addProvider((Provider) Class.forName("com.android.org.bouncycastle.jce.provider.BouncyCastleProvider", true, ClassLoader.getSystemClassLoader()).newInstance());
    }

    private static String bytesToHex(byte[] bArr) {
        char[] cArr = new char[(bArr.length * 2)];
        for (int i = 0; i < bArr.length; i++) {
            int i2 = bArr[i] & WebView.NORMAL_MODE_ALPHA;
            cArr[i * 2] = pzb[i2 >>> 4];
            cArr[(i * 2) + 1] = pzb[i2 & 15];
        }
        return new String(cArr);
    }

    public final String bOb() {
        if (this.pze == null) {
            byte[] bytes = this.pzd.getBytes();
            Cipher cipher = null;
            try {
                cipher = Cipher.getInstance("RSA/ECB/NoPadding");
            } catch (Exception e) {
                try {
                    bOa();
                    cipher = Cipher.getInstance("RSA/ECB/NoPadding");
                } catch (Exception e2) {
                }
            }
            cipher.init(1, KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode("MCwwDQYJKoZIhvcNAQEBBQADGwAwGAIRAMRB/Q0hTCD+XtnQhpQJefUCAwEAAQ==".getBytes(), 0))));
            this.pze = bytesToHex(cipher.doFinal(bytes));
        }
        return this.pze;
    }
}
