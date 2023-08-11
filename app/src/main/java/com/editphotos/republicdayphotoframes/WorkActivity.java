package com.editphotos.republicdayphotoframes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.PointF;
import android.graphics.Typeface;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Gallery;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

public class WorkActivity extends AppCompatActivity {

    private static final int DRAG = 1;
    private static final int MY_PREMISSION_REQUEST = 1;
    private static final int NONE = 0;
    private static final int RESULT_LOAD_IMAGE = 0;
    private static final int ZOOM = 2;
    /* access modifiers changed from: private */
    public InterstitialAd mInterstitialAd;
    Button apply;
    ImageButton btn_frame;
    ImageButton btn_image;
    ImageButton btn_save;
    ImageButton btn_share;
    ImageButton btn_text;
    LinearLayout colorLayout;
    Context context;
    String currentImage = RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
    float d = 0.0f;
    EditText editText;
    Gallery gallery;
    ImageView image_frame;
    ImageView image_gallery;
    float[] lastEvent = null;
    float newRot = 0.0f;
    float oldDist = 1.0f;
    Typeface selected;
    Button sendText;
    TextView text1;
    TextView text10;
    TextView text11;
    TextView text12;
    TextView text13;
    TextView text14;
    TextView text15;
    TextView text16;
    TextView text17;
    TextView text18;
    TextView text19;
    TextView text2;
    TextView text20;
    TextView text3;
    TextView text4;
    TextView text5;
    TextView text6;
    TextView text7;
    TextView text8;
    TextView text9;
    int textColor;
    LinearLayout textLayout;
    TextView textView;
    Typeface tf1;
    Typeface tf10;
    Typeface tf11;
    Typeface tf12;
    Typeface tf13;
    Typeface tf14;
    Typeface tf15;
    Typeface tf16;
    Typeface tf17;
    Typeface tf18;
    Typeface tf19;
    Typeface tf2;
    Typeface tf20;
    Typeface tf3;
    Typeface tf4;
    Typeface tf5;
    Typeface tf6;
    Typeface tf7;
    Typeface tf8;
    Typeface tf9;
    LinearLayout thumb_obj;
    private boolean isOutSide;
    private boolean isZoomAndRotate;
    private AdView mAdView;
    private PointF mid = new PointF();
    private int mode = 0;
    private PointF start = new PointF();
    private float xCoOrdinate;
    private float yCoOrdinate;

