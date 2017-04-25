package com.tencent.mm.plugin.sight.decode.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView.SurfaceTextureListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.as.k;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sight.decode.a.b.e;
import com.tencent.mm.plugin.sight.decode.a.b.f;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.MMTextureView;
import java.lang.ref.WeakReference;

@TargetApi(14)
public class SightPlayTextureView extends MMTextureView implements com.tencent.mm.plugin.sight.decode.a.a {
    private int gef;
    private int geg;
    private Surface huh;
    private com.tencent.mm.plugin.sight.decode.a.b iUW;
    private int iUY;
    private boolean iVe;
    private int iVj;

    private static final class a implements Runnable {
        Surface iVl;

        private a() {
            this.iVl = null;
        }

        public final void run() {
            if (this.iVl != null) {
                this.iVl.release();
            }
        }
    }

    private static final class b extends com.tencent.mm.plugin.sight.decode.a.b {
        private WeakReference<SightPlayTextureView> iVm;

        protected final int aPd() {
            return 2130968672;
        }

        public b(SightPlayTextureView sightPlayTextureView) {
            super(1, sightPlayTextureView);
            this.iVm = new WeakReference(sightPlayTextureView);
        }

        public final void br(int i, int i2) {
            if (this.iVm.get() == null) {
                v.e("MicroMsg.SightPlayTextureView", "onGetVideoSizeEnd, textureView is null, do clear");
                clear();
                return;
            }
            ((SightPlayTextureView) this.iVm.get()).geg = i;
            ((SightPlayTextureView) this.iVm.get()).gef = i2;
            v.d("MicroMsg.SightPlayTextureView", "on get video size %d*%d, needAutoResizeChatting: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(((SightPlayTextureView) this.iVm.get()).iVe)});
            final LayoutParams layoutParams = ((SightPlayTextureView) this.iVm.get()).getLayoutParams();
            if (((SightPlayTextureView) this.iVm.get()).iVe && i > 0 && i2 > 0) {
                if (i >= i2) {
                    ((SightPlayTextureView) this.iVm.get()).iUY = com.tencent.mm.bd.a.fromDPToPix(((SightPlayTextureView) this.iVm.get()).getContext(), 150);
                } else {
                    ((SightPlayTextureView) this.iVm.get()).iUY = com.tencent.mm.bd.a.fromDPToPix(((SightPlayTextureView) this.iVm.get()).getContext(), 85);
                }
            }
            if (layoutParams.height != (((SightPlayTextureView) this.iVm.get()).iUY * i2) / i) {
                layoutParams.width = ((SightPlayTextureView) this.iVm.get()).iUY;
                layoutParams.height = (((SightPlayTextureView) this.iVm.get()).iUY * i2) / i;
                if (((SightPlayTextureView) this.iVm.get()).iVe && layoutParams.height < com.tencent.mm.bd.a.fromDPToPix(((SightPlayTextureView) this.iVm.get()).getContext(), 50)) {
                    layoutParams.height = com.tencent.mm.bd.a.fromDPToPix(((SightPlayTextureView) this.iVm.get()).getContext(), 50);
                }
                v.i("MicroMsg.SightPlayTextureView", "params width %d height %d", new Object[]{Integer.valueOf(layoutParams.width), Integer.valueOf(layoutParams.height)});
                if (ad.isMainThread()) {
                    ((SightPlayTextureView) this.iVm.get()).setLayoutParams(layoutParams);
                } else {
                    ad.o(new Runnable(this) {
                        final /* synthetic */ b iVn;

                        public final void run() {
                            ((SightPlayTextureView) this.iVn.iVm.get()).setLayoutParams(layoutParams);
                        }
                    });
                }
            }
            this.iTO = com.tencent.mm.plugin.sight.decode.a.b.a(((SightPlayTextureView) this.iVm.get()).getContext(), ((SightPlayTextureView) this.iVm.get()).iVj, ((SightPlayTextureView) this.iVm.get()).iUY, i, i2);
        }

        public final void u(Bitmap bitmap) {
        }
    }

    public SightPlayTextureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iVe = false;
        setOpaque(false);
        this.iUW = new b(this);
        setSurfaceTextureListener(new SurfaceTextureListener(this) {
            final /* synthetic */ SightPlayTextureView iVk;

            {
                this.iVk = r1;
            }

            public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }

            public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
                v.i("MicroMsg.SightPlayTextureView", "on surface texture size changed, width " + i + " height " + i2);
            }

            public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                v.i("MicroMsg.SightPlayTextureView", "on surface texture destroyed");
                this.iVk.iUW.b(null);
                this.iVk.iUW.clear();
                Runnable aVar = new a();
                aVar.iVl = this.iVk.huh;
                k.b(aVar, 0);
                this.iVk.huh = null;
                return false;
            }

