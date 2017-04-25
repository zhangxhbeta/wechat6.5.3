package com.tencent.mm.plugin.sns.ui.a;

import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.e.ad;
import com.tencent.mm.plugin.sns.e.ak.a;
import com.tencent.mm.plugin.sns.e.g;
import com.tencent.mm.plugin.sns.ui.TagImageView;
import com.tencent.mm.plugin.sns.ui.a.a.c;
import com.tencent.mm.plugin.sns.ui.as;
import com.tencent.mm.plugin.sns.ui.av;
import com.tencent.mm.plugin.sns.ui.p;
import com.tencent.mm.protocal.c.aib;
import com.tencent.mm.protocal.c.azr;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.storage.ak;

public final class d extends a {
    public final void d(c cVar) {
        if (cVar.kaj == null || cVar.kaj.getParent() == null) {
            cVar.kaU = cVar.kad.findViewById(2131759417);
            cVar.kaT = true;
        } else {
            cVar.kaj.setLayoutResource(2130904476);
            if (!cVar.kaT) {
                cVar.kaU = cVar.kaj.inflate();
                cVar.kaT = true;
            }
        }
        cVar.jSd = cVar.kaU;
        cVar.kam = (TagImageView) cVar.jSd.findViewById(2131759412);
        cVar.jEe = (ImageView) cVar.jSd.findViewById(2131757389);
        cVar.kan = (TextView) cVar.jSd.findViewById(2131759415);
        cVar.dtB = (TextView) cVar.jSd.findViewById(2131759414);
        cVar.dtB.setTextColor(this.pP.getResources().getColor(2131689547));
        i.b(cVar.kam, this.pP);
    }

