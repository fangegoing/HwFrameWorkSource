package com.android.server.am;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.view.Window;
import android.widget.CheckBox;
import com.android.server.utils.AppInstallerUtil;

public class UnsupportedCompileSdkDialog {
    private final AlertDialog mDialog;
    private final String mPackageName;

    public UnsupportedCompileSdkDialog(AppWarnings manager, Context context, ApplicationInfo appInfo) {
        this.mPackageName = appInfo.packageName;
        Builder builder = new Builder(context).setPositiveButton(17039370, null).setMessage(context.getString(17041270, new Object[]{appInfo.loadSafeLabel(context.getPackageManager())})).setView(17367325);
        Intent installerIntent = AppInstallerUtil.createIntent(context, appInfo.packageName);
        if (installerIntent != null) {
            builder.setNeutralButton(17041269, new -$$Lambda$UnsupportedCompileSdkDialog$K7plB7GGwH9pXpEKQfCoIs-hrJg(context, installerIntent));
        }
        this.mDialog = builder.create();
        this.mDialog.create();
        Window window = this.mDialog.getWindow();
        window.setType(2002);
        window.getAttributes().setTitle("UnsupportedCompileSdkDialog");
        CheckBox alwaysShow = (CheckBox) this.mDialog.findViewById(16908738);
        alwaysShow.setChecked(true);
        alwaysShow.setOnCheckedChangeListener(new -$$Lambda$UnsupportedCompileSdkDialog$F6Sx14AYFmP1rpv_SSjEio25FYc(this, manager));
    }

    public String getPackageName() {
        return this.mPackageName;
    }

    public void show() {
        this.mDialog.show();
    }

    public void dismiss() {
        this.mDialog.dismiss();
    }
}
