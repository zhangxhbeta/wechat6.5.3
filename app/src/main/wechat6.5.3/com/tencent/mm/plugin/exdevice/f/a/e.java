package com.tencent.mm.plugin.exdevice.f.a;

import android.content.Context;
import android.content.Intent;
import android.widget.ImageView;
import com.tencent.mm.ay.c;
import com.tencent.mm.model.k;
import com.tencent.mm.modelcdntran.b;
import com.tencent.mm.modelcdntran.h;
import com.tencent.mm.plugin.exdevice.model.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.g.d;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public final class e {

    static class AnonymousClass1 implements Runnable {
        final /* synthetic */ ImageView fwb;
        final /* synthetic */ int fwc = 2131689643;
        final /* synthetic */ Context val$context;
        final /* synthetic */ String val$url;

        AnonymousClass1(Context context, ImageView imageView, String str, int i) {
            this.val$context = context;
            this.fwb = imageView;
            this.val$url = str;
        }

        public final void run() {
            e.b(this.fwb, this.val$url, this.fwc);
        }
    }

    public static void a(Context context, ImageView imageView, String str) {
        Assert.assertTrue(imageView != null);
        if (ad.isMainThread()) {
            b(imageView, str, 2131689643);
        } else {
            ad.o(new AnonymousClass1(context, imageView, str, 2131689643));
        }
    }

    static void b(ImageView imageView, String str, int i) {
        if (be.kS(str) || "#".equals(str)) {
            v.d("MicroMsg.ExdeviceRankUtil", "hy: url is null or nill. set to default picture resource");
            imageView.setImageResource(i);
            return;
        }
        v.d("MicroMsg.ExdeviceRankUtil", "hy: set url to %s", new Object[]{str});
        ac.ajt().a(str, imageView, ac.sf(str));
    }

    public static void b(final MMActivity mMActivity) {
        List linkedList = new LinkedList();
        List linkedList2 = new LinkedList();
        linkedList.add(mMActivity.getString(2131232510));
        linkedList2.add(Integer.valueOf(0));
        g.a(mMActivity, "", linkedList, linkedList2, null, true, new d() {
            public final void bw(int i, int i2) {
                switch (i2) {
                    case 0:
                        MMActivity mMActivity = mMActivity;
                        Intent intent = new Intent();
                        intent.putExtra("query_source_type", 9);
                        intent.putExtra("query_media_type", 1);
                        intent.putExtra("max_select_count", 1);
                        c.b(mMActivity, "gallery", ".ui.AlbumPreviewUI", intent, 1001);
                        return;
                    default:
                        return;
                }
            }
        });
    }

    public static boolean a(MMActivity mMActivity, int i, int i2, Intent intent, String str) {
        if (i == 1001 && i2 == -1) {
            ArrayList stringArrayListExtra = intent.getStringArrayListExtra("CropImage_OutputPath_List");
            if (stringArrayListExtra == null || stringArrayListExtra.size() <= 0) {
                return false;
            }
            String str2 = (String) stringArrayListExtra.get(0);
            Intent intent2 = new Intent();
            intent2.putExtra("CropImageMode", 1);
            intent2.putExtra("CropImage_OutputPath", com.tencent.mm.compatible.util.e.cgp + "temp.cover");
            intent2.putExtra("CropImage_ImgPath", str2);
            c.a(mMActivity, ".ui.tools.CropImageNewUI", intent2, 1002);
            return true;
        } else if (i != 1002 || i2 != -1) {
            return false;
        } else {
            String sh = d.sh(com.tencent.mm.compatible.util.e.cgp + "temp.cover");
            c ajA = ac.ajA();
            ajA.appName = str;
            long currentTimeMillis = System.currentTimeMillis();
            ajA.fvY = com.tencent.mm.modelcdntran.d.a("uploadexdeivce", currentTimeMillis, k.ym().field_username, String.valueOf(currentTimeMillis));
            String str3 = ajA.fvY;
            h hVar = new h();
            hVar.cFR = ajA;
            hVar.field_mediaId = str3;
            hVar.field_fullpath = sh;
            hVar.field_thumbpath = "";
            hVar.field_fileType = b.cEJ;
            hVar.field_talker = "";
            hVar.field_priority = b.cEz;
            hVar.field_needStorage = true;
            hVar.field_isStreamMedia = false;
            hVar.field_appType = 200;
            hVar.field_bzScene = 2;
            if (!com.tencent.mm.modelcdntran.g.DZ().b(hVar)) {
                v.e("MicroMsg.ExdevicePictureUploader", "hy: cdntra addSendTask failed. clientid:%s", new Object[]{str3});
            }
            return true;
        }
    }
}
