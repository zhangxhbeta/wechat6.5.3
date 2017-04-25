package com.tencent.mm.ui.contact;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.ay.c;
import com.tencent.mm.model.ak;
import com.tencent.mm.modelbiz.u;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.d;
import com.tencent.mm.u.n;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MaskLayout;

public class BizContactEntranceView extends RelativeLayout {
    private View eYG = null;
    private Context mContext;
    private View oFa;
    private TextView oFb;
    private boolean oFc = true;
    private boolean oFd;

    public BizContactEntranceView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        init();
        bHq();
    }

    public BizContactEntranceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        init();
        bHq();
    }

    public BizContactEntranceView(Context context) {
        super(context);
        this.mContext = context;
        init();
        bHq();
    }

    private void init() {
        this.oFd = false;
        View.inflate(getContext(), 2130903181, this);
        this.eYG = findViewById(2131755326);
        this.oFa = this.eYG.findViewById(2131755636);
        this.eYG.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ BizContactEntranceView oFe;

            {
                this.oFe = r1;
            }

            public final void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("intent_service_type", 251658241);
                c.b(view.getContext(), "brandservice", ".ui.BrandServiceIndexUI", intent);
            }
        });
        this.oFa.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ BizContactEntranceView oFe;

            {
                this.oFe = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (this.oFe.mContext instanceof MMActivity) {
                    ((MMActivity) this.oFe.mContext).axg();
                }
                return false;
            }
        });
        MaskLayout maskLayout = (MaskLayout) this.oFa.findViewById(2131755637);
        ImageView imageView = (ImageView) maskLayout.view;
        n.AX();
        imageView.setImageBitmap(d.gK("service_officialaccounts"));
        this.oFb = (TextView) maskLayout.findViewById(2131755330);
    }

    final void bHq() {
        long currentTimeMillis = System.currentTimeMillis();
        ak.yW();
        if (com.tencent.mm.model.c.wH().bvy() > 0) {
            this.oFc = true;
        } else {
            this.oFc = false;
        }
        this.oFa.setVisibility(this.oFc ? 0 : 8);
        if (this.oFc) {
            ak.vA().x(new Runnable(this) {
                final /* synthetic */ BizContactEntranceView oFe;

                {
                    this.oFe = r1;
                }

                public final void run() {
                    long j = 0;
                    com.tencent.mm.modelbiz.d Dy = u.Dy();
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("select updateTime from BizInfo").append(" where type = 1");
                    stringBuilder.append(" and status = 1").append(" ORDER BY updateTime DESC");
                    v.i("MicroMsg.BizInfoStorage", "getLastNewBizUpdateTime, sql %s", stringBuilder.toString());
                    Cursor rawQuery = Dy.rawQuery(r1, new String[0]);
                    if (rawQuery != null) {
                        if (rawQuery.moveToFirst()) {
                            j = rawQuery.getLong(0);
                            rawQuery.close();
                        } else {
                            rawQuery.close();
                        }
                    }
                    ak.yW();
                    final long bf = be.bf(com.tencent.mm.model.c.vf().get(233473, null));
                    v.i("MicroMsg.BizContactEntranceView", "last updateTime %d, enterTime %d", Long.valueOf(j), Long.valueOf(bf));
                    ad.o(new Runnable(this) {
                        final /* synthetic */ AnonymousClass3 oFh;

                        public final void run() {
                            TextView c = this.oFh.oFe.oFb;
                            int i = (!this.oFh.oFe.oFd || j <= bf) ? 4 : 0;
                            c.setVisibility(i);
                        }
                    });
                }
            });
        }
        v.i("MicroMsg.BizContactEntranceView", "biz contact Count %d, isEntranceShow %s, setStatus cost %d", Integer.valueOf(r4), Boolean.valueOf(this.oFc), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
    }

    public final void setVisible(boolean z) {
        int i = 0;
        v.i("MicroMsg.BizContactEntranceView", "setVisible visible = %s, isEntranceShow = %s", Boolean.valueOf(z), Boolean.valueOf(this.oFc));
        View view = this.eYG;
        if (!(z && this.oFc)) {
            i = 8;
        }
        view.setVisibility(i);
    }
}
