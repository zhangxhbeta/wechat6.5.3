package com.tencent.mm.plugin.card.widget;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.appbrand.jsapi.br;
import com.tencent.mm.plugin.card.b.j;
import com.tencent.mm.plugin.card.b.k;
import com.tencent.mm.protocal.c.bcv;
import com.tencent.mm.protocal.c.ld;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.util.Iterator;

public final class b extends a {
    private final String TAG = "MicroMsg.CardWidgetCommon";
    protected TextView dID;
    private boolean eMj = false;
    protected TextView eNG;
    protected TextView eNH;
    protected Button eNI;
    protected LinearLayout eNJ;
    protected TextView eNK;
    protected ImageView eNL;
    protected View eNM;
    protected ImageView eNN;

    public b(Context context) {
        super(context);
    }

    protected final void acQ() {
        this.dID = (TextView) this.eND.findViewById(2131755917);
        this.eNG = (TextView) this.eND.findViewById(2131755999);
        this.eNH = (TextView) this.eND.findViewById(2131756001);
        this.eNI = (Button) this.eND.findViewById(2131756000);
        this.eNJ = (LinearLayout) this.eND.findViewById(2131755786);
        this.eNL = (ImageView) this.eNJ.findViewById(2131755998);
        this.eNM = this.eND.findViewById(2131755787);
        this.eNN = (ImageView) this.eND.findViewById(2131755788);
        this.eNK = (TextView) this.eND.findViewById(2131755937);
    }

