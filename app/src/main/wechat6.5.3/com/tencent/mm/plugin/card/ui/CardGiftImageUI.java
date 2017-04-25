package com.tencent.mm.plugin.card.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.BaseAdapter;
import android.widget.Gallery.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.tencent.mm.platformtools.j;
import com.tencent.mm.plugin.card.model.CardGiftInfo;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.tools.MMGestureGallery;
import com.tencent.mm.ui.tools.MMGestureGallery.f;
import com.tencent.mm.ui.tools.g;
import com.tencent.mm.ui.tools.g.b;
import com.tencent.mm.ui.tools.l;

@com.tencent.mm.ui.base.a(3)
public class CardGiftImageUI extends MMActivity implements com.tencent.mm.plugin.card.b.a.a {
    private String bhr;
    private CardGiftInfo eIP;
    private ImageView eIQ;
    private RelativeLayout eIR;
    private MMGestureGallery eIS;
    private ProgressBar eIT;
    private ac eIU = new ac(Looper.getMainLooper());
    private l eIV;
    private Bundle eIW;
    private boolean eIX = false;
    private g eIY;
    private int eIZ = 0;
    private int eJa = 0;
    private int eJb = 0;
    private int eJc = 0;
    private a eJd;

    private class a extends BaseAdapter {
        final /* synthetic */ CardGiftImageUI eJe;

        private a(CardGiftImageUI cardGiftImageUI) {
            this.eJe = cardGiftImageUI;
        }

        public final int getCount() {
            return 1;
        }

        public final Object getItem(int i) {
            return null;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            Bitmap lW = j.lW(this.eJe.bhr);
            if (lW == null) {
                v.w("MicroMsg.CardGiftImageUI", "get image fail");
                if (view != null && !(view instanceof MultiTouchImageView)) {
                    return view;
                }
                view = View.inflate(viewGroup.getContext(), 2130904390, null);
                ((ImageView) view.findViewById(2131756901)).setImageResource(2131165477);
                view.setLayoutParams(new LayoutParams(-1, -1));
                return view;
            }
            Context context = viewGroup.getContext();
            if (view == null || !(view instanceof MultiTouchImageView)) {
                view = new MultiTouchImageView(context, lW.getWidth(), lW.getHeight());
            } else {
                MultiTouchImageView multiTouchImageView = (MultiTouchImageView) view;
                multiTouchImageView.di(lW.getWidth(), lW.getHeight());
            }
            view.setLayoutParams(new LayoutParams(-1, -1));
            view.setImageBitmap(lW);
            view.oad = true;
            return view;
        }
    }

    static /* synthetic */ void g(CardGiftImageUI cardGiftImageUI) {
        cardGiftImageUI.eIV = new l(cardGiftImageUI);
        cardGiftImageUI.eIV.jXn = new c(cardGiftImageUI) {
            final /* synthetic */ CardGiftImageUI eJe;

            {
                this.eJe = r1;
            }

            public final void a(com.tencent.mm.ui.base.l lVar) {
                lVar.d(0, this.eJe.getString(2131234727));
            }
        };
        cardGiftImageUI.eIV.jXo = new d(cardGiftImageUI) {
            final /* synthetic */ CardGiftImageUI eJe;

            {
                this.eJe = r1;
            }

            public final void c(MenuItem menuItem, int i) {
                switch (menuItem.getItemId()) {
                    case 0:
                        com.tencent.mm.pluginsdk.ui.tools.l.h(this.eJe.bhr, this.eJe);
                        return;
                    default:
                        return;
                }
            }
        };
    }

    public void onCreate(Bundle bundle) {
        if (getIntent().getExtras() != null) {
            getIntent().getExtras().setClassLoader(getClass().getClassLoader());
        }
        super.onCreate(bundle);
        this.nDR.bAj();
        this.eIW = bundle;
        if (VERSION.SDK_INT >= 21) {
            getWindow().setFlags(1024, 1024);
        }
        this.eIP = (CardGiftInfo) getIntent().getParcelableExtra("key_gift_into");
        String str = "MicroMsg.CardGiftImageUI";
        String str2 = "cardGiftInfo:%s";
        Object[] objArr = new Object[1];
        objArr[0] = this.eIP == null ? "null" : this.eIP.toString();
        v.d(str, str2, objArr);
        v.i("MicroMsg.CardGiftImageUI", "imgPath:%s", new Object[]{this.bhr});
        NI();
        com.tencent.mm.plugin.card.b.a.a(this);
        if (this.eIP == null || be.kS(this.eIP.eCc)) {
            v.e("MicroMsg.CardGiftImageUI", "fromUserContentPicUrl is null");
        } else {
            com.tencent.mm.plugin.card.b.a.c(this.eIP.eCc, this.eIP.eCf, this.eIP.eCo, 2);
        }
    }

