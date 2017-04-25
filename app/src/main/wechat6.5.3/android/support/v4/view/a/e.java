package android.support.v4.view.a;

import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.List;

final class e {

    static class AnonymousClass1 extends AccessibilityNodeProvider {
        final /* synthetic */ a zy;

        AnonymousClass1(a aVar) {
            this.zy = aVar;
        }

        public final AccessibilityNodeInfo createAccessibilityNodeInfo(int i) {
            this.zy.cj();
            return null;
        }

        public final List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String str, int i) {
            return this.zy.ch();
        }

        public final boolean performAction(int i, int i2, Bundle bundle) {
            return this.zy.cg();
        }

        public final AccessibilityNodeInfo findFocus(int i) {
            this.zy.ck();
            return null;
        }
    }

    interface a {
        boolean cg();

        List<Object> ch();

        Object cj();

        Object ck();
    }
}
