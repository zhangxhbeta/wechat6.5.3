package com.tencent.mm.network;

import com.tencent.mm.a.g;
import com.tencent.mm.model.am;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.s;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

public final class a extends com.tencent.mm.network.d.a implements c {
    byte[] cAN;
    private byte[] dlf;
    private a dlg = null;
    byte[] dlh;
    String dli;
    private Map<String, byte[]> dlj = new HashMap();
    private boolean foreground = true;
    private int uin;
    String username;

    public interface a {
    }

    public a(a aVar) {
        this.dlg = aVar;
        LW();
    }

    public final void reset() {
        v.i("MicroMsg.AccInfo", "reset accinfo");
        this.username = SQLiteDatabase.KeyEmpty;
        this.dlf = null;
        LW();
        this.uin = 0;
    }

    private void LW() {
        this.cAN = be.KG(am.zc().getString("server_id", SQLiteDatabase.KeyEmpty));
    }

    public final void setUsername(String str) {
        this.username = str;
    }

    public final void i(byte[] bArr, int i) {
        this.dlf = bArr;
        this.uin = i;
        if (this.dlg != null) {
            BQ();
        }
        v.d("MicroMsg.AccInfo", "summerauth update session info: session:%s, uin:%d stack:[%s]", be.KW(be.bk(bArr)), Integer.valueOf(i), be.bur());
    }

    public final void F(byte[] bArr) {
        this.cAN = bArr;
    }

    public final void G(byte[] bArr) {
        this.dlh = bArr;
    }

    public final byte[] uT() {
        return this.dlf;
    }

    public final byte[] BR() {
        return this.dlh;
    }

    public final byte[] BP() {
        return this.cAN;
    }

    public final String getUsername() {
        return this.username;
    }

    public final int ww() {
        return this.uin;
    }

    public final boolean BQ() {
        return this.dlf != null && this.dlf.length > 0;
    }

    public final String toString() {
        return ((((("AccInfo:\n" + "|-uin     =" + ww() + "\n") + "|-user    =" + getUsername() + "\n") + "|-wxuser  =" + Cn() + "\n") + "|-session =" + be.bk(uT()) + "\n") + "|-ecdhkey =" + be.bk(BR()) + "\n") + "`-cookie  =" + be.bk(BP());
    }

    public final void lK(String str) {
        this.dli = str;
    }

    public final String Cn() {
        return this.dli;
    }

    public final void h(String str, byte[] bArr) {
        this.dlj.put(str, bArr);
    }

    public final byte[] gS(String str) {
        return (byte[]) this.dlj.get(str);
    }

    public final boolean BS() {
        return this.foreground;
    }

    public final void aS(boolean z) {
        this.foreground = z;
        v.i("MicroMsg.AccInfo", "somr accinfo setForegroundMuteRoom :%b", Boolean.valueOf(this.foreground));
    }

    private void clear() {
        this.username = null;
        this.dlf = null;
        this.cAN = null;
        this.uin = 0;
        this.dlh = null;
        this.dli = null;
    }

    private String LX() {
        try {
            ByteBuffer allocate = ByteBuffer.allocate(4096);
            allocate.put(this.dlf).put(this.dlh).put(this.cAN).putInt(this.uin).put(this.dli.getBytes()).put(this.username.getBytes());
            return g.m(allocate.array());
        } catch (Exception e) {
            return SQLiteDatabase.KeyEmpty;
        }
    }

    public final byte[] BT() {
        long Ni = be.Ni();
        int i = be.kS(this.username) ? 0 : be.bl(this.dlf) ? 0 : be.bl(this.cAN) ? 0 : (this.uin == 0 || this.uin == -1) ? 0 : be.bl(this.dlh) ? 0 : be.kS(this.dli) ? 0 : 1;
        if (i == 0) {
            v.e("MicroMsg.AccInfo", "AccInfoCacheInWorker getCacheBuffer Error : isCacheValid== false");
            return null;
        }
        try {
            s sVar = new s();
            sVar.bsS();
            sVar.Kc(this.username);
            sVar.Kc(this.dli);
            sVar.uY(this.uin);
            sVar.bh(this.cAN);
            sVar.bh(this.dlh);
            sVar.bh(this.dlf);
            sVar.Kc(LX());
            v.i("MicroMsg.AccInfo", "AccInfoCacheInWorker getCacheBuffer finish time:%s buflen:%s md5:%s", Long.valueOf(be.ay(Ni)), Integer.valueOf(sVar.bsT().length), r6);
            return sVar.bsT();
        } catch (Throwable e) {
            v.e("MicroMsg.AccInfo", "AccInfoCacheInWorker getCacheBuffer exception:%s", be.e(e));
            return null;
        }
    }

    public final int A(byte[] bArr) {
        long Ni = be.Ni();
        if (BQ()) {
            v.e("MicroMsg.AccInfo", "AccInfoCacheInWorker parseBuf Error : isLogin == true ");
            return -2;
        }
        try {
            s sVar = new s();
            if (sVar.bg(bArr) != 0) {
                v.e("MicroMsg.AccInfo", "AccInfoCacheInWorker parseBuf Error : initParse: %s", Integer.valueOf(sVar.bg(bArr)));
                return -3;
            }
            this.username = sVar.getString();
            this.dli = sVar.getString();
            this.uin = sVar.getInt();
            this.cAN = sVar.getBuffer();
            this.dlh = sVar.getBuffer();
            this.dlf = sVar.getBuffer();
            String string = sVar.getString();
            if (be.kS(string) || !string.equals(LX())) {
                clear();
                v.e("MicroMsg.AccInfo", "AccInfoCacheInWorker parseBuf Error : checksum failed");
                return -4;
            }
            v.i("MicroMsg.AccInfo", "AccInfoCacheInWorker parseBuf finish time:%s  md5:%s", Long.valueOf(be.ay(Ni)), string);
            return 0;
        } catch (Throwable e) {
            clear();
            v.e("MicroMsg.AccInfo", "AccInfoCacheInWorker parseBuf exception:%s", be.e(e));
            return -5;
        }
    }

    public final void cW(int i) {
        this.uin = i;
    }
}
