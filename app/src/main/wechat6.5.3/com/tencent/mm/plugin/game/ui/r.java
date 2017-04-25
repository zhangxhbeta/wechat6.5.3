package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.game.e.e;
import com.tencent.mm.protocal.c.rm;
import com.tencent.mm.sdk.platformtools.be;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public final class r extends BaseAdapter {
    boolean aWL = false;
    Context context;
    ArrayList<b> eUn;
    int gur = 0;
    boolean gxf = false;
    int gxg = 0;
    int gxh = 0;
    int gxi = 0;
    int gxj = 0;
    private int gxk;
    boolean gxl = false;
    private ArrayList<d> gxm;

    private static class a {
        public View dtW;
        ImageView gxq;
        TextView gxr;
        TextView gxs;
        TextView gxt;
        TextView gxu;
        View gxv;
        TextView gxw;
        TextView gxx;

        private a() {
        }
    }

    public static class b {
        public String aXp;
        public int actionType;
        public String appId;
        public String cuQ;
        public long dhH;
        public rm gxA;
        public String gxB;
        public LinkedList<String> gxC;
        public int gxD;
        public int gxE;
        public boolean gxF = false;
        public boolean gxG = false;
        public c gxH;
        public String gxy;
        public String gxz;
        public String iconUrl;
        public String name;
        public int type;

        public static b R(int i, String str) {
            b bVar = new b();
            bVar.type = i;
            bVar.name = str;
            bVar.gxH = new c();
            return bVar;
        }

        public static b m(int i, String str, String str2) {
            b bVar = new b();
            bVar.type = i;
            bVar.name = str;
            bVar.gxH = new c(str2);
            return bVar;
        }
    }

    public static class c {
        public int actionType;
        String appId;
        int bmG;
        int gxD;
        int gxE;
        String gxI;
        String gxJ;
        int position;
        int type;

        public c(String str) {
            this.actionType = 2;
            this.gxI = str;
        }

        public c(String str, byte b) {
            this.actionType = 2;
            this.type = 3;
            this.gxI = str;
        }

        public c(int i, int i2, String str, String str2) {
            this.actionType = i;
            this.type = i2;
            this.appId = str;
            if (i == 2) {
                this.gxI = str2;
            }
        }
    }

    private class d {
        int end;
        final /* synthetic */ r gxp;
        int start;

        private d(r rVar) {
            this.gxp = rVar;
            this.start = -1;
            this.end = -1;
        }
    }

    public r(Context context) {
        this.context = context;
        this.eUn = null;
        this.gxk = context.getResources().getColor(2131689755);
    }

    public final int getCount() {
        return this.eUn == null ? 0 : this.eUn.size();
    }

    public final Object getItem(int i) {
        return this.eUn.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final int getItemViewType(int i) {
        return ((b) getItem(i)).type;
    }

    public final int getViewTypeCount() {
        return 7;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        b bVar = (b) getItem(i);
        if (view == null) {
            int i2;
            aVar = new a();
            Context context = this.context;
            switch (bVar.type) {
                case 0:
                    i2 = 2130903762;
                    break;
                case 1:
                    i2 = 2130903756;
                    break;
                case 2:
                    i2 = 2130903763;
                    break;
                case 3:
                    i2 = 2130903761;
                    break;
                case 4:
                case 5:
                    i2 = 2130903758;
                    break;
                case 6:
                    i2 = 2130903759;
                    break;
                default:
                    i2 = 0;
                    break;
            }
            view = View.inflate(context, i2, null);
            aVar.dtW = view.findViewById(2131757373);
            aVar.gxq = (ImageView) view.findViewById(2131757374);
            aVar.gxr = (TextView) view.findViewById(2131757376);
            aVar.gxs = (TextView) view.findViewById(2131757375);
            aVar.gxt = (TextView) view.findViewById(2131757377);
            aVar.gxu = (TextView) view.findViewById(2131757385);
            aVar.gxv = view.findViewById(2131757386);
            aVar.gxw = (TextView) view.findViewById(2131757387);
            aVar.gxx = (TextView) view.findViewById(2131757388);
            view.setTag(aVar);
            if (!(aVar.gxr == null || aVar.gxt == null)) {
                final TextView textView = aVar.gxr;
                final TextView textView2 = aVar.gxt;
                textView.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener(this) {
                    final /* synthetic */ r gxp;

                    public final void onGlobalLayout() {
                        if (textView.getLineCount() > 1) {
                            textView.setMaxLines(2);
                            textView2.setMaxLines(1);
                            return;
                        }
                        textView2.setMaxLines(2);
                    }
                });
            }
        } else {
            aVar = (a) view.getTag();
        }
        com.tencent.mm.plugin.game.e.e.a.a aVar2;
        switch (bVar.type) {
            case 0:
                aVar.gxt.setText(bVar.name);
                break;
            case 1:
                if (!be.kS(bVar.iconUrl)) {
                    aVar2 = new com.tencent.mm.plugin.game.e.e.a.a();
                    aVar2.cPq = false;
                    e.asK().a(aVar.gxq, bVar.iconUrl, aVar2.asL());
                }
                a(aVar.gxr, bVar.name);
                a(aVar.gxs, bVar.gxz);
                a(aVar.gxt, bVar.gxy);
                break;
            case 2:
                if (be.kS(bVar.iconUrl)) {
                    aVar.gxq.setVisibility(8);
                } else {
                    aVar2 = new com.tencent.mm.plugin.game.e.e.a.a();
                    aVar2.cPq = false;
                    aVar2.gzR = true;
                    e.asK().a(aVar.gxq, bVar.iconUrl, aVar2.asL());
                    aVar.gxq.setVisibility(0);
                }
                a(aVar.gxr, bVar.name);
                a(aVar.gxt, bVar.gxy);
                if (be.kS(bVar.cuQ)) {
                    aVar.gxw.setVisibility(8);
                } else {
                    aVar.gxw.setText(com.tencent.mm.pluginsdk.ui.d.e.a(this.context, bVar.cuQ));
                    aVar.gxw.setVisibility(0);
                }
                if (bVar.dhH <= 0) {
                    aVar.gxx.setVisibility(8);
                    break;
                }
                aVar.gxx.setText(com.tencent.mm.plugin.game.e.b.f(this.context, bVar.dhH * 1000));
                aVar.gxx.setVisibility(0);
                break;
            case 3:
                if (!be.kS(bVar.iconUrl)) {
                    aVar2 = new com.tencent.mm.plugin.game.e.e.a.a();
                    aVar2.cPq = false;
                    e.asK().a(aVar.gxq, bVar.iconUrl, aVar2.asL());
                }
                a(aVar.gxr, bVar.name);
                a(aVar.gxs, bVar.gxz);
                a(aVar.gxt, bVar.gxy);
                TextView textView3 = aVar.gxu;
                LinkedList linkedList = bVar.gxC;
                StringBuilder stringBuilder = new StringBuilder();
                if (!be.bP(linkedList)) {
                    int size = linkedList.size();
                    for (int i3 = 0; i3 < size - 1; i3++) {
                        stringBuilder.append(((String) linkedList.get(i3)) + "\n");
                    }
                    stringBuilder.append((String) linkedList.get(size - 1));
                    textView3.setVisibility(0);
                    textView3.setText(stringBuilder.toString());
                    break;
                }
                textView3.setVisibility(8);
                break;
            case 4:
            case 5:
                aVar.gxq.setImageResource(2131165896);
                break;
            case 6:
                break;
        }
        aVar.gxr.setText(bVar.name);
        switch (bVar.type) {
            case 0:
                if (!bVar.gxF) {
                    aVar.gxv.setVisibility(0);
                    break;
                }
                aVar.gxv.setVisibility(8);
                break;
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                if (bVar.gxG) {
                    aVar.dtW.setBackgroundResource(2130838048);
                } else {
                    aVar.dtW.setBackgroundResource(2130838046);
                }
                int dimensionPixelSize = this.context.getResources().getDimensionPixelSize(2131493187);
                aVar.dtW.setPadding(0, dimensionPixelSize, 0, dimensionPixelSize);
                break;
        }
        return view;
    }

    private void a(TextView textView, String str) {
        if (be.kS(str)) {
            textView.setVisibility(8);
            return;
        }
        if (this.gxm == null) {
            this.gxm = new ArrayList();
        } else {
            this.gxm.clear();
        }
        StringBuilder stringBuilder = new StringBuilder(str);
        d dVar = new d();
        for (int indexOf = stringBuilder.indexOf("<em>"); indexOf >= 0; indexOf = stringBuilder.indexOf("<em>")) {
            dVar.start = indexOf;
            stringBuilder.delete(indexOf, indexOf + 4);
            indexOf = stringBuilder.indexOf("</em>");
            if (indexOf < 0) {
                break;
            }
            dVar.end = indexOf;
            stringBuilder.delete(indexOf, indexOf + 5);
            this.gxm.add(dVar);
        }
        CharSequence spannableString = new SpannableString(stringBuilder.toString());
        Iterator it = this.gxm.iterator();
        while (it.hasNext()) {
            d dVar2 = (d) it.next();
            if (dVar2.start < dVar2.end) {
                spannableString.setSpan(new ForegroundColorSpan(this.gxk), dVar2.start, dVar2.end, 33);
            }
        }
        textView.setText(spannableString);
        textView.setVisibility(0);
    }
}
