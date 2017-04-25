package com.tencent.mm.modelfriend;

import android.os.Looper;
import android.os.Message;
import com.tencent.mm.a.g;
import com.tencent.mm.model.ak;
import com.tencent.mm.platformtools.c;
import com.tencent.mm.sdk.i.e;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bc;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a {
    public static final HashSet<b> cGF = new HashSet();
    private static final b cGG = new b() {
        public final void ba(boolean z) {
            v.i("MicroMsg.AddrBookSyncHelper", "syncAddrBookAndUpload onSyncEnd suc:%b", Boolean.valueOf(z));
            if (z) {
                System.currentTimeMillis();
                ak.vy().a(new ac(m.Ff(), m.Fe()), 0);
            }
        }
    };
    private static Thread thread = null;

    private static class a implements Runnable {
        public static boolean cGA = false;
        private static byte[] cGJ = new byte[0];
        private static final ac cGP = new ac(Looper.getMainLooper()) {
            public final void handleMessage(Message message) {
                if (ak.uz()) {
                    com.tencent.mm.compatible.util.g.a aVar = new com.tencent.mm.compatible.util.g.a();
                    int size = a.cGF.size();
                    boolean parseBoolean = Boolean.parseBoolean(message.obj.toString());
                    Iterator it = a.cGF.iterator();
                    while (it.hasNext()) {
                        ((b) it.next()).ba(parseBoolean);
                    }
                    a.cGF.clear();
                    v.i("MicroMsg.AddrBookSyncHelper", "callBackHandler setSize:%d time:%d", Integer.valueOf(size), Long.valueOf(aVar.sn()));
                }
            }
        };
        private List<String[]> cGK;
        private List<String[]> cGL;
        private List<b> cGM;
        private List<b> cGN;
        private bc cGO;

        private a() {
        }

        private static List<b> a(List<b> list, int i, int i2) {
            List<b> linkedList = new LinkedList();
            while (i < i2) {
                linkedList.add(list.get(i));
                i++;
            }
            return linkedList;
        }

        public final void run() {
            synchronized (cGJ) {
                this.cGO = new bc("MicroMsg.AddrBookSyncHelper", "sync addrBook");
                this.cGO.addSplit("sync begin");
                v.d("MicroMsg.AddrBookSyncHelper", "reading email info");
                this.cGK = com.tencent.mm.pluginsdk.a.cX(aa.getContext());
                if (this.cGK != null) {
                    v.i("MicroMsg.AddrBookSyncHelper", "sync address book email size: " + this.cGK.size());
                }
                this.cGN = a(1, this.cGK);
                v.d("MicroMsg.AddrBookSyncHelper", "reading mobile info");
                this.cGL = com.tencent.mm.pluginsdk.a.cV(aa.getContext());
                if (this.cGL != null) {
                    v.i("MicroMsg.AddrBookSyncHelper", "sync address book mobile size: " + this.cGL.size());
                }
                this.cGM = a(0, this.cGL);
                v.d("MicroMsg.AddrBookSyncHelper", "reading done, begin sync to addr_upload");
                if (this.cGK != null && this.cGN.size() > 0) {
                    for (int i = 0; i < this.cGN.size(); i += 100) {
                        List a;
                        v.i("MicroMsg.AddrBookSyncHelper", "sync email index: " + i);
                        if (i + 100 < this.cGN.size()) {
                            a = a(this.cGN, i, i + 100);
                        } else {
                            a = a(this.cGN, i, this.cGN.size());
                        }
                        v.i("MicroMsg.AddrBookSyncHelper", "sync email listToSync size: " + a.size());
                        m.D(a);
                    }
                }
                if (this.cGM == null || this.cGM.size() == 0) {
                    v.i("MicroMsg.AddrBookSyncHelper", "mobile list null stop service");
                    Message obtainMessage = cGP.obtainMessage();
                    obtainMessage.obj = Boolean.valueOf(false);
                    cGP.sendMessage(obtainMessage);
                    return;
                }
                int i2 = 0;
                while (i2 < this.cGM.size()) {
                    v.i("MicroMsg.AddrBookSyncHelper", "sync mobile index: " + i2);
                    if (ak.uz()) {
                        List a2;
                        if (i2 + 100 < this.cGM.size()) {
                            a2 = a(this.cGM, i2, i2 + 100);
                        } else {
                            a2 = a(this.cGM, i2, this.cGM.size());
                        }
                        v.i("MicroMsg.AddrBookSyncHelper", "sync mobile listToSync size: " + a2.size());
                        m.D(a2);
                        i2 += 100;
                    } else {
                        v.i("MicroMsg.AddrBookSyncHelper", "account not ready, stop sync");
                        obtainMessage = cGP.obtainMessage();
                        obtainMessage.obj = Boolean.valueOf(false);
                        cGP.sendMessage(obtainMessage);
                        return;
                    }
                }
                v.i("MicroMsg.AddrBookSyncHelper", "sync ok");
                if (ak.uz()) {
                    Ez();
                    System.currentTimeMillis();
                    this.cGO.addSplit("sync ok");
                    this.cGO.dumpToLog();
                    obtainMessage = cGP.obtainMessage();
                    obtainMessage.obj = Boolean.valueOf(true);
                    cGP.sendMessage(obtainMessage);
                    return;
                }
                v.i("MicroMsg.AddrBookSyncHelper", "account not ready, exit");
                obtainMessage = cGP.obtainMessage();
                obtainMessage.obj = Boolean.valueOf(false);
                cGP.sendMessage(obtainMessage);
            }
        }

        private static void Ez() {
            bc bcVar = new bc("MicroMsg.AddrBookSyncHelper", "delete");
            List arrayList = new ArrayList();
            List cY = com.tencent.mm.pluginsdk.a.cY(aa.getContext());
            for (String[] strArr : ah.FL().EO()) {
                String ma = be.ma(strArr[0]);
                String ma2 = be.ma(strArr[1]);
                if (!(ma.equals(SQLiteDatabase.KeyEmpty) || cY.contains(ma))) {
                    arrayList.add(ma2);
                }
            }
            if (arrayList.size() > 0) {
                ah.FL().A(arrayList);
                m.C(arrayList);
            }
            bcVar.addSplit("end");
            bcVar.dumpToLog();
        }

        private static List<b> a(int i, List<String[]> list) {
            if (list == null) {
                v.e("MicroMsg.AddrBookSyncHelper", "sync address book failed, null info list");
                return new LinkedList();
            }
            List<b> arrayList = new ArrayList();
            for (String[] strArr : list) {
                if (strArr != null) {
                    String str = strArr[0];
                    String str2 = strArr[1];
                    String str3 = strArr[2];
                    String str4 = strArr[3];
                    long KM = be.KM(strArr[4]);
                    if (!(str3 == null || str3.equals(SQLiteDatabase.KeyEmpty))) {
                        String str5 = SQLiteDatabase.KeyEmpty;
                        if (i == 1) {
                            str5 = g.m(str3.getBytes());
                        }
                        if (i == 0) {
                            str5 = com.tencent.mm.pluginsdk.a.yt(str3);
                            if (be.kS(str5)) {
                                v.d("MicroMsg.AddrBookSyncHelper", "formatted mobile null, continue");
                            } else {
                                str5 = g.m(str5.getBytes());
                            }
                        }
                        b bVar = new b();
                        bVar.cGS = str2;
                        bVar.cGT = c.lU(str2);
                        bVar.cGU = c.lT(str2);
                        bVar.cGQ = str;
                        bVar.cyx = str4;
                        bVar.iz(str5);
                        bVar.cHu = KM;
                        bVar.cHa = bVar.tm();
                        if (i == 1) {
                            bVar.bCc = str3;
                        }
                        if (i == 0) {
                            bVar.cGX = str3;
                        }
                        bVar.type = i;
                        bVar.bkU = 1095798;
                        arrayList.add(bVar);
                    }
                }
            }
            return arrayList;
        }
    }

    public interface b {
        void ba(boolean z);
    }

    public static boolean Ew() {
        return a(cGG);
    }

    public static boolean a(final b bVar) {
        final long id = Thread.currentThread().getId();
        if (m.Fb()) {
            ad.o(new Runnable() {
                public final void run() {
                    boolean z = a.thread != null && a.thread.isAlive();
                    v.i("MicroMsg.AddrBookSyncHelper", "syncAddrBook running:%b setSize:%d call:%d callback:%s", Boolean.valueOf(z), Integer.valueOf(a.cGF.size()), Long.valueOf(id), bVar);
                    a.cGF.add(bVar);
                    if (!z) {
                        a.thread = e.d(new a(), "AddrBookSyncHelper_addrBookRead", 1);
                        m.EV();
                        a.thread.start();
                    }
                }
            });
            return true;
        }
        v.e("MicroMsg.AddrBookSyncHelper", "canSync:%b, skip", Boolean.valueOf(m.Fb()));
        return false;
    }

    public static boolean Ex() {
        return a.cGA;
    }
}
