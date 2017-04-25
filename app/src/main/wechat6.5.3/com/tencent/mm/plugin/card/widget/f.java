package com.tencent.mm.plugin.card.widget;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.card.b.j;
import com.tencent.mm.plugin.card.b.k;
import com.tencent.mm.protocal.c.ix;
import com.tencent.mm.protocal.c.ld;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.util.ArrayList;

public final class f extends a {
    protected TextView dtY;
    public ArrayList<ix> eBn;
    private View eOh;
    private ImageView eOi;
    private TextView eOj;
    private TextView eOk;
    private View eOl;
    private TextView eOm;
    private TextView eOn;
    private ImageView eOo;
    private TextView eOp;

    public f(Context context) {
        super(context);
    }

    protected final void acQ() {
        this.dtY = (TextView) acP().findViewById(2131755917);
        this.eOh = acP().findViewById(2131755787);
        this.eOi = (ImageView) acP().findViewById(2131756007);
        this.eOj = (TextView) acP().findViewById(2131756008);
        this.eOk = (TextView) acP().findViewById(2131756009);
        this.eOl = acP().findViewById(2131756010);
        this.eOm = (TextView) acP().findViewById(2131756012);
        this.eOn = (TextView) acP().findViewById(2131756013);
        this.eOo = (ImageView) acP().findViewById(2131756011);
        this.eOp = (TextView) acP().findViewById(2131756014);
    }

    protected final void acR() {
        if (this.eBg.Zv().mlp != null && !TextUtils.isEmpty(this.eBg.Zv().mlp.title)) {
            this.eNF.setText(this.eBg.Zv().mlp.title);
        } else if (TextUtils.isEmpty(this.eBg.Zv().eCD)) {
            this.eNF.setText("");
        } else {
            this.eNF.setText(this.eBg.Zv().eCD);
        }
        if (this.eBg.Zv().mlp == null || TextUtils.isEmpty(this.eBg.Zv().mlp.eBN)) {
            this.dtY.setText("");
            this.dtY.setVisibility(8);
        } else {
            this.dtY.setText(this.eBg.Zv().mlp.eBN);
            this.dtY.setVisibility(0);
        }
        v.i("MicroMsg.CardWidgetTicket", "updateContentView()");
        if (be.kS(this.eBg.Zv().mkV)) {
            k.a(this.eOi, 2130837885, j.qv(this.eBg.Zv().coN));
        } else {
            k.a(this.mContext, this.eOi, this.eBg.Zv().mkV, this.mContext.getResources().getDimensionPixelSize(2131493381), j.qv(this.eBg.Zv().coN));
        }
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder stringBuilder2 = new StringBuilder();
        ld ldVar;
        if (this.eBg.Zv().mkN != null && this.eBg.Zv().mkN.size() >= 2) {
            v.i("MicroMsg.CardWidgetTicket", "primary_fields length is >= 2");
            ldVar = (ld) this.eBg.Zv().mkN.get(0);
            ld ldVar2 = (ld) this.eBg.Zv().mkN.get(1);
            stringBuilder.append(ldVar.title).append(" - ").append(ldVar2.title);
            if (!(TextUtils.isEmpty(ldVar.eBO) || TextUtils.isEmpty(ldVar2.eBO))) {
                stringBuilder2.append(ldVar.eBO).append(" ").append(ldVar.eBN);
                stringBuilder2.append(" - ");
                stringBuilder2.append(ldVar2.eBO).append(" ").append(ldVar2.eBN);
            }
        } else if (this.eBg.Zv().mkN != null && this.eBg.Zv().mkN.size() == 1) {
            v.i("MicroMsg.CardWidgetTicket", "primary_fields length is == 1");
            ldVar = (ld) this.eBg.Zv().mkN.get(0);
            stringBuilder.append(ldVar.title);
            stringBuilder2.append(ldVar.eBN);
        }
        if (TextUtils.isEmpty(stringBuilder.toString())) {
            this.eOj.setText("");
        } else {
            this.eOj.setText(stringBuilder.toString());
        }
        if (!TextUtils.isEmpty(stringBuilder2.toString())) {
            v.i("MicroMsg.CardWidgetTicket", "sub_title_builder is not empty!");
            this.eOk.setText(stringBuilder2.toString());
            this.eOk.setVisibility(0);
        } else if (TextUtils.isEmpty(this.eBg.Zv().mld)) {
            this.eOk.setVisibility(8);
        } else {
            v.i("MicroMsg.CardWidgetTicket", "primary_sub_title is not empty!");
            this.eOk.setText(this.eBg.Zv().mld);
            this.eOk.setVisibility(0);
        }
        v.e("MicroMsg.CardWidgetTicket", "updateShopView(), shop_count:" + this.eBg.Zv().mkR);
        if (this.eBg.Zv().mkR <= 0) {
            this.eOl.setVisibility(8);
            this.eOp.setVisibility(8);
        } else {
            this.eOl.setVisibility(0);
            this.eOl.setOnClickListener(this.eFl);
            k.a(this.eOo, 2130837886, j.qv(this.eBg.Zv().coN));
            ix ixVar = null;
            if (this.eBn != null && this.eBn.size() > 0) {
                ixVar = (ix) this.eBn.get(0);
            }
            if (this.eBg.Zv().mkR == 1 && ixVar != null) {
                this.eOm.setText(ixVar.name);
                this.eOn.setText(this.mContext.getString(2131231697, new Object[]{j.b(this.mContext, ixVar.mkD), ixVar.cJf}));
                this.eOp.setVisibility(8);
                this.eOl.setTag(ixVar.name);
            } else if (this.eBg.Zv().mkR > 1 && ixVar != null) {
                this.eOm.setText(ixVar.name);
                this.eOn.setText(this.mContext.getString(2131231697, new Object[]{j.b(this.mContext, ixVar.mkD), ixVar.cJf}));
                this.eOp.setVisibility(0);
                this.eOp.setOnClickListener(this.eFl);
                this.eOl.setTag(ixVar.name);
            } else if (this.eBg.Zv().mkR > 0) {
                this.eOm.setText(2131231594);
                this.eOn.setText(this.mContext.getString(2131231718, new Object[]{Integer.valueOf(this.eBg.Zv().mkR)}));
                this.eOp.setVisibility(8);
                this.eOp.setOnClickListener(null);
                this.eOl.setTag(this.mContext.getString(2131231594));
            }
        }
        if (this.eBg.Zu()) {
            this.eOh.setVisibility(8);
        } else {
            this.eOh.setVisibility(0);
        }
    }
}
