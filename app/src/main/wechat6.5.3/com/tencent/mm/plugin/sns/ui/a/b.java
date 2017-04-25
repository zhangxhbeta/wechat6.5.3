package com.tencent.mm.plugin.sns.ui.a;

import com.tencent.mm.model.k;
import com.tencent.mm.plugin.sns.ui.PhotosContent;
import com.tencent.mm.plugin.sns.ui.TagImageView;
import com.tencent.mm.plugin.sns.ui.a.a.c;
import com.tencent.mm.plugin.sns.ui.am;
import com.tencent.mm.plugin.sns.ui.ao;
import com.tencent.mm.plugin.sns.ui.as;
import com.tencent.mm.plugin.sns.ui.av;
import com.tencent.mm.protocal.c.aic;
import com.tencent.mm.protocal.c.azr;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ak;
import java.util.ArrayList;
import java.util.List;

public final class b extends a {
    private int jMR = 103;

    public final void d(c cVar) {
        cVar.kat.setImageResource(2130838511);
        cVar.kae.setTextColor(-2730427);
        if (cVar.kaj != null) {
            cVar.kaj.setLayoutResource(2130904453);
            if (!cVar.kak) {
                cVar.kaA = (PhotosContent) cVar.kaj.inflate();
                cVar.kak = true;
            }
        } else {
            cVar.kaA = (PhotosContent) cVar.kad.findViewById(2131759362);
            cVar.kak = true;
        }
        v.i("MiroMsg.HBRewardTimeLineItem", "viewtype " + this.eKg);
        TagImageView tagImageView = (TagImageView) cVar.kaA.findViewById(ao.jQI[0]);
        cVar.kaA.a(tagImageView);
        tagImageView.setOnClickListener(this.jpB.joV.jIT);
    }

    public final void a(c cVar, int i, av avVar, azr com_tencent_mm_protocal_c_azr, int i2, as asVar) {
        String str = avVar.jFt;
        if (cVar.kbh != null) {
            if (!avVar.jWL || cVar.jbw.mTz == null || cVar.jbw.mTz.mTY <= 0) {
                cVar.kbh.setBackgroundResource(2130838270);
            } else {
                cVar.kbh.setBackgroundResource(2130838271);
            }
        }
        TagImageView qQ = cVar.kaA.qQ(0);
        List arrayList = new ArrayList();
        arrayList.add(qQ);
        am amVar = new am();
        amVar.bde = str;
        amVar.index = 0;
        amVar.jOH = arrayList;
        amVar.jMd = this.jMd;
        if (qQ != null) {
            qQ.setTag(amVar);
        }
        aic com_tencent_mm_protocal_c_aic = avVar.jXl;
        cVar.jBT = com_tencent_mm_protocal_c_aic;
        if (com_tencent_mm_protocal_c_aic == null) {
            v.e("MiroMsg.HBRewardTimeLineItem", "mediaPostInfo is null " + avVar.jFt);
        } else if (k.xF().equals(com_tencent_mm_protocal_c_azr.gln)) {
            cVar.kaA.setVisibility(0);
            r1 = asVar.jMF;
            r2 = cVar.kaA;
            r4 = avVar.jFt;
            r5 = this.pP.hashCode();
            r8 = this.jMd;
            r9 = ak.bvR();
            r9.hrm = com_tencent_mm_protocal_c_azr.hNS;
            r1.a(r2, com_tencent_mm_protocal_c_azr, r4, r5, i2, i, r8, r9, true);
        } else if (avVar.jWO) {
            cVar.kaA.setVisibility(0);
            r1 = asVar.jMF;
            r2 = cVar.kaA;
            r4 = avVar.jFt;
            r5 = this.pP.hashCode();
            r8 = this.jMd;
            r9 = ak.bvR();
            r9.hrm = com_tencent_mm_protocal_c_azr.hNS;
            r1.a(r2, com_tencent_mm_protocal_c_azr, r4, r5, i2, i, r8, r9, false);
        } else if (com_tencent_mm_protocal_c_aic.hav == 0) {
            cVar.kaA.setVisibility(0);
            r1 = asVar.jMF;
            r2 = cVar.kaA;
            r4 = avVar.jFt;
            r5 = this.pP.hashCode();
            r8 = this.jMd;
            r9 = ak.bvR();
            r9.hrm = com_tencent_mm_protocal_c_azr.hNS;
            r1.a(r2, com_tencent_mm_protocal_c_azr, r4, r5, i2, i, r8, r9, true);
        } else {
            v.e("MiroMsg.HBRewardTimeLineItem", "mediaPostInfo.hbStatus is " + com_tencent_mm_protocal_c_aic.hav);
        }
    }
}