    /* access modifiers changed from: private */
    public static Bitmap getScreenShot(View view) {
        view.setDrawingCacheEnabled(true);
        Bitmap createBitmap = Bitmap.createBitmap(view.getDrawingCache());
        view.setDrawingCacheEnabled(false);
        return createBitmap;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_work);
        getWindow().addFlags(1024);
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        this.mAdView = (AdView) findViewById(R.id.adView);
        AdRequest build = new AdRequest.Builder().build();
        this.mAdView.loadAd(build);
        InterstitialAd.load(this, getResources().getString(R.string.InterstitialAd), build, new InterstitialAdLoadCallback() {
            public void onAdLoaded(InterstitialAd interstitialAd) {
                InterstitialAd unused = WorkActivity.this.mInterstitialAd = interstitialAd;
            }
        });
        this.tf1 = Typeface.createFromAsset(getAssets(), "font/f1.ttf");
        this.tf2 = Typeface.createFromAsset(getAssets(), "font/f2.ttf");
        this.tf3 = Typeface.createFromAsset(getAssets(), "font/f3.ttf");
        this.tf4 = Typeface.createFromAsset(getAssets(), "font/f4.ttf");
        this.tf5 = Typeface.createFromAsset(getAssets(), "font/f5.ttf");
        this.tf6 = Typeface.createFromAsset(getAssets(), "font/f6.ttf");
        this.tf7 = Typeface.createFromAsset(getAssets(), "font/f7.ttf");
        this.tf8 = Typeface.createFromAsset(getAssets(), "font/f8.ttf");
        this.tf9 = Typeface.createFromAsset(getAssets(), "font/f9.ttf");
        this.tf10 = Typeface.createFromAsset(getAssets(), "font/f10.ttf");
        this.tf11 = Typeface.createFromAsset(getAssets(), "font/f11.ttf");
        this.tf12 = Typeface.createFromAsset(getAssets(), "font/f12.ttf");
        this.tf13 = Typeface.createFromAsset(getAssets(), "font/f13.ttf");
        this.tf14 = Typeface.createFromAsset(getAssets(), "font/f14.ttf");
        this.tf15 = Typeface.createFromAsset(getAssets(), "font/f15.ttf");
        this.tf16 = Typeface.createFromAsset(getAssets(), "font/f16.ttf");
        this.tf17 = Typeface.createFromAsset(getAssets(), "font/f17.ttf");
        this.tf18 = Typeface.createFromAsset(getAssets(), "font/f18.ttf");
        this.tf19 = Typeface.createFromAsset(getAssets(), "font/f19.ttf");
        this.tf20 = Typeface.createFromAsset(getAssets(), "font/f20.ttf");
        this.text1 = (TextView) findViewById(R.id.text1);
        this.text2 = (TextView) findViewById(R.id.text2);
        this.text3 = (TextView) findViewById(R.id.text3);
        this.text4 = (TextView) findViewById(R.id.text4);
        this.text5 = (TextView) findViewById(R.id.text5);
        this.text6 = (TextView) findViewById(R.id.text6);
        this.text7 = (TextView) findViewById(R.id.text7);
        this.text8 = (TextView) findViewById(R.id.text8);
        this.text9 = (TextView) findViewById(R.id.text9);
        this.text10 = (TextView) findViewById(R.id.text10);
        this.text11 = (TextView) findViewById(R.id.text11);
        this.text12 = (TextView) findViewById(R.id.text12);
        this.text13 = (TextView) findViewById(R.id.text13);
        this.text14 = (TextView) findViewById(R.id.text14);
        this.text15 = (TextView) findViewById(R.id.text15);
        this.text16 = (TextView) findViewById(R.id.text16);
        this.text17 = (TextView) findViewById(R.id.text17);
        this.text18 = (TextView) findViewById(R.id.text18);
        this.text19 = (TextView) findViewById(R.id.text19);
        this.text20 = (TextView) findViewById(R.id.text20);
        ((ImageButton) findViewById(R.id.FF660000)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                WorkActivity.this.textView.setTextColor(ContextCompat.getColor(WorkActivity.this, R.color.FF660000));
                WorkActivity workActivity = WorkActivity.this;
                workActivity.textColor = ContextCompat.getColor(workActivity, R.color.FF660000);
            }
        });
        ((ImageButton) findViewById(R.id.FFFF0000)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                WorkActivity.this.textView.setTextColor(ContextCompat.getColor(WorkActivity.this, R.color.FFFF0000));
                WorkActivity workActivity = WorkActivity.this;
                workActivity.textColor = ContextCompat.getColor(workActivity, R.color.FFFF0000);
            }
        });
        ((ImageButton) findViewById(R.id.FFFF6600)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                WorkActivity.this.textView.setTextColor(ContextCompat.getColor(WorkActivity.this, R.color.FFFF6600));
                WorkActivity workActivity = WorkActivity.this;
                workActivity.textColor = ContextCompat.getColor(workActivity, R.color.FFFF6600);
            }
        });
        ((ImageButton) findViewById(R.id.FFFFCC00)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                WorkActivity.this.textView.setTextColor(ContextCompat.getColor(WorkActivity.this, R.color.FFFFCC00));
                WorkActivity workActivity = WorkActivity.this;
                workActivity.textColor = ContextCompat.getColor(workActivity, R.color.FFFFCC00);
            }
        });
        ((ImageButton) findViewById(R.id.FF009900)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                WorkActivity.this.textView.setTextColor(ContextCompat.getColor(WorkActivity.this, R.color.FF009900));
                WorkActivity workActivity = WorkActivity.this;
                workActivity.textColor = ContextCompat.getColor(workActivity, R.color.FF009900);
            }
        });
        ((ImageButton) findViewById(R.id.FF009999)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                WorkActivity.this.textView.setTextColor(ContextCompat.getColor(WorkActivity.this, R.color.FF009999));
                WorkActivity workActivity = WorkActivity.this;
                workActivity.textColor = ContextCompat.getColor(workActivity, R.color.FF009999);
            }
        });
        ((ImageButton) findViewById(R.id.FF0000FF)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                WorkActivity.this.textView.setTextColor(ContextCompat.getColor(WorkActivity.this, R.color.FF0000FF));
                WorkActivity workActivity = WorkActivity.this;
                workActivity.textColor = ContextCompat.getColor(workActivity, R.color.FF0000FF);
            }
        });
        ((ImageButton) findViewById(R.id.FF990099)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                WorkActivity.this.textView.setTextColor(ContextCompat.getColor(WorkActivity.this, R.color.FF990099));
                WorkActivity workActivity = WorkActivity.this;
                workActivity.textColor = ContextCompat.getColor(workActivity, R.color.FF990099);
            }
        });
        ((ImageButton) findViewById(R.id.FFFF6666)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                WorkActivity.this.textView.setTextColor(ContextCompat.getColor(WorkActivity.this, R.color.FFFF6666));
                WorkActivity workActivity = WorkActivity.this;
                workActivity.textColor = ContextCompat.getColor(workActivity, R.color.FFFF6666);
            }
        });
        ((ImageButton) findViewById(R.id.FFFFFFFF)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                WorkActivity.this.textView.setTextColor(ContextCompat.getColor(WorkActivity.this, R.color.FFFFFFFF));
                WorkActivity workActivity = WorkActivity.this;
                workActivity.textColor = ContextCompat.getColor(workActivity, R.color.FFFFFFFF);
            }
        });
        ((ImageButton) findViewById(R.id.FF787878)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                WorkActivity.this.textView.setTextColor(ContextCompat.getColor(WorkActivity.this, R.color.FF787878));
                WorkActivity workActivity = WorkActivity.this;
                workActivity.textColor = ContextCompat.getColor(workActivity, R.color.FF787878);
            }
        });
        ((ImageButton) findViewById(R.id.FF000000)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                WorkActivity.this.textView.setTextColor(ContextCompat.getColor(WorkActivity.this, R.color.FF000000));
                WorkActivity workActivity = WorkActivity.this;
                workActivity.textColor = ContextCompat.getColor(workActivity, R.color.FF000000);
            }
        });
        Button button = (Button) findViewById(R.id.textSend);
        this.apply = button;
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                WorkActivity.this.colorLayout.setVisibility(View.GONE);
            }
        });
        Gallery gallery2 = (Gallery) findViewById(R.id.gallery);
        this.gallery = gallery2;
        gallery2.setSpacing(2);
        final GalleryImageAdapter galleryImageAdapter = new GalleryImageAdapter(this);
        this.gallery.setAdapter(galleryImageAdapter);
        this.gallery.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                WorkActivity.this.image_frame.setImageResource(galleryImageAdapter.mImageIds[i].intValue());
            }
        });
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.textLayout);
        this.textLayout = linearLayout;
        linearLayout.setVisibility(View.GONE);
        TextView textView2 = (TextView) findViewById(R.id.textView);
        this.textView = textView2;
        textView2.setVisibility(View.GONE);
        this.editText = (EditText) findViewById(R.id.editText);
        this.sendText = (Button) findViewById(R.id.textSend);
        LinearLayout linearLayout2 = (LinearLayout) findViewById(R.id.colorLayout);
        this.colorLayout = linearLayout2;
        linearLayout2.setVisibility(View.GONE);
        this.thumb_obj = (LinearLayout) findViewById(R.id.llGallery);
        this.sendText.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                WorkActivity.this.textView.setText(WorkActivity.this.editText.getText().toString());
                WorkActivity.this.textView.setVisibility(View.VISIBLE);
                WorkActivity.this.textLayout.setVisibility(View.GONE);
                WorkActivity.this.editText.setText(RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED);
                WorkActivity.this.scrollViewButtons();
                WorkActivity.this.setTypeFaces();
                WorkActivity workActivity = WorkActivity.this;
                workActivity.changeColors(workActivity.textView);
                ((InputMethodManager) WorkActivity.this.getSystemService(Context.INPUT_METHOD_SERVICE)).toggleSoftInput(1, 0);
                WorkActivity.this.colorLayout.setVisibility(View.VISIBLE);
            }
        });
        this.image_gallery = (ImageView) findViewById(R.id.userImage);
        try {
            this.image_gallery.setImageBitmap(MediaStore.Images.Media.getBitmap(getContentResolver(), Uri.parse(getIntent().getStringExtra("stringUri"))));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.image_gallery.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                WorkActivity.this.viewTransformation((ImageView) view, motionEvent);
                WorkActivity.this.image_gallery.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                return true;
            }
        });
        this.textView.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                TextView textView = (TextView) view;
                textView.bringToFront();
                WorkActivity.this.viewTransformation(textView, motionEvent);
                return true;
            }
        });
        this.image_gallery = (ImageView) findViewById(R.id.userImage);
        this.image_frame = (ImageView) findViewById(R.id.backgroundImage);
        this.btn_frame = (ImageButton) findViewById(R.id.bgBtn);
        this.btn_image = (ImageButton) findViewById(R.id.bgGallery);
        this.btn_text = (ImageButton) findViewById(R.id.txtBtn);
        this.btn_save = (ImageButton) findViewById(R.id.saveBtn);
        this.btn_share = (ImageButton) findViewById(R.id.shareBtn);
        this.btn_frame.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (WorkActivity.this.thumb_obj.getVisibility() == View.GONE) {
                    WorkActivity.this.thumb_obj.setVisibility(View.VISIBLE);
                    WorkActivity.this.textLayout.setVisibility(View.GONE);
                    WorkActivity.this.colorLayout.setVisibility(View.GONE);
                } else {
                    WorkActivity.this.thumb_obj.setVisibility(View.GONE);
                }
                final GalleryImageAdapter galleryImageAdapter = new GalleryImageAdapter(WorkActivity.this);
                WorkActivity.this.gallery.setAdapter(galleryImageAdapter);
                WorkActivity.this.gallery.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                        WorkActivity.this.image_frame.setImageResource(galleryImageAdapter.mImageIds[i].intValue());
                    }
                });
            }
        });
        this.btn_image.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                WorkActivity.this.startActivityForResult(new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI), 0);
                WorkActivity.this.colorLayout.setVisibility(View.GONE);
                WorkActivity.this.mInterstitialAd.show(WorkActivity.this);
            }
        });
        this.btn_save.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Bitmap access$400 = WorkActivity.getScreenShot(WorkActivity.this.findViewById(R.id.rLayout));
                WorkActivity workActivity = WorkActivity.this;
                workActivity.currentImage = "image" + System.currentTimeMillis() + ".png";
                WorkActivity.this.store(access$400);
                WorkActivity.this.mInterstitialAd.show(WorkActivity.this);
            }
        });
        this.btn_text.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (WorkActivity.this.textLayout.getVisibility() != View.VISIBLE) {
                    WorkActivity.this.textLayout.setVisibility(View.VISIBLE);
                    WorkActivity.this.colorLayout.setVisibility(View.GONE);
                    WorkActivity.this.thumb_obj.setVisibility(View.GONE);
                    WorkActivity.this.mInterstitialAd.show(WorkActivity.this);
                    return;
                }
                WorkActivity.this.textLayout.setVisibility(View.GONE);
            }
        });
        this.btn_share.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Bitmap access$400 = WorkActivity.getScreenShot(WorkActivity.this.findViewById(R.id.rLayout));
                WorkActivity workActivity = WorkActivity.this;
                workActivity.currentImage = "image" + System.currentTimeMillis() + ".png";
                WorkActivity.this.shareImage(access$400);
                WorkActivity.this.mInterstitialAd.show(WorkActivity.this);
            }
        });
    }

    /* access modifiers changed from: private */
    public void store(Bitmap bitmap) {
        String file = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).toString();
        File file2 = new File(file + "/Independence Day Photo Frame");
        file2.mkdirs();
        int nextInt = new Random().nextInt(10000);
        File file3 = new File(file2, "Image-" + nextInt + ".jpg");
        if (file3.exists()) {
            file3.delete();
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file3);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 90, fileOutputStream);
            Toast.makeText(this, "image saved ! check gallery", Toast.LENGTH_LONG).show();
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        MediaScannerConnection.scanFile(this, new String[]{file3.toString()}, (String[]) null, new MediaScannerConnection.OnScanCompletedListener() {
            public void onScanCompleted(String str, Uri uri) {
                Log.i("ExternalStorage", "Scanned " + str + ":");
                StringBuilder sb = new StringBuilder();
                sb.append("-> uri=");
                sb.append(uri);
                Log.i("ExternalStorage", sb.toString());
            }
        });
    }

    /* access modifiers changed from: private */
    public void shareImage(Bitmap bitmap) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("image/jpeg");
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, new ByteArrayOutputStream());
        intent.putExtra("android.intent.extra.STREAM", Uri.parse(MediaStore.Images.Media.insertImage(getContentResolver(), bitmap, "Title", (String) null)));
        startActivity(Intent.createChooser(intent, "Select"));
    }

    /* access modifiers changed from: private */
    public void viewTransformation(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action != 0) {
            if (action == 1) {
                this.isZoomAndRotate = false;
                if (this.mode == 1) {
                    motionEvent.getX();
                    motionEvent.getY();
                }
            } else if (action != 2) {
                if (action != 4) {
                    if (action != 5) {
                        if (action != 6) {
                            return;
                        }
                        this.mode = 0;
                        this.lastEvent = null;
                        return;
                    }
                    float spacing = spacing(motionEvent);
                    this.oldDist = spacing;
                    if (spacing > 10.0f) {
                        midPoint(this.mid, motionEvent);
                        this.mode = 2;
                    }
                    float[] fArr = new float[4];
                    this.lastEvent = fArr;
                    fArr[0] = motionEvent.getX(0);
                    this.lastEvent[1] = motionEvent.getX(1);
                    this.lastEvent[2] = motionEvent.getY(0);
                    this.lastEvent[3] = motionEvent.getY(1);
                    this.d = rotation(motionEvent);
                    return;
                }
            } else if (!this.isOutSide) {
                if (this.mode == 1) {
                    this.isZoomAndRotate = false;
                    view.animate().x(motionEvent.getRawX() + this.xCoOrdinate).y(motionEvent.getRawY() + this.yCoOrdinate).setDuration(0).start();
                }
                if (this.mode == 2 && motionEvent.getPointerCount() == 2) {
                    float spacing2 = spacing(motionEvent);
                    if (spacing2 > 10.0f) {
                        float scaleX = (spacing2 / this.oldDist) * view.getScaleX();
                        view.setScaleX(scaleX);
                        view.setScaleY(scaleX);
                    }
                    if (this.lastEvent != null) {
                        this.newRot = rotation(motionEvent);
                        view.setRotation(view.getRotation() + (this.newRot - this.d));
                        return;
                    }
                    return;
                }
                return;
            } else {
                return;
            }
            this.isOutSide = false;
            this.mode = 0;
            this.lastEvent = null;
            this.mode = 0;
            this.lastEvent = null;
            return;
        }
        this.xCoOrdinate = view.getX() - motionEvent.getRawX();
        this.yCoOrdinate = view.getY() - motionEvent.getRawY();
        this.start.set(motionEvent.getX(), motionEvent.getY());
        this.isOutSide = false;
        this.mode = 1;
        this.lastEvent = null;
    }

    private float rotation(MotionEvent motionEvent) {
        return (float) Math.toDegrees(Math.atan2((double) (motionEvent.getY(0) - motionEvent.getY(1)), (double) (motionEvent.getX(0) - motionEvent.getX(1))));
    }

    private float spacing(MotionEvent motionEvent) {
        float x = motionEvent.getX(0) - motionEvent.getX(1);
        float y = motionEvent.getY(0) - motionEvent.getY(1);
        return (float) ((int) Math.sqrt((double) ((x * x) + (y * y))));
    }

    private void midPoint(PointF pointF, MotionEvent motionEvent) {
        pointF.set((motionEvent.getX(0) + motionEvent.getX(1)) / 2.0f, (motionEvent.getY(0) + motionEvent.getY(1)) / 2.0f);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 0 && i2 == -1 && intent != null) {
            String[] strArr = {"_data"};
            Cursor query = getContentResolver().query(intent.getData(), strArr, (String) null, (String[]) null, (String) null);
            query.moveToFirst();
            @SuppressLint("Range") String string = query.getString(query.getColumnIndex(strArr[0]));
            query.close();
            this.image_gallery.setImageBitmap(BitmapFactory.decodeFile(string));
            this.btn_image.setEnabled(true);
        }
    }

    /* access modifiers changed from: private */
    public void scrollViewButtons() {
        this.text1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                WorkActivity workActivity = WorkActivity.this;
                workActivity.selected = workActivity.tf1;
                WorkActivity.this.textView.setTypeface(WorkActivity.this.selected);
            }
        });
        this.text2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                WorkActivity workActivity = WorkActivity.this;
                workActivity.selected = workActivity.tf2;
                WorkActivity.this.textView.setTypeface(WorkActivity.this.selected);
            }
        });
        this.text3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                WorkActivity workActivity = WorkActivity.this;
                workActivity.selected = workActivity.tf3;
                WorkActivity.this.textView.setTypeface(WorkActivity.this.selected);
            }
        });
        this.text4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                WorkActivity workActivity = WorkActivity.this;
                workActivity.selected = workActivity.tf4;
                WorkActivity.this.textView.setTypeface(WorkActivity.this.selected);
            }
        });
        this.text5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                WorkActivity workActivity = WorkActivity.this;
                workActivity.selected = workActivity.tf5;
                WorkActivity.this.textView.setTypeface(WorkActivity.this.selected);
            }
        });
        this.text6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                WorkActivity workActivity = WorkActivity.this;
                workActivity.selected = workActivity.tf6;
                WorkActivity.this.textView.setTypeface(WorkActivity.this.selected);
            }
        });
        this.text7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                WorkActivity workActivity = WorkActivity.this;
                workActivity.selected = workActivity.tf7;
                WorkActivity.this.textView.setTypeface(WorkActivity.this.selected);
            }
        });
        this.text8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                WorkActivity workActivity = WorkActivity.this;
                workActivity.selected = workActivity.tf8;
                WorkActivity.this.textView.setTypeface(WorkActivity.this.selected);
            }
        });
        this.text9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                WorkActivity workActivity = WorkActivity.this;
                workActivity.selected = workActivity.tf9;
                WorkActivity.this.textView.setTypeface(WorkActivity.this.selected);
            }
        });
        this.text10.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                WorkActivity workActivity = WorkActivity.this;
                workActivity.selected = workActivity.tf10;
                WorkActivity.this.textView.setTypeface(WorkActivity.this.selected);
            }
        });
        this.text11.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                WorkActivity workActivity = WorkActivity.this;
                workActivity.selected = workActivity.tf11;
                WorkActivity.this.textView.setTypeface(WorkActivity.this.selected);
            }
        });
        this.text12.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                WorkActivity workActivity = WorkActivity.this;
                workActivity.selected = workActivity.tf12;
                WorkActivity.this.textView.setTypeface(WorkActivity.this.selected);
            }
        });
        this.text13.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                WorkActivity workActivity = WorkActivity.this;
                workActivity.selected = workActivity.tf13;
                WorkActivity.this.textView.setTypeface(WorkActivity.this.selected);
            }
        });
        this.text14.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                WorkActivity workActivity = WorkActivity.this;
                workActivity.selected = workActivity.tf14;
                WorkActivity.this.textView.setTypeface(WorkActivity.this.selected);
            }
        });
        this.text15.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                WorkActivity workActivity = WorkActivity.this;
                workActivity.selected = workActivity.tf15;
                WorkActivity.this.textView.setTypeface(WorkActivity.this.selected);
            }
        });
        this.text16.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                WorkActivity workActivity = WorkActivity.this;
                workActivity.selected = workActivity.tf16;
                WorkActivity.this.textView.setTypeface(WorkActivity.this.selected);
            }
        });
        this.text17.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                WorkActivity workActivity = WorkActivity.this;
                workActivity.selected = workActivity.tf17;
                WorkActivity.this.textView.setTypeface(WorkActivity.this.selected);
            }
        });
        this.text18.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                WorkActivity workActivity = WorkActivity.this;
                workActivity.selected = workActivity.tf18;
                WorkActivity.this.textView.setTypeface(WorkActivity.this.selected);
            }
        });
        this.text19.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                WorkActivity workActivity = WorkActivity.this;
                workActivity.selected = workActivity.tf19;
                WorkActivity.this.textView.setTypeface(WorkActivity.this.selected);
            }
        });
        this.text20.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                WorkActivity workActivity = WorkActivity.this;
                workActivity.selected = workActivity.tf20;
                WorkActivity.this.textView.setTypeface(WorkActivity.this.selected);
            }
        });
    }

    /* access modifiers changed from: private */
    public void setTypeFaces() {
        this.text1.setTypeface(this.tf1);
        this.text2.setTypeface(this.tf2);
        this.text3.setTypeface(this.tf3);
        this.text4.setTypeface(this.tf4);
        this.text5.setTypeface(this.tf5);
        this.text6.setTypeface(this.tf6);
        this.text7.setTypeface(this.tf7);
        this.text8.setTypeface(this.tf8);
        this.text9.setTypeface(this.tf9);
        this.text10.setTypeface(this.tf10);
        this.text11.setTypeface(this.tf11);
        this.text12.setTypeface(this.tf12);
        this.text13.setTypeface(this.tf13);
        this.text14.setTypeface(this.tf14);
        this.text15.setTypeface(this.tf15);
        this.text16.setTypeface(this.tf16);
        this.text17.setTypeface(this.tf17);
        this.text18.setTypeface(this.tf18);
        this.text19.setTypeface(this.tf19);
        this.text20.setTypeface(this.tf20);
    }

    public void changeColors(TextView textView2) {
        textView2.setTextColor(getResources().getColor(R.color.transparentBlack));
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
}