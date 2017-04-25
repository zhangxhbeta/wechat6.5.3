package com.tencent.mm.plugin.gallery.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.gallery.model.GalleryItem.ImageMediaItem;
import com.tencent.mm.plugin.gallery.model.c;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.util.ArrayList;

public final class b extends BaseAdapter {
    private int gew;
    ArrayList<com.tencent.mm.plugin.gallery.model.GalleryItem.a> gfO;
    com.tencent.mm.plugin.gallery.model.GalleryItem.a gfP;
    String gfQ = "";
    private int gfR = 0;
    private Context mContext;

    private static class a {
        public TextView dtZ;
        public ImageView fSI;
        public ImageView geY;
        public TextView gfS;
        public ImageView gfT;

        private a() {
        }
    }

    public final /* synthetic */ Object getItem(int i) {
        return ln(i);
    }

    public b(Context context, int i) {
        this.mContext = context;
        this.gfO = new ArrayList();
        this.gew = i;
        this.gfP = new com.tencent.mm.plugin.gallery.model.GalleryItem.a("", 0);
        this.gfP.gdX = new ImageMediaItem();
        this.gfR = context.getResources().getDimensionPixelSize(2131493199);
    }

    public final int getCount() {
        return this.gfO.size() + 1;
    }

    public final com.tencent.mm.plugin.gallery.model.GalleryItem.a ln(int i) {
        if (i == 0) {
            return this.gfP;
        }
        return (com.tencent.mm.plugin.gallery.model.GalleryItem.a) this.gfO.get(i - 1);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        v.i("MicroMsg.GalleryAdapter", "duanyi test getview:" + i);
        com.tencent.mm.plugin.gallery.model.GalleryItem.a ln = ln(i);
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(2130904304, viewGroup, false);
            a aVar2 = new a();
            aVar2.geY = (ImageView) view.findViewById(2131758990);
            aVar2.dtZ = (TextView) view.findViewById(2131758991);
            aVar2.fSI = (ImageView) view.findViewById(2131757492);
            aVar2.gfS = (TextView) view.findViewById(2131758992);
            aVar2.gfT = (ImageView) view.findViewById(2131758993);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        if (this.gfQ.equals(ln.gdW)) {
            aVar.gfT.setVisibility(0);
        } else {
            aVar.gfT.setVisibility(4);
        }
        if (i == 0) {
            aVar.geY.setImageResource(2130838891);
            if (ln.gdX != null) {
                f.a(aVar.geY, ln.gdX.getType(), ln.aqB(), ln.gdX.gdY, ln.aqC());
            }
            if (c.aqn().aqM() == 1) {
                aVar.dtZ.setText(2131233017);
            } else if (c.aqn().aqM() == 3) {
                aVar.dtZ.setText(2131233018);
            } else {
                aVar.dtZ.setText(2131233019);
            }
            aVar.geY.setVisibility(0);
            aVar.dtZ.setVisibility(0);
            aVar.gfS.setVisibility(8);
        } else {
            aVar.geY.setVisibility(0);
            aVar.dtZ.setVisibility(0);
            aVar.dtZ.setText(ln.gdW);
            aVar.gfS.setVisibility(0);
            aVar.gfS.setText(this.mContext.getString(2131233027, new Object[]{Integer.valueOf(ln.bcq)}));
            if (!(aVar.fSI == null || ln.gdX == null)) {
                aVar.fSI.setVisibility(ln.gdX.getType() == 2 ? 0 : 8);
            }
            String aqB = ln.aqB();
            if (!be.kS(aqB) && ln.gdX != null) {
                f.a(aVar.geY, ln.gdX.getType(), aqB, ln.gdX.gdY, ln.aqC());
            } else if (ln.gdX == null || ln.gdX.getType() != 2) {
                v.e("MicroMsg.GalleryAdapter", "get folder failed");
                aVar.geY.setVisibility(8);
                aVar.dtZ.setVisibility(8);
            } else {
                f.a(aVar.geY, ln.gdX.getType(), null, ln.gdX.gdY, ln.aqC());
            }
        }
        return view;
    }
}
