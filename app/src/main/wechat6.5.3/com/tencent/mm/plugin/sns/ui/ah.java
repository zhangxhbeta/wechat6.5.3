package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.sight.decode.a.a;
import com.tencent.mm.protocal.c.azr;
import com.tencent.mm.ui.widget.MMPinProgressBtn;

public final class ah {
    public String bap;
    public a iWn;
    public azr jKk;
    public View jKl;
    public View jKm;
    public TextView jKn;
    public boolean jdE = false;
    public MMPinProgressBtn jzr;
    public ImageView jzs;
    public TextView jzt;
    public int position;

    public final void a(azr com_tencent_mm_protocal_c_azr, int i, String str, boolean z) {
        this.jKk = com_tencent_mm_protocal_c_azr;
        this.position = i;
        this.bap = str;
        this.jdE = z;
    }
}
