package android.accounts;

import android.accounts.IAccountManager.Stub;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.text.TextUtils;
import android.util.ArraySet;
import android.util.Log;
import com.android.internal.annotations.GuardedBy;
import java.util.Set;

public class Account implements Parcelable {
    public static final Creator<Account> CREATOR = new Creator<Account>() {
        public Account createFromParcel(Parcel source) {
            return new Account(source);
        }

        public Account[] newArray(int size) {
            return new Account[size];
        }
    };
    private static final String TAG = "Account";
    @GuardedBy("sAccessedAccounts")
    private static final Set<Account> sAccessedAccounts = new ArraySet();
    private final String accessId;
    public final String name;
    public final String type;

    public boolean equals(Object o) {
        boolean z = true;
        if (o == this) {
            return true;
        }
        if (!(o instanceof Account)) {
            return false;
        }
        Account other = (Account) o;
        if (!(this.name.equals(other.name) && this.type.equals(other.type))) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return (31 * ((31 * 17) + this.name.hashCode())) + this.type.hashCode();
    }

    public Account(String name, String type) {
        this(name, type, null);
    }

    public Account(Account other, String accessId) {
        this(other.name, other.type, accessId);
    }

    public Account(String name, String type, String accessId) {
        StringBuilder stringBuilder;
        if (TextUtils.isEmpty(name)) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("the name must not be empty: ");
            stringBuilder.append(name);
            throw new IllegalArgumentException(stringBuilder.toString());
        } else if (TextUtils.isEmpty(type)) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("the type must not be empty: ");
            stringBuilder.append(type);
            throw new IllegalArgumentException(stringBuilder.toString());
        } else {
            this.name = name;
            this.type = type;
            this.accessId = accessId;
        }
    }

    public Account(Parcel in) {
        this.name = in.readString();
        this.type = in.readString();
        this.accessId = in.readString();
        if (this.accessId != null) {
            synchronized (sAccessedAccounts) {
                if (sAccessedAccounts.add(this)) {
                    try {
                        Stub.asInterface(ServiceManager.getService("account")).onAccountAccessed(this.accessId);
                    } catch (RemoteException e) {
                        Log.e(TAG, "Error noting account access", e);
                    }
                }
            }
        }
    }

    public String getAccessId() {
        return this.accessId;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.type);
        dest.writeString(this.accessId);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Account {name= XXXXXXXXX, type=");
        stringBuilder.append(this.type);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
