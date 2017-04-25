package com.tencent.wxop.stat;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import com.tencent.wxop.stat.b.b;
import com.tencent.wxop.stat.b.c;
import com.tencent.wxop.stat.b.f;
import com.tencent.wxop.stat.b.l;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

public class r {
    static b pLp = l.bQC();
    private static Context pLq = null;
    private static r pLr = null;
    volatile int a = 0;
    private String f = "";
    private String g = "";
    private int k = 0;
    private boolean m = false;
    f pKL = null;
    private aa pLm = null;
    private aa pLn = null;
    c pLo = null;
    private ConcurrentHashMap<com.tencent.wxop.stat.a.b, String> pLs = null;
    private HashMap<String, String> pLt = new HashMap();

    private r(Context context) {
        try {
            this.pKL = new f();
            pLq = context.getApplicationContext();
            this.pLs = new ConcurrentHashMap();
            this.f = l.hg(context);
            this.g = "pri_" + l.hg(context);
            this.pLm = new aa(pLq, this.f);
            this.pLn = new aa(pLq, this.g);
            a(true);
            a(false);
            f();
            gS(pLq);
            d();
            j();
        } catch (Throwable th) {
            pLp.i(th);
        }
    }

    private synchronized void a(com.tencent.wxop.stat.a.b r7, com.tencent.wxop.stat.ah r8, boolean r9, boolean r10) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Exception block dominator not found, method:com.tencent.wxop.stat.r.a(com.tencent.wxop.stat.a.b, com.tencent.wxop.stat.ah, boolean, boolean):void. bs: [B:20:0x009c, B:51:0x00f4]
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:86)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r6 = this;
        r1 = 0;
        monitor-enter(r6);
        r0 = com.tencent.wxop.stat.b.bQd();	 Catch:{ all -> 0x00f8 }
        if (r0 <= 0) goto L_0x00d0;	 Catch:{ all -> 0x00f8 }
    L_0x0008:
        r0 = com.tencent.wxop.stat.b.m;	 Catch:{ all -> 0x00f8 }
        if (r0 <= 0) goto L_0x0010;
    L_0x000c:
        if (r9 != 0) goto L_0x0010;
    L_0x000e:
        if (r10 == 0) goto L_0x011c;
    L_0x0010:
        r1 = r6.kI(r9);	 Catch:{ Throwable -> 0x00da }
        r1.beginTransaction();	 Catch:{ Throwable -> 0x00da }
        if (r9 != 0) goto L_0x003f;	 Catch:{ Throwable -> 0x00da }
    L_0x0019:
        r0 = r6.a;	 Catch:{ Throwable -> 0x00da }
        r2 = com.tencent.wxop.stat.b.bQd();	 Catch:{ Throwable -> 0x00da }
        if (r0 <= r2) goto L_0x003f;	 Catch:{ Throwable -> 0x00da }
    L_0x0021:
        r0 = pLp;	 Catch:{ Throwable -> 0x00da }
        r2 = "Too many events stored in db.";	 Catch:{ Throwable -> 0x00da }
        r0.warn(r2);	 Catch:{ Throwable -> 0x00da }
        r0 = r6.a;	 Catch:{ Throwable -> 0x00da }
        r2 = r6.pLm;	 Catch:{ Throwable -> 0x00da }
        r2 = r2.getWritableDatabase();	 Catch:{ Throwable -> 0x00da }
        r3 = "events";	 Catch:{ Throwable -> 0x00da }
        r4 = "event_id in (select event_id from events where timestamp in (select min(timestamp) from events) limit 1)";	 Catch:{ Throwable -> 0x00da }
        r5 = 0;	 Catch:{ Throwable -> 0x00da }
        r2 = r2.delete(r3, r4, r5);	 Catch:{ Throwable -> 0x00da }
        r0 = r0 - r2;	 Catch:{ Throwable -> 0x00da }
        r6.a = r0;	 Catch:{ Throwable -> 0x00da }
    L_0x003f:
        r0 = new android.content.ContentValues;	 Catch:{ Throwable -> 0x00da }
        r0.<init>();	 Catch:{ Throwable -> 0x00da }
        r2 = r7.g();	 Catch:{ Throwable -> 0x00da }
        r3 = com.tencent.wxop.stat.b.bPW();	 Catch:{ Throwable -> 0x00da }
        if (r3 == 0) goto L_0x0063;	 Catch:{ Throwable -> 0x00da }
    L_0x004e:
        r3 = pLp;	 Catch:{ Throwable -> 0x00da }
        r4 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00da }
        r5 = "insert 1 event, content:";	 Catch:{ Throwable -> 0x00da }
        r4.<init>(r5);	 Catch:{ Throwable -> 0x00da }
        r4 = r4.append(r2);	 Catch:{ Throwable -> 0x00da }
        r4 = r4.toString();	 Catch:{ Throwable -> 0x00da }
        r3.bw(r4);	 Catch:{ Throwable -> 0x00da }
    L_0x0063:
        r2 = com.tencent.wxop.stat.b.r.b(r2);	 Catch:{ Throwable -> 0x00da }
        r3 = "content";	 Catch:{ Throwable -> 0x00da }
        r0.put(r3, r2);	 Catch:{ Throwable -> 0x00da }
        r2 = "send_count";	 Catch:{ Throwable -> 0x00da }
        r3 = "0";	 Catch:{ Throwable -> 0x00da }
        r0.put(r2, r3);	 Catch:{ Throwable -> 0x00da }
        r2 = "status";	 Catch:{ Throwable -> 0x00da }
        r3 = 1;	 Catch:{ Throwable -> 0x00da }
        r3 = java.lang.Integer.toString(r3);	 Catch:{ Throwable -> 0x00da }
        r0.put(r2, r3);	 Catch:{ Throwable -> 0x00da }
        r2 = "timestamp";	 Catch:{ Throwable -> 0x00da }
        r4 = r7.c();	 Catch:{ Throwable -> 0x00da }
        r3 = java.lang.Long.valueOf(r4);	 Catch:{ Throwable -> 0x00da }
        r0.put(r2, r3);	 Catch:{ Throwable -> 0x00da }
        r2 = "events";	 Catch:{ Throwable -> 0x00da }
        r3 = 0;	 Catch:{ Throwable -> 0x00da }
        r2 = r1.insert(r2, r3, r0);	 Catch:{ Throwable -> 0x00da }
        r1.setTransactionSuccessful();	 Catch:{ Throwable -> 0x00da }
        if (r1 == 0) goto L_0x019b;
    L_0x009c:
        r1.endTransaction();	 Catch:{ Throwable -> 0x00d2 }
        r0 = r2;
    L_0x00a0:
        r2 = 0;
        r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r0 <= 0) goto L_0x0102;
    L_0x00a6:
        r0 = r6.a;	 Catch:{ all -> 0x00f8 }
        r0 = r0 + 1;	 Catch:{ all -> 0x00f8 }
        r6.a = r0;	 Catch:{ all -> 0x00f8 }
        r0 = com.tencent.wxop.stat.b.bPW();	 Catch:{ all -> 0x00f8 }
        if (r0 == 0) goto L_0x00cb;	 Catch:{ all -> 0x00f8 }
    L_0x00b2:
        r0 = pLp;	 Catch:{ all -> 0x00f8 }
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00f8 }
        r2 = "directStoreEvent insert event to db, event:";	 Catch:{ all -> 0x00f8 }
        r1.<init>(r2);	 Catch:{ all -> 0x00f8 }
        r2 = r7.g();	 Catch:{ all -> 0x00f8 }
        r1 = r1.append(r2);	 Catch:{ all -> 0x00f8 }
        r1 = r1.toString();	 Catch:{ all -> 0x00f8 }
        r0.bz(r1);	 Catch:{ all -> 0x00f8 }
    L_0x00cb:
        if (r8 == 0) goto L_0x00d0;	 Catch:{ all -> 0x00f8 }
    L_0x00cd:
        r8.a();	 Catch:{ all -> 0x00f8 }
    L_0x00d0:
        monitor-exit(r6);
        return;
    L_0x00d2:
        r0 = move-exception;
        r1 = pLp;	 Catch:{ all -> 0x00f8 }
        r1.i(r0);	 Catch:{ all -> 0x00f8 }
        r0 = r2;
        goto L_0x00a0;
    L_0x00da:
        r0 = move-exception;
        r2 = -1;
        r4 = pLp;	 Catch:{ all -> 0x00f1 }
        r4.i(r0);	 Catch:{ all -> 0x00f1 }
        if (r1 == 0) goto L_0x019b;
    L_0x00e4:
        r1.endTransaction();	 Catch:{ Throwable -> 0x00e9 }
        r0 = r2;
        goto L_0x00a0;
    L_0x00e9:
        r0 = move-exception;
        r1 = pLp;	 Catch:{ all -> 0x00f8 }
        r1.i(r0);	 Catch:{ all -> 0x00f8 }
        r0 = r2;
        goto L_0x00a0;
    L_0x00f1:
        r0 = move-exception;
        if (r1 == 0) goto L_0x00f7;
    L_0x00f4:
        r1.endTransaction();	 Catch:{ Throwable -> 0x00fb }
    L_0x00f7:
        throw r0;	 Catch:{ all -> 0x00f8 }
    L_0x00f8:
        r0 = move-exception;
        monitor-exit(r6);
        throw r0;
    L_0x00fb:
        r1 = move-exception;
        r2 = pLp;	 Catch:{ all -> 0x00f8 }
        r2.i(r1);	 Catch:{ all -> 0x00f8 }
        goto L_0x00f7;	 Catch:{ all -> 0x00f8 }
    L_0x0102:
        r0 = pLp;	 Catch:{ all -> 0x00f8 }
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00f8 }
        r2 = "Failed to store event:";	 Catch:{ all -> 0x00f8 }
        r1.<init>(r2);	 Catch:{ all -> 0x00f8 }
        r2 = r7.g();	 Catch:{ all -> 0x00f8 }
        r1 = r1.append(r2);	 Catch:{ all -> 0x00f8 }
        r1 = r1.toString();	 Catch:{ all -> 0x00f8 }
        r0.error(r1);	 Catch:{ all -> 0x00f8 }
        goto L_0x00d0;	 Catch:{ all -> 0x00f8 }
    L_0x011c:
        r0 = com.tencent.wxop.stat.b.m;	 Catch:{ all -> 0x00f8 }
        if (r0 <= 0) goto L_0x00d0;	 Catch:{ all -> 0x00f8 }
    L_0x0120:
        r0 = com.tencent.wxop.stat.b.bPW();	 Catch:{ all -> 0x00f8 }
        if (r0 == 0) goto L_0x0174;	 Catch:{ all -> 0x00f8 }
    L_0x0126:
        r0 = pLp;	 Catch:{ all -> 0x00f8 }
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00f8 }
        r2 = "cacheEventsInMemory.size():";	 Catch:{ all -> 0x00f8 }
        r1.<init>(r2);	 Catch:{ all -> 0x00f8 }
        r2 = r6.pLs;	 Catch:{ all -> 0x00f8 }
        r2 = r2.size();	 Catch:{ all -> 0x00f8 }
        r1 = r1.append(r2);	 Catch:{ all -> 0x00f8 }
        r2 = ",numEventsCachedInMemory:";	 Catch:{ all -> 0x00f8 }
        r1 = r1.append(r2);	 Catch:{ all -> 0x00f8 }
        r2 = com.tencent.wxop.stat.b.m;	 Catch:{ all -> 0x00f8 }
        r1 = r1.append(r2);	 Catch:{ all -> 0x00f8 }
        r2 = ",numStoredEvents:";	 Catch:{ all -> 0x00f8 }
        r1 = r1.append(r2);	 Catch:{ all -> 0x00f8 }
        r2 = r6.a;	 Catch:{ all -> 0x00f8 }
        r1 = r1.append(r2);	 Catch:{ all -> 0x00f8 }
        r1 = r1.toString();	 Catch:{ all -> 0x00f8 }
        r0.bw(r1);	 Catch:{ all -> 0x00f8 }
        r0 = pLp;	 Catch:{ all -> 0x00f8 }
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00f8 }
        r2 = "cache event:";	 Catch:{ all -> 0x00f8 }
        r1.<init>(r2);	 Catch:{ all -> 0x00f8 }
        r2 = r7.g();	 Catch:{ all -> 0x00f8 }
        r1 = r1.append(r2);	 Catch:{ all -> 0x00f8 }
        r1 = r1.toString();	 Catch:{ all -> 0x00f8 }
        r0.bw(r1);	 Catch:{ all -> 0x00f8 }
    L_0x0174:
        r0 = r6.pLs;	 Catch:{ all -> 0x00f8 }
        r1 = "";	 Catch:{ all -> 0x00f8 }
        r0.put(r7, r1);	 Catch:{ all -> 0x00f8 }
        r0 = r6.pLs;	 Catch:{ all -> 0x00f8 }
        r0 = r0.size();	 Catch:{ all -> 0x00f8 }
        r1 = com.tencent.wxop.stat.b.m;	 Catch:{ all -> 0x00f8 }
        if (r0 < r1) goto L_0x0189;	 Catch:{ all -> 0x00f8 }
    L_0x0186:
        r6.bQw();	 Catch:{ all -> 0x00f8 }
    L_0x0189:
        if (r8 == 0) goto L_0x00d0;	 Catch:{ all -> 0x00f8 }
    L_0x018b:
        r0 = r6.pLs;	 Catch:{ all -> 0x00f8 }
        r0 = r0.size();	 Catch:{ all -> 0x00f8 }
        if (r0 <= 0) goto L_0x0196;	 Catch:{ all -> 0x00f8 }
    L_0x0193:
        r6.bQw();	 Catch:{ all -> 0x00f8 }
    L_0x0196:
        r8.a();	 Catch:{ all -> 0x00f8 }
        goto L_0x00d0;
    L_0x019b:
        r0 = r2;
        goto L_0x00a0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.wxop.stat.r.a(com.tencent.wxop.stat.a.b, com.tencent.wxop.stat.ah, boolean, boolean):void");
    }

    private synchronized void a(af afVar) {
        Cursor query;
        Throwable th;
        try {
            Object obj;
            long update;
            String jSONObject = afVar.pMa.toString();
            String a = l.a(jSONObject);
            ContentValues contentValues = new ContentValues();
            contentValues.put("content", afVar.pMa.toString());
            contentValues.put("md5sum", a);
            afVar.c = a;
            contentValues.put("version", Integer.valueOf(afVar.d));
            query = this.pLm.getReadableDatabase().query("config", null, null, null, null, null, null);
            do {
                try {
                    if (!query.moveToNext()) {
                        obj = null;
                        break;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } while (query.getInt(0) != afVar.a);
            obj = 1;
            this.pLm.getWritableDatabase().beginTransaction();
            if (1 == obj) {
                update = (long) this.pLm.getWritableDatabase().update("config", contentValues, "type=?", new String[]{Integer.toString(afVar.a)});
            } else {
                contentValues.put("type", Integer.valueOf(afVar.a));
                update = this.pLm.getWritableDatabase().insert("config", null, contentValues);
            }
            if (update == -1) {
                pLp.by("Failed to store cfg:" + jSONObject);
            } else {
                pLp.bz("Sucessed to store cfg:" + jSONObject);
            }
            this.pLm.getWritableDatabase().setTransactionSuccessful();
            if (query != null) {
                query.close();
            }
            try {
                this.pLm.getWritableDatabase().endTransaction();
            } catch (Exception e) {
            }
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            this.pLm.getWritableDatabase().endTransaction();
            throw th;
        }
        return;
    }

    static /* synthetic */ void a(r rVar, int i, boolean z) {
        int g = i == -1 ? !z ? rVar.g() : rVar.h() : i;
        if (g > 0) {
            int bQe = (b.bQe() * 60) * b.bQc();
            if (g > bQe && bQe > 0) {
                g = bQe;
            }
            int a = b.a();
            int i2 = g / a;
            int i3 = g % a;
            if (b.bPW()) {
                pLp.bw("sentStoreEventsByDb sendNumbers=" + g + ",important=" + z + ",maxSendNumPerFor1Period=" + bQe + ",maxCount=" + i2 + ",restNumbers=" + i3);
            }
            for (g = 0; g < i2; g++) {
                rVar.aa(a, z);
            }
            if (i3 > 0) {
                rVar.aa(i3, z);
            }
        }
    }

    private void a(boolean z) {
        SQLiteDatabase sQLiteDatabase = null;
        try {
            sQLiteDatabase = kI(z);
            sQLiteDatabase.beginTransaction();
            ContentValues contentValues = new ContentValues();
            contentValues.put("status", Integer.valueOf(1));
            int update = sQLiteDatabase.update("events", contentValues, "status=?", new String[]{Long.toString(2)});
            if (b.bPW()) {
                pLp.bw("update " + update + " unsent events.");
            }
            sQLiteDatabase.setTransactionSuccessful();
            if (sQLiteDatabase != null) {
                try {
                    sQLiteDatabase.endTransaction();
                } catch (Throwable th) {
                    pLp.i(th);
                }
            }
        } catch (Throwable th2) {
            pLp.i(th2);
        }
    }

    private synchronized void aa(int i, boolean z) {
        try {
            if (this.a > 0 && i > 0 && !d.a()) {
                if (b.bPW()) {
                    pLp.bw("Load " + this.a + " unsent events");
                }
                List arrayList = new ArrayList(i);
                d(arrayList, i, z);
                if (arrayList.size() > 0) {
                    if (b.bPW()) {
                        pLp.bw("Peek " + arrayList.size() + " unsent events.");
                    }
                    c(arrayList, 2, z);
                    ai.hu(pLq).a(arrayList, new y(this, arrayList, z));
                }
            }
        } catch (Throwable th) {
            pLp.i(th);
        }
    }

    public static r bQv() {
        return pLr;
    }

    private void bQw() {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Exception block dominator not found, method:com.tencent.wxop.stat.r.bQw():void. bs: [B:42:0x0128, B:53:0x0140]
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:86)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r9 = this;
        r1 = 0;
        r0 = r9.m;
        if (r0 == 0) goto L_0x0006;
    L_0x0005:
        return;
    L_0x0006:
        r2 = r9.pLs;
        monitor-enter(r2);
        r0 = r9.pLs;	 Catch:{ all -> 0x0013 }
        r0 = r0.size();	 Catch:{ all -> 0x0013 }
        if (r0 != 0) goto L_0x0016;	 Catch:{ all -> 0x0013 }
    L_0x0011:
        monitor-exit(r2);	 Catch:{ all -> 0x0013 }
        goto L_0x0005;	 Catch:{ all -> 0x0013 }
    L_0x0013:
        r0 = move-exception;	 Catch:{ all -> 0x0013 }
        monitor-exit(r2);	 Catch:{ all -> 0x0013 }
        throw r0;
    L_0x0016:
        r0 = 1;
        r9.m = r0;	 Catch:{ all -> 0x0013 }
        r0 = com.tencent.wxop.stat.b.bPW();	 Catch:{ all -> 0x0013 }
        if (r0 == 0) goto L_0x0054;	 Catch:{ all -> 0x0013 }
    L_0x001f:
        r0 = pLp;	 Catch:{ all -> 0x0013 }
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0013 }
        r4 = "insert ";	 Catch:{ all -> 0x0013 }
        r3.<init>(r4);	 Catch:{ all -> 0x0013 }
        r4 = r9.pLs;	 Catch:{ all -> 0x0013 }
        r4 = r4.size();	 Catch:{ all -> 0x0013 }
        r3 = r3.append(r4);	 Catch:{ all -> 0x0013 }
        r4 = " events ,numEventsCachedInMemory:";	 Catch:{ all -> 0x0013 }
        r3 = r3.append(r4);	 Catch:{ all -> 0x0013 }
        r4 = com.tencent.wxop.stat.b.m;	 Catch:{ all -> 0x0013 }
        r3 = r3.append(r4);	 Catch:{ all -> 0x0013 }
        r4 = ",numStoredEvents:";	 Catch:{ all -> 0x0013 }
        r3 = r3.append(r4);	 Catch:{ all -> 0x0013 }
        r4 = r9.a;	 Catch:{ all -> 0x0013 }
        r3 = r3.append(r4);	 Catch:{ all -> 0x0013 }
        r3 = r3.toString();	 Catch:{ all -> 0x0013 }
        r0.bw(r3);	 Catch:{ all -> 0x0013 }
    L_0x0054:
        r0 = r9.pLm;	 Catch:{ Throwable -> 0x00d4 }
        r1 = r0.getWritableDatabase();	 Catch:{ Throwable -> 0x00d4 }
        r1.beginTransaction();	 Catch:{ Throwable -> 0x00d4 }
        r0 = r9.pLs;	 Catch:{ Throwable -> 0x00d4 }
        r0 = r0.entrySet();	 Catch:{ Throwable -> 0x00d4 }
        r3 = r0.iterator();	 Catch:{ Throwable -> 0x00d4 }
    L_0x0067:
        r0 = r3.hasNext();	 Catch:{ Throwable -> 0x00d4 }
        if (r0 == 0) goto L_0x0123;	 Catch:{ Throwable -> 0x00d4 }
    L_0x006d:
        r0 = r3.next();	 Catch:{ Throwable -> 0x00d4 }
        r0 = (java.util.Map.Entry) r0;	 Catch:{ Throwable -> 0x00d4 }
        r0 = r0.getKey();	 Catch:{ Throwable -> 0x00d4 }
        r0 = (com.tencent.wxop.stat.a.b) r0;	 Catch:{ Throwable -> 0x00d4 }
        r4 = new android.content.ContentValues;	 Catch:{ Throwable -> 0x00d4 }
        r4.<init>();	 Catch:{ Throwable -> 0x00d4 }
        r5 = r0.g();	 Catch:{ Throwable -> 0x00d4 }
        r6 = com.tencent.wxop.stat.b.bPW();	 Catch:{ Throwable -> 0x00d4 }
        if (r6 == 0) goto L_0x009d;	 Catch:{ Throwable -> 0x00d4 }
    L_0x0088:
        r6 = pLp;	 Catch:{ Throwable -> 0x00d4 }
        r7 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00d4 }
        r8 = "insert content:";	 Catch:{ Throwable -> 0x00d4 }
        r7.<init>(r8);	 Catch:{ Throwable -> 0x00d4 }
        r7 = r7.append(r5);	 Catch:{ Throwable -> 0x00d4 }
        r7 = r7.toString();	 Catch:{ Throwable -> 0x00d4 }
        r6.bw(r7);	 Catch:{ Throwable -> 0x00d4 }
    L_0x009d:
        r5 = com.tencent.wxop.stat.b.r.b(r5);	 Catch:{ Throwable -> 0x00d4 }
        r6 = "content";	 Catch:{ Throwable -> 0x00d4 }
        r4.put(r6, r5);	 Catch:{ Throwable -> 0x00d4 }
        r5 = "send_count";	 Catch:{ Throwable -> 0x00d4 }
        r6 = "0";	 Catch:{ Throwable -> 0x00d4 }
        r4.put(r5, r6);	 Catch:{ Throwable -> 0x00d4 }
        r5 = "status";	 Catch:{ Throwable -> 0x00d4 }
        r6 = 1;	 Catch:{ Throwable -> 0x00d4 }
        r6 = java.lang.Integer.toString(r6);	 Catch:{ Throwable -> 0x00d4 }
        r4.put(r5, r6);	 Catch:{ Throwable -> 0x00d4 }
        r5 = "timestamp";	 Catch:{ Throwable -> 0x00d4 }
        r6 = r0.c();	 Catch:{ Throwable -> 0x00d4 }
        r0 = java.lang.Long.valueOf(r6);	 Catch:{ Throwable -> 0x00d4 }
        r4.put(r5, r0);	 Catch:{ Throwable -> 0x00d4 }
        r0 = "events";	 Catch:{ Throwable -> 0x00d4 }
        r5 = 0;	 Catch:{ Throwable -> 0x00d4 }
        r1.insert(r0, r5, r4);	 Catch:{ Throwable -> 0x00d4 }
        r3.remove();	 Catch:{ Throwable -> 0x00d4 }
        goto L_0x0067;
    L_0x00d4:
        r0 = move-exception;
        r3 = pLp;	 Catch:{ all -> 0x013d }
        r3.i(r0);	 Catch:{ all -> 0x013d }
        if (r1 == 0) goto L_0x00e2;
    L_0x00dc:
        r1.endTransaction();	 Catch:{ Throwable -> 0x0136 }
        r9.f();	 Catch:{ Throwable -> 0x0136 }
    L_0x00e2:
        r0 = 0;
        r9.m = r0;	 Catch:{ all -> 0x0013 }
        r0 = com.tencent.wxop.stat.b.bPW();	 Catch:{ all -> 0x0013 }
        if (r0 == 0) goto L_0x0120;	 Catch:{ all -> 0x0013 }
    L_0x00eb:
        r0 = pLp;	 Catch:{ all -> 0x0013 }
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0013 }
        r3 = "after insert, cacheEventsInMemory.size():";	 Catch:{ all -> 0x0013 }
        r1.<init>(r3);	 Catch:{ all -> 0x0013 }
        r3 = r9.pLs;	 Catch:{ all -> 0x0013 }
        r3 = r3.size();	 Catch:{ all -> 0x0013 }
        r1 = r1.append(r3);	 Catch:{ all -> 0x0013 }
        r3 = ",numEventsCachedInMemory:";	 Catch:{ all -> 0x0013 }
        r1 = r1.append(r3);	 Catch:{ all -> 0x0013 }
        r3 = com.tencent.wxop.stat.b.m;	 Catch:{ all -> 0x0013 }
        r1 = r1.append(r3);	 Catch:{ all -> 0x0013 }
        r3 = ",numStoredEvents:";	 Catch:{ all -> 0x0013 }
        r1 = r1.append(r3);	 Catch:{ all -> 0x0013 }
        r3 = r9.a;	 Catch:{ all -> 0x0013 }
        r1 = r1.append(r3);	 Catch:{ all -> 0x0013 }
        r1 = r1.toString();	 Catch:{ all -> 0x0013 }
        r0.bw(r1);	 Catch:{ all -> 0x0013 }
    L_0x0120:
        monitor-exit(r2);	 Catch:{ all -> 0x0013 }
        goto L_0x0005;
    L_0x0123:
        r1.setTransactionSuccessful();	 Catch:{ Throwable -> 0x00d4 }
        if (r1 == 0) goto L_0x00e2;
    L_0x0128:
        r1.endTransaction();	 Catch:{ Throwable -> 0x012f }
        r9.f();	 Catch:{ Throwable -> 0x012f }
        goto L_0x00e2;
    L_0x012f:
        r0 = move-exception;
        r1 = pLp;	 Catch:{ all -> 0x0013 }
        r1.i(r0);	 Catch:{ all -> 0x0013 }
        goto L_0x00e2;	 Catch:{ all -> 0x0013 }
    L_0x0136:
        r0 = move-exception;	 Catch:{ all -> 0x0013 }
        r1 = pLp;	 Catch:{ all -> 0x0013 }
        r1.i(r0);	 Catch:{ all -> 0x0013 }
        goto L_0x00e2;
    L_0x013d:
        r0 = move-exception;
        if (r1 == 0) goto L_0x0146;
    L_0x0140:
        r1.endTransaction();	 Catch:{ Throwable -> 0x0147 }
        r9.f();	 Catch:{ Throwable -> 0x0147 }
    L_0x0146:
        throw r0;	 Catch:{ all -> 0x0013 }
    L_0x0147:
        r1 = move-exception;	 Catch:{ all -> 0x0013 }
        r3 = pLp;	 Catch:{ all -> 0x0013 }
        r3.i(r1);	 Catch:{ all -> 0x0013 }
        goto L_0x0146;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.wxop.stat.r.bQw():void");
    }

    private synchronized void c(List<ab> list, int i, boolean z) {
        SQLiteDatabase kI;
        Throwable th;
        String str = null;
        synchronized (this) {
            if (list.size() != 0) {
                int bQb = !z ? b.bQb() : b.bPZ();
                try {
                    String str2;
                    kI = kI(z);
                    if (i == 2) {
                        try {
                            str2 = "update events set status=" + i + ", send_count=send_count+1  where " + cN(list);
                        } catch (Throwable th2) {
                            th = th2;
                            try {
                                pLp.i(th);
                                if (kI != null) {
                                    try {
                                        kI.endTransaction();
                                    } catch (Throwable th3) {
                                        pLp.i(th3);
                                    }
                                }
                            } catch (Throwable th4) {
                                th3 = th4;
                                if (kI != null) {
                                    try {
                                        kI.endTransaction();
                                    } catch (Throwable th5) {
                                        pLp.i(th5);
                                    }
                                }
                                throw th3;
                            }
                        }
                    }
                    String str3 = "update events set status=" + i + " where " + cN(list);
                    if (this.k % 3 == 0) {
                        str = "delete from events where send_count>" + bQb;
                    }
                    this.k++;
                    str2 = str3;
                    if (b.bPW()) {
                        pLp.bw("update sql:" + str2);
                    }
                    kI.beginTransaction();
                    kI.execSQL(str2);
                    if (str != null) {
                        pLp.bw("update for delete sql:" + str);
                        kI.execSQL(str);
                        f();
                    }
                    kI.setTransactionSuccessful();
                    if (kI != null) {
                        try {
                            kI.endTransaction();
                        } catch (Throwable th32) {
                            pLp.i(th32);
                        }
                    }
                } catch (Throwable th6) {
                    th32 = th6;
                    kI = null;
                    if (kI != null) {
                        kI.endTransaction();
                    }
                    throw th32;
                }
            }
        }
    }

    private static String cN(List<ab> list) {
        StringBuilder stringBuilder = new StringBuilder(list.size() * 3);
        stringBuilder.append("event_id in (");
        int size = list.size();
        int i = 0;
        for (ab abVar : list) {
            stringBuilder.append(abVar.a);
            if (i != size - 1) {
                stringBuilder.append(",");
            }
            i++;
        }
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    private void d() {
        Throwable th;
        Cursor query;
        try {
            query = this.pLm.getReadableDatabase().query("config", null, null, null, null, null, null);
            while (query.moveToNext()) {
                try {
                    int i = query.getInt(0);
                    String string = query.getString(1);
                    String string2 = query.getString(2);
                    int i2 = query.getInt(3);
                    af afVar = new af(i);
                    afVar.a = i;
                    afVar.pMa = new JSONObject(string);
                    afVar.c = string2;
                    afVar.d = i2;
                    b.a(pLq, afVar);
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            if (query != null) {
                query.close();
            }
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    private void d(List<ab> list, int i, boolean z) {
        SQLiteDatabase readableDatabase;
        Throwable th;
        Cursor cursor;
        if (z) {
            readableDatabase = this.pLn.getReadableDatabase();
        } else {
            try {
                readableDatabase = this.pLm.getReadableDatabase();
            } catch (Throwable th2) {
                th = th2;
                cursor = null;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        }
        cursor = readableDatabase.query("events", null, "status=?", new String[]{Integer.toString(1)}, null, null, null, Integer.toString(i));
        while (cursor.moveToNext()) {
            try {
                long j = cursor.getLong(0);
                String string = cursor.getString(1);
                if (!b.g) {
                    string = com.tencent.wxop.stat.b.r.a(string);
                }
                int i2 = cursor.getInt(2);
                int i3 = cursor.getInt(3);
                ab abVar = new ab(j, string, i2, i3);
                if (b.bPW()) {
                    pLp.bw("peek event, id=" + j + ",send_count=" + i3 + ",timestamp=" + cursor.getLong(4));
                }
                list.add(abVar);
            } catch (Throwable th3) {
                th = th3;
            }
        }
        if (cursor != null) {
            cursor.close();
        }
    }

    private void f() {
        this.a = g() + h();
    }

    private int g() {
        return (int) DatabaseUtils.queryNumEntries(this.pLm.getReadableDatabase(), "events");
    }

    public static r gR(Context context) {
        if (pLr == null) {
            synchronized (r.class) {
                if (pLr == null) {
                    pLr = new r(context);
                }
            }
        }
        return pLr;
    }

    private int h() {
        return (int) DatabaseUtils.queryNumEntries(this.pLn.getReadableDatabase(), "events");
    }

    private synchronized void h(java.util.List<com.tencent.wxop.stat.ab> r9, boolean r10) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Exception block dominator not found, method:com.tencent.wxop.stat.r.h(java.util.List, boolean):void. bs: [B:26:0x00ca, B:49:0x00f2]
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:86)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r8 = this;
        r1 = 0;
        monitor-enter(r8);
        r0 = r9.size();	 Catch:{ all -> 0x00d7 }
        if (r0 != 0) goto L_0x000a;
    L_0x0008:
        monitor-exit(r8);
        return;
    L_0x000a:
        r0 = com.tencent.wxop.stat.b.bPW();	 Catch:{ all -> 0x00d7 }
        if (r0 == 0) goto L_0x0034;	 Catch:{ all -> 0x00d7 }
    L_0x0010:
        r0 = pLp;	 Catch:{ all -> 0x00d7 }
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00d7 }
        r3 = "Delete ";	 Catch:{ all -> 0x00d7 }
        r2.<init>(r3);	 Catch:{ all -> 0x00d7 }
        r3 = r9.size();	 Catch:{ all -> 0x00d7 }
        r2 = r2.append(r3);	 Catch:{ all -> 0x00d7 }
        r3 = " events, important:";	 Catch:{ all -> 0x00d7 }
        r2 = r2.append(r3);	 Catch:{ all -> 0x00d7 }
        r2 = r2.append(r10);	 Catch:{ all -> 0x00d7 }
        r2 = r2.toString();	 Catch:{ all -> 0x00d7 }
        r0.bw(r2);	 Catch:{ all -> 0x00d7 }
    L_0x0034:
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00d7 }
        r0 = r9.size();	 Catch:{ all -> 0x00d7 }
        r0 = r0 * 3;	 Catch:{ all -> 0x00d7 }
        r3.<init>(r0);	 Catch:{ all -> 0x00d7 }
        r0 = "event_id in (";	 Catch:{ all -> 0x00d7 }
        r3.append(r0);	 Catch:{ all -> 0x00d7 }
        r0 = 0;	 Catch:{ all -> 0x00d7 }
        r4 = r9.size();	 Catch:{ all -> 0x00d7 }
        r5 = r9.iterator();	 Catch:{ all -> 0x00d7 }
        r2 = r0;	 Catch:{ all -> 0x00d7 }
    L_0x004f:
        r0 = r5.hasNext();	 Catch:{ all -> 0x00d7 }
        if (r0 == 0) goto L_0x006e;	 Catch:{ all -> 0x00d7 }
    L_0x0055:
        r0 = r5.next();	 Catch:{ all -> 0x00d7 }
        r0 = (com.tencent.wxop.stat.ab) r0;	 Catch:{ all -> 0x00d7 }
        r6 = r0.a;	 Catch:{ all -> 0x00d7 }
        r3.append(r6);	 Catch:{ all -> 0x00d7 }
        r0 = r4 + -1;	 Catch:{ all -> 0x00d7 }
        if (r2 == r0) goto L_0x006a;	 Catch:{ all -> 0x00d7 }
    L_0x0064:
        r0 = ",";	 Catch:{ all -> 0x00d7 }
        r3.append(r0);	 Catch:{ all -> 0x00d7 }
    L_0x006a:
        r0 = r2 + 1;	 Catch:{ all -> 0x00d7 }
        r2 = r0;	 Catch:{ all -> 0x00d7 }
        goto L_0x004f;	 Catch:{ all -> 0x00d7 }
    L_0x006e:
        r0 = ")";	 Catch:{ all -> 0x00d7 }
        r3.append(r0);	 Catch:{ all -> 0x00d7 }
        r1 = r8.kI(r10);	 Catch:{ Throwable -> 0x00da }
        r1.beginTransaction();	 Catch:{ Throwable -> 0x00da }
        r0 = "events";	 Catch:{ Throwable -> 0x00da }
        r2 = r3.toString();	 Catch:{ Throwable -> 0x00da }
        r5 = 0;	 Catch:{ Throwable -> 0x00da }
        r0 = r1.delete(r0, r2, r5);	 Catch:{ Throwable -> 0x00da }
        r2 = com.tencent.wxop.stat.b.bPW();	 Catch:{ Throwable -> 0x00da }
        if (r2 == 0) goto L_0x00bc;	 Catch:{ Throwable -> 0x00da }
    L_0x008d:
        r2 = pLp;	 Catch:{ Throwable -> 0x00da }
        r5 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00da }
        r6 = "delete ";	 Catch:{ Throwable -> 0x00da }
        r5.<init>(r6);	 Catch:{ Throwable -> 0x00da }
        r4 = r5.append(r4);	 Catch:{ Throwable -> 0x00da }
        r5 = " event ";	 Catch:{ Throwable -> 0x00da }
        r4 = r4.append(r5);	 Catch:{ Throwable -> 0x00da }
        r3 = r3.toString();	 Catch:{ Throwable -> 0x00da }
        r3 = r4.append(r3);	 Catch:{ Throwable -> 0x00da }
        r4 = ", success delete:";	 Catch:{ Throwable -> 0x00da }
        r3 = r3.append(r4);	 Catch:{ Throwable -> 0x00da }
        r3 = r3.append(r0);	 Catch:{ Throwable -> 0x00da }
        r3 = r3.toString();	 Catch:{ Throwable -> 0x00da }
        r2.bw(r3);	 Catch:{ Throwable -> 0x00da }
    L_0x00bc:
        r2 = r8.a;	 Catch:{ Throwable -> 0x00da }
        r0 = r2 - r0;	 Catch:{ Throwable -> 0x00da }
        r8.a = r0;	 Catch:{ Throwable -> 0x00da }
        r1.setTransactionSuccessful();	 Catch:{ Throwable -> 0x00da }
        r8.f();	 Catch:{ Throwable -> 0x00da }
        if (r1 == 0) goto L_0x0008;
    L_0x00ca:
        r1.endTransaction();	 Catch:{ Throwable -> 0x00cf }
        goto L_0x0008;
    L_0x00cf:
        r0 = move-exception;
        r1 = pLp;	 Catch:{ all -> 0x00d7 }
        r1.i(r0);	 Catch:{ all -> 0x00d7 }
        goto L_0x0008;
    L_0x00d7:
        r0 = move-exception;
        monitor-exit(r8);
        throw r0;
    L_0x00da:
        r0 = move-exception;
        r2 = pLp;	 Catch:{ all -> 0x00ef }
        r2.i(r0);	 Catch:{ all -> 0x00ef }
        if (r1 == 0) goto L_0x0008;
    L_0x00e2:
        r1.endTransaction();	 Catch:{ Throwable -> 0x00e7 }
        goto L_0x0008;
    L_0x00e7:
        r0 = move-exception;
        r1 = pLp;	 Catch:{ all -> 0x00d7 }
        r1.i(r0);	 Catch:{ all -> 0x00d7 }
        goto L_0x0008;
    L_0x00ef:
        r0 = move-exception;
        if (r1 == 0) goto L_0x00f5;
    L_0x00f2:
        r1.endTransaction();	 Catch:{ Throwable -> 0x00f6 }
    L_0x00f5:
        throw r0;	 Catch:{ all -> 0x00d7 }
    L_0x00f6:
        r1 = move-exception;	 Catch:{ all -> 0x00d7 }
        r2 = pLp;	 Catch:{ all -> 0x00d7 }
        r2.i(r1);	 Catch:{ all -> 0x00d7 }
        goto L_0x00f5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.wxop.stat.r.h(java.util.List, boolean):void");
    }

    private void j() {
        Cursor query;
        Throwable th;
        try {
            query = this.pLm.getReadableDatabase().query("keyvalues", null, null, null, null, null, null);
            while (query.moveToNext()) {
                try {
                    this.pLt.put(query.getString(0), query.getString(1));
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            if (query != null) {
                query.close();
            }
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    private SQLiteDatabase kI(boolean z) {
        return !z ? this.pLm.getWritableDatabase() : this.pLn.getWritableDatabase();
    }

    final void a(int i) {
        this.pKL.a(new z(this, i));
    }

    final void b(com.tencent.wxop.stat.a.b bVar, ah ahVar, boolean z, boolean z2) {
        if (this.pKL != null) {
            this.pKL.a(new v(this, bVar, ahVar, z, z2));
        }
    }

    public final synchronized c gS(Context context) {
        c cVar;
        Cursor query;
        Throwable th;
        Cursor cursor;
        if (this.pLo != null) {
            cVar = this.pLo;
        } else {
            try {
                this.pLm.getWritableDatabase().beginTransaction();
                if (b.bPW()) {
                    pLp.bw("try to load user info from db.");
                }
                query = this.pLm.getReadableDatabase().query("user", null, null, null, null, null, null, null);
                Object obj = null;
                try {
                    String string;
                    String b;
                    if (query.moveToNext()) {
                        String a = com.tencent.wxop.stat.b.r.a(query.getString(0));
                        int i = query.getInt(1);
                        string = query.getString(2);
                        long currentTimeMillis = System.currentTimeMillis() / 1000;
                        int i2 = (i == 1 || l.eM(query.getLong(3) * 1000).equals(l.eM(1000 * currentTimeMillis))) ? i : 1;
                        int i3 = !string.equals(l.hd(context)) ? i2 | 2 : i2;
                        String[] split = a.split(",");
                        obj = null;
                        if (split == null || split.length <= 0) {
                            b = l.b(context);
                            obj = 1;
                            a = b;
                        } else {
                            b = split[0];
                            if (b == null || b.length() < 11) {
                                string = com.tencent.wxop.stat.b.r.a(context);
                                if (string == null || string.length() <= 10) {
                                    string = b;
                                } else {
                                    obj = 1;
                                }
                                b = a;
                                a = string;
                            } else {
                                String str = b;
                                b = a;
                                a = str;
                            }
                        }
                        if (split == null || split.length < 2) {
                            string = l.c(context);
                            if (string != null && string.length() > 0) {
                                b = a + "," + string;
                                obj = 1;
                            }
                        } else {
                            string = split[1];
                            b = a + "," + string;
                        }
                        this.pLo = new c(a, string, i3);
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("uid", com.tencent.wxop.stat.b.r.b(b));
                        contentValues.put("user_type", Integer.valueOf(i3));
                        contentValues.put("app_ver", l.hd(context));
                        contentValues.put("ts", Long.valueOf(currentTimeMillis));
                        if (obj != null) {
                            this.pLm.getWritableDatabase().update("user", contentValues, "uid=?", new String[]{r10});
                        }
                        if (i3 != i) {
                            this.pLm.getWritableDatabase().replace("user", null, contentValues);
                        }
                        obj = 1;
                    }
                    if (obj == null) {
                        string = l.b(context);
                        b = l.c(context);
                        String str2 = (b == null || b.length() <= 0) ? string : string + "," + b;
                        long currentTimeMillis2 = System.currentTimeMillis() / 1000;
                        String hd = l.hd(context);
                        ContentValues contentValues2 = new ContentValues();
                        contentValues2.put("uid", com.tencent.wxop.stat.b.r.b(str2));
                        contentValues2.put("user_type", Integer.valueOf(0));
                        contentValues2.put("app_ver", hd);
                        contentValues2.put("ts", Long.valueOf(currentTimeMillis2));
                        this.pLm.getWritableDatabase().insert("user", null, contentValues2);
                        this.pLo = new c(string, b, 0);
                    }
                    this.pLm.getWritableDatabase().setTransactionSuccessful();
                    if (query != null) {
                        try {
                            query.close();
                        } catch (Throwable th2) {
                            pLp.i(th2);
                        }
                    }
                    this.pLm.getWritableDatabase().endTransaction();
                } catch (Throwable th3) {
                    th2 = th3;
                    if (query != null) {
                        query.close();
                    }
                    this.pLm.getWritableDatabase().endTransaction();
                    throw th2;
                }
            } catch (Throwable th4) {
                th2 = th4;
                query = null;
                if (query != null) {
                    query.close();
                }
                this.pLm.getWritableDatabase().endTransaction();
                throw th2;
            }
            cVar = this.pLo;
        }
        return cVar;
    }
}
