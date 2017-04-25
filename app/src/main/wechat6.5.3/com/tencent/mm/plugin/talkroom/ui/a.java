package com.tencent.mm.plugin.talkroom.ui;

import android.content.Context;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.base.o;

public final class a {
    private static final int[] ewE = new int[]{0, 15, 30, 45, 60, 75, 90, 100};
    private static final int[] ewF = new int[]{2130837628, 2130837629, 2130837630, 2130837631, 2130837632, 2130837633, 2130837634};
    private Context context;
    private ImageView ewN;
    private final ac exe = new ac(this) {
        final /* synthetic */ a klw;

        {
            this.klw = r1;
        }

        public final void handleMessage(Message message) {
            super.handleMessage(message);
            this.klw.klr.dismiss();
        }
    };
    private View fTc;
    private View fTd;
    private View fTf;
    private o klr;
    private TextView kls;
    private ImageView klt;
    private View klu;
    private int klv;

    public a(Context context) {
        this.context = context;
        this.klv = b.a(context, 180.0f);
        this.klr = new o(((LayoutInflater) context.getSystemService("layout_inflater")).inflate(2130904588, null), -1, -2);
        this.ewN = (ImageView) this.klr.getContentView().findViewById(2131756976);
        this.fTf = this.klr.getContentView().findViewById(2131756978);
        this.kls = (TextView) this.klr.getContentView().findViewById(2131756980);
        this.klt = (ImageView) this.klr.getContentView().findViewById(2131756979);
        this.klu = this.klr.getContentView().findViewById(2131759671);
        this.fTc = this.klr.getContentView().findViewById(2131756973);
        this.fTd = this.klr.getContentView().findViewById(2131756981);
    }
}
