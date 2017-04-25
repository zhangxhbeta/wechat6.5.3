package com.tencent.mm.plugin.nearlife.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.protocal.c.aft;
import com.tencent.mm.sdk.platformtools.be;
import java.util.HashMap;

public final class b extends a {
    aft hGT;
    private aft hGU = new aft();
    String hGV;
    private HashMap<String, Integer> hGW = new HashMap();

    class a {
        TextView dtB;
        TextView emb;
        aft hGX;
        LinearLayout hGY;
        TextView hGZ;
        ImageView hHa;
        String hHb;
        final /* synthetic */ b hHc;
        int position;
        int type;

        a(b bVar) {
            this.hHc = bVar;
        }
    }

    public b(Context context, OnClickListener onClickListener, String str, boolean z) {
        super(context, onClickListener, str, z);
        this.hGU.aXz = context.getString(2131233978);
        this.hGW.put(this.hGU.hHb, Integer.valueOf(2));
        if (!z) {
            a(this.hGU, 0);
            notifyDataSetChanged();
        }
    }

    public final aft xi(String str) {
        if (this.hGT == null) {
            this.hGT = new aft();
            this.hGT.hHb = "City";
            this.hGW.put(this.hGT.hHb, Integer.valueOf(1));
            a(this.hGT, 1);
        }
        this.hGT.aXz = str;
        notifyDataSetChanged();
        return this.hGT;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        int intValue;
        if (view == null) {
            a aVar2 = new a(this);
            view = View.inflate(this.mContext, 2130904111, null);
            aVar2.dtB = (TextView) view.findViewById(2131758387);
            aVar2.hGZ = (TextView) view.findViewById(2131758399);
            aVar2.emb = (TextView) view.findViewById(2131758400);
            aVar2.hGY = (LinearLayout) view.findViewById(2131758385);
            aVar2.hHa = (ImageView) view.findViewById(2131758401);
            aVar2.hGY.setOnClickListener(this.fQr);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        aft com_tencent_mm_protocal_c_aft = (aft) getItem(i);
        if (this.hGW.containsKey(com_tencent_mm_protocal_c_aft.hHb)) {
            intValue = ((Integer) this.hGW.get(com_tencent_mm_protocal_c_aft.hHb)).intValue();
        } else {
            intValue = 0;
        }
        aVar.hHa.setVisibility(8);
        aVar.type = intValue;
        aVar.hGX = com_tencent_mm_protocal_c_aft;
        if (!be.kS(this.hGV) && this.hGV.equals(com_tencent_mm_protocal_c_aft.hHb)) {
            aVar.hHa.setVisibility(0);
        }
        switch (intValue) {
            case 0:
                aVar.dtB.setTextColor(this.mContext.getResources().getColor(2131689547));
                aVar.emb.setVisibility(0);
                break;
            case 1:
                aVar.dtB.setTextColor(this.mContext.getResources().getColor(2131689547));
                aVar.emb.setVisibility(8);
                break;
            case 2:
                aVar.emb.setVisibility(8);
                aVar.dtB.setTextColor(this.mContext.getResources().getColor(2131690029));
                if (be.kS(this.hGV)) {
                    aVar.hHa.setVisibility(0);
                    break;
                }
                break;
        }
        aVar.position = i;
        aVar.hHb = com_tencent_mm_protocal_c_aft.hHb;
        aVar.dtB.setText(com_tencent_mm_protocal_c_aft.aXz);
        aVar.hGZ.setVisibility(8);
        aVar.hGZ.setText(com_tencent_mm_protocal_c_aft.mFC);
        aVar.emb.setText(a.aR(com_tencent_mm_protocal_c_aft.mFG));
        return view;
    }
}
