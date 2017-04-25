package com.tencent.mm.plugin.wenote.b;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.ay.c;
import com.tencent.mm.e.a.hp;
import com.tencent.mm.e.a.jb;
import com.tencent.mm.plugin.wenote.d.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;

public final class a {
    static LinearLayout ltp;
    static LinearLayout ltq;
    static TextView ltr;
    static TextView lts;
    static ProgressBar ltt;
    static ImageView ltu;
    static ProgressBar ltv;
    static ImageView ltw;
    static ImageView ltx;
    private Context context;

    public final void blV() {
        this.context = aa.getContext();
        View inflate = LayoutInflater.from(this.context).inflate(2130903599, null);
        ltq = (LinearLayout) inflate.findViewById(2131756942);
        lts = (TextView) inflate.findViewById(2131756211);
        ltr = (TextView) inflate.findViewById(2131756210);
        ltp = (LinearLayout) inflate.findViewById(2131756209);
        ltt = (ProgressBar) inflate.findViewById(2131756215);
        ltu = (ImageView) inflate.findViewById(2131756213);
        ltv = (ProgressBar) inflate.findViewById(2131756212);
        ltw = (ImageView) inflate.findViewById(2131756214);
        ltx = (ImageView) inflate.findViewById(2131756176);
        inflate.measure(MeasureSpec.makeMeasureSpec(600, 1073741824), MeasureSpec.makeMeasureSpec(450, 1073741824));
        inflate.layout(0, 0, inflate.getMeasuredWidth(), inflate.getMeasuredHeight());
        ltu.measure(MeasureSpec.makeMeasureSpec(600, 1073741824), MeasureSpec.makeMeasureSpec(450, 1073741824));
        ltu.layout(0, 0, ltu.getMeasuredWidth(), ltu.getMeasuredHeight());
    }

    public static void d(String str, String str2, String str3, String str4, String str5) {
        ltp.setVisibility(8);
        if (be.kS(str3)) {
            ltu.setImageResource(2130838481);
        } else {
            Drawable createFromPath = Drawable.createFromPath(str3);
            if (createFromPath == null) {
                v.e("MicroMsg.GetLocationInfoThumb", "setLocalInfo: drawable is null. bg set failed");
            }
            ltq.setBackgroundDrawable(createFromPath);
        }
        if (!c.EH("location")) {
            ltt.setVisibility(0);
            ltp.setVisibility(8);
        } else if ((str != null || FM(str2)) && ((str == null || !str.equals("") || FM(str2)) && (str == null || !str.equals("err_not_started")))) {
            ltv.setVisibility(8);
            ltp.setVisibility(0);
            v.d("MicroMsg.GetLocationInfoThumb", "location info : " + str);
            if (FM(str2)) {
                ltr.setVisibility(0);
                ltr.setText(str2);
                if (str == null || str.equals("")) {
                    lts.setVisibility(8);
                } else {
                    lts.setVisibility(0);
                    lts.setText(str);
                }
            } else {
                ltr.setMaxLines(2);
                ltr.setText(str);
                lts.setVisibility(8);
            }
        } else {
            v.d("MicroMsg.GetLocationInfoThumb", "info error or subcore not started!");
            ltv.setVisibility(0);
            ltp.setVisibility(0);
            ltr.setText("");
            lts.setText("");
        }
        int width = ltq.getWidth();
        int height = ltq.getHeight();
        if (width <= 0 || height <= 0) {
            v.e("MicroMsg.GetLocationInfoThumb", "Save Location thumb file fail");
            return;
        }
        hp hpVar = new hp();
        hpVar.bho.bhq = 0;
        hpVar.bho.bhr = str4;
        hpVar.bho.filename = str5;
        hpVar.bho.view = ltq;
        com.tencent.mm.sdk.c.a.nhr.z(hpVar);
        String str6 = hpVar.bhp.path;
        v.i("MicroMsg.GetLocationInfoThumb", "WNNoteWebview　UI Save Location thumb file success");
        if (!be.kS(str3) && b.luG.containsKey(str3)) {
            jb jbVar = new jb();
            jbVar.bjB.type = 5;
            com.tencent.mm.sdk.c.a.nhr.z(jbVar);
            if (jbVar.bjC.ret != -1) {
                ltx.setVisibility(8);
                d dVar = (d) b.luG.get(str3);
                v.d("MicroMsg.GetLocationInfoThumb", "wenote location thumb update with WNNoteWebViewLogic.mInitWNNoteWebViewID");
                if (!be.kS(dVar.ltX)) {
                    jb jbVar2 = new jb();
                    jbVar2.bjB.type = 1;
                    jbVar2.bjB.bjt = dVar.ltX;
                    jbVar2.bjB.bjG = str6;
                    com.tencent.mm.sdk.c.a.nhr.z(jbVar2);
                }
            }
        }
    }

    private static boolean FM(String str) {
        return (str == null || str.equals("")) ? false : true;
    }
}
