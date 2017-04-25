package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import com.tencent.mm.plugin.sns.e.ad;
import com.tencent.mm.protocal.c.aib;
import com.tencent.mm.protocal.c.aid;
import com.tencent.mm.protocal.c.azr;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ak;
import com.tencent.mm.ui.widget.QFadeImageView;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class ao {
    public static int[] jQE = new int[]{0, 0, 1, 3, 6, 9};
    public static int[] jQF = new int[]{2131759363};
    public static int[] jQG = new int[]{2131759363, 2131759480, 2131759481};
    public static int[] jQH = new int[]{2131759363, 2131759480, 2131759481, 2131759482, 2131759483, 2131759484};
    public static int[] jQI = new int[]{2131759363, 2131759480, 2131759481, 2131759482, 2131759483, 2131759484, 2131759485, 2131759486, 2131759487};
    static double jQJ = -1.0d;
    static double jQK = -1.0d;
    static double jQL = -1.0d;
    static double jQM = -1.0d;
    static double jQN = -1.0d;
    private Context context;
    private LinkedList<LinearLayout> jQO = new LinkedList();

    public ao(Context context) {
        this.context = context;
    }

    public ao(Context context, byte b) {
        this.context = context;
    }

    public final void a(PhotosContent photosContent, azr com_tencent_mm_protocal_c_azr, String str, int i, int i2, int i3, boolean z, ak akVar, boolean z2) {
        int[] iArr = jQI;
        if (i2 == 2 || i2 == 11) {
            iArr = jQF;
        } else if (i2 == 3) {
            iArr = jQG;
        } else if (i2 == 4) {
            iArr = jQH;
        } else if (i2 == 5) {
            iArr = jQI;
        }
        List list = com_tencent_mm_protocal_c_azr.mWq.mom;
        if (jQJ < 0.0d) {
            jQJ = (double) b.a(this.context, 160.0f);
            jQK = (double) b.a(this.context, 200.0f);
            jQL = (double) b.a(this.context, 44.0f);
            jQM = (double) b.a(this.context, 66.0f);
            jQN = (double) b.a(this.context, 300.0f);
        }
        int size = list.size();
        if (size == 0) {
            for (size = 0; size < iArr.length; size++) {
                ad.aSB().ca(photosContent.qQ(size));
                photosContent.qQ(size).position = i3;
            }
            photosContent.setVisibility(8);
            return;
        }
        photosContent.setVisibility(0);
        if (size == 1) {
            for (size = 1; size < iArr.length; size++) {
                QFadeImageView qQ = photosContent.qQ(size);
                qQ.setVisibility(8);
                ad.aSB().ca(qQ);
                photosContent.qQ(size).position = i3;
            }
            photosContent.qQ(0).setVisibility(0);
            a((aib) list.get(0), photosContent.qQ(0), str, i, i3, z, akVar, i2, z2);
        }
    }

    public final void a(PhotosContent photosContent, azr com_tencent_mm_protocal_c_azr, String str, int i, int i2, int i3, boolean z, ak akVar, List<aid> list) {
        int[] iArr = jQI;
        if (i2 == 2 || i2 == 11) {
            iArr = jQF;
        } else if (i2 == 3) {
            iArr = jQG;
        } else if (i2 == 4) {
            iArr = jQH;
        } else if (i2 == 5) {
            iArr = jQI;
        }
        List list2 = com_tencent_mm_protocal_c_azr.mWq.mom;
        if (jQJ < 0.0d) {
            jQJ = (double) b.a(this.context, 160.0f);
            jQK = (double) b.a(this.context, 200.0f);
            jQL = (double) b.a(this.context, 44.0f);
            jQM = (double) b.a(this.context, 66.0f);
            jQN = (double) b.a(this.context, 300.0f);
        }
        int size = list2.size();
        if (size == 0) {
            for (size = 0; size < iArr.length; size++) {
                ad.aSB().ca(photosContent.qQ(size));
                photosContent.qQ(size).position = i3;
            }
            photosContent.setVisibility(8);
            return;
        }
        photosContent.qP(ad.aSK());
        photosContent.setVisibility(0);
        if (size == 1) {
            for (size = 1; size < iArr.length; size++) {
                QFadeImageView qQ = photosContent.qQ(size);
                qQ.setVisibility(8);
                ad.aSB().ca(qQ);
                photosContent.qQ(size).position = i3;
            }
            photosContent.qQ(0).setVisibility(0);
            if (list == null || list.size() <= 0) {
                a((aib) list2.get(0), photosContent.qQ(0), str, i, i3, z, akVar, i2, false);
                return;
            }
            a((aib) list2.get(0), photosContent.qQ(0), str, i, i3, z, akVar, i2, false, (aid) list.get(0));
        } else if (size == 4) {
            List arrayList = new ArrayList();
            int length = iArr.length - 1;
            int i4 = 3;
            while (length >= 0) {
                QFadeImageView qQ2 = photosContent.qQ(length);
                qQ2.position = i3;
                if (length == 0 || length == 1 || length == 3 || length == 4) {
                    qQ2.setVisibility(0);
                    arrayList.add(qQ2);
                    am amVar = new am();
                    amVar.bde = str;
                    size = i4 - 1;
                    amVar.index = i4;
                    amVar.jOH = arrayList;
                    amVar.jMd = z;
                    amVar.position = i3;
                    qQ2.setTag(amVar);
                    a((aib) list2.get(amVar.index), qQ2, i, akVar);
                    i4 = size;
                } else {
                    qQ2.setVisibility(8);
                    ad.aSB().ca(qQ2);
                }
                length--;
            }
        } else {
            List arrayList2 = new ArrayList();
            for (size = iArr.length - 1; size >= 0; size--) {
                QFadeImageView qQ3 = photosContent.qQ(size);
                qQ3.position = i3;
                if (size < list2.size()) {
                    qQ3.setVisibility(0);
                    arrayList2.add(qQ3);
                    am amVar2 = new am();
                    amVar2.bde = str;
                    amVar2.index = size;
                    amVar2.jOH = arrayList2;
                    amVar2.jMd = z;
                    amVar2.position = i3;
                    qQ3.setTag(amVar2);
                    a((aib) list2.get(amVar2.index), qQ3, i, akVar);
                } else {
                    qQ3.setVisibility(8);
                    ad.aSB().ca(qQ3);
                }
            }
        }
    }

    private static void a(aib com_tencent_mm_protocal_c_aib, QFadeImageView qFadeImageView, int i, ak akVar) {
        ad.aSB().b(com_tencent_mm_protocal_c_aib, qFadeImageView, i, akVar);
    }

    private static void a(aib com_tencent_mm_protocal_c_aib, QFadeImageView qFadeImageView, String str, int i, int i2, boolean z, ak akVar, int i3, boolean z2, aid com_tencent_mm_protocal_c_aid) {
        if (qFadeImageView == null) {
            v.e("MicroMsg.SnsMultiLineImageLineMgr", "");
            return;
        }
        double min;
        am amVar = new am();
        amVar.bde = str;
        amVar.index = 0;
        List arrayList = new ArrayList();
        arrayList.add(qFadeImageView);
        amVar.jOH = arrayList;
        amVar.jMd = z;
        amVar.position = i2;
        qFadeImageView.setTag(amVar);
        double d = 0.0d;
        double d2 = 0.0d;
        if (i3 == 11 && z2) {
            ad.aSB().d(com_tencent_mm_protocal_c_aib, qFadeImageView, i, akVar);
        } else {
            ad.aSB().c(com_tencent_mm_protocal_c_aib, qFadeImageView, i, akVar);
        }
        if (com_tencent_mm_protocal_c_aib.mHS != null) {
            d = (double) com_tencent_mm_protocal_c_aib.mHS.mID;
            d2 = (double) com_tencent_mm_protocal_c_aib.mHS.lHK;
        }
        if (d <= 0.0d || d2 <= 0.0d) {
            d = jQJ;
            d2 = jQJ;
        } else {
            min = Math.min(jQK / d, jQK / d2);
            d *= min;
            d2 *= min;
            if (d < jQL) {
                min = (1.0d * jQL) / d;
                d *= min;
                d2 *= min;
            }
            if (d2 < jQL) {
                min = (1.0d * jQL) / d2;
                d *= min;
                d2 *= min;
            }
            if (d > jQK) {
                d = jQK;
            }
            if (d2 > jQK) {
                d2 = jQK;
            }
        }
        if (d < 1.0d) {
            d = 1.0d;
        }
        if (d2 < 1.0d) {
            d2 = 1.0d;
        }
        if (com_tencent_mm_protocal_c_aid == null || com_tencent_mm_protocal_c_aid.mID <= 0.0f || com_tencent_mm_protocal_c_aid.lHK <= 0.0f) {
            min = d;
            d = d2;
        } else {
            min = (double) com_tencent_mm_protocal_c_aid.mID;
            d = (double) com_tencent_mm_protocal_c_aid.lHK;
        }
        if (qFadeImageView.getLayoutParams() instanceof LayoutParams) {
            LayoutParams layoutParams = (LayoutParams) qFadeImageView.getLayoutParams();
            if (((double) layoutParams.width) != min || ((double) layoutParams.height) != d) {
                qFadeImageView.setLayoutParams(new LayoutParams((int) min, (int) d));
            }
        }
    }

    private static void a(aib com_tencent_mm_protocal_c_aib, QFadeImageView qFadeImageView, String str, int i, int i2, boolean z, ak akVar, int i3, boolean z2) {
        a(com_tencent_mm_protocal_c_aib, qFadeImageView, str, i, i2, z, akVar, i3, z2, new aid());
    }
}
