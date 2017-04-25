package com.tencent.mm.plugin.location.ui;

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

public class SimpleImageView extends ImageView {
    public int fQm;
    public int gVE;
    public ac handler = new ac(this) {
        final /* synthetic */ SimpleImageView gVF;

        {
            this.gVF = r1;
        }

        public final void handleMessage(Message message) {
            byte[] bArr = (byte[]) message.obj;
            if (bArr == null || bArr.length == 0) {
                v.e("MicroMsg.SimpleImageView", "handleMsg fail, data is null");
                return;
            }
            Bitmap bitmap;
            Bitmap bc = d.bc(bArr);
            v.d("MicroMsg.SimpleImageView", "filePath  %s", new Object[]{this.gVF.imagePath + g.m(this.gVF.url.getBytes())});
            e.b(r2, bArr, bArr.length);
            if (bc == null || this.gVF.gVE <= 0 || this.gVF.fQm <= 0) {
                bitmap = bc;
            } else {
                bitmap = d.a(bc, this.gVF.fQm, this.gVF.gVE, true, false);
            }
            this.gVF.setImageBitmap(bitmap);
        }
    };
    public String imagePath;
    public String url = null;

    static class a implements Runnable {
        private ac handler;
        private String url;

        public a(String str, ac acVar) {
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

    public SimpleImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
