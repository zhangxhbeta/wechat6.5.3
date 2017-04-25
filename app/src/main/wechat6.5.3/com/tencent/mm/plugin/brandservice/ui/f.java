package com.tencent.mm.plugin.brandservice.ui;

import android.content.Context;
import android.util.SparseArray;
import com.tencent.mm.plugin.brandservice.ui.base.a;
import com.tencent.mm.plugin.brandservice.ui.base.c;
import com.tencent.mm.plugin.brandservice.ui.c.b;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.apw;
import com.tencent.mm.protocal.c.asf;
import com.tencent.mm.protocal.c.hy;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.util.List;

public final class f extends c {
    List<apw> ezw = null;
    private SparseArray<c> ezx = new SparseArray();
    private int ezy;

    public final /* synthetic */ Object getItem(int i) {
        return iM(i);
    }

    public f(Context context) {
        super(context);
        a(new b(this) {
            final /* synthetic */ f ezz;

            {
                this.ezz = r1;
            }

            public final void a(c cVar, a aVar, int i, String str, int i2, int i3) {
                hy iH = this.ezz.iH(i3);
                String str2 = be.ma(this.ezz.exS) + "," + i + "," + be.ma(str) + "," + i2 + "," + cVar.eyc + "," + (iH == null ? "" : iH.miU + ",0");
                g.iuh.Y(10866, str2);
                v.d("MicroMsg.SearchOrRecommendBizAdapter", "report : " + str2);
            }
        });
    }

    public final void c(String str, List<hy> list) {
        super.c(str, list);
        this.ezy = super.getCount();
    }

    public final void a(hy hyVar, boolean z) {
        super.a(hyVar, z);
        if (this.ezy == 0) {
            this.ezy = super.getCount();
        }
    }

    public final int getCount() {
        int count = super.getCount();
        if (count != 0 || this.ezw == null) {
            return count;
        }
        int i = count;
        for (apw com_tencent_mm_protocal_c_apw : this.ezw) {
            if (com_tencent_mm_protocal_c_apw == null || com_tencent_mm_protocal_c_apw.mPo == null) {
                count = i;
            } else {
                count = i + com_tencent_mm_protocal_c_apw.mPo.size();
            }
            i = count;
        }
        return i;
    }

    public final void Yq() {
        super.Yq();
    }

    public final a iM(int i) {
        String str = null;
        int count = super.getCount();
        if (count != 0) {
            return super.iM(i);
        }
        c cVar = (c) this.ezx.get(i);
        if (cVar != null || this.ezw.size() <= 0) {
            return cVar;
        }
        Object obj;
        for (apw com_tencent_mm_protocal_c_apw : this.ezw) {
            if (count == i) {
                String com_tencent_mm_protocal_c_arf = com_tencent_mm_protocal_c_apw.mPm == null ? null : com_tencent_mm_protocal_c_apw.mPm.toString();
                obj = (asf) com_tencent_mm_protocal_c_apw.mPo.get(0);
                str = com_tencent_mm_protocal_c_arf;
            } else if (i < com_tencent_mm_protocal_c_apw.mPo.size() + count) {
                asf com_tencent_mm_protocal_c_asf = (asf) com_tencent_mm_protocal_c_apw.mPo.get(i - count);
                break;
            } else {
                count = com_tencent_mm_protocal_c_apw.mPo.size() + count;
            }
        }
        obj = null;
        a bVar = new b(obj, str);
        bVar.iN(i);
        bVar.iO(i);
        this.ezx.put(i, bVar);
        return bVar;
    }

    protected final Object[] iL(int i) {
        a iG = iG(i);
        hy iH = iH(i);
        if (iG == null) {
            return super.iL(i);
        }
        Object[] objArr = new Object[4];
        objArr[0] = this;
        objArr[1] = iG.eyg;
        objArr[2] = Integer.valueOf(i < this.ezy ? 39 : 56);
        objArr[3] = iH != null ? iH.miU : "";
        return objArr;
    }
}
