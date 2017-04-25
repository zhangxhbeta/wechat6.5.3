package com.tencent.mm.plugin.music.ui;

import android.content.Intent;
import android.graphics.PorterDuff.Mode;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.view.ViewPager.e;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.Toast;
import com.tencent.mars.comm.NetStatusUtil;
import com.tencent.mm.e.a.id;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.music.a.d;
import com.tencent.mm.plugin.music.a.f;
import com.tencent.mm.plugin.music.a.h;
import com.tencent.mm.plugin.music.a.i;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.ajr;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.v.k;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

@com.tencent.mm.ui.base.a(19)
public class MusicMainUI extends MMActivity implements e, com.tencent.mm.v.e {
    private c dHB = new c<id>(this) {
        final /* synthetic */ MusicMainUI hEy;

        {
            this.hEy = r2;
            this.nhz = id.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            final id idVar = (id) bVar;
            switch (idVar.bif.action) {
                case 0:
                case 1:
                    this.hEy.hEp.setChecked(false);
                    break;
                case 2:
                case 3:
                case 4:
                    this.hEy.hEp.setChecked(true);
                    break;
                case 5:
                    ao.T(this.hEy.nDR.nEl, 2131235255);
                    ad.o(new Runnable(this) {
                        final /* synthetic */ AnonymousClass2 hEz;

                        {
                            this.hEz = r1;
                        }

                        public final void run() {
                            h.C(this.hEz.hEy);
                            this.hEz.hEy.aDr();
                        }
                    });
                    break;
                case 6:
                    ad.o(new Runnable(this) {
                        final /* synthetic */ AnonymousClass2 hEz;

                        public final void run() {
                            a h = this.hEz.hEy.hEu;
                            com.tencent.mm.ai.a aVar = idVar.bif.big;
                            for (Entry value : h.hDX.entrySet()) {
                                com.tencent.mm.plugin.music.ui.a.a aVar2 = (com.tencent.mm.plugin.music.ui.a.a) ((View) value.getValue()).getTag();
                                if (aVar2.big.field_musicId.equals(aVar.field_musicId)) {
                                    aVar2.f(aVar, true);
                                }
                            }
                        }
                    });
                    break;
                case 7:
                    if (i.aDd().mode == 2) {
                        ad.o(new Runnable(this) {
                            final /* synthetic */ AnonymousClass2 hEz;

                            {
                                this.hEz = r1;
                            }

                            public final void run() {
                                this.hEz.hEy.hEs.Z(this.hEz.hEy.hEs.xB + 1);
                            }
                        });
                        break;
                    }
                    break;
            }
            return false;
        }
    };
    private long evy;
    private com.tencent.mm.plugin.music.a.e.a hCK = new com.tencent.mm.plugin.music.a.e.a(this) {
        final /* synthetic */ MusicMainUI hEy;

        {
            this.hEy = r1;
        }

        public final void bY(int i, int i2) {
            if (this.hEy.mode == 1) {
                float floatExtra = this.hEy.getIntent().getFloatExtra("key_offset", 0.0f);
                floatExtra *= 1000.0f;
                long currentTimeMillis = (long) (floatExtra + ((float) (System.currentTimeMillis() - this.hEy.getIntent().getLongExtra("music_player_beg_time", 0))));
                if (currentTimeMillis >= 0) {
                    this.hEy.hEu.u(this.hEy.hEs.xB, currentTimeMillis);
                }
            } else if (i >= 0 && i2 > 0) {
                this.hEy.hEu.u(this.hEy.hEs.xB, (long) i);
            }
        }
    };
    private CheckBox hEp;
    private ImageButton hEq;
    private ImageButton hEr;
    private MusicViewPager hEs;
    private com.tencent.mm.pluginsdk.n.c hEt;
    private a hEu;
    private int hEv = 0;
    private ac hEw = new ac(Looper.getMainLooper());
    private int hEx = -1;
    private int mode;
    private boolean pRh;
    private int scene;

    private class a implements Runnable {
        final /* synthetic */ MusicMainUI hEy;
        int position;

        public a(MusicMainUI musicMainUI, int i) {
            this.hEy = musicMainUI;
            this.position = i;
        }

        public final void run() {
            f aDd = i.aDd();
            int i = this.position;
            if (aDd.hCP.size() != 0) {
                i = (i - 100000) % aDd.hCP.size();
                if (i < 0) {
                    i += aDd.hCP.size();
                }
                if (i != aDd.hCO) {
                    aDd.hCO = i;
                    aDd.f(null);
                }
            }
            com.tencent.mm.ai.a aCW = i.aDd().aCW();
            if (aCW != null) {
                if (aCW.Hy()) {
                    this.hEy.i(aCW);
                }
                if (i.aDd().aCZ()) {
                    this.hEy.hEs.CM = true;
                }
                this.hEy.h(aCW);
            }
        }
    }

    private class b extends com.tencent.mm.pluginsdk.n.c.a {
        final /* synthetic */ MusicMainUI hEy;

        private b(MusicMainUI musicMainUI) {
            this.hEy = musicMainUI;
        }

