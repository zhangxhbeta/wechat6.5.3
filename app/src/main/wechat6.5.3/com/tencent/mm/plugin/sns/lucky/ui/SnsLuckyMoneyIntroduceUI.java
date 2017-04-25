package com.tencent.mm.plugin.sns.lucky.ui;

import android.annotation.TargetApi;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.gmtrace.Constants;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.sns.g.h;
import com.tencent.mm.plugin.sns.g.i;
import com.tencent.mm.plugin.sns.lucky.b.o;
import com.tencent.mm.pluginsdk.k.a.a.b.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Iterator;

@a(3)
public class SnsLuckyMoneyIntroduceUI extends MMActivity implements e {
    private int aYo = 30;
    protected p dwg = null;
    private ImageView jgu;
    private int jgv = Constants.THREAD_BITSET_SIZE;

    public void onDestroy() {
        super.onDestroy();
        ak.vy().b(218, this);
    }

    @TargetApi(17)
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ak.vy().a(218, this);
        o aRh = o.aRh();
        getWindow().setFlags(1024, 1024);
        Fd("");
        this.nDR.bAj();
        t.a aVar = t.a.nrV;
        String str = aRh.jeW;
        i f = com.tencent.mm.plugin.sns.lucky.b.t.f(aVar);
        Iterator it = f.jqC.iterator();
        Object obj = null;
        while (it.hasNext()) {
            Object obj2;
            h hVar = (h) it.next();
            if (str.equals(hVar.iOR)) {
                hVar.state = 2;
                obj2 = 1;
            } else {
                obj2 = obj;
            }
            obj = obj2;
        }
        if (obj == null) {
            hVar = new h();
            hVar.state = 2;
            hVar.iOR = str;
            f.jqC.add(hVar);
        }
        try {
            ak.yW();
            c.vf().a(aVar, new String(f.toByteArray(), Charset.forName("ISO-8859-1")));
        } catch (IOException e) {
            v.w("MicroMsg.RedDotUtil", "mardRedotList save exception:" + e.getLocalizedMessage());
        }
        this.jgu = (ImageView) findViewById(2131759387);
        ((TextView) findViewById(2131759388)).setText(aRh.jeD);
        ((TextView) findViewById(2131759389)).setText(aRh.jeE);
        TextView textView = (TextView) findViewById(2131759384);
        textView.setText(aRh.jeH);
        textView.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ SnsLuckyMoneyIntroduceUI jgw;

            {
                this.jgw = r1;
            }

            public final void onClick(View view) {
                ak.vy().a(new com.tencent.mm.plugin.sns.e.p(1), 0);
                SnsLuckyMoneyIntroduceUI snsLuckyMoneyIntroduceUI = this.jgw;
                SnsLuckyMoneyIntroduceUI snsLuckyMoneyIntroduceUI2 = this.jgw;
                this.jgw.getString(2131231164);
                snsLuckyMoneyIntroduceUI.dwg = g.a(snsLuckyMoneyIntroduceUI2, this.jgw.getString(2131235539), false, new OnCancelListener(this) {
                    final /* synthetic */ AnonymousClass1 jgx;

                    {
                        this.jgx = r1;
                    }

                    public final void onCancel(DialogInterface dialogInterface) {
                    }
                });
            }
        });
        textView = (TextView) findViewById(2131759385);
        textView.setText(aRh.jeG);
        textView.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ SnsLuckyMoneyIntroduceUI jgw;

            {
                this.jgw = r1;
            }

            public final void onClick(View view) {
                ak.vy().a(new com.tencent.mm.plugin.sns.e.p(0), 0);
                SnsLuckyMoneyIntroduceUI snsLuckyMoneyIntroduceUI = this.jgw;
                SnsLuckyMoneyIntroduceUI snsLuckyMoneyIntroduceUI2 = this.jgw;
                this.jgw.getString(2131231164);
                snsLuckyMoneyIntroduceUI.dwg = g.a(snsLuckyMoneyIntroduceUI2, this.jgw.getString(2131235539), false, new OnCancelListener(this) {
                    final /* synthetic */ AnonymousClass2 jgy;

                    {
                        this.jgy = r1;
                    }

                    public final void onCancel(DialogInterface dialogInterface) {
                    }
                });
            }
        });
        b.bnR();
        String cT = com.tencent.mm.pluginsdk.k.a.a.b.cT(this.aYo, this.jgv);
        if (!be.kS(cT)) {
            Bitmap c = BackwardSupportUtil.b.c(cT, com.tencent.mm.bd.a.getDensity(this.nDR.nEl));
            if (c != null && !c.isRecycled()) {
                this.jgu.setImageBitmap(c);
            }
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return true;
    }

    protected final int getLayoutId() {
        return 2130904462;
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar.getType() == 218 && ((com.tencent.mm.plugin.sns.e.p) kVar).type == 11) {
            if (this.dwg != null) {
                this.dwg.dismiss();
            }
            finish();
        }
    }
}
