package com.tencent.mm.plugin.ipcall.ui;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mm.modelsearch.h;
import com.tencent.mm.sdk.platformtools.be;
import java.util.ArrayList;
import java.util.List;

public final class f extends BaseAdapter {
    private String dwS;
    private List<a> gKP = new ArrayList();
    private List<a> gKQ;
    private IPCallCountryCodeSelectUI gKR;
    int[] gKS;
    boolean gKT = false;
    boolean gKU = false;

    static class a {
        TextView exG;
        TextView gKV;
        TextView gKW;

        a() {
        }
    }

    public f(IPCallCountryCodeSelectUI iPCallCountryCodeSelectUI, List<a> list) {
        this.gKR = iPCallCountryCodeSelectUI;
        this.gKQ = list;
        avg();
        avh();
    }

    private void avg() {
        int size = this.gKQ.size();
        for (int i = 0; i < size; i++) {
            this.gKP.add(this.gKQ.get(i));
        }
        this.gKR.gKH.setVisibility(8);
    }

    private void avh() {
        this.gKS = new int[this.gKQ.size()];
        int size = this.gKQ.size();
        for (int i = 0; i < size; i++) {
            this.gKS[i] = ((a) this.gKQ.get(i)).auW();
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
                if (((a) this.gKP.get(i)).cQn.toUpperCase().contains(this.dwS.toUpperCase()) || ((a) this.gKP.get(i)).gIM.toUpperCase().contains(this.dwS.toUpperCase()) || ((a) this.gKP.get(i)).bfd.contains(this.dwS)) {
                    this.gKQ.add(this.gKP.get(i));
                }
                i++;
            }
            avh();
            if (this.gKQ.size() == 0) {
                this.gKR.gKH.setVisibility(0);
            } else {
                this.gKR.gKH.setVisibility(8);
            }
            super.notifyDataSetChanged();
        }
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        a aVar2 = (a) getItem(i);
        if (view == null) {
            view = View.inflate(this.gKR, 2130903818, null);
            aVar = new a();
            aVar.gKV = (TextView) view.findViewById(2131755332);
            aVar.exG = (TextView) view.findViewById(2131756022);
            aVar.gKW = (TextView) view.findViewById(2131755334);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        int i2 = i > 0 ? this.gKS[i - 1] : -1;
        if (i == 0) {
            aVar.gKV.setVisibility(0);
            if (this.gKU) {
                aVar.gKV.setText(2131234239);
            } else {
                aVar.gKV.setText(mc(this.gKS[i]));
            }
        } else if (i <= 0 || this.gKS[i] == i2) {
            aVar.gKV.setVisibility(8);
        } else {
            aVar.gKV.setVisibility(0);
            aVar.gKV.setText(mc(this.gKS[i]));
        }
        if (be.kS(this.dwS)) {
            aVar.exG.setText(aVar2.cQn);
            aVar.gKW.setText(" (+" + aVar2.bfd + ")");
        } else {
            aVar.exG.setText(h.a(this.gKR, aVar2.cQn, this.dwS));
            aVar.gKW.setText(h.a(this.gKR, " (+" + aVar2.bfd + ")", this.dwS));
        }
        if (this.gKT) {
            aVar.gKW.setVisibility(0);
        } else {
            aVar.gKW.setVisibility(4);
        }
        return view;
    }

    private static String mc(int i) {
        String valueOf = String.valueOf((char) i);
        for (String equals : IPCallCountryCodeScrollbar.gKX) {
            if (equals.equals(String.valueOf((char) i))) {
                return valueOf;
            }
        }
        return "#";
    }
}
