package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.modelsearch.h;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.e;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.preference.Preference;

public class SettingsAboutMMHeaderPreference extends Preference {
    String iKw = "";

    public SettingsAboutMMHeaderPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public SettingsAboutMMHeaderPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        TextView textView = (TextView) view.findViewById(2131759074);
        textView.setText(String.format("%s %s", new Object[]{view.getResources().getString(2131230720), this.iKw}));
        textView.setOnClickListener(new OnClickListener(this) {
            private long iKx = 0;
            final /* synthetic */ SettingsAboutMMHeaderPreference iKy;

            {
                this.iKy = r3;
            }

            public final void onClick(View view) {
                long Ni = be.Ni();
                if (this.iKx > Ni || Ni - this.iKx > 300) {
                    this.iKx = Ni;
                    return;
                }
                this.iKx = Ni;
                Context context = this.iKy.mContext;
                CharSequence stringBuilder = new StringBuilder();
                stringBuilder.append(String.format("[ver  ] %s %08X\n", new Object[]{f.b(context, d.lWh, true), Integer.valueOf(d.lWh)}));
                stringBuilder.append(e.bsN());
                stringBuilder.append(String.format("[cid  ] %d\n", new Object[]{Integer.valueOf(f.aPW)}));
                stringBuilder.append(String.format("[s.ver] %d\n", new Object[]{Integer.valueOf(h.cVT)}));
                View textView = new TextView(context);
                textView.setText(stringBuilder);
                textView.setGravity(19);
                textView.setTextSize(1, 10.0f);
                textView.setLayoutParams(new LayoutParams(-1, -2));
                textView.setTextColor(-16777216);
                textView.setTypeface(Typeface.MONOSPACE);
                int dimensionPixelSize = context.getResources().getDimensionPixelSize(2131493135);
                textView.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
                g.a(context, null, textView, null);
            }
        });
    }
}
