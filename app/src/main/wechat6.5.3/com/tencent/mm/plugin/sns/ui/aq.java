package com.tencent.mm.plugin.sns.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.as.u;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.e.ad;
import com.tencent.mm.plugin.sns.e.ah;
import com.tencent.mm.plugin.sns.lucky.b.x;
import com.tencent.mm.plugin.sns.storage.k;
import com.tencent.mm.plugin.sns.storage.s;
import com.tencent.mm.protocal.c.aib;
import com.tencent.mm.protocal.c.ajr;
import com.tencent.mm.protocal.c.awa;
import com.tencent.mm.protocal.c.azr;
import com.tencent.mm.protocal.c.pu;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.ak;
import com.tencent.mm.ui.q;
import com.tencent.mm.ui.widget.QFadeImageView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@SuppressLint({"UseSparseArrays"})
public final class aq extends BaseAdapter {
    boolean bcR = false;
    private Activity bij;
    private String cJg;
    String fHQ = "";
    List<k> gKQ = new ArrayList();
    private String gRN = "";
    Map<Integer, Integer> jDl = new HashMap();
    Map<Integer, Integer> jDm = new HashMap();
    int jDn = 0;
    int jDo = 0;
    String jJv = "";
    private aa jMH = null;
    private ak jRJ;
    Map<Integer, Integer> jRK = new HashMap();
    private f jRL;
    boolean jRM = false;
    ar jRN;
    private c jRO;
    int jRP = Integer.MAX_VALUE;
    int jRQ = 0;
    int jRR = 0;
    protected OnClickListener jRS = new OnClickListener(this) {
        final /* synthetic */ aq jRU;

        {
            this.jRU = r1;
        }

        public final void onClick(View view) {
            if (view.getTag() instanceof azr) {
                azr com_tencent_mm_protocal_c_azr = (azr) view.getTag();
                if (aq.Ce(com_tencent_mm_protocal_c_azr.gID)) {
                    g.iuh.Y(10231, "1");
                    com.tencent.mm.ai.b.HB();
                } else {
                    g.iuh.Y(10090, "1,0");
                    if (!(u.bj(this.jRU.bij) || com.tencent.mm.ah.a.aT(this.jRU.bij))) {
                        ajr a = com.tencent.mm.ai.b.a(ad.xq(), com_tencent_mm_protocal_c_azr, 8);
                        a.mKm = this.jRU.userName;
                        com.tencent.mm.ai.b.b(a);
                    }
                }
                this.jRU.notifyDataSetChanged();
            }
        }
    };
    private String userName = "";

    class a {
        LinearLayout jDC;
        View jDD;
        final /* synthetic */ aq jRU;
        View jRV;
        TextView jRW;
        TextView jRX;
        LinearLayout jRY;
        ImageView jRZ;
        TextView jSa;

        a(aq aqVar) {
            this.jRU = aqVar;
        }

        public void init() {
            this.jRW.setVisibility(8);
            this.jRX.setVisibility(8);
            this.jRY.setVisibility(4);
            this.jRZ.setVisibility(4);
            this.jDD.setVisibility(8);
            this.jSa.setVisibility(8);
        }
    }

    public interface c {
    }

    static abstract class f {
        OnClickListener jDt = new OnClickListener(this) {
            final /* synthetic */ f jSy;

            {
                this.jSy = r1;
            }

            public final void onClick(View view) {
                if (view.getTag() != null) {
                    this.jSy.jSx = (a) view.getTag();
                    this.jSy.cz(this.jSy.jSx.jdV, this.jSy.jSx.position);
                }
            }
        };
        OnClickListener jDu = new OnClickListener(this) {
            final /* synthetic */ f jSy;

            {
                this.jSy = r1;
            }

            public final void onClick(View view) {
                if (view.getTag() != null) {
                    this.jSy.jSx = (a) view.getTag();
                    this.jSy.cz(this.jSy.jSx.jdV, this.jSy.jSx.position + 1);
                }
            }
        };
        OnClickListener jDv = new OnClickListener(this) {
            final /* synthetic */ f jSy;

            {
                this.jSy = r1;
            }

            public final void onClick(View view) {
                if (view.getTag() != null) {
                    this.jSy.jSx = (a) view.getTag();
                    this.jSy.cz(this.jSy.jSx.jdV, this.jSy.jSx.position + 2);
                }
            }
        };
        OnClickListener jSu = new OnClickListener(this) {
            final /* synthetic */ f jSy;

            {
                this.jSy = r1;
            }

            public final void onClick(View view) {
                if (view.getTag() != null) {
                    v.d("MicroMsg.SnsphotoAdapter", "sign click");
                    this.jSy.jSx = (a) view.getTag();
                    this.jSy.cA(this.jSy.jSx.jdV, this.jSy.jSx.position + 2);
                }
            }
        };
        OnClickListener jSv = new OnClickListener(this) {
            final /* synthetic */ f jSy;

            {
                this.jSy = r1;
            }

            public final void onClick(View view) {
                if (view.getTag() != null) {
                    v.d("MicroMsg.SnsphotoAdapter", "sign click");
                    this.jSy.jSx = (a) view.getTag();
                    this.jSy.rc(this.jSy.jSx.jdV);
                }
            }
        };
        OnClickListener jSw = new OnClickListener(this) {
            final /* synthetic */ f jSy;

            {
                this.jSy = r1;
            }

            public final void onClick(View view) {
                if (view.getTag() != null) {
                    v.d("MicroMsg.SnsphotoAdapter", "snssight click");
                    this.jSy.jSx = (a) view.getTag();
                    this.jSy.cA(this.jSy.jSx.jdV, this.jSy.jSx.position + 2);
                }
            }
        };
        public a jSx = new a();

        public static class a {
            public int jdV;
            public int position;
        }

        public abstract void cA(int i, int i2);

        public abstract void cz(int i, int i2);

        public abstract void rc(int i);
    }

    class b extends a {
        TextView dtB;
        TextView emb;
        ImageView jEe;
        final /* synthetic */ aq jRU;
        TagImageView jSb;
        TextView jSc;
        View jSd;

        b(aq aqVar) {
            this.jRU = aqVar;
            super(aqVar);
        }

