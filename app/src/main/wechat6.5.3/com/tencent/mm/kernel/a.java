package com.tencent.mm.kernel;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.sqlite.SQLiteException;
import android.os.Looper;
import com.tencent.mm.a.g;
import com.tencent.mm.a.h;
import com.tencent.mm.a.o;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.kernel.api.b;
import com.tencent.mm.kernel.api.f;
import com.tencent.mm.model.af;
import com.tencent.mm.model.ai;
import com.tencent.mm.model.al;
import com.tencent.mm.model.bs;
import com.tencent.mm.network.c;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.h.i;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.q;
import com.tencent.mm.storage.r;
import com.tencent.mm.storage.t;
import com.tencent.mm.v.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public final class a {
    private static boolean cjj = true;
    private static boolean cjk = false;
    private static boolean cjl = false;
    private static boolean cjm = false;
    private static String cjp = "NoResetUinStack";
    private static String cjq = null;
    private static int cjv = -1;
    private static boolean cjx = true;
    private b cjg;
    public final v cjh;
    private final f cji;
    byte[] cjn = new byte[0];
    public volatile boolean cjo = false;
    public com.tencent.mm.model.a cjr;
    public int cjs = 0;
    public int cjt;
    public List<af> cju = new LinkedList();
    boolean cjw = true;
    private String cjy = SQLiteDatabase.KeyEmpty;
    private Map<String, Integer> cjz = new HashMap();
    public int uin = 0;

    public a(f fVar, b bVar) {
        g.vx();
        cjj = be.f((Integer) g.vw().cjT.get(17)) != 0;
        this.cjh = new v();
        com.tencent.mm.protocal.j.c.a.lWC = new al(702);
        this.cji = fVar;
        this.cjg = bVar;
    }

    public final boolean uz() {
        return this.uin != 0;
    }

    public static String uA() {
        return cjq;
    }

    public static String dP(String str) {
        cjq = str;
        return str;
    }

    public static String uB() {
        return cjp;
    }

    public static void dQ(String str) {
        cjp = str;
    }

    public static void uC() {
        g.vx();
        e.a(g.vw().cjT, 0);
    }

    public final void release() {
        com.tencent.mm.sdk.platformtools.v.w("MMKernel.CoreAccount", "account storage release  uin:%s thread:%s stack:%s", o.getString(this.uin), Thread.currentThread().getName(), be.bur());
        if (this.uin == 0) {
            com.tencent.mm.sdk.platformtools.v.e("MMKernel.CoreAccount", "[arthurdan.AccountNR] Fatal crash error!!! uin is 0 when release(), this callStack is:%s, last reset stack is:%s", be.bur().toString(), cjp);
            return;
        }
        this.cjg.th();
        g.vx();
        g.vw().cQ(null);
        reset();
        g.vx();
        g.vw().ckg.clear();
    }

    private void reset() {
        this.uin = 0;
        aa.getContext().getSharedPreferences(aa.bti(), 0).edit().putBoolean("isLogin", false).commit();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ", Locale.getDefault());
        com.tencent.mm.sdk.platformtools.v.w("MMKernel.CoreAccount", "[arthurdan.AccountNR] account storage reset! uin:%d, resetStack is:%s, resetTime:%s", Integer.valueOf(this.uin), cjp, simpleDateFormat.format(new Date()));
    }

    public static void uD() {
        g.vx();
        synchronized (g.vu().cjn) {
            g.vx();
            g.vu().ez(0);
        }
    }

    public static void ey(int i) {
        g.vx();
        synchronized (g.vu().cjn) {
            if (g.uz()) {
                return;
            }
            g.vx();
            g.vu().ez(i);
        }
    }

    private void ez(int i) {
        if (this.cju != null) {
            this.cju.clear();
        }
        SharedPreferences sharedPreferences = aa.getContext().getSharedPreferences(aa.bti(), 0);
        if (i == 0) {
            if (this.uin != 0) {
                release();
            }
            i = this.uin;
            this.uin = 0;
            sharedPreferences.edit().putBoolean("isLogin", false).commit();
        } else {
            sharedPreferences = aa.getContext().getSharedPreferences("app_brand_global_sp", 0);
            if (sharedPreferences != null) {
                Set stringSet = sharedPreferences.getStringSet("uin_set", new HashSet());
                if (stringSet != null && stringSet.add(String.valueOf(i))) {
                    Editor edit = sharedPreferences.edit();
                    edit.remove("uin_set");
                    edit.commit();
                    edit.putStringSet("uin_set", stringSet);
                    edit.commit();
                }
            }
        }
        Object obj = (((Thread.currentThread().getId() > g.vA().htb.getId() ? 1 : (Thread.currentThread().getId() == g.vA().htb.getId() ? 0 : -1)) == 0 ? 1 : null) == null || g.vA().btv()) ? null : 1;
        if (obj != null) {
            g.vA().btu();
        }
        this.cjo = true;
        long currentTimeMillis = System.currentTimeMillis();
        com.tencent.mm.sdk.platformtools.v.i("MMKernel.CoreAccount", "start time check setUinWapper begin mAccountInitializing %b", Boolean.valueOf(this.cjo));
        com.tencent.mm.sdk.platformtools.v.i("MMKernel.CoreAccount", "dkacc setAccuin From %s To %s hash:%d thread:%d[%s] stack:%s", o.getString(this.uin), o.getString(i), Integer.valueOf(h.aq(i, 100)), Long.valueOf(Thread.currentThread().getId()), Thread.currentThread().getName(), be.bur());
        if (i == 0) {
            com.tencent.mm.sdk.platformtools.v.w("MMKernel.CoreAccount", "setAccUin, Reset by MMCore.resetAccUin");
        } else if (this.uin == i) {
            com.tencent.mm.sdk.platformtools.v.w("MMKernel.CoreAccount", "setAccUin, uin not changed, return :%d", Integer.valueOf(i));
        } else {
            boolean z;
            long currentTimeMillis2;
            if (this.uin != 0) {
                release();
            }
            if (this.cji != null) {
                this.cji.a(this);
            }
            this.uin = i;
            o.getString(i);
            g.vx();
            e vw = g.vw();
            aa.getContext().getSharedPreferences(aa.bti(), 0).edit().putBoolean("isLogin", true).commit();
            String m = g.m(("mm" + i).getBytes());
            vw.cka = vw.cjZ + m + "/";
            vw.cachePath = t.cng + m + "/";
            File file = new File(vw.cachePath);
            com.tencent.mm.sdk.platformtools.v.d("MMKernel.CoreStorage", "dkacc cachePath:" + vw.cachePath + " accPath:" + vw.cka);
            if (file.exists()) {
                z = false;
            } else {
                com.tencent.mm.sdk.platformtools.v.w("MMKernel.CoreStorage", "setUin REBUILD data now ! DO NOT FUCKING TELL ME DB BROKEN !!! uin:%s data:%s sd:%s", o.getString(i), vw.cachePath, vw.cka);
                file.mkdirs();
                if (!vw.cachePath.equalsIgnoreCase(vw.cka)) {
                    currentTimeMillis2 = System.currentTimeMillis();
                    new File(vw.cka).renameTo(new File(e.cnj + (m + "temp" + System.currentTimeMillis())));
                    com.tencent.mm.sdk.platformtools.v.d("MMKernel.CoreStorage", "find the old files and rename then %s" + (System.currentTimeMillis() - currentTimeMillis2), m);
                }
                z = true;
            }
            vw.ckf = new bs(vw.cachePath, z);
            vw.vc();
            m = vw.cachePath + "MicroMsg.db";
            String str = vw.cachePath + "EnMicroMsg.db";
            String str2 = vw.cachePath + "EnMicroMsg2.db";
            vw.cQ(null);
            vw.ckb = new com.tencent.mm.bg.g(new com.tencent.mm.bg.g.a(vw) {
                final /* synthetic */ e ckm;

                {
                    this.ckm = r1;
                }

                public final void vl() {
                    if (this.ckm.ckd != null) {
                        com.tencent.mm.sdk.platformtools.v.i("MMKernel.CoreStorage", "summer preCloseCallback userConfigStg: " + this.ckm.ckd);
                        this.ckm.ckd.iB(true);
                    }
                    this.ckm.cjV.vl();
                }

                public final void vm() {
                    this.ckm.cjV.vm();
                }

                public final void vn() {
                    this.ckm.cjV.vn();
                }
            });
            if (vw.ckb.a(m, str, str2, (long) i, p.rJ(), vw.ti(), true)) {
                String str3 = vw.ckb.nxM;
                if (!be.kS(str3)) {
                    com.tencent.mm.sdk.platformtools.v.e("MMKernel.CoreStorage", "dbinit failed :" + str3);
                    com.tencent.mm.sdk.b.b.r("init db Failed: [ " + str3 + "]", "DBinit");
                }
                vw.ckd = new r(vw.ckb);
                vw.ckc = new com.tencent.mm.bg.g(vw.cjW);
                if (vw.ckc.a(m, str, str2, (long) i, p.rJ(), new HashMap(), true)) {
                    g.vx();
                    vw.cke = new az(g.vw().vf());
                    vw.cke.c(new com.tencent.mm.sdk.h.g.a(vw) {
                        final /* synthetic */ e ckm;

                        {
                            this.ckm = r1;
                        }

                        public final void a(String str, i iVar) {
                            p.dr(str);
                        }
                    });
                    vw.cke.bxg();
                    vw.cjU.a(vw.ckb, vw.ckc);
                    aa.getContext().getSharedPreferences(aa.bti() + i, 0);
                    com.tencent.mm.sdk.platformtools.v.d("MMKernel.CoreStorage", "edw setAccUin, needTransfer = " + vw.vb());
                    if (z) {
                        currentTimeMillis2 = ((Long) vw.ckd.get(com.tencent.mm.storage.t.a.USERINFO_INSTALL_FIRST_TIME_LONG, Long.valueOf(0))).longValue();
                        int intValue = ((Integer) vw.ckd.get(com.tencent.mm.storage.t.a.USERINFO_INSTALL_FIRST_CLIENT_VERSION_INT, Integer.valueOf(0))).intValue();
                        if (currentTimeMillis2 > 0) {
                            com.tencent.mm.sdk.platformtools.v.w("MMKernel.CoreStorage", "summerinstall new install but firsttime[%d] > 0", Long.valueOf(currentTimeMillis2));
                        } else {
                            vw.ckd.a(com.tencent.mm.storage.t.a.USERINFO_INSTALL_FIRST_TIME_LONG, Long.valueOf(System.currentTimeMillis()));
                        }
                        if (intValue > 0) {
                            com.tencent.mm.sdk.platformtools.v.w("MMKernel.CoreStorage", "summerinstall new install but version[%d] > 0", Integer.valueOf(intValue));
                        } else {
                            vw.ckd.a(com.tencent.mm.storage.t.a.USERINFO_INSTALL_FIRST_CLIENT_VERSION_INT, Integer.valueOf(d.lWh));
                        }
                        com.tencent.mm.sdk.platformtools.v.i("MMKernel.CoreStorage", "edw setAccUin, summerinstall time[%d]，version[%d], clientversion[%d]", (Long) vw.ckd.get(com.tencent.mm.storage.t.a.USERINFO_INSTALL_FIRST_TIME_LONG, Long.valueOf(0)), (Integer) vw.ckd.get(com.tencent.mm.storage.t.a.USERINFO_INSTALL_FIRST_CLIENT_VERSION_INT, Integer.valueOf(0)), Integer.valueOf(d.lWh));
                    }
                    com.tencent.mm.sdk.platformtools.v.d("MMKernel.CoreStorage", "edw postDataTransfer begin");
                    g.vx();
                    e vw2 = g.vw();
                    int f = be.f((Integer) vw2.ckd.get(14, null));
                    int i2 = d.lWh;
                    if (f == 0) {
                        cjk = true;
                    }
                    boolean z2 = i2 == f ? false : (i2 <= 570425344 || f > 570425344) ? i2 > 570556456 && f <= 570556456 : true;
                    if (z2) {
                        vw2.ckd.set(8197, SQLiteDatabase.KeyEmpty);
                        vw2.ckd.set(15, Integer.valueOf(0));
                    }
                    boolean z3 = f != i2;
                    if (f > 620822536 || f == i2) {
                        vw2.ckd.set(274480, Boolean.valueOf(false));
                        com.tencent.mm.sdk.platformtools.v.i("MMKernel.CoreStorage", "[initialize] need not init emoji");
                    } else {
                        vw2.ckd.set(274480, Boolean.valueOf(true));
                        com.tencent.mm.sdk.platformtools.v.i("MMKernel.CoreStorage", "[initialize] need init emoji");
                    }
                    if (f != 0 && f < 637599744) {
                        vw2.ckd.set(348162, Boolean.valueOf(true));
                    }
                    boolean z4 = f != i2;
                    if (z4) {
                        com.tencent.mm.sdk.platformtools.v.w("MMKernel.CoreStorage", "account storage version changed from " + Integer.toHexString(f) + " to " + Integer.toHexString(i2) + ", init=" + z2);
                        if (((Integer) vw2.cjT.get(37, Integer.valueOf(0))).intValue() == 0) {
                            vw2.cjT.set(37, Integer.valueOf(f));
                        }
                        vw2.ckd.set(14, Integer.valueOf(i2));
                        vw2.ckd.set(30, Boolean.valueOf(false));
                        vw2.ckd.set(-2046825377, Boolean.valueOf(false));
                        vw2.ckd.set(-2046825369, Boolean.valueOf(false));
                        vw2.ckd.set(54, Boolean.valueOf(false));
                        vw2.ckd.set(-2046825368, Boolean.valueOf(false));
                        vw2.ckd.set(-29414083, Integer.valueOf(0));
                        vw2.ckd.set(-2046825366, Boolean.valueOf(true));
                        vw2.ckd.set(62, Boolean.valueOf(true));
                        aa.getContext().getSharedPreferences("update_config_prefs", 4).edit().clear().commit();
                        if ((f & -256) == (i2 & -256)) {
                            ab.Ki("show_whatsnew");
                        }
                    } else {
                        ab.Ki("show_whatsnew");
                    }
                    vw2.cjU.aM(z4);
                    com.tencent.mm.sdk.platformtools.v.i("MMKernel.CoreAccount", "check is update :%b ", Boolean.valueOf(z3));
                    if (this.cji != null) {
                        this.cji.a(this, z3);
                    }
                    ai.cse.J("last_login_uin", o.getString(i));
                    com.tencent.mm.plugin.report.b.itm.cW(i);
                    this.cjr = new com.tencent.mm.model.a();
                    com.tencent.mm.sdk.platformtools.v.i("MMKernel.CoreAccount", "setAccUin done :%s", o.getString(i));
                    g.vx();
                    if (g.vv().cjC != null) {
                        g.vx();
                        if (g.vv().cjC.cAa != null) {
                            g.vx();
                            g.vv().cjC.cAa.aU(true);
                            g.vx();
                            c BU = g.vv().cjC.cAa.BU();
                            if (!(this.uin == 0 || BU == null || this.uin == BU.ww())) {
                                com.tencent.mm.sdk.platformtools.v.w("MMKernel.CoreAccount", "summerauth update acc info with acc stg: old acc uin=%d, this uin=%d", Integer.valueOf(BU.ww()), Integer.valueOf(this.uin));
                                com.tencent.mm.plugin.report.b.itm.a(148, 46, 1, false);
                                BU.cW(this.uin);
                            }
                        }
                    }
                } else {
                    throw new com.tencent.mm.model.b((byte) 0);
                }
            }
            throw new SQLiteException("main db init failed");
        }
        this.cjo = false;
        com.tencent.mm.sdk.platformtools.v.i("MMKernel.CoreAccount", "start time check setUinWapper end mAccountInitializing %b, total time %d", Boolean.valueOf(this.cjo), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        if (obj != null) {
            g.vA().btw();
        }
    }

    public static void aJ(boolean z) {
        cjk = false;
    }

    public static boolean uE() {
        return cjl;
    }

    public static void aK(boolean z) {
        cjl = false;
    }

    public static boolean uF() {
        return cjm;
    }

    public static void aL(boolean z) {
        cjm = z;
    }

    public static boolean uG() {
        if (cjj) {
            String string;
            String str = "MMKernel.CoreAccount";
            String str2 = "account holded :%s";
            Object[] objArr = new Object[1];
            g.vx();
            if (g.vu() != null) {
                g.vx();
                string = o.getString(g.vu().uin);
            } else {
                string = "-1";
            }
            objArr[0] = string;
            com.tencent.mm.sdk.platformtools.v.w(str, str2, objArr);
        }
        return cjj;
    }

    public static void hold() {
        String string;
        String str = "MMKernel.CoreAccount";
        String str2 = " HOLD ACCOUNT! uin:%s stack:%s";
        Object[] objArr = new Object[2];
        g.vx();
        if (g.vu() != null) {
            g.vx();
            string = o.getString(g.vu().uin);
        } else {
            string = "-1";
        }
        objArr[0] = string;
        objArr[1] = be.bur();
        com.tencent.mm.sdk.platformtools.v.w(str, str2, objArr);
        cjj = true;
        g.vx();
        g.vw().cjT.set(17, Integer.valueOf(1));
    }

    public static void unhold() {
        String string;
        String str = "MMKernel.CoreAccount";
        String str2 = " UN HOLD ACCOUNT! uin:%s";
        Object[] objArr = new Object[1];
        g.vx();
        if (g.vu() != null) {
            g.vx();
            string = o.getString(g.vu().uin);
        } else {
            string = "-1";
        }
        objArr[0] = string;
        com.tencent.mm.sdk.platformtools.v.w(str, str2, objArr);
        cjj = false;
        g.vx();
        g.vw().cjT.set(17, Integer.valueOf(0));
    }

    public final void uH() {
        if (this.uin == 0) {
            throw new com.tencent.mm.model.b();
        }
    }

    public final void uI() {
        new ac(Looper.getMainLooper()).post(new Runnable(this) {
            final /* synthetic */ a cjA;

            {
                this.cjA = r1;
            }

            public final void run() {
                for (af yM : this.cjA.cju) {
                    yM.yM();
                }
            }
        });
    }

    public final void aA(int i, int i2) {
        int i3 = (this.cjs == i && this.cjt == i2) ? 0 : 1;
        com.tencent.mm.sdk.platformtools.v.d("MMKernel.CoreAccount", "online status, %d, %d, %d ,%d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(this.cjt), Integer.valueOf(this.cjs));
        if (i3 != 0) {
            this.cjs = i;
            this.cjt = i2;
            new ac(Looper.getMainLooper()).post(new Runnable(this) {
                final /* synthetic */ a cjA;

                {
                    this.cjA = r1;
                }

                public final void run() {
                    this.cjA.uI();
                }
            });
        }
    }

    public static void eA(int i) {
        if (cjv == -1 || cjv != i) {
            cjv = i;
            uK().edit().putInt("notification.user.state", i).commit();
            com.tencent.mm.sdk.platformtools.v.i("MMKernel.CoreAccount", "[NOTIFICATION SETTINGS]save UserStatus: %d", Integer.valueOf(i));
        }
    }

    public static int uJ() {
        return uK().getInt("notification.user.state", 0);
    }

    public static SharedPreferences uK() {
        return aa.getContext().getSharedPreferences("notify_key_pref_settings", 4);
    }

    public static boolean eB(int i) {
        return (i & 1) != 0;
    }

    public final boolean uL() {
        if (this.cjw) {
            com.tencent.mm.sdk.platformtools.v.j("MMKernel.CoreAccount", "fuck u, MMCore.getAccStg", new Object[0]);
            this.cjw = false;
        }
        if (!g.uz()) {
            synchronized (this.cjn) {
                if (g.uz()) {
                } else {
                    g.vx();
                    q qVar = g.vw().cjT;
                    Integer valueOf = Integer.valueOf(uQ());
                    if (valueOf == null) {
                        com.tencent.mm.sdk.platformtools.v.e("MMKernel.CoreAccount", "getAccStg, uin ==== null, task %s", be.ea(aa.getContext()));
                    } else if (valueOf.intValue() != 0) {
                        com.tencent.mm.sdk.platformtools.v.w("MMKernel.CoreAccount", "auto set up account storage uin: %d, stack: %s", valueOf, be.bur());
                        ez(valueOf.intValue());
                        g.vx();
                        if (be.ma((String) g.vw().vf().get(2, null)).length() <= 0) {
                            com.tencent.mm.sdk.platformtools.v.e("MMKernel.CoreAccount", "username of acc stg not set: uin=" + valueOf);
                            reset();
                            e.a(qVar, 0);
                            cjp = be.bur().toString();
                            ad.o(new Runnable(this) {
                                final /* synthetic */ a cjA;

                                {
                                    this.cjA = r1;
                                }

                                public final void run() {
                                    g.vx().releaseAll();
                                }
                            });
                        }
                    }
                }
            }
        }
        return true;
    }

    public static boolean uM() {
        if (g.uz() || uQ() == 0) {
            return false;
        }
        return true;
    }

    public static boolean uN() {
        if (g.vr() || uQ() == 0) {
            return false;
        }
        return true;
    }

    public static boolean uO() {
        g.vx();
        return g.vu().uL();
    }

    public static boolean uP() {
        if (g.uz() || uQ() == 0) {
            return false;
        }
        return true;
    }

    public static int uQ() {
        g.vx();
        q qVar = g.vw().cjT;
        if (qVar == null) {
            com.tencent.mm.sdk.platformtools.v.w("MMKernel.CoreAccount", "summer read detault uin exception sysCfg is null!");
            return 0;
        }
        Integer num = (Integer) qVar.get(1);
        if (num == null) {
            if (qVar.nnY) {
                com.tencent.mm.plugin.report.b.itm.a(148, 40, 1, false);
            }
            Integer valueOf = Integer.valueOf(aa.getContext().getSharedPreferences("system_config_prefs", 0).getInt("default_uin", 0));
            if (valueOf != null) {
                com.tencent.mm.sdk.platformtools.v.i("MMKernel.CoreAccount", "summer read detault uin[%d], bakUin[%d] sysCfg.isOpenException[%b]", num, valueOf, Boolean.valueOf(qVar.nnY));
                if (cjx) {
                    com.tencent.mm.sdk.platformtools.v.w("MMKernel.CoreAccount", "summer read detault uin exception backup uin[%d], stack[%s]", valueOf, be.bur());
                    com.tencent.mm.plugin.report.b.itm.h(11911, Integer.valueOf(be.f(valueOf)));
                    cjx = false;
                }
                e.a(qVar, valueOf.intValue());
                num = valueOf;
            }
        }
        return be.f(num);
    }

    public static String uR() {
        g.vx();
        if (be.kS(g.vu().cjy)) {
            uS();
        }
        g.vx();
        return g.vu().cjy;
    }

    public static void uS() {
        g.vx();
        g.vu().cjy = p.rK() + "_" + System.currentTimeMillis();
        g.vx();
        g.vu().cjz.clear();
    }

    public static int dR(String str) {
        int i;
        g.vx();
        if (g.vu().cjz.get(str) == null) {
            i = 0;
        } else {
            g.vx();
            i = ((Integer) g.vu().cjz.get(str)).intValue();
        }
        int Nh = (int) be.Nh();
        if (i == 0) {
            g.vx();
            g.vu().cjz.put(str, Integer.valueOf(Nh));
            return i;
        }
        i = Nh - i;
        g.vx();
        g.vu().cjz.put(str, Integer.valueOf(Nh));
        return i < 0 ? 0 : i;
    }
}
