package com.tencent.mm.plugin.sns.ui.a;

import android.annotation.TargetApi;
import android.graphics.BitmapFactory;
import android.util.DisplayMetrics;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.tencent.mm.plugin.sns.e.ad;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d;
import com.tencent.mm.plugin.sns.storage.b;
import com.tencent.mm.plugin.sns.ui.MaskImageView;
import com.tencent.mm.plugin.sns.ui.PhotosContent;
import com.tencent.mm.plugin.sns.ui.TagImageView;
import com.tencent.mm.plugin.sns.ui.a.a.c;
import com.tencent.mm.plugin.sns.ui.ao;
import com.tencent.mm.plugin.sns.ui.as;
import com.tencent.mm.plugin.sns.ui.av;
import com.tencent.mm.protocal.c.aid;
import com.tencent.mm.protocal.c.azr;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ak;
import java.util.LinkedList;
import java.util.List;

public final class e extends a {
    private int jMQ;
    private int jMR = 103;
    MaskImageView kbk;

    public static class a extends c {
    }

    public final void d(c cVar) {
        this.pP.getWindowManager().getDefaultDisplay().getMetrics(new DisplayMetrics());
        v.i("MiroMsg.PhotoTimeLineItem", "viewtype " + this.eKg);
        this.jMQ = ad.aSK();
        if (cVar.kaj != null) {
            if (this.eKg == 2) {
                cVar.kaj.setLayoutResource(2130904510);
            } else if (this.eKg == 3) {
                cVar.kaj.setLayoutResource(2130904507);
            } else if (this.eKg == 4) {
                cVar.kaj.setLayoutResource(2130904508);
            } else if (this.eKg == 5) {
                cVar.kaj.setLayoutResource(2130904509);
            } else {
                v.e("MiroMsg.PhotoTimeLineItem", "error viewtyoe in photo item  " + this.eKg);
            }
            if (!cVar.kak) {
                cVar.kaA = (PhotosContent) cVar.kaj.inflate();
                cVar.kak = true;
            }
        } else {
            cVar.kaA = (PhotosContent) cVar.kad.findViewById(2131759479);
            cVar.kak = true;
        }
        cVar.kaA.jIu.clear();
        for (int i = 0; i < ao.jQE[this.eKg]; i++) {
            TagImageView tagImageView = (TagImageView) cVar.kaA.findViewById(ao.jQI[i]);
            cVar.kaA.a(tagImageView);
            tagImageView.setOnClickListener(this.jpB.joV.jIT);
            this.jpB.eyZ.a(tagImageView, this.jpB.joV.kbJ, this.jpB.joV.kbv);
        }
        cVar.kaA.qP(this.jMQ);
    }

