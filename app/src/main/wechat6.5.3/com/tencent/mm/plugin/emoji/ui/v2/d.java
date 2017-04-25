package com.tencent.mm.plugin.emoji.ui.v2;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mm.ae.n;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.emoji.d.g;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.protocal.c.nu;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.q;
import java.util.ArrayList;
import java.util.List;

public final class d extends BaseAdapter {
    private int eZC;
    private int eZD;
    private int eZE;
    List<nu> eZk;
    private int eZz;
    private boolean fqI;
    private LayoutParams fqJ;
    private LayoutParams fqK;
    a fqL;
    private Context mContext;

    interface a {
        void jH(int i);
    }

    class b {
        LinearLayout eZK;
        final /* synthetic */ d fqN;

        b(d dVar) {
            this.fqN = dVar;
        }
    }

    public final /* synthetic */ Object getItem(int i) {
        return kk(i);
    }

    public d(Context context) {
        this.eZz = 3;
        this.fqI = true;
        this.eZz = 3;
        this.mContext = context;
        this.eZD = com.tencent.mm.bd.a.dv(this.mContext);
        this.eZC = this.mContext.getResources().getDimensionPixelSize(2131493428);
        this.eZE = (int) (((float) (this.eZD - (this.eZz * this.eZC))) / (((float) this.eZz) + 1.0f));
    }

    public final void an(List<nu> list) {
        if (this.eZk == null) {
            this.eZk = new ArrayList();
        } else {
            this.eZk.clear();
        }
        this.eZk = list;
        notifyDataSetChanged();
    }

    private int aij() {
        return this.eZk == null ? 0 : this.eZk.size();
    }

    public final int getCount() {
        return this.eZk == null ? 0 : (int) Math.ceil((double) (((float) this.eZk.size()) / ((float) this.eZz)));
    }

    public final nu kk(int i) {
        if (i < 0 || i >= aij() || this.eZk == null) {
            return null;
        }
        return (nu) this.eZk.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        if (view == null || view.getTag() == null) {
            view = q.em(this.mContext).inflate(2130903510, null);
            bVar = new b(this);
            bVar.eZK = (LinearLayout) view.findViewById(2131756639);
            bVar.eZK.setPadding(0, this.eZE, 0, 0);
            view.setTag(bVar);
            for (int i2 = 0; i2 < this.eZz; i2++) {
                this.fqK = new LayoutParams(-2, -2);
                this.fqK.leftMargin = this.eZE;
                this.fqJ = new LayoutParams(this.eZC, this.eZC);
                View paddingImageView = new PaddingImageView(this.mContext);
                ViewGroup.LayoutParams layoutParams = this.fqJ;
                paddingImageView.addView(paddingImageView.fqF, layoutParams);
                paddingImageView.addView(paddingImageView.fqG, layoutParams);
                bVar.eZK.addView(paddingImageView, i2, this.fqK);
            }
        } else {
            bVar = (b) view.getTag();
        }
        for (int i3 = 0; i3 < this.eZz; i3++) {
            final int i4 = (this.eZz * i) + i3;
            final PaddingImageView paddingImageView2 = (PaddingImageView) bVar.eZK.getChildAt(i3);
            if (i4 <= aij() - 1) {
                nu kk = kk(i4);
                if (kk != null) {
                    String stringBuilder;
                    com.tencent.mm.ae.a.a GL;
                    String str;
                    ImageView imageView;
                    String str2;
                    if (!be.kS(kk.hOx)) {
                        StringBuilder stringBuilder2 = new StringBuilder();
                        ak.yW();
                        stringBuilder = stringBuilder2.append(EmojiLogic.A(c.wY(), "", kk.mpC)).append("_cover").toString();
                        GL = n.GL();
                        str = kk.hOx;
                        imageView = paddingImageView2.fqF;
                        str2 = kk.hOx;
                        GL.a(str, imageView, g.a(stringBuilder, this.eZC, new Object[0]));
                    } else if (be.kS(kk.glb)) {
                        v.w("MicroMsg.emoji.PreViewListGridAdapter", "this emoji has no thumb url and url. download faild");
                    } else {
                        ak.yW();
                        stringBuilder = EmojiLogic.A(c.wY(), "", kk.mpC);
                        GL = com.tencent.mm.plugin.emoji.model.g.afq();
                        str = kk.glb;
                        imageView = paddingImageView2.fqF;
                        str2 = kk.glb;
                        GL.a(str, imageView, g.a(stringBuilder, this.eZC, new Object[0]));
                    }
                    paddingImageView2.setClickable(true);
                    paddingImageView2.fqG.setBackgroundResource(2130838162);
                    paddingImageView2.setOnClickListener(new OnClickListener(this) {
                        final /* synthetic */ d fqN;

                        public final void onClick(View view) {
                            if (this.fqN.fqL != null) {
                                this.fqN.fqL.jH(i4);
                            }
                        }
                    });
                } else {
                    paddingImageView2.fqG.setBackgroundDrawable(null);
                    n.GL().a("", paddingImageView2.fqF);
                    v.w("MicroMsg.emoji.PreViewListGridAdapter", "item is null");
                    paddingImageView2.setClickable(false);
                    paddingImageView2.setOnClickListener(null);
                }
            } else {
                paddingImageView2.fqG.setBackgroundDrawable(null);
                n.GL().a("", paddingImageView2.fqF);
                paddingImageView2.setClickable(false);
                paddingImageView2.setOnClickListener(null);
            }
        }
        return view;
    }
}
