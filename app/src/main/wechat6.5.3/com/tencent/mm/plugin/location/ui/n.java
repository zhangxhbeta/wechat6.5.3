package com.tencent.mm.plugin.location.ui;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.plugin.e.d;
import com.tencent.mm.plugin.location.model.LocationInfo;
import com.tencent.mm.sdk.platformtools.v;

public final class n implements c {
    public boolean bcR = false;
    private String gRG;
    public double gRK = 1000000.0d;
    public double gRL = 1000000.0d;
    private TextView gTI;
    private ProgressBar gTJ;
    public String gTN = "";
    public boolean gUo = true;
    public View gUp;
    public d gUq;
    public String gUr;
    public ImageView gWW;
    public FrameLayout gWX;
    public View gWY;
    private TextView gWZ;
    public TextView gXa;
    public boolean isVisible = true;

    public final void ea(boolean z) {
        if (z && this.isVisible) {
            this.gWX.setVisibility(0);
        } else if ((!z || this.isVisible) && !z && this.isVisible) {
            this.gWX.setVisibility(4);
        }
    }

    public final void b(LocationInfo locationInfo) {
        this.gRK = locationInfo.gRK;
        this.gRL = locationInfo.gRL;
    }

    public final void vU(String str) {
        v.d("ZItemOverlay", "popView " + this.gUp.getWidth() + " " + this.gUp.getHeight());
        this.gTI = (TextView) this.gUp.findViewById(2131757716);
        this.gTJ = (ProgressBar) this.gUp.findViewById(2131757715);
        this.gWZ = (TextView) this.gUp.findViewById(2131758154);
        this.gUp.findViewById(2131757712).setVisibility(0);
        if (str == null || str.equals("")) {
            this.gTJ.setVisibility(0);
        } else {
            this.gTJ.setVisibility(8);
            this.gTI.setVisibility(0);
            this.gTI.setText(str);
        }
        if (this.gUr == null || this.gUr.equals("")) {
            this.gWZ.setText("");
            this.gWZ.setVisibility(8);
        } else {
            this.gWZ.setVisibility(0);
            this.gWZ.setText(this.gUr);
        }
        if (this.gUo) {
            this.gUp.setVisibility(0);
            this.gUq.updateLocaitonPinLayout(this.gUp, this.gRK, this.gRL);
            this.gUp.invalidate();
        }
    }

    public n(d dVar, Context context) {
        View inflate = View.inflate(context, 2130903951, null);
        this.gXa = (TextView) inflate.findViewById(2131758155);
        this.gXa.setVisibility(8);
        inflate.setVisibility(8);
        this.gWW = (ImageView) inflate.findViewById(2131757713);
        this.gWW.setImageResource(2130838477);
        this.gWX = (FrameLayout) inflate.findViewById(2131758153);
        this.gWY = inflate.findViewById(2131757714);
        this.gUq = dVar;
        this.gUp = inflate;
    }

    public final void setText(String str) {
        this.gRG = str;
        vU(this.gRG);
    }

    public final String awA() {
        return this.gTN;
    }
}
