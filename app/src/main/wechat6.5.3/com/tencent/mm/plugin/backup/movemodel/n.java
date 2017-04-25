package com.tencent.mm.plugin.backup.movemodel;

import android.os.Looper;
import com.tencent.mm.e.a.oz;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.backup.backuppcmodel.a.c;
import com.tencent.mm.plugin.backup.f.h;
import com.tencent.mm.plugin.backup.g.b.a;
import com.tencent.mm.plugin.backup.g.y;
import com.tencent.mm.plugin.zero.a.d;
import com.tencent.mm.protocal.c.dy;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.i.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.k;
import com.tencent.mm.storage.t;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public final class n {
    static int eak;
    private boolean cAv;
    public c eaC;
    final int ebg;
    private long ece = 0;
    private boolean egL = false;
    f ekw;
    private long elA = 0;
    d elB = ((d) g.f(d.class));
    private com.tencent.mm.sdk.c.c<oz> elC;
    final List<String> elu;
    List<String> elv = new LinkedList();
    int elw = 0;
    int elx = 0;
    int ely = 0;
    int elz = 0;
    private Object lock = new Object();

    public n(List<String> list, int i) {
        v.i("MicroMsg.RecoverMerger", "new RecoverMerger, msgDataIdList size:%d, totalSession:%d", Integer.valueOf(list.size()), Integer.valueOf(i));
        this.elu = list;
        this.ebg = i;
        this.elv.clear();
    }

    public final synchronized void im(int i) {
        if (this.egL) {
            v.e("MicroMsg.RecoverMerger", "hasStartMerge , return");
        } else {
            this.egL = true;
            v.i("MicroMsg.RecoverMerger", "start merge and call pause sync");
            eak = i;
            if (this.elC == null) {
                this.elC = new com.tencent.mm.sdk.c.c<oz>(this) {
                    final /* synthetic */ n elD;

                    {
                        this.elD = r2;
                        this.nhz = oz.class.getName().hashCode();
                    }

                    public final /* synthetic */ boolean a(b bVar) {
                        if (this.elD.elB.bmm().Ac()) {
                            this.elD.Ws();
                            v.i("MicroMsg.RecoverMerger", "sync pause and start init tempdb");
                            if (this.elD.eaC != null) {
                                this.elD.eaC.bM(true);
                            }
                            com.tencent.mm.plugin.backup.g.b.a(new a(this) {
                                final /* synthetic */ AnonymousClass1 elE;

                                {
                                    this.elE = r1;
                                }

                                public final void run() {
                                    if (this.elE.elD.eaC != null) {
                                        this.elE.elD.eaC.bM(false);
                                    }
                                    n nVar = this.elE.elD;
                                    ak.yW();
                                    com.tencent.mm.model.c.vf().a(t.a.USERINFO_BACKUP_PC_MERGERING_BOOLEAN, Boolean.valueOf(true));
                                    nVar.elw = nVar.getItemCount();
                                    v.i("MicroMsg.RecoverMerger", "readFromSdcard start, sessionSize:%d , itemCnt:%d", Integer.valueOf(nVar.ebg), Integer.valueOf(nVar.elw));
                                    e.d(new Runnable(nVar) {
                                        final /* synthetic */ n elD;

                                        {
                                            this.elD = r1;
                                        }

                                        public final void run() {
                                            Looper.prepare();
                                            h.reset();
                                            h.UI();
                                            y yVar = new y();
                                            yVar.begin();
                                            HashMap hashMap = new HashMap();
                                            HashSet hashSet = new HashSet();
                                            int i = 0;
                                            for (String str : this.elD.elu) {
                                                String str2 = com.tencent.mm.plugin.backup.g.b.Vj() + "mmbakItem/" + com.tencent.mm.plugin.backup.g.g.pd(str) + str;
                                                try {
                                                    long currentTimeMillis = System.currentTimeMillis();
                                                    int a = this.elD.a(str2, hashMap, yVar, hashSet);
                                                    n nVar = this.elD;
                                                    nVar.ely = (int) ((System.currentTimeMillis() - currentTimeMillis) + ((long) nVar.ely));
                                                    if (a < 0) {
                                                        yVar.end();
                                                        v.w("MicroMsg.RecoverMerger", "Thread has been canceled");
                                                        return;
                                                    }
                                                    i += a;
                                                    this.elD.bk(i, this.elD.elw);
                                                    v.i("MicroMsg.RecoverMerger", "recover has done,  msgsuccItem:%d, dealCount:%d, totalCnt:%d", Integer.valueOf(i), Integer.valueOf(this.elD.elz), Integer.valueOf(this.elD.elw));
                                                    com.tencent.mm.sdk.h.c kVar = new k();
                                                    kVar.field_msgDataId = str;
                                                    if (ak.yW().xy().b(kVar, new String[0])) {
                                                        if (!this.elD.elv.contains(kVar.field_bakchatName)) {
                                                            this.elD.elv.add(kVar.field_bakchatName);
                                                        }
                                                        com.tencent.mm.plugin.backup.g.b.UL();
                                                        com.tencent.mm.plugin.backup.backuppcmodel.a.hO(10);
                                                        com.tencent.mm.plugin.backup.g.b.UL().ebf = this.elD.elv.size() > this.elD.ebg ? this.elD.ebg : this.elD.elv.size();
                                                        com.tencent.mm.plugin.backup.g.b.UL().ebg = this.elD.ebg;
                                                        if (this.elD.eaC != null) {
                                                            this.elD.eaC.TS();
                                                        }
                                                    }
                                                } catch (Throwable e) {
                                                    v.a("MicroMsg.RecoverMerger", e, "recoverFromSdcard MMThread.run():", new Object[0]);
                                                }
                                            }
                                            this.elD.elx = hashSet.size();
                                            com.tencent.mm.plugin.backup.i.a.b(hashMap);
                                            v.i("MicroMsg.RecoverMerger", "build temDB finish!");
                                            yVar.end();
                                            this.elD.bk(100, 100);
                                            com.tencent.mm.plugin.backup.g.b.UL().ebf = this.elD.elv.size() > this.elD.ebg ? this.elD.ebg : this.elD.elv.size();
                                            com.tencent.mm.plugin.backup.g.b.UL().ebg = this.elD.ebg;
                                            v.bta();
                                            com.tencent.mm.plugin.backup.g.b.h(new Runnable(this) {
                                                final /* synthetic */ AnonymousClass2 elF;

                                                {
                                                    this.elF = r1;
                                                }

                                                public final void run() {
                                                    v.i("MicroMsg.RecoverMerger", "readFromSdcard end");
                                                    v.bta();
                                                    if (n.eak != 2 || this.elF.elD.ekw == null) {
                                                        v.i("MicroMsg.RecoverMerger", "operatorCallback is null");
                                                    } else {
                                                        this.elF.elD.ekw.UC();
                                                    }
                                                    this.elF.elD.elB.bmm().zY();
                                                    this.elF.elD.Ws();
                                                    v.i("MicroMsg.RecoverMerger", "recover ok and restart sync");
                                                    ak.yW();
                                                    com.tencent.mm.model.c.vf().a(t.a.USERINFO_BACKUP_PC_MERGERING_BOOLEAN, Boolean.valueOf(false));
                                                    if (n.eak == 1) {
                                                        com.tencent.mm.plugin.backup.backuppcmodel.b UN = com.tencent.mm.plugin.backup.g.b.UN();
                                                        UN.TV();
                                                        UN.hU(11);
                                                        com.tencent.mm.plugin.report.service.g.iuh.a(400, 27, 1, false);
                                                    }
                                                    this.elF.elD.Wr();
                                                    com.tencent.mm.plugin.backup.g.b.UL().TM();
                                                }
                                            });
                                            Looper.loop();
                                        }
                                    }, "RecoverMerger_recoverFromSdcard", 1).start();
                                }
                            }, true);
                        }
                        return false;
                    }
                };
                com.tencent.mm.sdk.c.a.nhr.e(this.elC);
            }
            this.elB.bmm().zX();
            com.tencent.mm.plugin.backup.g.b.UL().TL();
        }
    }

    public final int getItemCount() {
        int i = 0;
        for (String str : this.elu) {
            try {
                i = ((dy) new dy().az(com.tencent.mm.a.e.d(com.tencent.mm.plugin.backup.g.b.Vj() + "mmbakItem/" + com.tencent.mm.plugin.backup.g.g.pd(str) + str, 0, -1))).eeu.size() + i;
            } catch (Throwable e) {
                v.a("MicroMsg.RecoverMerger", e, "getItemCount: ", new Object[0]);
            }
        }
        return i;
    }

    final void bk(final int i, final int i2) {
        if (this.ece == 0 || be.az(this.ece) >= 100) {
            this.ece = be.Nj();
            if (!this.cAv && this.ekw != null) {
                ad.o(new Runnable(this) {
                    final /* synthetic */ n elD;

                    public final void run() {
                        if (this.elD.ekw != null) {
                            this.elD.ekw.bn(i, i2);
                        } else {
                            v.e("MicroMsg.RecoverMerger", "operatorCallback is null.");
                        }
                    }
                });
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    final int a(java.lang.String r11, java.util.HashMap<java.lang.String, java.lang.Integer> r12, com.tencent.mm.plugin.backup.g.y r13, java.util.HashSet<java.lang.String> r14) {
        /*
        r10 = this;
        r2 = java.lang.System.currentTimeMillis();
        r0 = 0;
        r1 = -1;
        r4 = com.tencent.mm.a.e.d(r11, r0, r1);
        r0 = new com.tencent.mm.protocal.c.dy;	 Catch:{ Exception -> 0x0054 }
        r0.<init>();	 Catch:{ Exception -> 0x0054 }
        r0 = r0.az(r4);	 Catch:{ Exception -> 0x0054 }
        r0 = (com.tencent.mm.protocal.c.dy) r0;	 Catch:{ Exception -> 0x0054 }
        r1 = r0.eeu;
        r4 = r1.iterator();
    L_0x001b:
        r1 = r4.hasNext();
        if (r1 == 0) goto L_0x00be;
    L_0x0021:
        r1 = r4.next();
        r1 = (com.tencent.mm.protocal.c.dx) r1;
        r5 = r10.lock;
        monitor-enter(r5);
        r6 = r10.cAv;	 Catch:{ all -> 0x00ad }
        if (r6 == 0) goto L_0x0076;
    L_0x002e:
        r0 = com.tencent.mm.plugin.report.service.g.iuh;	 Catch:{ all -> 0x00ad }
        r1 = 11790; // 0x2e0e float:1.6521E-41 double:5.825E-320;
        r2 = 2;
        r2 = new java.lang.Object[r2];	 Catch:{ all -> 0x00ad }
        r3 = 0;
        r4 = 0;
        r4 = java.lang.Integer.valueOf(r4);	 Catch:{ all -> 0x00ad }
        r2[r3] = r4;	 Catch:{ all -> 0x00ad }
        r3 = 1;
        r4 = 0;
        r4 = java.lang.Integer.valueOf(r4);	 Catch:{ all -> 0x00ad }
        r2[r3] = r4;	 Catch:{ all -> 0x00ad }
        r0.h(r1, r2);	 Catch:{ all -> 0x00ad }
        r0 = "MicroMsg.RecoverMerger";
        r1 = "backupImp canceled";
        com.tencent.mm.sdk.platformtools.v.i(r0, r1);	 Catch:{ all -> 0x00ad }
        r0 = -1;
        monitor-exit(r5);	 Catch:{ all -> 0x00ad }
    L_0x0053:
        return r0;
    L_0x0054:
        r0 = move-exception;
        r1 = r0;
        r2 = "MicroMsg.RecoverMerger";
        r3 = "read mmPath errr %s, %s, len:%d";
        r0 = 3;
        r5 = new java.lang.Object[r0];
        r0 = 0;
        r5[r0] = r11;
        r0 = 1;
        r5[r0] = r1;
        r6 = 2;
        if (r4 != 0) goto L_0x0074;
    L_0x0068:
        r0 = 0;
    L_0x0069:
        r0 = java.lang.Integer.valueOf(r0);
        r5[r6] = r0;
        com.tencent.mm.sdk.platformtools.v.a(r2, r1, r3, r5);
        r0 = 0;
        goto L_0x0053;
    L_0x0074:
        r0 = r4.length;
        goto L_0x0069;
    L_0x0076:
        r6 = r10.elA;	 Catch:{ all -> 0x00ad }
        r6 = com.tencent.mm.sdk.platformtools.be.ay(r6);	 Catch:{ all -> 0x00ad }
        r8 = 1800000; // 0x1b7740 float:2.522337E-39 double:8.89318E-318;
        r6 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1));
        if (r6 <= 0) goto L_0x0092;
    L_0x0083:
        r6 = r10.elB;	 Catch:{ all -> 0x00ad }
        r6 = r6.bmm();	 Catch:{ all -> 0x00ad }
        r6.zX();	 Catch:{ all -> 0x00ad }
        r6 = com.tencent.mm.sdk.platformtools.be.Ni();	 Catch:{ all -> 0x00ad }
        r10.elA = r6;	 Catch:{ all -> 0x00ad }
    L_0x0092:
        monitor-exit(r5);	 Catch:{ all -> 0x00ad }
        com.tencent.mm.plugin.backup.g.w.a(r1, r12, r14);	 Catch:{ Exception -> 0x00b0 }
    L_0x0096:
        r5 = r10.elz;
        r5 = r5 + 1;
        r10.elz = r5;
        r5 = r10.elz;
        r6 = r10.elw;
        r10.bk(r5, r6);
        r1 = r1.efm;
        com.tencent.mm.plugin.backup.f.h.ie(r1);
        r13.Wd();
        goto L_0x001b;
    L_0x00ad:
        r0 = move-exception;
        monitor-exit(r5);	 Catch:{ all -> 0x00ad }
        throw r0;
    L_0x00b0:
        r5 = move-exception;
        r6 = "MicroMsg.RecoverMerger";
        r7 = "readFromSdcard err";
        r8 = 0;
        r8 = new java.lang.Object[r8];
        com.tencent.mm.sdk.platformtools.v.a(r6, r5, r7, r8);
        goto L_0x0096;
    L_0x00be:
        com.tencent.mm.plugin.backup.f.h.UH();
        r1 = "MicroMsg.RecoverMerger";
        r4 = new java.lang.StringBuilder;
        r5 = "read item time ";
        r4.<init>(r5);
        r6 = java.lang.System.currentTimeMillis();
        r2 = r6 - r2;
        r2 = r4.append(r2);
        r2 = r2.toString();
        com.tencent.mm.sdk.platformtools.v.d(r1, r2);
        r0 = r0.eeu;
        r0 = r0.size();
        goto L_0x0053;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.backup.movemodel.n.a(java.lang.String, java.util.HashMap, com.tencent.mm.plugin.backup.g.y, java.util.HashSet):int");
    }

    public final void cancel() {
        synchronized (this.lock) {
            v.i("MicroMsg.RecoverMerger", "cancel");
            this.cAv = true;
            this.elB.bmm().zY();
            Ws();
            v.i("MicroMsg.RecoverMerger", "recover cancel and restart sync");
            Wr();
            com.tencent.mm.plugin.backup.g.b.UL().TM();
        }
    }

    final void Wr() {
        synchronized (this.lock) {
            this.lock.notifyAll();
        }
        this.ekw = null;
        this.egL = false;
        this.elw = 0;
        this.elx = 0;
        this.ely = 0;
    }

    final void Ws() {
        if (this.elC != null) {
            com.tencent.mm.sdk.c.a.nhr.f(this.elC);
            this.elC = null;
        }
    }
}
