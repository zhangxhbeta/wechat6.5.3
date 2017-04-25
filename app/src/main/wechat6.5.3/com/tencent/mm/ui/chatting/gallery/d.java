package com.tencent.mm.ui.chatting.gallery;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Build.VERSION;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import com.tencent.mm.a.e;
import com.tencent.mm.a.o;
import com.tencent.mm.ae.n;
import com.tencent.mm.e.b.bx;
import com.tencent.mm.h.j;
import com.tencent.mm.model.ak;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.MMJpegOptim;
import com.tencent.mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.chatting.dx;
import com.tencent.mm.v.k;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public final class d extends a implements com.tencent.mm.ae.c.a, com.tencent.mm.ui.chatting.gallery.e.a {
    private HashMap<String, WeakReference<Bitmap>> lji = new HashMap();
    private c oBa;
    public HashMap<Long, Integer> oBb = new HashMap();
    public final e oBc = new e(this);
    private HashMap<at, String> oBd = new HashMap();
    private HashMap<at, String> oBe = new HashMap();
    private long oBf = 0;
    int xe = 0;

    private static class a {
        private static HashMap<String, a> oBk = new HashMap();
        private int cyu;
        private int height;
        private long nji = 0;
        private int oBh = 0;
        private String oBi = SQLiteDatabase.KeyEmpty;
        private int oBj = 0;
        private int width;

        private a() {
        }

        public static void ci(String str, int i) {
            try {
                if (!be.kS(str) && i != 0) {
                    a aVar = (a) oBk.get(str);
                    if (aVar != null) {
                        aVar.cyu = i;
                    }
                    Set<String> hashSet = new HashSet();
                    for (String str2 : oBk.keySet()) {
                        a aVar2 = (a) oBk.get(str2);
                        if (aVar2 != null) {
                            v.i("MicroMsg.ImageGalleryHolderImage", "dkprog report: diff:%d [%d,%d,%d] succ:%d change:%d str:%s file:%s", Long.valueOf(be.ay(aVar2.nji)), Integer.valueOf(aVar2.cyu), Integer.valueOf(aVar2.width), Integer.valueOf(aVar2.height), Integer.valueOf(aVar2.oBh), Integer.valueOf(aVar2.oBj), aVar2.oBi, str2);
                            if (be.ay(aVar2.nji) >= 60000) {
                                if (aVar2.cyu > 0 && !be.kS(aVar2.oBi)) {
                                    g.iuh.h(11713, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(41), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(aVar2.cyu), Integer.valueOf(aVar2.width), Integer.valueOf(aVar2.height), Integer.valueOf(aVar2.oBh), Integer.valueOf(aVar2.oBj), aVar2.oBi);
                                }
                                hashSet.add(str2);
                            }
                        }
                    }
                    for (String str22 : hashSet) {
                        oBk.remove(str22);
                    }
                }
            } catch (Throwable th) {
                v.e("MicroMsg.ImageGalleryHolderImage", "get useopt  setTotalLen :%s", be.e(th));
            }
        }

        public static void g(String str, int i, int i2, int i3) {
            try {
                if (!be.kS(str) && i != 0 && i2 != 0) {
                    a aVar = (a) oBk.get(str);
                    if (aVar == null) {
                        aVar = new a();
                        aVar.nji = be.Ni();
                        oBk.put(str, aVar);
                    }
                    aVar.height = i2;
                    aVar.width = i;
                    aVar.oBi += i3 + "|";
                    if (i3 > 0) {
                        if (aVar.oBh == 0) {
                            aVar.oBh = i3;
                        }
                    } else if (aVar.oBh != 0) {
                        aVar.oBj++;
                        aVar.oBh = 0;
                    }
                    v.i("MicroMsg.ImageGalleryHolderImage", "dkprog addBit: [%d,%d,%d] succ:%d change:%d str:%s file:%s", Integer.valueOf(i3), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(aVar.oBh), Integer.valueOf(aVar.oBj), aVar.oBi, str);
                }
            } catch (Throwable th) {
                v.e("MicroMsg.ImageGalleryHolderImage", "get useopt  addBit :%s", be.e(th));
            }
        }
    }

    public d(b bVar) {
        super(bVar);
        com.tencent.mm.sdk.c.a aVar = com.tencent.mm.sdk.c.a.nhr;
        c dxVar = new dx(com.tencent.mm.ui.chatting.dx.a.IMAGE_GALLERY_UI, bVar.ozH);
        this.oBa = dxVar;
        aVar.e(dxVar);
        this.oBc.Y(a.oBu.ggr.snapshot());
    }

    public final void detach() {
        super.detach();
        com.tencent.mm.sdk.c.a.nhr.f(this.oBa);
        if (this.lji != null) {
            for (Object obj : this.lji.keySet()) {
                Bitmap bitmap = (Bitmap) ((WeakReference) this.lji.get(obj)).get();
                if (!(bitmap == null || bitmap.isRecycled())) {
                    v.i("MicroMsg.ImageGalleryHolderImage", "recycle bitmap:%s", bitmap.toString());
                    bitmap.recycle();
                }
            }
        }
        e eVar = this.oBc;
        eVar.oBl = null;
        eVar.ggn.clear();
        eVar.ggq.clear();
        eVar.ggp.clear();
        eVar.ggo.clear();
        eVar.aqU();
        n.GI().a((com.tencent.mm.ae.c.a) this);
    }

    public final int aV(at atVar) {
        if (atVar == null || !this.oBb.containsKey(Long.valueOf(atVar.field_msgId))) {
            return 0;
        }
        return ((Integer) this.oBb.get(Long.valueOf(atVar.field_msgId))).intValue();
    }

    private void b(at atVar, int i) {
        this.oBb.put(Long.valueOf(atVar.field_msgId), Integer.valueOf(i));
    }

    private void x(long j, int i) {
        this.oBb.put(Long.valueOf(j), Integer.valueOf(i));
    }

    public final boolean a(j jVar, at atVar, int i) {
        super.a(jVar, atVar, i);
        if (jVar == null || atVar == null || i < 0) {
            return false;
        }
        int aV = aV(atVar);
        v.i("MicroMsg.ImageGalleryHolderImage", "filling image : %s position : %s", Integer.valueOf(jVar.oDl.hashCode()), Integer.valueOf(i));
        j.G(jVar.oDc, 8);
        com.tencent.mm.ae.d e = e(atVar, false);
        if (e == null) {
            return false;
        }
        switch (aV) {
            case 0:
                boolean bwv;
                v.i("MicroMsg.ImageGalleryHolderImage", "edw dealDownloadOrSucc");
                v.i("MicroMsg.ImageGalleryHolderImage", "deal LoadFail");
                if (atVar.field_isSend == 1) {
                    bwv = atVar.bwv();
                } else if (atVar.bwv()) {
                    bwv = true;
                } else {
                    if (e.Go()) {
                        String c = c(atVar, e);
                        if (c == null || !e.aR(c)) {
                            bwv = true;
                        }
                    }
                    bwv = false;
                }
                if (!bwv) {
                    if (!a(jVar, atVar, e, i)) {
                        b(atVar, 2);
                    } else if (atVar.field_isSend == 1 || e.Go()) {
                        b(atVar, 4);
                        break;
                    } else {
                        b(atVar, 1);
                    }
                    v.i("MicroMsg.ImageGalleryHolderImage", "put image download task downloadCode [%d].", Integer.valueOf(n.GI().a(e.cLu, atVar.field_msgId, 0, Integer.valueOf(i), atVar.field_isSend == 1 ? 2130837922 : 2130837919, this, 0)));
                    if (n.GI().a(e.cLu, atVar.field_msgId, 0, Integer.valueOf(i), atVar.field_isSend == 1 ? 2130837922 : 2130837919, this, 0) != -2) {
                        a(jVar, atVar, e, false, i);
                        break;
                    }
                    v.w("MicroMsg.ImageGalleryHolderImage", "it is already download image finish, but imgInfo is old, search db and repair.");
                    com.tencent.mm.ae.d e2 = e(atVar, true);
                    if (e2 != null) {
                        if (!a(jVar, atVar, e2, i)) {
                            b(atVar, 2);
                        } else if (atVar.field_isSend == 1 || e2.Go()) {
                            b(atVar, 4);
                            break;
                        } else {
                            b(atVar, 1);
                        }
                        v.w("MicroMsg.ImageGalleryHolderImage", "it repair fail show thumb image.ImgInfo[%d, %b]", Long.valueOf(e2.cLu), Boolean.valueOf(e2.Go()));
                        a(jVar, atVar, e2, false, i);
                        break;
                    }
                    v.w("MicroMsg.ImageGalleryHolderImage", "get imgInfo by db but it is null.");
                    break;
                }
                b(atVar, 5);
                a(atVar, jVar, i, 5);
                break;
                break;
            case 1:
            case 4:
                a(jVar, atVar, e, i);
                break;
            case 2:
                a(jVar, atVar, e, false, i);
                break;
            case 3:
                a(jVar, atVar, e, true, i);
                break;
            case 5:
            case 6:
                a(atVar, jVar, i, aV);
                jVar.kad.invalidate();
                break;
        }
        return true;
    }

    public static com.tencent.mm.ae.d aW(at atVar) {
        if (!b.aH(atVar)) {
            return null;
        }
        if (atVar.field_isSend == 1) {
            com.tencent.mm.ae.d ai = n.GH().ai(atVar.field_msgId);
            if (ai.cLu != 0) {
                return ai;
            }
        }
        return n.GH().ah(atVar.field_msgSvrId);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.tencent.mm.ae.d e(com.tencent.mm.storage.at r11, boolean r12) {
        /*
        r10 = this;
        r8 = 0;
        r2 = 0;
        r4 = 1;
        r0 = com.tencent.mm.ui.chatting.gallery.b.aH(r11);
        if (r0 != 0) goto L_0x000b;
    L_0x000a:
        return r2;
    L_0x000b:
        r0 = r10.ozG;
        if (r0 == 0) goto L_0x0015;
    L_0x000f:
        r0 = r10.ozG;
        r0 = r0.ozI;
        if (r0 != 0) goto L_0x001f;
    L_0x0015:
        r0 = "MicroMsg.ImageGalleryHolderImage";
        r1 = "adapter is null!!";
        com.tencent.mm.sdk.platformtools.v.e(r0, r1);
        goto L_0x000a;
    L_0x001f:
        if (r12 != 0) goto L_0x0053;
    L_0x0021:
        r0 = r11.field_isSend;
        if (r0 != r4) goto L_0x0038;
    L_0x0025:
        r0 = r10.ozG;
        r0 = r0.ozI;
        r0 = r0.oAd;
        r2 = r11.field_msgId;
        r1 = java.lang.Long.valueOf(r2);
        r0 = r0.get(r1);
        r0 = (com.tencent.mm.ae.d) r0;
        r2 = r0;
    L_0x0038:
        if (r2 != 0) goto L_0x0053;
    L_0x003a:
        r0 = r11.field_msgSvrId;
        r0 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1));
        if (r0 <= 0) goto L_0x0053;
    L_0x0040:
        r0 = r10.ozG;
        r0 = r0.ozI;
        r0 = r0.oAc;
        r2 = r11.field_msgSvrId;
        r1 = java.lang.Long.valueOf(r2);
        r0 = r0.get(r1);
        r0 = (com.tencent.mm.ae.d) r0;
        r2 = r0;
    L_0x0053:
        if (r2 != 0) goto L_0x000a;
    L_0x0055:
        r3 = 0;
        r0 = r11.field_isSend;
        if (r0 != r4) goto L_0x006a;
    L_0x005a:
        r0 = r11.field_msgId;
        r2 = com.tencent.mm.ae.n.GH();
        r2 = r2.ai(r0);
        r6 = r2.cLu;
        r5 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1));
        if (r5 != 0) goto L_0x0075;
    L_0x006a:
        r0 = r11.field_msgSvrId;
        r2 = com.tencent.mm.ae.n.GH();
        r2 = r2.ah(r0);
        r3 = r4;
    L_0x0075:
        r4 = r10.ozG;
        r4 = r4.ozI;
        if (r3 == 0) goto L_0x0085;
    L_0x007b:
        r3 = r4.oAc;
        r0 = java.lang.Long.valueOf(r0);
        r3.put(r0, r2);
        goto L_0x000a;
    L_0x0085:
        r3 = r4.oAd;
        r0 = java.lang.Long.valueOf(r0);
        r3.put(r0, r2);
        goto L_0x000a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.chatting.gallery.d.e(com.tencent.mm.storage.at, boolean):com.tencent.mm.ae.d");
    }

    private String c(at atVar, com.tencent.mm.ae.d dVar) {
        String str = (String) this.oBd.get(atVar);
        if (str != null) {
            return str;
        }
        str = a(atVar, dVar, false);
        if (str == null || str.length() == 0) {
            return null;
        }
        this.oBd.put(atVar, str);
        return str;
    }

    private boolean a(j jVar, at atVar, com.tencent.mm.ae.d dVar, int i) {
        v.i("MicroMsg.ImageGalleryHolderImage", "edw dealSucc");
        String c = c(atVar, dVar);
        j.G(jVar.oDh, 8);
        String str = (String) this.oBe.get(atVar);
        if (str == null) {
            str = n.GH().w(atVar.field_imgPath, true);
            this.oBe.put(atVar, str);
        }
        boolean a = a(jVar, str, c, atVar);
        if (i == this.ozG.ozH.bGP() && this.ozG.ozL) {
            this.ozG.aQ(atVar);
            this.ozG.ozL = false;
        }
        return a;
    }

    private void a(j jVar, at atVar, com.tencent.mm.ae.d dVar, boolean z, int i) {
        a(jVar, atVar, dVar, z, true, i);
    }

    private void a(j jVar, at atVar, com.tencent.mm.ae.d dVar, boolean z, boolean z2, int i) {
        v.i("MicroMsg.ImageGalleryHolderImage", "edw dealDownloading, isHd = " + z);
        j.G(jVar.oDi, 8);
        String str = null;
        if (!z) {
            jVar.oDl.setVisibility(0);
        }
        com.tencent.mm.ae.d a = com.tencent.mm.ae.e.a(dVar);
        if (z && i == this.ozG.ozH.bGP()) {
            ImageGalleryUI imageGalleryUI = this.ozG.ozH;
            imageGalleryUI.dm(true);
            imageGalleryUI.bGO();
            imageGalleryUI.bGG().oBJ.setVisibility(0);
            imageGalleryUI.bGG().oBK.setVisibility(8);
            imageGalleryUI.bGG().oBL.setVisibility(0);
            imageGalleryUI.bGG().oBM.setVisibility(8);
            imageGalleryUI.bGR();
            imageGalleryUI.bGS();
            imageGalleryUI.bGG().oBL.setText("0%");
        }
        if (z) {
            str = a(atVar, dVar, true);
        }
        if (be.kS(str)) {
            str = n.GH().l(a.cLx, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty);
        }
        String w = n.GH().w(atVar.field_imgPath, true);
        if (z2) {
            a(jVar, w, str, atVar);
        }
        if (!z) {
            int i2 = dVar.cyu;
            if (Math.max(1, (int) (i2 != 0 ? ((((long) dVar.offset) * 100) / ((long) i2)) - 1 : 0)) > 50) {
                jVar.bHc().oDh.setVisibility(8);
            } else {
                jVar.bHc().oDh.setVisibility(0);
            }
        }
        jVar.bHc().oDf.setVisibility(8);
        jVar.bHc().oDe.setVisibility(8);
        jVar.bHc().oDd.setVisibility(8);
    }

    private void a(at atVar, j jVar, int i, int i2) {
        v.i("MicroMsg.ImageGalleryHolderImage", "edw dealFail", new Object[0]);
        String w = n.GH().w(atVar.field_imgPath, true);
        j.G(jVar.oDh, 8);
        j.G(jVar.oDc, 8);
        j.G(jVar.oDl, 8);
        jVar.bHd().oDi.setVisibility(0);
        if (w == null || !e.aR(w)) {
            jVar.bHd().oDk.setImageResource(2131165612);
            jVar.bHd().oDj.setText(2131233294);
            return;
        }
        ImageView imageView = jVar.bHd().oDk;
        if (imageView != null) {
            if (be.kS(w) || !e.aR(w)) {
                imageView.setImageBitmap(null);
            } else {
                Bitmap bitmap;
                if (this.oBc.ggr.aI(w)) {
                    bitmap = (Bitmap) this.oBc.ggr.get(w);
                    if (!bitmap.isRecycled()) {
                        imageView.setImageBitmap(bitmap);
                    }
                }
                if (this.ozG.ozR) {
                    bitmap = Pb(w);
                    if (bitmap != null) {
                        c(imageView, bitmap);
                    }
                }
                if (!this.oBc.b(imageView, i)) {
                    this.oBc.s(imageView, w);
                }
            }
        }
        if (i2 == 6) {
            jVar.bHd().oDj.setText(2131233292);
        } else if (atVar.bwv()) {
            jVar.bHd().oDj.setText(2131233290);
        } else {
            jVar.bHd().oDj.setText(2131233291);
        }
    }

    private boolean a(j jVar, String str, String str2, at atVar) {
        j.G(jVar.oDl, 0);
        j.G(jVar.oDc, 8);
        j.G(jVar.oDh, 8);
        j.G(jVar.oDi, 8);
        return a(true, jVar.oDl, str, str2, false, jVar.kB);
    }

    private boolean a(boolean z, MultiTouchImageView multiTouchImageView, String str, String str2, boolean z2, int i) {
        boolean z3;
        v.i("MicroMsg.ImageGalleryHolderImage", "initImageView image : %s bigImgPath %s position : %s", Integer.valueOf(multiTouchImageView.hashCode()), str2, Integer.valueOf(i));
        if (str2 == null || !e.aR(str2)) {
            z3 = false;
            Object obj = null;
        } else {
            z3 = true;
            String str3 = str2;
        }
        if (str3 != null || str == null || !e.aR(str)) {
            str = str3;
        } else if (e.aR(str + "hd")) {
            str = str + "hd";
        }
        if (str == null) {
            v.e("MicroMsg.ImageGalleryHolderImage", "getSuitableBmp fail, file does not exist, filePath %s", str2);
            return false;
        }
        Bitmap bitmap;
        if (!z2 && this.oBc.ggr.aI(str)) {
            bitmap = (Bitmap) this.oBc.ggr.get(str);
            if (!bitmap.isRecycled()) {
                v.i("MicroMsg.ImageGalleryHolderImage", "use cache, fillBitmap path : %s", str);
                b(multiTouchImageView, bitmap);
                return true;
            }
        }
        if (z) {
            multiTouchImageView.setImageBitmap(null);
        }
        if (this.ozG.ozR) {
            bitmap = Pb(str);
            if (bitmap != null) {
                c((ImageView) multiTouchImageView, bitmap);
                if (str.equals(str2)) {
                    this.oBc.s(str, bitmap);
                }
                return z3;
            }
        } else if (i >= 0) {
            this.oBc.b(multiTouchImageView, i);
        }
        this.oBc.s((ImageView) multiTouchImageView, str);
        return z3;
    }

    public final void c(ImageView imageView, Bitmap bitmap) {
        if (bitmap != null && imageView != null) {
            int hashCode = imageView.hashCode();
            int hashCode2 = bitmap.hashCode();
            int indexOfValue = this.oBc.ggs.indexOfValue(hashCode);
            if (indexOfValue >= 0) {
                this.oBc.ggs.removeAt(indexOfValue);
            }
            this.oBc.ggs.put(hashCode2, hashCode);
            if (imageView instanceof MultiTouchImageView) {
                b((MultiTouchImageView) imageView, bitmap);
            } else {
                imageView.setImageBitmap(bitmap);
            }
        }
    }

    public final Bitmap Pb(String str) {
        if (str == null) {
            return null;
        }
        Bitmap decodeAsBitmap;
        Options options = new Options();
        options.inJustDecodeBounds = true;
        Bitmap decodeFile = BitmapFactory.decodeFile(str, options);
        if (decodeFile != null) {
            v.i("MicroMsg.ImageGalleryHolderImage", "recycle bitmap:%s", decodeFile.toString());
            decodeFile.recycle();
        }
        boolean z = t.aZ(options.outWidth, options.outHeight) && options.outWidth > 480;
        boolean z2 = t.aY(options.outWidth, options.outHeight) && options.outHeight > 480;
        if (z || z2) {
            int i = options.outHeight;
            i = options.outWidth;
        }
        int JQ = ExifHelper.JQ(str);
        decodeFile = N(str, options.outHeight, options.outWidth);
        if (decodeFile == null) {
            decodeFile = com.tencent.mm.sdk.platformtools.d.bE(str, 0);
        }
        if (decodeFile == null && MMNativeJpeg.IsJpegFile(str) && MMNativeJpeg.isProgressive(str)) {
            decodeAsBitmap = MMNativeJpeg.decodeAsBitmap(str);
            String str2 = "MicroMsg.ImageGalleryHolderImage";
            String str3 = "Progressive jpeg, result isNull:%b";
            Object[] objArr = new Object[1];
            objArr[0] = Boolean.valueOf(decodeAsBitmap == null);
            v.i(str2, str3, objArr);
        } else {
            decodeAsBitmap = decodeFile;
        }
        if (decodeAsBitmap == null) {
            v.e("MicroMsg.ImageGalleryHolderImage", "getSuitableBmp fail, temBmp is null, filePath = " + str);
            return null;
        }
        decodeFile = com.tencent.mm.sdk.platformtools.d.b(decodeAsBitmap, (float) JQ);
        if (decodeFile != decodeAsBitmap || JQ % 360 == 0) {
            return decodeFile;
        }
        v.e("MicroMsg.ImageGalleryHolderImage", "rotate failed degree:%d", Integer.valueOf(JQ));
        return null;
    }

    private static Bitmap N(String str, int i, int i2) {
        Bitmap bitmap;
        Throwable th;
        Throwable th2;
        Bitmap bitmap2 = null;
        String str2 = str + "_tmp.jpg";
        try {
            if (com.tencent.mm.compatible.util.d.dX(16)) {
                return null;
            }
            if (!b.bsI()) {
                int i3 = be.getInt(j.sU().getValue("UseOptImageRecv"), 0);
                ak.yW();
                v.i("MicroMsg.ImageGalleryHolderImage", "fromPathToImgInfo opt:%d uin:(%d,%d) debug:%b sdk:%d", Integer.valueOf(i3), Long.valueOf(r2.longValue()), Long.valueOf(new o(com.tencent.mm.model.c.ww()).longValue() / 100), Boolean.valueOf(b.bsI()), Integer.valueOf(VERSION.SDK_INT));
                if ((((int) (new o(com.tencent.mm.model.c.ww()).longValue() / 100)) % 100) + 1 > i3) {
                    return null;
                }
            }
            com.tencent.mm.sdk.platformtools.j.n(str, str2, false);
            boolean IsJpegFile = MMNativeJpeg.IsJpegFile(str2);
            boolean isProgressive = MMNativeJpeg.isProgressive(str2);
            boolean checkIntegrity = (be.kS(str2) || !new File(str2).exists()) ? false : MMJpegOptim.checkIntegrity(str2);
            int aQ = e.aQ(str2);
            if (IsJpegFile && isProgressive) {
                if (checkIntegrity) {
                    bitmap2 = MMNativeJpeg.decodeAsBitmap(str2);
                }
                try {
                    a.g(str, i2, i, bitmap2 != null ? aQ : 0 - aQ);
                    bitmap = bitmap2;
                } catch (Throwable th3) {
                    th = th3;
                    bitmap = bitmap2;
                    th2 = th;
                    v.e("MicroMsg.ImageGalleryHolderImage", "dkprog tryUseImageOpt failed. file:%s e:%s", str, be.e(th2));
                    com.tencent.mm.loader.stub.b.deleteFile(str2);
                    return bitmap;
                }
            }
            bitmap = null;
            try {
                v.i("MicroMsg.ImageGalleryHolderImage", "dkprog tryUseImageOpt jpeg:%b isprog:%b inte:%b len:%d [%d,%d] bm:%s path:%s", Boolean.valueOf(IsJpegFile), Boolean.valueOf(isProgressive), Boolean.valueOf(checkIntegrity), Integer.valueOf(aQ), Integer.valueOf(i2), Integer.valueOf(i), bitmap, str);
            } catch (Throwable th4) {
                th2 = th4;
                v.e("MicroMsg.ImageGalleryHolderImage", "dkprog tryUseImageOpt failed. file:%s e:%s", str, be.e(th2));
                com.tencent.mm.loader.stub.b.deleteFile(str2);
                return bitmap;
            }
            com.tencent.mm.loader.stub.b.deleteFile(str2);
            return bitmap;
        } catch (Throwable th32) {
            v.e("MicroMsg.ImageGalleryHolderImage", "get useopt :%s", be.e(th32));
            return null;
        } catch (Throwable th322) {
            th = th322;
            bitmap = null;
            th2 = th;
            v.e("MicroMsg.ImageGalleryHolderImage", "dkprog tryUseImageOpt failed. file:%s e:%s", str, be.e(th2));
            com.tencent.mm.loader.stub.b.deleteFile(str2);
            return bitmap;
        }
    }

    public static String a(at atVar, com.tencent.mm.ae.d dVar, boolean z) {
        String l;
        if (atVar.field_isSend == 1) {
            l = n.GH().l(n.GH().d(dVar), SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty);
            if (e.aR(l)) {
                return l;
            }
            l = n.GH().l(dVar.cLv, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty);
            if (e.aR(l)) {
                return l;
            }
            return null;
        } else if (z || dVar.Go()) {
            String str = dVar.cLv;
            if (dVar.Gp()) {
                l = n.GH().d(dVar);
                if (l != null) {
                    l = n.GH().l(l, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty);
                    if (e.aR(l)) {
                        v.i("MicroMsg.ImageGalleryHolderImage", "hasHdImg");
                        if (l == null) {
                            l = n.GH().l(str, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty);
                        }
                        v.i("MicroMsg.ImageGalleryHolderImage", "the path : %s", l);
                        return l;
                    }
                }
            }
            l = null;
            if (l == null) {
                l = n.GH().l(str, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty);
            }
            v.i("MicroMsg.ImageGalleryHolderImage", "the path : %s", l);
            return l;
        } else {
            v.w("MicroMsg.ImageGalleryHolderImage", "getImagePath is null because of isTryToGetProgress %s img.isGetCompleted() %s", Boolean.valueOf(z), Boolean.valueOf(dVar.Go()));
            return null;
        }
    }

    public final void a(long j, int i, int i2, Object obj, int i3, int i4, k kVar) {
        if (this.xe == 0) {
            if (obj instanceof Integer) {
                int intValue = ((Integer) obj).intValue();
                v.i("MicroMsg.ImageGalleryHolderImage", "onImgTaskProgress, pos[%d], offset[%d], totalLen[%d], resId[%d], compressType[%d], imgLocalId[%d],", Integer.valueOf(intValue), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i2), Integer.valueOf(i), Long.valueOf(j));
                if (intValue == -1) {
                    v.e("MicroMsg.ImageGalleryHolderImage", "onImgTaskProgress, pos is -1");
                    return;
                } else if (this.ozG.wA(intValue) != null) {
                    j jVar = (j) this.ozG.wA(intValue).getTag();
                    if (jVar != null) {
                        int i5;
                        if (intValue == this.ozG.ozH.bGP() && !xF(i)) {
                            this.ozG.ozH.dm(false);
                        }
                        if (i3 == 0) {
                            i5 = 0;
                        } else {
                            i5 = (int) (i4 != 0 ? ((((float) i3) / ((float) i4)) * 100.0f) - 1.0f : 0.0f);
                        }
                        int max = Math.max(1, i5);
                        if (intValue == this.ozG.ozH.bGP() && xF(i)) {
                            v.i("MicroMsg.ImageGalleryHolderImage", "jacks loading hd from progress : %d, time: %d", Integer.valueOf(max), Long.valueOf(System.currentTimeMillis()));
                            this.ozG.ozH.xN(max);
                        }
                        com.tencent.mm.ae.j jVar2 = (com.tencent.mm.ae.j) kVar;
                        boolean isProgressive = MMNativeJpeg.isProgressive(jVar2.cMX);
                        boolean z = jVar2.cMZ;
                        long az = be.az(this.oBf);
                        a.ci(jVar2.cMX, i4);
                        v.i("MicroMsg.ImageGalleryHolderImage", "dkprog onImgTaskProgress getCanShow:%b isProg:%b timeDiff:%d  [%d/%d] %s", Boolean.valueOf(z), Boolean.valueOf(isProgressive), Long.valueOf(az), Integer.valueOf(i3), Integer.valueOf(i4), jVar2.cMX);
                        if (z && isProgressive && az > 1000) {
                            this.oBf = be.Nj();
                            at xs = this.ozG.xs(intValue);
                            if (a(false, jVar.oDl, n.GH().w(xs.field_imgPath, true), a(xs, e(xs, true), true), true, -1)) {
                                j.G(jVar.oDl, 0);
                                j.G(jVar.oDf, 8);
                                j.G(jVar.oDi, 8);
                                if (intValue == this.ozG.ozH.bGP() && !xF(i)) {
                                    if (max > 50) {
                                        j.G(jVar.oDh, 8);
                                        return;
                                    } else {
                                        j.G(jVar.oDh, 0);
                                        return;
                                    }
                                }
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                } else {
                    return;
                }
            }
            v.e("MicroMsg.ImageGalleryHolderImage", "param data not integer instance");
        }
    }

    public final void a(long j, long j2, int i, Object obj, int i2, int i3) {
        if (this.ozG != null && this.ozG.ozH != null) {
            if (obj instanceof Integer) {
                final int intValue = ((Integer) obj).intValue();
                v.i("MicroMsg.ImageGalleryHolderImage", "onSceneEnd, pos = " + intValue);
                if (intValue == -1) {
                    v.e("MicroMsg.ImageGalleryHolderImage", "onSceneEnd, pos is -1");
                    g.iuh.a(111, 3, 1, true);
                    return;
                }
                j jVar;
                if (this.ozG.wA(intValue) != null) {
                    jVar = (j) this.ozG.wA(intValue).getTag();
                } else {
                    jVar = null;
                }
                if (i2 == 0 && i3 == 0) {
                    v.i("MicroMsg.ImageGalleryHolderImage", "pos = " + intValue + ", selectedPos = " + this.ozG.ozH.bGP(), new Object[0]);
                    x(j2, 4);
                    at xs = this.ozG.xs(intValue);
                    com.tencent.mm.ae.d e = e(xs, true);
                    if (jVar != null) {
                        this.ozG.ozH.dm(true);
                        if (intValue == this.ozG.ozH.bGP()) {
                            if (xF(i)) {
                                ImageGalleryUI imageGalleryUI = this.ozG.ozH;
                                imageGalleryUI.dm(true);
                                imageGalleryUI.dm(true);
                                Animation xM = ImageGalleryUI.xM(1000);
                                xM.setAnimationListener(new AnimationListener(imageGalleryUI) {
                                    final /* synthetic */ ImageGalleryUI oCl;

                                    {
                                        this.oCl = r1;
                                    }

                                    public final void onAnimationStart(Animation animation) {
                                    }

                                    public final void onAnimationRepeat(Animation animation) {
                                    }

                                    public final void onAnimationEnd(Animation animation) {
                                        if (this.oCl.bGG().oBM.getVisibility() == 0) {
                                            this.oCl.bGO();
                                            this.oCl.bGG().oBJ.setVisibility(8);
                                            this.oCl.bGT();
                                            this.oCl.bGU();
                                        }
                                    }
                                });
                                imageGalleryUI.bGO();
                                imageGalleryUI.bGG().oBJ.setVisibility(0);
                                imageGalleryUI.bGG().oBK.setVisibility(8);
                                imageGalleryUI.bGG().oBL.setVisibility(8);
                                imageGalleryUI.bGG().oBM.setVisibility(0);
                                imageGalleryUI.bGG().oBM.startAnimation(xM);
                            } else {
                                jVar.oDl.post(new Runnable(this) {
                                    final /* synthetic */ d oBg;

                                    public final void run() {
                                        if (this.oBg.ozG != null && this.oBg.ozG.ozH != null) {
                                            this.oBg.ozG.ozH.xJ(intValue);
                                        }
                                    }
                                });
                            }
                        }
                        if (a(false, jVar.oDl, n.GH().w(xs.field_imgPath, true), a(xs, e, true), true, -1)) {
                            j.G(jVar.oDl, 0);
                            j.G(jVar.oDc, 8);
                            j.G(jVar.oDh, 8);
                            j.G(jVar.oDi, 8);
                            if (aV(xs) == 4 && this.ozG.ozL) {
                                this.ozG.aQ(xs);
                                this.ozG.ozL = false;
                                return;
                            }
                            return;
                        }
                        v.e("MicroMsg.ImageGalleryHolderImage", "failed to show downloaded image!");
                        g.iuh.a(111, 2, 1, true);
                        return;
                    }
                    return;
                }
                if (intValue == this.ozG.ozH.bGP()) {
                    this.ozG.ozH.dm(true);
                }
                if (i3 == -5103059) {
                    x(j2, 5);
                    g.iuh.a(111, 0, 1, true);
                } else {
                    x(j2, 6);
                    g.iuh.a(111, 1, 1, true);
                }
                v.e("MicroMsg.ImageGalleryHolderImage", "onSceneEnd, errType = " + i2 + ", errCode = " + i3);
                this.ozG.ozM.xr(intValue);
                return;
            }
            v.e("MicroMsg.ImageGalleryHolderImage", "param data not integer instance");
        }
    }

    private static boolean xF(int i) {
        return i == 1;
    }

    public final void a(long j, Object obj) {
        if (obj instanceof Integer) {
            v.i("MicroMsg.ImageGalleryHolderImage", "image task canceled at pos " + ((Integer) obj).intValue(), new Object[0]);
            return;
        }
        v.e("MicroMsg.ImageGalleryHolderImage", "param data not integer instance");
    }

    public final void xG(int i) {
        v.i("MicroMsg.ImageGalleryHolderImage", "viewHdImg, pos = " + i);
        at xs = this.ozG.xs(i);
        if (xs == null || xs.field_msgId == 0) {
            v.e("MicroMsg.ImageGalleryHolderImage", "msg is null");
        } else if (b.aH(xs)) {
            com.tencent.mm.ae.d e = e(xs, true);
            if (e == null || e.cLu == 0) {
                v.e("MicroMsg.ImageGalleryHolderImage", "viewHdImg fail, msgLocalId = " + (xs == null ? "null" : Long.valueOf(xs.field_msgId)) + ", imgLocalId = " + (e == null ? "null" : Long.valueOf(e.cLu)));
                return;
            }
            b(xs, 3);
            if (xq(i) != null) {
                a(xq(i), xs, e, true, false, i);
            }
            n.GI().a(e.cLu, xs.field_msgId, 1, Integer.valueOf(i), xs.field_isSend == 1 ? 2130837922 : 2130837919, this, 0);
        } else {
            v.e("MicroMsg.ImageGalleryHolderImage", "not img can't download hd");
        }
    }

    @TargetApi(11)
    private void b(MultiTouchImageView multiTouchImageView, Bitmap bitmap) {
        if (this.ozG != null && this.ozG.ozH != null) {
            v.i("MicroMsg.ImageGalleryHolderImage", "fillBitmap image : %s bmp %s", Integer.valueOf(multiTouchImageView.hashCode()), Integer.valueOf(bitmap.hashCode()));
            if (VERSION.SDK_INT == 20) {
                multiTouchImageView.setLayerType(1, null);
            } else {
                com.tencent.mm.sdk.platformtools.k.h((View) multiTouchImageView.getParent(), bitmap.getWidth(), bitmap.getHeight());
            }
            multiTouchImageView.jOS = false;
            multiTouchImageView.di(bitmap.getWidth(), bitmap.getHeight());
            multiTouchImageView.setImageBitmap(null);
            multiTouchImageView.setImageBitmap(bitmap);
            multiTouchImageView.invalidate();
        }
    }

    public final Bitmap xH(int i) {
        if (this.ozG == null) {
            return null;
        }
        bx xD = this.ozG.ozI.xD(i);
        if (xD == null) {
            return null;
        }
        String str = (String) this.oBe.get(xD);
        if (str == null) {
            str = n.GH().w(xD.field_imgPath, true);
            this.oBe.put(xD, str);
        }
        String str2 = str + "hd";
        if (e.aR(str2)) {
            return Pb(str2);
        }
        return Pb(str);
    }
}
