package com.tencent.mm.network;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Process;
import android.os.RemoteException;
import android.os.SystemClock;
import com.tencent.mars.BaseEvent;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mars.comm.WakerLock;
import com.tencent.mars.magicbox.IPxxLogic;
import com.tencent.mars.mm.MMLogic;
import com.tencent.mars.stn.StnLogic;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.e.a.an;
import com.tencent.mm.e.a.fw;
import com.tencent.mm.model.am;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.h;
import com.tencent.mm.protocal.o;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.q;
import com.tencent.mm.storage.t;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;

public final class s extends com.tencent.mm.network.f.a implements com.tencent.mm.network.a.a, e {
    int cYU = 0;
    byte[] cjG;
    g dlA;
    int dlo = 0;
    private long dlp = 0;
    private long dlq = 0;
    private long dlr = 0;
    private WakerLock dls = null;
    public a dlt;
    a dlu;
    b dlv;
    long dlw = 0;
    int dlx = -1;
    private q dly;
    private r dlz;
    ac handler;

    static class a extends com.tencent.mm.network.i.a implements k {
        private s bXw;
        private WakerLock dlV;
        private int dlW = 0;

        public a(s sVar, WakerLock wakerLock) {
            this.bXw = sVar;
            this.dlV = wakerLock;
        }

        public final void a(q qVar, int i, int i2, String str) {
            this.dlV.lock(1000, "MMAutoAuth.IOnAutoAuth.onAutoAuth");
            final q qVar2 = qVar;
            final int i3 = i;
            final int i4 = i2;
            final String str2 = str;
            new az<Object>(this) {
                final /* synthetic */ a dlZ;

                protected final Object run() {
                    try {
                        s.a(this.dlZ.bXw, qVar2, str2);
                    } catch (Throwable e) {
                        v.e("MicroMsg.AutoAuth", "exception:%s", be.e(e));
                    }
                    return null;
                }
            }.c(this.bXw.handler);
        }

