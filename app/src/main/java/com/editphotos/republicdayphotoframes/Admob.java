package com.editphotos.republicdayphotoframes;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;

public class Admob {

    static OnDismiss onDismiss;

    public Admob(OnDismiss onDismiss) {
        this.onDismiss = onDismiss;
    }

    public Admob(){

    }

    public static void setBanner(LinearLayout banner, Context context){


            MobileAds.initialize(context, initializationStatus -> {
            });
            AdView adView = new AdView(context);
            banner.addView(adView);
            adView.setAdUnitId(AdsUnit.BANNER);
            AdSize adSize = AdSize.BANNER;
            adView.setAdSize(adSize);
            AdRequest adRequest = new AdRequest.Builder().build();
            adView.loadAd(adRequest);
        }


    public static void loadint(Context context) {

            MobileAds.initialize(context, initializationStatus -> {
            });

            AdRequest adRequest = new AdRequest.Builder().build();

            InterstitialAd.load(context,AdsUnit.INTERSTITIAL, adRequest,
                    new InterstitialAdLoadCallback() {
                        @Override
                        public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                            // The mInterstitialAd reference will be null until
                            // an ad is loaded.
                            AdsUnit.mInterstitialAd = interstitialAd;
                            Log.i(TAG, "onAdLoaded");
                        }

                        @Override
                        public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                            // Handle the error
                            Log.d(TAG, loadAdError.toString());
                            AdsUnit.mInterstitialAd = null;
                        }
                    });

        }


    public void showIntCall(Activity activity, boolean isReload){

        if (AdsUnit.mInterstitialAd != null) {
            AdsUnit.mInterstitialAd .show(activity);

            AdsUnit.mInterstitialAd .setFullScreenContentCallback(new FullScreenContentCallback() {
                @Override
                public void onAdDismissedFullScreenContent() {
                    super.onAdDismissedFullScreenContent();

                    if (isReload){
                        AdsUnit.mInterstitialAd  = null;
                        Admob.loadint(activity);
                    }

                    onDismiss.OnDismiss();
                }

                @Override
                public void onAdFailedToShowFullScreenContent(@NonNull AdError adError) {
                    super.onAdFailedToShowFullScreenContent(adError);
                    onDismiss.OnDismiss();
                }
            });
        } else {
            Log.d("TAG", "The interstitial ad wasn't ready yet.");
            onDismiss.OnDismiss();
        }
    }

//    public static void loadReward(Context context){
//        AdRequest adRequest = new AdRequest.Builder().build();
//        RewardedAd.load(context, AdsUnit.REWARDEDAD,
//                adRequest, new RewardedAdLoadCallback() {
//                    @Override
//                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
//                        // Handle the error.
//                        Log.d(TAG, loadAdError.toString());
//                        AdsUnit.mRewardedAd = null;
//                    }
//
//                    @Override
//                    public void onAdLoaded(@NonNull RewardedAd ad) {
//                        AdsUnit.mRewardedAd = ad;
//                        Log.d(TAG, "Ad was loaded.");
//                    }
//                });
//    }
//
//    public void showRewCall(Activity activity, boolean isReload){
//
//        if (AdsUnit.mRewardedAd != null) {
//            AdsUnit.mRewardedAd.show(activity, rewardItem -> {
//                Toast.makeText(activity,"Reward Collected",Toast.LENGTH_SHORT).show();
//
//            });
//            AdsUnit.mRewardedAd.setFullScreenContentCallback(new FullScreenContentCallback() {
//                @Override
//                public void onAdDismissedFullScreenContent() {
//                    super.onAdDismissedFullScreenContent();
//
//                    if (isReload){
//                        AdsUnit.mRewardedAd = null ;
//                        Admob.loadReward(activity);
//
//                    }
//                    onDismiss.OnDismiss();
//                }
//
//                @Override
//                public void onAdFailedToShowFullScreenContent(@NonNull AdError adError) {
//                    super.onAdFailedToShowFullScreenContent(adError);
//                    Toast.makeText(activity,"Failed To Reward Please Try After Some Time ",Toast.LENGTH_SHORT).show();
//
//                }
//            });
//        } else {
//            Log.d("TAG", "The interstitial ad wasn't ready yet.");
//            Toast.makeText(activity,"Please Wait Ads Is Loading ! ",Toast.LENGTH_SHORT).show();
////            onDismiss.OnDismiss();
//        }
//    }

}
