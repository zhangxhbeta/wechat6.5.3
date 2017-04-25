package android.support.v4.app;

import android.graphics.Rect;
import android.transition.Transition;
import android.transition.Transition.EpicenterCallback;
import android.transition.TransitionSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnPreDrawListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

final class o {

    static class AnonymousClass2 implements OnPreDrawListener {
        final /* synthetic */ View qU;
        final /* synthetic */ Transition qV;
        final /* synthetic */ View qW;
        final /* synthetic */ b qX;
        final /* synthetic */ Map qY;
        final /* synthetic */ Map qZ;
        final /* synthetic */ ArrayList ra;

        AnonymousClass2(View view, Transition transition, View view2, b bVar, Map map, Map map2, ArrayList arrayList) {
            this.qU = view;
            this.qV = transition;
            this.qW = view2;
            this.qX = bVar;
            this.qY = map;
            this.qZ = map2;
            this.ra = arrayList;
        }

        public final boolean onPreDraw() {
            this.qU.getViewTreeObserver().removeOnPreDrawListener(this);
            if (this.qV != null) {
                this.qV.removeTarget(this.qW);
            }
            View view = this.qX.getView();
            if (view != null) {
                if (!this.qY.isEmpty()) {
                    o.a(this.qZ, view);
                    this.qZ.keySet().retainAll(this.qY.values());
                    for (Entry entry : this.qY.entrySet()) {
                        View view2 = (View) this.qZ.get((String) entry.getValue());
                        if (view2 != null) {
                            view2.setTransitionName((String) entry.getKey());
                        }
                    }
                }
                if (this.qV != null) {
                    o.a(this.ra, view);
                    this.ra.removeAll(this.qZ.values());
                    this.ra.add(this.qW);
                    o.b(this.qV, this.ra);
                }
            }
            return true;
        }
    }

    static class AnonymousClass3 extends EpicenterCallback {
        private Rect rc;
        final /* synthetic */ a rd;

        AnonymousClass3(a aVar) {
            this.rd = aVar;
        }

        public final Rect onGetEpicenter(Transition transition) {
            if (this.rc == null && this.rd.rj != null) {
                this.rc = o.x(this.rd.rj);
            }
            return this.rc;
        }
    }

    static class AnonymousClass4 implements OnPreDrawListener {
        final /* synthetic */ View nV;
        final /* synthetic */ ArrayList nX;
        final /* synthetic */ Transition qV;
        final /* synthetic */ View qW;
        final /* synthetic */ Map qZ;
        final /* synthetic */ ArrayList ra;
        final /* synthetic */ Transition re;
        final /* synthetic */ ArrayList rf;
        final /* synthetic */ Transition rg;
        final /* synthetic */ ArrayList rh;
        final /* synthetic */ Transition ri;

        AnonymousClass4(View view, Transition transition, ArrayList arrayList, Transition transition2, ArrayList arrayList2, Transition transition3, ArrayList arrayList3, Map map, ArrayList arrayList4, Transition transition4, View view2) {
            this.nV = view;
            this.qV = transition;
            this.ra = arrayList;
            this.re = transition2;
            this.rf = arrayList2;
            this.rg = transition3;
            this.nX = arrayList3;
            this.qZ = map;
            this.rh = arrayList4;
            this.ri = transition4;
            this.qW = view2;
        }

        public final boolean onPreDraw() {
            this.nV.getViewTreeObserver().removeOnPreDrawListener(this);
            if (this.qV != null) {
                o.a(this.qV, this.ra);
            }
            if (this.re != null) {
                o.a(this.re, this.rf);
            }
            if (this.rg != null) {
                o.a(this.rg, this.nX);
            }
            for (Entry entry : this.qZ.entrySet()) {
                ((View) entry.getValue()).setTransitionName((String) entry.getKey());
            }
            int size = this.rh.size();
            for (int i = 0; i < size; i++) {
                this.ri.excludeTarget((View) this.rh.get(i), false);
            }
            this.ri.excludeTarget(this.qW, false);
            return true;
        }
    }

    public static class a {
        public View rj;
    }

    public interface b {
        View getView();
    }

    public static Object e(Object obj) {
        if (obj != null) {
            return ((Transition) obj).clone();
        }
        return obj;
    }