        public final void init() {
            super.init();
            this.emb.setVisibility(8);
            this.jSb.setVisibility(8);
            this.jEe.setVisibility(8);
            this.dtB.setVisibility(8);
            this.jSc.setVisibility(8);
        }
    }

    class d extends a {
        TextView gtw;
        final /* synthetic */ aq jRU;
        MaskImageView jSe;
        QFadeImageView jSf;
        QFadeImageView jSg;
        QFadeImageView jSh;
        TextView jSi;
        TextView jSj;
        TextView jSk;
        TextView jSl;
        View jSm;
        TextView jSn;
        TextView jSo;
        TextView jSp;
        TextView jSq;
        TextView jSr;
        TextView jSs;
        MaskLinearLayout jSt;

        d(aq aqVar) {
            this.jRU = aqVar;
            super(aqVar);
        }

        public final void init() {
            super.init();
            this.jSe.setVisibility(8);
            this.jSg.setVisibility(8);
            this.jSh.setVisibility(8);
            this.gtw.setVisibility(8);
            this.jSi.setVisibility(8);
            this.jSj.setVisibility(8);
            this.jSk.setVisibility(8);
            this.jSl.setVisibility(8);
            this.jSm.setVisibility(8);
            this.jSf.setVisibility(8);
            this.jSn.setVisibility(8);
            this.jSo.setVisibility(8);
            this.jSp.setVisibility(8);
            this.jSq.setVisibility(8);
            this.jSr.setVisibility(8);
            this.jSs.setVisibility(8);
            if (com.tencent.mm.ui.u.ds(this.jRU.bij) > 1.0f) {
                this.gtw.setMaxLines(2);
            }
        }
    }

    class e extends a {
        TextView gtw;
        final /* synthetic */ aq jRU;
        MaskImageView jSe;
        View jSm;
        TextView jSn;
        MaskLinearLayout jSt;

        e(aq aqVar) {
            this.jRU = aqVar;
            super(aqVar);
        }

        public final void init() {
            super.init();
            this.jSe.setVisibility(8);
            this.gtw.setVisibility(8);
            this.jSn.setVisibility(8);
            this.jSm.setVisibility(8);
            if (com.tencent.mm.ui.u.ds(this.jRU.bij) > 1.0f) {
                this.gtw.setMaxLines(2);
            }
        }
    }

