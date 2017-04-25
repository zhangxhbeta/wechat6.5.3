package com.tencent.mm.plugin.favorite.ui.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.MMTagPanel;
import com.tencent.mm.ui.base.MMTagPanel.d;
import java.util.Iterator;
import java.util.LinkedList;

public class FavTagPanel extends MMTagPanel {
    public LinkedList<d> fQf = new LinkedList();
    a fQg = null;
    public OnClickListener fQh = new OnClickListener(this) {
        final /* synthetic */ FavTagPanel fQi;

        {
            this.fQi = r1;
        }

        public final void onClick(final View view) {
            if (((Integer) view.getTag()).intValue() == 0) {
                this.fQi.a((TextView) view, true, false);
                if (this.fQi.fQg != null) {
                    view.post(new Runnable(this) {
                        final /* synthetic */ AnonymousClass1 fQj;

                        public final void run() {
                            this.fQj.fQi.fQg;
                            ((TextView) view).getText().toString();
                        }
                    });
                    return;
                }
                return;
            }
            this.fQi.a((TextView) view, false, false);
            if (this.fQi.fQg != null) {
                view.post(new Runnable(this) {
                    final /* synthetic */ AnonymousClass1 fQj;

                    public final void run() {
                        this.fQj.fQi.fQg.tn(((TextView) view).getText().toString());
                    }
                });
            }
        }
    };

    public interface a extends com.tencent.mm.ui.base.MMTagPanel.a {
        void tm(String str);

        void tn(String str);
    }

    public FavTagPanel(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public FavTagPanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected final void amV() {
        if (this.mtZ.size() <= 0 && !this.fQf.isEmpty()) {
            String str = ((d) this.fQf.getLast()).nYF;
            to(str);
            if (this.fQg != null) {
                this.fQg.tm(str);
            }
            bCD();
        }
    }

    public final void to(String str) {
        if (be.kS(str)) {
            v.w("MicroMsg.FavTagPanel", "want to remove type, but it is null or empty");
            return;
        }
        Iterator it = this.fQf.iterator();
        while (it.hasNext()) {
            d dVar = (d) it.next();
            if (str.equals(dVar.nYF)) {
                this.fQf.remove(dVar);
                removeView(dVar.nYG);
                a(dVar);
                bCD();
                return;
            }
        }
        v.w("MicroMsg.FavTagPanel", "want to remove type %s, but it not exsited!", new Object[]{str});
    }
}
