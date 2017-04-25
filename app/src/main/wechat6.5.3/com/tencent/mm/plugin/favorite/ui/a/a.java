package com.tencent.mm.plugin.favorite.ui.a;

import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import java.util.Set;

public abstract class a extends BaseAdapter implements OnItemClickListener {
    protected Set<Integer> fPh;
    protected com.tencent.mm.plugin.favorite.b.v.a fPi;
    protected a fPj;
    protected long lastUpdateTime;
    protected int type;

    public interface a {
        void amK();
    }

    public abstract void amN();

    public abstract void amO();

    public abstract boolean isEmpty();

    public final int getType() {
        return this.type;
    }

    public final long amL() {
        return this.lastUpdateTime;
    }

    public final void a(a aVar) {
        this.fPj = aVar;
    }

    public final void amM() {
        if (this.fPj != null) {
            this.fPj.amK();
        }
    }

    public final void f(Set<Integer> set) {
        this.fPh = set;
    }

    public final void a(com.tencent.mm.plugin.favorite.b.v.a aVar) {
        this.fPi = aVar;
    }
}