    public aq(Activity activity, f fVar, String str, final c cVar) {
        this.userName = str;
        this.bij = activity;
        this.jRL = fVar;
        this.jRO = cVar;
        this.jMH = ad.aSs();
        String d = com.tencent.mm.sdk.platformtools.u.d(this.bij.getSharedPreferences(com.tencent.mm.sdk.platformtools.aa.bti(), 0));
        v.d("MicroMsg.SnsphotoAdapter", "filterLan temp " + d);
        if (!(d.equals("zh_CN") || d.equals("en") || d.equals("zh_TW"))) {
            d = d.equals("zh_HK") ? "zh_TW" : "en";
        }
        this.gRN = d;
        this.cJg = com.tencent.mm.sdk.platformtools.u.d(this.bij.getSharedPreferences(com.tencent.mm.sdk.platformtools.aa.bti(), 0));
        com.tencent.mm.model.ak.yW();
        if (this.userName.equals((String) com.tencent.mm.model.c.vf().get(2, null))) {
            this.bcR = true;
        }
        v.d("MicroMsg.SnsphotoAdapter", "SnsphotoAdapter : userName : " + this.userName + " country: " + this.cJg);
        if (this.bcR) {
            this.jRJ = ak.bvT();
        } else {
            com.tencent.mm.model.ak.yW();
            com.tencent.mm.storage.u LX = com.tencent.mm.model.c.wH().LX(str);
            if (LX == null || !com.tencent.mm.i.a.ei(LX.field_type)) {
                this.jRJ = ak.bvU();
            } else {
                this.jRJ = ak.bvS();
            }
        }
        this.jRN = new ar(new com.tencent.mm.plugin.sns.ui.ar.b(this) {
            final /* synthetic */ aq jRU;

            public final void a(List<k> list, Map<Integer, Integer> map, Map<Integer, Integer> map2, Map<Integer, Integer> map3, int i, int i2) {
                v.d("MicroMsg.SnsphotoAdapter", "onFinishFixPos");
                aq aqVar = this.jRU;
                v.d("MicroMsg.SnsphotoAdapter", "setSnsList the thread id is " + Thread.currentThread().getId());
                if (list != null && list.size() > 0) {
                    int i3;
                    v.d("MicroMsg.SnsphotoAdapter", "copy list info");
                    int size = list.size();
                    aqVar.gKQ.clear();
                    aqVar.jDl.clear();
                    aqVar.jDm.clear();
                    aqVar.jRK.clear();
                    for (i3 = 0; i3 < size; i3++) {
                        aqVar.gKQ.add(k.x((k) list.get(i3)));
                    }
                    for (Integer intValue : map.keySet()) {
                        size = intValue.intValue();
                        aqVar.jDl.put(Integer.valueOf(size), Integer.valueOf(((Integer) map.get(Integer.valueOf(size))).intValue()));
                    }
                    for (Integer intValue2 : map2.keySet()) {
                        size = intValue2.intValue();
                        aqVar.jDm.put(Integer.valueOf(size), Integer.valueOf(((Integer) map2.get(Integer.valueOf(size))).intValue()));
                    }
                    for (Integer intValue22 : map3.keySet()) {
                        size = intValue22.intValue();
                        aqVar.jRK.put(Integer.valueOf(size), Integer.valueOf(((Integer) map3.get(Integer.valueOf(size))).intValue()));
                    }
                    map.clear();
                    map2.clear();
                    if (aqVar.bcR) {
                        i3 = aqVar.gKQ.size() <= 1 ? Integer.MAX_VALUE : ((k) aqVar.gKQ.get(1)).field_head;
                    } else {
                        i3 = aqVar.gKQ.isEmpty() ? Integer.MAX_VALUE : ((k) aqVar.gKQ.get(0)).field_head;
                    }
                    aqVar.jRP = 0;
                    size = 0;
                    while (size < aqVar.gKQ.size()) {
                        if (!aqVar.bcR || size != 0) {
                            if (i3 != ((k) aqVar.gKQ.get(size)).field_head) {
                                break;
                            }
                            aqVar.jRP = Math.max(aqVar.jRP, ((k) aqVar.gKQ.get(size)).field_createTime);
                        }
                        size++;
                    }
                    if (aqVar.gKQ.isEmpty() || (aqVar.bcR && aqVar.gKQ.size() == 1)) {
                        aqVar.jRP = Integer.MAX_VALUE;
                    }
                    i3 = aqVar.gKQ.isEmpty() ? 0 : ((k) aqVar.gKQ.get(aqVar.gKQ.size() - 1)).field_head;
                    aqVar.jRQ = Integer.MAX_VALUE;
                    int size2 = aqVar.gKQ.size() - 1;
                    while (size2 >= 0 && i3 != 0 && i3 == ((k) aqVar.gKQ.get(size2)).field_head) {
                        aqVar.jRQ = Math.min(aqVar.jRQ, ((k) aqVar.gKQ.get(size2)).field_createTime);
                        size2--;
                    }
                    if (aqVar.gKQ.isEmpty()) {
                        aqVar.jRQ = 0;
                    }
                    aqVar.jDo = i;
                    aqVar.jDn = i2;
                    v.d("MicroMsg.SnsphotoAdapter", "reallyCount " + i + " icount " + i2 + " stTime " + aqVar.jRP + " edTIme " + aqVar.jRQ);
                    aqVar.notifyDataSetChanged();
                }
            }

            public final void aXo() {
                this.jRU.notifyDataSetChanged();
            }
        }, str, this.bcR);
        dk(0);
        gv(false);
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        int itemViewType = getItemViewType(i);
        v.i("MicroMsg.SnsphotoAdapter", "position " + itemViewType);
        d dVar;
        int i2;
        k kVar;
        int i3;
        azr aUp;
        CharSequence charSequence;
        a aVar;
        a aVar2;
        if (itemViewType == 0) {
            if (view == null || view.getTag() == null || !(view.getTag() instanceof d)) {
                dVar = new d(this);
                view = q.em(this.bij).inflate(2130904484, null);
                dVar.jRX = (TextView) view.findViewById(2131759336);
                dVar.jRW = (TextView) view.findViewById(2131759337);
                dVar.jSe = (MaskImageView) view.findViewById(2131759285);
                dVar.jSf = (QFadeImageView) view.findViewById(2131759436);
                dVar.jSg = (MaskImageView) view.findViewById(2131759286);
                dVar.jSh = (MaskImageView) view.findViewById(2131759287);
                dVar.gtw = (TextView) view.findViewById(2131757325);
                dVar.jSi = (TextView) view.findViewById(2131759437);
                dVar.jSj = (TextView) view.findViewById(2131759442);
                dVar.jSk = (TextView) view.findViewById(2131759445);
                dVar.jSl = (TextView) view.findViewById(2131759440);
                dVar.jSm = view.findViewById(2131759439);
                dVar.jSa = (TextView) view.findViewById(2131755095);
                dVar.jRY = (LinearLayout) view.findViewById(2131759432);
                dVar.jRZ = (ImageView) view.findViewById(2131759433);
                dVar.jDC = (LinearLayout) view.findViewById(2131759282);
                dVar.jDD = view.findViewById(2131759281);
                dVar.jSf.setOnClickListener(this.jRL.jDt);
                dVar.jSe.setOnClickListener(this.jRL.jDt);
                dVar.jSg.setOnClickListener(this.jRL.jDu);
                dVar.jSh.setOnClickListener(this.jRL.jDv);
                dVar.jSn = (TextView) view.findViewById(2131759438);
                dVar.jSo = (TextView) view.findViewById(2131759443);
                dVar.jSp = (TextView) view.findViewById(2131759446);
                dVar.jSq = (TextView) view.findViewById(2131759435);
                dVar.jSr = (TextView) view.findViewById(2131759441);
                dVar.jSs = (TextView) view.findViewById(2131759444);
                dVar.jSt = (MaskLinearLayout) view.findViewById(2131759434);
                dVar.jSt.b(dVar.jSe);
                view.setTag(dVar);
            } else {
                dVar = (d) view.getTag();
            }
            ad.aSB().ca(dVar.jSe);
            ad.aSB().ca(dVar.jSg);
            ad.aSB().ca(dVar.jSh);
            i2 = -1;
            if (this.jDl.get(Integer.valueOf(i)) != null) {
                i2 = ((Integer) this.jDl.get(Integer.valueOf(i))).intValue();
            }
            dVar.init();
            dVar.jSt.aZw = false;
            dVar.jSt.setBackgroundResource(0);
            dVar.jSt.setDescendantFocusability(131072);
            dVar.jSt.setClickable(false);
            dVar.jSe.aZw = true;
            dVar.jSe.setClickable(true);
            dVar.jSt.setOnClickListener(null);
            if (i2 >= this.jDo || i2 == -1) {
                view.setLayoutParams(new LayoutParams(-1, 1));
                view.setVisibility(8);
            } else {
                if (i2 - 1 >= 0) {
                    kVar = (k) getItem(i2 - 1);
                    i3 = kVar.field_head;
                    ah.H(kVar.field_localPrivate, this.bcR);
                } else {
                    i3 = -1;
                }
                view.setLayoutParams(new LayoutParams(-1, -2));
                view.setVisibility(0);
                int intValue = this.jDm.get(Integer.valueOf(i)) != null ? ((Integer) this.jDm.get(Integer.valueOf(i))).intValue() : 1;
                k kVar2 = (k) getItem(i2);
                aUp = kVar2.aUp();
                if ((this.bcR && i == 0) || r4 == -1 || kVar2.field_head != r4) {
                    a(dVar.jRW, dVar.jRX, (long) kVar2.field_createTime);
                    if (aUp.mWo != null) {
                        charSequence = aUp.mWo.cHe;
                        if (!(charSequence == null || charSequence.equals(""))) {
                            dVar.jSa.setText(charSequence);
                            dVar.jSa.setVisibility(0);
                        }
                    }
                    dVar.jDD.setVisibility(0);
                }
                dVar.jRY.setVisibility(0);
                if (this.bcR && i == 0) {
                    dVar.jSf.setVisibility(0);
                    dVar.jSf.setContentDescription(this.bij.getString(2131235546));
                    dVar.jSe.setVisibility(8);
                    dVar.gtw.setText(this.jDn == 1 ? this.bij.getString(2131235578) : "");
                    dVar.gtw.setVisibility(0);
                    dVar.jSm.setVisibility(0);
                    dVar.jSl.setVisibility(8);
                    ad.aSB().a(dVar.jSf, 2131689675, 2130839236, this.bij.hashCode());
                    aVar = new a();
                    aVar.jdV = -1;
                    aVar.position = -1;
                    dVar.jSf.setTag(aVar);
                } else {
                    if (intValue > 0) {
                        a(i2, dVar.jSe, dVar.jSi, dVar.jSl, dVar.jSn, dVar.jSq, 1, dVar, i);
                    }
                    if (intValue >= 2) {
                        a(i2 + 1, dVar.jSg, dVar.jSj, dVar.jSl, dVar.jSo, dVar.jSr, 2, dVar, i);
                    }
                    if (intValue >= 3) {
                        a(i2 + 2, dVar.jSh, dVar.jSk, dVar.jSl, dVar.jSp, dVar.jSs, 3, dVar, i);
                    }
                    if (intValue == 1) {
                        kVar = (k) getItem(i2);
                        if (!be.kS(kVar.aUp().mWn) && kVar.field_type == 1) {
                            dVar.jSt.setDescendantFocusability(393216);
                            dVar.jSt.setClickable(true);
                            dVar.jSe.setClickable(false);
                            dVar.jSe.aZw = false;
                            dVar.jSt.setOnClickListener(this.jRL.jDt);
                            dVar.jSt.aZw = true;
                            itemViewType = kVar2.jBI;
                            aVar2 = new a();
                            aVar2.jdV = itemViewType;
                            if (this.jRK.get(Integer.valueOf(i)) != null) {
                                aVar2.position = ((Integer) this.jRK.get(Integer.valueOf(i))).intValue();
                            } else {
                                aVar2.position = 0;
                            }
                            dVar.jSt.setTag(aVar2);
                        }
                    }
                    view.setDrawingCacheEnabled(false);
                }
            }
        } else {
            if (itemViewType == 2) {
                e eVar;
                if (view == null || view.getTag() == null || !(view.getTag() instanceof e)) {
                    e eVar2 = new e(this);
                    view = q.em(this.bij).inflate(2130904495, null);
                    eVar2.jRX = (TextView) view.findViewById(2131759336);
                    eVar2.jRW = (TextView) view.findViewById(2131759337);
                    eVar2.jSe = (MaskImageView) view.findViewById(2131759285);
                    eVar2.jSa = (TextView) view.findViewById(2131755095);
                    eVar2.jRY = (LinearLayout) view.findViewById(2131759432);
                    eVar2.jRZ = (ImageView) view.findViewById(2131759433);
                    eVar2.jDC = (LinearLayout) view.findViewById(2131759282);
                    eVar2.jDD = view.findViewById(2131759281);
                    eVar2.jSe.setOnClickListener(this.jRL.jSw);
                    eVar2.jSn = (TextView) view.findViewById(2131759438);
                    eVar2.jSt = (MaskLinearLayout) view.findViewById(2131759434);
                    eVar2.jSt.b(eVar2.jSe);
                    eVar2.gtw = (TextView) view.findViewById(2131757325);
                    eVar2.jSm = view.findViewById(2131759439);
                    view.setTag(eVar2);
                    eVar = eVar2;
                } else {
                    eVar = (e) view.getTag();
                }
                ad.aSB().ca(eVar.jSe);
                int intValue2 = this.jDl.get(Integer.valueOf(i)) != null ? ((Integer) this.jDl.get(Integer.valueOf(i))).intValue() : -1;
                eVar.init();
                eVar.jSt.aZw = false;
                eVar.jSt.setBackgroundResource(0);
                eVar.jSt.setDescendantFocusability(131072);
                eVar.jSt.setClickable(false);
                eVar.jSe.aZw = true;
                eVar.jSe.setClickable(true);
                eVar.jSt.setOnClickListener(null);
                if (intValue2 >= this.jDo || intValue2 == -1) {
                    view.setLayoutParams(new LayoutParams(-1, 1));
                    view.setVisibility(8);
                } else {
                    if (intValue2 - 1 >= 0) {
                        kVar = (k) getItem(intValue2 - 1);
                        i2 = kVar.field_head;
                        ah.H(kVar.field_localPrivate, this.bcR);
                    } else {
                        i2 = -1;
                    }
                    view.setLayoutParams(new LayoutParams(-1, -2));
                    view.setVisibility(0);
                    if (this.jDm.get(Integer.valueOf(i)) != null) {
                        ((Integer) this.jDm.get(Integer.valueOf(i))).intValue();
                    }
                    k kVar3 = (k) getItem(intValue2);
                    azr aUp2 = kVar3.aUp();
                    if ((this.bcR && i == 0) || r3 == -1 || kVar3.field_head != r3) {
                        a(eVar.jRW, eVar.jRX, (long) kVar3.field_createTime);
                        if (aUp2.mWo != null) {
                            charSequence = aUp2.mWo.cHe;
                            if (!(charSequence == null || charSequence.equals(""))) {
                                eVar.jSa.setText(charSequence);
                                eVar.jSa.setVisibility(0);
                            }
                        }
                        eVar.jDD.setVisibility(0);
                    }
                    eVar.jRY.setVisibility(0);
                    ah.n(kVar3);
                    ak akVar = new ak(this.jRJ.tag);
                    akVar.hrm = kVar3.field_createTime;
                    eVar.jSe.setVisibility(0);
                    ad.aSB().a(aUp2.mWq.mom, eVar.jSe, this.bij.hashCode(), com.tencent.mm.plugin.sns.e.g.a.jjE, akVar);
                    if (ah.H(kVar3.field_localPrivate, this.bcR)) {
                        eVar.jSn.setVisibility(0);
                        eVar.jSn.setBackgroundResource(2130838879);
                        com.tencent.mm.storage.u LX = this.jMH.LX(kVar3.field_userName);
                        if (LX != null) {
                            LX.tU();
                        }
                    }
                    charSequence = ((k) getItem(intValue2)).aUp().mWn;
                    if (!(charSequence == null || charSequence.equals(""))) {
                        eVar.jSm.setVisibility(0);
                        eVar.gtw.setVisibility(0);
                        eVar.gtw.setText(charSequence);
                        eVar.gtw.setText(com.tencent.mm.pluginsdk.ui.d.e.a(this.bij, charSequence, eVar.gtw.getTextSize()));
                    }
                    eVar.jSt.setDescendantFocusability(393216);
                    eVar.jSt.setClickable(true);
                    eVar.jSe.setClickable(false);
                    eVar.jSe.aZw = false;
                    eVar.jSt.setOnClickListener(this.jRL.jSw);
                    eVar.jSt.aZw = true;
                    itemViewType = kVar3.jBI;
                    aVar2 = new a();
                    aVar2.jdV = itemViewType;
                    if (this.jRK.get(Integer.valueOf(i)) != null) {
                        aVar2.position = ((Integer) this.jRK.get(Integer.valueOf(i))).intValue();
                    } else {
                        aVar2.position = 0;
                    }
                    eVar.jSt.setTag(aVar2);
                }
            } else if (itemViewType == 3) {
                if (view == null || view.getTag() == null || !(view.getTag() instanceof d)) {
                    dVar = new d(this);
                    view = q.em(this.bij).inflate(2130904484, null);
                    dVar.jRX = (TextView) view.findViewById(2131759336);
                    dVar.jRW = (TextView) view.findViewById(2131759337);
                    dVar.jSe = (MaskImageView) view.findViewById(2131759285);
                    dVar.jSf = (QFadeImageView) view.findViewById(2131759436);
                    dVar.jSg = (MaskImageView) view.findViewById(2131759286);
                    dVar.jSh = (MaskImageView) view.findViewById(2131759287);
                    dVar.gtw = (TextView) view.findViewById(2131757325);
                    dVar.jSi = (TextView) view.findViewById(2131759437);
                    dVar.jSj = (TextView) view.findViewById(2131759442);
                    dVar.jSk = (TextView) view.findViewById(2131759445);
                    dVar.jSl = (TextView) view.findViewById(2131759440);
                    dVar.jSm = view.findViewById(2131759439);
                    dVar.jSa = (TextView) view.findViewById(2131755095);
                    dVar.jRY = (LinearLayout) view.findViewById(2131759432);
                    dVar.jRZ = (ImageView) view.findViewById(2131759433);
                    dVar.jDC = (LinearLayout) view.findViewById(2131759282);
                    dVar.jDD = view.findViewById(2131759281);
                    dVar.jSf.setOnClickListener(this.jRL.jSv);
                    dVar.jSe.setOnClickListener(this.jRL.jSv);
                    dVar.jSn = (TextView) view.findViewById(2131759438);
                    dVar.jSo = (TextView) view.findViewById(2131759443);
                    dVar.jSp = (TextView) view.findViewById(2131759446);
                    dVar.jSq = (TextView) view.findViewById(2131759435);
                    dVar.jSr = (TextView) view.findViewById(2131759441);
                    dVar.jSs = (TextView) view.findViewById(2131759444);
                    dVar.jSt = (MaskLinearLayout) view.findViewById(2131759434);
                    dVar.jSt.b(dVar.jSe);
                    view.setTag(dVar);
                } else {
                    dVar = (d) view.getTag();
                }
                ad.aSB().ca(dVar.jSe);
                ad.aSB().ca(dVar.jSg);
                ad.aSB().ca(dVar.jSh);
                i2 = -1;
                if (this.jDl.get(Integer.valueOf(i)) != null) {
                    i2 = ((Integer) this.jDl.get(Integer.valueOf(i))).intValue();
                }
                dVar.init();
                dVar.jSt.aZw = false;
                dVar.jSt.setBackgroundResource(0);
                dVar.jSt.setDescendantFocusability(131072);
                dVar.jSt.setClickable(false);
                dVar.jSe.aZw = true;
                dVar.jSe.setClickable(true);
                dVar.jSt.setOnClickListener(null);
                if (i2 >= this.jDo || i2 == -1) {
                    view.setLayoutParams(new LayoutParams(-1, 1));
                    view.setVisibility(8);
                } else {
                    if (i2 - 1 >= 0) {
                        kVar = (k) getItem(i2 - 1);
                        i3 = kVar.field_head;
                        ah.H(kVar.field_localPrivate, this.bcR);
                    } else {
                        i3 = -1;
                    }
                    view.setLayoutParams(new LayoutParams(-1, -2));
                    view.setVisibility(0);
                    k kVar4 = (k) getItem(i2);
                    aUp = kVar4.aUp();
                    if ((this.bcR && i == 0) || r4 == -1 || kVar4.field_head != r4) {
                        a(dVar.jRW, dVar.jRX, (long) kVar4.field_createTime);
                        if (aUp.mWo != null) {
                            charSequence = aUp.mWo.cHe;
                            if (!(charSequence == null || charSequence.equals(""))) {
                                dVar.jSa.setText(charSequence);
                                dVar.jSa.setVisibility(0);
                            }
                        }
                        dVar.jDD.setVisibility(0);
                    }
                    dVar.jRY.setVisibility(0);
                    if (this.bcR && i == 0) {
                        dVar.jSf.setVisibility(0);
                        dVar.jSf.setContentDescription(this.bij.getString(2131235546));
                        dVar.jSe.setVisibility(8);
                        dVar.gtw.setText(this.jDn == 1 ? this.bij.getString(2131235578) : "");
                        dVar.gtw.setVisibility(0);
                        dVar.jSm.setVisibility(0);
                        dVar.jSl.setVisibility(8);
                        ad.aSB().a(dVar.jSf, 2131689675, 2130839236, this.bij.hashCode());
                        aVar = new a();
                        aVar.jdV = -1;
                        aVar.position = -1;
                        dVar.jSf.setTag(aVar);
                    } else {
                        a(i2, dVar.jSe, dVar.jSi, dVar.jSl, dVar.jSn, dVar.jSq, 1, dVar, i);
                        kVar = (k) getItem(i2);
                        if (!be.kS(kVar.aUp().mWn) && kVar.field_type == 1) {
                            dVar.jSt.setDescendantFocusability(393216);
                            dVar.jSt.setClickable(true);
                            dVar.jSe.setClickable(false);
                            dVar.jSe.aZw = false;
                            dVar.jSt.setOnClickListener(this.jRL.jSv);
                            dVar.jSt.aZw = true;
                            itemViewType = kVar4.jBI;
                            aVar2 = new a();
                            aVar2.jdV = itemViewType;
                            if (this.jRK.get(Integer.valueOf(i)) != null) {
                                aVar2.position = ((Integer) this.jRK.get(Integer.valueOf(i))).intValue();
                            } else {
                                aVar2.position = 0;
                            }
                            dVar.jSt.setTag(aVar2);
                        }
                        view.setDrawingCacheEnabled(false);
                    }
                }
            } else {
                b bVar;
                if (view == null || view.getTag() == null || !(view.getTag() instanceof b)) {
                    b bVar2 = new b(this);
                    view = q.em(this.bij).inflate(2130904483, null);
                    bVar2.jRV = view.findViewById(2131758280);
                    bVar2.jRX = (TextView) view.findViewById(2131759336);
                    bVar2.jRW = (TextView) view.findViewById(2131759337);
                    bVar2.jSa = (TextView) view.findViewById(2131755095);
                    bVar2.jDD = view.findViewById(2131759281);
                    bVar2.jSa = (TextView) view.findViewById(2131755095);
                    bVar2.jRY = (LinearLayout) view.findViewById(2131759432);
                    bVar2.jRZ = (ImageView) view.findViewById(2131759433);
                    bVar2.jDC = (LinearLayout) view.findViewById(2131759282);
                    bVar2.emb = (TextView) view.findViewById(2131755458);
                    bVar2.jSb = (TagImageView) view.findViewById(2131759412);
                    bVar2.jEe = (ImageView) view.findViewById(2131757389);
                    bVar2.dtB = (TextView) view.findViewById(2131759414);
                    bVar2.jSc = (TextView) view.findViewById(2131759415);
                    bVar2.jRV.setOnClickListener(this.jRL.jSu);
                    bVar2.jSd = view.findViewById(2131759417);
                    view.setTag(bVar2);
                    i.b(bVar2.jSb, this.bij);
                    bVar = bVar2;
                } else {
                    bVar = (b) view.getTag();
                }
                i2 = this.jDl.get(Integer.valueOf(i)) != null ? ((Integer) this.jDl.get(Integer.valueOf(i))).intValue() : -1;
                bVar.init();
                if (i2 >= this.jDo || i2 == -1) {
                    view.setLayoutParams(new LayoutParams(-1, 1));
                    view.setVisibility(8);
                } else {
                    view.setVisibility(0);
                    if (i2 - 1 >= 0) {
                        kVar = (k) getItem(i2 - 1);
                        i3 = kVar.field_head;
                        ah.H(kVar.field_localPrivate, this.bcR);
                    } else {
                        i3 = -1;
                    }
                    view.setLayoutParams(new LayoutParams(-1, -2));
                    view.setVisibility(0);
                    if (this.jDm.get(Integer.valueOf(i)) != null) {
                        ((Integer) this.jDm.get(Integer.valueOf(i))).intValue();
                    }
                    k kVar5 = (k) getItem(i2);
                    azr aUp3 = kVar5.aUp();
                    if ((this.bcR && i == 0) || r4 == -1 || kVar5.field_head != r4) {
                        a(bVar.jRW, bVar.jRX, (long) kVar5.field_createTime);
                        if (aUp3.mWo != null) {
                            charSequence = aUp3.mWo.cHe;
                            if (!(charSequence == null || charSequence.equals(""))) {
                                bVar.jSa.setText(charSequence);
                                bVar.jSa.setVisibility(0);
                            }
                        }
                        bVar.jDD.setVisibility(0);
                    }
                    a aVar3 = new a();
                    aVar3.jdV = kVar5.jBI;
                    if (this.jRK.get(Integer.valueOf(i)) != null) {
                        aVar3.position = ((Integer) this.jRK.get(Integer.valueOf(i))).intValue();
                    } else {
                        aVar3.position = 0;
                    }
                    bVar.jRV.setTag(aVar3);
                    if (be.kS(aUp3.mWn)) {
                        bVar.emb.setVisibility(8);
                    } else {
                        bVar.emb.setVisibility(0);
                        bVar.emb.setText(aUp3.mWn);
                        bVar.emb.setText(com.tencent.mm.pluginsdk.ui.d.e.a(this.bij, aUp3.mWn, bVar.emb.getTextSize()));
                    }
                    bVar.jRY.setVisibility(0);
                    bVar.emb.setSingleLine(true);
                    bVar.jSd.setVisibility(0);
                    itemViewType = aUp3.mWq.mol;
                    ak akVar2 = new ak(this.jRJ.tag);
                    akVar2.hrm = kVar5.field_createTime;
                    if (itemViewType == 2) {
                        bVar.emb.setVisibility(0);
                        bVar.emb.setSingleLine(false);
                        bVar.emb.setMaxLines(2);
                        bVar.jSd.setVisibility(8);
                    } else if (itemViewType != 4) {
                        CharSequence Cf;
                        CharSequence charSequence2;
                        bVar.dtB.setTextColor(this.bij.getResources().getColor(2131689986));
                        if (((com.tencent.mm.plugin.sns.e.ak.a.aTb() & 1) <= 0 ? 1 : null) != null) {
                            Cf = as.Cf(aUp3.mWq.glb);
                        } else {
                            Object obj = "";
                        }
                        String str = aUp3.mWq.aXz;
                        if (str == null || str.length() <= 40) {
                            Object obj2 = str;
                        } else {
                            charSequence2 = str.substring(0, 40) + "...";
                        }
                        if (bVar.jSb != null) {
                            bVar.jSb.setOnClickListener(null);
                        }
                        bVar.jEe.setVisibility(8);
                        if (aUp3.mWq.mom.isEmpty()) {
                            bVar.jSb.setVisibility(8);
                        } else {
                            bVar.jSb.setVisibility(0);
                            r3 = (aib) aUp3.mWq.mom.get(0);
                            if (aUp3.mWq.mol == 5) {
                                Cf = as.Cf(r3.glb);
                                charSequence2 = r3.aXz;
                                bVar.jEe.setVisibility(0);
                                ad.aSB().a(r3, bVar.jSb, 2131165244, this.bij.hashCode(), com.tencent.mm.plugin.sns.e.g.a.jjE, akVar2);
                            } else {
                                ad.aSB().a(r3, bVar.jSb, this.bij.hashCode(), com.tencent.mm.plugin.sns.e.g.a.jjE, akVar2);
                            }
                        }
                        if (be.kS(Cf)) {
                            bVar.jSc.setVisibility(8);
                        } else {
                            bVar.jSc.setVisibility(0);
                            bVar.jSc.setText(Cf);
                        }
                        if (be.kS(charSequence2)) {
                            bVar.dtB.setVisibility(8);
                        } else {
                            if (bVar.jSc.getVisibility() == 8) {
                                bVar.dtB.setMaxLines(2);
                            } else {
                                bVar.dtB.setMaxLines(1);
                            }
                            bVar.dtB.setVisibility(0);
                            if ((aUp3.cog & 1) > 0) {
                                bVar.dtB.setText(i.a(charSequence2, this.bij, bVar.dtB));
                            } else {
                                bVar.dtB.setText(charSequence2);
                            }
                        }
                    } else if (aUp3.mWq.mom.isEmpty()) {
                        bVar.jSd.setVisibility(8);
                    } else {
                        bVar.jSb.setVisibility(0);
                        bVar.jEe.setVisibility(0);
                        bVar.jSd.setVisibility(0);
                        bVar.dtB.setMaxLines(1);
                        bVar.dtB.setTextColor(this.bij.getResources().getColor(2131690029));
                        r3 = (aib) aUp3.mWq.mom.get(0);
                        ad.aSB().a(r3, bVar.jSb, 2131165232, this.bij.hashCode(), com.tencent.mm.plugin.sns.e.g.a.jjE, akVar2);
                        bVar.jEe.setPressed(false);
                        if (Ce(aUp3.gID)) {
                            bVar.jEe.setImageResource(2130838733);
                        } else {
                            bVar.jEe.setImageResource(2130838735);
                        }
                        bVar.jSb.setTag(aUp3);
                        bVar.jSb.setOnClickListener(this.jRS);
                        r3.jdV = kVar5.jBI;
                        bVar.jSd.setTag(aUp3);
                        charSequence = r3.gkC;
                        if (be.kS(charSequence)) {
                            bVar.jSc.setVisibility(4);
                        } else {
                            bVar.jSc.setVisibility(0);
                            bVar.jSc.setText(charSequence);
                        }
                        charSequence = r3.aXz;
                        if (be.kS(charSequence)) {
                            bVar.dtB.setVisibility(8);
                        } else {
                            bVar.dtB.setVisibility(0);
                            bVar.dtB.setTag(aVar3);
                            bVar.dtB.setOnTouchListener(new y());
                            bVar.dtB.setText(charSequence);
                        }
                    }
                }
            }
            view.setDrawingCacheEnabled(false);
        }
        return view;
    }

