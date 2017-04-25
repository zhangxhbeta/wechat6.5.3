package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mm.protocal.c.rg;
import com.tencent.mm.sdk.platformtools.be;
import java.util.Iterator;
import java.util.LinkedList;

public final class s extends BaseAdapter {
    private String aXp = "";
    private Context context;
    private LinkedList<a> cqE = new LinkedList();

    public static class a {
        public int actionType;
        public String appId;
        public String description;
        public String gxK;
        public String text;
        public int type;
    }

    private static class b {
        TextView dID;
        ViewGroup gxL;
        TextView gxM;
        TextView gxN;
        ViewGroup gxO;
        TextView gxP;
        ViewGroup gxQ;

        private b() {
        }
    }

    public final /* synthetic */ Object getItem(int i) {
        return lE(i);
    }

    public s(Context context) {
        this.context = context;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        a lE = lE(i);
        if (view == null) {
            view = View.inflate(this.context, 2130903760, null);
            b bVar2 = new b();
            bVar2.dID = (TextView) view.findViewById(2131757381);
            bVar2.gxL = (ViewGroup) bVar2.dID.getParent();
            bVar2.gxM = (TextView) view.findViewById(2131757382);
            bVar2.gxN = (TextView) view.findViewById(2131757383);
            bVar2.gxO = (ViewGroup) bVar2.gxM.getParent();
            bVar2.gxP = (TextView) view.findViewById(2131757384);
            bVar2.gxQ = (ViewGroup) bVar2.gxP.getParent().getParent();
            view.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        switch (lE.type) {
            case 1:
                bVar.gxL.setVisibility(0);
                bVar.gxO.setVisibility(8);
                bVar.gxQ.setVisibility(8);
                bVar.gxL.setOnClickListener(null);
                bVar.dID.setText(lE.text);
                break;
            case 2:
                bVar.gxL.setVisibility(8);
                bVar.gxO.setVisibility(0);
                bVar.gxQ.setVisibility(8);
                bVar.gxM.setText(lE.text);
                bVar.gxN.setText(lE.description);
                break;
            case 3:
                bVar.gxL.setVisibility(8);
                bVar.gxO.setVisibility(8);
                bVar.gxQ.setVisibility(0);
                bVar.gxP.setTextColor(this.context.getResources().getColor(2131689909));
                int color = this.context.getResources().getColor(2131689755);
                int indexOf = lE.text.indexOf(this.aXp);
                if (indexOf < 0) {
                    bVar.gxP.setText(lE.text);
                    break;
                }
                CharSequence spannableString = new SpannableString(lE.text);
                spannableString.setSpan(new ForegroundColorSpan(color), indexOf, this.aXp.length() + indexOf, 33);
                bVar.gxP.setText(spannableString);
                break;
        }
        return view;
    }

    public final int getCount() {
        return this.cqE.size();
    }

    public final a lE(int i) {
        return (a) this.cqE.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final void a(String str, String str2, LinkedList<rg> linkedList) {
        if (!be.bP(linkedList)) {
            this.aXp = str;
            this.cqE.clear();
            if (be.kS(str)) {
                a aVar = new a();
                aVar.type = 1;
                if (be.kS(str2)) {
                    aVar.text = this.context.getString(2131233129);
                } else {
                    aVar.text = str2;
                }
                this.cqE.add(aVar);
            }
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                rg rgVar = (rg) it.next();
                a aVar2 = new a();
                aVar2.type = be.kS(str) ? 2 : 3;
                aVar2.appId = rgVar.gkz;
                aVar2.text = rgVar.mvd;
                aVar2.description = rgVar.mdJ;
                aVar2.actionType = rgVar.muU;
                aVar2.gxK = rgVar.muV;
                this.cqE.add(aVar2);
            }
            notifyDataSetChanged();
        }
    }
}
