package com.tencent.mm.memory.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.tencent.mm.memory.a.a;
import com.tencent.mm.memory.i;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.widget.QImageView;

public class QPictureView extends QImageView {
    private boolean DEBUG = false;
    private i cnT = null;
    private boolean cnU = false;
    private Runnable cnV = new Runnable(this) {
        final /* synthetic */ QPictureView cnX;

        {
            this.cnX = r1;
        }

        public final void run() {
            QPictureView.a(this.cnX);
        }
    };

    static /* synthetic */ void a(QPictureView qPictureView) {
        av(qPictureView.cnT);
        qPictureView.cnT = null;
        super.setImageDrawable(null);
    }

    public QPictureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public QPictureView(Context context, AttributeSet attributeSet, int i) {
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
                v.i("MicroMsg.QPictureView", "setImageDrawable " + hashCode() + " old: " + au(this.cnT) + " new:" + au(drawable) + " " + be.bur().toString());
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
        if (this.DEBUG) {
            v.i("MicroMsg.QPictureView", "onAttach" + hashCode() + " " + be.bur().toString());
        }
        removeCallbacks(this.cnV);
        if (!this.cnU) {
            this.cnU = true;
        }
    }

    private void onDetach() {
        if (this.DEBUG) {
            v.i("MicroMsg.QPictureView", "onDetach " + hashCode() + " " + be.bur().toString());
        }
        if (this.cnU) {
            this.cnU = false;
            removeCallbacks(this.cnV);
            postDelayed(this.cnV, 500);
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ws();
    }

    public void onDetachedFromWindow() {
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
