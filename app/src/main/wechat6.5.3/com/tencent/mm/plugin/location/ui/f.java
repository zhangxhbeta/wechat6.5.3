package com.tencent.mm.plugin.location.ui;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import com.tencent.mm.plugin.e.d;
import com.tencent.mm.sdk.platformtools.v;

public final class f implements c {
    public boolean bcR = false;
    private String gRG;
    private double gRK = 1000000.0d;
    private double gRL = 1000000.0d;
    private String gTN = "";
    private boolean gUo = true;
    private View gUp;
    private d gUq;
    public String gUr;
    private TextView gUs;
    private TextView gUt;
    public ImageButton gUu;
    private boolean isVisible = true;

    public f(d dVar, Context context) {
        View findViewById = ((Activity) context).findViewById(2131758450);
        this.gUs = (TextView) findViewById.findViewById(2131758451);
        this.gUt = (TextView) findViewById.findViewById(2131758452);
        this.gUu = (ImageButton) findViewById.findViewById(2131758453);
        this.gUq = dVar;
        this.gUp = findViewById;
    }

    public final void setText(String str) {
        this.gRG = str;
        CharSequence charSequence = this.gRG;
        v.d("NewItemOverlay", "popView " + this.gUp.getWidth() + " " + this.gUp.getHeight());
        if (!(charSequence == null || charSequence.equals(""))) {
            this.gUt.setText(charSequence);
        }
        if (this.gUr == null || this.gUr.equals("")) {
            this.gUs.setText(2131233523);
        } else {
            this.gUs.setText(this.gUr);
        }
        if (this.gUo) {
            this.gUp.setVisibility(0);
            this.gUp.invalidate();
        }
    }

    public final String awA() {
        return this.gTN;
    }
}
