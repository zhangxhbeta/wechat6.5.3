package com.tencent.mm.plugin.gcm.modelgcm;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import com.tencent.mm.network.z;
import com.tencent.mm.plugin.report.b;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import com.tencent.mmdb.database.SQLiteDatabase;

public class a implements e {
    private static a gAC;
    Context context;
    private int gAA = 3;
    private int gAB = 0;
    com.google.android.gms.gcm.a gAD;

    class a extends AsyncTask<Void, Void, String> {
        final /* synthetic */ a gAE;

        a(a aVar) {
            this.gAE = aVar;
        }

        protected final /* synthetic */ Object doInBackground(Object[] objArr) {
            return asW();
        }

        protected final /* bridge */ /* synthetic */ void onPostExecute(Object obj) {
        }

        private String asW() {
            Object obj = null;
            b.itm.a(452, 5, 1, false);
            String b;
            String str;
            try {
                v.i("GcmRegister", "RegisterAsyncTask doInBackground.");
                if (this.gAE.gAD == null) {
                    this.gAE.gAD = com.google.android.gms.gcm.a.C(this.gAE.context);
                }
                b = this.gAE.gAD.b("546136561403");
                str = "Device registered, registration ID=" + b;
                if (b == null || b.length() <= 0) {
                    g.iuh.Y(11250, new StringBuilder("2,1").toString());
                    b.itm.a(452, 7, 1, false);
                    b = str;
                    v.i("GcmRegister", b);
                    if (obj == null && this.gAE.gAA > 0) {
                        a.e(this.gAE);
                        this.gAE.asQ();
                    }
                    return b;
                }
                this.gAE.Y(this.gAE.context, b);
                this.gAE.asT();
                obj = 1;
                b.itm.a(452, 6, 1, false);
                b = str;
                v.i("GcmRegister", b);
                a.e(this.gAE);
                this.gAE.asQ();
                return b;
            } catch (Throwable e) {
                str = "Device register Error :" + e.getMessage();
                v.a("GcmRegister", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                g.iuh.Y(11250, new StringBuilder("2,1").toString());
                b.itm.a(452, 8, 1, false);
                b = str;
            } catch (Throwable e2) {
                this.gAE.gAA = 0;
                str = "Device register Error :" + e2.getMessage();
                v.a("GcmRegister", e2, SQLiteDatabase.KeyEmpty, new Object[0]);
                g.iuh.Y(11250, new StringBuilder("2,1").toString());
                b.itm.a(452, 9, 1, false);
                b = str;
            } catch (Throwable e22) {
                str = "Device register Error :" + e22.getMessage();
                v.a("GcmRegister", e22, SQLiteDatabase.KeyEmpty, new Object[0]);
                g.iuh.Y(11250, new StringBuilder("2,1").toString());
                b.itm.a(452, 10, 1, false);
                b = str;
            }
        }
    }

    static /* synthetic */ int e(a aVar) {
        int i = aVar.gAA - 1;
        aVar.gAA = i;
        return i;
    }

    private a(Context context) {
        this.context = context;
    }

    public static a asP() {
        v.i("GcmRegister", "GCM getInstance");
        if (gAC != null) {
            return gAC;
        }
        Context context = aa.getContext();
        if (context == null) {
            v.e("GcmRegister", "GCM appcontext null");
            return null;
        }
        a aVar = new a(context);
        gAC = aVar;
        return aVar;
    }

    public final void asQ() {
        v.i("GcmRegister", "checkregister");
        z.Mv().postDelayed(new Runnable(this) {
            final /* synthetic */ a gAE;

            {
                this.gAE = r1;
            }

            public final void run() {
                v.e("GcmRegister", "onCreate~~~threadID:" + Thread.currentThread());
                a asP = a.asP();
                if (asP != null) {
                    v.i("GcmRegister", "doRegist~~~");
                    String asR = asP.asR();
                    v.i("GcmRegister", "regid = " + asR);
                    if (a.cc(asP.context)) {
                        asP.gAD = com.google.android.gms.gcm.a.C(asP.context);
                        if (asR == null || asR.length() == 0) {
                            new a(asP).execute(new Void[]{null, null, null});
                            return;
                        }
                        asP.asT();
                        return;
                    }
                    v.i("GcmRegister", "Google Play Services Unavailable.");
                    g.iuh.Y(11250, new StringBuilder("2,0").toString());
                    b.itm.a(452, 0, 1, false);
                    if (asP.asV()) {
                        asP.asR();
                        asP.asU();
                    }
                }
            }
        }, 5000);
    }

