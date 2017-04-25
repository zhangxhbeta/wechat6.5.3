package com.tencent.mm.plugin.card.ui;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.a.e;
import com.tencent.mm.ae.a.a.c;
import com.tencent.mm.ae.n;
import com.tencent.mm.as.p;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.card.model.CardGiftInfo;
import com.tencent.mm.plugin.card.model.i;
import com.tencent.mm.pluginsdk.ui.tools.VideoTextureView;
import com.tencent.mm.pluginsdk.ui.tools.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.tools.g.b;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.tmassistantsdk.logreport.BaseReportManager;

@a(3)
public class CardGiftVideoUI extends MMActivity implements com.tencent.mm.plugin.card.b.a.a, g.a {
    private String bou;
    int duration = 0;
    private CardGiftInfo eIP;
    private ImageView eIQ;
    private ProgressBar eIT;
    private ac eIU = new ac(Looper.getMainLooper());
    private Bundle eIW;
    private boolean eIX = false;
    private com.tencent.mm.ui.tools.g eIY;
    private int eIZ = 0;
    private RelativeLayout eJA;
    private ImageView eJB;
    TextView eJC;
    private MMPinProgressBtn eJD;
    private TextView eJE;
    private ah eJF = new ah(new ah.a(this) {
        final /* synthetic */ CardGiftVideoUI eJG;

        {
            this.eJG = r1;
        }

        public final boolean oU() {
            if (this.eJG.eJz.isPlaying()) {
                CardGiftVideoUI cardGiftVideoUI = this.eJG;
                int currentPosition = this.eJG.eJz.getCurrentPosition() / BaseReportManager.MAX_READ_COUNT;
                if (cardGiftVideoUI.eJC != null && cardGiftVideoUI.duration > 0) {
                    currentPosition = cardGiftVideoUI.duration - currentPosition;
                    if (currentPosition < 0) {
                        currentPosition = 0;
                    }
                    cardGiftVideoUI.eJC.setText(currentPosition + "\"");
                }
            }
            return true;
        }
    }, true);
    private int eJa = 0;
    private int eJb = 0;
    private int eJc = 0;
    private boolean eJx;
    private RelativeLayout eJy;
    private g eJz;
    private l eyZ;

    class AnonymousClass11 implements Runnable {
        final /* synthetic */ CardGiftVideoUI eJG;
        final /* synthetic */ boolean eJI = true;

        AnonymousClass11(CardGiftVideoUI cardGiftVideoUI, boolean z) {
            this.eJG = cardGiftVideoUI;
        }

        public final void run() {
            v.i("MicroMsg.CardGiftVideoUI", "%d switch video model isVideoPlay %b", new Object[]{Integer.valueOf(this.eJG.hashCode()), Boolean.valueOf(this.eJI)});
            if (this.eJI) {
                ((View) this.eJG.eJz).setVisibility(0);
                this.eJG.eJB.setVisibility(8);
                return;
            }
            ((View) this.eJG.eJz).setVisibility(8);
            this.eJG.eJB.setVisibility(0);
        }
    }

    class AnonymousClass2 implements Runnable {
        final /* synthetic */ int cFI;
        final /* synthetic */ int cNh = 100;
        final /* synthetic */ CardGiftVideoUI eJG;

        AnonymousClass2(CardGiftVideoUI cardGiftVideoUI, int i, int i2) {
            this.eJG = cardGiftVideoUI;
            this.cFI = i2;
        }

        public final void run() {
            if (this.eJG.eJD == null) {
                return;
            }
            if (this.cNh == 0) {
                this.eJG.eJD.setVisibility(8);
                return;
            }
            if (this.eJG.eJD.getVisibility() != 0) {
                this.eJG.eJD.setVisibility(0);
            }
            v.i("MicroMsg.CardGiftVideoUI", "update progress %d %d", new Object[]{Integer.valueOf(this.cFI), Integer.valueOf(this.cNh)});
            if (this.eJG.eJD.pcv != this.cNh && this.cNh > 0) {
                this.eJG.eJD.setMax(this.cNh);
            }
            this.eJG.eJD.setProgress(this.cFI);
        }
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
        if (ak.oJ() != null) {
            ak.oJ().pU();
        }
        this.eIP = (CardGiftInfo) getIntent().getParcelableExtra("key_gift_into");
        this.bou = getIntent().getStringExtra("key_video_path");
        this.eJx = getIntent().getBooleanExtra("key_is_mute", false);
        String str = "MicroMsg.CardGiftVideoUI";
        String str2 = "cardGiftInfo %s";
        Object[] objArr = new Object[1];
        objArr[0] = this.eIP == null ? "null" : this.eIP.toString();
        v.d(str, str2, objArr);
        v.d("MicroMsg.CardGiftVideoUI", "videoPath:%s, isMute:%b", new Object[]{this.bou, Boolean.valueOf(this.eJx)});
        NI();
        com.tencent.mm.plugin.card.b.a.a(this);
        abG();
        if (this.eIP == null) {
            v.e("MicroMsg.CardGiftVideoUI", "cardGiftInfo is null");
        } else if (be.kS(this.eIP.eCd)) {
            v.e("MicroMsg.CardGiftVideoUI", "fromUserContentVideoUrl is null");
        } else {
            com.tencent.mm.plugin.card.b.a.c(this.eIP.eCe, this.eIP.eCh, this.eIP.eCq, 2);
            com.tencent.mm.plugin.card.b.a.c(this.eIP.eCd, this.eIP.eCg, this.eIP.eCp, 1);
        }
    }