    public final int getCount() {
        return this.jDn;
    }

    private void a(TextView textView, TextView textView2, long j) {
        String str = (String) aw.a(this.bij, 1000 * j, !this.gRN.equals("en"));
        String[] split;
        if (str.indexOf(":") > 0) {
            split = str.split(":");
            if (split[1].length() < 2) {
                split[1] = "0" + split[1];
            }
            textView.setText(split[0]);
            textView2.setText(split[1]);
            textView2.setVisibility(0);
            textView.setVisibility(0);
        } else if (str.indexOf("/") > 0) {
            split = str.split("/");
            if (split[1].length() < 2) {
                split[1] = "0" + split[1];
            }
            split[0] = aw.q(this.bij, split[0], this.gRN);
            textView.setText(split[0]);
            textView2.setText(split[1]);
            textView2.setVisibility(0);
            textView.setVisibility(0);
        } else {
            textView2.setVisibility(0);
            textView2.setText(str);
        }
    }

    public final int getItemViewType(int i) {
        if (this.bcR && i == 0) {
            v.d("MicroMsg.SnsphotoAdapter", "position isSelf " + i + " - 0");
            return 0;
        }
        int intValue;
        if (this.jDl.get(Integer.valueOf(i)) != null) {
            intValue = ((Integer) this.jDl.get(Integer.valueOf(i))).intValue();
        } else {
            intValue = -1;
        }
        if (intValue == -1) {
            v.e("MicroMsg.SnsphotoAdapter", "unknow error " + intValue);
            return 0;
        }
        k kVar = (k) getItem(intValue);
        if (kVar.aUp().mWq.mol == 1) {
            v.d("MicroMsg.SnsphotoAdapter", "position " + i + " - 0");
            return 0;
        } else if (kVar.aUp().mWq.mol != 15) {
            return kVar.aUp().mWq.mol == 21 ? 3 : 1;
        } else {
            v.d("MicroMsg.SnsphotoAdapter", "position " + i + " - 2");
            return 2;
        }
    }

