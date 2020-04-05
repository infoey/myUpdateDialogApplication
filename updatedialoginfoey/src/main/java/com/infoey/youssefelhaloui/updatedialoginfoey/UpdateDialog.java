package com.infoey.youssefelhaloui.updatedialoginfoey;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.ColorStateListDrawable;
import android.net.Uri;
import android.os.Handler;
import android.service.autofill.FieldClassification;
import android.view.View;
import android.view.ViewParent;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

import java.util.Calendar;
import java.util.Objects;

public class UpdateDialog {



    public static void ShowDialogInfoey(final Context context, String styleOption, String show_dialog, String message_dialog, String title_dialog, final String rate_dialog, int timeshowdialog, final int Shownotnow){
        if (show_dialog.equals("show")) {
            if (styleOption.equals("large")) {
            final Dialog welcomeDialog = new Dialog(context);
            welcomeDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            welcomeDialog.setContentView(R.layout.dialog_show_popup);
            welcomeDialog.setCanceledOnTouchOutside(false);
            welcomeDialog.setCancelable(false);
            Objects.requireNonNull(welcomeDialog.getWindow()).getAttributes().windowAnimations = R.style.DialograteAnim;
            final Button updateDialogyes = (Button) welcomeDialog.findViewById(R.id.yesnow);
            final Button updateDialogno = (Button) welcomeDialog.findViewById(R.id.notnow);
            final ImageView Iconyess = (ImageView) welcomeDialog.findViewById(R.id.iconyes);
            PropertyValuesHolder scalex = PropertyValuesHolder.ofFloat(View.SCALE_X, 1.2f);
            PropertyValuesHolder scaley = PropertyValuesHolder.ofFloat(View.SCALE_Y, 1.2f);
            ObjectAnimator anim = ObjectAnimator.ofPropertyValuesHolder(Iconyess, scalex, scaley);
            anim.setRepeatCount(Animation.INFINITE);
            anim.setRepeatMode(ValueAnimator.REVERSE);
            anim.setDuration(1500);
            anim.start();
            final LottieAnimationView animationday = (LottieAnimationView) welcomeDialog.findViewById(R.id.loading);
            RelativeLayout MainLayoutDialog = (RelativeLayout) welcomeDialog.findViewById(R.id.maindialogpopup);
            TextView titledialog = (TextView) welcomeDialog.findViewById(R.id.dialog_content_title);
            TextView messagedialog = (TextView) welcomeDialog.findViewById(R.id.dialog_content_message);
            messagedialog.setText(message_dialog);
            Calendar timezone = Calendar.getInstance();
            int timeOfDay = timezone.get(Calendar.HOUR_OF_DAY);
            if (timeOfDay >= 05 && timeOfDay < 12) {
                if (title_dialog.equals("dontshow")) {
                    titledialog.setText("Good Morning \nHave a wonderful day");
                    animationday.setAnimation("morning.json");
                    animationday.loop(true);
                    MainLayoutDialog.setBackgroundColor(context.getResources().getColor(R.color.morning));
                } else {
                    titledialog.setText(title_dialog);
                    animationday.setAnimation("welcomeanimation.json");
                    MainLayoutDialog.setBackgroundColor(context.getResources().getColor(R.color.welcome));
                }
            }
            else if (timeOfDay >= 12 && timeOfDay < 16) {
                if (title_dialog.equals("dontshow")) {
                    titledialog.setText("Good Afternoon");
                    animationday.setAnimation("afternoon.json");
                    MainLayoutDialog.setBackgroundColor(context.getResources().getColor(R.color.afternoon));
                } else {
                    titledialog.setText(title_dialog);
                    animationday.setAnimation("welcomeanimation.json");
                    MainLayoutDialog.setBackgroundColor(context.getResources().getColor(R.color.welcome));
                }
            }
            else if (timeOfDay >= 16 && timeOfDay < 21) {
                if (title_dialog.equals("dontshow")) {
                    titledialog.setText("Good Evening");
                    animationday.setAnimation("evening.json");
                    MainLayoutDialog.setBackgroundColor(context.getResources().getColor(R.color.evening));
                } else {
                    titledialog.setText(title_dialog);
                    animationday.setAnimation("welcomeanimation.json");
                    MainLayoutDialog.setBackgroundColor(context.getResources().getColor(R.color.welcome));
                }
            }
            else if (timeOfDay >= 21 || timeOfDay < 05) {
                if (title_dialog.equals("dontshow")) {
                    titledialog.setText("Good Night \nHave a lovely night");
                    animationday.setAnimation("night-moon.json");
                    animationday.loop(true);
                    MainLayoutDialog.setBackgroundColor(context.getResources().getColor(R.color.night));
                } else {
                    titledialog.setText(title_dialog);
                    animationday.setAnimation("welcomeanimation.json");
                    MainLayoutDialog.setBackgroundColor(context.getResources().getColor(R.color.welcome));
                }
            }
            welcomeDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            updateDialogno.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    welcomeDialog.dismiss();
                }
            });
            updateDialogyes.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    try {
                        context.startActivity(new Intent(Intent.ACTION_VIEW,
                                Uri.parse("market://details?id=" + rate_dialog)));
                    }
                    catch (android.content.ActivityNotFoundException anfe) {
                        context.startActivity(new Intent(Intent.ACTION_VIEW,
                                Uri.parse("http://play.google.com/store/apps/details?id=" + rate_dialog)));
                    }
                }
            });

            new Handler().postDelayed(new Runnable() {
                public void run() {
                    welcomeDialog.show();
                    updateDialogno.setVisibility(View.INVISIBLE);
                    updateDialogyes.startAnimation(AnimationUtils.loadAnimation(context,R.anim.popup_enter));
                    animationday.resumeAnimation();
                    animationday.playAnimation();
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            updateDialogno.setVisibility(View.VISIBLE);
                        }
                    }, 1000 * Shownotnow);
                }
            }, 1000 * timeshowdialog);
            Window window = welcomeDialog.getWindow();
            window.setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
            } else if (styleOption.equals("small")) {
                final Dialog welcomeDialog = new Dialog(context);
                welcomeDialog.setContentView(R.layout.dialog_popup_update);
                welcomeDialog.setCanceledOnTouchOutside(false);
                welcomeDialog.setCancelable(false);
                Objects.requireNonNull(welcomeDialog.getWindow()).getAttributes().windowAnimations = R.style.DialograteAnim2;
                final Button updateDialogyes = (Button) welcomeDialog.findViewById(R.id.yesnow);
                final Button updateDialogno = (Button) welcomeDialog.findViewById(R.id.notnow);
                final ImageView Iconyess = (ImageView) welcomeDialog.findViewById(R.id.iconyes);
                PropertyValuesHolder scalex = PropertyValuesHolder.ofFloat(View.SCALE_X, 1.2f);
                PropertyValuesHolder scaley = PropertyValuesHolder.ofFloat(View.SCALE_Y, 1.2f);
                ObjectAnimator anim = ObjectAnimator.ofPropertyValuesHolder(Iconyess, scalex, scaley);
                anim.setRepeatCount(Animation.INFINITE);
                anim.setRepeatMode(ValueAnimator.REVERSE);
                anim.setDuration(1500);
                anim.start();
                TextView messagedialog = (TextView) welcomeDialog.findViewById(R.id.dialog_content_message);
                messagedialog.setText(message_dialog);
                updateDialogno.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v)
                    {
                        welcomeDialog.dismiss();
                    }
                });
                updateDialogyes.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View view) {
                        try {
                            context.startActivity(new Intent(Intent.ACTION_VIEW,
                                    Uri.parse("market://details?id=" + rate_dialog)));
                        }
                        catch (android.content.ActivityNotFoundException anfe) {
                            context.startActivity(new Intent(Intent.ACTION_VIEW,
                                    Uri.parse("http://play.google.com/store/apps/details?id=" + rate_dialog)));
                        }
                    }
                });
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        welcomeDialog.show();
                        updateDialogyes.startAnimation(AnimationUtils.loadAnimation(context,R.anim.popup_enter));
                        updateDialogno.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                        updateDialogno.setVisibility(View.INVISIBLE);
                        new Handler().postDelayed(new Runnable() {
                            public void run() {
                                updateDialogno.setVisibility(View.VISIBLE);
                                updateDialogno.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.close_24dp));
                            }
                        }, 1000 * Shownotnow);
                    }
                }, 1000 * timeshowdialog);
                welcomeDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                Window window = welcomeDialog.getWindow();
                window.setLayout(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            }
            else{}}else{}
    }
}
