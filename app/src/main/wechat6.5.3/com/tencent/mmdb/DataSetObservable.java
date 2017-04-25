package com.tencent.mmdb;

public class DataSetObservable extends Observable<DataSetObserver> {
    public void notifyChanged() {
        synchronized (this.mObservers) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((DataSetObserver) this.mObservers.get(size)).onChanged();
            }
        }
    }

    public void notifyInvalidated() {
        synchronized (this.mObservers) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((DataSetObserver) this.mObservers.get(size)).onInvalidated();
            }
        }
    }
}
