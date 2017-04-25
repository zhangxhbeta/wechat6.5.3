package com.tencent.mm.plugin.sns.ui.a;

import android.text.SpannableString;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.mm.ai.b;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.e.ad;
import com.tencent.mm.plugin.sns.e.g;
import com.tencent.mm.plugin.sns.ui.TagImageView;
import com.tencent.mm.plugin.sns.ui.as;
import com.tencent.mm.plugin.sns.ui.av;
import com.tencent.mm.plugin.sns.ui.p;
import com.tencent.mm.protocal.c.aib;
import com.tencent.mm.protocal.c.ajr;
import com.tencent.mm.protocal.c.azr;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.storage.ak;

public final class c extends a {
    public final void d(com.tencent.mm.plugin.sns.ui.a.a.c cVar) {
        if (cVar.kaj != null) {
            cVar.kaj.setLayoutResource(2130904476);
            cVar.kaS = (ViewStub) cVar.kad.findViewById(2131759294);
            if (!(cVar.kaT || cVar.kaS == null)) {
                cVar.kaU = cVar.kaS.inflate();
                cVar.kaT = true;
            }
        } else {
            cVar.kaU = cVar.kad.findViewById(2131759417);
            cVar.kaT = true;
        }
        cVar.jSd = cVar.kaU;
        cVar.jSd.findViewById(2131757389).setOnTouchListener(this.jpB.jFF);
        cVar.kam = (TagImageView) cVar.jSd.findViewById(2131759412);
        cVar.jEe = (ImageView) cVar.jSd.findViewById(2131757389);
        cVar.kan = (TextView) cVar.jSd.findViewById(2131759415);
        cVar.dtB = (TextView) cVar.jSd.findViewById(2131759414);
        cVar.dtB.setTextColor(this.pP.getResources().getColor(2131690029));
        cVar.dtB.setMaxLines(1);
        i.b(cVar.kam, this.pP);
    }

    public final void a(com.tencent.mm.plugin.sns.ui.a.a.c cVar, int i, av avVar, azr com_tencent_mm_protocal_c_azr, int i2, as asVar) {
        String str = avVar.jFt;
        if (com_tencent_mm_protocal_c_azr.mWq.mom.isEmpty()) {
            cVar.jSd.setVisibility(8);
            return;
        }
        Object obj;
        CharSequence charSequence;
        cVar.kam.position = i;
        cVar.jSd.setVisibility(0);
        aib com_tencent_mm_protocal_c_aib = (aib) com_tencent_mm_protocal_c_azr.mWq.mom.get(0);
        g aSB = ad.aSB();
        TagImageView tagImageView = cVar.kam;
        int hashCode = this.pP.hashCode();
        ak bvR = ak.bvR();
        bvR.hrm = com_tencent_mm_protocal_c_azr.hNS;
        aSB.b(com_tencent_mm_protocal_c_aib, tagImageView, 2131165232, hashCode, bvR);
        cVar.jEe.setPressed(false);
        String str2 = com_tencent_mm_protocal_c_azr.gID;
        if (b.HC()) {
            ajr HE = b.HE();
            if (HE != null && b.d(HE) && str2.equals(HE.mJW)) {
                obj = 1;
                if (obj == null) {
                    cVar.jEe.setImageResource(2130838733);
                } else {
                    cVar.jEe.setImageResource(2130838735);
                }
                cVar.kam.setTag(new p(com_tencent_mm_protocal_c_azr, str));
                cVar.kam.setOnClickListener(asVar.jMO.jZb);
                cVar.jSd.setTag(new p(com_tencent_mm_protocal_c_azr, str));
                asVar.eyZ.a(cVar.jSd, asVar.joV.kbK, asVar.joV.kbv);
                cVar.jSd.setOnClickListener(asVar.jMO.jRS);
                charSequence = com_tencent_mm_protocal_c_aib.gkC;
                if (be.kS(charSequence)) {
                    cVar.kan.setVisibility(0);
                    cVar.kan.setText(charSequence);
                } else {
                    cVar.kan.setVisibility(4);
                }
                charSequence = com_tencent_mm_protocal_c_aib.aXz;
                if (be.kS(charSequence)) {
                    cVar.dtB.setVisibility(0);
                    cVar.dtB.setText(new SpannableString(charSequence), BufferType.SPANNABLE);
                }
                cVar.dtB.setVisibility(8);
                return;
            }
        }
        obj = null;
        if (obj == null) {
            cVar.jEe.setImageResource(2130838735);
        } else {
            cVar.jEe.setImageResource(2130838733);
        }
        cVar.kam.setTag(new p(com_tencent_mm_protocal_c_azr, str));
        cVar.kam.setOnClickListener(asVar.jMO.jZb);
        cVar.jSd.setTag(new p(com_tencent_mm_protocal_c_azr, str));
        asVar.eyZ.a(cVar.jSd, asVar.joV.kbK, asVar.joV.kbv);
        cVar.jSd.setOnClickListener(asVar.jMO.jRS);
        charSequence = com_tencent_mm_protocal_c_aib.gkC;
        if (be.kS(charSequence)) {
            cVar.kan.setVisibility(4);
        } else {
            cVar.kan.setVisibility(0);
            cVar.kan.setText(charSequence);
        }
        charSequence = com_tencent_mm_protocal_c_aib.aXz;
        if (be.kS(charSequence)) {
            cVar.dtB.setVisibility(8);
            return;
        }
        cVar.dtB.setVisibility(0);
        cVar.dtB.setText(new SpannableString(charSequence), BufferType.SPANNABLE);
    }
}
