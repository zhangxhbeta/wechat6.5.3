package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Message;
import com.tencent.mm.a.g;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.webview.stub.e;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.o;
import com.tencent.mm.sdk.platformtools.v;
import java.io.IOException;

public final class c extends Thread {
    private String TAG = "MicroMsg.DownloadEmojiThread";
    private String bea;
    private boolean cRi = false;
    private a loh;
    a loi;

    public interface a {
        void remove();
    }

    public c(e eVar, k kVar, String str, String str2, String str3, i iVar) {
        this.loh = new a(eVar, kVar, str, str3, iVar);
        this.bea = str2;
    }

    public final void interrupt() {
        super.interrupt();
        if (this.loi != null) {
            this.loi.remove();
        }
        this.cRi = true;
    }

    public final void run() {
        if (interrupted()) {
            v.v(this.TAG, "add_emoticon:cancel,emojiUrl : " + this.loh.url);
            v.v(this.TAG, "cancel_add_emoticon:ok");
            blb();
            return;
        }
        byte[] KO = be.KO(this.bea);
        byte[] KO2 = be.KO(this.loh.url);
        if (this.cRi) {
            v.v(this.TAG, "add_emoticon:cancel,emojiUrl : " + this.loh.url);
            blb();
        } else if (KO2 == null) {
            bla();
        } else {
            ak.yW();
            String wY = com.tencent.mm.model.c.wY();
            String m = g.m(KO2);
            if (be.kS(m)) {
                bla();
                return;
            }
            if (KO != null) {
                Bitmap bc = d.bc(KO);
                if (bc != null) {
                    l(wY + m + "_thumb", bc);
                }
            }
            Message obtainMessage = this.loh.obtainMessage(10);
            this.loh.aZy = m;
            com.tencent.mm.a.e.b(wY + m, KO2, KO2.length);
            this.loh.len = KO2.length;
            if (o.be(KO2)) {
                obtainMessage.arg1 = 1;
            } else {
                obtainMessage.arg1 = 0;
            }
            this.loh.sendMessage(obtainMessage);
            bkZ();
        }
    }

    private void bkZ() {
        if (this.loi != null) {
            this.loi.remove();
        }
    }

    private void bla() {
        this.loh.sendEmptyMessage(11);
        bkZ();
    }

    private void blb() {
        this.loh.sendEmptyMessage(-1);
        bkZ();
    }

    private static boolean l(String str, Bitmap bitmap) {
        try {
            d.a(bitmap, 100, CompressFormat.PNG, str, true);
            return true;
        } catch (IOException e) {
            return false;
        }
    }
}
