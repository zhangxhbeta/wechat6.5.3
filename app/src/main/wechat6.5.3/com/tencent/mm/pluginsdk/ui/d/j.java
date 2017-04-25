package com.tencent.mm.pluginsdk.ui.d;

import android.view.View;

public class j extends i {
    private a lRs;
    private Object tag;

    public interface a {
        void aW(Object obj);
    }

    public j(Object obj, a aVar) {
        super(2, null);
        this.lRs = aVar;
        this.tag = obj;
    }

    public j(Object obj, a aVar, int i) {
        super(2, null);
        this.lRs = aVar;
        this.tag = obj;
        ut(i);
    }

    public void onClick(View view) {
        if (this.lRs != null) {
            this.lRs.aW(this.tag);
        }
    }
}
