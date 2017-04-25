package com.tencent.mm.plugin.wear.model;

import com.tencent.mm.a.g;
import com.tencent.mm.plugin.wear.model.a.a;
import com.tencent.mm.plugin.wear.model.a.b;
import com.tencent.mm.plugin.wear.model.e.i;
import com.tencent.mm.plugin.wear.model.e.j;
import com.tencent.mm.plugin.wear.model.e.p;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.v;
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public final class d {
    b lbh = new a();
    com.tencent.mm.plugin.wear.model.e.b lbi = new com.tencent.mm.plugin.wear.model.e.b();
    public i lbj = new i();
    j lbk = new j();
    p lbl = new p();

    public final boolean bhM() {
        return bhN() != null && bhN().bhS().size() > 0;
    }

    private b bhN() {
        if (this.lbh.isAvailable() && this.lbh.bhT()) {
            return this.lbh;
        }
        return null;
    }

    public final boolean aN(byte[] bArr) {
        if (bArr == null) {
            return false;
        }
        if (!bhM()) {
            return false;
        }
        String format = String.format("/%s/%s/%d", new Object[]{aa.getContext().getPackageName(), "phone", Long.valueOf(System.currentTimeMillis())});
        b bhN = bhN();
        if (bhN == null) {
            return false;
        }
        b.a s;
        if (bArr.length > 92160) {
            s = bhN.s(format, bArr);
        } else {
            s = bhN.r(format, bArr);
        }
        if (s.aJW == 0) {
            return true;
        }
        return false;
    }

    public final byte[] aO(byte[] bArr) {
        byte[] bArr2 = null;
        byte[] uT = this.lbi.uT();
        if (!(bArr == null || uT == null)) {
            try {
                v.d("MicroMsg.Wear.WearConnectLogic", "sessionKey is not null %s", new Object[]{g.m(uT)});
                Key secretKeySpec = new SecretKeySpec(uT, "AES");
                Cipher instance = Cipher.getInstance("AES/ECB/PKCS5Padding");
                instance.init(2, secretKeySpec);
                bArr2 = instance.doFinal(bArr);
            } catch (Throwable e) {
                v.a("MicroMsg.Wear.WearConnectLogic", e, "", new Object[0]);
            }
        }
        return bArr2;
    }

    public final byte[] aP(byte[] bArr) {
        byte[] bArr2 = null;
        byte[] uT = this.lbi.uT();
        if (!(bArr == null || uT == null)) {
            try {
                v.d("MicroMsg.Wear.WearConnectLogic", "sessionKey is not null %s", new Object[]{g.m(uT)});
                bArr2 = com.tencent.mm.plugin.wear.a.a.h(bArr, uT);
            } catch (Throwable e) {
                v.a("MicroMsg.Wear.WearConnectLogic", e, "", new Object[0]);
            }
        }
        return bArr2;
    }
}