    public final int getViewTypeCount() {
        return 4;
    }

    private void a(int i, QFadeImageView qFadeImageView, TextView textView, TextView textView2, TextView textView3, TextView textView4, int i2, d dVar, int i3) {
        CharSequence tU;
        k kVar = (k) getItem(i);
        azr aUp = kVar.aUp();
        awa n = ah.n(kVar);
        Object obj = null;
        if (n != null && (((n.mTr & 2) == 2 && n.mTw != null) || ((n.mTr & 4) == 4 && n.mIw != null))) {
            obj = 1;
        }
        if (!(!this.bcR || n == null || r1 == null || this.userName == null || !this.userName.equals(kVar.field_userName))) {
            textView3.setBackgroundResource(2130838885);
            textView3.setVisibility(0);
        }
        com.tencent.mm.storage.u LX;
        if (i2 == 1) {
            if (ah.H(kVar.field_localPrivate, this.bcR)) {
                textView3.setVisibility(0);
                textView3.setBackgroundResource(2130838879);
                LX = this.jMH.LX(kVar.field_userName);
                tU = LX == null ? "" : LX.tU();
                if (!(tU.equals("") || this.userName.equals(kVar.field_userName))) {
                    textView.setVisibility(0);
                    textView.setText(tU);
                }
            }
        } else if (ah.H(kVar.field_localPrivate, this.bcR)) {
            textView3.setVisibility(0);
            textView3.setBackgroundResource(2130838879);
            LX = this.jMH.LX(kVar.field_userName);
            tU = LX == null ? "" : LX.tU();
            if (!(tU == null || tU.equals("") || this.userName.equals(kVar.field_userName))) {
                textView.setVisibility(0);
                textView.setText(tU);
            }
        }
        int i4 = kVar.jBI;
        a aVar = new a();
        aVar.jdV = i4;
        if (this.jRK.get(Integer.valueOf(i3)) != null) {
            aVar.position = ((Integer) this.jRK.get(Integer.valueOf(i3))).intValue();
        } else {
            aVar.position = 0;
        }
        qFadeImageView.setTag(aVar);
        ak akVar = new ak(this.jRJ.tag);
        akVar.hrm = kVar.field_createTime;
        if (aUp.mWq.mol == 1) {
            qFadeImageView.setVisibility(0);
            ad.aSB().a(aUp.mWq.mom, (View) qFadeImageView, this.bij.hashCode(), com.tencent.mm.plugin.sns.e.g.a.jjE, akVar);
        } else if (aUp.mWq.mol == 2) {
            textView4.setText(be.ah(aUp.mWq.gkC, ""));
            textView4.setVisibility(0);
        } else if (aUp.mWq.mol == 21) {
            kVar.aUD();
            boolean z = true;
            if (this.bcR) {
                z = true;
            } else if (x.a(kVar, n)) {
                z = false;
            }
            qFadeImageView.setVisibility(0);
            ad.aSB().a(aUp.mWq.mom, (View) qFadeImageView, this.bij.hashCode(), com.tencent.mm.plugin.sns.e.g.a.jjE, akVar, z);
        }
        if (kVar.aSn() && kVar.aUN()) {
            textView3.setVisibility(0);
            textView3.setBackgroundResource(2130838877);
        }
        if (i2 == 1) {
            if (aUp.mWq.mom == null || aUp.mWq.mom.size() <= 1) {
                textView2.setVisibility(8);
            } else {
                dVar.jSm.setVisibility(0);
                textView2.setVisibility(0);
                textView2.setText(this.bij.getResources().getQuantityString(2131361819, i4, new Object[]{Integer.valueOf(aUp.mWq.mom.size())}));
            }
            tU = aUp.mWn;
            if (tU != null && !tU.equals("")) {
                dVar.jSm.setVisibility(0);
                dVar.gtw.setVisibility(0);
                dVar.gtw.setText(tU);
                dVar.gtw.setText(com.tencent.mm.pluginsdk.ui.d.e.a(this.bij, tU, dVar.gtw.getTextSize()));
            }
        }
    }

