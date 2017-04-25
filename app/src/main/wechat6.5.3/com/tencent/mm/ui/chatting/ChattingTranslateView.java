package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;

public class ChattingTranslateView extends LinearLayout {
    private String bpg;
    private ImageView ltd;
    private TextView osI;
    private boolean osJ;
    a osK;
    private boolean osL;

    public enum a {
        NoTranslate,
        Translating,
        Translated
    }

    public ChattingTranslateView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.osJ = false;
        this.osK = null;
        this.osL = false;
        init();
    }

    public ChattingTranslateView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet);
        init();
    }

    public final void jJ(boolean z) {
        this.osL = z;
        if (z) {
            super.setVisibility(8);
        }
    }

    private void init() {
        int applyDimension = (int) TypedValue.applyDimension(1, 3.0f, getResources().getDisplayMetrics());
        this.ltd = new ImageView(getContext());
        LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 16;
        layoutParams.setMargins(applyDimension, applyDimension, 0, applyDimension);
        this.ltd.setLayoutParams(layoutParams);
        addView(this.ltd);
        this.osI = new TextView(getContext());
        layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(applyDimension, applyDimension, applyDimension, applyDimension);
        layoutParams.gravity = 16;
        this.osI.setLayoutParams(layoutParams);
        this.osI.setTextSize(1, 11.0f);
        this.osI.setTextColor(-1);
        addView(this.osI);
        setBackgroundResource(2130837935);
        a(a.NoTranslate);
    }

    public final void bEU() {
        a(a.NoTranslate);
    }

    public final void bEV() {
        a(a.Translating);
    }

    public final void OR(String str) {
        if (!be.ma(this.bpg).equals(be.ma(str))) {
            this.osJ = true;
        }
        this.bpg = str;
        a(a.Translated);
    }

    private void a(a aVar) {
        if (this.osL) {
            super.setVisibility(8);
        } else if (this.osK != aVar || this.osJ) {
            this.osJ = false;
            v.d("MicroMsg.ChattingTranslateView", "from status %s to status %s", this.osK, aVar);
            this.osK = aVar;
            switch (aVar) {
                case NoTranslate:
                    super.setVisibility(8);
                    break;
                case Translating:
                    super.setVisibility(0);
                    this.ltd.setImageResource(2131165983);
                    this.osI.setText(2131231908);
                    break;
                case Translated:
                    super.setVisibility(0);
                    this.ltd.setImageResource(2131165982);
                    if (!be.kS(this.bpg)) {
                        this.osI.setText(this.bpg);
                        break;
                    } else {
                        this.osI.setText(2131231907);
                        break;
                    }
            }
            invalidate();
        }
    }
}
