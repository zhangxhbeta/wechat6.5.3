package com.tencent.mm.ui.contact;

import android.content.Context;
import android.content.Intent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.ay.c;
import com.tencent.mm.e.b.ab;
import com.tencent.mm.model.ab.a;
import com.tencent.mm.model.ak;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MaskLayout;

public final class j extends LinearLayout {
    private String cBj;
    private Context context;

    public j(Context context, String str) {
        super(context);
        this.context = context;
        this.cBj = str;
        View inflate = View.inflate(getContext(), 2130903523, this);
        View findViewById = findViewById(2131756762);
        inflate.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ j oGu;

            {
                this.oGu = r1;
            }

            public final void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("enterprise_from_scene", 2);
                intent.putExtra("enterprise_biz_name", this.oGu.cBj);
                c.b(view.getContext(), "brandservice", ".ui.EnterpriseBizContactListUI", intent);
            }
        });
        findViewById.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ j oGu;

            {
                this.oGu = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (this.oGu.context instanceof MMActivity) {
                    ((MMActivity) this.oGu.context).axg();
                }
                return false;
            }
        });
        ak.yW();
        ab LV = com.tencent.mm.model.c.wH().LV(this.cBj);
        if (LV == null || ((int) LV.chr) <= 0) {
            v.e("MicroMsg.EnterpriseBizViewItem", "contact is null, %s", this.cBj);
            return;
        }
        MaskLayout maskLayout = (MaskLayout) findViewById.findViewById(2131755637);
        b.m((ImageView) maskLayout.view, this.cBj);
        if (LV.field_verifyFlag == 0) {
            maskLayout.bCL();
        } else if (a.csb != null) {
            String eJ = a.csb.eJ(LV.field_verifyFlag);
            if (eJ != null) {
                maskLayout.d(com.tencent.mm.modelbiz.j.hL(eJ), MaskLayout.a.nZN);
            } else {
                maskLayout.bCL();
            }
        } else {
            maskLayout.bCL();
        }
        ((TextView) findViewById(2131756763)).setText(LV.tT());
    }
}
