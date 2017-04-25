package com.tencent.mm.plugin.wear.model.e;

import com.tencent.mm.c.c.d;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.wear.model.d.c;
import com.tencent.mm.protocal.c.bin;
import com.tencent.mm.protocal.c.bio;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.OutputStream;
import java.util.LinkedList;

public final class p implements e {
    public static final String lce = (t.cng + "tmp_wearvoicetotext.spx");
    public boolean cFQ = false;
    public c lcf;
    public com.tencent.qqpinyin.voicerecoapi.c lcg;
    public d lch;
    private int lci = 0;
    public int lcj;
    public int lck;
    public LinkedList<Integer> lcl = new LinkedList();

    class AnonymousClass1 implements Runnable {
        final /* synthetic */ String chh;
        final /* synthetic */ p lcm;

        public AnonymousClass1(p pVar, String str) {
            this.lcm = pVar;
            this.chh = str;
        }

        public final void run() {
            this.lcm.lcf = new c(p.lce, this.chh, this.lcm.lcj);
            ak.vy().a(349, this.lcm);
            v.i("MicroMsg.Wear.VoiceToTextServer", "Create NetSceneVoiceInput");
        }
    }

    class a extends com.tencent.mm.plugin.wear.model.f.c {
        public int iwf;
        public int lbw = 2;
        public int lbx;
        final /* synthetic */ p lcm;
        public bio lcn;

        public a(p pVar, int i, bio com_tencent_mm_protocal_c_bio) {
            this.lcm = pVar;
            this.iwf = i;
            this.lbx = 30001;
            this.lcn = com_tencent_mm_protocal_c_bio;
        }

        protected final void send() {
            try {
                byte[] aP = com.tencent.mm.plugin.wear.model.a.bhH().laR.aP(this.lcn.toByteArray());
                OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
                try {
                    dataOutputStream.writeInt(this.lbw);
                    dataOutputStream.writeInt(this.iwf);
                    dataOutputStream.writeInt(this.lbx);
                    if (aP == null || aP.length <= 0) {
                        dataOutputStream.writeInt(0);
                    } else {
                        dataOutputStream.writeInt(aP.length);
                        dataOutputStream.write(aP);
                    }
                    aP = byteArrayOutputStream.toByteArray();
                    v.i("MicroMsg.Wear.VoiceToTextServer", "send data findId=%d length=%d", new Object[]{Integer.valueOf(this.lbx), Integer.valueOf(aP.length)});
                    com.tencent.mm.plugin.wear.model.a.bhH().laR.aN(byteArrayOutputStream.toByteArray());
                } catch (Throwable e) {
                    v.a("MicroMsg.Wear.VoiceToTextServer", e, "gen response data error connectType=%d, sessionId=%d, funId=%d", new Object[]{Integer.valueOf(this.lbw), Integer.valueOf(this.iwf), Integer.valueOf(this.lbx)});
                }
            } catch (Throwable e2) {
                v.a("MicroMsg.Wear.VoiceToTextServer", e2, "", new Object[0]);
            }
        }

        public final String getName() {
            return "WearVoiceToTextTask";
        }
    }

