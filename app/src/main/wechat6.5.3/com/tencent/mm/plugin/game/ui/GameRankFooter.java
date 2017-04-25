package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.game.ui.q.a;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.e;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.storage.u;

public class GameRankFooter extends LinearLayout {
    private boolean gvW = false;
    TextView gwC;
    private View gwD;
    private TextView gwE;
    private ImageView gwF;
    private TextView gwG;
    private TextView gwH;
    private Context mContext;

    public GameRankFooter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        init();
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        if (!this.gvW) {
            init();
            this.gvW = true;
        }
    }

    public final void asy() {
        this.gwC.setVisibility(0);
    }

    public final void asz() {
        this.gwC.setVisibility(8);
    }

    public final void a(a aVar) {
        if (this.gvW && this.gwD.getVisibility() != 0) {
            this.gwD.setVisibility(0);
            ak.yW();
            u LX = c.wH().LX(aVar.ble);
            if (LX != null) {
                b.m(this.gwF, LX.field_username);
                this.gwG.setText(e.a(this.mContext, LX.tU(), this.gwG.getTextSize()));
            }
            this.gwE.setText(aVar.gjv);
            this.gwH.setText(be.formatNumber(aVar.cWZ));
        }
    }

    public final void asA() {
        if (this.gwD != null && this.gwD.getVisibility() != 8) {
            this.gwD.setVisibility(8);
        }
    }

    private void init() {
        this.gwC = (TextView) findViewById(2131756683);
        this.gwD = findViewById(2131757358);
        this.gwE = (TextView) findViewById(2131757359);
        this.gwF = (ImageView) findViewById(2131757360);
        this.gwG = (TextView) findViewById(2131757361);
        this.gwH = (TextView) findViewById(2131757362);
    }
}
