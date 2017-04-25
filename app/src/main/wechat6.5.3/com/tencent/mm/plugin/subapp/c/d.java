package com.tencent.mm.plugin.subapp.c;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.RingtoneManager;
import android.net.Uri;
import com.tencent.mm.bg.g.c;
import com.tencent.mm.e.a.ls;
import com.tencent.mm.e.a.qe;
import com.tencent.mm.e.a.qf;
import com.tencent.mm.e.b.bx;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ab.e;
import com.tencent.mm.model.ab.g;
import com.tencent.mm.model.ag;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.m;
import com.tencent.mm.platformtools.g.a;
import com.tencent.mm.plugin.subapp.ui.voicereminder.RemindDialog;
import com.tencent.mm.pluginsdk.j.o;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SuppressLint({"UseSparseArrays"})
public class d implements g, ag {
    private static HashMap<Integer, c> ius;
    private static d kfu;
    private final Set<e> cbh = new HashSet();
    private String cka;
    private a iut;
    private k kft;
    private j kfv;
    private List<Long> kfw = new ArrayList();
    private com.tencent.mm.sdk.c.c kfx = new com.tencent.mm.sdk.c.c<qf>(this) {
        final /* synthetic */ d kfA;

        {
            this.kfA = r2;
            this.nhz = qf.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            qf qfVar = (qf) bVar;
            e Cs = e.Cs(qfVar.bru.blq);
            bx bxVar = qfVar.bru.aXd;
            if (Cs != null) {
                d aZu = d.aZu();
                String str = bxVar.field_talker;
                String str2 = qfVar.bru.description;
                String H = o.H(aa.getContext(), Cs.kfB);
                String str3 = SQLiteDatabase.KeyEmpty;
                if (H != null && H.length() > 0) {
                    String[] split = H.split(";");
                    str3 = str3 + split[0];
                    if (split.length > 1) {
                        str3 = str3 + split[1];
                    }
                }
                if (str2 != null) {
                    str3 = str3 + str2;
                }
                aZu.e(str, str3, bxVar.field_createTime);
            }
            return false;
        }
    };
    private com.tencent.mm.sdk.c.c kfy = new com.tencent.mm.sdk.c.c<qe>(this) {
        final /* synthetic */ d kfA;

        {
            this.kfA = r2;
            this.nhz = qe.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            String str = ((qe) bVar).brt.path;
            if (str != null) {
                String as = h.as(str, false);
                if (!be.kS(as)) {
                    d.aZv().hc(as);
                }
                d.aZv().lD(str);
                new File(str).delete();
            }
            return false;
        }
    };
    private com.tencent.mm.sdk.c.c kfz = new com.tencent.mm.sdk.c.c<ls>(this) {
        final /* synthetic */ d kfA;

        {
            this.kfA = r2;
            this.nhz = ls.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            int i = (int) ((ls) bVar).bmW.aXd.field_msgId;
            ak.yW();
            at ek = com.tencent.mm.model.c.wJ().ek((long) i);
            if (!(ek.field_msgId == 0 || ek.field_imgPath == null || be.kS(ek.field_imgPath))) {
                g Ct = h.Ct(ek.field_imgPath);
                if (!(Ct == null || be.kS(Ct.field_filename))) {
                    Ct.field_status = 3;
                    Ct.field_offset = 0;
                    Ct.field_createtime = System.currentTimeMillis() / 1000;
                    Ct.field_lastmodifytime = System.currentTimeMillis() / 1000;
                    Ct.bkU = 16840;
                    h.a(Ct);
                    v.d("MicroMsg.VoiceRemindLogic", " file:" + Ct.field_filename + " msgid:" + Ct.field_msglocalid + "  stat:" + Ct.field_status);
                    if (Ct.field_msglocalid == 0 || be.kS(Ct.field_user)) {
                        v.e("MicroMsg.VoiceRemindLogic", " failed msg id:" + Ct.field_msglocalid + " user:" + Ct.field_user);
                    } else {
                        ek.dh(1);
                        ak.yW();
                        com.tencent.mm.model.c.wJ().a(ek.field_msgId, ek);
                        d.aZw().run();
                    }
                }
            }
            return false;
        }
    };

