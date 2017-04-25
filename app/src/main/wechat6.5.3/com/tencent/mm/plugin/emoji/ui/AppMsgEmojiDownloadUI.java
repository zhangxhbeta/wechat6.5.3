package com.tencent.mm.plugin.emoji.ui;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.ae.n;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.pluginsdk.model.app.aa;
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pluginsdk.ui.chat.l.b;
import com.tencent.mm.pluginsdk.ui.emoji.PreViewEmojiView;
import com.tencent.mm.sdk.h.g.a;
import com.tencent.mm.sdk.h.i;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.o;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.v.e;
import com.tencent.mm.v.f;
import com.tencent.mm.v.k;
import java.io.IOException;

public class AppMsgEmojiDownloadUI extends MMActivity implements a, e {
    private String aXa;
    private String appName;
    private long bao;
    private String bdZ;
    private String blu;
    private String bmJ;
    private at bmk;
    private String cod;
    private ProgressBar elJ;
    private aa ffu;
    private f ffv;
    private TextView ffw;
    private String ffx;
    private PreViewEmojiView ffy;

    protected final int getLayoutId() {
        return 2130903124;
    }

    public void onCreate(Bundle bundle) {
        boolean z = true;
        super.onCreate(bundle);
        this.ffx = "da_" + be.Ni();
        this.bao = getIntent().getLongExtra("msgid", -1);
        if (this.bao == -1) {
            z = false;
        } else {
            ak.yW();
            this.bmk = c.wJ().ek(this.bao);
            if (this.bmk == null || this.bmk.field_msgId == 0 || this.bmk.field_content == null) {
                z = false;
            } else {
                this.blu = this.bmk.field_content;
                com.tencent.mm.q.a.a dV = com.tencent.mm.q.a.a.dV(this.blu);
                if (dV == null) {
                    z = false;
                } else {
                    this.cod = dV.cod;
                    this.aXa = dV.aXa;
                    this.bmJ = dV.appId;
                    this.appName = g.a(this.nDR.nEl, g.aC(this.bmJ, true), null);
                    this.bdZ = this.bmk.field_imgPath;
                }
            }
        }
        if (z) {
            am.Wf().c(this);
            NI();
            this.ffv = new f(this) {
                final /* synthetic */ AppMsgEmojiDownloadUI ffz;

                {
                    this.ffz = r1;
                }

                public final void a(int i, int i2, k kVar) {
                    float f;
                    if (i2 == 0) {
                        f = 0.0f;
                    } else {
                        f = (((float) i) * 100.0f) / ((float) i2);
                    }
                    this.ffz.jN((int) f);
                }
            };
            if (am.Wf().Gu(this.aXa) == null) {
                long j = this.bao;
                String str = this.blu;
                StringBuilder stringBuilder = new StringBuilder();
                ak.yW();
                l.b(j, str, stringBuilder.append(c.wY()).append(this.ffx).toString());
            }
            this.ffu = new aa(this.aXa, this.ffv, 8);
            ak.vy().a(this.ffu, 0);
            return;
        }
        finish();
    }

