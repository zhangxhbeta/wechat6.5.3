package com.tencent.mm.ae.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.widget.ImageView;
import com.tencent.mm.ae.a.a.b;
import com.tencent.mm.ae.a.a.c;
import com.tencent.mm.ae.a.b.g;
import com.tencent.mm.ae.a.c.d;
import com.tencent.mm.ae.a.c.e;
import com.tencent.mm.ae.a.c.i;
import com.tencent.mm.ae.a.c.j;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.util.concurrent.ExecutorService;

public final class a {
    public b cOJ;
    private b cOK;
    private final i cOL = new g();

    public a(Context context) {
        a(b.aR(context));
    }

    public a(b bVar) {
        a(bVar);
    }

    private synchronized void a(b bVar) {
        if (bVar == null) {
            throw new IllegalArgumentException("[cpan] image loader configuration is null.");
        } else if (this.cOK == null) {
            this.cOJ = new b(bVar);
            this.cOK = bVar;
        } else {
            v.w("MicroMsg.imageloader.ImageLoader", "[cpan] image loader had init.");
        }
    }

    public final void a(String str, ImageView imageView) {
        a(str, imageView, null, null, null, null, null, null);
    }

    public final void a(String str, ImageView imageView, com.tencent.mm.ae.a.c.g gVar) {
        a(str, imageView, null, null, null, gVar, null, null);
    }

    public final void a(String str, ImageView imageView, c cVar, com.tencent.mm.ae.a.c.g gVar) {
        a(str, imageView, cVar, null, null, gVar, null, null);
    }

    public final void b(String str, ImageView imageView, c cVar, com.tencent.mm.ae.a.c.g gVar) {
        a(str, imageView, cVar, null, null, gVar, null, null);
    }

    public final void a(String str, ImageView imageView, c cVar) {
        a(str, imageView, cVar, null, null, null, null, null);
    }

    public final void a(String str, ImageView imageView, c cVar, e eVar, d dVar) {
        a(str, imageView, cVar, null, null, null, eVar, dVar);
    }

    public final void a(String str, ImageView imageView, c cVar, i iVar) {
        a(str, imageView, cVar, iVar, null, null, null, null);
    }

