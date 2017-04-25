package com.tencent.mm.ui.base;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import com.tencent.mm.bd.a;
import com.tencent.mm.sdk.platformtools.v;

public final class k extends AlertDialog {
    private ListView Eq;
    private View eEX;
    public BaseAdapter eGK;
    public OnItemClickListener lSE;
    private Context mContext;
    private CharSequence up;

    public k(Context context) {
        super(context, 2131559263);
        this.mContext = context;
        if (a.dt(this.mContext)) {
            this.eEX = View.inflate(this.mContext, 2130903993, null);
        } else {
            this.eEX = View.inflate(this.mContext, 2130903992, null);
        }
        this.Eq = (ListView) this.eEX.findViewById(2131756740);
    }

    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(this.eEX);
    }

    public final void setTitle(CharSequence charSequence) {
        if (charSequence != null) {
            this.up = charSequence;
        } else {
            this.up = null;
        }
    }

    public final void show() {
        if (this.up != null) {
            this.up.length();
        }
        if (this.lSE != null) {
            this.Eq.setOnItemClickListener(this.lSE);
        }
        if (this.eGK != null) {
            this.Eq.setAdapter(this.eGK);
        }
        super.show();
    }

    public final void dismiss() {
        try {
            super.dismiss();
        } catch (Exception e) {
            v.e("MicroMsg.MMListDialog", "dismiss exception, e = " + e.getMessage());
        }
    }
}
