package com.tencent.mm.plugin.webview.d;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.RemoteException;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public final class ai {
    private static int leO = 0;
    private static int leP = 0;
    public l leC;
    public j leD;
    public k leE;
    public i leF;
    public e leG;
    public a leH;
    public f leI;
    public c leJ;
    private d leK;
    private h leL;
    private g leM;
    private b leN;

    public static class a {
        public String bpX;
        public boolean leQ = false;
        public boolean leR = false;
    }

    public static class b {
        public boolean leS = false;
        public boolean leT = false;
    }

    public static class c {
        public Object[] leU = null;

        public final void a(com.tencent.mm.plugin.webview.stub.d dVar) {
            if (dVar != null) {
                com.tencent.mm.plugin.webview.ui.tools.d.a(dVar, 11577, this.leU);
            }
        }
    }

    public class d {
        public int bsZ;
        public String ldY = "";
        public HashMap<String, Long> leV = new HashMap();
        public HashMap<String, Long> leW = new HashMap();
        public boolean leX = true;
        public String leY;
        final /* synthetic */ ai leZ;

        public d(ai aiVar) {
            this.leZ = aiVar;
        }

        public final void a(com.tencent.mm.plugin.webview.stub.d dVar) {
            if (dVar != null) {
                String str;
                long longValue;
                Object[] objArr;
                int bip = ai.bip();
                for (Entry entry : this.leV.entrySet()) {
                    str = (String) entry.getKey();
                    longValue = ((Long) entry.getValue()).longValue();
                    if (longValue >= 0 && longValue <= 180000) {
                        objArr = new Object[11];
                        objArr[0] = Integer.valueOf(5);
                        objArr[1] = Long.valueOf(longValue);
                        objArr[2] = Integer.valueOf(bip);
                        if (str != null) {
                            str = str.replace(",", "!");
                        }
                        objArr[3] = str;
                        objArr[4] = Integer.valueOf(0);
                        objArr[5] = Integer.valueOf(0);
                        objArr[6] = Integer.valueOf(0);
                        objArr[7] = Integer.valueOf(ai.leO);
                        objArr[8] = Integer.valueOf(ai.leP);
                        objArr[9] = Integer.valueOf(this.bsZ);
                        objArr[10] = this.leY;
                        com.tencent.mm.plugin.webview.ui.tools.d.a(dVar, 11215, objArr);
                        if (ai.leO == 1) {
                            com.tencent.mm.plugin.report.service.g.iuh.a(32, 18, 1, true);
                            com.tencent.mm.plugin.report.service.g.iuh.a(32, 19, longValue, true);
                        }
                        com.tencent.mm.plugin.report.service.g.iuh.a(32, 8, 1, true);
                        com.tencent.mm.plugin.report.service.g.iuh.a(32, 9, longValue, true);
                        v.i("MicroMsg.WebviewReporter", "WebViewRenderReporter.report DomReady cost time : %d, netType : %d, coreType %d, httpType %d, getA8KeyScene:%d, prePublishid:%s", new Object[]{Long.valueOf(longValue), Integer.valueOf(bip), Integer.valueOf(ai.leO), Integer.valueOf(ai.leP), Integer.valueOf(this.bsZ), this.leY});
                    } else {
                        return;
                    }
                }
                for (Entry entry2 : this.leW.entrySet()) {
                    str = (String) entry2.getKey();
                    longValue = ((Long) entry2.getValue()).longValue();
                    if (longValue >= 0 && longValue <= 180000) {
                        objArr = new Object[11];
                        objArr[0] = Integer.valueOf(6);
                        objArr[1] = Long.valueOf(longValue);
                        objArr[2] = Integer.valueOf(bip);
                        if (str != null) {
                            str = str.replace(",", "!");
                        }
                        objArr[3] = str;
                        objArr[4] = Integer.valueOf(0);
                        objArr[5] = Integer.valueOf(0);
                        objArr[6] = Integer.valueOf(0);
                        objArr[7] = Integer.valueOf(ai.leO);
                        objArr[8] = Integer.valueOf(ai.leP);
                        objArr[9] = Integer.valueOf(this.bsZ);
                        objArr[10] = this.leY;
                        com.tencent.mm.plugin.webview.ui.tools.d.a(dVar, 11215, objArr);
                        if (ai.leO == 1) {
                            com.tencent.mm.plugin.report.service.g.iuh.a(32, 20, 1, true);
                            com.tencent.mm.plugin.report.service.g.iuh.a(32, 21, longValue, true);
                        }
                        com.tencent.mm.plugin.report.service.g.iuh.a(32, 10, 1, true);
                        com.tencent.mm.plugin.report.service.g.iuh.a(32, 11, longValue, true);
                        v.i("MicroMsg.WebviewReporter", "WebViewRenderReporter.report Render cost time : %d, netType : %d, coreType %d, httpType %d, getA8KeyScene:%d, prePublishid:%s", new Object[]{Long.valueOf(longValue), Integer.valueOf(bip), Integer.valueOf(ai.leO), Integer.valueOf(ai.leP), Integer.valueOf(this.bsZ), this.leY});
                    } else {
                        return;
                    }
                }
            }
        }
    }

    public class e {
        public int bsZ;
        public boolean eyP = false;
        public String leY;
        final /* synthetic */ ai leZ;
        public long startTime = be.Ni();
        public String url;

        public e(ai aiVar) {
            this.leZ = aiVar;
        }
    }

    public static class f {
        public Object[] leU = null;

        public final void a(com.tencent.mm.plugin.webview.stub.d dVar) {
            if (dVar != null) {
                com.tencent.mm.plugin.webview.ui.tools.d.a(dVar, 11576, this.leU);
            }
        }
    }

    public static class g {
        public List<String> lfa;
    }

    public static class h {
        public List<String> lfa;
    }

    public static class i {
        public String appId;
        public String bNx;
        long bYN = (System.currentTimeMillis() / 1000);
        public String bpX;
        public String jGu;
        public long jxX;
        public String lfb;
        public String lfc;
        public long lfd;
        public int lfe;
        public String lff;
        public String lfg;
        public String lfh;
        public String lfi;
        public int lfj;
        public long lfk = -1;
        public int scene;
        public String title;
        public String username;
    }

    public class j {
        public int bsZ;
        public String leY;
        final /* synthetic */ ai leZ;
        public HashMap<String, Long> lfl = new HashMap();

        public j(ai aiVar) {
            this.leZ = aiVar;
        }

        public final void aw(String str, boolean z) {
            if (be.kS(str)) {
                v.e("MicroMsg.WebviewReporter", "WebviewOpenUrl.stopLoadUrl failed, url is null");
            } else if (!this.lfl.containsKey(str)) {
            } else {
                if (z) {
                    this.lfl.put(str, Long.valueOf(be.Ni() - ((Long) this.lfl.get(str)).longValue()));
                    return;
                }
                this.lfl.put(str, Long.valueOf(-1));
            }
        }

        public final void a(com.tencent.mm.plugin.webview.stub.d dVar) {
            if (dVar != null) {
                int bip = ai.bip();
                for (Entry entry : this.lfl.entrySet()) {
                    String str = (String) entry.getKey();
                    long longValue = ((Long) entry.getValue()).longValue();
                    com.tencent.mm.plugin.report.service.g.iuh.a(32, 2, 1, true);
                    if (longValue == -1) {
                        com.tencent.mm.plugin.report.service.g.iuh.a(32, 13, 1, true);
                        v.i("MicroMsg.WebviewReporter", "WebviewGetA8keyReporter.report fail url : %s, netType : %d", new Object[]{str, Integer.valueOf(bip)});
                    }
                    if (longValue >= 0 && longValue <= 60000) {
                        Object[] objArr = new Object[11];
                        objArr[0] = Integer.valueOf(2);
                        objArr[1] = Long.valueOf(longValue);
                        objArr[2] = Integer.valueOf(bip);
                        objArr[3] = str == null ? str : str.replace(",", "!");
                        objArr[4] = Integer.valueOf(0);
                        objArr[5] = Integer.valueOf(0);
                        objArr[6] = Integer.valueOf(0);
                        objArr[7] = Integer.valueOf(ai.leO);
                        objArr[8] = Integer.valueOf(ai.leP);
                        objArr[9] = Integer.valueOf(this.bsZ);
                        objArr[10] = this.leY;
                        com.tencent.mm.plugin.webview.ui.tools.d.a(dVar, 11215, objArr);
                        v.i("MicroMsg.WebviewReporter", "WebviewGetA8keyReporter.report url : %s, cost time : %d, netType : %d, getA8KeyScene:%d, prePublishid:%s", new Object[]{str, Long.valueOf(longValue), Integer.valueOf(bip), Integer.valueOf(this.bsZ), this.leY});
                        com.tencent.mm.plugin.report.service.g.iuh.a(32, 6, longValue, true);
                    }
                }
            }
        }
    }

    public class k {
        public int bsZ;
        public String leY;
        final /* synthetic */ ai leZ;
        public HashMap<String, Long> lfm = new HashMap();

        public k(ai aiVar) {
            this.leZ = aiVar;
        }
    }

    public class l {
        public boolean bbq = true;
        public int bsZ;
        public long fVN;
        public String leY;
        final /* synthetic */ ai leZ;
        public String url;

        public l(ai aiVar) {
            this.leZ = aiVar;
        }
    }

    public static int bip() {
        switch (ak.getNetType(aa.getContext())) {
            case -1:
                return 255;
            case 0:
                return 1;
            case 1:
            case 6:
            case 8:
                return 3;
            case 2:
            case 5:
            case 7:
                return 2;
            case 3:
            case 4:
                return 4;
            case 10:
                return 5;
            default:
                return 6;
        }
    }

    public static String biq() {
        ConnectivityManager connectivityManager = (ConnectivityManager) aa.getContext().getSystemService("connectivity");
        if (connectivityManager == null) {
            return "no";
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            return "no";
        }
        if (activeNetworkInfo.getType() == 1) {
            return "WIFI";
        }
        v.d("MicroMsg.WebviewReporter", "activeNetInfo extra=%s, type=%d, %s", new Object[]{activeNetworkInfo.getExtraInfo(), Integer.valueOf(activeNetworkInfo.getType()), activeNetworkInfo.getExtraInfo()});
        if (activeNetworkInfo.getExtraInfo() != null) {
            return activeNetworkInfo.getExtraInfo().toLowerCase();
        }
        return "no";
    }

    public final l bir() {
        if (this.leC == null) {
            this.leC = new l(this);
        }
        return this.leC;
    }

    public final j bis() {
        if (this.leD == null) {
            this.leD = new j(this);
        }
        return this.leD;
    }

    public final k bit() {
        if (this.leE == null) {
            this.leE = new k(this);
        }
        return this.leE;
    }

    public final d biu() {
        if (this.leK == null) {
            this.leK = new d(this);
        }
        return this.leK;
    }

    public final i biv() {
        if (this.leF == null) {
            this.leF = new i();
        }
        return this.leF;
    }

    public final e biw() {
        if (this.leG == null) {
            this.leG = new e(this);
        }
        return this.leG;
    }

    public final a bix() {
        if (this.leH == null) {
            this.leH = new a();
        }
        return this.leH;
    }

    public final f biy() {
        if (this.leI == null) {
            this.leI = new f();
        }
        return this.leI;
    }

    public final c biz() {
        if (this.leJ == null) {
            this.leJ = new c();
        }
        return this.leJ;
    }

    public final h biA() {
        if (this.leL == null) {
            this.leL = new h();
        }
        return this.leL;
    }

    public final g biB() {
        if (this.leM == null) {
            this.leM = new g();
        }
        return this.leM;
    }

    public final b biC() {
        if (this.leN == null) {
            this.leN = new b();
        }
        return this.leN;
    }

    public static void y(boolean z, boolean z2) {
        if (z) {
            leO = 1;
        } else {
            leO = 0;
        }
        if (z2) {
            leP = 1;
        } else {
            leP = 0;
        }
    }

    public final void a(com.tencent.mm.plugin.webview.stub.d dVar) {
        k bit = bit();
        if (dVar != null) {
            int bip = bip();
            for (Entry entry : bit.lfm.entrySet()) {
                String str = (String) entry.getKey();
                long longValue = ((Long) entry.getValue()).longValue();
                com.tencent.mm.plugin.report.service.g.iuh.a(32, 0, 1, true);
                if (longValue >= 0 && longValue <= 180000) {
                    Object[] objArr = new Object[11];
                    objArr[0] = Integer.valueOf(3);
                    objArr[1] = Long.valueOf(longValue);
                    objArr[2] = Integer.valueOf(bip);
                    objArr[3] = str == null ? str : str.replace(",", "!");
                    objArr[4] = Integer.valueOf(0);
                    objArr[5] = Integer.valueOf(0);
                    objArr[6] = Integer.valueOf(0);
                    objArr[7] = Integer.valueOf(leO);
                    objArr[8] = Integer.valueOf(leP);
                    objArr[9] = Integer.valueOf(bit.bsZ);
                    objArr[10] = bit.leY;
                    com.tencent.mm.plugin.webview.ui.tools.d.a(dVar, 11215, objArr);
                    com.tencent.mm.plugin.report.service.g.iuh.a(160, 0, 1, false);
                    if (-1 != com.tencent.mm.plugin.webview.ui.tools.a.dx(longValue)) {
                        com.tencent.mm.plugin.report.service.g.iuh.a(160, (long) com.tencent.mm.plugin.webview.ui.tools.a.dx(longValue), 1, false);
                    }
                    com.tencent.mm.plugin.report.service.g.iuh.a(32, 3, 1, true);
                    com.tencent.mm.plugin.report.service.g.iuh.a(32, 7, longValue, true);
                    if (leP == 1) {
                        com.tencent.mm.plugin.report.service.g.iuh.a(32, 16, 1, true);
                        com.tencent.mm.plugin.report.service.g.iuh.a(32, 17, longValue, true);
                    }
                    v.i("MicroMsg.WebviewReporter", "WebviewOpenUrlReporter.report url : %s, cost time : %d, netType : %d, %d, %d, getA8KeyScene:%d, prePublishid:%s", new Object[]{str, Long.valueOf(longValue), Integer.valueOf(bip), Integer.valueOf(leO), Integer.valueOf(leP), Integer.valueOf(bit.bsZ), bit.leY});
                }
            }
        }
        i biv = biv();
        if (!be.kS(biv.lfc)) {
            v.d("MicroMsg.WebviewReporter", "WebViewVisitReporter report viewID = %s", new Object[]{biv.lfc});
        }
        if (dVar != null) {
            String str2 = "";
            try {
                Bundle i = dVar.i(23, new Bundle(0));
                if (i != null) {
                    str2 = i.getString("config_info_username");
                }
            } catch (RemoteException e) {
                v.w("MicroMsg.WebviewReporter", "invokeAsResult error, %s", new Object[]{e});
            }
            PString pString = new PString();
            v.d("MicroMsg.WebviewReporter", "report 10643(%s), username : %s, msgId : %s, msgIndex : %s, scene : %s, enterTime : %s, stayTime : %s, rawUrl : %s, publisher : %s, viewId : %s, publishId : %s,appId : %s, newMsgId : %s, preUsername : %s, curUsername : %s, referUrl : %s, statExtStr:%s(%s), chatType:%d, title:%s, expidstr[chatting_exp]:%s, sourceAppId:%s", new Object[]{Integer.valueOf(10643), biv.username, Long.valueOf(biv.lfd), Integer.valueOf(biv.lfe), Integer.valueOf(biv.scene), Long.valueOf(biv.bYN), Long.valueOf(biv.jxX), biv.bpX, biv.lfb, biv.lfc, biv.lff, biv.appId, biv.lfg, biv.lfh, str2, biv.lfi, biv.jGu, o.b(biv.jGu, pString), Integer.valueOf(biv.lfj), biv.title, biv.bNx, pString.value});
            String str3 = biv.title;
            try {
                str3 = URLEncoder.encode(biv.title, "UTF-8");
            } catch (Throwable e2) {
                v.a("MicroMsg.WebviewReporter", e2, "", new Object[0]);
            }
            Object[] objArr2 = new Object[20];
            objArr2[0] = biv.username;
            objArr2[1] = Long.valueOf(biv.lfd);
            objArr2[2] = Integer.valueOf(biv.lfe);
            objArr2[3] = Integer.valueOf(biv.scene);
            objArr2[4] = Long.valueOf(biv.bYN);
            objArr2[5] = Long.valueOf(biv.jxX);
            objArr2[6] = biv.bpX == null ? biv.bpX : biv.bpX.replace(",", "!");
            objArr2[7] = biv.lfb;
            objArr2[8] = biv.lfc;
            objArr2[9] = biv.lff;
            objArr2[10] = biv.appId;
            objArr2[11] = biv.lfg;
            objArr2[12] = biv.lfh;
            objArr2[13] = str2;
            objArr2[14] = biv.lfi == null ? biv.lfi : biv.lfi.replace(",", "!");
            objArr2[15] = r7;
            objArr2[16] = Integer.valueOf(biv.lfj);
            objArr2[17] = str3;
            objArr2[18] = biv.bNx;
            objArr2[19] = pString.value;
            com.tencent.mm.plugin.webview.ui.tools.d.a(dVar, 10643, objArr2);
        }
        bis().a(dVar);
        biu().a(dVar);
        a bix = bix();
        if (dVar != null) {
            int bip2 = bip();
            if (!bix.leR) {
                com.tencent.mm.plugin.webview.ui.tools.d.a(dVar, 11575, bix.bpX, Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(bip2));
            } else if (bix.leQ) {
                com.tencent.mm.plugin.webview.ui.tools.d.a(dVar, 11575, bix.bpX, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(bip2));
            } else {
                com.tencent.mm.plugin.webview.ui.tools.d.a(dVar, 11575, bix.bpX, Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(bip2));
            }
        }
    }
}
