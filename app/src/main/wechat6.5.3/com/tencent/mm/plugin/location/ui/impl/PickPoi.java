package com.tencent.mm.plugin.location.ui.impl;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import com.tencent.mm.modelgeo.Addr;
import com.tencent.mm.modelgeo.b;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.sdk.platformtools.v;

public class PickPoi extends RelativeLayout {
    private Context context;
    Animation gTK;
    View gTL;
    protected b gXm;
    public a gXu = new a(this) {
        final /* synthetic */ PickPoi gYG;

        {
            this.gYG = r1;
        }

        public final void b(Addr addr) {
            v.d("MicroMsg.PickPoi", "onGetAddrss  %s", new Object[]{addr.toString()});
            if (this.gYG.gYD == null) {
                v.i("MicroMsg.PickPoi", "error, empty poi!");
                return;
            }
            f a = this.gYG.gYD;
            a.gYZ = addr;
            a.gYP = addr.cJf;
            a.aIl = (double) addr.cJq;
            a.aIm = (double) addr.cJr;
            a.gYT = addr.cJh;
            a.gYU = addr.cJi;
            a.gYW = addr.cJm;
            a.gYY = addr.cJo;
            v.d("poidata", "roughAddr %s", new Object[]{addr.toString()});
            if (this.gYG.gYF != null) {
                this.gYG.gYF.notifyDataSetChanged();
            }
        }
    };
    private double gYB;
    private double gYC;
    f gYD = new f();
    boolean gYE = true;
    e gYF = null;

    public PickPoi(Context context) {
        super(context);
        this.context = context;
        init();
    }

    public PickPoi(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
        init();
    }

    public PickPoi(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.context = context;
        init();
    }

    private void init() {
        this.gXm = b.FW();
        this.gTK = AnimationUtils.loadAnimation(this.context, 2130968692);
        this.gTL = LayoutInflater.from(this.context).inflate(2130903867, this, true).findViewById(2131757713);
    }

    public final void i(double d, double d2) {
        this.gYB = d;
        this.gYC = d2;
        this.gYD = new f();
        this.gYD.type = 3;
        this.gYD.mName = this.context.getResources().getString(2131233537);
        this.gYD.aIl = d;
        this.gYD.aIm = d2;
        this.gYD.gYP = "";
        this.gXm.a(this.gXu);
        this.gXm.a(d, d2, this.gXu);
        this.gYE = true;
    }
}
