package com.tencent.mm.modelcdntran;

import android.net.wifi.WifiInfo;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.ih;
import com.tencent.mm.protocal.c.tv;
import com.tencent.mm.protocal.c.tw;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.k;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.nio.ByteBuffer;

public final class e extends k implements j {
    public static long cFA = 0;
    public static long cFB = 0;
    public static long cFC = 0;
    public static long cFz = 0;
    private final b cif;
    private com.tencent.mm.v.e cii;
    private int scene;
    public long startTime;

    public e() {
        this(0);
    }

    public e(int i) {
        this.startTime = 0;
        this.scene = 0;
        v.i("MicroMsg.NetSceneGetCDNDns", "summersafecdn init Scene:%d  [%s]", Integer.valueOf(i), be.bur());
        a aVar = new a();
        aVar.czn = new tv();
        aVar.czo = new tw();
        aVar.uri = "/cgi-bin/micromsg-bin/getcdndns";
        aVar.czm = 379;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        this.scene = i;
        ((tv) this.cif.czk.czs).mwR = SQLiteDatabase.KeyEmpty;
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.v.e eVar2) {
        this.cii = eVar2;
        ak.yW();
        int ww = c.ww();
        if (ww == 0) {
            v.e("MicroMsg.NetSceneGetCDNDns", "has not set uin.");
            return -1;
        }
        if (cFz != ((long) ww)) {
            cFz = (long) ww;
            cFA = 0;
            cFB = 0;
            cFC = 0;
        }
        long Nh = be.Nh();
        if (this.scene == 0) {
            ih is = is(SQLiteDatabase.KeyEmpty);
            ih is2 = is("sns");
            ih is3 = is("app");
            ih is4 = is("safec2c");
            byte[] it = it("c2crule");
            byte[] it2 = it("safec2crule");
            v.d("MicroMsg.NetSceneGetCDNDns", "summersafecdn doScene info[%s], safec2cinfo[%s]", is, is4);
            if (!(is == null || it == null)) {
                v.i("MicroMsg.NetSceneGetCDNDns", "cdntra getfromcache succ , setCDNDnsInfo :%b ", Boolean.valueOf(g.Ea().a(is, is2, is3, it, it2, is4)));
                if (g.Ea().a(is, is2, is3, it, it2, is4)) {
                    return -1;
                }
            }
            v.d("MicroMsg.NetSceneGetCDNDns", "cdntra doscene Sec:%d Hour[%d,%d]", Long.valueOf(Nh - cFA), Long.valueOf(Nh - cFB), Long.valueOf(cFC));
            if (Nh > cFA && Nh - cFA < 10) {
                v.w("MicroMsg.NetSceneGetCDNDns", "Last get dns at %d ago . ignore!", Long.valueOf(Nh - cFA));
                return -1;
            } else if (Nh > cFB && Nh - cFB < 3600 && cFC >= 90) {
                v.w("MicroMsg.NetSceneGetCDNDns", "in 1 hour , get dns more than 90  (%d). ignore!", Long.valueOf(Nh - cFB));
                return -1;
            }
        }
        cFA = Nh;
        if (Nh < cFB || Nh - cFC > 3600) {
            cFB = Nh;
            cFC = 0;
        } else {
            cFC++;
        }
        this.startTime = Nh;
        return a(eVar, this.cif, this);
    }

    private static String DV() {
        if (!com.tencent.mm.sdk.platformtools.ak.isConnected(aa.getContext())) {
            return null;
        }
        String str;
        if (com.tencent.mm.sdk.platformtools.ak.isWifi(aa.getContext())) {
            WifiInfo wifiInfo = com.tencent.mm.sdk.platformtools.ak.getWifiInfo(aa.getContext());
            if (wifiInfo == null) {
                return null;
            }
            str = "wifi_" + wifiInfo.getSSID();
        } else {
            str = "mobile_" + com.tencent.mm.sdk.platformtools.ak.getNetTypeString(aa.getContext()) + "_" + com.tencent.mm.sdk.platformtools.ak.getISPCode(aa.getContext());
        }
        v.d("MicroMsg.NetSceneGetCDNDns", "cdntra getCurCacheFullPath file:%s", str);
        if (str == null || str.length() < 2) {
            return null;
        }
        str = String.format("%x", new Object[]{Integer.valueOf(str.hashCode())});
        StringBuilder stringBuilder = new StringBuilder();
        g.DW();
        return stringBuilder.append(g.DX()).append(str).toString();
    }

