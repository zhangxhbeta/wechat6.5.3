package com.tencent.mm.ui.base;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.q;
import com.tencent.mmdb.database.SQLiteDatabase;

public final class p extends q {
    private View Hq;
    public ProgressBar dVb;
    private Context mContext;
    private TextView nTM;
    private int style;

    private p(Context context, int i, int i2) {
        int i3 = 2130904072;
        super(context, i);
        this.mContext = context;
        this.style = i2;
        switch (this.style) {
            case 1:
                i3 = 2130904073;
                break;
        }
        this.Hq = q.em(this.mContext).inflate(i3, null);
        this.nTM = (TextView) this.Hq.findViewById(2131755640);
        this.dVb = (ProgressBar) this.Hq.findViewById(2131755639);
        setCanceledOnTouchOutside(true);
    }

    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(this.Hq, new LayoutParams(-1, -1));
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.width = -1;
        attributes.height = -2;
        if (this.style == 2) {
            getWindow().addFlags(2);
            attributes.dimAmount = 0.65f;
        }
        onWindowAttributesChanged(attributes);
    }

    public final void setCancelable(boolean z) {
        super.setCancelable(z);
        setCanceledOnTouchOutside(z);
    }

    public final void setMessage(CharSequence charSequence) {
        this.nTM.setText(charSequence);
    }

    public static p a(Context context, CharSequence charSequence, boolean z, int i, OnCancelListener onCancelListener) {
        int i2 = 2131559263;
        switch (i) {
            case 0:
            case 1:
            case 2:
                break;
            default:
                i2 = 2131559268;
                break;
        }
        p pVar = new p(context, i2, i);
        pVar.setMessage(charSequence);
        pVar.setCancelable(z);
        pVar.setOnCancelListener(onCancelListener);
        pVar.setCanceledOnTouchOutside(false);
        return pVar;
    }

    public static p b(Context context, CharSequence charSequence, boolean z, int i, OnCancelListener onCancelListener) {
        p a = a(context, charSequence, z, i, onCancelListener);
        a.show();
        return a;
    }

    public final void show() {
        try {
            super.show();
        } catch (Throwable e) {
            v.a("MicroMsg.MMProgressDialog", e, SQLiteDatabase.KeyEmpty, new Object[0]);
        }
    }

    public final void dismiss() {
        try {
            super.dismiss();
        } catch (Exception e) {
            v.e("MicroMsg.MMProgressDialog", "dismiss exception, e = " + e.getMessage());
        }
    }
}
