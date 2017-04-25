package com.tencent.mm.plugin.ext.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Binder;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.ay;
import com.tencent.mm.network.e;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.b.b;
import com.tencent.mm.pluginsdk.e.a.a;
import com.tencent.mm.pluginsdk.j;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.HashMap;

@JgClassChecked(author = 32, fComment = "checked", lastDate = "20141016", reviewer = 20, vComment = {EType.PROVIDERCHECK})
public class ExtContentProviderBase extends ContentProvider {
    protected static boolean enB = false;
    private static HashMap<String, Long> fHk = new HashMap();
    public MatrixCursor enz = new MatrixCursor(new String[0]);
    private long fHf = be.Nj();
    private String fHg;
    public String fHh = SQLiteDatabase.KeyEmpty;
    private String[] fHi;
    private int fHj = 0;

    public boolean onCreate() {
        return true;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    public String getType(Uri uri) {
        return null;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }

    public final void kB(int i) {
        v.i("MicroMsg.ExtContentProviderBase", "callingPkg = %s, appID = %s, apiID = %s, result = %s, timeCost = %s", akY(), this.fHh, Integer.valueOf(this.fHj), Integer.valueOf(i), Integer.valueOf(akX()));
        g.iuh.h(10505, akY(), this.fHh, Integer.valueOf(this.fHj), Integer.valueOf(i), Integer.valueOf(akX()));
    }

    public final void bB(int i, int i2) {
        v.i("MicroMsg.ExtContentProviderBase", "callingPkg = %s, appID = %s, apiID = %s, result = %s, timeCost = %s", akY(), this.fHh, Integer.valueOf(this.fHj), Integer.valueOf(i), Integer.valueOf(akX()));
        g.iuh.h(10505, akY(), this.fHh, Integer.valueOf(this.fHj), Integer.valueOf(i), Integer.valueOf(akX()), Integer.valueOf(i2));
    }

    public final void z(int i, int i2, int i3) {
        v.i("MicroMsg.ExtContentProviderBase", "callingPkg = %s, appID = %s, apiID = %s, result = %s, timeCost = %s", akY(), this.fHh, Integer.valueOf(this.fHj), Integer.valueOf(i2), Integer.valueOf(akX()));
        g.iuh.h(10505, akY(), this.fHh, Integer.valueOf(this.fHj), Integer.valueOf(i2), Integer.valueOf(akX()), Integer.valueOf(i3));
        g.iuh.a(300, (long) i, 1, false);
    }

    private int akX() {
        return (int) be.az(this.fHf);
    }

    protected final void a(Uri uri, Context context, UriMatcher uriMatcher) {
        this.fHh = f(uri);
        bH(context);
        if (uriMatcher != null) {
            this.fHj = uriMatcher.match(uri);
            if (this.fHj < 0) {
                this.fHj = 0;
            }
        }
        this.fHf = be.Nj();
    }

    protected final void a(Uri uri, Context context, int i) {
        this.fHh = f(uri);
        bH(context);
        this.fHj = i;
        this.fHf = be.Nj();
    }

    public final void a(Uri uri, Context context, int i, String[] strArr) {
        this.fHh = f(uri);
        if (strArr == null) {
            bH(context);
        } else {
            this.fHi = strArr;
        }
        this.fHj = i;
        this.fHf = be.Nj();
    }

    public final String akY() {
        if (!be.kS(this.fHg)) {
            return this.fHg;
        }
        if (this.fHi == null || this.fHi.length <= 0) {
            return SQLiteDatabase.KeyEmpty;
        }
        return this.fHi[0];
    }

    public final boolean WN() {
        try {
            v.i("MicroMsg.ExtContentProviderBase", "checkIsLogin()");
            if (!enB) {
                final a aVar = new a();
                aVar.b(4000, new Runnable(this) {
                    final /* synthetic */ ExtContentProviderBase fHl;

                    public final void run() {
                        try {
                            if (ak.uz()) {
                                ak.vy().a(new ay(new ay.a(this) {
                                    final /* synthetic */ AnonymousClass1 fHm;

                                    {
                                        this.fHm = r1;
                                    }

                                    public final void a(e eVar) {
                                        v.i("MicroMsg.ExtContentProviderBase", "checkIsLogin() onSceneEnd()");
                                        aVar.countDown();
                                    }
                                }), 0);
                            }
                        } catch (Exception e) {
                            v.e("MicroMsg.ExtContentProviderBase", "exception in NetSceneLocalProxy");
                            aVar.countDown();
                        }
                    }
                });
            }
            if (ak.uz() && ak.uN() && !ak.uG()) {
                enB = true;
            } else {
                enB = false;
            }
            v.i("MicroMsg.ExtContentProviderBase", "hasLogin = " + enB);
            return enB;
        } catch (Throwable e) {
            v.w("MicroMsg.ExtContentProviderBase", e.getMessage());
            v.a("MicroMsg.ExtContentProviderBase", e, SQLiteDatabase.KeyEmpty, new Object[0]);
            return false;
        }
    }

    private static String f(Uri uri) {
        if (uri == null) {
            return SQLiteDatabase.KeyEmpty;
        }
        return be.ma(uri.getQueryParameter("appid"));
    }

    public final boolean bG(Context context) {
        Throwable th;
        boolean z;
        if (context == null) {
            v.w("MicroMsg.ExtContentProviderBase", "in checkAppId(), context == null");
            return false;
        } else if (be.kS(this.fHh)) {
            v.e("MicroMsg.ExtContentProviderBase", "invalid appid, ignore");
            return false;
        } else if (this.fHi == null || this.fHi.length <= 0) {
            v.e("MicroMsg.ExtContentProviderBase", "packageList is null");
            return false;
        } else {
            try {
                f aC = com.tencent.mm.pluginsdk.model.app.g.aC(this.fHh, true);
                if (aC == null) {
                    v.w("MicroMsg.ExtContentProviderBase", "app not reg, do nothing");
                    return false;
                }
                boolean z2;
                if (aC.field_status == 3) {
                    v.e("MicroMsg.ExtContentProviderBase", "app is in blacklist.pkg:%s", aC.field_packageName);
                    z2 = false;
                } else {
                    for (String str : this.fHi) {
                        if (str.equals(aC.field_packageName) && p.b(aa.getContext(), aC, str)) {
                            v.i("MicroMsg.ExtContentProviderBase", "check app success, calling package name = %s", str);
                            try {
                                this.fHg = str;
                                z2 = true;
                                break;
                            } catch (Throwable e) {
                                th = e;
                                z = true;
                                v.e("MicroMsg.ExtContentProviderBase", "Exception in isAppidValid, %s", th.getMessage());
                                v.a("MicroMsg.ExtContentProviderBase", th, SQLiteDatabase.KeyEmpty, new Object[0]);
                                return z;
                            }
                        }
                    }
                    z2 = false;
                    if (z2) {
                        Integer num = (Integer) b.lxx.get(Integer.valueOf(this.fHj));
                        if (num == null) {
                            num = Integer.valueOf(64);
                        }
                        if (com.tencent.mm.pluginsdk.model.app.g.a(aC, num.intValue())) {
                            v.e("MicroMsg.ExtContentProviderBase", "appInfoFlag not set");
                        } else {
                            z2 = false;
                        }
                    }
                }
                try {
                    v.i("MicroMsg.ExtContentProviderBase", "lastCheckTime = %s, current = %s", Long.valueOf(be.a((Long) fHk.get(this.fHh), 0)), Long.valueOf(System.currentTimeMillis()));
                    if (System.currentTimeMillis() - Long.valueOf(be.a((Long) fHk.get(this.fHh), 0)).longValue() > 3600000) {
                        v.i("MicroMsg.ExtContentProviderBase", "update appInfo %s", this.fHh);
                        j.a.lxJ.Gi(this.fHh);
                        fHk.put(this.fHh, Long.valueOf(System.currentTimeMillis()));
                    }
                    return z2;
                } catch (Throwable e2) {
                    Throwable th2 = e2;
                    z = z2;
                    th = th2;
                    v.e("MicroMsg.ExtContentProviderBase", "Exception in isAppidValid, %s", th.getMessage());
                    v.a("MicroMsg.ExtContentProviderBase", th, SQLiteDatabase.KeyEmpty, new Object[0]);
                    return z;
                }
            } catch (Throwable e22) {
                th = e22;
                z = false;
                v.e("MicroMsg.ExtContentProviderBase", "Exception in isAppidValid, %s", th.getMessage());
                v.a("MicroMsg.ExtContentProviderBase", th, SQLiteDatabase.KeyEmpty, new Object[0]);
                return z;
            }
        }
    }

    public final int akZ() {
        int i;
        Throwable th;
        if (be.kS(this.fHh)) {
            v.e("MicroMsg.ExtContentProviderBase", "invalid appid, ignore");
            return 7;
        } else if (this.fHi == null || this.fHi.length <= 0) {
            v.e("MicroMsg.ExtContentProviderBase", "packageList is null");
            return 6;
        } else {
            try {
                f aC = com.tencent.mm.pluginsdk.model.app.g.aC(this.fHh, true);
                if (aC == null) {
                    v.w("MicroMsg.ExtContentProviderBase", "app not reg, do nothing");
                    return 13;
                }
                int i2;
                if (aC.field_status == 3) {
                    v.e("MicroMsg.ExtContentProviderBase", "app is in blacklist.pkg:%s", aC.field_packageName);
                    i2 = 10;
                } else {
                    for (String str : this.fHi) {
                        if (str.equals(aC.field_packageName) && p.b(aa.getContext(), aC, str)) {
                            v.i("MicroMsg.ExtContentProviderBase", "check app success, calling package name = %s", str);
                            try {
                                this.fHg = str;
                                i2 = 1;
                                break;
                            } catch (Throwable e) {
                                th = e;
                                i = 1;
                                v.e("MicroMsg.ExtContentProviderBase", "Exception in isAppidValid, %s", th.getMessage());
                                v.a("MicroMsg.ExtContentProviderBase", th, SQLiteDatabase.KeyEmpty, new Object[0]);
                                return i;
                            }
                        }
                    }
                    i2 = 0;
                    if (i2 == 1) {
                        Integer num = (Integer) b.lxx.get(Integer.valueOf(this.fHj));
                        if (num == null) {
                            bB(5, 16);
                            v.i("MicroMsg.ExtContentProviderBase", "api flag = null");
                            num = Integer.valueOf(64);
                        }
                        if (com.tencent.mm.pluginsdk.model.app.g.a(aC, num.intValue())) {
                            v.e("MicroMsg.ExtContentProviderBase", "appInfoFlag not set");
                        } else {
                            i2 = 11;
                        }
                    }
                }
                try {
                    v.i("MicroMsg.ExtContentProviderBase", "lastCheckTime = %s, current = %s", Long.valueOf(be.a((Long) fHk.get(this.fHh), 0)), Long.valueOf(System.currentTimeMillis()));
                    if (System.currentTimeMillis() - Long.valueOf(be.a((Long) fHk.get(this.fHh), 0)).longValue() > 3600000) {
                        v.i("MicroMsg.ExtContentProviderBase", "update appInfo %s", this.fHh);
                        j.a.lxJ.Gi(this.fHh);
                        fHk.put(this.fHh, Long.valueOf(System.currentTimeMillis()));
                    }
                    return i2;
                } catch (Throwable e2) {
                    Throwable th2 = e2;
                    i = i2;
                    th = th2;
                    v.e("MicroMsg.ExtContentProviderBase", "Exception in isAppidValid, %s", th.getMessage());
                    v.a("MicroMsg.ExtContentProviderBase", th, SQLiteDatabase.KeyEmpty, new Object[0]);
                    return i;
                }
            } catch (Throwable e22) {
                th = e22;
                i = 0;
                v.e("MicroMsg.ExtContentProviderBase", "Exception in isAppidValid, %s", th.getMessage());
                v.a("MicroMsg.ExtContentProviderBase", th, SQLiteDatabase.KeyEmpty, new Object[0]);
                return i;
            }
        }
    }

    private void bH(Context context) {
        if (context == null) {
            v.w("MicroMsg.ExtContentProviderBase", "in initCallerPkgName(), context == null");
            return;
        }
        v.i("MicroMsg.ExtContentProviderBase", "Binder.getCallingUid() = " + Binder.getCallingUid());
        this.fHi = context.getPackageManager().getPackagesForUid(Binder.getCallingUid());
        if (this.fHi == null) {
            v.w("MicroMsg.ExtContentProviderBase", "m_pkgs == null");
        }
    }

    public static MatrixCursor kC(int i) {
        v.i("MicroMsg.ExtContentProviderBase", "returnMatrix = " + i);
        MatrixCursor matrixCursor = new MatrixCursor(com.tencent.mm.plugin.ext.b.a.fGL);
        matrixCursor.addRow(new Object[]{Integer.valueOf(i)});
        return matrixCursor;
    }
}
