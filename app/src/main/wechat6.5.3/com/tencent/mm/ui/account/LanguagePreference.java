package com.tencent.mm.ui.account;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.preference.Preference;

public class LanguagePreference extends Preference {
    public a nIA;

    public static class a {
        public boolean gxa;
        String nIB;
        private String nIC;
        public String nID;

        public a(String str, String str2, String str3, boolean z) {
            this.nIB = str;
            this.nIC = str2;
            this.nID = str3;
            this.gxa = z;
        }
    }

    public LanguagePreference(Context context) {
        this(context, null);
    }

    public LanguagePreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LanguagePreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setLayoutResource(2130903996);
    }

    public final void a(a aVar) {
        if (aVar == null || be.kS(aVar.nID)) {
            v.e("MicroMsg.LanguagePreference", "setInfo info error");
            return;
        }
        this.nIA = aVar;
        setKey(aVar.nID);
    }

    protected final View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        LayoutInflater layoutInflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(2131755329);
        viewGroup2.removeAllViews();
        layoutInflater.inflate(2130904020, viewGroup2);
        return onCreateView;
    }

    protected final void onBindView(View view) {
        int i = 1;
        super.onBindView(view);
        TextView textView = (TextView) view.findViewById(2131755626);
        CheckBox checkBox = (CheckBox) view.findViewById(2131757372);
        int i2 = textView != null ? 1 : 0;
        if (checkBox == null) {
            i = 0;
        }
        if ((i & i2) != 0) {
            textView.setText(this.nIA.nIB);
            checkBox.setChecked(this.nIA.gxa);
        }
    }
}
