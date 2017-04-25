package com.tencent.mm.pluginsdk.model;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.util.DisplayMetrics;
import com.tencent.mm.a.g;
import com.tencent.mm.ae.p;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.i;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;

public final class r implements i {
    private boolean bdH;
    private long ehb = 0;
    private long ehc = 0;
    private String iei;
    private boolean lzT;
    private int type;
    private String url;

    public static final class a {
        public int h;
        public int w;
        public int x;
        public int y;

        public final String toString() {
            return String.format("crop area[x=%d,y=%d,h=%d,w=%d]", new Object[]{Integer.valueOf(this.x), Integer.valueOf(this.y), Integer.valueOf(this.h), Integer.valueOf(this.w)});
        }
    }

    public r(String str, int i, String str2, boolean z) {
        this.url = str;
        this.type = i;
        this.iei = str2;
        this.bdH = z;
    }

    public static String o(String str, int i, String str2) {
        if (!ak.uz()) {
            return SQLiteDatabase.KeyEmpty;
        }
        r1 = new Object[4];
        ak.yW();
        r1[0] = c.wP();
        r1[1] = Integer.valueOf(i);
        r1[2] = str2;
        r1[3] = g.m(str.getBytes());
        return String.format("%s/ReaderApp_%d%s_%s", r1);
    }

    public final String MU() {
        return o(this.url, this.type, this.iei);
    }

    public final String MV() {
        if (p.GP()) {
            return p.je(this.url);
        }
        return this.url;
    }

    public final String MW() {
        return this.url;
    }

    public final String MX() {
        return this.url + this.iei;
    }

    public final boolean MY() {
        return false;
    }

    public final boolean MZ() {
        return this.bdH;
    }

    public final Bitmap a(Bitmap bitmap, com.tencent.mm.platformtools.i.a aVar) {
        int i = 100;
        if (com.tencent.mm.platformtools.i.a.NET == aVar) {
            DisplayMetrics displayMetrics;
            int i2;
            String str = this.iei;
            a aVar2 = new a();
            Context context = aa.getContext();
            if (context != null) {
                Resources resources = context.getResources();
                if (resources != null) {
                    displayMetrics = resources.getDisplayMetrics();
                    if (displayMetrics == null) {
                        if ("@T".equals(str)) {
                            i = (int) (50.0f * displayMetrics.density);
                            i2 = i;
                        } else {
                            i2 = (int) (((float) displayMetrics.widthPixels) - (60.0f * displayMetrics.density));
                            i = (int) (167.0f * displayMetrics.density);
                        }
                    } else if ("@T".equals(str)) {
                        i2 = 100;
                    } else {
                        i2 = Integer.MAX_VALUE;
                        i = 334;
                    }
                    aVar2.w = i2;
                    aVar2.h = i;
                    v.d("MicroMsg.ReaaderAppGetPicStrategy", aVar2.toString());
                    bitmap = d.a(bitmap, aVar2.w, aVar2.h, true);
                    v.d("MicroMsg.ReaaderAppGetPicStrategy", "handlerBitmap, path:%s", MU());
                    d.a(bitmap, 100, CompressFormat.PNG, MU(), false);
                }
            }
            displayMetrics = null;
            if (displayMetrics == null) {
                if ("@T".equals(str)) {
                    i2 = 100;
                } else {
                    i2 = Integer.MAX_VALUE;
                    i = 334;
                }
            } else if ("@T".equals(str)) {
                i = (int) (50.0f * displayMetrics.density);
                i2 = i;
            } else {
                i2 = (int) (((float) displayMetrics.widthPixels) - (60.0f * displayMetrics.density));
                i = (int) (167.0f * displayMetrics.density);
            }
            aVar2.w = i2;
            aVar2.h = i;
            v.d("MicroMsg.ReaaderAppGetPicStrategy", aVar2.toString());
            bitmap = d.a(bitmap, aVar2.w, aVar2.h, true);
            try {
                v.d("MicroMsg.ReaaderAppGetPicStrategy", "handlerBitmap, path:%s", MU());
                d.a(bitmap, 100, CompressFormat.PNG, MU(), false);
            } catch (Throwable e) {
                v.a("MicroMsg.ReaaderAppGetPicStrategy", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                v.e("MicroMsg.ReaaderAppGetPicStrategy", "save image %s fail", this.url);
            }
        }
        return bitmap;
    }

    public final void Nb() {
        this.ehb = be.Ni();
        if (this.lzT) {
            v.d("MicroMsg.ReaaderAppGetPicStrategy", "beforeGetPicFromNet, from biz msg");
            com.tencent.mm.plugin.report.service.g.iuh.a(86, 0, 1, false);
        }
    }

    public final void H(String str, boolean z) {
        this.ehc = be.Ni();
        Object obj = null;
        if (p.GP() && !be.kS(str) && p.jf(MV()) && str.equals("image/webp")) {
            obj = 1;
        }
        if (!this.lzT) {
            return;
        }
        if (z) {
            long j = this.ehc - this.ehb;
            v.d("MicroMsg.ReaaderAppGetPicStrategy", "afterGetPicFromNet, download biz image success, used %d", Long.valueOf(j));
            com.tencent.mm.plugin.report.service.g.iuh.a(86, 4, j, false);
            if (obj != null) {
                v.d("MicroMsg.ReaaderAppGetPicStrategy", "afterGetPicFromNet, download biz webp image success");
                com.tencent.mm.plugin.report.service.g.iuh.a(86, 17, j, false);
                com.tencent.mm.plugin.report.service.g.iuh.a(86, 13, 1, false);
                return;
            }
            return;
        }
        v.d("MicroMsg.ReaaderAppGetPicStrategy", "afterGetPicFromNet, download biz image failed");
        com.tencent.mm.plugin.report.service.g.iuh.a(86, 2, 1, false);
        if (obj != null) {
            v.d("MicroMsg.ReaaderAppGetPicStrategy", "afterGetPicFromNet, download biz webp image failed");
            com.tencent.mm.plugin.report.service.g.iuh.a(86, 15, 1, false);
        }
    }

    public final void a(com.tencent.mm.platformtools.i.a aVar, String str) {
        if (aVar == com.tencent.mm.platformtools.i.a.NET && this.lzT && p.GP() && !be.kS(str) && p.jf(MV()) && str.equals("image/webp")) {
            v.d("MicroMsg.ReaaderAppGetPicStrategy", "decode download webp picture failed");
            com.tencent.mm.plugin.report.service.g.iuh.a(86, 14, 1, false);
        }
    }

    public final Bitmap Na() {
        return BitmapFactory.decodeResource(aa.getContext().getResources(), 2130838791);
    }
}