    @SuppressLint({"NewApi"})
    public final String asR() {
        SharedPreferences asS = asS();
        String string = asS.getString("registration_id", SQLiteDatabase.KeyEmpty);
        if (string.length() == 0) {
            v.i("GcmRegister", "Registration not found.");
            b.itm.a(452, 1, 1, false);
            return SQLiteDatabase.KeyEmpty;
        } else if (asS.getInt("appVersion", Integer.MIN_VALUE) != cb(this.context)) {
            v.i("GcmRegister", "App version changed.");
            b.itm.a(452, 2, 1, false);
            return SQLiteDatabase.KeyEmpty;
        } else if (be.ax(asS.getLong("regtime", 0)) > 259200) {
            v.i("GcmRegister", "gcm regid timeout");
            b.itm.a(452, 3, 1, false);
            return SQLiteDatabase.KeyEmpty;
        } else {
            b.itm.a(452, 4, 1, false);
            return string;
        }
    }

    private SharedPreferences asS() {
        return this.context.getSharedPreferences(a.class.getSimpleName(), 0);
    }

    private static int cb(Context context) {
        int i = 0;
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (NameNotFoundException e) {
            v.e("GcmRegister", "Could not get package name.");
            return i;
        }
    }

    public final void asT() {
        b.itm.a(452, 11, 1, false);
        int ww = z.Mx().dlt.ww();
        if (this.gAB == 0 || ww != this.gAB) {
            String asR = asR();
            if (asR == null || asR.length() == 0) {
                v.i("GcmRegister", "sendRegistrationIdToBackend regid is empty.");
                b.itm.a(452, 13, 1, false);
                return;
            }
            v.i("GcmRegister", "regToWeixinServer.");
            try {
                new e(asR, ww).a(z.Mx(), this);
                b.itm.a(452, 14, 1, false);
                return;
            } catch (Throwable th) {
                b.itm.a(452, 15, 1, false);
                v.e("GcmRegister", "NetScenePushReg doScene error:" + th.toString());
                return;
            }
        }
        v.i("GcmRegister", "uin already reg to weixin svr:" + this.gAB);
        b.itm.a(452, 12, 1, false);
    }

    public final void asU() {
        v.i("GcmRegister", "unregToWeixinServer");
        b.itm.a(452, 18, 1, false);
        String asR = asR();
        if (asR == null || asR.length() == 0) {
            v.e("GcmRegister", "unregToWeixinServer regid is empty.");
            b.itm.a(452, 19, 1, false);
        } else if (asV()) {
            dq(false);
            try {
                new f(asR, z.Mx().dlt.ww()).a(z.Mx(), this);
                b.itm.a(452, 21, 1, false);
            } catch (Throwable th) {
                v.e("GcmRegister", "NetScenePushUnReg doScene error:" + th.toString());
                b.itm.a(452, 22, 1, false);
            }
        } else {
            v.e("GcmRegister", "is not reg to Svr. no need unreg.");
            b.itm.a(452, 20, 1, false);
        }
    }

    public final void Y(Context context, String str) {
        SharedPreferences asS = asS();
        int cb = cb(context);
        v.i("GcmRegister", "Saving regId on app version " + cb);
        Editor edit = asS.edit();
        edit.putString("registration_id", str);
        edit.putInt("appVersion", cb);
        edit.putLong("regtime", be.Nh());
        edit.commit();
    }

    private void dq(boolean z) {
        SharedPreferences asS = asS();
        v.i("GcmRegister", "Saving regSvrResult: " + z);
        Editor edit = asS.edit();
        edit.putBoolean("isRegToSvr", z);
        edit.commit();
        if (z) {
            this.gAB = z.Mx().dlt.ww();
        } else {
            this.gAB = 0;
        }
    }

    public final boolean asV() {
        return asS().getBoolean("isRegToSvr", false);
    }

    static boolean cc(Context context) {
        try {
            if (Integer.valueOf(VERSION.SDK_INT).intValue() < 8) {
                return false;
            }
            int v = com.google.android.gms.common.e.v(context);
            if (v == 0) {
                return true;
            }
            v.w("GcmRegister", "device not support GCM reason = " + v);
            return false;
        } catch (Throwable th) {
            v.e("GcmRegister", th.toString());
            return false;
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        boolean z = false;
        v.i("GcmRegister", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        kVar.czK = true;
        if (kVar != null) {
            if (kVar instanceof e) {
                if (i == 0 && i2 == 0) {
                    v.i("GcmRegister", "NetScenePushReg success.");
                    b.itm.a(452, 16, 1, false);
                    z = true;
                } else {
                    v.i("GcmRegister", "NetScenePushReg faild.");
                    b.itm.a(452, 17, 1, false);
                }
                dq(z);
            } else if (kVar instanceof f) {
                if (i == 0 && i2 == 0) {
                    v.i("GcmRegister", "NetScenePushUnReg success.");
                    b.itm.a(452, 23, 1, false);
                } else {
                    v.e("GcmRegister", "NetScenePushUnReg faild.");
                    b.itm.a(452, 24, 1, false);
                }
                dq(false);
            }
        }
    }
}
