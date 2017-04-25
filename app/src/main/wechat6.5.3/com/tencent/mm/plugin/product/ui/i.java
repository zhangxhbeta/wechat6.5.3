package com.tencent.mm.plugin.product.ui;

import android.content.Context;
import android.text.TextPaint;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mm.plugin.product.b.c;
import com.tencent.mm.plugin.product.c.h;
import com.tencent.mm.plugin.product.c.m;
import com.tencent.mm.sdk.platformtools.v;
import java.util.Iterator;
import java.util.LinkedList;

public final class i extends BaseAdapter {
    LinkedList<m> hSL;
    OnItemClickListener hSM;
    private c hSa = com.tencent.mm.plugin.product.a.a.aFX();
    private Context mContext;

    class a {
        public TextView hSN = null;
        public MaxGridView hSO = null;
        public j hSP = null;
        final /* synthetic */ i hSQ;

        a(i iVar) {
            this.hSQ = iVar;
        }
    }

    public final /* synthetic */ Object getItem(int i) {
        return oc(i);
    }

    public i(Context context) {
        this.mContext = context;
        com.tencent.mm.plugin.product.a.a.aFW();
    }

    public final int getCount() {
        return this.hSL != null ? this.hSL.size() : 0;
    }

    private m oc(int i) {
        return (m) this.hSL.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        String str;
        Pair pair;
        m oc = oc(i);
        if (view == null || view.getTag() == null) {
            aVar = new a(this);
            view = View.inflate(this.mContext, 2130904189, null);
            aVar.hSN = (TextView) view.findViewById(2131758616);
            aVar.hSO = (MaxGridView) view.findViewById(2131758617);
            aVar.hSP = new j(this.mContext);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.hSN.setText(oc.hRp);
        aVar.hSO.setOnItemClickListener(this.hSM);
        j jVar = aVar.hSP;
        c cVar = this.hSa;
        String str2 = oc.hRo;
        if (cVar.hQo.containsKey(str2)) {
            str = (String) cVar.hQo.get(str2);
        } else {
            str = null;
        }
        jVar.hSR = oc;
        jVar.hSS = str;
        Context context = this.mContext;
        LinkedList linkedList = oc.hRq;
        int fromDPToPix = context.getResources().getDisplayMetrics().widthPixels - (com.tencent.mm.bd.a.fromDPToPix(context, 16) * 2);
        TextPaint paint = ((TextView) ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(2130904188, null)).getPaint();
        float f = 0.0f;
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            float measureText = paint.measureText(((h) it.next()).name);
            if (f >= measureText) {
                measureText = f;
            }
            f = measureText;
        }
        int fromDPToPix2 = ((int) f) + (com.tencent.mm.bd.a.fromDPToPix(context, 10) * 2);
        int[] iArr = new int[4];
        int fromDPToPix3 = com.tencent.mm.bd.a.fromDPToPix(context, 12);
        for (int i2 = 0; i2 < 4; i2++) {
            iArr[i2] = (fromDPToPix - (fromDPToPix3 * i2)) / (i2 + 1);
        }
        for (fromDPToPix3 = 4; fromDPToPix3 > 0; fromDPToPix3--) {
            if (fromDPToPix2 < iArr[fromDPToPix3 - 1]) {
                pair = new Pair(Integer.valueOf(fromDPToPix3), Integer.valueOf(iArr[fromDPToPix3 - 1]));
                break;
            }
        }
        pair = new Pair(Integer.valueOf(1), Integer.valueOf(fromDPToPix));
        v.d("MicroMsg.MallProductImageAdapter", oc.hRp + " numColumns = " + pair);
        aVar.hSO.setColumnWidth(((Integer) pair.second).intValue());
        aVar.hSP.notifyDataSetChanged();
        aVar.hSO.setAdapter(aVar.hSP);
        return view;
    }
}
