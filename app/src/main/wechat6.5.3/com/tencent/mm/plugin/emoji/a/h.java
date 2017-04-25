package com.tencent.mm.plugin.emoji.a;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import com.tencent.mm.ae.n;
import com.tencent.mm.plugin.emoji.a.a.f;
import com.tencent.mm.plugin.emoji.d.g;
import com.tencent.mm.sdk.platformtools.v;
import java.util.HashMap;

public final class h extends com.tencent.mm.plugin.emoji.a.a.a {
    private int eZA;
    private int eZB;
    private int eZC;
    private int eZD;
    private int eZE;
    private boolean eZF;
    public a eZG;
    private HashMap<String, b> eZH;
    public int eZu = 0;
    private int eZz = 3;
    private Context mContext;

    public interface a {
        void jH(int i);
    }

    class b {
        final /* synthetic */ h eZJ;
        LinearLayout eZK;

        b(h hVar) {
            this.eZJ = hVar;
        }
    }

    public h(Context context) {
        super(context);
        this.mContext = context;
        this.eZF = false;
        this.eZA = this.mContext.getResources().getDimensionPixelSize(2131493168);
        this.eZB = this.mContext.getResources().getDimensionPixelSize(2131492966);
        this.eZC = this.mContext.getResources().getDimensionPixelSize(2131493428);
        this.eZD = com.tencent.mm.bd.a.dv(this.mContext);
        this.eZE = (int) (((float) (this.eZD - (this.eZz * this.eZC))) / (((float) this.eZz) + 1.0f));
    }

    public final int aeM() {
        if (!this.eZF) {
            return super.getCount();
        }
        if (this.eZu == 0) {
            return 0;
        }
        if (this.eZu <= 0 || super.getCount() <= this.eZu) {
            return super.getCount();
        }
        return this.eZu;
    }

    public final int getCount() {
        if (!this.eZF) {
            int aeM = aeM();
            if (aeM > this.eZu) {
                return (int) Math.ceil((double) (((float) (aeM - this.eZu)) / ((float) this.eZz)));
            }
            return 0;
        } else if (this.eZu == 0) {
            return 0;
        } else {
            if (this.eZu <= 0 || aeM() <= this.eZu) {
                return (int) Math.ceil((double) (((float) aeM()) / ((float) this.eZz)));
            }
            return (int) Math.ceil((double) (((float) this.eZu) / ((float) this.eZz)));
        }
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        if (view == null || view.getTag() == null) {
            view = new LinearLayout(this.mContext);
            LayoutParams layoutParams = new AbsListView.LayoutParams(-1, -2);
            view.setBackgroundResource(2130839576);
            view.setOrientation(0);
            view.setLayoutParams(layoutParams);
            view.setPadding(0, 0, 0, this.eZB);
            b bVar2 = new b(this);
            bVar2.eZK = view;
            view.setTag(bVar2);
            for (int i2 = 0; i2 < this.eZz; i2++) {
                LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                layoutParams2.leftMargin = this.eZE;
                bVar2.eZK.addView(new b(this.mContext).eYV, i2, layoutParams2);
            }
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        for (int i3 = 0; i3 < this.eZz; i3++) {
            int i4;
            if (this.eZF) {
                i4 = this.eZz * i;
            } else {
                i4 = (this.eZz * i) + this.eZu;
            }
            i4 += i3;
            final b bVar3 = new b(this.mContext, bVar.eZK.getChildAt(i3));
            bVar3.eYV.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ h eZJ;

                public final void onClick(View view) {
                    if (this.eZJ.eZG != null) {
                        this.eZJ.eZG.jH(i4);
                    }
                }
            });
            f jG = jG(i4);
            if (i4 > aeM() - 1 || jG == null) {
                bVar3.eYV.setClickable(false);
                bVar3.eYV.setVisibility(8);
                bVar3.eZf.setBackgroundDrawable(null);
            } else {
                if (this.eZH == null) {
                    this.eZH = new HashMap();
                }
                if (this.eZH.containsValue(bVar3)) {
                    this.eZH.remove(bVar3.eZd);
                }
                bVar3.eZd = a(jG);
                this.eZH.put(a(jG), bVar3);
                bVar3.eYV.setVisibility(0);
                bVar3.eJL.setText(jG.fai.mqd);
                n.GL().a(jG.fai.gnp, bVar3.eZe, g.bl(jG.fai.mdM, jG.fai.gnp));
                bVar3.eZf.setBackgroundResource(2130838157);
                bVar3.eYV.setClickable(true);
                a(bVar3, jG.mStatus);
            }
        }
        return view;
    }

    private void a(b bVar, int i) {
        switch (i) {
            case 7:
                bVar.eJL.setTextColor(this.mContext.getResources().getColor(2131689781));
                Drawable drawable = this.mContext.getResources().getDrawable(2131165483);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                bVar.eJL.setCompoundDrawables(null, null, drawable, null);
                return;
            default:
                bVar.eJL.setTextColor(this.mContext.getResources().getColor(2131689909));
                bVar.eJL.setCompoundDrawables(null, null, null, null);
                v.w("MicroMsg.emoji.EmojiStoreV2PersonAdapter", "unknow product status:%d", new Object[]{Integer.valueOf(i)});
                return;
        }
    }

    protected final a c(Context context, View view) {
        return null;
    }

    public final int aeI() {
        return this.eZu;
    }

    public final void jD(int i) {
        this.eZu = i;
    }

    public final int aeJ() {
        return 0;
    }

    public final void jE(int i) {
    }

    public final int aeK() {
        return 0;
    }

    public final void jF(int i) {
    }

    public final View b(int i, View view, ViewGroup viewGroup) {
        return null;
    }

    public final void an(String str, int i) {
        if (this.eZH == null) {
            v.w("MicroMsg.emoji.EmojiStoreV2PersonAdapter", "updateStatus mCacheHolder is nulll.");
            return;
        }
        b bVar = (b) this.eZH.get(str);
        f qY = this.eZW.qY(str);
        if (qY != null) {
            a(qY, str, i);
        }
        if (!(qY == null || this.eZW == null || qY.mStatus != -1)) {
            v.i("MicroMsg.emoji.EmojiStoreV2PersonAdapter", "force refresh status");
            qY.a(this.eZW.faf, this.eZW.rc(str), this.eZW.ra(str));
        }
        if (bVar == null) {
            v.w("MicroMsg.emoji.EmojiStoreV2PersonAdapter", "updateStatus viewHolder is nulll.");
        } else {
            a(bVar, i);
        }
    }
}
