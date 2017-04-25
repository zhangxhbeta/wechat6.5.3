package com.tencent.mm.plugin.ipcall.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Looper;
import android.widget.ImageView;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.u.b;
import com.tencent.mm.u.n;
import java.lang.ref.WeakReference;

public final class d {
    private ac cnC = new ac(Looper.getMainLooper());
    Context context;
    ap gJV = new ap(5, "IPCallAddressAvatarLoader", 1, Looper.getMainLooper());
    x<String, WeakReference<Bitmap>> gJW = new x(50);

    class AnonymousClass2 implements a {
        final /* synthetic */ String chj;
        final /* synthetic */ String cxT;
        final /* synthetic */ ImageView dKp;
        final /* synthetic */ d gJY;

        AnonymousClass2(d dVar, String str, ImageView imageView, String str2) {
            this.gJY = dVar;
            this.cxT = str;
            this.dKp = imageView;
            this.chj = str2;
        }

        public final boolean AZ() {
            Bitmap a = b.a(this.cxT, false, -1);
            if (a == null) {
                n.AX();
                a = com.tencent.mm.u.d.gI(this.cxT);
            }
            d.a(this.gJY, this.dKp, this.chj, a);
            return true;
        }

        public final boolean Ba() {
            return false;
        }
    }

    static /* synthetic */ void a(d dVar, final ImageView imageView, final String str, final Bitmap bitmap) {
        if (bitmap != null) {
            dVar.gJW.put(str, new WeakReference(bitmap));
            dVar.cnC.post(new Runnable(dVar) {
                final /* synthetic */ d gJY;

                public final void run() {
                    if (imageView.getTag() != null && imageView.getTag().equals(str) && bitmap != null && !bitmap.isRecycled()) {
                        imageView.setImageBitmap(bitmap);
                    }
                }
            });
        }
    }

    public d(Context context) {
        this.context = context;
    }

    public final void a(String str, String str2, ImageView imageView) {
        if (!be.kS(str) && !be.kS(str2) && imageView != null) {
            final String bQ = bQ(str, str2);
            imageView.setTag(bQ);
            if (!d(bQ(str, str2), imageView)) {
                final String str3 = str;
                final ImageView imageView2 = imageView;
                final String str4 = str2;
                this.gJV.c(new a(this) {
                    private boolean clE = false;
                    final /* synthetic */ d gJY;

                    public final boolean AZ() {
                        Bitmap ad = com.tencent.mm.plugin.ipcall.b.a.ad(this.gJY.context, str3);
                        if (ad != null) {
                            this.gJY.gJW.put(bQ, new WeakReference(ad));
                            this.clE = true;
                            d.a(this.gJY, imageView2, bQ, ad);
                        }
                        return true;
                    }

                    public final boolean Ba() {
                        if (!this.clE) {
                            d dVar = this.gJY;
                            String str = str3;
                            String str2 = str4;
                            dVar.gJV.c(new AnonymousClass2(dVar, str2, imageView2, d.bQ(str, str2)));
                        }
                        return true;
                    }
                });
            }
        }
    }

    public final void b(final String str, final ImageView imageView) {
        if (!be.kS(str) && imageView != null) {
            final String uX = uX(str);
            imageView.setTag(uX);
            if (!d(uX(str), imageView)) {
                this.gJV.c(new a(this) {
                    final /* synthetic */ d gJY;

                    public final boolean AZ() {
                        d.a(this.gJY, imageView, uX, com.tencent.mm.plugin.ipcall.b.a.ad(this.gJY.context, str));
                        return true;
                    }

                    public final boolean Ba() {
                        return true;
                    }
                });
            }
        }
    }

    public final void c(final String str, final ImageView imageView) {
        if (!be.kS(str) && imageView != null) {
            final String uW = uW(str);
            imageView.setTag(uW);
            if (!d(uW(str), imageView)) {
                this.gJV.c(new a(this) {
                    final /* synthetic */ d gJY;

                    public final boolean AZ() {
                        Bitmap a = b.a(str, false, -1);
                        if (a == null) {
                            n.AX();
                            a = com.tencent.mm.u.d.gI(str);
                        }
                        d.a(this.gJY, imageView, uW, a);
                        return true;
                    }

                    public final boolean Ba() {
                        return false;
                    }
                });
            }
        }
    }

    private boolean d(String str, ImageView imageView) {
        WeakReference weakReference = (WeakReference) this.gJW.get(str);
        if (weakReference != null) {
            Bitmap bitmap = (Bitmap) weakReference.get();
            if (!(bitmap == null || imageView.getTag() == null || !imageView.getTag().toString().equals(str))) {
                if (!(bitmap == null || bitmap.isRecycled())) {
                    imageView.setImageBitmap(bitmap);
                }
                return true;
            }
        }
        return false;
    }

    private static String uW(String str) {
        return str + "@username";
    }

    private static String uX(String str) {
        return str + "@contactId";
    }

    public static String bQ(String str, String str2) {
        return str + "@" + str2 + "@contactId@username";
    }
}
