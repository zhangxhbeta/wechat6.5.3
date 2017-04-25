package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.tencent.mm.pluginsdk.ui.chat.g;

public abstract class ChatFooterPanel extends LinearLayout {
    public static int SCENE_SNS = 2;
    public static int lGp = 0;
    public static int lGq = 1;
    public a lGm;
    public g lGn;
    protected int lGo;

    public interface a {
        void Tm();

        void append(String str);

        void ayC();

        void ef(boolean z);
    }

    public abstract void ahk();

    public abstract void ahl();

    public abstract void ahm();

    public abstract void ahn();

    public abstract void ahq();

    public abstract void ahr();

    public abstract void cB(boolean z);

    public abstract void jS(int i);

    public abstract void jT(int i);

    public abstract void l(boolean z, boolean z2);

    public abstract void onPause();

    public abstract void onResume();

    public abstract void rL(String str);

    public abstract void rM(String str);

    public abstract void refresh();

    public ChatFooterPanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void a(g gVar) {
        this.lGn = gVar;
    }

    public final void tN(int i) {
        this.lGo = i;
    }

    public void destroy() {
    }
}