    public final void a(String str, ImageView imageView, c cVar, i iVar, j jVar, com.tencent.mm.ae.a.c.g gVar, e eVar, d dVar) {
        c cVar2;
        i iVar2;
        if (cVar == null) {
            cVar2 = this.cOK.cPf;
        } else {
            cVar2 = cVar;
        }
        if (iVar == null) {
            iVar2 = this.cOL;
        } else {
            iVar2 = iVar;
        }
        c cVar3 = new c(imageView, str);
        if (be.kS(str)) {
            v.w("MicroMsg.imageloader.ImageLoader", "[cpan load image url is null.]");
            a(imageView, cVar2);
            this.cOJ.a(cVar3);
            iVar2.a(str, null, cVar2.cPT);
            return;
        }
        ac acVar = cVar2.handler;
        if (acVar == null || Looper.myLooper() == Looper.getMainLooper()) {
            acVar = new ac();
        }
        Runnable bVar = new com.tencent.mm.ae.a.f.b(str, cVar3, acVar, cVar2, iVar2, jVar, this.cOJ, gVar, eVar, dVar);
        Bitmap jh = this.cOJ.jh(bVar.jl(str));
        if (imageView == null || jh == null || jh.isRecycled()) {
            if (imageView != null) {
                a(imageView, cVar2);
            }
            if (bVar.cPf.cPt || !this.cOJ.cON.oZ()) {
                Object obj;
                b bVar2;
                com.tencent.mm.ae.a.f.b bVar3;
                boolean z;
                b bVar4 = this.cOJ;
                if (!be.kS(str)) {
                    String str2 = (String) bVar4.cOP.get(Integer.valueOf(cVar3.GS()));
                    if (be.kS(str2) || !str.equals(str2)) {
                        bVar4.cOP.put(Integer.valueOf(cVar3.GS()), str);
                        obj = 1;
                        if (obj != null) {
                            bVar2 = this.cOJ;
                            if (!(bVar2.cOQ == null || bVar.cQb == null)) {
                                bVar3 = (com.tencent.mm.ae.a.f.b) bVar2.cOQ.get(Integer.valueOf(bVar.cQb.GS()));
                                if (!(bVar3 == null || bVar3.cQb == null || bVar.cQb.GS() != bVar3.cQb.GS())) {
                                    bVar2.cON.remove(bVar3);
                                    v.d("MicroMsg.imageloader.ImageLoaderManager", "remove taks url:%s", bVar3.url);
                                }
                                bVar2.cOQ.put(Integer.valueOf(bVar.cQb.GS()), bVar);
                            }
                            bVar2 = this.cOJ;
                            z = cVar2.cPr;
                            if (((ExecutorService) bVar2.cOM.cPn).isShutdown()) {
                                bVar2.cON = com.tencent.mm.ae.a.a.a.aH(bVar2.cOM.cPd, bVar2.cOM.cPe);
                            }
                            bVar2.cON.execute(bVar);
                            if (z && com.tencent.mm.ae.a.g.b.GX()) {
                                bVar2.cOO.execute(new com.tencent.mm.ae.a.f.d());
                                return;
                            }
                            return;
                        }
                        return;
                    }
                }
                obj = null;
                if (obj != null) {
                    bVar2 = this.cOJ;
                    bVar3 = (com.tencent.mm.ae.a.f.b) bVar2.cOQ.get(Integer.valueOf(bVar.cQb.GS()));
                    bVar2.cON.remove(bVar3);
                    v.d("MicroMsg.imageloader.ImageLoaderManager", "remove taks url:%s", bVar3.url);
                    bVar2.cOQ.put(Integer.valueOf(bVar.cQb.GS()), bVar);
                    bVar2 = this.cOJ;
                    z = cVar2.cPr;
                    if (((ExecutorService) bVar2.cOM.cPn).isShutdown()) {
                        bVar2.cON = com.tencent.mm.ae.a.a.a.aH(bVar2.cOM.cPd, bVar2.cOM.cPe);
                    }
                    bVar2.cON.execute(bVar);
                    if (z) {
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        v.d("MicroMsg.imageloader.ImageLoader", "[cpan] load from cache. not need to load:%s", r5);
        if (cVar2.cPC) {
            jh = com.tencent.mm.sdk.platformtools.d.c(jh, cVar2.cPD);
        }
        imageView.setImageBitmap(jh);
        bVar.am(0);
        if (gVar != null) {
            gVar.a(str, imageView, new com.tencent.mm.ae.a.d.b(jh));
        }
        this.cOJ.a(cVar3);
    }

    public final void ba(int i) {
        v.d("MicroMsg.imageloader.ImageLoader", "[cpan] on scroll state changed :%d", Integer.valueOf(i));
        if (i == 0 || i == 1) {
            v.d("MicroMsg.imageloader.ImageLoader", "[cpan] resume");
            this.cOJ.cON.resume();
            return;
        }
        v.d("MicroMsg.imageloader.ImageLoader", "[cpan] pause");
        this.cOJ.cON.pause();
    }

    public final void detach() {
        if (this.cOJ != null) {
            b bVar = this.cOJ;
            if (bVar.cOM != null) {
                bVar.cOM.cPg.clear();
                bVar.cOM.cPh.GV();
            }
        }
    }

    public final Bitmap jh(String str) {
        if (this.cOJ != null) {
            return this.cOJ.jh(str);
        }
        return null;
    }

    public final void h(String str, Bitmap bitmap) {
        if (this.cOJ != null) {
            b bVar = this.cOJ;
            if (bVar.cOM != null) {
                bVar.cOM.cPg.b(str, bitmap);
            }
        }
    }

    private void a(ImageView imageView, c cVar) {
        if (imageView == null || cVar == null) {
            v.w("MicroMsg.imageloader.ImageLoader", "[cpan] should show default image view or options is null.");
            return;
        }
        Object obj = (cVar.cPL > 0 || cVar.cPM != null) ? 1 : null;
        if (obj == null) {
            imageView.setBackgroundDrawable(null);
        } else if (cVar.cPL == 0) {
            imageView.setBackgroundDrawable(cVar.cPL != 0 ? this.cOK.cPc.getDrawable(cVar.cPL) : cVar.cPM);
        } else {
            imageView.setBackgroundResource(cVar.cPL);
        }
        if (cVar.cPH > 0 || cVar.cPI != null) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            if (cVar.cPH == 0) {
                Drawable drawable;
                Resources resources = this.cOK.cPc;
                if (cVar.cPH != 0) {
                    drawable = resources.getDrawable(cVar.cPH);
                } else {
                    drawable = cVar.cPI;
                }
                imageView.setImageDrawable(drawable);
                return;
            }
            imageView.setImageResource(cVar.cPH);
        } else if (cVar.cPO) {
            imageView.setImageDrawable(null);
        }
    }

    public final void a(String str, c cVar, com.tencent.mm.ae.a.c.c cVar2) {
        this.cOJ.cON.execute(new com.tencent.mm.ae.a.f.a(str, cVar, this.cOJ, cVar2));
    }
}