    static {
        HashMap hashMap = new HashMap();
        ius = hashMap;
        hashMap.put(Integer.valueOf("VOICEREMIND_TABLE".hashCode()), new c() {
            public final String[] pS() {
                return k.cic;
            }
        });
    }

    public final void a(e eVar) {
        v.d("MicroMsg.SubCoreVoiceRemind", "addVoiceRemind ");
        if (eVar != null) {
            this.cbh.add(eVar);
        }
    }

    public final void b(e eVar) {
        v.d("MicroMsg.SubCoreVoiceRemind", "removeVoiceRemind ");
        if (eVar != null) {
            this.cbh.remove(eVar);
        }
    }

    public final void e(String str, String str2, long j) {
        Context context = aa.getContext();
        if (context == null) {
            v.d("MicroMsg.SubCoreVoiceRemind", "notifyVoiceRemind context null");
            return;
        }
        try {
            boolean sx = com.tencent.mm.h.a.sx();
            boolean sv = com.tencent.mm.h.a.sv();
            v.d("MicroMsg.SubCoreVoiceRemind", "shake " + sx + "sound " + sv);
            if (!m.fa(ak.oH().qr())) {
                if (sx) {
                    be.j(context, true);
                }
                if (sv) {
                    String sw = com.tencent.mm.h.a.sw();
                    Uri defaultUri = sw == com.tencent.mm.ui.d.c.cgI ? RingtoneManager.getDefaultUri(2) : Uri.parse(sw);
                    MediaPlayer mediaPlayer = new MediaPlayer();
                    try {
                        mediaPlayer.setDataSource(context, defaultUri);
                        mediaPlayer.setOnCompletionListener(new OnCompletionListener(this) {
                            final /* synthetic */ d kfA;

                            {
                                this.kfA = r1;
                            }

                            public final void onCompletion(MediaPlayer mediaPlayer) {
                                try {
                                    mediaPlayer.release();
                                } catch (Throwable e) {
                                    v.a("MicroMsg.SubCoreVoiceRemind", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                                }
                            }
                        });
                        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
                        if (audioManager.getStreamVolume(5) != 0) {
                            if (audioManager.isWiredHeadsetOn()) {
                                int streamVolume = audioManager.getStreamVolume(8);
                                int streamMaxVolume = audioManager.getStreamMaxVolume(8);
                                int streamVolume2 = audioManager.getStreamVolume(5);
                                if (streamVolume2 <= streamMaxVolume) {
                                    streamMaxVolume = streamVolume2;
                                }
                                audioManager.setStreamVolume(8, streamMaxVolume, 0);
                                mediaPlayer.setAudioStreamType(8);
                                mediaPlayer.setLooping(true);
                                mediaPlayer.prepare();
                                mediaPlayer.setLooping(false);
                                mediaPlayer.start();
                                audioManager.setStreamVolume(8, streamVolume, 0);
                                v.d("MicroMsg.SubCoreVoiceRemind", "oldVolume is %d, toneVolume is %d", Integer.valueOf(streamVolume), Integer.valueOf(streamMaxVolume));
                            } else {
                                mediaPlayer.setAudioStreamType(5);
                                mediaPlayer.setLooping(true);
                                mediaPlayer.prepare();
                                mediaPlayer.setLooping(false);
                                mediaPlayer.start();
                            }
                        }
                    } catch (Throwable e) {
                        v.a("MicroMsg.SubCoreVoiceRemind", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                        mediaPlayer.release();
                    } catch (Throwable e2) {
                        v.a("MicroMsg.SubCoreVoiceRemind", e2, "relese error", new Object[0]);
                    }
                }
            } else if (sx) {
                be.j(context, true);
            }
        } catch (Throwable e22) {
            v.a("MicroMsg.SubCoreVoiceRemind", e22, SQLiteDatabase.KeyEmpty, new Object[0]);
        }
        if (this.cbh == null || this.cbh.size() == 0) {
            RemindDialog.r(context, str, str2);
            return;
        }
        for (e g : this.cbh) {
            g.g(str2, j);
        }
    }

    public final void fE(String str) {
        ak.yW();
        com.tencent.mm.model.c.wK().Mj(str);
        this.kfw.clear();
        ak.yW();
        Cursor MR = com.tencent.mm.model.c.wJ().MR(str);
        MR.moveToFirst();
        v.d("MicroMsg.SubCoreVoiceRemind", "resetSilentQuene");
        while (!MR.isAfterLast()) {
            bx atVar = new at();
            atVar.b(MR);
            long j = atVar.field_msgId;
            v.d("MicroMsg.SubCoreVoiceRemind", "resetSilentQuene: msgId = " + j + " status = " + atVar.field_status);
            MR.moveToNext();
            this.kfw.add(Long.valueOf(j));
        }
        MR.close();
        ak.yW();
        com.tencent.mm.model.c.wJ().MP(str);
    }

    public final void yH() {
        aZw().run();
    }

    public final boolean K(long j) {
        boolean contains = this.kfw.contains(Long.valueOf(j));
        v.d("MicroMsg.SubCoreVoiceRemind", "silent " + contains + "  mid " + j);
        return contains;
    }

    public static d aZu() {
        com.tencent.mm.plugin.subapp.a aVar = (com.tencent.mm.plugin.subapp.a) ak.yP().fY("plugin.subapp");
        kfu = (d) aVar.Cq(d.class.getName());
        v.d("MicroMsg.SubCoreVoiceRemind", "summervoice SubCoreVoiceRemind getCore subCoreSubapp[%s], theCore[%s], stack[%s]", aVar, kfu, be.bur());
        if (kfu == null) {
            g dVar = new d();
            kfu = dVar;
            ab.a.csd = dVar;
            aVar.b(d.class.getName(), kfu);
        }
        return kfu;
    }

    public static k aZv() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new com.tencent.mm.model.b();
        }
        if (aZu().kft == null) {
            d aZu = aZu();
            aZu();
            if (aZu().iut == null) {
                StringBuilder stringBuilder = new StringBuilder();
                ak.yW();
                String stringBuilder2 = stringBuilder.append(com.tencent.mm.model.c.xp()).append("CommonOneMicroMsg.db").toString();
                aZu().iut = com.tencent.mm.platformtools.g.a(d.class.hashCode(), stringBuilder2, ius, false);
            }
            aZu.kft = new k(aZu().iut);
        }
        return aZu().kft;
    }

