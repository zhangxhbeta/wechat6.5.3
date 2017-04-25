package android.support.v7.view;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.XmlResourceParser;
import android.support.v4.view.d;
import android.support.v4.view.l;
import android.support.v7.view.menu.h;
import android.support.v7.view.menu.i;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public final class g extends MenuInflater {
    private static final Class<?>[] NO;
    private static final Class<?>[] NP;
    private final Object[] NQ;
    private final Object[] NR = this.NQ;
    private Object NS;
    private Context mContext;

    private static class a implements OnMenuItemClickListener {
        private static final Class<?>[] NT = new Class[]{MenuItem.class};
        private Object NS;
        private Method NU;

        public a(Object obj, String str) {
            this.NS = obj;
            Class cls = obj.getClass();
            try {
                this.NU = cls.getMethod(str, NT);
            } catch (Throwable e) {
                InflateException inflateException = new InflateException("Couldn't resolve menu item onClick handler " + str + " in class " + cls.getName());
                inflateException.initCause(e);
                throw inflateException;
            }
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            try {
                if (this.NU.getReturnType() == Boolean.TYPE) {
                    return ((Boolean) this.NU.invoke(this.NS, new Object[]{menuItem})).booleanValue();
                }
                this.NU.invoke(this.NS, new Object[]{menuItem});
                return true;
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }
    }

    private class b {
        Menu NV;
        int NW;
        int NX;
        int NY;
        int NZ;
        boolean Oa;
        boolean Ob;
        boolean Oc;
        int Od;
        int Oe;
        CharSequence Of;
        CharSequence Og;
        int Oh;
        char Oi;
        char Oj;
        int Ok;
        boolean Ol;
        boolean Om;
        boolean On;
        int Oo;
        int Op;
        String Oq;
        String Or;
        String Os;
        d Ot;
        final /* synthetic */ g Ou;

        public b(g gVar, Menu menu) {
            this.Ou = gVar;
            this.NV = menu;
            dn();
        }

        public final void dn() {
            this.NW = 0;
            this.NX = 0;
            this.NY = 0;
            this.NZ = 0;
            this.Oa = true;
            this.Ob = true;
        }

        static char p(String str) {
            if (str == null) {
                return '\u0000';
            }
            return str.charAt(0);
        }

        final void e(MenuItem menuItem) {
            boolean z = true;
            menuItem.setChecked(this.Ol).setVisible(this.Om).setEnabled(this.On).setCheckable(this.Ok > 0).setTitleCondensed(this.Og).setIcon(this.Oh).setAlphabeticShortcut(this.Oi).setNumericShortcut(this.Oj);
            if (this.Oo >= 0) {
                l.a(menuItem, this.Oo);
            }
            if (this.Os != null) {
                if (this.Ou.mContext.isRestricted()) {
                    throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
                }
                menuItem.setOnMenuItemClickListener(new a(g.b(this.Ou), this.Os));
            }
            if (this.Ok >= 2) {
                if (menuItem instanceof h) {
                    ((h) menuItem).E(true);
                } else if (menuItem instanceof i) {
                    i iVar = (i) menuItem;
                    try {
                        if (iVar.Qg == null) {
                            iVar.Qg = ((android.support.v4.c.a.b) iVar.Pe).getClass().getDeclaredMethod("setExclusiveCheckable", new Class[]{Boolean.TYPE});
                        }
                        iVar.Qg.invoke(iVar.Pe, new Object[]{Boolean.valueOf(true)});
                    } catch (Exception e) {
                    }
                }
            }
            if (this.Oq != null) {
                l.a(menuItem, (View) newInstance(this.Oq, g.NO, this.Ou.NQ));
            } else {
                z = false;
            }
            if (this.Op > 0 && !r2) {
                l.b(menuItem, this.Op);
            }
            if (this.Ot != null) {
                l.a(menuItem, this.Ot);
            }
        }

        public final SubMenu do() {
            this.Oc = true;
            SubMenu addSubMenu = this.NV.addSubMenu(this.NW, this.Od, this.Oe, this.Of);
            e(addSubMenu.getItem());
            return addSubMenu;
        }

        final <T> T newInstance(String str, Class<?>[] clsArr, Object[] objArr) {
            try {
                Constructor constructor = this.Ou.mContext.getClassLoader().loadClass(str).getConstructor(clsArr);
                constructor.setAccessible(true);
                return constructor.newInstance(objArr);
            } catch (Exception e) {
                return null;
            }
        }
    }

    static /* synthetic */ Object b(g gVar) {
        if (gVar.NS == null) {
            Object obj = gVar.mContext;
            while (!(obj instanceof Activity) && (obj instanceof ContextWrapper)) {
                obj = ((ContextWrapper) obj).getBaseContext();
            }
            gVar.NS = obj;
        }
        return gVar.NS;
    }

    static {
        Class[] clsArr = new Class[]{Context.class};
        NO = clsArr;
        NP = clsArr;
    }

    public g(Context context) {
        super(context);
        this.mContext = context;
        this.NQ = new Object[]{context};
    }

    public final void inflate(int i, Menu menu) {
        if (menu instanceof android.support.v4.c.a.a) {
            XmlResourceParser xmlResourceParser = null;
            try {
                xmlResourceParser = this.mContext.getResources().getLayout(i);
                a(xmlResourceParser, Xml.asAttributeSet(xmlResourceParser), menu);
                if (xmlResourceParser != null) {
                    xmlResourceParser.close();
                }
            } catch (Throwable e) {
                throw new InflateException("Error inflating menu XML", e);
            } catch (Throwable e2) {
                throw new InflateException("Error inflating menu XML", e2);
            } catch (Throwable th) {
                if (xmlResourceParser != null) {
                    xmlResourceParser.close();
                }
            }
        } else {
            super.inflate(i, menu);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(org.xmlpull.v1.XmlPullParser r11, android.util.AttributeSet r12, android.view.Menu r13) {
        /*
        r10 = this;
        r4 = new android.support.v7.view.g$b;
        r4.<init>(r10, r13);
        r0 = r11.getEventType();
        r3 = 0;
        r2 = 0;
    L_0x000b:
        r1 = 2;
        if (r0 != r1) goto L_0x0048;
    L_0x000e:
        r0 = r11.getName();
        r1 = "menu";
        r1 = r0.equals(r1);
        if (r1 == 0) goto L_0x0032;
    L_0x001b:
        r0 = r11.next();
    L_0x001f:
        r1 = 0;
    L_0x0020:
        if (r1 != 0) goto L_0x022f;
    L_0x0022:
        switch(r0) {
            case 1: goto L_0x0226;
            case 2: goto L_0x0050;
            case 3: goto L_0x01ba;
            default: goto L_0x0025;
        };
    L_0x0025:
        r0 = r1;
        r1 = r2;
        r2 = r3;
    L_0x0028:
        r3 = r11.next();
        r9 = r0;
        r0 = r3;
        r3 = r2;
        r2 = r1;
        r1 = r9;
        goto L_0x0020;
    L_0x0032:
        r1 = new java.lang.RuntimeException;
        r2 = new java.lang.StringBuilder;
        r3 = "Expecting menu, got ";
        r2.<init>(r3);
        r0 = r2.append(r0);
        r0 = r0.toString();
        r1.<init>(r0);
        throw r1;
    L_0x0048:
        r0 = r11.next();
        r1 = 1;
        if (r0 != r1) goto L_0x000b;
    L_0x004f:
        goto L_0x001f;
    L_0x0050:
        if (r3 != 0) goto L_0x0025;
    L_0x0052:
        r0 = r11.getName();
        r5 = "group";
        r5 = r0.equals(r5);
        if (r5 == 0) goto L_0x00a6;
    L_0x005f:
        r0 = r4.Ou;
        r0 = r0.mContext;
        r5 = android.support.v7.a.a.k.cl;
        r0 = r0.obtainStyledAttributes(r12, r5);
        r5 = android.support.v7.a.a.k.Lv;
        r6 = 0;
        r5 = r0.getResourceId(r5, r6);
        r4.NW = r5;
        r5 = android.support.v7.a.a.k.Lw;
        r6 = 0;
        r5 = r0.getInt(r5, r6);
        r4.NX = r5;
        r5 = android.support.v7.a.a.k.Lx;
        r6 = 0;
        r5 = r0.getInt(r5, r6);
        r4.NY = r5;
        r5 = android.support.v7.a.a.k.Lt;
        r6 = 0;
        r5 = r0.getInt(r5, r6);
        r4.NZ = r5;
        r5 = android.support.v7.a.a.k.Ly;
        r6 = 1;
        r5 = r0.getBoolean(r5, r6);
        r4.Oa = r5;
        r5 = android.support.v7.a.a.k.Lu;
        r6 = 1;
        r5 = r0.getBoolean(r5, r6);
        r4.Ob = r5;
        r0.recycle();
        r0 = r1;
        r1 = r2;
        r2 = r3;
        goto L_0x0028;
    L_0x00a6:
        r5 = "item";
        r5 = r0.equals(r5);
        if (r5 == 0) goto L_0x019f;
    L_0x00af:
        r0 = r4.Ou;
        r0 = r0.mContext;
        r5 = android.support.v7.a.a.k.cm;
        r5 = r0.obtainStyledAttributes(r12, r5);
        r0 = android.support.v7.a.a.k.LH;
        r6 = 0;
        r0 = r5.getResourceId(r0, r6);
        r4.Od = r0;
        r0 = android.support.v7.a.a.k.LI;
        r6 = r4.NX;
        r0 = r5.getInt(r0, r6);
        r6 = android.support.v7.a.a.k.LL;
        r7 = r4.NY;
        r6 = r5.getInt(r6, r7);
        r7 = -65536; // 0xffffffffffff0000 float:NaN double:NaN;
        r0 = r0 & r7;
        r7 = 65535; // 0xffff float:9.1834E-41 double:3.23786E-319;
        r6 = r6 & r7;
        r0 = r0 | r6;
        r4.Oe = r0;
        r0 = android.support.v7.a.a.k.LM;
        r0 = r5.getText(r0);
        r4.Of = r0;
        r0 = android.support.v7.a.a.k.LN;
        r0 = r5.getText(r0);
        r4.Og = r0;
        r0 = android.support.v7.a.a.k.LG;
        r6 = 0;
        r0 = r5.getResourceId(r0, r6);
        r4.Oh = r0;
        r0 = android.support.v7.a.a.k.LC;
        r0 = r5.getString(r0);
        r0 = android.support.v7.view.g.b.p(r0);
        r4.Oi = r0;
        r0 = android.support.v7.a.a.k.LJ;
        r0 = r5.getString(r0);
        r0 = android.support.v7.view.g.b.p(r0);
        r4.Oj = r0;
        r0 = android.support.v7.a.a.k.LD;
        r0 = r5.hasValue(r0);
        if (r0 == 0) goto L_0x0194;
    L_0x0115:
        r0 = android.support.v7.a.a.k.LD;
        r6 = 0;
        r0 = r5.getBoolean(r0, r6);
        if (r0 == 0) goto L_0x0192;
    L_0x011e:
        r0 = 1;
    L_0x011f:
        r4.Ok = r0;
    L_0x0121:
        r0 = android.support.v7.a.a.k.LE;
        r6 = 0;
        r0 = r5.getBoolean(r0, r6);
        r4.Ol = r0;
        r0 = android.support.v7.a.a.k.LO;
        r6 = r4.Oa;
        r0 = r5.getBoolean(r0, r6);
        r4.Om = r0;
        r0 = android.support.v7.a.a.k.LF;
        r6 = r4.Ob;
        r0 = r5.getBoolean(r0, r6);
        r4.On = r0;
        r0 = android.support.v7.a.a.k.LP;
        r6 = -1;
        r0 = r5.getInt(r0, r6);
        r4.Oo = r0;
        r0 = android.support.v7.a.a.k.LK;
        r0 = r5.getString(r0);
        r4.Os = r0;
        r0 = android.support.v7.a.a.k.Lz;
        r6 = 0;
        r0 = r5.getResourceId(r0, r6);
        r4.Op = r0;
        r0 = android.support.v7.a.a.k.LB;
        r0 = r5.getString(r0);
        r4.Oq = r0;
        r0 = android.support.v7.a.a.k.LA;
        r0 = r5.getString(r0);
        r4.Or = r0;
        r0 = r4.Or;
        if (r0 == 0) goto L_0x0199;
    L_0x016c:
        r0 = 1;
    L_0x016d:
        if (r0 == 0) goto L_0x019b;
    L_0x016f:
        r0 = r4.Op;
        if (r0 != 0) goto L_0x019b;
    L_0x0173:
        r0 = r4.Oq;
        if (r0 != 0) goto L_0x019b;
    L_0x0177:
        r0 = r4.Or;
        r6 = NP;
        r7 = r4.Ou;
        r7 = r7.NR;
        r0 = r4.newInstance(r0, r6, r7);
        r0 = (android.support.v4.view.d) r0;
        r4.Ot = r0;
    L_0x0187:
        r5.recycle();
        r0 = 0;
        r4.Oc = r0;
        r0 = r1;
        r1 = r2;
        r2 = r3;
        goto L_0x0028;
    L_0x0192:
        r0 = 0;
        goto L_0x011f;
    L_0x0194:
        r0 = r4.NZ;
        r4.Ok = r0;
        goto L_0x0121;
    L_0x0199:
        r0 = 0;
        goto L_0x016d;
    L_0x019b:
        r0 = 0;
        r4.Ot = r0;
        goto L_0x0187;
    L_0x019f:
        r5 = "menu";
        r5 = r0.equals(r5);
        if (r5 == 0) goto L_0x01b4;
    L_0x01a8:
        r0 = r4.do();
        r10.a(r11, r12, r0);
        r0 = r1;
        r1 = r2;
        r2 = r3;
        goto L_0x0028;
    L_0x01b4:
        r2 = 1;
        r9 = r1;
        r1 = r0;
        r0 = r9;
        goto L_0x0028;
    L_0x01ba:
        r0 = r11.getName();
        if (r3 == 0) goto L_0x01cd;
    L_0x01c0:
        r5 = r0.equals(r2);
        if (r5 == 0) goto L_0x01cd;
    L_0x01c6:
        r2 = 0;
        r0 = 0;
        r9 = r1;
        r1 = r0;
        r0 = r9;
        goto L_0x0028;
    L_0x01cd:
        r5 = "group";
        r5 = r0.equals(r5);
        if (r5 == 0) goto L_0x01de;
    L_0x01d6:
        r4.dn();
        r0 = r1;
        r1 = r2;
        r2 = r3;
        goto L_0x0028;
    L_0x01de:
        r5 = "item";
        r5 = r0.equals(r5);
        if (r5 == 0) goto L_0x0218;
    L_0x01e7:
        r0 = r4.Oc;
        if (r0 != 0) goto L_0x0025;
    L_0x01eb:
        r0 = r4.Ot;
        if (r0 == 0) goto L_0x01ff;
    L_0x01ef:
        r0 = r4.Ot;
        r0 = r0.hasSubMenu();
        if (r0 == 0) goto L_0x01ff;
    L_0x01f7:
        r4.do();
        r0 = r1;
        r1 = r2;
        r2 = r3;
        goto L_0x0028;
    L_0x01ff:
        r0 = 1;
        r4.Oc = r0;
        r0 = r4.NV;
        r5 = r4.NW;
        r6 = r4.Od;
        r7 = r4.Oe;
        r8 = r4.Of;
        r0 = r0.add(r5, r6, r7, r8);
        r4.e(r0);
        r0 = r1;
        r1 = r2;
        r2 = r3;
        goto L_0x0028;
    L_0x0218:
        r5 = "menu";
        r0 = r0.equals(r5);
        if (r0 == 0) goto L_0x0025;
    L_0x0221:
        r0 = 1;
        r1 = r2;
        r2 = r3;
        goto L_0x0028;
    L_0x0226:
        r0 = new java.lang.RuntimeException;
        r1 = "Unexpected end of document";
        r0.<init>(r1);
        throw r0;
    L_0x022f:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.view.g.a(org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.view.Menu):void");
    }
}
