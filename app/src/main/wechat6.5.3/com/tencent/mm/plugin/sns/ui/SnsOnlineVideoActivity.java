package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.view.View.OnTouchListener;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.mm.ay.c;
import com.tencent.mm.e.a.no;
import com.tencent.mm.e.a.np;
import com.tencent.mm.e.a.oh;
import com.tencent.mm.e.a.pn;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.d;
import com.tencent.mm.model.m;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.e.ad;
import com.tencent.mm.plugin.sns.e.al;
import com.tencent.mm.plugin.sns.storage.k;
import com.tencent.mm.pluginsdk.j;
import com.tencent.mm.protocal.c.aib;
import com.tencent.mm.protocal.c.azr;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.tools.g;
import com.tencent.mm.ui.tools.l;
import com.tencent.tmassistantsdk.logreport.BaseReportManager;

@a(3)
public class SnsOnlineVideoActivity extends MMActivity implements d.a {
    private String bdZ;
    private String bde;
    private aib boL;
    private String cPu;
    private Bundle eIW;
    private boolean eIX = false;
    private g eIY;
    private int eIZ = 0;
    private int eJa = 0;
    private int eJb = 0;
    private int eJc = 0;
    private boolean eJx;
    private l eyZ;
    private VelocityTracker fj;
    private GestureDetector fjR;
    private float gpp = 0.0f;
    n.d hkn = new n.d(this) {
        final /* synthetic */ SnsOnlineVideoActivity jRt;

        {
            this.jRt = r1;
        }

        public final void c(MenuItem menuItem, int i) {
            boolean z = false;
            Intent intent;
            oh ohVar;
            switch (menuItem.getItemId()) {
                case 1:
                    intent = new Intent();
                    k Bq = ad.aSE().Bq(this.jRt.bde);
                    if (Bq != null) {
                        v.i("MicroMsg.SnsOnlineVideoActivity", "expose id " + Bq.aUq());
                    }
                    intent.putExtra("k_expose_msg_id", Bq == null ? Integer.valueOf(0) : Bq.aUq());
                    intent.putExtra("k_username", Bq == null ? "" : Bq.field_userName);
                    intent.putExtra("showShare", false);
                    intent.putExtra("rawUrl", String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[]{Integer.valueOf(33)}));
                    c.b(this.jRt, "webview", ".ui.tools.WebViewUI", intent);
                    return;
                case 2:
                    oh ohVar2 = new oh();
                    ohVar2.bpj.bdn = 2;
                    ohVar2.bpj.bpk = 17;
                    oh.a aVar = ohVar2.bpj;
                    if (this.jRt.scene == 0) {
                        z = true;
                    }
                    aVar.bpl = z;
                    ohVar2.bpj.bde = this.jRt.bde;
                    com.tencent.mm.sdk.c.a.nhr.z(ohVar2);
                    return;
                case 3:
                    this.jRt.jRn = true;
                    ohVar = new oh();
                    ohVar.bpj.bdn = 1;
                    ohVar.bpj.bpm = 4097;
                    ohVar.bpj.bde = this.jRt.bde;
                    com.tencent.mm.sdk.c.a.nhr.z(ohVar);
                    return;
                case 4:
                    k Bq2 = ad.aSE().Bq(this.jRt.bde);
                    if (Bq2 != null) {
                        intent = new Intent();
                        if (Bq2.aUp().mWq.mol == 15 && ((aib) Bq2.aUp().mWq.mom.get(0)) == null) {
                            v.w("MicroMsg.SnsOnlineVideoActivity", "send sight fail, mediaObj is null");
                            return;
                        }
                        intent.putExtra("exdevice_open_scene_type", 2);
                        intent.putExtra("sns_local_id", this.jRt.bde);
                        intent.putExtra("sns_send_data_ui_activity", true);
                        c.a(this.jRt, ".ui.chatting.ChattingSendDataToDeviceUI", intent);
                        return;
                    }
                    return;
                case 5:
                    ohVar = new oh();
                    ohVar.bpj.bdn = 3;
                    ohVar.bpj.bde = this.jRt.bde;
                    com.tencent.mm.sdk.c.a.nhr.z(ohVar);
                    return;
                default:
                    return;
            }
        }
    };
    private RelativeLayout hsA;
    private d iVr;
    private boolean jHw;
    private ImageView jKJ;
    private float jMj = 1.0f;
    private int jMk = 0;
    private int jMl = 0;
    private boolean jRk = true;
    private k jRl;
    private OnlineVideoView jRm;
    private boolean jRn = false;
    private float jRo = 0.0f;
    private boolean jRp = false;
    private boolean jRq = false;
    private boolean jRr = false;
    OnCreateContextMenuListener jRs = new OnCreateContextMenuListener(this) {
        final /* synthetic */ SnsOnlineVideoActivity jRt;

        {
            this.jRt = r1;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onCreateContextMenu(android.view.ContextMenu r10, android.view.View r11, android.view.ContextMenu.ContextMenuInfo r12) {
            /*
            r9 = this;
            r8 = 2;
            r0 = 1;
            r1 = 0;
            r2 = com.tencent.mm.h.j.sU();
            r3 = "SIGHTCannotTransmitForFav";
            r2 = r2.getValue(r3);
            r2 = com.tencent.mm.sdk.platformtools.be.KL(r2);
            if (r2 != 0) goto L_0x009c;
        L_0x0014:
            r2 = r9.jRt;
            r2 = r2.bdZ;
            r2 = com.tencent.mm.modelsfs.FileOp.aR(r2);
            r3 = r9.jRt;
            r3 = r3.cPu;
            r3 = com.tencent.mm.modelsfs.FileOp.aR(r3);
            r4 = "MicroMsg.SnsOnlineVideoActivity";
            r5 = "config can forward sight, thumb existed %B, video existed %B";
            r6 = new java.lang.Object[r8];
            r7 = java.lang.Boolean.valueOf(r2);
            r6[r1] = r7;
            r7 = java.lang.Boolean.valueOf(r3);
            r6[r0] = r7;
            com.tencent.mm.sdk.platformtools.v.i(r4, r5, r6);
            r4 = 3;
            r5 = r9.jRt;
            r6 = 2131235368; // 0x7f081228 float:1.8086928E38 double:1.0529701785E-314;
            r5 = r5.getString(r6);
            r10.add(r1, r4, r1, r5);
            if (r2 == 0) goto L_0x009c;
        L_0x004e:
            if (r3 == 0) goto L_0x009c;
        L_0x0050:
            r2 = "favorite";
            r2 = com.tencent.mm.ay.c.EH(r2);
            if (r2 == 0) goto L_0x0065;
        L_0x0059:
            r2 = r9.jRt;
            r3 = 2131234180; // 0x7f080d84 float:1.8084518E38 double:1.0529695916E-314;
            r2 = r2.getString(r3);
            r10.add(r1, r8, r1, r2);
        L_0x0065:
            r2 = 5;
            r3 = r9.jRt;
            r4 = 2131234728; // 0x7f080fa8 float:1.808563E38 double:1.0529698623E-314;
            r3 = r3.getString(r4);
            r10.add(r1, r2, r1, r3);
            if (r0 == 0) goto L_0x009b;
        L_0x0074:
            r0 = new com.tencent.mm.e.a.cp;
            r0.<init>();
            r2 = r0.bay;
            r3 = r9.jRt;
            r3 = r3.bde;
            r2.bap = r3;
            r2 = com.tencent.mm.sdk.c.a.nhr;
            r2.z(r0);
            r0 = r0.baz;
            r0 = r0.aZW;
            if (r0 == 0) goto L_0x009b;
        L_0x008e:
            r0 = 4;
            r2 = r9.jRt;
            r3 = 2131231834; // 0x7f08045a float:1.807976E38 double:1.0529684325E-314;
            r2 = r2.getString(r3);
            r10.add(r1, r0, r1, r2);
        L_0x009b:
            return;
        L_0x009c:
            r0 = r1;
            goto L_0x0050;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sns.ui.SnsOnlineVideoActivity.7.onCreateContextMenu(android.view.ContextMenu, android.view.View, android.view.ContextMenu$ContextMenuInfo):void");
        }
    };
    private int scene = 0;

    public void onCreate(Bundle bundle) {
        OnlineVideoView onlineVideoView;
        if (getIntent().getExtras() != null) {
            getIntent().getExtras().setClassLoader(getClass().getClassLoader());
        }
        super.onCreate(bundle);
        this.nDR.bAj();
        if (com.tencent.mm.compatible.util.d.dW(19)) {
            getWindow().setFlags(201327616, 201327616);
        } else {
            getWindow().setFlags(1024, 1024);
        }
        this.eIW = bundle;
        this.iVr = new d();
        if (ak.oJ() != null) {
            ak.oJ().pU();
        }
        this.bdZ = getIntent().getStringExtra("intent_thumbpath");
        this.bde = getIntent().getStringExtra("intent_localid");
        this.scene = getIntent().getIntExtra("intent_from_scene", -1);
        this.jHw = getIntent().getBooleanExtra("intent_ispreview", false);
        this.eJx = getIntent().getBooleanExtra("intent_ismute", false);
        v.i("MicroMsg.SnsOnlineVideoActivity", "init data get intent info finish. thumbPath %s localId %s scene %d isPreView %b isMute %b videoPath %s", new Object[]{this.bdZ, this.bde, Integer.valueOf(this.scene), Boolean.valueOf(this.jHw), Boolean.valueOf(this.eJx), getIntent().getStringExtra("intent_videopath")});
        if (this.jHw) {
            this.cPu = r0;
        } else {
            try {
                this.jRl = ad.aSE().Bq(this.bde);
                this.boL = (aib) this.jRl.aUp().mWq.mom.get(0);
                this.cPu = al.cA(ad.xh(), this.boL.gID) + i.i(this.boL);
                v.i("MicroMsg.SnsOnlineVideoActivity", "init data finish, sns info local id %s ", new Object[]{this.jRl.aUL()});
            } catch (Exception e) {
                v.e("MicroMsg.SnsOnlineVideoActivity", "init data exception " + e.toString());
            }
        }
        this.hsA = (RelativeLayout) findViewById(2131755864);
        this.jRm = (OnlineVideoView) findViewById(2131759513);
        if (this.jHw) {
            onlineVideoView = this.jRm;
            String str = this.cPu;
            String str2 = this.bdZ;
            onlineVideoView.jHx = str;
            onlineVideoView.jHw = true;
            onlineVideoView.jHz.setImageBitmap(b.c(str2, 1.0f));
            v.i("MicroMsg.OnlineVideoView", "%d set preview video %s isPreview %b ", new Object[]{Integer.valueOf(onlineVideoView.hashCode()), str, Boolean.valueOf(onlineVideoView.jHw)});
        } else {
            this.jRm.a(this.boL, this.jRl.aUL(), this.jRl.field_createTime);
        }
        onlineVideoView = this.jRm;
        onlineVideoView.eJx = this.eJx;
        onlineVideoView.jHA.dJ(onlineVideoView.eJx);
        this.jKJ = (ImageView) findViewById(2131755841);
        this.jKJ.setLayerType(2, null);
        this.hsA.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ SnsOnlineVideoActivity jRt;

            {
                this.jRt = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                this.jRt.abE();
                return true;
            }
        });
        this.fjR = new GestureDetector(this.nDR.nEl, new SimpleOnGestureListener(this) {
            final /* synthetic */ SnsOnlineVideoActivity jRt;

            {
                this.jRt = r1;
            }

            public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                float translationX = (this.jRt.jRm.getTranslationX() + motionEvent2.getX()) - motionEvent.getX();
                float translationY = (this.jRt.jRm.getTranslationY() + motionEvent2.getY()) - motionEvent.getY();
                if (Math.abs(translationX) <= ((float) this.jRt.hsA.getWidth()) && Math.abs(translationY) <= ((float) this.jRt.hsA.getHeight()) && this.jRt.jRp) {
                    this.jRt.jRm.setTranslationX(translationX);
                    this.jRt.jRm.setTranslationY(translationY);
                }
                return true;
            }

            public final void onLongPress(MotionEvent motionEvent) {
                this.jRt.jRr = true;
                super.onLongPress(motionEvent);
            }

            public final boolean onSingleTapUp(MotionEvent motionEvent) {
                this.jRt.abE();
                return super.onSingleTapUp(motionEvent);
            }
        });
        this.jRm.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ SnsOnlineVideoActivity jRt;

            {
                this.jRt = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                float f = 1.0f;
                this.jRt.fjR.onTouchEvent(motionEvent);
                if (this.jRt.fj == null) {
                    this.jRt.fj = VelocityTracker.obtain();
                }
                this.jRt.fj.addMovement(motionEvent);
                switch (motionEvent.getAction() & 255) {
                    case 0:
                        this.jRt.gpp = motionEvent.getX();
                        this.jRt.jRo = motionEvent.getY();
                        if (this.jRt.jRq) {
                            this.jRt.abG();
                            this.jRt.jRq = false;
                            break;
                        }
                        break;
                    case 1:
                        if (this.jRt.jRq) {
                            this.jRt.jRm.setPivotX((float) (this.jRt.hsA.getWidth() / 2));
                            this.jRt.jRm.setPivotY((float) (this.jRt.hsA.getHeight() / 2));
                            this.jRt.jRm.setScaleX(1.0f);
                            this.jRt.jRm.setScaleY(1.0f);
                            this.jRt.jRm.setTranslationX(0.0f);
                            this.jRt.jRm.setTranslationY(0.0f);
                            this.jRt.jKJ.setAlpha(1.0f);
                            this.jRt.jMj = 1.0f;
                            this.jRt.jRp = false;
                            this.jRt.jRr = false;
                            return true;
                        } else if (!this.jRt.jRp || this.jRt.jRr) {
                            this.jRt.jRr = false;
                            break;
                        } else {
                            this.jRt.abE();
                            this.jRt.jRr = false;
                            return true;
                        }
                        break;
                    case 2:
                        VelocityTracker e = this.jRt.fj;
                        e.computeCurrentVelocity(BaseReportManager.MAX_READ_COUNT);
                        int xVelocity = (int) e.getXVelocity();
                        int yVelocity = (int) e.getYVelocity();
                        float translationX = this.jRt.jRm.getTranslationX();
                        float translationY = this.jRt.jRm.getTranslationY();
                        this.jRt.jMk = (int) translationX;
                        this.jRt.jMl = (int) translationY;
                        v.d("MicroMsg.SnsOnlineVideoActivity", "dancy scaled:%s, tx:%s, ty:%s, vx:%s, vy:%s", new Object[]{Boolean.valueOf(this.jRt.jRp), Float.valueOf(translationX), Float.valueOf(translationY), Integer.valueOf(xVelocity), Integer.valueOf(yVelocity)});
                        if ((Math.abs(translationX) > 250.0f || Math.abs(yVelocity) <= Math.abs(xVelocity) || yVelocity <= 0 || this.jRt.jRr) && !this.jRt.jRp) {
                            this.jRt.jRp = false;
                        } else {
                            translationX = 1.0f - (translationY / ((float) this.jRt.hsA.getHeight()));
                            if (translationX <= 1.0f) {
                                f = translationX;
                            }
                            if (((yVelocity > 0 && f < this.jRt.jMj) || yVelocity < 0) && ((double) f) >= 0.5d) {
                                v.d("MicroMsg.SnsOnlineVideoActivity", "dancy scale:%s", new Object[]{Float.valueOf(f)});
                                this.jRt.jMj = f;
                                this.jRt.jRm.setPivotX((float) (this.jRt.hsA.getWidth() / 2));
                                this.jRt.jRm.setPivotY((float) (this.jRt.hsA.getHeight() / 2));
                                this.jRt.jRm.setScaleX(f);
                                this.jRt.jRm.setScaleY(f);
                                this.jRt.jRm.setTranslationY(translationY);
                                this.jRt.jKJ.setAlpha(f);
                            }
                            this.jRt.jRp = true;
                        }
                        if (translationY > 200.0f) {
                            this.jRt.jRq = false;
                        } else if (translationY > 10.0f) {
                            this.jRt.jRq = true;
                        }
                        if (translationY > 50.0f) {
                            this.jRt.jRm.setOnLongClickListener(null);
                        }
                        if (this.jRt.fj != null) {
                            this.jRt.fj.recycle();
                            this.jRt.fj = null;
                        }
                        if (this.jRt.jRp) {
                            return true;
                        }
                        break;
                }
                return false;
            }
        });
        this.eIY = new g(this.nDR.nEl);
        abG();
        pn pnVar = new pn();
        pnVar.bqP.type = 1;
        com.tencent.mm.sdk.c.a.nhr.z(pnVar);
    }

    protected final int getLayoutId() {
        return 2130904519;
    }

    private void abG() {
        if (this.jHw) {
            v.i("MicroMsg.SnsOnlineVideoActivity", "it is preview mode, don't register menu.");
            return;
        }
        if (this.eyZ == null) {
            this.eyZ = new l(this.nDR.nEl);
        }
        this.eyZ.a(this.jRm, this.jRs, this.hkn);
    }

    public void onStart() {
        Bundle bundle = this.eIW;
        if (!this.eIX) {
            this.eIX = true;
            if (VERSION.SDK_INT >= 12) {
                this.eIZ = getIntent().getIntExtra("img_gallery_top", 0);
                this.eJa = getIntent().getIntExtra("img_gallery_left", 0);
                this.eJb = getIntent().getIntExtra("img_gallery_width", 0);
                this.eJc = getIntent().getIntExtra("img_gallery_height", 0);
                this.eIY.m(this.eJa, this.eIZ, this.eJb, this.eJc);
                if (bundle == null) {
                    this.jRm.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener(this) {
                        final /* synthetic */ SnsOnlineVideoActivity jRt;

                        {
                            this.jRt = r1;
                        }

                        public final boolean onPreDraw() {
                            this.jRt.jRm.getViewTreeObserver().removeOnPreDrawListener(this);
                            this.jRt.eIY.a(this.jRt.jRm, this.jRt.jKJ, new g.b(this) {
                                final /* synthetic */ AnonymousClass5 jRu;

                                {
                                    this.jRu = r1;
                                }

                                public final void onAnimationStart() {
                                    if (this.jRu.jRt.jRm != null) {
                                        this.jRu.jRt.jRm.onResume();
                                    }
                                }

                                public final void onAnimationEnd() {
                                }
                            });
                            return true;
                        }
                    });
                }
            }
        }
        super.onStart();
    }

    protected void onResume() {
        if (VERSION.SDK_INT >= 21) {
            getWindow().clearFlags(2048);
        }
        this.iVr.a(this);
        if (!this.jRk) {
            this.jRm.onResume();
        }
        this.jRk = false;
        if (this.jRn) {
            this.jRn = false;
        }
        super.onResume();
    }

    protected void onPause() {
        if (VERSION.SDK_INT >= 21) {
            getWindow().setFlags(2048, 2048);
        }
        v.d("MicroMsg.OnlineVideoView", "%d on pause %s ", new Object[]{Integer.valueOf(this.jRm.hashCode()), be.bur()});
        r0.aPy();
        if (!this.jRn) {
            v.d("MicroMsg.SnsOnlineVideoActivity", "close Popup");
            new ac().post(new Runnable(this) {
                final /* synthetic */ SnsOnlineVideoActivity jRt;

                {
                    this.jRt = r1;
                }

                public final void run() {
                    this.jRt.finish();
                }
            });
        }
        super.onPause();
    }

    protected void onDestroy() {
        this.jRm.onDestroy();
        if (ak.oJ() != null) {
            ak.oJ().pT();
        }
        this.iVr.aN(false);
        super.onDestroy();
    }

    public final void abE() {
        int width = this.hsA.getWidth();
        int height = this.hsA.getHeight();
        if (!(this.eJb == 0 || this.eJc == 0)) {
            height = (int) ((((float) width) / ((float) this.eJb)) * ((float) this.eJc));
        }
        this.eIY.du(width, height);
        this.eIY.m(this.eJa, this.eIZ, this.eJb, this.eJc);
        if (((double) this.jMj) != 1.0d) {
            this.eIY.oSK = 1.0f / this.jMj;
            if (!(this.jMk == 0 && this.jMl == 0)) {
                this.eIY.dv(((int) (((float) (this.hsA.getWidth() / 2)) * (1.0f - this.jMj))) + this.jMk, (int) (((float) ((this.hsA.getHeight() / 2) + this.jMl)) - (((float) (height / 2)) * this.jMj)));
            }
        }
        this.eIY.a(this.jRm, this.jKJ, new g.b(this) {
            final /* synthetic */ SnsOnlineVideoActivity jRt;

            {
                this.jRt = r1;
            }

            public final void onAnimationStart() {
            }

            public final void onAnimationEnd() {
                new ac().post(new Runnable(this) {
                    final /* synthetic */ AnonymousClass6 jRv;

                    {
                        this.jRv = r1;
                    }

                    public final void run() {
                        this.jRv.jRt.finish();
                        this.jRv.jRt.overridePendingTransition(0, 0);
                    }
                });
            }
        }, null);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4 || keyEvent.getAction() != 0) {
            return super.dispatchKeyEvent(keyEvent);
        }
        v.d("MicroMsg.SnsOnlineVideoActivity", "dispatchKeyEvent");
        abE();
        return true;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        v.i("MicroMsg.SnsOnlineVideoActivity", "on activity result reqCode %d resultCode %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (4097 == i && -1 == i2) {
            String stringExtra = intent.getStringExtra("Select_Conv_User");
            String stringExtra2 = intent.getStringExtra("custom_send_text");
            for (String str : be.g(stringExtra.split(","))) {
                if (this.scene == 0) {
                    k Bq = ad.aSE().Bq(this.bde);
                    if (Bq != null) {
                        if (m.dE(str)) {
                            no noVar = new no();
                            noVar.boH.boC = i.g(Bq);
                            noVar.boH.bap = Bq.aUL();
                            com.tencent.mm.sdk.c.a.nhr.z(noVar);
                        } else {
                            np npVar = new np();
                            npVar.boI.boC = i.g(Bq);
                            npVar.boI.bap = Bq.aUL();
                            com.tencent.mm.sdk.c.a.nhr.z(npVar);
                        }
                    }
                }
                azr aUp = this.jRl.aUp();
                int zZ = i.zZ(this.cPu);
                if (be.kS(this.bdZ)) {
                    aib com_tencent_mm_protocal_c_aib = this.boL;
                    if (com_tencent_mm_protocal_c_aib == null) {
                        stringExtra = "";
                    } else {
                        String cA = al.cA(ad.xh(), com_tencent_mm_protocal_c_aib.gID);
                        stringExtra = cA + i.c(com_tencent_mm_protocal_c_aib);
                        v.d("MicroMsg.SnsVideoLogic", "get sns video thumb path %s [%b]", new Object[]{stringExtra, Boolean.valueOf(FileOp.aR(stringExtra))});
                        if (!FileOp.aR(stringExtra)) {
                            stringExtra = cA + i.m(com_tencent_mm_protocal_c_aib);
                            v.i("MicroMsg.SnsVideoLogic", "get sns video thumb path %s", new Object[]{stringExtra});
                        }
                    }
                } else {
                    stringExtra = this.bdZ;
                }
                this.bdZ = stringExtra;
                v.i("MicroMsg.SnsOnlineVideoActivity", "send sight to %s, videopath %s, thumbpath %s url: %s time: %d, duration: %s", new Object[]{str, this.cPu, this.bdZ, this.boL.mHW, Integer.valueOf(this.boL.jZD), Integer.valueOf(zZ)});
                j.a.bmt().a(this, str, this.cPu, this.bdZ, 43, zZ, aUp.jGu);
                if (stringExtra2 != null) {
                    j.a.bmt().df(stringExtra2, str);
                }
                com.tencent.mm.ui.snackbar.a.f(this, getString(2131233278));
            }
        }
        super.onActivityResult(i, i2, intent);
    }
}
