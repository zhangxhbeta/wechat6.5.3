package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Context;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.u;
import com.tencent.mm.u.d.a;
import com.tencent.mm.u.n;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;

public final class PluginPreference extends Preference implements a {
    private MMActivity aWn;
    private ImageView cHH;
    private String fgv;
    private int fgw;
    int fgx;
    String iJO;
    String iJP;
    int iJQ;

    public PluginPreference(Context context) {
        this(context, null);
    }

    public PluginPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PluginPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fgv = "";
        this.fgw = -1;
        this.fgx = 8;
        this.cHH = null;
        this.iJQ = 255;
        this.aWn = (MMActivity) context;
        setLayoutResource(2130903996);
        n.AX().a(this);
    }

    public final boolean zm(String str) {
        ak.yW();
        u LX = c.wH().LX(str);
        if (LX == null || ((int) LX.chr) == 0) {
            v.e("MicroMsg.PluginPreference", "plugin do not exist");
            return false;
        }
        this.iJO = LX.field_username;
        this.iJP = LX.tT();
        setKey("settings_plugins_list_#" + this.iJO);
        return true;
    }

    private void aKp() {
        if (this.cHH != null) {
            b.m(this.cHH, this.iJO);
        }
    }

    protected final View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        LayoutInflater layoutInflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(2131755329);
        viewGroup2.removeAllViews();
        layoutInflater.inflate(2130904025, viewGroup2);
        return onCreateView;
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        this.cHH = (ImageView) view.findViewById(2131756901);
        this.cHH.setAlpha(this.iJQ);
        TextView textView = (TextView) view.findViewById(2131758235);
        if (textView != null) {
            textView.setVisibility(this.fgx);
            textView.setText(this.fgv);
            if (this.fgw != -1) {
                textView.setBackgroundDrawable(com.tencent.mm.bd.a.a(this.aWn, this.fgw));
            }
        }
        aKp();
    }

    public final void aO(String str, int i) {
        this.fgv = str;
        this.fgw = i;
    }

    public final void gM(String str) {
        if (this.iJO != null && this.iJO.equals(str)) {
            new ac(Looper.getMainLooper()).post(new Runnable(this) {
                final /* synthetic */ PluginPreference iJR;

                {
                    this.iJR = r1;
                }

                public final void run() {
                    this.iJR.aKp();
                }
            });
        }
    }
}
