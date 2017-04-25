package com.tencent.mm.plugin.backup.movemodel;

import android.database.Cursor;
import android.os.Looper;
import com.tencent.mm.e.b.af;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.m;
import com.tencent.mm.plugin.backup.g.d;
import com.tencent.mm.plugin.backup.g.g;
import com.tencent.mm.plugin.backup.g.y;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.u;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class b {
    private static int eaq = 8;
    public boolean cAv = false;
    final int eak = 2;
    List<String> efQ;
    private final b eko;
    final c ekp;
    private final a ekq;
    ArrayList<a> ekr;
    final ac handler;

    class AnonymousClass4 implements Runnable {
        final /* synthetic */ b ekt;
        final /* synthetic */ long eku;
        final /* synthetic */ long ekv;

        AnonymousClass4(b bVar, long j, long j2) {
            this.ekt = bVar;
            this.eku = j;
            this.ekv = j2;
        }

        public final void run() {
            this.ekt.ekp.a(this.eku, this.ekv, this.ekt.ekr, false);
        }
    }

    public interface a {
        void p(int i, long j);
    }

    public interface b {
        void Wh();

        void q(int i, long j);
    }

    public interface c {
        void a(long j, long j2, ArrayList<a> arrayList, boolean z);

        void p(ArrayList<a> arrayList);
    }

    public b(b bVar, c cVar) {
        this.eko = bVar;
        this.ekp = cVar;
        this.ekq = null;
        this.handler = new ac(Looper.getMainLooper());
    }

    public final List<String> b(PLong pLong, PInt pInt) {
        pInt.value = 0;
        pLong.value = 0;
        this.efQ = new LinkedList();
        y yVar = new y();
        yVar.begin();
        long currentTimeMillis = System.currentTimeMillis();
        Cursor b = com.tencent.mm.plugin.backup.g.b.Vd().wK().b(m.crA, g.Vw(), "*");
        if (b.getCount() == 0) {
            b.close();
            yVar.end();
            if (this.cAv) {
                return null;
            }
            return this.efQ;
        }
        b.moveToFirst();
        v.i("MicroMsg.BakCalculatorMove", "calcItems userCnt at conv:%d", Integer.valueOf(b.getCount()));
        while (!this.cAv) {
            af abVar = new ab();
            abVar.b(b);
            if (!be.kS(abVar.field_username)) {
                int MW = com.tencent.mm.plugin.backup.g.b.Vd().wJ().MW(abVar.field_username);
                v.i("MicroMsg.BakCalculatorMove", "calcItems user:%s msgCnt:%d", abVar.field_username, Integer.valueOf(MW));
                if (MW > 0) {
                    pInt.value = MW + pInt.value;
                    ak.yW();
                    if (!u.vd(com.tencent.mm.model.c.wH().LX(abVar.field_username).field_verifyFlag)) {
                        this.efQ.add(abVar.field_username);
                    }
                }
            }
            if (!b.moveToNext()) {
                final PLong pLong2;
                b.close();
                String str = (String) com.tencent.mm.plugin.backup.g.b.Vd().vf().get(2, null);
                int i = 0;
                int i2 = 0;
                for (String MQ : this.efQ) {
                    int i3;
                    Cursor MQ2 = com.tencent.mm.plugin.backup.g.b.Vd().wJ().MQ(MQ);
                    v.i("MicroMsg.BakCalculatorMove", "calcItems user:%s msgCnt:%d[cu.getCount]", MQ, Integer.valueOf(MQ2.getCount()));
                    long j = pLong.value;
                    if (MQ2.moveToFirst()) {
                        int i4 = i2;
                        int i5 = i;
                        while (!MQ2.isAfterLast()) {
                            if (this.cAv) {
                                v.i("MicroMsg.BakCalculatorMove", "calcItems cancel, return");
                                MQ2.close();
                                return null;
                            }
                            at atVar = new at();
                            atVar.b(MQ2);
                            try {
                                d.a(atVar, true, str, pLong, null, false);
                            } catch (Throwable e) {
                                v.a("MicroMsg.BakCalculatorMove", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                            }
                            i = i5 + 1;
                            i2 = (int) ((((long) i) * 100) / ((long) pInt.value));
                            v.i("MicroMsg.BakCalculatorMove", "temPro, progress, tempCnt, pCount.value:  %d, %d, %d, %d", Integer.valueOf(i2), Integer.valueOf(i4), Integer.valueOf(i), Integer.valueOf(pInt.value));
                            if (this.eko == null || i2 <= i4) {
                                i2 = i4;
                            } else if (1 == this.eak) {
                                this.ekq.p(i2, pLong.value);
                            } else if (2 == this.eak) {
                                pLong2 = pLong;
                                this.handler.post(new Runnable(this) {
                                    final /* synthetic */ b ekt;

                                    public final void run() {
                                        this.ekt.eko.q(i2, pLong2.value);
                                    }
                                });
                            }
                            MQ2.moveToNext();
                            i4 = i2;
                            i5 = i;
                        }
                        i3 = i4;
                        i2 = i5;
                    } else {
                        i3 = i2;
                        i2 = i;
                    }
                    MQ2.close();
                    v.i("MicroMsg.BakCalculatorMove", "calc user:%s,  itemSize:%d, addupSize:%d, totalCount:%d", MQ, Long.valueOf(pLong.value - j), Long.valueOf(pLong.value), Integer.valueOf(pInt.value));
                    i = i2;
                    i2 = i3;
                }
                v.i("MicroMsg.BakCalculatorMove", "calc all, addupSize:%d, totalCount:%d, userSize:%d", Long.valueOf(pLong.value), Integer.valueOf(pInt.value), Integer.valueOf(this.efQ.size()));
                if (1 == this.eak) {
                    this.ekq.p(100, pLong.value);
                } else if (2 == this.eak && this.eko != null) {
                    pLong2 = pLong;
                    this.handler.post(new Runnable(this) {
                        final /* synthetic */ b ekt;

                        public final void run() {
                            this.ekt.eko.q(100, pLong2.value);
                            this.ekt.eko.Wh();
                        }
                    });
                }
                yVar.end();
                v.d("MicroMsg.BakCalculatorMove", "loading  " + (System.currentTimeMillis() - currentTimeMillis));
                if (this.cAv) {
                    return null;
                }
                return this.efQ;
            }
        }
        b.close();
        return null;
    }

    final boolean a(PLong pLong, PInt pInt, String str, long j, PLong pLong2, String str2) {
        Cursor MQ = com.tencent.mm.plugin.backup.g.b.Vd().wJ().MQ(str2);
        v.i("MicroMsg.BakCalculatorMove", "calcItemsToChoose user:%s msgCnt:%d[cu.getCount]", str2, Integer.valueOf(MQ.getCount()));
        if (MQ.moveToFirst()) {
            a aVar = new a();
            aVar.username = str2;
            pLong.value = 0;
            pInt.value = 0;
            while (!MQ.isAfterLast()) {
                if (this.cAv) {
                    v.i("MicroMsg.BakCalculatorMove", "calcItemsToChoose cancel, return");
                    MQ.close();
                    g.q(this.ekr);
                    return true;
                }
                at atVar = new at();
                atVar.b(MQ);
                try {
                    d.a(atVar, true, str, pLong, null, false);
                } catch (Throwable e) {
                    v.a("MicroMsg.BakCalculatorMove", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                }
                pInt.value++;
                MQ.moveToNext();
            }
            aVar.beE = pLong.value;
            aVar.dnm = (long) pInt.value;
            this.ekr.add(aVar);
            pLong2.value++;
            v.i("MicroMsg.BakCalculatorMove", "calcItemsToChoose calitem user:%s,  convSize:%d, convCount:%d", str2, Long.valueOf(pLong.value), Integer.valueOf(pInt.value));
        }
        if (this.ekp != null) {
            final long j2 = pLong2.value;
            if (1 != this.eak && 2 == this.eak) {
                final long j3 = j;
                this.handler.post(new Runnable(this) {
                    final /* synthetic */ b ekt;

                    public final void run() {
                        if (j2 % ((long) b.eaq) == 0) {
                            this.ekt.ekp.a(j2, j3, this.ekt.ekr, true);
                        } else {
                            this.ekt.ekp.a(j2, j3, this.ekt.ekr, false);
                        }
                    }
                });
            }
        }
        MQ.close();
        return false;
    }
}
