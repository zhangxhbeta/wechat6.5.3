package com.tencent.mm.plugin.music.a;

import android.graphics.Bitmap;
import android.os.Looper;
import android.view.View;
import com.tencent.mm.a.f;
import com.tencent.mm.ae.a.c.g;
import com.tencent.mm.pluginsdk.j.ak;
import com.tencent.mm.protocal.c.aib;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.v;

public final class d {
    public f<String, Bitmap> bYS = new f(5);
    public a hCv;
    public g hCw = new g(this) {
        final /* synthetic */ d hCy;

        {
            this.hCy = r1;
        }

        public final void jk(String str) {
        }

        public final void a(String str, View view, com.tencent.mm.ae.a.d.b bVar) {
            String str2 = "MicroMsg.Music.MusicImageLoader";
            String str3 = "onImageLoadFinish %s %b";
            Object[] objArr = new Object[2];
            objArr[0] = str;
            objArr[1] = Boolean.valueOf(bVar.bitmap != null);
            v.i(str2, str3, objArr);
            if (bVar != null && bVar.bitmap != null) {
                final com.tencent.mm.ai.a aVar = (com.tencent.mm.ai.a) view.getTag();
                this.hCy.a(aVar, bVar.bitmap);
                final int[] q = h.q(bVar.bitmap);
                if (!aVar.e(q)) {
                    i.aDe().B(aVar.field_musicId, q[0], q[1]);
                }
                if (this.hCy.hCv != null) {
                    ad.o(new Runnable(this) {
                        final /* synthetic */ AnonymousClass1 hCB;

                        public final void run() {
                            this.hCB.hCy.hCv.a(aVar, q);
                        }
                    });
                }
            }
        }
    };
    public ac hCx = new ac(Looper.getMainLooper());

    public interface a {
        void a(com.tencent.mm.ai.a aVar, int[] iArr);
    }

    private class b implements Runnable {
        com.tencent.mm.ai.a big;
        final /* synthetic */ d hCy;

        public b(d dVar, com.tencent.mm.ai.a aVar) {
            this.hCy = dVar;
            this.big = aVar;
        }

        public final void run() {
            aib com_tencent_mm_protocal_c_aib = new aib();
            com_tencent_mm_protocal_c_aib.gID = this.big.field_songMediaId;
            com_tencent_mm_protocal_c_aib.mHP = this.big.field_songAlbumUrl;
            com_tencent_mm_protocal_c_aib.mHQ = this.big.field_songAlbumType;
            com_tencent_mm_protocal_c_aib.glb = com_tencent_mm_protocal_c_aib.mHP;
            Bitmap r = ak.lye.r(com_tencent_mm_protocal_c_aib);
            if (r != null) {
                r = com.tencent.mm.sdk.platformtools.d.c(r, 10);
                this.hCy.a(this.big, r);
                int[] q = h.q(r);
                if (!this.big.e(q)) {
                    this.big = i.aDe().B(this.big.field_musicId, q[0], q[1]);
                }
                if (this.hCy.hCv != null) {
                    this.hCy.hCv.a(this.big, q);
                }
            }
        }
    }

    public final void a(com.tencent.mm.ai.a aVar, Bitmap bitmap) {
        v.i("MicroMsg.Music.MusicImageLoader", "putBitmapToCache %s", new Object[]{aVar.field_musicId});
        this.bYS.put(aVar.field_musicId, bitmap);
    }
}
