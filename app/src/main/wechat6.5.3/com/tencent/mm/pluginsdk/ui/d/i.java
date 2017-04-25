package com.tencent.mm.pluginsdk.ui.d;

import android.content.Context;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mm.e.b.bx;
import com.tencent.mm.model.aw;
import com.tencent.mm.pluginsdk.j.a;
import com.tencent.mm.pluginsdk.ui.applet.h;
import com.tencent.mm.pluginsdk.ui.chat.c;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.v;
import java.lang.ref.WeakReference;

public class i extends ClickableSpan {
    private WeakReference<View> fg = null;
    private int hPX;
    boolean hVC = true;
    public boolean hsl = false;
    String jGE;
    private Context lRk = null;
    private int lRp;
    c lRq = null;
    private h lRr = null;

    public i(int i, h hVar) {
        int i2;
        int i3 = 0;
        if (hVar != null) {
            i2 = hVar.linkColor;
            i3 = hVar.backgroundColor;
        } else {
            i2 = 0;
        }
        if (i2 == 0 && i3 == 0) {
            ut(i);
        } else {
            cV(i2, i3);
        }
        this.lRq = new c();
        this.lRr = hVar;
    }

    protected final void ut(int i) {
        Context context = aa.getContext();
        switch (i) {
            case 1:
                cV(context.getResources().getColor(2131689619), -5908174);
                return;
            case 2:
                cV(context.getResources().getColor(2131689819), context.getResources().getColor(2131690028));
                return;
            case 3:
                cV(context.getResources().getColor(2131690035), context.getResources().getColor(2131690028));
                return;
            default:
                return;
        }
    }

    private void cV(int i, int i2) {
        this.lRp = i;
        this.hPX = i2;
    }

    public void onClick(View view) {
        if (this.lRq != null && this.lRr != null && this.hVC) {
            this.lRq.mContext = this.lRk != null ? this.lRk : view.getContext();
            c cVar = this.lRq;
            h hVar = this.lRr;
            if (hVar == null) {
                v.e("MicroMsg.MMSpanClickListener", "onClick error, hrefInfo is null!");
            } else {
                v.d("MicroMsg.MMSpanClickListener", "MMSpanClickListener.onClick, hrefInfo type = %d", Integer.valueOf(hVar.type));
                if (cVar.mContext == null) {
                    v.e("MicroMsg.MMSpanClickListener", "onClick error, context is null!");
                } else {
                    b bVar;
                    String str;
                    if (e.lQS == null || e.lQS.size() <= 0) {
                        bVar = null;
                    } else {
                        int size = e.lQS.size();
                        b bVar2 = (b) e.lQS.getLast();
                        v.d("MicroMsg.MMSpanClickListener", "spanCallbackList.size:%d, get the last callback", Integer.valueOf(size));
                        bVar = bVar2;
                    }
                    if (view != null && (view.getTag() instanceof c)) {
                        bx bxVar = ((c) view.getTag()).bmk;
                        if (bxVar != null) {
                            str = bxVar.field_talker;
                            if (str.endsWith("@chatroom")) {
                                str = aw.fL(bxVar.field_content);
                            }
                            hVar.username = str;
                            hVar.jGE = cVar.jGE;
                            a.lxW.a(cVar.mContext, hVar, bVar);
                            hVar.jGE = null;
                        }
                    }
                    str = null;
                    hVar.username = str;
                    hVar.jGE = cVar.jGE;
                    a.lxW.a(cVar.mContext, hVar, bVar);
                    hVar.jGE = null;
                }
            }
            this.lRq.mContext = null;
            this.hVC = false;
        }
    }

    public void updateDrawState(TextPaint textPaint) {
        super.updateDrawState(textPaint);
        textPaint.setColor(this.lRp);
        textPaint.setUnderlineText(false);
        if (this.hsl) {
            textPaint.bgColor = this.hPX;
        } else {
            textPaint.bgColor = 0;
        }
    }

    public final void setContext(Context context) {
        this.lRk = context;
        this.lRq.mContext = context;
    }
}
