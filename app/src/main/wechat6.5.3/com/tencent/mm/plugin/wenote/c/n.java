package com.tencent.mm.plugin.wenote.c;

import android.content.Context;
import android.os.Message;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.c.b.j;
import com.tencent.mm.compatible.b.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ah.a;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.io.File;

public final class n {
    private static n luA = null;
    private Context context;
    public long dfS;
    private long ewI = -1;
    private Toast ewJ;
    private boolean ewV;
    private boolean ewW;
    private final ah exc = new ah(new a(this) {
        final /* synthetic */ n luE;

        {
            this.luE = r1;
        }

        public final boolean oU() {
            if (this.luE.ewI == -1) {
                this.luE.ewI = be.Nj();
            }
            long az = be.az(this.luE.ewI);
            if (az >= 3590000 && az <= 3600000) {
                if (this.luE.ewJ == null) {
                    this.luE.ewJ = Toast.makeText(this.luE.context, this.luE.context.getString(2131231871, new Object[]{Integer.valueOf((int) ((3600000 - az) / 1000))}), 0);
                } else {
                    this.luE.ewJ.setText(this.luE.context.getString(2131231871, new Object[]{Integer.valueOf((int) ((3600000 - az) / 1000))}));
                }
                this.luE.ewJ.show();
            }
            if (az < 3600000) {
                return true;
            }
            v.v("MicroMsg.WNNoteVoiceLogic", "record stop on countdown");
            this.luE.ewW = true;
            this.luE.ane();
            if (this.luE.luC != null) {
                this.luE.luC.blZ();
            }
            return false;
        }
    }, true);
    private final ac exe = new ac(this) {
        final /* synthetic */ n luE;

        {
            this.luE = r1;
        }

        public final void handleMessage(Message message) {
            super.handleMessage(message);
            this.luE.ewV = false;
        }
    };
    private TextView fQw;
    private long fTb;
    private j fTi;
    public int luB = 0;
    private a luC;
    private final ac luD = new ac(this) {
        final /* synthetic */ n luE;

        {
            this.luE = r1;
        }

        public final void handleMessage(Message message) {
            this.luE.fQw.setText(com.tencent.mm.au.a.s(this.luE.context, (int) com.tencent.mm.au.a.au(this.luE.getDuration())).toString());
            sendEmptyMessageDelayed(4096, 100);
        }
    };
    public String path;

    private n() {
    }

    public static n bmd() {
        if (luA == null) {
            luA = new n();
        }
        return luA;
    }

    public final void a(Context context, int i, TextView textView, a aVar) {
        if (!this.ewV) {
            String str;
            this.ewV = true;
            this.context = context;
            this.fQw = textView;
            this.luB = i;
            this.luC = aVar;
            this.ewW = false;
            String bLR = com.tencent.mm.bj.a.bLR();
            File file = new File(bLR);
            if (!file.exists()) {
                file.mkdirs();
            }
            do {
                str = bLR + "/" + System.currentTimeMillis();
            } while (new File(str).exists());
            this.path = str;
            b.qP();
            j jVar = new j();
            jVar.aVH = new j.a(this) {
                final /* synthetic */ n luE;

                {
                    this.luE = r1;
                }

                public final void onError() {
                    this.luE.exc.QI();
                }
            };
            this.fTi = jVar;
            this.ewI = -1;
            if (this.fTi.bz(this.path)) {
                this.fTb = be.Nj();
                this.exc.ea(200);
            } else {
                this.fTb = 0;
            }
            this.luD.sendEmptyMessage(4096);
        }
    }

    public final void bme() {
        if (this.ewV && !this.ewW) {
            ane();
        }
    }

    private void ane() {
        if (this.ewV) {
            this.luD.removeMessages(4096);
            this.fTi.pb();
            this.dfS = getDuration();
            boolean z = this.dfS < 800;
            this.exc.QI();
            if (z) {
                File file = new File(this.path);
                if (file.exists()) {
                    file.delete();
                }
                this.exe.sendEmptyMessageDelayed(0, 500);
            }
            this.ewV = false;
        }
    }

    private long getDuration() {
        if (this.fTb == 0) {
            return 0;
        }
        return be.az(this.fTb);
    }
}
