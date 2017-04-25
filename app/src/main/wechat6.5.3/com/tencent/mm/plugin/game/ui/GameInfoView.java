package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.mm.plugin.game.c.af;
import com.tencent.mm.plugin.game.c.au;
import com.tencent.mm.plugin.game.c.n;
import com.tencent.mm.plugin.game.c.q;
import com.tencent.mm.plugin.game.d.bf;
import com.tencent.mm.plugin.game.d.cc;
import com.tencent.mm.plugin.game.e.c;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;

public class GameInfoView extends FrameLayout implements OnClickListener {
    private int bZj = 0;
    int gjl = 0;
    View gtA;
    TextView gtB;
    ImageView gtC;
    ImageView gtD;
    private ImageView gtE;
    private TextView gtF;
    ImageView gtG;
    ImageView gtH;
    View gtI;
    ImageView gtJ;
    TextView gtK;
    ImageView gtL;
    ImageView gtM;
    String gtN = "";
    private int gtO = 1;
    private int gtP = 2;
    private int gtQ = 3;
    int gtR = 4;
    String gtS;
    int gtT;
    int gtU;
    private OnClickListener gtV = new OnClickListener(this) {
        final /* synthetic */ GameInfoView gtY;

        {
            this.gtY = r1;
        }

        public final void onClick(View view) {
            int i = 7;
            if (view.getTag() == null || !(view.getTag() instanceof String)) {
                com.tencent.mm.plugin.game.c.a.a arc = com.tencent.mm.plugin.game.c.a.arc();
                if (arc.bkU == 2) {
                    c.n(this.gtY.mContext, arc.url, "game_center_msgcenter");
                } else {
                    Intent intent = new Intent(this.gtY.mContext, GameMessageUI.class);
                    intent.putExtra("game_report_from_scene", 1001);
                    intent.putExtra("game_unread_msg_count", this.gtY.bZj);
                    intent.putExtra("game_manage_url", this.gtY.gtN);
                    this.gtY.mContext.startActivity(intent);
                    i = 6;
                }
            } else {
                c.n(this.gtY.mContext, (String) view.getTag(), "game_center_msgcenter");
            }
            af.a(this.gtY.mContext, 10, 1001, this.gtY.gtP, i, 0, null, this.gtY.gjl, 0, null, null, af.bH("resource", "5"));
        }
    };
    private OnClickListener gtW = new OnClickListener(this) {
        final /* synthetic */ GameInfoView gtY;

        {
            this.gtY = r1;
        }

        public final void onClick(View view) {
            if (view.getTag() != null && (view.getTag() instanceof String)) {
                c.n(this.gtY.mContext, (String) view.getTag(), "game_center_giftcenter");
                au.asd();
                n arw = q.arw();
                if (arw == null) {
                    af.a(this.gtY.mContext, 10, 1001, this.gtY.gtQ, 7, 0, null, this.gtY.gjl, 0, null, null, null);
                } else {
                    String bH;
                    arw.arp();
                    if (this.gtY.gtE.getVisibility() == 0) {
                        bH = af.bH("resource", "5");
                    } else {
                        bH = af.bH("resource", "0");
                    }
                    af.a(this.gtY.mContext, 10, 1001, this.gtY.gtQ, 7, 0, arw.field_appId, this.gtY.gjl, arw.field_msgType, arw.field_gameMsgId, arw.giU, bH);
                }
                au.asd();
                q.arx();
                this.gtY.ass();
            }
        }
    };
    private OnClickListener gtX = new OnClickListener(this) {
        final /* synthetic */ GameInfoView gtY;

        {
            this.gtY = r1;
        }

        public final void onClick(View view) {
            if (view.getTag() != null && (view.getTag() instanceof String)) {
                c.n(this.gtY.mContext, (String) view.getTag(), "game_center_profile");
                af.a(this.gtY.mContext, 10, 1001, this.gtY.gtR, 7, this.gtY.gjl, this.gtY.gtS);
            }
        }
    };
    View gtx;
    TextView gty;
    ImageView gtz;
    Context mContext;

    public static class a {
        public String gjj;
        public String gtZ;
        public String gua;
        public String gub;
        public String guc;
        public String gud;
        public String gue;
        public cc guf;
        public bf gug;
        public String guh;
        public String gui;
        public String guj;
    }

    public GameInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.gtI = findViewById(2131757209);
        this.gtI.setOnClickListener(this.gtX);
        this.gtJ = (ImageView) findViewById(2131755383);
        this.gtK = (TextView) findViewById(2131757212);
        this.gtL = (ImageView) findViewById(2131757213);
        this.gtM = (ImageView) findViewById(2131757214);
        this.gtx = findViewById(2131757215);
        this.gtx.setOnClickListener(this.gtV);
        this.gty = (TextView) findViewById(2131757219);
        this.gtz = (ImageView) findViewById(2131757217);
        this.gtA = findViewById(2131757221);
        this.gtA.setOnClickListener(this.gtW);
        this.gtB = (TextView) findViewById(2131757225);
        this.gtC = (ImageView) findViewById(2131757223);
        this.gtD = (ImageView) findViewById(2131757220);
        this.gtE = (ImageView) findViewById(2131757224);
        this.gtF = (TextView) findViewById(2131757218);
        this.gtG = (ImageView) findViewById(2131757207);
        this.gtH = (ImageView) findViewById(2131757208);
        v.i("MicroMsg.GameInfoView", "initView finished");
    }

    final int b(ImageView imageView, int i, int i2) {
        int screenWidth = c.getScreenWidth(this.mContext);
        LayoutParams layoutParams = imageView.getLayoutParams();
        if (layoutParams == null) {
            v.e("MicroMsg.GameInfoView", "resizeGameThemePic, params is null");
            return 0;
        }
        layoutParams.height = (int) (((float) screenWidth) * (((float) i) / ((float) i2)));
        imageView.setLayoutParams(layoutParams);
        imageView.setScaleType(ScaleType.FIT_XY);
        return layoutParams.height;
    }

    public final void asr() {
        this.bZj = au.asc().arA();
        if (this.bZj > 0 && this.bZj <= 99) {
            this.gtF.setVisibility(0);
            this.gtF.setText(this.bZj);
        } else if (this.bZj > 99) {
            this.gtF.setVisibility(0);
            this.gtF.setText("99+");
            this.gtF.setTextSize(1, 9.0f);
        } else {
            this.gtF.setVisibility(4);
        }
    }

    final void ass() {
        au.asd();
        if (q.arw() != null) {
            this.gtE.setVisibility(0);
        } else {
            this.gtE.setVisibility(4);
        }
    }

    public void onClick(View view) {
        if (view.getTag() != null && (view.getTag() instanceof String)) {
            String str = (String) view.getTag();
            if (!be.kS(str)) {
                c.n(this.mContext, str, "game_center_top_banner");
                af.a(this.mContext, 10, 1017, 1, 7, 0, null, this.gjl, 0, null, null, null);
            }
        }
    }
}
