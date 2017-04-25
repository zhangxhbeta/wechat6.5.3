package com.tencent.mm.bc;

import android.util.Base64;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mmdb.FileUtils;
import com.tencent.recovery.a.b.a;
import com.tencent.recovery.d;
import java.io.ByteArrayOutputStream;
import java.security.Key;
import java.security.KeyFactory;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.UUID;
import javax.crypto.Cipher;

public final class b {
    public static void JG(String str) {
        a aVar = new a();
        aVar.processName = str;
        aVar.ptY = 10000;
        aVar.ptZ = 10000;
        aVar.ptX = com.tencent.recovery.a.a.ptJ;
        aVar.pua = true;
        aVar.pub = true;
        aVar.puc = "com.tencent.mm.plugin.recovery.service.WXRecoveryHandleService";
        aVar.pud = String.format("file:///sdcard/test-recovery-%s.conf", new Object[]{"0x26050341"});
        d.a(aa.getContext(), aVar.bMC(), new ArrayList());
    }

    public static final String JH(String str) {
        if (str.contains("?")) {
            return str + "uuid=" + UUID.randomUUID().toString();
        }
        return str + "?uuid=" + UUID.randomUUID().toString();
    }

    public static byte[] e(byte[] bArr, String str) {
        byte[] doFinal;
        Key generatePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str, 0)));
        Cipher instance = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        instance.init(2, generatePublic);
        int length = bArr.length;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i = 0;
        int i2 = 0;
        while (length - i2 > 0) {
            if (length - i2 > FileUtils.S_IWUSR) {
                doFinal = instance.doFinal(bArr, i2, FileUtils.S_IWUSR);
            } else {
                doFinal = instance.doFinal(bArr, i2, length - i2);
            }
            byteArrayOutputStream.write(doFinal, 0, doFinal.length);
            i2 = i + 1;
            int i3 = i2;
            i2 *= FileUtils.S_IWUSR;
            i = i3;
        }
        doFinal = byteArrayOutputStream.toByteArray();
        byteArrayOutputStream.close();
        return doFinal;
    }
}
