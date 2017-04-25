package android.support.v4.app;

public final class i {
    final j<?> oU;

    i(j<?> jVar) {
        this.oU = jVar;
    }

    final Fragment i(String str) {
        return this.oU.oT.i(str);
    }

    public final void noteStateNotSaved() {
        this.oU.oT.qk = false;
    }

    public final boolean execPendingActions() {
        return this.oU.oT.execPendingActions();
    }
}
