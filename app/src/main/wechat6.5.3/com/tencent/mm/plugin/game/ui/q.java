package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableString;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.model.k;
import com.tencent.mm.pluginsdk.ui.d.e;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.u;
import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class q extends BaseAdapter {
    LinkedList<a> gwn;
    List<a> gwo;
    int gwp = 0;
    String gwq;
    a gwr;
    GameRankFooter gws;
    boolean gwt = false;
    boolean gwu = false;
    int gwv = 0;
    private Context mContext;

    public static class a implements Serializable {
        public String ble;
        public long cWZ;
        public int gjv;
        public int level = 0;
    }

    static final class b {
        public TextView gwA;
        public ImageView gwB;
        public TextView gww;
        public ImageView gwx;
        public ImageView gwy;
        public TextView gwz;

        b() {
        }
    }

    public q(Context context, GameRankFooter gameRankFooter) {
        this.mContext = context;
        this.gwn = new LinkedList();
        this.gwo = new LinkedList();
        this.gwq = k.xF();
        this.gws = gameRankFooter;
    }

    public final void L(LinkedList<a> linkedList) {
        int i = 25;
        if (linkedList.size() == 0) {
            v.i("MicroMsg.GameRankAdapter", "Null or empty rank info");
            return;
        }
        this.gwn.clear();
        this.gwn.addAll(linkedList);
        if (this.gwn.size() <= 25) {
            i = this.gwn.size();
        }
        this.gwp = i;
        this.gwo = this.gwn.subList(0, this.gwp);
        this.gwv = 0;
        if (this.gwn != null && this.gwn.size() > 0) {
            Iterator it = this.gwn.iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                this.gwv++;
                if (!be.kS(aVar.ble) && aVar.ble.equals(this.gwq)) {
                    this.gwr = aVar;
                    break;
                }
            }
        }
        if (this.gwp == this.gwn.size()) {
            this.gws.asz();
            this.gwu = true;
        } else {
            this.gws.asy();
        }
        if (this.gwt || this.gwv <= this.gwp) {
            this.gws.asA();
        } else if (this.gwr != null) {
            this.gws.a(this.gwr);
        } else {
            this.gws.asA();
        }
    }

    public final int getCount() {
        return this.gwo.size();
    }

    public final Object getItem(int i) {
        return this.gwo.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        if (view == null) {
            bVar = new b();
            view = View.inflate(this.mContext, 2130903751, null);
            bVar.gww = (TextView) view.findViewById(2131757363);
            bVar.gwx = (ImageView) view.findViewById(2131757364);
            bVar.gwy = (ImageView) view.findViewById(2131757360);
            bVar.gwz = (TextView) view.findViewById(2131757361);
            bVar.gwA = (TextView) view.findViewById(2131757362);
            bVar.gwB = (ImageView) view.findViewById(2131757365);
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        a aVar = (a) getItem(i);
        ak.yW();
        u LX = c.wH().LX(aVar.ble);
        if (LX != null) {
            com.tencent.mm.pluginsdk.ui.a.b.m(bVar.gwy, LX.field_username);
            bVar.gwz.setText(new SpannableString(e.a(this.mContext, LX.tU(), bVar.gwz.getTextSize())));
        }
        bVar.gwA.setText(be.formatNumber(aVar.cWZ));
        switch (aVar.gjv) {
            case 1:
                bVar.gww.setVisibility(8);
                bVar.gwx.setVisibility(0);
                bVar.gwx.setImageResource(2130838355);
                break;
            case 2:
                bVar.gww.setVisibility(8);
                bVar.gwx.setVisibility(0);
                bVar.gwx.setImageResource(2130839191);
                break;
            case 3:
                bVar.gww.setVisibility(8);
                bVar.gwx.setVisibility(0);
                bVar.gwx.setImageResource(2130837793);
                break;
            default:
                bVar.gww.setVisibility(0);
                bVar.gwx.setVisibility(8);
                bVar.gww.setText(aVar.gjv);
                break;
        }
        switch (aVar.level) {
            case 1:
                bVar.gwB.setVisibility(0);
                bVar.gwB.setImageResource(2130838343);
                break;
            case 2:
                bVar.gwB.setVisibility(0);
                bVar.gwB.setImageResource(2130838344);
                break;
            case 3:
                bVar.gwB.setVisibility(0);
                bVar.gwB.setImageResource(2130838345);
                break;
            case 4:
                bVar.gwB.setVisibility(0);
                bVar.gwB.setImageResource(2130838346);
                break;
            default:
                bVar.gwB.setVisibility(8);
                break;
        }
        if (i == 0) {
            if (getCount() == 1) {
                if (us(aVar.ble)) {
                    view.setBackgroundResource(2130838739);
                } else {
                    view.setBackgroundResource(2130838738);
                }
            } else if (us(aVar.ble)) {
                view.setBackgroundResource(2130838746);
            } else {
                view.setBackgroundResource(2130838745);
            }
        } else if (i != getCount() - 1) {
            view.setBackgroundColor(Color.parseColor("#00000000"));
            if (us(aVar.ble)) {
                view.setBackgroundResource(2130838743);
            } else {
                view.setBackgroundResource(2130838742);
            }
        } else if (us(aVar.ble)) {
            if (this.gwu) {
                view.setBackgroundResource(2130838741);
            } else {
                view.setBackgroundResource(2130838743);
            }
        } else if (this.gwu) {
            view.setBackgroundResource(2130838740);
        } else {
            view.setBackgroundResource(2130838742);
        }
        return view;
    }

    private boolean us(String str) {
        if (be.kS(str) || be.kS(this.gwq)) {
            return false;
        }
        boolean equals = this.gwq.equals(str);
        this.gwt = equals;
        return equals;
    }
}
