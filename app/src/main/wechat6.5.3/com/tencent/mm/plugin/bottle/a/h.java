package com.tencent.mm.plugin.bottle.a;

import android.content.Context;
import com.tencent.mm.model.ak;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.Map;
import junit.framework.Assert;

public final class h {

    public interface a {
        void bo(int i, int i2);
    }

    public static class b implements e {
        public int etd = -10001;
        public String eti;
        private a etn = null;
        public String eto = "";
        public final f etp = new f();
        public String iconUrl = "";

        public final boolean a(a aVar) {
            v.d("MicroMsg.PickBottle", "bottle pick:" + c.Xz() + " throw:" + c.Xy());
            Assert.assertTrue("renew this class", this.etn == null);
            Assert.assertTrue("must call back onFin", true);
            if (c.Xz() <= 0) {
                aVar.bo(1, 16);
                return false;
            }
            ak.vy().a(155, this);
            ak.vy().a(156, this);
            this.etn = aVar;
            return ak.vy().a(this.etp, 0);
        }

        public final void a(int i, int i2, String str, k kVar) {
            v.d("MicroMsg.PickBottle", "type:" + kVar.getType() + " errType:" + i + " errCode:" + i2);
            if (kVar.getType() == 155) {
                f fVar = (f) kVar;
                if (fVar.etl) {
                    ak.vy().b(155, this);
                    com.tencent.mm.plugin.bottle.a.drq.ow();
                    this.eti = fVar.XD().mLT == null ? "" : fVar.XD().mLT;
                    this.etd = fVar.XD().gll;
                    Map q = bf.q(fVar.XD().myI == null ? "" : fVar.XD().myI, "branduser");
                    if (q != null) {
                        this.eto = (String) q.get(".branduser.$username");
                        this.iconUrl = (String) q.get(".branduser.$iconurl");
                        if (this.eto != null) {
                            this.etd = 19990;
                            if (this.etn != null) {
                                if (i == 0 && i2 == 0) {
                                    this.etn.bo(i, i2);
                                } else {
                                    this.etn.bo(i, i2);
                                }
                            }
                            this.etn = null;
                            return;
                        }
                    }
                    ak.vy().a(new e(this.eti, this.etd), 0);
                    return;
                }
                if (this.etn != null) {
                    this.etn.bo(i, i2);
                }
                this.etn = null;
                ak.vy().b(155, this);
                ak.vy().b(156, this);
            } else if (kVar.getType() == 156) {
                ak.vy().b(156, this);
                if (this.etn != null) {
                    if (i == 0 && i2 == 0) {
                        this.etn.bo(i, i2);
                    } else {
                        this.etn.bo(i, i2);
                    }
                }
                this.etn = null;
            }
        }
    }

    public static class c implements e {
        private a etn = null;
        private int etq = 0;

        public c(String str, a aVar) {
            boolean z;
            Assert.assertTrue("emtpy input text", !be.kS(str));
            String str2 = "must call back onFin";
            if (aVar != null) {
                z = true;
            } else {
                z = false;
            }
            Assert.assertTrue(str2, z);
            if (c.Xy() > 0) {
                ak.vy().a(154, this);
                this.etn = aVar;
                ak.vy().a(new g(str), 0);
            } else if (aVar != null) {
                aVar.bo(1, 16);
            }
        }

        public final void a(int i, int i2, String str, k kVar) {
            if (kVar.getType() == 154) {
                if (this.etn != null) {
                    this.etq = ((g) kVar).XE();
                    this.etn.bo(i, i2);
                }
                this.etn = null;
                ak.vy().b(154, this);
            }
        }
    }

    public static class d extends com.tencent.mm.c.b.h implements e {
        public a etn = null;
        private int etq = 0;

        public d(Context context, a aVar) {
            boolean z = false;
            super(context, false);
            String str = "must call back onFin";
            if (aVar != null) {
                z = true;
            }
            Assert.assertTrue(str, z);
            ak.vy().a(154, this);
            this.etn = aVar;
        }

        public final boolean ph() {
            String fileName = super.getFileName();
            boolean ph = super.ph();
            super.reset();
            if (!ph) {
                ak.vy().b(154, this);
                this.etn = null;
                return false;
            } else if (c.Xy() > 0) {
                ak.vy().a(new g(fileName, this.aVe), 0);
                return true;
            } else {
                ak.vy().b(154, this);
                if (this.etn == null) {
                    return false;
                }
                this.etn.bo(1, 16);
                return false;
            }
        }

        public final void a(int i, int i2, String str, k kVar) {
            if (kVar.getType() == 154) {
                if (this.etn != null) {
                    this.etq = ((g) kVar).XE();
                    this.etn.bo(i, i2);
                }
                this.etn = null;
                ak.vy().b(154, this);
            }
        }
    }
}
