package com.tencent.mm.plugin.record.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.util.Base64;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.a.e;
import com.tencent.mm.ay.c;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.record.a.i.a;
import com.tencent.mm.plugin.record.a.j;
import com.tencent.mm.plugin.record.a.m;
import com.tencent.mm.plugin.record.a.s;
import com.tencent.mm.pluginsdk.ui.tools.g;
import com.tencent.mm.pluginsdk.ui.tools.o;
import com.tencent.mm.protocal.c.pw;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.modelmsg.WXFileObject;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.modelmsg.WXVideoObject;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.p;
import java.io.File;
import java.util.Iterator;
import java.util.List;

public class RecordMsgFileUI extends MMActivity implements a {
    private long bao;
    private pw bdE;
    private ac cnC;
    private TextView dMQ;
    private g eJz = null;
    private TextView eVA;
    private ProgressBar elJ;
    private Button fQD;
    private Button fQE;
    private Button fQF;
    private MMImageView fQG;
    private TextView fQH;
    private View fQI;
    private View fQJ;
    private boolean fQL = false;
    private j iqw;
    private String mediaId;

    static /* synthetic */ void f(RecordMsgFileUI recordMsgFileUI) {
        int i = 1;
        Intent intent = new Intent();
        intent.putExtra("Select_Conv_Type", 3);
        intent.putExtra("select_is_ret", true);
        intent.putExtra("mutil_select_is_ret", true);
        if (recordMsgFileUI.getType() == 15) {
            i = 11;
            intent.putExtra("image_path", recordMsgFileUI.aJS());
        } else if (recordMsgFileUI.getType() == 4) {
            intent.putExtra("image_path", recordMsgFileUI.aJS());
        } else {
            intent.putExtra("file_title", recordMsgFileUI.bdE.title);
            i = 3;
        }
        intent.putExtra("Retr_Msg_Type", i);
        c.a(recordMsgFileUI, ".ui.transmit.SelectConversationUI", intent, 1001);
    }

    protected final int getLayoutId() {
        return 2130903633;
    }

