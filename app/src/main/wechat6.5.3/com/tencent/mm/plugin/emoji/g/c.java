package com.tencent.mm.plugin.emoji.g;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.TrafficStats;
import android.os.Process;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.e.a.bz;
import com.tencent.mm.e.a.d;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;

public final class c implements f {
    int cKY;
    boolean dMT = false;
    public int feL = 0;
    private int feM = 0;
    public boolean feN = false;
    boolean feO = false;
    boolean feP = false;
    public boolean feQ = false;
    public boolean feR = false;
    private boolean feS = false;
    boolean feT = false;
    e feU = null;
    private b feV;
    public Vector<e> feW = new Vector();
    public Vector<e> feX = new Vector();
    public Vector<e> feY = new Vector();
    public Set<d> feZ = new HashSet();
    public a ffa;
    int ffb = -1;
    long ffc = 0;
    long ffd = 0;
    ah ffe = new ah(new com.tencent.mm.sdk.platformtools.ah.a(this) {
        final /* synthetic */ c ffh;

        {
            this.ffh = r1;
        }

        public final boolean oU() {
            if (this.ffh.feO || this.ffh.feP || this.ffh.feQ) {
                long uidTxBytes = TrafficStats.getUidTxBytes(this.ffh.cKY);
                long uidRxBytes = TrafficStats.getUidRxBytes(this.ffh.cKY);
                long j = (uidTxBytes - this.ffh.ffc) + (uidRxBytes - this.ffh.ffd);
                v.d("MicroMsg.BKGLoader.BKGLoaderManager", "delta of data: " + (j / 1024));
                if (j <= 20480) {
                    this.ffh.afU();
                } else {
                    this.ffh.ffc = uidTxBytes;
                    this.ffh.ffd = uidRxBytes;
                    this.ffh.ffe.ea(1000);
                }
            }
            return false;
        }
    }, false);
    public com.tencent.mm.sdk.c.c fff = new com.tencent.mm.sdk.c.c<d>(this) {
        final /* synthetic */ c ffh;

        {
            this.ffh = r2;
            this.nhz = d.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            d dVar = (d) bVar;
            if ((dVar instanceof d) && !dVar.aWo.aWp) {
                this.ffh.afU();
            }
            return false;
        }
    };
    public com.tencent.mm.sdk.c.c ffg = new com.tencent.mm.sdk.c.c<bz>(this) {
        final /* synthetic */ c ffh;

        {
            this.ffh = r2;
            this.nhz = bz.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            bz bzVar = (bz) bVar;
            if ((bzVar instanceof bz) && !be.kS(bzVar.aZx.aZy)) {
                this.ffh.i(bzVar.aZx.aZy, bzVar.aZx.aYt, bzVar.aZx.aZz);
            }
            return false;
        }
    };

    final class a extends BroadcastReceiver {
        final /* synthetic */ c ffh;

        a(c cVar) {
            this.ffh = cVar;
        }

