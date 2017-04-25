package com.tencent.mm.plugin.sight.decode.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.as.k;
import com.tencent.mm.memory.ui.QPictureView;
import com.tencent.mm.plugin.sight.decode.a.b;
import com.tencent.mm.plugin.sight.decode.a.b.e;
import com.tencent.mm.plugin.sight.decode.a.b.f;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.v;
import java.lang.ref.WeakReference;

public class SightPlayImageView extends QPictureView implements com.tencent.mm.plugin.sight.decode.a.a {
    public b iUW;
    private int iUY;
    private int iUZ;
    private int iVa;
    private int iVb;
    public com.tencent.mm.pluginsdk.ui.tools.g.a iVc;
    public boolean iVd;
    private boolean iVe;
    public boolean iVf;

    private static final class a extends b {
        private WeakReference<SightPlayImageView> iUX;

        protected final int aPd() {
            return 2130968672;
        }

        public a(SightPlayImageView sightPlayImageView) {
            super(0, sightPlayImageView);
            this.iUX = new WeakReference(sightPlayImageView);
        }

        public final void br(int i, int i2) {
            final SightPlayImageView sightPlayImageView = (SightPlayImageView) this.iUX.get();
            if (sightPlayImageView == null) {
                v.e("MicroMsg.SightPlayImageView", "onGetVideoSizeEnd, imageView is null, do clear");
                clear();
            } else if (!sightPlayImageView.iVf) {
                sightPlayImageView.iVa = i;
                sightPlayImageView.iVb = i2;
                if (sightPlayImageView.iVc != null) {
                    sightPlayImageView.iVc.br(i, i2);
                }
                if (sightPlayImageView.iVe) {
                    if (sightPlayImageView.iVa >= sightPlayImageView.iVb) {
                        sightPlayImageView.iUY = com.tencent.mm.bd.a.fromDPToPix(sightPlayImageView.getContext(), 150);
                    } else {
                        sightPlayImageView.iUY = com.tencent.mm.bd.a.fromDPToPix(sightPlayImageView.getContext(), 85);
                    }
                }
                if (sightPlayImageView.iUY > 0) {
                    final LayoutParams layoutParams = sightPlayImageView.getLayoutParams();
                    if (!(layoutParams.width == sightPlayImageView.iUY && layoutParams.height == (sightPlayImageView.iUY * i2) / i)) {
                        layoutParams.width = sightPlayImageView.iUY;
                        layoutParams.height = (sightPlayImageView.iUY * i2) / i;
                        ad.o(new Runnable(this) {
                            final /* synthetic */ a iVi;

                            public final void run() {
                                sightPlayImageView.setLayoutParams(layoutParams);
                            }
                        });
                        sightPlayImageView.postInvalidate();
                    }
                    v.i("MicroMsg.SightPlayImageView", "onGetVideoSize::params width %d height %d", Integer.valueOf(layoutParams.width), Integer.valueOf(layoutParams.height));
                }
                v.i("MicroMsg.SightPlayImageView", "onGetVideoSize::DrawWidth %d, video size %d*%d", Integer.valueOf(sightPlayImageView.iUY), Integer.valueOf(i), Integer.valueOf(i2));
            }
        }

        public final void u(Bitmap bitmap) {
            SightPlayImageView sightPlayImageView = (SightPlayImageView) this.iUX.get();
            if (sightPlayImageView == null) {
                v.e("MicroMsg.SightPlayImageView", "onGetFrameBmp, imageView is null, do clear");
                clear();
                return;
            }
            sightPlayImageView.setImageBitmap(bitmap);
        }
    }