        public final void aDu() {
            v.i("MicroMsg.Music.MusicMainUI", "shake %b", new Object[]{Boolean.valueOf(true)});
            long az = be.az(this.hEy.evy);
            if (az < 1200) {
                v.i("MicroMsg.Music.MusicMainUI", "tryStartShake delay too short:" + az);
                return;
            }
            v.w("MicroMsg.Music.MusicMainUI", "tryStartShake delay too enough:" + az);
            this.hEy.evy = be.Nj();
            this.hEy.hEv = this.hEy.hEv + 1;
            if (this.hEy.hEv % 2 == 0) {
                f aDd = i.aDd();
                int e = this.hEy.scene;
                g.iuh.a(285, 2, 1, false);
                id idVar;
                if (aDd.mode != 1) {
                    aDd.mode = 1;
                    idVar = new id();
                    idVar.bif.action = 5;
                    com.tencent.mm.sdk.c.a.nhr.z(idVar);
                    com.tencent.mm.plugin.music.a.g.G(2, 1, e);
                } else if (aDd.hCS) {
                    v.i("MicroMsg.Music.MusicPlayerManager", "already running get list");
                } else {
                    aDd.mode = 2;
                    if (aDd.hCP.size() <= 1) {
                        aDd.aCY();
                    } else {
                        idVar = new id();
                        idVar.bif.action = 5;
                        com.tencent.mm.sdk.c.a.nhr.z(idVar);
                    }
                    com.tencent.mm.plugin.music.a.g.G(1, 2, e);
                }
            }
        }

