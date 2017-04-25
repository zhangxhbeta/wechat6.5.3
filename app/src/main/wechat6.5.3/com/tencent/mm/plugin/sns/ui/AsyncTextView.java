package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.mm.pluginsdk.ui.d.e;
import com.tencent.mm.pluginsdk.ui.d.f;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.pluginsdk.ui.d.j.a;

public class AsyncTextView extends TextView implements Runnable {
    private Context context;
    public int eKg;
    public String jEa;
    public boolean jEb;
    public String jEc;
    public a jEd;
    public String userName;

    public AsyncTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.context = context;
    }

    public AsyncTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
    }

    public void run() {
        if (getTag() instanceof String) {
            String str = (String) getTag();
            if (str != null && str.equals(this.userName)) {
                return;
            }
        }
        int i = this.eKg == 11 ? 3 : 2;
        j jVar = new j(new com.tencent.mm.plugin.sns.data.a(this.jEb, this.userName, this.jEc, 1), this.jEd, i);
        Context context = getContext();
        CharSequence charSequence = this.jEa;
        getTextSize();
        CharSequence fVar = new f(e.b(context, charSequence, i));
        fVar.f(jVar, this.jEa);
        setText(fVar, BufferType.SPANNABLE);
        setTag(this.userName);
    }
}
