package com.tencent.mm.plugin.favorite.ui.c;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.a.g;
import com.tencent.mm.ai.b;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.plugin.favorite.b.i;
import com.tencent.mm.plugin.favorite.b.v;
import com.tencent.mm.protocal.c.pw;
import com.tencent.mm.protocal.c.qg;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.base.s;
import java.io.File;
import java.util.HashSet;
import java.util.Set;

public final class h extends a {
    private Set<ImageView> fSB;
    private OnClickListener fSC = new OnClickListener(this) {
        final /* synthetic */ h fSD;

        {
            this.fSD = r1;
        }

        public final void onClick(View view) {
            if (!f.sj()) {
                s.ey(this.fSD.fJV.context);
            } else if (view.getTag() instanceof i) {
                i iVar = (i) view.getTag();
                qg qgVar = iVar.field_favProto.mtP;
                pw n = v.n(iVar);
                if (n == null) {
                    com.tencent.mm.sdk.platformtools.v.w("MicroMsg.FavBaseListItem", "data item is null");
                } else if (e.k(n)) {
                    com.tencent.mm.sdk.platformtools.v.i("MicroMsg.FavBaseListItem", "same song, do release");
                    b.HB();
                    h.a(this.fSD, null);
                } else {
                    String absolutePath;
                    File file = new File(v.g(n));
                    if (file.exists()) {
                        absolutePath = file.getAbsolutePath();
                    } else if (n.aZh == null) {
                        absolutePath = "";
                    } else {
                        file = new File(v.alQ() + g.m(n.aZh.getBytes()));
                        absolutePath = file.exists() ? file.getAbsolutePath() : "";
                    }
                    b.b(b.a(6, null, n.title, n.desc, n.mrZ, n.msd, n.msb, n.luu, v.alS(), absolutePath, qgVar.appId));
                    h.a(this.fSD, (ImageView) view);
                }
            }
        }
    };
    private final int fSr;

    public static class a extends a.b {
        TextView dtY;
        TextView dtZ;
        MMImageView fQG;
        ImageView fSE;
        TextView fSs;
    }

    static /* synthetic */ void a(h hVar, ImageView imageView) {
        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.FavBaseListItem", "mask iv set size is %d", new Object[]{Integer.valueOf(hVar.fSB.size())});
        for (ImageView imageView2 : hVar.fSB) {
            if (imageView2 == imageView) {
                imageView2.setImageResource(2130838733);
            } else {
                imageView2.setImageResource(2130838735);
            }
        }
    }

    public h(com.tencent.mm.plugin.favorite.c.g gVar) {
        super(gVar);
        this.fSr = com.tencent.mm.bd.a.fromDPToPix(gVar.context, 60);
        this.fSB = new HashSet();
    }

    public final View a(View view, ViewGroup viewGroup, i iVar) {
        a.b bVar;
        Context context = viewGroup.getContext();
        if (view == null) {
            a.b aVar = new a();
            view = a(View.inflate(context, 2130903600, null), aVar, iVar);
            aVar.fQG = (MMImageView) view.findViewById(2131756943);
            aVar.dtY = (TextView) view.findViewById(2131755050);
            aVar.dtZ = (TextView) view.findViewById(2131755034);
            aVar.fSE = (ImageView) view.findViewById(2131756944);
            aVar.fSs = (TextView) view.findViewById(2131755046);
            aVar.fSs.setVisibility(8);
            aVar.fSE.setOnClickListener(this.fSC);
            aVar.fSE.setVisibility(0);
            this.fSB.add(aVar.fSE);
            bVar = aVar;
        } else {
            bVar = (a) view.getTag();
        }
        a(bVar, iVar);
        qg qgVar = iVar.field_favProto.mtP;
        pw n = v.n(iVar);
        bVar.dtY.setText(n.title);
        bVar.dtZ.setText(n.desc);
        this.fJV.a(bVar.fQG, n, iVar, 2131165512, this.fSr, this.fSr);
        bVar.fSE.setTag(iVar);
        if (e.k(n)) {
            bVar.fSE.setImageResource(2130838733);
        } else {
            bVar.fSE.setImageResource(2130838735);
        }
        return view;
    }

    public final void bS(View view) {
        e.b(view.getContext(), ((a) view.getTag()).fLP);
    }
}