    private void qj(String str) {
        if (be.kS(str)) {
            v.e("MicroMsg.CardGiftVideoUI", "the videoPath is null, fail~!!!");
            setResult(0);
            finish();
        } else if (e.aR(str)) {
            this.eJz.setVideoPath(str);
        } else {
            v.e("MicroMsg.CardGiftVideoUI", "the videoPath is %s, the file isn't exist~!!!", new Object[]{str});
            setResult(0);
            finish();
        }
    }

    private void abG() {
        if (this.eyZ == null) {
            this.eyZ = new l(this.nDR.nEl);
        }
        if (be.kS(this.bou)) {
            v.e("MicroMsg.CardGiftVideoUI", "videoPath is null");
        } else {
            this.eyZ.a((VideoTextureView) this.eJz, new OnCreateContextMenuListener(this) {
                final /* synthetic */ CardGiftVideoUI eJG;

                {
                    this.eJG = r1;
                }

                public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
                    contextMenu.add(0, 0, 0, this.eJG.getString(2131231838));
                }
            }, new d(this) {
                final /* synthetic */ CardGiftVideoUI eJG;

                {
                    this.eJG = r1;
                }

                public final void c(MenuItem menuItem, int i) {
                    switch (menuItem.getItemId()) {
                        case 0:
                            String lq = p.lq(this.eJG.bou);
                            if (be.kS(lq)) {
                                Toast.makeText(this.eJG, this.eJG.getString(2131235794), 1).show();
                                return;
                            }
                            Toast.makeText(this.eJG, this.eJG.getString(2131235795, new Object[]{lq}), 1).show();
                            com.tencent.mm.pluginsdk.ui.tools.l.c(lq, this.eJG);
                            return;
                        default:
                            return;
                    }
                }
            });
        }
    }

    protected final void NI() {
        this.eJy = (RelativeLayout) findViewById(2131755864);
        this.eJA = (RelativeLayout) findViewById(2131755866);
        this.eJB = (ImageView) findViewById(2131755865);
        this.eJC = (TextView) findViewById(2131755867);
        this.eJD = (MMPinProgressBtn) findViewById(2131755868);
        this.eIT = (ProgressBar) findViewById(2131755870);
        this.eJE = (TextView) findViewById(2131755871);
        this.eJz = new VideoTextureView(this);
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(13);
        this.eJz.dJ(this.eJx);
        this.eJz.a(this);
        this.eJA.addView((View) this.eJz, layoutParams);
        this.eIQ = (ImageView) findViewById(2131755841);
        this.eIQ.setLayerType(2, null);
        this.eJy.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ CardGiftVideoUI eJG;

            {
                this.eJG = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                this.eJG.abE();
                return true;
            }
        });
        ((View) this.eJz).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ CardGiftVideoUI eJG;

            {
                this.eJG = r1;
            }

            public final void onClick(View view) {
                this.eJG.abE();
            }
        });
        this.eIY = new com.tencent.mm.ui.tools.g(this);
    }

    public void onStart() {
        Bundle bundle = this.eIW;
        if (!this.eIX) {
            this.eIX = true;
            if (VERSION.SDK_INT < 12) {
                v.e("MicroMsg.CardGiftVideoUI", "version is %d, no animation", new Object[]{Integer.valueOf(VERSION.SDK_INT)});
            } else {
                this.eIZ = getIntent().getIntExtra("img_top", 0);
                this.eJa = getIntent().getIntExtra("img_left", 0);
                this.eJb = getIntent().getIntExtra("img_width", 0);
                this.eJc = getIntent().getIntExtra("img_height", 0);
                this.eIY.m(this.eJa, this.eIZ, this.eJb, this.eJc);
                if (bundle == null) {
                    this.eJy.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener(this) {
                        final /* synthetic */ CardGiftVideoUI eJG;

                        {
                            this.eJG = r1;
                        }

                        public final boolean onPreDraw() {
                            this.eJG.eJy.getViewTreeObserver().removeOnPreDrawListener(this);
                            this.eJG.eIY.a(this.eJG.eJy, this.eJG.eIQ, null);
                            return true;
                        }
                    });
                }
            }
        }
        super.onStart();
    }

    protected void onResume() {
        if (!be.kS(this.bou)) {
            qj(this.bou);
        }
        super.onResume();
    }

    protected void onPause() {
        this.eJz.pause();
        super.onPause();
    }

    protected void onDestroy() {
        this.eJz.stop();
        this.eJF.QI();
        com.tencent.mm.plugin.card.b.a.b(this);
        super.onDestroy();
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4 || keyEvent.getAction() != 0) {
            return super.dispatchKeyEvent(keyEvent);
        }
        v.d("MicroMsg.CardGiftVideoUI", "dispatchKeyEvent");
        abE();
        return true;
    }

    public final void abE() {
        this.eIY.m(this.eJa, this.eIZ, this.eJb, this.eJc);
        this.eIY.a(this.eJy, this.eIQ, new b(this) {
            final /* synthetic */ CardGiftVideoUI eJG;

            {
                this.eJG = r1;
            }

            public final void onAnimationStart() {
            }

            public final void onAnimationEnd() {
                new ac().post(new Runnable(this) {
                    final /* synthetic */ AnonymousClass9 eJH;

                    {
                        this.eJH = r1;
                    }

                    public final void run() {
                        this.eJH.eJG.finish();
                        this.eJH.eJG.overridePendingTransition(0, 0);
                    }
                });
            }
        }, null);
    }

    protected final int getLayoutId() {
        return 2130903223;
    }

    public final void bp(int i, int i2) {
        setResult(0);
        this.eJz.stop();
        v.e("MicroMsg.CardGiftVideoUI", "%d on play video error what %d extra %d.", new Object[]{Integer.valueOf(hashCode()), Integer.valueOf(i), Integer.valueOf(i2)});
    }

    public final void abH() {
        setResult(-1);
        this.eIU.post(new AnonymousClass11(this, true));
        this.eIU.post(new Runnable(this) {
            final /* synthetic */ CardGiftVideoUI eJG;

            {
                this.eJG = r1;
            }

            public final void run() {
                v.d("MicroMsg.CardGiftVideoUI", "hide loading.");
                if (!(this.eJG.eIT == null || this.eJG.eIT.getVisibility() == 8)) {
                    this.eJG.eIT.setVisibility(8);
                }
                if (this.eJG.eJD != null && this.eJG.eJD.getVisibility() != 8) {
                    this.eJG.eJD.setVisibility(8);
                }
            }
        });
        this.eJz.start();
        this.duration = this.eJz.getDuration() / BaseReportManager.MAX_READ_COUNT;
        this.eJF.ea(500);
        v.i("MicroMsg.CardGiftVideoUI", "onPrepared videoView.start duration:%d", new Object[]{Integer.valueOf(this.duration)});
    }

    public final void pa() {
        v.i("MicroMsg.CardGiftVideoUI", "%d on completion", new Object[]{Integer.valueOf(hashCode())});
        this.eJz.i(0.0d);
    }

    public final int bq(int i, int i2) {
        return 0;
    }

    public final void br(int i, int i2) {
    }

    public final void ak(String str, int i) {
        if (str.equals(this.eIP.eCd)) {
            this.eIU.post(new AnonymousClass2(this, 100, i));
        }
    }

    public final void bj(String str, final String str2) {
        if (str.equals(this.eIP.eCd)) {
            this.eIU.post(new Runnable(this) {
                final /* synthetic */ CardGiftVideoUI eJG;

                public final void run() {
                    this.eJG.eJB.setVisibility(8);
                    this.eJG.bou = str2;
                    this.eJG.qj(this.eJG.bou);
                    this.eJG.abG();
                }
            });
        } else if (str.equals(this.eIP.eCe)) {
            this.eIU.post(new Runnable(this) {
                final /* synthetic */ CardGiftVideoUI eJG;

                public final void run() {
                    if (be.kS(this.eJG.bou)) {
                        this.eJG.eJB.setVisibility(0);
                        c.a aVar = new c.a();
                        aVar.cPv = com.tencent.mm.compatible.util.e.cnj;
                        n.GM();
                        aVar.cPN = null;
                        aVar.cPu = i.pR(str2);
                        aVar.cPx = 1;
                        aVar.cPs = true;
                        aVar.cPq = true;
                        n.GL().a(str2, this.eJG.eJB, aVar.GU());
                    }
                }
            });
        } else {
            v.i("MicroMsg.CardGiftVideoUI", "fieldId:%s is unsuitable", new Object[]{str});
        }
    }
}
