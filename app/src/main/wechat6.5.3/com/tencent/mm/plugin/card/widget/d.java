package com.tencent.mm.plugin.card.widget;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.mm.plugin.card.b.j;
import com.tencent.mm.plugin.card.b.k;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.protocal.c.ld;
import com.tencent.mm.sdk.platformtools.v;
import java.util.LinkedList;

public final class d extends a {
    private View eNQ;
    private TextView eNR;
    private TextView eNS;
    private View eNT;
    private TextView eNU;
    private TextView eNV;
    private View eNW;
    private View eNX;
    private View eNY;

    public d(Context context) {
        super(context);
    }

    protected final void acQ() {
        this.eNQ = this.eND.findViewById(2131755896);
        this.eNR = (TextView) this.eND.findViewById(2131755897);
        this.eNS = (TextView) this.eND.findViewById(2131755898);
        this.eNT = this.eND.findViewById(2131755899);
        this.eNU = (TextView) this.eND.findViewById(2131755900);
        this.eNV = (TextView) this.eND.findViewById(2131755901);
        this.eNX = this.eND.findViewById(2131755904);
        this.eNY = this.eND.findViewById(2131755903);
    }

    protected final void acR() {
        ld ldVar;
        if (this.eBg.Zv().mkN == null || this.eBg.Zv().mkN.size() <= 0) {
            v.i("MicroMsg.CardWidgetInvoice", "primary_fields is null");
        } else {
            LinkedList linkedList = this.eBg.Zv().mkN;
            ld ldVar2 = null;
            if (linkedList.size() == 1) {
                ldVar = (ld) linkedList.get(0);
            } else {
                ldVar = (ld) linkedList.get(0);
                ldVar2 = (ld) linkedList.get(1);
            }
            if (ldVar != null) {
                this.eNQ.setVisibility(0);
                this.eNR.setText(ldVar.title);
                this.eNS.setText(ldVar.eBN);
                if (!TextUtils.isEmpty(ldVar.mnE)) {
                    this.eNR.setTextColor(j.qv(ldVar.mnE));
                }
                if (!TextUtils.isEmpty(ldVar.mnF)) {
                    this.eNS.setTextColor(j.qv(ldVar.mnF));
                }
            }
            if (ldVar2 != null) {
                this.eNT.setVisibility(0);
                this.eNU.setText(ldVar2.title);
                this.eNV.setText(ldVar2.eBN);
                if (!TextUtils.isEmpty(ldVar2.mnE)) {
                    this.eNU.setTextColor(j.qv(ldVar2.mnE));
                }
                if (!TextUtils.isEmpty(ldVar2.mnF)) {
                    this.eNV.setTextColor(j.qv(ldVar2.mnF));
                }
            }
        }
        if (this.eBg.Za() && !this.eBg.Zg()) {
            v.i("MicroMsg.CardWidgetInvoice", "is not invoice, don't updateCardSecondaryFieldListView");
        } else if (this.eBg.Zw().mko == null || this.eBg.Zw().mko.size() <= 0) {
            if (this.eNW != null) {
                this.eNW.setVisibility(8);
            }
            this.eND.findViewById(2131755903).setVisibility(8);
        } else {
            if (this.eNW == null) {
                this.eNW = ((ViewStub) this.eND.findViewById(2131755902)).inflate();
            }
            this.eND.findViewById(2131755903).setVisibility(8);
            View view = this.eNW;
            b bVar = this.eBg;
            OnClickListener onClickListener = this.eFl;
            LinkedList linkedList2 = bVar.Zw().mko;
            if (linkedList2.size() == 1) {
                view.findViewById(2131755957).setVisibility(0);
                ldVar = (ld) linkedList2.get(0);
                ((TextView) view.findViewById(2131755958)).setText(ldVar.title);
                ((TextView) view.findViewById(2131755959)).setText(ldVar.eBN);
                view.findViewById(2131755957).setOnClickListener(onClickListener);
                if (!TextUtils.isEmpty(ldVar.mnE)) {
                    ((TextView) view.findViewById(2131755958)).setTextColor(j.qv(ldVar.mnE));
                }
                if (!TextUtils.isEmpty(ldVar.mnF)) {
                    ((TextView) view.findViewById(2131755959)).setTextColor(j.qv(ldVar.mnF));
                }
                view.findViewById(2131755960).setVisibility(8);
            } else if (linkedList2.size() >= 2) {
                ldVar = (ld) linkedList2.get(0);
                ((TextView) view.findViewById(2131755958)).setText(ldVar.title);
                ((TextView) view.findViewById(2131755959)).setText(ldVar.eBN);
                if (!TextUtils.isEmpty(ldVar.mnE)) {
                    ((TextView) view.findViewById(2131755958)).setTextColor(j.qv(ldVar.mnE));
                }
                if (!TextUtils.isEmpty(ldVar.mnF)) {
                    ((TextView) view.findViewById(2131755959)).setTextColor(j.qv(ldVar.mnF));
                }
                ldVar = (ld) linkedList2.get(1);
                ((TextView) view.findViewById(2131755961)).setText(ldVar.title);
                ((TextView) view.findViewById(2131755962)).setText(ldVar.eBN);
                if (!TextUtils.isEmpty(ldVar.mnE)) {
                    ((TextView) view.findViewById(2131755961)).setTextColor(j.qv(ldVar.mnE));
                }
                if (!TextUtils.isEmpty(ldVar.mnF)) {
                    ((TextView) view.findViewById(2131755962)).setTextColor(j.qv(ldVar.mnF));
                }
                view.findViewById(2131755957).setOnClickListener(onClickListener);
                view.findViewById(2131755960).setOnClickListener(onClickListener);
            }
        }
        if (this.eBg.Zr()) {
            this.eNX.setVisibility(8);
        } else {
            this.eNX.setVisibility(0);
            TextView textView = (TextView) this.eNX.findViewById(2131755994);
            if (TextUtils.isEmpty(this.eBg.Zv().mll)) {
                k.b(textView, this.eBg.Zw().status);
            } else {
                textView.setText(this.eBg.Zv().mll);
            }
        }
        if (this.eBg.Zw().mkx == null && this.eBg.Zr()) {
            this.eNY.setVisibility(0);
        } else {
            this.eNY.setVisibility(8);
        }
    }
}
