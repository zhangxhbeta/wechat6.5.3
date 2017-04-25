package com.tencent.mm.plugin.traceroute.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.TextView;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.k;
import com.tencent.mm.network.e;
import com.tencent.mm.plugin.traceroute.b.a;
import com.tencent.mm.plugin.traceroute.b.a.b;
import com.tencent.mm.plugin.traceroute.b.a.c;
import com.tencent.mm.plugin.traceroute.b.a.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMProgressBar;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.s;

public class NetworkDiagnoseUI extends MMActivity {
    private TextView fSi;
    private ac handler = new ac(this) {
        final /* synthetic */ NetworkDiagnoseUI knA;

        {
            this.knA = r1;
        }

        public final void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    NetworkDiagnoseUI.e(this.knA);
                    if (this.knA.knw < 95) {
                        this.knA.kny.setProgress(95);
                    }
                    this.knA.knx.baH();
                    return;
                case 2:
                    if (this.knA.knw < 95) {
                        this.knA.kny.setProgress(95);
                    }
                    this.knA.knx.baH();
                    return;
                case 3:
                    this.knA.kny.setProgress(100);
                    NetworkDiagnoseUI.a(this.knA, false);
                    return;
                case 4:
                    this.knA.kny.setProgress(100);
                    NetworkDiagnoseUI.a(this.knA, true);
                    return;
                default:
                    return;
            }
        }
    };
    private int hvJ = 0;
    private final int knv = 100;
    private int knw = 0;
    private a knx;
    private MMProgressBar kny;
    private ah knz = new ah(new ah.a(this) {
        final /* synthetic */ NetworkDiagnoseUI knA;

        {
            this.knA = r1;
        }

        public final boolean oU() {
            this.knA.knw = this.knA.hvJ + 1;
            this.knA.hvJ = this.knA.knw;
            if (this.knA.knw < 100) {
                this.knA.kny.setProgress(this.knA.knw);
                return true;
            }
            this.knA.kny.setProgress(100);
            return false;
        }
    }, true);

    static /* synthetic */ void a(NetworkDiagnoseUI networkDiagnoseUI, boolean z) {
        Intent intent = new Intent(networkDiagnoseUI, NetworkDiagnoseReportUI.class);
        intent.putExtra("diagnose_result", z);
        if (!z) {
            intent.putExtra("diagnose_log_file_path", a.kmO);
        }
        networkDiagnoseUI.startActivity(intent);
        networkDiagnoseUI.finish();
    }

    static /* synthetic */ void e(NetworkDiagnoseUI networkDiagnoseUI) {
        networkDiagnoseUI.knz.QI();
        if (networkDiagnoseUI.knx != null) {
            networkDiagnoseUI.knx.stop();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        NI();
    }

    protected final void NI() {
        this.fSi = (TextView) findViewById(2131758445);
        this.kny = (MMProgressBar) findViewById(2131758444);
        this.kny.nWR = new MMProgressBar.a(this) {
            final /* synthetic */ NetworkDiagnoseUI knA;

            {
                this.knA = r1;
            }

            public final void rw(int i) {
                if (i < 5) {
                    this.knA.fSi.setText(this.knA.getString(2131231992));
                } else if (i < 5 || i >= 95) {
                    this.knA.fSi.setText(this.knA.getString(2131235731));
                } else {
                    this.knA.fSi.setText(this.knA.getString(2131233187));
                }
            }
        };
        Fd("");
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ NetworkDiagnoseUI knA;

            {
                this.knA = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.knA.baM();
                return true;
            }
        });
        new ac().postDelayed(new Runnable(this) {
            final /* synthetic */ NetworkDiagnoseUI knA;

            {
                this.knA = r1;
            }

            public final void run() {
                ak.vy().a(new ay(new ay.a(this.knA) {
                    final /* synthetic */ NetworkDiagnoseUI knA;

                    {
                        this.knA = r1;
                    }

                    public final void a(e eVar) {
                        if (eVar != null) {
                            this.knA.knx = new a(k.xF());
                            this.knA.knx.b(eVar.getIPsString(true), true);
                            this.knA.knx.b(eVar.getIPsString(false), false);
                            this.knA.knx.kmV = new d(this) {
                                final /* synthetic */ AnonymousClass6 knB;

                                {
                                    this.knB = r1;
                                }

                                public final void baK() {
                                    this.knB.knA.handler.sendEmptyMessageDelayed(2, 500);
                                }
                            };
                            this.knA.knx.kmU = new a.e(this) {
                                final /* synthetic */ AnonymousClass6 knB;

                                {
                                    this.knB = r1;
                                }

                                public final void baL() {
                                    this.knB.knA.handler.sendEmptyMessageDelayed(1, 500);
                                }
                            };
                            this.knA.knx.kmX = new b(this) {
                                final /* synthetic */ AnonymousClass6 knB;

                                {
                                    this.knB = r1;
                                }

                                public final void baI() {
                                    this.knB.knA.handler.sendEmptyMessage(3);
                                }
                            };
                            this.knA.knx.kmW = new c(this) {
                                final /* synthetic */ AnonymousClass6 knB;

                                {
                                    this.knB = r1;
                                }

                                public final void baJ() {
                                    this.knB.knA.handler.sendEmptyMessage(4);
                                }
                            };
                            a d = this.knA.knx;
                            if (d.kmT == null || d.kmT.size() == 0) {
                                v.e("MicroMsg.MMTraceRoute", "no iplist");
                            } else {
                                if (a.kmP == null) {
                                    a.kmP = new com.tencent.mm.plugin.traceroute.b.c();
                                }
                                com.tencent.mm.sdk.i.e.a(new j(), "MMTraceRoute_start");
                            }
                            this.knA.knz.ea(1200);
                        }
                    }
                }), 0);
            }
        }, 200);
    }

    protected final int getLayoutId() {
        return 2130904125;
    }

    protected void onPause() {
        this.kny.jn(false);
        super.onPause();
    }

    protected void onResume() {
        ak.yW();
        if (com.tencent.mm.model.c.isSDCardAvailable()) {
            this.kny.jn(true);
            super.onResume();
            return;
        }
        s.ey(this);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        baM();
        return true;
    }

    private void baM() {
        g.a(this, 2131231969, 2131232284, 2131231183, 2131231104, new OnClickListener(this) {
            final /* synthetic */ NetworkDiagnoseUI knA;

            {
                this.knA = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                NetworkDiagnoseUI.e(this.knA);
                this.knA.finish();
            }
        }, new OnClickListener(this) {
            final /* synthetic */ NetworkDiagnoseUI knA;

            {
                this.knA = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        });
    }
}