    protected final void NI() {
        this.eIQ = (ImageView) findViewById(2131755841);
        this.eIQ.setLayerType(2, null);
        this.eIT = (ProgressBar) findViewById(2131755844);
        this.eIR = (RelativeLayout) findViewById(2131755842);
        this.eIS = (MMGestureGallery) findViewById(2131755843);
        this.eIS.setVerticalFadingEdgeEnabled(false);
        this.eIS.setHorizontalFadingEdgeEnabled(false);
        this.eJd = new a();
        this.eIS.setAdapter(this.eJd);
        this.eIS.oTm = new f(this) {
            final /* synthetic */ CardGiftImageUI eJe;

            {
                this.eJe = r1;
            }

            public final void abF() {
                this.eJe.abE();
            }
        };
        this.eIS.setOnItemLongClickListener(new OnItemLongClickListener(this) {
            final /* synthetic */ CardGiftImageUI eJe;

            {
                this.eJe = r1;
            }

            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                com.tencent.mm.ui.base.g.a(this.eJe, this.eJe.eIV.aXZ());
                return true;
            }
        });
        this.eIY = new g(this);
    }

    public void onStart() {
        Bundle bundle = this.eIW;
        if (!this.eIX) {
            this.eIX = true;
            if (VERSION.SDK_INT < 12) {
                v.e("MicroMsg.CardGiftImageUI", "version is %d, no animation", new Object[]{Integer.valueOf(VERSION.SDK_INT)});
            } else {
                this.eIZ = getIntent().getIntExtra("img_top", 0);
                this.eJa = getIntent().getIntExtra("img_left", 0);
                this.eJb = getIntent().getIntExtra("img_width", 0);
                this.eJc = getIntent().getIntExtra("img_height", 0);
                this.eIY.m(this.eJa, this.eIZ, this.eJb, this.eJc);
                if (bundle == null) {
                    this.eIR.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener(this) {
                        final /* synthetic */ CardGiftImageUI eJe;

                        {
                            this.eJe = r1;
                        }

                        public final boolean onPreDraw() {
                            this.eJe.eIR.getViewTreeObserver().removeOnPreDrawListener(this);
                            this.eJe.eIY.a(this.eJe.eIR, this.eJe.eIQ, null);
                            return true;
                        }
                    });
                }
            }
        }
        super.onStart();
    }

    protected void onResume() {
        super.onResume();
        if (this.eJd != null) {
            this.eJd.notifyDataSetChanged();
        }
    }

    protected void onPause() {
        super.onPause();
    }

    protected void onDestroy() {
        super.onDestroy();
        com.tencent.mm.plugin.card.b.a.b(this);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4 || keyEvent.getAction() != 0) {
            return super.dispatchKeyEvent(keyEvent);
        }
        v.d("MicroMsg.CardGiftImageUI", "dispatchKeyEvent");
        abE();
        return true;
    }

    public final void abE() {
        this.eIY.m(this.eJa, this.eIZ, this.eJb, this.eJc);
        this.eIY.a(this.eIR, this.eIQ, new b(this) {
            final /* synthetic */ CardGiftImageUI eJe;

            {
                this.eJe = r1;
            }

            public final void onAnimationStart() {
            }

            public final void onAnimationEnd() {
                new ac().post(new Runnable(this) {
                    final /* synthetic */ AnonymousClass6 eJf;

                    {
                        this.eJf = r1;
                    }

                    public final void run() {
                        this.eJf.eJe.finish();
                        this.eJf.eJe.overridePendingTransition(0, 0);
                    }
                });
            }
        }, null);
    }

    protected final int getLayoutId() {
        return 2130903221;
    }

    public final void ak(String str, int i) {
        this.eIU.post(new Runnable(this) {
            final /* synthetic */ CardGiftImageUI eJe;

            {
                this.eJe = r1;
            }

            public final void run() {
                if (this.eJe.eIT.getVisibility() != 0) {
                    this.eJe.eIT.setVisibility(0);
                }
            }
        });
    }

    public final void bj(String str, final String str2) {
        this.eIU.post(new Runnable(this) {
            final /* synthetic */ CardGiftImageUI eJe;

            public final void run() {
                if (this.eJe.eIT.getVisibility() != 8) {
                    this.eJe.eIT.setVisibility(8);
                }
                this.eJe.bhr = str2;
                CardGiftImageUI.g(this.eJe);
                this.eJe.eJd.notifyDataSetChanged();
            }
        });
    }
}
