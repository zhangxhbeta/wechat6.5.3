package com.tencent.mm.pluginsdk.l.a;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.pluginsdk.l.d;
import com.tencent.mm.pluginsdk.l.f;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public abstract class b extends k implements j {
    private d lEW;

    private class a implements a {
        final /* synthetic */ b lEX;

        private a(b bVar) {
            this.lEX = bVar;
        }

        public final void bom() {
            this.lEX.JK();
        }

        public final void n(int i, int i2, String str) {
            this.lEX.b(i, i2, str);
        }
    }

    public abstract e BH();

    public abstract void JK();

    public abstract void b(int i, int i2, String str);

    public abstract void b(int i, int i2, String str, p pVar);

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        int i4 = 1;
        v.i("MicroMsg.NetSceneSoterBase", "onGYNetEnd errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.lEW = new d(new a());
        this.lEW.lEZ = -3202;
        d dVar = this.lEW;
        if (i2 == 4 && i3 == -3200) {
            f.a(aa.getContext(), new d(dVar) {
                final /* synthetic */ d lFa;

                {
                    this.lFa = r1;
                }

                public final void h(int i, String str, String str2) {
                    v.i("MicroMsg.SoterNetDelegateUtil", "generate ask onProcessEnd errCode: %d, errMsg: %s", Integer.valueOf(i), str);
                    if (i == 0) {
                        d dVar = this.lFa;
                        f.a(aa.getContext(), false, new com.tencent.mm.pluginsdk.l.d(dVar) {
                            final /* synthetic */ d lFa;

                            {
                                this.lFa = r1;
                            }

                            public final void h(int i, String str, String str2) {
                                v.i("MicroMsg.SoterNetDelegateUtil", "upload ASK onProcessEnd errCode: %d, errMsg: %s", Integer.valueOf(i), str);
                                if (i == 0) {
                                    v.i("MicroMsg.SoterNetDelegateUtil", "uploadASK start process successfully errCode: %d, errMsg: %s", Integer.valueOf(i), str);
                                } else if (this.lFa.lEY != null) {
                                    this.lFa.lEY.n(3, i, str);
                                }
                            }
                        }, new e(dVar) {
                            final /* synthetic */ d lFa;

                            {
                                this.lFa = r1;
                            }

                            public final void a(int i, int i2, String str, k kVar) {
                                v.i("MicroMsg.SoterNetDelegateUtil", "SoteNetDelegate upload ask errCode: %d, errMsg: %s", Integer.valueOf(i2), str);
                                if (i == 0 && i2 == 0) {
                                    if (this.lFa.lEY != null) {
                                        this.lFa.lEY.bom();
                                    }
                                } else if (this.lFa.lEY != null) {
                                    this.lFa.lEY.n(i, i2, str);
                                }
                            }
                        });
                    } else if (this.lFa.lEY != null) {
                        this.lFa.lEY.n(3, i, str);
                    }
                }
            });
        } else if (i2 != 4 || i3 != dVar.lEZ) {
            i4 = 0;
        } else if (dVar.lEY != null) {
            dVar.lEY.bom();
        }
        if (i4 == 0) {
            b(i2, i3, str, pVar);
        }
    }
}