    private void gv(boolean z) {
        v.d("MicroMsg.SnsphotoAdapter", "limitSeq " + this.fHQ);
        if (this.jRN != null) {
            this.jRN.c(this.fHQ, this.jRM, z);
        }
    }

    public final void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }

    public final void aVH() {
        gv(true);
        notifyDataSetChanged();
    }

    public final void aXn() {
        v.d("MicroMsg.SnsphotoAdapter", "i addSize ");
        dk(this.gKQ.isEmpty() ? 0 : ((k) this.gKQ.get(this.gKQ.size() - 1)).field_snsId);
    }

    private void dk(long j) {
        aq aqVar;
        String cF = i.cF(ad.aSE().a(j, ad.aSu().Ax(this.userName), this.userName, this.bcR));
        if (this.jJv.equals("")) {
            aqVar = this;
        } else if (cF.compareTo(this.jJv) < 0) {
            aqVar = this;
        } else {
            cF = this.jJv;
            aqVar = this;
        }
        aqVar.fHQ = cF;
        pu aUA = ad.aSG().Bu(this.userName).aUA();
        if (aUA.mrG != 0) {
            cF = i.cF(aUA.mrG);
            if (this.fHQ.equals("")) {
                this.fHQ = cF;
                return;
            }
            if (cF.compareTo(this.fHQ) <= 0) {
                cF = this.fHQ;
            }
            this.fHQ = cF;
        }
    }

    public final Object getItem(int i) {
        return this.gKQ.get(i);
    }

    public final long getItemId(int i) {
        return 0;
    }

    public final ArrayList<com.tencent.mm.plugin.sns.g.b> cy(int i, int i2) {
        ArrayList<com.tencent.mm.plugin.sns.g.b> arrayList = new ArrayList();
        this.jRR = i2;
        for (int i3 = 0; i3 < this.gKQ.size(); i3++) {
            k kVar = (k) this.gKQ.get(i3);
            int i4 = kVar.jBI;
            if (!(kVar.aUp() == null || kVar.aUp().mWq == null || kVar.aUp().mWq.mom.size() == 0 || (kVar.aUp().mWq.mol != 1 && kVar.aUp().mWq.mol != 15))) {
                if (i4 == i) {
                    this.jRR = arrayList.size();
                }
                Iterator it = kVar.aUp().mWq.mom.iterator();
                while (it.hasNext()) {
                    aib com_tencent_mm_protocal_c_aib = (aib) it.next();
                    com.tencent.mm.plugin.sns.g.b bVar = new com.tencent.mm.plugin.sns.g.b();
                    bVar.boL = com_tencent_mm_protocal_c_aib;
                    bVar.jqo = s.B("sns_table_", (long) i4);
                    bVar.cLB = kVar.field_createTime;
                    arrayList.add(bVar);
                }
            }
        }
        return arrayList;
    }

    protected static boolean Ce(String str) {
        ajr HE = com.tencent.mm.ai.b.HE();
        if (HE != null && com.tencent.mm.ai.b.d(HE) && str.equals(HE.mJW) && com.tencent.mm.ai.b.HC()) {
            return true;
        }
        return false;
    }
}
