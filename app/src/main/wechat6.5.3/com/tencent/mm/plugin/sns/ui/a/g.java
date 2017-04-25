package com.tencent.mm.plugin.sns.ui.a;

import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.model.ak;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelsns.d;
import com.tencent.mm.plugin.sight.decode.a.a;
import com.tencent.mm.plugin.sight.decode.a.b;
import com.tencent.mm.plugin.sight.decode.a.b.e;
import com.tencent.mm.plugin.sight.decode.a.b.f;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.e.ad;
import com.tencent.mm.plugin.sns.e.al;
import com.tencent.mm.plugin.sns.storage.k;
import com.tencent.mm.plugin.sns.ui.a.a.c;
import com.tencent.mm.plugin.sns.ui.as;
import com.tencent.mm.plugin.sns.ui.av;
import com.tencent.mm.protocal.c.aib;
import com.tencent.mm.protocal.c.azr;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.widget.MMPinProgressBtn;

public final class g extends a {
    private e kbm = new e(this) {
        final /* synthetic */ g kbn;

        {
            this.kbn = r1;
        }

        public final void d(b bVar, int i) {
        }
    };
    private int mScreenHeight;
    private int mScreenWidth;

    public final void d(c cVar) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        this.pP.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.mScreenWidth = displayMetrics.widthPixels;
        this.mScreenHeight = displayMetrics.heightPixels;
        if (cVar.kaj != null) {
            cVar.kaj.setLayoutResource(2130904474);
            cVar.kaX = (ViewStub) cVar.kad.findViewById(2131759294);
            if (!cVar.kaY) {
                cVar.kaZ.jKl = cVar.kaX.inflate();
                cVar.kaY = true;
            }
        } else {
            cVar.kaZ.jKl = cVar.kad.findViewById(2131759416);
            cVar.kaY = true;
        }
        cVar.kaZ.jKm = cVar.kaZ.jKl.findViewById(2131756148);
        cVar.kaZ.iWn = (a) cVar.kaZ.jKl.findViewById(2131755052);
        cVar.kaZ.jKm.setOnClickListener(this.jpB.joV.kbQ);
        cVar.kaZ.jzs = (ImageView) cVar.kaZ.jKl.findViewById(2131755281);
        cVar.kaZ.jzr = (MMPinProgressBtn) cVar.kaZ.jKl.findViewById(2131758183);
        cVar.kaZ.jKn = (TextView) cVar.kaZ.jKl.findViewById(2131759208);
        cVar.kaZ.jzt = (TextView) cVar.kaZ.jKl.findViewById(2131759209);
        this.jpB.eyZ.a(cVar.kaZ.jKm, this.jpB.joV.kbL, this.jpB.joV.kbv);
        ak.yW();
        if (((Boolean) com.tencent.mm.model.c.vf().get(344065, Boolean.valueOf(false))).booleanValue()) {
            cVar.kaZ.iWn.g((TextView) ((ViewStub) cVar.kaZ.jKl.findViewById(2131756221)).inflate());
        }
    }

    public final void a(c cVar, int i, av avVar, azr com_tencent_mm_protocal_c_azr, int i2, as asVar) {
        aib com_tencent_mm_protocal_c_aib;
        if (com_tencent_mm_protocal_c_azr.mWq == null || com_tencent_mm_protocal_c_azr.mWq.mom.size() <= 0) {
            com_tencent_mm_protocal_c_aib = null;
        } else {
            com_tencent_mm_protocal_c_aib = (aib) com_tencent_mm_protocal_c_azr.mWq.mom.get(0);
        }
        v.v("MicroMsg.VideoTimeLineItem", "videoTImeline %d ", new Object[]{Integer.valueOf(i)});
        k Bp = ad.aSE().Bp(cVar.boC);
        if (!avVar.jEb || com_tencent_mm_protocal_c_aib == null) {
            cVar.kaZ.jKn.setVisibility(8);
            cVar.kaZ.iWn.aPc();
            cVar.kaZ.iWn.a(null);
            cVar.kaZ.iWn.a(null);
        } else {
            final long j = avVar.jWv;
            final as asVar2 = asVar;
            cVar.kaZ.iWn.a(new e(this) {
                final /* synthetic */ g kbn;

                public final void d(b bVar, int i) {
                    if (i != -1 && asVar2 != null && asVar2.jUe != null && asVar2.jUe.jEn != null) {
                        asVar2.jUe.jEn.cC(j);
                    }
                }
            });
            if (!asVar.jUe.jEn.cD(j)) {
                final as asVar3 = asVar;
                final c cVar2 = cVar;
                cVar.kaZ.iWn.a(new f(this) {
                    final /* synthetic */ g kbn;

                    public final void b(b bVar, long j) {
                        if (asVar3 != null && asVar3.jUe != null && asVar3.jUe.jEn != null) {
                            int aPi = (int) bVar.aPi();
                            asVar3.jUe.jEn.n(j, be.Nj());
                            asVar3.jUe.jEn.s(j, aPi);
                            asVar3.jUe.jEn.m(j, j);
                            cVar2.kaZ.iWn.a(null);
                        }
                    }
                });
            }
        }
        cVar.kaZ.a(com_tencent_mm_protocal_c_azr, i, avVar.jFt, avVar.jEb);
        cVar.kaZ.jzt.setVisibility(8);
        com.tencent.mm.plugin.sns.e.g aSB = ad.aSB();
        if (com_tencent_mm_protocal_c_azr.mWq == null || com_tencent_mm_protocal_c_azr.mWq.mom.size() <= 0) {
            Object obj = cVar.kaZ.iWn;
            aSB.a(obj, "", -1, this.pP.hashCode());
            obj.s(null);
            obj.ag(null, false);
            return;
        }
        int width;
        Pair create;
        int intValue;
        LayoutParams layoutParams;
        a aVar;
        int hashCode;
        com.tencent.mm.storage.ak bvR;
        boolean z;
        long nanoTime = System.nanoTime() - System.nanoTime();
        v.i("MicroMsg.VideoTimeLineItem", "isMediaSightExist %b duration %s", new Object[]{Boolean.valueOf(com.tencent.mm.plugin.sns.e.g.v(com_tencent_mm_protocal_c_aib)), Long.valueOf(nanoTime)});
        if (com.tencent.mm.plugin.sns.e.g.v(com_tencent_mm_protocal_c_aib)) {
            if (aSB.w(com_tencent_mm_protocal_c_aib)) {
                cVar.kaZ.jzs.setVisibility(0);
                cVar.kaZ.jzr.setVisibility(8);
                cVar.kaZ.jzs.setImageDrawable(com.tencent.mm.bd.a.a(this.pP, 2131165914));
                cVar.kaZ.jzs.setContentDescription(this.pP.getString(2131234179));
            } else if (aSB.x(com_tencent_mm_protocal_c_aib)) {
                cVar.kaZ.jzs.setVisibility(8);
                cVar.kaZ.jzr.setVisibility(8);
            } else if (!avVar.jEb || aSB.b(Bp, null) > 5) {
                aSB.z(com_tencent_mm_protocal_c_aib);
                cVar.kaZ.jzs.setVisibility(0);
                cVar.kaZ.jzr.setVisibility(8);
                cVar.kaZ.jzs.setImageDrawable(com.tencent.mm.bd.a.a(this.pP, 2131165914));
                cVar.kaZ.jzs.setContentDescription(this.pP.getString(2131234179));
            } else {
                cVar.kaZ.jzs.setVisibility(8);
                cVar.kaZ.jzr.setVisibility(8);
            }
            if (cVar.kaZ.iWn.aPa()) {
                v.d("MicroMsg.VideoTimeLineItem", "play video error " + com_tencent_mm_protocal_c_aib.gID + " " + com_tencent_mm_protocal_c_aib.glb + " " + com_tencent_mm_protocal_c_aib.mHP + " " + i);
                aSB.z(com_tencent_mm_protocal_c_aib);
                cVar.kaZ.jzs.setVisibility(0);
                cVar.kaZ.jzr.setVisibility(8);
                cVar.kaZ.jzs.setImageDrawable(com.tencent.mm.bd.a.a(this.pP, 2131165914));
                cVar.kaZ.jzs.setContentDescription(this.pP.getString(2131234179));
            }
        } else if (aSB.y(com_tencent_mm_protocal_c_aib)) {
            cVar.kaZ.jzs.setVisibility(8);
            cVar.kaZ.jzr.setVisibility(0);
            cVar.kaZ.jzr.bKj();
        } else if (avVar.jEb && aSB.b(Bp, null) == 5) {
            aSB.B(com_tencent_mm_protocal_c_aib);
            cVar.kaZ.jzs.setVisibility(8);
            cVar.kaZ.jzr.setVisibility(0);
            cVar.kaZ.jzr.bKj();
        } else {
            obj = (aSB.jjf.containsKey(com_tencent_mm_protocal_c_aib.gID) && ((Integer) aSB.jjf.get(com_tencent_mm_protocal_c_aib.gID)).intValue() == 4) ? 1 : null;
            if (obj != null) {
                cVar.kaZ.jzr.setVisibility(8);
                cVar.kaZ.jzs.setImageResource(2130839161);
                cVar.kaZ.jzs.setVisibility(0);
            } else {
                aSB.z(com_tencent_mm_protocal_c_aib);
                cVar.kaZ.jzs.setVisibility(0);
                cVar.kaZ.jzr.setVisibility(8);
                cVar.kaZ.jzs.setImageDrawable(com.tencent.mm.bd.a.a(this.pP, 2131165914));
                cVar.kaZ.jzs.setContentDescription(this.pP.getString(2131234179));
                if (!avVar.jEb && aSB.a(Bp, null) == 4) {
                    cVar.kaZ.jzt.setVisibility(0);
                } else if (avVar.jEb && aSB.b(Bp, null) == 4) {
                    cVar.kaZ.jzt.setVisibility(0);
                }
            }
        }
        Pair a = d.a(cVar.kba, cVar.kaZ.iWn.aOZ(), avVar.jEb);
        if (avVar.jEb) {
            com.tencent.mm.plugin.sns.storage.b aUm = avVar.jaC.aUm();
            if (aUm != null && aUm.juP > 0.0f && aUm.juQ > 0.0f) {
                float a2 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.a((double) aUm.juP, 1, aUm.juR, aUm.juS);
                float a3 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.a((double) aUm.juQ, 1, aUm.juR, aUm.juS);
                width = ((WindowManager) this.pP.getSystemService("window")).getDefaultDisplay().getWidth();
                if (aUm.juO == 0) {
                    float fromDPToPix;
                    if (a2 >= ((float) (((width - com.tencent.mm.bd.a.fromDPToPix(this.pP, 50)) - com.tencent.mm.bd.a.fromDPToPix(this.pP, 12)) - com.tencent.mm.bd.a.fromDPToPix(this.pP, 12)))) {
                        fromDPToPix = (float) (((width - com.tencent.mm.bd.a.fromDPToPix(this.pP, 50)) - com.tencent.mm.bd.a.fromDPToPix(this.pP, 12)) - com.tencent.mm.bd.a.fromDPToPix(this.pP, 12));
                        a2 = (float) ((int) ((aUm.juQ * fromDPToPix) / aUm.juP));
                    } else {
                        fromDPToPix = a2;
                        a2 = a3;
                    }
                    create = Pair.create(Integer.valueOf((int) fromDPToPix), Integer.valueOf((int) a2));
                } else if (aUm.juO == 1) {
                    r4 = (((width - com.tencent.mm.bd.a.fromDPToPix(this.pP, 50)) - com.tencent.mm.bd.a.fromDPToPix(this.pP, 50)) - com.tencent.mm.bd.a.fromDPToPix(this.pP, 12)) - com.tencent.mm.bd.a.fromDPToPix(this.pP, 12);
                    r3 = Pair.create(Integer.valueOf(r4), Integer.valueOf((int) ((((float) r4) * aUm.juQ) / aUm.juP)));
                    cVar.kah.setLayoutParams(new LinearLayout.LayoutParams(r4, -2));
                    create = r3;
                } else if (aUm.juO == 2) {
                    r4 = ((width - com.tencent.mm.bd.a.fromDPToPix(this.pP, 50)) - com.tencent.mm.bd.a.fromDPToPix(this.pP, 12)) - com.tencent.mm.bd.a.fromDPToPix(this.pP, 12);
                    r3 = Pair.create(Integer.valueOf(r4), Integer.valueOf((int) ((((float) r4) * aUm.juQ) / aUm.juP)));
                    cVar.kah.setLayoutParams(new LinearLayout.LayoutParams(r4, -2));
                    create = r3;
                }
                intValue = ((Integer) create.first).intValue();
                width = ((Integer) create.second).intValue();
                cVar.kaZ.iWn.co(intValue, width);
                layoutParams = cVar.kaZ.jKn.getLayoutParams();
                layoutParams.width = intValue;
                layoutParams.height = width;
                cVar.kaZ.jKn.setLayoutParams(layoutParams);
                cVar.kaZ.iWn.aU(cVar.kaZ);
                aVar = cVar.kaZ.iWn;
                hashCode = this.pP.hashCode();
                bvR = com.tencent.mm.storage.ak.bvR();
                bvR.hrm = com_tencent_mm_protocal_c_azr.hNS;
                aSB.a(Bp, com_tencent_mm_protocal_c_aib, aVar, hashCode, i, bvR, avVar.jEb);
                cVar.kaZ.jKm.setTag(cVar.kaZ);
                if (FileOp.aR(al.cA(ad.xh(), com_tencent_mm_protocal_c_aib.gID) + i.i(com_tencent_mm_protocal_c_aib))) {
                    asVar.jUe.jEn.c(avVar.jWv, 0, false);
                } else {
                    asVar.jUe.jEn.c(avVar.jWv, 0, true);
                }
                z = avVar.jEb ? ad.aSB().b(Bp, null) != 5 : ad.aSB().a(Bp, null) != 5;
                asVar.jUe.jEn.j(avVar.jWv, z);
            }
        }
        create = a;
        intValue = ((Integer) create.first).intValue();
        width = ((Integer) create.second).intValue();
        cVar.kaZ.iWn.co(intValue, width);
        layoutParams = cVar.kaZ.jKn.getLayoutParams();
        layoutParams.width = intValue;
        layoutParams.height = width;
        cVar.kaZ.jKn.setLayoutParams(layoutParams);
        cVar.kaZ.iWn.aU(cVar.kaZ);
        aVar = cVar.kaZ.iWn;
        hashCode = this.pP.hashCode();
        bvR = com.tencent.mm.storage.ak.bvR();
        bvR.hrm = com_tencent_mm_protocal_c_azr.hNS;
        aSB.a(Bp, com_tencent_mm_protocal_c_aib, aVar, hashCode, i, bvR, avVar.jEb);
        cVar.kaZ.jKm.setTag(cVar.kaZ);
        if (FileOp.aR(al.cA(ad.xh(), com_tencent_mm_protocal_c_aib.gID) + i.i(com_tencent_mm_protocal_c_aib))) {
            asVar.jUe.jEn.c(avVar.jWv, 0, false);
        } else {
            asVar.jUe.jEn.c(avVar.jWv, 0, true);
        }
        if (avVar.jEb) {
            if (ad.aSB().b(Bp, null) != 5) {
            }
        }
        asVar.jUe.jEn.j(avVar.jWv, z);
    }
}
