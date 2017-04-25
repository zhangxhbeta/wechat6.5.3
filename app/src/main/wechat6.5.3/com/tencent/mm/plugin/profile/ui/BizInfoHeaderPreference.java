package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.model.m;
import com.tencent.mm.modelbiz.BizInfo;
import com.tencent.mm.modelbiz.j;
import com.tencent.mm.modelbiz.j.a.a;
import com.tencent.mm.pluginsdk.ui.d.e;
import com.tencent.mm.pluginsdk.ui.f;
import com.tencent.mm.sdk.h.j.b;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.u;
import com.tencent.mm.u.d;
import com.tencent.mm.u.n;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;

public class BizInfoHeaderPreference extends Preference implements a, b, d.a {
    private MMActivity aWn;
    u euW;
    BizInfo exj;
    private boolean fyL = false;
    private ImageView hTO;
    private ImageView hTP;
    private View hTQ;
    private TextView hTR;
    String hTS;
    private TextView hfz;

    public BizInfoHeaderPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aWn = (MMActivity) context;
        this.fyL = false;
    }

    public BizInfoHeaderPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aWn = (MMActivity) context;
        this.fyL = false;
    }

    public final void onBindView(View view) {
        v.d("MicroMsg.BizInfoHeaderPreference", "onBindView");
        this.hfz = (TextView) view.findViewById(2131755445);
        this.hTR = (TextView) view.findViewById(2131756460);
        this.hTP = (ImageView) view.findViewById(2131756461);
        this.hTO = (ImageView) view.findViewById(2131755444);
        this.hTQ = view.findViewById(2131756459);
        this.fyL = true;
        NI();
        super.onBindView(view);
    }

    private boolean aGC() {
        return this.fyL && this.euW != null;
    }

    final void NI() {
        if (aGC()) {
            Bitmap b;
            this.hfz.setText(e.a(this.aWn, be.ma(this.euW.tT()) + " ", this.hfz.getTextSize()));
            if (this.exj == null) {
                this.exj = com.tencent.mm.modelbiz.e.hw(this.euW.field_username);
            }
            if (this.exj != null) {
                this.hTS = this.exj.field_brandIconURL;
                b = j.b(this.exj.field_username, this.exj.field_brandIconURL, 2130838793);
            } else {
                b = com.tencent.mm.u.b.a(this.euW.field_username, true, -1);
                if (!(b == null || b.isRecycled())) {
                    b = com.tencent.mm.sdk.platformtools.d.a(b, false, (float) (b.getWidth() / 2));
                }
                if (b == null && !TextUtils.isEmpty(this.hTS)) {
                    b = j.b(this.euW.field_username, this.hTS, 2130838793);
                }
            }
            if (b == null) {
                b = BitmapFactory.decodeResource(this.aWn.getResources(), 2130837790);
            }
            if (!(b == null || b.isRecycled())) {
                this.hTO.setImageBitmap(b);
            }
            this.hTO.setTag(this.euW.field_username);
            this.hTQ.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ BizInfoHeaderPreference hTT;

                {
                    this.hTT = r1;
                }

                public final void onClick(View view) {
                    new f(this.hTT.aWn, this.hTT.euW.field_username, this.hTT.hTS).boy();
                }
            });
            if (!com.tencent.mm.i.a.ei(this.euW.field_type)) {
                this.hTR.setVisibility(8);
            } else if (!be.kS(this.euW.pD())) {
                this.hTR.setVisibility(0);
                this.hTR.setText(this.mContext.getString(2131231058) + this.euW.pD());
            } else if (u.LL(this.euW.field_username) || m.eB(this.euW.field_username)) {
                this.hTR.setVisibility(8);
            } else {
                this.hTR.setText(this.mContext.getString(2131231058) + be.ma(this.euW.tV()));
                this.hTR.setVisibility(0);
            }
            if (this.euW.tL()) {
                this.hTP.setVisibility(0);
                return;
            } else {
                this.hTP.setVisibility(8);
                return;
            }
        }
        v.w("MicroMsg.BizInfoHeaderPreference", "initView : bindView = " + this.fyL + "contact = " + this.euW);
    }

    public final void onDetach() {
        ak.yW();
        c.wH().b(this);
        n.AX().e(this);
        com.tencent.mm.modelbiz.u.DG().b(this);
    }

    public final void gM(String str) {
        if (!aGC()) {
            v.e("MicroMsg.BizInfoHeaderPreference", "initView : bindView = " + this.fyL + "contact = " + this.euW);
        } else if (be.ma(str).length() <= 0) {
            v.e("MicroMsg.BizInfoHeaderPreference", "notifyChanged: user = " + str);
        } else if (str.equals(this.euW.field_username)) {
            NI();
        }
    }

    public final void a(int i, com.tencent.mm.sdk.h.j jVar, Object obj) {
        if (obj == null || !(obj instanceof String)) {
            v.d("MicroMsg.BizInfoHeaderPreference", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[]{Integer.valueOf(i), jVar, obj});
        } else if (aGC()) {
            String str = (String) obj;
            if (be.ma(str).length() > 0 && this.euW != null && this.euW.field_username.equals(str)) {
                ak.yW();
                this.euW = c.wH().LX(str);
            }
        } else {
            v.e("MicroMsg.BizInfoHeaderPreference", "initView : bindView = " + this.fyL + "contact = " + this.euW);
        }
    }

    public final void hO(String str) {
        if (this.euW != null && str != null && str.equals(this.euW.field_username)) {
            NI();
        }
    }
}
