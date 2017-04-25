package com.tencent.mm.pluginsdk.model.app;

import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.mm.a.g;
import com.tencent.mm.e.b.n;
import com.tencent.mm.model.ak;
import com.tencent.mm.sdk.h.c;
import com.tencent.mm.sdk.h.d;
import com.tencent.mm.sdk.h.f;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.FileUtils;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public final class i extends f<f> {
    public static final String[] cic = new String[]{f.a(f.chq, "AppInfo")};
    final com.tencent.mm.a.f<String, f> lAu = new com.tencent.mm.a.f(50);

    public final /* synthetic */ boolean b(c cVar) {
        return m((f) cVar);
    }

    public final /* synthetic */ boolean c(c cVar, String[] strArr) {
        return b((f) cVar, strArr);
    }

    public i(d dVar) {
        super(dVar, f.chq, "AppInfo", n.btd);
        c fVar = new f();
        fVar.field_appId = "wx4310bbd51be7d979";
        if (!super.b(fVar, new String[0])) {
            fVar = new f();
            fVar.field_appId = "wx4310bbd51be7d979";
            fVar.field_appName = "weixinfile";
            fVar.field_packageName = "com.tencent.mm.openapi";
            fVar.field_status = -1;
            super.b(fVar);
        }
    }

    private void l(f fVar) {
        if (fVar != null && fVar.field_appId != null) {
            this.lAu.k(fVar.field_appId, fVar);
        }
    }

    private void zk(String str) {
        if (!be.kS(str)) {
            this.lAu.remove(str);
        }
    }

    public final boolean m(f fVar) {
        if (fVar == null || be.kS(fVar.field_appId) || !super.a((c) fVar, false)) {
            return false;
        }
        a(fVar.field_appId, 2, fVar.field_appId);
        l(fVar);
        return true;
    }

    public final boolean a(f fVar, String... strArr) {
        boolean z = false;
        if (!(fVar == null || be.kS(fVar.field_appId))) {
            zk(fVar.field_appId);
            z = super.b(fVar, false, strArr);
            if (z) {
                a(fVar.field_appId, 3, fVar.field_appId);
            }
        }
        return z;
    }

    public final boolean b(f fVar, String... strArr) {
        boolean z = false;
        if (!(fVar == null || be.kS(fVar.field_appId))) {
            zk(fVar.field_appId);
            z = super.a((c) fVar, false, strArr);
            if (z) {
                a(fVar.field_appId, 5, fVar.field_appId);
            }
        }
        return z;
    }

    public final List<String> bnq() {
        v.d("MicroMsg.AppInfoStorage", new StringBuilder("getNullOpenIdList, maxCount = -1").toString());
        List arrayList = new ArrayList();
        Cursor rawQuery = rawQuery("select appId from AppInfo where openId is NULL ", new String[0]);
        if (rawQuery == null) {
            v.e("MicroMsg.AppInfoStorage", "get null cursor");
        } else {
            int count = rawQuery.getCount();
            if (count <= 0) {
                v.w("MicroMsg.AppInfoStorage", "getNullOpenIdList fail, cursor count = " + count);
                rawQuery.close();
            } else {
                if (rawQuery.moveToFirst()) {
                    while (!rawQuery.isAfterLast()) {
                        count = rawQuery.getColumnIndex("appId");
                        if (count >= 0) {
                            String string = rawQuery.getString(count);
                            if (!be.kS(string)) {
                                arrayList.add(string);
                            }
                        }
                        rawQuery.moveToNext();
                    }
                }
                if (rawQuery != null) {
                    rawQuery.close();
                }
            }
        }
        return arrayList;
    }

    public final f Gz(String str) {
        if (str == null || str.length() == 0) {
            v.e("MicroMsg.AppInfoStorage", "appId is null");
            return null;
        }
        f fVar = (f) this.lAu.get(str);
        if (fVar == null) {
            fVar = null;
        }
        if (fVar != null && !be.kS(fVar.field_appId)) {
            return fVar;
        }
        c fVar2 = new f();
        fVar2.field_appId = str;
        if (!super.b(fVar2, new String[0])) {
            return null;
        }
        l(fVar2);
        return fVar2;
    }

    public final void n(f fVar) {
        if (fVar != null && fVar.field_status != 5) {
            fVar.field_status = 3;
            v.i("MicroMsg.AppInfoStorage", "setBlack package name = %s", fVar.field_packageName);
            a(fVar, new String[0]);
        }
    }

    public final void o(f fVar) {
        if (fVar != null && fVar.field_status == 3) {
            fVar.field_status = 4;
            a(fVar, new String[0]);
        }
    }

    public final Cursor cQ(int i, int i2) {
        StringBuilder stringBuilder = new StringBuilder(FileUtils.S_IRUSR);
        stringBuilder.append("select * from AppInfo");
        stringBuilder.append(" where ");
        if (i != 0) {
            stringBuilder.append(" ( serviceAppInfoFlag & ").append(i).append(" ) != 0 and ");
        }
        stringBuilder.append(" ( serviceShowFlag & ").append(i2).append(" ) != 0");
        Cursor rawQuery = rawQuery(stringBuilder.toString(), new String[0]);
        if (rawQuery == null) {
            v.e("MicroMsg.AppInfoStorage", "getServiceByAppInfoFlagAndShowFlag : cursor is null");
            return null;
        }
        v.d("MicroMsg.AppInfoStorage", "getServiceByAppInfoFlagAndShowFlag count = %d", Integer.valueOf(rawQuery.getCount()));
        return rawQuery;
    }

    public final Cursor bnr() {
        Cursor rawQuery = rawQuery("select * from AppInfo where appType like '%1,%'", new String[0]);
        if (rawQuery != null) {
            return rawQuery;
        }
        v.e("MicroMsg.AppInfoStorage", "getGameApp : cursor is null");
        return null;
    }

    public static String bB(String str, int i) {
        int i2 = 0;
        if (str == null || str.length() == 0) {
            v.e("MicroMsg.AppInfoStorage", "getIconPath : invalid argument");
            return null;
        }
        StringBuilder stringBuilder;
        ak.yW();
        File file = new File(com.tencent.mm.model.c.xc());
        if (!file.exists()) {
            if (!file.getParentFile().exists()) {
                File parentFile = file.getParentFile();
                File file2 = new File(parentFile.getAbsolutePath() + System.currentTimeMillis());
                if (file2.mkdir()) {
                    file2.renameTo(parentFile);
                } else {
                    v.e("MicroMsg.AppInfoStorage", "mkdir error, %s", parentFile.getAbsolutePath());
                    if (i2 != 0) {
                        return null;
                    }
                    switch (i) {
                        case 1:
                            stringBuilder = new StringBuilder();
                            ak.yW();
                            return stringBuilder.append(com.tencent.mm.model.c.xc()).append(g.m(str.getBytes())).append(".png").toString();
                        case 2:
                            stringBuilder = new StringBuilder();
                            ak.yW();
                            return stringBuilder.append(com.tencent.mm.model.c.xc()).append(g.m(str.getBytes())).append("_wm.png").toString();
                        case 3:
                            stringBuilder = new StringBuilder();
                            ak.yW();
                            return stringBuilder.append(com.tencent.mm.model.c.xc()).append(g.m(str.getBytes())).append("_sg.png").toString();
                        case 4:
                            stringBuilder = new StringBuilder();
                            ak.yW();
                            return stringBuilder.append(com.tencent.mm.model.c.xc()).append(g.m(str.getBytes())).append("_sp.png").toString();
                        case 5:
                            stringBuilder = new StringBuilder();
                            ak.yW();
                            return stringBuilder.append(com.tencent.mm.model.c.xc()).append(g.m(str.getBytes())).append("_sl.png").toString();
                        default:
                            v.e("MicroMsg.AppInfoStorage", "getIconPath, unknown iconType = " + i);
                            return null;
                    }
                }
            }
            if (!(file.mkdir() && file.isDirectory())) {
                v.e("MicroMsg.AppInfoStorage", "mkdir error. %s", r3);
                if (i2 != 0) {
                    return null;
                }
                switch (i) {
                    case 1:
                        stringBuilder = new StringBuilder();
                        ak.yW();
                        return stringBuilder.append(com.tencent.mm.model.c.xc()).append(g.m(str.getBytes())).append(".png").toString();
                    case 2:
                        stringBuilder = new StringBuilder();
                        ak.yW();
                        return stringBuilder.append(com.tencent.mm.model.c.xc()).append(g.m(str.getBytes())).append("_wm.png").toString();
                    case 3:
                        stringBuilder = new StringBuilder();
                        ak.yW();
                        return stringBuilder.append(com.tencent.mm.model.c.xc()).append(g.m(str.getBytes())).append("_sg.png").toString();
                    case 4:
                        stringBuilder = new StringBuilder();
                        ak.yW();
                        return stringBuilder.append(com.tencent.mm.model.c.xc()).append(g.m(str.getBytes())).append("_sp.png").toString();
                    case 5:
                        stringBuilder = new StringBuilder();
                        ak.yW();
                        return stringBuilder.append(com.tencent.mm.model.c.xc()).append(g.m(str.getBytes())).append("_sl.png").toString();
                    default:
                        v.e("MicroMsg.AppInfoStorage", "getIconPath, unknown iconType = " + i);
                        return null;
                }
            }
        }
        i2 = 1;
        if (i2 != 0) {
            return null;
        }
        switch (i) {
            case 1:
                stringBuilder = new StringBuilder();
                ak.yW();
                return stringBuilder.append(com.tencent.mm.model.c.xc()).append(g.m(str.getBytes())).append(".png").toString();
            case 2:
                stringBuilder = new StringBuilder();
                ak.yW();
                return stringBuilder.append(com.tencent.mm.model.c.xc()).append(g.m(str.getBytes())).append("_wm.png").toString();
            case 3:
                stringBuilder = new StringBuilder();
                ak.yW();
                return stringBuilder.append(com.tencent.mm.model.c.xc()).append(g.m(str.getBytes())).append("_sg.png").toString();
            case 4:
                stringBuilder = new StringBuilder();
                ak.yW();
                return stringBuilder.append(com.tencent.mm.model.c.xc()).append(g.m(str.getBytes())).append("_sp.png").toString();
            case 5:
                stringBuilder = new StringBuilder();
                ak.yW();
                return stringBuilder.append(com.tencent.mm.model.c.xc()).append(g.m(str.getBytes())).append("_sl.png").toString();
            default:
                v.e("MicroMsg.AppInfoStorage", "getIconPath, unknown iconType = " + i);
                return null;
        }
    }

    public final boolean r(String str, Bitmap bitmap) {
        if (str == null || str.length() == 0 || bitmap == null || bitmap.isRecycled()) {
            v.e("MicroMsg.AppInfoStorage", "saveIcon : invalid argument");
            return false;
        }
        String bB = bB(str, 1);
        if (bB == null) {
            v.e("MicroMsg.AppInfoStorage", "saveIcon fail, iconPath is null");
            return false;
        }
        File file = new File(bB);
        if (file.exists()) {
            file.delete();
        }
        try {
            OutputStream fileOutputStream = new FileOutputStream(file);
            bitmap.compress(CompressFormat.PNG, 100, fileOutputStream);
            fileOutputStream.close();
            Lf(str);
            return true;
        } catch (Throwable e) {
            v.a("MicroMsg.AppInfoStorage", e, SQLiteDatabase.KeyEmpty, new Object[0]);
            v.e("MicroMsg.AppInfoStorage", "saveIcon : compress occurs an exception");
            return false;
        }
    }

    public final boolean d(String str, byte[] bArr, int i) {
        FileOutputStream fileOutputStream;
        Throwable e;
        if (str == null || str.length() == 0 || bArr == null || bArr.length == 0) {
            v.e("MicroMsg.AppInfoStorage", "saveIcon, invalid argument");
            return false;
        }
        String bB = bB(str, i);
        if (bB == null) {
            v.e("MicroMsg.AppInfoStorage", "saveIcon fail, iconPath is null");
            return false;
        }
        File file = new File(bB);
        if (file.exists()) {
            file.delete();
        }
        try {
            fileOutputStream = new FileOutputStream(file);
            try {
                fileOutputStream.write(bArr);
                fileOutputStream.close();
                Lf(str);
                return true;
            } catch (Exception e2) {
                e = e2;
                v.a("MicroMsg.AppInfoStorage", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                v.e("MicroMsg.AppInfoStorage", "saveIcon, exception, e = " + e.getMessage());
                if (fileOutputStream != null) {
                    return false;
                }
                try {
                    fileOutputStream.close();
                    return false;
                } catch (IOException e3) {
                    return false;
                }
            }
        } catch (Exception e4) {
            e = e4;
            fileOutputStream = null;
            v.a("MicroMsg.AppInfoStorage", e, SQLiteDatabase.KeyEmpty, new Object[0]);
            v.e("MicroMsg.AppInfoStorage", "saveIcon, exception, e = " + e.getMessage());
            if (fileOutputStream != null) {
                return false;
            }
            fileOutputStream.close();
            return false;
        }
    }

    public static f bns() {
        f fVar = new f();
        fVar.field_appName = "invalid_appname";
        fVar.field_packageName = SQLiteDatabase.KeyEmpty;
        fVar.field_signature = SQLiteDatabase.KeyEmpty;
        fVar.field_status = 3;
        return fVar;
    }
}