    protected final void acR() {
        if (this.eBg.Zv().mkN != null && this.eBg.Zv().mkN.size() > 0) {
            ld ldVar = (ld) this.eBg.Zv().mkN.get(0);
            if (!be.kS(ldVar.title)) {
                this.dID.setText(ldVar.title);
            }
            if (be.kS(ldVar.eBN)) {
                this.eNG.setVisibility(8);
            } else {
                this.eNG.setText(ldVar.eBN);
                this.eNG.setVisibility(0);
            }
            LayoutParams layoutParams = (LayoutParams) this.eNG.getLayoutParams();
            if (be.kS(ldVar.eBO)) {
                this.eNH.setVisibility(8);
                layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelSize(2131493138);
            } else {
                this.eNH.setText(ldVar.eBO);
                this.eNH.setVisibility(0);
                layoutParams.bottomMargin = 0;
            }
            this.eNG.setLayoutParams(layoutParams);
            this.eNG.invalidate();
        }
        if (this.eNI == null || this.eNN == null) {
            v.e("MicroMsg.CardWidgetCommon", "consumeBtn == null || mCardCodeImg == null");
        } else if (this.eBg.Zw() == null) {
            v.e("MicroMsg.CardWidgetCommon", "mCardInfo.getDataInfo() == null");
            this.eNI.setVisibility(8);
            this.eNN.setVisibility(8);
        } else {
            if (this.eBg.Zw().mkv != null) {
                v.i("MicroMsg.CardWidgetCommon", "operate_field.title is " + this.eBg.Zw().mkv.title);
                v.d("MicroMsg.CardWidgetCommon", "operate_field.url is " + this.eBg.Zw().mkv.url);
                v.i("MicroMsg.CardWidgetCommon", "operate_field.aux_title is " + this.eBg.Zw().mkv.eBO);
            }
            ld ldVar2 = this.eBg.Zw().mkw;
            if (ldVar2 != null) {
                v.i("MicroMsg.CardWidgetCommon", "limit_field.title is " + ldVar2.title);
                v.i("MicroMsg.CardWidgetCommon", "limit_field.show_flag is " + ldVar2.mlB);
                v.i("MicroMsg.CardWidgetCommon", "limit_field.aux_title is " + ldVar2.eBO);
            }
            bcv com_tencent_mm_protocal_c_bcv = this.eBg.Zv().mlg;
            LinearLayout linearLayout = (LinearLayout) this.eNJ.findViewById(2131756002);
            if (com_tencent_mm_protocal_c_bcv == null || be.bP(com_tencent_mm_protocal_c_bcv.mYF)) {
                linearLayout.setVisibility(8);
            } else {
                linearLayout.setVisibility(0);
                linearLayout.removeAllViews();
                Iterator it = com_tencent_mm_protocal_c_bcv.mYF.iterator();
                while (it.hasNext()) {
                    ld ldVar3 = (ld) it.next();
                    View inflate = LayoutInflater.from(this.mContext).inflate(2130903214, null);
                    TextView textView = (TextView) inflate.findViewById(2131755790);
                    ((TextView) inflate.findViewById(2131755789)).setText(ldVar3.title);
                    textView.setText(ldVar3.eBN);
                    linearLayout.addView(inflate);
                }
            }
            if (ldVar2 != null && !TextUtils.isEmpty(ldVar2.title) && ldVar2.mlB != 0 && this.eBg.Zr()) {
                this.eNI.setClickable(false);
                this.eNI.setVisibility(0);
                this.eNI.setTextColor(this.mContext.getResources().getColor(2131690182));
                this.eNI.setText(ldVar2.title);
                if (ldVar2 == null || TextUtils.isEmpty(ldVar2.eBN)) {
                    this.eNK.setVisibility(8);
                } else {
                    this.eNK.setText(ldVar2.eBN);
                    this.eNK.setVisibility(0);
                }
                this.eNN.setVisibility(8);
                if ((ldVar2.mlB & 2) > 0) {
                    this.eNI.setBackgroundDrawable(j.t(this.mContext, j.am(this.eBg.Zv().coN, br.CTRL_INDEX)));
                    this.eNK.setTextColor(j.qv(this.eBg.Zv().coN));
                } else if ((ldVar2.mlB & 4) > 0) {
                    this.eNI.setBackgroundDrawable(j.t(this.mContext, this.mContext.getResources().getColor(2131689814)));
                    this.eNK.setTextColor(this.mContext.getResources().getColor(2131689906));
                } else {
                    this.eNI.setBackgroundDrawable(j.t(this.mContext, j.qv(this.eBg.Zv().coN)));
                    this.eNK.setTextColor(this.mContext.getResources().getColor(2131689906));
                }
            } else if (this.eBg.Zw().mkv != null && !TextUtils.isEmpty(this.eBg.Zw().mkv.title) && !TextUtils.isEmpty(this.eBg.Zw().mkv.url) && this.eBg.Zr()) {
                this.eNI.setClickable(true);
                this.eNI.setVisibility(0);
                this.eNI.setBackgroundDrawable(j.t(this.mContext, j.qv(this.eBg.Zv().coN)));
                this.eNI.setTextColor(this.mContext.getResources().getColorStateList(2131690182));
                this.eNI.setText(this.eBg.Zw().mkv.title);
                if (this.eBg.Zw().mkv == null || TextUtils.isEmpty(this.eBg.Zw().mkv.eBO)) {
                    this.eNK.setVisibility(8);
                } else {
                    this.eNK.setTextColor(this.mContext.getResources().getColor(2131689906));
                    this.eNK.setText(this.eBg.Zw().mkv.eBO);
                    this.eNK.setVisibility(0);
                }
                if (TextUtils.isEmpty(this.eBg.Zw().code)) {
                    this.eNN.setVisibility(8);
                } else {
                    this.eNN.setVisibility(0);
                }
            } else if (!TextUtils.isEmpty(this.eBg.Zw().code) && this.eBg.Zr()) {
                v.i("MicroMsg.CardWidgetCommon", "mCardInfo.getDataInfo().code is valid");
                this.eNN.setVisibility(8);
                this.eNK.setVisibility(8);
                this.eNI.setClickable(true);
                this.eNI.setVisibility(0);
                this.eNI.setBackgroundDrawable(j.t(this.mContext, j.qv(this.eBg.Zv().coN)));
                this.eNI.setTextColor(this.mContext.getResources().getColorStateList(2131690182));
                this.eNI.setText(2131231707);
            } else if (this.eBg.Zr()) {
                v.i("MicroMsg.CardWidgetCommon", "operate_field and code is empty!");
                this.eNI.setVisibility(8);
                this.eNK.setVisibility(8);
                this.eNN.setVisibility(8);
            } else {
                v.i("MicroMsg.CardWidgetCommon", "mCardInfo.getDataInfo().status is " + this.eBg.Zw().status);
                this.eNN.setVisibility(8);
                this.eNK.setVisibility(8);
                this.eNI.setClickable(true);
                this.eNI.setVisibility(0);
                this.eNI.setTextColor(this.mContext.getResources().getColor(2131689769));
                this.eNI.setBackgroundDrawable(j.t(this.mContext, this.mContext.getResources().getColor(2131689586)));
                if (TextUtils.isEmpty(this.eBg.Zv().mll)) {
                    k.b(this.eNI, this.eBg.Zw().status);
                } else {
                    this.eNI.setText(this.eBg.Zv().mll);
                }
            }
        }
        acS();
        this.eNJ.setBackgroundDrawable(this.mContext.getResources().getDrawable(2130837892));
        acT();
        this.eND.invalidate();
    }

