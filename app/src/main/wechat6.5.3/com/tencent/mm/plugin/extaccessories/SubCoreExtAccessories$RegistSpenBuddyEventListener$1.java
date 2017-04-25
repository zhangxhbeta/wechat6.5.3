package com.tencent.mm.plugin.extaccessories;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.samsung.android.sdk.look.writingbuddy.SlookWritingBuddy.ImageWritingListener;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.e.a.lc;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.extaccessories.b.a;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.v;

class SubCoreExtAccessories$RegistSpenBuddyEventListener$1 implements ImageWritingListener {
    final /* synthetic */ lc fIw;
    final /* synthetic */ a fIx;

    SubCoreExtAccessories$RegistSpenBuddyEventListener$1(a aVar, lc lcVar) {
        this.fIx = aVar;
        this.fIw = lcVar;
    }

    public void onImageReceived(Bitmap bitmap) {
        v.i("MicroMsg.extaccessories.SubCoreExtAccessories", "onImageReceived");
        if (bitmap == null) {
            v.e("MicroMsg.extaccessories.SubCoreExtAccessories", "img is null");
            this.fIw.bmw.bmx.Hu(null);
        } else if (f.sj()) {
            b bVar = (b) ak.yP().fY("plugin.extaccessories");
            if (bVar == null) {
                v.w("MicroMsg.extaccessories.SubCoreExtAccessories", "not found in MMCore, new one");
                bVar = new b();
                ak.yP().a("plugin.extaccessories", bVar);
            }
            String str = System.currentTimeMillis();
            String str2 = (!ak.uz() || be.kS(str)) ? "" : bVar.cka + "image/spen/spen_" + str;
            if (be.kS(str2)) {
                v.e("MicroMsg.extaccessories.SubCoreExtAccessories", "filePath is null");
                this.fIw.bmw.bmx.Hu(null);
                return;
            }
            try {
                if (bitmap.getWidth() > 1000 || bitmap.getHeight() > 1000) {
                    v.d("MicroMsg.extaccessories.SubCoreExtAccessories", "spen image %d, %d, need scale", new Object[]{Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight())});
                    Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, bitmap.getWidth() / 2, bitmap.getHeight() / 2, true);
                    if (!(bitmap == createScaledBitmap || createScaledBitmap == null)) {
                        bitmap.recycle();
                        bitmap = createScaledBitmap;
                    }
                }
                d.a(bitmap, 55, CompressFormat.JPEG, str2, true);
                v.d("MicroMsg.extaccessories.SubCoreExtAccessories", "save spen temp image : %s", new Object[]{str2});
                this.fIw.bmw.bmx.Hu(str2);
            } catch (Throwable e) {
                v.e("MicroMsg.extaccessories.SubCoreExtAccessories", "Exception %s", new Object[]{e.getMessage()});
                v.a("MicroMsg.extaccessories.SubCoreExtAccessories", e, "", new Object[0]);
                this.fIw.bmw.bmx.Hu(null);
            }
        } else {
            v.e("MicroMsg.extaccessories.SubCoreExtAccessories", "SDCard not available");
            this.fIw.bmw.bmx.Hu(null);
        }
    }
}
