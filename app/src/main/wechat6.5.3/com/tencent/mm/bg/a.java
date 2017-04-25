package com.tencent.mm.bg;

import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.preference.PreferenceManager;
import com.tencent.mm.a.e;
import com.tencent.mm.a.g;
import com.tencent.mm.bg.g.c;
import com.tencent.mm.compatible.d.k;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.plugin.report.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import junit.framework.Assert;

public final class a {
    private static final Pattern nxr = Pattern.compile("^[\\s]*CREATE[\\s]+TABLE[\\s]*", 2);
    String apU;
    private String biS = SQLiteDatabase.KeyEmpty;
    e nxs;
    String nxt = SQLiteDatabase.KeyEmpty;
    public boolean nxu = false;
    String nxv = SQLiteDatabase.KeyEmpty;

    public final String bxV() {
        if (be.kS(this.biS) || be.kS(this.nxv)) {
            return SQLiteDatabase.KeyEmpty;
        }
        if (!be.kS(com.tencent.mm.sdk.h.a.getValue(this.nxv, "Reported"))) {
            return SQLiteDatabase.KeyEmpty;
        }
        com.tencent.mm.sdk.h.a.X(this.nxv, "Reported", "true");
        return this.biS;
    }

    private void dS(String str, String str2) {
        Set hashSet = new HashSet();
        String str3 = SQLiteDatabase.KeyEmpty;
        Cursor rawQuery = this.nxs.rawQuery("select * from " + str + " limit 1 ", null);
        if (rawQuery.getCount() == 0) {
            rawQuery.close();
            return;
        }
        rawQuery.moveToFirst();
        for (int i = 0; i < rawQuery.getColumnCount(); i++) {
            hashSet.add(rawQuery.getColumnName(i));
        }
        rawQuery.close();
        rawQuery = this.nxs.rawQuery("PRAGMA table_info( " + str2 + " )", null);
        String str4 = str3;
        while (rawQuery.moveToNext()) {
            str3 = rawQuery.getString(rawQuery.getColumnIndex("name"));
            if (hashSet.contains(str3)) {
                str4 = (str4 + str3) + ",";
            }
        }
        rawQuery.close();
        str4 = str4.substring(0, str4.length() - 1);
        this.nxs.execSQL("insert into " + str2 + "(" + str4 + ") select " + str4 + " from " + str + ";");
    }

    private boolean dT(String str, String str2) {
        Cursor rawQuery = this.nxs.rawQuery("select DISTINCT  tbl_name from sqlite_master;", null);
        if (rawQuery == null) {
            return false;
        }
        if (be.kS(str2)) {
            this.nxs.execSQL("ATTACH DATABASE '" + str + "' AS old KEY ''");
        } else {
            this.nxs.execSQL("ATTACH DATABASE '" + str + "' AS old KEY '" + str2 + "'");
        }
        this.nxs.beginTransaction();
        for (int i = 0; i < rawQuery.getCount(); i++) {
            int count;
            rawQuery.moveToPosition(i);
            Cursor rawQuery2 = this.nxs.rawQuery("select * from old.sqlite_master where tbl_name = '" + rawQuery.getString(0) + "'", null);
            if (rawQuery2 != null) {
                count = rawQuery2.getCount();
                rawQuery2.close();
            } else {
                count = 0;
            }
            if (count == 0) {
                v.w("MicroMsg.DBInit", "In old db not found :" + rawQuery.getString(0));
            } else {
                try {
                    dS("old." + rawQuery.getString(0), rawQuery.getString(0));
                } catch (Exception e) {
                    v.w("MicroMsg.DBInit", "Insertselect FAILED :" + rawQuery.getString(0));
                }
            }
        }
        this.nxs.endTransaction();
        rawQuery.close();
        this.nxs.execSQL("DETACH DATABASE old;");
        return true;
    }

    public final boolean a(String str, HashMap<Integer, c> hashMap, boolean z, boolean z2) {
        boolean z3 = false;
        if (this.nxs != null) {
            this.nxs.close();
            this.nxs = null;
        }
        boolean aR = e.aR(str);
        this.nxs = e.aJ(str, z2);
        v.i("MicroMsg.DBInit", "initSysDB checkini:%b exist:%b db:%s ", Boolean.valueOf(z), Boolean.valueOf(aR), str);
        if (this.nxs == null) {
            return false;
        }
        if (!aR) {
            z3 = true;
        }
        a(hashMap, z, z3);
        return true;
    }

