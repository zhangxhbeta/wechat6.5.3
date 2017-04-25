package com.tencent.mm.bg;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.mm.sdk.h.d;
import com.tencent.mm.sdk.i.e;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import com.tencent.mmdb.repair.DBDumpUtil;
import com.tencent.mmdb.repair.DBDumpUtil.ExecuteSqlCallback;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public class g implements d {
    String TAG = "MicroMsg.SqliteDB";
    private long ejX = 0;
    public int field_MARK_CURSOR_CHECK_IGNORE = 1;
    private a nxJ = null;
    public a nxK = new a();
    private String nxL = SQLiteDatabase.KeyEmpty;
    public String nxM = SQLiteDatabase.KeyEmpty;
    LinkedList<b> nxN = new LinkedList();
    private ac nxO = null;
    protected e nxs = null;

    public interface a {
        void vl();

        void vm();

        void vn();
    }

    public static class b {
        public long ctO;
        public String nmg;
        public Cursor nxS;
        public String nxT;
        public long nxU;
        public boolean nxV;
        public String nxW;
    }

    public interface c {
        String[] pS();
    }

    public g(a aVar) {
        this.nxJ = aVar;
    }

    protected void finalize() {
        cQ(null);
    }

    public void wB() {
        cQ(null);
    }

    public void cQ(String str) {
        if (this.nxs != null) {
            if (this.nxJ != null) {
                this.nxJ.vl();
            }
            v.w(this.TAG, "begin close db, inTrans:%b ticket:%s  thr:%d {%s}", Boolean.valueOf(inTransaction()), Long.toHexString(this.ejX), Long.valueOf(Thread.currentThread().getId()), be.bur());
            com.tencent.mm.compatible.util.g.a aVar = new com.tencent.mm.compatible.util.g.a();
            if (str != null) {
                this.nxL = str;
            }
            this.nxs.close();
            this.nxs = null;
            v.d(this.TAG, "end close db time:%d", Long.valueOf(aVar.sn()));
        }
    }

    public final boolean buA() {
        return this.nxs == null || !this.nxs.isOpen();
    }

    private void NP(String str) {
        String processName = aa.getProcessName();
        String packageName = aa.getPackageName();
        v.i(this.TAG, "check process :[%s] [%s] path[%s]", processName, packageName, str);
        if (processName != null && packageName != null && !packageName.equals(processName)) {
            Assert.assertTrue("processName:" + processName + "  packagename:" + packageName, false);
        }
    }

    public final boolean b(String str, HashMap<Integer, c> hashMap, boolean z, boolean z2) {
        int lastIndexOf = str.lastIndexOf("/");
        if (lastIndexOf != -1) {
            this.TAG += "." + str.substring(lastIndexOf + 1);
        }
        NP(str);
        if (!this.nxK.a(str, hashMap, true, z2) || this.nxK.nxs == null) {
            this.nxs = null;
            this.nxK = null;
            v.e(this.TAG, "initDB failed.");
            return false;
        }
        this.nxs = this.nxK.nxs;
        return true;
    }

    public final boolean a(String str, String str2, String str3, long j, String str4, HashMap<Integer, c> hashMap, boolean z) {
        int lastIndexOf = str.lastIndexOf("/");
        if (lastIndexOf != -1) {
            this.TAG += "." + str.substring(lastIndexOf + 1);
        }
        NP(str2);
        if (!this.nxK.a(str, str2, str3, j, str4, hashMap, z) || this.nxK.nxs == null) {
            this.nxM = this.nxK.bxV();
            this.nxs = null;
            this.nxK = null;
            v.i(this.TAG, "initDB failed. %s", this.nxM);
            return false;
        }
        this.nxM = this.nxK.bxV();
        this.nxs = this.nxK.nxs;
        return true;
    }

    public final boolean a(String str, String str2, long j, String str3, HashMap<Integer, c> hashMap) {
        return a(str, str2, SQLiteDatabase.KeyEmpty, j, str3, hashMap, true);
    }

    public final boolean isOpen() {
        if (this.nxs != null && this.nxs.isOpen()) {
            return true;
        }
        Assert.assertTrue("DB has been closed :[" + this.nxL + "]", be.kS(this.nxL));
        return false;
    }

    public final String getKey() {
        if (this.nxK == null) {
            return null;
        }
        return this.nxK.apU;
    }

    public final String getPath() {
        if (isOpen()) {
            return this.nxs.getPath();
        }
        v.e(this.TAG, "DB IS CLOSED ! {%s}", be.bur());
        return null;
    }

    public static String dM(String str) {
        if (be.kS(str)) {
            return SQLiteDatabase.KeyEmpty;
        }
        return DatabaseUtils.sqlEscapeString(str);
    }

    private synchronized void b(final Cursor cursor, final String str) {
        if (com.tencent.mm.sdk.b.b.bsG() || com.tencent.mm.sdk.b.b.bsI()) {
            if (this.nxO == null) {
                HandlerThread Lg = e.Lg("CheckCursor");
                Lg.start();
                this.nxO = new ac(Lg.getLooper());
            }
            final StackTraceElement[] stackTrace = new Throwable().getStackTrace();
            this.nxO.postDelayed(new Runnable(this) {
                final /* synthetic */ g nxR;

                public final void run() {
                    try {
                        long Ni = be.Ni();
                        if (cursor != null && !cursor.isClosed()) {
                            Pair pair;
                            String str;
                            int i;
                            String className;
                            HashMap hashMap = new HashMap();
                            int i2 = 0;
                            Iterator it = this.nxR.nxN.iterator();
                            while (it.hasNext()) {
                                b bVar = (b) it.next();
                                if (bVar == null || bVar.nxS == null || bVar.nxS.isClosed()) {
                                    it.remove();
                                } else {
                                    if ((Ni - bVar.ctO) / 1000 > 100) {
                                        bVar.ctO = Ni;
                                        if (!bVar.nxV) {
                                            v.w(this.nxR.TAG, "CheckCursorRES time:%d MSG: NOTCLOSE cu:%s caller:%s outCu:%b kw:%s", Long.valueOf(Ni - bVar.nxU), Integer.valueOf(bVar.nxS.hashCode()), bVar.nxT, Boolean.valueOf(bVar.nxV), bVar.nxW);
                                        } else if (TextUtils.isEmpty(bVar.nxW)) {
                                            v.w(this.nxR.TAG, "CheckCursorRES time:%d MSG: BadOut cu:%s caller:%s outCu:%b kw:%s", Long.valueOf(Ni - bVar.nxU), Integer.valueOf(bVar.nxS.hashCode()), bVar.nxT, Boolean.valueOf(bVar.nxV), bVar.nxW);
                                        } else {
                                            v.w(this.nxR.TAG, "CheckCursorRES time:%d MSG: Adapter cu:%s caller:%s outCu:%b kw:%s", Long.valueOf(Ni - bVar.nxU), Integer.valueOf(bVar.nxS.hashCode()), bVar.nxT, Boolean.valueOf(bVar.nxV), bVar.nxW);
                                        }
                                    }
                                    pair = (Pair) hashMap.get(bVar.nxT);
                                    if (pair == null) {
                                        str = bVar.nxT;
                                        if (Ni - bVar.nxU > 30000) {
                                            i = 1;
                                        } else {
                                            i = 0;
                                        }
                                        hashMap.put(str, new Pair(Integer.valueOf(i), bVar));
                                    } else {
                                        int intValue;
                                        if (Ni - bVar.nxU > 30000) {
                                            hashMap.put(bVar.nxT, new Pair(Integer.valueOf(((Integer) pair.first).intValue() + 1), bVar));
                                            if (i2 < ((Integer) pair.first).intValue() + 1) {
                                                intValue = ((Integer) pair.first).intValue() + 1;
                                            } else {
                                                intValue = i2;
                                            }
                                        } else {
                                            intValue = i2;
                                        }
                                        i2 = intValue;
                                    }
                                }
                            }
                            v.d(this.nxR.TAG, "CheckCursor: checkAss max:%d list:%d map:%d", Integer.valueOf(i2), Integer.valueOf(this.nxR.nxN.size()), Integer.valueOf(hashMap.size()));
                            if (i2 <= (com.tencent.mm.sdk.b.b.bsG() ? 20 : 50)) {
                                if (this.nxR.nxN.size() <= (com.tencent.mm.sdk.b.b.bsG() ? 50 : 100)) {
                                    long Ni2 = be.Ni();
                                    b bVar2 = new b();
                                    bVar2.nxS = cursor;
                                    bVar2.nmg = str;
                                    bVar2.nxU = Ni;
                                    bVar2.nxT = SQLiteDatabase.KeyEmpty;
                                    bVar2.nxV = true;
                                    for (i = 0; i < stackTrace.length; i++) {
                                        Object obj;
                                        className = stackTrace[i].getClassName();
                                        String methodName = stackTrace[i].getMethodName();
                                        str = className.replace("com.tencent.mm.", SQLiteDatabase.KeyEmpty) + ":" + methodName + "(" + stackTrace[i].getLineNumber() + ")";
                                        Class cls = Class.forName(className);
                                        try {
                                            obj = cls.getDeclaredField("field_MARK_CURSOR_CHECK_IGNORE") != null ? 1 : null;
                                        } catch (Exception e) {
                                            obj = null;
                                        }
                                        if (obj == null) {
                                            if (!TextUtils.isEmpty(bVar2.nxT)) {
                                                if (!bVar2.nxV) {
                                                    break;
                                                }
                                                className = str.toLowerCase();
                                                if (className.contains("cursor") || className.contains("adapter")) {
                                                    bVar2.nxW = str;
                                                }
                                            } else {
                                                bVar2.nxT = str;
                                                boolean z = false;
                                                for (Method method : cls.getMethods()) {
                                                    if (method.getName().equals(methodName)) {
                                                        z = method.getReturnType().getName().contains(".Cursor");
                                                        if (z) {
                                                            break;
                                                        }
                                                    }
                                                }
                                                bVar2.nxV = z;
                                            }
                                        }
                                    }
                                    if (TextUtils.isEmpty(bVar2.nxT)) {
                                        bVar2.nxT = af.b(stackTrace);
                                    }
                                    this.nxR.nxN.add(bVar2);
                                    v.d(this.nxR.TAG, "checkCursor insert [%d,%d] caller:%s outCu:%b kw:%s", Long.valueOf(Ni2 - Ni), Long.valueOf(be.ay(Ni)), bVar2.nxT, Boolean.valueOf(bVar2.nxV), bVar2.nxW);
                                    return;
                                }
                            }
                            className = SQLiteDatabase.KeyEmpty;
                            str = className;
                            for (String className2 : hashMap.keySet()) {
                                pair = (Pair) hashMap.get(className2);
                                str = str + className2 + "," + pair.first + "," + ((b) pair.second).nxV + "," + ((b) pair.second).nxW + ";";
                            }
                            Assert.assertTrue("LeakCursor:" + str, false);
                        }
                    } catch (Throwable e2) {
                        v.e(this.nxR.TAG, "checkCursor table:[%s] e:%s[%s]", str, e2.getMessage(), be.e(e2));
                    }
                }
            }, 500);
        }
    }

    public final Cursor query(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5) {
        if (isOpen()) {
            b.begin();
            try {
                Cursor query = this.nxs.query(str, strArr, str2, strArr2, str3, str4, str5);
                b(query, str);
                b.a(str, query, this.ejX);
                return query;
            } catch (Exception e) {
                com.tencent.mm.plugin.report.b.itm.a(181, 10, 1, false);
                v.e(this.TAG, "execSQL Error :" + e.getMessage());
                b.i(e);
                return c.bxW();
            }
        }
        v.e(this.TAG, "DB IS CLOSED ! {%s}", be.bur());
        return c.bxW();
    }

    public final Cursor rawQuery(String str, String[] strArr) {
        Assert.assertTrue("sql is null ", !be.kS(str));
        if (isOpen()) {
            b.begin();
            try {
                Cursor rawQuery = this.nxs.rawQuery(str, strArr);
                b(rawQuery, str);
                b.a(str, rawQuery, this.ejX);
                return rawQuery;
            } catch (Exception e) {
                com.tencent.mm.plugin.report.b.itm.a(181, 10, 1, false);
                v.e(this.TAG, "execSQL Error :" + e.getMessage());
                b.i(e);
                return c.bxW();
            }
        }
        v.e(this.TAG, "DB IS CLOSED ! {%s}", be.bur());
        return c.bxW();
    }

    public final boolean a(String str, String str2, String str3, List<String> list, ExecuteSqlCallback executeSqlCallback) {
        if (isOpen()) {
            return DBDumpUtil.doRecoveryDb(this.nxs.nxA, str, str2, str3, list, null, executeSqlCallback, true);
        }
        v.e(this.TAG, "DB IS CLOSED ! {%s}", be.bur());
        return false;
    }

    public final long getPageSize() {
        return this.nxs.nxA.getPageSize();
    }

    public final SQLiteDatabase bxY() {
        if (this.nxs.nxA != null) {
            return this.nxs.nxA;
        }
        return this.nxs.nxB;
    }

    public final Cursor aH(String str, boolean z) {
        Assert.assertTrue("sql is null ", !be.kS(str));
        if (isOpen()) {
            b.begin();
            try {
                Cursor rawQuery = this.nxs.nxA.rawQuery(str, null, z);
                b(rawQuery, str);
                b.a(str, rawQuery, this.ejX);
                return rawQuery;
            } catch (Exception e) {
                com.tencent.mm.plugin.report.b.itm.a(181, 10, 1, false);
                v.e(this.TAG, "execSQL Error :" + e.getMessage());
                b.i(e);
                return c.bxW();
            }
        }
        v.e(this.TAG, "DB IS CLOSED ! {%s}", be.bur());
        return c.bxW();
    }

    public final boolean dF(String str, String str2) {
        Assert.assertTrue("sql is null ", !be.kS(str2));
        if (isOpen()) {
            b.begin();
            try {
                this.nxs.execSQL(str2);
                b.a(str2, null, this.ejX);
                return true;
            } catch (Exception e) {
                com.tencent.mm.plugin.report.b.itm.a(181, 11, 1, false);
                String message = e.getMessage();
                v.e(this.TAG, "execSQL Error :" + message);
                if (message != null && message.contains("no such table")) {
                    v.d("MicroMsg.DBInit", "resetIniCache iniFilename:%s", this.nxK.nxt);
                    com.tencent.mm.loader.stub.b.deleteFile(r1.nxt);
                    Assert.assertTrue("clean ini cache and reboot", false);
                }
                b.i(e);
                return false;
            }
        }
        v.e(this.TAG, "DB IS CLOSED ! {%s}", be.bur());
        return false;
    }

    public final long insert(String str, String str2, ContentValues contentValues) {
        if (isOpen()) {
            b.begin();
            try {
                long insert = this.nxs.insert(str, str2, contentValues);
                b.a(str, null, this.ejX);
                return insert;
            } catch (Exception e) {
                com.tencent.mm.plugin.report.b.itm.a(181, 11, 1, false);
                v.e(this.TAG, "insert Error :" + e.getMessage());
                b.i(e);
                return -1;
            }
        }
        v.e(this.TAG, "DB IS CLOSED ! {%s}", be.bur());
        return -2;
    }

    public final int update(String str, ContentValues contentValues, String str2, String[] strArr) {
        if (isOpen()) {
            b.begin();
            try {
                int update = this.nxs.update(str, contentValues, str2, strArr);
                b.a(str, null, this.ejX);
                return update;
            } catch (Exception e) {
                com.tencent.mm.plugin.report.b.itm.a(181, 11, 1, false);
                v.e(this.TAG, "update Error :" + e.getMessage());
                b.i(e);
                return -1;
            }
        }
        v.e(this.TAG, "DB IS CLOSED ! {%s}", be.bur());
        return -2;
    }

    public final long replace(String str, String str2, ContentValues contentValues) {
        if (isOpen()) {
            b.begin();
            try {
                long replace = this.nxs.replace(str, str2, contentValues);
                b.a(str, null, this.ejX);
                return replace;
            } catch (Exception e) {
                com.tencent.mm.plugin.report.b.itm.a(181, 11, 1, false);
                v.e(this.TAG, "repalce  Error :" + e.getMessage());
                b.i(e);
                return -1;
            }
        }
        v.e(this.TAG, "DB IS CLOSED ! {%s}", be.bur());
        return -2;
    }

    public final int delete(String str, String str2, String[] strArr) {
        if (isOpen()) {
            b.begin();
            try {
                int delete = this.nxs.delete(str, str2, strArr);
                b.a(str, null, this.ejX);
                return delete;
            } catch (Exception e) {
                com.tencent.mm.plugin.report.b.itm.a(181, 11, 1, false);
                v.e(this.TAG, "delete Error :" + e.getMessage());
                b.i(e);
                return -1;
            }
        }
        v.e(this.TAG, "DB IS CLOSED ! {%s}", be.bur());
        return -2;
    }

    public final boolean NQ(String str) {
        if (isOpen()) {
            try {
                this.nxs.execSQL("DROP TABLE " + str);
            } catch (Exception e) {
                com.tencent.mm.plugin.report.b.itm.a(181, 11, 1, false);
                v.e(this.TAG, "drop table Error :" + e.getMessage());
                b.i(e);
            }
        } else {
            v.e(this.TAG, "DB IS CLOSED ! {%s}", be.bur());
        }
        return false;
    }

    public final synchronized long auU() {
        return er(-1);
    }

    public final synchronized long er(long j) {
        long j2 = -1;
        synchronized (this) {
            v.i(this.TAG, "beginTransaction thr:(%d,%d) ticket:%d db:%b  {%s}", Long.valueOf(j), Long.valueOf(Thread.currentThread().getId()), Long.valueOf(this.ejX), Boolean.valueOf(isOpen()), be.bur());
            if (!isOpen()) {
                v.e(this.TAG, "DB IS CLOSED ! {%s}", be.bur());
                j2 = -4;
            } else if (this.ejX > 0) {
                v.e(this.TAG, "ERROR beginTransaction transactionTicket:" + this.ejX);
            } else if (ad.isMainThread() || j != -1) {
                try {
                    b.begin();
                    this.nxs.beginTransaction();
                    b.a("beginTrans", null, 0);
                    this.ejX = be.Ni() & 2147483647L;
                    this.ejX |= (r2 & 2147483647L) << 32;
                    if (this.nxJ != null) {
                        this.nxJ.vm();
                    }
                    j2 = this.ejX;
                } catch (Exception e) {
                    com.tencent.mm.plugin.report.b.itm.a(181, 8, 1, false);
                    v.e(this.TAG, "beginTransaction Error :" + e.getMessage());
                    b.i(e);
                    j2 = -3;
                }
            } else {
                v.e(this.TAG, "FORBID: beginTrans UNKNOW_THREAD ParamID:%d nowThr:%d", Long.valueOf(j), Long.valueOf(r2));
                j2 = -2;
            }
        }
        return j2;
    }

    public final synchronized int es(long j) {
        int i = 0;
        synchronized (this) {
            long Ni = be.Ni();
            v.i(this.TAG, "endTransaction thr:%d ticket:(%d,%d) db:%b  {%s} ", Long.valueOf(Thread.currentThread().getId()), Long.valueOf(j), Long.valueOf(this.ejX), Boolean.valueOf(isOpen()), be.bur());
            if (!isOpen()) {
                v.e(this.TAG, "DB IS CLOSED ! {%s}", be.bur());
                i = -4;
            } else if (j != this.ejX) {
                v.e(this.TAG, "ERROR endTransaction ticket:" + j + " transactionTicket:" + this.ejX);
                i = -1;
            } else {
                if (((j >> 32) & 2147483647L) != r4) {
                    v.e(this.TAG, "FORBID: endTrans UNKNOW_THREAD ticket:%s ParamID:%d nowThr:%d", Long.toHexString(j), Long.valueOf((j >> 32) & 2147483647L), Long.valueOf(r4));
                    i = -2;
                } else {
                    try {
                        b.begin();
                        this.nxs.endTransaction();
                        v.i(this.TAG, "endTransaction Succ Time:%d thr:%d ticket:(%d,%d) db:%b  {%s} ", Long.valueOf(be.ay(Ni)), Long.valueOf(r4), Long.valueOf(j), Long.valueOf(this.ejX), Boolean.valueOf(isOpen()), be.bur());
                        b.a("endTrans", null, 0);
                        this.ejX = 0;
                        if (this.nxJ != null) {
                            this.nxJ.vn();
                        }
                    } catch (Exception e) {
                        v.e(this.TAG, "endTransaction Error :" + e.getMessage());
                        com.tencent.mm.plugin.report.b.itm.a(181, 9, 1, false);
                        b.i(e);
                        i = -3;
                    }
                }
            }
        }
        return i;
    }

    public final synchronized boolean inTransaction() {
        boolean z = false;
        synchronized (this) {
            if (!isOpen()) {
                v.e(this.TAG, "DB IS CLOSED ! {%s}", be.bur());
            } else if (this.ejX > 0) {
                z = true;
            }
        }
        return z;
    }
}