    public SightPlayImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iVd = true;
        this.iVe = false;
        this.iVf = false;
        this.iUW = new a(this);
        v.i("MicroMsg.SightPlayImageView", "mController %s", new af().toString());
    }

    public SightPlayImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SightPlayImageView(Context context) {
        this(context, null, 0);
    }

    public final String aOV() {
        return this.iUW.iTJ;
    }

    public final void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        if (!this.iVf) {
            int height = bitmap == null ? this.iUZ == 0 ? 240 : this.iUZ : bitmap.getHeight();
            int width = bitmap == null ? this.iUY == 0 ? 320 : this.iUY : bitmap.getWidth();
            LayoutParams layoutParams = getLayoutParams();
            if (((float) layoutParams.height) != ((float) (this.iUY * height)) / ((float) width)) {
                layoutParams.width = this.iUY;
                layoutParams.height = (int) ((((float) height) * ((float) this.iUY)) / ((float) width));
                setLayoutParams(layoutParams);
            }
        }
    }

    public final void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        if (!this.iVf) {
            int intrinsicHeight = drawable == null ? this.iUZ == 0 ? 240 : this.iUZ : drawable.getIntrinsicHeight();
            int intrinsicWidth = drawable == null ? this.iUY == 0 ? 320 : this.iUY : drawable.getIntrinsicWidth();
            if (intrinsicHeight != 0 && intrinsicWidth != 0) {
                LayoutParams layoutParams = getLayoutParams();
                if (((float) layoutParams.height) != (((float) this.iUY) * ((float) intrinsicHeight)) / ((float) intrinsicWidth)) {
                    layoutParams.width = this.iUY;
                    layoutParams.height = (int) ((((float) intrinsicHeight) * ((float) this.iUY)) / ((float) intrinsicWidth));
                    setLayoutParams(layoutParams);
                }
            }
        }
    }

    public final void v(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
    }

    public final void clear() {
        this.iUW.clear();
    }

    public final void ag(String str, boolean z) {
        this.iUW.ag(str, z);
    }

    public final boolean aPa() {
        return this.iUW.aPf();
    }

    public final void iO(int i) {
        this.iUW.position = i;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        v.i("MicroMsg.SightPlayImageView", "#0x%x clear, on deattached to window", Integer.valueOf(hashCode()));
        this.iUW.clear();
        com.tencent.mm.sdk.c.a.nhr.f(this.iUW.aPh());
    }

    protected void onAttachedToWindow() {
        v.d("MicroMsg.SightPlayImageView", "#0x%x on attached from window", Integer.valueOf(hashCode()));
        super.onAttachedToWindow();
        com.tencent.mm.sdk.c.a.nhr.e(this.iUW.aPh());
    }

    public void pv(int i) {
        this.iVd = false;
        this.iUY = i;
        if (this.iVa > 0 && this.iVb > 0) {
            LayoutParams layoutParams = getLayoutParams();
            this.iUZ = (this.iUY * this.iVb) / this.iVa;
            if (layoutParams.width != this.iUY || layoutParams.height != this.iUZ) {
                layoutParams.width = this.iUY;
                layoutParams.height = this.iUZ;
                setLayoutParams(layoutParams);
            }
        }
    }

    public final void s(Bitmap bitmap) {
        setImageBitmap(bitmap);
    }

    public final void aOX() {
        setImageBitmap(null);
        setImageResource(2130838791);
    }

    public final void aOW() {
        this.iVe = true;
        if (this.iVb > 0 && this.iVa > 0) {
            if (this.iVa >= this.iVb) {
                this.iUY = com.tencent.mm.bd.a.fromDPToPix(getContext(), 150);
            } else {
                this.iUY = com.tencent.mm.bd.a.fromDPToPix(getContext(), 85);
            }
            LayoutParams layoutParams = getLayoutParams();
            this.iUZ = (this.iUY * this.iVb) / this.iVa;
            if (layoutParams.width != this.iUY || layoutParams.height != this.iUZ) {
                layoutParams.width = this.iUY;
                layoutParams.height = this.iUZ;
                setLayoutParams(layoutParams);
            }
        }
    }

    public final void aU(Object obj) {
        setTag(obj);
    }

    public final Object aOY() {
        return getTag();
    }

    public final Context aOZ() {
        return getContext();
    }

    public void co(int i, int i2) {
        this.iVd = false;
        LayoutParams layoutParams = getLayoutParams();
        this.iUY = i;
        this.iUZ = (this.iUY * i2) / i;
        layoutParams.width = this.iUY;
        layoutParams.height = this.iUZ;
        setLayoutParams(layoutParams);
        postInvalidate();
    }

    public final void fy(boolean z) {
        this.iUW.iUd = z;
    }

    public final void a(e eVar) {
        this.iUW.iUo = eVar;
    }

    public final void aPc() {
        this.iUW.iUq = null;
    }

    public final void a(f fVar) {
        this.iUW.iUp = fVar;
    }

    public final void g(TextView textView) {
        this.iUW.g(textView);
    }

    public final void fB(boolean z) {
        b bVar = this.iUW;
        v.i("MicroMsg.SightPlayController", "configure: need sound %B", Boolean.valueOf(z));
        if (!z) {
            if (bVar.iTY != null) {
                bVar.iTY.type = 0;
                k.b(bVar.iTY, 0);
            }
            bVar.iTY = null;
        } else if (bVar.iTY == null) {
            bVar.iTY = new i();
        }
    }

    public final void detach() {
        com.tencent.mm.sdk.c.a.nhr.f(this.iUW.aPh());
    }

    public final void aPb() {
    }

    public final void aPw() {
        if (this.iUW != null) {
            this.iUW.iUe = true;
        }
    }

    public int getDuration() {
        if (this.iUW == null) {
            return 0;
        }
        return (int) this.iUW.aPi();
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
}
