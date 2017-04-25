package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.util.AttributeSet;
import com.tencent.mm.as.k;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.plugin.sight.decode.a.b;
import com.tencent.mm.plugin.sight.decode.a.b.AnonymousClass3;
import com.tencent.mm.plugin.sight.decode.a.b.e;
import com.tencent.mm.plugin.sight.decode.a.b.f;
import com.tencent.mm.plugin.sight.decode.ui.SightPlayImageView;
import com.tencent.mm.pluginsdk.ui.tools.g.a;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.g;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.File;

public class VideoSightView extends SightPlayImageView implements g {
    protected int duration = 0;
    private boolean eJx = false;
    protected String iTJ;
    private boolean lUA;
    public boolean lUB = true;

    public VideoSightView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public VideoSightView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public VideoSightView(Context context) {
        super(context);
        init();
    }

    protected void init() {
        if (be.ah(p.ceJ.cef, SQLiteDatabase.KeyEmpty).equals("other")) {
            v.i("MicroMsg.VideoSightView", "init::use other player");
        } else {
            fB(true);
        }
        a(new e(this) {
            final /* synthetic */ VideoSightView lUC;

            {
                this.lUC = r1;
            }

            public final void d(b bVar, int i) {
                if (-1 == i) {
                    if (this.lUC.iVc != null) {
                        this.lUC.iVc.bp(0, 0);
                    }
                } else if (i == 0 && this.lUC.iVc != null) {
                    this.lUC.iVc.pa();
                }
            }
        });
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        v.v("MicroMsg.VideoSightView", "ashutest::on layout changed %B, %d %d %d %d %s", Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(this.iVd));
        if (this.iVd && i3 - i > 0) {
            pv(i3 - i);
        }
    }

    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.lUB) {
            pv(getResources().getDisplayMetrics().widthPixels);
        }
    }

    public boolean isPlaying() {
        return this.iUW.aPe();
    }

    public final void setVideoPath(String str) {
        String str2 = "MicroMsg.VideoSightView";
        String str3 = "set sight path %s, callback null ? %B";
        Object[] objArr = new Object[2];
        objArr[0] = str;
        objArr[1] = Boolean.valueOf(this.iVc == null);
        v.i(str2, str3, objArr);
        this.duration = 0;
        this.iTJ = str;
        if (this.iVc != null) {
            this.iVc.abH();
        }
    }

    public void stop() {
        this.iUW.clear();
    }

    public void pause() {
        ag(this.iTJ, true);
    }

    public final void fD(boolean z) {
        if (this.iUW != null) {
            this.iUW.gFD = z;
        }
    }

    public final void a(a aVar) {
        this.iVc = aVar;
    }

    public int getCurrentPosition() {
        v.v("MicroMsg.VideoSightView", "get current position");
        return 0;
    }

    public int getDuration() {
        int duration = super.getDuration();
        v.v("MicroMsg.VideoSightView", "get duration " + duration);
        return duration;
    }

    public final void onDetach() {
        detach();
    }

    public boolean start() {
        return h(getContext(), false);
    }

    public final boolean h(Context context, boolean z) {
        boolean z2 = false;
        if (this.iTJ == null) {
            v.e("MicroMsg.VideoSightView", "start::use path is null!");
            return false;
        } else if (be.ah(p.ceJ.cef, SQLiteDatabase.KeyEmpty).equals("other") || !b.zE(this.iTJ)) {
            v.i("MicroMsg.VideoSightView", "start::use other player, path %s, has called %B", this.iTJ, Boolean.valueOf(this.lUA));
            if (this.lUA && !z) {
                return false;
            }
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setDataAndType(Uri.fromFile(new File(this.iTJ)), "video/*");
            try {
                context.startActivity(Intent.createChooser(intent, context.getString(2131232752)));
            } catch (Exception e) {
                v.e("MicroMsg.VideoSightView", "startActivity fail, activity not found");
                g.bf(context, context.getResources().getString(2131235793));
            }
            this.lUA = true;
            return false;
        } else {
            ag(this.iTJ, false);
            if (!this.eJx) {
                z2 = true;
            }
            fB(z2);
            return true;
        }
    }

    public double aPB() {
        if (this.iUW == null) {
            return 0.0d;
        }
        b bVar = this.iUW;
        return bVar.iUk != -1.0d ? bVar.iUk : bVar.iUh;
    }

    public void i(double d) {
        if (this.iUW != null) {
            b bVar = this.iUW;
            v.v("MicroMsg.SightPlayController", "seekToFrame now %f %s", Double.valueOf(d), be.bur().toString());
            k.b(new AnonymousClass3(bVar, d), 0);
        }
    }

    public void fE(boolean z) {
        if (z) {
            a(new f(this) {
                final /* synthetic */ VideoSightView lUC;

                {
                    this.lUC = r1;
                }

                public final void b(b bVar, long j) {
                    if (this.lUC.duration == 0) {
                        this.lUC.duration = this.lUC.getDuration();
                    }
                    if (this.lUC.iVc != null) {
                        v.v("MicroMsg.VideoSightView", "onPlayTime, currentTime: %s, duration: %s", Long.valueOf(j), Integer.valueOf(this.lUC.duration));
                        this.lUC.iVc.bq((int) j, this.lUC.duration);
                    }
                }
            });
        } else {
            a(null);
        }
    }

    public final long aPC() {
        return 0;
    }

    public final void dJ(boolean z) {
        this.eJx = z;
        fB(!this.eJx);
    }
}
