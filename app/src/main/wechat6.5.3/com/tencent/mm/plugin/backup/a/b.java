package com.tencent.mm.plugin.backup.a;

import android.os.Process;
import android.util.Pair;
import com.tencent.mm.jniinterface.AesEcb;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.backup.d.q;
import com.tencent.mm.plugin.backup.d.r;
import com.tencent.mm.protocal.c.dx;
import com.tencent.mm.protocal.c.dy;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.k;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public final class b {
    public com.tencent.mm.v.e cAR = new com.tencent.mm.v.e(this) {
        final /* synthetic */ b ecU;

        {
            this.ecU = r1;
        }

        public final void a(int i, int i2, String str, k kVar) {
            if (6 == kVar.getType()) {
                final b bVar = (b) kVar;
                v.i("MicroMsg.BackupPcDataPush.dkbackup", "enddatapush [%s] queue[%d,%d] time[%d,%d] ret[%d,%d,%s] id:%s type:%d size:%d/%d ", this.ecU.ecR, Integer.valueOf(this.ecU.ecP.size()), Integer.valueOf(this.ecU.ecO.size()), Long.valueOf(be.ay(bVar.startTime)), Long.valueOf(be.ay(bVar.edc)), Integer.valueOf(i), Integer.valueOf(i2), str, bVar.eda.efo, Integer.valueOf(bVar.eda.efp), Integer.valueOf(bVar.eda.efs - bVar.eda.efr), Integer.valueOf(bVar.eda.efq));
                this.ecU.ecP.remove(bVar);
                final String b = this.ecU.b(bVar);
                if (b != null) {
                    ad.o(new Runnable(this) {
                        final /* synthetic */ AnonymousClass2 ecX;

                        public final void run() {
                            this.ecX.ecU.ecB.ae(b, bVar.eda.efq);
                        }
                    });
                }
            }
        }
    };
    c ecB = null;
    public LinkedBlockingQueue<b> ecO = new LinkedBlockingQueue(10);
    public LinkedBlockingQueue<b> ecP = new LinkedBlockingQueue(20);
    private HashMap<String, HashSet<b>> ecQ = new HashMap();
    public String ecR = null;
    boolean ecS = false;
    private Runnable ecT = new Runnable(this) {
        final /* synthetic */ b ecU;

        {
            this.ecU = r1;
        }

        public final void run() {
            Process.setThreadPriority(-8);
            b bVar = null;
            while (!this.ecU.ecS) {
                be.Ni();
                if (bVar == null) {
                    try {
                        bVar = (b) this.ecU.ecO.poll(500, TimeUnit.MILLISECONDS);
                    } catch (Throwable e) {
                        v.a("MicroMsg.BackupPcDataPush.dkbackup", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                        bVar = null;
                    }
                }
                if (bVar != null) {
                    try {
                        if (this.ecU.ecP.offer(bVar, 500, TimeUnit.MILLISECONDS)) {
                            bVar.Uh();
                            bVar = null;
                        }
                    } catch (Throwable e2) {
                        v.a("MicroMsg.BackupPcDataPush.dkbackup", e2, SQLiteDatabase.KeyEmpty, new Object[0]);
                    }
                }
            }
        }
    };
    private Thread thread = null;

    private class a {
        int cyu = 0;
        final /* synthetic */ b ecU;
        byte[] ecY = null;
        private FileInputStream ecZ = null;
        String filePath = null;
        int offset = 0;

        public a(b bVar, String str) {
            int i;
            this.ecU = bVar;
            this.filePath = str;
            this.ecY = null;
            String str2 = this.filePath;
            ak.yW();
            if (str2.startsWith(com.tencent.mm.model.c.wY())) {
                com.tencent.mm.storage.a.c rg = com.tencent.mm.pluginsdk.j.a.bmr().rg(this.filePath.substring(this.filePath.lastIndexOf("/") + 1));
                if (rg == null) {
                    i = 0;
                } else if ((rg.field_reserved4 & com.tencent.mm.storage.a.c.nxh) != com.tencent.mm.storage.a.c.nxh) {
                    i = 0;
                } else {
                    this.ecY = com.tencent.mm.pluginsdk.j.a.bmr().g(rg);
                    i = 1;
                }
            } else {
                i = 0;
            }
            if (i != 0) {
                this.cyu = be.bm(this.ecY);
            } else {
                this.cyu = com.tencent.mm.a.e.aQ(this.filePath);
            }
            if (this.cyu < 0) {
                this.cyu = 0;
            }
        }

        final boolean a(byte[] bArr, boolean z) {
            try {
                if (this.ecZ == null) {
                    this.ecZ = new FileInputStream(this.filePath);
                }
                if (this.ecZ.read(bArr) != bArr.length) {
                    return false;
                }
                if (z) {
                    this.ecZ.close();
                }
                return true;
            } catch (Exception e) {
                return false;
            }
        }
    }

    public interface c {
        void ae(String str, int i);
    }

    public class b extends com.tencent.mm.plugin.backup.b.b {
        com.tencent.mm.v.e cAR;
        final /* synthetic */ b ecU;
        q eda = new q();
        r edb = new r();
        long edc;
        byte[] key = null;
        long startTime = be.Ni();

        public final com.tencent.mm.ba.a Ud() {
            return this.edb;
        }

        public final com.tencent.mm.ba.a Ue() {
            return this.eda;
        }

        public final int getType() {
            return 6;
        }

        public final void Uf() {
            this.cAR.a(0, this.edb.eeO, SQLiteDatabase.KeyEmpty, this);
        }

        public b(b bVar, com.tencent.mm.v.e eVar) {
            this.ecU = bVar;
            this.cAR = eVar;
            this.key = com.tencent.mm.plugin.backup.g.b.UY();
        }

        public final com.tencent.mm.ba.b b(byte[] bArr, boolean z) {
            if (be.bm(this.key) <= 0 || be.bm(bArr) <= 0) {
                return new com.tencent.mm.ba.b(new byte[0]);
            }
            return new com.tencent.mm.ba.b(AesEcb.aesCryptEcb(bArr, this.key, true, z));
        }
    }

    public class d extends b {
        final /* synthetic */ b ecU;
        private a edd = null;

        public d(b bVar, com.tencent.mm.v.e eVar, String str, a aVar) {
            this.ecU = bVar;
            super(bVar, eVar);
            this.edd = aVar;
            this.eda.efo = str;
            this.eda.efp = 2;
        }

        public final boolean Uh() {
            Pair pair;
            this.edc = be.Ni();
            a aVar = this.edd;
            if (aVar.cyu <= 0) {
                pair = new Pair(Integer.valueOf(0), new byte[0]);
            } else {
                int i = (int) (((long) (aVar.cyu - aVar.offset)) > 524288 ? 524288 : (long) (aVar.cyu - aVar.offset));
                Object obj = new byte[i];
                if (aVar.ecY != null) {
                    System.arraycopy(aVar.ecY, aVar.offset, obj, 0, i);
                } else {
                    aVar.a(obj, ((long) i) < 524288);
                }
                int i2 = aVar.offset;
                aVar.offset += i;
                pair = new Pair(Integer.valueOf(i2), obj);
            }
            if (pair.second == null || pair.first == null) {
                v.w("MicroMsg.BackupBaseScene.dkbackup", "doScene Error Read OVERFLOW    file:%s", this.edd.filePath);
                return false;
            }
            byte[] bArr = (byte[]) pair.second;
            this.eda.efq = this.edd.cyu;
            this.eda.efr = ((Integer) pair.first).intValue();
            this.eda.efs = this.eda.efr + bArr.length;
            this.eda.eew = b(bArr, this.eda.efs == this.eda.efq);
            v.i("MicroMsg.BackupBaseScene.dkbackup", "doScene ret:%b media id:%s [%d,%d,%d,%d] time:%d", Boolean.valueOf(super.Uq()), this.eda.efo, Integer.valueOf(this.eda.eew.lVU.length), Integer.valueOf(this.eda.eew.lVU.length), Integer.valueOf(this.eda.efr), Integer.valueOf(this.eda.efs), Long.valueOf(be.ay(this.edc)));
            return super.Uq();
        }
    }

    public class e extends b {
        final /* synthetic */ b ecU;
        private LinkedList<dx> ede;

        public e(b bVar, com.tencent.mm.v.e eVar, String str, LinkedList<dx> linkedList) {
            this.ecU = bVar;
            super(bVar, eVar);
            this.ede = linkedList;
            this.eda.efo = str;
        }

        public final boolean Uh() {
            byte[] toByteArray;
            int i = -1;
            this.edc = be.Ni();
            try {
                dy dyVar = new dy();
                dyVar.eeu = this.ede;
                dyVar.eet = this.ede.size();
                toByteArray = dyVar.toByteArray();
            } catch (Exception e) {
                Exception exception = e;
                String str = "MicroMsg.BackupBaseScene.dkbackup";
                String str2 = "ERROR: BakChatMsgList to Buffer list:%d :%s";
                Object[] objArr = new Object[2];
                objArr[0] = Integer.valueOf(this.ede == null ? -1 : this.ede.size());
                objArr[1] = exception.getMessage();
                v.e(str, str2, objArr);
                toByteArray = null;
            }
            if (toByteArray == null) {
                toByteArray = new byte[0];
            }
            this.eda.efr = 0;
            this.eda.efs = toByteArray.length;
            this.eda.efq = toByteArray.length;
            this.eda.eew = b(toByteArray, true);
            boolean Uq = super.Uq();
            String str3 = "MicroMsg.BackupBaseScene.dkbackup";
            String str4 = "doScene ret:%b text id:%s list:%d [%d,%d,%d,%d] time:%d";
            Object[] objArr2 = new Object[8];
            objArr2[0] = Boolean.valueOf(Uq);
            objArr2[1] = this.eda.efo;
            if (this.ede != null) {
                i = this.ede.size();
            }
            objArr2[2] = Integer.valueOf(i);
            objArr2[3] = Integer.valueOf(this.eda.eew.lVU.length);
            objArr2[4] = Integer.valueOf(this.eda.efq);
            objArr2[5] = Integer.valueOf(this.eda.efr);
            objArr2[6] = Integer.valueOf(this.eda.efs);
            objArr2[7] = Long.valueOf(be.ay(this.edc));
            v.i(str3, str4, objArr2);
            return Uq;
        }
    }

    public final synchronized void reset() {
        this.ecS = true;
        this.ecO.clear();
        this.ecP.clear();
        this.ecQ.clear();
        this.ecB = null;
        try {
            this.thread.join();
        } catch (Exception e) {
        }
    }

    public final synchronized boolean a(String str, c cVar) {
        boolean z = true;
        synchronized (this) {
            if (be.kS(str) || cVar == null) {
                v.e("MicroMsg.BackupPcDataPush.dkbackup", "init failed session:%s idcb:%s", str, cVar);
                z = false;
            } else {
                reset();
                this.ecR = str;
                this.ecB = cVar;
                this.ecS = false;
            }
        }
        return z;
    }

    public final synchronized boolean Ug() {
        boolean z = true;
        synchronized (this) {
            v.i("MicroMsg.BackupPcDataPush.dkbackup", "checkFinish  queue[%d,%d]", Integer.valueOf(this.ecP.size()), Integer.valueOf(this.ecO.size()));
            if ((this.ecO.size() + this.ecP.size()) + this.ecQ.size() != 0) {
                z = false;
            }
        }
        return z;
    }

    public final boolean aW(String str, String str2) {
        int i;
        int i2 = 0;
        v.i("MicroMsg.BackupPcDataPush.dkbackup", "startdatapush [%s] queue[%d,%d] media id:%s file:%s ", this.ecR, Integer.valueOf(this.ecP.size()), Integer.valueOf(this.ecO.size()), str, str2);
        a aVar = new a(this, str2);
        if (aVar.cyu <= 0) {
            i = 1;
        } else {
            i = (int) (((long) aVar.cyu) / 524288);
            if (((long) aVar.cyu) % 524288 != 0) {
                i++;
            }
        }
        while (i2 < i) {
            b dVar = new d(this, this.cAR, str, aVar);
            a(str, dVar);
            a(dVar);
            i2++;
        }
        return true;
    }

    public final void a(b bVar) {
        if (this.thread == null) {
            this.thread = com.tencent.mm.sdk.i.e.c(this.ecT, "MicroMsg.BackupPcDataPush.dkbackup_" + this.ecR);
            this.thread.start();
        }
        while (!this.ecO.offer(bVar, 1000, TimeUnit.MILLISECONDS)) {
            try {
                v.v("MicroMsg.BackupPcDataPush.dkbackup", "waitQueue is full ,wait [%s] [%s,%s]", this.ecR, Integer.valueOf(this.ecP.size()), Integer.valueOf(this.ecO.size()));
            } catch (Exception e) {
                v.v("MicroMsg.BackupPcDataPush.dkbackup", "waitQueue Exception ,wait [%s] [%s,%s]", this.ecR, Integer.valueOf(this.ecP.size()), Integer.valueOf(this.ecO.size()));
            }
        }
    }

    public final synchronized void a(String str, b bVar) {
        HashSet hashSet = (HashSet) this.ecQ.remove(str);
        if (hashSet == null) {
            hashSet = new HashSet();
        }
        hashSet.add(bVar);
        this.ecQ.put(str, hashSet);
    }

    final synchronized String b(b bVar) {
        String str;
        String str2 = bVar.eda.efo;
        HashSet hashSet = (HashSet) this.ecQ.remove(str2);
        hashSet.remove(bVar);
        if (hashSet.size() == 0) {
            str = str2;
        } else {
            this.ecQ.put(str2, hashSet);
            str = null;
        }
        return str;
    }
}
