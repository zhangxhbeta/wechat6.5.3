package com.tencent.mm.plugin.record.ui;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.widget.ImageView;
import com.tencent.mm.a.e;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.plugin.appbrand.jsapi.am;
import com.tencent.mm.plugin.appbrand.jsapi.an;
import com.tencent.mm.plugin.record.a.j;
import com.tencent.mm.plugin.record.a.m;
import com.tencent.mm.plugin.record.ui.h.a;
import com.tencent.mm.plugin.record.ui.h.a.b;
import com.tencent.mm.plugin.record.ui.h.a.c;
import com.tencent.mm.protocal.c.pw;
import com.tencent.mm.protocal.c.qe;
import com.tencent.mm.protocal.c.qj;
import com.tencent.mm.protocal.c.qp;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.v;

public final class g extends j implements a {
    public final void a(a.a aVar) {
        String str = null;
        ImageView imageView = aVar.bdF;
        pw pwVar = aVar.bdE;
        long j = aVar.iqn;
        int i = aVar.bdG;
        int i2 = aVar.width;
        int i3 = aVar.height;
        if (imageView != null) {
            if (!f.sj()) {
                imageView.setImageResource(2130838791);
            } else if (pwVar == null) {
                imageView.setImageResource(i);
            } else {
                qe qeVar;
                switch (pwVar.aKG) {
                    case 4:
                    case am.CTRL_INDEX /*15*/:
                        super.a(imageView, pwVar, j, pwVar.aZh, i, i2, i3);
                        return;
                    case 5:
                        qp qpVar;
                        if (pwVar.msM != null) {
                            qpVar = pwVar.msM.mtc;
                        } else {
                            v.w("MicroMsg.RecordMsgImgService", "webpage: get data proto item null, dataid[%s]", new Object[]{pwVar.luu});
                            qpVar = null;
                        }
                        if (qpVar != null) {
                            str = qpVar.bea;
                        }
                        super.a(imageView, pwVar, j, be.kS(str) ? pwVar.aZh : str, i, i2, i3);
                        return;
                    case 7:
                        super.a(imageView, pwVar, j, pwVar.aZh, i, i2, i3);
                        return;
                    case 10:
                        if (pwVar.msM == null) {
                            v.w("MicroMsg.RecordMsgImgService", "good: get data proto item null, dataid[%s]", new Object[]{pwVar.luu});
                            return;
                        }
                        qeVar = pwVar.msM.mte;
                        if (qeVar != null) {
                            this.ipD.a(imageView, null, qeVar.bea, i, i2, i3);
                            return;
                        }
                        return;
                    case 11:
                        if (pwVar.msM == null) {
                            v.w("MicroMsg.RecordMsgImgService", "product: get data proto item null, dataid[%s]", new Object[]{pwVar.luu});
                            return;
                        }
                        qeVar = pwVar.msM.mte;
                        if (qeVar != null) {
                            this.ipD.a(imageView, null, qeVar.bea, i, i2, i3);
                            return;
                        }
                        return;
                    case an.CTRL_INDEX /*14*/:
                        if (pwVar.msM == null) {
                            v.w("MicroMsg.RecordMsgImgService", "tv: get data proto item null, dataid[%s]", new Object[]{pwVar.luu});
                            return;
                        }
                        qj qjVar = pwVar.msM.mtg;
                        if (qjVar != null) {
                            this.ipD.a(imageView, null, qjVar.bea, i, i2, i3);
                            return;
                        }
                        return;
                    default:
                        v.w("MicroMsg.RecordMsgImgService", "attach thumb, pass data type is %d", new Object[]{Integer.valueOf(pwVar.aKG)});
                        return;
                }
            }
        }
    }

    public final Bitmap a(c cVar) {
        return super.b(cVar.bdE, cVar.iqn);
    }

    public final Bitmap a(b bVar) {
        Bitmap bitmap;
        pw pwVar = bVar.bdE;
        long j = bVar.iqn;
        boolean z = bVar.bdH;
        int i = bVar.maxWidth;
        if (f.sj()) {
            String c = m.c(pwVar, j);
            if (be.kS(c) || !e.aR(c)) {
                v.d("MicroMsg.RecordMsgImgService", "getBitmap file not exist, thumb[%B] path[%s]", new Object[]{Boolean.valueOf(false), c});
                bitmap = null;
            } else {
                bitmap = (Bitmap) this.fMG.get(c);
                if (bitmap != null) {
                    v.d("MicroMsg.RecordMsgImgService", "get bm from cache %s", new Object[]{c});
                } else if (z) {
                    bitmap = null;
                } else {
                    v.d("MicroMsg.RecordMsgImgService", "get from cache fail, try to decode from file, path %s", new Object[]{c});
                    Options options = new Options();
                    options.inJustDecodeBounds = true;
                    bitmap = BitmapFactory.decodeFile(c, options);
                    if (bitmap != null) {
                        v.i("MicroMsg.RecordMsgImgService", "bitmap recycle %s", new Object[]{bitmap});
                        bitmap.recycle();
                    }
                    int i2 = options.outHeight;
                    int i3 = options.outWidth;
                    v.d("MicroMsg.RecordMsgImgService", "width: %s, height: %s", new Object[]{Integer.valueOf(i3), Integer.valueOf(i2)});
                    if (i3 > i) {
                        i2 = (options.outHeight * i) / options.outWidth;
                        i3 = i;
                    }
                    i3 = Math.max(1, i3);
                    i2 = Math.max(1, i2);
                    if (i3 > i) {
                        i3 = (options.outHeight * i) / options.outWidth;
                    } else {
                        i = i3;
                        i3 = i2;
                    }
                    i2 = ExifHelper.JQ(c);
                    if (i2 == 90 || i2 == 270) {
                        int i4 = i3;
                        i3 = i;
                        i = i4;
                    }
                    bitmap = d.b(c, i3, i, false);
                    if (bitmap == null) {
                        v.e("MicroMsg.RecordMsgImgService", "extractThumbNail fail, temBmp is null, filePath = " + c);
                        bitmap = null;
                    } else {
                        bitmap = d.b(bitmap, (float) i2);
                        this.fMG.put(c, bitmap);
                    }
                }
            }
        } else {
            bitmap = BitmapFactory.decodeResource(aa.getContext().getResources(), 2130838791);
        }
        if (bitmap == null && !z) {
            v.d("MicroMsg.RecordMsgImgService", "get image fail, try download, can retry:%B", new Object[]{Boolean.valueOf(super.a(pwVar, j))});
            m.a(pwVar, j, r3);
        }
        return bitmap;
    }

    public final void aJH() {
        super.destory();
    }
}
