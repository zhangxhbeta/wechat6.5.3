package com.tencent.mm.plugin.gesture.a;

import android.app.Activity;
import android.os.SystemClock;
import com.tencent.mm.a.g;
import com.tencent.mm.a.o;
import com.tencent.mm.e.a.fy;
import com.tencent.mm.e.a.pr;
import com.tencent.mm.h.j;
import com.tencent.mm.jni.utils.UtilsJni;
import com.tencent.mm.model.ag;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.k;
import com.tencent.mm.plugin.gesture.ui.GestureGuardLogicUI;
import com.tencent.mm.protocal.c.alj;
import com.tencent.mm.protocal.c.alk;
import com.tencent.mm.sdk.c.a;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.io.ByteArrayOutputStream;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public final class d implements ag {
    public HashSet<WeakReference<Activity>> gAS;
    private boolean gAT;
    private boolean gAU;
    private Object gAV;
    private c gAW;
    private c gAX;

    public d() {
        this.gAS = null;
        this.gAT = false;
        this.gAU = false;
        this.gAV = new Object();
        this.gAW = new c<fy>(this) {
            final /* synthetic */ d gAY;

            {
                this.gAY = r2;
                this.nhz = fy.class.getName().hashCode();
            }

            private boolean a(fy fyVar) {
                long asZ;
                long elapsedRealtime;
                switch (fyVar.bfu.bfw) {
                    case 0:
                        if (!(fyVar.bfu.aXH instanceof GestureGuardLogicUI)) {
                            if (!this.gAY.atk()) {
                                asZ = b.asZ();
                                elapsedRealtime = (SystemClock.elapsedRealtime() - asZ) / 1000;
                                if ((asZ != -1 && elapsedRealtime < ((long) a.gAO) && !d.atj()) || !this.gAY.ati()) {
                                    v.d("MicroMsg.SubCoreGestureGuard", "REQUEST_PROTECT_ME_ONCREATE indicates need not verify.");
                                    fyVar.bfv.data = Integer.valueOf(16);
                                    this.gAY.gAS.add(new WeakReference(fyVar.bfu.aXH));
                                    break;
                                }
                                v.d("MicroMsg.SubCoreGestureGuard", "REQUEST_PROTECT_ME_ONCREATE indicates needs verify.");
                                fyVar.bfv.data = Integer.valueOf(17);
                                break;
                            }
                            v.d("MicroMsg.SubCoreGestureGuard", "REQUEST_PROTECT_ME_ONCREATE indicates need not verify.");
                            fyVar.bfv.data = Integer.valueOf(16);
                            this.gAY.gAS.add(new WeakReference(fyVar.bfu.aXH));
                            this.gAY.dr(false);
                            break;
                        }
                        v.d("MicroMsg.SubCoreGestureGuard", "REQUEST_PROTECT_ME_ONCREATE indicates need not verify.");
                        fyVar.bfv.data = Integer.valueOf(16);
                        break;
                        break;
                    case 1:
                        if (!(fyVar.bfu.aXH instanceof GestureGuardLogicUI)) {
                            if (!this.gAY.atk()) {
                                if (!this.gAY.atl()) {
                                    asZ = b.asZ();
                                    elapsedRealtime = (SystemClock.elapsedRealtime() - asZ) / 1000;
                                    if ((asZ == -1 || elapsedRealtime >= ((long) a.gAO) || d.atj()) && this.gAY.ati()) {
                                        v.d("MicroMsg.SubCoreGestureGuard", "REQUEST_PROTECT_ME_ONRESUME indicates needs verify.");
                                        fyVar.bfv.data = Integer.valueOf(17);
                                    } else {
                                        v.d("MicroMsg.SubCoreGestureGuard", "REQUEST_PROTECT_ME_ONRESUME indicates need not verify.");
                                        fyVar.bfv.data = Integer.valueOf(16);
                                    }
                                    this.gAY.gAS.add(new WeakReference(fyVar.bfu.aXH));
                                    break;
                                }
                                v.d("MicroMsg.SubCoreGestureGuard", "REQUEST_PROTECT_ME_ONRESUME indicates reenter.");
                                this.gAY.dr(false);
                                this.gAY.ds(false);
                                fyVar.bfv.data = Integer.valueOf(18);
                                break;
                            }
                            v.d("MicroMsg.SubCoreGestureGuard", "REQUEST_PROTECT_ME_ONRESUME indicates need not verify.");
                            this.gAY.dr(false);
                            this.gAY.ds(false);
                            fyVar.bfv.data = Integer.valueOf(16);
                            break;
                        }
                        v.d("MicroMsg.SubCoreGestureGuard", "REQUEST_PROTECT_ME_ONRESUME indicates need not verify.");
                        fyVar.bfv.data = Integer.valueOf(16);
                        break;
                    case 2:
                        fyVar.bfv.data = Boolean.valueOf(this.gAY.ati());
                        break;
                    case 3:
                        fyVar.bfv.data = Boolean.valueOf(d.atj());
                        break;
                    case 4:
                        this.gAY.atm();
                        break;
                }
                fyVar.bfu.aXH = null;
                return false;
            }
        };
        this.gAX = new c<pr>(this) {
            final /* synthetic */ d gAY;

            {
                this.gAY = r2;
                this.nhz = pr.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(b bVar) {
                alk com_tencent_mm_protocal_c_alk = ((pr) bVar).bqX.bqY;
                b.ata();
                if (d.b(com_tencent_mm_protocal_c_alk)) {
                    v.i("MicroMsg.SubCoreGestureGuard", "tom update PatternLockInfo, sign_len:%d,valid:%b,status:%d,ver:%d", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_alk.mMm.mQu), Boolean.valueOf(d.b(com_tencent_mm_protocal_c_alk)), Integer.valueOf(com_tencent_mm_protocal_c_alk.mMn), Integer.valueOf(com_tencent_mm_protocal_c_alk.mMl)});
                    b.a(com_tencent_mm_protocal_c_alk);
                } else {
                    v.w("MicroMsg.SubCoreGestureGuard", "UserInfoExt.PatternLockInfo is null or invalid.");
                }
                return false;
            }
        };
        this.gAS = new HashSet();
    }

    public static d ath() {
        v.d("MicroMsg.SubCoreGestureGuard", "GestureGuard getCore");
        d dVar = (d) ak.yP().fY("plugin.gesture");
        if (dVar != null) {
            return dVar;
        }
        dVar = new d();
        ak.yP().a("plugin.gesture", dVar);
        return dVar;
    }

    public final void aG(boolean z) {
        v.d("MicroMsg.SubCoreGestureGuard", "GestureGuard onAccountPostReset.");
        if (!a.nhr.g(this.gAW)) {
            a.nhr.e(this.gAW);
        }
        if (!a.nhr.g(this.gAX)) {
            a.nhr.e(this.gAX);
        }
        String str = null;
        try {
            str = j.sU().getValue("PatternLockTimeInterval");
        } catch (Throwable e) {
            v.a("MicroMsg.SubCoreGestureGuard", e, "", new Object[0]);
        }
        if (be.kS(str)) {
            v.d("MicroMsg.SubCoreGestureGuard", "PatternLockInterval keeps default value.");
            a.gAO = 300;
            return;
        }
        int i = be.getInt(str, 0);
        if (i >= 0) {
            v.d("MicroMsg.SubCoreGestureGuard", String.format("Dynamic config for PatternLockInterval override default config, newval=%d", new Object[]{Integer.valueOf(i)}));
            a.gAO = i;
            return;
        }
        v.d("MicroMsg.SubCoreGestureGuard", "PatternLockInterval keeps default value.");
        a.gAO = 300;
    }

    public final void th() {
        v.d("MicroMsg.SubCoreGestureGuard", "GestureGuard onAccountRelease");
        if (a.nhr.g(this.gAW)) {
            a.nhr.f(this.gAW);
        }
        if (a.nhr.g(this.gAX)) {
            a.nhr.f(this.gAX);
        }
        this.gAS.clear();
    }

    private static byte[] ar(byte[] bArr) {
        String str = "0123456789abcdef";
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for (int i = 0; i < bArr.length - 1; i += 2) {
            byteArrayOutputStream.write((str.indexOf(Character.toLowerCase(bArr[i])) << 4) | str.indexOf(Character.toLowerCase(bArr[i + 1])));
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static void a(e eVar) {
        if (eVar.gAZ != -1) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (elapsedRealtime < eVar.gAZ) {
                eVar.gAZ = elapsedRealtime;
                eVar.gBa += elapsedRealtime;
                v.d("MicroMsg.SubCoreGestureGuard", String.format("Rebooted, need to add additional %d ms, now elapsed %d ms", new Object[]{Long.valueOf(elapsedRealtime), Long.valueOf(eVar.gBa)}));
                return;
            }
            eVar.gBa = (elapsedRealtime - eVar.gAZ) + eVar.gBa;
            eVar.gAZ = elapsedRealtime;
        }
    }

    public static boolean b(alj com_tencent_mm_protocal_c_alj) {
        if (com_tencent_mm_protocal_c_alj == null || com_tencent_mm_protocal_c_alj.mMk == null || com_tencent_mm_protocal_c_alj.mMk.mQw == null) {
            return false;
        }
        byte[] bArr = com_tencent_mm_protocal_c_alj.mMk.mQw.lVU;
        if (bArr.length == 0 || (bArr.length & 1) != 0) {
            return false;
        }
        long longValue = new o(com_tencent_mm_protocal_c_alj.uin).longValue();
        bArr = ar(bArr);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(com_tencent_mm_protocal_c_alj.version);
        if (com_tencent_mm_protocal_c_alj.mMi.mQx) {
            stringBuilder.append(new String(com_tencent_mm_protocal_c_alj.mMi.mQw.lVU));
        }
        stringBuilder.append(longValue);
        v.d("MicroMsg.SubCoreGestureGuard", String.format("verifyPatternBuffer, ret:%d", new Object[]{Integer.valueOf(UtilsJni.doEcdsaVerify(a.gAP, stringBuilder.toString().getBytes(), bArr))}));
        if (UtilsJni.doEcdsaVerify(a.gAP, stringBuilder.toString().getBytes(), bArr) != 1) {
            return false;
        }
        return true;
    }

    public static boolean b(alk com_tencent_mm_protocal_c_alk) {
        if (com_tencent_mm_protocal_c_alk == null || com_tencent_mm_protocal_c_alk.mMm == null || com_tencent_mm_protocal_c_alk.mMm.mQw == null) {
            return false;
        }
        byte[] bArr = com_tencent_mm_protocal_c_alk.mMm.mQw.lVU;
        if (bArr.length == 0 || (bArr.length & 1) != 0) {
            return false;
        }
        boolean z;
        bArr = ar(bArr);
        ak.yW();
        long longValue = new o(com.tencent.mm.model.c.ww()).longValue();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(com_tencent_mm_protocal_c_alk.mMl);
        stringBuilder.append(longValue);
        int doEcdsaVerify = UtilsJni.doEcdsaVerify(a.gAP, stringBuilder.toString().getBytes(), bArr);
        if ((doEcdsaVerify == 1 || com_tencent_mm_protocal_c_alk.mMn != 1) && !(doEcdsaVerify == 1 && com_tencent_mm_protocal_c_alk.mMn == 0)) {
            z = false;
        } else {
            z = true;
        }
        v.d("MicroMsg.SubCoreGestureGuard", String.format("verifyPatternInfo, verifyRes:%d ret:%b", new Object[]{Integer.valueOf(doEcdsaVerify), Boolean.valueOf(z)}));
        return z;
    }

    public final boolean ati() {
        int i = -1;
        if (!ak.uz() || ak.uG()) {
            v.w("MicroMsg.SubCoreGestureGuard", "not login !!");
            return false;
        }
        boolean z;
        boolean b;
        alk ate = b.ate();
        alj atd = b.atd();
        if (ate == null) {
            int i2 = 1;
        } else {
            z = false;
        }
        if (atd == null) {
            int i3 = 1;
        } else {
            boolean z2 = false;
        }
        if (i2 == 0) {
            z = b(ate);
        } else {
            z = false;
        }
        String str = "MicroMsg.SubCoreGestureGuard";
        String str2 = "tom isUserSetGesturePwd serverInfo:%s status:%d  svrinfoValid:%s";
        Object[] objArr = new Object[3];
        objArr[0] = ate;
        objArr[1] = Integer.valueOf(ate == null ? -1 : ate.mMn);
        objArr[2] = Boolean.valueOf(z);
        v.i(str, str2, objArr);
        if (i3 == 0) {
            b = b(atd);
        } else {
            b = false;
        }
        String str3 = "MicroMsg.SubCoreGestureGuard";
        str = "tom isUserSetGesturePwd localBuff:%s status:%d  localBuffValid:%s";
        Object[] objArr2 = new Object[3];
        objArr2[0] = atd;
        if (atd != null) {
            i = atd.mMj;
        }
        objArr2[1] = Integer.valueOf(i);
        objArr2[2] = Boolean.valueOf(b);
        v.i(str3, str, objArr2);
        if (z) {
            if (b) {
                try {
                    v.i("MicroMsg.SubCoreGestureGuard", "Both info & buff are valid, choose one to trust.");
                    if (ate.mMl > atd.version) {
                        v.i("MicroMsg.SubCoreGestureGuard", "srvInfoVer:%d, localBuffVer:%d, srvInfo wins.", new Object[]{Integer.valueOf(ate.mMl), Integer.valueOf(atd.version)});
                        if (ate.mMn == 1) {
                            return true;
                        }
                        return false;
                    } else if (ate.mMl == atd.version) {
                        v.i("MicroMsg.SubCoreGestureGuard", "srvInfoVer:%d, localBuffVer:%d, draw.", new Object[]{Integer.valueOf(ate.mMl), Integer.valueOf(atd.version)});
                        if (ate.mMn == 1) {
                            return true;
                        }
                        return false;
                    } else {
                        v.i("MicroMsg.SubCoreGestureGuard", "srvInfoVer:%d, localBuffVer:%d, localBuff wins.", new Object[]{Integer.valueOf(ate.mMl), Integer.valueOf(atd.version)});
                        if (atd.mMj == 1) {
                            return true;
                        }
                        return false;
                    }
                } catch (Throwable e) {
                    v.a("MicroMsg.SubCoreGestureGuard", e, "isUserSetGesturePwd throw an exception.", new Object[0]);
                    return false;
                }
            }
            v.i("MicroMsg.SubCoreGestureGuard", "Info is valid but buf is invalid, we trust info this time.");
            if (ate.mMn == 1) {
                return true;
            }
            return false;
        } else if (b) {
            v.i("MicroMsg.SubCoreGestureGuard", "Info is invalid but buff is valid, we trust buff this time.");
            if (atd.mMj == 1) {
                return true;
            }
            return false;
        } else {
            v.w("MicroMsg.SubCoreGestureGuard", "Both buff & info are invalid, do not activate this time and wait for next sync.");
            return false;
        }
    }

    public static boolean atj() {
        e asX = b.asX();
        if (asX.gAZ == -1) {
            return false;
        }
        a(asX);
        if (asX.gBa / 1000 < 600) {
            b.i(asX.gAZ, asX.gBa);
            return true;
        }
        b.asY();
        return false;
    }

    public final void dr(boolean z) {
        synchronized (this.gAV) {
            this.gAT = z;
        }
    }

    public final boolean atk() {
        boolean z;
        synchronized (this.gAV) {
            z = this.gAT;
        }
        return z;
    }

    public final void ds(boolean z) {
        synchronized (this.gAV) {
            this.gAU = z;
        }
    }

    public final boolean atl() {
        boolean z;
        synchronized (this.gAV) {
            z = this.gAU;
        }
        return z;
    }

    public final void atm() {
        synchronized (this.gAV) {
            this.gAU = true;
        }
    }

    public static byte[] aA(List<c> list) {
        if (list == null) {
            throw new IllegalArgumentException("pattern is null");
        }
        int size = list.size();
        byte[] bArr = new byte[size];
        for (int i = 0; i < size; i++) {
            c cVar = (c) list.get(i);
            bArr[i] = (byte) ((cVar.fkR + (cVar.fkQ * 3)) + 1);
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i2 = 0; i2 < size; i2++) {
            stringBuilder.append(bArr[i2]);
        }
        String stringBuilder2 = stringBuilder.toString();
        return g.m((g.m((g.m(stringBuilder2.getBytes()) + k.xF()).getBytes()) + stringBuilder2).getBytes()).getBytes();
    }

    public final HashMap<Integer, com.tencent.mm.bg.g.c> ti() {
        return null;
    }

    public final void ed(int i) {
    }

    public final void aH(boolean z) {
    }
}