        public final void onReceive(Context context, Intent intent) {
            int netType = ak.getNetType(context);
            if (this.ffh.ffb != netType) {
                v.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] network change type:%d", new Object[]{Integer.valueOf(netType)});
                if (c.aeT()) {
                    this.ffh.afV();
                } else if (c.afX()) {
                    this.ffh.afU();
                } else if (ak.isConnected(aa.getContext())) {
                    this.ffh.afW();
                } else {
                    this.ffh.afV();
                }
                this.ffh.ffb = netType;
            }
        }
    }

    public c(b bVar) {
        this.feV = bVar;
        this.cKY = Process.myUid();
        this.ffb = ak.getNetType(aa.getContext());
        com.tencent.mm.sdk.c.a.nhr.e(this.fff);
        com.tencent.mm.sdk.c.a.nhr.e(this.ffg);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        this.ffa = new a(this);
        aa.getContext().registerReceiver(this.ffa, intentFilter);
    }

    public final void al(List<e> list) {
        if (this.feX == null) {
            this.feX = new Vector();
        }
        if (list.size() > 0) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                e eVar = (e) list.get(i);
                if (eVar == null || this.feX.contains(eVar)) {
                    v.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] task is has exist:%s", new Object[]{eVar.getKey()});
                } else {
                    this.feX.add(eVar);
                }
            }
        }
    }

    public final synchronized void afU() {
        boolean z = true;
        synchronized (this) {
            if (ak.isWifi(aa.getContext()) || this.feN) {
                if (this.feW != null && this.feW.size() > 0) {
                    if (f.G(2097152)) {
                        z = false;
                    }
                    this.feT = z;
                    this.feO = true;
                    this.feP = false;
                    this.feR = false;
                    this.feQ = false;
                    if (this.feT) {
                        v.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] sdcard is full.");
                    } else {
                        this.feU = (e) this.feW.remove(0);
                        this.feU.a(this);
                        this.feV.feJ.execute(this.feU);
                        v.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] tryToStart task is ruing. key:%s donwload list size:%d", new Object[]{this.feU.getKey(), Integer.valueOf(this.feW.size())});
                    }
                    afW();
                } else if (this.feX == null || this.feX.size() <= 0) {
                    v.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] tryToStart no task list .");
                    if (this.feW == null || this.feW.size() <= 0) {
                        if (this.feO && this.dMT) {
                            this.feR = true;
                        }
                        this.feO = false;
                    }
                    if (this.feX == null || this.feX.size() <= 0) {
                        if (this.feP && this.dMT) {
                            this.feS = true;
                        }
                        this.feP = false;
                    }
                    if ((this.feW == null || this.feW.size() <= 0) && ((this.feX == null || this.feX.size() <= 0) && ((this.feO || this.feP) && this.dMT))) {
                        this.feP = false;
                        this.feO = false;
                    }
                    this.feN = false;
                    afW();
                } else {
                    this.feP = true;
                    this.feO = false;
                    this.feS = false;
                    this.feQ = false;
                    this.feU = (e) this.feX.remove(0);
                    this.feU.a(this);
                    this.feV.feJ.execute(this.feU);
                    v.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] tryToStart task is ruing. key:%s upload list size:%d", new Object[]{this.feU.getKey(), Integer.valueOf(this.feX.size())});
                    afW();
                }
                if (!(this.feP || this.feO)) {
                    if (this.feY == null || this.feY.size() <= 0) {
                        this.feQ = false;
                    } else {
                        this.feQ = true;
                        this.feU = (e) this.feY.remove(0);
                        this.feU.a(this);
                        this.feV.feJ.execute(this.feU);
                        v.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] tryToStart download store emoji task is runing. productID:%s size:%d", new Object[]{this.feU.getKey(), Integer.valueOf(this.feY.size())});
                    }
                }
            } else if (aeT()) {
                v.i("MicroMsg.BKGLoader.BKGLoaderManager", "[dz tryToStart is 3g or 4g]");
                this.feO = false;
                this.feP = false;
                this.feR = false;
                this.feQ = false;
                afW();
            } else {
                v.i("MicroMsg.BKGLoader.BKGLoaderManager", "[dz tryToStart is not wifi, 3g nor 4g]");
            }
        }
    }

    public final void afV() {
        this.feO = false;
        this.feP = false;
        this.feN = false;
        afW();
        if (this.feU != null) {
            this.feU.cancel();
        }
    }

    public final void afW() {
        if (this.feZ != null && this.feZ.size() > 0) {
            for (d afY : this.feZ) {
                afY.afY();
            }
        }
    }

    public final void rG(String str) {
        v.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] task is ruing. key:%s", new Object[]{str});
    }

    public final void i(String str, int i, boolean z) {
        v.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] task is finish. key:%s success:%b", new Object[]{str, Boolean.valueOf(z)});
        if (this.feU == null || be.kS(str)) {
            v.e("MicroMsg.BKGLoader.BKGLoaderManager", "CurrentTask or key is null. or key is no equal crrentkey ");
            return;
        }
        if (this.feW.contains(this.feU)) {
            this.feW.remove(this.feU);
        } else if (this.feX.contains(this.feU)) {
            this.feX.remove(this.feU);
        } else if (this.feY.contains(this.feU)) {
            this.feY.remove(this.feU);
        }
        if (!z) {
            v.i("MicroMsg.BKGLoader.BKGLoaderManager", "retry later.");
        } else if (!(i == 2 || this.feZ == null || this.feZ.size() <= 0)) {
            for (d afZ : this.feZ) {
                afZ.afZ();
            }
        }
        if (i == 2) {
            this.ffe.ea(5000);
        } else {
            this.ffe.ea(1000);
        }
    }

    public static boolean afX() {
        NetworkInfo networkInfo = ((ConnectivityManager) aa.getContext().getSystemService("connectivity")).getNetworkInfo(1);
        if (networkInfo != null) {
            return networkInfo.isConnected();
        }
        return false;
    }

    public static boolean aeT() {
        return ak.is3G(aa.getContext()) || ak.is4G(aa.getContext()) || ak.is2G(aa.getContext());
    }
}
