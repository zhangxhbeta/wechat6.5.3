package com.tencent.mm.wallet_core.ui.formview;

import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.method.NumberKeyListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.b.q;

public final class a {
    private static String TAG = "MicroMsg.CommonHintViewConfig";

    private static class b implements com.tencent.mm.wallet_core.ui.formview.a.a {
        private b() {
        }

        public final void bex() {
        }

        public boolean a(WalletFormView walletFormView, MotionEvent motionEvent) {
            return false;
        }
    }

    private static class c implements com.tencent.mm.wallet_core.ui.formview.a.b {
        private c() {
        }

        public boolean h(WalletFormView walletFormView) {
            return true;
        }

        public boolean c(WalletFormView walletFormView, String str) {
            return false;
        }

        public boolean d(WalletFormView walletFormView, String str) {
            return false;
        }

        public boolean aJv() {
            return false;
        }

        public String e(WalletFormView walletFormView, String str) {
            return null;
        }
    }

    public static class a extends c {
        private int pjZ;
        private WalletFormView pka;

        public final /* bridge */ /* synthetic */ boolean aJv() {
            return super.aJv();
        }

        public final /* bridge */ /* synthetic */ boolean c(WalletFormView walletFormView, String str) {
            return super.c(walletFormView, str);
        }

        public final /* bridge */ /* synthetic */ boolean d(WalletFormView walletFormView, String str) {
            return super.d(walletFormView, str);
        }

        public final /* bridge */ /* synthetic */ String e(WalletFormView walletFormView, String str) {
            return super.e(walletFormView, str);
        }

        public a(WalletFormView walletFormView) {
            this(1, walletFormView);
        }

        public a(int i, WalletFormView walletFormView) {
            super();
            this.pjZ = 1;
            this.pka = walletFormView;
            this.pjZ = 1;
            bLH();
        }

        public final void yE(int i) {
            this.pjZ = i;
            bLH();
        }

        private void bLH() {
            if (this.pjZ == 1) {
                if (this.pka != null) {
                    this.pka.setKeyListener(new NumberKeyListener(this) {
                        final /* synthetic */ a pkb;

                        {
                            this.pkb = r1;
                        }

                        public final int getInputType() {
                            return 1;
                        }

                        protected final char[] getAcceptedChars() {
                            return new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9', '0', 'x', 'X'};
                        }
                    });
                }
            } else if (this.pka != null) {
                this.pka.setInputType(1);
            }
        }

        public final boolean h(WalletFormView walletFormView) {
            return walletFormView.pkj == null ? false : walletFormView.pkj.isAreaIDCardNum(this.pjZ);
        }
    }

    public static void a(EditHintPasswdView editHintPasswdView) {
        if (editHintPasswdView != null) {
            editHintPasswdView.pkf = 1;
        }
    }

    public static void a(EditHintPasswdView editHintPasswdView, boolean z) {
        if (editHintPasswdView != null) {
            editHintPasswdView.pkf = z ? -10 : 20;
        }
    }

    public static void a(WalletFormView walletFormView) {
        if (walletFormView == null) {
            v.e(TAG, "hy: param error");
        } else {
            walletFormView.pkm = new c() {
                public final boolean c(WalletFormView walletFormView, String str) {
                    if (be.kS(str) || str.length() > 5) {
                        return false;
                    }
                    walletFormView.setSelection(0);
                    if (walletFormView.pkj != null) {
                        walletFormView.pkj.setBankcardTailNum(str);
                    }
                    walletFormView.ioU = 24 - str.length();
                    walletFormView.setFilters(new InputFilter[]{new LengthFilter(walletFormView.ioU)});
                    return true;
                }

                public final boolean d(WalletFormView walletFormView, String str) {
                    if (be.kS(str) || str.length() > 5) {
                        return false;
                    }
                    walletFormView.setSelection(0);
                    if (walletFormView.pkj != null) {
                        walletFormView.pkj.set3DesEncrptData(str);
                    }
                    walletFormView.ioU = 24 - str.length();
                    walletFormView.setFilters(new InputFilter[]{new LengthFilter(walletFormView.ioU)});
                    return true;
                }

                public final boolean h(WalletFormView walletFormView) {
                    return walletFormView.pkj == null ? false : walletFormView.pkj.isBankcardNum();
                }
            };
        }
    }

