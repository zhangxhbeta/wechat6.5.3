package com.tencent.mm.plugin.remittance.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.wallet_core.ui.e;

public final class a extends i implements OnClickListener {
    private int cVh;
    protected View eEX;
    private OnClickListener isy;

    private a(Context context) {
        this(context, (byte) 0);
    }

    private a(Context context, byte b) {
        super(context, 2131559267);
        this.cVh = 0;
        this.eEX = View.inflate(context, 2130904276, null);
        setContentView(this.eEX);
        ((Button) this.eEX.findViewById(2131757038)).setOnClickListener(this);
        ((Button) this.eEX.findViewById(2131758899)).setOnClickListener(this);
    }

    public final void onClick(View view) {
        if (view.getId() != 2131757039) {
            v.i("RemittanceChargeDialog", "click cancel");
            dismiss();
        }
        if (view.getId() != 2131757038) {
            return;
        }
        if (this.cVh == 1) {
            g.iuh.h(12689, new Object[]{Integer.valueOf(11), Integer.valueOf(1)});
            return;
        }
        g.iuh.h(12689, new Object[]{Integer.valueOf(2), Integer.valueOf(1)});
    }

    public static void a(Context context, int i, String str, double d) {
        v.i("RemittanceChargeDialog", "showAlert");
        Object aVar = new a(context);
        aVar.cVh = i;
        v.i("RemittanceChargeDialog", "showTips");
        TextView textView = (TextView) aVar.findViewById(2131758889);
        if (be.kS(str)) {
            v.e("RemittanceChargeDialog", "desc is null");
        } else {
            textView.setText(str);
            textView.setVisibility(0);
        }
        ((TextView) aVar.findViewById(2131758891)).setText(context.getResources().getString(2131234522, new Object[]{e.l(d)}));
        aVar.findViewById(2131758898).setVisibility(0);
        aVar.findViewById(2131758890).setVisibility(0);
        aVar.show();
        com.tencent.mm.ui.base.g.a(context, aVar);
    }

    public static a a(Context context, int i, double d, double d2, double d3, String str, OnClickListener onClickListener) {
        v.i("RemittanceChargeDialog", "showCostDetail");
        a aVar = new a(context);
        aVar.cVh = i;
        if (d == 0.0d) {
            v.i("RemittanceChargeDialog", "showCostDetail ::: remian_fee = 0");
        }
        ((TextView) aVar.findViewById(2131758895)).setText(e.l(d));
        ((TextView) aVar.findViewById(2131758896)).setText(e.l(d2));
        if (d3 == 0.0d) {
            v.e("RemittanceChargeDialog", "showCostDetail ::: transaction_costs = 0");
        }
        ((TextView) aVar.findViewById(2131758893)).setText(e.l(d3));
        aVar.findViewById(2131758892).setVisibility(0);
        if (!be.kS(str)) {
            TextView textView = (TextView) aVar.findViewById(2131758889);
            textView.setText(str);
            textView.setVisibility(0);
        }
        aVar.findViewById(2131758897).setVisibility(0);
        aVar.isy = onClickListener;
        aVar.findViewById(2131757039).setOnClickListener(new OnClickListener(aVar) {
            final /* synthetic */ a isz;

            {
                this.isz = r1;
            }

            public final void onClick(View view) {
                if (this.isz.isy != null) {
                    this.isz.isy.onClick(view);
                    this.isz.dismiss();
                }
            }
        });
        aVar.show();
        com.tencent.mm.ui.base.g.a(context, aVar);
        if (i == 1) {
            g.iuh.h(12689, new Object[]{Integer.valueOf(10), Integer.valueOf(1)});
        } else {
            g.iuh.h(12689, new Object[]{Integer.valueOf(1), Integer.valueOf(1)});
        }
        return aVar;
    }
}
