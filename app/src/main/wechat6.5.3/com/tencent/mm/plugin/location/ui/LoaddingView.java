package com.tencent.mm.plugin.location.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.sdk.platformtools.be;

public class LoaddingView extends LinearLayout implements c {
    private TextView gTI;
    private ProgressBar gTJ;
    private Animation gTK;
    private View gTL;
    private boolean gTM = false;
    private String gTN = "";

    @TargetApi(11)
    public LoaddingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    public LoaddingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    private void init(Context context) {
        this.gTK = AnimationUtils.loadAnimation(context, 2130968692);
        View inflate = LayoutInflater.from(context).inflate(2130903869, this, true);
        this.gTJ = (ProgressBar) inflate.findViewById(2131757715);
        this.gTI = (TextView) inflate.findViewById(2131757716);
        this.gTL = inflate.findViewById(2131757713);
        this.gTI.setText("");
        this.gTI.setVisibility(0);
        this.gTJ.setVisibility(0);
    }

    public final void setText(String str) {
        if (this.gTI != null && this.gTJ != null && !this.gTM) {
            if (be.kS(str)) {
                this.gTI.setText("");
                this.gTI.setVisibility(0);
                this.gTJ.setVisibility(0);
                return;
            }
            this.gTI.setText(str);
            this.gTJ.setVisibility(8);
            this.gTI.setVisibility(0);
        }
    }

    public final String awA() {
        return this.gTN;
    }
}
