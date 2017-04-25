package com.google.android.gms.analytics.internal;

import android.content.Context;
import com.google.android.gms.common.internal.w;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public final class y extends o {
    private volatile String agW;
    private Future<String> ahJ;

    protected y(q qVar) {
        super(qVar);
    }

    private boolean f(Context context, String str) {
        w.U(str);
        w.W("ClientId should be saved from worker thread");
        FileOutputStream fileOutputStream = null;
        try {
            d("Storing clientId", str);
            fileOutputStream = context.openFileOutput("gaClientId", 0);
            fileOutputStream.write(str.getBytes());
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    g("Failed to close clientId writing stream", e);
                }
            }
            return true;
        } catch (FileNotFoundException e2) {
            g("Error creating clientId file", e2);
            if (fileOutputStream == null) {
                return false;
            }
            try {
                fileOutputStream.close();
                return false;
            } catch (IOException e3) {
                g("Failed to close clientId writing stream", e3);
                return false;
            }
        } catch (IOException e32) {
            g("Error writing to clientId file", e32);
            if (fileOutputStream == null) {
                return false;
            }
            try {
                fileOutputStream.close();
                return false;
            } catch (IOException e322) {
                g("Failed to close clientId writing stream", e322);
                return false;
            }
        } catch (Throwable th) {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e3222) {
                    g("Failed to close clientId writing stream", e3222);
                }
            }
        }
    }

    protected final void hm() {
    }

    public final String ix() {
        String str;
        hX();
        synchronized (this) {
            if (this.agW == null) {
                this.ahJ = this.afY.ia().a(new Callable<String>(this) {
                    final /* synthetic */ y ahK;

                    {
                        this.ahK = r1;
                    }

                    public final /* synthetic */ Object call() {
                        n nVar = this.ahK;
                        String u = nVar.u(nVar.afY.ia().mContext);
                        return u == null ? nVar.iz() : u;
                    }
                });
            }
            if (this.ahJ != null) {
                try {
                    this.agW = (String) this.ahJ.get();
                } catch (InterruptedException e) {
                    f("ClientId loading or generation was interrupted", e);
                    this.agW = "0";
                } catch (ExecutionException e2) {
                    g("Failed to load or generate client id", e2);
                    this.agW = "0";
                }
                if (this.agW == null) {
                    this.agW = "0";
                }
                d("Loaded clientId", this.agW);
                this.ahJ = null;
            }
            str = this.agW;
        }
        return str;
    }

    final String iy() {
        synchronized (this) {
            this.agW = null;
            this.ahJ = this.afY.ia().a(new Callable<String>(this) {
                final /* synthetic */ y ahK;

                {
                    this.ahK = r1;
                }

                public final /* synthetic */ Object call() {
                    return this.ahK.iz();
                }
            });
        }
        return ix();
    }

    final String iz() {
        String toLowerCase = UUID.randomUUID().toString().toLowerCase();
        try {
            return !f(this.afY.ia().mContext, toLowerCase) ? "0" : toLowerCase;
        } catch (Exception e) {
            g("Error saving clientId file", e);
            return "0";
        }
    }

    String u(Context context) {
        FileInputStream fileInputStream;
        Object e;
        Throwable th;
        w.W("ClientId should be loaded from worker thread");
        FileInputStream openFileInput;
        try {
            openFileInput = context.openFileInput("gaClientId");
            try {
                byte[] bArr = new byte[36];
                int read = openFileInput.read(bArr, 0, 36);
                if (openFileInput.available() > 0) {
                    F("clientId file seems corrupted, deleting it.");
                    openFileInput.close();
                    context.deleteFile("gaClientId");
                    if (openFileInput == null) {
                        return null;
                    }
                    try {
                        openFileInput.close();
                        return null;
                    } catch (IOException e2) {
                        g("Failed to close client id reading stream", e2);
                        return null;
                    }
                } else if (read < 14) {
                    F("clientId file is empty, deleting it.");
                    openFileInput.close();
                    context.deleteFile("gaClientId");
                    if (openFileInput == null) {
                        return null;
                    }
                    try {
                        openFileInput.close();
                        return null;
                    } catch (IOException e22) {
                        g("Failed to close client id reading stream", e22);
                        return null;
                    }
                } else {
                    openFileInput.close();
                    String str = new String(bArr, 0, read);
                    d("Read client id from disk", str);
                    if (openFileInput != null) {
                        try {
                            openFileInput.close();
                        } catch (IOException e3) {
                            g("Failed to close client id reading stream", e3);
                        }
                    }
                    return str;
                }
            } catch (FileNotFoundException e4) {
                fileInputStream = openFileInput;
                if (fileInputStream != null) {
                    return null;
                }
                try {
                    fileInputStream.close();
                    return null;
                } catch (IOException e222) {
                    g("Failed to close client id reading stream", e222);
                    return null;
                }
            } catch (IOException e5) {
                e = e5;
                try {
                    g("Error reading client id file, deleting it", e);
                    context.deleteFile("gaClientId");
                    if (openFileInput != null) {
                        return null;
                    }
                    try {
                        openFileInput.close();
                        return null;
                    } catch (IOException e2222) {
                        g("Failed to close client id reading stream", e2222);
                        return null;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (openFileInput != null) {
                        try {
                            openFileInput.close();
                        } catch (IOException e22222) {
                            g("Failed to close client id reading stream", e22222);
                        }
                    }
                    throw th;
                }
            }
        } catch (FileNotFoundException e6) {
            fileInputStream = null;
            if (fileInputStream != null) {
                return null;
            }
            fileInputStream.close();
            return null;
        } catch (IOException e7) {
            e = e7;
            openFileInput = null;
            g("Error reading client id file, deleting it", e);
            context.deleteFile("gaClientId");
            if (openFileInput != null) {
                return null;
            }
            openFileInput.close();
            return null;
        } catch (Throwable th3) {
            openFileInput = null;
            th = th3;
            if (openFileInput != null) {
                openFileInput.close();
            }
            throw th;
        }
    }
}