    public final boolean a(String str, String str2, String str3, long j, String str4, HashMap<Integer, c> hashMap, boolean z) {
        Object obj;
        Assert.assertTrue("create SqliteDB enDbCachePath == null ", !be.kS(str2));
        this.nxv = str2 + ".errreport";
        if (this.nxs != null) {
            this.nxs.close();
            this.nxs = null;
        }
        boolean aR = e.aR(str2);
        boolean z2 = !aR || NN(str2) > 2;
        boolean aR2 = e.aR(str);
        boolean aR3 = e.aR(str3);
        Object obj2 = (aR || !aR2) ? null : 1;
        Object obj3 = null;
        this.nxu = d(str2, j, str4);
        String str5 = "MicroMsg.DBInit";
        String str6 = "initDb(en) path:%s enExist:%b oldExist:%b copyold:%b dbopenSUCC:%b db:%b thr:%s";
        Object[] objArr = new Object[7];
        objArr[0] = str2;
        objArr[1] = Boolean.valueOf(aR);
        objArr[2] = Boolean.valueOf(aR2);
        objArr[3] = Boolean.valueOf(true);
        objArr[4] = Boolean.valueOf(this.nxu);
        objArr[5] = Boolean.valueOf(this.nxs != null);
        objArr[6] = Thread.currentThread().getName();
        v.i(str5, str6, objArr);
        if (this.nxs == null) {
            str4 = p.getDeviceID(aa.getContext());
            this.nxu = d(str2, j, str4);
            if (this.nxs != null) {
                k.rv().set(258, str4);
                b.itm.a(181, 5, 1, false);
            }
        }
        if (this.nxs == null && !be.kS(str3)) {
            v.i("MicroMsg.DBInit", "en DB cannot open ,use backup");
            this.nxu = d(str3, j, str4);
            if (aR2) {
                obj3 = 1;
                obj2 = 1;
            } else {
                obj3 = obj2;
                obj2 = null;
            }
            Object obj4;
            if (this.nxs != null) {
                b.itm.a(181, 6, 1, false);
                obj = null;
                obj4 = obj3;
                obj3 = obj2;
                obj2 = obj4;
            } else {
                b.itm.a(181, 7, 1, false);
                obj = null;
                obj4 = obj3;
                obj3 = obj2;
                obj2 = obj4;
            }
        } else if (this.nxs == null || !aR3) {
            obj = null;
        } else {
            obj = 1;
            v.i("MicroMsg.DBInit", "backup db exsits,copy data to en db");
        }
        a(hashMap, z, z2);
        if (!aR2 && !aR3) {
            return true;
        }
        if (obj != null) {
            this.apU = g.m((str4 + j).getBytes()).substring(0, 7);
            dU(str3, this.apU);
        }
        if (obj2 != null) {
            long currentTimeMillis = System.currentTimeMillis();
            boolean dU = dU(str, SQLiteDatabase.KeyEmpty);
            currentTimeMillis = System.currentTimeMillis() - currentTimeMillis;
            if (obj3 != null) {
                b bVar = b.itm;
                Object[] objArr2 = new Object[2];
                objArr2[0] = Integer.valueOf(dU ? 1 : 2);
                objArr2[1] = Long.valueOf(currentTimeMillis);
                bVar.h(11692, objArr2);
            }
            return dU;
        } else if (this.nxs != null) {
            return true;
        } else {
            return false;
        }
    }

    private boolean dU(String str, String str2) {
        if (dT(str, str2)) {
            v.i("MicroMsg.DBInit", "system transfer success ,delete it path %s", str);
            v.i("MicroMsg.DBInit", "delete result :%b", Boolean.valueOf(com.tencent.mm.loader.stub.b.deleteFile(str)));
            return true;
        }
        v.i("MicroMsg.DBInit", "system transfer fail path %s", str);
        return false;
    }