    protected final void NI() {
        this.ffy = (PreViewEmojiView) findViewById(2131755434);
        this.ffy.setImageBitmap(n.GH().a(this.bdZ, 1.0f, true));
        Fd("");
        this.ffw = (TextView) findViewById(2131755435);
        TextView textView = (TextView) findViewById(2131755437);
        this.appName = g.a(this.nDR.nEl, g.aC(this.bmJ, true), null);
        if (this.bmJ != null && this.bmJ.length() > 0) {
            String str = this.appName;
            boolean z = (str == null || str.trim().length() == 0 || str.equals("weixinfile") || str.equals("invalid_appname")) ? false : true;
            if (z) {
                textView.setText(getString(2131231902, new Object[]{this.appName}));
                textView.setVisibility(0);
                str = this.bmJ;
                b bVar = new b();
                bVar.appId = str;
                bVar.bmm = "message";
                textView.setTag(bVar);
                textView.setOnClickListener(new com.tencent.mm.pluginsdk.ui.chat.l(this));
                Bitmap b = g.b(this.bmJ, 2, com.tencent.mm.bd.a.getDensity(this));
                if (b == null || b.isRecycled()) {
                    a(this, textView, BitmapFactory.decodeResource(getResources(), 2130838795));
                } else {
                    a(this, textView, b);
                }
                this.elJ = (ProgressBar) findViewById(2131755436);
                this.elJ.setMax(100);
                b(new OnMenuItemClickListener(this) {
                    final /* synthetic */ AppMsgEmojiDownloadUI ffz;

                    {
                        this.ffz = r1;
                    }

                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        this.ffz.finish();
                        return true;
                    }
                });
            }
        }
        textView.setVisibility(8);
        this.elJ = (ProgressBar) findViewById(2131755436);
        this.elJ.setMax(100);
        b(/* anonymous class already generated */);
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar.getType() == 221) {
            if (i == 0 && i2 == 0) {
                jN(this.elJ.getMax());
                return;
            }
            Toast.makeText(this, 2131232297, 0).show();
            this.elJ.setVisibility(8);
            this.ffw.setVisibility(8);
            v.e("MicroMsg.emoji.AppMsgEmojiDownloadUI", "onSceneEnd, download fail, errType = " + i + ", errCode = " + i2);
        }
    }

    protected void onPause() {
        super.onPause();
        ak.vy().b(221, this);
    }

    protected void onResume() {
        super.onResume();
        ak.vy().a(221, this);
    }

    public final void a(String str, i iVar) {
        com.tencent.mm.pluginsdk.model.app.b Gu = am.Wf().Gu(this.aXa);
        if (Gu == null) {
            v.e("MicroMsg.emoji.AppMsgEmojiDownloadUI", "updateProgress fail");
            return;
        }
        long j = Gu.field_totalLen;
        long j2 = Gu.field_offset;
        this.ffw.setText(getString(2131232299) + " " + getString(2131232296, new Object[]{be.aw(j2), be.aw(j)}));
        int i = (int) ((Gu.field_offset * 100) / Gu.field_totalLen);
        v.v("MicroMsg.emoji.AppMsgEmojiDownloadUI", "attach progress:" + i + " offset:" + j2 + " totallen:" + j);
        jN(i);
    }

    private void jN(int i) {
        this.elJ.setProgress(i);
        if (i >= 100) {
            ak.yW();
            String wY = c.wY();
            com.tencent.mm.pluginsdk.model.app.b Gu = am.Wf().Gu(this.aXa);
            if (Gu == null) {
                v.e("MicroMsg.emoji.AppMsgEmojiDownloadUI", "saveImageAndPreview fail, info is null, attachid = " + this.aXa + ", msgContent = " + this.blu);
            } else {
                int aQ = com.tencent.mm.a.e.aQ(Gu.field_fileFullPath);
                Object c = com.tencent.mm.a.e.c(Gu.field_fileFullPath, 0, aQ);
                String m = com.tencent.mm.a.g.m(c);
                if (!be.kS(m)) {
                    if (m == null || this.cod == null || m.equalsIgnoreCase(this.cod)) {
                        com.tencent.mm.a.e.h(wY, this.ffx, m);
                        Gu.field_fileFullPath = wY + m;
                        am.Wf().a(Gu.field_msgInfoId, Gu);
                        Bitmap a = n.GH().a(this.bdZ, 1.0f, true);
                        if (a != null) {
                            l(wY + m + "_thumb", a);
                        }
                        com.tencent.mm.storage.a.c a2 = o.be(c) ? com.tencent.mm.plugin.emoji.model.g.afx().fch.a(m, "", com.tencent.mm.storage.a.c.nwM, com.tencent.mm.storage.a.c.nwW, aQ, this.bmJ, "") : com.tencent.mm.plugin.emoji.model.g.afx().fch.a(m, "", com.tencent.mm.storage.a.c.nwM, com.tencent.mm.storage.a.c.nwX, aQ, this.bmJ, "");
                        this.elJ.setVisibility(8);
                        this.ffw.setVisibility(8);
                        if (a2 != null) {
                            this.ffy.bN(a2.dR(a2.field_groupId, a2.EB()), null);
                            this.ffy.resume();
                        }
                    } else {
                        v.e("MicroMsg.emoji.AppMsgEmojiDownloadUI", "md5 not match!! emoticonmd5 is=" + this.cod + ", gen md5 is=" + m);
                        v.e("MicroMsg.emoji.AppMsgEmojiDownloadUI", "fileFullPath = " + Gu.field_fileFullPath + ", fileLength = " + aQ + ", bufLength = " + c.length + ", buf = " + c);
                        Toast.makeText(this, getString(2131232297), 0).show();
                        finish();
                    }
                }
            }
            am.Wf().d(this);
            ak.vy().b(221, this);
        }
    }

    private static boolean l(String str, Bitmap bitmap) {
        try {
            d.a(bitmap, 100, CompressFormat.PNG, str, true);
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    private static void a(AppMsgEmojiDownloadUI appMsgEmojiDownloadUI, TextView textView, Bitmap bitmap) {
        Drawable bitmapDrawable = new BitmapDrawable(bitmap);
        int dimension = (int) appMsgEmojiDownloadUI.getResources().getDimension(2131493128);
        bitmapDrawable.setBounds(0, 0, dimension, dimension);
        textView.setCompoundDrawables(bitmapDrawable, null, null, null);
    }

    protected void onDestroy() {
        super.onDestroy();
        ak.vy().c(this.ffu);
        am.Wf().d(this);
    }
}
