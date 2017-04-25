package com.tencent.mm.ui.chatting;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.ae.f;
import com.tencent.mm.ae.n;
import com.tencent.mm.ay.c;
import com.tencent.mm.e.a.gv;
import com.tencent.mm.e.a.hq;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tencent.mm.ui.chatting.ad.a;
import com.tencent.mmdb.database.SQLiteDatabase;

final class do extends a {
    LinearLayout ltp;
    TextView ltr;
    TextView lts;
    ProgressBar ltt;
    ImageView ltu;
    ProgressBar ltv;
    ImageView ltw;
    ImageView okm;

    public do(int i) {
        super(i);
    }

    public final a o(View view, boolean z) {
        super.cM(view);
        this.eTg = (TextView) view.findViewById(2131755027);
        this.lts = (TextView) view.findViewById(2131756211);
        this.ltr = (TextView) view.findViewById(2131756210);
        this.ltp = (LinearLayout) view.findViewById(2131756209);
        this.ltt = (ProgressBar) view.findViewById(2131756215);
        this.onC = view.findViewById(2131756148);
        this.iJL = (TextView) view.findViewById(2131755341);
        this.gfb = (CheckBox) view.findViewById(2131755022);
        this.fIV = view.findViewById(2131755026);
        this.ltu = (ImageView) view.findViewById(2131756213);
        this.ltv = (ProgressBar) view.findViewById(2131756212);
        this.ltw = (ImageView) view.findViewById(2131756214);
        this.type = z ? 16 : 17;
        if (!z) {
            this.oky = (ImageView) view.findViewById(2131756230);
            this.okm = (ImageView) view.findViewById(2131756258);
        }
        this.ltr.setTextSize(1, 16.0f);
        this.lts.setTextSize(1, 12.0f);
        return this;
    }

    public static void a(do doVar, at atVar, boolean z, int i, ChattingUI.a aVar) {
        if (doVar != null) {
            b hqVar;
            Object obj;
            doVar.ltp.setVisibility(8);
            int fromDPToPix = com.tencent.mm.bd.a.fromDPToPix(aVar.nDR.nEl, 236);
            int fromDPToPix2 = com.tencent.mm.bd.a.fromDPToPix(aVar.nDR.nEl, 90);
            doVar.ltr.setMaxLines(1);
            doVar.lts.setMaxLines(1);
            doVar.lts.setText(SQLiteDatabase.KeyEmpty);
            if (c.EH("location")) {
                v.d("MicroMsg.LocationItemHolder", "plugin found!");
                hqVar = new hq();
                hqVar.bhv.bhq = 1;
                hqVar.bhv.aXd = atVar;
                com.tencent.mm.sdk.c.a.nhr.z(hqVar);
                CharSequence charSequence = hqVar.bhw.bhy;
                CharSequence charSequence2 = hqVar.bhw.bhz;
                if ((charSequence != null || a(charSequence2, aVar)) && ((charSequence == null || !charSequence.equals(SQLiteDatabase.KeyEmpty) || a(charSequence2, aVar)) && (charSequence == null || !charSequence.equals("err_not_started")))) {
                    doVar.ltv.setVisibility(8);
                    doVar.ltp.setVisibility(0);
                    v.d("MicroMsg.LocationItemHolder", "location info : " + charSequence);
                    if (a(charSequence2, aVar)) {
                        doVar.ltr.setVisibility(0);
                        doVar.ltr.setText(charSequence2);
                        if (charSequence == null || charSequence.equals(SQLiteDatabase.KeyEmpty)) {
                            doVar.lts.setVisibility(8);
                        } else {
                            doVar.lts.setVisibility(0);
                            doVar.lts.setText(charSequence);
                        }
                    } else {
                        doVar.ltr.setMaxLines(2);
                        doVar.ltr.setText(charSequence);
                        doVar.lts.setVisibility(8);
                    }
                } else {
                    v.d("MicroMsg.LocationItemHolder", "info error or subcore not started!");
                    doVar.ltv.setVisibility(0);
                    doVar.ltp.setVisibility(0);
                    doVar.ltr.setText(SQLiteDatabase.KeyEmpty);
                    doVar.lts.setText(SQLiteDatabase.KeyEmpty);
                }
            } else {
                doVar.ltt.setVisibility(0);
                doVar.ltp.setVisibility(8);
            }
            ImageView imageView = doVar.ltu;
            f GH = n.GH();
            if (z) {
                obj = "location_backgroup_key_from";
            } else {
                String str = "location_backgroup_key_tor";
            }
            Bitmap bitmap = (Bitmap) GH.cMb.get(obj);
            if (bitmap == null || bitmap.isRecycled()) {
                bitmap = d.o(2130838481, 2130838629, fromDPToPix, fromDPToPix2);
                GH.cMb.k(obj, bitmap);
            }
            imageView.setImageBitmap(bitmap);
            hqVar = new gv();
            hqVar.bgt.aXd = atVar;
            hqVar.bgt.w = fromDPToPix;
            hqVar.bgt.h = fromDPToPix2;
            hqVar.bgt.bgy = 2130838629;
            hqVar.bgt.bgv = doVar.ltu;
            hqVar.bgt.bgx = doVar.ltt;
            hqVar.bgt.bgw = doVar.ltw;
            com.tencent.mm.sdk.c.a.nhr.z(hqVar);
            doVar.onC.setTag(new dl(atVar, aVar.nQK, i, null, 0, (byte) 0));
            doVar.onC.setOnClickListener(aVar.onh.oqh);
            doVar.onC.setOnLongClickListener(aVar.onh.oqj);
        }
    }

    private static boolean a(String str, ChattingUI.a aVar) {
        return (str == null || str.equals(SQLiteDatabase.KeyEmpty) || str.equals(aVar.getString(2131233537))) ? false : true;
    }
}
