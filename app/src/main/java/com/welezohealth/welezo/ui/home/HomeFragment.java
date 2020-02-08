package com.welezohealth.welezo.ui.home;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.welezohealth.welezo.R;

import butterknife.BindView;

public class HomeFragment extends Fragment {

    private CardView cardmenu;
    private String setTop = "reset", setBottom = "reset", cardsetTop = "reset", cardsetBtm = "reset", grown = "";
    @BindView(R.id.scroll_home)
    NestedScrollView scrollHome;
    private OnscrollUpL onscrollUpL;

    private TextView nameText,searText1,searchText2,backg;
    private HomeViewModel homeViewModel;

    public HomeFragment() {

    }


    public interface OnscrollUpL {

        void scrollup(String s);

        void scrolldownn(String s);

        void Searchscrollup(String s);

        void Searchscrolldownn(String s);
    }


    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        scrollHome = root.findViewById(R.id.scroll_home);
        cardmenu = root.findViewById(R.id.cardMEnu);
        nameText = root.findViewById((R.id.editTex4t4));
        searText1 = root.findViewById((R.id.search1));
        searchText2 = root.findViewById((R.id.search2));
        backg = root.findViewById((R.id.backg));


        nameText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 if (grown.equals("")){

                     grown = "grown";


                     Animation slideUp = AnimationUtils.loadAnimation(getActivity(), R.anim.slide_up_search);

                     if (searText1.getVisibility() == View.GONE) {
                         searText1.setVisibility(View.VISIBLE);
                         searText1.startAnimation(slideUp);

                     }

                     slideUp = AnimationUtils.loadAnimation(getActivity(), R.anim.slide_up_search2);
                     if (searchText2.getVisibility() == View.GONE) {
                         searchText2.setVisibility(View.VISIBLE);
                         searchText2.startAnimation(slideUp);

                     }

                     ValueAnimator anim = ValueAnimator.ofInt(backg.getMeasuredHeight(), backg.getMeasuredHeight() + 300);
                     anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                         @Override
                         public void onAnimationUpdate(ValueAnimator valueAnimator) {
                             int val = (Integer) valueAnimator.getAnimatedValue();
                             ViewGroup.LayoutParams layoutParams = backg.getLayoutParams();
                             layoutParams.height = val;
                             backg.setLayoutParams(layoutParams);
                         }
                     });
                     anim.setDuration(600);
                     anim.start();


                     TranslateAnimation Tanimation2 = new TranslateAnimation(0, 0,0, 20);
                     Tanimation2.setDuration(600);
                     Tanimation2.setFillAfter(true);
                     cardmenu.startAnimation(Tanimation2);


                 }


            }
        });

        scrollHome.setOnScrollChangeListener((NestedScrollView.OnScrollChangeListener) (v, scrollX, scrollY, oldScrollX, oldScrollY) -> {


            if (v.computeVerticalScrollOffset() > 50) {


                if (setTop.equals("reset")) {
                    //  Toast.makeText(ScrollingActivity.this, "Collapsed", Toast.LENGTH_SHORT).show();
                    AlphaAnimation animation1 = new AlphaAnimation(1.0f, 0.0f);
                    animation1.setDuration(200);
                    animation1.setFillAfter(true);
                    nameText.startAnimation(animation1);
                    setTop = "set";
                    setBottom = "reset";
                    onscrollUpL.Searchscrollup("");
                }

            }

            else if (v.computeVerticalScrollOffset() < 50) {

                if (setBottom.equals("reset")) {
                    //Expanded
                    //  Toast.makeText(ScrollingActivity.this, "Exbnfnnpanded" + String.valueOf(appBarLayout.getTotalScrollRange()), Toast.LENGTH_SHORT).show();
                    AlphaAnimation animation1 = new AlphaAnimation(0.0f, 1.0f);
                    animation1.setDuration(200);
                    animation1.setFillAfter(true);
                    nameText.startAnimation(animation1);
                    setBottom = "set";
                    setTop = "reset";
                    onscrollUpL.Searchscrolldownn("");

                }



            }

             if (v.computeVerticalScrollOffset() < 250){
                if (grown.equals("grown")){
                    Toast.makeText(getActivity(), String.valueOf(v.computeVerticalScrollOffset()), Toast.LENGTH_SHORT).show();

                    grown="";
                    Animation slideUp = AnimationUtils.loadAnimation(getActivity(), R.anim.slide_dwn_search);

                    if (searText1.getVisibility() == View.VISIBLE) {
                        searText1.setVisibility(View.GONE);
                        // searText1.startAnimation(slideUp);

                    }

                    slideUp = AnimationUtils.loadAnimation(getActivity(), R.anim.slide_dwn_search2);
                    if (searchText2.getVisibility() == View.VISIBLE) {
                        searchText2.setVisibility(View.GONE);
                        //searchText2.startAnimation(slideUp);

                    }

                    ValueAnimator anim = ValueAnimator.ofInt(backg.getMeasuredHeight(), backg.getMeasuredHeight() - 300);
                    anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                        @Override
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            int val = (Integer) valueAnimator.getAnimatedValue();
                            ViewGroup.LayoutParams layoutParams = backg.getLayoutParams();
                            layoutParams.height = val;
                            backg.setLayoutParams(layoutParams);
                        }
                    });
                    anim.setDuration(600);
                    anim.start();


                    TranslateAnimation Tanimation2 = new TranslateAnimation(0, 0,20, 0);
                    Tanimation2.setDuration(600);
                    Tanimation2.setFillAfter(true);
                    cardmenu.startAnimation(Tanimation2);

                }
            }


            if (v.computeVerticalScrollOffset() > 550) {
                if (cardsetTop.equals("reset")) {
                    AlphaAnimation animation1 = new AlphaAnimation(1.0f, 0.0f);
                    animation1.setDuration(200);
                    animation1.setFillAfter(true);
                    cardmenu.startAnimation(animation1);
                    cardsetTop = "set";
                    cardsetBtm = "reset";
                    onscrollUpL.scrollup(String.valueOf(v.computeVerticalScrollOffset()));
                }
            } else if (v.computeVerticalScrollOffset() < 550) {
                if (cardsetBtm.equals("reset")) {

                    cardsetBtm = "set";
                    cardsetTop = "reset";
                    AlphaAnimation animation2 = new AlphaAnimation(0.0f, 1.0f);
                    animation2.setDuration(200);
                    animation2.setFillAfter(true);
                    cardmenu.startAnimation(animation2);
                    onscrollUpL.scrolldownn(String.valueOf(v.computeVerticalScrollOffset()));

                }
            }

        });


        return root;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Activity activity = (Activity) context;
        try {

            onscrollUpL = (OnscrollUpL) activity;
        } catch (Exception e) {
            Toast.makeText(activity, "error in home frag", Toast.LENGTH_SHORT).show();
        }


    }
}