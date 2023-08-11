package com.editphotos.republicdayphotoframes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.ump.ConsentDebugSettings;
import com.google.android.ump.ConsentForm;
import com.google.android.ump.ConsentInformation;
import com.google.android.ump.ConsentRequestParameters;
import com.google.android.ump.FormError;
import com.google.android.ump.UserMessagingPlatform;

public class MainActivity extends AppCompatActivity {

    private static final int MY_PREMISSION_REQUEST = 1;
    /* access modifiers changed from: private */
    public int PICK_IMAGE_REQUEST = 0;
    /* access modifiers changed from: private */
    public ConsentForm consentForm;
    /* access modifiers changed from: private */
    public ConsentInformation consentInformation;
    ImageButton btnStart;
    private AdView mAdView;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_main);
        ConsentRequestParameters build = new ConsentRequestParameters.Builder().setConsentDebugSettings(new ConsentDebugSettings.Builder(this).setDebugGeography(1).build()).build();
        ConsentInformation consentInformation2 = UserMessagingPlatform.getConsentInformation(this);
        this.consentInformation = consentInformation2;
        consentInformation2.requestConsentInfoUpdate(this, build, new ConsentInformation.OnConsentInfoUpdateSuccessListener() {
            public void onConsentInfoUpdateSuccess() {
                if (MainActivity.this.consentInformation.isConsentFormAvailable()) {
                    MainActivity.this.loadForm();
                }
            }
        }, new ConsentInformation.OnConsentInfoUpdateFailureListener() {
            public void onConsentInfoUpdateFailure(FormError formError) {
            }
        });
        getWindow().addFlags(1024);
        this.btnStart = (ImageButton) findViewById(R.id.btnStart);
        Admob.loadint(MainActivity.this);
      //  Admob.loadReward(First_Screen.this);
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        this.mAdView = (AdView) findViewById(R.id.adView);
        this.mAdView.loadAd(new AdRequest.Builder().build());
//        if (ContextCompat.checkSelfPermission(this, "android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
//            if (ActivityCompat.shouldShowRequestPermissionRationale(this, "android.permission.WRITE_EXTERNAL_STORAGE")) {
//                ActivityCompat.requestPermissions(this, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 1);
//            } else {
//                ActivityCompat.requestPermissions(this, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 1);
//            }
//        }
        this.btnStart.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction("android.intent.action.GET_CONTENT");
                MainActivity.this.startActivityForResult(Intent.createChooser(intent, "Select Picture"), MainActivity.this.PICK_IMAGE_REQUEST);
            }
        });
    }

    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.app_name);
        builder.setMessage("Do you want to exit?").setCancelable(false).setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                MainActivity.this.finish();
            }
        }).setNegativeButton("No", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        builder.create().show();
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == this.PICK_IMAGE_REQUEST && i2 == -1 && intent != null && intent.getData() != null) {
            Uri data = intent.getData();
            Intent intent2 = new Intent(getApplicationContext(), WorkActivity.class);
            intent2.putExtra("stringUri", data.toString());
            startActivity(intent2);
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i == 1) {
            if (iArr.length <= 0 || iArr[0] != 0) {
                Toast.makeText(this, "No premission granted!", Toast.LENGTH_SHORT).show();
                finish();
                return;
            }
            int checkSelfPermission = ContextCompat.checkSelfPermission(this, "android.permission.WRITE_EXTERNAL_STORAGE");
        }
    }

    public void loadForm() {
        UserMessagingPlatform.loadConsentForm(this, new UserMessagingPlatform.OnConsentFormLoadSuccessListener() {
            public void onConsentFormLoadSuccess(ConsentForm consentForm) {
                ConsentForm unused = MainActivity.this.consentForm = consentForm;
                if (MainActivity.this.consentInformation.getConsentStatus() == 2) {
                    consentForm.show(MainActivity.this, new ConsentForm.OnConsentFormDismissedListener() {
                        public void onConsentFormDismissed(FormError formError) {
                            MainActivity.this.consentInformation.getConsentStatus();
                            MainActivity.this.loadForm();
                        }
                    });
                }
            }
        }, new UserMessagingPlatform.OnConsentFormLoadFailureListener() {
            public void onConsentFormLoadFailure(FormError formError) {
            }
        });
    }
}