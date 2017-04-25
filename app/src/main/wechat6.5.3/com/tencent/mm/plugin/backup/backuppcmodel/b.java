package com.tencent.mm.plugin.backup.backuppcmodel;

import android.database.Cursor;
import android.os.Looper;
import android.util.Pair;
import com.tencent.mm.a.e;
import com.tencent.mm.jniinterface.AesEcb;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.backup.b.b.d;
import com.tencent.mm.plugin.backup.backuppcmodel.a.c;
import com.tencent.mm.plugin.backup.d.f;
import com.tencent.mm.plugin.backup.d.h;
import com.tencent.mm.plugin.backup.d.q;
import com.tencent.mm.plugin.backup.d.r;
import com.tencent.mm.plugin.backup.d.s;
import com.tencent.mm.plugin.backup.d.t;
import com.tencent.mm.plugin.backup.d.y;
import com.tencent.mm.plugin.backup.d.z;
import com.tencent.mm.plugin.backup.movemodel.n;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.i;
import com.tencent.mm.storage.k;
import com.tencent.mm.storage.t.a;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public final class b implements d, c {
    private long beE = 0;
    private boolean cAv = false;
    c eaC;
    private n ebK;
    private LinkedList<String> ebL = new LinkedList();
    private long ebM = 0;
    private long ebN = 0;
    private int ebO = 0;
    private long ebP = 0;
    private int ebQ = 0;
    private long ebR = 0;
    private int ebS = 0;
    private boolean ebT = true;
    private HashSet<String> ebU = new HashSet();
    long ebV;
    long ebW;
    LinkedList<String> ebX;
    LinkedList<Long> ebY;
    private long ebZ = 0;
    private long eca = 0;
    public com.tencent.mm.plugin.backup.backuppcmodel.a.b ecb;
    private HashMap<String, k> ecc = new HashMap();
    private HashMap<String, Pair<Long, Long>> ecd = new HashMap();
    private long ece = 0;
    private long ecf = 0;
    public ac handler;
    private Object lock = new Object();
    private long recvSize = 0;

    public final void a(c cVar) {
        this.eaC = cVar;
        this.handler = new ac(Looper.getMainLooper());
    }

    public final boolean TT() {
        if (this.ebL == null || this.ebL.size() == 0) {
            return false;
        }
        return true;
    }

    public final boolean TU() {
        v.i("MicroMsg.BackupPcRecoverServer", "setContinueRecoverData.");
        Cursor Kp = ak.yW().xy().Kp();
        if (Kp == null) {
            return false;
        }
        if (Kp.moveToFirst()) {
            while (!Kp.isAfterLast()) {
                k kVar = new k();
                kVar.b(Kp);
                this.ebL.add(kVar.field_msgDataId);
                Kp.moveToNext();
            }
        }
        Kp.close();
        v.i("MicroMsg.BackupPcRecoverServer", "setContinueRecoverData sucess, msgDataIdList size:%d", Integer.valueOf(this.ebL.size()));
        return true;
    }

    public final void init() {
        v.i("MicroMsg.BackupPcRecoverServer", "recover init");
        this.ebZ = 0;
        this.beE = 0;
        this.recvSize = 0;
        this.ebM = 0;
        this.ebN = 0;
        this.cAv = false;
        this.ebT = true;
        this.ebP = 0;
        this.ebU.clear();
        this.ecc.clear();
        this.ecd.clear();
        this.ebL.clear();
    }

    public final void TV() {
        v.i("MicroMsg.BackupPcRecoverServer", "recover clearContinueRecoverData");
        this.ecc.clear();
        this.ecd.clear();
        this.ebL.clear();
        e.e(new File(com.tencent.mm.plugin.backup.g.b.Vj()));
        ak.yW();
        com.tencent.mm.model.c.vf().a(a.USERINFO_BACKUP_PC_RECOVERING_BOOLEAN, Boolean.valueOf(false));
        boolean dF = ak.yW().xy().cie.dF("BackupPcRecoverTagInfo", "delete from BackupPcRecoverTagInfo");
        v.i("MicroMsg.BackupPcRecoverTagInfoStorage", "deleteAllData, result:%b", Boolean.valueOf(dF));
        dF = ak.yW().xz().cie.dF("BackupPcRecoverSessionInfo", "delete from BackupPcRecoverSessionInfo");
        v.i("MicroMsg.BackupPcRecoverSessionInfoStorage", "deleteAllData, result:%b", Boolean.valueOf(dF));
    }

    public final void bl(boolean z) {
        v.i("MicroMsg.BackupPcRecoverServer", "summerbak backupPcRecoverServer cancel.");
        v.i("MicroMsg.BackupPcRecoverServer", "summerbak backupPcRecoverServer cancel stack:%s", be.bur());
        if (!z) {
            com.tencent.mm.plugin.backup.g.b.UL();
            a.TK();
        }
        synchronized (this.lock) {
            this.cAv = true;
            if (this.ebK != null) {
                this.ebK.cancel();
                this.ebK = null;
            }
        }
        com.tencent.mm.plugin.backup.g.b.UL().TF();
        com.tencent.mm.plugin.backup.g.b.UL().TI();
    }

    public final void a(boolean z, int i, byte[] bArr, int i2) {
        long j;
        Throwable e;
        String str = "MicroMsg.BackupPcRecoverServer";
        String str2 = "onNotify isLocal:%b, type:%d, seq:%d, buf.len:%d";
        Object[] objArr = new Object[4];
        objArr[0] = Boolean.valueOf(z);
        objArr[1] = Integer.valueOf(i);
        objArr[2] = Integer.valueOf(i2);
        objArr[3] = Integer.valueOf(bArr == null ? 0 : bArr.length);
        v.i(str, str2, objArr);
        if (z && 10011 == i) {
            com.tencent.mm.plugin.backup.g.b.UL();
            v.i("MicroMsg.BackupPcRecoverServer", "summerbak local disconnect, backupPcState:%d", Integer.valueOf(a.TD()));
            switch (a.TD()) {
                case -11:
                case -10:
                case -9:
                case -8:
                case -7:
                case -6:
                    com.tencent.mm.plugin.backup.g.b.UP().stop();
                    break;
                case -1:
                    bl(true);
                    break;
                case 1:
                case 6:
                    com.tencent.mm.plugin.backup.g.b.UP().stop();
                    hU(-100);
                    break;
                case 7:
                case 8:
                    bl(true);
                    com.tencent.mm.plugin.backup.g.b.UP().stop();
                    hU(-1);
                    g.iuh.a(400, 17, 1, false);
                    j = 0;
                    if (this.ebZ != 0) {
                        j = System.currentTimeMillis() - this.ebZ;
                    }
                    g.iuh.h(13737, Integer.valueOf(MMGIFException.D_GIF_ERR_NOT_GIF_FILE), Long.valueOf(this.beE), Long.valueOf(j), Integer.valueOf(2));
                    v.i("MicroMsg.BackupPcRecoverServer", "summerbak recover transfer disconnect, recoverDataSize:%d, recoverCostTime:%d", Long.valueOf(this.beE), Long.valueOf(j));
                    break;
                case 11:
                    com.tencent.mm.plugin.backup.g.b.UP().stop();
                    hU(-100);
                    break;
            }
        }
        if (2 == com.tencent.mm.plugin.backup.g.b.UL().eaT || 4 == com.tencent.mm.plugin.backup.g.b.UL().eaT) {
            if (i == 10) {
                try {
                    new com.tencent.mm.plugin.backup.d.d().az(bArr);
                    v.i("MicroMsg.BackupPcRecoverServer", "summerbak receive heartbeat response, ack:%d", Long.valueOf(r2.eba));
                } catch (Throwable e2) {
                    v.a("MicroMsg.BackupPcRecoverServer", e2, "summerbak heartbeat resp parse from buf error.", new Object[0]);
                }
            } else if (i == 18) {
                try {
                    new com.tencent.mm.plugin.backup.d.b().az(bArr);
                    v.i("MicroMsg.BackupPcRecoverServer", "summerbak command response, command:%d", Integer.valueOf(r2.eev));
                } catch (Throwable e22) {
                    v.a("MicroMsg.BackupPcRecoverServer", e22, "summerbak BackupCommandResponse parse from buf error.", new Object[0]);
                }
            } else if (i == 3) {
                h hVar = new h();
                try {
                    hVar.az(bArr);
                    v.i("MicroMsg.BackupPcRecoverServer", "summerbak start response, SessionCount:%d, MsgCount:%d, DataSize:%d", Long.valueOf(hVar.eeH), Long.valueOf(hVar.eeI), Long.valueOf(hVar.eeK));
                    if (com.tencent.mm.plugin.backup.g.b.UZ().equals(hVar.ID)) {
                        com.tencent.mm.plugin.backup.g.b.UL().ebo = hVar.eeG;
                        this.ebV = hVar.eeH;
                        this.ebW = hVar.eeI;
                        j = hVar.eeK;
                        ak.yW();
                        e.aQ(com.tencent.mm.model.c.xn());
                        ak.yW();
                        e.aQ(com.tencent.mm.model.c.xo());
                        StringBuilder stringBuilder = new StringBuilder();
                        ak.yW();
                        e.e(new File(stringBuilder.append(com.tencent.mm.model.c.xn()).append(".tem").toString()));
                        stringBuilder = new StringBuilder();
                        ak.yW();
                        e.e(new File(stringBuilder.append(com.tencent.mm.model.c.xo()).append(".tem").toString()));
                        if (this.eaC != null) {
                            this.handler.post(new Runnable(this) {
                                final /* synthetic */ b ecg;

                                {
                                    this.ecg = r1;
                                }

                                public final void run() {
                                    this.ecg.eaC.bM(true);
                                }
                            });
                        }
                        com.tencent.mm.plugin.backup.g.b.a(new com.tencent.mm.plugin.backup.g.b.a(this) {
                            final /* synthetic */ b ecg;

                            public final void run() {
                                double d = 5.24288E8d;
                                if (this.ecg.eaC != null) {
                                    this.ecg.handler.post(new Runnable(this) {
                                        final /* synthetic */ AnonymousClass2 eci;

                                        {
                                            this.eci = r1;
                                        }

                                        public final void run() {
                                            this.eci.ecg.eaC.bM(false);
                                        }
                                    });
                                }
                                PLong pLong = new PLong();
                                PLong pLong2 = new PLong();
                                ak.yW();
                                com.tencent.mm.plugin.backup.g.g.a(0, pLong, pLong2, com.tencent.mm.model.c.xq());
                                long j = pLong2.value;
                                if (((double) j) * 0.1d <= 5.24288E8d) {
                                    d = ((double) j) * 0.1d;
                                }
                                long j2 = (j - ((long) d)) / 1048576;
                                if (!this.eiS) {
                                    b.o(2, 0);
                                    com.tencent.mm.plugin.backup.g.b.UP().Tt();
                                    com.tencent.mm.plugin.backup.g.b.UL().h(this.dbSize, this.eiU);
                                    this.ecg.hU(-9);
                                    g.iuh.a(400, 62, 1, false);
                                    g.iuh.h(13736, Integer.valueOf(MMGIFException.D_GIF_ERR_NOT_GIF_FILE), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2));
                                } else if (j2 >= j) {
                                    b.o(0, j2);
                                    com.tencent.mm.plugin.backup.g.b.UL().TE();
                                } else {
                                    b.o(2, j2);
                                    com.tencent.mm.plugin.backup.g.b.UP().Tt();
                                    this.ecg.hU(-10);
                                    g.iuh.a(400, 6, 1, false);
                                    g.iuh.h(13736, Integer.valueOf(MMGIFException.D_GIF_ERR_NO_SCRN_DSCR), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2));
                                }
                            }
                        }, false);
                        this.ebZ = System.currentTimeMillis();
                        v.i("MicroMsg.BackupPcRecoverServer", "summerbak recoverStartTime:%d", Long.valueOf(this.ebZ));
                        return;
                    }
                    o(1, 0);
                    com.tencent.mm.plugin.backup.g.b.UL();
                    a.TK();
                    v.e("MicroMsg.BackupPcRecoverServer", "summerbak startRequst not the same id.");
                    hU(-8);
                } catch (Throwable e222) {
                    v.a("MicroMsg.BackupPcRecoverServer", e222, "start req parse from buf error.", new Object[0]);
                }
            } else if (i == 11) {
                com.tencent.mm.plugin.backup.d.e eVar = new com.tencent.mm.plugin.backup.d.e();
                try {
                    eVar.az(bArr);
                    this.ebX = eVar.eex;
                    this.ebY = eVar.eey;
                    com.tencent.mm.plugin.backup.g.b.UL().ebp = this.ebX;
                    com.tencent.mm.plugin.backup.g.b.UL().ebq = this.ebY;
                    if (this.ebY.size() != this.ebX.size() * 2) {
                        com.tencent.mm.plugin.backup.g.b.UL();
                        a.TK();
                        return;
                    }
                    com.tencent.mm.plugin.backup.g.b.UL().ebf = 1;
                    com.tencent.mm.plugin.backup.g.b.UL().ebg = this.ebX.size();
                    hU(8);
                    r2 = new LinkedList();
                    a(this.ebX, this.ebY, r2);
                    f fVar = new f();
                    fVar.eex = this.ebX;
                    fVar.eey = r2;
                    com.tencent.mm.plugin.backup.g.b.UL().TH();
                    try {
                        v.i("MicroMsg.BackupPcRecoverServer", "summerbak send requestsession resp, SessionName size:%d, TimeInterval size:%d", Integer.valueOf(this.ebX.size()), Integer.valueOf(r2.size()));
                        com.tencent.mm.plugin.backup.b.b.r(fVar.toByteArray(), 12);
                    } catch (Throwable e2222) {
                        v.a("MicroMsg.BackupPcRecoverServer", e2222, "buf to BackupRequestSessionResponse err.", new Object[0]);
                    }
                } catch (Throwable e22222) {
                    v.a("MicroMsg.BackupPcRecoverServer", e22222, "session req parse from buf error.", new Object[0]);
                }
            } else if (i == 6) {
                r rVar = new r();
                q qVar = new q();
                try {
                    qVar.az(bArr);
                    v.i("MicroMsg.BackupPcRecoverServer", "summerbak receive recoverData id:%s, type:%d, start:%d, end:%d", qVar.efo, Integer.valueOf(qVar.efp), Integer.valueOf(qVar.efr), Integer.valueOf(qVar.efs));
                    if (!(com.tencent.mm.plugin.backup.g.b.UY() == null || qVar.eew == null)) {
                        qVar.eew = new com.tencent.mm.ba.b(AesEcb.aesCryptEcb(qVar.eew.lVU, com.tencent.mm.plugin.backup.g.b.UY(), false, qVar.efs == qVar.efq));
                    }
                    if (qVar.efp == 1 && qVar.eew != null) {
                        this.ebL.add(qVar.efo);
                        String str3 = com.tencent.mm.plugin.backup.g.b.Vj() + "mmbakItem/" + com.tencent.mm.plugin.backup.g.g.pd(qVar.efo);
                        v.i("MicroMsg.BackupPcRecoverServer", "receive datapush text dataid:%s, dir:%s", qVar.efo, str3);
                        File file = new File(str3 + qVar.efo);
                        r4 = file.exists() ? file.length() : 0;
                        e.a(str3, qVar.efo, qVar.eew.lVU);
                        file = new File(str3 + qVar.efo);
                        if (r4 == (file.exists() ? file.length() : 0)) {
                            v.e("MicroMsg.BackupPcRecoverServer", "append failed and try again:%s", str3 + qVar.efo);
                            e.a(str3, qVar.efo, qVar.eew.lVU);
                        }
                        this.recvSize += (long) qVar.eew.lVU.length;
                    }
                    if (qVar.efp == 2) {
                        String str4 = com.tencent.mm.plugin.backup.g.b.Vj() + "mmbakMeida/" + com.tencent.mm.plugin.backup.g.g.pd(qVar.efo);
                        v.i("MicroMsg.BackupPcRecoverServer", "receive datapush media dataid:%s, dir:%s", qVar.efo, str4);
                        RandomAccessFile randomAccessFile = null;
                        try {
                            File file2 = new File(str4);
                            if (!file2.exists()) {
                                file2.mkdirs();
                            }
                            str4 = str4 + qVar.efo;
                            file2 = new File(str4);
                            if (!file2.exists()) {
                                file2.createNewFile();
                            }
                            RandomAccessFile randomAccessFile2 = new RandomAccessFile(str4, "rw");
                            try {
                                randomAccessFile2.setLength((long) qVar.efq);
                                randomAccessFile2.seek((long) qVar.efr);
                                randomAccessFile2.write(qVar.eew.lVU);
                                try {
                                    randomAccessFile2.close();
                                } catch (Exception e3) {
                                }
                            } catch (Exception e4) {
                                e22222 = e4;
                                randomAccessFile = randomAccessFile2;
                                try {
                                    v.a("MicroMsg.BackupPcRecoverServer", e22222, "summerbak writeMediaToFile fail with exception", new Object[0]);
                                    if (randomAccessFile != null) {
                                        try {
                                            randomAccessFile.close();
                                        } catch (Exception e5) {
                                        }
                                    }
                                    this.recvSize += (long) qVar.eew.lVU.length;
                                    this.ebU.add(qVar.efo);
                                    v.i("MicroMsg.BackupPcRecoverServer", "onNotify recvSize/totalSize: %d, %d", Long.valueOf(this.recvSize), Long.valueOf(this.beE));
                                    if (this.beE < this.recvSize) {
                                        this.beE = this.recvSize;
                                    }
                                    rVar.efo = qVar.efo;
                                    rVar.efp = qVar.efp;
                                    rVar.efr = qVar.efr;
                                    rVar.efs = qVar.efs;
                                    rVar.eeO = 0;
                                    com.tencent.mm.plugin.backup.b.b.e(rVar.toByteArray(), 7, i2);
                                } catch (Throwable th) {
                                    e22222 = th;
                                    if (randomAccessFile != null) {
                                        try {
                                            randomAccessFile.close();
                                        } catch (Exception e6) {
                                        }
                                    }
                                    throw e22222;
                                }
                            } catch (Throwable th2) {
                                e22222 = th2;
                                randomAccessFile = randomAccessFile2;
                                if (randomAccessFile != null) {
                                    randomAccessFile.close();
                                }
                                throw e22222;
                            }
                        } catch (Exception e7) {
                            e22222 = e7;
                            v.a("MicroMsg.BackupPcRecoverServer", e22222, "summerbak writeMediaToFile fail with exception", new Object[0]);
                            if (randomAccessFile != null) {
                                randomAccessFile.close();
                            }
                            this.recvSize += (long) qVar.eew.lVU.length;
                            this.ebU.add(qVar.efo);
                            v.i("MicroMsg.BackupPcRecoverServer", "onNotify recvSize/totalSize: %d, %d", Long.valueOf(this.recvSize), Long.valueOf(this.beE));
                            if (this.beE < this.recvSize) {
                                this.beE = this.recvSize;
                            }
                            rVar.efo = qVar.efo;
                            rVar.efp = qVar.efp;
                            rVar.efr = qVar.efr;
                            rVar.efs = qVar.efs;
                            rVar.eeO = 0;
                            com.tencent.mm.plugin.backup.b.b.e(rVar.toByteArray(), 7, i2);
                        }
                        this.recvSize += (long) qVar.eew.lVU.length;
                        this.ebU.add(qVar.efo);
                    }
                    v.i("MicroMsg.BackupPcRecoverServer", "onNotify recvSize/totalSize: %d, %d", Long.valueOf(this.recvSize), Long.valueOf(this.beE));
                    if (this.beE < this.recvSize) {
                        this.beE = this.recvSize;
                    }
                    rVar.efo = qVar.efo;
                    rVar.efp = qVar.efp;
                    rVar.efr = qVar.efr;
                    rVar.efs = qVar.efs;
                    rVar.eeO = 0;
                } catch (Throwable e222222) {
                    v.a("MicroMsg.BackupPcRecoverServer", e222222, "parseFrom", new Object[0]);
                    rVar.efo = SQLiteDatabase.KeyEmpty;
                    rVar.efp = 0;
                    rVar.efr = 0;
                    rVar.efs = 0;
                    rVar.eeO = 1;
                }
                try {
                    com.tencent.mm.plugin.backup.b.b.e(rVar.toByteArray(), 7, i2);
                } catch (Throwable e2222222) {
                    v.a("MicroMsg.BackupPcRecoverServer", e2222222, "sendResp", new Object[0]);
                }
            } else if (i == 13) {
                y yVar = new y();
                try {
                    yVar.az(bArr);
                    v.i("MicroMsg.BackupPcRecoverServer", "summerbak receive svrId request.");
                    r2 = yVar.efG;
                } catch (Throwable e22222222) {
                    v.a("MicroMsg.BackupPcRecoverServer", e22222222, "svrId req parse from buf error.", new Object[0]);
                }
                z zVar = new z();
                zVar.efG = yVar.efG;
                zVar.efI = yVar.efI;
                zVar.efH = yVar.efH;
                zVar.eer = yVar.eer;
                try {
                    v.i("MicroMsg.BackupPcRecoverServer", "send SvrID resp");
                    com.tencent.mm.plugin.backup.b.b.r(zVar.toByteArray(), 14);
                } catch (Throwable e222222222) {
                    v.a("MicroMsg.BackupPcRecoverServer", e222222222, "buf to PacketSvrIDResponse err.", new Object[0]);
                }
            } else if (i == 15) {
                s sVar = new s();
                try {
                    sVar.az(bArr);
                    v.i("MicroMsg.BackupPcRecoverServer", "summerbak receive tag, MsgDataID:%s, BakChatName:%s, StartTime:%d, EndTime:%d,  NickName:%s", sVar.efx, sVar.eer, Long.valueOf(sVar.efv), Long.valueOf(sVar.efw), sVar.efy);
                } catch (Throwable e2222222222) {
                    v.a("MicroMsg.BackupPcRecoverServer", e2222222222, "summerbak tag req parse from buf error.", new Object[0]);
                }
                if (this.ecc.containsKey(sVar.efx)) {
                    v.i("MicroMsg.BackupPcRecoverServer", "summerbak the same tag has received, ignore. MsgDataID:%s", sVar.efx);
                } else {
                    int size;
                    ak.yW();
                    com.tencent.mm.model.c.vf().a(a.USERINFO_BACKUP_PC_RECOVERING_BOOLEAN, Boolean.valueOf(true));
                    com.tencent.mm.sdk.h.c kVar = new k();
                    kVar.field_msgDataId = sVar.efx;
                    if (!ak.yW().xy().b(kVar, new String[0])) {
                        kVar.field_bakchatName = sVar.eer;
                        kVar.field_startTime = sVar.efv;
                        kVar.field_endTime = sVar.efw;
                        kVar.field_nickName = sVar.efy;
                        v.i("MicroMsg.BackupPcRecoverServer", "summerbak insert BackupPcRecoverTagInfoStorage ret[%b], systemRowid[%d]", Boolean.valueOf(ak.yW().xy().b(kVar)), Long.valueOf(kVar.nmb));
                        this.ecc.put(sVar.efx, kVar);
                    } else if (sVar.efv == 0 && sVar.efw == 0) {
                        this.ecc.put(sVar.efx, kVar);
                        v.i("MicroMsg.BackupPcRecoverServer", "summerbak database has this tag, add to tagHashMap, tagHashMap size:%d", Integer.valueOf(this.ecc.size()));
                    }
                    Pair pair = (Pair) this.ecd.get(sVar.eer);
                    if (pair == null) {
                        kVar = new i();
                        kVar.field_sessionName = sVar.eer;
                        if (ak.yW().xz().b(kVar, new String[0])) {
                            if (kVar.field_startTime > sVar.efv) {
                                kVar.field_startTime = sVar.efv;
                            }
                            if (kVar.field_endTime < sVar.efw) {
                                kVar.field_endTime = sVar.efw;
                            }
                            this.ecd.put(kVar.field_sessionName, new Pair(Long.valueOf(kVar.field_startTime), Long.valueOf(kVar.field_endTime)));
                            boolean b = ak.yW().xz().b(kVar, false, SQLiteDatabase.KeyEmpty);
                            v.i("MicroMsg.BackupPcRecoverServer", "summerbak update BackupPcRecoverTagInfoStorage ret[%b], systemRowid[%d]", Boolean.valueOf(b), Long.valueOf(kVar.nmb));
                        } else {
                            this.ecd.put(sVar.eer, new Pair(Long.valueOf(sVar.efv), Long.valueOf(sVar.efw)));
                            kVar.field_startTime = sVar.efv;
                            kVar.field_endTime = sVar.efw;
                            v.i("MicroMsg.BackupPcRecoverServer", "summerbak insert BackupPcRecoverSessionInfoStorage ret[%b], systemRowid[%d]", Boolean.valueOf(ak.yW().xz().b(kVar)), Long.valueOf(kVar.nmb));
                        }
                    } else {
                        r4 = ((Long) pair.first).longValue();
                        long longValue = ((Long) pair.second).longValue();
                        if (r4 > sVar.efv) {
                            j = sVar.efv;
                        } else {
                            j = r4;
                        }
                        if (longValue < sVar.efw) {
                            r4 = sVar.efw;
                        } else {
                            r4 = longValue;
                        }
                        this.ecd.put(sVar.eer, new Pair(Long.valueOf(j), Long.valueOf(r4)));
                        com.tencent.mm.sdk.h.c iVar = new i();
                        iVar.field_sessionName = sVar.eer;
                        if (ak.yW().xz().b(iVar, new String[0])) {
                            iVar.field_startTime = j;
                            iVar.field_endTime = r4;
                            boolean b2 = ak.yW().xz().b(iVar, false, SQLiteDatabase.KeyEmpty);
                            v.i("MicroMsg.BackupPcRecoverServer", "summerbak update BackupPcRecoverTagInfoStorage ret[%b], systemRowid[%d]", Boolean.valueOf(b2), Long.valueOf(iVar.nmb));
                        } else {
                            iVar.field_startTime = j;
                            iVar.field_endTime = r4;
                            v.i("MicroMsg.BackupPcRecoverServer", "summerbak insert BackupPcRecoverTagInfoStorage ret[%b], systemRowid[%d]", Boolean.valueOf(ak.yW().xz().b(iVar)), Long.valueOf(iVar.nmb));
                        }
                    }
                    a UL = com.tencent.mm.plugin.backup.g.b.UL();
                    if (this.ecd.size() < this.ebX.size()) {
                        size = this.ecd.size();
                    } else {
                        size = this.ebX.size();
                    }
                    UL.ebf = size;
                    com.tencent.mm.plugin.backup.g.b.UL().ebg = this.ebX.size();
                    hU(8);
                }
                t tVar = new t();
                tVar.eer = sVar.eer;
                tVar.efv = sVar.efv;
                tVar.efw = sVar.efw;
                tVar.efx = sVar.efx;
                try {
                    v.i("MicroMsg.BackupPcRecoverServer", "summerbak send tag resp");
                    com.tencent.mm.plugin.backup.b.b.r(tVar.toByteArray(), 16);
                } catch (Throwable e22222222222) {
                    v.a("MicroMsg.BackupPcRecoverServer", e22222222222, "summerbak buf to PacketBackupDataTagResponse err.", new Object[0]);
                }
            } else if (i == 8) {
                try {
                    new com.tencent.mm.plugin.backup.c.b().az(bArr);
                    v.i("MicroMsg.BackupPcRecoverServer", "summerbak receive finish request.");
                } catch (Throwable e222222222222) {
                    v.a("MicroMsg.BackupPcRecoverServer", e222222222222, "summerbak buf to parseFrom err.", new Object[0]);
                }
                this.ecf = 0;
                ak.yW();
                com.tencent.mm.model.c.vf().a(a.USERINFO_BACKUP_PC_RECOVERING_BOOLEAN, Boolean.valueOf(false));
                com.tencent.mm.plugin.backup.g.b.UL().TF();
                com.tencent.mm.plugin.backup.g.b.UL().TI();
                com.tencent.mm.plugin.backup.g.b.UL().ebf = this.ecd.size();
                com.tencent.mm.plugin.backup.g.b.UL().ebg = this.ebX.size();
                hU(9);
                g.iuh.a(400, 19, 1, false);
                this.eca = System.currentTimeMillis();
                g.iuh.a(400, 20, this.eca - this.ebZ, false);
                g.iuh.a(400, 21, this.beE, false);
                g.iuh.h(13737, Integer.valueOf(MMGIFException.D_GIF_ERR_READ_FAILED), Long.valueOf(this.beE), Long.valueOf(r8), Integer.valueOf(2));
                v.i("MicroMsg.BackupPcRecoverServer", "summerbak recover success. recoverTotalSize:%d, recoverCostTime:%d, recoverStartTime:%d, recoverEndTime:%d", Long.valueOf(this.beE), Long.valueOf(r8), Long.valueOf(this.ebZ), Long.valueOf(this.eca));
            }
        } else if (i == 5) {
            bl(true);
            hU(-100);
        }
    }

    static void o(int i, long j) {
        com.tencent.mm.plugin.backup.d.i iVar = new com.tencent.mm.plugin.backup.d.i();
        iVar.ID = com.tencent.mm.plugin.backup.g.b.UZ();
        iVar.eeO = i;
        com.tencent.mm.plugin.backup.g.b.UL();
        iVar.eeJ = a.aC(j);
        try {
            v.i("MicroMsg.BackupPcRecoverServer", "send start resp, status:%d", Integer.valueOf(i));
            com.tencent.mm.plugin.backup.b.b.r(iVar.toByteArray(), 4);
        } catch (Throwable e) {
            v.a("MicroMsg.BackupPcRecoverServer", e, "buf to BackupStartRequest err.", new Object[0]);
        }
    }

    public final void TW() {
        synchronized (this.lock) {
            if (this.cAv) {
                return;
            }
            if (this.ebK != null) {
                this.ebK.cancel();
            }
            com.tencent.mm.plugin.backup.g.b.UL().ebf = 1;
            com.tencent.mm.plugin.backup.g.b.UL().ebg = this.ecd.size();
            hU(10);
            this.ebK = new n(this.ebL, this.ecd.size());
            this.ebK.eaC = this;
            this.ebK.im(1);
            g.iuh.a(400, 24, 1, false);
        }
    }

    private void a(LinkedList<String> linkedList, LinkedList<Long> linkedList2, LinkedList<Long> linkedList3) {
        if (this.ecd == null || this.ecd.size() == 0) {
            linkedList3.addAll(linkedList2);
            return;
        }
        Iterator it = linkedList2.iterator();
        Iterator it2 = linkedList.iterator();
        while (it2.hasNext()) {
            String str = (String) it2.next();
            if (it.hasNext()) {
                long longValue = ((Long) it.next()).longValue();
                if (this.ecd.get(str) != null) {
                    long longValue2 = ((Long) ((Pair) this.ecd.get(str)).second).longValue();
                    if (longValue2 > longValue) {
                        linkedList3.add(Long.valueOf(longValue2));
                    } else {
                        linkedList3.add(Long.valueOf(longValue));
                    }
                } else {
                    linkedList3.add(Long.valueOf(longValue));
                }
                if (it.hasNext()) {
                    linkedList3.add(it.next());
                }
            }
        }
    }

    public final void TR() {
        if (this.eaC != null) {
            this.handler.post(new Runnable(this) {
                final /* synthetic */ b ecg;

                {
                    this.ecg = r1;
                }

                public final void run() {
                    this.ecg.eaC.TR();
                }
            });
        }
    }

    public final void TS() {
        if (this.eaC != null) {
            this.handler.post(new Runnable(this) {
                final /* synthetic */ b ecg;

                {
                    this.ecg = r1;
                }

                public final void run() {
                    this.ecg.eaC.TS();
                }
            });
        }
        if (this.ecb != null) {
            this.handler.post(new Runnable(this) {
                final /* synthetic */ b ecg;

                {
                    this.ecg = r1;
                }

                public final void run() {
                    this.ecg.ecb.TQ();
                }
            });
        }
    }

    public final void bM(final boolean z) {
        if (this.eaC != null) {
            this.handler.post(new Runnable(this) {
                final /* synthetic */ b ecg;

                public final void run() {
                    this.ecg.eaC.bM(z);
                }
            });
        }
    }

    public final void hU(int i) {
        com.tencent.mm.plugin.backup.g.b.UL();
        a.hO(i);
        if (this.eaC != null) {
            this.handler.post(new Runnable(this) {
                final /* synthetic */ b ecg;

                {
                    this.ecg = r1;
                }

                public final void run() {
                    this.ecg.eaC.TS();
                }
            });
        }
        if (this.ecb != null) {
            this.handler.post(new Runnable(this) {
                final /* synthetic */ b ecg;

                {
                    this.ecg = r1;
                }

                public final void run() {
                    this.ecg.ecb.TQ();
                }
            });
        }
    }
}
