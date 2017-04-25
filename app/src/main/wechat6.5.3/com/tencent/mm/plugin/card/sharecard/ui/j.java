package com.tencent.mm.plugin.card.sharecard.ui;

import android.content.Context;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mars.smc.SmcLogic.IDKey;
import com.tencent.mm.plugin.card.b.k;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.base.c;
import com.tencent.mm.plugin.card.widget.CardTagTextView;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.d.e;
import com.tencent.mm.protocal.c.azb;
import com.tencent.mm.protocal.c.ld;
import com.tencent.mm.sdk.platformtools.be;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public final class j implements c {
    private BaseAdapter eGK;
    private long eGL = 0;
    private long eGM = 0;
    private int eGN;
    private int eGO;
    private ArrayList<Integer> eGP = new ArrayList();
    private ArrayList<String> eGQ = new ArrayList();
    private ArrayList<String> eGR = new ArrayList();
    protected LinkedList<CardTagTextView> eGS = new LinkedList();
    private Context mContext;

    public class a {
        public LinearLayout eGT;
        public TextView eGU;
        public TextView eGV;
        public RelativeLayout eGW;
        public ImageView eGX;
        public TextView eGY;
        public TextView eGZ;
        public TextView eHa;
        public TextView eHb;
        public TextView eHc;
        public View eHd;
        public TextView eHe;
        final /* synthetic */ j eHf;

        public a(j jVar) {
            this.eHf = jVar;
        }
    }

    public j(Context context, BaseAdapter baseAdapter) {
        this.mContext = context;
        this.eGK = baseAdapter;
        this.eGN = this.mContext.getResources().getDimensionPixelSize(2131493170);
        this.eGO = this.mContext.getResources().getDimensionPixelSize(2131493152);
        this.eGP.clear();
        this.eGQ.clear();
        this.eGR.clear();
    }

    public final void release() {
        this.mContext = null;
        this.eGK = null;
        if (this.eGM > 0) {
            ArrayList arrayList = new ArrayList();
            IDKey iDKey = new IDKey();
            iDKey.SetID(281);
            iDKey.SetKey(5);
            iDKey.SetValue(1);
            IDKey iDKey2 = new IDKey();
            iDKey2.SetID(281);
            iDKey2.SetKey(6);
            iDKey2.SetValue((int) (this.eGL / this.eGM));
            arrayList.add(iDKey);
            arrayList.add(iDKey2);
            g gVar = g.iuh;
            g.d(arrayList, true);
        }
        if (this.eGP.size() == this.eGQ.size() && this.eGQ.size() == this.eGR.size() && this.eGP.size() > 0) {
            long currentTimeMillis = System.currentTimeMillis();
            for (int i = 0; i < this.eGP.size(); i++) {
                g.iuh.h(13220, new Object[]{this.eGR.get(i), this.eGQ.get(i), this.eGP.get(i), Long.valueOf(currentTimeMillis)});
            }
        }
        this.eGP.clear();
        this.eGQ.clear();
        this.eGR.clear();
        if (this.eGS != null) {
            this.eGS.clear();
        }
    }

    public final View a(int i, View view, b bVar) {
        a aVar;
        Object obj;
        StringBuilder stringBuilder;
        CharSequence pT;
        boolean iX;
        int pU;
        LayoutParams layoutParams;
        long currentTimeMillis = System.currentTimeMillis();
        if (view == null) {
            view = View.inflate(this.mContext, 2130903250, null);
            a aVar2 = new a(this);
            aVar2.eGT = (LinearLayout) view.findViewById(2131755968);
            aVar2.eGU = (TextView) view.findViewById(2131755966);
            aVar2.eGV = (TextView) view.findViewById(2131755967);
            aVar2.eGW = (RelativeLayout) view.findViewById(2131755711);
            aVar2.eGX = (ImageView) view.findViewById(2131755713);
            aVar2.eGY = (TextView) view.findViewById(2131755714);
            aVar2.eGZ = (TextView) view.findViewById(2131755716);
            aVar2.eHd = view.findViewById(2131755971);
            aVar2.eHa = (TextView) view.findViewById(2131755719);
            aVar2.eHb = (TextView) view.findViewById(2131755972);
            aVar2.eHc = (TextView) view.findViewById(2131755720);
            aVar2.eHe = (TextView) view.findViewById(2131755970);
            aVar2.eHa.setEllipsize(TruncateAt.MIDDLE);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        b bVar2 = (b) this.eGK.getItem(i);
        int ZE = bVar2.ZE();
        if (com.tencent.mm.plugin.card.sharecard.a.b.iX(bVar2.ZE())) {
            if (i == 0) {
                if (!TextUtils.isEmpty(bVar2.iR(ZE))) {
                    obj = 1;
                    if (obj != null) {
                        aVar.eGU.setVisibility(0);
                        aVar.eGU.setText(bVar2.iR(ZE));
                        if (TextUtils.isEmpty(bVar2.ZD())) {
                            aVar.eGV.setVisibility(8);
                        } else {
                            aVar.eGV.setVisibility(0);
                            aVar.eGV.setText(bVar2.ZD());
                        }
                    } else {
                        aVar.eGU.setVisibility(8);
                        aVar.eGV.setVisibility(8);
                        aVar.eGU.setText("");
                    }
                    if (bVar.Zh()) {
                        aVar.eGX.setVisibility(0);
                        aVar.eGY.setVisibility(0);
                        aVar.eGT.setVisibility(0);
                        aVar.eGZ.setVisibility(0);
                        aVar.eHe.setVisibility(0);
                        aVar.eHd.setVisibility(0);
                        aVar.eHa.setVisibility(0);
                        aVar.eHb.setVisibility(0);
                        aVar.eHc.setVisibility(8);
                        aVar.eGY.setText(bVar.Zv().eCD);
                        if (!bVar.Ze()) {
                            aVar.eGZ.setText(bVar.Zv().title);
                        } else if (bVar.Zv().mkN == null && bVar.Zv().mkN.size() == 1) {
                            aVar.eGZ.setText(((ld) bVar.Zv().mkN.get(0)).title);
                        } else if (bVar.Zv().mkN != null && bVar.Zv().mkN.size() == 2) {
                            stringBuilder = new StringBuilder();
                            stringBuilder.append(((ld) bVar.Zv().mkN.get(0)).title);
                            stringBuilder.append("-");
                            stringBuilder.append(((ld) bVar.Zv().mkN.get(1)).title);
                            aVar.eGZ.setText(stringBuilder.toString());
                        }
                        k.a(aVar.eGX, bVar.Zv().eBM, this.mContext.getResources().getDimensionPixelSize(2131493362), 2130838736, true);
                        aVar.eGY.setTextColor(this.mContext.getResources().getColor(2131689589));
                        pT = com.tencent.mm.plugin.card.sharecard.a.b.pT(bVar.ZA());
                        if (TextUtils.isEmpty(pT)) {
                            aVar.eHb.setText("");
                        } else {
                            aVar.eHb.setText(pT);
                        }
                        pT = com.tencent.mm.plugin.card.sharecard.a.b.hU(bVar.ZA());
                        iX = com.tencent.mm.plugin.card.sharecard.a.b.iX(bVar.ZE());
                        if (TextUtils.isEmpty(pT) && iX) {
                            aVar.eHa.setText(e.a(this.mContext, pT, this.mContext.getResources().getDimensionPixelOffset(2131493202)));
                        } else if (TextUtils.isEmpty(bVar.ZB())) {
                            aVar.eHa.setText("");
                        } else {
                            if (TextUtils.isEmpty(com.tencent.mm.plugin.card.b.j.qy(bVar.ZB()))) {
                                aVar.eHa.setText("");
                            } else {
                                aVar.eHa.setText(e.a(this.mContext, this.mContext.getResources().getString(2131231681, new Object[]{pT}), this.mContext.getResources().getDimensionPixelOffset(2131493202)));
                            }
                        }
                        pU = com.tencent.mm.plugin.card.sharecard.a.b.pU(bVar.ZA());
                        if (pU > 1 || !iX) {
                            aVar.eHe.setVisibility(8);
                        } else {
                            aVar.eHe.setText("X" + pU);
                            aVar.eHe.setVisibility(0);
                        }
                        if ((bVar.Zv().mlg != null || be.bP(bVar.Zv().mlg.mYD)) && !com.tencent.mm.plugin.card.sharecard.a.b.pW(bVar.ZA())) {
                            aVar.eGT.setVisibility(8);
                        } else {
                            aVar.eGT.setVisibility(0);
                            for (int i2 = 0; i2 < aVar.eGT.getChildCount(); i2++) {
                                this.eGS.add((CardTagTextView) aVar.eGT.getChildAt(i2));
                            }
                            aVar.eGT.removeAllViews();
                            if (com.tencent.mm.plugin.card.sharecard.a.b.pW(bVar.ZA())) {
                                View aaX = aaX();
                                aaX.setPadding(this.eGO, this.eGN, this.eGO, this.eGN);
                                aaX.setTextColor(this.mContext.getResources().getColor(2131689960));
                                aaX.setText(this.mContext.getString(2131231692));
                                aaX.setTextSize(12.0f);
                                ViewGroup.LayoutParams layoutParams2 = new LayoutParams(-2, -2);
                                layoutParams2.rightMargin = this.mContext.getResources().getDimensionPixelOffset(2131493144);
                                aVar.eGT.addView(aaX, layoutParams2);
                            }
                            if (!(bVar.Zv().mlg == null || be.bP(bVar.Zv().mlg.mYD))) {
                                Iterator it = bVar.Zv().mlg.mYD.iterator();
                                while (it.hasNext()) {
                                    azb com_tencent_mm_protocal_c_azb = (azb) it.next();
                                    View aaX2 = aaX();
                                    aaX2.setPadding(this.eGO, this.eGN, this.eGO, this.eGN);
                                    aaX2.setTextColor(com.tencent.mm.plugin.card.b.j.qv(com_tencent_mm_protocal_c_azb.coN));
                                    aaX2.setText(com_tencent_mm_protocal_c_azb.tag);
                                    aaX2.setTextSize(12.0f);
                                    aVar.eGT.addView(aaX2);
                                }
                            }
                        }
                    } else {
                        aVar.eGX.setVisibility(8);
                        aVar.eGY.setVisibility(8);
                        aVar.eGT.setVisibility(8);
                        aVar.eGZ.setVisibility(8);
                        aVar.eHe.setVisibility(8);
                        aVar.eHd.setVisibility(8);
                        aVar.eHa.setVisibility(8);
                        aVar.eHb.setVisibility(8);
                        aVar.eHc.setVisibility(0);
                        aVar.eHc.setText(this.mContext.getResources().getString(2131231661));
                    }
                    if (i == this.eGK.getCount() - 1 || aVar.eGW == null) {
                        layoutParams = (LayoutParams) aVar.eGW.getLayoutParams();
                        if (layoutParams.bottomMargin != 0) {
                            layoutParams.bottomMargin = 0;
                            aVar.eGW.setLayoutParams(layoutParams);
                        }
                    } else {
                        layoutParams = (LayoutParams) aVar.eGW.getLayoutParams();
                        if (layoutParams.bottomMargin != this.mContext.getResources().getDimensionPixelOffset(2131493144)) {
                            layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelOffset(2131493144);
                            aVar.eGW.setLayoutParams(layoutParams);
                        }
                    }
                    this.eGL = (System.currentTimeMillis() - currentTimeMillis) + this.eGL;
                    this.eGM++;
                    if (!this.eGQ.contains(bVar.Zz())) {
                        this.eGQ.add(bVar.Zz());
                        this.eGR.add(bVar.ZA());
                        this.eGP.add(Integer.valueOf(i));
                    }
                    return view;
                }
            } else if (ZE != ((b) this.eGK.getItem(i - 1)).ZE()) {
                obj = 1;
                if (obj != null) {
                    aVar.eGU.setVisibility(8);
                    aVar.eGV.setVisibility(8);
                    aVar.eGU.setText("");
                } else {
                    aVar.eGU.setVisibility(0);
                    aVar.eGU.setText(bVar2.iR(ZE));
                    if (TextUtils.isEmpty(bVar2.ZD())) {
                        aVar.eGV.setVisibility(8);
                    } else {
                        aVar.eGV.setVisibility(0);
                        aVar.eGV.setText(bVar2.ZD());
                    }
                }
                if (bVar.Zh()) {
                    aVar.eGX.setVisibility(8);
                    aVar.eGY.setVisibility(8);
                    aVar.eGT.setVisibility(8);
                    aVar.eGZ.setVisibility(8);
                    aVar.eHe.setVisibility(8);
                    aVar.eHd.setVisibility(8);
                    aVar.eHa.setVisibility(8);
                    aVar.eHb.setVisibility(8);
                    aVar.eHc.setVisibility(0);
                    aVar.eHc.setText(this.mContext.getResources().getString(2131231661));
                } else {
                    aVar.eGX.setVisibility(0);
                    aVar.eGY.setVisibility(0);
                    aVar.eGT.setVisibility(0);
                    aVar.eGZ.setVisibility(0);
                    aVar.eHe.setVisibility(0);
                    aVar.eHd.setVisibility(0);
                    aVar.eHa.setVisibility(0);
                    aVar.eHb.setVisibility(0);
                    aVar.eHc.setVisibility(8);
                    aVar.eGY.setText(bVar.Zv().eCD);
                    if (!bVar.Ze()) {
                        aVar.eGZ.setText(bVar.Zv().title);
                    } else {
                        if (bVar.Zv().mkN == null) {
                        }
                        stringBuilder = new StringBuilder();
                        stringBuilder.append(((ld) bVar.Zv().mkN.get(0)).title);
                        stringBuilder.append("-");
                        stringBuilder.append(((ld) bVar.Zv().mkN.get(1)).title);
                        aVar.eGZ.setText(stringBuilder.toString());
                    }
                    k.a(aVar.eGX, bVar.Zv().eBM, this.mContext.getResources().getDimensionPixelSize(2131493362), 2130838736, true);
                    aVar.eGY.setTextColor(this.mContext.getResources().getColor(2131689589));
                    pT = com.tencent.mm.plugin.card.sharecard.a.b.pT(bVar.ZA());
                    if (TextUtils.isEmpty(pT)) {
                        aVar.eHb.setText("");
                    } else {
                        aVar.eHb.setText(pT);
                    }
                    pT = com.tencent.mm.plugin.card.sharecard.a.b.hU(bVar.ZA());
                    iX = com.tencent.mm.plugin.card.sharecard.a.b.iX(bVar.ZE());
                    if (TextUtils.isEmpty(pT)) {
                    }
                    if (TextUtils.isEmpty(bVar.ZB())) {
                        aVar.eHa.setText("");
                    } else {
                        if (TextUtils.isEmpty(com.tencent.mm.plugin.card.b.j.qy(bVar.ZB()))) {
                            aVar.eHa.setText("");
                        } else {
                            aVar.eHa.setText(e.a(this.mContext, this.mContext.getResources().getString(2131231681, new Object[]{pT}), this.mContext.getResources().getDimensionPixelOffset(2131493202)));
                        }
                    }
                    pU = com.tencent.mm.plugin.card.sharecard.a.b.pU(bVar.ZA());
                    if (pU > 1) {
                    }
                    aVar.eHe.setVisibility(8);
                    if (bVar.Zv().mlg != null) {
                    }
                    aVar.eGT.setVisibility(8);
                }
                if (i == this.eGK.getCount() - 1) {
                }
                layoutParams = (LayoutParams) aVar.eGW.getLayoutParams();
                if (layoutParams.bottomMargin != 0) {
                    layoutParams.bottomMargin = 0;
                    aVar.eGW.setLayoutParams(layoutParams);
                }
                this.eGL = (System.currentTimeMillis() - currentTimeMillis) + this.eGL;
                this.eGM++;
                if (this.eGQ.contains(bVar.Zz())) {
                    this.eGQ.add(bVar.Zz());
                    this.eGR.add(bVar.ZA());
                    this.eGP.add(Integer.valueOf(i));
                }
                return view;
            }
        }
        obj = null;
        if (obj != null) {
            aVar.eGU.setVisibility(0);
            aVar.eGU.setText(bVar2.iR(ZE));
            if (TextUtils.isEmpty(bVar2.ZD())) {
                aVar.eGV.setVisibility(0);
                aVar.eGV.setText(bVar2.ZD());
            } else {
                aVar.eGV.setVisibility(8);
            }
        } else {
            aVar.eGU.setVisibility(8);
            aVar.eGV.setVisibility(8);
            aVar.eGU.setText("");
        }
        if (bVar.Zh()) {
            aVar.eGX.setVisibility(0);
            aVar.eGY.setVisibility(0);
            aVar.eGT.setVisibility(0);
            aVar.eGZ.setVisibility(0);
            aVar.eHe.setVisibility(0);
            aVar.eHd.setVisibility(0);
            aVar.eHa.setVisibility(0);
            aVar.eHb.setVisibility(0);
            aVar.eHc.setVisibility(8);
            aVar.eGY.setText(bVar.Zv().eCD);
            if (!bVar.Ze()) {
                if (bVar.Zv().mkN == null) {
                }
                stringBuilder = new StringBuilder();
                stringBuilder.append(((ld) bVar.Zv().mkN.get(0)).title);
                stringBuilder.append("-");
                stringBuilder.append(((ld) bVar.Zv().mkN.get(1)).title);
                aVar.eGZ.setText(stringBuilder.toString());
            } else {
                aVar.eGZ.setText(bVar.Zv().title);
            }
            k.a(aVar.eGX, bVar.Zv().eBM, this.mContext.getResources().getDimensionPixelSize(2131493362), 2130838736, true);
            aVar.eGY.setTextColor(this.mContext.getResources().getColor(2131689589));
            pT = com.tencent.mm.plugin.card.sharecard.a.b.pT(bVar.ZA());
            if (TextUtils.isEmpty(pT)) {
                aVar.eHb.setText(pT);
            } else {
                aVar.eHb.setText("");
            }
            pT = com.tencent.mm.plugin.card.sharecard.a.b.hU(bVar.ZA());
            iX = com.tencent.mm.plugin.card.sharecard.a.b.iX(bVar.ZE());
            if (TextUtils.isEmpty(pT)) {
            }
            if (TextUtils.isEmpty(bVar.ZB())) {
                if (TextUtils.isEmpty(com.tencent.mm.plugin.card.b.j.qy(bVar.ZB()))) {
                    aVar.eHa.setText(e.a(this.mContext, this.mContext.getResources().getString(2131231681, new Object[]{pT}), this.mContext.getResources().getDimensionPixelOffset(2131493202)));
                } else {
                    aVar.eHa.setText("");
                }
            } else {
                aVar.eHa.setText("");
            }
            pU = com.tencent.mm.plugin.card.sharecard.a.b.pU(bVar.ZA());
            if (pU > 1) {
            }
            aVar.eHe.setVisibility(8);
            if (bVar.Zv().mlg != null) {
            }
            aVar.eGT.setVisibility(8);
        } else {
            aVar.eGX.setVisibility(8);
            aVar.eGY.setVisibility(8);
            aVar.eGT.setVisibility(8);
            aVar.eGZ.setVisibility(8);
            aVar.eHe.setVisibility(8);
            aVar.eHd.setVisibility(8);
            aVar.eHa.setVisibility(8);
            aVar.eHb.setVisibility(8);
            aVar.eHc.setVisibility(0);
            aVar.eHc.setText(this.mContext.getResources().getString(2131231661));
        }
        if (i == this.eGK.getCount() - 1) {
        }
        layoutParams = (LayoutParams) aVar.eGW.getLayoutParams();
        if (layoutParams.bottomMargin != 0) {
            layoutParams.bottomMargin = 0;
            aVar.eGW.setLayoutParams(layoutParams);
        }
        this.eGL = (System.currentTimeMillis() - currentTimeMillis) + this.eGL;
        this.eGM++;
        if (this.eGQ.contains(bVar.Zz())) {
            this.eGQ.add(bVar.Zz());
            this.eGR.add(bVar.ZA());
            this.eGP.add(Integer.valueOf(i));
        }
        return view;
    }

    public final void q(View view, int i) {
    }

    public final void r(View view, int i) {
    }

    public final void a(View view, int i, OnClickListener onClickListener) {
    }

    private CardTagTextView aaX() {
        if (this.eGS.size() == 0) {
            return new CardTagTextView(this.mContext);
        }
        return (CardTagTextView) this.eGS.removeFirst();
    }
}
