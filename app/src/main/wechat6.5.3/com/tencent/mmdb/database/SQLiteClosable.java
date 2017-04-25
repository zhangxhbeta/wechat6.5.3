package com.tencent.mmdb.database;

import java.io.Closeable;

public abstract class SQLiteClosable implements Closeable {
    private int mReferenceCount = 1;

    public abstract void onAllReferencesReleased();

    @Deprecated
    protected void onAllReferencesReleasedFromContainer() {
        onAllReferencesReleased();
    }

    public void acquireReference() {
        synchronized (this) {
            if (this.mReferenceCount <= 0) {
                throw new IllegalStateException("attempt to re-open an already-closed object: " + this);
            }
            this.mReferenceCount++;
        }
    }

    public void releaseReference() {
        synchronized (this) {
            int i = this.mReferenceCount - 1;
            this.mReferenceCount = i;
            Object obj = i == 0 ? 1 : null;
        }
        if (obj != null) {
            onAllReferencesReleased();
        }
    }

    @Deprecated
    public void releaseReferenceFromContainer() {
        synchronized (this) {
            int i = this.mReferenceCount - 1;
            this.mReferenceCount = i;
            Object obj = i == 0 ? 1 : null;
        }
        if (obj != null) {
            onAllReferencesReleasedFromContainer();
        }
    }

    public void close() {
        releaseReference();
    }
}
