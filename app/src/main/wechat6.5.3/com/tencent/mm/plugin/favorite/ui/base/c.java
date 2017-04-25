package com.tencent.mm.plugin.favorite.ui.base;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mm.plugin.favorite.b.i;
import com.tencent.mm.plugin.favorite.b.j;
import com.tencent.mm.plugin.favorite.h;
import com.tencent.mm.sdk.platformtools.v;
import java.util.List;

public final class c extends LinearLayout {
    private View fPQ = View.inflate(getContext(), 2130903612, null);
    public View fPR;
    public View fPS;
    public a fPT;
    private int fPU;

    public interface a {
        void amH();
    }

    public c(Context context) {
        super(context);
        setOrientation(1);
        MarginLayoutParams layoutParams = new LayoutParams(-1, -2);
        View inflate = View.inflate(getContext(), 2130903596, null);
        inflate.findViewById(2131756936).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ c fPV;

            {
                this.fPV = r1;
            }

            public final void onClick(View view) {
                if (this.fPV.fPU == 1 || this.fPV.fPU == 3) {
                    v.i("MicroMsg.FavHeaderView", "click clear fav item");
                    if (this.fPV.fPT != null) {
                        this.fPV.fPT.amH();
                    }
                }
            }
        });
        this.fPR = inflate;
        inflate = View.inflate(getContext(), 2130903611, null);
        inflate.findViewById(2131756967).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ c fPV;

            {
                this.fPV = r1;
            }

            public final void onClick(View view) {
                v.i("MicroMsg.FavHeaderView", "click retry item");
                List<i> alH = h.alu().alH();
                if (alH != null && !alH.isEmpty()) {
                    for (i iVar : alH) {
                        if (iVar.alB()) {
                            com.tencent.mm.plugin.favorite.b.v.l(iVar);
                        } else {
                            v.w("MicroMsg.FavHeaderView", "item id is %d, status is not upload fail", new Object[]{Integer.valueOf(iVar.field_id)});
                        }
                    }
                    this.fPV.fPS.setVisibility(8);
                    this.fPV.fPR.setVisibility(8);
                }
            }
        });
        this.fPS = inflate;
        addView(this.fPQ, new LayoutParams(layoutParams));
        addView(this.fPR, new LayoutParams(layoutParams));
        addView(this.fPS, new LayoutParams(layoutParams));
    }

    public final void da(boolean z) {
        this.fPQ.setVisibility(z ? 0 : 8);
    }

    private void kK(int i) {
        this.fPU = i;
        v.i("MicroMsg.FavHeaderView", "showStatusBar status:" + i);
        if (i == 0) {
            this.fPS.setVisibility(8);
            this.fPR.setVisibility(8);
        } else if (i == 1) {
            this.fPS.setVisibility(8);
            this.fPR.setVisibility(0);
            this.fPR.findViewById(2131756939).setVisibility(0);
            this.fPR.findViewById(2131756940).setVisibility(8);
        } else if (i == 2) {
            this.fPS.setVisibility(0);
            this.fPR.setVisibility(8);
        } else if (i == 3) {
            this.fPS.setVisibility(8);
            this.fPR.setVisibility(0);
            this.fPR.findViewById(2131756939).setVisibility(8);
            this.fPR.findViewById(2131756940).setVisibility(0);
        }
    }

    public final void amT() {
        long j;
        int i;
        List<i> alH = h.alu().alH();
        if (alH != null) {
            j = 0;
            i = 0;
            for (i iVar : alH) {
                h.alu();
                j = j.e(iVar) + j;
                i = 1;
            }
            v.i("MicroMsg.FavHeaderView", "triggerStatusBar uploadFailedItemList size:%d,totalSize:%d", new Object[]{Integer.valueOf(alH.size()), Long.valueOf(j)});
        } else {
            j = 0;
            i = 0;
        }
        if (i != 0) {
            if (j > com.tencent.mm.plugin.favorite.b.v.alW()) {
                kK(1);
            } else {
                kK(2);
            }
        } else if (com.tencent.mm.plugin.favorite.b.v.ama()) {
            kK(3);
        } else {
            kK(0);
        }
    }
}
