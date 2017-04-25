package android.support.v7.app;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.location.Location;
import android.os.Bundle;
import android.support.v4.view.am;
import android.support.v4.view.y;
import android.support.v4.widget.m;
import android.support.v7.a.a.f;
import android.support.v7.view.b;
import android.support.v7.view.d;
import android.support.v7.view.e;
import android.support.v7.widget.ActionBarContextView;
import android.support.v7.widget.ViewStubCompat;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.Window.Callback;
import android.widget.PopupWindow;
import com.tencent.map.geolocation.TencentLocation;
import java.util.Calendar;

class g extends f {
    private static m FO;
    private int FP = -100;
    private boolean FQ;
    boolean FR = true;

    class a extends a {
        final /* synthetic */ g FS;

        a(g gVar, Callback callback) {
            this.FS = gVar;
            super(gVar, callback);
        }

        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            if (this.FS.FR) {
                return a(callback);
            }
            return super.onWindowStartingActionMode(callback);
        }

        final ActionMode a(ActionMode.Callback callback) {
            Object aVar = new android.support.v7.view.f.a(this.FS.mContext, callback);
            AppCompatDelegateImplV7 appCompatDelegateImplV7 = this.FS;
            if (appCompatDelegateImplV7.FY != null) {
                appCompatDelegateImplV7.FY.finish();
            }
            android.support.v7.view.b.a bVar = new b(appCompatDelegateImplV7, aVar);
            ActionBar cV = appCompatDelegateImplV7.cV();
            if (cV != null) {
                appCompatDelegateImplV7.FY = cV.a(bVar);
            }
            if (appCompatDelegateImplV7.FY == null) {
                appCompatDelegateImplV7.dc();
                if (appCompatDelegateImplV7.FY != null) {
                    appCompatDelegateImplV7.FY.finish();
                }
                android.support.v7.view.b.a bVar2 = new b(appCompatDelegateImplV7, bVar);
                if (appCompatDelegateImplV7.FZ == null) {
                    if (appCompatDelegateImplV7.FK) {
                        Context dVar;
                        TypedValue typedValue = new TypedValue();
                        Theme theme = appCompatDelegateImplV7.mContext.getTheme();
                        theme.resolveAttribute(android.support.v7.a.a.a.actionBarTheme, typedValue, true);
                        if (typedValue.resourceId != 0) {
                            Theme newTheme = appCompatDelegateImplV7.mContext.getResources().newTheme();
                            newTheme.setTo(theme);
                            newTheme.applyStyle(typedValue.resourceId, true);
                            dVar = new d(appCompatDelegateImplV7.mContext, 0);
                            dVar.getTheme().setTo(newTheme);
                        } else {
                            dVar = appCompatDelegateImplV7.mContext;
                        }
                        appCompatDelegateImplV7.FZ = new ActionBarContextView(dVar);
                        appCompatDelegateImplV7.Ga = new PopupWindow(dVar, null, android.support.v7.a.a.a.HO);
                        m.a(appCompatDelegateImplV7.Ga, 2);
                        appCompatDelegateImplV7.Ga.setContentView(appCompatDelegateImplV7.FZ);
                        appCompatDelegateImplV7.Ga.setWidth(-1);
                        dVar.getTheme().resolveAttribute(android.support.v7.a.a.a.actionBarSize, typedValue, true);
                        appCompatDelegateImplV7.FZ.aw(TypedValue.complexToDimensionPixelSize(typedValue.data, dVar.getResources().getDisplayMetrics()));
                        appCompatDelegateImplV7.Ga.setHeight(-2);
                        appCompatDelegateImplV7.Gb = new Runnable(appCompatDelegateImplV7) {
                            final /* synthetic */ AppCompatDelegateImplV7 Gr;

                            {
                                this.Gr = r1;
                            }

                            public final void run() {
                                this.Gr.Ga.showAtLocation(this.Gr.FZ, 55, 0, 0);
                                this.Gr.dc();
                                y.d(this.Gr.FZ, 0.0f);
                                this.Gr.Gc = y.U(this.Gr.FZ).p(1.0f);
                                this.Gr.Gc.a(new am(this) {
                                    final /* synthetic */ AnonymousClass5 Gs;

                                    {
                                        this.Gs = r1;
                                    }

                                    public final void q(View view) {
                                        y.d(this.Gs.Gr.FZ, 1.0f);
                                        this.Gs.Gr.Gc.a(null);
                                        this.Gs.Gr.Gc = null;
                                    }

                                    public final void p(View view) {
                                        this.Gs.Gr.FZ.setVisibility(0);
                                    }
                                });
                            }
                        };
                    } else {
                        ViewStubCompat viewStubCompat = (ViewStubCompat) appCompatDelegateImplV7.Ge.findViewById(f.Jb);
                        if (viewStubCompat != null) {
                            viewStubCompat.CE = LayoutInflater.from(appCompatDelegateImplV7.da());
                            appCompatDelegateImplV7.FZ = (ActionBarContextView) viewStubCompat.inflate();
                        }
                    }
                }
                if (appCompatDelegateImplV7.FZ != null) {
                    appCompatDelegateImplV7.dc();
                    appCompatDelegateImplV7.FZ.dT();
                    b eVar = new e(appCompatDelegateImplV7.FZ.getContext(), appCompatDelegateImplV7.FZ, bVar2, appCompatDelegateImplV7.Ga == null);
                    if (bVar.a(eVar, eVar.getMenu())) {
                        eVar.invalidate();
                        appCompatDelegateImplV7.FZ.c(eVar);
                        appCompatDelegateImplV7.FY = eVar;
                        y.d(appCompatDelegateImplV7.FZ, 0.0f);
                        appCompatDelegateImplV7.Gc = y.U(appCompatDelegateImplV7.FZ).p(1.0f);
                        appCompatDelegateImplV7.Gc.a(new am(appCompatDelegateImplV7) {
                            final /* synthetic */ AppCompatDelegateImplV7 Gr;

                            {
                                this.Gr = r1;
                            }

                            public final void q(View view) {
                                y.d(this.Gr.FZ, 1.0f);
                                this.Gr.Gc.a(null);
                                this.Gr.Gc = null;
                            }

                            public final void p(View view) {
                                this.Gr.FZ.setVisibility(0);
                                this.Gr.FZ.sendAccessibilityEvent(32);
                                if (this.Gr.FZ.getParent() != null) {
                                    y.Y((View) this.Gr.FZ.getParent());
                                }
                            }
                        });
                        if (appCompatDelegateImplV7.Ga != null) {
                            appCompatDelegateImplV7.Eo.getDecorView().post(appCompatDelegateImplV7.Gb);
                        }
                    } else {
                        appCompatDelegateImplV7.FY = null;
                    }
                }
                appCompatDelegateImplV7.FY = appCompatDelegateImplV7.FY;
            }
            b bVar3 = appCompatDelegateImplV7.FY;
            if (bVar3 != null) {
                return aVar.b(bVar3);
            }
            return null;
        }
    }

    g(Context context, Window window, c cVar) {
        super(context, window, cVar);
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null && this.FP == -100) {
            this.FP = bundle.getInt("appcompat:local_night_mode", -100);
        }
    }

    Callback a(Callback callback) {
        return new a(this, callback);
    }

    public final boolean cY() {
        this.FQ = true;
        int at = at(this.FP == -100 ? d.FC : this.FP);
        if (at == -1) {
            return false;
        }
        Resources resources = this.mContext.getResources();
        Configuration configuration = resources.getConfiguration();
        int i = configuration.uiMode & 48;
        at = at == 2 ? 32 : 16;
        if (i == at) {
            return false;
        }
        configuration.uiMode = at | (configuration.uiMode & -49);
        resources.updateConfiguration(configuration, null);
        return true;
    }

    int at(int i) {
        Location location = null;
        switch (i) {
            case -100:
                return -1;
            case 0:
                boolean z;
                if (FO == null) {
                    FO = new m(this.mContext.getApplicationContext());
                }
                m mVar = FO;
                a aVar = m.Hb;
                if (m.a(aVar)) {
                    z = aVar.Hd;
                } else {
                    Location o;
                    if (android.support.v4.content.d.d(mVar.mContext, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
                        o = mVar.o(TencentLocation.NETWORK_PROVIDER);
                    } else {
                        o = null;
                    }
                    if (android.support.v4.content.d.d(mVar.mContext, "android.permission.ACCESS_FINE_LOCATION") == 0) {
                        location = mVar.o("gps");
                    }
                    if (location == null || o == null) {
                        if (location != null) {
                            o = location;
                        }
                    } else if (location.getTime() > o.getTime()) {
                        o = location;
                    }
                    if (o != null) {
                        m.b(o);
                        z = aVar.Hd;
                    } else {
                        int i2 = Calendar.getInstance().get(11);
                        z = i2 < 6 || i2 >= 22;
                    }
                }
                return z ? 2 : 1;
            default:
                return i;
        }
    }

    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.FP != -100) {
            bundle.putInt("appcompat:local_night_mode", this.FP);
        }
    }
}