    private static void b(byte[] bArr, String str) {
        if (be.bl(bArr)) {
            v.w("MicroMsg.NetSceneGetCDNDns", "saveToCache failed infoBuf is null");
            return;
        }
        String str2 = DV() + str;
        if (!be.kS(str2)) {
            try {
                ByteBuffer allocate = ByteBuffer.allocate(bArr.length + 8);
                allocate.putLong(be.Nh());
                allocate.put(bArr);
                com.tencent.mm.a.e.b(str2, allocate.array(), allocate.array().length);
            } catch (Throwable e) {
                v.e("MicroMsg.NetSceneGetCDNDns", "exception:%s", be.e(e));
                v.w("MicroMsg.NetSceneGetCDNDns", "saveToCache failed path:%s e:%s", str2, e.getMessage());
            }
        }
    }

    private static ih is(String str) {
        String str2 = DV() + str;
        if (be.kS(str2)) {
            return null;
        }
        byte[] d = com.tencent.mm.a.e.d(str2, 0, -1);
        if (be.bl(d)) {
            v.e("MicroMsg.NetSceneGetCDNDns", "cdntra getFromCache  read file failed:%s", str2);
            return null;
        }
        try {
            ByteBuffer wrap = ByteBuffer.wrap(d);
            if (be.Nh() - wrap.getLong() > 3600) {
                v.w("MicroMsg.NetSceneGetCDNDns", "cdntra getFromCache  file is timeout remove it :%s", str2);
                com.tencent.mm.loader.stub.b.deleteFile(str2);
                return null;
            }
            d = new byte[(d.length - 8)];
            wrap.get(d);
            return (ih) new ih().az(d);
        } catch (Throwable e) {
            v.e("MicroMsg.NetSceneGetCDNDns", "exception:%s", be.e(e));
            v.w("MicroMsg.NetSceneGetCDNDns", "parse from file failed :%s  e:%s", str2, e.getMessage());
            return null;
        }
    }

    private static byte[] it(String str) {
        String str2 = DV() + str;
        if (be.kS(str2)) {
            return null;
        }
        byte[] d = com.tencent.mm.a.e.d(str2, 0, -1);
        if (!be.bl(d)) {
            return d;
        }
        v.e("MicroMsg.NetSceneGetCDNDns", "cdntra getRuleFromCache  read file failed:%s", str2);
        return null;
    }