    private boolean d(String str, long j, String str2) {
        int NN = NN(str);
        Editor edit = PreferenceManager.getDefaultSharedPreferences(aa.getContext()).edit();
        if (NN > 2) {
            v.e("MicroMsg.DBInit", "db crash count extends limit ,rename db ");
            e.renameTo(new File(str), new File(str + "err" + be.Ni()));
            edit.putInt(str, 0).commit();
            b.itm.h(11670, new Object[0]);
            b.itm.a(181, 2, 1, false);
        }
        this.apU = g.m((str2 + j).getBytes()).substring(0, 7);
        this.nxs = e.d(str, this.apU, 1, false);
        if (this.nxs == null) {
            b.itm.a(181, 0, 1, false);
            this.biS = "Endbinit open failed: [" + j + "] dev: [" + str2 + "]";
            return false;
        }
        if (NN == 1) {
            int i = NN + 1;
            String str3 = "MicroMsg.DBInit";
            String str4 = "check db Integrity %b";
            Object[] objArr = new Object[1];
            e eVar = this.nxs;
            boolean isDatabaseIntegrityOk = eVar.nxA != null ? eVar.nxA.isDatabaseIntegrityOk() : eVar.nxB != null ? eVar.nxB.isDatabaseIntegrityOk() : false;
            objArr[0] = Boolean.valueOf(isDatabaseIntegrityOk);
            v.i(str3, str4, objArr);
            edit.putInt(str, i).commit();
        }
        try {
            Cursor rawQuery = this.nxs.rawQuery("select count(*) from sqlite_master limit 1;", null);
            rawQuery.moveToNext();
            v.i("MicroMsg.DBInit", "openEncryptDatabase check master tables:%d", Integer.valueOf(rawQuery.getInt(0)));
            if (rawQuery != null) {
                rawQuery.close();
            }
            return true;
        } catch (Exception e) {
            b.itm.a(181, 1, 1, false);
            v.e("MicroMsg.DBInit", "Check EnDB Key failed :" + e.getMessage());
            this.biS = "Endbinit check failed: [" + j + "] dev: [" + str2 + "] msg:[" + e.getMessage() + "] stack:[" + e.getStackTrace() + "]";
            try {
                this.nxs.close();
            } catch (Exception e2) {
            }
            this.nxs = null;
            this.apU = null;
            return false;
        }
    }

    private static int NN(String str) {
        return PreferenceManager.getDefaultSharedPreferences(aa.getContext()).getInt(str, 0);
    }

    private boolean a(HashMap<Integer, c> hashMap, boolean z, boolean z2) {
        int i;
        int i2;
        String str = "MicroMsg.DBInit";
        String str2 = "createtables checkCreateIni:%b  tables:%d";
        Object[] objArr = new Object[2];
        objArr[0] = Boolean.valueOf(z);
        objArr[1] = Integer.valueOf(hashMap == null ? -1 : hashMap.size());
        v.d(str, str2, objArr);
        String str3 = SQLiteDatabase.KeyEmpty;
        if (z) {
            this.nxt = this.nxs.getPath() + ".ini";
            StringBuilder stringBuilder = new StringBuilder();
            if (hashMap != null) {
                for (c cVar : hashMap.values()) {
                    if (cVar.pS() == null) {
                        v.e("MicroMsg.DBInit", "factory.getSQLs() is null: %s", cVar.getClass().toString());
                        Assert.assertTrue("factory.getSQLs() is null:" + cVar.getClass().toString(), false);
                    }
                    for (String hashCode : cVar.pS()) {
                        stringBuilder.append(hashCode.hashCode());
                    }
                }
            }
            str3 = g.m(stringBuilder.toString().getBytes());
            if (!z2) {
                str = com.tencent.mm.sdk.h.a.getValue(this.nxt, "createmd5");
                if (!be.kS(str) && str3.equals(str)) {
                    v.i("MicroMsg.DBInit", "Create table factories not changed , no need create !  %s", this.nxs.getPath());
                    return true;
                }
            }
        }
        str = str3;
        this.nxs.execSQL("pragma auto_vacuum = 0 ");
        this.nxs.rawQuery("pragma journal_mode=\"WAL\"", null).close();
        com.tencent.mm.compatible.util.g.a aVar = new com.tencent.mm.compatible.util.g.a();
        this.nxs.beginTransaction();
        if (hashMap != null) {
            i2 = 0;
            for (c pS : hashMap.values()) {
                i = i2;
                for (String str4 : pS.pS()) {
                    try {
                        this.nxs.execSQL(str4);
                        i++;
                    } catch (Exception e) {
                        Matcher matcher = nxr.matcher(str4);
                        if (matcher == null || !matcher.matches()) {
                            v.f("MicroMsg.DBInit", "CreateTable failed:[" + str4 + "][" + e.getMessage() + "]");
                        } else {
                            Assert.assertTrue("CreateTable failed:[" + str4 + "][" + e.getMessage() + "]", false);
                        }
                    }
                }
                i2 = i;
            }
        } else {
            i2 = 0;
        }
        long sn = aVar.sn();
        this.nxs.endTransaction();
        v.i("MicroMsg.DBInit", "createtables end sql:%d trans:%d sqlCount:%d", Long.valueOf(sn), Long.valueOf(aVar.sn()), Integer.valueOf(i2));
        if (z) {
            com.tencent.mm.sdk.h.a.X(this.nxt, "createmd5", str);
        }
        return true;
    }
}
