package com.tencent.mm.plugin.card.ui;

import android.graphics.Bitmap;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.card.b.j;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMVerticalTextView;
import com.tencent.mm.ui.base.o;
import java.util.ArrayList;

public final class i {
    b eBg;
    public Bitmap eFb;
    public Bitmap eFc;
    float eFk = 0.0f;
    OnClickListener eFl = new OnClickListener(this) {
        final /* synthetic */ i eLz;

        {
            this.eLz = r1;
        }

        public final void onClick(View view) {
            if (view.getId() == 2131755947 || view.getId() == 2131755953) {
                if (this.eLz.eLp != null && this.eLz.eLp.isShowing()) {
                    this.eLz.eLp.dismiss();
                }
                if (!this.eLz.eBg.Ze()) {
                    this.eLz.abR();
                }
            }
        }
    };
    boolean eIt = true;
    MMActivity eLn;
    Bitmap eLo = null;
    o eLp = null;
    View eLq;
    ImageView eLr;
    TextView eLs;
    TextView eLt;
    View eLu;
    ImageView eLv;
    MMVerticalTextView eLw;
    MMVerticalTextView eLx;
    ArrayList<Bitmap> eLy = new ArrayList();

    public i(MMActivity mMActivity) {
        this.eLn = mMActivity;
    }

    private void L(float f) {
        LayoutParams attributes = this.eLn.getWindow().getAttributes();
        attributes.screenBrightness = f;
        this.eLn.getWindow().setAttributes(attributes);
    }

    public final void abQ() {
        if (this.eFk < 0.8f) {
            L(0.8f);
        }
    }

    public final void abR() {
        L(this.eFk);
    }

    final void abS() {
        if (this.eLy.size() > 2) {
            for (int size = this.eLy.size() - 1; size > 1; size--) {
                j.l((Bitmap) this.eLy.remove(size));
            }
        }
    }
}
