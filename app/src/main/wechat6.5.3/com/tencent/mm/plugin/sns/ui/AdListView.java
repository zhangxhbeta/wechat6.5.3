package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ListView;
import com.tencent.mm.modelstat.o.a;
import com.tencent.mm.platformtools.q;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.sight.decode.ui.SightPlayImageView;
import com.tencent.mm.plugin.sns.a.a.b;
import com.tencent.mm.plugin.sns.a.a.j;
import com.tencent.mm.plugin.sns.e.ad;
import com.tencent.mm.plugin.sns.e.e;
import com.tencent.mm.plugin.sns.e.f;
import com.tencent.mm.plugin.sns.i.d;
import com.tencent.mm.plugin.sns.ui.a.a.c;
import com.tencent.mm.protocal.c.axz;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.util.HashSet;

public class AdListView extends ListView {
    b jCY;
    f jCZ;
    e jDa;
    private boolean jDb = true;
    private HashSet<String> jDc = new HashSet();

    public AdListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public AdListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void layoutChildren() {
        super.layoutChildren();
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    protected void detachViewFromParent(View view) {
        String str = "";
        if (view.getTag() != null && (view.getTag() instanceof c)) {
            c cVar = (c) view.getTag();
            str = cVar.position + " " + cVar.bap;
        }
        if (q.dqK) {
            v.d("MicroMsg.AdListView", "1childview  onRemoved " + str + " count:" + getChildCount());
        }
        super.detachViewFromParent(view);
    }

    protected void detachViewFromParent(int i) {
        if (q.dqK) {
            v.d("MicroMsg.AdListView", "2childview  onRemoved " + i + " count:" + getChildCount());
        }
        super.detachViewFromParent(i);
    }

    protected void attachViewToParent(View view, int i, LayoutParams layoutParams) {
        super.attachViewToParent(view, i, layoutParams);
        String str = "";
        if (view.getTag() != null && (view.getTag() instanceof c)) {
            c cVar = (c) view.getTag();
            String str2 = cVar.position + " " + cVar.bap;
            d.jtP.Bb(cVar.kba.gID);
            if (this.jCY != null && cVar.jdE) {
                this.jCY.a(cVar.position, cVar.bap, cVar.jbF, cVar.ghH, view, cVar.kab, cVar.jdF, cVar.jbw, cVar.eKg);
            }
            if (!this.jDc.contains(cVar.boC) && ((cVar.jdE && cVar.kba.mWq.mol == 15) || cVar.kba.mWq.mol == 18)) {
                boolean z = false;
                if (cVar.kba.mWq.mol == 15 && (cVar.kaZ.iWn instanceof SightPlayImageView)) {
                    z = ((SightPlayImageView) cVar.kaZ.iWn).iUW.aPe();
                }
                j.a(ad.aSE().Bp(cVar.boC), false, z);
                this.jDc.add(cVar.boC);
            }
            if (this.jCZ != null) {
                this.jCZ.a(cVar.bap, cVar.kba);
            }
            if (this.jDa != null) {
                this.jDa.a(cVar.position, cVar.bap, cVar.kab, cVar.jbF, cVar.kba, cVar.jdE, cVar.jdF);
            }
            str = str2;
        }
        if (q.dqK) {
            v.d("MicroMsg.AdListView", "3childview  onAdded " + str + " count:" + getChildCount());
        }
    }

    public void onViewAdded(View view) {
        String str = "";
        if (view.getTag() != null && (view.getTag() instanceof c)) {
            c cVar = (c) view.getTag();
            String str2 = cVar.position + " " + cVar.bap;
            d.jtP.Bb(cVar.kba.gID);
            if (this.jCY != null && cVar.jdE) {
                this.jCY.a(cVar.position, cVar.bap, cVar.jbF, cVar.ghH, view, cVar.kab, cVar.jdF, cVar.jbw, cVar.eKg);
            }
            if (!this.jDc.contains(cVar.boC) && ((cVar.jdE && cVar.kba.mWq.mol == 15) || cVar.kba.mWq.mol == 18)) {
                boolean z = false;
                if (cVar.kba.mWq.mol == 15 && (cVar.kaZ.iWn instanceof SightPlayImageView)) {
                    z = ((SightPlayImageView) cVar.kaZ.iWn).iUW.aPe();
                }
                j.a(ad.aSE().Bp(cVar.boC), false, z);
                this.jDc.add(cVar.boC);
            }
            if (this.jCZ != null) {
                this.jCZ.a(cVar.bap, cVar.kba);
            }
            if (this.jDa != null) {
                this.jDa.a(cVar.position, cVar.bap, cVar.kab, cVar.jbF, cVar.kba, cVar.jdE, cVar.jdF);
            }
            str = str2;
        }
        if (q.dqK) {
            v.d("MicroMsg.AdListView", "4childview  onViewAdded " + str + " count:" + getChildCount());
        }
    }

    public void onViewRemoved(View view) {
        String str = "";
        if (view.getTag() != null && (view.getTag() instanceof c)) {
            c cVar = (c) view.getTag();
            String str2 = cVar.position + " " + cVar.bap;
            if (this.jCY != null && cVar.jdE) {
                this.jCY.u(cVar.position, cVar.bap, cVar.jbF);
            }
            if (this.jCZ != null) {
                this.jCZ.Ah(cVar.bap);
            }
            if (this.jDa != null) {
                this.jDa.a(cVar.position, cVar.bap, cVar.kab, cVar.jbF, cVar.kba, cVar.jdE);
            }
            if (cVar.kba.mWq.mol == 3) {
                a aVar = a.ddJ;
                str = cVar.kba.jGu;
                if (!be.kS(str)) {
                    byte[] decode = Base64.decode(str, 0);
                    axz com_tencent_mm_protocal_c_axz = new axz();
                    try {
                        com_tencent_mm_protocal_c_axz.az(decode);
                        if (com_tencent_mm_protocal_c_axz.mVt == null) {
                            str = str2;
                        } else {
                            v.i("MicroMsg.SnsStatExtUtil", "report adPageExposure(13235): scene(%d), statExtStr:%s(id=%s, uxinfo=%s)", new Object[]{Integer.valueOf(aVar.value), str, com_tencent_mm_protocal_c_axz.mVt.mVw, com_tencent_mm_protocal_c_axz.mVt.mVx});
                            g.iuh.h(13235, new Object[]{aVar.value, com_tencent_mm_protocal_c_axz.mVt.mVw, com_tencent_mm_protocal_c_axz.mVt.mVx});
                        }
                    } catch (Throwable e) {
                        v.a("MicroMsg.SnsStatExtUtil", e, "", new Object[0]);
                        str = str2;
                    }
                }
            }
            str = str2;
        }
        if (q.dqK) {
            v.d("MicroMsg.AdListView", "5childview  onViewRemoved " + str + " count:" + getChildCount());
        }
    }

    public void removeViewInLayout(View view) {
        String str = "";
        if (view.getTag() != null && (view.getTag() instanceof c)) {
            c cVar = (c) view.getTag();
            str = cVar.position + " " + cVar.bap;
        }
        if (q.dqK) {
            v.d("MicroMsg.AdListView", "6removeViewInLayout  onViewRemoved " + str + " count:" + getChildCount());
        }
        super.removeViewInLayout(view);
    }

    public void removeView(View view) {
        super.removeView(view);
        String str = "";
        if (view.getTag() != null && (view.getTag() instanceof c)) {
            c cVar = (c) view.getTag();
            str = cVar.position + " " + cVar.bap;
        }
        if (q.dqK) {
            v.d("MicroMsg.AdListView", "7removeView  onViewRemoved " + str + " count:" + getChildCount());
        }
    }

    protected void detachViewsFromParent(int i, int i2) {
        for (int i3 = i; i3 < i + i2; i3++) {
            View childAt = getChildAt(i3);
            String str = "";
            if (childAt.getTag() != null && (childAt.getTag() instanceof c)) {
                c cVar = (c) childAt.getTag();
                if (this.jCY != null && cVar.jdE) {
                    this.jCY.u(cVar.position, cVar.bap, cVar.jbF);
                }
                if (this.jCZ != null) {
                    this.jCZ.Ah(cVar.bap);
                }
                if (this.jDa != null) {
                    this.jDa.a(cVar.position, cVar.bap, cVar.kab, cVar.jbF, cVar.kba, cVar.jdE);
                }
                str = cVar.position + " " + cVar.bap;
            }
            if (q.dqK) {
                v.d("MicroMsg.AdListView", "8removeView  detachViewsFromParent " + str + " count:" + getChildCount());
            }
        }
        super.detachViewsFromParent(i, i2);
    }
}
