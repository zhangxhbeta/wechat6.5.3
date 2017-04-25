package com.tencent.mm.plugin.record.a;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.SystemClock;
import android.widget.ImageView;
import com.tencent.mm.a.e;
import com.tencent.mm.a.f;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.platformtools.i;
import com.tencent.mm.pluginsdk.ui.tools.h;
import com.tencent.mm.protocal.c.pw;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.v;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;

public class j {
    private HashMap<String, String[]> fME = new HashMap();
    public f<String, Bitmap> fMG = new f(10);
    public h ipD = new h(this) {
        final /* synthetic */ j ipG;

        {
            this.ipG = r2;
        }

        protected final i d(String str, String str2, int i, int i2) {
            return new o(str, str2, i, i2);
        }
    };
    private HashSet<String> ipE = new HashSet();
    private HashMap<String, a> ipF = new HashMap();

    public final void destory() {
        this.ipD.destory();
        this.fME.clear();
        this.ipE.clear();
        this.ipD = null;
        this.fME = null;
        this.ipE = null;
    }

    public final boolean a(pw pwVar, long j) {
        String c = m.c(pwVar.luu, j, true);
        a aVar = (a) this.ipF.get(c);
        if (aVar == null) {
            this.ipF.put(c, new a());
            return true;
        } else if (aVar.sn() <= 30000) {
            return false;
        } else {
            aVar.cgu = SystemClock.elapsedRealtime();
            return true;
        }
    }

    public final Bitmap a(pw pwVar, long j, boolean z, boolean z2) {
        if (!com.tencent.mm.compatible.util.f.sj()) {
            return BitmapFactory.decodeResource(aa.getContext().getResources(), 2130838791);
        }
        String f;
        if (z) {
            f = m.f(pwVar, j);
        } else {
            f = m.c(pwVar, j);
        }
        if (be.kS(f) || !e.aR(f)) {
            v.d("MicroMsg.RecordMsgImgService", "getBitmap file not exist, thumb[%B] path[%s]", new Object[]{Boolean.valueOf(z), f});
            return null;
        }
        Bitmap bitmap = (Bitmap) this.fMG.get(f);
        if (bitmap != null) {
            return bitmap;
        }
        int i;
        int i2;
        v.d("MicroMsg.RecordMsgImgService", "get from cache fail, try to decode from file, path %s", new Object[]{f});
        Options options = new Options();
        options.inJustDecodeBounds = true;
        bitmap = BitmapFactory.decodeFile(f, options);
        if (bitmap != null) {
            v.i("MicroMsg.RecordMsgImgService", "bitmap recycled %s", new Object[]{bitmap});
            bitmap.recycle();
        }
        Object obj = (!d.aZ(options.outWidth, options.outHeight) || options.outWidth <= 480) ? null : 1;
        Object obj2 = (!d.aY(options.outWidth, options.outHeight) || options.outHeight <= 480) ? null : 1;
        if (obj == null && obj2 == null) {
            i = 960;
            i2 = 960;
        } else {
            i = options.outHeight;
            i2 = options.outWidth;
        }
        int JQ = ExifHelper.JQ(f);
        if (JQ == 90 || JQ == 270) {
            int i3 = i2;
            i2 = i;
            i = i3;
        }
        bitmap = d.b(f, i, i2, false);
        if (bitmap == null) {
            v.e("MicroMsg.RecordMsgImgService", "extractThumbNail fail, temBmp is null, filePath = " + f);
            return null;
        }
        bitmap = d.b(bitmap, (float) JQ);
        this.fMG.put(f, bitmap);
        return bitmap;
    }

    public final Bitmap b(pw pwVar, long j) {
        Bitmap a = a(pwVar, j, true, false);
        if (a == null) {
            v.d("MicroMsg.RecordMsgImgService", "get thumb fail, try download, can retry:%B", new Object[]{Boolean.valueOf(a(pwVar, j))});
            m.b(pwVar, j, r1);
        }
        return a;
    }

    public final void a(ImageView imageView, pw pwVar, long j, String str, int i, int i2, int i3) {
        String str2 = m.sX(pwVar.luu) + "@" + String.valueOf(j);
        if (pwVar.luu != null) {
            String[] strArr;
            String[] strArr2 = (String[]) this.fME.get(str2);
            if (strArr2 == null || strArr2.length <= 0) {
                strArr = new String[]{m.f(pwVar, j)};
                this.fME.put(str2, strArr);
            } else {
                strArr = strArr2;
            }
            this.ipD.a(imageView, strArr, str, i, i2, i3);
            if (!this.ipE.contains(str2)) {
                this.ipE.add(str2);
                if (!new File(strArr[0]).exists() && !be.kS(pwVar.coj)) {
                    m.b(pwVar, j, a(pwVar, j));
                }
            }
        }
    }
}
