package com.tencent.mm.plugin.sns.e;

import android.graphics.Bitmap.CompressFormat;
import com.tencent.mm.memory.n;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.sns.e.g.AnonymousClass2;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.protocal.c.aib;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.v;
import java.util.LinkedList;
import java.util.List;

public final class i extends h<String, Integer, Boolean> {
    private String apU = "";
    private n cnP = null;
    private String jdN;
    private int jjO;
    private String jjP;
    private List<aib> jjQ;

    public final /* synthetic */ Object aRX() {
        String zK = com.tencent.mm.plugin.sns.data.i.zK(this.jdN);
        String cA = al.cA(this.jjP, this.jdN);
        if (!FileOp.aR(cA + zK)) {
            b(this.jdN, zK, this.jjQ);
        }
        this.cnP = com.tencent.mm.plugin.sns.data.i.zS(cA + zK);
        ad.aqz().post(new AnonymousClass2(ad.aSB(), 0, this.jdN, this.cnP));
        v.i("MicroMsg.MutiImageLoader", "deocde done bm " + this.cnP + " requestid " + this.jdN + " " + cA + zK);
        return Boolean.valueOf(true);
    }

    public final /* synthetic */ void onPostExecute(Object obj) {
        super.onPostExecute((Boolean) obj);
        ad.aSB().jjs.remove(this.apU);
        ad.aSB().b(this.apU, this.cnP);
    }

    public i(String str, String str2, List<aib> list) {
        ad.aSB().jjs.add(str);
        this.jdN = str2;
        this.jjP = ad.xh();
        this.jjO = ad.aSK();
        this.jjQ = list;
        this.apU = str;
    }

    public final ac aRW() {
        return ad.aqy();
    }

    private boolean b(String str, String str2, List<aib> list) {
        v.i("MicroMsg.MutiImageLoader", "makeMutilMedia " + str + " " + str2);
        List linkedList = new LinkedList();
        int i = 0;
        for (aib com_tencent_mm_protocal_c_aib : list) {
            String str3;
            String d = com.tencent.mm.plugin.sns.data.i.d(com_tencent_mm_protocal_c_aib);
            String c = com.tencent.mm.plugin.sns.data.i.c(com_tencent_mm_protocal_c_aib);
            String cA = al.cA(this.jjP, com_tencent_mm_protocal_c_aib.gID);
            if (!FileOp.aR(cA + d)) {
                if (!FileOp.aR(cA + c)) {
                    String k = com.tencent.mm.plugin.sns.data.i.k(com_tencent_mm_protocal_c_aib);
                    if (FileOp.aR(cA + k)) {
                        str3 = k;
                    } else {
                        str3 = com.tencent.mm.plugin.sns.data.i.l(com_tencent_mm_protocal_c_aib);
                    }
                    p.a(cA, str3, c, (float) ad.aSL());
                }
                p.b(cA, c, d, (float) ad.aSK());
            }
            n zS = com.tencent.mm.plugin.sns.data.i.zS(cA + d);
            if (zS == null) {
                FileOp.deleteFile(cA + d);
                v.e("MicroMsg.MutiImageLoader", "userThumb decode fail !! " + d);
                return false;
            }
            linkedList.add(zS);
            v.i("MicroMsg.MutiImageLoader", "getbitmap from bm " + zS + " " + cA + d);
            int i2 = i + 1;
            if (i2 < 4) {
                i = i2;
            }
        }
        try {
            str3 = al.cA(this.jjP, str);
            FileOp.jS(str3);
            d.a(com.tencent.mm.plugin.sns.data.i.f(linkedList, this.jjO), 100, CompressFormat.JPEG, str3 + str2, false);
            return true;
        } catch (Throwable e) {
            v.a("MicroMsg.MutiImageLoader", e, "makeMutilMedia failed: " + str2, new Object[0]);
            return false;
        }
    }
}
