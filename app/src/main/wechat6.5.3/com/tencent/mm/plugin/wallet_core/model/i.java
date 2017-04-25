package com.tencent.mm.plugin.wallet_core.model;

import android.util.Base64;
import com.tencent.mm.a.l;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.v;
import java.security.Key;
import java.security.PublicKey;
import javax.crypto.Cipher;

public final class i {
    private static i kOF;
    private PublicKey kOG = null;

    public static i bfT() {
        if (kOF == null) {
            kOF = new i();
        }
        return kOF;
    }

    public final String CY(String str) {
        try {
            this.kOG = l.m(aa.getContext(), "lbs_rsa_public_key.pem");
            v.i("MicroMsg.LocationEncrypt", "getPemPublickKeyFromAsset23 done2");
            byte[] bytes = str.getBytes();
            Key key = this.kOG;
            Cipher instance = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            instance.init(1, key);
            return new String(Base64.encode(instance.doFinal(bytes), 0));
        } catch (Exception e) {
            v.e("MicroMsg.LocationEncrypt", "encry publicKey error %s", new Object[]{e.getMessage()});
            return str;
        }
    }
}