            public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                v.i("MicroMsg.SightPlayTextureView", "on surface texture available, width %d height %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
                Runnable aVar = new a();
                aVar.iVl = this.iVk.huh;
                k.b(aVar, 0);
                this.iVk.huh = new Surface(surfaceTexture);
                this.iVk.iUW.b(this.iVk.huh);
                this.iVk.bCE();
            }
        });
    }

    public SightPlayTextureView(Context context, AttributeSet attributeSet) {
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
        v.i("MicroMsg.SightPlayTextureView", "#0x%x clear, on deattached to window", new Object[]{Integer.valueOf(hashCode())});
        this.iUW.clear();
        com.tencent.mm.sdk.c.a.nhr.f(this.iUW.aPh());
    }

    protected void onAttachedToWindow() {
        v.d("MicroMsg.SightPlayTextureView", "#0x%x on attached from window", new Object[]{Integer.valueOf(hashCode())});
        super.onAttachedToWindow();
        com.tencent.mm.sdk.c.a.nhr.e(this.iUW.aPh());
    }

    public final void pv(int i) {
        this.iUY = i;
        h(0.75d);
    }

    private void h(double d) {
        final LayoutParams layoutParams = getLayoutParams();
        if (layoutParams.height != ((int) (((double) this.iUY) * d))) {
            layoutParams.width = this.iUY;
            layoutParams.height = (int) (((double) this.iUY) * d);
            if (this.iVe && layoutParams.height < com.tencent.mm.bd.a.fromDPToPix(getContext(), 50)) {
                layoutParams.height = com.tencent.mm.bd.a.fromDPToPix(getContext(), 50);
            }
            v.i("MicroMsg.SightPlayTextureView", "params width %d height %d", new Object[]{Integer.valueOf(layoutParams.width), Integer.valueOf(layoutParams.height)});
            if (ad.isMainThread()) {
                setLayoutParams(layoutParams);
            } else {
                ad.o(new Runnable(this) {
                    final /* synthetic */ SightPlayTextureView iVk;

                    public final void run() {
                        this.iVk.setLayoutParams(layoutParams);
                    }
                });
            }
        }
    }

    public final void s(Bitmap bitmap) {
        String str = "MicroMsg.SightPlayTextureView";
        String str2 = "thumb is null? %B, surface is null? %B";
        Object[] objArr = new Object[2];
        objArr[0] = Boolean.valueOf(bitmap == null);
        objArr[1] = Boolean.valueOf(this.huh == null);
        v.d(str, str2, objArr);
        if (bitmap != null) {
            v.d("MicroMsg.SightPlayTextureView", "thumb size [%d, %d]", new Object[]{Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight())});
            if (this.iVe) {
                if (bitmap.getWidth() >= bitmap.getHeight()) {
                    this.iUY = com.tencent.mm.bd.a.fromDPToPix(getContext(), 150);
                } else {
                    this.iUY = com.tencent.mm.bd.a.fromDPToPix(getContext(), 85);
                }
            }
            Bitmap a = com.tencent.mm.plugin.sight.decode.a.b.a(getContext(), this.iVj, this.iUY, bitmap.getWidth(), bitmap.getHeight());
            h(((double) bitmap.getHeight()) / ((double) bitmap.getWidth()));
            this.iUW.iTO = a;
            this.iUW.t(bitmap);
            return;
        }
        this.iUW.t(null);
    }

    public final void aOX() {
        SightVideoJNI.drawSurfaceThumb(this.huh, com.tencent.mm.plugin.sight.decode.a.b.a(getContext(), 2130838791, this.iUY, 320, 240), com.tencent.mm.plugin.sight.decode.a.b.a(getContext(), this.iVj, this.iUY, 320, 240));
    }

    public final void aOW() {
        this.iVe = true;
        if (this.gef > 0 && this.geg > 0) {
            if (this.geg >= this.gef) {
                this.iUY = com.tencent.mm.bd.a.fromDPToPix(getContext(), 150);
            } else {
                this.iUY = com.tencent.mm.bd.a.fromDPToPix(getContext(), 85);
            }
            h(0.75d);
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

    public final void co(int i, int i2) {
        final LayoutParams layoutParams = getLayoutParams();
        this.iUY = i;
        layoutParams.width = this.iUY;
        layoutParams.height = (this.iUY * i2) / i;
        v.i("MicroMsg.SightPlayTextureView", "params width %d height %d", new Object[]{Integer.valueOf(layoutParams.width), Integer.valueOf(layoutParams.height)});
        if (ad.isMainThread()) {
            setLayoutParams(layoutParams);
        } else {
            ad.o(new Runnable(this) {
                final /* synthetic */ SightPlayTextureView iVk;

                public final void run() {
                    this.iVk.setLayoutParams(layoutParams);
                }
            });
        }
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
    }

    public final void a(f fVar) {
        this.iUW.iUp = fVar;
    }
}
