package com.tencent.mm.plugin.game.e;

import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mm.a.f;
import com.tencent.mm.ae.n;
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.h.i;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.v;
import java.lang.ref.WeakReference;

public class e {
    private static e gzI;
    private f<String, Bitmap> goO = new f(6);
    private f<String, Bitmap> gvD = new f(15);
    private ColorDrawable gzJ = new ColorDrawable(android.support.v4.content.a.b(aa.getContext(), 2131689730));
    private Bitmap gzK;

    public static class a {
        final boolean cPP;
        final boolean cPq;
        final boolean gzR;
        final boolean gzS;
        final boolean gzT;
        final int gzU;

        public static class a {
            public boolean cPP = false;
            public boolean cPq = true;
            public boolean gzR = false;
            public boolean gzS = true;
            boolean gzT = false;
            public int gzU = 0;

            public final a asL() {
                return new a();
            }
        }

        private a(a aVar) {
            this.cPq = aVar.cPq;
            this.cPP = aVar.cPP;
            this.gzR = aVar.gzR;
            this.gzS = aVar.gzS;
            this.gzT = aVar.gzT;
            this.gzU = aVar.gzU;
        }
    }

    public static abstract class b {
        public abstract void m(Bitmap bitmap);
    }

    static /* synthetic */ Bitmap o(Bitmap bitmap) {
        if (bitmap == null || bitmap.isRecycled()) {
            return bitmap;
        }
        int width = bitmap.getHeight() > bitmap.getWidth() ? bitmap.getWidth() : bitmap.getHeight();
        return d.a(bitmap, width, width, false);
    }

    public static e asK() {
        if (gzI == null) {
            synchronized (e.class) {
                if (gzI == null) {
                    gzI = new e();
                }
            }
        }
        return gzI;
    }

    private e() {
        try {
            this.gzK = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.a(aa.getContext().getAssets().open("avatar/default_nor_avatar.png"), com.tencent.mm.bd.a.getDensity(null), 0, 0);
        } catch (Exception e) {
            v.i("MicroMsg.GameImageUtil", e.getMessage());
        }
        am.bnB().c(new com.tencent.mm.sdk.h.g.a(this) {
            final /* synthetic */ e gzL;

            {
                this.gzL = r1;
            }

            public final void a(String str, i iVar) {
                if (this.gzL.goO.aI(str)) {
                    this.gzL.goO.k(str, g.b(str, 1, com.tencent.mm.bd.a.getDensity(null)));
                }
            }
        });
    }

    public final void e(ImageView imageView, String str) {
        a(imageView, str, null, null);
    }

    public final void a(ImageView imageView, String str, a aVar) {
        a(imageView, str, aVar, null);
    }

    public final void a(final ImageView imageView, String str, a aVar, final b bVar) {
        boolean z;
        boolean z2 = true;
        if (aVar == null) {
            aVar = new a().asL();
        }
        if (!aVar.cPq || aVar.gzT) {
            z = false;
        } else {
            if (this.gvD.aI(str)) {
                Bitmap bitmap = (Bitmap) this.gvD.get(str);
                if (!(bitmap == null || bitmap.isRecycled())) {
                    if (imageView != null) {
                        imageView.setImageBitmap(bitmap);
                    }
                    if (bVar != null) {
                        bVar.m(bitmap);
                    }
                    z = true;
                }
            }
            z = false;
        }
        if (!z) {
            com.tencent.mm.ae.a.a.c.a aVar2 = new com.tencent.mm.ae.a.a.c.a();
            aVar2.cPq = !aVar.gzT;
            if (aVar.gzT) {
                z2 = false;
            }
            aVar2.cPr = z2;
            aVar2.cPP = aVar.cPP;
            aVar2.cPO = false;
            if (imageView != null && aVar.gzS) {
                if (aVar.gzU == 0) {
                    imageView.setImageDrawable(this.gzJ);
                } else {
                    imageView.setImageResource(aVar.gzU);
                }
            }
            n.GL().a(str, null, aVar2.GU(), new com.tencent.mm.ae.a.c.g(this) {
                final /* synthetic */ e gzL;

                public final void jk(String str) {
                }

                public final void a(String str, View view, com.tencent.mm.ae.a.d.b bVar) {
                    if (bVar != null && bVar.bitmap != null) {
                        Bitmap bitmap = bVar.bitmap;
                        if (aVar.gzR) {
                            bitmap = e.o(bitmap);
                        }
                        if (aVar.cPq) {
                            this.gzL.gvD.k(str, bitmap);
                        }
                        ad.o(new Runnable(this) {
                            final /* synthetic */ AnonymousClass2 gzP;

                            public final void run() {
                                if (imageView != null) {
                                    imageView.setImageBitmap(bitmap);
                                }
                            }
                        });
                        if (bVar != null) {
                            bVar.m(bitmap);
                        }
                    }
                }
            });
        }
    }

    public static Bitmap n(Bitmap bitmap) {
        if (bitmap.getWidth() == bitmap.getHeight()) {
            return d.a(bitmap, false, (float) (bitmap.getWidth() / 2));
        }
        int min = Math.min(bitmap.getWidth(), bitmap.getHeight());
        if (min <= 0) {
            min = Math.max(bitmap.getWidth(), bitmap.getHeight());
        }
        return d.a(d.a(bitmap, min, min, false), false, (float) (bitmap.getWidth() / 2));
    }

    public final Bitmap f(ImageView imageView, String str) {
        Bitmap a = com.tencent.mm.u.b.a(str, false, -1);
        if (a == null || a.isRecycled()) {
            if (this.gzK == null || this.gzK.isRecycled()) {
                try {
                    this.gzK = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.a(aa.getContext().getAssets().open("avatar/default_nor_avatar.png"), com.tencent.mm.bd.a.getDensity(null), 0, 0);
                } catch (Exception e) {
                }
            }
            if (!(this.gzK == null || this.gzK.isRecycled() || imageView == null)) {
                imageView.setImageBitmap(this.gzK);
            }
            return this.gzK;
        } else if (imageView == null) {
            return a;
        } else {
            imageView.setImageBitmap(a);
            return a;
        }
    }

    public final void a(ImageView imageView, final String str, final float f) {
        if (imageView != null && !be.kS(str)) {
            Bitmap bitmap;
            if (this.goO.aI(str)) {
                bitmap = (Bitmap) this.goO.get(str);
                if (!(bitmap == null || bitmap.isRecycled())) {
                    imageView.setImageBitmap(bitmap);
                    return;
                }
            }
            bitmap = g.b(str, 1, f);
            if (bitmap == null || bitmap.isRecycled()) {
                imageView.setImageResource(2130838303);
                final WeakReference weakReference = new WeakReference(imageView);
                am.bnB().c(new com.tencent.mm.sdk.h.g.a(this) {
                    final /* synthetic */ e gzL;

                    public final void a(String str, i iVar) {
                        if (str.equals(str)) {
                            Bitmap b = g.b(str, 1, f);
                            if (b != null) {
                                if (!(weakReference == null || weakReference.get() == null)) {
                                    ((ImageView) weakReference.get()).setImageBitmap(b);
                                }
                                this.gzL.goO.put(str, b);
                                am.bnB().d(this);
                            }
                        }
                    }
                });
                return;
            }
            imageView.setImageBitmap(bitmap);
            this.goO.put(str, bitmap);
        }
    }
}
