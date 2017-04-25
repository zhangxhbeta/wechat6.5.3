package com.tencent.mm.plugin.backup.movemodel;

import com.tencent.mm.a.e;
import com.tencent.mm.a.k;
import com.tencent.mm.h.j;
import com.tencent.mm.plugin.backup.b.b.d;
import com.tencent.mm.plugin.backup.d.i;
import com.tencent.mm.plugin.backup.d.o;
import com.tencent.mm.plugin.backup.d.p;
import com.tencent.mm.plugin.backup.movemodel.b.b;
import com.tencent.mm.plugin.backup.moveui.BakMoveChooseUI;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.File;
import java.util.List;

public final class h implements d, b, f {
    b egg;
    c ela;
    private boolean elb = false;
    public f elc;
    public b eld;
    private a ele;
    List<String> elf;
    PLong elg;
    PInt elh;
    long eli;
    private boolean elj = true;
    public boolean elk = false;
    Object lock = new Object();

    class AnonymousClass2 implements Runnable {
        final /* synthetic */ int eag;
        final /* synthetic */ h ell;

        AnonymousClass2(h hVar, int i) {
            this.ell = hVar;
            this.eag = i;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            /*
            r10 = this;
            r8 = 0;
            r3 = 0;
            r7 = 1;
            r6 = 0;
            r0 = r10.ell;
            r0 = r0.elf;
            if (r0 == 0) goto L_0x0017;
        L_0x000b:
            r0 = r10.ell;
            r0 = r0.elg;
            if (r0 == 0) goto L_0x0017;
        L_0x0011:
            r0 = r10.ell;
            r0 = r0.elh;
            if (r0 != 0) goto L_0x0065;
        L_0x0017:
            r0 = r10.ell;
            r1 = new com.tencent.mm.pointers.PLong;
            r1.<init>();
            r0.elg = r1;
            r0 = r10.ell;
            r1 = new com.tencent.mm.pointers.PInt;
            r1.<init>();
            r0.elh = r1;
            r0 = r10.ell;
            r0 = r0.egg;
            if (r0 == 0) goto L_0x0035;
        L_0x002f:
            r0 = r10.ell;
            r0 = r0.egg;
            r0.cAv = r7;
        L_0x0035:
            r0 = r10.ell;
            r1 = new com.tencent.mm.plugin.backup.movemodel.b;
            r2 = r10.ell;
            r1.<init>(r2, r3);
            r0.egg = r1;
            r0 = r10.ell;
            r1 = r10.ell;
            r1 = r1.egg;
            r2 = r10.ell;
            r2 = r2.elg;
            r3 = r10.ell;
            r3 = r3.elh;
            r1 = r1.b(r2, r3);
            r0.elf = r1;
            r0 = r10.ell;
            r1 = r10.ell;
            r1 = r1.elf;
            r2 = r10.ell;
            r2 = r2.elg;
            r3 = r10.ell;
            r3 = r3.elh;
            r0.a(r1, r2, r3);
        L_0x0065:
            r0 = "MicroMsg.MoveBakServer";
            r1 = "transfer conversation size:%d, addupSize:%d, pCount:%d";
            r2 = 3;
            r2 = new java.lang.Object[r2];
            r3 = r10.ell;
            r3 = r3.elf;
            r3 = r3.size();
            r3 = java.lang.Integer.valueOf(r3);
            r2[r6] = r3;
            r3 = r10.ell;
            r3 = r3.elg;
            r4 = r3.value;
            r3 = java.lang.Long.valueOf(r4);
            r2[r7] = r3;
            r3 = 2;
            r4 = r10.ell;
            r4 = r4.elh;
            r4 = r4.value;
            r4 = java.lang.Integer.valueOf(r4);
            r2[r3] = r4;
            com.tencent.mm.sdk.platformtools.v.i(r0, r1, r2);
            r0 = r10.ell;
            r1 = r0.lock;
            monitor-enter(r1);
            r0 = r10.ell;	 Catch:{ all -> 0x0143 }
            r0 = r0.elf;	 Catch:{ all -> 0x0143 }
            if (r0 != 0) goto L_0x00aa;
        L_0x00a3:
            r0 = r10.ell;	 Catch:{ all -> 0x0143 }
            r2 = 0;
            r0.ela = r2;	 Catch:{ all -> 0x0143 }
            monitor-exit(r1);	 Catch:{ all -> 0x0143 }
        L_0x00a9:
            return;
        L_0x00aa:
            r0 = r10.ell;	 Catch:{ all -> 0x0143 }
            r0 = r0.ela;	 Catch:{ all -> 0x0143 }
            if (r0 == 0) goto L_0x00b7;
        L_0x00b0:
            r0 = r10.ell;	 Catch:{ all -> 0x0143 }
            r0 = r0.ela;	 Catch:{ all -> 0x0143 }
            r0.cancel();	 Catch:{ all -> 0x0143 }
        L_0x00b7:
            r0 = r10.ell;	 Catch:{ all -> 0x0143 }
            r2 = new com.tencent.mm.plugin.backup.movemodel.c;	 Catch:{ all -> 0x0143 }
            r2.<init>();	 Catch:{ all -> 0x0143 }
            r0.ela = r2;	 Catch:{ all -> 0x0143 }
            monitor-exit(r1);	 Catch:{ all -> 0x0143 }
            r1 = new com.tencent.mm.plugin.backup.d.i;
            r1.<init>();
            r0 = com.tencent.mm.plugin.backup.g.b.UZ();
            r1.ID = r0;
            r0 = r10.ell;
            r0 = r0.elh;
            r0 = r0.value;
            r2 = (long) r0;
            r1.eeM = r2;
            r0 = r10.ell;
            r0 = r0.elg;
            r2 = r0.value;
            r1.eeN = r2;
            r1.eeO = r6;
            r0 = r10.ell;
            r0 = r0.elk;
            if (r0 == 0) goto L_0x0146;
        L_0x00e5:
            r0 = com.tencent.mm.plugin.backup.movemodel.d.ekS;
        L_0x00e7:
            r1.eeP = r0;
            r0 = r1.toByteArray();	 Catch:{ IOException -> 0x0149 }
            r1 = 4;
            r2 = r10.eag;	 Catch:{ IOException -> 0x0149 }
            com.tencent.mm.plugin.backup.b.b.e(r0, r1, r2);	 Catch:{ IOException -> 0x0149 }
            r0 = r10.ell;
            r2 = r0.ela;
            r0 = r10.ell;
            r3 = r0.elf;
            r0 = r10.ell;
            r0 = r0.elg;
            r0 = r0.value;
            r2.efQ = r3;
            r2.beg = r6;
            r2.cAv = r6;
            r2.efU = r6;
            r3 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1));
            if (r3 != 0) goto L_0x0110;
        L_0x010d:
            r4 = 1;
            r0 = r0 + r4;
        L_0x0110:
            r2.efV = r0;
            r2.efW = r8;
            r2.efX = r6;
            r0 = r2.efR;
            r0.clear();
            com.tencent.mm.plugin.backup.e.b.setProgress(r6);
            r0 = r10.ell;
            r0 = r0.ela;
            r1 = r10.ell;
            r0.ekw = r1;
            r0 = r10.ell;
            r2 = java.lang.System.currentTimeMillis();
            r0.eli = r2;
            r0 = r10.ell;
            r0 = r0.ela;
            r1 = new com.tencent.mm.plugin.backup.movemodel.c$1;
            r1.<init>(r0);
            r0 = "BakPCServer_startBak";
            r0 = com.tencent.mm.sdk.i.e.d(r1, r0, r7);
            r0.start();
            goto L_0x00a9;
        L_0x0143:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x0143 }
            throw r0;
        L_0x0146:
            r0 = com.tencent.mm.plugin.backup.movemodel.d.ekR;
            goto L_0x00e7;
        L_0x0149:
            r0 = move-exception;
            r1 = "MicroMsg.MoveBakServer";
            r2 = "prase resp error!!";
            com.tencent.mm.sdk.platformtools.v.e(r1, r2);
            r1 = "MicroMsg.MoveBakServer";
            r2 = "";
            r3 = new java.lang.Object[r6];
            com.tencent.mm.sdk.platformtools.v.a(r1, r0, r2, r3);
            goto L_0x00a9;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.backup.movemodel.h.2.run():void");
        }
    }

    public interface a {
        void Wp();
    }

    public final void a(List<String> list, PLong pLong, PInt pInt) {
        this.elf = list;
        this.elg = pLong;
        this.elh = pInt;
    }

    public final void a(a aVar) {
        v.d("MicroMsg.MoveBakServer", "setOnAuthOK onAuthCb is null : " + (aVar == null));
        this.ele = aVar;
    }

    public final void bl(boolean z) {
        if (!z) {
            com.tencent.mm.plugin.backup.c.a aVar = new com.tencent.mm.plugin.backup.c.a();
            aVar.ID = com.tencent.mm.plugin.backup.g.b.UZ();
            try {
                com.tencent.mm.plugin.backup.b.b.r(aVar.toByteArray(), 5);
            } catch (Throwable e) {
                v.a("MicroMsg.MoveBakServer", e, SQLiteDatabase.KeyEmpty, new Object[0]);
            }
        }
        Wo();
    }

    private void Wo() {
        synchronized (this.lock) {
            if (this.egg != null) {
                this.egg.cAv = true;
                this.egg = null;
            }
            if (this.ela != null) {
                this.ela.cancel();
                this.ela = null;
            }
            e.e(new File(com.tencent.mm.plugin.backup.g.b.Vj()));
        }
    }

    public final void a(boolean z, int i, byte[] bArr, final int i2) {
        String str = "MicroMsg.MoveBakServer";
        String str2 = "onNotify isLocal:%b, type:%d, seq:%d, buf.len:%d";
        Object[] objArr = new Object[4];
        objArr[0] = Boolean.valueOf(z);
        objArr[1] = Integer.valueOf(i);
        objArr[2] = Integer.valueOf(i2);
        objArr[3] = Integer.valueOf(bArr == null ? 0 : bArr.length);
        v.i(str, str2, objArr);
        if (z) {
            onError(i, SQLiteDatabase.KeyEmpty);
        }
        if (i == 1) {
            o oVar = new o();
            try {
                oVar.az(bArr);
                v.i("MicroMsg.MoveBakServer", "req info, id:%s, step:%d", oVar.ID, Integer.valueOf(oVar.efk));
                byte[] bArr2 = oVar.eew.lVU;
                if (be.kS(com.tencent.mm.plugin.backup.g.b.UZ())) {
                    com.tencent.mm.plugin.backup.g.b.oW(oVar.ID);
                }
                if (oVar.ID.equals(com.tencent.mm.plugin.backup.g.b.UZ())) {
                    if (oVar.efk == 0) {
                        if ((oVar.efn & d.ekW) == 0) {
                            this.elj = false;
                        } else {
                            this.elj = true;
                        }
                        p pVar = new p();
                        pVar.efk = 0;
                        pVar.ID = com.tencent.mm.plugin.backup.g.b.UZ();
                        if (com.tencent.mm.plugin.backup.g.b.Va().equals(new String(k.b(bArr2, com.tencent.mm.plugin.backup.g.b.UV())))) {
                            v.i("MicroMsg.MoveBakServer", "get auth req stpe 0 and validate hello  success, and send ok");
                            pVar.eeO = 0;
                            pVar.eew = new com.tencent.mm.ba.b(k.c(com.tencent.mm.plugin.backup.g.b.Vb().getBytes(), com.tencent.mm.plugin.backup.g.b.UV()));
                            if (be.getInt(j.sU().getValue("ChattingRecordsKvstatDisable"), 0) == 0) {
                                pVar.efn |= d.ekW;
                            }
                        } else {
                            pVar.eeO = 1;
                            v.e("MicroMsg.MoveBakServer", "get auth req stpe 0 and valite failed, hello failed");
                        }
                        com.tencent.mm.plugin.backup.b.b.e(pVar.toByteArray(), 2, i2);
                    }
                    if (oVar.efk != 1) {
                        return;
                    }
                    if (com.tencent.mm.plugin.backup.g.b.Vb().equals(new String(k.b(bArr2, com.tencent.mm.plugin.backup.g.b.UV())))) {
                        v.i("MicroMsg.MoveBakServer", "get auth req step 1 and validate ok success");
                        this.elb = true;
                        if (this.ele != null) {
                            this.ele.Wp();
                            return;
                        } else {
                            v.w("MicroMsg.MoveBakServer", "onAuthCb is null.");
                            return;
                        }
                    }
                    v.e("MicroMsg.MoveBakServer", "get auth req stpe 1 and validate ok failed");
                    this.elb = false;
                    return;
                }
                v.e("MicroMsg.MoveBakServer", "id not equel:self:%s, req.id:%s", com.tencent.mm.plugin.backup.g.b.UZ(), oVar.ID);
            } catch (Throwable e) {
                this.elb = false;
                v.a("MicroMsg.MoveBakServer", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                v.e("MicroMsg.MoveBakServer", "parse bakauth req failed, %s", e);
            }
        } else if (this.elb) {
            if (i == 3) {
                q(0, 0);
                BakMoveChooseUI.elR = true;
                com.tencent.mm.plugin.backup.g.b.a(new com.tencent.mm.plugin.backup.g.b.a(this) {
                    final /* synthetic */ h ell;

                    public final void run() {
                        BakMoveChooseUI.elR = false;
                        if (this.eiS) {
                            h hVar = this.ell;
                            int i = i2;
                            List list = this.ell.elf;
                            PLong pLong = this.ell.elg;
                            PInt pInt = this.ell.elh;
                            hVar.elf = list;
                            hVar.elg = pLong;
                            hVar.elh = pInt;
                            com.tencent.mm.sdk.i.e.a(new AnonymousClass2(hVar, i), "MoveBakServer.calcelate");
                            return;
                        }
                        i iVar = new i();
                        iVar.ID = com.tencent.mm.plugin.backup.g.b.UZ();
                        iVar.eeM = 0;
                        iVar.eeN = 0;
                        iVar.eeO = 1;
                        iVar.eeP = this.ell.elk ? d.ekS : d.ekR;
                        try {
                            com.tencent.mm.plugin.backup.b.b.e(iVar.toByteArray(), 4, i2);
                        } catch (Throwable e) {
                            v.a("MicroMsg.MoveBakServer", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                        }
                        v.e("MicroMsg.MoveBakServer", "init TempDB error");
                        this.ell.onError(10012, this.dbSize + "," + (this.dbSize - this.eiU));
                    }
                }, false);
            }
            if (i == 5) {
                Wo();
            }
        } else {
            v.w("MicroMsg.MoveBakServer", "not resp nonAuth is inval status!!! type:%d, seq:%d", Integer.valueOf(i), Integer.valueOf(i2));
        }
    }

    public final void onError(int i, String str) {
        if (this.elc != null) {
            this.elc.onError(i, str);
        }
    }

    public final void b(long j, long j2, int i) {
        if (this.elc != null) {
            this.elc.b(j, j2, i);
        }
    }

    public final void bn(int i, int i2) {
    }

    public final void UB() {
        int currentTimeMillis = (int) (System.currentTimeMillis() - this.eli);
        com.tencent.mm.plugin.backup.c.b bVar = new com.tencent.mm.plugin.backup.c.b();
        bVar.ID = com.tencent.mm.plugin.backup.g.b.UZ();
        if (this.elj && be.getInt(j.sU().getValue("ChattingRecordsKvstatDisable"), 0) == 0) {
            bVar.eei = this.elf.size();
            bVar.eej = this.elh.value;
            bVar.eek = this.ela.ekz;
            bVar.eel = (int) (this.elg.value / 1024);
            bVar.eem = (int) (this.ela.ekA / 1024);
            bVar.een = this.ela.ekx;
            bVar.eeo = this.ela.eky;
            bVar.eep = currentTimeMillis;
            bVar.eeq = com.tencent.mm.protocal.d.lWh;
            v.i("MicroMsg.MoveBakServer", "NewBakMoveInfoKvstat, Server, ServerSessionCount:%d, ServerMessageCount:%d, ServerFileCount:%d, CalculateSize:%d, ServerDataPushSize:%d, ServerReadDBTotalTime:%d, ServerReadFileTotalTime:%d, ServerCostTotalTime:%d, ServerVersion:%x", Integer.valueOf(bVar.eei), Integer.valueOf(bVar.eej), Integer.valueOf(bVar.eek), Integer.valueOf(bVar.eel), Integer.valueOf(bVar.eem), Integer.valueOf(bVar.een), Integer.valueOf(bVar.eeo), Integer.valueOf(bVar.eep), Integer.valueOf(bVar.eeq));
        }
        try {
            com.tencent.mm.plugin.backup.b.b.r(bVar.toByteArray(), 8);
        } catch (Throwable e) {
            v.e("MicroMsg.MoveBakServer", "onNetFinish parse req failed");
            v.a("MicroMsg.MoveBakServer", e, SQLiteDatabase.KeyEmpty, new Object[0]);
        }
        if (this.elc != null) {
            this.elc.UB();
        }
    }

    public final void UC() {
        if (this.elc != null) {
            this.elc.UC();
        }
    }

    public final void q(int i, long j) {
        v.i("MicroMsg.MoveBakServer", "onCalcuProgress progress:%d, calcuSize%d", Integer.valueOf(i), Long.valueOf(j));
        if (this.eld != null) {
            this.eld.q(i, j);
        }
    }

    public final void Wh() {
        if (this.eld != null) {
            this.eld.Wh();
        }
    }
}