    @TargetApi(16)
    public final void a(c cVar, int i, av avVar, azr com_tencent_mm_protocal_c_azr, int i2, as asVar) {
        cVar.kaA.setVisibility(0);
        String str = com_tencent_mm_protocal_c_azr.mWp == null ? null : com_tencent_mm_protocal_c_azr.mWp.gID;
        if (!be.kS(str)) {
            boolean booleanValue;
            if (asVar.jUq.containsKey(str)) {
                booleanValue = ((Boolean) asVar.jUq.get(str)).booleanValue();
            } else {
                asVar.jUq.put(str, Boolean.valueOf(com.tencent.mm.plugin.sns.b.a.drq.bp(str)));
                booleanValue = true;
            }
            if (booleanValue) {
                com.tencent.mm.plugin.sns.b.a.drq.a(this.pP, str, com_tencent_mm_protocal_c_azr.gln, com_tencent_mm_protocal_c_azr.mWu, avVar.jWv);
            }
        }
        List linkedList = new LinkedList();
        if (avVar.jEb && i2 == 2) {
            final b aUm = avVar.jaC.aUm();
            if (aUm != null && aUm.juP > 0.0f && aUm.juQ > 0.0f) {
                float a = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.a((double) aUm.juP, 1, aUm.juR, aUm.juS);
                float a2 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.a((double) aUm.juQ, 1, aUm.juR, aUm.juS);
                int width = ((WindowManager) this.pP.getSystemService("window")).getDefaultDisplay().getWidth();
                if (aUm.juO == 0) {
                    aid com_tencent_mm_protocal_c_aid = new aid();
                    com_tencent_mm_protocal_c_aid.mID = a;
                    com_tencent_mm_protocal_c_aid.lHK = a2;
                    if (a >= ((float) (((width - com.tencent.mm.bd.a.fromDPToPix(this.pP, 50)) - com.tencent.mm.bd.a.fromDPToPix(this.pP, 12)) - com.tencent.mm.bd.a.fromDPToPix(this.pP, 12)))) {
                        com_tencent_mm_protocal_c_aid.mID = (float) (((width - com.tencent.mm.bd.a.fromDPToPix(this.pP, 50)) - com.tencent.mm.bd.a.fromDPToPix(this.pP, 12)) - com.tencent.mm.bd.a.fromDPToPix(this.pP, 12));
                        com_tencent_mm_protocal_c_aid.lHK = (float) ((int) ((com_tencent_mm_protocal_c_aid.mID * aUm.juQ) / aUm.juP));
                    }
                    com_tencent_mm_protocal_c_aid.mIE = com_tencent_mm_protocal_c_aid.mID * com_tencent_mm_protocal_c_aid.lHK;
                    linkedList.add(com_tencent_mm_protocal_c_aid);
                } else if (aUm.juO == 1) {
                    float f;
                    width = (((width - com.tencent.mm.bd.a.fromDPToPix(this.pP, 50)) - com.tencent.mm.bd.a.fromDPToPix(this.pP, 50)) - com.tencent.mm.bd.a.fromDPToPix(this.pP, 12)) - com.tencent.mm.bd.a.fromDPToPix(this.pP, 12);
                    r5 = (int) ((((float) width) * aUm.juQ) / aUm.juP);
                    r6 = new aid();
                    if (width > 0) {
                        f = (float) width;
                    } else {
                        f = a;
                    }
                    r6.mID = f;
                    if (r5 > 0) {
                        f = (float) r5;
                    } else {
                        f = a2;
                    }
                    r6.lHK = f;
                    r6.mIE = r6.mID * r6.lHK;
                    linkedList.add(r6);
                } else if (aUm.juO == 2) {
                    width = ((width - com.tencent.mm.bd.a.fromDPToPix(this.pP, 50)) - com.tencent.mm.bd.a.fromDPToPix(this.pP, 12)) - com.tencent.mm.bd.a.fromDPToPix(this.pP, 12);
                    r5 = (int) ((((float) width) * aUm.juQ) / aUm.juP);
                    r6 = new aid();
                    if (width > 0) {
                        a = (float) width;
                    }
                    r6.mID = a;
                    if (r5 > 0) {
                        a2 = (float) r5;
                    }
                    r6.lHK = a2;
                    r6.mIE = r6.mID * r6.lHK;
                    linkedList.add(r6);
                }
            }
            if (!be.kS(aUm.juU)) {
                final PhotosContent photosContent = cVar.kaA;
                final TagImageView qQ = cVar.kaA.qQ(0);
                d.a("adId", aUm.juU, false, 41, 0, new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d.a(this) {
                    final /* synthetic */ e kbl;

                    public final void aRx() {
                    }

                    public final void aTV() {
                    }

                    public final void Bg(String str) {
                        this.kbl.kbk = (MaskImageView) photosContent.findViewById(2131759488);
                        if (this.kbl.kbk != null) {
                            this.kbl.kbk.setVisibility(0);
                            this.kbl.kbk.setImageBitmap(BitmapFactory.decodeFile(str));
                            float a = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.a((double) aUm.juV, 1, aUm.juR, aUm.juS);
                            float a2 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.a((double) aUm.juW, 1, aUm.juR, aUm.juS);
                            float a3 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.a((double) aUm.juX, 1, aUm.juR, aUm.juS);
                            float a4 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.a((double) aUm.juY, 1, aUm.juR, aUm.juS);
                            LayoutParams layoutParams = new FrameLayout.LayoutParams((int) a, (int) a2);
                            layoutParams.setMargins((int) ((((float) qQ.getRight()) - a3) - a), (int) ((((float) qQ.getBottom()) - a4) - a2), 0, 0);
                            this.kbl.kbk.setLayoutParams(layoutParams);
                        }
                    }
                });
            }
        }
        ao aoVar = asVar.jMF;
        PhotosContent photosContent2 = cVar.kaA;
        str = avVar.jFt;
        int hashCode = this.pP.hashCode();
        boolean z = this.jMd;
        ak bvR = ak.bvR();
        bvR.hrm = com_tencent_mm_protocal_c_azr.hNS;
        aoVar.a(photosContent2, com_tencent_mm_protocal_c_azr, str, hashCode, i2, i, z, bvR, linkedList);
    }
}
