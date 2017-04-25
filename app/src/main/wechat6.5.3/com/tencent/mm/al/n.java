package com.tencent.mm.al;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.support.v7.a.a.k;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.tencent.mm.loader.stub.b;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.h.g;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.File;
import junit.framework.Assert;

public final class n extends g {
    public static final String[] cic = new String[]{"CREATE TABLE IF NOT EXISTS packageinfo ( id int  PRIMARY KEY, version int  , name text  , size int  , packname text  , status int  , reserved1 text  , reserved2 text  , reserved3 int  , reserved4 int  ) ", "CREATE TABLE IF NOT EXISTS packageinfo2 ( localId text  PRIMARY KEY , id int  , version int  , name text  , size int  , packname text  , status int  , type int  , reserved1 text  , reserved2 text  , reserved3 int  , reserved4 int  ) "};
    public com.tencent.mm.bg.g cuX;

    public n(com.tencent.mm.bg.g gVar) {
        this.cuX = gVar;
    }

    public final boolean a(m mVar) {
        if (mVar == null) {
            return false;
        }
        mVar.bkU = -1;
        if (((int) this.cuX.insert("packageinfo2", "localId", mVar.py())) == -1) {
            return false;
        }
        Ls();
        return true;
    }

    public final boolean b(m mVar) {
        Assert.assertTrue(mVar != null);
        ContentValues py = mVar.py();
        if (py.size() > 0) {
            if (this.cuX.update("packageinfo2", py, "id= ? and type =?", new String[]{mVar.id, mVar.cUv}) > 0) {
                Ls();
                return true;
            }
        }
        Ls();
        return false;
    }

    public final boolean fS(int i) {
        boolean dF = this.cuX.dF("packageinfo2", "update packageinfo2 set status = 2 where status = 1 and type = " + i + ";");
        Ls();
        return dF;
    }

    public final m aK(int i, int i2) {
        m mVar = null;
        Cursor rawQuery = this.cuX.rawQuery("select packageinfo2.localId,packageinfo2.id,packageinfo2.version,packageinfo2.name,packageinfo2.size,packageinfo2.packname,packageinfo2.status,packageinfo2.type,packageinfo2.reserved1,packageinfo2.reserved2,packageinfo2.reserved3,packageinfo2.reserved4 from packageinfo2   where packageinfo2.id = \"" + be.lZ(String.valueOf(i)) + "\" and packageinfo2." + "type = \"" + be.lZ(String.valueOf(i2)) + "\"", null);
        if (rawQuery != null) {
            if (rawQuery.moveToFirst()) {
                mVar = new m();
                mVar.b(rawQuery);
            }
            rawQuery.close();
        }
        return mVar;
    }

    public final boolean fT(int i) {
        if (this.cuX.delete("packageinfo2", "type =?", new String[]{String.valueOf(i)}) <= 0) {
            return false;
        }
        Ls();
        return true;
    }

    public final m[] fU(int i) {
        m[] mVarArr = null;
        Cursor rawQuery = this.cuX.rawQuery("select packageinfo2.localId,packageinfo2.id,packageinfo2.version,packageinfo2.name,packageinfo2.size,packageinfo2.packname,packageinfo2.status,packageinfo2.type,packageinfo2.reserved1,packageinfo2.reserved2,packageinfo2.reserved3,packageinfo2.reserved4 from packageinfo2   where packageinfo2.type=" + i, null);
        int count = rawQuery.getCount();
        v.d("MicroMsg.PackageInfoStorage", "getInfoByType : count:" + count + " type:" + i);
        if (count == 0) {
            rawQuery.close();
        } else {
            mVarArr = new m[count];
            for (int i2 = 0; i2 < count; i2++) {
                rawQuery.moveToPosition(i2);
                m mVar = new m();
                mVar.b(rawQuery);
                mVarArr[i2] = mVar;
            }
            rawQuery.close();
        }
        return mVarArr;
    }

    public static String HO() {
        ak.yW();
        return c.xb();
    }

    public static String aL(int i, int i2) {
        return i + "_" + i2 + "_thumb.jpg";
    }

    public final String aM(int i, int i2) {
        switch (i2) {
            case 0:
                return SQLiteDatabase.KeyEmpty;
            case 1:
                return i + "_session_bg.zip";
            case 2:
                return i + "_emoji_art.temp";
            case 5:
                return "brand_i18n.apk";
            case 7:
                return i + "_configlist.cfg";
            case 8:
                return i + "_regiondata.temp";
            case 9:
                return "_speex_upload.cfg";
            case 12:
                return "_rcpt_addr";
            case k.MG /*18*/:
                return aK(i, i2).version + "_feature.zip";
            case 19:
                return "_report_reason.temp";
            case 20:
                return "_pluginDesc.cfg";
            case 21:
                return "_trace_config.cfg";
            case k.Nb /*23*/:
                return "permissioncfg.cfg";
            case k.Kr /*26*/:
                return "ipcallCountryCodeConfig.cfg";
            case 36:
                return i + "_sensewhere.xml";
            default:
                return SQLiteDatabase.KeyEmpty;
        }
    }

    public final String aN(int i, int i2) {
        String stringBuilder;
        switch (i2) {
            case 0:
                return SQLiteDatabase.KeyEmpty;
            case 1:
                StringBuilder stringBuilder2 = new StringBuilder();
                ak.yW();
                stringBuilder = stringBuilder2.append(c.xb()).append(i).append("_session_bg/").toString();
                try {
                    File file = new File(stringBuilder);
                    if (file.exists()) {
                        return stringBuilder;
                    }
                    file.mkdirs();
                    return stringBuilder;
                } catch (Throwable e) {
                    v.e("MicroMsg.PackageInfoStorage", "exception:%s", be.e(e));
                    v.e("MicroMsg.PackageInfoStorage", "can not create dir, dir = " + stringBuilder);
                    return stringBuilder;
                }
            case 2:
                return SQLiteDatabase.KeyEmpty;
            case k.MG /*18*/:
                stringBuilder = aM(i, i2);
                StringBuilder stringBuilder3 = new StringBuilder();
                ak.yW();
                return stringBuilder3.append(c.xb()).append(stringBuilder.replace(".zip", SQLiteDatabase.KeyEmpty)).toString();
            default:
                return SQLiteDatabase.KeyEmpty;
        }
    }

    public final void aO(int i, int i2) {
        StringBuilder stringBuilder = new StringBuilder();
        ak.yW();
        b.deleteFile(stringBuilder.append(c.xb()).append(aM(i, i2)).toString());
        m aK = aK(i, i2);
        if (aK != null) {
            aK.status = 5;
            t.HS().b(aK);
        }
    }

    public static int aU(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        int i = displayMetrics.heightPixels > displayMetrics.widthPixels ? 1 : 0;
        if (displayMetrics.density <= 1.0f) {
            if (i != 0) {
                return 4;
            }
            return 2;
        } else if (i != 0) {
            return 3;
        } else {
            return 1;
        }
    }

    public static String z(String str, boolean z) {
        if (z) {
            StringBuilder stringBuilder = new StringBuilder();
            ak.yW();
            return stringBuilder.append(c.xb()).append(str).append("_chatting_bg_vertical.jpg").toString();
        }
        stringBuilder = new StringBuilder();
        ak.yW();
        return stringBuilder.append(c.xb()).append(str).append("_chatting_bg_horizontal.jpg").toString();
    }

    public final String x(String str, int i) {
        switch (i) {
            case 1:
            case 2:
                return z(str, false);
            case 3:
            case 4:
                return z(str, true);
            default:
                return null;
        }
    }
}
