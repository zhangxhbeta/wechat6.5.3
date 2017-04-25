package com.tencent.mm.plugin.collect.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.pluginsdk.ui.d.e;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.u;
import com.tencent.mm.u.b;
import com.tencent.mm.u.n;
import com.tencent.mm.ui.base.preference.Preference;

public final class a extends Preference {
    String bZy = null;
    private TextView eXB = null;
    private ImageView eXC = null;
    private Context mContext = null;
    String mTitle = null;
    private View mView = null;

    public a(Context context) {
        super(context);
        this.mContext = context;
        setLayoutResource(2130903390);
    }

    public a(Context context, byte b) {
        super(context);
        this.mContext = context;
        setLayoutResource(2130903389);
    }

    public final View getView(View view, ViewGroup viewGroup) {
        if (this.mView == null) {
            this.mView = onCreateView(viewGroup);
        }
        onBindView(this.mView);
        return this.mView;
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        this.eXB = (TextView) view.findViewById(16908310);
        this.eXC = (ImageView) view.findViewById(2131756395);
        this.eXB.setText(e.a(this.mContext, this.mTitle, this.eXB.getTextSize()));
        if (be.kS(this.bZy)) {
            this.eXC.setVisibility(8);
            return;
        }
        this.eXC.setVisibility(0);
        ak.yW();
        u LW = c.wH().LW(this.bZy);
        if (LW == null || ((int) LW.chr) <= 0) {
            v.d("MicroMsg.CollectPayInfoPreference", "Receiver in contactStg and try to get contact");
            final long Ni = be.Ni();
            com.tencent.mm.model.ab.a.crZ.a(this.bZy, "", new com.tencent.mm.model.ab.c.a(this) {
                final /* synthetic */ a eXE;

                public final void p(String str, boolean z) {
                    if (z) {
                        v.v("MicroMsg.CollectPayInfoPreference", "getContact suc; cost=" + (be.Ni() - Ni) + " ms");
                        b.r(str, 3);
                        n.Bq().gD(str);
                    } else {
                        v.w("MicroMsg.CollectPayInfoPreference", "getContact failed");
                    }
                    com.tencent.mm.pluginsdk.ui.a.b.m(this.eXE.eXC, this.eXE.bZy);
                }
            });
            return;
        }
        com.tencent.mm.pluginsdk.ui.a.b.m(this.eXC, this.bZy);
    }
}
