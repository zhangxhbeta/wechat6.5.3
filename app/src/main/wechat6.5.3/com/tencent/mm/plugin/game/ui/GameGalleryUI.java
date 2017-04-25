package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.e;
import android.support.v4.view.t;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.tencent.mm.ae.a.c.g;
import com.tencent.mm.ae.a.d.b;
import com.tencent.mm.ae.n;
import com.tencent.mm.plugin.game.c.af;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMDotView;

@com.tencent.mm.ui.base.a(19)
public class GameGalleryUI extends MMActivity implements e {
    private String appId = "";
    private int dzy = -1;
    private MMDotView fjs;
    private ViewPager fjt;
    private int gsN = 0;

    private static class a extends t {
        private String[] gsO = new String[0];
        private View[] gsP;
        Context mContext;

        public a(Context context, String[] strArr) {
            this.mContext = context;
            if (strArr != null) {
                this.gsO = strArr;
            }
            this.gsP = new View[this.gsO.length];
        }

        public final Object b(ViewGroup viewGroup, int i) {
            View view = this.gsP[i];
            if (view == null) {
                View inflate = View.inflate(this.mContext, 2130903720, null);
                this.gsP[i] = inflate;
                ImageView imageView = (ImageView) inflate.findViewById(2131757302);
                final ProgressBar progressBar = (ProgressBar) inflate.findViewById(2131757303);
                progressBar.setVisibility(0);
                com.tencent.mm.ae.a.a GL = n.GL();
                String str = this.gsO[i];
                com.tencent.mm.ae.a.a.c.a aVar = new com.tencent.mm.ae.a.a.c.a();
                aVar.cPr = true;
                GL.a(str, imageView, aVar.GU(), new g(this) {
                    final /* synthetic */ a gsR;

                    public final void jk(String str) {
                    }

                    public final void a(String str, View view, b bVar) {
                        ad.o(new Runnable(this) {
                            final /* synthetic */ AnonymousClass1 gsS;

                            {
                                this.gsS = r1;
                            }

                            public final void run() {
                                progressBar.setVisibility(8);
                            }
                        });
                    }
                });
                view = inflate;
            }
            viewGroup.addView(view);
            view.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ a gsR;

                {
                    this.gsR = r1;
                }

                public final void onClick(View view) {
                    ((MMActivity) this.gsR.mContext).finish();
                }
            });
            return view;
        }

        public final void a(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) obj);
        }

        public final int getCount() {
            return this.gsO.length;
        }

        public final boolean a(View view, Object obj) {
            return view == obj;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.nDR.bAj();
        this.fjt = (ViewPager) findViewById(2131757300);
        this.fjs = (MMDotView) findViewById(2131757301);
        String[] stringArrayExtra = getIntent().getStringArrayExtra("URLS");
        if (stringArrayExtra == null) {
            finish();
            return;
        }
        int intExtra = getIntent().getIntExtra("CURRENT", 0);
        if (intExtra < 0 || intExtra >= stringArrayExtra.length) {
            intExtra = 0;
        }
        this.appId = getIntent().getStringExtra("REPORT_APPID");
        this.dzy = getIntent().getIntExtra("REPORT_SCENE", -1);
        this.gsN = getIntent().getIntExtra("SOURCE_SCENE", 0);
        this.fjt.a(new a(this, stringArrayExtra));
        this.fjt.yk = this;
        this.fjt.k(intExtra, false);
        MMDotView mMDotView = this.fjs;
        mMDotView.nUK = 2130838830;
        mMDotView.nUL = 2130838835;
        this.fjs.wt(stringArrayExtra.length);
        this.fjs.wu(intExtra);
        if (intExtra == 0) {
            af.a(this, this.dzy, 1202, 1, 12, this.appId, this.gsN, null);
        }
    }

    protected final int getLayoutId() {
        return 2130903719;
    }

    public final void a(int i, float f, int i2) {
    }

    public final void W(int i) {
        this.fjs.wu(i);
        af.a(this, this.dzy, 1202, i + 1, 12, this.appId, this.gsN, null);
    }

    public final void X(int i) {
    }
}
