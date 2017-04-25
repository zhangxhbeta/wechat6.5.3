package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.game.c.c;
import com.tencent.mm.plugin.game.c.i.b;
import com.tencent.mm.plugin.game.c.j;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.platformtools.v;

public class GameRankHeadView extends LinearLayout implements OnClickListener {
    TextView dID;
    b grE;
    j grG;
    TextView grc;
    c gwI;
    TextView gwJ;
    private ImageView gwK;

    public GameRankHeadView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.dID = (TextView) findViewById(2131757295);
        this.gwJ = (TextView) findViewById(2131757296);
        this.grc = (TextView) findViewById(2131757297);
        this.gwK = (ImageView) findViewById(2131757298);
        v.i("MicroMsg.GameRankHeadView", "initView finished");
    }

    final void asB() {
        if (g.a(getContext(), this.gwI)) {
            if (this.gwI.versionCode > com.tencent.mm.plugin.game.e.c.ut(this.gwI.field_packageName)) {
                this.grc.setText(2131233074);
                return;
            } else {
                this.grc.setText(2131233072);
                return;
            }
        }
        switch (this.gwI.status) {
            case 0:
                if (this.grG == null) {
                    this.grc.setVisibility(8);
                    this.gwK.setVisibility(8);
                    return;
                }
                this.grc.setVisibility(0);
                this.gwK.setVisibility(0);
                switch (this.grG.status) {
                    case 0:
                        this.grc.setText(2131233069);
                        return;
                    case 1:
                        this.grc.setText(2131233070);
                        return;
                    case 2:
                        this.grc.setText(2131233068);
                        return;
                    case 3:
                        this.grc.setText(2131233071);
                        return;
                    default:
                        return;
                }
            default:
                this.grc.setText(2131233069);
                return;
        }
    }

    public void onClick(View view) {
        new e(getContext()).a(this.gwI, new j(this.gwI));
    }
}
