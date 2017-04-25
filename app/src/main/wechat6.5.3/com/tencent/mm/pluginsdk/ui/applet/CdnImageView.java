package com.tencent.mm.pluginsdk.ui.applet;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import android.os.Message;
import android.util.AttributeSet;
import com.tencent.mm.ae.b;
import com.tencent.mm.ae.n;
import com.tencent.mm.sdk.i.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mmdb.database.SQLiteDatabase;

public class CdnImageView extends MMImageView {
    private int fQm;
    private int gVE;
    private ac handler;
    private String lJu;
    private String url;

    static class a implements Runnable {
        private ac handler;
        private String url;

        a(String str, ac acVar) {
            this.url = str;
            this.handler = acVar;
        }

        public final void run() {
            byte[] KO = be.KO(this.url);
            Message obtain = Message.obtain();
            Bundle bundle = new Bundle();
            bundle.putByteArray("k_data", KO);
            bundle.putString("k_url", this.url);
            obtain.setData(bundle);
            this.handler.sendMessage(obtain);
        }
    }

    public CdnImageView(Context context) {
        this(context, null);
    }

    public CdnImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CdnImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.url = null;
        this.handler = new ac(this) {
            final /* synthetic */ CdnImageView lJv;

            {
                this.lJv = r1;
            }

            public final void handleMessage(Message message) {
                String ah = be.ah(message.getData().getString("k_url"), SQLiteDatabase.KeyEmpty);
                this.lJv.url = be.ah(this.lJv.url, SQLiteDatabase.KeyEmpty);
                if (be.kS(this.lJv.url) && be.kS(ah)) {
                    this.lJv.setImageBitmap(null);
                    this.lJv.p(null);
                } else if (this.lJv.url.equals(ah)) {
                    byte[] byteArray = message.getData().getByteArray("k_data");
                    if (byteArray == null || byteArray.length == 0) {
                        v.e("MicroMsg.CdnImageView", "handleMsg fail, data is null");
                        return;
                    }
                    Bitmap bitmap;
                    Bitmap bc = d.bc(byteArray);
                    n.GG();
                    b.f(this.lJv.url, bc);
                    if (bc == null || this.lJv.gVE <= 0 || this.lJv.fQm <= 0) {
                        bitmap = bc;
                    } else {
                        bitmap = d.a(bc, this.lJv.fQm, this.lJv.gVE, true, false);
                    }
                    if (!(bitmap == null || be.kS(this.lJv.lJu))) {
                        try {
                            d.a(bitmap, 100, CompressFormat.JPEG, this.lJv.lJu, false);
                        } catch (Exception e) {
                            v.e("MicroMsg.CdnImageView", "save image failed, %s", e.getMessage());
                        }
                    }
                    this.lJv.setImageBitmap(bitmap);
                    this.lJv.p(bitmap);
                } else {
                    v.d("MicroMsg.CdnImageView", "hy: url not equal. abort this msg");
                }
            }
        };
    }

    public void p(Bitmap bitmap) {
    }

    public void G(String str, int i, int i2) {
        Bitmap JV;
        this.url = str;
        this.gVE = i;
        this.fQm = i2;
        this.lJu = null;
        if (!be.kS(this.lJu)) {
            JV = d.JV(this.lJu);
            if (JV != null && JV.getWidth() > 0 && JV.getHeight() > 0) {
                setImageBitmap(JV);
                p(JV);
                return;
            }
        }
        if (str == null || str.length() == 0) {
            setVisibility(8);
        } else if (str.startsWith("http")) {
            n.GG();
            JV = b.gu(str);
            if (JV != null) {
                if (this.gVE > 0 && this.fQm > 0) {
                    JV = d.a(JV, this.gVE, this.fQm, true, false);
                }
                setImageBitmap(JV);
                p(JV);
                return;
            }
            e.a(new a(str, this.handler), "CdnImageView_download");
        } else if (com.tencent.mm.a.e.aR(str)) {
            JV = (this.gVE <= 0 || this.fQm <= 0) ? d.JV(str) : d.b(str, this.gVE, this.fQm, true);
            if (JV == null) {
                setVisibility(8);
                return;
            }
            setImageBitmap(JV);
            p(JV);
        } else {
            setVisibility(8);
        }
    }
}
