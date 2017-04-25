package com.tencent.mm.plugin.backup.movemodel;

import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.backup.b.b.d;
import com.tencent.mm.plugin.backup.b.c;
import com.tencent.mm.plugin.backup.c.a;
import com.tencent.mm.plugin.backup.c.b;
import com.tencent.mm.plugin.backup.d.q;
import com.tencent.mm.plugin.backup.d.x;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.File;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public final class i implements d, f, e {
    public long beE = 0;
    public boolean cAv = false;
    private n ebK;
    public long ebM = 0;
    public long ebN = 0;
    private int ebO = 0;
    public long ebP = 0;
    private int ebQ = 0;
    private long ebR = 0;
    private int ebS = 0;
    public boolean ebT = true;
    public HashSet<String> ebU = new HashSet();
    private long ece = 0;
    private long ecf = 0;
    List<String> egH = new LinkedList();
    public boolean elb = false;
    public f elc;
    public boolean elj = true;
    public boolean elk = false;
    private long elm = 0;
    public String eln = SQLiteDatabase.KeyEmpty;
    private int elo = 0;
    private boolean elp = true;
    private b elq;
    private Object lock = new Object();
    public long recvSize = 0;

    public final void Wq() {
        a aVar = new a();
        aVar.ID = com.tencent.mm.plugin.backup.g.b.UZ();
        try {
            com.tencent.mm.plugin.backup.b.b.r(aVar.toByteArray(), 5);
        } catch (Throwable e) {
            v.a("MicroMsg.MoveRecoverServer", e, "sendBuf", new Object[0]);
        }
        Wo();
    }

    private void Wo() {
        synchronized (this.lock) {
            this.cAv = true;
            if (this.ebK != null) {
                this.ebK.cancel();
                this.ebK = null;
            }
            this.egH.clear();
            com.tencent.mm.a.e.e(new File(com.tencent.mm.plugin.backup.g.b.Vj()));
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        v.i("MicroMsg.MoveRecoverServer", "onSceneEnd type:%d, [%d, %d]", Integer.valueOf(kVar.getType()), Integer.valueOf(i2), Integer.valueOf(i));
        if (kVar.getType() == 1) {
            com.tencent.mm.plugin.backup.b.b.b(1, this);
            g.iuh.a(103, 9, 1, false);
            if (i2 != 0) {
                v.e("MicroMsg.MoveRecoverServer", "auth failed");
                this.elb = false;
                return;
            }
            this.elp = (((j) kVar).edU.efn & d.ekW) != 0;
            this.elb = true;
            v.i("MicroMsg.MoveRecoverServer", "auth ok and request bakStart");
            com.tencent.mm.plugin.backup.b.b.a(3, (e) this);
            com.tencent.mm.a.e.e(new File(com.tencent.mm.plugin.backup.g.b.Vj()));
            com.tencent.mm.plugin.backup.g.b.a(new com.tencent.mm.plugin.backup.g.b.a(this) {
                final /* synthetic */ i elr;

                {
                    this.elr = r1;
                }

                public final void run() {
                    v.i("MicroMsg.MoveRecoverServer", "initTempDB before bakstart: initOK:%b, availData:%d, availSD:%d, dbSize:%d", Boolean.valueOf(this.eiS), Long.valueOf(this.eiU), Long.valueOf(this.eiT), Long.valueOf(this.dbSize));
                    if (this.eiS) {
                        this.elr.ebM = this.eiU - this.dbSize;
                        this.elr.ebN = this.eiT;
                        new c(com.tencent.mm.plugin.backup.g.b.UZ()).Uh();
                        return;
                    }
                    this.elr.onError(10012, this.dbSize + "," + (this.dbSize - this.eiU));
                    v.e("MicroMsg.MoveRecoverServer", "init TempDB error");
                }
            }, false);
        } else if (kVar.getType() == 3) {
            this.egH.clear();
            c cVar = (c) kVar;
            this.beE = cVar.eeg.eeN;
            this.elm = cVar.eeg.eeM;
            this.elo = cVar.eeg.eeP;
            com.tencent.mm.plugin.backup.b.b.b(3, this);
            v.i("MicroMsg.MoveRecoverServer", "move recover total:%d, totalSize:%d, and wait old mobile's pushData", Long.valueOf(cVar.eeg.eeM), Long.valueOf(cVar.eeg.eeN));
            if (this.elj && this.elp) {
                g gVar = g.iuh;
                int i3 = (this.elk || this.elo == 1) ? 16 : 17;
                gVar.a(103, (long) i3, 1, false);
            }
            if (this.ebN < cVar.eeg.eeN && this.ebM < cVar.eeg.eeN) {
                com.tencent.mm.plugin.backup.g.b.UT().il(30050035);
                Wq();
                onError(10012, cVar.eeg.eeN + "," + (this.ebN == 0 ? cVar.eeg.eeN - this.ebM : cVar.eeg.eeN - this.ebN));
            }
        }
    }

    public final void a(boolean z, int i, byte[] bArr, int i2) {
        int i3;
        String str = "MicroMsg.MoveRecoverServer";
        String str2 = "onNotify isLocal:%b, type:%d, seq:%d, buf.len:%d";
        Object[] objArr = new Object[4];
        objArr[0] = Boolean.valueOf(z);
        objArr[1] = Integer.valueOf(i);
        objArr[2] = Integer.valueOf(i2);
        if (bArr == null) {
            i3 = 0;
        } else {
            i3 = bArr.length;
        }
        objArr[3] = Integer.valueOf(i3);
        v.i(str, str2, objArr);
        if (z) {
            onError(i, SQLiteDatabase.KeyEmpty);
        }
        if (!this.elb) {
            v.w("MicroMsg.MoveRecoverServer", "statusOK not ok, drop this notify");
        } else if (i == 6) {
            if (this.ebT) {
                this.ebR = System.currentTimeMillis();
                this.ebT = false;
            }
            this.ebP += (long) bArr.length;
            x xVar = new x();
            q qVar = new q();
            try {
                qVar.az(bArr);
                v.i("MicroMsg.MoveRecoverServer", "reveive recoverData id:%s, type:%d, start:%d, end:%d", qVar.efo, Integer.valueOf(qVar.efp), Integer.valueOf(qVar.efr), Integer.valueOf(qVar.efs));
                long currentTimeMillis = System.currentTimeMillis();
                if (qVar.efp == 1 && qVar.eew != null) {
                    this.egH.add(qVar.efo);
                    a(com.tencent.mm.plugin.backup.g.b.Vj() + "mmbakItem/" + com.tencent.mm.plugin.backup.g.g.pd(qVar.efo), qVar);
                    this.recvSize += (long) qVar.eew.lVU.length;
                }
                this.ebO = (int) ((System.currentTimeMillis() - currentTimeMillis) + ((long) this.ebO));
                currentTimeMillis = System.currentTimeMillis();
                if (qVar.efp == 2) {
                    a(com.tencent.mm.plugin.backup.g.b.Vj() + "mmbakMeida/" + com.tencent.mm.plugin.backup.g.g.pd(qVar.efo), qVar);
                    this.recvSize += (long) qVar.eew.lVU.length;
                    this.ebU.add(qVar.efo);
                }
                this.ebQ = (int) ((System.currentTimeMillis() - currentTimeMillis) + ((long) this.ebQ));
                v.i("MicroMsg.MoveRecoverServer", "onNotify recvSize/totalSize: %d, %d", Long.valueOf(this.recvSize), Long.valueOf(this.beE));
                if (this.beE < this.recvSize) {
                    this.beE = this.recvSize;
                }
                b(this.recvSize, this.beE, 0);
                xVar.efo = qVar.efo;
                xVar.efp = qVar.efp;
                xVar.efr = qVar.efr;
                xVar.efs = qVar.efs;
                xVar.eeO = 0;
            } catch (Throwable e) {
                xVar.efo = SQLiteDatabase.KeyEmpty;
                xVar.efp = 0;
                xVar.efr = 0;
                xVar.efs = 0;
                xVar.eeO = 1;
                v.a("MicroMsg.MoveRecoverServer", e, "BACKUP_DATA_PUSH:", new Object[0]);
            }
            try {
                com.tencent.mm.plugin.backup.b.b.e(xVar.toByteArray(), 7, i2);
            } catch (Throwable e2) {
                v.a("MicroMsg.MoveRecoverServer", e2, "BACKUP_DATA_RESPONSE:", new Object[0]);
            }
        } else {
            if (i == 8) {
                this.ebS = (int) (System.currentTimeMillis() - this.ebR);
                this.elq = new b();
                try {
                    this.elq.az(bArr);
                    v.i("MicroMsg.MoveRecoverServer", "NewBakMoveInfoKvstat, Client receive Server data, ServerSessionCount:%d, ServerMessageCount:%d, ServerFileCount:%d, CalculateSize:%d, ServerDataPushSize:%d, ServerReadDBTotalTime:%d, ServerReadFileTotalTime:%d, ServerCostTotalTime:%d, ServerVersion:%x", Integer.valueOf(this.elq.eei), Integer.valueOf(this.elq.eej), Integer.valueOf(this.elq.eek), Integer.valueOf(this.elq.eel), Integer.valueOf(this.elq.eem), Integer.valueOf(this.elq.een), Integer.valueOf(this.elq.eeo), Integer.valueOf(this.elq.eep), Integer.valueOf(this.elq.eeq));
                } catch (Throwable e22) {
                    v.a("MicroMsg.MoveRecoverServer", e22, "COMMAND_FINISH:", new Object[0]);
                }
                long az = be.az(this.ecf) / 1000;
                if (az == 0) {
                    az = 1;
                }
                long j = this.beE / az;
                g gVar = g.iuh;
                objArr = new Object[6];
                objArr[0] = Integer.valueOf(1);
                boolean z2 = com.tencent.mm.plugin.backup.g.g.Vy() || this.eln.endsWith(".1");
                objArr[1] = Boolean.valueOf(z2);
                objArr[2] = Long.valueOf(j);
                objArr[3] = Long.valueOf(this.recvSize);
                objArr[4] = Long.valueOf(this.beE);
                objArr[5] = Integer.valueOf(0);
                gVar.h(11789, objArr);
                g.iuh.a(103, 20, 1, false);
                gVar = g.iuh;
                i3 = (this.elk || this.elo == 1) ? 19 : 18;
                gVar.a(103, (long) i3, 1, false);
                g.iuh.a(103, 14, this.recvSize / 1024, false);
                gVar = g.iuh;
                i3 = (this.elk || this.elo == 1) ? 22 : 21;
                gVar.a(103, (long) i3, j / 1024, false);
                this.ecf = 0;
                UB();
                synchronized (this.lock) {
                    if (this.cAv) {
                        return;
                    }
                    if (this.ebK != null) {
                        this.ebK.cancel();
                    }
                    v.i("MicroMsg.MoveRecoverServer", "summerbak digestList size: %d", Integer.valueOf(this.egH.size()));
                    this.ebK = new n(this.egH, (int) this.elm);
                    this.ebK.ekw = this;
                    this.ebK.im(2);
                }
            }
            if (i == 5) {
                com.tencent.mm.plugin.backup.g.b.UT().il(30050107);
                Wo();
            }
        }
    }

    private static void a(String str, q qVar) {
        long j = 0;
        File file = new File(str + qVar.efo);
        long length = file.exists() ? file.length() : 0;
        com.tencent.mm.a.e.a(str, qVar.efo, qVar.eew.lVU);
        File file2 = new File(str + qVar.efo);
        if (file2.exists()) {
            j = file2.length();
        }
        if (length == j) {
            v.e("MicroMsg.MoveRecoverServer", "append failed and try again:%s", str + qVar.efo);
            com.tencent.mm.a.e.a(str, qVar.efo, qVar.eew.lVU);
        }
    }

    public final void onError(int i, String str) {
        boolean z;
        g gVar = g.iuh;
        Object[] objArr = new Object[6];
        objArr[0] = Integer.valueOf(0);
        if (com.tencent.mm.plugin.backup.g.g.Vy() || this.eln.endsWith(".1")) {
            z = true;
        } else {
            z = false;
        }
        objArr[1] = Boolean.valueOf(z);
        objArr[2] = Integer.valueOf(0);
        objArr[3] = Long.valueOf(this.recvSize);
        objArr[4] = Long.valueOf(this.beE);
        objArr[5] = Integer.valueOf(i);
        gVar.h(11789, objArr);
        if (this.elc != null) {
            this.elc.onError(i, str);
        }
    }

    public final void b(long j, long j2, int i) {
        if (this.ece == 0 || be.az(this.ece) >= 100) {
            long j3;
            this.ece = be.Nj();
            if (this.ecf == 0) {
                this.ecf = be.Nj();
            }
            if (j > j2) {
                j3 = j2;
            } else {
                j3 = j;
            }
            int i2 = ((int) (((this.ece - this.ecf) * (j2 - j3)) / j3)) / 1000;
            if (this.elc != null) {
                this.elc.b(j3, j2, i2);
            }
        }
    }

    public final void bn(int i, int i2) {
        if (this.elc != null) {
            this.elc.bn(i, i2);
        }
    }

    public final void UB() {
        if (this.elc != null) {
            this.elc.UB();
        }
    }

    public final void UC() {
        g.iuh.a(103, 6, 1, false);
        il(30059999);
        ak.yW();
        com.tencent.mm.model.c.vf().a(t.a.USERINFO_BACKUP_OLD_RECORDS_BOOLEAN, Boolean.valueOf(true));
        v.i("MicroMsg.MoveRecoverServer", "move recover finish, make BACKUP_MOVE_RECORDS.");
        if (this.elc != null) {
            this.elc.UC();
        }
    }

    public final void il(int i) {
        int i2 = 1;
        if (this.elj && this.elp && this.elq != null && this.ebK != null) {
            int i3;
            g gVar = g.iuh;
            Object[] objArr = new Object[19];
            objArr[0] = Integer.valueOf(this.elq.eei);
            objArr[1] = Integer.valueOf(this.elq.eej);
            objArr[2] = Integer.valueOf(this.elq.eek);
            objArr[3] = Integer.valueOf(this.elq.eel);
            objArr[4] = Integer.valueOf(this.elq.eem);
            objArr[5] = Integer.valueOf(this.elq.een);
            objArr[6] = Integer.valueOf(this.elq.eeo);
            objArr[7] = Integer.valueOf(this.elq.eep);
            objArr[8] = Integer.valueOf(this.ebK.elx);
            objArr[9] = Integer.valueOf(this.ebK.elw);
            objArr[10] = Integer.valueOf(this.ebU.size());
            objArr[11] = Integer.valueOf(this.ebO);
            objArr[12] = Integer.valueOf(this.ebK.ely);
            objArr[13] = Integer.valueOf(this.ebQ);
            objArr[14] = Integer.valueOf(this.ebS);
            objArr[15] = Integer.valueOf((int) (this.ebP / 1024));
            objArr[16] = Integer.valueOf(i);
            objArr[17] = Integer.valueOf(this.elq.eeq);
            if (this.elk) {
                i3 = 1;
            } else {
                i3 = this.elo;
            }
            objArr[18] = Integer.valueOf(i3);
            gVar.h(13287, objArr);
            String str = "MicroMsg.MoveRecoverServer";
            String str2 = "NewBakMoveInfoKvstat, Client, ServerSessionCount:%d, ServerMessageCount:%d, ServerFileCount:%d, CalculateSize:%d, ServerDataPushSize:%d, ServerReadDBTotalTime:%d, ServerReadFileTotalTime:%d, ServerCostTotalTime:%d, ClientSessionCount:%d, ClientMessageCount:%d, ClientFileCount:%d, ClientWriteTmpFileTotalTime:%d, ClientWriteDBTotalTime:%d, ClientWriteFileTotalTime:%d, ClientCostTotalTime:%d, ClientDataPushSize:%d, ErrorCode:%d, ServerVersion:%x, m_networkState:%d";
            Object[] objArr2 = new Object[19];
            objArr2[0] = Integer.valueOf(this.elq.eei);
            objArr2[1] = Integer.valueOf(this.elq.eej);
            objArr2[2] = Integer.valueOf(this.elq.eek);
            objArr2[3] = Integer.valueOf(this.elq.eel);
            objArr2[4] = Integer.valueOf(this.elq.eem);
            objArr2[5] = Integer.valueOf(this.elq.een);
            objArr2[6] = Integer.valueOf(this.elq.eeo);
            objArr2[7] = Integer.valueOf(this.elq.eep);
            objArr2[8] = Integer.valueOf(this.ebK.elx);
            objArr2[9] = Integer.valueOf(this.ebK.elw);
            objArr2[10] = Integer.valueOf(this.ebU.size());
            objArr2[11] = Integer.valueOf(this.ebO);
            objArr2[12] = Integer.valueOf(this.ebK.ely);
            objArr2[13] = Integer.valueOf(this.ebQ);
            objArr2[14] = Integer.valueOf(this.ebS);
            objArr2[15] = Integer.valueOf((int) (this.ebP / 1024));
            objArr2[16] = Integer.valueOf(i);
            objArr2[17] = Integer.valueOf(this.elq.eeq);
            if (!this.elk) {
                i2 = this.elo;
            }
            objArr2[18] = Integer.valueOf(i2);
            v.i(str, str2, objArr2);
        }
    }
}
