package com.tencent.mm.plugin.backup.backupmodel;

import android.database.Cursor;
import android.os.Looper;
import com.tencent.mm.e.b.af;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.m;
import com.tencent.mm.plugin.backup.g.g;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.u;
import java.util.Iterator;
import java.util.LinkedList;

public final class b {
    private static int eaq = 8;
    boolean cAv = false;
    private final int eak = 1;
    private final c eal = null;
    final a eam;
    private final d ean;
    private final b eao;
    LinkedList<String> eap;
    final ac handler;

    public interface a {
        void s(LinkedList<String> linkedList);
    }

    public interface b {
    }

    public interface c {
    }

    public interface d {
    }

    public b(b bVar, a aVar) {
        this.eam = aVar;
        this.ean = null;
        this.eao = bVar;
        this.handler = new ac(Looper.getMainLooper());
    }

    public final void cancel() {
        v.i("MicroMsg.BackupCalculator", "calculator cancel.");
        v.d("MicroMsg.BackupCalculator", "calculator cancel. stack:%s", be.bur());
        this.cAv = true;
    }

    public final LinkedList<String> a(PLong pLong, PInt pInt) {
        pInt.value = 0;
        pLong.value = 0;
        this.eap = new LinkedList();
        long currentTimeMillis = System.currentTimeMillis();
        Cursor b = com.tencent.mm.plugin.backup.g.b.Vd().wK().b(m.crA, g.Vw(), "*");
        if (b.getCount() == 0) {
            b.close();
            if (this.cAv) {
                return null;
            }
            return this.eap;
        }
        b.moveToFirst();
        v.i("MicroMsg.BackupCalculator", "calcItems userCnt at conv:%d", Integer.valueOf(b.getCount()));
        while (!this.cAv) {
            af abVar = new ab();
            abVar.b(b);
            if (!be.kS(abVar.field_username)) {
                int MW = com.tencent.mm.plugin.backup.g.b.Vd().wJ().MW(abVar.field_username);
                v.i("MicroMsg.BackupCalculator", "calculConv user:%s convMsgCount:%d", abVar.field_username, Integer.valueOf(MW));
                if (MW > 0) {
                    pInt.value = MW + pInt.value;
                    ak.yW();
                    if (!u.vd(com.tencent.mm.model.c.wH().LX(abVar.field_username).field_verifyFlag)) {
                        this.eap.add(abVar.field_username);
                    }
                }
            }
            if (!b.moveToNext()) {
                final PLong pLong2;
                b.close();
                String str = (String) com.tencent.mm.plugin.backup.g.b.Vd().vf().get(2, null);
                Iterator it = this.eap.iterator();
                int i = 0;
                int i2 = 0;
                while (it.hasNext()) {
                    int i3;
                    Cursor MQ = com.tencent.mm.plugin.backup.g.b.Vd().wJ().MQ((String) it.next());
                    v.i("MicroMsg.BackupCalculator", "calcItems user:%s msgCnt:%d[cu.getCount]", r8, Integer.valueOf(MQ.getCount()));
                    long j = pLong.value;
                    if (MQ.moveToFirst()) {
                        int i4 = i2;
                        int i5 = i;
                        while (!MQ.isAfterLast()) {
                            if (this.cAv) {
                                v.i("MicroMsg.BackupCalculator", "calcItems cancel, return");
                                MQ.close();
                                return null;
                            }
                            at atVar = new at();
                            atVar.b(MQ);
                            try {
                                com.tencent.mm.plugin.backup.g.d.a(atVar, true, str, pLong, null, false);
                            } catch (Throwable e) {
                                v.a("MicroMsg.BackupCalculator", e, "packedMsg", new Object[0]);
                            }
                            i = i5 + 1;
                            i2 = (int) ((((long) i) * 100) / ((long) pInt.value));
                            v.i("MicroMsg.BackupCalculator", "temPro, progress, tempCnt, msgCount.value:  %d, %d, %d, %d", Integer.valueOf(i2), Integer.valueOf(i4), Integer.valueOf(i), Integer.valueOf(pInt.value));
                            if (this.eal == null || i2 <= i4) {
                                i2 = i4;
                            } else if (1 != this.eak && 2 == this.eak) {
                                pLong2 = pLong;
                                this.handler.post(new Runnable(this) {
                                    final /* synthetic */ b eat;

                                    public final void run() {
                                    }
                                });
                            }
                            MQ.moveToNext();
                            i4 = i2;
                            i5 = i;
                        }
                        i3 = i4;
                        i2 = i5;
                    } else {
                        i3 = i2;
                        i2 = i;
                    }
                    MQ.close();
                    v.i("MicroMsg.BackupCalculator", "calc user:%s,  itemSize:%d, backupDataSize:%d, msgCount:%d", r8, Long.valueOf(pLong.value - j), Long.valueOf(pLong.value), Integer.valueOf(pInt.value));
                    i = i2;
                    i2 = i3;
                }
                v.i("MicroMsg.BackupCalculator", "calc all, backupDataSize:%d, msgCount:%d, userSize:%d", Long.valueOf(pLong.value), Integer.valueOf(pInt.value), Integer.valueOf(this.eap.size()));
                if (!(1 == this.eak || 2 != this.eak || this.eal == null)) {
                    pLong2 = pLong;
                    this.handler.post(new Runnable(this) {
                        final /* synthetic */ b eat;

                        public final void run() {
                        }
                    });
                }
                v.d("MicroMsg.BackupCalculator", "loading  " + (System.currentTimeMillis() - currentTimeMillis));
                return this.cAv ? null : this.eap;
            }
        }
        b.close();
        return null;
    }
}
