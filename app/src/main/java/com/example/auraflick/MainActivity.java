package com.example.auraflick;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.inputmethodservice.KeyboardView;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import static com.example.auraflick.MoviesActivity.getContext;

public class MainActivity extends AppCompatActivity {

    private Button btnMove;
    private Button btnFavorites;
    private EditText how;
    private String feeling, feel;
    private CheckBox movie, tv;
    boolean first, second;

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            View v = getCurrentFocus();
            if ( v instanceof EditText) {
                Rect outRect = new Rect();
                v.getGlobalVisibleRect(outRect);
                if (!outRect.contains((int)event.getRawX(), (int)event.getRawY())) {
                    v.clearFocus();
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                }
            }
        }
        return super.dispatchTouchEvent( event );
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        how = findViewById(R.id.etHow);
        btnFavorites = findViewById(R.id.btnFavorites);
        movie = findViewById(R.id.cbMovies);
        tv = findViewById(R.id.cbTV);

        Drawable backgrounds[] = new Drawable[2];

        backgrounds[0] = getResources().getDrawable(R.drawable.et_shape);
        backgrounds[1] = getResources().getDrawable(R.drawable.et_shape_focused);

        final TransitionDrawable transition = new TransitionDrawable(backgrounds);

        how.setBackground(transition);

        how.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus) {
                    transition.startTransition(100);
                } else {
                    transition.reverseTransition(100);
                }
            }
        });

        how.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId == EditorInfo.IME_ACTION_SEARCH) {
                    if(movie.isChecked()) {
                        first = true;
                    } else {
                        first = false;
                    }
                    if(tv.isChecked()) {
                        second = true;
                    } else {
                        second = false;
                    }

                    feeling = how.getText().toString();
                    feeling = feeling.toLowerCase();

                    if(feeling.equals("happy") || feeling.equals("cheerful") || feeling.equals("delighted") || feeling.equals("ecstatic") || feeling.equals("glad") || feeling.equals("joyful") || feeling.equals("joyous") || feeling.equals("jubilant") || feeling.equals("lively") || feeling.equals("overjoyed") || feeling.equals("thrilled") || feeling.equals("upbeat")) {
                        feel = "happy";
                    } else if(feeling.equals("sad") || feeling.equals("unhappy") || feeling.equals("depressed") || feeling.equals("bitter") || feeling.equals("dismal") || feeling.equals("heartbroken") || feeling.equals("melancholy") || feeling.equals("pessimistic") || feeling.equals("somber") || feeling.equals("sorry") || feeling.equals("sorrowful")) {
                        feel = "sad";
                    } else if(feeling.equals("scared") || feeling.equals("frightened") || feeling.equals("afraid") || feeling.equals("anxious") || feeling.equals("fearful") || feeling.equals("panicked") || feeling.equals("terrified") || feeling.equals("startled")) {
                        feel = "scared";
                    } else if(feeling.equals("intrigued") || feeling.equals("fascinated") || feeling.equals("interested") || feeling.equals("mindblow")) {
                        feel = "mindblow";
                    } else if(feeling.equals("funny") || feeling.equals("comical") || feeling.equals("humorous") || feeling.equals("absurd") || feeling.equals("amusing") || feeling.equals("entertaining") || feeling.equals("hilarious") || feeling.equals("ludicrous") || feeling.equals("playful") || feeling.equals("ridiculous") || feeling.equals("silly")) {
                        feel = "funny";
                    } else {
                        feel = "happy";
                    }
                    moveToActivityTwo();
                    return true;
                }
                return false;
            }
        });

        btnFavorites.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToFavorites();
            }
        });
    }

    private void moveToActivityTwo(){
        Intent intent = new Intent(MainActivity.this, MoviesActivity.class);
        intent.putExtra("moviechecked", first);
        intent.putExtra("tvchecked", second);
        intent.putExtra("feel", feel);
        startActivity(intent);
    }

    public void moveToFavorites() {
        Intent intent = new Intent(MainActivity.this, FavoritesActivity.class);
        startActivity(intent);
    }

}
