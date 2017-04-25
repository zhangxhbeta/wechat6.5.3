package com.tencent.mm.plugin.clean.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.PowerManager;
import android.os.StatFs;
import com.tencent.mm.bg.g.c;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.model.ag;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.clean.b.h.a;
import com.tencent.mm.plugin.clean.b.h.b;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t;
import java.io.File;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Pattern;

public final class i implements ag {
    private BroadcastReceiver eUP;
    boolean eUQ = false;
    boolean eUR = true;
    long eUS = 0;
    Runnable eUT;
    a eUU;
    long eUV = 86400000;
    long eUW = 1800000;

    class AnonymousClass2 implements Runnable {
        final /* synthetic */ i eUX;
        final /* synthetic */ h eUZ;
        final Map<String, Integer> eVa = this.eVb;
        final /* synthetic */ Map eVb;
        final /* synthetic */ a eVc;
        final /* synthetic */ File eVd;

        AnonymousClass2(i iVar, Map map, a aVar, File file, h hVar) {
            this.eUX = iVar;
            this.eVb = map;
            this.eVc = aVar;
            this.eVd = file;
            this.eUZ = hVar;
        }

        public final void run() {
            v.i("MicroMsg.SubCoreClean", "summerclean true scan start fileScanResult[%s], subDirMap[%d]", new Object[]{this.eVc, Integer.valueOf(this.eVb.size())});
            long currentTimeMillis = System.currentTimeMillis();
            this.eUX.a(this.eVd, this.eVc, null, null, this.eVa, true, 0);
            if (this.eVb.size() > 0) {
                Iterator it = this.eVb.entrySet().iterator();
                while (it != null && it.hasNext()) {
                    Entry entry = (Entry) it.next();
                    this.eVc.eUN.add(new b((String) entry.getKey(), ((Integer) entry.getValue()).intValue()));
                }
            }
            this.eVc.cWl = System.currentTimeMillis() - currentTimeMillis;
            v.i("MicroMsg.SubCoreClean", "summerclean true scan end takes[%d], emptySubDir[%d], fileScanResult[%s], tid[%d]", new Object[]{Long.valueOf(this.eVc.cWl), Integer.valueOf(this.eVb.values().size()), this.eVc, Long.valueOf(Thread.currentThread().getId())});
            this.eUZ.a(0, this.eVc);
        }
    }

    public final HashMap<Integer, c> ti() {
        return null;
    }

    public final void ed(int i) {
        d.adQ();
    }

