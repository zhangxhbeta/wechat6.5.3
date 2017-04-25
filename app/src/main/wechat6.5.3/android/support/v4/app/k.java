package android.support.v4.app;

import android.os.Bundle;
import android.support.v4.app.Fragment.SavedState;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.List;

public abstract class k {
    public abstract Fragment E(int i);

    public abstract void F(int i);

    public abstract Fragment a(Bundle bundle, String str);

    public abstract void a(Bundle bundle, String str, Fragment fragment);

    public abstract n aW();

    public abstract List<Fragment> aX();

    public abstract void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    public abstract SavedState e(Fragment fragment);

    public abstract boolean executePendingTransactions();

    public abstract boolean isDestroyed();

    public abstract Fragment k(String str);

    public abstract void popBackStack();

    public abstract boolean popBackStackImmediate();
}
