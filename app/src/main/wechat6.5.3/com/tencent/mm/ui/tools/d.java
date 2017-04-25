package com.tencent.mm.ui.tools;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mm.sdk.platformtools.u;
import java.util.ArrayList;
import java.util.List;

public final class d extends BaseAdapter {
    private Context context;
    private String dwS;
    private List<c> gKP = new ArrayList();
    private List<c> gKQ;
    int[] gKS;
    boolean gKT = false;

    static class a {
        TextView exG;
        TextView gKV;
        TextView gKW;

        a() {
        }
    }

    public d(Context context, List<c> list) {
        this.context = context;
        this.gKQ = list;
        avg();
        avh();
    }

    private void avg() {
        int size = this.gKQ.size();
        for (int i = 0; i < size; i++) {
            this.gKP.add(this.gKQ.get(i));
        }
    }

    private void avh() {
        this.gKS = new int[this.gKQ.size()];
        int size = this.gKQ.size();
        for (int i = 0; i < size; i++) {
            this.gKS[i] = ((c) this.gKQ.get(i)).gIL;
        }
    }

    public final int getCount() {
        return this.gKQ.size();
    }

    public final Object getItem(int i) {
        return this.gKQ.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final void uU(String str) {
        if (str != null) {
            this.dwS = str.trim();
            this.gKQ.clear();
            int size = this.gKP.size();
            int i = 0;
            while (i < size) {
                if (((c) this.gKP.get(i)).cQn.toUpperCase().contains(this.dwS.toUpperCase()) || ((c) this.gKP.get(i)).gIM.toUpperCase().contains(this.dwS.toUpperCase()) || ((c) this.gKP.get(i)).bfd.contains(this.dwS)) {
                    this.gKQ.add(this.gKP.get(i));
                }
                i++;
            }
            avh();
            super.notifyDataSetChanged();
        }
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        c cVar = (c) getItem(i);
        if (view == null) {
            View inflate;
            if (u.bsW()) {
                inflate = View.inflate(this.context, 2130903437, null);
            } else {
                inflate = View.inflate(this.context, 2130903436, null);
            }
            a aVar2 = new a();
            aVar2.gKV = (TextView) inflate.findViewById(2131755332);
            aVar2.exG = (TextView) inflate.findViewById(2131756022);
            aVar2.gKW = (TextView) inflate.findViewById(2131755334);
            inflate.setTag(aVar2);
            view = inflate;
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        int i2 = i > 0 ? this.gKS[i - 1] : -1;
        if (i == 0) {
            aVar.gKV.setVisibility(0);
            aVar.gKV.setText(mc(this.gKS[i]));
        } else if (i <= 0 || this.gKS[i] == i2) {
            aVar.gKV.setVisibility(8);
        } else {
            aVar.gKV.setVisibility(0);
            aVar.gKV.setText(mc(this.gKS[i]));
        }
        aVar.exG.setText(cVar.cQn);
        aVar.gKW.setText(cVar.bfd);
        if (this.gKT) {
            aVar.gKW.setVisibility(0);
        } else {
            aVar.gKW.setVisibility(4);
        }
        return view;
    }

    private static String mc(int i) {
        if (u.bsW()) {
            return Integer.toString(i) + "劃";
        }
        return String.valueOf((char) i);
    }
}
