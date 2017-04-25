package com.tencent.mm.plugin.sns.a.a;

import android.database.Cursor;
import android.os.SystemClock;
import com.tencent.mm.ba.b;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.sns.e.ad;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.protocal.c.afi;
import com.tencent.mm.protocal.c.avz;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import com.tencent.tmassistantsdk.logreport.BaseReportManager;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public final class i implements e {
    public static int jcE = 20480;
    public static int jcF = 30720;
    public static int jcG = 51200;
    public static int jcH = 60;
    public static int jcI = 1800;
    public static int jcJ = 43200;
    private int jcD = 0;
    private long jcK = 0;
    private avz jcL = new avz();
    private boolean jcM = false;
    private long jcN = 0;
    private int jcO = 0;
    private Random random = new Random(System.currentTimeMillis());

    static /* synthetic */ void d(i iVar) {
        if (iVar.jcL.mby.size() > 0) {
            v.i("MicroMsg.SnsLogMgr", "trigerSave " + iVar.jcL.mby.size());
            ad.aSx().a(iVar.jcL);
            iVar.jcL.mby.clear();
        }
    }

    static /* synthetic */ void e(i iVar) {
        int i;
        String str;
        int i2;
        if (be.az(iVar.jcN) >= 100 || iVar.jcO <= 0) {
            iVar.jcO = jcE;
            if (ak.isWifi(aa.getContext())) {
                iVar.jcO = jcG;
            }
            if (ak.is3G(aa.getContext()) || ak.is4G(aa.getContext())) {
                iVar.jcO = jcF;
            }
            if (ak.is2G(aa.getContext())) {
                iVar.jcO = jcE;
            }
            iVar.jcN = SystemClock.elapsedRealtime();
            i = iVar.jcO;
        } else {
            i = iVar.jcO;
        }
        List linkedList = new LinkedList();
        avz cu = ad.aSx().cu(i, iVar.jcD);
        afi com_tencent_mm_protocal_c_afi;
        if (cu.mby.size() == 0) {
            str = "read from memery";
            i2 = 0;
            while (iVar.jcL.mby.size() > 0) {
                com_tencent_mm_protocal_c_afi = (afi) iVar.jcL.mby.remove();
                if (com_tencent_mm_protocal_c_afi.mFe.lVU.length + i2 >= i) {
                    break;
                }
                i2 += com_tencent_mm_protocal_c_afi.mFe.lVU.length;
                linkedList.add(com_tencent_mm_protocal_c_afi);
            }
        } else {
            str = "read from db";
            i2 = 0;
            while (cu.mby.size() > 0) {
                com_tencent_mm_protocal_c_afi = (afi) cu.mby.remove();
                linkedList.add(com_tencent_mm_protocal_c_afi);
                i2 = com_tencent_mm_protocal_c_afi.mFe.lVU.length + i2;
            }
        }
        String str2 = str;
        if (linkedList.size() == 0) {
            v.i("MicroMsg.SnsLogMgr", "nothing for report");
            return;
        }
        v.i("MicroMsg.SnsLogMgr", "size " + i2 + " " + linkedList.size() + " " + i + " logItemList.LogList.size  " + iVar.jcL.mby.size() + " label:  " + str2);
        com.tencent.mm.model.ak.vy().a(new e(linkedList), 0);
    }

    public final void h(final int i, final Object... objArr) {
        ad.aSr().post(new Runnable(this) {
            final /* synthetic */ i jcR;

            public final void run() {
                afi com_tencent_mm_protocal_c_afi = new afi();
                com_tencent_mm_protocal_c_afi.mFd = i;
                com_tencent_mm_protocal_c_afi.mFl = (int) (System.currentTimeMillis() / 1000);
                com_tencent_mm_protocal_c_afi.eet = 1;
                String k = i.k(objArr);
                com_tencent_mm_protocal_c_afi.mFe = new b(k.getBytes());
                this.jcR.jcL.mby.add(com_tencent_mm_protocal_c_afi);
                v.i("MicroMsg.SnsLogMgr", "snsadlog " + i + " " + k);
                if (this.jcR.jcK == 0) {
                    this.jcR.jcK = System.currentTimeMillis();
                }
            }
        });
        if (!this.jcM) {
            this.jcM = true;
            ad.aSr().postDelayed(new Runnable(this) {
                final /* synthetic */ i jcR;

                {
                    this.jcR = r1;
                }

                public final void run() {
                    this.jcR.jcM = false;
                    this.jcR.aQW();
                }
            }, 2000);
        }
    }

    public final void aQW() {
        if (ad.jlu) {
            com.tencent.mm.model.ak.yW();
            int intValue = ((Integer) c.vf().get(a.nqp, Integer.valueOf(0))).intValue();
            com.tencent.mm.model.ak.yW();
            int intValue2 = ((Integer) c.vf().get(a.nqo, Integer.valueOf(-1))).intValue();
            if (intValue2 > jcJ || intValue2 < 0) {
                intValue2 = this.random.nextInt((jcI - jcH) + 1) + jcH;
            }
            if ((System.currentTimeMillis() / 1000) - ((long) intValue) > ((long) intValue2)) {
                intValue2 = 1;
            } else {
                intValue2 = 0;
            }
            if (intValue2 == 0) {
                aQX();
                v.d("MicroMsg.SnsLogMgr", "pass report ");
                return;
            }
            n aSx = ad.aSx();
            String str = "select rowid from SnsReportKv order by rowid desc  limit 1";
            v.i("MicroMsg.SnsKvReportStg", " getLast " + str);
            Cursor rawQuery = aSx.cuX.rawQuery(str, null);
            if (rawQuery.moveToFirst()) {
                intValue2 = rawQuery.getInt(0);
            } else {
                intValue2 = 0;
            }
            rawQuery.close();
            this.jcD = intValue2;
            aQY();
            aQX();
        }
    }

    private void aQX() {
        ad.aSr().post(new Runnable(this) {
            final /* synthetic */ i jcR;

            {
                this.jcR = r1;
            }

            public final void run() {
                if (System.currentTimeMillis() - this.jcR.jcK >= 60000 || this.jcR.jcL.mby.size() > BaseReportManager.MAX_READ_COUNT) {
                    if (this.jcR.jcL != null && this.jcR.jcL.mby.size() > 0) {
                        i.d(this.jcR);
                    }
                    this.jcR.jcK = 0;
                }
            }
        });
    }

    private void aQY() {
        ad.aSr().post(new Runnable(this) {
            final /* synthetic */ i jcR;

            {
                this.jcR = r1;
            }

            public final void run() {
                i.e(this.jcR);
            }
        });
    }

    public static String k(Object... objArr) {
        if (objArr == null || objArr.length <= 0) {
            v.w("MicroMsg.SnsLogMgr", "vals is null, use '' as value");
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        int length = objArr.length - 1;
        for (int i = 0; i < length; i++) {
            stringBuilder.append(String.valueOf(objArr[i])).append(',');
        }
        stringBuilder.append(String.valueOf(objArr[length]));
        return stringBuilder.toString();
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar.getType() == 1802 && (kVar instanceof e)) {
            e eVar = (e) kVar;
            if (i == 0 && i2 == 0) {
                com.tencent.mm.model.ak.yW();
                c.vf().a(a.nqp, Integer.valueOf((int) (System.currentTimeMillis() / 1000)));
                aQY();
                return;
            }
            List<afi> list = eVar.dIB;
            n aSx = ad.aSx();
            avz com_tencent_mm_protocal_c_avz = new avz();
            for (afi add : list) {
                com_tencent_mm_protocal_c_avz.mby.add(add);
            }
            aSx.a(com_tencent_mm_protocal_c_avz);
        }
    }
}