    public final HashMap<Integer, c> ti() {
        return null;
    }

    public final void ed(int i) {
    }

    public final void aG(boolean z) {
        StringBuilder stringBuilder = new StringBuilder();
        ak.yW();
        stringBuilder.append(com.tencent.mm.model.c.xp()).append("CommonOneMicroMsg.db");
        aZv();
        com.tencent.mm.sdk.c.a.nhr.e(this.kfx);
        com.tencent.mm.sdk.c.a.nhr.e(this.kfy);
        com.tencent.mm.sdk.c.a.nhr.e(this.kfz);
        v.d("MicroMsg.SubCoreVoiceRemind", "summervoiceremind onAccountPostReset hash[%d]", Integer.valueOf(hashCode()));
    }

    public final void aH(boolean z) {
        ak.yW();
        String xq = com.tencent.mm.model.c.xq();
        if (be.kS(xq) || be.kS(this.cka) || !xq.equals(this.cka)) {
            v.d("MicroMsg.SubCoreVoiceRemind", "setVoiceRemindPath core on accPath : " + xq);
            this.cka = xq;
            File file = new File(xq);
            if (!file.exists()) {
                file.mkdirs();
            }
            ak.yW();
            File file2 = new File(com.tencent.mm.model.c.xk());
            if (!file2.exists()) {
                file2.mkdirs();
            }
        }
    }

    public final void th() {
        if (this.kfv != null) {
            this.kfv.aVw = 0;
        }
        if (kfu != null) {
            v.d("MicroMsg.SubCoreVoiceRemind", "SubCoreVoiceRemind close db");
            d dVar = kfu;
            if (dVar.iut != null) {
                dVar.iut.gG(dVar.hashCode());
                dVar.iut = null;
            }
            dVar.cka = SQLiteDatabase.KeyEmpty;
        }
        com.tencent.mm.sdk.c.a.nhr.f(this.kfx);
        com.tencent.mm.sdk.c.a.nhr.f(this.kfy);
        com.tencent.mm.sdk.c.a.nhr.f(this.kfz);
    }

    public static j aZw() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new com.tencent.mm.model.b();
        }
        if (aZu().kfv == null) {
            aZu().kfv = new j();
        }
        return aZu().kfv;
    }
}
