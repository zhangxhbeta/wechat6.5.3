package com.tencent.mm.plugin.wallet_core.ui.view;

import android.content.Context;
import android.text.TextUtils.TruncateAt;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;

public class SwitchPhoneItemView extends RelativeLayout {
    private TextView kWH;
    private TextView kWI;
    ImageView kWJ;

    public SwitchPhoneItemView(Context context) {
        super(context);
        bF(context);
    }

    public SwitchPhoneItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        bF(context);
    }

    public SwitchPhoneItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        bF(context);
    }

    private void bF(Context context) {
        View inflate = inflate(context, 2130904685, this);
        this.kWH = (TextView) inflate.findViewById(2131760031);
        this.kWI = (TextView) inflate.findViewById(2131760032);
        this.kWJ = (ImageView) inflate.findViewById(2131760033);
    }

    public final void a(CharSequence charSequence, CharSequence charSequence2) {
        if (be.D(charSequence)) {
            this.kWH.setVisibility(8);
        } else {
            if (charSequence.toString().startsWith("86")) {
                v.i("SwitchPhoneItemView", "cut 86 prefix");
                charSequence = charSequence.subSequence(2, charSequence.length());
            }
            this.kWH.setText(charSequence);
        }
        if (be.D(charSequence2)) {
            this.kWI.setVisibility(8);
            return;
        }
        this.kWI.setMaxLines(2);
        this.kWI.setSelected(true);
        this.kWI.setEllipsize(TruncateAt.MIDDLE);
        this.kWI.setText(charSequence2);
        this.kWI.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
