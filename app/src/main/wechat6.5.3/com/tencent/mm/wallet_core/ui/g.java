package com.tencent.mm.wallet_core.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.ui.base.q;

public final class g extends q {
    private View Hq = null;
    private ProgressBar dVb;
    private Context mContext;
    private TextView nTM;

    private g(Context context) {
        super(context, 2131559263);
        this.mContext = context;
        if (this.Hq == null) {
            this.Hq = View.inflate(this.mContext, 2130904673, null);
            this.nTM = (TextView) this.Hq.findViewById(2131755640);
            this.dVb = (ProgressBar) this.Hq.findViewById(2131755639);
            setCanceledOnTouchOutside(true);
        }
    }

    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(this.Hq, new LayoutParams(-1, -1));
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.width = -2;
        attributes.height = -2;
        getWindow().addFlags(2);
        attributes.dimAmount = 0.65f;
        onWindowAttributesChanged(attributes);
    }

    public final void setCancelable(boolean z) {
        super.setCancelable(z);
        setCanceledOnTouchOutside(z);
    }

    public final void setMessage(CharSequence charSequence) {
        this.nTM.setText(charSequence);
    }

    public static Dialog a(Context context, CharSequence charSequence, boolean z, OnCancelListener onCancelListener) {
        g gVar = new g(context);
        gVar.setMessage(charSequence);
        gVar.setCancelable(z);
        gVar.setOnCancelListener(onCancelListener);
        gVar.setCanceledOnTouchOutside(false);
        gVar.show();
        return gVar;
    }

    public static Dialog a(Context context, boolean z, OnCancelListener onCancelListener) {
        View inflate = View.inflate(context, 2130904674, null);
        i iVar = new i(context, 2131559151);
        iVar.setCancelable(z);
        iVar.setContentView(inflate);
        iVar.setOnCancelListener(onCancelListener);
        iVar.show();
        return iVar;
    }

    public static Dialog e(Context context, OnCancelListener onCancelListener) {
        View inflate = View.inflate(context, 2130904674, null);
        i iVar = new i(context, 2131559151);
        iVar.setCancelable(true);
        iVar.setContentView(inflate);
        iVar.setCanceledOnTouchOutside(false);
        iVar.setOnCancelListener(onCancelListener);
        iVar.show();
        return iVar;
    }

    public final void dismiss() {
        try {
            super.dismiss();
        } catch (Exception e) {
            v.e("MicroMsg.WalletProgressDialog", "dismiss exception, e = " + e.getMessage());
        }
    }
}
