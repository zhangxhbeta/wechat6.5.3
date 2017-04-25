package com.tencent.mm.a;

import android.util.Base64;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.security.Key;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;

public final class d {
    private Cipher aPN;
    private Cipher aPO;

    public d(String str) {
        try {
            Key generateSecret = SecretKeyFactory.getInstance("DES").generateSecret(new DESKeySpec(str.getBytes("UTF8")));
            AlgorithmParameterSpec ivParameterSpec = new IvParameterSpec("manifest".getBytes("UTF8"));
            this.aPN = Cipher.getInstance("DES/CBC/PKCS5Padding");
            this.aPN.init(1, generateSecret, ivParameterSpec);
            this.aPO = Cipher.getInstance("DES/CBC/PKCS5Padding");
            this.aPO.init(2, generateSecret, ivParameterSpec);
        } catch (Throwable e) {
            v.a("MicroMsg.DESUtil", e, SQLiteDatabase.KeyEmpty, new Object[0]);
        }
    }

    public final String aP(String str) {
        try {
            return new String(this.aPO.doFinal(Base64.decode(str, 0)), "UTF8");
        } catch (Exception e) {
            return "[des]" + str + "|" + e.toString();
        }
    }
}
