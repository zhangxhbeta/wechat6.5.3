package com.tencent.mm.plugin.webview.e;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import com.tencent.mm.sdk.i.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.v;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Locale;

public final class f {
    ac ihw = new ac(Looper.getMainLooper(), this.lho);
    View lhl;
    public String lhm;
    c lhn;
    private com.tencent.mm.sdk.platformtools.ac.a lho = new com.tencent.mm.sdk.platformtools.ac.a(this) {
        final /* synthetic */ f lhp;

        {
            this.lhp = r1;
        }

        public final boolean handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    Bitmap createBitmap = Bitmap.createBitmap(this.lhp.lhl.getWidth(), this.lhp.lhl.getHeight(), Config.ARGB_8888);
                    if (createBitmap != null) {
                        createBitmap.eraseColor(-1);
                        this.lhp.lhl.draw(new Canvas(createBitmap));
                    }
                    if (createBitmap != null) {
                        e.a(new b(this.lhp, createBitmap), "ViewCaptureHelper_SaveBitmap");
                        this.lhp.lhl = null;
                        break;
                    }
                    break;
                case 2:
                    if (this.lhp.lhn != null) {
                        this.lhp.lhn.Ey(this.lhp.lhm);
                        break;
                    }
                    break;
            }
            return false;
        }
    };

    private final class a implements Runnable {
        final /* synthetic */ f lhp;

        private a(f fVar) {
            this.lhp = fVar;
        }

        public final void run() {
            if (this.lhp.lhm != null) {
                int length = new File(this.lhp.lhm).getParentFile().listFiles(new FilenameFilter(this) {
                    final /* synthetic */ a lhq;

                    {
                        this.lhq = r1;
                    }

                    public final boolean accept(File file, String str) {
                        return str.matches(".+_.+.\\.jpg");
                    }
                }).length;
                for (int i = 0; i < length; i++) {
                    v.i("MicroMsg.ViewCaptureHelper", "deleteFile result: %b", new Object[]{Boolean.valueOf(r2[i].delete())});
                }
                this.lhp.lhm = null;
            }
        }
    }

    private final class b implements Runnable {
        final /* synthetic */ f lhp;
        private Bitmap mBitmap;

        public b(f fVar, Bitmap bitmap) {
            this.lhp = fVar;
            this.mBitmap = bitmap;
        }

        public final void run() {
            this.lhp.lhm = String.format(Locale.US, "%s%s_%08x.jpg", new Object[]{com.tencent.mm.compatible.util.e.cnj, Long.valueOf(System.currentTimeMillis()), Integer.valueOf(this.mBitmap.hashCode())});
            try {
                d.a(this.mBitmap, 100, CompressFormat.JPEG, this.lhp.lhm, true);
            } catch (IOException e) {
                v.e("MicroMsg.ViewCaptureHelper", "saveBitmapToImage failed, " + e.getMessage());
                this.lhp.lhm = null;
            }
            this.mBitmap.recycle();
            this.lhp.ihw.sendEmptyMessage(2);
        }
    }

    public interface c {
        void Ey(String str);
    }

    public final void a(View view, c cVar) {
        this.lhl = view;
        this.lhn = cVar;
        this.ihw.sendEmptyMessage(1);
    }

    public final void bji() {
        e.a(new a(), "ViewCaptureHelper_DeleteBitmap");
    }
}
