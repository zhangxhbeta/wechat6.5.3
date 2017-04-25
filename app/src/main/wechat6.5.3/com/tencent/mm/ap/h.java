package com.tencent.mm.ap;

import android.annotation.SuppressLint;
import android.os.CancellationSignal;
import com.tencent.mm.model.ak;
import com.tencent.mm.pluginsdk.l.b;
import com.tencent.mm.pluginsdk.l.d;
import com.tencent.mm.pluginsdk.l.f;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.security.Signature;
import org.json.JSONObject;

public final class h implements e {
    String bax;
    public a cZY;
    public CancellationSignal cZZ;
    private String daa;

    public interface a {
        void a(boolean z, int i, String str);

        void kr(String str);

        void u(int i, String str);
    }

    static /* synthetic */ void a(h hVar, String str) {
        try {
            hVar.daa = str;
            JSONObject jSONObject = new JSONObject(str);
            ak.vy().a(new g(jSONObject.getString("SignatureWithAsk"), jSONObject.getString("JsonSignedByAsk"), jSONObject.getString("SignatureWithAuthKey"), jSONObject.getString("JsonSignedByAuthKey")), 0);
        } catch (Exception e) {
            v.a("MicroMsg.SoterFingerprintLoginService", null, "parse soter verfiy info json exception: %s", new Object[]{e.getMessage()});
            if (hVar.cZY != null) {
                hVar.cZY.a(false, 14, "json parse error");
            }
        }
    }

    public h() {
        ak.vy().a(261, this);
        ak.vy().a(248, this);
    }

    public final void a(int i, int i2, String str, k kVar) {
        v.i("MicroMsg.SoterFingerprintLoginService", "alvinluo: Soter fingerprint login onSceneEnd errType: %d, errCode: %d, errMsg: %s, sceneType: %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, Integer.valueOf(kVar.getType())});
        if (kVar.getType() == 261) {
            if (i == 0 && i2 == 0) {
                this.bax = ((d) kVar).cZU;
                JL();
            } else if (this.cZY != null) {
                this.cZY.u(i2, str);
            }
        } else if (kVar.getType() == 248) {
            v.i("MicroMsg.SoterFingerprintLoginService", "login service on verify end, errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
            if (i == 0 && i2 == 0) {
                if (this.cZY != null) {
                    this.cZY.a(true, i2, str);
                }
            } else if (i == 0) {
            } else {
                if (i2 == -3203) {
                    if (this.cZY != null) {
                        this.cZY.a(false, i2, str);
                    }
                } else if (i2 == -3202) {
                    f.a(aa.getContext(), "SoteLoginAuthKeyName", new d(this) {
                        final /* synthetic */ h dab;

                        {
                            this.dab = r1;
                        }

                        public final void h(int i, String str, String str2) {
                            v.i("MicroMsg.SoterFingerprintLoginService", "alvinluo: generate login auth key onProcessEnd errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i), str});
                            if (i == 0 && !be.kS(f.aQ(aa.getContext(), "SoteLoginAuthKeyName"))) {
                                h hVar = this.dab;
                                AnonymousClass4 anonymousClass4 = new d(hVar) {
                                    final /* synthetic */ h dab;

                                    {
                                        this.dab = r1;
                                    }

                                    public final void h(int i, String str, String str2) {
                                        if (i == 0) {
                                            if (this.dab.cZY == null) {
                                            }
                                        } else if (this.dab.cZY != null) {
                                            this.dab.cZY.a(false, i, str);
                                        }
                                    }
                                };
                                AnonymousClass5 anonymousClass5 = new b(hVar) {
                                    final /* synthetic */ h dab;

                                    {
                                        this.dab = r1;
                                    }

                                    public final void s(int i, String str) {
                                    }

                                    public final void t(int i, String str) {
                                        v.e("MicroMsg.SoterFingerprintLoginService", "doAuthentication onAuthenticationHelp helpCode: %d, helpMsg: %s", new Object[]{Integer.valueOf(i), str});
                                        if (this.dab.cZY != null) {
                                            this.dab.cZY.a(false, i, str);
                                        }
                                    }

                                    public final void a(String str, Signature signature) {
                                        h.a(this.dab, str);
                                    }

                                    public final void kq(String str) {
                                        if (this.dab.cZY != null) {
                                            this.dab.cZY.a(false, 11, str);
                                        }
                                    }
                                };
                                hVar.cZZ = new CancellationSignal();
                                f.a(aa.getContext(), hVar.bax, "SoteLoginAuthKeyName", anonymousClass4, anonymousClass5, hVar.cZZ);
                            } else if (this.dab.cZY != null) {
                                this.dab.cZY.a(false, i, str);
                            }
                        }
                    }, false);
                } else if (i == -3204 && this.cZY != null) {
                    this.cZY.kr(this.daa);
                }
            }
        }
    }

    @SuppressLint({"NewApi"})
    public final void JL() {
        AnonymousClass1 anonymousClass1 = new d(this) {
            final /* synthetic */ h dab;

            {
                this.dab = r1;
            }

            public final void h(int i, String str, String str2) {
                if (i == 0) {
                    if (this.dab.cZY == null) {
                    }
                } else if (this.dab.cZY != null) {
                    this.dab.cZY.a(false, i, str);
                }
            }
        };
        AnonymousClass2 anonymousClass2 = new b(this) {
            final /* synthetic */ h dab;

            {
                this.dab = r1;
            }

            public final void s(int i, String str) {
                v.e("MicroMsg.SoterFingerprintLoginService", "doAuthentication onAuthenticationError errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i), str});
                if (this.dab.cZY != null) {
                    this.dab.cZY.a(false, i, str);
                }
            }

            public final void t(int i, String str) {
                v.e("MicroMsg.SoterFingerprintLoginService", "doAuthentication onAuthenticationHelp helpCode: %d, helpMsg: %s", new Object[]{Integer.valueOf(i), str});
                if (this.dab.cZY != null) {
                    this.dab.cZY.a(false, i, str);
                }
            }

            public final void a(String str, Signature signature) {
                h.a(this.dab, str);
            }

            public final void kq(String str) {
                v.e("MicroMsg.SoterFingerprintLoginService", "doAuthentication onAuthenticationFailed");
                if (this.dab.cZY != null) {
                    this.dab.cZY.a(false, 11, str);
                }
            }
        };
        this.cZZ = new CancellationSignal();
        f.a(aa.getContext(), this.bax, "SoteLoginAuthKeyName", anonymousClass1, anonymousClass2, this.cZZ);
    }
}
