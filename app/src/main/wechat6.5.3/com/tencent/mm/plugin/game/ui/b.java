package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.BaseAdapter;
import com.tencent.mm.a.f;
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.h.i;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.be;
import java.util.LinkedList;

public abstract class b<T> extends BaseAdapter {
    private static int goP = 500;
    protected LinkedList<T> gjE;
    a goM;
    protected boolean goN = false;
    private f<String, Bitmap> goO;
    private ah goQ = new ah(new com.tencent.mm.sdk.platformtools.ah.a(this) {
        final /* synthetic */ b goS;

        {
            this.goS = r1;
        }

        public final boolean oU() {
            this.goS.notifyDataSetChanged();
            return false;
        }
    }, false);
    private final com.tencent.mm.sdk.h.g.a goR = new com.tencent.mm.sdk.h.g.a(this) {
        final /* synthetic */ b goS;

        {
            this.goS = r1;
        }

        public final void a(String str, i iVar) {
            this.goS.goQ.QI();
            this.goS.goQ.ea((long) b.goP);
        }
    };
    protected Context mContext;

    public interface a {
        void lt(int i);
    }

    public b(Context context) {
        this.mContext = context;
        this.gjE = new LinkedList();
        this.goO = new f(20);
        am.bnB().c(this.goR);
    }

    public void H(LinkedList<T> linkedList) {
        if (linkedList != null) {
            this.gjE.addAll(linkedList);
            if (this.goM != null) {
                this.goM.lt(this.gjE.size());
            }
            super.notifyDataSetChanged();
        } else if (this.goM != null) {
            this.goM.lt(this.gjE.size());
        }
    }

    public void I(LinkedList<T> linkedList) {
        if (linkedList != null) {
            this.gjE = linkedList;
            if (this.goM != null) {
                this.goM.lt(this.gjE.size());
            }
            super.notifyDataSetChanged();
        } else if (this.goM != null) {
            this.goM.lt(this.gjE.size());
        }
    }

    protected final void remove(int i) {
        if (this.gjE != null && i >= 0 && i <= this.gjE.size() - 1) {
            this.gjE.remove(i);
            if (this.goM != null) {
                this.goM.lt(this.gjE.size());
            }
            super.notifyDataSetChanged();
        }
    }

    public void clear() {
        if (this.gjE != null) {
            this.gjE.clear();
        }
        if (this.goO != null) {
            this.goO.a(new com.tencent.mm.a.f.a<String, Bitmap>(this) {
                final /* synthetic */ b goS;

                {
                    this.goS = r1;
                }
            });
        }
        this.goO = null;
        am.bnB().d(this.goR);
    }

    protected final Bitmap un(String str) {
        if (be.kS(str)) {
            return null;
        }
        Bitmap bitmap;
        if (this.goO.aI(str)) {
            bitmap = (Bitmap) this.goO.get(str);
            if (!(bitmap == null || bitmap.isRecycled())) {
                return bitmap;
            }
        }
        bitmap = g.b(str, 1, com.tencent.mm.bd.a.getDensity(this.mContext));
        if (bitmap == null || bitmap.isRecycled()) {
            return bitmap;
        }
        this.goO.k(str, bitmap);
        return bitmap;
    }

    public int getCount() {
        return this.gjE.size();
    }

    public Object getItem(int i) {
        return this.gjE.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }
}
