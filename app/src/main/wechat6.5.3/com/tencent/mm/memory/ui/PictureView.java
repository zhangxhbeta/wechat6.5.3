package com.tencent.mm.memory.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.mm.memory.a.a;
import com.tencent.mm.memory.i;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;

public class PictureView extends ImageView {
    private boolean DEBUG = false;
    private i cnT = null;
    private boolean cnU = false;
    private Runnable cnV = new Runnable(this) {
        final /* synthetic */ PictureView cnW;

        {
            this.cnW = r1;
        }

        public final void run() {
            PictureView.a(this.cnW);
        }
    };

    static /* synthetic */ void a(PictureView pictureView) {
        av(pictureView.cnT);
        pictureView.cnT = null;
        super.setImageDrawable(null);
    }

    public PictureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PictureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    private static String au(Object obj) {
        if (obj == null) {
            return "NULL";
        }
        if (obj instanceof a) {
            return obj + " hashcode " + obj.hashCode() + " " + ((a) obj).wr() + " " + ((a) obj).wr().hashCode();
        }
        return String.valueOf(obj);
    }

    public void setImageDrawable(Drawable drawable) {
        removeCallbacks(this.cnV);
        if (drawable != null && !drawable.equals(this.cnT)) {
            if (this.DEBUG) {
                v.i("MicroMsg.PictureView", "setImageDrawable " + hashCode() + " old: " + au(this.cnT) + " new:" + au(drawable) + " " + be.bur().toString());
            }
            av(this.cnT);
            if (drawable instanceof i) {
                this.cnT = (i) drawable;
            } else {
                this.cnT = null;
            }
            if (drawable != null && (drawable instanceof i)) {
                ((i) drawable).wi();
            }
            super.setImageDrawable(drawable);
        }
    }

    private static void av(Object obj) {
        if (obj != null && (obj instanceof i)) {
            ((i) obj).wj();
        }
    }

    private void ws() {
        removeCallbacks(this.cnV);
        if (this.DEBUG) {
            v.i("MicroMsg.PictureView", "onAttach" + hashCode() + " " + be.bur().toString());
        }
        if (!this.cnU) {
            this.cnU = true;
        }
    }

    private void onDetach() {
        if (this.DEBUG) {
            v.i("MicroMsg.PictureView", "onDetach " + hashCode() + " " + be.bur().toString());
        }
        if (this.cnU) {
            this.cnU = false;
            removeCallbacks(this.cnV);
            postDelayed(this.cnV, 500);
        }
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ws();
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        onDetach();
    }

    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        onDetach();
    }

    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        ws();
    }
}
