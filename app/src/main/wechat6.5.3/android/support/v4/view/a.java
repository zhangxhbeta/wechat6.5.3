package android.support.v4.view;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;

public class a {
    private static final b vW;
    private static final Object vX = vW.bM();
    final Object vY = vW.a(this);

    interface b {
        Object a(a aVar);

        void a(Object obj, View view, int i);

        void a(Object obj, View view, android.support.v4.view.a.b bVar);

        boolean a(Object obj, View view, int i, Bundle bundle);

        boolean a(Object obj, View view, AccessibilityEvent accessibilityEvent);

        boolean a(Object obj, ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent);

        android.support.v4.view.a.c b(Object obj, View view);

        void b(Object obj, View view, AccessibilityEvent accessibilityEvent);

        Object bM();

        void c(Object obj, View view, AccessibilityEvent accessibilityEvent);

        void d(Object obj, View view, AccessibilityEvent accessibilityEvent);
    }

    static class d implements b {
        d() {
        }

        public Object bM() {
            return null;
        }

        public Object a(a aVar) {
            return null;
        }

        public boolean a(Object obj, View view, AccessibilityEvent accessibilityEvent) {
            return false;
        }

        public void b(Object obj, View view, AccessibilityEvent accessibilityEvent) {
        }

        public void a(Object obj, View view, android.support.v4.view.a.b bVar) {
        }

        public void c(Object obj, View view, AccessibilityEvent accessibilityEvent) {
        }

        public boolean a(Object obj, ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            return true;
        }

        public void a(Object obj, View view, int i) {
        }

        public void d(Object obj, View view, AccessibilityEvent accessibilityEvent) {
        }

        public android.support.v4.view.a.c b(Object obj, View view) {
            return null;
        }

        public boolean a(Object obj, View view, int i, Bundle bundle) {
            return false;
        }
    }

    static class a extends d {
        a() {
        }

        public final Object bM() {
            return new AccessibilityDelegate();
        }

        public Object a(final a aVar) {
            return new android.support.v4.view.b.AnonymousClass1(new android.support.v4.view.b.a(this) {
                final /* synthetic */ a wa;

                public final boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
                    return aVar.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
                }

                public final void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
                    aVar.onInitializeAccessibilityEvent(view, accessibilityEvent);
                }

                public final void b(View view, Object obj) {
                    aVar.a(view, new android.support.v4.view.a.b(obj));
                }

                public final void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
                    aVar.onPopulateAccessibilityEvent(view, accessibilityEvent);
                }

                public final boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
                    return aVar.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
                }

                public final void sendAccessibilityEvent(View view, int i) {
                    a.sendAccessibilityEvent(view, i);
                }

                public final void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
                    a.sendAccessibilityEventUnchecked(view, accessibilityEvent);
                }
            });
        }

        public final boolean a(Object obj, View view, AccessibilityEvent accessibilityEvent) {
            return ((AccessibilityDelegate) obj).dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
        }

        public final void b(Object obj, View view, AccessibilityEvent accessibilityEvent) {
            ((AccessibilityDelegate) obj).onInitializeAccessibilityEvent(view, accessibilityEvent);
        }

        public final void a(Object obj, View view, android.support.v4.view.a.b bVar) {
            ((AccessibilityDelegate) obj).onInitializeAccessibilityNodeInfo(view, (AccessibilityNodeInfo) bVar.yT);
        }

        public final void c(Object obj, View view, AccessibilityEvent accessibilityEvent) {
            ((AccessibilityDelegate) obj).onPopulateAccessibilityEvent(view, accessibilityEvent);
        }

        public final boolean a(Object obj, ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            return ((AccessibilityDelegate) obj).onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
        }

        public final void a(Object obj, View view, int i) {
            ((AccessibilityDelegate) obj).sendAccessibilityEvent(view, i);
        }

        public final void d(Object obj, View view, AccessibilityEvent accessibilityEvent) {
            ((AccessibilityDelegate) obj).sendAccessibilityEventUnchecked(view, accessibilityEvent);
        }
    }

    static class c extends a {
        c() {
        }

        public final Object a(final a aVar) {
            return new android.support.v4.view.c.AnonymousClass1(new android.support.v4.view.c.a(this) {
                final /* synthetic */ c wb;

                public final boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
                    return aVar.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
                }

                public final void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
                    aVar.onInitializeAccessibilityEvent(view, accessibilityEvent);
                }

                public final void b(View view, Object obj) {
                    aVar.a(view, new android.support.v4.view.a.b(obj));
                }

                public final void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
                    aVar.onPopulateAccessibilityEvent(view, accessibilityEvent);
                }

                public final boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
                    return aVar.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
                }

                public final void sendAccessibilityEvent(View view, int i) {
                    a.sendAccessibilityEvent(view, i);
                }

                public final void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
                    a.sendAccessibilityEventUnchecked(view, accessibilityEvent);
                }

                public final Object A(View view) {
                    android.support.v4.view.a.c z = a.z(view);
                    return z != null ? z.zt : null;
                }

                public final boolean performAccessibilityAction(View view, int i, Bundle bundle) {
                    return aVar.performAccessibilityAction(view, i, bundle);
                }
            });
        }

        public final android.support.v4.view.a.c b(Object obj, View view) {
            AccessibilityNodeProvider accessibilityNodeProvider = ((AccessibilityDelegate) obj).getAccessibilityNodeProvider(view);
            if (accessibilityNodeProvider != null) {
                return new android.support.v4.view.a.c(accessibilityNodeProvider);
            }
            return null;
        }

        public final boolean a(Object obj, View view, int i, Bundle bundle) {
            return ((AccessibilityDelegate) obj).performAccessibilityAction(view, i, bundle);
        }
    }

    static {
        if (VERSION.SDK_INT >= 16) {
            vW = new c();
        } else if (VERSION.SDK_INT >= 14) {
            vW = new a();
        } else {
            vW = new d();
        }
    }

    public static void sendAccessibilityEvent(View view, int i) {
        vW.a(vX, view, i);
    }

    public static void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
        vW.d(vX, view, accessibilityEvent);
    }

    public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        return vW.a(vX, view, accessibilityEvent);
    }

    public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        vW.c(vX, view, accessibilityEvent);
    }

    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        vW.b(vX, view, accessibilityEvent);
    }

    public void a(View view, android.support.v4.view.a.b bVar) {
        vW.a(vX, view, bVar);
    }

    public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return vW.a(vX, viewGroup, view, accessibilityEvent);
    }

    public static android.support.v4.view.a.c z(View view) {
        return vW.b(vX, view);
    }

    public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
        return vW.a(vX, view, i, bundle);
    }
}
