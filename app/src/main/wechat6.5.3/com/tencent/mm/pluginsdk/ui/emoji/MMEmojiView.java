package com.tencent.mm.pluginsdk.ui.emoji;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.plugin.gif.MMGIFImageView;
import com.tencent.mm.plugin.gif.b;
import com.tencent.mm.pluginsdk.j.a;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.a.c;
import java.io.IOException;

public class MMEmojiView extends MMGIFImageView {
    private c fgM;

    public MMEmojiView(Context context) {
        this(context, null);
    }

    public MMEmojiView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public MMEmojiView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public final void a(c cVar, String str) {
        this.fgM = cVar;
        String dR = cVar.dR(cVar.field_groupId, cVar.EB());
        if ((cVar.field_reserved4 & c.nxh) != c.nxh) {
            bM(dR, str);
        } else if (b.atw().ux(str) != null) {
            setImageDrawable(b.atw().ux(str));
        } else {
            a(this.fgM, a.bmr().g(this.fgM), str);
        }
    }

    public final void a(c cVar, byte[] bArr, String str) {
        this.fgM = cVar;
        try {
            if (!be.bl(bArr)) {
                Drawable aVar;
                if (be.kS(str)) {
                    aVar = new com.tencent.mm.plugin.gif.a(bArr);
                } else {
                    this.eZd = str;
                    aVar = b.atw().o(this.eZd, bArr);
                }
                setImageDrawable(aVar);
                return;
            }
        } catch (MMGIFException e) {
            MMGIFImageView.a(e);
            if (e.getErrorCode() == MMGIFException.D_GIF_ERR_NOT_GIF_FILE) {
                v.d("MicroMsg.emoji.MMEmojiView", "setMMGIFFileByteArray D_GIF_ERR_NOT_GIF_FILE");
                Bitmap bc = d.bc(bArr);
                if (bc != null) {
                    bc.setDensity(240);
                    setImageBitmap(bc);
                    return;
                }
                v.w("MicroMsg.emoji.MMEmojiView", "setMMGIFFileByteArray failedbitmap is null. bytes %s", bArr.toString());
                if (this.fgM != null) {
                    this.fgM.bxF();
                    v.i("MicroMsg.emoji.MMEmojiView", "delete file.");
                }
                init();
                return;
            }
            v.e("MicroMsg.emoji.MMEmojiView", "setMMGIFFileByteArray failed. %s", e.toString());
            if (this.fgM != null) {
                this.fgM.bxF();
                v.i("MicroMsg.emoji.MMEmojiView", "delete file.");
            }
        } catch (IOException e2) {
            v.e("MicroMsg.emoji.MMEmojiView", "setMMGIFFileByteArray failed. %s", e2.toString());
        }
        if (this.fgM != null) {
            this.fgM.bxF();
            v.i("MicroMsg.emoji.MMEmojiView", "delete file.");
        }
        init();
    }
}
