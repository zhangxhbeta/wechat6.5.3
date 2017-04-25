package com.tencent.mm.ui.tools;

import android.app.Activity;
import android.os.IBinder;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.l;
import android.support.v4.view.l.e;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.ArrayList;

public class p {
    final String TAG;
    ac cnC;
    MenuItem fOi;
    boolean oUm;
    public boolean oUn;
    private boolean oUo;
    private boolean oUp;
    boolean oUq;
    public f oUr;
    public b oUs;
    public com.tencent.mm.ui.tools.SearchViewNotRealTimeHelper.a oUt;
    private boolean oUu;
    private ArrayList<String> oUv;
    private boolean oUw;
    public int oUx;
    private int oUy;
    a oUz;

    public interface a {
        void bJt();

        void collapseActionView();
    }

    public interface b {
        void Of();

        void Og();

        void Oh();

        boolean mk(String str);

        void ml(String str);
    }

    public p() {
        this.oUm = false;
        this.oUn = false;
        this.oUo = false;
        this.oUp = true;
        this.oUq = true;
        this.fOi = null;
        this.cnC = new ac(Looper.getMainLooper());
        this.oUr = null;
        this.oUu = true;
        this.oUx = 2131231035;
        this.oUy = 0;
        this.oUu = true;
        this.oUm = false;
        this.TAG = "MicroMsg.SearchViewHelper-" + String.valueOf(System.currentTimeMillis());
    }

    public p(boolean z, boolean z2) {
        this.oUm = false;
        this.oUn = false;
        this.oUo = false;
        this.oUp = true;
        this.oUq = true;
        this.fOi = null;
        this.cnC = new ac(Looper.getMainLooper());
        this.oUr = null;
        this.oUu = true;
        this.oUx = 2131231035;
        this.oUy = 0;
        this.oUu = z;
        this.oUm = true;
        this.TAG = "MicroMsg.SearchViewHelper-" + String.valueOf(System.currentTimeMillis());
    }

    public final String boJ() {
        if (this.oUr != null) {
            return this.oUr.boJ();
        }
        return SQLiteDatabase.KeyEmpty;
    }

    public final void Pw(String str) {
        if (this.oUr != null) {
            this.oUr.Pw(str);
        }
    }

    public final void setHint(CharSequence charSequence) {
        if (this.oUr != null) {
            this.oUr.setHint(charSequence);
        }
    }

    public final void clearFocus() {
        if (this.oUr != null) {
            this.oUr.bIS();
        }
    }

    public boolean bra() {
        return false;
    }

    public void brb() {
    }

    public void brc() {
    }

