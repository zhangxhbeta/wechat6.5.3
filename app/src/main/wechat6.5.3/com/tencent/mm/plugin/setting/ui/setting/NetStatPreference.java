package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.format.DateFormat;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mm.R;
import com.tencent.mm.modelstat.j;
import com.tencent.mm.modelstat.p;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.preference.Preference;

public class NetStatPreference extends Preference {
    boolean iJI;

    public NetStatPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NetStatPreference(Context context, AttributeSet attributeSet, int i) {
        boolean z;
        super(context, attributeSet, i);
        this.iJI = false;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.b.aPv, i, 0);
        if (obtainStyledAttributes.getInt(0, 0) == 1) {
            z = true;
        } else {
            z = false;
        }
        this.iJI = z;
        obtainStyledAttributes.recycle();
        setSummary(context.getString(2131235078, new Object[]{Integer.valueOf(15)}));
    }

    protected final View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(2131755329);
        viewGroup2.removeAllViews();
        View.inflate(this.mContext, 2130904023, viewGroup2);
        return onCreateView;
    }

    protected final void onBindView(View view) {
        View netStatGroup;
        super.onBindView(view);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(2131758248);
        linearLayout.removeAllViews();
        int currentTimeMillis = (int) (System.currentTimeMillis() / 86400000);
        for (int i = 15; i > 0; i -= 5) {
            netStatGroup = new NetStatGroup(this.mContext);
            int i2 = (currentTimeMillis - i) + 1;
            boolean z = this.iJI;
            Object charSequence = DateFormat.format(netStatGroup.getContext().getString(2131232866, new Object[]{""}), ((long) i2) * 86400000).toString();
            netStatGroup.ilO.setText(charSequence);
            v.d("MicroMsg.NetStatGroup", "NetStat dataTime = " + charSequence);
            netStatGroup.iJH.removeAllViews();
            for (int i3 = 0; i3 < 5; i3++) {
                View netStatUnit = new NetStatUnit(netStatGroup.getContext());
                j gm = p.Km().gm(i2 + i3);
                if (gm != null) {
                    if (z) {
                        v.i("MicroMsg.NetStatUnit", "dknetflow peroid:%d wifi : %d %d %d %d", new Object[]{Integer.valueOf(gm.dcz), Integer.valueOf(gm.dcV), Integer.valueOf(gm.dcJ), Integer.valueOf(gm.dcX), Integer.valueOf(gm.dcL)});
                        netStatUnit.cn(gm.dcV + gm.dcJ, gm.dcL + gm.dcX);
                    } else {
                        v.i("MicroMsg.NetStatUnit", "dknetflow peroid:%d mobile : %d %d %d %d", new Object[]{Integer.valueOf(gm.dcz), Integer.valueOf(gm.dcU), Integer.valueOf(gm.dcI), Integer.valueOf(gm.dcW), Integer.valueOf(gm.dcK)});
                        netStatUnit.cn(gm.dcU + gm.dcI, gm.dcK + gm.dcW);
                    }
                }
                netStatUnit.setLayoutParams(new LayoutParams(-1, -1, 1.0f));
                netStatGroup.iJH.addView(netStatUnit);
            }
            linearLayout.addView(netStatGroup, -2, -1);
        }
        linearLayout = (LinearLayout) view.findViewById(2131758268);
        linearLayout.removeAllViews();
        View netStatGroup2 = new NetStatGroup(this.mContext);
        boolean z2 = this.iJI;
        netStatGroup2.removeAllViews();
        View.inflate(netStatGroup2.getContext(), 2130904122, netStatGroup2);
        netStatGroup2.iJH = (LinearLayout) netStatGroup2.findViewById(2131758248);
        netStatGroup = new NetStatRuler(netStatGroup2.getContext());
        netStatGroup.setTag(z2 ? "wifi" : "mobile");
        netStatGroup.setLayoutParams(new LayoutParams(-1, -1, 1.0f));
        netStatGroup2.iJH.addView(netStatGroup);
        linearLayout.addView(netStatGroup2);
    }
}
