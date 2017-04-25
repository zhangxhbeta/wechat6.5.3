package com.google.android.gms.analytics.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.analytics.AnalyticsReceiver;
import com.google.android.gms.analytics.AnalyticsService;
import com.google.android.gms.analytics.CampaignTrackingReceiver;
import com.google.android.gms.analytics.CampaignTrackingService;
import com.google.android.gms.analytics.c;
import com.google.android.gms.analytics.d;
import com.google.android.gms.analytics.internal.i.a;
import com.google.android.gms.c.ae;
import com.google.android.gms.c.af;
import com.google.android.gms.c.ah;
import com.google.android.gms.c.ai;
import com.google.android.gms.c.aj;
import com.google.android.gms.c.ak;
import com.google.android.gms.c.g;
import com.google.android.gms.c.h;
import com.google.android.gms.common.internal.f;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import java.util.HashMap;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;

final class w extends o {
    private boolean ahA;
    private final u ahr;
    private final h ahs;
    private final g aht;
    private final t ahu;
    private long ahv = Long.MIN_VALUE;
    private final ae ahw;
    private final ae ahx;
    private final j ahy;
    private long ahz;
    private boolean rm;

    protected w(q qVar, r rVar) {
        super(qVar);
        com.google.android.gms.common.internal.w.Z(rVar);
        this.aht = new g(qVar);
        this.ahr = new u(qVar);
        this.ahs = new h(qVar);
        this.ahu = r.d(qVar);
        this.ahy = new j(this.afY.agn);
        this.ahw = new ae(this, qVar) {
            final /* synthetic */ w ahB;

            public final void run() {
                w wVar = this.ahB;
                wVar.b(new ah(wVar) {
                    final /* synthetic */ w ahB;

                    {
                        this.ahB = r1;
                    }

                    public final void hj() {
                        this.ahB.is();
                    }
                });
            }
        };
        this.ahx = new ae(this, qVar) {
            final /* synthetic */ w ahB;

            public final void run() {
                w.a(this.ahB);
            }
        };
    }

    private boolean K(String str) {
        return this.afY.mContext.checkCallingOrSelfPermission(str) == 0;
    }

    private void a(s sVar, ak akVar) {
        com.google.android.gms.common.internal.w.Z(sVar);
        com.google.android.gms.common.internal.w.Z(akVar);
        c cVar = new c(this.afY);
        String str = sVar.agX;
        com.google.android.gms.common.internal.w.U(str);
        Uri O = d.O(str);
        ListIterator listIterator = cVar.kY().listIterator();
        while (listIterator.hasNext()) {
            if (O.equals(((ai) listIterator.next()).iS())) {
                listIterator.remove();
            }
        }
        cVar.kY().add(new d(cVar.ahP, str));
        cVar.aiX = sVar.agY;
        ae iR = cVar.iR();
        h hVar = (h) iR.b(h.class);
        hVar.awZ = SlookAirButtonFrequentContactAdapter.DATA;
        hVar.axe = true;
        iR.b((af) akVar);
        g gVar = (g) iR.b(g.class);
        aj ajVar = (aj) iR.b(aj.class);
        for (Entry entry : sVar.afL.entrySet()) {
            String str2 = (String) entry.getKey();
            String str3 = (String) entry.getValue();
            if ("an".equals(str2)) {
                ajVar.afG = str3;
            } else if ("av".equals(str2)) {
                ajVar.afH = str3;
            } else if ("aid".equals(str2)) {
                ajVar.azg = str3;
            } else if ("aiid".equals(str2)) {
                ajVar.azh = str3;
            } else if ("uid".equals(str2)) {
                hVar.axa = str3;
            } else {
                gVar.afL.put(g.af(str2), str3);
            }
        }
        b("Sending installation campaign to", sVar.agX, akVar);
        iR.ayN = hV().hz();
        ah ahVar = iR.ayK.ayU;
        if (iR.ayR) {
            throw new IllegalStateException("Measurement prototype can't be submitted");
        } else if (iR.ayL) {
            throw new IllegalStateException("Measurement can only be submitted once");
        } else {
            ae kW = iR.kW();
            kW.ayO = kW.agn.elapsedRealtime();
            if (kW.ayN != 0) {
                kW.ayM = kW.ayN;
            } else {
                kW.ayM = kW.agn.currentTimeMillis();
            }
            kW.ayL = true;
            ahVar.aza.execute(new com.google.android.gms.c.ah.AnonymousClass1(ahVar, kW));
        }
    }

