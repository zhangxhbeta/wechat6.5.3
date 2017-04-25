package com.tencent.mm.plugin.brandservice.ui.base;

import android.content.Context;
import android.view.View;

public abstract class a {
    public Object data;
    public boolean ezH;
    public int type;

    public interface a {
    }

    public static abstract class b {
        public abstract void a(Context context, a aVar, a aVar2);

        public abstract void a(View view, a aVar);

        public abstract boolean a(Context context, a aVar, Object... objArr);

        public abstract View b(Context context, View view);
    }

    public abstract b Yn();

    public abstract a Yo();

    public abstract void a(Context context, a aVar, Object... objArr);

    public a(int i, Object obj) {
        this.type = i;
        this.data = obj;
    }
}