    public static void a(final MMActivity mMActivity, final WalletFormView walletFormView) {
        if (walletFormView == null) {
            v.e(TAG, "hy: param error");
            return;
        }
        walletFormView.pkm = new c() {
            public final boolean aJv() {
                return true;
            }

            public final String e(WalletFormView walletFormView, String str) {
                return be.ah((String) walletFormView.getTag(), "").replace("/", "");
            }
        };
        b.e(mMActivity, walletFormView);
        walletFormView.k(new OnClickListener() {
            public final void onClick(View view) {
                walletFormView.getContext();
                int bLn = q.bLn();
                walletFormView.getContext();
                b.b(mMActivity, bLn, q.bLo());
            }
        });
    }

    public static void b(final MMActivity mMActivity, final WalletFormView walletFormView) {
        if (walletFormView == null) {
            v.e(TAG, "hy: param error");
        } else {
            walletFormView.k(new OnClickListener() {
                public final void onClick(View view) {
                    walletFormView.getContext();
                    b.b(mMActivity, q.bLp(), 2131232258);
                }
            });
        }
    }

    public static void b(WalletFormView walletFormView) {
        if (walletFormView == null) {
            v.e(TAG, "hy: param error");
        } else {
            walletFormView.pkm = new a(1, walletFormView);
        }
    }

    public static void c(WalletFormView walletFormView) {
        if (walletFormView == null) {
            v.e(TAG, "hy: param error");
            return;
        }
        walletFormView.pkm = new a(walletFormView);
        "\\x20\\t\\r\\n".toCharArray();
    }

    public static void d(WalletFormView walletFormView) {
        if (walletFormView == null) {
            v.e(TAG, "hy: param error");
        } else {
            walletFormView.pkm = new c() {
                public final boolean h(WalletFormView walletFormView) {
                    return be.Kx(walletFormView.getText());
                }
            };
        }
    }

    public static void c(final MMActivity mMActivity, WalletFormView walletFormView) {
        if (walletFormView == null) {
            v.e(TAG, "hy: param error");
            return;
        }
        walletFormView.k(new OnClickListener() {
            public final void onClick(View view) {
                b.b(mMActivity, 2130904672, 2131236114);
            }
        });
        walletFormView.pkm = new c() {
            public final boolean h(WalletFormView walletFormView) {
                return walletFormView.pkj == null ? false : walletFormView.pkj.isPhoneNum();
            }
        };
    }

    public static void d(final MMActivity mMActivity, WalletFormView walletFormView) {
        if (walletFormView == null) {
            v.e(TAG, "hy: param error");
            return;
        }
        walletFormView.k(new OnClickListener() {
            public final void onClick(View view) {
                b.b(mMActivity, 2130904653, 2131236108);
            }
        });
        "\\x20\\t\\r\\n".toCharArray();
    }

    public static void e(WalletFormView walletFormView) {
        if (walletFormView == null) {
            v.e(TAG, "hy: param error");
        } else {
            walletFormView.pkm = new c() {
                public final boolean h(WalletFormView walletFormView) {
                    return walletFormView.pkj == null ? false : walletFormView.pkj.isMoneyAmount();
                }
            };
        }
    }

    public static void f(WalletFormView walletFormView) {
        if (walletFormView == null) {
            v.e(TAG, "hy: param error");
        } else if (walletFormView.pkj != null) {
            walletFormView.pkj.setIsSecurityAnswerFormat(true);
        }
    }

    public static void g(final WalletFormView walletFormView) {
        if (walletFormView == null) {
            v.e(TAG, "hy: param error");
        } else {
            walletFormView.pkl = new b() {
                public final boolean a(WalletFormView walletFormView, MotionEvent motionEvent) {
                    if (!walletFormView.a(walletFormView.ioA, motionEvent) || motionEvent.getAction() != 1) {
                        return super.a(walletFormView, motionEvent);
                    }
                    v.d(a.TAG, "hy: click on info iv");
                    walletFormView.performClick();
                    return true;
                }
            };
        }
    }
}
