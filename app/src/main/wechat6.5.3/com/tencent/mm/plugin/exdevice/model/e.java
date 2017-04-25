package com.tencent.mm.plugin.exdevice.model;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Base64;
import com.tencent.mm.ae.d;
import com.tencent.mm.ae.n;
import com.tencent.mm.as.o;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.compatible.d.r;
import com.tencent.mm.e.a.cc;
import com.tencent.mm.e.a.cd;
import com.tencent.mm.e.a.ce;
import com.tencent.mm.e.a.cf;
import com.tencent.mm.e.a.cg;
import com.tencent.mm.e.a.ch;
import com.tencent.mm.e.a.ci;
import com.tencent.mm.e.a.cj;
import com.tencent.mm.e.a.ck;
import com.tencent.mm.e.a.cl;
import com.tencent.mm.e.a.cm;
import com.tencent.mm.e.a.cn;
import com.tencent.mm.e.a.co;
import com.tencent.mm.e.a.cp;
import com.tencent.mm.e.a.cr;
import com.tencent.mm.e.a.cx;
import com.tencent.mm.e.a.cz;
import com.tencent.mm.e.a.da;
import com.tencent.mm.e.a.db;
import com.tencent.mm.e.a.dc;
import com.tencent.mm.e.a.dd;
import com.tencent.mm.e.a.de;
import com.tencent.mm.e.a.dg;
import com.tencent.mm.e.a.dh;
import com.tencent.mm.e.a.di;
import com.tencent.mm.e.a.dk;
import com.tencent.mm.e.a.dl;
import com.tencent.mm.e.a.dm;
import com.tencent.mm.e.a.dn;
import com.tencent.mm.e.a.do;
import com.tencent.mm.e.a.dq;
import com.tencent.mm.e.a.dr;
import com.tencent.mm.e.a.ds;
import com.tencent.mm.e.a.dt;
import com.tencent.mm.e.a.du;
import com.tencent.mm.e.a.dv;
import com.tencent.mm.e.a.dw;
import com.tencent.mm.e.a.em;
import com.tencent.mm.e.a.gs;
import com.tencent.mm.e.a.hr;
import com.tencent.mm.e.a.ht;
import com.tencent.mm.e.a.hu;
import com.tencent.mm.e.a.jf;
import com.tencent.mm.e.a.jh;
import com.tencent.mm.e.a.jk;
import com.tencent.mm.e.a.os;
import com.tencent.mm.e.a.ot;
import com.tencent.mm.e.a.ox;
import com.tencent.mm.e.b.bk;
import com.tencent.mm.h.j;
import com.tencent.mm.model.ak;
import com.tencent.mm.modelbiz.BizInfo;
import com.tencent.mm.modelbiz.BizInfo.ExtInfo;
import com.tencent.mm.modelcdntran.g;
import com.tencent.mm.modelcdntran.h;
import com.tencent.mm.plugin.c.a.b.a.f;
import com.tencent.mm.plugin.exdevice.h.b;
import com.tencent.mm.plugin.exdevice.i.i;
import com.tencent.mm.plugin.exdevice.i.k;
import com.tencent.mm.plugin.exdevice.jni.Java2CExDevice;
import com.tencent.mm.plugin.exdevice.service.ExDeviceService;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.protocal.c.abt;
import com.tencent.mm.protocal.c.acj;
import com.tencent.mm.protocal.c.ack;
import com.tencent.mm.protocal.c.acm;
import com.tencent.mm.protocal.c.acn;
import com.tencent.mm.protocal.c.aco;
import com.tencent.mm.protocal.c.aib;
import com.tencent.mm.protocal.c.azr;
import com.tencent.mm.protocal.c.wk;
import com.tencent.mm.protocal.c.wm;
import com.tencent.mm.protocal.c.wn;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tencent.tmassistantsdk.logreport.BaseReportManager;
import com.tencent.tmassistantsdk.logreport.UpdateInfoReportManager.UpdateLogConst;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class e {
    private static int ftg = 0;
    private static int fth = 0;
    public com.tencent.mm.sdk.c.c dzX = new com.tencent.mm.sdk.c.c<hr>(this) {
        final /* synthetic */ e fti;

        {
            this.fti = r2;
            this.nhz = hr.class.getName().hashCode();
        }

        public final /* bridge */ /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            return false;
        }
    };
    public com.tencent.mm.sdk.c.c fsA = new com.tencent.mm.sdk.c.c<cx>(this) {
        final /* synthetic */ e fti;

        {
            this.fti = r2;
            this.nhz = cx.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            return e.o((cx) bVar);
        }
    };
    public com.tencent.mm.sdk.c.c fsB = new com.tencent.mm.sdk.c.c<cl>(this) {
        final /* synthetic */ e fti;

        {
            this.fti = r2;
            this.nhz = cl.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            return e.e((cl) bVar);
        }
    };
    public com.tencent.mm.sdk.c.c fsC = new com.tencent.mm.sdk.c.c<dk>(this) {
        final /* synthetic */ e fti;

        {
            this.fti = r2;
            this.nhz = dk.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            return e.q((dk) bVar);
        }
    };
    public com.tencent.mm.sdk.c.c fsD = new com.tencent.mm.sdk.c.c<dr>(this) {
        final /* synthetic */ e fti;

        {
            this.fti = r2;
            this.nhz = dr.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            return e.f(this.fti, (dr) bVar);
        }
    };
    public com.tencent.mm.sdk.c.c fsE = new com.tencent.mm.sdk.c.c<dn>(this) {
        final /* synthetic */ e fti;

        {
            this.fti = r2;
            this.nhz = dn.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            return e.g(this.fti, (dn) bVar);
        }
    };
    public com.tencent.mm.sdk.c.c fsF = new com.tencent.mm.sdk.c.c<ds>(this) {
        final /* synthetic */ e fti;

        {
            this.fti = r2;
            this.nhz = ds.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            return e.h(this.fti, (ds) bVar);
        }
    };
    public com.tencent.mm.sdk.c.c fsG = new com.tencent.mm.sdk.c.c<dm>(this) {
        final /* synthetic */ e fti;

        {
            this.fti = r2;
            this.nhz = dm.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            return e.i(this.fti, (dm) bVar);
        }
    };
    public com.tencent.mm.sdk.c.c fsH = new com.tencent.mm.sdk.c.c<dt>(this) {
        final /* synthetic */ e fti;

        {
            this.fti = r2;
            this.nhz = dt.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            dt dtVar = (dt) bVar;
            if (dtVar == null || !(dtVar instanceof dt)) {
                v.e("MicroMsg.exdevice.ExdeviceEventManager", "event is not instanceof ExDeviceSimpleBTUploadDataToServerEvent");
                return false;
            }
            dtVar = dtVar;
            if (e.c(dtVar.bbL.mac, dtVar.bbL.aZU, dtVar.bbL.data)) {
                dtVar.bbM.aZW = true;
                return true;
            }
            dtVar.bbM.aZW = false;
            return true;
        }
    };
    public com.tencent.mm.sdk.c.c fsI = new com.tencent.mm.sdk.c.c<cf>(this) {
        final /* synthetic */ e fti;

        {
            this.fti = r2;
            this.nhz = cf.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            return e.r((cf) bVar);
        }
    };
    public com.tencent.mm.sdk.c.c fsJ = new com.tencent.mm.sdk.c.c<ce>(this) {
        final /* synthetic */ e fti;

        {
            this.fti = r2;
            this.nhz = ce.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            return e.s((ce) bVar);
        }
    };
    public com.tencent.mm.sdk.c.c fsK = new com.tencent.mm.sdk.c.c<ck>(this) {
        final /* synthetic */ e fti;

        {
            this.fti = r2;
            this.nhz = ck.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            return e.t((ck) bVar);
        }
    };
    public com.tencent.mm.sdk.c.c fsL = new com.tencent.mm.sdk.c.c<jf>(this) {
        final /* synthetic */ e fti;

        {
            this.fti = r2;
            this.nhz = jf.class.getName().hashCode();
        }

        public final /* bridge */ /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            return e.a((jf) bVar);
        }
    };
    public com.tencent.mm.sdk.c.c fsM = new com.tencent.mm.sdk.c.c<com.tencent.mm.e.a.v>(this) {
        final /* synthetic */ e fti;

        {
            this.fti = r2;
            this.nhz = com.tencent.mm.e.a.v.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            return e.aiT();
        }
    };
    public com.tencent.mm.sdk.c.c fsN = new com.tencent.mm.sdk.c.c<jh>(this) {
        final /* synthetic */ e fti;

        {
            this.fti = r2;
            this.nhz = jh.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            return e.aiW();
        }
    };
    public com.tencent.mm.sdk.c.c fsO = new com.tencent.mm.sdk.c.c<cp>(this) {
        final /* synthetic */ e fti;

        {
            this.fti = r2;
            this.nhz = cp.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            return e.j(this.fti, (cp) bVar);
        }
    };
    public com.tencent.mm.sdk.c.c fsP = new com.tencent.mm.sdk.c.c<cn>(this) {
        final /* synthetic */ e fti;

        {
            this.fti = r2;
            this.nhz = cn.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            return e.k(this.fti, (cn) bVar);
        }
    };
    public com.tencent.mm.sdk.c.c fsQ = new com.tencent.mm.sdk.c.c<di>(this) {
        final /* synthetic */ e fti;

        {
            this.fti = r2;
            this.nhz = di.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            return e.l(this.fti, (di) bVar);
        }
    };
    public com.tencent.mm.sdk.c.c fsR = new com.tencent.mm.sdk.c.c<dv>(this) {
        final /* synthetic */ e fti;

        {
            this.fti = r2;
            this.nhz = dv.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            return e.m(this.fti, (dv) bVar);
        }
    };
    public com.tencent.mm.sdk.c.c fsS = new com.tencent.mm.sdk.c.c<dl>(this) {
        final /* synthetic */ e fti;

        {
            this.fti = r2;
            this.nhz = dl.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            return e.u((dl) bVar);
        }
    };
    public com.tencent.mm.sdk.c.c fsT = new com.tencent.mm.sdk.c.c<cd>(this) {
        final /* synthetic */ e fti;

        {
            this.fti = r2;
            this.nhz = cd.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            return e.n(this.fti, (cd) bVar);
        }
    };
    public com.tencent.mm.sdk.c.c fsU = new com.tencent.mm.sdk.c.c<dd>(this) {
        final /* synthetic */ e fti;

        {
            this.fti = r2;
            this.nhz = dd.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            return e.o(this.fti, (dd) bVar);
        }
    };
    public com.tencent.mm.sdk.c.c fsV = new com.tencent.mm.sdk.c.c<du>(this) {
        final /* synthetic */ e fti;

        {
            this.fti = r2;
            this.nhz = du.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            return e.p(this.fti, (du) bVar);
        }
    };
    public com.tencent.mm.sdk.c.c fsW = new com.tencent.mm.sdk.c.c<ch>(this) {
        final /* synthetic */ e fti;

        {
            this.fti = r2;
            this.nhz = ch.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            return e.q(this.fti, (ch) bVar);
        }
    };
    public com.tencent.mm.sdk.c.c fsX = new com.tencent.mm.sdk.c.c<dh>(this) {
        final /* synthetic */ e fti;

        {
            this.fti = r2;
            this.nhz = dh.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            return e.r(this.fti, (dh) bVar);
        }
    };
    public com.tencent.mm.sdk.c.c fsY = new com.tencent.mm.sdk.c.c<cm>(this) {
        final /* synthetic */ e fti;

        {
            this.fti = r2;
            this.nhz = cm.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            return this.fti.d((com.tencent.mm.sdk.c.b) (cm) bVar);
        }
    };
    public com.tencent.mm.sdk.c.c fsZ = new com.tencent.mm.sdk.c.c<em>(this) {
        final /* synthetic */ e fti;

        {
            this.fti = r2;
            this.nhz = em.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            return this.fti.c((com.tencent.mm.sdk.c.b) (em) bVar);
        }
    };
    List<b> fsj = new LinkedList();
    Map<String, b> fsk = new HashMap();
    public com.tencent.mm.sdk.c.c fsl = new com.tencent.mm.sdk.c.c<hu>(this) {
        final /* synthetic */ e fti;

        {
            this.fti = r2;
            this.nhz = hu.class.getName().hashCode();
        }

        public final /* bridge */ /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            return e.a(this.fti, (hu) bVar);
        }
    };
    public com.tencent.mm.sdk.c.c fsm = new com.tencent.mm.sdk.c.c<ht>(this) {
        final /* synthetic */ e fti;

        {
            this.fti = r2;
            this.nhz = ht.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            return u.ajW().a(new i(((ht) ((ht) bVar)).bhE.opType));
        }
    };
    public com.tencent.mm.sdk.c.c fsn = new com.tencent.mm.sdk.c.c<dc>(this) {
        final /* synthetic */ e fti;

        {
            this.fti = r2;
            this.nhz = dc.class.getName().hashCode();
        }

        public final /* bridge */ /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            return e.a(this.fti, (dc) bVar);
        }
    };
    public com.tencent.mm.sdk.c.c fso = new com.tencent.mm.sdk.c.c<cc>(this) {
        final /* synthetic */ e fti;

        {
            this.fti = r2;
            this.nhz = cc.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            return e.j((cc) bVar);
        }
    };
    public com.tencent.mm.sdk.c.c fsp = new com.tencent.mm.sdk.c.c<dw>(this) {
        final /* synthetic */ e fti;

        {
            this.fti = r2;
            this.nhz = dw.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            return e.k((dw) bVar);
        }
    };
    public com.tencent.mm.sdk.c.c fsq = new com.tencent.mm.sdk.c.c<os>(this) {
        final /* synthetic */ e fti;

        {
            this.fti = r2;
            this.nhz = os.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            return e.aiU();
        }
    };
    public com.tencent.mm.sdk.c.c fsr = new com.tencent.mm.sdk.c.c<ot>(this) {
        final /* synthetic */ e fti;

        {
            this.fti = r2;
            this.nhz = ot.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            return e.l((ot) bVar);
        }
    };
    public com.tencent.mm.sdk.c.c fss = new com.tencent.mm.sdk.c.c<ox>(this) {
        final /* synthetic */ e fti;

        {
            this.fti = r2;
            this.nhz = ox.class.getName().hashCode();
        }

        public final /* bridge */ /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            return e.a(this.fti);
        }
    };
    public com.tencent.mm.sdk.c.c fst = new com.tencent.mm.sdk.c.c<cj>(this) {
        final /* synthetic */ e fti;

        {
            this.fti = r2;
            this.nhz = cj.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            return e.cM(((cj) bVar).bac.bad);
        }
    };
    public com.tencent.mm.sdk.c.c fsu = new com.tencent.mm.sdk.c.c<cr>(this) {
        final /* synthetic */ e fti;

        {
            this.fti = r2;
            this.nhz = cr.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            return e.m((cr) bVar);
        }
    };
    public com.tencent.mm.sdk.c.c fsv = new com.tencent.mm.sdk.c.c<de>(this) {
        final /* synthetic */ e fti;

        {
            this.fti = r2;
            this.nhz = de.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            return this.fti.h((de) bVar);
        }
    };
    public com.tencent.mm.sdk.c.c fsw = new com.tencent.mm.sdk.c.c<co>(this) {
        final /* synthetic */ e fti;

        {
            this.fti = r2;
            this.nhz = co.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            return this.fti.g((co) bVar);
        }
    };
    public com.tencent.mm.sdk.c.c fsx = new com.tencent.mm.sdk.c.c<cg>(this) {
        final /* synthetic */ e fti;

        {
            this.fti = r2;
            this.nhz = cg.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            return e.d(this.fti, (cg) bVar);
        }
    };
    public com.tencent.mm.sdk.c.c fsy = new com.tencent.mm.sdk.c.c<ci>(this) {
        final /* synthetic */ e fti;

        {
            this.fti = r2;
            this.nhz = ci.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            return e.n((ci) bVar);
        }
    };
    public com.tencent.mm.sdk.c.c fsz = new com.tencent.mm.sdk.c.c<dg>(this) {
        final /* synthetic */ e fti;

        {
            this.fti = r2;
            this.nhz = dg.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            return e.f((dg) bVar);
        }
    };
    ExdeviceWCLanSDKUtil fta;
    private String ftb = null;
    g ftc;
    private final long ftd = 300000;
    private boolean fte = false;
    private c ftf;
    ac mHandler;

    public interface b {
        void b(String str, int i, long j);

        void c(String str, byte[] bArr, boolean z);

        void h(String str, String str2, boolean z);
    }

    private class c implements Runnable {
        List<com.tencent.mm.plugin.exdevice.h.b> cwe;
        final /* synthetic */ e fti;

        public c(e eVar, List<com.tencent.mm.plugin.exdevice.h.b> list) {
            this.fti = eVar;
            this.cwe = list;
        }

        public final void run() {
            v.i("MicroMsg.exdevice.ExdeviceEventManager", "Wifi device heart beat");
            if (this.cwe != null && this.cwe.size() > 0) {
                for (com.tencent.mm.plugin.exdevice.h.b bVar : this.cwe) {
                    u.ajW().a(new k(bVar.field_brandName, bVar.field_deviceType, bVar.field_deviceID, 1));
                }
                this.fti.mHandler.postDelayed(this, 300000);
            }
        }
    }

    public class a implements b {
        private String aOw;
        final /* synthetic */ e fti;
        private String fto;
        private String ftp;
        private String mURL;

        public a(e eVar, String str, String str2, String str3, String str4) {
            this.fti = eVar;
            this.fto = str;
            this.aOw = str2;
            this.mURL = str3;
            this.ftp = str4;
            v.d("MicroMsg.exdevice.ExdeviceEventManager", "brandName : %s, mac : %s.", new Object[]{str, str2});
        }

        public final void h(String str, String str2, boolean z) {
            if (this.aOw == null || !this.aOw.equals(str2)) {
                v.d("MicroMsg.exdevice.ExdeviceEventManager", "onScanResult, mac(%s) is null or not correct.(mac : %s, isCompleted : %s)", new Object[]{this.aOw, str2, Boolean.valueOf(z)});
            }
        }

        public final void c(String str, byte[] bArr, boolean z) {
            if (this.aOw == null || !this.aOw.equals(str)) {
                v.i("MicroMsg.exdevice.ExdeviceEventManager", "onRecvFromDevice, mac(%s) is null or not correct.(mac : %s, succ : %s)", new Object[]{this.aOw, str, Boolean.valueOf(z)});
            } else if (z && bArr != null) {
                try {
                    ac.ajB();
                    if (!e.c(this.aOw, this.fto, bArr)) {
                        v.w("MicroMsg.exdevice.ExdeviceEventManager", "The parser isn't a correct type.");
                    }
                } catch (Exception e) {
                    v.e("MicroMsg.exdevice.ExdeviceEventManager", "Read data from bytes failed.");
                }
            }
        }

        public final void b(String str, int i, long j) {
            if (this.aOw == null || !this.aOw.equals(str)) {
                v.i("MicroMsg.exdevice.ExdeviceEventManager", "onConnectStateChanged, mac(%s) is null or not correct.(mac : %s, state : %s, type : %s)", new Object[]{this.aOw, str, Integer.valueOf(i), Long.valueOf(j)});
                return;
            }
            v.i("MicroMsg.exdevice.ExdeviceEventManager", "mac(%s), connectState(%s), profileType(%s)", new Object[]{str, Integer.valueOf(i), Long.valueOf(j)});
            switch (i) {
                case 0:
                    e.a(this.fto, this.mURL, 0, this.ftp);
                    v.i("MicroMsg.exdevice.ExdeviceEventManager", "onConnectStateChanged, device state none.(mac : %s)", new Object[]{str});
                    return;
                case 1:
                    v.i("MicroMsg.exdevice.ExdeviceEventManager", "onConnectStateChanged, device is connectiong.(mac: %s)", new Object[]{str});
                    e.a(this.fto, this.mURL, 1, this.ftp);
                    return;
                case 2:
                    v.i("MicroMsg.exdevice.ExdeviceEventManager", "onConnectStateChanged, device connected now start send data to it.(mac : %s)", new Object[]{str});
                    e.a(this.fto, this.mURL, 2, this.ftp);
                    f fVar = new f();
                    fVar.eqO = f.erT;
                    fVar.eqP = 2;
                    ac.ajB().m(this.aOw, com.tencent.mm.plugin.exdevice.j.b.aF(fVar));
                    return;
                case 4:
                    e.a(this.fto, this.mURL, 4, this.ftp);
                    v.i("MicroMsg.exdevice.ExdeviceEventManager", "onConnectStateChanged, device disconnected.(mac : %s)", new Object[]{str});
                    return;
                default:
                    v.d("MicroMsg.exdevice.ExdeviceEventManager", "onConnectStateChanged, out of range(mac : %s, state : %s, type : %s).", new Object[]{str, Integer.valueOf(i), Long.valueOf(j)});
                    e.a(this.fto, this.mURL, -1, this.ftp);
                    return;
            }
        }
    }

    static /* synthetic */ void a(e eVar, String str, int i, long j) {
        List<b> linkedList;
        synchronized (eVar.fsj) {
            linkedList = new LinkedList(eVar.fsj);
        }
        for (b b : linkedList) {
            b.b(str, i, j);
        }
        linkedList.clear();
        for (b b2 : eVar.fsk.values()) {
            b2.b(str, i, j);
        }
        do doVar = new do();
        doVar.bbE.mac = str;
        doVar.bbE.baO = i;
        doVar.bbE.bbB = j;
        com.tencent.mm.sdk.c.a.nhr.a(doVar, Looper.getMainLooper());
    }

    static /* synthetic */ void a(e eVar, String str, boolean z) {
        v.d("MicroMsg.exdevice.ExdeviceEventManager", "notifySimpleBTOnSend, mac : %s, isSucc : %s", new Object[]{str, Boolean.valueOf(z)});
        if (!z) {
            List<b> linkedList;
            synchronized (eVar.fsj) {
                linkedList = new LinkedList(eVar.fsj);
            }
            for (b c : linkedList) {
                c.c(str, null, false);
            }
            linkedList.clear();
            for (b c2 : eVar.fsk.values()) {
                c2.c(str, null, false);
            }
        }
    }

    static /* synthetic */ void a(String str, byte[] bArr, boolean z) {
        if (bArr == null) {
            v.i("MicroMsg.exdevice.ExdeviceEventManager", "notifyOnScanDeviceResult. deviceId=%s, isCompleted=%s", new Object[]{str, Boolean.valueOf(z)});
        } else {
            v.i("MicroMsg.exdevice.ExdeviceEventManager", "notifyOnScanDeviceResult. deviceId=%s, base64(broadcastData)=%s, isCompleted=%s", new Object[]{str, Base64.encodeToString(bArr, 0), Boolean.valueOf(z)});
        }
        db dbVar = new db();
        dbVar.bba.baR = bArr;
        dbVar.bba.aRh = str;
        dbVar.bba.baS = z;
        com.tencent.mm.sdk.c.a.nhr.a(dbVar, Looper.getMainLooper());
    }

    static /* synthetic */ boolean a(jf jfVar) {
        if (jfVar == null) {
            v.w("MicroMsg.exdevice.ExdeviceEventManager", "handleOnAuthSyncEvent, event is null.");
        } else {
            v.i("MicroMsg.exdevice.ExdeviceEventManager", "handleOnAuthSyncEvent");
        }
        return false;
    }

    static /* synthetic */ boolean a(e eVar) {
        v.i("MicroMsg.exdevice.ExdeviceEventManager", "receive SyncExdeviceDataEvent");
        int BJ = ak.vy().BJ();
        if (BJ == 4 || BJ == 6) {
            Object obj;
            String value = j.sU().getValue("DeviceAutoSyncClose");
            v.i("MicroMsg.exdevice.Util", "handleSyncExdeviceDataEvent, auto sync has close : %s", new Object[]{value});
            if (be.kS(value) || !value.equalsIgnoreCase("1")) {
                obj = 1;
            } else {
                v.i("MicroMsg.exdevice.Util", "auto sync has closed, ignore this sync request");
                obj = null;
            }
            if (obj == null) {
                v.i("MicroMsg.exdevice.ExdeviceEventManager", "not allowed to sync exdevice data");
                return false;
            } else if (com.tencent.mm.plugin.c.a.e.a.by(aa.getContext())) {
                em emVar;
                long akH = com.tencent.mm.plugin.exdevice.j.b.akH();
                SharedPreferences sharedPreferences = aa.getContext().getSharedPreferences("exdevice_pref", 0);
                if (sharedPreferences != null) {
                    long j = sharedPreferences.getLong("device_auto_sync_last_time", 0);
                    long Ni = be.Ni();
                    v.i("MicroMsg.exdevice.Util", "last sync time :%d, inteval config : %d, now time in millsecons is %d,  nowTime - lasysynctime = %d", new Object[]{Long.valueOf(j), Long.valueOf(akH), Long.valueOf(Ni), Long.valueOf(Ni - j)});
                    if (Ni - j > akH) {
                        sharedPreferences.edit().putLong("device_auto_sync_last_time", Ni).commit();
                        obj = 1;
                        if (obj != null) {
                            v.i("MicroMsg.exdevice.ExdeviceEventManager", "it is not the time to sync data");
                            if (ftg == 1) {
                                return false;
                            }
                            if (ftg == 0) {
                                com.tencent.mm.compatible.a.a.a(19, new com.tencent.mm.compatible.a.a.a(eVar) {
                                    final /* synthetic */ e fti;

                                    {
                                        this.fti = r1;
                                    }

                                    public final void run() {
                                        if (e.aiP()) {
                                            e.b(this.fti);
                                        }
                                        if (e.aiO()) {
                                            v.i("MicroMsg.exdevice.ExdeviceEventManager", "[hakon][step] support device step");
                                            e.ftg = 2;
                                            e.c(this.fti);
                                            return;
                                        }
                                        v.i("MicroMsg.exdevice.ExdeviceEventManager", "[hakon][step] not support device step");
                                        e.ftg = 1;
                                    }
                                });
                            } else if (ftg == 2) {
                                v.i("MicroMsg.exdevice.ExdeviceEventManager", "[hakon][step] support device step, wait for sync");
                            }
                            return false;
                        }
                        if (aiP()) {
                            emVar = new em();
                            emVar.bcU.action = 1;
                            com.tencent.mm.sdk.c.a.nhr.a(emVar, Looper.getMainLooper());
                        }
                        com.tencent.mm.compatible.a.a.a(19, new com.tencent.mm.compatible.a.a.a(eVar) {
                            final /* synthetic */ e fti;

                            {
                                this.fti = r1;
                            }

                            public final void run() {
                                if (e.aiP()) {
                                    e.b(this.fti);
                                }
                                if (e.aiO()) {
                                    e.c(this.fti);
                                }
                            }
                        });
                        if (com.tencent.mm.plugin.c.a.e.a.Xw()) {
                            v.i("MicroMsg.exdevice.ExdeviceEventManager", "Bluetooth is not open, Just leave");
                            return false;
                        }
                        ac.ajx();
                        if (d.aiM() == 1) {
                            v.i("MicroMsg.exdevice.ExdeviceEventManager", "it is in brand");
                            return false;
                        } else if (i.fuj.cO(false)) {
                            v.i("MicroMsg.exdevice.ExdeviceEventManager", "now do not need to get bound device, do sync directly");
                            return aiQ();
                        } else {
                            v.i("MicroMsg.exdevice.ExdeviceEventManager", "now need to get bound harddevices");
                            i.fuj.a(null, new com.tencent.mm.plugin.exdevice.model.i.a(eVar) {
                                final /* synthetic */ e fti;

                                {
                                    this.fti = r1;
                                }

                                public final void cN(boolean z) {
                                    e.aiQ();
                                }
                            });
                            return true;
                        }
                    }
                }
                obj = (f.ajb() && f.aje()) ? 1 : null;
                if (obj != null) {
                    if (aiP()) {
                        emVar = new em();
                        emVar.bcU.action = 1;
                        com.tencent.mm.sdk.c.a.nhr.a(emVar, Looper.getMainLooper());
                    }
                    com.tencent.mm.compatible.a.a.a(19, /* anonymous class already generated */);
                    if (com.tencent.mm.plugin.c.a.e.a.Xw()) {
                        ac.ajx();
                        if (d.aiM() == 1) {
                            v.i("MicroMsg.exdevice.ExdeviceEventManager", "it is in brand");
                            return false;
                        } else if (i.fuj.cO(false)) {
                            v.i("MicroMsg.exdevice.ExdeviceEventManager", "now do not need to get bound device, do sync directly");
                            return aiQ();
                        } else {
                            v.i("MicroMsg.exdevice.ExdeviceEventManager", "now need to get bound harddevices");
                            i.fuj.a(null, /* anonymous class already generated */);
                            return true;
                        }
                    }
                    v.i("MicroMsg.exdevice.ExdeviceEventManager", "Bluetooth is not open, Just leave");
                    return false;
                }
                v.i("MicroMsg.exdevice.ExdeviceEventManager", "it is not the time to sync data");
                if (ftg == 1) {
                    return false;
                }
                if (ftg == 0) {
                    com.tencent.mm.compatible.a.a.a(19, /* anonymous class already generated */);
                } else if (ftg == 2) {
                    v.i("MicroMsg.exdevice.ExdeviceEventManager", "[hakon][step] support device step, wait for sync");
                }
                return false;
            } else {
                v.i("MicroMsg.exdevice.ExdeviceEventManager", "now sdk version not support ble device : %d", new Object[]{Integer.valueOf(VERSION.SDK_INT)});
                return false;
            }
        }
        v.i("MicroMsg.exdevice.ExdeviceEventManager", "net work state is not connected, now state is %d", new Object[]{Integer.valueOf(BJ)});
        return false;
    }

    static /* synthetic */ boolean a(e eVar, hu huVar) {
        com.tencent.mm.plugin.exdevice.h.b bVar;
        int i = huVar.bhF.opType;
        int i2 = huVar.bhF.bhH;
        String str = huVar.bhF.bhG;
        if (i == 1) {
            v.i("MicroMsg.exdevice.ExdeviceEventManager", "Just enter, so clear previous state.");
            jk jkVar = new jk();
            jkVar.bjP.op = 3;
            jkVar.bjP.bhG = huVar.bhF.bhG;
            com.tencent.mm.sdk.c.a.nhr.z(jkVar);
        }
        LinkedList ss = ac.ajq().ss(str);
        BizInfo hw = com.tencent.mm.modelbiz.e.hw(str);
        if (hw != null) {
            ExtInfo aX = hw.aX(false);
            if (aX != null) {
                com.tencent.mm.modelbiz.BizInfo.ExtInfo.a CR = aX.CR();
                if (CR != null && CR.Da() && CR.cCd == 1) {
                    List<com.tencent.mm.plugin.exdevice.h.b> aka = ac.ajq().aka();
                    v.i("MicroMsg.exdevice.ExdeviceEventManager", "Wechat sport biz...");
                    if (aka.size() != 0) {
                        for (com.tencent.mm.plugin.exdevice.h.b bVar2 : aka) {
                            if (0 != (bVar2.bLh & 1)) {
                                v.i("MicroMsg.exdevice.ExdeviceEventManager", "BLE connected device info, mac(%s), deviceId(%s), deviceType(%s), SimpleProtol(%d), connProto(%s)", new Object[]{Long.valueOf(bVar2.field_mac), bVar2.field_deviceID, bVar2.field_deviceType, Long.valueOf(bVar2.bLh), bVar2.field_connProto});
                                ss.add(bVar2);
                            }
                        }
                    }
                }
            }
        }
        if (ss == null) {
            v.i("MicroMsg.exdevice.ExdeviceEventManager", "get hdinfo by brandName failed : %s", new Object[]{str});
            return false;
        } else if (ss.size() == 0) {
            v.i("MicroMsg.exdevice.ExdeviceEventManager", "get hdinfo by brandName(%s) result count is 0 ", new Object[]{str});
            return true;
        } else {
            if (i == 2) {
                v.d("MicroMsg.exdevice.ExdeviceEventManager", "exit chattingui, clear observers.");
                eVar.fsk.clear();
            }
            List linkedList = new LinkedList();
            Iterator it = ss.iterator();
            Object obj = null;
            while (it.hasNext()) {
                bVar2 = (com.tencent.mm.plugin.exdevice.h.b) it.next();
                if (bVar2 == null || be.kS(bVar2.field_brandName)) {
                    return false;
                }
                String ma = be.ma(bVar2.field_connProto);
                if (ma.contains("4")) {
                    v.i("MicroMsg.exdevice.ExdeviceEventManager", "Wifi biz.");
                    linkedList.add(bVar2);
                } else {
                    if (ma.contains("1") || ma.contains("3") || ma.contains("5") || ma.length() == 0) {
                        v.i("MicroMsg.exdevice.ExdeviceEventManager", "BlueTooth biz.");
                        if (com.tencent.mm.plugin.c.a.e.a.Xw()) {
                            obj = null;
                            eVar.a(bVar2, i, i2);
                        } else {
                            v.w("MicroMsg.exdevice.ExdeviceEventManager", "System bluetooth is close");
                            obj = 1;
                        }
                    }
                    obj = obj;
                }
            }
            i2 = linkedList.size();
            if (i2 > 0) {
                eVar.d(linkedList, i);
                bVar2 = (com.tencent.mm.plugin.exdevice.h.b) linkedList.get(i2 - 1);
                if (i2 == ss.size()) {
                    a(bVar2.field_brandName, bVar2.field_url, 0, bVar2.field_deviceID);
                }
            }
            as(str, obj != null ? 0 : -1);
            return false;
        }
    }

    static /* synthetic */ boolean a(e eVar, com.tencent.mm.sdk.c.b bVar) {
        v.i("MicroMsg.exdevice.ExdeviceEventManager", "handleOpInChattingUIEvent");
        final dc dcVar = (dc) bVar;
        if (be.kS(dcVar.bbb.userName)) {
            v.e("MicroMsg.exdevice.ExdeviceEventManager", "ExDeviceOpInChattingUIEventListener, userName is null");
            return false;
        }
        v.i("MicroMsg.exdevice.ExdeviceEventManager", "This biz is binded a device, notify chatting view to dimiss connect fail tips");
        as(dcVar.bbb.userName, -1);
        if ((dcVar.bbb.op != 0 && dcVar.bbb.op != 3) || !i.fuj.cO(false)) {
            return eVar.G(dcVar.bbb.op, dcVar.bbb.userName);
        }
        i.fuj.a(dcVar.bbb.context, new com.tencent.mm.plugin.exdevice.model.i.a(eVar) {
            final /* synthetic */ e fti;

            public final void cN(boolean z) {
                if (z) {
                    this.fti.G(dcVar.bbb.op, dcVar.bbb.userName);
                }
            }
        });
        return true;
    }

    static /* synthetic */ boolean aiU() {
        v.i("MicroMsg.exdevice.ExdeviceEventManager", "receive StopAllChannelEvent");
        ac.ajx();
        d.cL(false);
        ac.ajx().aiN();
        return true;
    }

    static /* synthetic */ boolean aiW() {
        v.i("MicroMsg.exdevice.ExdeviceEventManager", "OnSubCoreInited, process : %s", new Object[]{aa.getProcessName()});
        if (aa.btr()) {
            return false;
        }
        r.rZ().a(new com.tencent.mm.plugin.exdevice.a());
        return true;
    }

    static /* synthetic */ boolean b(e eVar) {
        LinkedList akb = ac.ajq().akb();
        if (akb.isEmpty()) {
            v.i("MicroMsg.exdevice.ExdeviceEventManager", "[hakon][step]no device need phone step");
            return false;
        }
        Iterator it = akb.iterator();
        while (it.hasNext()) {
            v.i("MicroMsg.exdevice.ExdeviceEventManager", "doUploadExtApiStep: %b", new Object[]{Boolean.valueOf(b((com.tencent.mm.plugin.exdevice.h.b) it.next()))});
        }
        return true;
    }

    static /* synthetic */ boolean c(com.tencent.mm.plugin.exdevice.h.b bVar) {
        Calendar instance = Calendar.getInstance();
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        if (u.ajW() == null || u.ajW().frL == null) {
            v.w("MicroMsg.exdevice.ExdeviceEventManager", "[hakon][Step] IBTDeviceManager_AIDL not ready");
            return false;
        }
        int ajM = u.ajW().frL.ajM();
        if (fth == ajM) {
            v.w("MicroMsg.exdevice.ExdeviceEventManager", "[hakon][Step] step(%d) not change", new Object[]{Integer.valueOf(fth)});
            return false;
        }
        v.i("MicroMsg.exdevice.ExdeviceEventManager", "[hakon][Step] uploadDeviceStep (current : %d, cache : %d).", new Object[]{Integer.valueOf(ajM), Integer.valueOf(fth)});
        fth = ajM;
        String str = "";
        if (bVar.field_connProto != null && bVar.field_connProto.contains("6")) {
            str = Build.MANUFACTURER + "_" + Build.MODEL;
        }
        ak.vy().a(new com.tencent.mm.plugin.exdevice.devicestep.b(bVar.field_deviceID, bVar.field_deviceType, (int) (instance.getTimeInMillis() / 1000), (int) (System.currentTimeMillis() / 1000), ajM, str), 0);
        return true;
    }

    static /* synthetic */ boolean c(e eVar) {
        LinkedList akb = ac.ajq().akb();
        if (akb.isEmpty()) {
            v.i("MicroMsg.exdevice.ExdeviceEventManager", "[hakon][step]no device need phone step");
            return false;
        } else if (akb.isEmpty()) {
            v.i("MicroMsg.exdevice.ExdeviceEventManager", "[hakon][step]no device need phone step");
            return false;
        } else {
            ac.ajx().kl(0);
            Iterator it = akb.iterator();
            while (it.hasNext()) {
                final com.tencent.mm.plugin.exdevice.h.b bVar = (com.tencent.mm.plugin.exdevice.h.b) it.next();
                ak.yW();
                com.tencent.mm.storage.u LX = com.tencent.mm.model.c.wH().LX(bVar.field_brandName);
                if (LX == null || !com.tencent.mm.i.a.ei(LX.field_type)) {
                    v.e("MicroMsg.exdevice.ExdeviceEventManager", "[hakon][step]%s not contact, may be has been deleted", new Object[]{bVar.field_brandName});
                } else {
                    ftg = 2;
                    v.i("MicroMsg.exdevice.ExdeviceEventManager", "[hakon][step] try to connect %s", new Object[]{bVar.field_brandName});
                    ac.ajx().a(bVar.field_brandName, bVar.field_mac, 0, true);
                    ac.ajx().l(new Runnable(eVar) {
                        final /* synthetic */ e fti;

                        public final void run() {
                            com.tencent.mm.plugin.exdevice.devicestep.c.cI(true);
                            boolean c = e.c(bVar);
                            v.i("MicroMsg.exdevice.ExdeviceEventManager", "[hakon][step]true doSyncExdeviceStep %s, %s, commitRet %s", new Object[]{bVar.field_brandName, Boolean.valueOf(c), Boolean.valueOf(true)});
                        }
                    });
                    return true;
                }
            }
            com.tencent.mm.plugin.exdevice.devicestep.c.cI(false);
            v.i("MicroMsg.exdevice.ExdeviceEventManager", "[hakon][step]false doSyncExdeviceStep, commitRet = %s", new Object[]{Boolean.valueOf(true)});
            return false;
        }
    }

    static /* synthetic */ boolean cM(boolean z) {
        v.i("MicroMsg.exdevice.ExdeviceEventManager", "------handleGetBoundDeviceEvent------ check if need to get bound device after auth");
        if (i.fuj.cO(z)) {
            v.i("MicroMsg.exdevice.ExdeviceEventManager", "do get bound device after auth");
            i.fuj.a(null, null);
        }
        return true;
    }

    static /* synthetic */ boolean d(e eVar, com.tencent.mm.sdk.c.b bVar) {
        boolean z = false;
        cg cgVar = (cg) bVar;
        v.i("MicroMsg.exdevice.ExdeviceEventManager", "handleConnectDeviceEvent: brandName=%s, deviceId=%s, type=%b", new Object[]{cgVar.aZS.aZU, cgVar.aZS.aRh, Boolean.valueOf(cgVar.aZS.aZV)});
        String str = cgVar.aZS.aZU;
        String str2 = cgVar.aZS.aRh;
        boolean z2 = cgVar.aZS.aZV;
        if (be.kS(str) || be.kS(str2)) {
            v.e("MicroMsg.exdevice.ExdeviceEventManager", "connectBluetoothDevice %s, %s, %s", new Object[]{str, str2, Boolean.valueOf(z2)});
        } else {
            com.tencent.mm.plugin.exdevice.h.b sq = ac.ajq().sq(str2);
            if (sq == null) {
                v.e("MicroMsg.exdevice.ExdeviceEventManager", "hdInfo null, %s", new Object[]{str2});
            } else if (!sq.field_brandName.equals(str)) {
                v.e("MicroMsg.exdevice.ExdeviceEventManager", "brand name not match. %s != %s", new Object[]{sq.field_brandName, str});
            } else if (be.ma(sq.field_connProto).contains("4")) {
                a(str, sq.field_url, -1, sq.field_deviceType);
                as(str, -1);
                v.i("MicroMsg.exdevice.ExdeviceEventManager", "Wifi biz, Just leave");
            } else if (com.tencent.mm.plugin.c.a.e.a.Xw()) {
                as(str, -1);
                int a = a(sq);
                if (a == 1) {
                    if (!com.tencent.mm.plugin.c.a.e.a.Xu()) {
                        v.e("MicroMsg.exdevice.ExdeviceEventManager", "device is BC, but you phone not support BC.");
                    }
                } else if (a == 0 && !com.tencent.mm.plugin.c.a.e.a.by(aa.getContext())) {
                    as(str, 1);
                    v.e("MicroMsg.exdevice.ExdeviceEventManager", "device is BLE, but you phone not support BLE.");
                }
                if (z2) {
                    if (aa.ajn().ftU) {
                        aa.ajn().kn(a);
                    }
                    d ajx = ac.ajx();
                    if (!(ajx.frV == null || ajx.frV.size() == 0)) {
                        ajx.frV.clear();
                    }
                    ac.ajx().c(sq.field_brandName, sq.field_mac, a);
                } else {
                    ac.ajx();
                    d.aU(sq.field_mac);
                }
                z = true;
            } else {
                v.w("MicroMsg.exdevice.ExdeviceEventManager", "System bluetooth is close");
                as(str, 0);
            }
        }
        cgVar.aZT.aZW = z;
        return z;
    }

    static /* synthetic */ boolean f(e eVar, com.tencent.mm.sdk.c.b bVar) {
        if (bVar == null || !(bVar instanceof dr)) {
            v.e("MicroMsg.exdevice.ExdeviceEventManager", "event is not instanceof ExDeviceSimpleBTScanDeviceEvent");
            return false;
        }
        dr drVar = (dr) bVar;
        if (aiS()) {
            drVar.bbI.aZW = true;
            return true;
        }
        drVar.bbI.aZW = false;
        return true;
    }

    static /* synthetic */ boolean g(e eVar, com.tencent.mm.sdk.c.b bVar) {
        if (bVar == null || !(bVar instanceof dn)) {
            v.e("MicroMsg.exdevice.ExdeviceEventManager", "event is not instanceof ExDeviceSimpleBTConnectDeviceEvent");
            return false;
        }
        dn dnVar = (dn) bVar;
        if (dnVar.bbC.aZV ? eVar.sa(dnVar.bbC.mac) : rZ(dnVar.bbC.mac)) {
            dnVar.bbD.aZW = true;
            return true;
        }
        dnVar.bbD.aZW = false;
        return true;
    }

    static /* synthetic */ boolean h(e eVar, com.tencent.mm.sdk.c.b bVar) {
        if (bVar == null || !(bVar instanceof ds)) {
            v.e("MicroMsg.exdevice.ExdeviceEventManager", "event is not instanceof ExDeviceSimpleBTSendDataToDeviceEvent");
            return false;
        }
        ds dsVar = (ds) bVar;
        if (eVar.m(dsVar.bbJ.mac, dsVar.bbJ.data)) {
            dsVar.bbK.aZW = true;
            return true;
        }
        dsVar.bbK.aZW = false;
        return true;
    }

    static /* synthetic */ boolean i(e eVar, com.tencent.mm.sdk.c.b bVar) {
        if (bVar == null || !(bVar instanceof dm)) {
            v.e("MicroMsg.exdevice.ExdeviceEventManager", "event is not instanceof ExDeviceSimpleBTBindDeviceEvent");
            return false;
        }
        dm dmVar = (dm) bVar;
        if (ac.ajq().bq(com.tencent.mm.plugin.exdevice.j.b.sE(dmVar.bby.mac)) != null) {
            v.d("MicroMsg.exdevice.ExdeviceEventManager", "device(" + dmVar.bby.mac + ") has been binded");
            dmVar.bbz.aZW = true;
        } else {
            boolean z;
            String str = dmVar.bby.mac;
            String str2 = dmVar.bby.bbA;
            long j = dmVar.bby.bbB;
            if (be.kS(str)) {
                v.e("MicroMsg.exdevice.ExdeviceEventManager", "mac is null or nil");
                z = false;
            } else {
                String str3 = "MicroMsg.exdevice.ExdeviceEventManager";
                String str4 = "handleExDeviceSimpleBTBindDevice. mac = %s, broadcastName = %s, profileType = %d";
                Object[] objArr = new Object[3];
                objArr[0] = str;
                objArr[1] = str2 == null ? "null" : str2;
                objArr[2] = Long.valueOf(j);
                v.d(str3, str4, objArr);
                int BJ = ak.vy().BJ();
                if (BJ == 4 || BJ == 6) {
                    if (ak.vy().a(new m(com.tencent.mm.plugin.exdevice.j.b.sE(str), str2, "3", j), 0)) {
                        z = true;
                    } else {
                        v.e("MicroMsg.exdevice.ExdeviceEventManager", "do NetSceneBindUnauthDevice fail");
                        z = false;
                    }
                } else {
                    v.e("MicroMsg.exdevice.ExdeviceEventManager", "net work state is not connected, current state is %d", new Object[]{Integer.valueOf(BJ)});
                    z = false;
                }
            }
            if (z) {
                dmVar.bbz.aZW = true;
            } else {
                dmVar.bbz.aZW = false;
            }
        }
        return true;
    }

    static /* synthetic */ boolean j(e eVar, com.tencent.mm.sdk.c.b bVar) {
        cp cpVar = (cp) bVar;
        long j = cpVar.bay.bao;
        String str = cpVar.bay.bap;
        List<com.tencent.mm.plugin.exdevice.h.b> ajY = ac.ajq().ajY();
        if (ajY.size() > 0) {
            boolean z;
            if (j == -1 || j == Long.MIN_VALUE) {
                z = false;
            } else {
                ak.yW();
                at ek = com.tencent.mm.model.c.wJ().ek(j);
                if (ek.field_msgId == 0) {
                    z = false;
                } else {
                    int i = ek.field_type;
                    String str2 = ek.field_content;
                    String str3;
                    if (ek.bvY()) {
                        com.tencent.mm.q.a.a dV = com.tencent.mm.q.a.a.dV(str2);
                        if (dV == null) {
                            v.e("MicroMsg.exdevice.ExdeviceEventManager", "get content is null");
                            z = false;
                        } else if (dV.type == 3) {
                            for (com.tencent.mm.plugin.exdevice.h.b bVar2 : ajY) {
                                str3 = bVar2.bLi;
                                if (str3 != null && str3.contains("wxmsg_music")) {
                                    z = true;
                                    break;
                                }
                            }
                            z = false;
                        } else if (dV.type == 4) {
                            z = false;
                        } else if (dV.type == 6) {
                            for (com.tencent.mm.plugin.exdevice.h.b bVar22 : ajY) {
                                str3 = bVar22.bLi;
                                if (str3 != null && str3.contains("wxmsg_file")) {
                                    z = true;
                                    break;
                                }
                            }
                            z = false;
                        } else if (dV.type == 5) {
                            z = e(dV.url, (List) ajY);
                        } else {
                            if (dV.type == 2) {
                                for (com.tencent.mm.plugin.exdevice.h.b bVar222 : ajY) {
                                    str3 = bVar222.bLi;
                                    if (str3 != null && str3.contains("wxmsg_image")) {
                                        z = true;
                                        break;
                                    }
                                }
                                z = false;
                            }
                            z = false;
                        }
                    } else if (i == 3) {
                        for (com.tencent.mm.plugin.exdevice.h.b bVar2222 : ajY) {
                            str3 = bVar2222.bLi;
                            if (str3 != null && str3.contains("wxmsg_image")) {
                                z = true;
                                break;
                            }
                        }
                        z = false;
                    } else if (i == 48) {
                        for (com.tencent.mm.plugin.exdevice.h.b bVar22222 : ajY) {
                            str3 = bVar22222.bLi;
                            if (str3 != null && str3.contains("wxmsg_poi")) {
                                z = true;
                                break;
                            }
                        }
                        z = false;
                    } else {
                        if (i == 62) {
                            for (com.tencent.mm.plugin.exdevice.h.b bVar222222 : ajY) {
                                str3 = bVar222222.bLi;
                                if (str3 != null && str3.contains("wxmsg_video")) {
                                    z = true;
                                    break;
                                }
                            }
                        }
                        z = false;
                    }
                    v.i("MicroMsg.exdevice.ExdeviceEventManager", "isSupportsMsgType = " + z + ", msgType = " + i);
                }
            }
            if (z || f(str, (List) ajY)) {
                cpVar.baz.aZW = true;
                return true;
            }
        }
        cpVar.baz.aZW = false;
        return true;
    }

    static /* synthetic */ boolean j(com.tencent.mm.sdk.c.b bVar) {
        v.i("MicroMsg.exdevice.ExdeviceEventManager", "receive ExDeviceBindHardDeviceEvent");
        cc ccVar = (cc) bVar;
        int i = ccVar.aZF.opType;
        v.i("MicroMsg.exdevice.ExdeviceEventManager", "now optype is %d, subscribeFlag is %d", new Object[]{Integer.valueOf(i), Integer.valueOf(ccVar.aZF.aZI)});
        if (i == 1) {
            l lVar = new l(ccVar.aZF.aZH, r1);
            ak.vy().a(lVar, 0);
            ccVar.aZG.aZJ = lVar;
        } else if (i == 2 && ccVar.aZF.aZJ != null) {
            ak.vy().c((l) ccVar.aZF.aZJ);
        }
        return true;
    }

    static /* synthetic */ boolean k(e eVar, com.tencent.mm.sdk.c.b bVar) {
        cn cnVar = (cn) bVar;
        eVar.ftc = new g();
        g gVar = eVar.ftc;
        v.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "startScanWCLanDevice...");
        Java2CExDevice.startScanWCLanDevice(new byte[0], BaseReportManager.MAX_READ_COUNT);
        gVar.ftr = false;
        new ah(new com.tencent.mm.sdk.platformtools.ah.a(gVar) {
            final /* synthetic */ g ftT;

            {
                this.ftT = r1;
            }

            public final boolean oU() {
                int size = this.ftT.ftE.size();
                int i = 0;
                while (i < size) {
                    if (((b) this.ftT.ftE.get(i)).bLi.contains("internet_to_device") && ((b) this.ftT.ftE.get(i)).bLi.contains("wechat_to_device") && !this.ftT.ftF.contains(this.ftT.ftE.get(i))) {
                        this.ftT.ftF.add(this.ftT.ftE.get(i));
                        g.a(this.ftT, this.ftT.ftF);
                    }
                    i++;
                }
                return true;
            }
        }, false).ea(3000);
        g gVar2 = eVar.ftc;
        long j = cnVar.bam.bao;
        String str = cnVar.bam.bap;
        String str2 = cnVar.bam.baq;
        int i = cnVar.bam.bar;
        List arrayList = new ArrayList();
        gVar2.bZz = j;
        gVar2.ftu = str;
        gVar2.ftv = str2;
        gVar2.ftw = i;
        int size = gVar2.ftF.size();
        for (int i2 = 0; i2 < size; i2++) {
            HashMap hashMap = new HashMap();
            hashMap.put("deviceType", ((com.tencent.mm.plugin.exdevice.h.b) gVar2.ftF.get(i2)).field_deviceType);
            hashMap.put("deviceID", ((com.tencent.mm.plugin.exdevice.h.b) gVar2.ftF.get(i2)).field_deviceID);
            hashMap.put("displayName", g.f((com.tencent.mm.plugin.exdevice.h.b) gVar2.ftF.get(i2)));
            hashMap.put("iconUrl", ((com.tencent.mm.plugin.exdevice.h.b) gVar2.ftF.get(i2)).iconUrl);
            hashMap.put("ability", ((com.tencent.mm.plugin.exdevice.h.b) gVar2.ftF.get(i2)).bLi);
            hashMap.put("abilityInf", ((com.tencent.mm.plugin.exdevice.h.b) gVar2.ftF.get(i2)).bLj);
            arrayList.add(hashMap);
        }
        if (arrayList.size() > 0) {
            cnVar.ban.bas = arrayList;
            cnVar.ban.aZW = true;
        } else {
            cnVar.ban.aZW = false;
        }
        return true;
    }

    static /* synthetic */ boolean k(com.tencent.mm.sdk.c.b bVar) {
        v.i("MicroMsg.exdevice.ExdeviceEventManager", "receive ExDeviceUnBindHardDeviceEvent");
        ac.ajx().kl(0);
        dw dwVar = (dw) bVar;
        if (be.kS(dwVar.bbP.aZU)) {
            v.e("MicroMsg.exdevice.ExdeviceEventManager", "brandName is null, can not unbind device");
            return false;
        }
        abt com_tencent_mm_protocal_c_abt = new abt();
        com_tencent_mm_protocal_c_abt.eez = "";
        com_tencent_mm_protocal_c_abt.meq = dwVar.bbP.aZU;
        ak.vy().a(new x(com_tencent_mm_protocal_c_abt, 1), 0);
        return true;
    }

    static /* synthetic */ boolean l(e eVar, com.tencent.mm.sdk.c.b bVar) {
        di diVar = (di) bVar;
        if (be.kS(diVar.bbm.aZN) || be.kS(diVar.bbm.aRh)) {
            diVar.bbn.bbq = false;
        } else {
            String str;
            Boolean valueOf;
            int i;
            com.tencent.mm.e.a.di.b bVar2 = diVar.bbn;
            g gVar = eVar.ftc;
            String str2 = diVar.bbm.aZN;
            String str3 = diVar.bbm.aRh;
            String str4 = diVar.bbm.bbo;
            long j = diVar.bbm.bao;
            String str5 = diVar.bbm.bap;
            boolean z = diVar.bbm.bbp;
            gVar.bZz = j;
            gVar.fts = false;
            gVar.ftt = z;
            v.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "deviceType: %s, deviceId: %s", new Object[]{str2, str3});
            int i2 = 0;
            if (str4 == null || !str4.contains("wechat_to_device") || gVar.ftG.get(str3) == null) {
                if (str4 != null && str4.contains("internet_to_device")) {
                    i2 = 1;
                    if (!z && (g.aW(j).booleanValue() || g.aV(j).booleanValue() || g.aY(j).booleanValue() || g.aX(j).booleanValue())) {
                        str4 = "MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice";
                        str5 = "mDeviceMsgForUseCdn %s deviceId %s deviceType %s";
                        Object[] objArr = new Object[3];
                        objArr[0] = Boolean.valueOf(gVar.ftD == null);
                        objArr[1] = str3;
                        objArr[2] = str2;
                        v.d(str4, str5, objArr);
                        if (gVar.ftD != null) {
                            ak.vy().a(new n(gVar.ftD, str2, str3, 1), 0);
                        } else {
                            gVar.ftC.put(str3, str2);
                            if (!gVar.ftB) {
                                Object obj;
                                str4 = "";
                                str = "";
                                gVar.ftA = true;
                                ak.yW();
                                at ek = com.tencent.mm.model.c.wJ().ek(j);
                                Object[] objArr2;
                                h hVar;
                                if (g.aW(j).booleanValue()) {
                                    d j2 = n.GH().j(ek);
                                    str4 = n.GH().l(j2.cLv, "", "");
                                    str = n.GH().l(j2.cLx, "", "");
                                    gVar.cMR = j2.cLu;
                                    if (be.kS(gVar.cMU)) {
                                        v.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "createMediaId time:%d talker:%s msg:%d img:%d compressType:%d", new Object[]{Long.valueOf(ek.field_createTime), ek.field_talker, Long.valueOf(ek.field_msgId), Long.valueOf(gVar.cMR), Integer.valueOf(0)});
                                        gVar.cMU = com.tencent.mm.modelcdntran.d.a("upimg", ek.field_createTime, ek.field_talker, ek.field_msgId + "_" + gVar.cMR + "_0");
                                    }
                                    g.DZ();
                                    if (!com.tencent.mm.modelcdntran.c.fk(1) && be.kS(j2.cLF)) {
                                        objArr2 = new Object[2];
                                        g.DZ();
                                        objArr2[0] = Boolean.valueOf(com.tencent.mm.modelcdntran.c.fk(1));
                                        objArr2[1] = j2.cLF;
                                        v.w("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "cdntra not use cdn flag:%b getCdnInfo:%s", objArr2);
                                        obj = null;
                                    }
                                    hVar = new h();
                                    hVar.cFR = gVar.cNe;
                                    hVar.field_mediaId = gVar.cMU;
                                    hVar.field_fullpath = str4;
                                    hVar.field_thumbpath = str;
                                    hVar.field_fileType = com.tencent.mm.modelcdntran.b.cEK;
                                    hVar.field_talker = ek.field_talker;
                                    hVar.field_priority = com.tencent.mm.modelcdntran.b.cEz;
                                    hVar.field_needStorage = false;
                                    hVar.field_isStreamMedia = false;
                                    hVar.field_appType = 200;
                                    hVar.field_bzScene = 2;
                                    if (!g.aV(j).booleanValue()) {
                                        hVar.field_fileType = com.tencent.mm.modelcdntran.b.cEI;
                                        hVar.field_appType = 202;
                                    } else if (g.aY(j).booleanValue()) {
                                        hVar.field_appType = 102;
                                        hVar.field_fileType = com.tencent.mm.modelcdntran.b.cEE;
                                        hVar.field_bzScene = 1;
                                    }
                                    if (g.DZ().b(hVar)) {
                                        obj = 1;
                                    } else {
                                        com.tencent.mm.plugin.report.service.g.iuh.a(111, 205, 1, false);
                                        v.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "cdntra addSendTask failed. clientid:%s", new Object[]{gVar.cMU});
                                        gVar.cMU = "";
                                        obj = null;
                                    }
                                } else if (g.aV(j).booleanValue() || g.aX(j).booleanValue()) {
                                    com.tencent.mm.pluginsdk.model.app.b Gu = am.Wf().Gu(com.tencent.mm.q.a.a.dV(ek.field_content).aXa);
                                    if (Gu != null) {
                                        str4 = Gu.field_fileFullPath;
                                        g.DZ();
                                        if (com.tencent.mm.modelcdntran.c.fk(4) || Gu.field_isUseCdn == 1) {
                                            if (!be.kS(ek.field_imgPath)) {
                                                str = n.GH().iW(ek.field_imgPath);
                                            }
                                            int aQ = com.tencent.mm.a.e.aQ(str);
                                            int aQ2 = com.tencent.mm.a.e.aQ(Gu.field_fileFullPath);
                                            if (aQ >= com.tencent.mm.modelcdntran.b.cEP) {
                                                v.w("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "cdntra thumb[%s][%d] Too Big Not Use CDN TRANS", new Object[]{str, Integer.valueOf(aQ)});
                                                obj = null;
                                            } else {
                                                gVar.cMU = com.tencent.mm.modelcdntran.d.a("upattach", Gu.field_createTime, ek.field_talker, new StringBuilder("0").toString());
                                                if (be.kS(gVar.cMU)) {
                                                    v.w("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "cdntra genClientId failed not use cdn compressType:%d", new Object[]{Integer.valueOf(0)});
                                                    obj = null;
                                                } else {
                                                    v.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "cdntra checkUseCdn id:%d file[%s][%d] thumb[%s][%d]", new Object[]{Long.valueOf(Gu.field_msgInfoId), Gu.field_fileFullPath, Integer.valueOf(aQ2), str, Integer.valueOf(aQ)});
                                                    hVar = new h();
                                                    hVar.cFR = gVar.cNe;
                                                    hVar.field_mediaId = gVar.cMU;
                                                    hVar.field_fullpath = str4;
                                                    hVar.field_thumbpath = str;
                                                    hVar.field_fileType = com.tencent.mm.modelcdntran.b.cEK;
                                                    hVar.field_talker = ek.field_talker;
                                                    hVar.field_priority = com.tencent.mm.modelcdntran.b.cEz;
                                                    hVar.field_needStorage = false;
                                                    hVar.field_isStreamMedia = false;
                                                    hVar.field_appType = 200;
                                                    hVar.field_bzScene = 2;
                                                    if (!g.aV(j).booleanValue()) {
                                                        hVar.field_fileType = com.tencent.mm.modelcdntran.b.cEI;
                                                        hVar.field_appType = 202;
                                                    } else if (g.aY(j).booleanValue()) {
                                                        hVar.field_appType = 102;
                                                        hVar.field_fileType = com.tencent.mm.modelcdntran.b.cEE;
                                                        hVar.field_bzScene = 1;
                                                    }
                                                    if (g.DZ().b(hVar)) {
                                                        obj = 1;
                                                    } else {
                                                        com.tencent.mm.plugin.report.service.g.iuh.a(111, 205, 1, false);
                                                        v.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "cdntra addSendTask failed. clientid:%s", new Object[]{gVar.cMU});
                                                        gVar.cMU = "";
                                                        obj = null;
                                                    }
                                                }
                                            }
                                        } else {
                                            objArr2 = new Object[2];
                                            g.DZ();
                                            objArr2[0] = Boolean.valueOf(com.tencent.mm.modelcdntran.c.fk(4));
                                            objArr2[1] = Integer.valueOf(Gu.field_isUseCdn);
                                            v.w("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "cdntra not use cdn flag:%b getCdnInfo:%d", objArr2);
                                            obj = null;
                                        }
                                    } else {
                                        v.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "getFilePath attInfo is null");
                                        obj = null;
                                    }
                                } else {
                                    if (g.aY(j).booleanValue()) {
                                        com.tencent.mm.as.n kZ = com.tencent.mm.as.k.KV().kZ(ek.field_imgPath);
                                        if (kZ == null) {
                                            v.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "Get info Failed file:" + ek.field_imgPath);
                                            obj = null;
                                        } else {
                                            g.DZ();
                                            if (com.tencent.mm.modelcdntran.c.fk(2) || kZ.dhP == 1) {
                                                gVar.cMU = com.tencent.mm.modelcdntran.d.a("upvideo", kZ.dhH, kZ.Ld(), kZ.getFileName());
                                                if (be.kS(gVar.cMU)) {
                                                    v.w("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "cdntra genClientId failed not use cdn file:%s", new Object[]{kZ.getFileName()});
                                                    obj = null;
                                                } else {
                                                    com.tencent.mm.as.k.KV();
                                                    str = o.ld(ek.field_imgPath);
                                                    com.tencent.mm.as.k.KV();
                                                    str4 = o.lc(ek.field_imgPath);
                                                }
                                            } else {
                                                r5 = new Object[2];
                                                g.DZ();
                                                r5[0] = Boolean.valueOf(com.tencent.mm.modelcdntran.c.fk(2));
                                                r5[1] = Integer.valueOf(kZ.dhP);
                                                v.w("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "cdntra not use cdn flag:%b getCdnInfo:%d", r5);
                                                obj = null;
                                            }
                                        }
                                    }
                                    hVar = new h();
                                    hVar.cFR = gVar.cNe;
                                    hVar.field_mediaId = gVar.cMU;
                                    hVar.field_fullpath = str4;
                                    hVar.field_thumbpath = str;
                                    hVar.field_fileType = com.tencent.mm.modelcdntran.b.cEK;
                                    hVar.field_talker = ek.field_talker;
                                    hVar.field_priority = com.tencent.mm.modelcdntran.b.cEz;
                                    hVar.field_needStorage = false;
                                    hVar.field_isStreamMedia = false;
                                    hVar.field_appType = 200;
                                    hVar.field_bzScene = 2;
                                    if (!g.aV(j).booleanValue()) {
                                        hVar.field_fileType = com.tencent.mm.modelcdntran.b.cEI;
                                        hVar.field_appType = 202;
                                    } else if (g.aY(j).booleanValue()) {
                                        hVar.field_appType = 102;
                                        hVar.field_fileType = com.tencent.mm.modelcdntran.b.cEE;
                                        hVar.field_bzScene = 1;
                                    }
                                    if (g.DZ().b(hVar)) {
                                        com.tencent.mm.plugin.report.service.g.iuh.a(111, 205, 1, false);
                                        v.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "cdntra addSendTask failed. clientid:%s", new Object[]{gVar.cMU});
                                        gVar.cMU = "";
                                        obj = null;
                                    } else {
                                        obj = 1;
                                    }
                                }
                                if (obj == null) {
                                    g.bq(str3, gVar.fty);
                                    gVar.ftB = false;
                                } else {
                                    gVar.ftB = true;
                                }
                            }
                        }
                        valueOf = Boolean.valueOf(true);
                        bVar2.bbq = valueOf.booleanValue();
                    }
                }
                i = i2;
            } else {
                i = 0;
            }
            acj com_tencent_mm_protocal_c_acj = new acj();
            if (!z) {
                gVar.a(com_tencent_mm_protocal_c_acj, gVar.bZz);
            } else if (gVar.ajf().mWq.mol != 1 || i != 0 || gVar.ftv != null) {
                if (str5 != null) {
                    azr ajf = gVar.ajf();
                    switch (ajf.mWq.mol) {
                        case 1:
                            v.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "is sns photo!");
                            int i3 = -1;
                            String str6 = null;
                            str5 = null;
                            str = null;
                            String str7 = gVar.ftv;
                            if (str7 != null && str7.length() > 0) {
                                File file = new File(str7);
                                str5 = file.getName();
                                i3 = (int) file.length();
                                str = str5.substring(str5.lastIndexOf(".") + 1, str5.length());
                                str6 = com.tencent.mm.a.g.g(file);
                                v.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "dataSnsInit filePath %s, fileSize %s, fileMd5 %s", new Object[]{str7, Integer.valueOf(i3), str6});
                            }
                            ack com_tencent_mm_protocal_c_ack = new ack();
                            com_tencent_mm_protocal_c_ack.mqB = str;
                            com_tencent_mm_protocal_c_ack.gkB = str5;
                            com_tencent_mm_protocal_c_ack.efj = i3;
                            com_tencent_mm_protocal_c_ack.mpC = str6;
                            if (i == 1) {
                                r2 = (aib) ajf.mWq.mom.get(gVar.ftw);
                                if (r2 == null) {
                                    v.w("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "mediaObjImage is null");
                                    break;
                                }
                                com_tencent_mm_protocal_c_ack.glb = r2.glb;
                                com_tencent_mm_protocal_c_ack.mDz = r2.mIg;
                                if (!be.kS(com_tencent_mm_protocal_c_ack.mDz)) {
                                    com_tencent_mm_protocal_c_ack.glb += "?idx=" + r2.mIf + "&token=" + r2.mIe;
                                }
                            }
                            com_tencent_mm_protocal_c_acj.mDv = com_tencent_mm_protocal_c_ack;
                            com_tencent_mm_protocal_c_acj.mDs = 3;
                            break;
                        case 3:
                            r2 = (aib) ajf.mWq.mom.get(0);
                            if (r2 != null) {
                                gVar.fts = true;
                                acn com_tencent_mm_protocal_c_acn = new acn();
                                com_tencent_mm_protocal_c_acn.glb = r2.glb;
                                com_tencent_mm_protocal_c_acn.aXz = r2.aXz;
                                com_tencent_mm_protocal_c_acn.mDD = r2.gkC;
                                com_tencent_mm_protocal_c_acj.mDx = com_tencent_mm_protocal_c_acn;
                                com_tencent_mm_protocal_c_acj.mDs = 5;
                                break;
                            }
                            v.w("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "mediaObUrl is null");
                            break;
                        case 4:
                            v.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "is sns music!");
                            r2 = (aib) ajf.mWq.mom.get(0);
                            if (r2 != null) {
                                gVar.fts = true;
                                acm com_tencent_mm_protocal_c_acm = new acm();
                                com_tencent_mm_protocal_c_acm.aXz = r2.aXz;
                                com_tencent_mm_protocal_c_acm.mDD = r2.gkC;
                                com_tencent_mm_protocal_c_acm.glb = ajf.mWq.glb;
                                com_tencent_mm_protocal_c_acm.mDF = r2.glb;
                                com_tencent_mm_protocal_c_acm.mDG = r2.mHT;
                                com_tencent_mm_protocal_c_acm.hNZ = ajf.mWp.hNZ;
                                com_tencent_mm_protocal_c_acj.mDt = com_tencent_mm_protocal_c_acm;
                                com_tencent_mm_protocal_c_acj.mDs = 1;
                                break;
                            }
                            v.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "mediaObj is null");
                            break;
                        case com.tencent.mm.plugin.appbrand.jsapi.am.CTRL_INDEX /*15*/:
                            v.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "is sns sight!");
                            r2 = (aib) ajf.mWq.mom.get(0);
                            if (r2 != null) {
                                gVar.fts = true;
                                aco com_tencent_mm_protocal_c_aco = new aco();
                                com_tencent_mm_protocal_c_aco.glb = r2.glb;
                                v.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "videoMsg.url = %s", new Object[]{com_tencent_mm_protocal_c_aco.glb});
                                com_tencent_mm_protocal_c_acj.mDy = com_tencent_mm_protocal_c_aco;
                                com_tencent_mm_protocal_c_acj.mDs = 6;
                                break;
                            }
                            v.w("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "mediaObjSight is null");
                            break;
                    }
                }
            } else {
                gVar.ftO = com_tencent_mm_protocal_c_acj;
                gVar.ftP = str2;
                gVar.ftQ = str3;
                gVar.ftR = 0;
                r2 = (aib) gVar.ajf().mWq.mom.get(gVar.ftw);
                if (r2 == null) {
                    v.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "mediaObjImage is null");
                    g.bq(str3, gVar.fty);
                } else {
                    gVar.bhR = r2.glb;
                    com.tencent.mm.sdk.i.e.a(gVar.ftN, "ExdeviceDownloadImage");
                }
                valueOf = Boolean.valueOf(true);
                bVar2.bbq = valueOf.booleanValue();
            }
            ak.vy().a(new n(com_tencent_mm_protocal_c_acj, str2, str3, i), 0);
            valueOf = Boolean.valueOf(true);
            bVar2.bbq = valueOf.booleanValue();
        }
        return true;
    }

    static /* synthetic */ boolean l(com.tencent.mm.sdk.c.b bVar) {
        v.i("MicroMsg.exdevice.ExdeviceEventManager", "receive StopAllChannelWithParamsEvent");
        ot otVar = (ot) bVar;
        ac.ajx();
        d.cL(otVar.bqc.bqd);
        return true;
    }

    static /* synthetic */ boolean m(e eVar, com.tencent.mm.sdk.c.b bVar) {
        dv dvVar = (dv) bVar;
        g gVar = eVar.ftc;
        if (!gVar.ftr) {
            v.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "stopScanNetworkDevice...");
            Java2CExDevice.stopScanWCLanDevice();
            gVar.ftr = true;
        }
        ak.vA().x(new Runnable(gVar) {
            final /* synthetic */ g ftT;

            {
                this.ftT = r1;
            }

            public final void run() {
                v.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "releaseWCLanDeviceLib...");
                Java2CExDevice.releaseWCLanDeviceLib();
            }
        });
        ak.vy().b(1717, gVar);
        j.ajh().b(14, gVar.ftJ);
        j.ajh().b(12, gVar.ftK);
        j.ajh().b(13, gVar.ftL);
        j.ajh().b(15, gVar.ftM);
        dvVar.bbO.bbq = true;
        return true;
    }

    static /* synthetic */ boolean m(com.tencent.mm.sdk.c.b bVar) {
        if (bVar != null && (bVar instanceof cr)) {
            cr crVar = (cr) bVar;
            String str = crVar.baC.baE;
            boolean z = crVar.baC.baB;
            d ajx = ac.ajx();
            v.i("MicroMsg.exdevice.ExdeviceConnectManager", "ranging, uuid = %s, op = %s", new Object[]{str, String.valueOf(z)});
            ak.vA().x(new com.tencent.mm.plugin.exdevice.model.d.AnonymousClass5(ajx, str, z));
        }
        return true;
    }

    static /* synthetic */ boolean n(e eVar, com.tencent.mm.sdk.c.b bVar) {
        String str = ((cd) bVar).aZK.aRh;
        g gVar = eVar.ftc;
        gVar.ftC.remove(str);
        if (gVar.ftH.get(str) != null) {
            v.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "cancelWCLanDeviceTask cmdId: " + gVar.ftH.get(str));
            Java2CExDevice.cancelWCLanDeviceTask(((Integer) gVar.ftH.get(str)).intValue());
        }
        return true;
    }

    static /* synthetic */ boolean n(com.tencent.mm.sdk.c.b bVar) {
        ci ciVar = (ci) bVar;
        com.tencent.mm.plugin.exdevice.h.b bt = ac.ajq().bt(ciVar.aZZ.bab, ciVar.aZZ.aRh);
        if (bt == null || (bt.field_connStrategy & 16) != 0) {
            ciVar.baa.aZW = false;
        } else {
            v.i("MicroMsg.exdevice.ExdeviceEventManager", "CONNECT_STRATEGY_IGNORE_ON_CHAT disable, (%s) do not disconnect ble device(%s)", new Object[]{ciVar.aZZ.bab, ciVar.aZZ.aRh});
            ciVar.baa.aZW = true;
        }
        return true;
    }

    static /* synthetic */ boolean o(e eVar, com.tencent.mm.sdk.c.b bVar) {
        dd ddVar = (dd) bVar;
        if (eVar.fta == null) {
            eVar.fta = new ExdeviceWCLanSDKUtil();
        }
        ExdeviceWCLanSDKUtil exdeviceWCLanSDKUtil = eVar.fta;
        if (ddVar.bbc.aZV) {
            v.i("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "initWCLanDeviceLib...");
            Java2CExDevice.initWCLanDeviceLib();
            j.ajh().a(14, exdeviceWCLanSDKUtil.ftJ);
            j.ajh().a(10, exdeviceWCLanSDKUtil.fub);
            j.ajh().a(13, exdeviceWCLanSDKUtil.ftL);
            j.ajh().a(16, exdeviceWCLanSDKUtil.fuc);
        } else {
            ak.vA().x(new Runnable(exdeviceWCLanSDKUtil) {
                final /* synthetic */ ExdeviceWCLanSDKUtil fui;

                {
                    this.fui = r1;
                }

                public final void run() {
                    v.i("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "releaseWCLanDeviceLib...");
                    Java2CExDevice.releaseWCLanDeviceLib();
                }
            });
            v.d("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "unregisterReceiver...");
            if (exdeviceWCLanSDKUtil.esp != null) {
                exdeviceWCLanSDKUtil.mContext.unregisterReceiver(exdeviceWCLanSDKUtil.esp);
                exdeviceWCLanSDKUtil.esp = null;
            }
            j.ajh().b(14, exdeviceWCLanSDKUtil.ftJ);
            j.ajh().b(10, exdeviceWCLanSDKUtil.fub);
            j.ajh().b(13, exdeviceWCLanSDKUtil.ftL);
            j.ajh().b(16, exdeviceWCLanSDKUtil.fuc);
        }
        return true;
    }

    static /* synthetic */ boolean o(com.tencent.mm.sdk.c.b bVar) {
        v.i("MicroMsg.exdevice.ExdeviceEventManager", "handleDeviceOPFromJSAPIEvent: %d", new Object[]{Integer.valueOf(((cx) bVar).baV.op)});
        if (((cx) bVar).baV.op == 1) {
            d ajx = ac.ajx();
            if (ajx.frR == null) {
                ajx.frR = new com.tencent.mm.plugin.exdevice.service.c();
                ajx.frR.fxm = new com.tencent.mm.plugin.exdevice.model.d.AnonymousClass11(ajx, 0);
                ajx.frR.bD(aa.getContext());
            }
        }
        return true;
    }

    static /* synthetic */ boolean p(e eVar, com.tencent.mm.sdk.c.b bVar) {
        if (((du) bVar).bbN.aZV) {
            v.i("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "startScanWCLanDevice...");
            Java2CExDevice.startScanWCLanDevice(new byte[0], BaseReportManager.MAX_READ_COUNT);
        } else {
            v.i("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "stopScanWCLanDevice...");
            Java2CExDevice.stopScanWCLanDevice();
        }
        return true;
    }

    static /* synthetic */ boolean q(e eVar, com.tencent.mm.sdk.c.b bVar) {
        ch chVar = (ch) bVar;
        v.i("MicroMsg.exdevice.ExdeviceEventManager", "ExDeviceConnectLanDeviceEvent: brandName=%s, deviceId=%s, type=%b", new Object[]{chVar.aZX.aZU, chVar.aZX.aRh, Boolean.valueOf(chVar.aZX.aZV)});
        if (rY(chVar.aZX.aZU)) {
            com.tencent.mm.plugin.exdevice.h.b sq = ac.ajq().sq(chVar.aZX.aRh);
            if (sq == null) {
                chVar.aZY.aZW = false;
                v.e("MicroMsg.exdevice.ExdeviceEventManager", "hdInfo null, %s", new Object[]{chVar.aZX.aRh});
                return false;
            } else if (sq.field_brandName.equals(chVar.aZX.aZU)) {
                boolean R = eVar.fta.R(chVar.aZX.aRh, chVar.aZX.aZV);
                chVar.aZY.aZW = R;
                return R;
            } else {
                chVar.aZY.aZW = false;
                v.e("MicroMsg.exdevice.ExdeviceEventManager", "brand name not match. %s != %s", new Object[]{sq.field_brandName, chVar.aZX.aZU});
                return false;
            }
        }
        chVar.aZY.aZW = false;
        return false;
    }

    static /* synthetic */ boolean q(com.tencent.mm.sdk.c.b bVar) {
        dk dkVar = (dk) bVar;
        v.i("MicroMsg.exdevice.ExdeviceEventManager", "handleSetSendDataDirectionEvent: %s, %s, %s", new Object[]{dkVar.bbu.aRh, Integer.valueOf(dkVar.bbu.direction), Boolean.valueOf(dkVar.bbu.bbw)});
        if (dkVar.bbu.bbw) {
            com.tencent.mm.plugin.exdevice.b.k.aiw().frk.clear();
            dkVar.bbv.aZW = true;
        } else if (be.kS(dkVar.bbu.aRh)) {
            dkVar.bbv.aZW = false;
        } else {
            com.tencent.mm.plugin.exdevice.b.k aiw = com.tencent.mm.plugin.exdevice.b.k.aiw();
            String str = dkVar.bbu.aRh;
            int i = dkVar.bbu.direction;
            if (!be.kS(str)) {
                aiw.frk.put(str, Integer.valueOf(i));
            }
            dkVar.bbv.aZW = true;
        }
        return true;
    }

    static /* synthetic */ boolean r(e eVar, com.tencent.mm.sdk.c.b bVar) {
        dh dhVar = (dh) bVar;
        v.i("MicroMsg.exdevice.ExdeviceEventManager", "ExDeviceSendDataToLanDeviceEvent: brandName=%s, deviceId=%s", new Object[]{dhVar.bbk.aZU, dhVar.bbk.aRh});
        if (!rY(dhVar.bbk.aZU) || be.kS(dhVar.bbk.data)) {
            dhVar.bbl.aZW = false;
            return false;
        } else if (ac.ajq().sq(dhVar.bbk.aRh) == null) {
            v.e("MicroMsg.exdevice.ExdeviceEventManager", "hdInfo error");
            dhVar.bbl.aZW = false;
            return false;
        } else {
            dhVar.bbl.aZW = eVar.fta.br(dhVar.bbk.aRh, dhVar.bbk.data);
            return true;
        }
    }

    static /* synthetic */ boolean r(com.tencent.mm.sdk.c.b bVar) {
        com.tencent.mm.e.a.cf.b bVar2;
        com.tencent.mm.e.a.cf.b bVar3;
        boolean z;
        cf cfVar = (cf) bVar;
        v.i("MicroMsg.exdevice.ExdeviceEventManager", "handleExDeviceCheckDeviceIsBoundEvent: deviceType(%s), deviceId(%s)", new Object[]{cfVar.aZP.aZN, cfVar.aZP.aRh});
        if (cfVar.aZP.aZN == null || cfVar.aZP.aRh == null) {
            bVar2 = cfVar.aZQ;
        } else {
            com.tencent.mm.plugin.exdevice.h.b bs = ac.ajq().bs(cfVar.aZP.aRh, cfVar.aZP.aZN);
            bVar2 = cfVar.aZQ;
            if (bs != null) {
                bVar3 = bVar2;
                z = true;
                bVar3.aZR = z;
                return true;
            }
        }
        bVar3 = bVar2;
        z = false;
        bVar3.aZR = z;
        return true;
    }

    static /* synthetic */ boolean s(com.tencent.mm.sdk.c.b bVar) {
        ce ceVar = (ce) bVar;
        v.i("MicroMsg.exdevice.ExdeviceEventManager", "handleExDeviceCheckDeviceHasAbilityEvent: deviceType(%s), deviceId(%s)", new Object[]{ceVar.aZL.aZN, ceVar.aZL.aRh});
        if (ceVar.aZL.aZN == null || ceVar.aZL.aRh == null) {
            ceVar.aZM.aZO = false;
        } else {
            bk bt = ac.ajq().bt(ceVar.aZL.aZN, ceVar.aZL.aRh);
            if (bt != null) {
                String str = bt.bLi;
                com.tencent.mm.e.a.ce.b bVar2 = ceVar.aZM;
                ac.ajq();
                bVar2.aZO = com.tencent.mm.plugin.exdevice.h.c.sr(str);
            } else {
                ceVar.aZM.aZO = false;
            }
        }
        return true;
    }

    static /* synthetic */ boolean t(com.tencent.mm.sdk.c.b bVar) {
        ck ckVar = (ck) bVar;
        v.i("MicroMsg.exdevice.ExdeviceEventManager", "handleExDeviceGetCurrentSSIDEvent: opCode = %b", new Object[]{Boolean.valueOf(ckVar.bae.aZV)});
        if (ckVar.bae.aZV) {
            String ssid = com.tencent.mm.sdk.platformtools.ak.getWifiInfo(aa.getContext()).getSSID();
            if (!be.kS(ssid)) {
                ckVar.baf.aZW = true;
                ckVar.baf.bag = ssid.replaceAll("\"", "");
                return true;
            }
        }
        ckVar.baf.aZW = false;
        ckVar.baf.bag = null;
        return true;
    }

    static /* synthetic */ boolean u(com.tencent.mm.sdk.c.b bVar) {
        dl dlVar = (dl) bVar;
        if (ac.ajq().ajZ().size() > 0) {
            dlVar.bbx.aZW = true;
        } else {
            dlVar.bbx.aZW = false;
        }
        return true;
    }

    public e() {
        HandlerThread Lg = com.tencent.mm.sdk.i.e.Lg("wifi_device_heart_beat");
        Lg.start();
        this.mHandler = new ac(Lg.getLooper());
    }

    private boolean c(com.tencent.mm.sdk.c.b bVar) {
        em emVar = (em) bVar;
        switch (emVar.bcU.action) {
            case 2:
                if (com.tencent.mm.plugin.exdevice.devicestep.c.aiE()) {
                    if (r.getInt(UpdateLogConst.ACTION_POP_INSTALL_DIALOG, 0) != 0) {
                        long j = r.getLong(207, 0);
                        long j2 = r.getLong(206, 0);
                        long currentTimeMillis = System.currentTimeMillis();
                        long j3 = emVar.bcU.bcX;
                        v.v("MicroMsg.exdevice.ExdeviceEventManager", "lastUpdateTime:%d lastUpdateStep:%d newUpdateTime:%d newUpdateStep:%d", new Object[]{Long.valueOf(j), Long.valueOf(j2), Long.valueOf(currentTimeMillis), Long.valueOf(j3)});
                        if (currentTimeMillis - j >= 300000) {
                            if (!be.r(currentTimeMillis, j)) {
                                j = be.bul();
                                j2 = 0;
                            }
                            long j4 = currentTimeMillis - j;
                            v.v("MicroMsg.exdevice.ExdeviceEventManager", "interval5m %d intervalTime %d newUpdateTime:%d compareUpdateTime:%d maxIncreaseStep:%d", new Object[]{Long.valueOf(((long) (j4 % 300000 > 0 ? 1 : 0)) + (j4 / 300000)), Long.valueOf(j4), Long.valueOf(currentTimeMillis), Long.valueOf(j), Long.valueOf(((long) p.ceL.cfr) * (((long) (j4 % 300000 > 0 ? 1 : 0)) + (j4 / 300000)))});
                            j2 = j3 - j2;
                            if (j2 >= 0 && j2 <= r14) {
                                v.i("MicroMsg.exdevice.ExdeviceEventManager", "can update time: %s, step: %d", new Object[]{com.tencent.mm.pluginsdk.j.o.F("yyyy-MM-dd", currentTimeMillis / 1000), Long.valueOf(j3)});
                                r.i(207, currentTimeMillis);
                                r.i(206, j3);
                                r.i(208, emVar.bcU.bcY);
                                emVar.bcV.bdb = 1;
                                break;
                            }
                            v.w("MicroMsg.exdevice.ExdeviceEventManager", "invalid step in 5 minute actual: %d max: %d", new Object[]{Long.valueOf(j2), Long.valueOf(r14)});
                            emVar.bcV.bdb = 3904;
                            break;
                        }
                        v.w("MicroMsg.exdevice.ExdeviceEventManager", "update interval must larger than 5 minute");
                        emVar.bcV.bdb = 3903;
                        break;
                    }
                    v.i("MicroMsg.exdevice.ExdeviceEventManager", "stepExtSwitch not open");
                    emVar.bcV.bdb = 3902;
                    break;
                }
                v.i("MicroMsg.exdevice.ExdeviceEventManager", "stepSwitch record data not open");
                emVar.bcV.bdb = 3901;
                break;
                break;
            case 3:
                if (be.kS(this.ftb)) {
                    InputStream inputStream = null;
                    try {
                        inputStream = aa.getContext().getAssets().open("ext_step_count_config.conf");
                        this.ftb = new String(com.tencent.mm.loader.stub.b.d(inputStream));
                    } catch (Throwable e) {
                        v.a("MicroMsg.exdevice.ExdeviceEventManager", e, e.getMessage(), new Object[0]);
                    } finally {
                        com.tencent.mm.a.e.c(inputStream);
                    }
                }
                if (!be.kS(this.ftb)) {
                    emVar.bcV.bcZ = this.ftb;
                    emVar.bcV.bdb = 1;
                    break;
                }
                emVar.bcV.bdb = 3905;
                break;
            default:
                return true;
        }
        emVar.bcV.bda = true;
        return true;
    }

    private boolean d(com.tencent.mm.sdk.c.b bVar) {
        cm cmVar = (cm) bVar;
        v.i("MicroMsg.exdevice.ExdeviceEventManager", "ExDeviceGetLanDeviceInfosEvent: brandName=%s, context=%s", new Object[]{cmVar.bak.aZU, cmVar.bak.context});
        if (rY(cmVar.bak.aZU)) {
            LinkedList ss = ac.ajq().ss(cmVar.bak.aZU);
            JSONArray jSONArray = new JSONArray();
            try {
                Iterator it = ss.iterator();
                while (it.hasNext()) {
                    com.tencent.mm.plugin.exdevice.h.b bVar2 = (com.tencent.mm.plugin.exdevice.h.b) it.next();
                    if (!ss.isEmpty() && be.ma(bVar2.field_connProto).contains("4")) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("deviceId", bVar2.field_deviceID);
                        if (this.fta.se(bVar2.field_deviceID)) {
                            jSONObject.put("state", "connected");
                        } else {
                            jSONObject.put("state", "disconnected");
                        }
                        jSONArray.put(jSONObject);
                    }
                }
            } catch (Exception e) {
                v.e("MicroMsg.exdevice.ExdeviceEventManager", "Ex in handleGetDeviceInfosEvent, %s", new Object[]{e.getMessage()});
            }
            cmVar.bal.baj = jSONArray;
            cmVar.bal.aZW = true;
            v.i("MicroMsg.exdevice.ExdeviceEventManager", "GetDeviceInfos: %s", new Object[]{jSONArray.toString()});
        } else {
            cmVar.bal.baj = null;
            cmVar.bal.aZW = false;
        }
        return true;
    }

    private static boolean e(String str, List<com.tencent.mm.plugin.exdevice.h.b> list) {
        String host = Uri.parse(str).getHost();
        v.i("MicroMsg.exdevice.ExdeviceEventManager", "is url...");
        JSONArray jSONArray = null;
        boolean z = false;
        for (com.tencent.mm.plugin.exdevice.h.b bVar : list) {
            boolean z2;
            String str2 = bVar.bLi;
            String str3 = bVar.bLj;
            if (str3 == null || str3.length() <= 0 || str2 == null || !str2.contains("wxmsg_url")) {
                z2 = z;
            } else {
                JSONArray jSONArray2;
                boolean z3;
                try {
                    jSONArray2 = new JSONObject(str3).getJSONArray("wxmsg_url");
                } catch (Throwable e) {
                    v.a("MicroMsg.exdevice.ExdeviceEventManager", e, "", new Object[0]);
                    jSONArray2 = jSONArray;
                }
                int length = jSONArray2.length();
                int i = 0;
                while (i < length) {
                    try {
                        if (jSONArray2.getString(i).equals(host)) {
                            z3 = true;
                            break;
                        }
                        i++;
                    } catch (Throwable e2) {
                        v.a("MicroMsg.exdevice.ExdeviceEventManager", e2, "", new Object[0]);
                    }
                }
                z3 = z;
                if (z3) {
                    return z3;
                }
                JSONArray jSONArray3 = jSONArray2;
                z2 = z3;
                jSONArray = jSONArray3;
            }
            z = z2;
        }
        return z;
    }

    private static boolean f(String str, List<com.tencent.mm.plugin.exdevice.h.b> list) {
        if (str == null) {
            return false;
        }
        boolean z;
        gs gsVar = new gs();
        gsVar.bgj.bap = str;
        com.tencent.mm.sdk.c.a.nhr.z(gsVar);
        azr com_tencent_mm_protocal_c_azr = gsVar.bgk.bgl;
        int i = com_tencent_mm_protocal_c_azr.mWq.mol;
        String str2;
        if (i == 1) {
            v.i("MicroMsg.exdevice.ExdeviceEventManager", "is photo...");
            for (com.tencent.mm.plugin.exdevice.h.b bVar : list) {
                str2 = bVar.bLi;
                if (str2 != null && str2.contains("wxmsg_image")) {
                    z = true;
                    break;
                }
            }
            z = false;
        } else if (i == 4) {
            v.i("MicroMsg.exdevice.ExdeviceEventManager", "is music...");
            for (com.tencent.mm.plugin.exdevice.h.b bVar2 : list) {
                str2 = bVar2.bLi;
                if (str2 != null && str2.contains("wxmsg_music")) {
                    z = true;
                    break;
                }
            }
            z = false;
        } else if (i == 15) {
            v.i("MicroMsg.exdevice.ExdeviceEventManager", "is sight...");
            for (com.tencent.mm.plugin.exdevice.h.b bVar22 : list) {
                str2 = bVar22.bLi;
                if (str2 != null && str2.contains("wxmsg_video")) {
                    z = true;
                    break;
                }
            }
            z = false;
        } else {
            z = i == 3 ? e(com_tencent_mm_protocal_c_azr.mWq.glb, (List) list) : false;
        }
        v.i("MicroMsg.exdevice.ExdeviceEventManager", "isSupportsSnsInfo = " + z + ", snsLocalId = " + str);
        return z;
    }

    private static boolean e(com.tencent.mm.sdk.c.b bVar) {
        cl clVar = (cl) bVar;
        v.i("MicroMsg.exdevice.ExdeviceEventManager", "handleGetDeviceInfosEvent: brandName=%s, context=%s", new Object[]{clVar.bah.aZU, clVar.bah.context});
        LinkedList ss = ac.ajq().ss(clVar.bah.aZU);
        JSONArray jSONArray = new JSONArray();
        try {
            Iterator it = ss.iterator();
            while (it.hasNext()) {
                com.tencent.mm.plugin.exdevice.h.b bVar2 = (com.tencent.mm.plugin.exdevice.h.b) it.next();
                if (!ss.isEmpty()) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("deviceId", bVar2.field_deviceID);
                    if (u.ajV().be(bVar2.field_mac)) {
                        jSONObject.put("state", "connected");
                    } else {
                        jSONObject.put("state", "disconnected");
                    }
                    jSONArray.put(jSONObject);
                }
            }
        } catch (Exception e) {
            v.e("MicroMsg.exdevice.ExdeviceEventManager", "Ex in handleGetDeviceInfosEvent, %s", new Object[]{e.getMessage()});
        }
        clVar.bai.baj = jSONArray;
        clVar.bai.aZW = true;
        v.i("MicroMsg.exdevice.ExdeviceEventManager", "GetDeviceInfos: %s", new Object[]{jSONArray.toString()});
        return true;
    }

    private static boolean f(com.tencent.mm.sdk.c.b bVar) {
        dg dgVar = (dg) bVar;
        v.i("MicroMsg.exdevice.ExdeviceEventManager", "handleSendDataToDeviceEvent: brandName=%s, deviceId=%s", new Object[]{dgVar.bbi.aZU, dgVar.bbi.aRh});
        if (be.bl(dgVar.bbi.data)) {
            dgVar.bbj.aZW = false;
            return false;
        }
        com.tencent.mm.plugin.exdevice.h.b sq = ac.ajq().sq(dgVar.bbi.aRh);
        if (sq == null) {
            v.e("MicroMsg.exdevice.ExdeviceEventManager", "hdInfo error");
            dgVar.bbj.aZW = false;
            return false;
        } else if (!u.ajV().be(sq.field_mac)) {
            v.e("MicroMsg.exdevice.ExdeviceEventManager", "haven't connect");
            dgVar.bbj.aZW = false;
            return false;
        } else if (u.ajV().bk(sq.field_mac)) {
            if (aa.ajn().ftU) {
                aa.ajn().kn(a(sq));
            }
            u.ajW().a(new com.tencent.mm.plugin.exdevice.i.g(dgVar.bbi.data, 10001, sq.field_mac));
            dgVar.bbj.aZW = true;
            return true;
        } else {
            v.e("MicroMsg.exdevice.ExdeviceEventManager", "haven't authed");
            dgVar.bbj.aZW = false;
            return false;
        }
    }

    private static int a(com.tencent.mm.plugin.exdevice.h.b bVar) {
        if (be.ma(bVar.field_connProto).contains("1")) {
            return 1;
        }
        if (be.ma(bVar.field_connProto).contains("3")) {
            return 0;
        }
        return -1;
    }

    private boolean g(com.tencent.mm.sdk.c.b bVar) {
        final co coVar = (co) bVar;
        v.i("MicroMsg.exdevice.ExdeviceEventManager", "handleGetTicketEvent: brandName=%s, deviceId=%s, type=%d", new Object[]{coVar.bat.aZU, coVar.bat.aRh, Integer.valueOf(coVar.bat.type)});
        wk wkVar = new wk();
        wkVar.myO = coVar.bat.type;
        wkVar.myP = 0;
        wkVar.mgb = new abt();
        wkVar.mgb.eez = coVar.bat.aRh;
        wkVar.mgb.meq = coVar.bat.aZU;
        LinkedList linkedList = new LinkedList();
        linkedList.add(wkVar);
        AnonymousClass38 anonymousClass38 = new com.tencent.mm.v.e(this) {
            final /* synthetic */ e fti;

            public final void a(int i, int i2, String str, com.tencent.mm.v.k kVar) {
                if (kVar == null || kVar.getType() != 543) {
                    coVar.bau.baw = true;
                    coVar.bau.bax = null;
                    if (coVar.bpT != null) {
                        coVar.bpT.run();
                        return;
                    }
                    return;
                }
                ak.vy().b(543, this);
                if (i == 0 && i2 == 0) {
                    wm wmVar;
                    v.i("MicroMsg.exdevice.ExdeviceEventManager", "getTicketSceneEndImpl errType = [%s], errCode = [%s]， errMsg = [%s]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
                    z zVar = (z) kVar;
                    if (zVar.fut == null || zVar.fut.czl.czs == null) {
                        wmVar = null;
                    } else {
                        wmVar = (wm) zVar.fut.czl.czs;
                    }
                    Iterator it = wmVar.myS.iterator();
                    Object obj = null;
                    while (it.hasNext()) {
                        wn wnVar = (wn) it.next();
                        if (wnVar != null) {
                            String str2 = null;
                            String str3 = null;
                            if (wnVar.mgb != null) {
                                str2 = wnVar.mgb.eez;
                                str3 = wnVar.mgb.meq;
                            }
                            if (wnVar.mcj != 0 || be.kS(wnVar.mpB)) {
                                v.e("MicroMsg.exdevice.ExdeviceEventManager", "deviceId(%s) get ticket fail. ret=%d, ticket=%s", new Object[]{str2, Integer.valueOf(wnVar.mcj), wnVar.mpB});
                            } else {
                                Object obj2;
                                v.i("MicroMsg.exdevice.ExdeviceEventManager", "GetHardDeviceOperTicket end. deviceId=%s, deviceType=%s, ticket=%s, oper=%d", new Object[]{str2, str3, wnVar.mpB, Integer.valueOf(wnVar.myO)});
                                coVar.bau.baw = true;
                                coVar.bau.bax = wnVar.mpB;
                                if (coVar.bpT != null) {
                                    coVar.bpT.run();
                                    obj2 = 1;
                                } else {
                                    obj2 = obj;
                                }
                                obj = obj2;
                            }
                        }
                    }
                    if (obj == null) {
                        coVar.bau.baw = true;
                        coVar.bau.bax = null;
                        if (coVar.bpT != null) {
                            coVar.bpT.run();
                            return;
                        }
                        return;
                    }
                    return;
                }
                v.e("MicroMsg.exdevice.ExdeviceEventManager", "getTicketSceneEndImpl errType = [%s], errCode = [%s]， errMsg = [%s]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
                coVar.bau.baw = true;
                coVar.bau.bax = null;
                if (coVar.bpT != null) {
                    coVar.bpT.run();
                }
            }
        };
        z zVar = new z(linkedList, coVar.bat.aZU, coVar.bat.bav);
        ak.vy().a(543, anonymousClass38);
        if (ak.vy().a(zVar, 0)) {
            return false;
        }
        v.e("MicroMsg.exdevice.ExdeviceEventManager", "MMCore.getNetSceneQueue().doScene failed!!!");
        ak.vy().b(543, anonymousClass38);
        coVar.bau.baw = true;
        coVar.bau.bax = null;
        if (coVar.bpT == null) {
            return true;
        }
        coVar.bpT.run();
        return true;
    }

    private boolean h(com.tencent.mm.sdk.c.b bVar) {
        de deVar = (de) bVar;
        v.i("MicroMsg.exdevice.ExdeviceEventManager", "handleScanDeviceEvent: brandName=%s, op=%s, btVersion=%s", new Object[]{deVar.bbd.aZU, Boolean.valueOf(deVar.bbd.aZV), Integer.valueOf(deVar.bbd.bbf)});
        int i = deVar.bbd.bbf;
        if (!(i == 0 || i == 1)) {
            if (com.tencent.mm.plugin.c.a.e.a.by(aa.getContext())) {
                v.w("MicroMsg.exdevice.ExdeviceEventManager", "invalid btVersion %s, use defalut BLE", new Object[]{Integer.valueOf(i)});
                i = 0;
            } else {
                v.e("MicroMsg.exdevice.ExdeviceEventManager", "invalid btVersion %s, return fail", new Object[]{Integer.valueOf(i)});
                deVar.bbe.aZW = false;
                return false;
            }
        }
        if (deVar.bbd.aZV) {
            com.tencent.mm.plugin.exdevice.service.j ajn = aa.ajn();
            String str = deVar.bbd.aZU;
            com.tencent.mm.plugin.exdevice.model.aa.a anonymousClass39 = new com.tencent.mm.plugin.exdevice.model.aa.a(this) {
                final /* synthetic */ e fti;

                {
                    this.fti = r1;
                }

                public final void b(String str, byte[] bArr, boolean z) {
                    v.i("MicroMsg.exdevice.ExdeviceEventManager", "OnScanDevice %s", new Object[]{str});
                    e.a(str, bArr, z);
                }
            };
            v.i("MicroMsg.exdevice.ScanDeviceLogic", "startScanDevice, brandName=%s", new Object[]{str});
            if (be.kS(str)) {
                v.i("MicroMsg.exdevice.ScanDeviceLogic", "brand name is null");
            } else {
                ajn.fto = str;
                ajn.fuI = anonymousClass39;
                ajn.fuJ.clear();
                Iterator it = ajn.fuK.iterator();
                while (it.hasNext()) {
                    com.tencent.mm.v.k kVar = (com.tencent.mm.v.k) it.next();
                    if (kVar != null) {
                        ak.vy().c(kVar);
                    }
                }
                ajn.fuK.clear();
                synchronized (aa.cCN) {
                    aa.fuL.clear();
                }
                if (ajn.ftU) {
                    v.w("MicroMsg.exdevice.ScanDeviceLogic", "still scanning. just change brand name and callback");
                } else {
                    ajn.ftU = true;
                    ak.vy().a(542, ajn);
                    ac.ajx().a(i, ajn);
                    v.i("MicroMsg.exdevice.ScanDeviceLogic", "should start scan, startTimer");
                    ajn.dIO.ea(12000);
                }
            }
        } else {
            aa.ajn().kn(i);
        }
        deVar.bbe.aZW = true;
        return true;
    }

    private static boolean rY(String str) {
        BizInfo hw = com.tencent.mm.modelbiz.e.hw(str);
        if (hw == null) {
            v.e("MicroMsg.exdevice.ExdeviceEventManager", "bizInfo is null");
            return false;
        }
        ExtInfo aX = hw.aX(false);
        if (aX != null && aX.CR() != null && aX.CR().Da()) {
            return true;
        }
        v.e("MicroMsg.exdevice.ExdeviceEventManager", "this is not hardware biz");
        return false;
    }

    private boolean a(com.tencent.mm.plugin.exdevice.h.b bVar, int i, int i2) {
        v.i("MicroMsg.exdevice.ExdeviceEventManager", "handleSwitchViewEvent");
        if (bVar == null) {
            v.i("MicroMsg.exdevice.ExdeviceEventManager", "HardDeviceInfo is null.");
            return false;
        }
        String str = bVar.field_brandName;
        com.tencent.mm.plugin.exdevice.service.f.a bg = u.ajV().bg(bVar.field_mac);
        if (bg == null) {
            v.i("MicroMsg.exdevice.ExdeviceEventManager", "can not find the hardevice connect state");
            return false;
        }
        if (bg.baO == 2) {
            v.i("MicroMsg.exdevice.ExdeviceEventManager", "notify the connect device %s", new Object[]{str});
            u.ajW().a(new com.tencent.mm.plugin.exdevice.i.j(i, i2, bVar.field_mac));
        }
        ac.ajx().kl(i == 1 ? 1 : 0);
        if (i == 2) {
            v.i("MicroMsg.exdevice.ExdeviceEventManager", "now exit chattingui, do not notify change the subtitle");
            ah ahVar = (ah) ac.ajx().frT.remove(Long.valueOf(bVar.field_mac));
            if (ahVar != null) {
                ahVar.QI();
            }
            v.i("MicroMsg.exdevice.ExdeviceEventManager", "Device close strategy(%d)", new Object[]{Integer.valueOf(bVar.field_closeStrategy)});
            if (!((bVar.field_closeStrategy & 1) == 0 && u.ajV().bk(bg.fxs) && (2 == bg.baO || bg.baO == 0))) {
                v.i("MicroMsg.exdevice.ExdeviceEventManager", "now the device is not auth or not connect  or closeStrategy is to close after exit, try to stop connetct, connet state is %d, device is %s", new Object[]{Integer.valueOf(bg.baO), str});
                if (u.ajW().frL != null) {
                    u.ajW().frL.bm(bg.fxs);
                }
            }
            if (f.e(bVar)) {
                v.i("MicroMsg.exdevice.ExdeviceEventManager", "try to disconnect simpleBTDevice(%s).", new Object[]{Long.valueOf(bVar.field_mac)});
                rZ(com.tencent.mm.plugin.exdevice.j.b.br(bVar.field_mac));
            }
            return true;
        } else if (2 == bg.baO || com.tencent.mm.pluginsdk.j.am.lym == null || !com.tencent.mm.pluginsdk.j.am.lym.bhL()) {
            return true;
        } else {
            v.i("MicroMsg.exdevice.ExdeviceEventManager", "getWearCommand is null or wear has connected in the brandName.");
            return false;
        }
    }

    private boolean d(List<com.tencent.mm.plugin.exdevice.h.b> list, int i) {
        v.i("MicroMsg.exdevice.ExdeviceEventManager", "handleWifiDeviceSwitchViewEvent");
        if (list.size() == 0) {
            v.i("MicroMsg.exdevice.ExdeviceEventManager", "HardDeviceInfo is null or nil.");
            return false;
        }
        int i2 = -1;
        switch (i) {
            case 1:
                if (this.fte) {
                    this.mHandler.removeCallbacks(this.ftf);
                }
                this.ftf = new c(this, list);
                this.mHandler.postDelayed(this.ftf, 300000);
                this.fte = true;
                i2 = 2;
                break;
            case 2:
                if (this.fte) {
                    this.mHandler.removeCallbacks(this.ftf);
                    this.fte = false;
                }
                i2 = 0;
                break;
        }
        for (com.tencent.mm.plugin.exdevice.h.b bVar : list) {
            u.ajW().a(new k(bVar.field_brandName, bVar.field_deviceType, bVar.field_deviceID, i2));
        }
        return true;
    }

    @TargetApi(19)
    private static boolean aiO() {
        try {
            if (com.tencent.mm.plugin.exdevice.devicestep.c.aiC() && com.tencent.mm.plugin.exdevice.devicestep.c.aiF()) {
                return true;
            }
            return false;
        } catch (Exception e) {
            v.e("MicroMsg.exdevice.ExdeviceEventManager", "[hakon][Step], Exception in registerDetector %s", new Object[]{e.getMessage()});
            return false;
        }
    }

    private static boolean aiP() {
        try {
            return com.tencent.mm.plugin.exdevice.devicestep.c.aiE() && r.getInt(UpdateLogConst.ACTION_POP_INSTALL_DIALOG, 0) != 0;
        } catch (Exception e) {
            return false;
        }
    }

    private static boolean aiQ() {
        LinkedList aka = ac.ajq().aka();
        if (aka.isEmpty()) {
            v.i("MicroMsg.exdevice.ExdeviceEventManager", "get harddevice info is null or empty");
            return false;
        }
        ac.ajx().kl(2);
        Iterator it = aka.iterator();
        while (it.hasNext()) {
            com.tencent.mm.plugin.exdevice.h.b bVar = (com.tencent.mm.plugin.exdevice.h.b) it.next();
            ak.yW();
            com.tencent.mm.storage.u LX = com.tencent.mm.model.c.wH().LX(bVar.field_brandName);
            if (LX == null || !com.tencent.mm.i.a.ei(LX.field_type)) {
                v.e("MicroMsg.exdevice.ExdeviceEventManager", "%s is not my contact now, may be has been deleted", new Object[]{bVar.field_brandName});
            } else if ((bVar.field_connStrategy & 4) == 0) {
                v.i("MicroMsg.exdevice.ExdeviceEventManager", "Connect Strategy is %d, no need to sync in main ui", new Object[]{Integer.valueOf(bVar.field_connStrategy)});
            } else {
                v.i("MicroMsg.exdevice.ExdeviceEventManager", "now try to connect %s", new Object[]{bVar.field_brandName});
                ac.ajx().a(bVar.field_brandName, bVar.field_mac, 0, true);
            }
        }
        return true;
    }

    private static boolean b(com.tencent.mm.plugin.exdevice.h.b bVar) {
        v.i("MicroMsg.exdevice.ExdeviceEventManager", "update Api Step");
        Calendar instance = Calendar.getInstance();
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        ak.yW();
        com.tencent.mm.storage.u LX = com.tencent.mm.model.c.wH().LX(bVar.field_brandName);
        if (LX == null || !com.tencent.mm.i.a.ei(LX.field_type)) {
            v.e("MicroMsg.exdevice.ExdeviceEventManager", "[hakon][step]%s not contact, may be has been deleted", new Object[]{bVar.field_brandName});
            return false;
        }
        String str = "";
        if (bVar.field_connProto != null && bVar.field_connProto.contains("6")) {
            str = Build.MANUFACTURER + "_" + Build.MODEL;
        }
        long j = r.getLong(206, 0);
        if (j == 0) {
            return false;
        }
        v.i("MicroMsg.exdevice.ExdeviceEventManager", "update Api Step time: %s stepCount: %s", new Object[]{com.tencent.mm.pluginsdk.j.o.F("yyyy-MM-dd HH:mm", r.getLong(207, 0) / 1000), Long.valueOf(j)});
        Calendar instance2 = Calendar.getInstance();
        instance2.setTimeInMillis(r0);
        if (!instance2.after(instance)) {
            return false;
        }
        ak.vy().a(new com.tencent.mm.plugin.exdevice.devicestep.b(bVar.field_deviceID, bVar.field_deviceType, (int) (instance.getTimeInMillis() / 1000), (int) (instance2.getTimeInMillis() / 1000), (int) j, str, 2), 0);
        return true;
    }

    private boolean G(int i, String str) {
        v.v("MicroMsg.exdevice.ExdeviceEventManager", "handleInChattingUI.");
        BizInfo hw = com.tencent.mm.modelbiz.e.hw(str);
        if (hw == null) {
            v.e("MicroMsg.exdevice.ExdeviceEventManager", "bizInfo is null");
            return false;
        }
        ExtInfo aX = hw.aX(false);
        if (aX != null) {
            com.tencent.mm.modelbiz.BizInfo.ExtInfo.a CR = aX.CR();
            if (CR != null && CR.Da()) {
                List<com.tencent.mm.plugin.exdevice.h.b> ss = ac.ajq().ss(str);
                if (CR.cCd == 1) {
                    List<com.tencent.mm.plugin.exdevice.h.b> aka = ac.ajq().aka();
                    if (aka.size() != 0) {
                        for (com.tencent.mm.plugin.exdevice.h.b bVar : aka) {
                            v.i("MicroMsg.exdevice.ExdeviceEventManager", "BLE hard device info, mac(%s), deviceId(%s), deviceType(%s), SimpleProtol(%d)", new Object[]{Long.valueOf(bVar.field_mac), bVar.field_deviceID, bVar.field_deviceType, Long.valueOf(bVar.bLh)});
                            if (0 != (bVar.bLh & 1)) {
                                ss.add(bVar);
                            }
                        }
                    }
                }
                if (ss == null) {
                    v.i("MicroMsg.exdevice.ExdeviceEventManager", "handleInChattingUI, hdInfo is null.");
                    return false;
                } else if (ss.size() == 0) {
                    v.i("MicroMsg.exdevice.ExdeviceEventManager", "handleInChattingUI, hdInfo size is 0.");
                    return true;
                } else {
                    Object obj = null;
                    int i2 = 0;
                    int i3 = 0;
                    for (final com.tencent.mm.plugin.exdevice.h.b bVar2 : ss) {
                        if (bVar2 == null) {
                            v.e("MicroMsg.exdevice.ExdeviceEventManager", "hdInfo error");
                        } else if (be.ma(bVar2.field_connProto).contains("4")) {
                            v.i("MicroMsg.exdevice.ExdeviceEventManager", "%s, Wifi biz, continue.", new Object[]{bVar2.field_brandName});
                        } else if ((bVar2.field_connStrategy & 16) != 0) {
                            v.i("MicroMsg.exdevice.ExdeviceEventManager", "%s, Connect stragegy(%d) ignore connection on chat, continue!!!", new Object[]{bVar2.field_brandName, Integer.valueOf(bVar2.field_connStrategy)});
                        } else {
                            int i4;
                            int i5;
                            int i6;
                            if (be.ma(bVar2.field_connProto).contains("1")) {
                                i6 = i2 + 1;
                                if (com.tencent.mm.plugin.c.a.e.a.Xu()) {
                                    i4 = i3;
                                    i5 = i6;
                                    i3 = 1;
                                } else {
                                    v.e("MicroMsg.exdevice.ExdeviceEventManager", "%s, device is BC, but you phone not support BC.", new Object[]{bVar2.field_brandName});
                                    i2 = i6;
                                }
                            } else if (be.ma(bVar2.field_connProto).contains("3")) {
                                i6 = i3 + 1;
                                if (com.tencent.mm.plugin.c.a.e.a.by(aa.getContext())) {
                                    i3 = 0;
                                    i4 = i6;
                                    i5 = i2;
                                } else {
                                    v.e("MicroMsg.exdevice.ExdeviceEventManager", "device is BLE, but you phone not support BLE.");
                                    i3 = i6;
                                }
                            } else {
                                i4 = i3;
                                i5 = i2;
                                i3 = -1;
                            }
                            v.i("MicroMsg.exdevice.ExdeviceEventManager", "receive ExDeviceOpInChattingUIEventListener, op(%d), brandName(%s), connProto(%s),", new Object[]{Integer.valueOf(i), bVar2.field_brandName, bVar2.field_connProto});
                            if (i == 0) {
                                d ajx = ac.ajx();
                                long j = bVar2.field_mac;
                                v.i("MicroMsg.exdevice.ExdeviceConnectManager", "StopSyncTimer, device Id = %d", new Object[]{Long.valueOf(j)});
                                if (ajx.frU.containsKey(Long.valueOf(j))) {
                                    v.i("MicroMsg.exdevice.ExdeviceConnectManager", "Switch from main view to chatting view before exdevice sync timeout, just stop MTimerHandler");
                                    ah ahVar = (ah) ajx.frU.remove(Long.valueOf(j));
                                    if (ahVar != null) {
                                        ahVar.QI();
                                    } else {
                                        v.e("MicroMsg.exdevice.ExdeviceConnectManager", "Remove deviceId(%d) from syncTimeOutMap failed!!!", new Object[]{Long.valueOf(j)});
                                    }
                                }
                                if (u.ajV().be(bVar2.field_mac)) {
                                    v.i("MicroMsg.exdevice.ExdeviceEventManager", "Enter chatting ui, find this deivce has been connected aready, device name = %s, device id = %d", new Object[]{bVar2.field_brandName, Long.valueOf(bVar2.field_mac)});
                                    if (u.ajV().bk(bVar2.field_mac)) {
                                        v.i("MicroMsg.exdevice.ExdeviceEventManager", "This device is auth aready");
                                        a(bVar2.field_brandName, bVar2.field_url, 2, bVar2.field_deviceID);
                                        i3 = i4;
                                        i2 = i5;
                                    } else {
                                        v.i("MicroMsg.exdevice.ExdeviceEventManager", "This device has been connected but not auth yet.");
                                        i3 = i4;
                                        i2 = i5;
                                    }
                                } else if (!com.tencent.mm.plugin.exdevice.service.d.bE(aa.getContext())) {
                                    v.e("MicroMsg.exdevice.ExdeviceEventManager", "service not running");
                                    i3 = i4;
                                    i2 = i5;
                                } else if (f.e(bVar2)) {
                                    v.i("MicroMsg.exdevice.ExdeviceEventManager", "Connect simple device, mac(%s), brandName(%s)", new Object[]{com.tencent.mm.plugin.exdevice.j.b.br(bVar2.field_mac), bVar2.field_brandName});
                                    a(bVar2.field_brandName + bVar2.field_mac, new a(this, bVar2.field_brandName, com.tencent.mm.plugin.exdevice.j.b.br(bVar2.field_mac), bVar2.field_url, bVar2.field_deviceID));
                                    sa(com.tencent.mm.plugin.exdevice.j.b.br(bVar2.field_mac));
                                } else {
                                    v.i("MicroMsg.exdevice.ExdeviceEventManager", "Connect AirSync device, mac(%s), brandName(%s)", new Object[]{com.tencent.mm.plugin.exdevice.j.b.br(bVar2.field_mac), bVar2.field_brandName});
                                    ac.ajx().kl(1);
                                    ac.ajx().a(Long.valueOf(bVar2.field_mac), bVar2.field_connStrategy);
                                    ac.ajx().c(bVar2.field_brandName, bVar2.field_mac, i3);
                                }
                            } else if (i == 1) {
                                if (f.e(bVar2)) {
                                    a(bVar2.field_brandName + bVar2.field_mac, new a(this, bVar2.field_brandName, com.tencent.mm.plugin.exdevice.j.b.br(bVar2.field_mac), bVar2.field_url, bVar2.field_deviceID));
                                    sa(com.tencent.mm.plugin.exdevice.j.b.br(bVar2.field_mac));
                                } else {
                                    ac.ajx().a(Long.valueOf(bVar2.field_mac), bVar2.field_connStrategy);
                                    ac.ajx().c(bVar2.field_brandName, bVar2.field_mac, i3);
                                }
                            } else if (i == 2) {
                                if (f.e(bVar2)) {
                                    rZ(com.tencent.mm.plugin.exdevice.j.b.br(bVar2.field_mac));
                                } else {
                                    ac.ajx();
                                    d.aU(bVar2.field_mac);
                                }
                            }
                            if (be.ma(bVar2.field_connProto).contains("6") && r11 == null) {
                                ak.yW();
                                com.tencent.mm.storage.u LX = com.tencent.mm.model.c.wH().LX(bVar2.field_brandName);
                                if (LX == null || !com.tencent.mm.i.a.ei(LX.field_type)) {
                                    v.e("MicroMsg.exdevice.ExdeviceEventManager", "[hakon][step]%s not contact", new Object[]{bVar2.field_brandName});
                                    i3 = i4;
                                    i2 = i5;
                                } else {
                                    com.tencent.mm.plugin.exdevice.devicestep.c.cI(true);
                                    obj = 1;
                                    com.tencent.mm.compatible.a.a.a(19, new com.tencent.mm.compatible.a.a.a(this) {
                                        final /* synthetic */ e fti;

                                        public final void run() {
                                            if (e.aiO()) {
                                                ac.ajx().l(new Runnable(this) {
                                                    final /* synthetic */ AnonymousClass46 ftn;

                                                    {
                                                        this.ftn = r1;
                                                    }

                                                    public final void run() {
                                                        e.c(bVar2);
                                                    }
                                                });
                                            }
                                            if (e.aiP()) {
                                                v.i("MicroMsg.exdevice.ExdeviceEventManager", "upload api step result %b", new Object[]{Boolean.valueOf(e.b(bVar2))});
                                            }
                                        }
                                    });
                                }
                            }
                            i3 = i4;
                            i2 = i5;
                            obj = obj;
                        }
                    }
                    if (i2 + i3 <= 0) {
                        as(str, -1);
                    } else if (!com.tencent.mm.plugin.c.a.e.a.Xw()) {
                        v.w("MicroMsg.exdevice.ExdeviceEventManager", "System bluetooth is close");
                        as(str, 0);
                    } else if (i3 > 0 && i2 == 0 && !com.tencent.mm.plugin.c.a.e.a.by(aa.getContext())) {
                        as(str, 1);
                    }
                    em emVar = new em();
                    emVar.bcU.action = 1;
                    com.tencent.mm.sdk.c.a.nhr.a(emVar, Looper.getMainLooper());
                    return true;
                }
            }
        }
        v.e("MicroMsg.exdevice.ExdeviceEventManager", "this is not hardware biz");
        return false;
    }

    private static boolean aiR() {
        if (!com.tencent.mm.plugin.c.a.e.a.by(aa.getContext())) {
            v.e("MicroMsg.exdevice.ExdeviceEventManager", "now sdk version not support ble device : %d", new Object[]{Integer.valueOf(VERSION.SDK_INT)});
            return false;
        } else if (com.tencent.mm.plugin.c.a.e.a.Xw()) {
            return true;
        } else {
            v.e("MicroMsg.exdevice.ExdeviceEventManager", "Bluetooth is not open, Just leave");
            return false;
        }
    }

    public static boolean aiS() {
        v.d("MicroMsg.exdevice.ExdeviceEventManager", "handleExDeviceSimpleBTScanDevice");
        if (aiR()) {
            ac.ajC().ajg();
            return true;
        }
        v.e("MicroMsg.exdevice.ExdeviceEventManager", "isBTOpenAndBLESupported return false");
        return false;
    }

    private static boolean rZ(String str) {
        v.d("MicroMsg.exdevice.ExdeviceEventManager", "handleExDeviceSimpleBTDisconnectDevice, mac(%s).", new Object[]{str});
        if (!aiR()) {
            v.e("MicroMsg.exdevice.ExdeviceEventManager", "isBTOpenAndBLESupported return false");
            return false;
        } else if (be.kS(str)) {
            v.e("MicroMsg.exdevice.ExdeviceEventManager", "mac is null or nil");
            return false;
        } else {
            ac.ajC();
            h.aU(com.tencent.mm.plugin.exdevice.j.b.sE(str));
            return true;
        }
    }

    private boolean sa(String str) {
        v.d("MicroMsg.exdevice.ExdeviceEventManager", "handleExDeviceSimpleBTConnectDevice");
        if (!aiR()) {
            v.e("MicroMsg.exdevice.ExdeviceEventManager", "isBTOpenAndBLESupported return false");
            return false;
        } else if (be.kS(str)) {
            v.e("MicroMsg.exdevice.ExdeviceEventManager", "mac is null or nil");
            return false;
        } else {
            ac.ajC().a(com.tencent.mm.plugin.exdevice.j.b.sE(str), new com.tencent.mm.plugin.exdevice.model.h.a(this) {
                final /* synthetic */ e fti;

                {
                    this.fti = r1;
                }

                public final void a(long j, int i, int i2, int i3, long j2) {
                    v.d("MicroMsg.exdevice.ExdeviceEventManager", "mac=%d, oldState=%d, newState=%d, errCode=%d, profileType=%d", new Object[]{Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j2)});
                    e.a(this.fti, com.tencent.mm.plugin.exdevice.j.b.br(j), i2, j2);
                }
            });
            return true;
        }
    }

    public final boolean m(String str, byte[] bArr) {
        if (be.kS(str) || be.bl(bArr)) {
            String str2;
            int i;
            String str3 = "MicroMsg.exdevice.ExdeviceEventManager";
            String str4 = "input error. mac = %s, dataLen = %d";
            Object[] objArr = new Object[2];
            if (be.kS(str)) {
                str2 = "null";
            } else {
                str2 = "mac";
            }
            objArr[0] = str2;
            if (be.bl(bArr)) {
                i = 0;
            } else {
                i = bArr.length;
            }
            objArr[1] = Integer.valueOf(i);
            v.e(str3, str4, objArr);
            return false;
        }
        str3 = "MicroMsg.exdevice.ExdeviceEventManager";
        str4 = "handleExDeviceSimpleBTSendDataToDevice. mac = %s, dataLen = %d";
        objArr = new Object[2];
        objArr[0] = be.kS(str) ? "null" : str;
        objArr[1] = Integer.valueOf(be.bl(bArr) ? 0 : bArr.length);
        v.e(str3, str4, objArr);
        long sE = com.tencent.mm.plugin.exdevice.j.b.sE(str);
        com.tencent.mm.plugin.exdevice.service.f.a bh = ac.ajC().ftV.bh(sE);
        if (bh == null) {
            v.e("MicroMsg.exdevice.ExdeviceEventManager", "can not find the hardevice connect state");
            return false;
        } else if (bh.baO != 2) {
            v.e("MicroMsg.exdevice.ExdeviceEventManager", "device is not connected.");
            return false;
        } else {
            ac.ajC();
            return h.a(sE, bArr, new com.tencent.mm.plugin.exdevice.service.t.a(this) {
                final /* synthetic */ e fti;

                {
                    this.fti = r1;
                }

                public final void b(long j, int i, int i2, String str) {
                    boolean z = true;
                    String str2 = "MicroMsg.exdevice.ExdeviceEventManager";
                    String str3 = "onSendEnd. mac=%d, errType=%d, errCode=%d, errMsg=%s";
                    Object[] objArr = new Object[4];
                    objArr[0] = Long.valueOf(j);
                    objArr[1] = Integer.valueOf(i);
                    objArr[2] = Integer.valueOf(i2);
                    if (str == null) {
                        str = "null";
                    }
                    objArr[3] = str;
                    v.d(str2, str3, objArr);
                    e eVar = this.fti;
                    str3 = com.tencent.mm.plugin.exdevice.j.b.br(j);
                    if (i2 != 0) {
                        z = false;
                    }
                    e.a(eVar, str3, z);
                }
            });
        }
    }

    public static boolean c(String str, String str2, byte[] bArr) {
        if (be.kS(str) || be.kS(str2) || be.bl(bArr)) {
            int i;
            String str3 = "MicroMsg.exdevice.ExdeviceEventManager";
            String str4 = "input error. mac = %s, brandName = %s, dataLen = %d";
            Object[] objArr = new Object[3];
            if (be.kS(str)) {
                str = "null";
            }
            objArr[0] = str;
            if (be.kS(str2)) {
                str2 = "null";
            }
            objArr[1] = str2;
            if (be.bl(bArr)) {
                i = 0;
            } else {
                i = bArr.length;
            }
            objArr[2] = Integer.valueOf(i);
            v.e(str3, str4, objArr);
            return false;
        }
        str3 = "MicroMsg.exdevice.ExdeviceEventManager";
        str4 = "handleExDeviceSimpleBTUploadDataToServer. mac = %s, brandName = %s, dataLen = %d";
        objArr = new Object[3];
        objArr[0] = be.kS(str) ? "null" : str;
        objArr[1] = be.kS(str2) ? "null" : str2;
        objArr[2] = Integer.valueOf(be.bl(bArr) ? 0 : bArr.length);
        v.d(str3, str4, objArr);
        com.tencent.mm.plugin.exdevice.h.b bq = ac.ajq().bq(com.tencent.mm.plugin.exdevice.j.b.sE(str));
        if (bq == null) {
            v.e("MicroMsg.exdevice.ExdeviceEventManager", "device(mac=%s) not found in brand(brandName=%s)", new Object[]{str, str2});
            return false;
        }
        com.tencent.mm.plugin.c.a.b.a.a ab = com.tencent.mm.plugin.c.a.b.a.a.ab(bArr);
        if (1 != ab.eqh) {
            v.e("MicroMsg.exdevice.ExdeviceEventManager", "not step profile type %d != %d", new Object[]{Long.valueOf(1), Long.valueOf(ab.eqh)});
            return false;
        }
        f fVar = (f) ab;
        Calendar instance = Calendar.getInstance();
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        return ak.vy().a(new com.tencent.mm.plugin.exdevice.devicestep.b(bq.field_deviceID, bq.field_deviceType, (int) (instance.getTimeInMillis() / 1000), (int) (System.currentTimeMillis() / 1000), fVar.erV, ""), 0);
    }

    public final void g(String str, String str2, boolean z) {
        List<b> linkedList;
        synchronized (this.fsj) {
            linkedList = new LinkedList(this.fsj);
        }
        for (b h : linkedList) {
            h.h(str, str2, z);
        }
        linkedList.clear();
        for (b h2 : this.fsk.values()) {
            h2.h(str, str2, z);
        }
        v.d("MicroMsg.exdevice.ExdeviceEventManager", "simple BT on scan result: broadcastName=" + str + ", mac=" + str2 + ", isCompleted=" + z);
        dq dqVar = new dq();
        dqVar.bbG.bbA = str;
        dqVar.bbG.mac = str2;
        dqVar.bbG.baS = z;
        com.tencent.mm.sdk.c.a.nhr.a(dqVar, Looper.getMainLooper());
    }

    public static void a(String str, String str2, int i, String str3) {
        jk jkVar = new jk();
        jkVar.bjP.op = 2;
        jkVar.bjP.bhG = str;
        jkVar.bjP.baO = i;
        jkVar.bjP.url = str2;
        jkVar.bjP.aRh = str3;
        com.tencent.mm.sdk.c.a.nhr.a(jkVar, Looper.getMainLooper());
    }

    public static void as(String str, int i) {
        jk jkVar = new jk();
        jkVar.bjP.op = 1;
        jkVar.bjP.bhG = str;
        jkVar.bjP.bhB = i;
        com.tencent.mm.sdk.c.a.nhr.a(jkVar, Looper.getMainLooper());
    }

    public static void d(String str, String str2, byte[] bArr) {
        v.i("MicroMsg.exdevice.ExdeviceEventManager", "notifyOnRecvDataFromDevice. deviceId=%s, brandName=%s", new Object[]{str, str2});
        da daVar = new da();
        daVar.baZ.aRh = str;
        daVar.baZ.aZU = str2;
        daVar.baZ.data = bArr;
        com.tencent.mm.sdk.c.a.nhr.a(daVar, Looper.getMainLooper());
    }

    public static void Q(String str, boolean z) {
        v.i("MicroMsg.exdevice.ExdeviceEventManager", "notifyOnDeviceBindStateChange. deviceId=%s, isBound=%s", new Object[]{str, Boolean.valueOf(z)});
        cz czVar = new cz();
        czVar.baY.aRh = str;
        czVar.baY.aZR = z;
        com.tencent.mm.sdk.c.a.nhr.a(czVar, Looper.getMainLooper());
    }

    public final boolean a(b bVar) {
        if (bVar == null || this.fsj.contains(bVar)) {
            return false;
        }
        return this.fsj.add(bVar);
    }

    public final boolean b(b bVar) {
        return bVar != null && this.fsj.remove(bVar);
    }

    private b a(String str, b bVar) {
        return (b) this.fsk.put(str, bVar);
    }

    private static boolean aiT() {
        v.i("MicroMsg.exdevice.ExdeviceEventManager", "Wechat exit, stop ExDeviceService.");
        Context context = aa.getContext();
        try {
            ac.ajx().aiN();
        } catch (Throwable e) {
            v.w("MicroMsg.exdevice.ExDeviceServiceHelper", "unbindService() Service is not start by bindService.%s", new Object[]{e.getMessage()});
            v.a("MicroMsg.exdevice.ExDeviceServiceHelper", e, "", new Object[0]);
        }
        context.stopService(new Intent(context, ExDeviceService.class));
        return true;
    }
}
