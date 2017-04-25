package com.tencent.mm.plugin.gesture.a;

import android.util.Base64;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.protocal.c.alj;
import com.tencent.mm.protocal.c.alk;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.r;
import java.io.ByteArrayOutputStream;

public final class b {
    private static long gAQ = -1;

    public static e asX() {
        ak.yW();
        r vf = c.vf();
        if (vf == null) {
            return new e();
        }
        Object obj = vf.get(339969, null);
        if (obj == null) {
            return new e();
        }
        return new e().as(uw((String) obj));
    }

    public static void i(long j, long j2) {
        ak.yW();
        r vf = c.vf();
        if (vf != null) {
            e eVar = new e();
            eVar.gAZ = j;
            eVar.gBa = j2;
            vf.set(339969, aq(eVar.toByteArray()));
            vf.iB(true);
        }
    }

    public static void asY() {
        ak.yW();
        r vf = c.vf();
        if (vf != null) {
            vf.set(339969, null);
            vf.iB(true);
        }
    }

    public static long asZ() {
        return gAQ;
    }

    public static void bY(long j) {
        gAQ = j;
    }

    public static void ata() {
        gAQ = -1;
    }

    public static e atb() {
        ak.yW();
        r vf = c.vf();
        if (vf == null) {
            return new e();
        }
        Object obj = vf.get(339971, null);
        if (obj == null) {
            return new e();
        }
        return new e().as(uw((String) obj));
    }

    public static void j(long j, long j2) {
        ak.yW();
        r vf = c.vf();
        if (vf != null) {
            e eVar = new e();
            eVar.gAZ = j;
            eVar.gBa = j2;
            vf.set(339971, aq(eVar.toByteArray()));
            vf.iB(true);
        }
    }

    public static void atc() {
        ak.yW();
        r vf = c.vf();
        if (vf != null) {
            vf.set(339971, null);
            vf.iB(true);
        }
    }

    public static alj atd() {
        ak.yW();
        r vf = c.vf();
        if (vf == null) {
            return null;
        }
        String str = (String) vf.get(339989, null);
        if (be.kS(str)) {
            return null;
        }
        try {
            return (alj) new alj().az(Base64.decode(str, 2));
        } catch (Throwable e) {
            v.a("MicroMsg.GestureGuardInfoManager", e, "", new Object[0]);
            return null;
        } catch (Throwable e2) {
            v.a("MicroMsg.GestureGuardInfoManager", e2, "", new Object[0]);
            return null;
        }
    }

    public static void a(alj com_tencent_mm_protocal_c_alj) {
        ak.yW();
        r vf = c.vf();
        if (vf != null) {
            try {
                vf.set(339989, Base64.encodeToString(com_tencent_mm_protocal_c_alj.toByteArray(), 2));
                vf.iB(true);
            } catch (Throwable e) {
                v.a("MicroMsg.GestureGuardInfoManager", e, "", new Object[0]);
            }
        }
    }

    public static alk ate() {
        ak.yW();
        r vf = c.vf();
        if (vf == null) {
            return null;
        }
        String str = (String) vf.get(339990, null);
        if (be.kS(str)) {
            return null;
        }
        try {
            return (alk) new alk().az(Base64.decode(str, 2));
        } catch (Throwable e) {
            v.a("MicroMsg.GestureGuardInfoManager", e, "", new Object[0]);
            return null;
        } catch (Throwable e2) {
            v.a("MicroMsg.GestureGuardInfoManager", e2, "", new Object[0]);
            return null;
        }
    }

    public static void a(alk com_tencent_mm_protocal_c_alk) {
        ak.yW();
        r vf = c.vf();
        if (vf != null) {
            try {
                vf.set(339990, Base64.encodeToString(com_tencent_mm_protocal_c_alk.toByteArray(), 2));
                vf.iB(true);
            } catch (Throwable e) {
                v.a("MicroMsg.GestureGuardInfoManager", e, "", new Object[0]);
            }
        }
    }

    public static int atf() {
        ak.yW();
        r vf = c.vf();
        if (vf == null) {
            return -1;
        }
        Object obj = vf.get(339972, null);
        if (obj == null) {
            return -1;
        }
        return ((Integer) obj).intValue();
    }

    public static void lJ(int i) {
        ak.yW();
        r vf = c.vf();
        if (vf != null) {
            vf.set(339972, Integer.valueOf(i));
            vf.iB(true);
        }
    }

    public static void atg() {
        ak.yW();
        r vf = c.vf();
        if (vf != null) {
            vf.set(339972, null);
            vf.iB(true);
        }
    }

    private static String aq(byte[] bArr) {
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : bArr) {
            String toHexString = Integer.toHexString(b & 255);
            if (toHexString.length() < 2) {
                stringBuilder.append('0');
            }
            stringBuilder.append(toHexString);
        }
        return stringBuilder.toString();
    }

    private static byte[] uw(String str) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for (int i = 0; i < str.length(); i += 2) {
            byteArrayOutputStream.write(Integer.parseInt(str.substring(i, i + 2), 16));
        }
        return byteArrayOutputStream.toByteArray();
    }
}