    static /* synthetic */ void a(w wVar) {
        try {
            wVar.ahr.ij();
            wVar.is();
        } catch (SQLiteException e) {
            wVar.f("Failed to delete stale hits", e);
        }
        wVar.ahx.j(86400000);
    }

    private long ik() {
        ah.if();
        hX();
        try {
            return this.ahr.ik();
        } catch (SQLiteException e) {
            g("Failed to get min/max hit times from local store", e);
            return 0;
        }
    }

    private void iq() {
        if (!this.ahA && ac.iC() && !this.ahu.isConnected()) {
            if (this.ahy.f(((Long) aj.aiQ.get()).longValue())) {
                this.ahy.start();
                C("Connecting to service");
                if (this.ahu.connect()) {
                    C("Connected to service");
                    this.ahy.ago = 0;
                    onServiceConnected();
                }
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean ir() {
        /*
        r12 = this;
        r1 = 1;
        r2 = 0;
        com.google.android.gms.c.ah.if();
        r12.hX();
        r0 = "Dispatching a batch of local hits";
        r12.C(r0);
        r0 = r12.ahu;
        r0 = r0.isConnected();
        if (r0 != 0) goto L_0x002e;
    L_0x0016:
        r0 = com.google.android.gms.common.internal.f.aob;
        if (r0 != 0) goto L_0x002e;
    L_0x001a:
        r0 = r1;
    L_0x001b:
        r3 = r12.ahs;
        r3 = r3.hw();
        if (r3 != 0) goto L_0x0030;
    L_0x0023:
        if (r0 == 0) goto L_0x0032;
    L_0x0025:
        if (r1 == 0) goto L_0x0032;
    L_0x0027:
        r0 = "No network or service available. Will retry later";
        r12.C(r0);
    L_0x002d:
        return r2;
    L_0x002e:
        r0 = r2;
        goto L_0x001b;
    L_0x0030:
        r1 = r2;
        goto L_0x0023;
    L_0x0032:
        r0 = com.google.android.gms.analytics.internal.ac.iG();
        r1 = com.google.android.gms.analytics.internal.ac.iH();
        r0 = java.lang.Math.max(r0, r1);
        r6 = (long) r0;
        r3 = new java.util.ArrayList;
        r3.<init>();
        r0 = 0;
        r4 = r0;
    L_0x0047:
        r0 = r12.ahr;	 Catch:{ all -> 0x01e4 }
        r0.beginTransaction();	 Catch:{ all -> 0x01e4 }
        r3.clear();	 Catch:{ all -> 0x01e4 }
        r0 = r12.ahr;	 Catch:{ SQLiteException -> 0x00cb }
        r8 = r0.h(r6);	 Catch:{ SQLiteException -> 0x00cb }
        r0 = r8.isEmpty();	 Catch:{ SQLiteException -> 0x00cb }
        if (r0 == 0) goto L_0x007a;
    L_0x005b:
        r0 = "Store is empty, nothing to dispatch";
        r12.C(r0);	 Catch:{ SQLiteException -> 0x00cb }
        r12.iu();	 Catch:{ SQLiteException -> 0x00cb }
        r0 = r12.ahr;	 Catch:{ SQLiteException -> 0x006f }
        r0.setTransactionSuccessful();	 Catch:{ SQLiteException -> 0x006f }
        r0 = r12.ahr;	 Catch:{ SQLiteException -> 0x006f }
        r0.endTransaction();	 Catch:{ SQLiteException -> 0x006f }
        goto L_0x002d;
    L_0x006f:
        r0 = move-exception;
        r1 = "Failed to commit local dispatch transaction";
        r12.g(r1, r0);
        r12.iu();
        goto L_0x002d;
    L_0x007a:
        r0 = "Hits loaded from store. count";
        r1 = r8.size();	 Catch:{ SQLiteException -> 0x00cb }
        r1 = java.lang.Integer.valueOf(r1);	 Catch:{ SQLiteException -> 0x00cb }
        r12.d(r0, r1);	 Catch:{ SQLiteException -> 0x00cb }
        r1 = r8.iterator();	 Catch:{ all -> 0x01e4 }
    L_0x008c:
        r0 = r1.hasNext();	 Catch:{ all -> 0x01e4 }
        if (r0 == 0) goto L_0x00ed;
    L_0x0092:
        r0 = r1.next();	 Catch:{ all -> 0x01e4 }
        r0 = (com.google.android.gms.analytics.internal.c) r0;	 Catch:{ all -> 0x01e4 }
        r10 = r0.afN;	 Catch:{ all -> 0x01e4 }
        r0 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1));
        if (r0 != 0) goto L_0x008c;
    L_0x009e:
        r0 = "Database contains successfully uploaded hit";
        r1 = java.lang.Long.valueOf(r4);	 Catch:{ all -> 0x01e4 }
        r3 = r8.size();	 Catch:{ all -> 0x01e4 }
        r3 = java.lang.Integer.valueOf(r3);	 Catch:{ all -> 0x01e4 }
        r12.d(r0, r1, r3);	 Catch:{ all -> 0x01e4 }
        r12.iu();	 Catch:{ all -> 0x01e4 }
        r0 = r12.ahr;	 Catch:{ SQLiteException -> 0x00bf }
        r0.setTransactionSuccessful();	 Catch:{ SQLiteException -> 0x00bf }
        r0 = r12.ahr;	 Catch:{ SQLiteException -> 0x00bf }
        r0.endTransaction();	 Catch:{ SQLiteException -> 0x00bf }
        goto L_0x002d;
    L_0x00bf:
        r0 = move-exception;
        r1 = "Failed to commit local dispatch transaction";
        r12.g(r1, r0);
        r12.iu();
        goto L_0x002d;
    L_0x00cb:
        r0 = move-exception;
        r1 = "Failed to read hits from persisted store";
        r12.f(r1, r0);	 Catch:{ all -> 0x01e4 }
        r12.iu();	 Catch:{ all -> 0x01e4 }
        r0 = r12.ahr;	 Catch:{ SQLiteException -> 0x00e1 }
        r0.setTransactionSuccessful();	 Catch:{ SQLiteException -> 0x00e1 }
        r0 = r12.ahr;	 Catch:{ SQLiteException -> 0x00e1 }
        r0.endTransaction();	 Catch:{ SQLiteException -> 0x00e1 }
        goto L_0x002d;
    L_0x00e1:
        r0 = move-exception;
        r1 = "Failed to commit local dispatch transaction";
        r12.g(r1, r0);
        r12.iu();
        goto L_0x002d;
    L_0x00ed:
        r0 = r12.ahu;	 Catch:{ all -> 0x01e4 }
        r0 = r0.isConnected();	 Catch:{ all -> 0x01e4 }
        if (r0 == 0) goto L_0x0156;
    L_0x00f5:
        r0 = com.google.android.gms.common.internal.f.aob;	 Catch:{ all -> 0x01e4 }
        if (r0 != 0) goto L_0x0156;
    L_0x00f9:
        r0 = "Service connected, sending hits to the service";
        r12.C(r0);	 Catch:{ all -> 0x01e4 }
    L_0x00ff:
        r0 = r8.isEmpty();	 Catch:{ all -> 0x01e4 }
        if (r0 != 0) goto L_0x0156;
    L_0x0105:
        r0 = 0;
        r0 = r8.get(r0);	 Catch:{ all -> 0x01e4 }
        r0 = (com.google.android.gms.analytics.internal.c) r0;	 Catch:{ all -> 0x01e4 }
        r1 = r12.ahu;	 Catch:{ all -> 0x01e4 }
        r1 = r1.d(r0);	 Catch:{ all -> 0x01e4 }
        if (r1 == 0) goto L_0x0156;
    L_0x0114:
        r10 = r0.afN;	 Catch:{ all -> 0x01e4 }
        r4 = java.lang.Math.max(r4, r10);	 Catch:{ all -> 0x01e4 }
        r8.remove(r0);	 Catch:{ all -> 0x01e4 }
        r1 = "Hit sent do device AnalyticsService for delivery";
        r12.e(r1, r0);	 Catch:{ all -> 0x01e4 }
        r1 = r12.ahr;	 Catch:{ SQLiteException -> 0x0134 }
        r10 = r0.afN;	 Catch:{ SQLiteException -> 0x0134 }
        r1.i(r10);	 Catch:{ SQLiteException -> 0x0134 }
        r0 = r0.afN;	 Catch:{ SQLiteException -> 0x0134 }
        r0 = java.lang.Long.valueOf(r0);	 Catch:{ SQLiteException -> 0x0134 }
        r3.add(r0);	 Catch:{ SQLiteException -> 0x0134 }
        goto L_0x00ff;
    L_0x0134:
        r0 = move-exception;
        r1 = "Failed to remove hit that was send for delivery";
        r12.g(r1, r0);	 Catch:{ all -> 0x01e4 }
        r12.iu();	 Catch:{ all -> 0x01e4 }
        r0 = r12.ahr;	 Catch:{ SQLiteException -> 0x014a }
        r0.setTransactionSuccessful();	 Catch:{ SQLiteException -> 0x014a }
        r0 = r12.ahr;	 Catch:{ SQLiteException -> 0x014a }
        r0.endTransaction();	 Catch:{ SQLiteException -> 0x014a }
        goto L_0x002d;
    L_0x014a:
        r0 = move-exception;
        r1 = "Failed to commit local dispatch transaction";
        r12.g(r1, r0);
        r12.iu();
        goto L_0x002d;
    L_0x0156:
        r0 = r4;
        r4 = r12.ahs;	 Catch:{ all -> 0x01e4 }
        r4 = r4.hw();	 Catch:{ all -> 0x01e4 }
        if (r4 == 0) goto L_0x018b;
    L_0x015f:
        r4 = r12.ahs;	 Catch:{ all -> 0x01e4 }
        r9 = r4.i(r8);	 Catch:{ all -> 0x01e4 }
        r10 = r9.iterator();	 Catch:{ all -> 0x01e4 }
        r4 = r0;
    L_0x016a:
        r0 = r10.hasNext();	 Catch:{ all -> 0x01e4 }
        if (r0 == 0) goto L_0x017f;
    L_0x0170:
        r0 = r10.next();	 Catch:{ all -> 0x01e4 }
        r0 = (java.lang.Long) r0;	 Catch:{ all -> 0x01e4 }
        r0 = r0.longValue();	 Catch:{ all -> 0x01e4 }
        r4 = java.lang.Math.max(r4, r0);	 Catch:{ all -> 0x01e4 }
        goto L_0x016a;
    L_0x017f:
        r8.removeAll(r9);	 Catch:{ all -> 0x01e4 }
        r0 = r12.ahr;	 Catch:{ SQLiteException -> 0x01a9 }
        r0.k(r9);	 Catch:{ SQLiteException -> 0x01a9 }
        r3.addAll(r9);	 Catch:{ SQLiteException -> 0x01a9 }
        r0 = r4;
    L_0x018b:
        r4 = r3.isEmpty();	 Catch:{ all -> 0x01e4 }
        if (r4 == 0) goto L_0x01cb;
    L_0x0191:
        r0 = r12.ahr;	 Catch:{ SQLiteException -> 0x019d }
        r0.setTransactionSuccessful();	 Catch:{ SQLiteException -> 0x019d }
        r0 = r12.ahr;	 Catch:{ SQLiteException -> 0x019d }
        r0.endTransaction();	 Catch:{ SQLiteException -> 0x019d }
        goto L_0x002d;
    L_0x019d:
        r0 = move-exception;
        r1 = "Failed to commit local dispatch transaction";
        r12.g(r1, r0);
        r12.iu();
        goto L_0x002d;
    L_0x01a9:
        r0 = move-exception;
        r1 = "Failed to remove successfully uploaded hits";
        r12.g(r1, r0);	 Catch:{ all -> 0x01e4 }
        r12.iu();	 Catch:{ all -> 0x01e4 }
        r0 = r12.ahr;	 Catch:{ SQLiteException -> 0x01bf }
        r0.setTransactionSuccessful();	 Catch:{ SQLiteException -> 0x01bf }
        r0 = r12.ahr;	 Catch:{ SQLiteException -> 0x01bf }
        r0.endTransaction();	 Catch:{ SQLiteException -> 0x01bf }
        goto L_0x002d;
    L_0x01bf:
        r0 = move-exception;
        r1 = "Failed to commit local dispatch transaction";
        r12.g(r1, r0);
        r12.iu();
        goto L_0x002d;
    L_0x01cb:
        r4 = r12.ahr;	 Catch:{ SQLiteException -> 0x01d8 }
        r4.setTransactionSuccessful();	 Catch:{ SQLiteException -> 0x01d8 }
        r4 = r12.ahr;	 Catch:{ SQLiteException -> 0x01d8 }
        r4.endTransaction();	 Catch:{ SQLiteException -> 0x01d8 }
        r4 = r0;
        goto L_0x0047;
    L_0x01d8:
        r0 = move-exception;
        r1 = "Failed to commit local dispatch transaction";
        r12.g(r1, r0);
        r12.iu();
        goto L_0x002d;
    L_0x01e4:
        r0 = move-exception;
        r1 = r12.ahr;	 Catch:{ SQLiteException -> 0x01f0 }
        r1.setTransactionSuccessful();	 Catch:{ SQLiteException -> 0x01f0 }
        r1 = r12.ahr;	 Catch:{ SQLiteException -> 0x01f0 }
        r1.endTransaction();	 Catch:{ SQLiteException -> 0x01f0 }
        throw r0;
    L_0x01f0:
        r0 = move-exception;
        r1 = "Failed to commit local dispatch transaction";
        r12.g(r1, r0);
        r12.iu();
        goto L_0x002d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.analytics.internal.w.ir():boolean");
    }

    private void it() {
        ag hU = hU();
        if (hU.ahZ && !hU.aia) {
            long ik = ik();
            if (ik != 0 && Math.abs(this.afY.agn.currentTimeMillis() - ik) <= ((Long) aj.aip.get()).longValue()) {
                d("Dispatch alarm scheduled (ms)", Long.valueOf(ac.iF()));
                hU.iP();
            }
        }
    }

    private void iu() {
        if (this.ahw.iN()) {
            C("All hits dispatched or no network/service. Going to power save mode");
        }
        this.ahw.cancel();
        ag hU = hU();
        if (hU.aia) {
            hU.cancel();
        }
    }

    private long iv() {
        if (this.ahv != Long.MIN_VALUE) {
            return this.ahv;
        }
        return this.afY.id().hM() ? ((long) this.afY.id().hN()) * 1000 : ((Long) aj.aik.get()).longValue();
    }

    private void iw() {
        hX();
        q.if();
        this.ahA = true;
        this.ahu.disconnect();
        is();
    }

    public final void L(String str) {
        com.google.android.gms.common.internal.w.U(str);
        q.if();
        n.hT();
        ak a = k.a(this.afY.hZ(), str);
        if (a == null) {
            f("Parsing failed. Ignoring invalid campaign data", str);
            return;
        }
        CharSequence hD = hV().hD();
        if (str.equals(hD)) {
            F("Ignoring duplicate install campaign");
        } else if (TextUtils.isEmpty(hD)) {
            hV().y(str);
            if (hV().hA().f(ac.iM())) {
                f("Campaign received too late, ignoring", a);
                return;
            }
            e("Received installation campaign", a);
            for (s a2 : this.ahr.il()) {
                a(a2, a);
            }
        } else {
            d("Ignoring multiple install campaigns. original, new", hD, str);
        }
    }

    public final void b(ah ahVar) {
        long j = this.ahz;
        ah.if();
        hX();
        long j2 = -1;
        long hB = hV().hB();
        if (hB != 0) {
            j2 = Math.abs(this.afY.agn.currentTimeMillis() - hB);
        }
        e("Dispatching local hits. Elapsed time since last dispatch (ms)", Long.valueOf(j2));
        if (!f.aob) {
            iq();
        }
        try {
            ir();
            hV().hC();
            is();
            if (ahVar != null) {
                ahVar.hj();
            }
            if (this.ahz != j) {
                g gVar = this.aht;
                if (VERSION.SDK_INT > 10) {
                    Context context = gVar.afY.mContext;
                    Intent intent = new Intent("com.google.analytics.RADIO_POWERED");
                    intent.addCategory(context.getPackageName());
                    intent.putExtra(g.afX, true);
                    context.sendOrderedBroadcast(intent, null);
                }
            }
        } catch (Throwable th) {
            g("Local dispatch failed", th);
            hV().hC();
            is();
            if (ahVar != null) {
                ahVar.hj();
            }
        }
    }

    public final void c(c cVar) {
        com.google.android.gms.common.internal.w.Z(cVar);
        ah.if();
        hX();
        if (this.ahA) {
            D("Hit delivery not possible. Missing network permissions. See http://goo.gl/8Rd3yj for instructions");
        } else {
            d("Delivering hit", cVar);
        }
        if (TextUtils.isEmpty(cVar.c("_m", ""))) {
            Pair pair;
            a aVar = hV().agk;
            long hF = aVar.hF();
            hF = hF == 0 ? 0 : Math.abs(hF - aVar.agm.afY.agn.currentTimeMillis());
            if (hF < aVar.agl) {
                pair = null;
            } else if (hF > aVar.agl * 2) {
                aVar.hE();
                pair = null;
            } else {
                String string = aVar.agm.agh.getString(aVar.hI(), null);
                long j = aVar.agm.agh.getLong(aVar.hH(), 0);
                aVar.hE();
                pair = (string == null || j <= 0) ? null : new Pair(string, Long.valueOf(j));
            }
            if (pair != null) {
                String str = ((Long) pair.second) + ":" + ((String) pair.first);
                Map hashMap = new HashMap(cVar.afL);
                hashMap.put("_m", str);
                cVar = new c(this, hashMap, cVar.afO, cVar.afQ, cVar.afN, cVar.afP, cVar.afM);
            }
        }
        iq();
        if (this.ahu.d(cVar)) {
            D("Hit sent to the device AnalyticsService for delivery");
        } else if (f.aob) {
            this.afY.hZ().a(cVar, "Service unavailable on package side");
        } else {
            try {
                this.ahr.e(cVar);
                is();
            } catch (SQLiteException e) {
                g("Delivery failed to save hit to a database", e);
                this.afY.hZ().a(cVar, "deliver: failed to insert hit to database");
            }
        }
    }

    protected final void c(s sVar) {
        q.if();
        e("Sending first hit to property", sVar.agX);
        if (!hV().hA().f(ac.iM())) {
            String hD = hV().hD();
            if (!TextUtils.isEmpty(hD)) {
                ak a = k.a(this.afY.hZ(), hD);
                e("Found relevant installation campaign", a);
                a(sVar, a);
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long d(com.google.android.gms.analytics.internal.s r6) {
        /*
        r5 = this;
        com.google.android.gms.common.internal.w.Z(r6);
        r5.hX();
        com.google.android.gms.analytics.internal.q.if();
        r0 = r5.ahr;	 Catch:{ SQLiteException -> 0x0040 }
        r0.beginTransaction();	 Catch:{ SQLiteException -> 0x0040 }
        r0 = r5.ahr;	 Catch:{ SQLiteException -> 0x0040 }
        r2 = r6.agV;	 Catch:{ SQLiteException -> 0x0040 }
        r1 = r6.agW;	 Catch:{ SQLiteException -> 0x0040 }
        r0.a(r2, r1);	 Catch:{ SQLiteException -> 0x0040 }
        r0 = r5.ahr;	 Catch:{ SQLiteException -> 0x0040 }
        r2 = r6.agV;	 Catch:{ SQLiteException -> 0x0040 }
        r1 = r6.agW;	 Catch:{ SQLiteException -> 0x0040 }
        r4 = r6.agX;	 Catch:{ SQLiteException -> 0x0040 }
        r0 = r0.a(r2, r1, r4);	 Catch:{ SQLiteException -> 0x0040 }
        r2 = 1;
        r2 = r2 + r0;
        r6.agZ = r2;	 Catch:{ SQLiteException -> 0x0040 }
        r2 = r5.ahr;	 Catch:{ SQLiteException -> 0x0040 }
        r2.b(r6);	 Catch:{ SQLiteException -> 0x0040 }
        r2 = r5.ahr;	 Catch:{ SQLiteException -> 0x0040 }
        r2.setTransactionSuccessful();	 Catch:{ SQLiteException -> 0x0040 }
        r2 = r5.ahr;	 Catch:{ SQLiteException -> 0x0038 }
        r2.endTransaction();	 Catch:{ SQLiteException -> 0x0038 }
    L_0x0037:
        return r0;
    L_0x0038:
        r2 = move-exception;
        r3 = "Failed to end transaction";
        r5.g(r3, r2);
        goto L_0x0037;
    L_0x0040:
        r0 = move-exception;
        r1 = "Failed to update Analytics property";
        r5.g(r1, r0);	 Catch:{ all -> 0x0057 }
        r0 = r5.ahr;	 Catch:{ SQLiteException -> 0x004f }
        r0.endTransaction();	 Catch:{ SQLiteException -> 0x004f }
    L_0x004c:
        r0 = -1;
        goto L_0x0037;
    L_0x004f:
        r0 = move-exception;
        r1 = "Failed to end transaction";
        r5.g(r1, r0);
        goto L_0x004c;
    L_0x0057:
        r0 = move-exception;
        r1 = r5.ahr;	 Catch:{ SQLiteException -> 0x005e }
        r1.endTransaction();	 Catch:{ SQLiteException -> 0x005e }
    L_0x005d:
        throw r0;
    L_0x005e:
        r1 = move-exception;
        r2 = "Failed to end transaction";
        r5.g(r2, r1);
        goto L_0x005d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.analytics.internal.w.d(com.google.android.gms.analytics.internal.s):long");
    }

    public final void hR() {
        ah.if();
        hX();
        C("Service disconnected");
    }

    final void hS() {
        q.if();
        this.ahz = this.afY.agn.currentTimeMillis();
    }

    protected final void hm() {
        this.ahr.hY();
        this.ahs.hY();
        this.ahu.hY();
    }

    protected final void ip() {
        hX();
        hV().hz();
        if (!K("android.permission.ACCESS_NETWORK_STATE")) {
            G("Missing required android.permission.ACCESS_NETWORK_STATE. Google Analytics disabled. See http://goo.gl/8Rd3yj for instructions");
            iw();
        }
        if (!K("android.permission.INTERNET")) {
            G("Missing required android.permission.INTERNET. Google Analytics disabled. See http://goo.gl/8Rd3yj for instructions");
            iw();
        }
        if (AnalyticsService.s(this.afY.mContext)) {
            C("AnalyticsService registered in the app manifest and enabled");
        } else if (f.aob) {
            G("Device AnalyticsService not registered! Hits will not be delivered reliably.");
        } else {
            F("AnalyticsService not registered in the app manifest. Hits might not be delivered reliably. See http://goo.gl/8Rd3yj for instructions.");
        }
        if (!(this.ahA || f.aob || this.ahr.isEmpty())) {
            iq();
        }
        is();
    }

    public final void is() {
        long j = 0;
        q.if();
        hX();
        boolean z = !this.ahA && ((!f.aob || this.afY.agG.iB()) && iv() > 0);
        if (!z) {
            this.aht.unregister();
            iu();
        } else if (this.ahr.isEmpty()) {
            this.aht.unregister();
            iu();
        } else {
            if (((Boolean) aj.aiL.get()).booleanValue()) {
                z = true;
            } else {
                BroadcastReceiver broadcastReceiver = this.aht;
                broadcastReceiver.hv();
                if (!broadcastReceiver.afZ) {
                    Context context = broadcastReceiver.afY.mContext;
                    context.registerReceiver(broadcastReceiver, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                    IntentFilter intentFilter = new IntentFilter("com.google.analytics.RADIO_POWERED");
                    intentFilter.addCategory(context.getPackageName());
                    context.registerReceiver(broadcastReceiver, intentFilter);
                    broadcastReceiver.aga = broadcastReceiver.hw();
                    broadcastReceiver.afY.hZ().d("Registering connectivity change receiver. Network connected", Boolean.valueOf(broadcastReceiver.aga));
                    broadcastReceiver.afZ = true;
                }
                g gVar = this.aht;
                if (!gVar.afZ) {
                    gVar.afY.hZ().F("Connectivity unknown. Receiver not registered");
                }
                z = gVar.aga;
            }
            if (z) {
                it();
                long iv = iv();
                long hB = hV().hB();
                if (hB != 0) {
                    hB = iv - Math.abs(this.afY.agn.currentTimeMillis() - hB);
                    if (hB <= 0) {
                        hB = Math.min(ac.iE(), iv);
                    }
                } else {
                    hB = Math.min(ac.iE(), iv);
                }
                d("Dispatch scheduled (ms)", Long.valueOf(hB));
                if (this.ahw.iN()) {
                    ae aeVar = this.ahw;
                    hB = Math.max(1, hB + (aeVar.ahW == 0 ? 0 : Math.abs(aeVar.afY.agn.currentTimeMillis() - aeVar.ahW)));
                    aeVar = this.ahw;
                    if (!aeVar.iN()) {
                        return;
                    }
                    if (hB < 0) {
                        aeVar.cancel();
                        return;
                    }
                    hB -= Math.abs(aeVar.afY.agn.currentTimeMillis() - aeVar.ahW);
                    if (hB >= 0) {
                        j = hB;
                    }
                    aeVar.getHandler().removeCallbacks(aeVar.ahV);
                    if (!aeVar.getHandler().postDelayed(aeVar.ahV, j)) {
                        aeVar.afY.hZ().g("Failed to adjust delayed post. time", Long.valueOf(j));
                        return;
                    }
                    return;
                }
                this.ahw.j(hB);
                return;
            }
            iu();
            it();
        }
    }

    protected final void onServiceConnected() {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:37)
	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:61)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:33)
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
        com.google.android.gms.analytics.internal.q.if();
        r0 = com.google.android.gms.common.internal.f.aob;
        if (r0 != 0) goto L_0x002a;
    L_0x0007:
        com.google.android.gms.c.ah.if();
        r6.hX();
        com.google.android.gms.analytics.internal.n.hT();
        r0 = com.google.android.gms.analytics.internal.ac.iC();
        if (r0 != 0) goto L_0x001c;
    L_0x0016:
        r0 = "Service client disabled. Can't dispatch local hits to device AnalyticsService";
        r6.F(r0);
    L_0x001c:
        r0 = r6.ahu;
        r0 = r0.isConnected();
        if (r0 != 0) goto L_0x002b;
    L_0x0024:
        r0 = "Service not connected";
        r6.C(r0);
    L_0x002a:
        return;
    L_0x002b:
        r0 = r6.ahr;
        r0 = r0.isEmpty();
        if (r0 != 0) goto L_0x002a;
    L_0x0033:
        r0 = "Dispatching local hits to device AnalyticsService";
        r6.C(r0);
    L_0x0039:
        r0 = r6.ahr;	 Catch:{ SQLiteException -> 0x004e }
        r1 = com.google.android.gms.analytics.internal.ac.iG();	 Catch:{ SQLiteException -> 0x004e }
        r2 = (long) r1;	 Catch:{ SQLiteException -> 0x004e }
        r1 = r0.h(r2);	 Catch:{ SQLiteException -> 0x004e }
        r0 = r1.isEmpty();	 Catch:{ SQLiteException -> 0x004e }
        if (r0 == 0) goto L_0x0063;	 Catch:{ SQLiteException -> 0x004e }
    L_0x004a:
        r6.is();	 Catch:{ SQLiteException -> 0x004e }
        goto L_0x002a;
    L_0x004e:
        r0 = move-exception;
        r1 = "Failed to read hits from store";
        r6.g(r1, r0);
        r6.iu();
        goto L_0x002a;
    L_0x0059:
        r1.remove(r0);
        r2 = r6.ahr;	 Catch:{ SQLiteException -> 0x007c }
        r4 = r0.afN;	 Catch:{ SQLiteException -> 0x007c }
        r2.i(r4);	 Catch:{ SQLiteException -> 0x007c }
    L_0x0063:
        r0 = r1.isEmpty();
        if (r0 != 0) goto L_0x0039;
    L_0x0069:
        r0 = 0;
        r0 = r1.get(r0);
        r0 = (com.google.android.gms.analytics.internal.c) r0;
        r2 = r6.ahu;
        r2 = r2.d(r0);
        if (r2 != 0) goto L_0x0059;
    L_0x0078:
        r6.is();
        goto L_0x002a;
    L_0x007c:
        r0 = move-exception;
        r1 = "Failed to remove hit that was send for delivery";
        r6.g(r1, r0);
        r6.iu();
        goto L_0x002a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.analytics.internal.w.onServiceConnected():void");
    }

    final void start() {
        hX();
        com.google.android.gms.common.internal.w.a(!this.rm, "Analytics backend already started");
        this.rm = true;
        if (!f.aob) {
            Context context = this.afY.mContext;
            if (!AnalyticsReceiver.r(context)) {
                F("AnalyticsReceiver is not registered or is disabled. Register the receiver for reliable dispatching on non-Google Play devices. See http://goo.gl/8Rd3yj for instructions.");
            } else if (!AnalyticsService.s(context)) {
                G("AnalyticsService is not registered or is disabled. Analytics service at risk of not starting. See http://goo.gl/8Rd3yj for instructions.");
            }
            if (!CampaignTrackingReceiver.r(context)) {
                F("CampaignTrackingReceiver is not registered, not exported or is disabled. Installation campaign tracking is not possible. See http://goo.gl/8Rd3yj for instructions.");
            } else if (!CampaignTrackingService.s(context)) {
                F("CampaignTrackingService is not registered or is disabled. Installation campaign tracking is not possible. See http://goo.gl/8Rd3yj for instructions.");
            }
        }
        this.afY.ia().c(new Runnable(this) {
            final /* synthetic */ w ahB;

            {
                this.ahB = r1;
            }

            public final void run() {
                this.ahB.ip();
            }
        });
    }
}
