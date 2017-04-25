package com.tencent.smtt.utils;

import android.util.Base64;
import com.tencent.mmdb.database.SQLiteDatabase;
import com.tencent.smtt.sdk.WebView;
import java.security.Key;
import java.security.KeyFactory;
import java.security.spec.X509EncodedKeySpec;
import java.util.Random;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;

public final class i {
    protected static final char[] hexArray = "0123456789abcdef".toCharArray();
    private static String pyV = SQLiteDatabase.KeyEmpty;
    private static byte[] pyW = null;
    private static i pyZ = null;
    private static String pza;
    private Cipher pyX = null;
    private Cipher pyY = null;

    private i() {
        pza = String.valueOf(new Random().nextInt(89999999) + 10000000) + String.valueOf(new Random().nextInt(89999999) + 10000000) + String.valueOf(new Random().nextInt(89999999) + 10000000);
        String str = "00000000";
        for (int i = 0; i < 12; i++) {
            str = str + String.valueOf(new Random().nextInt(89999999) + 10000000);
        }
        pyW = (str + pza).getBytes();
        this.pyX = Cipher.getInstance("RSA/ECB/NoPadding");
        this.pyX.init(1, KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDcEQ3TCNWPBqgIiY7WQ/IqTOTTV2w8aZ/GPm68FK0fAJBemZKtYR3Li46VJ+Hwnor7ZpQnblGWPFaLv5JoPqvavgB0GInuhm+T+syPs1mw0uPLWaqwvZsCfoaIvUuxy5xHJgmWARrK4/9pHyDxRlZte0PCIoR1ko5B8lVVH1X1dQIDAQAB".getBytes(), 0))));
        pyV = bytesToHex(this.pyX.doFinal(pyW));
        Key generateSecret = SecretKeyFactory.getInstance("DESede").generateSecret(new DESedeKeySpec(pza.getBytes()));
        this.pyY = Cipher.getInstance("DESede/ECB/PKCS5Padding");
        this.pyY.init(1, generateSecret);
    }

    public static i bNW() {
        try {
            if (pyZ == null) {
                pyZ = new i();
            }
            return pyZ;
        } catch (Exception e) {
            pyZ = null;
            return null;
        }
    }

    public static String bNX() {
        return pyV;
    }

    public static String bNY() {
        return pza;
    }

    public static String bytesToHex(byte[] bArr) {
        char[] cArr = new char[(bArr.length * 2)];
        for (int i = 0; i < bArr.length; i++) {
            int i2 = bArr[i] & WebView.NORMAL_MODE_ALPHA;
            cArr[i * 2] = hexArray[i2 >>> 4];
            cArr[(i * 2) + 1] = hexArray[i2 & 15];
        }
        return new String(cArr);
    }

    public static byte[] bz(byte[] bArr) {
        try {
            Key generateSecret = SecretKeyFactory.getInstance("DESede").generateSecret(new DESedeKeySpec(pza.getBytes()));
            Cipher instance = Cipher.getInstance("DESede/ECB/PKCS5Padding");
            instance.init(2, generateSecret);
            return instance.doFinal(bArr);
        } catch (Exception e) {
            return null;
        }
    }

    public static byte[] f(byte[] bArr, String str) {
        Key generateSecret = SecretKeyFactory.getInstance("DESede").generateSecret(new DESedeKeySpec(str.getBytes()));
        Cipher instance = Cipher.getInstance("DESede/ECB/PKCS5Padding");
        instance.init(1, generateSecret);
        return instance.doFinal(bArr);
    }

    public final byte[] by(byte[] bArr) {
        return this.pyY.doFinal(bArr);
    }
}
