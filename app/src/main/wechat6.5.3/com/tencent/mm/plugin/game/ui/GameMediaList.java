package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mm.ae.n;
import com.tencent.mm.plugin.game.c.af;
import com.tencent.mm.plugin.game.e.c;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.util.LinkedList;

public class GameMediaList extends LinearLayout implements OnClickListener {
    String appId = "";
    int dzy = -1;
    int gsN = 0;
    int gvs;
    private LinkedList<String> gvt;
    Context mContext;

    public static class a {
        public String gvu;
        public int type;
        public String url;
    }

    public GameMediaList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final void K(LinkedList<a> linkedList) {
        if (linkedList == null || linkedList.size() == 0) {
            setVisibility(8);
            return;
        }
        this.gvt = new LinkedList();
        for (int i = 0; i < linkedList.size(); i++) {
            a aVar = (a) linkedList.get(i);
            if (!be.kS(aVar.url) && aVar.type == 0) {
                this.gvt.add(aVar.url);
            }
        }
        removeAllViews();
        LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService("layout_inflater");
        for (int i2 = 0; i2 < linkedList.size(); i2++) {
            a aVar2 = (a) linkedList.get(i2);
            if (!be.kS(aVar2.gvu)) {
                View inflate = layoutInflater.inflate(this.gvs, this, false);
                ImageView imageView = (ImageView) inflate.findViewById(2131756015);
                com.tencent.mm.ae.a.a GL = n.GL();
                String str = aVar2.gvu;
                com.tencent.mm.ae.a.a.c.a aVar3 = new com.tencent.mm.ae.a.a.c.a();
                aVar3.cPr = true;
                GL.a(str, imageView, aVar3.GU());
                if (aVar2.type == 1) {
                    inflate.findViewById(2131757340).setVisibility(0);
                }
                addView(inflate);
                imageView.setTag(aVar2);
                imageView.setOnClickListener(this);
            }
        }
        setVisibility(0);
    }

    public void onClick(View view) {
        if (view.getTag() == null || !(view.getTag() instanceof a)) {
            v.i("MicroMsg.GameMediaList", "Invalid tag");
            return;
        }
        a aVar = (a) view.getTag();
        switch (aVar.type) {
            case 0:
                int indexOf = this.gvt.indexOf(aVar.url);
                if (indexOf < 0) {
                    indexOf = 0;
                }
                Intent intent = new Intent(getContext(), GameGalleryUI.class);
                String[] strArr = new String[this.gvt.size()];
                this.gvt.toArray(strArr);
                intent.putExtra("URLS", strArr);
                intent.putExtra("CURRENT", indexOf);
                intent.putExtra("REPORT_APPID", this.appId);
                intent.putExtra("REPORT_SCENE", this.dzy);
                intent.putExtra("SOURCE_SCENE", this.gsN);
                getContext().startActivity(intent);
                return;
            case 1:
                c.W(getContext(), aVar.url);
                af.a(this.mContext, this.dzy, 1202, 1, 13, this.appId, this.gsN, null);
                return;
            default:
                return;
        }
    }
}
