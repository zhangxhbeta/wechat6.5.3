package com.tencent.mm.plugin.ipcall.ui;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.plugin.ipcall.a.g.c;
import com.tencent.mm.plugin.ipcall.a.g.k;
import com.tencent.mm.plugin.ipcall.a.g.m;
import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.u.n;
import com.tencent.mm.ui.j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public final class h extends j<c> implements com.tencent.mm.u.d.a {
    private static HashMap<String, c> gIA = null;
    private boolean eyB = false;
    private d gJB;
    private HashMap<Long, c> gJC = new HashMap();
    private HashSet<String> gJD = new HashSet();
    private boolean gJE = false;
    ArrayList<k> gMQ;
    private OnClickListener gMR = new OnClickListener(this) {
        final /* synthetic */ h gMS;

        {
            this.gMS = r1;
        }

        public final void onClick(View view) {
            if (view.getTag() instanceof Integer) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (com.tencent.mm.plugin.ipcall.b.c.avB()) {
                    Toast.makeText(this.gMS.context, 2131233397, 1).show();
                    return;
                }
                k mh = this.gMS.mh(intValue);
                c cVar = null;
                if (mh.field_addressId > 0) {
                    if (this.gMS.gJC.containsKey(Long.valueOf(mh.field_addressId))) {
                        cVar = (c) this.gMS.gJC.get(Long.valueOf(mh.field_addressId));
                    } else {
                        cVar = i.aur().ca(mh.field_addressId);
                    }
                    if (cVar != null) {
                        this.gMS.gJC.put(Long.valueOf(mh.field_addressId), cVar);
                    }
                }
                Intent intent;
                if (cVar != null) {
                    intent = new Intent(this.gMS.context, IPCallTalkUI.class);
                    intent.putExtra("IPCallTalkUI_phoneNumber", mh.field_phonenumber);
                    intent.putExtra("IPCallTalkUI_contactId", cVar.field_contactId);
                    intent.putExtra("IPCallTalkUI_nickname", cVar.field_systemAddressBookUsername);
                    intent.putExtra("IPCallTalkUI_toWechatUsername", cVar.field_wechatUsername);
                    intent.putExtra("IPCallTalkUI_dialScene", 3);
                    g.iuh.h(12059, new Object[]{Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(3)});
                    ((FragmentActivity) this.gMS.context).startActivityForResult(intent, 1001);
                    return;
                }
                intent = new Intent(this.gMS.context, IPCallTalkUI.class);
                intent.putExtra("IPCallTalkUI_phoneNumber", mh.field_phonenumber);
                intent.putExtra("IPCallTalkUI_dialScene", 3);
                g.iuh.h(12059, new Object[]{Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(3)});
                ((FragmentActivity) this.gMS.context).startActivityForResult(intent, 1001);
            }
        }
    };

    private class a {
        ImageView dtz;
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
        final /* synthetic */ h gMS;

        private a(h hVar) {
            this.gMS = hVar;
        }
    }

    public final /* synthetic */ Object a(Object obj, Cursor cursor) {
        obj = (c) obj;
        if (obj == null) {
            obj = new c();
        }
        obj.b(cursor);
        return obj;
    }

    public h(Context context) {
        super(context, null);
        iQ(true);
        this.gJB = new d(context);
        n.AX().a(this);
    }

    protected final void Om() {
        this.gMQ = m.auV();
    }

    public final void Ol() {
        this.gMQ = m.auV();
    }

    public final int getCount() {
        if (this.gMQ == null) {
            this.gMQ = m.auV();
        }
        if (this.gMQ != null) {
            return this.gMQ.size();
        }
        return 0;
    }

    public final k mh(int i) {
        return (k) this.gMQ.get(i);
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(this.context).inflate(2130903828, viewGroup, false);
            a aVar = new a();
            aVar.gJS = view.findViewById(2131757600);
            aVar.gJT = view.findViewById(2131757601);
            aVar.dtz = (ImageView) view.findViewById(2131755508);
            aVar.gJJ = (TextView) view.findViewById(2131756539);
            aVar.gJK = (TextView) view.findViewById(2131757550);
            aVar.gJL = (LinearLayout) view.findViewById(2131757603);
            aVar.gJM = (TextView) view.findViewById(2131757604);
            aVar.gJN = (TextView) view.findViewById(2131757605);
            aVar.gJO = (TextView) view.findViewById(2131757599);
            aVar.gJP = (TextView) view.findViewById(2131757598);
            aVar.gJQ = (ImageView) view.findViewById(2131757606);
            aVar.gJR = view.findViewById(2131757602);
            aVar.gJR.setClickable(true);
            aVar.gJU = (ImageView) view.findViewById(2131755264);
            view.setTag(aVar);
        }
        a aVar2 = (a) view.getTag();
        aVar2.gJR.setClickable(true);
        aVar2.gJR.setTag(Integer.valueOf(i));
        aVar2.gJU.setVisibility(8);
        if (lB(i)) {
            aVar2.gJJ.setVisibility(8);
            aVar2.gJK.setVisibility(8);
            aVar2.gJL.setVisibility(8);
            aVar2.dtz.setVisibility(8);
            aVar2.dtz.setTag(null);
            aVar2.gJP.setVisibility(8);
            aVar2.gJO.setVisibility(8);
            aVar2.gJQ.setVisibility(8);
        } else {
            k mh = mh(i);
            if (mh != null) {
                c ca;
                if (i == 0) {
                    aVar2.gJP.setVisibility(0);
                    aVar2.gJO.setVisibility(8);
                    aVar2.gJP.setText(this.context.getString(2131233374));
                } else {
                    aVar2.gJP.setVisibility(8);
                    aVar2.gJO.setVisibility(8);
                }
                aVar2.gJU.setVisibility(0);
                aVar2.gJJ.setVisibility(0);
                LayoutParams layoutParams = (LayoutParams) aVar2.gJS.getLayoutParams();
                layoutParams.height = (int) aVar2.gJK.getContext().getResources().getDimension(2131492915);
                aVar2.gJS.setLayoutParams(layoutParams);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) aVar2.dtz.getLayoutParams();
                layoutParams2.height = (int) aVar2.dtz.getContext().getResources().getDimension(2131492957);
                layoutParams2.width = (int) aVar2.dtz.getContext().getResources().getDimension(2131492957);
                aVar2.dtz.setLayoutParams(layoutParams2);
                if (mh.field_addressId > 0) {
                    ca = this.gJC.containsKey(Long.valueOf(mh.field_addressId)) ? (c) this.gJC.get(Long.valueOf(mh.field_addressId)) : i.aur().ca(mh.field_addressId);
                    if (ca != null) {
                        this.gJC.put(Long.valueOf(mh.field_addressId), ca);
                        aVar2.gJJ.setText(ca.field_systemAddressBookUsername);
                    }
                } else {
                    aVar2.gJJ.setText(com.tencent.mm.plugin.ipcall.b.a.vp(mh.field_phonenumber));
                    ca = null;
                }
                aVar2.gJK.setVisibility(8);
                aVar2.gJL.setVisibility(0);
                aVar2.gJN.setText(com.tencent.mm.plugin.ipcall.b.c.cd(mh.field_calltime));
                if (mh.field_duration > 0) {
                    aVar2.gJM.setText(com.tencent.mm.plugin.ipcall.b.c.cf(mh.field_duration));
                } else {
                    aVar2.gJM.setText(com.tencent.mm.plugin.ipcall.b.c.ml(mh.field_status));
                }
                ImageView imageView = aVar2.dtz;
                if (imageView != null) {
                    imageView.setVisibility(0);
                    imageView.setTag(null);
                    imageView.setImageResource(2130838439);
                    if (ca != null) {
                        if (!be.kS(ca.field_contactId) && !be.kS(ca.field_wechatUsername)) {
                            this.gJB.a(ca.field_contactId, ca.field_wechatUsername, imageView);
                        } else if (!be.kS(ca.field_contactId)) {
                            this.gJB.b(ca.field_contactId, imageView);
                        } else if (!be.kS(ca.field_wechatUsername)) {
                            this.gJB.c(ca.field_wechatUsername, imageView);
                        }
                        if (!be.kS(ca.field_wechatUsername)) {
                            this.gJD.add(ca.field_wechatUsername);
                        }
                    }
                }
            }
            aVar2.gJR.setVisibility(0);
            aVar2.gJQ.setVisibility(0);
            aVar2.gJR.setOnClickListener(this.gMR);
        }
        return view;
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
                final /* synthetic */ h gMS;

                {
                    this.gMS = r1;
                }

                public final void run() {
                    this.gMS.notifyDataSetChanged();
                }
            });
        }
    }

    public final void notifyDataSetChanged() {
        this.gMQ = m.auV();
        this.gJC.clear();
        super.notifyDataSetChanged();
    }
}
