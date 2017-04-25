package com.tencent.mm.plugin.soter.ui;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.plugin.soter.a.a;
import com.tencent.mm.plugin.soter.a.a.b;
import com.tencent.mm.plugin.soter.a.a.d;
import com.tencent.mm.plugin.soter.c.h;
import com.tencent.mm.plugin.soter.c.i;
import com.tencent.mm.plugin.soter.c.k;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import java.security.Signature;
import java.security.SignatureException;

public class SoterTestUI extends MMActivity {
    private Button kdE = null;
    private Button kdF = null;
    private Button kdG = null;
    private Button kdH = null;
    private Button kdI = null;
    private Button kdJ = null;
    private Button kdK = null;
    private Button kdL = null;
    private Button kdM = null;
    private TextView kdN = null;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.kdE = (Button) findViewById(2131759515);
        this.kdF = (Button) findViewById(2131759516);
        this.kdG = (Button) findViewById(2131759517);
        this.kdH = (Button) findViewById(2131759518);
        this.kdI = (Button) findViewById(2131759519);
        this.kdJ = (Button) findViewById(2131759520);
        this.kdK = (Button) findViewById(2131759521);
        this.kdL = (Button) findViewById(2131759522);
        this.kdM = (Button) findViewById(2131759523);
        this.kdN = (TextView) findViewById(2131759514);
        this.kdE.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ SoterTestUI kdO;

            {
                this.kdO = r1;
            }

            public final void onClick(View view) {
                this.kdO.kdN.setText(k.aYJ() ? "passed" : "not support");
            }
        });
        this.kdF.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ SoterTestUI kdO;

            {
                this.kdO = r1;
            }

            public final void onClick(View view) {
                this.kdO.kdN.setText(k.aYK() == 0 ? "passed" : "not support");
            }
        });
        this.kdG.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ SoterTestUI kdO;

            {
                this.kdO = r1;
            }

            public final void onClick(View view) {
                this.kdO.kdN.setText(k.aYL() ? "passed" : "not passed");
            }
        });
        this.kdH.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ SoterTestUI kdO;

            {
                this.kdO = r1;
            }

            public final void onClick(View view) {
                h aYN = k.aYN();
                if (aYN == null) {
                    this.kdO.kdN.setText("not passed: no certificate");
                } else {
                    this.kdO.kdN.setText("model available: " + aYN.toString());
                }
            }
        });
        this.kdI.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ SoterTestUI kdO;

            {
                this.kdO = r1;
            }

            public final void onClick(View view) {
                this.kdO.kdN.setText(k.Ck("WechatAuthKeyPay") == 0 ? "pass" : "not passed");
            }
        });
        this.kdJ.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ SoterTestUI kdO;

            {
                this.kdO = r1;
            }

            public final void onClick(View view) {
                this.kdO.kdN.setText(k.ar("WechatAuthKeyPay", false) ? "pass" : "not passed");
            }
        });
        this.kdK.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ SoterTestUI kdO;

            {
                this.kdO = r1;
            }

            public final void onClick(View view) {
                h Cn = k.Cn("WechatAuthKeyPay");
                if (Cn == null) {
                    this.kdO.kdN.setText("not passed: no certificate");
                } else {
                    this.kdO.kdN.setText("model available: " + Cn.toString());
                }
            }
        });
        this.kdL.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ SoterTestUI kdO;

            {
                this.kdO = r1;
            }

            public final void onClick(View view) {
                final Signature Co = k.Co("WechatAuthKeyPay");
                if (Co != null) {
                    try {
                        Co.update("challenge".getBytes());
                        Co.sign();
                        v.e("MicroMsg.SoterTestUI", "hy: should NOT happen if no exception");
                        this.kdO.kdN.setText("not passed: signature success without fingerprint authentication");
                        return;
                    } catch (SignatureException e) {
                        v.e("MicroMsg.SoterTestUI", "hy: occurred exception when sign: " + e.toString());
                        r0 = a.cx(this.kdO);
                        a cx;
                        if (cx.isHardwareDetected() && cx.hasEnrolledFingerprints()) {
                            cx.a(new d(Co), null, new b(this) {
                                final /* synthetic */ AnonymousClass8 kdP;

                                public final void onAuthenticationError(int i, CharSequence charSequence) {
                                    v.i("MicroMsg.SoterTestUI", "hy: onAuthenticationError");
                                }

                                public final void onAuthenticationHelp(int i, CharSequence charSequence) {
                                    v.i("MicroMsg.SoterTestUI", "hy: onAuthenticationHelp");
                                }

                                public final void aYA() {
                                    v.i("MicroMsg.SoterTestUI", "hy: onAuthenticationSucceeded");
                                    try {
                                        Co.update("challenge".getBytes());
                                        i aE = k.aE(Co.sign());
                                        this.kdP.kdO.kdN.setText(aE == null ? "not pass: exception occurs" : aE.toString());
                                    } catch (SignatureException e) {
                                        v.e("MicroMsg.SoterTestUI", "hy: occurred exception when sign: " + e.toString());
                                    }
                                }

                                public final void onAuthenticationFailed() {
                                    v.i("MicroMsg.SoterTestUI", "hy: onAuthenticationFailed");
                                }
                            });
                            return;
                        } else {
                            v.e("MicroMsg.SoterTestUI", "hy: no hardware detected or no fingerprint registered");
                            return;
                        }
                    }
                }
                v.e("MicroMsg.SoterTestUI", "hy: signature is null. do sign failed");
            }
        });
    }

    protected final int getLayoutId() {
        return 2130904525;
    }
}
