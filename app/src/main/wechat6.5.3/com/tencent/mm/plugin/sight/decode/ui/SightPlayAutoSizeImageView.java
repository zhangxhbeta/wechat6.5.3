package com.tencent.mm.plugin.sight.decode.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.mm.plugin.sight.decode.a.b;
import com.tencent.mm.plugin.sight.decode.a.b.e;
import com.tencent.mm.plugin.sight.decode.a.b.f;
import com.tencent.mm.sdk.platformtools.v;
import java.lang.ref.WeakReference;

public class SightPlayAutoSizeImageView extends ImageView implements com.tencent.mm.plugin.sight.decode.a.a {
    private b iUW;

    private static final class a extends b {
        private WeakReference<SightPlayAutoSizeImageView> iUX;

        protected final int aPd() {
            return 2130968672;
        }

        public a(SightPlayAutoSizeImageView sightPlayAutoSizeImageView) {
            super(0, sightPlayAutoSizeImageView);
            this.iUX = new WeakReference(sightPlayAutoSizeImageView);
        }

        public final void br(int i, int i2) {
        }

        public final void u(Bitmap bitmap) {
            SightPlayAutoSizeImageView sightPlayAutoSizeImageView = (SightPlayAutoSizeImageView) this.iUX.get();
            if (sightPlayAutoSizeImageView == null) {
                v.e("MicroMsg.SightPlayAutoSizeImageView", "onGetFrameBmp, imageView is null, do clear");
                clear();
                return;
            }
            sightPlayAutoSizeImageView.setScaleType(ScaleType.CENTER_CROP);
            sightPlayAutoSizeImageView.setImageBitmap(bitmap);
        }
    }

    public SightPlayAutoSizeImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iUW = new a(this);
    }

    public SightPlayAutoSizeImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final String aOV() {
        return this.iUW.iTJ;
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
        v.i("MicroMsg.SightPlayAutoSizeImageView", "#0x%x clear, on deattached to window", new Object[]{Integer.valueOf(hashCode())});
        this.iUW.clear();
        com.tencent.mm.sdk.c.a.nhr.f(this.iUW.aPh());
    }

    protected void onAttachedToWindow() {
        v.d("MicroMsg.SightPlayAutoSizeImageView", "#0x%x on attached from window", new Object[]{Integer.valueOf(hashCode())});
        super.onAttachedToWindow();
        com.tencent.mm.sdk.c.a.nhr.e(this.iUW.aPh());
    }

    public final void pv(int i) {
    }

    public final void s(Bitmap bitmap) {
        setImageBitmap(bitmap);
    }

    public final void aOX() {
        setImageBitmap(null);
        setImageResource(2130838791);
    }

    public final void aOW() {
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

    public final void co(int i, int i2) {
    }

    public final void fy(boolean z) {
        this.iUW.iUd = z;
    }

    public final void a(e eVar) {
        this.iUW.iUo = eVar;
    }

    public final void aPc() {
    }

    public final void g(TextView textView) {
        this.iUW.g(textView);
    }

    public final void aPb() {
        this.iUW.iUm = false;
    }

    public final void a(f fVar) {
        this.iUW.iUp = fVar;
    }
}
