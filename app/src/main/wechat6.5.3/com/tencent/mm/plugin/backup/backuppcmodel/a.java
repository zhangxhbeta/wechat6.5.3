package com.tencent.mm.plugin.backup.backuppcmodel;

import android.content.Intent;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.model.ak;
import com.tencent.mm.platformtools.q;
import com.tencent.mm.plugin.backup.g.g;
import com.tencent.mm.plugin.backup.h.i;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.protocal.c.li;
import com.tencent.mm.protocal.c.vb;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentLinkedQueue;

public final class a {
    private static int cxZ = 2;
    private static boolean ebA = false;
    private static boolean ebb = false;
    public int eaT = 1;
    String eaU;
    String eaV;
    public String eaW;
    String eaX;
    int eaY;
    private long eaZ = 0;
    final e ebB = new e(this) {
        final /* synthetic */ a ebE;

        {
            this.ebE = r1;
        }

        public final void a(int i, int i2, String str, k kVar) {
            ak.vy().b(595, this.ebE.ebB);
            if (i == 0 && i2 == 0) {
                vb WC = ((i) kVar).WC();
                ak.yW();
                if (be.ma((String) com.tencent.mm.model.c.vf().get(2, null)).equals(WC.meG)) {
                    com.tencent.mm.plugin.backup.b.b.a(this.ebE.eby);
                    com.tencent.mm.plugin.backup.b.b.a(this.ebE.ebx);
                    this.ebE.TL();
                    com.tencent.mm.plugin.backup.b.b.a(this.ebE.ebD);
                    com.tencent.mm.plugin.backup.b.b.a(com.tencent.mm.plugin.backup.g.b.UP());
                    com.tencent.mm.plugin.backup.b.b.setMode(1);
                    com.tencent.mm.plugin.backup.g.b.Q(WC.mes.mQw.lVU);
                    String str2 = null;
                    int i3 = 0;
                    if (q.dqL) {
                        str2 = q.dqM;
                        i3 = q.dqN;
                    } else if (WC.meD > 0) {
                        li liVar = (li) WC.meE.getFirst();
                        str2 = liVar.mnP;
                        i3 = ((Integer) liVar.mnQ.getFirst()).intValue();
                    } else {
                        v.e("MicroMsg.BackupPcProcessMgr", "summerbak address count is empty");
                    }
                    a UL = com.tencent.mm.plugin.backup.g.b.UL();
                    String str3 = WC.meF;
                    String str4 = WC.meG;
                    String str5 = WC.meH;
                    UL.eaU = str3;
                    UL.eaV = str4;
                    UL.eaW = str5;
                    UL.eaX = str2;
                    UL.eaY = i3;
                    v.i("MicroMsg.BackupPcProcessMgr", "summerbak getconnetinfo, type:%d, scene:%d, wifiName:%s, ip:%s, port:%d", Integer.valueOf(WC.efm), Integer.valueOf(WC.maG), WC.meH, str2, Integer.valueOf(i3));
                    com.tencent.mm.plugin.backup.g.b.UL();
                    a.hO(1);
                    Intent className = new Intent().setClassName(aa.getContext(), "com.tencent.mm.ui.LauncherUI");
                    className.addFlags(335544320);
                    className.putExtra("nofification_type", "back_to_pcmgr_notification");
                    aa.getContext().startActivity(className);
                    a.ebA = false;
                    v.i("MicroMsg.BackupPcProcessMgr", "summerbak try connct pc, pc ip:%s, pc wifi:%s, phone wifi:%s", str2, WC.meH, g.bw(aa.getContext()));
                    a.cxZ = 2;
                    this.ebE.ad(str2, i3);
                    return;
                }
                v.e("MicroMsg.BackupPcProcessMgr", "summerbak getConnectinfo not the same account");
                com.tencent.mm.plugin.backup.g.b.UM().hU(-8);
                com.tencent.mm.plugin.report.service.g.iuh.a(400, 5, 1, false);
                return;
            }
            v.i("MicroMsg.BackupPcProcessMgr", "summerbak getConnect info other error [%d,%d,%s]", Integer.valueOf(i), Integer.valueOf(i2), str);
            if (i == 4 && i2 == -2011) {
                v.e("MicroMsg.BackupPcProcessMgr", "summerbak getConnect info: INVALID URL");
            }
            com.tencent.mm.plugin.backup.g.b.UM().hU(-8);
        }
    };
    private final e ebC = new e(this) {
        final /* synthetic */ a ebE;

        {
            this.ebE = r1;
        }

        public final void a(int i, int i2, String str, k kVar) {
            a.ebA = true;
            com.tencent.mm.plugin.backup.b.b.b(1, this.ebE.ebC);
            if (i == 0 && i2 == 0) {
                v.i("MicroMsg.BackupPcProcessMgr", "summerbak auth success");
                return;
            }
            v.e("MicroMsg.BackupPcProcessMgr", "summerbak auth failed");
            com.tencent.mm.plugin.backup.g.b.UM().hU(-8);
        }
    };
    private final com.tencent.mm.plugin.backup.b.b.d ebD = new com.tencent.mm.plugin.backup.b.b.d(this) {
        final /* synthetic */ a ebE;

        {
            this.ebE = r1;
        }

        public final void a(boolean z, int i, byte[] bArr, int i2) {
            String str = "MicroMsg.BackupPcProcessMgr";
            String str2 = "summerbak onNotify isLocal:%b type:%d seq:%d buf:%d";
            Object[] objArr = new Object[4];
            objArr[0] = Boolean.valueOf(z);
            objArr[1] = Integer.valueOf(i);
            objArr[2] = Integer.valueOf(i2);
            objArr[3] = Integer.valueOf(bArr == null ? -1 : bArr.length);
            v.i(str, str2, objArr);
            if (z && bArr != null && 10011 == i) {
                com.tencent.mm.plugin.backup.g.b.UL();
                v.i("MicroMsg.BackupPcProcessMgr", "summerbak local disconnect, backupPcState:%d", Integer.valueOf(a.TD()));
                switch (a.TD()) {
                    case -100:
                    case -11:
                    case -9:
                    case -8:
                    case -7:
                    case -6:
                        com.tencent.mm.plugin.backup.g.b.UP().stop();
                        break;
                    case 1:
                        com.tencent.mm.plugin.backup.g.b.UP().stop();
                        if (!a.ebA) {
                            if (this.ebE.ebz != null) {
                                v.i("MicroMsg.BackupPcProcessMgr", "stop backupConnectTimerHandler.");
                                this.ebE.ebz.QI();
                            }
                            a.l(this.ebE);
                            break;
                        }
                        com.tencent.mm.plugin.backup.g.b.UM().hU(-1);
                        break;
                }
            }
            if (i == 17) {
                com.tencent.mm.plugin.backup.d.a aVar = new com.tencent.mm.plugin.backup.d.a();
                try {
                    aVar.az(bArr);
                    v.e("MicroMsg.BackupPcProcessMgr", "summerbak receive command request, command:%d", Integer.valueOf(aVar.eev));
                    switch (aVar.eev) {
                        case 1:
                            a.hR(1);
                            return;
                        case 3:
                            a.hS(3);
                            return;
                        case 5:
                            ak.yW();
                            if (((Boolean) com.tencent.mm.model.c.vf().get(com.tencent.mm.storage.t.a.USERINFO_BACKUP_PC_BACKUPING_BOOLEAN, Boolean.valueOf(false))).booleanValue()) {
                                String string = com.tencent.mm.plugin.backup.g.b.UU().getString("BACKUP_PC_CHOOSE_SESSION", null);
                                if (string == null) {
                                    a.hR(5);
                                    return;
                                }
                                v.i("MicroMsg.BackupPcProcessMgr", "summerbak continue Backup.");
                                com.tencent.mm.plugin.report.service.g.iuh.a(400, 29, 1, false);
                                com.tencent.mm.plugin.backup.g.b.UL().eaT = 3;
                                com.tencent.mm.plugin.backup.b.b.a(com.tencent.mm.plugin.backup.g.b.UM());
                                com.tencent.mm.plugin.backup.g.b.UL();
                                LinkedList linkedList = new LinkedList(Arrays.asList(a.aV(string, ",")));
                                com.tencent.mm.plugin.backup.g.b.UM().init();
                                com.tencent.mm.plugin.backup.g.b.UM().v(linkedList);
                                com.tencent.mm.plugin.backup.g.b.UL();
                                a.hQ(5);
                                com.tencent.mm.plugin.backup.g.b.UM().TR();
                                com.tencent.mm.plugin.backup.g.b.UL();
                                a.hP(6);
                                c UM = com.tencent.mm.plugin.backup.g.b.UM();
                                if (UM.eaC != null) {
                                    UM.handler.post(new Runnable(UM) {
                                        final /* synthetic */ c ect;

                                        {
                                            this.ect = r1;
                                        }

                                        public final void run() {
                                            this.ect.eaC.bM(true);
                                        }
                                    });
                                }
                                com.tencent.mm.plugin.backup.g.b.a(new com.tencent.mm.plugin.backup.g.b.a(UM) {
                                    final /* synthetic */ c ect;

                                    {
                                        this.ect = r1;
                                    }

                                    public final void run() {
                                        if (this.ect.eaC != null) {
                                            this.ect.handler.post(new Runnable(this) {
                                                final /* synthetic */ AnonymousClass2 ecu;

                                                {
                                                    this.ecu = r1;
                                                }

                                                public final void run() {
                                                    this.ecu.ect.eaC.bM(false);
                                                }
                                            });
                                        }
                                        if (this.eiS) {
                                            this.ect.aD((long) this.ect.ecm.size());
                                            return;
                                        }
                                        v.e("MicroMsg.BackupPcServer.dkbackup", "init TempDB error, not enough space.");
                                        com.tencent.mm.plugin.backup.g.b.UL();
                                        a.TK();
                                        com.tencent.mm.plugin.backup.g.b.UL().h(this.dbSize, this.eiU);
                                        this.ect.hU(-9);
                                        com.tencent.mm.plugin.report.service.g.iuh.a(400, 61, 1, false);
                                        com.tencent.mm.plugin.report.service.g.iuh.h(13736, Integer.valueOf(MMGIFException.D_GIF_ERR_NOT_GIF_FILE), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1));
                                    }
                                }, false);
                                return;
                            }
                            a.hR(5);
                            return;
                        case 7:
                            ak.yW();
                            if (((Boolean) com.tencent.mm.model.c.vf().get(com.tencent.mm.storage.t.a.USERINFO_BACKUP_PC_RECOVERING_BOOLEAN, Boolean.valueOf(false))).booleanValue()) {
                                com.tencent.mm.plugin.backup.g.b.UN().init();
                                if (com.tencent.mm.plugin.backup.g.b.UN().TU()) {
                                    v.i("MicroMsg.BackupPcProcessMgr", "summerbak continue Recover.");
                                    com.tencent.mm.plugin.report.service.g.iuh.a(400, 30, 1, false);
                                    com.tencent.mm.plugin.backup.g.b.UL().eaT = 4;
                                    com.tencent.mm.plugin.backup.b.b.a(com.tencent.mm.plugin.backup.g.b.UN());
                                    com.tencent.mm.plugin.backup.g.b.UL();
                                    a.hQ(7);
                                    com.tencent.mm.plugin.backup.g.b.UM().TR();
                                    com.tencent.mm.plugin.backup.g.b.UL();
                                    a.hP(8);
                                    return;
                                }
                                a.hS(7);
                                return;
                            }
                            a.hS(7);
                            return;
                        default:
                            return;
                    }
                } catch (Throwable e) {
                    v.a("MicroMsg.BackupPcProcessMgr", e, "summerbak buf to BackupCommandRequest error.", new Object[0]);
                }
                v.a("MicroMsg.BackupPcProcessMgr", e, "summerbak buf to BackupCommandRequest error.", new Object[0]);
            }
        }
    };
    long eba = 0;
    private long ebc;
    private long ebd;
    private long ebe;
    public int ebf = 0;
    public int ebg = 0;
    public long ebh;
    public long ebi;
    private ah ebj = null;
    private HandlerThread ebk = null;
    private ConcurrentLinkedQueue<Long> ebl = new ConcurrentLinkedQueue();
    private long ebm = 0;
    private ah ebn = new ah(Looper.getMainLooper(), new com.tencent.mm.sdk.platformtools.ah.a(this) {
        final /* synthetic */ a ebE;

        {
            this.ebE = r1;
        }

        public final boolean oU() {
            long currentTimeMillis = System.currentTimeMillis() - this.ebE.ebe;
            if (currentTimeMillis != 0) {
                this.ebE.ebc = (this.ebE.ebd / currentTimeMillis) * 1000;
                this.ebE.ebl.offer(Long.valueOf(this.ebE.ebc));
                this.ebE.ebc = (((this.ebE.ebm * 10) - ((Long) this.ebE.ebl.poll()).longValue()) + this.ebE.ebc) / 10;
                this.ebE.ebc = this.ebE.ebc > 0 ? this.ebE.ebc : 0;
                this.ebE.ebm = this.ebE.ebc;
                this.ebE.ebd = 0;
                this.ebE.ebe = System.currentTimeMillis();
                int TD = a.TD();
                if (TD == 4) {
                    com.tencent.mm.plugin.backup.g.b.UM().hU(TD);
                } else if (TD == 8) {
                    com.tencent.mm.plugin.backup.g.b.UN().hU(TD);
                }
            }
            return true;
        }
    }, true);
    public long ebo;
    public LinkedList<String> ebp;
    public LinkedList<Long> ebq;
    public HashMap<Long, com.tencent.mm.plugin.backup.f.g> ebr = new HashMap();
    public LinkedList<Long> ebs = new LinkedList();
    public LinkedList<String> ebt = new LinkedList();
    public LinkedList<String> ebu = new LinkedList();
    LinkedList<a> ebv;
    public d ebw;
    com.tencent.mm.plugin.backup.b.b.c ebx = new com.tencent.mm.plugin.backup.b.b.c(this) {
        final /* synthetic */ a ebE;

        {
            this.ebE = r1;
        }

        public final void TP() {
            v.i("MicroMsg.BackupPcProcessMgr", "stopCallback ");
            this.ebE.TF();
            this.ebE.TM();
        }
    };
    com.tencent.mm.plugin.backup.b.b.b eby = new com.tencent.mm.plugin.backup.b.b.b(this) {
        final /* synthetic */ a ebE;

        {
            this.ebE = r1;
        }

        public final void hT(int i) {
            com.tencent.mm.plugin.backup.g.b.UL().aB((long) i);
        }
    };
    private ah ebz;
    private WakeLock wakeLock = null;

    public class a {
        final /* synthetic */ a ebE;
        String ebF;
        PLong ebG;
        PLong ebH;
        PInt ebI;
        boolean ebJ = false;

        a(a aVar, String str, long j, long j2) {
            this.ebE = aVar;
            this.ebF = str;
            this.ebG = new PLong();
            this.ebG.value = j;
            this.ebH = new PLong();
            this.ebH.value = j2;
            this.ebI = new PInt();
        }
    }

    public interface b {
        void TQ();
    }

    public interface c {
        void TR();

        void TS();

        void bM(boolean z);
    }

    public interface d {
    }

    static /* synthetic */ void hR(int i) {
        v.i("MicroMsg.BackupPcProcessMgr", "summerbak newBackup, command:%d", Integer.valueOf(i));
        com.tencent.mm.plugin.backup.g.b.UL().eaT = 1;
        a UL = com.tencent.mm.plugin.backup.g.b.UL();
        UL.ebp = null;
        UL.ebq = null;
        UL.ebv = null;
        UL.ebo = 0;
        UL.ebr.clear();
        UL.ebs.clear();
        UL.ebt.clear();
        UL.ebu.clear();
        UL.ebf = 0;
        UL.ebg = 0;
        com.tencent.mm.plugin.backup.g.b.UM().init();
        com.tencent.mm.plugin.backup.g.b.UM();
        c.TX();
        com.tencent.mm.plugin.backup.b.b.a(com.tencent.mm.plugin.backup.g.b.UM());
        com.tencent.mm.plugin.backup.g.b.UL();
        hQ(i);
        com.tencent.mm.plugin.backup.g.b.UM().TR();
    }

    static /* synthetic */ void hS(int i) {
        v.i("MicroMsg.BackupPcProcessMgr", "summerbak newRecover, command:%d", Integer.valueOf(i));
        com.tencent.mm.plugin.backup.g.b.UL().eaT = 2;
        a UL = com.tencent.mm.plugin.backup.g.b.UL();
        UL.ebf = 0;
        UL.ebg = 0;
        com.tencent.mm.plugin.backup.g.b.UN().init();
        com.tencent.mm.plugin.backup.g.b.UN().TV();
        com.tencent.mm.plugin.backup.b.b.a(com.tencent.mm.plugin.backup.g.b.UN());
        com.tencent.mm.plugin.backup.g.b.UL();
        hQ(i);
        com.tencent.mm.plugin.backup.g.b.UN().TR();
    }

    static /* synthetic */ void l(a aVar) {
        String str = aVar.eaW;
        String str2 = aVar.eaX;
        String bw = g.bw(aa.getContext());
        v.e("MicroMsg.BackupPcProcessMgr", "connect failed thisWifi:%s, pcWifiName:%s, pcIpAddress:%s, tryCount:%d", bw, str, str2, Integer.valueOf(cxZ));
        if (bw == null || bw.equals(SQLiteDatabase.KeyEmpty)) {
            com.tencent.mm.plugin.report.service.g.iuh.a(400, 1, 1, false);
            com.tencent.mm.plugin.report.service.g.iuh.h(13736, Integer.valueOf(100), str, bw, Integer.valueOf(0));
            com.tencent.mm.plugin.backup.g.b.UM().hU(-3);
        } else if (str == null || !str.equals(bw)) {
            com.tencent.mm.plugin.report.service.g.iuh.a(400, 2, 1, false);
            com.tencent.mm.plugin.report.service.g.iuh.h(13736, Integer.valueOf(MMGIFException.D_GIF_ERR_OPEN_FAILED), str, bw, Integer.valueOf(0));
            com.tencent.mm.plugin.backup.g.b.UM().hU(-4);
        } else if (!g.pf(str2)) {
            com.tencent.mm.plugin.report.service.g.iuh.a(400, 3, 1, false);
            com.tencent.mm.plugin.report.service.g.iuh.h(13736, Integer.valueOf(MMGIFException.D_GIF_ERR_READ_FAILED), str, bw, Integer.valueOf(0));
            com.tencent.mm.plugin.backup.g.b.UM().hU(-5);
        } else if (cxZ <= 0) {
            com.tencent.mm.plugin.backup.g.b.UM().hU(-8);
            com.tencent.mm.plugin.report.service.g.iuh.a(400, 63, 1, false);
        } else {
            cxZ--;
            aVar.ad(com.tencent.mm.plugin.backup.g.b.UL().eaX, com.tencent.mm.plugin.backup.g.b.UL().eaY);
        }
    }

    public static void hO(int i) {
        v.i("MicroMsg.BackupPcProcessMgr", "setBackupPcState state:%d", Integer.valueOf(i));
        ak.yW();
        com.tencent.mm.model.c.vf().a(com.tencent.mm.storage.t.a.USERINFO_BACKUP_PC_STATE_INT, Integer.valueOf(i));
    }

    public static int TD() {
        ak.yW();
        return ((Integer) com.tencent.mm.model.c.vf().get(com.tencent.mm.storage.t.a.USERINFO_BACKUP_PC_STATE_INT, Integer.valueOf(-100))).intValue();
    }

    public final void aA(long j) {
        this.eaZ = j;
        ebb = false;
    }

    public final void TE() {
        v.i("MicroMsg.BackupPcProcessMgr", "start backup heart beat handler.");
        this.eaZ = System.currentTimeMillis();
        ebb = false;
        if (this.ebj == null) {
            this.ebk = com.tencent.mm.sdk.i.e.Lg("SendBackupHeartBeat");
            this.ebk.start();
            this.ebj = new ah(this.ebk.getLooper(), new com.tencent.mm.sdk.platformtools.ah.a(this) {
                final /* synthetic */ a ebE;

                {
                    this.ebE = r1;
                }

                public final boolean oU() {
                    if (System.currentTimeMillis() - this.ebE.eaZ > 15000) {
                        if (a.ebb) {
                            v.e("MicroMsg.BackupPcProcessMgr", "backup pc heart beat overtime, currentTime:%d, heartbeatStamp:%d, backupPcState:%d", Long.valueOf(System.currentTimeMillis()), Long.valueOf(this.ebE.eaZ), Integer.valueOf(a.TD()));
                            if (a.TD() > 0) {
                                if (1 == com.tencent.mm.plugin.backup.g.b.UL().eaT) {
                                    com.tencent.mm.plugin.backup.g.b.UM().bl(true);
                                } else if (2 == com.tencent.mm.plugin.backup.g.b.UL().eaT) {
                                    com.tencent.mm.plugin.backup.g.b.UN().bl(true);
                                }
                                com.tencent.mm.plugin.backup.g.b.UP().stop();
                                com.tencent.mm.plugin.backup.g.b.UM().hU(-1);
                            }
                        } else {
                            a.TJ();
                            this.ebE.aA(System.currentTimeMillis());
                            a.ebb = true;
                        }
                    }
                    return true;
                }
            }, true);
            this.ebj.ea(15000);
        }
        TJ();
    }

    public final void TF() {
        if (this.ebj != null) {
            v.i("MicroMsg.BackupPcProcessMgr", "stop backup heart beat handler.");
            this.ebj.QI();
            this.ebj = null;
        }
    }

    public final void h(long j, long j2) {
        this.ebh = j;
        this.ebi = j2;
    }

    public final String TG() {
        String b;
        long j = this.ebc;
        if ((j >> 30) > 0) {
            b = be.b(j, 100.0d);
        } else if ((j >> 20) > 0) {
            b = be.a(j, 100.0d);
        } else if ((j >> 9) > 0) {
            b = Math.round((float) (j / 1024)) + " KB";
        } else {
            b = j + " B";
        }
        v.i("MicroMsg.BackupPcProcessMgr", "getBackupPcSpeed :%s", b);
        return b;
    }

    public final void aB(long j) {
        this.ebd += j;
    }

    public final void TH() {
        v.i("MicroMsg.BackupPcProcessMgr", "start backup get speed handler.");
        this.ebe = System.currentTimeMillis();
        this.ebd = 0;
        this.ebm = 0;
        this.ebl.clear();
        for (int i = 0; i < 10; i++) {
            this.ebl.offer(Long.valueOf(0));
        }
        this.ebn.ea(1000);
    }

    public final void TI() {
        if (this.ebn != null) {
            v.i("MicroMsg.BackupPcProcessMgr", "stop backup get speed handler.");
            this.ebn.QI();
        }
    }

    public static String a(String str, String str2, String... strArr) {
        if (strArr == null || strArr.length == 0) {
            return str;
        }
        StringBuilder stringBuilder;
        int i;
        if (str.equals(SQLiteDatabase.KeyEmpty)) {
            stringBuilder = new StringBuilder(strArr[0]);
            i = 1;
        } else {
            stringBuilder = new StringBuilder(str);
            i = 0;
        }
        for (String str3 : strArr) {
            if (i != 0) {
                i = 0;
            } else {
                stringBuilder.append(str2).append(str3);
            }
        }
        return stringBuilder.toString();
    }

    public static String[] aV(String str, String str2) {
        return str.split(str2);
    }

    public static void hP(int i) {
        com.tencent.mm.plugin.backup.d.a aVar = new com.tencent.mm.plugin.backup.d.a();
        aVar.eev = i;
        try {
            v.i("MicroMsg.BackupPcProcessMgr", "send command req cmd:%d", Integer.valueOf(i));
            com.tencent.mm.plugin.backup.b.b.r(aVar.toByteArray(), 17);
        } catch (Throwable e) {
            v.a("MicroMsg.BackupPcProcessMgr", e, "buf to BackupCommandResponse err.", new Object[0]);
        }
    }

    public static void hQ(int i) {
        com.tencent.mm.plugin.backup.d.b bVar = new com.tencent.mm.plugin.backup.d.b();
        bVar.eev = i;
        try {
            v.i("MicroMsg.BackupPcProcessMgr", "send command resp cmd:%d", Integer.valueOf(i));
            com.tencent.mm.plugin.backup.b.b.r(bVar.toByteArray(), 18);
        } catch (Throwable e) {
            v.a("MicroMsg.BackupPcProcessMgr", e, "buf to BackupCommandResponse err.", new Object[0]);
        }
    }

    public static void TJ() {
        com.tencent.mm.plugin.backup.d.c cVar = new com.tencent.mm.plugin.backup.d.c();
        a UL = com.tencent.mm.plugin.backup.g.b.UL();
        if (UL.eba == Long.MAX_VALUE) {
            UL.eba = 0;
        }
        UL.eba++;
        cVar.eba = UL.eba;
        try {
            v.i("MicroMsg.BackupPcProcessMgr", "send heartbeat req, ack:%d", Long.valueOf(cVar.eba));
            com.tencent.mm.plugin.backup.b.b.r(cVar.toByteArray(), 9);
        } catch (Throwable e) {
            v.a("MicroMsg.BackupPcProcessMgr", e, "buf to BackupHeartBeatRequest err.", new Object[0]);
        }
    }

    public static void TK() {
        com.tencent.mm.plugin.backup.c.a aVar = new com.tencent.mm.plugin.backup.c.a();
        aVar.ID = com.tencent.mm.plugin.backup.g.b.UZ();
        try {
            v.i("MicroMsg.BackupPcProcessMgr", "send cancel req.");
            com.tencent.mm.plugin.backup.b.b.r(aVar.toByteArray(), 5);
        } catch (Throwable e) {
            v.a("MicroMsg.BackupPcProcessMgr", e, "buf to BackupCancelRequest err.", new Object[0]);
        }
    }

    public static com.tencent.mm.plugin.backup.d.g aC(long j) {
        com.tencent.mm.plugin.backup.d.g gVar = new com.tencent.mm.plugin.backup.d.g();
        String deviceID = p.getDeviceID(aa.getContext());
        if (deviceID == null) {
            deviceID = p.rK();
        }
        gVar.eez = deviceID;
        gVar.eeA = Build.MANUFACTURER;
        gVar.eeB = Build.MODEL;
        gVar.eeC = "Android";
        gVar.eeD = VERSION.RELEASE;
        gVar.eeE = com.tencent.mm.protocal.d.lWh;
        gVar.eeF = j;
        v.i("MicroMsg.BackupPcProcessMgr", "summerbak generalinfo wechatversion:%s, freespace:%d, deviceId:%s", Integer.valueOf(com.tencent.mm.protocal.d.lWh), Long.valueOf(j), gVar.eez);
        return gVar;
    }

    public final void a(LinkedList<String> linkedList, LinkedList<Long> linkedList2) {
        long j = 0;
        this.ebv = new LinkedList();
        Iterator it = linkedList2.iterator();
        Iterator it2 = linkedList.iterator();
        long j2 = 0;
        while (it2.hasNext()) {
            String str = (String) it2.next();
            if (it.hasNext()) {
                j2 = ((Long) it.next()).longValue();
                if (it.hasNext()) {
                    j = ((Long) it.next()).longValue();
                }
            }
            this.ebv.add(new a(this, str, j2, j));
        }
    }

    private void ad(String str, int i) {
        com.tencent.mm.plugin.backup.g.b.UP().connect(str, i);
        com.tencent.mm.plugin.backup.b.b.a(1, this.ebC);
        new com.tencent.mm.plugin.backup.b.a(com.tencent.mm.plugin.backup.g.b.Va(), com.tencent.mm.plugin.backup.g.b.Vb(), com.tencent.mm.plugin.backup.g.b.UV(), com.tencent.mm.plugin.backup.g.b.UZ(), 1).Uh();
        v.i("MicroMsg.BackupPcProcessMgr", "summerbak tryConnect start connect timehandler.");
        if (this.ebz == null) {
            this.ebz = new ah(new com.tencent.mm.sdk.platformtools.ah.a(this) {
                final /* synthetic */ a ebE;

                {
                    this.ebE = r1;
                }

                public final boolean oU() {
                    if (!a.ebA) {
                        v.e("MicroMsg.BackupPcProcessMgr", "summerbak try connect overtime failed.");
                        if (this.ebE.ebz != null) {
                            this.ebE.ebz.QI();
                        }
                        a.l(this.ebE);
                    }
                    return true;
                }
            }, false);
        }
        this.ebz.ea(3000);
    }

    public final void TL() {
        ad.o(new Runnable(this) {
            final /* synthetic */ a ebE;

            {
                this.ebE = r1;
            }

            public final void run() {
                try {
                    if (this.ebE.wakeLock == null) {
                        this.ebE.wakeLock = ((PowerManager) aa.getContext().getSystemService("power")).newWakeLock(26, "BackupPc Lock");
                    }
                    if (!this.ebE.wakeLock.isHeld()) {
                        this.ebE.wakeLock.acquire();
                    }
                } catch (Throwable th) {
                }
            }
        });
    }

    public final void TM() {
        ad.o(new Runnable(this) {
            final /* synthetic */ a ebE;

            {
                this.ebE = r1;
            }

            public final void run() {
                try {
                    if (this.ebE.wakeLock != null && this.ebE.wakeLock.isHeld()) {
                        this.ebE.wakeLock.release();
                    }
                } catch (Throwable th) {
                }
            }
        });
    }
}