    public final void a(c cVar, int i, av avVar, azr com_tencent_mm_protocal_c_azr, int i2, as asVar) {
        Object obj;
        String Cf;
        cVar.kam.position = i;
        String str = avVar.jFt;
        if (com_tencent_mm_protocal_c_azr.mWq.mol == 9) {
            if (com_tencent_mm_protocal_c_azr.mWq.mom.size() > 0) {
                cVar.jSd.setTag(new p(com_tencent_mm_protocal_c_azr, str));
                cVar.jSd.setOnClickListener(asVar.jMO.jYV);
                obj = null;
            }
            obj = null;
        } else if (com_tencent_mm_protocal_c_azr.mWq.mol == 10) {
            if (com_tencent_mm_protocal_c_azr.mWq.mom.size() > 0) {
                cVar.jSd.setTag(new p(com_tencent_mm_protocal_c_azr, str));
                cVar.jSd.setOnClickListener(asVar.jMO.jYX);
                obj = null;
            }
            obj = null;
        } else if (com_tencent_mm_protocal_c_azr.mWq.mol == 17) {
            if (com_tencent_mm_protocal_c_azr.mWq.mom.size() > 0) {
                cVar.jSd.setTag(new p(com_tencent_mm_protocal_c_azr, str));
                cVar.jSd.setOnClickListener(asVar.jMO.jYY);
                obj = null;
            }
            obj = null;
        } else if (com_tencent_mm_protocal_c_azr.mWq.mol == 22) {
            if (com_tencent_mm_protocal_c_azr.mWq.mom.size() > 0) {
                cVar.jSd.setTag(new p(com_tencent_mm_protocal_c_azr, str));
                cVar.jSd.setOnClickListener(asVar.jMO.jYZ);
                obj = null;
            }
            obj = null;
        } else if (com_tencent_mm_protocal_c_azr.mWq.mol == 23) {
            if (com_tencent_mm_protocal_c_azr.mWq.mom.size() > 0) {
                cVar.jSd.setTag(new p(com_tencent_mm_protocal_c_azr, str));
                cVar.jSd.setOnClickListener(asVar.jMO.jZa);
                obj = null;
            }
            obj = null;
        } else if (com_tencent_mm_protocal_c_azr.mWq.mol == 14) {
            if (com_tencent_mm_protocal_c_azr.mWq.mom.size() > 0) {
                cVar.jSd.setTag(new p(com_tencent_mm_protocal_c_azr, str));
                cVar.jSd.setOnClickListener(asVar.jMO.jYW);
                obj = null;
            }
            obj = null;
        } else if (com_tencent_mm_protocal_c_azr.mWq.mol == 12) {
            if (com_tencent_mm_protocal_c_azr.mWq.mom.size() > 0) {
                cVar.jSd.setTag(new p(com_tencent_mm_protocal_c_azr, str));
                cVar.jSd.setOnClickListener(asVar.jMO.jZe);
                obj = null;
            }
            obj = null;
        } else if (com_tencent_mm_protocal_c_azr.mWq.mol == 13) {
            if (com_tencent_mm_protocal_c_azr.mWq.mom.size() > 0) {
                cVar.jSd.setTag(new p(com_tencent_mm_protocal_c_azr, str));
                cVar.jSd.setOnClickListener(asVar.jMO.jZf);
                obj = null;
            } else {
                cVar.jSd.setOnClickListener(null);
                obj = null;
            }
        } else if (com_tencent_mm_protocal_c_azr.mWq.mol == 15) {
            if (com_tencent_mm_protocal_c_azr.mWq.mom.size() > 0) {
                cVar.jSd.setTag(new p(com_tencent_mm_protocal_c_azr, str));
                cVar.jSd.setOnClickListener(asVar.joV.kbR);
                obj = null;
            }
            obj = null;
        } else {
            cVar.jSd.setTag(new p(com_tencent_mm_protocal_c_azr, str));
            cVar.jSd.setOnClickListener(asVar.jMO.jRS);
            if ((com_tencent_mm_protocal_c_azr.cog & 1) > 0) {
                int i3 = 1;
            }
            obj = null;
        }
        asVar.eyZ.a(cVar.jSd, asVar.joV.kbK, asVar.joV.kbv);
        Object obj2 = com_tencent_mm_protocal_c_azr.mWq.mol == 9 ? 1 : (a.aTb() & 1) <= 0 ? 1 : null;
        if (obj2 != null) {
            Cf = as.Cf(com_tencent_mm_protocal_c_azr.mWq.glb);
        } else {
            Cf = "";
        }
        if (com_tencent_mm_protocal_c_azr.mWq.mol == 9 || com_tencent_mm_protocal_c_azr.mWq.mol == 14 || com_tencent_mm_protocal_c_azr.mWq.mol == 12 || com_tencent_mm_protocal_c_azr.mWq.mol == 13) {
            CharSequence charSequence = com_tencent_mm_protocal_c_azr.mWq.gkC;
        } else {
            Object obj3 = Cf;
        }
        Cf = com_tencent_mm_protocal_c_azr.mWq.aXz;
        if (Cf == null || Cf.length() <= 40) {
            Object obj4 = Cf;
        } else {
            CharSequence charSequence2 = Cf.substring(0, 40) + "...";
        }
        cVar.jEe.setVisibility(8);
        if (!com_tencent_mm_protocal_c_azr.mWq.mom.isEmpty()) {
            cVar.kam.setVisibility(0);
            aib com_tencent_mm_protocal_c_aib = (aib) com_tencent_mm_protocal_c_azr.mWq.mom.get(0);
            g aSB;
            TagImageView tagImageView;
            int hashCode;
            ak bvR;
            if (com_tencent_mm_protocal_c_azr.mWq.mol == 15) {
                cVar.jEe.setImageResource(2130838735);
                cVar.jEe.setVisibility(0);
                aSB = ad.aSB();
                tagImageView = cVar.kam;
                hashCode = this.pP.hashCode();
                bvR = ak.bvR();
                bvR.hrm = com_tencent_mm_protocal_c_azr.hNS;
                aSB.b(com_tencent_mm_protocal_c_aib, tagImageView, 2131165244, hashCode, bvR);
            } else if (com_tencent_mm_protocal_c_azr.mWq.mol == 5) {
                charSequence2 = com_tencent_mm_protocal_c_aib.aXz;
                cVar.jEe.setImageResource(2130839379);
                cVar.jEe.setVisibility(0);
                aSB = ad.aSB();
                tagImageView = cVar.kam;
                hashCode = this.pP.hashCode();
                bvR = ak.bvR();
                bvR.hrm = com_tencent_mm_protocal_c_azr.hNS;
                aSB.b(com_tencent_mm_protocal_c_aib, tagImageView, 2131165244, hashCode, bvR);
            } else if (com_tencent_mm_protocal_c_azr.mWq.mol == 18) {
                cVar.jEe.setVisibility(0);
                cVar.jEe.setImageResource(2130839379);
                cVar.kam.setVisibility(0);
                aSB = ad.aSB();
                tagImageView = cVar.kam;
                hashCode = this.pP.hashCode();
                bvR = ak.bvR();
                bvR.hrm = com_tencent_mm_protocal_c_azr.hNS;
                aSB.b(com_tencent_mm_protocal_c_aib, tagImageView, 2131165244, hashCode, bvR);
            } else {
                aSB = ad.aSB();
                tagImageView = cVar.kam;
                int hashCode2 = this.pP.hashCode();
                ak bvR2 = ak.bvR();
                bvR2.hrm = com_tencent_mm_protocal_c_azr.hNS;
                aSB.b(com_tencent_mm_protocal_c_aib, tagImageView, hashCode2, bvR2);
            }
        } else if (com_tencent_mm_protocal_c_azr.mWq.mol == 18) {
            cVar.jEe.setVisibility(0);
            cVar.jEe.setImageResource(2130839379);
            cVar.kam.setVisibility(0);
            ad.aSB().a(cVar.kam, -1, 2131165244, this.pP.hashCode());
        } else {
            cVar.kam.setVisibility(0);
            ad.aSB().a(cVar.kam, -1, 2131165247, this.pP.hashCode());
        }
        if (com_tencent_mm_protocal_c_azr.mWq.mol == 15) {
            charSequence = "";
            charSequence2 = this.pP.getString(2131235409);
        }
        if (be.kS(charSequence)) {
            cVar.kan.setVisibility(8);
        } else {
            cVar.kan.setVisibility(0);
            cVar.kan.setText(charSequence);
        }
        if (!be.kS(charSequence2)) {
            if (cVar.kan.getVisibility() == 8) {
                if (cVar.kao != 2) {
                    cVar.dtB.setMaxLines(2);
                }
                cVar.kao = 2;
            } else {
                if (cVar.kao != 1) {
                    cVar.dtB.setMaxLines(1);
                }
                cVar.kao = 1;
            }
            cVar.dtB.setVisibility(0);
            if (obj != null) {
                cVar.dtB.setText(i.a(charSequence2, this.pP, cVar.dtB));
            } else {
                cVar.dtB.setText(charSequence2);
            }
        } else if (i2 == 1) {
            cVar.dtB.setText(as.Cf(com_tencent_mm_protocal_c_azr.mWq.glb));
            cVar.dtB.setVisibility(0);
        } else {
            cVar.dtB.setVisibility(8);
        }
    }
}