    private static void c(byte[] bArr, String str) {
        if (be.bl(bArr)) {
            v.w("MicroMsg.NetSceneGetCDNDns", "saveToCache failed infoBuf is null");
            return;
        }
        String str2 = DV() + str;
        if (!be.kS(str2)) {
            try {
                com.tencent.mm.a.e.b(str2, bArr, bArr.length);
            } catch (Throwable e) {
                v.e("MicroMsg.NetSceneGetCDNDns", "exception:%s", be.e(e));
                v.w("MicroMsg.NetSceneGetCDNDns", "saveRuleToCache failed path:%s e:%s", str2, e.getMessage());
            }
        }
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.d("MicroMsg.NetSceneGetCDNDns", "summersafecdn onGYNetEnd errtype:" + i2 + " errcode:" + i3);
        tw twVar = (tw) ((b) pVar).czl.czs;
        if (i2 == 0 && i3 == 0 && twVar.mwS != null) {
            byte[] bArr2 = null;
            if (twVar.mwV != null && twVar.mwV.mQu > 0) {
                v.i("MicroMsg.NetSceneGetCDNDns", "summersafecdn onGYNetEnd cdnrule:%d", Integer.valueOf(twVar.mwV.mQu));
                bArr2 = m.a(twVar.mwV);
            }
            byte[] bArr3 = null;
            if (twVar.mwW != null && twVar.mwW.mQu > 0) {
                v.i("MicroMsg.NetSceneGetCDNDns", "summersafecdn onGYNetEnd safecdnrule:%d", Integer.valueOf(twVar.mwW.mQu));
                bArr3 = m.a(twVar.mwW);
            }
            v.i("MicroMsg.NetSceneGetCDNDns", "summersafecdn onGYNetEnd FakeDnsInfo:%s", twVar.mwX);
            if (twVar.mwX != null) {
                v.i("MicroMsg.NetSceneGetCDNDns", "summersafecdn onGYNetEnd FakeDnsInfo FakeUin:%d NewAuthKey:%s", Integer.valueOf(twVar.mwX.fvo), twVar.mwX.mjy);
            }
            if (g.Ea().a(twVar.mwS, twVar.mwT, twVar.mwU, bArr2, bArr3, twVar.mwX)) {
                byte[] toByteArray;
                try {
                    toByteArray = twVar.mwS.toByteArray();
                } catch (Throwable e) {
                    v.w("MicroMsg.NetSceneGetCDNDns", "onGYNetEnd getDnsInfo toByteArray failed: %s", e.getMessage());
                    v.e("MicroMsg.NetSceneGetCDNDns", "exception:%s", be.e(e));
                    toByteArray = null;
                }
                b(toByteArray, SQLiteDatabase.KeyEmpty);
                try {
                    toByteArray = twVar.mwT.toByteArray();
                } catch (Throwable e2) {
                    v.w("MicroMsg.NetSceneGetCDNDns", "onGYNetEnd getsnsDnsInfo toByteArray failed: %s", e2.getMessage());
                    v.e("MicroMsg.NetSceneGetCDNDns", "exception:%s", be.e(e2));
                    toByteArray = null;
                }
                b(toByteArray, "sns");
                try {
                    toByteArray = twVar.mwU.toByteArray();
                } catch (Throwable e22) {
                    v.w("MicroMsg.NetSceneGetCDNDns", "onGYNetEnd getappDnsInfo toByteArray failed: %s", e22.getMessage());
                    v.e("MicroMsg.NetSceneGetCDNDns", "exception:%s", be.e(e22));
                    toByteArray = null;
                }
                b(toByteArray, "app");
                try {
                    toByteArray = twVar.mwX.toByteArray();
                } catch (Throwable e222) {
                    v.w("MicroMsg.NetSceneGetCDNDns", "onGYNetEnd getappDnsInfo toByteArray failed: %s", e222.getMessage());
                    v.e("MicroMsg.NetSceneGetCDNDns", "exception:%s", be.e(e222));
                    toByteArray = null;
                }
                b(toByteArray, "safec2c");
                if (bArr2 != null) {
                    c(bArr2, "c2crule");
                }
                if (bArr3 != null) {
                    c(bArr3, "safec2crule");
                }
                this.cii.a(i2, i3, str, this);
                return;
            }
            v.e("MicroMsg.NetSceneGetCDNDns", "onGYNetEnd setCDNDnsInfo failed ");
            this.cii.a(i2, i3, str, this);
            return;
        }
        g.iuh.h(10769, Integer.valueOf(d.cFy), Integer.valueOf(0), Long.valueOf(this.startTime));
        String str2 = "MicroMsg.NetSceneGetCDNDns";
        String str3 = "onGYNetEnd: [%d ,%d]  info is null :%b";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i2);
        objArr[1] = Integer.valueOf(i3);
        objArr[2] = Boolean.valueOf(twVar.mwS == null);
        v.w(str2, str3, objArr);
        this.cii.a(i2, i3, str, this);
    }

    public final int getType() {
        return 379;
    }
}