    public final void aG(boolean z) {
        v.i("MicroMsg.SubCoreClean", "summerclean onAccountPostReset updated[%b]", new Object[]{Boolean.valueOf(z)});
        ak.yW();
        this.eUS = ((Long) com.tencent.mm.model.c.vf().get(t.a.ntO, Long.valueOf(0))).longValue();
        ak.yW();
        this.eUV = ((Long) com.tencent.mm.model.c.vf().get(t.a.ntP, Long.valueOf(86400000))).longValue();
        ak.yW();
        this.eUW = ((Long) com.tencent.mm.model.c.vf().get(t.a.ntQ, Long.valueOf(1800000))).longValue();
        Context context = aa.getContext();
        Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver != null) {
            boolean z2;
            int intExtra = registerReceiver.getIntExtra("status", -1);
            if (intExtra == 2 || intExtra == 5) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.eUQ = z2;
        } else {
            this.eUQ = false;
        }
        this.eUR = ((PowerManager) context.getSystemService("power")).isScreenOn();
        this.eUP = new BroadcastReceiver(this) {
            final /* synthetic */ i eUX;

            {
                this.eUX = r1;
            }

            public final void onReceive(Context context, Intent intent) {
                String action = intent.getAction();
                boolean z = true;
                switch (action.hashCode()) {
                    case -2128145023:
                        if (action.equals("android.intent.action.SCREEN_OFF")) {
                            z = true;
                            break;
                        }
                        break;
                    case -1886648615:
                        if (action.equals("android.intent.action.ACTION_POWER_DISCONNECTED")) {
                            z = true;
                            break;
                        }
                        break;
                    case -1454123155:
                        if (action.equals("android.intent.action.SCREEN_ON")) {
                            z = false;
                            break;
                        }
                        break;
                    case 1019184907:
                        if (action.equals("android.intent.action.ACTION_POWER_CONNECTED")) {
                            z = true;
                            break;
                        }
                        break;
                }
                switch (z) {
                    case false:
                        this.eUX.eUR = true;
                        break;
                    case true:
                        this.eUX.eUR = false;
                        break;
                    case true:
                        this.eUX.eUQ = true;
                        break;
                    case true:
                        this.eUX.eUQ = false;
                        break;
                }
                String str = "MicroMsg.SubCoreClean";
                String str2 = "summerclean Action received: %s, interactive: %s, charging: %s, lastScanTime:%d, delayTimerRunnable null[%b]";
                Object[] objArr = new Object[5];
                objArr[0] = action;
                objArr[1] = Boolean.valueOf(this.eUX.eUR);
                objArr[2] = Boolean.valueOf(this.eUX.eUQ);
                objArr[3] = Long.valueOf(this.eUX.eUS);
                if (this.eUX.eUT == null) {
                    z = true;
                } else {
                    z = false;
                }
                objArr[4] = Boolean.valueOf(z);
                v.v(str, str2, objArr);
                if (this.eUX.eUT == null && this.eUX.eUQ && !this.eUX.eUR) {
                    if (System.currentTimeMillis() - this.eUX.eUS < this.eUX.eUV) {
                        v.d("MicroMsg.SubCoreClean", "summerclean last scan time not matched in [%d]", new Object[]{Long.valueOf(this.eUX.eUV)});
                        return;
                    }
                    final h anonymousClass1 = new h(this) {
                        final /* synthetic */ AnonymousClass1 eUY;

                        {
                            this.eUY = r1;
                        }

                        public final void a(int i, a aVar) {
                            this.eUY.eUX.eUS = System.currentTimeMillis();
                            v.i("MicroMsg.SubCoreClean", "summerclean callback errType[%d] lastScanTime[%d], result[%s][%s]", new Object[]{Integer.valueOf(i), Long.valueOf(this.eUY.eUX.eUS), this.eUY.eUX.eUU, aVar});
                            this.eUY.eUX.eUU = null;
                            if (i == 0 && !aVar.cRi) {
                                ak.yW();
                                com.tencent.mm.model.c.vf().a(t.a.ntO, Long.valueOf(this.eUY.eUX.eUS));
                                ak.yW();
                                com.tencent.mm.model.c.vf().iB(false);
                                try {
                                    long j;
                                    long j2;
                                    long j3;
                                    long j4;
                                    long j5;
                                    int i2;
                                    i iVar = this.eUY.eUX;
                                    h.c cVar = new h.c("total/temp/acc/");
                                    Iterator it = aVar.eUO.iterator();
                                    while (it.hasNext()) {
                                        h.c cVar2 = (h.c) it.next();
                                        cVar.eUJ += cVar2.eUJ;
                                        cVar.eUK += cVar2.eUK;
                                        cVar.beE += cVar2.beE;
                                        cVar.eUL += cVar2.eUL;
                                    }
                                    v.i("MicroMsg.SubCoreClean", "summerclean doReportSDInfo total tempAccDirResult[%d][%s]", new Object[]{Integer.valueOf(aVar.eUO.size()), cVar});
                                    Collections.sort(aVar.eUN, new Comparator<b>(iVar) {
                                        final /* synthetic */ i eUX;

                                        {
                                            this.eUX = r1;
                                        }

                                        public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
                                            long j = (long) (((b) obj).tag - ((b) obj2).tag);
                                            if (j > 0) {
                                                return 1;
                                            }
                                            return j == 0 ? 0 : -1;
                                        }
                                    });
                                    Iterator it2 = aVar.eUN.iterator();
                                    while (it2.hasNext()) {
                                        v.d("MicroMsg.SubCoreClean", "summerclean doReportSDInfo subDirResult[%s]", new Object[]{(b) it2.next()});
                                    }
                                    String str = aVar.beE + ":" + aVar.eUJ + ":" + aVar.eUK + ":" + aVar.eUL + ":" + aVar.eUN.size() + ":" + aVar.cWl + ":" + aVar.eUM + "|" + aVar.eUO.size() + ":" + cVar.beE + ":" + cVar.eUJ + ":" + cVar.eUK + ":" + cVar.eUL;
                                    it2 = aVar.eUN.iterator();
                                    String str2 = str;
                                    while (it2.hasNext()) {
                                        b bVar = (b) it2.next();
                                        str2 = str2 + "|" + bVar.tag + ":" + bVar.beE + ":" + bVar.eUJ + ":" + bVar.eUK + ":" + bVar.eUL;
                                    }
                                    v.i("MicroMsg.SubCoreClean", "summerclean doReportSDInfo wechatResult[%d][%s]", new Object[]{Integer.valueOf(str2.length()), str2});
                                    String path = h.getExternalStorageDirectory().getPath();
                                    boolean btW = at.btW();
                                    String Kr = at.Kr(e.cni);
                                    StatFs statFs = new StatFs(path);
                                    long blockSize = (long) statFs.getBlockSize();
                                    long blockCount = (long) statFs.getBlockCount();
                                    long availableBlocks = (long) statFs.getAvailableBlocks();
                                    long j6 = blockSize * blockCount;
                                    long j7 = blockSize * availableBlocks;
                                    int i3 = -1;
                                    if (blockCount > 0) {
                                        i3 = Math.round((float) ((100 * availableBlocks) / blockCount));
                                    }
                                    boolean equals = e.cni.equals(path);
                                    if (equals) {
                                        j = j7;
                                        j2 = j6;
                                        j3 = availableBlocks;
                                        j4 = blockCount;
                                        j5 = blockSize;
                                        i2 = i3;
                                    } else {
                                        statFs = new StatFs(e.cni);
                                        j4 = (long) statFs.getBlockSize();
                                        j3 = (long) statFs.getBlockCount();
                                        j2 = (long) statFs.getAvailableBlocks();
                                        j = j4 * j3;
                                        long j8 = j4 * j2;
                                        if (j3 > 0) {
                                            i2 = Math.round((float) ((100 * j2) / j3));
                                            j5 = j4;
                                            j4 = j3;
                                            j3 = j2;
                                            j2 = j;
                                            j = j8;
                                        } else {
                                            j5 = j4;
                                            j4 = j3;
                                            j3 = j2;
                                            j2 = j;
                                            j = j8;
                                            i2 = i3;
                                        }
                                    }
                                    v.i("MicroMsg.SubCoreClean", "summerclean doReportSDInfo phoneResult[%d][%s]", new Object[]{Integer.valueOf((Math.round((float) ((aVar.beE * 100) / j2)) + ";" + (equals ? 1 : 0) + ";" + (btW ? 1 : 0) + ";" + j5 + ":" + j4 + ":" + j3 + ":" + j2 + ":" + j + ":" + i2 + "|" + blockSize + ":" + blockCount + ":" + availableBlocks + ":" + j6 + ":" + j7 + ":" + i3 + ";" + path + ";" + e.cni + ";" + Kr).length()), Math.round((float) ((aVar.beE * 100) / j2)) + ";" + (equals ? 1 : 0) + ";" + (btW ? 1 : 0) + ";" + j5 + ":" + j4 + ":" + j3 + ":" + j2 + ":" + j + ":" + i2 + "|" + blockSize + ":" + blockCount + ":" + availableBlocks + ":" + j6 + ":" + j7 + ":" + i3 + ";" + path + ";" + e.cni + ";" + Kr});
                                    str = str2 + ";" + str;
                                    v.i("MicroMsg.SubCoreClean", "summerclean doReportSDInfo totalResult[%d][%s]", new Object[]{Integer.valueOf(str.length()), str});
                                    g.iuh.a(418, 5, 1, false);
                                    g.iuh.h(13778, new Object[]{Integer.valueOf(2), Integer.valueOf(1), str});
                                } catch (Throwable e) {
                                    v.a("MicroMsg.SubCoreClean", e, "doReportSDInfo err!", new Object[0]);
                                    g.iuh.a(418, 6, 1, false);
                                }
                            }
                        }
                    };
                    this.eUX.eUT = new Runnable(this) {
                        final /* synthetic */ AnonymousClass1 eUY;

                        public final void run() {
                            a aVar = null;
                            this.eUY.eUX.eUT = null;
                            i iVar = this.eUY.eUX;
                            i iVar2 = this.eUY.eUX;
                            h hVar = anonymousClass1;
                            v.i("MicroMsg.SubCoreClean", "summerclean startScan");
                            ak.yW();
                            if (com.tencent.mm.model.c.isSDCardAvailable()) {
                                File file = new File(e.cnj);
                                String wT;
                                if (file.exists() && file.isDirectory()) {
                                    v.i("MicroMsg.SubCoreClean", "summerclean startScan root[%s] exist[%b], diretory[%b]", new Object[]{wT, Boolean.valueOf(file.exists()), Boolean.valueOf(file.isDirectory())});
                                    Map hashMap = new HashMap(26);
                                    ak.yW();
                                    wT = com.tencent.mm.model.c.wT();
                                    ak.yW();
                                    hashMap.put(wT.substring(0, com.tencent.mm.model.c.wT().length() - 1), Integer.valueOf(1));
                                    ak.yW();
                                    wT = com.tencent.mm.model.c.wU();
                                    ak.yW();
                                    hashMap.put(wT.substring(0, com.tencent.mm.model.c.wU().length() - 1), Integer.valueOf(2));
                                    ak.yW();
                                    wT = com.tencent.mm.model.c.wP();
                                    ak.yW();
                                    hashMap.put(wT.substring(0, com.tencent.mm.model.c.wP().length() - 1), Integer.valueOf(3));
                                    ak.yW();
                                    wT = com.tencent.mm.model.c.wQ();
                                    ak.yW();
                                    hashMap.put(wT.substring(0, com.tencent.mm.model.c.wQ().length() - 1), Integer.valueOf(4));
                                    ak.yW();
                                    hashMap.put(com.tencent.mm.model.c.xj(), Integer.valueOf(5));
                                    ak.yW();
                                    wT = com.tencent.mm.model.c.wR();
                                    ak.yW();
                                    hashMap.put(wT.substring(0, com.tencent.mm.model.c.wR().length() - 1), Integer.valueOf(6));
                                    ak.yW();
                                    wT = com.tencent.mm.model.c.wY();
                                    ak.yW();
                                    hashMap.put(wT.substring(0, com.tencent.mm.model.c.wY().length() - 1), Integer.valueOf(7));
                                    ak.yW();
                                    wT = com.tencent.mm.model.c.getAccVideoPath();
                                    ak.yW();
                                    hashMap.put(wT.substring(0, com.tencent.mm.model.c.getAccVideoPath().length() - 1), Integer.valueOf(8));
                                    ak.yW();
                                    wT = com.tencent.mm.model.c.xb();
                                    ak.yW();
                                    hashMap.put(wT.substring(0, com.tencent.mm.model.c.xb().length() - 1), Integer.valueOf(9));
                                    ak.yW();
                                    wT = com.tencent.mm.model.c.wZ();
                                    ak.yW();
                                    hashMap.put(wT.substring(0, com.tencent.mm.model.c.wZ().length() - 1), Integer.valueOf(10));
                                    ak.yW();
                                    wT = com.tencent.mm.model.c.xc();
                                    ak.yW();
                                    hashMap.put(wT.substring(0, com.tencent.mm.model.c.xc().length() - 1), Integer.valueOf(11));
                                    ak.yW();
                                    wT = com.tencent.mm.model.c.xd();
                                    ak.yW();
                                    hashMap.put(wT.substring(0, com.tencent.mm.model.c.xd().length() - 1), Integer.valueOf(12));
                                    ak.yW();
                                    wT = com.tencent.mm.model.c.xe();
                                    ak.yW();
                                    hashMap.put(wT.substring(0, com.tencent.mm.model.c.xe().length() - 1), Integer.valueOf(13));
                                    ak.yW();
                                    wT = com.tencent.mm.model.c.xk();
                                    ak.yW();
                                    hashMap.put(wT.substring(0, com.tencent.mm.model.c.xk().length() - 1), Integer.valueOf(14));
                                    ak.yW();
                                    wT = com.tencent.mm.model.c.wV();
                                    ak.yW();
                                    hashMap.put(wT.substring(0, com.tencent.mm.model.c.wV().length() - 1), Integer.valueOf(15));
                                    ak.yW();
                                    wT = com.tencent.mm.model.c.wX();
                                    ak.yW();
                                    hashMap.put(wT.substring(0, com.tencent.mm.model.c.wX().length() - 1), Integer.valueOf(16));
                                    ak.yW();
                                    wT = com.tencent.mm.model.c.wW();
                                    ak.yW();
                                    hashMap.put(wT.substring(0, com.tencent.mm.model.c.wW().length() - 1), Integer.valueOf(17));
                                    ak.yW();
                                    wT = com.tencent.mm.model.c.xg();
                                    ak.yW();
                                    hashMap.put(wT.substring(0, com.tencent.mm.model.c.xg().length() - 1), Integer.valueOf(18));
                                    ak.yW();
                                    wT = com.tencent.mm.model.c.xf();
                                    ak.yW();
                                    hashMap.put(wT.substring(0, com.tencent.mm.model.c.xf().length() - 1), Integer.valueOf(19));
                                    ak.yW();
                                    wT = com.tencent.mm.model.c.xh();
                                    ak.yW();
                                    hashMap.put(wT.substring(0, com.tencent.mm.model.c.xh().length() - 1), Integer.valueOf(20));
                                    ak.yW();
                                    wT = com.tencent.mm.model.c.xl();
                                    ak.yW();
                                    hashMap.put(wT.substring(0, com.tencent.mm.model.c.xl().length() - 1), Integer.valueOf(21));
                                    ak.yW();
                                    wT = com.tencent.mm.model.c.wS();
                                    ak.yW();
                                    hashMap.put(wT.substring(0, com.tencent.mm.model.c.wS().length() - 1), Integer.valueOf(22));
                                    hashMap.put(e.cgn, Integer.valueOf(23));
                                    hashMap.put(e.cge.substring(0, e.cge.length() - 1), Integer.valueOf(24));
                                    hashMap.put(e.cgj.substring(0, e.cgj.length() - 1), Integer.valueOf(25));
                                    hashMap.put(e.cgg.substring(0, e.cgg.length() - 1), Integer.valueOf(26));
                                    aVar = new a(file.getAbsolutePath());
                                    com.tencent.mm.sdk.i.e.a(new AnonymousClass2(iVar2, hashMap, aVar, file, hVar), "summerclean_scanFile");
                                } else {
                                    v.i("MicroMsg.SubCoreClean", "summerclean startScan failed as path not exists[%s]", new Object[]{wT});
                                    hVar.a(-1, null);
                                }
                            } else {
                                v.i("MicroMsg.SubCoreClean", "summerclean startScan failed as sdcard not available");
                                hVar.a(-1, null);
                            }
                            iVar.eUU = aVar;
                            v.i("MicroMsg.SubCoreClean", "summerclean auto scan started[%s]", new Object[]{this.eUY.eUX.eUU});
                        }
                    };
                    ak.vA().f(this.eUX.eUT, this.eUX.eUW);
                    v.i("MicroMsg.SubCoreClean", "summerclean auto scan post delay[%d]", new Object[]{Long.valueOf(this.eUX.eUW)});
                } else if (this.eUX.eUT != null) {
                    ak.vA().btx().removeCallbacks(this.eUX.eUT);
                    this.eUX.eUT = null;
                    v.i("MicroMsg.SubCoreClean", "summerclean auto scan remove[%s]", new Object[]{this.eUX.eUU});
                } else if (this.eUX.eUU != null) {
                    this.eUX.eUU.cRi = true;
                    v.i("MicroMsg.SubCoreClean", "summerclean auto scan canceled[%s]", new Object[]{this.eUX.eUU});
                    this.eUX.eUU = null;
                }
            }
        };
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
        intentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
        context.registerReceiver(this.eUP, intentFilter);
        String str = "MicroMsg.SubCoreClean";
        String str2 = "summerclean registerReceiver auto scan %s. Device status:%s interactive,%s charging mLastAutoScanTime[%d], mAutoScanInterval[%d], mAutoScanWaitTime[%d].";
        Object[] objArr = new Object[6];
        objArr[0] = this.eUU != null ? "enabled" : "disabled";
        objArr[1] = this.eUR ? "" : " not";
        objArr[2] = this.eUQ ? "" : " not";
        objArr[3] = Long.valueOf(this.eUS);
        objArr[4] = Long.valueOf(this.eUV);
        objArr[5] = Long.valueOf(this.eUW);
        v.i(str, str2, objArr);
    }

    public final void aH(boolean z) {
        v.i("MicroMsg.SubCoreClean", "summerclean onSdcardMount mounted[%b]", new Object[]{Boolean.valueOf(z)});
    }

    public final void th() {
        v.i("MicroMsg.SubCoreClean", "summerclean onAccountRelease");
        d.adQ();
        if (this.eUP != null) {
            aa.getContext().unregisterReceiver(this.eUP);
            v.i("MicroMsg.SubCoreClean", "summerclean unregisterReceiver mChargeAndInteractiveReceiver[%s]", new Object[]{this.eUP});
            this.eUP = null;
        }
        if (this.eUT != null) {
            ak.vA().btx().removeCallbacks(this.eUT);
            this.eUT = null;
            v.i("MicroMsg.SubCoreClean", "summerclean unregisterReceiver remove[%s]", new Object[]{this.eUU});
        }
        if (this.eUU != null) {
            this.eUU.cRi = true;
            v.i("MicroMsg.SubCoreClean", "summerclean unregisterReceiver canceled[%s]", new Object[]{this.eUU});
            this.eUU = null;
        }
    }

    final a a(File file, a aVar, b bVar, h.c cVar, Map<String, Integer> map, boolean z, int i) {
        if (aVar.cRi) {
            v.i("MicroMsg.SubCoreClean", "summclean scanFile been canceled fileResult[%s], subDirResult[%s]", new Object[]{aVar, bVar});
        } else {
            if (aVar.eUM < i) {
                aVar.eUM++;
            }
            if (file.isDirectory()) {
                b bVar2;
                String absolutePath = file.getAbsolutePath();
                if (bVar != null || map == null || map.size() <= 0 || map.get(absolutePath) == null) {
                    bVar2 = bVar;
                } else {
                    b bVar3 = new b(absolutePath, ((Integer) map.get(absolutePath)).intValue());
                    map.remove(absolutePath);
                    aVar.eUN.add(bVar3);
                    v.d("MicroMsg.SubCoreClean", "summerclean scanFile start scan subDir[%s], fileResult[%s], newSubDirResult[%s]", new Object[]{absolutePath, aVar, bVar3});
                    bVar2 = bVar3;
                }
                aVar.eUJ++;
                if (bVar2 != null) {
                    bVar2.eUJ++;
                }
                if (cVar != null) {
                    cVar.eUJ++;
                }
                if (i > 20) {
                    v.i("MicroMsg.SubCoreClean", "summclean scanFile been stopped as depth[%d] over limit path[%s], fileResult[%s]", new Object[]{Integer.valueOf(i), file.getAbsolutePath(), aVar});
                    g.iuh.a(418, 7, 1, false);
                    g.iuh.h(13778, new Object[]{Integer.valueOf(2), Integer.valueOf(2), file.getAbsolutePath()});
                } else {
                    String[] list = file.list();
                    if (list == null) {
                        v.i("MicroMsg.SubCoreClean", "summerclean scanFile dir is empty[%s] ret", new Object[]{file.getAbsolutePath()});
                    } else if (z) {
                        h.c cVar2 = cVar;
                        for (String str : list) {
                            if (!be.kS(str) && Pattern.matches("[a-fA-F0-9]{32}temp[0-9]{13}", str)) {
                                cVar2 = new h.c(file.getAbsolutePath() + File.separator + str);
                                aVar.eUO.add(cVar2);
                            }
                            a(new File(file.getAbsolutePath() + File.separator + str), aVar, bVar2, cVar2, map, false, i + 1);
                        }
                    } else {
                        for (String str2 : list) {
                            a(new File(file.getAbsolutePath() + File.separator + str2), aVar, bVar2, cVar, map, false, i + 1);
                        }
                    }
                }
            } else {
                aVar.eUK++;
                if (bVar != null) {
                    bVar.eUK++;
                }
                if (cVar != null) {
                    cVar.eUK++;
                }
                if (file.exists()) {
                    long length = file.length();
                    if (length > 0) {
                        aVar.beE += length;
                        if (bVar != null) {
                            bVar.beE += length;
                        }
                        if (cVar != null) {
                            cVar.beE = length + cVar.beE;
                        }
                    } else {
                        aVar.eUL++;
                        if (bVar != null) {
                            bVar.eUL++;
                        }
                        if (cVar != null) {
                            cVar.eUL++;
                        }
                    }
                } else {
                    v.i("MicroMsg.SubCoreClean", "summerclean scanFile file not exist[%s][%d] ret", new Object[]{file.getAbsolutePath(), Long.valueOf(aVar.eUK)});
                }
            }
        }
        return aVar;
    }
}
