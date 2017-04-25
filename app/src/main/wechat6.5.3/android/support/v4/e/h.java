package android.support.v4.e;

public final class h {

    public interface a<T> {
        T bJ();

        boolean i(T t);
    }

    public static class b<T> implements a<T> {
        private final Object[] vN;
        private int vO;

        public b(int i) {
            if (i <= 0) {
                throw new IllegalArgumentException("The max pool size must be > 0");
            }
            this.vN = new Object[i];
        }

        public T bJ() {
            if (this.vO <= 0) {
                return null;
            }
            int i = this.vO - 1;
            T t = this.vN[i];
            this.vN[i] = null;
            this.vO--;
            return t;
        }

        public boolean i(T t) {
            boolean z;
            for (int i = 0; i < this.vO; i++) {
                if (this.vN[i] == t) {
                    z = true;
                    break;
                }
            }
            z = false;
            if (z) {
                throw new IllegalStateException("Already in the pool!");
            } else if (this.vO >= this.vN.length) {
                return false;
            } else {
                this.vN[this.vO] = t;
                this.vO++;
                return true;
            }
        }
    }

    public static class c<T> extends b<T> {
        private final Object mLock = new Object();

        public c() {
            super(16);
        }

        public final T bJ() {
            T bJ;
            synchronized (this.mLock) {
                bJ = super.bJ();
            }
            return bJ;
        }

        public final boolean i(T t) {
            boolean i;
            synchronized (this.mLock) {
                i = super.i(t);
            }
            return i;
        }
    }
}
