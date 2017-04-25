package com.tencent.mm.plugin.ipcall.ui;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.modelsearch.h;
import com.tencent.mm.plugin.ipcall.a.g.d;
import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.n;
import com.tencent.mm.ui.j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public final class c extends j<com.tencent.mm.plugin.ipcall.a.g.c> implements com.tencent.mm.u.d.a {
    static HashMap<String, com.tencent.mm.plugin.ipcall.a.g.c> gIA = null;
    private String dwS;
    HashMap<String, Integer> eTn = new HashMap();
    boolean eyB = false;
    private d gJB;
    private HashMap<Long, com.tencent.mm.plugin.ipcall.a.g.c> gJC = new HashMap();
    private HashSet<String> gJD = new HashSet();
    private boolean gJE = false;
    private OnClickListener gJF = new OnClickListener(this) {
        final /* synthetic */ c gJG;

        {
            this.gJG = r1;
        }

        public final void onClick(View view) {
            if (view.getTag() instanceof Integer) {
                com.tencent.mm.plugin.ipcall.a.g.c ma = this.gJG.ma(((Integer) view.getTag()).intValue());
                Intent intent = new Intent(this.gJG.context, IPCallUserProfileUI.class);
                intent.putExtra("IPCallProfileUI_contactid", ma.field_contactId);
                intent.putExtra("IPCallProfileUI_systemUsername", ma.field_systemAddressBookUsername);
                intent.putExtra("IPCallProfileUI_wechatUsername", ma.field_wechatUsername);
                this.gJG.context.startActivity(intent);
            }
        }
    };
    al gJe = new al();
    private Context mContext;

    class a {
        final /* synthetic */ c gJG;
        String gJH;
        String gJI;

        public a(c cVar, String str, String str2) {
            this.gJG = cVar;
            this.gJI = str2;
            this.gJH = str;
        }
    }

    private class b {
        ImageView dtz;
        final /* synthetic */ c gJG;
        TextView gJJ;
        TextView gJK;
        LinearLayout gJL;
        TextView gJM;
        TextView gJN;
        TextView gJO;
        TextView gJP;
        ImageView gJQ;
        View gJR;
        View gJS;
        View gJT;
        ImageView gJU;

        private b(c cVar) {
            this.gJG = cVar;
        }
    }

    public final /* synthetic */ Object a(Object obj, Cursor cursor) {
        obj = (com.tencent.mm.plugin.ipcall.a.g.c) obj;
        if (obj == null) {
            obj = new com.tencent.mm.plugin.ipcall.a.g.c();
        }
        obj.b(cursor);
        return obj;
    }

    public final /* synthetic */ Object getItem(int i) {
        return ma(i);
    }

    public c(Context context) {
        super(context, null);
        iQ(true);
        this.mContext = context;
        this.gJB = new d(context);
        n.AX().a(this);
    }

    public final int getCount() {
        return super.getCount();
    }

    public final int avb() {
        return super.getCount();
    }

    public final com.tencent.mm.plugin.ipcall.a.g.c ma(int i) {
        return (com.tencent.mm.plugin.ipcall.a.g.c) super.getItem(i);
    }

    public final void uU(String str) {
        this.dwS = str;
        if (be.kS(this.dwS)) {
            this.gJE = false;
        } else {
            this.gJE = true;
        }
        this.nDJ.clear();
        Ol();
        notifyDataSetChanged();
    }

    public final void Ol() {
        Cursor uM;
        Object obj = null;
        if (this.gJE) {
            this.eyB = true;
            uM = i.aur().uM(this.dwS);
            this.eyB = false;
        } else {
            uM = i.aur().cie.query("IPCallAddressItem", d.gIC, null, null, null, null, "upper(sortKey) asc");
        }
        if (uM != null) {
            uM.moveToFirst();
        }
        setCursor(uM);
        if (getCursor() != null) {
            Cursor cursor = getCursor();
            try {
                if (cursor.moveToFirst()) {
                    int i = 0;
                    while (!cursor.isAfterLast()) {
                        com.tencent.mm.plugin.ipcall.a.g.c cVar = new com.tencent.mm.plugin.ipcall.a.g.c();
                        cVar.b(cursor);
                        String uV = uV(cVar.field_sortKey);
                        if (i == 0) {
                            this.eTn.put(uV, Integer.valueOf(i));
                        } else if (obj != null) {
                            if (!uV.equals(obj)) {
                                this.eTn.put(uV, Integer.valueOf(i));
                            }
                        }
                        i++;
                        cursor.moveToNext();
                        String str = uV;
                    }
                }
            } catch (Exception e) {
                v.e("MicroMsg.IPCallAddressAdapter", "initSectionPosMap error: %s", new Object[]{e.getMessage()});
            }
        }
    }

    public final void avc() {
        super.avc();
    }

    protected final void Om() {
        super.avc();
        Ol();
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(this.context).inflate(2130903828, viewGroup, false);
            b bVar = new b();
            bVar.gJS = view.findViewById(2131757600);
            bVar.gJT = view.findViewById(2131757601);
            bVar.dtz = (ImageView) view.findViewById(2131755508);
            bVar.gJJ = (TextView) view.findViewById(2131756539);
            bVar.gJK = (TextView) view.findViewById(2131757550);
            bVar.gJL = (LinearLayout) view.findViewById(2131757603);
            bVar.gJM = (TextView) view.findViewById(2131757604);
            bVar.gJN = (TextView) view.findViewById(2131757605);
            bVar.gJO = (TextView) view.findViewById(2131757599);
            bVar.gJP = (TextView) view.findViewById(2131757598);
            bVar.gJQ = (ImageView) view.findViewById(2131757606);
            bVar.gJR = view.findViewById(2131757602);
            bVar.gJR.setClickable(true);
            bVar.gJU = (ImageView) view.findViewById(2131755264);
            view.setTag(bVar);
        }
        b bVar2 = (b) view.getTag();
        bVar2.gJR.setClickable(true);
        bVar2.gJR.setTag(Integer.valueOf(i));
        bVar2.gJU.setVisibility(8);
        if (lB(i)) {
            bVar2.gJJ.setVisibility(8);
            bVar2.gJK.setVisibility(8);
            bVar2.gJL.setVisibility(8);
            bVar2.dtz.setVisibility(8);
            bVar2.dtz.setTag(null);
            bVar2.gJP.setVisibility(8);
            bVar2.gJO.setVisibility(8);
            bVar2.gJQ.setVisibility(8);
        } else {
            com.tencent.mm.plugin.ipcall.a.g.c ma = ma(i);
            if (ma != null) {
                CharSequence charSequence;
                if (be.kS(ma.field_systemAddressBookUsername)) {
                    bVar2.gJJ.setVisibility(8);
                    bVar2.gJK.setVisibility(8);
                } else {
                    bVar2.gJJ.setVisibility(0);
                    LayoutParams layoutParams;
                    RelativeLayout.LayoutParams layoutParams2;
                    if (this.gJE) {
                        bVar2.gJK.setVisibility(0);
                        layoutParams = (LayoutParams) bVar2.gJS.getLayoutParams();
                        layoutParams.height = (int) bVar2.gJK.getContext().getResources().getDimension(2131492959);
                        bVar2.gJS.setLayoutParams(layoutParams);
                        layoutParams2 = (RelativeLayout.LayoutParams) bVar2.dtz.getLayoutParams();
                        layoutParams2.height = (int) bVar2.dtz.getContext().getResources().getDimension(2131492914);
                        layoutParams2.width = (int) bVar2.dtz.getContext().getResources().getDimension(2131492914);
                        bVar2.dtz.setLayoutParams(layoutParams2);
                    } else {
                        bVar2.gJK.setVisibility(8);
                        layoutParams = (LayoutParams) bVar2.gJS.getLayoutParams();
                        layoutParams.height = (int) bVar2.gJK.getContext().getResources().getDimension(2131492915);
                        bVar2.gJS.setLayoutParams(layoutParams);
                        layoutParams2 = (RelativeLayout.LayoutParams) bVar2.dtz.getLayoutParams();
                        layoutParams2.height = (int) bVar2.dtz.getContext().getResources().getDimension(2131492957);
                        layoutParams2.width = (int) bVar2.dtz.getContext().getResources().getDimension(2131492957);
                        bVar2.dtz.setLayoutParams(layoutParams2);
                    }
                    if (this.gJE && ma.gIB == null && gIA != null && gIA.containsKey(ma.field_contactId)) {
                        ma.gIB = ((com.tencent.mm.plugin.ipcall.a.g.c) gIA.get(ma.field_contactId)).gIB;
                    } else if (this.gJE && ma.gIB == null && (gIA == null || gIA.containsKey(ma.field_contactId))) {
                        ma.gIB = com.tencent.mm.plugin.ipcall.a.g.b.uJ(ma.field_contactId);
                    }
                    if (!be.kS(this.dwS) && (be.j(this.dwS.charAt(0)) || this.dwS.startsWith("+"))) {
                        bVar2.gJK.setText(h.a(this.mContext, a(ma, this.dwS), al.Kp(this.dwS)));
                        bVar2.gJJ.setText(h.a(this.mContext, ma.field_systemAddressBookUsername, this.dwS));
                    } else if (!be.kS(this.dwS) && !be.j(this.dwS.charAt(0))) {
                        String str;
                        Context context = this.mContext;
                        CharSequence charSequence2 = ma.field_systemAddressBookUsername;
                        String str2 = ma.field_systemAddressBookUsername;
                        CharSequence charSequence3 = this.dwS;
                        if (be.kS(charSequence3) || be.kS(str2)) {
                            str = "";
                        } else {
                            if (!be.Ku(charSequence3) && be.Kv(charSequence3)) {
                                int i2;
                                int i3;
                                List arrayList = new ArrayList();
                                for (i2 = 0; i2 < str2.length(); i2++) {
                                    String substring = str2.substring(i2, i2 + 1);
                                    arrayList.add(new a(this, com.tencent.mm.platformtools.c.lT(substring), substring));
                                }
                                for (i2 = 2; i2 <= str2.length(); i2++) {
                                    for (i3 = 0; i3 <= str2.length() - i2; i3++) {
                                        String substring2 = str2.substring(i3, i3 + i2);
                                        arrayList.add(new a(this, com.tencent.mm.platformtools.c.lT(substring2), substring2));
                                    }
                                }
                                for (i3 = 0; i3 < arrayList.size(); i3++) {
                                    a aVar = (a) arrayList.get(i3);
                                    if (aVar.gJH.contains(charSequence3)) {
                                        str = aVar.gJI;
                                        break;
                                    }
                                }
                            }
                            charSequence = charSequence3;
                        }
                        bVar2.gJJ.setText(h.a(context, charSequence2, str));
                        bVar2.gJK.setText(a(ma, this.dwS));
                    } else if (be.kS(this.dwS)) {
                        bVar2.gJJ.setText(ma.field_systemAddressBookUsername);
                    }
                }
                ImageView imageView = bVar2.dtz;
                if (imageView != null) {
                    imageView.setVisibility(0);
                    imageView.setTag(null);
                    imageView.setImageResource(2130838439);
                    if (ma != null) {
                        if (!be.kS(ma.field_contactId) && !be.kS(ma.field_wechatUsername)) {
                            this.gJB.a(ma.field_contactId, ma.field_wechatUsername, imageView);
                        } else if (!be.kS(ma.field_contactId)) {
                            this.gJB.b(ma.field_contactId, imageView);
                        } else if (!be.kS(ma.field_wechatUsername)) {
                            this.gJB.c(ma.field_wechatUsername, imageView);
                        }
                        if (!be.kS(ma.field_wechatUsername)) {
                            this.gJD.add(ma.field_wechatUsername);
                        }
                    }
                }
                bVar2.gJL.setVisibility(8);
                charSequence = uV(ma.field_sortKey);
                if (i == 0) {
                    bVar2.gJO.setVisibility(0);
                    bVar2.gJO.setText(charSequence);
                    bVar2.gJP.setVisibility(8);
                } else if (uV(ma(i - 1).field_sortKey).equals(charSequence)) {
                    bVar2.gJO.setVisibility(8);
                    bVar2.gJO.setText("");
                    bVar2.gJP.setVisibility(8);
                } else {
                    bVar2.gJO.setVisibility(0);
                    bVar2.gJO.setText(charSequence);
                    bVar2.gJP.setVisibility(8);
                }
            }
            bVar2.gJR.setVisibility(8);
            bVar2.gJQ.setVisibility(8);
            bVar2.gJQ.setOnClickListener(this.gJF);
        }
        Object obj = 1;
        if (!(ma(i + 1) == null || ma(i) == null || uV(ma(i + 1).field_sortKey).equals(uV(ma(i).field_sortKey)))) {
            obj = null;
        }
        if (i + 1 == getCount() || r1 == null) {
            bVar2.gJT.setVisibility(8);
        } else {
            bVar2.gJT.setVisibility(0);
        }
        return view;
    }

    private static String a(com.tencent.mm.plugin.ipcall.a.g.c cVar, String str) {
        if (!(cVar == null || cVar.gIB == null)) {
            Iterator it = cVar.gIB.iterator();
            while (it.hasNext()) {
                String str2 = (String) it.next();
                if (str2.contains(str)) {
                    return str2;
                }
            }
        }
        return null;
    }

    private static String uV(String str) {
        if (be.kS(str)) {
            return "";
        }
        if (str.startsWith(com.tencent.mm.plugin.ipcall.a.g.b.eTm)) {
            return "#";
        }
        return str.toUpperCase().substring(0, 1);
    }

    public final int getItemViewType(int i) {
        return super.getItemViewType(i);
    }

    public final int getViewTypeCount() {
        return super.getViewTypeCount();
    }

    public final void gM(String str) {
        if (this.gJD.contains(str)) {
            ad.o(new Runnable(this) {
                final /* synthetic */ c gJG;

                {
                    this.gJG = r1;
                }

                public final void run() {
                    this.gJG.notifyDataSetChanged();
                }
            });
        }
    }

    public final void notifyDataSetChanged() {
        this.gJC.clear();
        super.notifyDataSetChanged();
    }
}