        public final void onRelease() {
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.nDR.bAj();
        this.mode = getIntent().getIntExtra("key_mode", 2);
        this.scene = getIntent().getIntExtra("key_scene", 0);
        this.pRh = getIntent().getBooleanExtra("KGlobalShakeMusic", false);
        this.hEs = (MusicViewPager) findViewById(2131758378);
        this.hEu = new a(this, this.scene, this.pRh);
        this.hEs.a(this.hEu);
        this.hEs.b(this);
        this.hEs.setSystemUiVisibility(Downloads.RECV_BUFFER_SIZE);
        this.hEq = (ImageButton) findViewById(2131758380);
        this.hEr = (ImageButton) findViewById(2131758381);
        this.hEp = (CheckBox) findViewById(2131758379);
        this.hEp.setChecked(!i.aDd().hCQ.HC());
        this.hEt = new com.tencent.mm.pluginsdk.n.c(this);
        this.hEp.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ MusicMainUI hEy;

            {
                this.hEy = r1;
            }

            public final void onClick(View view) {
                if (this.hEy.hEp.isChecked()) {
                    com.tencent.mm.ai.b.rb();
                    this.hEy.hEp.setChecked(true);
                    MusicMainUI.aDt();
                    return;
                }
                if (i.aDd().hCQ.hCI) {
                    i.aDd().hCQ.resume();
                } else {
                    i.aDd().f(null);
                }
                this.hEy.aDs();
                this.hEy.hEp.setChecked(false);
            }
        });
        com.tencent.mm.sdk.c.a.nhr.e(this.dHB);
        if (!this.hEt.bou()) {
            v.w("MicroMsg.Music.MusicMainUI", "not support shake");
        }
        aDr();
        this.hEs.Z(100000 + i.aDd().hCO);
        aDs();
        int i = this.scene;
        if (i.aDd().aCW() != null) {
            v.v("MicroMsg.Music.MusicReportUtil", "kvReportEnterMusicUI: %d, %d, %s, %s, %s, %s, %s, %s", new Object[]{Integer.valueOf(13041), Integer.valueOf(i), i.aDd().aCW().field_musicId, i.aDd().aCW().field_songName, i.aDd().aCW().field_songAlbum, Integer.valueOf(i.aDd().aCW().field_songId), i.aDd().aCW().field_songSinger, i.aDd().aCW().field_appId});
            g.iuh.h(13041, new Object[]{Integer.valueOf(i), r2.field_musicId, r2.field_songName, r2.field_songAlbum, Integer.valueOf(r2.field_songId), r2.field_songSinger, r2.field_appId});
        }
        g.iuh.a(285, 1, 1, false);
        com.tencent.mm.ai.a aCW = i.aDd().aCW();
        if (aCW == null) {
            finish();
            return;
        }
        if (this.scene == 4 && i.aDd().mode == 2) {
            ak.yW();
            int i2 = com.tencent.mm.model.c.vf().getInt(83, 0);
            if (i2 < 3) {
                Toast.makeText(this, 2131233010, 0).show();
                i2++;
                ak.yW();
                com.tencent.mm.model.c.vf().set(83, Integer.valueOf(i2));
            }
        }
        h(aCW);
    }

    public final void a(int i, int i2, String str, k kVar) {
    }

    protected void onResume() {
        byte b;
        super.onResume();
        com.tencent.mm.ai.a aCW = i.aDd().aCW();
        if (aCW != null) {
            switch (aCW.field_musicType) {
                case 1:
                case 4:
                case 6:
                case 8:
                case NetStatusUtil.MOBILE /*9*/:
                    b = (byte) 1;
                    break;
            }
        }
        b = (byte) 0;
        if (b == (byte) 0 || this.pRh) {
            v.i("MicroMsg.Music.MusicMainUI", "no need to shake music");
            return;
        }
        if (!(this.hEt == null || !this.hEt.bou() || this.hEt.bos())) {
            this.hEt.a(new b());
        }
        this.evy = be.Nj();
    }

    protected void onPause() {
        super.onPause();
        if (this.hEt != null) {
            this.hEt.arf();
        }
    }

    private void aDr() {
        i.aDd();
        this.hEu.count = 200000;
        this.hEu.notifyDataSetChanged();
        if (i.aDd().aCZ()) {
            this.hEs.CM = true;
        } else {
            this.hEs.CM = false;
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.hEt != null) {
            this.hEt.arf();
        }
        if (this.hEu != null) {
            a aVar = this.hEu;
            aVar.hCx.removeCallbacksAndMessages(null);
            d dVar = aVar.hDY;
            dVar.hCx.removeCallbacksAndMessages(null);
            dVar.bYS.clear();
        }
        com.tencent.mm.sdk.c.a.nhr.f(this.dHB);
        aDt();
        if (!i.aDd().hCQ.HC()) {
            i.aDd().hCQ.XV();
        }
        f aDd = i.aDd();
        if (!aDd.hCQ.HC()) {
            v.i("MicroMsg.Music.MusicPlayerManager", "really exit music");
            aDd.mode = 1;
        }
    }

    public void onClickBack(View view) {
        finish();
    }

    public void onClickSend(View view) {
        List arrayList = new ArrayList();
        String[] strArr = new String[]{getString(2131236667), getString(2131236668), getString(2131231780), getString(2131232637)};
        arrayList.add(Integer.valueOf(0));
        arrayList.add(Integer.valueOf(1));
        arrayList.add(Integer.valueOf(2));
        arrayList.add(Integer.valueOf(3));
        com.tencent.mm.ui.base.g.a(this, "", strArr, "", new com.tencent.mm.ui.base.g.c(this) {
            final /* synthetic */ MusicMainUI hEy;

            {
                this.hEy = r1;
            }

            public final void gT(int i) {
                ajr aCX = i.aDd().aCX();
                switch (i) {
                    case 0:
                        h.B(this.hEy);
                        return;
                    case 1:
                        h.c(aCX, this.hEy);
                        return;
                    case 2:
                        h.a(aCX, this.hEy);
                        return;
                    case 3:
                        h.b(aCX, this.hEy);
                        return;
                    default:
                        return;
                }
            }
        });
    }

    protected final int getLayoutId() {
        return 2130904105;
    }

    public final void a(int i, float f, int i2) {
    }

    private void h(com.tencent.mm.ai.a aVar) {
        if (!h.e(aVar) || this.pRh) {
            this.hEp.setVisibility(8);
            this.hEr.setVisibility(8);
            return;
        }
        this.hEp.setVisibility(0);
        this.hEr.setVisibility(0);
    }

    public final void W(int i) {
        v.i("MicroMsg.Music.MusicMainUI", "onPageSelected %d", new Object[]{Integer.valueOf(i)});
        if (i.aDd().aCZ()) {
            this.hEs.CM = false;
        }
        this.hEw.removeCallbacksAndMessages(null);
        this.hEw.postDelayed(new a(this, i), 500);
        if (this.hEx == -1) {
            this.hEx = i;
        }
        if (this.hEx != i) {
            this.hEx = i;
            com.tencent.mm.plugin.music.a.g.hCV = true;
            g.iuh.a(285, 3, 1, false);
            com.tencent.mm.plugin.music.a.g.bZ(1, this.scene);
        }
    }

    public final void X(int i) {
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (-1 == i2 && 1 == i) {
            if (intent != null) {
                h.a(i.aDd().aCX(), intent, this);
                return;
            }
            v.e("MicroMsg.Music.MusicMainUI", "error on ActivityResult data == null");
        }
        super.onActivityResult(i, i2, intent);
    }

    public final void aDs() {
        i.aDd().hCQ.hCK = this.hCK;
    }

    public static void aDt() {
        i.aDd().hCQ.hCK = null;
    }

    public final void i(com.tencent.mm.ai.a aVar) {
        com.tencent.mm.ai.a aCW = i.aDd().aCW();
        if (aCW != null && aCW.a(aVar) && this.hEr != null && this.hEq != null && this.hEp != null && this.hEr.getBackground() != null && this.hEq.getBackground() != null && this.hEp.getBackground() != null) {
            if (aVar.Hy()) {
                int i = aVar.field_songLyricColor;
                this.hEr.getBackground().setColorFilter(i, Mode.MULTIPLY);
                this.hEq.getBackground().setColorFilter(i, Mode.MULTIPLY);
                this.hEp.getBackground().setColorFilter(i, Mode.MULTIPLY);
                return;
            }
            this.hEr.getBackground().setColorFilter(-1, Mode.MULTIPLY);
            this.hEq.getBackground().setColorFilter(-1, Mode.MULTIPLY);
            this.hEp.getBackground().setColorFilter(-1, Mode.MULTIPLY);
        }
    }
}