    public static void a(Object obj, View view, boolean z) {
        ((Transition) obj).excludeTarget(view, z);
    }

    public static void a(Object obj, View view) {
        Transition transition = (Transition) obj;
        final Rect x = x(view);
        transition.setEpicenterCallback(new EpicenterCallback() {
            public final Rect onGetEpicenter(Transition transition) {
                return x;
            }
        });
    }

    public static void a(Object obj, View view, Map<String, View> map, ArrayList<View> arrayList) {
        TransitionSet transitionSet = (TransitionSet) obj;
        arrayList.clear();
        arrayList.addAll(map.values());
        List targets = transitionSet.getTargets();
        targets.clear();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            View view2 = (View) arrayList.get(i);
            int size2 = targets.size();
            if (!a(targets, view2, size2)) {
                targets.add(view2);
                for (int i2 = size2; i2 < targets.size(); i2++) {
                    view2 = (View) targets.get(i2);
                    if (view2 instanceof ViewGroup) {
                        ViewGroup viewGroup = (ViewGroup) view2;
                        int childCount = viewGroup.getChildCount();
                        for (int i3 = 0; i3 < childCount; i3++) {
                            View childAt = viewGroup.getChildAt(i3);
                            if (!a(targets, childAt, size2)) {
                                targets.add(childAt);
                            }
                        }
                    }
                }
            }
        }
        arrayList.add(view);
        b(transitionSet, arrayList);
    }

    private static boolean a(List<View> list, View view, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (list.get(i2) == view) {
                return true;
            }
        }
        return false;
    }

    static Rect x(View view) {
        Rect rect = new Rect();
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        rect.set(iArr[0], iArr[1], iArr[0] + view.getWidth(), iArr[1] + view.getHeight());
        return rect;
    }

    static void a(ArrayList<View> arrayList, View view) {
        if (view.getVisibility() != 0) {
            return;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (viewGroup.isTransitionGroup()) {
                arrayList.add(viewGroup);
                return;
            }
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                a((ArrayList) arrayList, viewGroup.getChildAt(i));
            }
            return;
        }
        arrayList.add(view);
    }

    public static void a(Map<String, View> map, View view) {
        if (view.getVisibility() == 0) {
            String transitionName = view.getTransitionName();
            if (transitionName != null) {
                map.put(transitionName, view);
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    a((Map) map, viewGroup.getChildAt(i));
                }
            }
        }
    }

    public static void a(Object obj, ArrayList<View> arrayList) {
        Transition transition = (Transition) obj;
        int transitionCount;
        if (transition instanceof TransitionSet) {
            TransitionSet transitionSet = (TransitionSet) transition;
            transitionCount = transitionSet.getTransitionCount();
            for (int i = 0; i < transitionCount; i++) {
                a(transitionSet.getTransitionAt(i), (ArrayList) arrayList);
            }
        } else if (!a(transition)) {
            List targets = transition.getTargets();
            if (targets != null && targets.size() == arrayList.size() && targets.containsAll(arrayList)) {
                for (transitionCount = arrayList.size() - 1; transitionCount >= 0; transitionCount--) {
                    transition.removeTarget((View) arrayList.get(transitionCount));
                }
            }
        }
    }

    public static void b(Object obj, ArrayList<View> arrayList) {
        int i = 0;
        Transition transition = (Transition) obj;
        int transitionCount;
        if (transition instanceof TransitionSet) {
            TransitionSet transitionSet = (TransitionSet) transition;
            transitionCount = transitionSet.getTransitionCount();
            while (i < transitionCount) {
                b(transitionSet.getTransitionAt(i), arrayList);
                i++;
            }
        } else if (!a(transition) && d(transition.getTargets())) {
            int size = arrayList.size();
            for (transitionCount = 0; transitionCount < size; transitionCount++) {
                transition.addTarget((View) arrayList.get(transitionCount));
            }
        }
    }

    private static boolean a(Transition transition) {
        return (d(transition.getTargetIds()) && d(transition.getTargetNames()) && d(transition.getTargetTypes())) ? false : true;
    }

    private static boolean d(List list) {
        return list == null || list.isEmpty();
    }
}
