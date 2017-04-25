package com.tencent.mm.plugin.backup.b;

import android.os.Looper;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class b extends k {
    private static final Map<Integer, Set<e>> cAd = new HashMap();
    private static d edY;
    private static a edZ;
    private static final Map<Integer, b> eea = new HashMap();
    private static int eeb = 1;
    private static c eec = null;
    private static b eed = null;
    private static final ac handler = new ac(Looper.getMainLooper());
    private static int mode = -1;

    public interface a {
        void i(int i, byte[] bArr);

        int j(int i, byte[] bArr);
    }

    public interface b {
        void hT(int i);
    }

    public interface c {
        void TP();
    }

    public interface d {
        void a(boolean z, int i, byte[] bArr, int i2);
    }

    public abstract com.tencent.mm.ba.a Ud();

    public abstract com.tencent.mm.ba.a Ue();

    public abstract void Uf();

    public abstract int getType();

    public static void a(d dVar) {
        edY = dVar;
    }

    public static void a(a aVar) {
        edZ = aVar;
    }

    public static void setMode(int i) {
        mode = i;
    }

    public static int getMode() {
        return mode;
    }

    public static void clear() {
        v.i("MicroMsg.BackupBaseScene.dkbackup", "BackupBaseScene clear.");
        synchronized (eea) {
            cAd.clear();
            eea.clear();
            eeb = 1;
        }
    }

    public boolean Uh() {
        return bP(false);
    }

    public final boolean bP(boolean z) {
        PByteArray pByteArray = new PByteArray();
        try {
            byte[] toByteArray = Ue().toByteArray();
            synchronized (eea) {
                com.tencent.mm.plugin.backup.backupmodel.e.a(toByteArray, eeb, (short) getType(), pByteArray);
                if (edZ != null) {
                    edZ.i(eeb, pByteArray.value);
                }
                v.i("MicroMsg.BackupBaseScene.dkbackup", "BackupBaseScene doscene globalSeq:%d, isDirect:%b, type:%d, len:%d", Integer.valueOf(eeb), Boolean.valueOf(z), Integer.valueOf(getType()), Integer.valueOf(pByteArray.value.length));
                if (!z) {
                    eea.put(Integer.valueOf(eeb), this);
                }
                eeb++;
            }
            return true;
        } catch (Throwable e) {
            v.a("MicroMsg.BackupBaseScene.dkbackup", e, "req to buf fail: " + e.toString(), new Object[0]);
            return false;
        }
    }

    public final boolean Uq() {
        PByteArray pByteArray = new PByteArray();
        try {
            byte[] toByteArray = Ue().toByteArray();
            synchronized (eea) {
                int i = eeb;
                eeb++;
                com.tencent.mm.plugin.backup.backupmodel.e.a(toByteArray, i, (short) getType(), pByteArray);
                eea.put(Integer.valueOf(i), this);
                int j = edZ.j(i, pByteArray.value);
                v.i("MicroMsg.BackupBaseScene.dkbackup", "BackupBaseScene doscene  ret:%d globalSeq:%d, type:%d, len:%d", Integer.valueOf(j), Integer.valueOf(eeb), Integer.valueOf(getType()), Integer.valueOf(pByteArray.value.length));
            }
            return true;
        } catch (Throwable e) {
            v.a("MicroMsg.BackupBaseScene.dkbackup", e, "req to buf fail: " + e.toString(), new Object[0]);
            return false;
        }
    }

    public static boolean r(byte[] bArr, int i) {
        PByteArray pByteArray = new PByteArray();
        synchronized (eea) {
            com.tencent.mm.plugin.backup.backupmodel.e.a(bArr, eeb, (short) i, pByteArray);
            if (edZ != null) {
                edZ.i(eeb, pByteArray.value);
            }
            v.i("MicroMsg.BackupBaseScene.dkbackup", "BackupBaseScene sendBuf globalSeq:%d, type:%d, len:%d", Integer.valueOf(eeb), Integer.valueOf(i), Integer.valueOf(pByteArray.value.length));
            eeb++;
        }
        return true;
    }

    public static boolean e(byte[] bArr, int i, int i2) {
        PByteArray pByteArray = new PByteArray();
        com.tencent.mm.plugin.backup.backupmodel.e.a(bArr, i2, (short) i, pByteArray);
        if (edZ != null) {
            edZ.i(i2, pByteArray.value);
        }
        v.i("MicroMsg.BackupBaseScene.dkbackup", "BackupBaseScene sendResp globalSeq:%d, type:%d, len:%d", Integer.valueOf(i2), Integer.valueOf(i), Integer.valueOf(pByteArray.value.length));
        return true;
    }

    public static void b(boolean z, int i, int i2, byte[] bArr) {
        String str = "MicroMsg.BackupBaseScene.dkbackup";
        String str2 = "BackupBaseScene callback isLocal: %b,  globalSeq:%d   type:%d,  bufLen:%d";
        Object[] objArr = new Object[4];
        objArr[0] = Boolean.valueOf(z);
        objArr[1] = Integer.valueOf(i);
        objArr[2] = Integer.valueOf(i2);
        objArr[3] = Integer.valueOf(bArr == null ? 0 : bArr.length);
        v.i(str, str2, objArr);
        if (z) {
            try {
                v.w("MicroMsg.BackupBaseScene.dkbackup", "callback error buf content : " + new String(bArr));
            } catch (Exception e) {
            }
            b(z, i2, bArr, i);
            return;
        }
        com.tencent.mm.plugin.backup.g.b.UL().aA(System.currentTimeMillis());
        v.d("MicroMsg.BackupBaseScene.dkbackup", "updateHeartBeatTimeStamp type:%d, current time stamp:%d", Integer.valueOf(i2), Long.valueOf(System.currentTimeMillis()));
        synchronized (eea) {
            if (eea.containsKey(Integer.valueOf(i))) {
                b bVar = (b) eea.remove(Integer.valueOf(i));
                try {
                    bVar.Ud().az(bArr);
                    bVar.Uf();
                } catch (Throwable e2) {
                    bVar.e(3, -1, "buf to resq fail");
                    v.a("MicroMsg.BackupBaseScene.dkbackup", e2, "buf to resq fail: " + e2.toString(), new Object[0]);
                }
                return;
            }
            v.i("MicroMsg.BackupBaseScene.dkbackup", "notify globalSeq:%d, type:%d", Integer.valueOf(i), Integer.valueOf(i2));
            b(z, i2, bArr, i);
        }
    }

    private static void b(final boolean z, final int i, final byte[] bArr, final int i2) {
        handler.post(new Runnable() {
            public final void run() {
                if (b.edY != null) {
                    b.edY.a(z, i, bArr, i2);
                } else {
                    v.i("MicroMsg.BackupBaseScene.dkbackup", "onNotify is null");
                }
            }
        });
    }

    public static void a(int i, e eVar) {
        synchronized (cAd) {
            if (!cAd.containsKey(Integer.valueOf(i))) {
                cAd.put(Integer.valueOf(i), new HashSet());
            }
            if (!((Set) cAd.get(Integer.valueOf(i))).contains(eVar)) {
                ((Set) cAd.get(Integer.valueOf(i))).add(eVar);
            }
        }
    }

    public static void b(int i, e eVar) {
        synchronized (cAd) {
            try {
                if (cAd.get(Integer.valueOf(i)) != null) {
                    ((Set) cAd.get(Integer.valueOf(i))).remove(eVar);
                }
            } catch (Exception e) {
            }
        }
    }

    public final void e(final int i, final int i2, final String str) {
        handler.post(new Runnable(this) {
            final /* synthetic */ b eee;

            public final void run() {
                Set set = (Set) b.cAd.get(Integer.valueOf(this.eee.getType()));
                if (set != null && set.size() > 0) {
                    Set<e> hashSet = new HashSet();
                    hashSet.addAll(set);
                    for (e eVar : hashSet) {
                        if (eVar != null && set.contains(eVar)) {
                            eVar.a(i, i2, str, this.eee);
                        }
                    }
                }
            }
        });
    }

    public static void a(c cVar) {
        eec = cVar;
    }

    public static void TP() {
        if (eec != null) {
            eec.TP();
        }
    }

    public static void a(b bVar) {
        eed = bVar;
    }

    public static void w(final int i, final int i2, final int i3) {
        ad.o(new Runnable() {
            public final void run() {
                if (b.eed != null) {
                    b.eed.hT(i3);
                }
            }
        });
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        return 0;
    }
}
