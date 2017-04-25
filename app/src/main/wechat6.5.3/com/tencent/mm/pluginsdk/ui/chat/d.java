package com.tencent.mm.pluginsdk.ui.chat;

import android.content.Context;
import android.view.View;
import com.tencent.mm.bd.a;
import com.tencent.mm.pluginsdk.ui.emoji.PreViewEmojiView;
import com.tencent.mm.storage.a.c;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.s;

public final class d {
    private View Hq = View.inflate(this.mContext, 2130903284, null);
    public c fgM;
    public PreViewEmojiView lNE = ((PreViewEmojiView) this.Hq.findViewById(2131756066));
    public o lNF = new o(this.mContext);
    public View lNG;
    public int lNH = a.N(this.mContext, 2131493447);
    public int lNI;
    public Context mContext;

    public d(Context context, View view) {
        this.mContext = context;
        this.lNG = view;
        this.lNF.setContentView(this.Hq);
        this.lNF.setOutsideTouchable(false);
        this.lNF.setFocusable(false);
        this.lNF.setBackgroundDrawable(null);
        this.lNI = s.eA(this.mContext);
    }
}