    private void acS() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eNJ.getLayoutParams();
        if (this.eBg.Za()) {
            this.eNE.setVisibility(0);
            this.eNL.setVisibility(8);
            layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(2131493345);
        } else if (this.eBg.Zb() && this.eMj) {
            this.eNE.setVisibility(8);
            this.eNL.setVisibility(8);
            layoutParams.topMargin = 0;
        } else if (this.eBg.Zb()) {
            this.eNE.setVisibility(0);
            this.eNL.setVisibility(8);
            layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(2131493345);
        }
        this.eNJ.setLayoutParams(layoutParams);
    }

    public final void jm(int i) {
        RelativeLayout.LayoutParams layoutParams;
        this.eNJ.setBackgroundResource(i);
        this.eNL.setVisibility(8);
        if (i == 0) {
            layoutParams = (RelativeLayout.LayoutParams) this.eNJ.getLayoutParams();
            if (this.eBg.Za()) {
                this.eNE.setVisibility(8);
                layoutParams.topMargin = 0;
                this.eNL.setVisibility(0);
                k.a(this.eNL, this.eBg.Zv().eBM, this.mContext.getResources().getDimensionPixelSize(2131493341), 2130838736, false);
            } else if (this.eBg.Zb() && this.eMj) {
                this.eNE.setVisibility(8);
                layoutParams.topMargin = 0;
            }
            this.eNJ.setLayoutParams(layoutParams);
            this.eNJ.invalidate();
        } else {
            acS();
        }
        acT();
        layoutParams = (RelativeLayout.LayoutParams) this.eNM.getLayoutParams();
        if (i == 0) {
            layoutParams.leftMargin = 0;
            layoutParams.rightMargin = 0;
        } else {
            layoutParams.leftMargin = this.mContext.getResources().getDimensionPixelSize(2131492971);
            layoutParams.rightMargin = this.mContext.getResources().getDimensionPixelSize(2131492971);
        }
        this.eNM.setLayoutParams(layoutParams);
        this.eNM.invalidate();
        this.eND.invalidate();
    }

    private void acT() {
        LayoutParams layoutParams = (LayoutParams) this.eNI.getLayoutParams();
        if (this.eBg.Zw().mkv != null && !TextUtils.isEmpty(this.eBg.Zw().mkv.eBO)) {
            layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelOffset(2131493168);
        } else if (this.eBg.Zw().mkw != null && !TextUtils.isEmpty(this.eBg.Zw().mkw.eBN)) {
            layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelOffset(2131493168);
        } else if (this.eBg.Zv().mkN == null || this.eBg.Zv().mkN.size() <= 0) {
            layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelOffset(2131493138);
        } else {
            layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelOffset(2131493168);
        }
        this.eNI.setLayoutParams(layoutParams);
    }

    public final void setOnClickListener(OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
        if (this.eNI != null) {
            this.eNI.setOnClickListener(onClickListener);
        }
        if (this.eNN != null) {
            this.eNN.setOnClickListener(onClickListener);
        }
    }

    public final void j(boolean z, boolean z2) {
        if (this.eNI != null) {
            ld ldVar = this.eBg.Zw().mkw;
            if (ldVar != null && !TextUtils.isEmpty(ldVar.title) && ldVar.mlB != 0 && this.eBg.Zr()) {
                this.eNI.setClickable(false);
                this.eNI.setVisibility(0);
                this.eNN.setVisibility(8);
            } else if (this.eBg.Zw().mkv != null && !TextUtils.isEmpty(this.eBg.Zw().mkv.title) && !TextUtils.isEmpty(this.eBg.Zw().mkv.url) && this.eBg.Zr()) {
                this.eNI.setVisibility(0);
                this.eNI.setEnabled(true);
                if (TextUtils.isEmpty(this.eBg.Zw().code) || this.eBg.Zw().mkn == 0) {
                    this.eNN.setVisibility(8);
                } else {
                    this.eNN.setVisibility(0);
                }
            } else if (z && !TextUtils.isEmpty(this.eBg.Zw().code) && this.eBg.Zr()) {
                this.eNI.setVisibility(0);
                this.eNI.setEnabled(z2);
                this.eNN.setVisibility(8);
            } else if (!z || this.eBg.Zr()) {
                this.eNI.setVisibility(8);
                this.eNN.setVisibility(8);
            } else {
                this.eNI.setVisibility(0);
                this.eNI.setEnabled(false);
                this.eNN.setVisibility(8);
            }
        }
    }

    public final void acU() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eNJ.getLayoutParams();
        if (this.eBg.Zb()) {
            this.eNE.setVisibility(0);
            layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(2131493345);
        }
        this.eNJ.setLayoutParams(layoutParams);
        this.eNJ.invalidate();
    }

    public final void cn(boolean z) {
        this.eMj = z;
        if (z) {
            this.eNM.setVisibility(0);
        } else {
            this.eNM.setVisibility(8);
        }
    }
}
