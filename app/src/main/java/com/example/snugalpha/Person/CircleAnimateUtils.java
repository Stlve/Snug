package com.example.snugalpha.Person;

import android.animation.Animator;
import android.os.Build;
import android.view.View;
import android.view.ViewAnimationUtils;

public class CircleAnimateUtils {
    public static void handleAnimate(final View animateView){

        if(animateView.getVisibility()==View.VISIBLE){
            if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){
                final Animator animator= ViewAnimationUtils.createCircularReveal(animateView,
                        0,
                        0,
                        0,
                        (float)Math.hypot(animateView.getWidth(),animateView.getHeight()));
                animator.addListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {
                        animateView.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {

                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {

                    }
                });
                animator.setDuration(300);
                animator.start();
            }else{
                animateView.setVisibility(View.VISIBLE);
            }
            animateView.setEnabled(true);

        }
        else{
            if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){
                final Animator animatorHide= ViewAnimationUtils.createCircularReveal(animateView,
                        0,
                        0,
                        (float)Math.hypot(animateView.getWidth(),animateView.getHeight()),
                        0);
                animatorHide.addListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        animateView.setVisibility(View.GONE);

                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {

                    }
                });
                animatorHide.setDuration(300);
                animatorHide.start();
            }else{
                animateView.setVisibility(View.GONE);
            }
            animateView.setEnabled(false);

        }
    }
}
