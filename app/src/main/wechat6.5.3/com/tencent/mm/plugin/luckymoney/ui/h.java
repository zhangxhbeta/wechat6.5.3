package com.tencent.mm.plugin.luckymoney.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;
import com.tencent.mm.e.a.bp;
import com.tencent.mm.model.ak;
import com.tencent.mm.platformtools.d;
import com.tencent.mm.plugin.luckymoney.c.n;
import com.tencent.mm.pluginsdk.ui.GetHdHeadImageGalleryView;
import com.tencent.mm.protocal.c.pw;
import com.tencent.mm.protocal.c.qf;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.g.c;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.tools.MMGestureGallery;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class h {
    private static final Drawable hhb = new ColorDrawable();
    private Activity aXH;
    private o hha;
    private GetHdHeadImageGalleryView hhc;
    private int hhd;
    private int hhe;
    private String imagePath;
    private String username;

    public enum a {
        ;

        static {
            hhg = 1;
            hhh = 2;
            hhi = 3;
            hhj = new int[]{hhg, hhh, hhi};
        }
    }

    static /* synthetic */ void a(h hVar) {
        List arrayList = new ArrayList();
        arrayList.add(hVar.aXH.getString(2131234560));
        arrayList.add(hVar.aXH.getString(2131234727));
        arrayList.add(hVar.aXH.getString(2131234180));
        g.a(hVar.aXH, null, (String[]) arrayList.toArray(new String[arrayList.size()]), "", new c(hVar) {
            final /* synthetic */ h hhf;

            {
                this.hhf = r1;
            }

            public final void gT(int i) {
                String b;
                switch (i) {
                    case 0:
                        v.i("MicroMsg.LuckyMoneyPreviewImgGallaryView", "shareImgToFriend");
                        b = this.hhf.imagePath;
                        Context c = this.hhf.aXH;
                        if (be.kS(b)) {
                            v.w("MicroMsg.LuckyMoneyApplication", "share image to friend fail, imgPath is null");
                        } else {
                            Intent intent = new Intent();
                            intent.putExtra("Retr_File_Name", b);
                            intent.putExtra("Retr_Compress_Type", 0);
                            intent.putExtra("Retr_Msg_Type", 0);
                            com.tencent.mm.plugin.luckymoney.a.drp.l(intent, c);
                        }
                        if (this.hhf.hhe == 1) {
                            com.tencent.mm.plugin.report.service.g.iuh.h(13079, new Object[]{Integer.valueOf(8), Integer.valueOf(1)});
                            return;
                        }
                        com.tencent.mm.plugin.report.service.g.iuh.h(13079, new Object[]{Integer.valueOf(8), Integer.valueOf(2)});
                        return;
                    case 1:
                        v.i("MicroMsg.LuckyMoneyPreviewImgGallaryView", "saveImg");
                        b = this.hhf.imagePath;
                        CharSequence string = this.hhf.aXH.getString(2131233652);
                        Context c2 = this.hhf.aXH;
                        if (be.kS(b)) {
                            v.w("MicroMsg.LuckyMoneyApplication", "save image fail, path is null");
                        } else if (!d.b(b, c2)) {
                            Toast.makeText(c2, string, 1).show();
                        }
                        if (this.hhf.hhe == 1) {
                            com.tencent.mm.plugin.report.service.g.iuh.h(13079, new Object[]{Integer.valueOf(9), Integer.valueOf(1)});
                            return;
                        }
                        com.tencent.mm.plugin.report.service.g.iuh.h(13079, new Object[]{Integer.valueOf(9), Integer.valueOf(2)});
                        return;
                    case 2:
                        v.i("MicroMsg.LuckyMoneyPreviewImgGallaryView", "doFav");
                        h.e(this.hhf);
                        if (this.hhf.hhe == 1) {
                            com.tencent.mm.plugin.report.service.g.iuh.h(13079, new Object[]{Integer.valueOf(10), Integer.valueOf(1)});
                            return;
                        }
                        com.tencent.mm.plugin.report.service.g.iuh.h(13079, new Object[]{Integer.valueOf(10), Integer.valueOf(2)});
                        return;
                    default:
                        return;
                }
            }
        });
    }

    static /* synthetic */ void e(h hVar) {
        bp bpVar = new bp();
        qf qfVar = new qf();
        pw pwVar = new pw();
        pwVar.uG(2);
        pwVar.IK(hVar.imagePath);
        LinkedList linkedList = new LinkedList();
        linkedList.add(pwVar);
        qfVar.ah(linkedList);
        bpVar.aZd.aZf = qfVar;
        bpVar.aZd.type = 2;
        bpVar.aZd.aXH = hVar.aXH;
        bpVar.aZd.aZl = 2;
        com.tencent.mm.sdk.c.a.nhr.z(bpVar);
    }

    public h(Activity activity, String str, String str2) {
        this(activity, str, str2, a.hhg);
    }

    private h(Activity activity, String str, String str2, int i) {
        this.hhe = 1;
        this.aXH = activity;
        this.username = str;
        this.imagePath = str2;
        this.hhd = i;
    }

    public final void k(boolean z, int i) {
        v.i("MicroMsg.LuckyMoneyPreviewImgGallaryView", "previewImg readImgFromCache:" + z + ", sceneFromUI:" + i);
        View inflate = LayoutInflater.from(this.aXH).inflate(2130903772, null);
        this.hha = new o(inflate, -1, -1);
        this.hha.setFocusable(true);
        this.hha.setOutsideTouchable(true);
        this.hha.setBackgroundDrawable(hhb);
        this.hha.showAtLocation(this.aXH.getWindow().getDecorView(), 49, 0, 0);
        this.hhc = (GetHdHeadImageGalleryView) inflate.findViewById(2131755843);
        this.hhc.lGs = this.hha;
        this.hhc.username = this.username;
        this.hhc.iJV = this.imagePath;
        this.hhe = i;
        ak.yW();
        Bitmap Y;
        if (com.tencent.mm.model.c.isSDCardAvailable()) {
            Y = n.Y(this.imagePath, z);
            if (Y == null || Y.isRecycled()) {
                v.i("MicroMsg.LuckyMoneyPreviewImgGallaryView", "The image of %s is not in the cache, use default avatar", new Object[]{this.username});
            } else {
                v.i("MicroMsg.LuckyMoneyPreviewImgGallaryView", "The image of %s is in the cache", new Object[]{this.username});
                this.hhc.B(Y);
            }
            this.hhc.oTn = new MMGestureGallery.c(this) {
                final /* synthetic */ h hhf;

                {
                    this.hhf = r1;
                }

                public final void amC() {
                    h.a(this.hhf);
                }
            };
            return;
        }
        v.i("MicroMsg.LuckyMoneyPreviewImgGallaryView", "previewImg sdcard is not available!");
        s.ey(this.aXH);
        Y = BitmapFactory.decodeResource(aa.getContext().getResources(), 2130838791);
        try {
            Bitmap createBitmap;
            if (Y.getWidth() < 480) {
                float width = (float) (480 / Y.getWidth());
                Matrix matrix = new Matrix();
                matrix.postScale(width, width);
                createBitmap = Bitmap.createBitmap(Y, 0, 0, Y.getWidth(), Y.getHeight(), matrix, true);
            } else {
                createBitmap = Y;
            }
            v.d("MicroMsg.LuckyMoneyPreviewImgGallaryView", "dkhdbm old[%d %d] new[%d %d]", new Object[]{Integer.valueOf(Y.getWidth()), Integer.valueOf(Y.getHeight()), Integer.valueOf(createBitmap.getWidth()), Integer.valueOf(createBitmap.getHeight())});
            this.hhc.B(createBitmap);
            this.hhc.iJV = null;
        } catch (Throwable e) {
            v.a("MicroMsg.LuckyMoneyPreviewImgGallaryView", e, "", new Object[0]);
        }
    }
}
