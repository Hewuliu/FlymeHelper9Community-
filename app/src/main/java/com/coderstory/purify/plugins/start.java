package com.coderstory.purify.plugins;

import com.coderstory.purify.BuildConfig;
import com.coderstory.purify.module.FlymeHome;
import com.coderstory.purify.module.FlymeRoot;
import com.coderstory.purify.module.HideApp;
import com.coderstory.purify.module.IsEnable;
import com.coderstory.purify.module.Others;
import com.coderstory.purify.module.RemoveAds;
import com.coderstory.purify.module.ThemePatcher;

import de.robv.android.xposed.IXposedHookInitPackageResources;
import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.IXposedHookZygoteInit;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.callbacks.XC_InitPackageResources;
import de.robv.android.xposed.callbacks.XC_LoadPackage;


public class start implements IXposedHookZygoteInit, IXposedHookLoadPackage, IXposedHookInitPackageResources {
    @Override
    public void handleInitPackageResources(XC_InitPackageResources.InitPackageResourcesParam resparam) {
        new FlymeRoot().handleInitPackageResources(resparam);
        new FlymeHome().handleInitPackageResources(resparam);
    }

    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam lpparam) {
        new FlymeHome().handleLoadPackage(lpparam);
        new IsEnable().handleLoadPackage(lpparam);
        new HideApp().handleLoadPackage(lpparam);
        new Others().handleLoadPackage(lpparam);
        new ThemePatcher().handleLoadPackage(lpparam);
        new FlymeRoot().handleLoadPackage(lpparam);
        new RemoveAds().handleLoadPackage(lpparam);
    }

    @Override
    public void initZygote(StartupParam startupParam) {
        XposedBridge.log("Flyme7助手 " + BuildConfig.VERSION_NAME + " 开始Patch");
    }
}
