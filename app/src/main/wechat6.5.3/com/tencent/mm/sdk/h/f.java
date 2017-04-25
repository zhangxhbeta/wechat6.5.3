package com.tencent.mm.sdk.h;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.h.c.a;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import junit.framework.Assert;

public abstract class f<T extends c> extends g {
    private final d cie;
    public int field_MARK_CURSOR_CHECK_IGNORE = 1;
    public final a nmf;
    private final String nmg;

    public f(d dVar, a aVar, String str, String[] strArr) {
        int i = 0;
        this.cie = dVar;
        this.nmf = aVar;
        this.nmf.nmc = be.kS(this.nmf.nmc) ? "rowid" : this.nmf.nmc;
        this.nmg = str;
        List a = a(this.nmf, getTableName(), this.cie);
        for (int i2 = 0; i2 < a.size(); i2++) {
            this.cie.dF(this.nmg, (String) a.get(i2));
        }
        if (strArr != null && strArr.length > 0) {
            while (i < strArr.length) {
                this.cie.dF(this.nmg, strArr[i]);
                i++;
            }
        }
    }

    public String getTableName() {
        return this.nmg;
    }

    public static String a(a aVar, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CREATE TABLE IF NOT EXISTS " + str + " ( ");
        stringBuilder.append(aVar.nme);
        stringBuilder.append(");");
        return stringBuilder.toString();
    }

    public static List<String> a(a aVar, String str, d dVar) {
        List<String> linkedList = new LinkedList();
        if (dVar == null || str == null) {
            boolean z;
            String str2 = "MicroMsg.SDK.MAutoStorage";
            String str3 = "dk getUpdateSQLs db==null :%b  table:%s";
            Object[] objArr = new Object[2];
            if (dVar == null) {
                z = true;
            } else {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            objArr[1] = str;
            v.e(str2, str3, objArr);
            return linkedList;
        }
        Cursor rawQuery = dVar.rawQuery("PRAGMA table_info( " + str + " )", new String[0]);
        if (rawQuery == null) {
            return linkedList;
        }
        Map hashMap = new HashMap();
        while (rawQuery.moveToNext()) {
            hashMap.put(rawQuery.getString(rawQuery.getColumnIndex("name")), rawQuery.getString(rawQuery.getColumnIndex("type")));
        }
        rawQuery.close();
        for (Entry entry : aVar.nmd.entrySet()) {
            String str4 = (String) entry.getValue();
            String str5 = (String) entry.getKey();
            if (str4 != null && str4.length() > 0) {
                String str6 = (String) hashMap.get(str5);
                if (str6 == null) {
                    linkedList.add("ALTER TABLE " + str + " ADD COLUMN " + str5 + " " + str4 + ";");
                    hashMap.remove(str5);
                } else if (!str4.toLowerCase().startsWith(str6.toLowerCase())) {
                    v.e("MicroMsg.SDK.MAutoStorage", "conflicting alter table on column: " + str5 + ", " + str6 + "<o-n>" + str4);
                    hashMap.remove(str5);
                }
            }
        }
        return linkedList;
    }

    public final boolean dF(String str, String str2) {
        if (str.length() == 0) {
            Le("null or nill table");
            return false;
        } else if (str2 != null && str2.length() != 0) {
            return this.cie.dF(str, str2);
        } else {
            Le("null or nill sql");
            return false;
        }
    }

    public boolean b(T t) {
        return a((c) t, true);
    }

    public final boolean a(T t, boolean z) {
        ContentValues py = t.py();
        if (py == null || py.size() <= 0) {
            Le("insert failed, value.size <= 0");
            return false;
        }
        t.nmb = this.cie.insert(getTableName(), this.nmf.nmc, py);
        if (t.nmb <= 0) {
            Le("insert failed");
            return false;
        }
        py.put("rowid", Long.valueOf(t.nmb));
        if (z) {
            Lf(py.getAsString(this.nmf.nmc));
        }
        return true;
    }

    public final boolean a(T t, boolean z, String... strArr) {
        boolean z2 = false;
        ContentValues py = t.py();
        if (py == null || py.size() <= 0) {
            Le("delete failed, value.size <= 0");
            return false;
        } else if (strArr == null || strArr.length <= 0) {
            Ld("delete with primary key");
            if (this.cie.delete(getTableName(), this.nmf.nmc + " = ?", new String[]{be.ma(py.getAsString(this.nmf.nmc))}) > 0) {
                z2 = true;
            }
            if (!z2 || !z) {
                return z2;
            }
            Ls();
            return z2;
        } else {
            StringBuilder a = a(py, strArr);
            if (a == null) {
                Le("delete failed, check keys failed");
                return false;
            } else if (this.cie.delete(getTableName(), a.toString(), a(strArr, py)) <= 0 || !z) {
                Le("delete failed");
                return false;
            } else {
                Lf(this.nmf.nmc);
                return true;
            }
        }
    }

    public boolean c(T t, String... strArr) {
        return a((c) t, true, strArr);
    }

    public boolean delete(long j) {
        boolean z = true;
        if (this.cie.delete(getTableName(), "rowid = ?", new String[]{String.valueOf(j)}) <= 0) {
            z = false;
        }
        if (z) {
            Ls();
        }
        return z;
    }

    public final boolean b(long j, T t) {
        Cursor query = this.cie.query(getTableName(), this.nmf.bXK, "rowid = ?", new String[]{String.valueOf(j)}, null, null, null);
        if (query.moveToFirst()) {
            t.b(query);
            query.close();
            return true;
        }
        query.close();
        return false;
    }

    public boolean b(T t, String... strArr) {
        ContentValues py = t.py();
        if (py == null || py.size() <= 0) {
            Le("get failed, value.size <= 0");
            return false;
        } else if (strArr == null || strArr.length <= 0) {
            Ld("get with primary key");
            r0 = this.cie.query(getTableName(), this.nmf.bXK, this.nmf.nmc + " = ?", new String[]{be.ma(py.getAsString(this.nmf.nmc))}, null, null, null);
            if (r0.moveToFirst()) {
                t.b(r0);
                r0.close();
                return true;
            }
            r0.close();
            return false;
        } else {
            StringBuilder a = a(py, strArr);
            if (a == null) {
                Le("get failed, check keys failed");
                return false;
            }
            r0 = this.cie.query(getTableName(), this.nmf.bXK, a.toString(), a(strArr, py), null, null, null);
            if (r0.moveToFirst()) {
                t.b(r0);
                r0.close();
                return true;
            }
            r0.close();
            Ld("get failed, not found");
            return false;
        }
    }

    public boolean a(long j, T t) {
        ContentValues py = t.py();
        if (py == null || py.size() <= 0) {
            Le("update failed, value.size <= 0");
            return false;
        }
        Cursor query = this.cie.query(getTableName(), this.nmf.bXK, "rowid = ?", new String[]{String.valueOf(j)}, null, null, null);
        if (c.a(py, query)) {
            query.close();
            Ld("no need replace , fields no change");
            return true;
        }
        query.close();
        boolean z = this.cie.update(getTableName(), py, "rowid = ?", new String[]{String.valueOf(j)}) > 0;
        if (!z) {
            return z;
        }
        Ls();
        return z;
    }

    public final boolean b(T t, boolean z, String... strArr) {
        boolean z2 = false;
        ContentValues py = t.py();
        if (py == null || py.size() <= 0) {
            Le("update failed, value.size <= 0");
            return false;
        } else if (strArr == null || strArr.length <= 0) {
            Ld("update with primary key");
            if (a(py)) {
                Ld("no need replace , fields no change");
                return true;
            }
            if (this.cie.update(getTableName(), py, this.nmf.nmc + " = ?", new String[]{be.ma(py.getAsString(this.nmf.nmc))}) > 0) {
                z2 = true;
            }
            if (!z2 || !z) {
                return z2;
            }
            Ls();
            return z2;
        } else {
            StringBuilder a = a(py, strArr);
            if (a == null) {
                Le("update failed, check keys failed");
                return false;
            } else if (this.cie.update(getTableName(), py, a.toString(), a(strArr, py)) > 0) {
                if (z) {
                    Lf(py.getAsString(this.nmf.nmc));
                }
                return true;
            } else {
                Le("update failed");
                return false;
            }
        }
    }

    public boolean a(T t, String... strArr) {
        return b(t, true, strArr);
    }

    public boolean a(T t) {
        Assert.assertTrue("replace primaryKey == null", !be.kS(this.nmf.nmc));
        ContentValues py = t.py();
        if (py != null) {
            int i;
            int size = py.size();
            int length = t.tl().ddU.length;
            if (py.containsKey("rowid")) {
                i = 1;
            } else {
                i = 0;
            }
            if (size == i + length) {
                if (a(py)) {
                    Ld("no need replace , fields no change");
                    return true;
                } else if (this.cie.replace(getTableName(), this.nmf.nmc, py) > 0) {
                    Lf(this.nmf.nmc);
                    return true;
                } else {
                    Le("replace failed");
                    return false;
                }
            }
        }
        Le("replace failed, cv.size() != item.fields().length");
        return false;
    }

    private boolean a(ContentValues contentValues) {
        Cursor query = this.cie.query(getTableName(), this.nmf.bXK, this.nmf.nmc + " = ?", new String[]{be.ma(contentValues.getAsString(this.nmf.nmc))}, null, null, null);
        boolean a = c.a(contentValues, query);
        query.close();
        return a;
    }

    public Cursor Kp() {
        return this.cie.query(getTableName(), this.nmf.bXK, null, null, null, null, null);
    }

    public int getCount() {
        Cursor rawQuery = rawQuery("select count(*) from " + getTableName(), new String[0]);
        if (rawQuery == null) {
            return 0;
        }
        rawQuery.moveToFirst();
        int i = rawQuery.getInt(0);
        rawQuery.close();
        return i;
    }

    public final Cursor rawQuery(String str, String... strArr) {
        return this.cie.rawQuery(str, strArr);
    }

    private static StringBuilder a(ContentValues contentValues, String... strArr) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : strArr) {
            stringBuilder.append(str + " = ? AND ");
            if (contentValues.get(str) == null) {
                return null;
            }
        }
        stringBuilder.append(" 1=1");
        return stringBuilder;
    }

    private static String[] a(String[] strArr, ContentValues contentValues) {
        String[] strArr2 = new String[strArr.length];
        for (int i = 0; i < strArr2.length; i++) {
            strArr2[i] = be.ma(contentValues.getAsString(strArr[i]));
        }
        return strArr2;
    }

    private void Ld(String str) {
        v.d("MicroMsg.SDK.MAutoStorage", getTableName() + ":" + str);
    }

    private void Le(String str) {
        v.e("MicroMsg.SDK.MAutoStorage", getTableName() + ":" + str);
    }
}
