package com.tencent.mm.plugin.f2f;

import android.content.Context;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ah.a;

public class F2FButton extends RelativeLayout {
    private int count = 0;
    private View fIV;
    private TextView fIW;
    private ah fIX = new ah(Looper.getMainLooper(), new a(this) {
        final /* synthetic */ F2FButton fIY;

        {
            this.fIY = r1;
        }

        public final boolean oU() {
            this.fIY.fIW.setText((10 - this.fIY.count));
            this.fIY.count = this.fIY.count + 1;
            if (this.fIY.count == 10) {
                return false;
            }
            return true;
        }
    }, true);

    public F2FButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public F2FButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(2130903579, this);
        this.fIV = findViewById(2131756876);
        this.fIW = (TextView) findViewById(2131756877);
        this.fIV.setVisibility(4);
        this.fIW.setVisibility(4);
        setClickable(true);
    }
}
