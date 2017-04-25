package com.tencent.mm.plugin.nearlife.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Message;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.mm.a.e;
import com.tencent.mm.a.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.v;

public class LogoImageView extends ImageView {
    int fQm;
    int gVE;
    ac handler = new ac(this) {
        final /* synthetic */ LogoImageView hHl;

        {
            this.hHl = r1;
        }

        public final void handleMessage(Message message) {
            byte[] bArr = (byte[]) message.obj;
            if (bArr == null || bArr.length == 0) {
                v.e("MicroMsg.LogoImageView", "handleMsg fail, data is null");
                return;
            }
            Bitmap bitmap;
            Bitmap bc = d.bc(bArr);
            v.d("MicroMsg.LogoImageView", "filePath  %s", new Object[]{this.hHl.imagePath + g.m(this.hHl.url.getBytes())});
            e.b(r2, bArr, bArr.length);
            if (bc == null || this.hHl.gVE <= 0 || this.hHl.fQm <= 0) {
                bitmap = bc;
            } else {
                bitmap = d.a(bc, this.hHl.fQm, this.hHl.gVE, true, false);
            }
            this.hHl.setImageBitmap(bitmap);
        }
    };
    String imagePath;
    String url = null;

    static class a implements Runnable {
        private ac handler;
        private String url;

        a(String str, ac acVar) {
            this.url = str;
            this.handler = acVar;
        }

        public final void run() {
            Object KO = be.KO(this.url);
            Message obtain = Message.obtain();
            obtain.obj = KO;
            this.handler.sendMessage(obtain);
        }
    }

    public LogoImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
