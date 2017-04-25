package com.tencent.mm.plugin.location.ui;

import android.content.Context;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.plugin.e.d;
import com.tencent.mm.sdk.platformtools.ac;

public class MyLocationButton extends FrameLayout {
    public a bYl = new a(this) {
        final /* synthetic */ MyLocationButton gUa;

        {
            this.gUa = r1;
        }

        public final boolean a(boolean z, float f, float f2, int i, double d, double d2) {
            if (!z) {
                return false;
            }
            this.gUa.gTX.setVisibility(8);
            this.gUa.gTW.setVisibility(0);
            if (this.gUa.gTY != null && this.gUa.gTZ) {
                this.gUa.gTY.getIController().setCenter((double) f2, (double) f);
                if (this.gUa.gTY.getZoomLevel() < 16) {
                    this.gUa.gTY.getIController().setZoom(16);
                }
            }
            new ac(Looper.getMainLooper()).post(new Runnable(this) {
                final /* synthetic */ AnonymousClass1 gUb;

                {
                    this.gUb = r1;
                }

                public final void run() {
                    c.FY().c(this.gUb.gUa.bYl);
                }
            });
            return false;
        }
    };
    private Context context;
    public ImageButton gTW;
    public LinearLayout gTX;
    public d gTY;
    public boolean gTZ = true;

    public MyLocationButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.context = context;
        init();
    }

    public MyLocationButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
        init();
    }

    private void init() {
        View inflate = View.inflate(this.context, 2130904107, this);
        this.gTW = (ImageButton) inflate.findViewById(2131758384);
        this.gTX = (LinearLayout) inflate.findViewById(2131755518);
    }

    public final void awB() {
        this.gTW.setImageResource(2130838898);
    }

    public final void awC() {
        this.gTW.setImageResource(2130838899);
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.gTW.setOnClickListener(onClickListener);
    }
}