    public final void a(final FragmentActivity fragmentActivity, Menu menu) {
        v.v(this.TAG, "on create options menu");
        if (fragmentActivity == null) {
            v.w(this.TAG, "on add search menu, activity is null");
            return;
        }
        if (this.oUr == null) {
            if (this.oUu) {
                this.oUr = new ActionBarSearchView(fragmentActivity);
            } else {
                this.oUr = new SearchViewNotRealTimeHelper(fragmentActivity);
                this.oUr.a(this.oUt);
            }
            this.oUr.kh(this.oUw);
            this.oUr.ad(this.oUv);
        }
        this.oUr.a(new com.tencent.mm.ui.tools.ActionBarSearchView.b(this) {
            final /* synthetic */ p oUA;

            {
                this.oUA = r1;
            }

            public final void bIW() {
                if (this.oUA.oUn) {
                    this.oUA.brb();
                } else {
                    v.v(this.oUA.TAG, "onVoiceSearchRequired, but not in searching");
                }
            }

            public final void Ht(String str) {
                if (!this.oUA.oUn) {
                    v.v(this.oUA.TAG, "onSearchTextChange %s, but not in searching", str);
                } else if (this.oUA.oUs != null) {
                    this.oUA.oUs.ml(str);
                }
            }

            public final void Oh() {
                if (this.oUA.oUs != null) {
                    this.oUA.oUs.Oh();
                }
            }
        });
        this.oUr.kd(bra());
        this.oUr.setOnEditorActionListener(new OnEditorActionListener(this) {
            final /* synthetic */ p oUA;

            {
                this.oUA = r1;
            }

            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (3 != i || this.oUA.oUs == null) {
                    return false;
                }
                return this.oUA.oUs.mk(this.oUA.boJ());
            }
        });
        if (this.oUy != 0) {
            this.oUr.yd(this.oUy);
        }
        this.fOi = menu.add(0, 2131755061, 0, this.oUx);
        this.fOi.setEnabled(this.oUp);
        this.fOi.setIcon(2131165206);
        l.a(this.fOi, (View) this.oUr);
        if (this.oUm) {
            l.a(this.fOi, 9);
        } else {
            l.a(this.fOi, 2);
        }
        if (this.oUm) {
            l.a(this.fOi, new e(this) {
                final /* synthetic */ p oUA;

                public final boolean onMenuItemActionExpand(MenuItem menuItem) {
                    this.oUA.a(fragmentActivity, false);
                    return true;
                }

                public final boolean onMenuItemActionCollapse(MenuItem menuItem) {
                    this.oUA.b(fragmentActivity, false);
                    return true;
                }
            });
        } else {
            this.oUz = new a(this) {
                final /* synthetic */ p oUA;

                public final void bJt() {
                    this.oUA.a(fragmentActivity, true);
                }

                public final void collapseActionView() {
                    this.oUA.b(fragmentActivity, true);
                }
            };
        }
        this.oUr.a(new com.tencent.mm.ui.tools.ActionBarSearchView.a(this) {
            final /* synthetic */ p oUA;

            {
                this.oUA = r1;
            }

            public final void bIV() {
                if (this.oUA.oUm) {
                    if (this.oUA.fOi != null) {
                        l.c(this.oUA.fOi);
                    }
                } else if (this.oUA.oUz != null) {
                    this.oUA.oUz.collapseActionView();
                }
            }
        });
    }

    public void a(Activity activity, Menu menu) {
        v.v(this.TAG, "on prepare options menu, searchViewExpand %B, triggerExpand %B, canExpand %B", Boolean.valueOf(this.oUn), Boolean.valueOf(this.oUo), Boolean.valueOf(this.oUp));
        if (activity == null) {
            v.w(this.TAG, "on hanle status fail, activity is null");
            return;
        }
        this.fOi = menu.findItem(2131755061);
        if (this.fOi == null) {
            v.w(this.TAG, "can not find search menu, error");
            return;
        }
        this.fOi.setOnMenuItemClickListener(new OnMenuItemClickListener(this) {
            final /* synthetic */ p oUA;

            {
                this.oUA = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                return false;
            }
        });
        b(activity, menu);
    }

    private void b(final Activity activity, Menu menu) {
        if (!this.oUp) {
            return;
        }
        if (this.oUn || this.oUo) {
            this.oUo = false;
            if (menu != null) {
                for (int i = 0; i < menu.size(); i++) {
                    MenuItem item = menu.getItem(i);
                    if (item.getItemId() != 2131755061) {
                        item.setVisible(false);
                    }
                }
            }
            this.cnC.postDelayed(new Runnable(this) {
                final /* synthetic */ p oUA;

                public final void run() {
                    if (this.oUA.fOi == null) {
                        v.w(this.oUA.TAG, "on post expand search menu, but item is null");
                        return;
                    }
                    v.i(this.oUA.TAG, "try to expand action view, searchViewExpand %B", Boolean.valueOf(this.oUA.oUn));
                    if (this.oUA.oUm) {
                        if (!this.oUA.oUn) {
                            l.b(this.oUA.fOi);
                        }
                    } else if (this.oUA.oUz != null) {
                        this.oUA.oUz.bJt();
                    }
                    final View a = l.a(this.oUA.fOi);
                    if (a != null && this.oUA.oUn) {
                        a.findViewById(2131755280).requestFocus();
                        if (this.oUA.oUq) {
                            this.oUA.cnC.postDelayed(new Runnable(this) {
                                final /* synthetic */ AnonymousClass10 oUD;

                                public final void run() {
                                    ((InputMethodManager) activity.getSystemService("input_method")).showSoftInput(a.findViewById(2131755280), 0);
                                }
                            }, 128);
                        }
                    }
                }
            }, 128);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        v.v(this.TAG, "on key down, key code %d, expand %B", Integer.valueOf(i), Boolean.valueOf(this.oUn));
        if (4 != i || !this.oUn) {
            return false;
        }
        bJs();
        return true;
    }

    public final void kj(boolean z) {
        boolean z2 = false;
        String str = this.TAG;
        String str2 = "do expand, expanded[%B], search menu item null[%B]";
        Object[] objArr = new Object[2];
        objArr[0] = Boolean.valueOf(this.oUn);
        if (this.fOi == null) {
            z2 = true;
        }
        objArr[1] = Boolean.valueOf(z2);
        v.d(str, str2, objArr);
        if (!this.oUn) {
            if (this.oUp) {
                this.oUq = z;
                if (this.fOi != null) {
                    this.cnC.post(new Runnable(this) {
                        final /* synthetic */ p oUA;

                        {
                            this.oUA = r1;
                        }

                        public final void run() {
                            if (this.oUA.fOi == null) {
                                v.w(this.oUA.TAG, "post do expand search menu, but search menu item is null");
                            } else if (this.oUA.oUm) {
                                l.b(this.oUA.fOi);
                            } else if (this.oUA.oUz != null) {
                                this.oUA.oUz.bJt();
                            }
                        }
                    });
                    return;
                } else {
                    this.oUo = true;
                    return;
                }
            }
            v.w(this.TAG, "can not expand now");
        }
    }

    public final void bJs() {
        v.d(this.TAG, "do collapse");
        if (this.oUn && this.fOi != null) {
            if (this.oUm) {
                l.c(this.fOi);
            } else if (this.oUz != null) {
                this.oUz.collapseActionView();
            }
        }
    }

    public final boolean bIT() {
        if (this.oUr != null) {
            return this.oUr.bIT();
        }
        return false;
    }

    public final boolean bIU() {
        if (this.oUr != null) {
            return this.oUr.bIU();
        }
        return false;
    }

    public final void a(final FragmentActivity fragmentActivity, final boolean z) {
        v.d(this.TAG, "doNewExpand, searchViewExpand " + this.oUn);
        if (!this.oUn) {
            this.oUn = true;
            b((Activity) fragmentActivity, null);
            this.cnC.post(new Runnable(this) {
                final /* synthetic */ p oUA;

                public final void run() {
                    if (fragmentActivity == null || fragmentActivity.isFinishing()) {
                        v.w(this.oUA.TAG, "want to expand search view, but activity status error");
                    } else if (z) {
                        fragmentActivity.aR();
                    }
                }
            });
            if (this.oUs != null) {
                this.oUs.Og();
            }
        }
    }

    public final void b(final FragmentActivity fragmentActivity, final boolean z) {
        v.d(this.TAG, "doNewCollapse, searchViewExpand " + this.oUn);
        if (this.oUn) {
            this.oUn = false;
            brc();
            if (this.oUr != null) {
                this.oUr.kg(false);
            }
            this.cnC.post(new Runnable(this) {
                final /* synthetic */ p oUA;

                public final void run() {
                    if (fragmentActivity == null || fragmentActivity.isFinishing()) {
                        v.w(this.oUA.TAG, "want to collapse search view, but activity status error");
                    } else if (z) {
                        fragmentActivity.aR();
                    }
                }
            });
            if (this.oUs != null) {
                this.cnC.post(new Runnable(this) {
                    final /* synthetic */ p oUA;

                    {
                        this.oUA = r1;
                    }

                    public final void run() {
                        this.oUA.oUs.Of();
                    }
                });
            }
        }
        this.cnC.post(new Runnable(this) {
            final /* synthetic */ p oUA;

            public final void run() {
                if (this.oUA.fOi == null) {
                    v.w(this.oUA.TAG, "want to collapse search view, but search menu item is null");
                    return;
                }
                if (!(fragmentActivity == null || fragmentActivity.isFinishing())) {
                    FragmentActivity fragmentActivity = fragmentActivity;
                    InputMethodManager inputMethodManager = (InputMethodManager) fragmentActivity.getSystemService("input_method");
                    if (inputMethodManager != null) {
                        View currentFocus = fragmentActivity.getCurrentFocus();
                        if (currentFocus != null) {
                            IBinder windowToken = currentFocus.getWindowToken();
                            if (windowToken != null) {
                                inputMethodManager.hideSoftInputFromWindow(windowToken, 0);
                            }
                        }
                    }
                }
                View a = l.a(this.oUA.fOi);
                if (a != null) {
                    a.findViewById(2131755280).clearFocus();
                }
            }
        });
    }
}