    public final void reset() {
        v.i("MicroMsg.Wear.VoiceToTextServer", "reset: sessionId=%s", new Object[]{Integer.valueOf(this.lcj)});
        if (this.lch != null) {
            this.lch.pv();
            this.lch = null;
            v.i("MicroMsg.Wear.VoiceToTextServer", "reset speexWriter");
        }
        if (this.lcg != null) {
            this.lcg.stop();
            this.lcg = null;
            v.i("MicroMsg.Wear.VoiceToTextServer", "reset voiceDetectAPI");
        }
        if (this.lcf != null) {
            this.lcf.diB = true;
            ak.vy().b(349, this);
            ak.vy().c(this.lcf);
            this.lcf = null;
        }
        this.lck = 0;
        this.cFQ = false;
        this.lci = 0;
        this.lcj = -1;
        this.lcl.clear();
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar instanceof c) {
            c cVar = (c) kVar;
            bio com_tencent_mm_protocal_c_bio;
            if (i != 0 || i2 != 0) {
                ak.vy().b(349, this);
                com_tencent_mm_protocal_c_bio = new bio();
                com_tencent_mm_protocal_c_bio.ncy = cVar.bdo;
                com_tencent_mm_protocal_c_bio.mzO = "";
                com_tencent_mm_protocal_c_bio.lZu = -1;
                com_tencent_mm_protocal_c_bio.ndd = false;
                com.tencent.mm.plugin.wear.model.a.bhH().laX.a(new a(this, cVar.iwf, com_tencent_mm_protocal_c_bio));
            } else if (cVar.lbV) {
                ak.vy().b(349, this);
                com_tencent_mm_protocal_c_bio = new bio();
                com_tencent_mm_protocal_c_bio.ncy = cVar.bdo;
                if (be.kS(cVar.lbU)) {
                    com_tencent_mm_protocal_c_bio.mzO = "";
                    com_tencent_mm_protocal_c_bio.lZu = -1;
                    com_tencent_mm_protocal_c_bio.ndd = false;
                } else {
                    v.i("MicroMsg.Wear.VoiceToTextServer", "receive text: %s", new Object[]{cVar.lbU});
                    com_tencent_mm_protocal_c_bio.mzO = cVar.lbU;
                    com_tencent_mm_protocal_c_bio.lZu = 0;
                    com_tencent_mm_protocal_c_bio.ndd = true;
                }
                com.tencent.mm.plugin.wear.model.a.bhH().laX.a(new a(this, cVar.iwf, com_tencent_mm_protocal_c_bio));
            }
        }
    }

    public final void a(int i, bin com_tencent_mm_protocal_c_bin) {
        if (com_tencent_mm_protocal_c_bin.mdy == null) {
            v.i("MicroMsg.Wear.VoiceToTextServer", "voice data is null");
            return;
        }
        byte[] toByteArray = com_tencent_mm_protocal_c_bin.mdy.toByteArray();
        this.lci += this.lch.a(new com.tencent.mm.c.b.g.a(toByteArray, com_tencent_mm_protocal_c_bin.mff), 0);
        v.i("MicroMsg.Wear.VoiceToTextServer", "write bytes: %d", new Object[]{Integer.valueOf(this.lci)});
        short[] sArr = new short[(com_tencent_mm_protocal_c_bin.mff / 2)];
        for (int i2 = 0; i2 < com_tencent_mm_protocal_c_bin.mff / 2; i2++) {
            sArr[i2] = (short) ((toByteArray[i2 * 2] & 255) | (toByteArray[(i2 * 2) + 1] << 8));
        }
        com.tencent.qqpinyin.voicerecoapi.c.a aVar = new com.tencent.qqpinyin.voicerecoapi.c.a();
        this.lcg.a(sArr, com_tencent_mm_protocal_c_bin.mff / 2, aVar);
        v.i("MicroMsg.Wear.VoiceToTextServer", "state.vad_flag: " + aVar.ptC);
        if (aVar.ptC == 2) {
            this.lck = 1;
        } else if (aVar.ptC == 3) {
            this.lck = 2;
        }
        if (this.lck != 0) {
            if (this.lck < 0) {
                if (this.lcl.size() > 10) {
                    this.lcl.removeLast();
                }
                this.lcl.addFirst(Integer.valueOf(i));
            }
            if (this.lck == 1) {
                bio com_tencent_mm_protocal_c_bio = new bio();
                com_tencent_mm_protocal_c_bio.ncy = this.lcf.bdo;
                com_tencent_mm_protocal_c_bio.mzO = "";
                com_tencent_mm_protocal_c_bio.lZu = this.lck;
                com_tencent_mm_protocal_c_bio.ndd = true;
                com.tencent.mm.plugin.wear.model.a.bhH().laX.a(new a(this, this.lcf.iwf, com_tencent_mm_protocal_c_bio));
                this.lck = 0;
            }
        }
        if (!this.cFQ && this.lci > 3300) {
            this.cFQ = true;
            ak.vy().a(this.lcf, 0);
        }
    }
}
