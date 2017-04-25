package android.support.v4.view.a;

import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.List;

final class d {

    static class AnonymousClass1 extends AccessibilityNodeProvider {
        final /* synthetic */ a zx;

        AnonymousClass1(a aVar) {
            this.zx = aVar;
        }

        public final AccessibilityNodeInfo createAccessibilityNodeInfo(int i) {
            this.zx.cj();
            return null;
        }

        public final List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String str, int i) {
            return this.zx.ch();
        }

        public final boolean performAction(int i, int i2, Bundle bundle) {
            return this.zx.cg();
        }
    }

    interface a {
        boolean cg();

        List<Object> ch();

        Object cj();
    }
}
