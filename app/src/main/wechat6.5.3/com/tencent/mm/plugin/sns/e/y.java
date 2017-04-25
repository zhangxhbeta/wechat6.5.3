package com.tencent.mm.plugin.sns.e;

import android.content.SharedPreferences;
import android.os.Looper;
import android.os.Message;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.k;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelsfs.SFSContext.FileEntry;
import com.tencent.mm.plugin.appbrand.jsapi.bu;
import com.tencent.mm.plugin.sns.storage.i;
import com.tencent.mm.pluginsdk.model.j;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;

public final class y {
    public static boolean gTV = false;
    public static char[] jlb = new char[36];
    private ac handler = new ac(this, Looper.getMainLooper()) {
        final /* synthetic */ y jlc;

        public final void handleMessage(Message message) {
            super.handleMessage(message);
            if (this.jlc.jla >= 5 || System.currentTimeMillis() - this.jlc.jkZ > 300000) {
                v.d("MicroMsg.RemoveSnsTask", "cleanCount: " + this.jlc.jla);
                y.gTV = false;
            } else if (!this.jlc.jkY && y.gTV) {
                new a(this.jlc).l("");
            }
        }
    };
    public boolean jkY = false;
    public long jkZ = 0;
    private int jla = 0;

    class a extends j<String, String, Boolean> {
        private String apU;
        private SharedPreferences cnm;
        final /* synthetic */ y jlc;
        private String jld;
        PInt jle;
        PInt jlf;
        private String jlg;
        private String username;

        public final /* synthetic */ Object aRX() {
            return aSd();
        }

        public final /* synthetic */ void onPostExecute(Object obj) {
            Boolean bool = (Boolean) obj;
            v.d("MicroMsg.RemoveSnsTask", "onPostExecute " + bool);
            this.jlc.jla = this.jlc.jla + 1;
            if (bool.booleanValue()) {
                y.b(this.jle, this.jlf);
                if (this.cnm != null) {
                    this.cnm.edit().putInt(this.jld, this.jle.value).commit();
                    this.cnm.edit().putInt(this.apU, this.jlf.value).commit();
                    v.d("MicroMsg.RemoveSnsTask", "update dir " + this.jle.value + " " + this.jlf.value + " cleanCount: " + this.jlc.jla);
                }
                this.jlc.handler.sendEmptyMessageDelayed(0, 20000);
            }
            this.jlc.jkY = false;
        }

        public a(y yVar) {
            this.jlc = yVar;
            this.cnm = null;
            this.jld = "";
            this.apU = "";
            this.jle = new PInt();
            this.jlf = new PInt();
            this.cnm = aa.getContext().getSharedPreferences("preferences_remove_task", 0);
            if (ak.uz()) {
                this.username = k.xF();
                this.jld = "remove_key_base" + this.username;
                this.apU = "remove_key" + this.username;
                if (ak.uz() && !ad.aSn() && ad.wE() != null && ad.aSG() != null) {
                    i Bu = ad.aSG().Bu(this.username);
                    if (Bu != null) {
                        this.jlg = Bu.field_bgId;
                    }
                    v.d("MicroMsg.RemoveSnsTask", "my bgid %s", new Object[]{this.jlg});
                    yVar.jkY = true;
                }
            }
        }

        private Boolean aSd() {
            v.d("MicroMsg.RemoveSnsTask", "simpleCleans sns");
            if (!y.gTV) {
                return Boolean.valueOf(false);
            }
            if (!this.jlc.jkY) {
                return Boolean.valueOf(false);
            }
            if (ad.aSn()) {
                y.gTV = false;
                return Boolean.valueOf(false);
            }
            this.jle.value = this.cnm.getInt(this.jld, 0);
            this.jlf.value = this.cnm.getInt(this.apU, 0);
            String xh = ad.xh();
            try {
                long currentTimeMillis = System.currentTimeMillis();
                if (!y.L(xh + y.jlb[this.jle.value % 36] + "/" + y.jlb[this.jlf.value % 36], this.jlg, this.username)) {
                    return Boolean.valueOf(false);
                }
                v.d("MicroMsg.RemoveSnsTask", "clean sns uses time : " + (System.currentTimeMillis() - currentTimeMillis) + " " + this.jle.value + " " + this.jlf.value);
                return Boolean.valueOf(true);
            } catch (Exception e) {
            }
        }

        public final ac aRW() {
            return ad.aSq();
        }
    }

    static /* synthetic */ boolean L(String str, String str2, String str3) {
        for (FileEntry fileEntry : FileOp.A(str, true)) {
            if (!gTV) {
                v.d("MicroMsg.RemoveSnsTask", "broken here by ??");
                return false;
            } else if (fileEntry.name != null && !be.kS(str2) && str3 != null && (fileEntry.name.contains(str2) || fileEntry.name.contains(str3))) {
                v.d("MicroMsg.RemoveSnsTask", "do not delete my bg %s", new Object[]{str2});
            } else if (be.ay(fileEntry.timestamp) > 604800000) {
                FileOp.deleteFile(fileEntry.name);
            }
        }
        return true;
    }

    static {
        int i = 0;
        int i2 = 48;
        while (i2 <= 57) {
            jlb[i] = (char) i2;
            i2++;
            i++;
        }
        i2 = 97;
        while (i2 <= bu.CTRL_INDEX) {
            jlb[i] = (char) i2;
            i2++;
            i++;
        }
    }

    public static void b(PInt pInt, PInt pInt2) {
        if (pInt2.value + 1 >= 36) {
            pInt2.value = 0;
            pInt.value = (pInt.value + 1) % 36;
            return;
        }
        pInt2.value = (pInt2.value + 1) % 36;
    }
}
