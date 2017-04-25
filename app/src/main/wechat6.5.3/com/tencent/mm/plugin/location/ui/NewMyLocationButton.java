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

public class NewMyLocationButton extends FrameLayout {
    private a bYl = new a(this) {
        final /* synthetic */ NewMyLocationButton gUv;

        {
            this.gUv = r1;
        }

        public final boolean a(boolean z, float f, float f2, int i, double d, double d2) {
            if (!z) {
                return false;
            }
            this.gUv.gTX.setVisibility(8);
            this.gUv.gTW.setVisibility(0);
            if (this.gUv.gTY != null && this.gUv.gTZ) {
                this.gUv.gTY.getIController().setCenter((double) f2, (double) f);
                if (this.gUv.gTY.getZoomLevel() < 16) {
                    this.gUv.gTY.getIController().setZoom(16);
                }
            }
            new ac(Looper.getMainLooper()).post(new Runnable(this) {
                final /* synthetic */ AnonymousClass1 gUw;

                {
                    this.gUw = r1;
                }

                public final void run() {
                    c.FY().c(this.gUw.gUv.bYl);
                }
            });
            return false;
        }
    };
    private Context context;
    private ImageButton gTW;
    private LinearLayout gTX;
    private d gTY;
    private boolean gTZ = true;

    public NewMyLocationButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.context = context;
        init();
    }

    public NewMyLocationButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
        init();
    }

    private void init() {
        View inflate = View.inflate(this.context, 2130904128, this);
        this.gTW = (ImageButton) inflate.findViewById(2131758454);
        this.gTX = (LinearLayout) inflate.findViewById(2131758455);
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.gTW.setOnClickListener(onClickListener);
    }
}
