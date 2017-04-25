package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.game.c.af;
import com.tencent.mm.plugin.game.c.au;
import com.tencent.mm.plugin.game.c.n;
import com.tencent.mm.plugin.game.c.n.c;
import com.tencent.mm.plugin.game.c.o;
import com.tencent.mm.plugin.game.c.q;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;

public class GameMessageBubbleView extends LinearLayout implements OnClickListener {
    View gvS;
    private TextView gvT;
    private ImageView gvU;
    private n gvV;
    private boolean gvW = false;
    private final long gvX = 500;
    private long gvY = 0;
    private Context mContext;

    public GameMessageBubbleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        if (!this.gvW) {
            this.gvU = (ImageView) findViewById(2131757197);
            this.gvT = (TextView) findViewById(2131757198);
            this.gvS = findViewById(2131757196);
            setVisibility(8);
            this.gvW = true;
        }
    }

    public final void asx() {
        au.asd();
        this.gvV = q.aru();
        if (this.gvV == null) {
            this.gvS.setOnClickListener(null);
            setVisibility(8);
            return;
        }
        this.gvV.arp();
        if (this.gvV.field_msgType == 100 && (be.kS(this.gvV.gip.can) || be.kS(this.gvV.gip.giY) || be.kS(this.gvV.gip.giZ) || !this.gvV.giq.containsKey(this.gvV.gip.giZ))) {
            v.w("MicroMsg.GameMessageHeaderView", "bubble is invalid");
            this.gvS.setOnClickListener(null);
            setVisibility(8);
            return;
        }
        this.gvT.setText(this.gvV.gip.can);
        com.tencent.mm.ae.n.GL().a(this.gvV.gip.giY, this.gvU);
        this.gvS.setOnClickListener(this);
        setVisibility(0);
    }

    public void onClick(View view) {
        if (System.currentTimeMillis() - this.gvY > 500 && this.gvV != null) {
            au.asd();
            q.arv();
            int a;
            if (this.gvV.field_msgType == 100) {
                if (!be.kS(this.gvV.gip.giZ)) {
                    c cVar = (c) this.gvV.giq.get(this.gvV.gip.giZ);
                    if (cVar != null) {
                        a = o.a(this.mContext, this.gvV, cVar, this.gvV.field_appId, 1007);
                        if (a != 0) {
                            af.a(this.mContext, 10, 1007, 1, a, 0, this.gvV.field_appId, 0, this.gvV.giT, this.gvV.field_gameMsgId, this.gvV.giU, null);
                        }
                        if (cVar.gjb != 4) {
                            this.gvV.field_isRead = true;
                            au.asc().a(this.gvV, new String[0]);
                        }
                    }
                }
                this.gvY = System.currentTimeMillis();
                return;
            }
            if (!(this.gvV == null || this.gvV.gis == 3)) {
                this.gvV.field_isRead = true;
                au.asc().a(this.gvV, new String[0]);
            }
            switch (this.gvV.gis) {
                case 1:
                    String str = this.gvV.gie;
                    if (!be.kS(str)) {
                        com.tencent.mm.plugin.game.e.c.n(this.mContext, str, "game_center_bubble");
                    }
                    a = 7;
                    break;
                case 2:
                    if (!be.kS(this.gvV.field_appId)) {
                        Bundle bundle = new Bundle();
                        bundle.putCharSequence("game_app_id", this.gvV.field_appId);
                        bundle.putInt("game_report_from_scene", 1007);
                        a = com.tencent.mm.plugin.game.e.c.a(this.mContext, this.gvV.field_appId, null, bundle);
                        break;
                    }
                    v.e("MicroMsg.GameMessageHeaderView", "message type : " + this.gvV.field_msgType + " ,message.field_appId is null.");
                    a = 0;
                    break;
                case 3:
                    Intent intent = new Intent(this.mContext, GameMessageUI.class);
                    intent.putExtra("game_report_from_scene", 1007);
                    this.mContext.startActivity(intent);
                    a = 6;
                    break;
                default:
                    v.e("MicroMsg.GameMessageHeaderView", "unknown bubble_action = " + this.gvV.gis);
                    return;
            }
            af.a(this.mContext, 10, 1007, 1, a, 0, this.gvV.field_appId, 0, this.gvV.field_msgType, this.gvV.field_gameMsgId, this.gvV.giU, null);
            this.gvY = System.currentTimeMillis();
        }
    }
}