        public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
            if (qVar.getType() == 701) {
                v.d("MicroMsg.AutoAuth", "summerauth IOnAutoAuth onGYNetEnd manual auth");
                if (qVar.Cf().Ci() != 0 || i2 != 0) {
                    com.tencent.mm.plugin.report.b.itm.a(148, -102 == i3 ? 30 : 29, 1, false);
                } else if (qVar.Cg() == 2) {
                    com.tencent.mm.plugin.report.b.itm.a(148, 28, 1, false);
                    this.dlW++;
                    if (this.dlW > 1) {
                        v.w("MicroMsg.AutoAuth", "summerauth manualLoginDecodeFailedTry beyond 1 no more try!");
                        this.bXw.c(i2, i3, "auth_decode_failed_" + be.ah(str, SQLiteDatabase.KeyEmpty));
                    } else {
                        qVar.a(this, 0, 0);
                    }
                } else {
                    this.dlW = 0;
                    qVar.a((i) this, i2, i3, str);
                }
            }
            if (qVar.Cf().Ci() == 0 && i2 == 0) {
                qVar.a((i) this, i2, i3, str);
            } else if (-102 == i3) {
                this.bXw.dlx = i;
                qVar.a(this.bXw.dlt, this.bXw.dlv, 0, 0);
            } else {
                if (-301 == i3) {
                    qVar.a((i) this, i2, i3, str);
                } else if (-105 == i3) {
                    qVar.a((i) this, i2, i3, str);
                } else if (-17 == i3) {
                    qVar.a((i) this, i2, i3, str);
                }
                this.bXw.c(i2, i3, "autoauth_errmsg_" + be.ah(str, SQLiteDatabase.KeyEmpty));
            }
        }
    }

    static class b extends com.tencent.mm.network.i.a implements k {
        private s bXw;
        private WakerLock dlV;

        public b(s sVar, WakerLock wakerLock) {
            this.bXw = sVar;
            this.dlV = wakerLock;
        }

        public final void a(final q qVar, final int i, final int i2, String str) {
            this.dlV.lock(1000, "MMAutoAuth.IOnGetCert.onAutoAuth");
            new az<Object>(this) {
                final /* synthetic */ b dmb;

                protected final Object run() {
                    try {
                        s.a(this.dmb.bXw, qVar);
                    } catch (Throwable e) {
                        v.e("MicroMsg.AutoAuth", "exception:%s", be.e(e));
                    }
                    return null;
                }
            }.c(this.bXw.handler);
        }

        public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        }
    }

    static /* synthetic */ int a(s sVar, q qVar, k kVar) {
        int i = 1;
        v.i("MicroMsg.AutoAuth", "dkcgi sendImp rr.type:%d callback:%d", Integer.valueOf(qVar.getType()), Integer.valueOf(kVar.hashCode()));
        switch (qVar.getType()) {
            case 126:
                qVar.getType();
                c aVar = new a(sVar);
                aVar.setUsername(qVar.Ce().getUserName());
                i = z.My().a(qVar, kVar, aVar, 0);
                if (i < 0) {
                    v.e("MicroMsg.AutoAuth", "register: net.send err");
                    return i;
                }
                v.i("MicroMsg.AutoAuth", "register: netid=" + i);
                return i;
            case 701:
                if (z.My().Ml()) {
                    return -1;
                }
                h Ce = qVar.Ce();
                c aVar2 = new a(sVar);
                aVar2.setUsername(Ce.getUserName());
                i = z.My().a(qVar, kVar, aVar2, 0);
                if (i < 0) {
                    v.e("MicroMsg.AutoAuth", "auth: net.send err");
                    return i;
                }
                v.i("MicroMsg.AutoAuth", "auth: netid=" + i);
                return i;
            default:
                qVar.Ce().cW(sVar.dlt.ww());
                y My = z.My();
                c cVar = sVar.dlt;
                if (!qVar.By()) {
                    i = 0;
                }
                i = My.a(qVar, kVar, cVar, i);
                if (i >= 0) {
                    return i;
                }
                v.e("MicroMsg.AutoAuth", "nonauth: in queue err");
                return i;
        }
    }

    static /* synthetic */ void a(s sVar) {
        sVar.dlo = 0;
        sVar.dlp = 0;
        sVar.dlq = 0;
        z.My().reset();
    }

    static /* synthetic */ void a(s sVar, q qVar) {
        v.d("MicroMsg.AutoAuth", "dkcert doGetCert");
        if (60000 >= SystemClock.elapsedRealtime() - sVar.dlw) {
            v.w("MicroMsg.AutoAuth", "getcert lastGetCertSucTime=%d, curtime=%d", Long.valueOf(sVar.dlw), Long.valueOf(SystemClock.elapsedRealtime()));
            sVar.c(3, -1, SQLiteDatabase.KeyEmpty);
        } else if (z.My().a(qVar, sVar.dlv, sVar.dlt, 0) < 0) {
            sVar.c(3, -1, SQLiteDatabase.KeyEmpty);
        }
    }

    static /* synthetic */ void a(s sVar, q qVar, String str) {
        v.d("MicroMsg.AutoAuth", "account info updated:" + sVar.dlt);
        v.i("MicroMsg.AutoAuth", "oreh doAutoAuth ticket:%s, login:%b", str, Boolean.valueOf(sVar.dlt.BQ()));
        v.bta();
        if (!sVar.dlt.BQ() && !z.My().Ml() && z.My().a(qVar, sVar.dlu, sVar.dlt, 1) < 0) {
            sVar.c(3, -1, SQLiteDatabase.KeyEmpty);
        }
    }

    static /* synthetic */ void gB(int i) {
        int i2 = 0;
        v.i("MicroMsg.AutoAuth", "cancel: netid=" + i);
        if (i < 0) {
            v.e("MicroMsg.AutoAuth", "error netid < 0, " + i);
            return;
        }
        y My = z.My();
        v.i("MicroMsg.MMNativeNetTaskAdapter", "stopTask netId=" + i);
        if (i >= 0 && i < 100) {
            synchronized (My.dmn) {
                if (My.dmn[i] != null) {
                    i2 = My.dmn[i].taskId;
                }
            }
            if (i2 != 0) {
                StnLogic.stopTask(i2);
            }
            synchronized (My.dmn) {
                if (My.dmn[i] != null) {
                    try {
                        v.i("MicroMsg.MMNativeNetTaskAdapter", "mmcgi stopTask outQueue: netId:%d hash:%d type:%d", Integer.valueOf(i2), Integer.valueOf(My.dmn[i].dmr.getType()), Integer.valueOf(My.dmn[i].dmr.BE()));
                        My.dmn[i] = null;
                    } catch (Throwable e) {
                        v.e("MicroMsg.MMNativeNetTaskAdapter", "exception:%s", be.e(e));
                    }
                }
            }
        }
    }

    public final /* bridge */ /* synthetic */ c BU() {
        return this.dlt;
    }

    public final /* bridge */ /* synthetic */ d LY() {
        return this.dlt;
    }

    public s(ac acVar) {
        if (acVar == null) {
            acVar = new ac();
        }
        this.handler = acVar;
        this.dlt = new a(this);
        this.dls = new WakerLock(z.getContext());
        this.dlu = new a(this, this.dls);
        this.dlv = new b(this, this.dls);
        this.dly = new q(t.cng + "autoauth.cfg");
    }

    protected final void finalize() {
        reset();
        super.finalize();
    }

    public final void cancel(final int i) {
        this.dls.lock(1000, String.format("MMAutoAuth.cancel,%d", new Object[]{Integer.valueOf(i)}));
        new az<Object>(this) {
            final /* synthetic */ s dlB;

            protected final Object run() {
                try {
                    s.gB(i);
                } catch (Throwable e) {
                    v.e("MicroMsg.AutoAuth", "exception:%s", be.e(e));
                }
                return null;
            }
        }.c(this.handler);
    }

    public final boolean BK() {
        return this.dlo < 5;
    }

    public final String getNetworkServerIp() {
        return MMLogic.getNetworkServerIp();
    }

    public final String[] getIPsString(boolean z) {
        return MMLogic.getIPsString(z);
    }

    public final void reset() {
        this.dls.lock(1000, "MMAutoAuth.reset");
        new az<Object>(this) {
            final /* synthetic */ s dlB;

            {
                this.dlB = r4;
            }

            protected final Object run() {
                s.a(this.dlB);
                return null;
            }
        }.c(this.handler);
    }

    public final synchronized int a(final q qVar, final k kVar) {
        this.dls.lock(1000, "MMAutoAuth.send");
        return ((Integer) new az<Integer>(this, Integer.valueOf(-1)) {
            final /* synthetic */ s dlB;

            public final /* synthetic */ Object run() {
                return Mi();
            }

            private Integer Mi() {
                try {
                    return Integer.valueOf(s.a(this.dlB, qVar, kVar));
                } catch (Throwable e) {
                    v.e("MicroMsg.AutoAuth", "exception:%s", be.e(e));
                    s.a(this.dlB);
                    return Integer.valueOf(-1);
                }
            }
        }.c(this.handler)).intValue();
    }

    public final boolean Me() {
        if (90000 >= SystemClock.elapsedRealtime() - this.dlq) {
            v.w("MicroMsg.AutoAuth", "auto limit lastSessionTimeout=%d, curtime=%d", Long.valueOf(this.dlq), Long.valueOf(SystemClock.elapsedRealtime()));
            return false;
        }
        this.dlq = SystemClock.elapsedRealtime();
        this.dlt.i(new byte[0], this.dlt.ww());
        return true;
    }

    public final void aT(final boolean z) {
        new az<Object>(this, Integer.valueOf(-1)) {
            final /* synthetic */ s dlB;

            public final Object run() {
                BaseEvent.onForeground(z);
                com.tencent.mm.sdk.b.b.aR(z);
                return null;
            }
        }.c(this.handler);
    }

    public final void a(boolean z, String str, String str2, int[] iArr, int[] iArr2, int i, int i2, String str3, String str4) {
        this.dls.lock(1000, "MMAutoAuth.setIDCHostInfo");
        List<o> Iu = o.Iu(str2);
        List<o> Iu2 = o.Iu(str);
        String str5 = "MicroMsg.AutoAuth";
        String str6 = "dkidc setIDCHostInfo short:[%s][%s](%d) long:[%s][%s](%d) reset:%s";
        Object[] objArr = new Object[7];
        objArr[0] = str3;
        objArr[1] = str;
        objArr[2] = Integer.valueOf(Iu2.size());
        objArr[3] = str4;
        objArr[4] = str2;
        objArr[5] = Integer.valueOf(Iu.size());
        objArr[6] = z ? "!!!!!CHANGE IDC NOW" : "false";
        v.d(str5, str6, objArr);
        final Map hashMap = new HashMap();
        for (o oVar : Iu) {
            ArrayList arrayList = (ArrayList) hashMap.get(oVar.host);
            if (arrayList == null) {
                arrayList = new ArrayList();
                hashMap.put(oVar.host, arrayList);
            }
            arrayList.add(oVar.gRG);
        }
        final Map hashMap2 = new HashMap();
        for (o oVar2 : Iu2) {
            arrayList = (ArrayList) hashMap2.get(oVar2.host);
            if (arrayList == null) {
                arrayList = new ArrayList();
                hashMap2.put(oVar2.host, arrayList);
            }
            arrayList.add(oVar2.gRG);
        }
        final int[] iArr3 = iArr2;
        final int[] iArr4 = iArr;
        new az<Object>(this, Integer.valueOf(-1)) {
            final /* synthetic */ s dlB;

            public final Object run() {
                for (Entry entry : hashMap.entrySet()) {
                    MMLogic.saveAuthLongIPs((String) entry.getKey(), (String[]) ((ArrayList) entry.getValue()).toArray(new String[0]));
                }
                for (Entry entry2 : hashMap2.entrySet()) {
                    MMLogic.saveAuthShortIPs((String) entry2.getKey(), (String[]) ((ArrayList) entry2.getValue()).toArray(new String[0]));
                }
                MMLogic.saveAuthPorts(iArr3, iArr4);
                BaseEvent.onNetworkChange();
                return null;
            }
        }.c(this.handler);
    }

    public final void c(String str, String str2, String str3, String str4) {
        this.dls.lock(1000, "MMAutoAuth.setFixedHost");
        v.i("MicroMsg.AutoAuth", "dkidc setFixedHost debug short:%s:%s long:%s:%s", str, str2, str3, str4);
        if (be.kS(str) || be.kS(str3)) {
            v.w("MicroMsg.AutoAuth", "dkidc setFixedHost FAILED ! check assist");
            return;
        }
        final String str5 = str;
        final String str6 = str2;
        final String str7 = str3;
        final String str8 = str4;
        new az<Object>(this, Integer.valueOf(-1)) {
            final /* synthetic */ s dlB;

            public final Object run() {
                MMLogic.setDebugIP(str5, str6, str7, str8);
                BaseEvent.onNetworkChange();
                return null;
            }
        }.c(this.handler);
    }

    public final void setNewDnsDebugHost(final String str, final String str2) {
        if (be.kS(str) && be.kS(str2)) {
            v.d("MicroMsg.AutoAuth", "setNewDnsDebugHost FAILED ! check assist");
        } else {
            new az<Object>(this) {
                final /* synthetic */ s dlB;

                protected final Object run() {
                    MMLogic.setNewDnsDebugHost(str, str2);
                    return null;
                }
            }.c(this.handler);
        }
    }

    public final void LZ() {
        this.dls.lock(1000, "MMAutoAuth.forceUpdateHostCache");
        new az<Object>(this, Integer.valueOf(-1)) {
            final /* synthetic */ s dlB;

            public final Object run() {
                BaseEvent.onNetworkChange();
                return null;
            }
        }.c(this.handler);
    }

    public final void gT(final String str) {
        this.dls.lock(1000, "MMAutoAuth.ipxxStatistics");
        new az<Object>(this) {
            final /* synthetic */ s dlB;

            protected final Object run() {
                v.bta();
                IPxxLogic.onIPxx(str, 0);
                return null;
            }
        }.c(this.handler);
    }

    public final void a(com.tencent.mm.network.a.b bVar) {
        z.Mt().dmE = bVar;
    }

    public final h Ma() {
        return z.Mu();
    }

    final boolean Mf() {
        if (CdnLogic.MediaType_FAVORITE_FILE == com.tencent.mm.platformtools.q.dqj && com.tencent.mm.platformtools.q.dqk > 0) {
            com.tencent.mm.platformtools.q.dqk = 0;
            Me();
        }
        if (this.dlt.BQ()) {
            return true;
        }
        if (z.My().Ml()) {
            return false;
        }
        if (this.dlx != -1) {
            v.w("MicroMsg.AutoAuth", "auto limit now is getting cert");
            return false;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (60000 >= elapsedRealtime - this.dlp && this.dlp > 0) {
            v.w("MicroMsg.AutoAuth", "auto limit lastAutoAuthtime=%d, curtime=%d", Long.valueOf(this.dlp), Long.valueOf(elapsedRealtime));
            return false;
        } else if (aa.getContext().getSharedPreferences("auth_hold_prefs", 0).getBoolean("auth_ishold", false)) {
            if (!z.My().Mm()) {
                v.e("MicroMsg.AutoAuth", "sendImp hit push hold, pid:%d", Integer.valueOf(Process.myPid()));
                z.Mv().post(new Runnable(this) {
                    final /* synthetic */ s dlB;

                    {
                        this.dlB = r1;
                    }

                    public final void run() {
                        z.My().d(4, -100, "hit push hold!!" + be.bur());
                    }
                });
            }
            return false;
        } else {
            q bm = z.My().bm(Mh());
            if (bm != null) {
                try {
                    if (!(bm instanceof com.tencent.mm.network.q.a)) {
                        this.dlp = SystemClock.elapsedRealtime();
                        a(bm, 3, 3);
                    } else if (30000 < elapsedRealtime - this.dlr || this.dlr <= 0) {
                        v.i("MicroMsg.AutoAuth", "session time out in push_notify mode, send broast to mm");
                        this.dlr = SystemClock.elapsedRealtime();
                        z.Mz().onPush(5, null);
                    } else {
                        v.i("MicroMsg.AutoAuth", "session time out in push_notify mode, but hit limit");
                        return false;
                    }
                } catch (Throwable e) {
                    v.e("MicroMsg.AutoAuth", "exception:%s", be.e(e));
                }
            }
            return false;
        }
    }

    final void c(int i, int i2, String str) {
        int i3;
        v.i("MicroMsg.AutoAuth", "summerauth handleAutoAuthFail inErrType=" + i + ", inErrCode=" + i2 + ", errMsg=" + str + " stack=" + be.bur());
        if (i == 4 && i2 == -106) {
            v.e("MicroMsg.AutoAuth", "summerauth handleAutoAuthFail autoauth should not be return MM_ERR_BLOCK_BY_SPAM trans to MM_ERR_AUTH_ANOTHERPLACE");
            i3 = -100;
        } else {
            i3 = i2;
        }
        if (i == 5 && i2 == -13) {
            v.e("MicroMsg.AutoAuth", "summerauth handleAutoAuthFail autoauth should not be return MM_ERR_SESSIONTIMEOUT trans to MM_ERR_PASSWORD");
            i = 4;
            i3 = -3;
            com.tencent.mm.plugin.report.b.itm.a(148, 42, 1, false);
        }
        int i4 = i;
        if (i4 == 6 && i2 == -10001) {
            v.e("MicroMsg.AutoAuth", "summerauth handleAutoAuthFail autoauth ENCODE ERROR check sp");
            SharedPreferences zc = am.zc();
            String string = zc.getString("_auth_key", SQLiteDatabase.KeyEmpty);
            String string2 = zc.getString("server_id", SQLiteDatabase.KeyEmpty);
            if (be.kS(string) && be.kS(string2)) {
                v.e("MicroMsg.AutoAuth", "summerauth handleAutoAuthFail autoauth ENCODE ERROR check sp aak and cookie null logout");
                i3 = -104;
                com.tencent.mm.plugin.report.b.itm.a(148, 52, 1, false);
                i4 = 4;
            }
        }
        z.My().d(i4, i3, str);
        if (i4 != 4) {
            return;
        }
        if (i3 == -100 || i3 == -205 || i3 == -213) {
            aa.getContext().getSharedPreferences("auth_hold_prefs", 0).edit().putBoolean("auth_ishold", true).commit();
            reset();
        }
    }

    final boolean d(String str, String str2, int i) {
        boolean z;
        int i2;
        int i3;
        String string;
        aa.getContext().getSharedPreferences("auth_hold_prefs", 0).edit().remove("auth_ishold").commit();
        SharedPreferences sharedPreferences = aa.getContext().getSharedPreferences("auth_info_key_prefs", 4);
        boolean z2 = sharedPreferences.getBoolean("key_auth_info_prefs_created", false);
        int i4 = sharedPreferences.getInt("key_auth_update_version", 0);
        int i5 = sharedPreferences.getInt("_auth_uin", 0);
        String string2 = sharedPreferences.getString("_auth_key", SQLiteDatabase.KeyEmpty);
        String string3 = sharedPreferences.getString("server_id", SQLiteDatabase.KeyEmpty);
        Editor edit = sharedPreferences.edit();
        edit.putBoolean("key_auth_info_prefs_created", true);
        edit.putInt("key_auth_update_version", d.lWh);
        edit.putInt("_auth_uin", i);
        edit.putString("_auth_key", str);
        edit.putString("server_id", str2);
        if (!edit.commit()) {
            v.e("MicroMsg.AutoAuth", "summerauth save aak & id commit failed 1th!");
            com.tencent.mm.plugin.report.b.itm.a(148, 36, 1, false);
            if (!edit.commit()) {
                v.e("MicroMsg.AutoAuth", "summerauth save aak & id commit failed 2nd!");
                com.tencent.mm.plugin.report.b.itm.a(148, 37, 1, false);
                z = sharedPreferences.getBoolean("key_auth_info_prefs_created", false);
                i2 = sharedPreferences.getInt("key_auth_update_version", 0);
                i3 = sharedPreferences.getInt("_auth_uin", 0);
                string = sharedPreferences.getString("_auth_key", SQLiteDatabase.KeyEmpty);
                String string4 = sharedPreferences.getString("server_id", SQLiteDatabase.KeyEmpty);
                v.e("MicroMsg.AutoAuth", "summerauth save aak & id commit failed 2th so ret false old vs new vs input create[%b, %b, %b] version[%d, %d, %d], uin[%d, %d, %d], aak[%s, %s, %s], cookie[%s, %s, %s]", Boolean.valueOf(z2), Boolean.valueOf(z), Boolean.valueOf(true), Integer.valueOf(i4), Integer.valueOf(i2), Integer.valueOf(d.lWh), Integer.valueOf(i5), Integer.valueOf(i3), Integer.valueOf(i), string2, string, str, string3, string4, str2);
                v.bta();
                return false;
            }
        }
        z = sharedPreferences.getBoolean("key_auth_info_prefs_created", false);
        i2 = sharedPreferences.getInt("key_auth_update_version", 0);
        i3 = sharedPreferences.getInt("_auth_uin", 0);
        string = sharedPreferences.getString("_auth_key", SQLiteDatabase.KeyEmpty);
        String string5 = sharedPreferences.getString("server_id", SQLiteDatabase.KeyEmpty);
        if (z && i2 == d.lWh && i3 == i && string.equals(str) && string5.equals(str2)) {
            this.dly.bvj();
            this.dly.set(1, Integer.valueOf(d.lWh));
            this.dly.set(2, Integer.valueOf(i));
            this.dly.set(3, str);
            this.dly.set(4, str2);
            this.dly.bvk();
            String str3 = "MicroMsg.AutoAuth";
            String str4 = "summerauth save aak & id ok old vs new vs input[%b, %b, %b, %b] version[%d, %d, %d. %d], uin[%d, %d, %d, %d], aak[%s, %s, %s, %s], cookie[%s, %s, %s, %s]";
            Object[] objArr = new Object[20];
            objArr[0] = Boolean.valueOf(z2);
            objArr[1] = Boolean.valueOf(z);
            objArr[2] = Boolean.valueOf(true);
            objArr[3] = Boolean.valueOf(!this.dly.nnZ);
            objArr[4] = Integer.valueOf(i4);
            objArr[5] = Integer.valueOf(i2);
            objArr[6] = Integer.valueOf(d.lWh);
            objArr[7] = (Integer) this.dly.get(1);
            objArr[8] = Integer.valueOf(i5);
            objArr[9] = Integer.valueOf(i3);
            objArr[10] = Integer.valueOf(i);
            objArr[11] = (Integer) this.dly.get(2);
            objArr[12] = string2;
            objArr[13] = string;
            objArr[14] = str;
            objArr[15] = (String) this.dly.get(3);
            objArr[16] = string3;
            objArr[17] = string5;
            objArr[18] = str2;
            objArr[19] = (String) this.dly.get(4);
            v.i(str3, str4, objArr);
            return true;
        }
        v.e("MicroMsg.AutoAuth", "summerauth save aak & id commit failed check not equal so ret false old vs new vs input create[%b, %b, %b] version[%d, %d, %d], uin[%d, %d, %d], aak[%s, %s, %s], cookie[%s, %s, %s]", Boolean.valueOf(z2), Boolean.valueOf(z), Boolean.valueOf(true), Integer.valueOf(i4), Integer.valueOf(i2), Integer.valueOf(d.lWh), Integer.valueOf(i5), Integer.valueOf(i3), Integer.valueOf(i), string2, string, str, string3, string5, str2);
        v.bta();
        return false;
    }

    final void a(q qVar, int i, int i2) {
        qVar.a(this.dlu, i, i2);
    }

    public final void a(com.tencent.mm.protocal.ac acVar) {
        z.My().Mn();
    }

    public final byte[] Mg() {
        if (!this.dlt.BQ()) {
            return null;
        }
        com.tencent.mm.protocal.ab.a aVar = new com.tencent.mm.protocal.ab.a();
        aVar.uin = this.dlt.ww();
        aVar.cRq = be.KG(aa.getContext().getSharedPreferences("notify_sync_pref", 4).getString("notify_sync_key_keybuf", SQLiteDatabase.KeyEmpty));
        aVar.netType = com.tencent.mm.protocal.a.getNetType(aa.getContext());
        aVar.lWW = com.tencent.mm.protocal.a.brq();
        try {
            byte[] zf = aVar.zf();
            this.cjG = aVar.cjG;
            return zf;
        } catch (Throwable e) {
            v.e("MicroMsg.AutoAuth", "exception:%s", be.e(e));
            return null;
        }
    }

    public final int getHostByName(String str, List<String> list) {
        return MMLogic.getHostByName(str, list);
    }

    public final int a(boolean z, List<String> list) {
        return MMLogic.getSnsIpsForScene(list, z);
    }

    public final int a(String str, boolean z, List<String> list) {
        return MMLogic.getSnsIpsForSceneWithHostName(list, str, z);
    }

    public final String getIspId() {
        return MMLogic.getIspId();
    }

    public final void setHostInfo(final String[] strArr, final String[] strArr2, final int[] iArr) {
        this.dls.lock(1000, "MMAutoAuth.setHostInfo");
        new az<Object>(this) {
            final /* synthetic */ s dlB;

            protected final Object run() {
                MMLogic.setHostInfo(strArr, strArr2, iArr);
                return null;
            }
        }.c(this.handler);
    }

    public final int g(int i, byte[] bArr) {
        return ad.ME().h(i, bArr);
    }

    public final void a(int i, String str, int i2, boolean z) {
        this.dls.lock(1000, "MMAutoAuth.logUtil");
        final int i3 = i;
        final int i4 = i2;
        final String str2 = str;
        final boolean z2 = z;
        new az<Object>(this) {
            final /* synthetic */ s dlB;

            protected final Object run() {
                if (i3 == 3) {
                    Date date = new Date();
                    date.setTime(be.Ni() - (86400000 * ((long) i4)));
                    MMLogic.uploadFile(e.cnk + "crash_" + new SimpleDateFormat("yyyyMMdd", Locale.getDefault()).format(date) + ".txt", str2, SQLiteDatabase.KeyEmpty);
                } else if (i3 == 2) {
                    v.bta();
                    MMLogic.uploadLog(new int[]{i4}, z2, str2, SQLiteDatabase.KeyEmpty);
                } else {
                    v.bta();
                }
                return null;
            }
        }.c(this.handler);
    }

    public final void setSignallingStrategy(long j, long j2) {
        StnLogic.setSignallingStrategy(j, j2);
    }

    public final void keepSignalling() {
        StnLogic.keepSignalling();
    }

    public final void stopSignalling() {
        StnLogic.stopSignalling();
    }

    public final void a(n nVar) {
        z.MB().dmf = nVar;
    }

    public final void a(r rVar) {
        this.dlz = rVar;
    }

    public final boolean Mh() {
        boolean z = false;
        if (this.dlz != null) {
            try {
                z = this.dlz.og();
            } catch (RemoteException e) {
            }
        }
        return z;
    }

    public final void a(g gVar) {
        this.dlA = gVar;
    }

    public final void reportFailIp(String str) {
        MMLogic.reportFailIp(str);
    }

    public final void gU(String str) {
        v.e("MicroMsg.AutoAuth", "killPush %s", str);
    }

    public final void aU(boolean z) {
        if (com.tencent.mm.sdk.c.a.nhr == null) {
            v.w("MicroMsg.AutoAuth", "loginevent but eventpool null, event:" + z);
        } else if (z) {
            com.tencent.mm.sdk.c.a.nhr.z(new an());
        } else {
            com.tencent.mm.sdk.c.a.nhr.z(new fw());
        }
    }

    public final h BV() {
        return null;
    }

    public final void aV(boolean z) {
        be.ed(aa.getContext());
    }

    public final void aW(boolean z) {
        v.d("MicroMsg.AutoAuth", "summer setMMTLS enable[%b]", Boolean.valueOf(z));
        MMLogic.setMmtlsCtrlInfo(z);
    }

    public final void BW() {
        StnLogic.makesureLongLinkConnected();
    }
}