    protected final int NO() {
        return 1;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.cnC = new ac();
        this.iqw = new j();
        this.bao = getIntent().getLongExtra("message_id", -1);
        String stringExtra = getIntent().getStringExtra("record_data_id");
        com.tencent.mm.protocal.b.a.c yy = m.yy(getIntent().getStringExtra("record_xml"));
        if (yy == null) {
            v.w("MicroMsg.RecordMsgFileUI", "get record msg data error, empty");
            finish();
            return;
        }
        Iterator it = yy.cqE.iterator();
        while (it.hasNext()) {
            pw pwVar = (pw) it.next();
            if (pwVar.luu.equals(stringExtra)) {
                this.bdE = pwVar;
            }
        }
        if (this.bdE == null) {
            v.w("MicroMsg.RecordMsgFileUI", "get data error, empty");
            finish();
            return;
        }
        this.mediaId = m.c(this.bdE.luu, this.bao, true);
        this.fQD = (Button) findViewById(2131757001);
        this.fQE = (Button) findViewById(2131757002);
        this.fQF = (Button) findViewById(2131756255);
        this.fQG = (MMImageView) findViewById(2131756771);
        this.eVA = (TextView) findViewById(2131756329);
        this.dMQ = (TextView) findViewById(2131757003);
        this.fQJ = findViewById(2131755473);
        this.fQI = findViewById(2131755471);
        this.elJ = (ProgressBar) findViewById(2131755472);
        this.fQH = (TextView) findViewById(2131757000);
        if (4 == getType()) {
            vD(2131232752);
        } else if (15 == getType()) {
            vD(2131232732);
            findViewById(2131756998).setBackgroundResource(2131689547);
        } else {
            vD(2131232668);
        }
        if (getType() == 4) {
            this.fQG.setImageResource(2131165244);
        } else {
            this.fQG.setImageResource(com.tencent.mm.pluginsdk.c.Ga(this.bdE.msh));
        }
        this.eVA.setText(this.bdE.title);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ RecordMsgFileUI iqx;

            {
                this.iqx = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.iqx.finish();
                return true;
            }
        });
        this.fQE.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ RecordMsgFileUI iqx;

            {
                this.iqx = r1;
            }

            public final void onClick(View view) {
                String c = m.c(this.iqx.bdE, this.iqx.bao);
                Intent intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                if (4 == this.iqx.getType()) {
                    intent.setDataAndType(Uri.fromFile(new File(c)), "video/*");
                    try {
                        this.iqx.startActivity(Intent.createChooser(intent, this.iqx.getString(2131232752)));
                        return;
                    } catch (Exception e) {
                        v.e("MicroMsg.RecordMsgFileUI", "startActivity fail, activity not found");
                        com.tencent.mm.ui.base.g.f(this.iqx.nDR.nEl, 2131232691, 2131232692);
                        return;
                    }
                }
                com.tencent.mm.pluginsdk.ui.tools.a.c(this.iqx, c, this.iqx.bdE.msh, 5);
            }
        });
        final String str = this.bdE.mrZ;
        if (!be.kS(str)) {
            this.fQD.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ RecordMsgFileUI iqx;

                public final void onClick(View view) {
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", str);
                    c.b(this.iqx.nDR.nEl, "webview", ".ui.tools.WebViewUI", intent);
                }
            });
        }
        this.fQF.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ RecordMsgFileUI iqx;

            {
                this.iqx = r1;
            }

            public final void onClick(View view) {
                if (f.sj()) {
                    m.a(this.iqx.bdE, this.iqx.bao, true);
                    this.iqx.amZ();
                    return;
                }
                com.tencent.mm.ui.base.g.f(this.iqx.nDR.nEl, 2131232694, 2131231164);
            }
        });
        this.fQJ.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ RecordMsgFileUI iqx;

            {
                this.iqx = r1;
            }

            public final void onClick(View view) {
                this.iqx.ana();
            }
        });
        if (getType() != 15 || be.KL(com.tencent.mm.h.j.sU().getValue("SightForwardEnable")) == 1) {
            a(0, 2130838681, new OnMenuItemClickListener(this) {
                final /* synthetic */ RecordMsgFileUI iqx;

                {
                    this.iqx = r1;
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    com.tencent.mm.ui.widget.f fVar = new com.tencent.mm.ui.widget.f(this.iqx.nDR.nEl, com.tencent.mm.ui.widget.f.pbS, false);
                    fVar.jXn = new n.c(this) {
                        final /* synthetic */ AnonymousClass11 iqA;

                        {
                            this.iqA = r1;
                        }

                        public final void a(l lVar) {
                            lVar.d(0, this.iqA.iqx.getString(2131232731));
                        }
                    };
                    fVar.jXo = new d(this) {
                        final /* synthetic */ AnonymousClass11 iqA;

                        {
                            this.iqA = r1;
                        }

                        public final void c(MenuItem menuItem, int i) {
                            switch (menuItem.getItemId()) {
                                case 0:
                                    if (this.iqA.iqx.getType() == 8) {
                                        String c = m.c(this.iqA.iqx.bdE, this.iqA.iqx.bao);
                                        if (!e.aR(c)) {
                                            v.e("MicroMsg.RecordMsgFileUI", "share file failed, file not exists");
                                            Toast.makeText(this.iqA.iqx, this.iqA.iqx.getString(2131232729), 1).show();
                                            return;
                                        } else if (new File(c).length() > 10485760) {
                                            v.e("MicroMsg.RecordMsgFileUI", "share file failed, file too large");
                                            Toast.makeText(this.iqA.iqx, this.iqA.iqx.getString(2131232730), 1).show();
                                            return;
                                        }
                                    }
                                    RecordMsgFileUI.f(this.iqA.iqx);
                                    return;
                                default:
                                    return;
                            }
                        }
                    };
                    fVar.bKh();
                    return true;
                }
            });
        } else {
            v.w("MicroMsg.RecordMsgFileUI", "can not retransmit sight msg");
        }
        if (m.d(this.bdE, this.bao)) {
            iT(true);
            aJR();
        } else {
            com.tencent.mm.plugin.record.a.g yx = s.aJE().yx(this.mediaId);
            if (yx == null || 2 == yx.field_status) {
                ana();
            } else if (4 == yx.field_status) {
                amY();
            } else if (yx.field_status == 0 || 1 == yx.field_status) {
                amZ();
            } else {
                v.w("MicroMsg.RecordMsgFileUI", "other status, not done, downloading, uploading, downloadfail, uploadfail");
                ana();
            }
            iT(false);
        }
        s.aJE().a((a) this);
    }

    private int getType() {
        int i = this.bdE.aKG;
        if (i == 15) {
            return 4;
        }
        return i;
    }

    private void amY() {
        this.fQF.setVisibility(8);
        this.fQD.setVisibility(8);
        this.fQE.setVisibility(8);
        this.fQI.setVisibility(8);
        this.dMQ.setVisibility(0);
        if (this.bdE.aKG == 4) {
            this.dMQ.setGravity(17);
            this.dMQ.setText(2131232699);
            return;
        }
        this.dMQ.setGravity(17);
        this.dMQ.setText(2131232698);
    }

    private void amZ() {
        this.fQF.setVisibility(8);
        this.fQD.setVisibility(8);
        this.fQE.setVisibility(8);
        this.dMQ.setVisibility(8);
        this.fQI.setVisibility(0);
        b(s.aJE().yx(this.mediaId));
    }

    private void ana() {
        this.fQI.setVisibility(8);
        this.fQE.setVisibility(8);
        if (be.kS(this.bdE.mrZ)) {
            this.fQD.setVisibility(8);
        } else {
            this.fQD.setVisibility(0);
        }
        this.fQF.setVisibility(0);
        this.fQF.setText(2131232678);
        this.dMQ.setVisibility(8);
    }

    private void aJR() {
        if (getType() == 15) {
            this.fQG.setVisibility(8);
            this.fQI.setVisibility(8);
            this.fQF.setVisibility(8);
            this.fQD.setVisibility(8);
            this.fQE.setVisibility(8);
            this.dMQ.setVisibility(8);
            String c = m.c(this.bdE, this.bao);
            v.d("MicroMsg.RecordMsgFileUI", com.tencent.mm.compatible.util.g.sl() + " initView: fullpath:" + c);
            ViewGroup viewGroup = (ViewGroup) findViewById(2131756998);
            this.eJz = o.do(this.nDR.nEl);
            LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(13);
            viewGroup.addView((View) this.eJz, 0, layoutParams);
            this.eJz.a(new g.a(this) {
                final /* synthetic */ RecordMsgFileUI iqx;

                {
                    this.iqx = r1;
                }

                public final void abH() {
                    v.d("MicroMsg.RecordMsgFileUI", com.tencent.mm.compatible.util.g.sl() + " onPrepared");
                    this.iqx.eJz.fD(true);
                    this.iqx.eJz.start();
                }

                public final void bp(int i, int i2) {
                    this.iqx.eJz.stop();
                    if (!this.iqx.fQL) {
                        this.iqx.fQL = true;
                        final Bitmap b = this.iqx.iqw.b(this.iqx.bdE, this.iqx.bao);
                        final String aOV = this.iqx.eJz.aOV();
                        b.r(Base64.encodeToString((com.tencent.mm.plugin.sight.base.d.aOU() + "[RecordMsgFileUI] on play sight error, what=" + i + ", extra=" + i2 + ", path=" + be.ah(aOV, "")).getBytes(), 2), "FullScreenPlaySight");
                        ad.o(new Runnable(this) {
                            final /* synthetic */ AnonymousClass12 iqC;

                            public final void run() {
                                ImageView imageView = (ImageView) this.iqC.iqx.findViewById(2131756999);
                                imageView.setImageBitmap(b);
                                imageView.setVisibility(0);
                                Intent intent = new Intent();
                                intent.setAction("android.intent.action.VIEW");
                                intent.setDataAndType(Uri.fromFile(new File(aOV)), "video/*");
                                try {
                                    this.iqC.iqx.startActivity(Intent.createChooser(intent, this.iqC.iqx.getString(2131232752)));
                                } catch (Exception e) {
                                    v.e("MicroMsg.RecordMsgFileUI", "startActivity fail, activity not found");
                                    com.tencent.mm.ui.base.g.f(this.iqC.iqx.nDR.nEl, 2131232691, 2131232692);
                                }
                            }
                        });
                    }
                }

                public final void pa() {
                }

                public final int bq(int i, int i2) {
                    return 0;
                }

                public final void br(int i, int i2) {
                }
            });
            v.d("MicroMsg.RecordMsgFileUI", com.tencent.mm.compatible.util.g.sl() + " initView :" + c);
            if (c != null) {
                this.eJz.stop();
                this.eJz.setVideoPath(c);
            }
            v.d("MicroMsg.RecordMsgFileUI", com.tencent.mm.compatible.util.g.sl() + " initView");
            if (ak.oJ() != null) {
                ak.oJ().pU();
                return;
            }
            return;
        }
        this.fQI.setVisibility(8);
        this.fQF.setVisibility(4);
        if (be.kS(this.bdE.mrZ)) {
            this.fQD.setVisibility(8);
        } else {
            this.fQD.setVisibility(0);
        }
        this.fQE.setVisibility(0);
        this.dMQ.setVisibility(0);
    }

    protected void onDestroy() {
        if (this.eJz != null) {
            this.eJz.a(null);
            this.eJz.stop();
            this.eJz.onDetach();
            if (ak.oJ() != null) {
                ak.oJ().pT();
            }
        }
        super.onDestroy();
        s.aJE().b((a) this);
        this.iqw.destory();
    }

    protected void onResume() {
        super.onResume();
        if (this.eJz != null) {
            this.eJz.start();
        }
    }

    protected void onPause() {
        super.onPause();
        if (this.eJz != null) {
            this.eJz.stop();
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        com.tencent.mm.pluginsdk.ui.tools.a.a(this, i, i2, intent, true, 5);
        if (i2 == -1 && i == 1001) {
            String str;
            String stringExtra = intent == null ? null : intent.getStringExtra("Select_Conv_User");
            if (intent == null) {
                str = null;
            } else {
                str = intent.getStringExtra("custom_send_text");
            }
            final p a = com.tencent.mm.ui.base.g.a(this.nDR.nEl, getString(2131232670), false, null);
            v.d("MicroMsg.RecordMsgFileUI", "do share msg, fav msg type %d", new Object[]{Integer.valueOf(getType())});
            final Runnable anonymousClass13 = new Runnable(this) {
                final /* synthetic */ RecordMsgFileUI iqx;

                public final void run() {
                    a.dismiss();
                }
            };
            if (!be.kS(stringExtra)) {
                final List g = be.g(stringExtra.split(","));
                if (getType() == 4 || getType() == 15) {
                    ak.vA().x(new Runnable(this) {
                        final /* synthetic */ RecordMsgFileUI iqx;

                        public final void run() {
                            File file = new File(m.c(this.iqx.bdE, this.iqx.bao));
                            for (String str : g) {
                                if (file.exists()) {
                                    String k = this.iqx.aJS();
                                    v.d("MicroMsg.RecordMsgFileUI", "sendVideo::data path[%s] thumb path[%s]", new Object[]{file.getAbsolutePath(), k});
                                    if (this.iqx.getType() == 15) {
                                        com.tencent.mm.pluginsdk.j.a.bmt().a(this.iqx.nDR.nEl, str, file.getAbsolutePath(), k, 62, this.iqx.bdE.duration, "");
                                    } else {
                                        com.tencent.mm.pluginsdk.j.a.bmt().a(this.iqx.nDR.nEl, str, file.getAbsolutePath(), k, 1, this.iqx.bdE.duration, "");
                                    }
                                } else {
                                    String str2 = this.iqx.bdE.mrZ;
                                    if (!be.kS(str2)) {
                                        WXVideoObject wXVideoObject = new WXVideoObject();
                                        wXVideoObject.videoUrl = str2;
                                        WXMediaMessage wXMediaMessage = new WXMediaMessage(wXVideoObject);
                                        str2 = be.ah(this.iqx.bdE.title, this.iqx.nDR.nEl.getResources().getString(2131232752));
                                        wXMediaMessage.mediaObject = wXVideoObject;
                                        wXMediaMessage.title = str2;
                                        wXMediaMessage.description = this.iqx.bdE.desc;
                                        wXMediaMessage.thumbData = be.readFromFile(m.f(this.iqx.bdE, this.iqx.bao));
                                        if (wXMediaMessage.thumbData == null) {
                                            StringBuilder stringBuilder = new StringBuilder();
                                            ak.yW();
                                            wXMediaMessage.thumbData = be.readFromFile(stringBuilder.append(com.tencent.mm.model.c.xf()).append("web/").append(com.tencent.mm.a.g.m(be.ah(this.iqx.bdE.aZh, "").getBytes())).toString());
                                        }
                                        com.tencent.mm.pluginsdk.model.app.l.a(wXMediaMessage, "", "", str, 3, null);
                                    }
                                }
                                com.tencent.mm.pluginsdk.j.a.bmt().df(str, str);
                            }
                            ad.o(anonymousClass13);
                        }

                        public final String toString() {
                            return super.toString() + "|onActivityResult1";
                        }
                    });
                } else {
                    ak.vA().x(new Runnable(this) {
                        final /* synthetic */ RecordMsgFileUI iqx;

                        public final void run() {
                            String c = m.c(this.iqx.bdE, this.iqx.bao);
                            WXFileObject wXFileObject = new WXFileObject();
                            wXFileObject.setFilePath(c);
                            WXMediaMessage wXMediaMessage = new WXMediaMessage();
                            wXMediaMessage.mediaObject = wXFileObject;
                            wXMediaMessage.title = this.iqx.bdE.title;
                            wXMediaMessage.description = this.iqx.bdE.desc;
                            wXMediaMessage.thumbData = be.readFromFile(m.f(this.iqx.bdE, this.iqx.bao));
                            for (String str : g) {
                                com.tencent.mm.pluginsdk.model.app.l.a(wXMediaMessage, "", "", str, 3, null);
                                com.tencent.mm.pluginsdk.j.a.bmt().df(str, str);
                            }
                            ad.o(anonymousClass13);
                        }

                        public final String toString() {
                            return super.toString() + "|onActivityResult2";
                        }
                    });
                }
            }
        }
    }

    private String aJS() {
        File file = new File(m.f(this.bdE, this.bao));
        if (file.exists()) {
            return file.getAbsolutePath();
        }
        StringBuilder stringBuilder = new StringBuilder();
        ak.yW();
        return stringBuilder.append(com.tencent.mm.model.c.xf()).append("web/").append(com.tencent.mm.a.g.m(be.ah(this.bdE.aZh, "").getBytes())).toString();
    }

    private void b(com.tencent.mm.plugin.record.a.g gVar) {
        int max;
        int i;
        int i2 = 0;
        if (gVar != null) {
            max = (int) ((((float) gVar.field_offset) / ((float) Math.max(1, gVar.field_totalLen))) * 100.0f);
            i2 = gVar.field_offset;
            i = gVar.field_totalLen;
        } else {
            i = (int) this.bdE.msn;
            max = 0;
        }
        this.cnC.post(new Runnable(this) {
            final /* synthetic */ RecordMsgFileUI iqx;

            public final void run() {
                this.iqx.elJ.setProgress(max);
                this.iqx.fQH.setText(this.iqx.getString(2131232644, new Object[]{be.N((float) i2), be.N((float) i)}));
            }
        });
    }

    public final void a(int i, com.tencent.mm.plugin.record.a.g gVar) {
        if (gVar == null) {
            v.w("MicroMsg.RecordMsgFileUI", "on cdn info changed, but cdn info is null");
            return;
        }
        v.v("MicroMsg.RecordMsgFileUI", "cur mediaid[%s], notify mediaid[%s]", new Object[]{this.mediaId, gVar.field_mediaId});
        if (this.mediaId.equals(gVar.field_mediaId)) {
            switch (gVar.field_status) {
                case 2:
                    this.cnC.post(new Runnable(this) {
                        final /* synthetic */ RecordMsgFileUI iqx;

                        {
                            this.iqx = r1;
                        }

                        public final void run() {
                            this.iqx.iT(true);
                            this.iqx.aJR();
                        }
                    });
                    return;
                case 3:
                    this.cnC.post(new Runnable(this) {
                        final /* synthetic */ RecordMsgFileUI iqx;

                        {
                            this.iqx = r1;
                        }

                        public final void run() {
                            this.iqx.ana();
                            com.tencent.mm.ui.base.g.bf(this.iqx.nDR.nEl, this.iqx.getString(2131232297));
                        }
                    });
                    return;
                case 4:
                    this.cnC.post(new Runnable(this) {
                        final /* synthetic */ RecordMsgFileUI iqx;

                        {
                            this.iqx = r1;
                        }

                        public final void run() {
                            this.iqx.amY();
                        }
                    });
                    return;
                default:
                    b(gVar);
                    return;
            }
        }
    }
}
