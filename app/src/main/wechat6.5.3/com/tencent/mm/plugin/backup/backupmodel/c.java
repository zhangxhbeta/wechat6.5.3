package com.tencent.mm.plugin.backup.backupmodel;

import android.database.Cursor;
import android.os.Looper;
import com.tencent.mm.e.b.af;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.m;
import com.tencent.mm.plugin.backup.backupmodel.b.a;
import com.tencent.mm.plugin.backup.g.b;
import com.tencent.mm.plugin.backup.g.g;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.sdk.i.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.u;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;

public final class c implements a {
    private static ArrayList<com.tencent.mm.plugin.backup.movemodel.a> eaA = null;
    public static boolean eaB = false;
    private static LinkedList<String> eap = null;
    private static ArrayList<com.tencent.mm.plugin.backup.movemodel.a> eaw = new ArrayList();
    private static boolean eax = false;
    private static boolean eay = false;
    private static LinkedList<String> eaz = null;
    private com.tencent.mm.plugin.backup.backuppcmodel.a.c eaC;
    private b eau;
    public a eav;
    private ac handler;
    private Object lock = new Object();

    public final void a(com.tencent.mm.plugin.backup.backuppcmodel.a.c cVar) {
        this.eaC = cVar;
        this.handler = new ac(Looper.getMainLooper());
    }

    public final void bK(boolean z) {
        eaB = z;
        if (this.eaC != null) {
            this.handler.post(new Runnable(this) {
                final /* synthetic */ c eaD;

                {
                    this.eaD = r1;
                }

                public final void run() {
                    this.eaD.eaC.bM(true);
                }
            });
        }
        b.a(new b.a(this) {
            final /* synthetic */ c eaD;

            {
                this.eaD = r1;
            }

            public final void run() {
                if (this.eaD.eaC != null) {
                    this.eaD.handler.post(new Runnable(this) {
                        final /* synthetic */ AnonymousClass2 eaE;

                        {
                            this.eaE = r1;
                        }

                        public final void run() {
                            this.eaE.eaD.eaC.bM(false);
                        }
                    });
                }
                if (this.eiS) {
                    e.a(new Runnable(this.eaD) {
                        final /* synthetic */ c eaD;

                        {
                            this.eaD = r1;
                        }

                        public final void run() {
                            if (this.eaD.eau != null) {
                                this.eaD.eau.cancel();
                            }
                            this.eaD.eau = new b(null, this.eaD);
                            b d = this.eaD.eau;
                            long currentTimeMillis = System.currentTimeMillis();
                            d.eap = new LinkedList();
                            Cursor b = b.Vd().wK().b(m.crA, g.Vw(), "*");
                            if (b.getCount() == 0) {
                                if (d.eam != null) {
                                    d.handler.post(new Runnable(d) {
                                        final /* synthetic */ b eat;

                                        {
                                            this.eat = r1;
                                        }

                                        public final void run() {
                                            this.eat.eam.s(this.eat.eap);
                                        }
                                    });
                                }
                                v.i("MicroMsg.BackupCalculator", "empty conversation!");
                                b.close();
                                return;
                            }
                            b.moveToFirst();
                            v.i("MicroMsg.BackupCalculator", "calculChooseConv userCnt at conv:%d", Integer.valueOf(b.getCount()));
                            while (!d.cAv) {
                                af abVar = new ab();
                                abVar.b(b);
                                if (!be.kS(abVar.field_username)) {
                                    v.i("MicroMsg.BackupCalculator", "calculChooseConv user:%s msgCnt:%d", abVar.field_username, Integer.valueOf(b.Vd().wJ().MW(abVar.field_username)));
                                    if (b.Vd().wJ().MW(abVar.field_username) > 0) {
                                        ak.yW();
                                        if (!u.vd(com.tencent.mm.model.c.wH().LX(abVar.field_username).field_verifyFlag)) {
                                            d.eap.add(abVar.field_username);
                                        }
                                    }
                                }
                                if (!b.moveToNext()) {
                                    b.close();
                                    c.t(d.eap);
                                    if (d.eam != null) {
                                        d.handler.post(new Runnable(d) {
                                            final /* synthetic */ b eat;

                                            {
                                                this.eat = r1;
                                            }

                                            public final void run() {
                                                this.eat.eam.s(this.eat.eap);
                                            }
                                        });
                                    }
                                    v.d("MicroMsg.BackupCalculator", "calculChooseConv loading time:" + (System.currentTimeMillis() - currentTimeMillis));
                                    return;
                                }
                            }
                            b.close();
                        }
                    }, "BackupChooseServer.calculate");
                    return;
                }
                v.e("MicroMsg.BackupChooseServer", "init TempDB error, not enough space.");
                b.UL().h(this.dbSize, this.eiU);
                b.UM().hU(-9);
                com.tencent.mm.plugin.report.service.g.iuh.a(400, 61, 1, false);
                com.tencent.mm.plugin.report.service.g.iuh.h(13736, Integer.valueOf(MMGIFException.D_GIF_ERR_NOT_GIF_FILE), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1));
            }
        }, false);
    }

    public static ArrayList<com.tencent.mm.plugin.backup.movemodel.a> Tu() {
        if (eaw == null) {
            eaw = new ArrayList();
        }
        return eaw;
    }

    public static void Tv() {
        if (eaw != null) {
            eaw.clear();
        }
        eaz = null;
        eaA = null;
        eax = false;
        eay = false;
    }

    public static void t(LinkedList<String> linkedList) {
        eap = new LinkedList(linkedList);
    }

    public static LinkedList<String> Tw() {
        if (eap == null) {
            eap = new LinkedList();
        }
        return eap;
    }

    public static void u(LinkedList<String> linkedList) {
        if (linkedList == null || linkedList.size() == 0) {
            eaz = new LinkedList();
            return;
        }
        LinkedList linkedList2 = new LinkedList(linkedList.subList((linkedList.size() * 3) / 4, linkedList.size()));
        eaz = linkedList2;
        linkedList2.addAll(linkedList.subList(0, (linkedList.size() * 3) / 4));
    }

    private static LinkedList<String> Tx() {
        if (eaz == null) {
            eaz = new LinkedList();
        }
        return eaz;
    }

    public static boolean Ty() {
        return eax;
    }

    public final void cancel() {
        v.i("MicroMsg.BackupChooseServer", "cancel, stack:%s", be.bur());
        synchronized (this.lock) {
            if (this.eau != null) {
                this.eau.cancel();
                this.eau = null;
            }
            com.tencent.mm.a.e.e(new File(b.Vj()));
            eax = false;
            eay = false;
        }
    }

    public final void s(LinkedList<String> linkedList) {
        if (linkedList == null || linkedList.size() == 0) {
            if (this.eav != null) {
                this.eav.s(linkedList);
            }
            if (eaB) {
                b.UM();
                com.tencent.mm.plugin.backup.backuppcmodel.c.TZ();
                b.UM().hU(-13);
                return;
            }
            return;
        }
        v.i("MicroMsg.BackupChooseServer", "summerbak onCalcuConvFinish, calAllConvNames size:%s", Integer.valueOf(linkedList.size()));
        t(linkedList);
        if (eaB) {
            u(linkedList);
            b.UM().v(Tx());
            b.UM().aD((long) Tx().size());
            this.eav = null;
        }
        if (this.eav != null) {
            this.eav.s(linkedList);
        }
        eax = true;
    }
}
