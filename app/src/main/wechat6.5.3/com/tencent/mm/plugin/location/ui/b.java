package com.tencent.mm.plugin.location.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import com.tencent.mm.bd.a;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.MMGridPaper;
import com.tencent.mm.ui.base.i;
import java.util.ArrayList;
import java.util.Iterator;

public final class b {
    private i gTB = null;
    private MMGridPaper gTC = null;
    private a gTD = null;
    private ViewGroup gTE = null;
    private RelativeLayout gTF = null;
    private ArrayList<String> gTG = null;
    private int gTH = 0;
    private Context mContext = null;

    private b(Context context) {
        this.mContext = context;
        this.gTB = new i(this.mContext, 2131559286);
        this.gTE = (ViewGroup) ((LayoutInflater) this.mContext.getSystemService("layout_inflater")).inflate(2130903144, null);
        this.gTC = (MMGridPaper) this.gTE.findViewById(2131755500);
        this.gTC.bBZ();
        this.gTC.bBX();
        this.gTC.bBY();
        this.gTC.bBW();
        this.gTC.wy(3);
        this.gTC.bCa();
        this.gTC.bBZ();
        this.gTC.bBU();
        this.gTC.bBV();
        this.gTB.setCanceledOnTouchOutside(true);
        this.gTB.setContentView(this.gTE);
        this.gTD = new a();
        this.gTC.a(this.gTD);
    }

    public static void b(Context context, ArrayList<String> arrayList) {
        v.d("MicroMsg.AvatarsDialog", "showDialog, username.size = %d", new Object[]{Integer.valueOf(arrayList.size())});
        b bVar = new b(context);
        bVar.gTG = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            bVar.gTG.add((String) it.next());
        }
        if (bVar.gTG.size() < 3) {
            bVar.gTC.wy(bVar.gTG.size());
        } else {
            bVar.gTC.wy(3);
        }
        LayoutParams layoutParams = bVar.gTC.getLayoutParams();
        bVar.gTH = a.fromDPToPix(bVar.mContext, 70);
        int fromDPToPix = a.fromDPToPix(bVar.mContext, 8);
        if (bVar.gTG.size() <= 0) {
            fromDPToPix = 0;
        } else if (bVar.gTG.size() < 3) {
            fromDPToPix = (fromDPToPix * (bVar.gTG.size() - 1)) + (bVar.gTH * bVar.gTG.size());
        } else {
            fromDPToPix = (fromDPToPix * 2) + (bVar.gTH * 3);
        }
        String dD = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.dD(bVar.mContext);
        v.d("MicroMsg.AvatarsDialog", "calculateGridWidth, result = %d, mUsername.size = %d, avatarSize = %d, densityType = %s", new Object[]{Integer.valueOf(fromDPToPix), Integer.valueOf(bVar.gTG.size()), Integer.valueOf(bVar.gTH), dD});
        layoutParams.width = fromDPToPix;
        bVar.gTH = a.fromDPToPix(bVar.mContext, 70);
        fromDPToPix = a.fromDPToPix(bVar.mContext, 15);
        if (bVar.gTG.size() > 0) {
            if (bVar.gTG.size() <= 3) {
                fromDPToPix += bVar.gTH;
            } else if (bVar.gTG.size() <= 6) {
                fromDPToPix += bVar.gTH * 2;
            } else {
                fromDPToPix = ((fromDPToPix * 2) + (bVar.gTH * 3)) + a.fromDPToPix(bVar.mContext, 10);
            }
            v.d("MicroMsg.AvatarsDialog", "calculateGridHeight, result = %d", new Object[]{Integer.valueOf(fromDPToPix)});
        } else {
            fromDPToPix = 0;
        }
        layoutParams.height = fromDPToPix;
        bVar.gTC.setLayoutParams(layoutParams);
        bVar.gTC.requestLayout();
        bVar.gTD.F(bVar.gTG);
        bVar.gTB.show();
    }
}
