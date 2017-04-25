package com.tencent.mm.model;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.v;

public class be {
    private static be cuY;
    public final SharedPreferences cnm = aa.getContext().getSharedPreferences(aa.bti(), 0);

    public static class a {
        private int cuZ;
        private int cva;
        private int cvb;
        private int id;

        public final a eT(int i) {
            this.cuZ = i;
            return this;
        }

        public final a eU(int i) {
            this.cva = i;
            return this;
        }

        public final a eV(int i) {
            this.cvb = i;
            return this;
        }

        public final boolean commit() {
            Editor edit = be.zN().cnm.edit();
            if (this.id > 0) {
                edit.putInt("MicroMsg.RegStyleStoragestyle_id", this.id);
            } else {
                edit.remove("MicroMsg.RegStyleStoragestyle_id");
            }
            if (this.cuZ > 0) {
                edit.putInt("MicroMsg.RegStyleStoragenew_flow", this.cuZ);
            } else {
                edit.remove("MicroMsg.RegStyleStoragenew_flow");
            }
            if (this.cva > 0) {
                edit.putInt("MicroMsg.RegStyleStoragehas_password", this.cva);
            } else {
                edit.remove("MicroMsg.RegStyleStoragehas_password");
            }
            if (this.cvb > 0) {
                edit.putInt("MicroMsg.RegStyleStoragehas_AVATAR", this.cvb);
            } else {
                edit.remove("MicroMsg.RegStyleStoragehas_AVATAR");
            }
            v.i("MicroMsg.RegStyleStorage", "id: " + this.id + " newFlow: " + this.cuZ + "hasPassword:" + this.cva + "hasAvatar:" + this.cvb);
            return edit.commit();
        }
    }

    private be() {
    }

    public static be zN() {
        synchronized (be.class) {
            if (cuY == null) {
                cuY = new be();
            }
        }
        return cuY;
    }
}
