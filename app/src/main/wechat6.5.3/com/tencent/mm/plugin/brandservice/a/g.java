package com.tencent.mm.plugin.brandservice.a;

import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.protocal.c.abr;
import com.tencent.mm.protocal.c.abs;
import com.tencent.mm.protocal.c.apw;
import com.tencent.mm.protocal.c.apx;
import com.tencent.mm.protocal.c.asf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.h;
import com.tencent.mm.u.n;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.Iterator;
import java.util.LinkedList;

public final class g extends k implements j {
    private static long exq = 0;
    private b cif;
    private e cii;

    public static boolean Yk() {
        return System.currentTimeMillis() - exq > 3600000;
    }

    public final int getType() {
        return 456;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        exq = System.currentTimeMillis();
        this.cii = eVar2;
        a aVar = new a();
        aVar.czn = new abr();
        aVar.czo = new abs();
        aVar.uri = "/cgi-bin/micromsg-bin/grouprecommendbiz";
        aVar.czm = 456;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        return a(eVar, this.cif, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.d("MicroMsg.BrandService.NetSceneGroupRecommendBiz", "onGYNetEnd errtype:" + i2 + " errcode:" + i3 + " errMsg:" + str);
        if (i2 == 0 && i3 == 0) {
            abs com_tencent_mm_protocal_c_abs = (abs) this.cif.czl.czs;
            if (com_tencent_mm_protocal_c_abs.mCL.mKB > 0) {
                v.d("MicroMsg.BrandService.NetSceneGroupRecommendBiz", "GroupCount, %d", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_abs.mCL.mKB)});
                try {
                    byte[] toByteArray = com_tencent_mm_protocal_c_abs.mCL.toByteArray();
                    StringBuilder stringBuilder = new StringBuilder();
                    ak.yW();
                    com.tencent.mm.a.e.b(stringBuilder.append(c.xq()).append("search_biz_recommend").toString(), toByteArray, toByteArray.length);
                    Iterator it = com_tencent_mm_protocal_c_abs.mCL.mPp.iterator();
                    while (it.hasNext()) {
                        Iterator it2 = ((apw) it.next()).mPo.iterator();
                        while (it2.hasNext()) {
                            asf com_tencent_mm_protocal_c_asf = (asf) it2.next();
                            h hVar = new h();
                            hVar.username = m.a(com_tencent_mm_protocal_c_asf.moM);
                            hVar.cyD = com_tencent_mm_protocal_c_asf.mlY;
                            hVar.cyC = com_tencent_mm_protocal_c_asf.mlZ;
                            hVar.bkU = -1;
                            hVar.bBY = 3;
                            hVar.aP(true);
                            n.Bo().a(hVar);
                        }
                    }
                } catch (Throwable e) {
                    v.d("MicroMsg.BrandService.NetSceneGroupRecommendBiz", e.getMessage());
                    v.a("MicroMsg.BrandService.NetSceneGroupRecommendBiz", e, "", new Object[0]);
                }
            } else {
                StringBuilder stringBuilder2 = new StringBuilder();
                ak.yW();
                com.tencent.mm.loader.stub.b.deleteFile(stringBuilder2.append(c.xq()).append("search_biz_recommend").toString());
            }
        }
        this.cii.a(i2, i3, str, this);
    }

    public static LinkedList<apw> Yl() {
        try {
            StringBuilder stringBuilder = new StringBuilder();
            ak.yW();
            byte[] d = com.tencent.mm.a.e.d(stringBuilder.append(c.xq()).append("search_biz_recommend").toString(), 0, Integer.MAX_VALUE);
            if (d != null) {
                apx com_tencent_mm_protocal_c_apx = new apx();
                com_tencent_mm_protocal_c_apx.az(d);
                v.d("MicroMsg.BrandService.NetSceneGroupRecommendBiz", "GroupCount2: %d", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_apx.mKB)});
                return com_tencent_mm_protocal_c_apx.mPp;
            }
        } catch (Throwable e) {
            v.d("MicroMsg.BrandService.NetSceneGroupRecommendBiz", e.getMessage());
            v.a("MicroMsg.BrandService.NetSceneGroupRecommendBiz", e, "", new Object[0]);
        }
        return new LinkedList();
    }
}
