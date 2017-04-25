package com.tencent.mm.plugin.sight.decode.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.as.k;
import com.tencent.mm.as.n;
import com.tencent.mm.as.p;
import com.tencent.mm.e.a.ly;
import com.tencent.mm.e.a.pn;
import com.tencent.mm.e.b.bx;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.d;
import com.tencent.mm.pluginsdk.ui.tools.VideoSurfaceView;
import com.tencent.mm.pluginsdk.ui.tools.VideoTextureView;
import com.tencent.mm.pluginsdk.ui.tools.g;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.i;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.File;
import java.lang.ref.WeakReference;

public final class c extends i implements com.tencent.mm.model.d.a {
    private static a iVq = new a();
    public int bqS = 0;
    public String cPu;
    private g eJz = null;
    public int fNz = 0;
    public int iUu = 0;
    private TextView iVo = null;
    public boolean iVp = false;
    private d iVr = new d();
    public String imagePath;

    private static class a extends com.tencent.mm.sdk.c.c<ly> {
        WeakReference<c> iVu;

        private a() {
            this.iVu = null;
            this.nhz = ly.class.getName().hashCode();
        }

        /* synthetic */ a(byte b) {
            this();
            this.nhz = ly.class.getName().hashCode();
        }

        private boolean a(ly lyVar) {
            if (lyVar instanceof ly) {
                long j = lyVar.bnd.bao;
                ak.yW();
                bx ek = com.tencent.mm.model.c.wJ().ek(j);
                if (ek.field_msgId <= 0) {
                    ek = lyVar.bnd.bnf;
                }
                if (62 != ek.field_type) {
                    v.e("MicroMsg.VideoPopupHelper", "not short video type !!! cur type %d", Integer.valueOf(ek.field_type));
                } else {
                    n lp = p.lp(ek.field_imgPath);
                    if (lp != null) {
                        try {
                            com.tencent.mm.modelcdntran.g.DZ().iq(com.tencent.mm.modelcdntran.d.a("downvideo", lp.dhH, lp.Ld(), lp.getFileName()));
                            v.i("MicroMsg.VideoPopupHelper", "[oneliang][revokeMsgVideo] cancel result:%s", Boolean.valueOf(true));
                            ak.vy().cancel(150);
                            k.KV().la(lp.getFileName());
                        } catch (Throwable e) {
                            v.a("MicroMsg.VideoPopupHelper", e, "[oneliang][revokeMsgVideo] chatting item video,cancel failure:%s", e.getMessage());
                        }
                    }
                    if (this.iVu == null) {
                        v.w("MicroMsg.VideoPopupHelper", "popup view ref is null");
                    } else {
                        final c cVar = (c) this.iVu.get();
                        if (cVar == null) {
                            v.w("MicroMsg.VideoPopupHelper", "popup view is null");
                            this.iVu = null;
                        } else {
                            cVar.aPy();
                            com.tencent.mm.ui.base.g.a(cVar.getContext(), lyVar.bnd.bne, SQLiteDatabase.KeyEmpty, false, new OnClickListener(this) {
                                final /* synthetic */ a iVw;

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    dialogInterface.dismiss();
                                    cVar.dismiss();
                                }
                            });
                            this.iVu = null;
                        }
                    }
                }
            } else {
                v.e("MicroMsg.VideoPopupHelper", "can not be here");
            }
            return false;
        }
    }

    static /* synthetic */ void b(c cVar) {
        if (cVar.eJz.start()) {
            cVar.iVr.a(cVar);
        } else {
            cVar.aPx();
        }
    }

    public c(Context context) {
        super(context, 2131559287);
    }

    protected final void onCreate(Bundle bundle) {
        long currentTimeMillis = System.currentTimeMillis();
        v.d("MicroMsg.VideoPopupHelper", currentTimeMillis + " initView beg");
        super.onCreate(bundle);
        getWindow().setFlags(16777216, 16777216);
        setContentView(2130904385);
        if (ak.oJ() != null) {
            ak.oJ().pU();
        }
        v.d("MicroMsg.VideoPopupHelper", com.tencent.mm.compatible.util.g.sl() + " initView: fullpath:" + this.cPu + ", imagepath:" + this.imagePath);
        this.iVo = (TextView) findViewById(2131757003);
        findViewById(2131759210).setVisibility(8);
        ViewGroup viewGroup = (ViewGroup) findViewById(2131756998);
        viewGroup.setBackgroundResource(2131689547);
        v.i("MicroMsg.VideoPopupHelper", "getVideoView, is normal video");
        if (com.tencent.mm.compatible.util.d.dW(14)) {
            this.eJz = new VideoTextureView(getContext());
        } else {
            this.eJz = new VideoSurfaceView(getContext());
        }
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        viewGroup.addView((View) this.eJz, layoutParams);
        this.eJz.a(new com.tencent.mm.pluginsdk.ui.tools.g.a(this) {
            final /* synthetic */ c iVs;

            {
                this.iVs = r1;
            }

            public final void abH() {
                v.d("MicroMsg.VideoPopupHelper", com.tencent.mm.compatible.util.g.sl() + " onPrepared");
                c.b(this.iVs);
            }

            public final void bp(int i, int i2) {
                v.e("MicroMsg.VideoPopupHelper", "on play video error, what %d extra %d", Integer.valueOf(i), Integer.valueOf(i2));
                this.iVs.eJz.stop();
                b.r(Base64.encodeToString((com.tencent.mm.plugin.sight.base.d.aOU() + "[SightPopupHelper] on play video error, what " + i + " extra " + i2 + ", path=" + be.ah(this.iVs.imagePath, SQLiteDatabase.KeyEmpty)).getBytes(), 2), "FullScreenPlaySight");
                final String d = this.iVs.imagePath;
                final Bitmap a = com.tencent.mm.ae.n.GH().a(d, com.tencent.mm.bd.a.getDensity(this.iVs.getContext()), this.iVs.getContext(), -1);
                ad.o(new Runnable(this) {
                    final /* synthetic */ AnonymousClass1 iVt;

                    public final void run() {
                        ImageView imageView = (ImageView) this.iVt.iVs.findViewById(2131756999);
                        imageView.setImageBitmap(a);
                        imageView.setVisibility(0);
                        Intent intent = new Intent();
                        intent.setAction("android.intent.action.VIEW");
                        intent.setDataAndType(Uri.fromFile(new File(d)), "video/*");
                        try {
                            this.iVt.iVs.getContext().startActivity(Intent.createChooser(intent, this.iVt.iVs.getContext().getString(2131232752)));
                        } catch (Exception e) {
                            v.e("MicroMsg.VideoPopupHelper", "startActivity fail, activity not found");
                            com.tencent.mm.ui.base.g.f(this.iVt.iVs.getContext(), 2131232691, 2131232692);
                        }
                    }
                });
            }

            public final void pa() {
                v.d("MicroMsg.VideoPopupHelper", "on completion");
                this.iVs.iVo.post(new Runnable(this) {
                    final /* synthetic */ AnonymousClass1 iVt;

                    {
                        this.iVt = r1;
                    }

                    public final void run() {
                        this.iVt.iVs.iVo.setVisibility(0);
                        this.iVt.iVs.iVo.startAnimation(AnimationUtils.loadAnimation(this.iVt.iVs.getContext(), 2130968622));
                    }
                });
                this.iVs.eJz.fD(true);
                c.b(this.iVs);
            }

            public final int bq(int i, int i2) {
                return 0;
            }

            public final void br(int i, int i2) {
            }
        });
        findViewById(2131756998).setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ c iVs;

            {
                this.iVs = r1;
            }

            public final void onClick(View view) {
                this.iVs.aPx();
            }
        });
        ((View) this.eJz).setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ c iVs;

            {
                this.iVs = r1;
            }

            public final void onClick(View view) {
                this.iVs.aPx();
            }
        });
        if (this.cPu != null) {
            this.eJz.stop();
            this.eJz.setVideoPath(this.cPu);
        }
        v.d("MicroMsg.VideoPopupHelper", (System.currentTimeMillis() - currentTimeMillis) + " initView end");
        com.tencent.mm.sdk.c.b pnVar = new pn();
        pnVar.bqP.type = 1;
        com.tencent.mm.sdk.c.a.nhr.z(pnVar);
        if (!com.tencent.mm.sdk.c.a.nhr.g(iVq)) {
            com.tencent.mm.sdk.c.a.nhr.e(iVq);
        }
        iVq.iVu = new WeakReference(this);
    }

    private void aPx() {
        v.v("check", "onclick");
        if (this.eJz.isPlaying()) {
            aPy();
        }
        new ac().post(new Runnable(this) {
            final /* synthetic */ c iVs;

            {
                this.iVs = r1;
            }

            public final void run() {
                this.iVs.dismiss();
            }
        });
    }

    private void aPy() {
        this.eJz.pause();
        this.iVr.aN(false);
    }

    public final void dismiss() {
        v.d("MicroMsg.VideoPopupHelper", "on dismiss");
        if (ak.oJ() != null) {
            ak.oJ().pT();
        }
        if (this.eJz != null) {
            this.eJz.a(null);
            this.eJz.stop();
            this.eJz.onDetach();
            findViewById(2131756998).setOnClickListener(null);
        }
        if (!this.iVp && isShowing()) {
            com.tencent.mm.sdk.c.b pnVar = new pn();
            pnVar.bqP.type = 0;
            pnVar.bqP.bqQ = this.iUu;
            pnVar.bqP.bqR = this.fNz;
            pnVar.bqP.bqS = this.bqS;
            com.tencent.mm.sdk.c.a.nhr.z(pnVar);
        }
        com.tencent.mm.sdk.c.a.nhr.f(iVq);
        super.dismiss();
        this.iVr.aN(true);
    }
}
