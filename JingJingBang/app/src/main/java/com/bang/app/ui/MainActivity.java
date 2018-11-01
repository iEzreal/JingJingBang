package com.bang.app.ui;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.bang.app.R;
import com.bang.app.fragment.ARewardFragment;
import com.bang.app.fragment.HomeFragment;
import com.bang.app.fragment.MessageFragment;
import com.bang.app.fragment.MineFragment;

public class MainActivity extends AppCompatActivity {
    private RadioGroup mRadioGroup;
    private RadioButton tabHomeRB;
    private RadioButton tabCourseRB;
    private ImageView tabControllerIV;
    private RadioButton tabShopRB;
    private RadioButton tabMineRB;

    private RadioButton currentRB;

    private FragmentManager fm;

    private HomeFragment homeFragment;
    private ARewardFragment arewardFragment;
    private MessageFragment messageFragment;
    private MineFragment mineFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        fm = getSupportFragmentManager();
        initTabBarView();

        currentRB = tabHomeRB;
        showFragment(0);
    }

    private void initTabBarView () {
        tabHomeRB = findViewById(R.id.tab_home);
        tabCourseRB = findViewById(R.id.tab_classroom);
        tabShopRB = findViewById(R.id.tab_shop);
        tabMineRB = findViewById(R.id.tab_mine);

        mRadioGroup = findViewById(R.id.tab_bar_gr);
        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.tab_home:
                        currentRB = tabHomeRB;
                        showFragment(0);
                        break;

                    case R.id.tab_classroom:
                        currentRB = tabCourseRB;
                        showFragment(1);
                        break;

                    case R.id.tab_shop:
                        currentRB = tabShopRB;
                        showFragment(2);
                        break;

                    case R.id.tab_mine:
                        currentRB = tabMineRB;
                        showFragment(3);
                        break;
                }
            }
        });

        tabControllerIV = findViewById(R.id.tab_controller);
        tabControllerIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ReleaseActivity.class);
                startActivity(intent);
            }
        });
    }

    private void showFragment(int index) {
        FragmentTransaction transaction = fm.beginTransaction();
        hideFragment(transaction);
        switch (index) {
            case 0: {
                if (homeFragment == null) {
                    homeFragment = new HomeFragment();
                    transaction.add(R.id.id_content, homeFragment);
                } else {
                    transaction.show(homeFragment);
                }
                break;
            }

            case 1: {
                if (arewardFragment == null) {
                    arewardFragment = new ARewardFragment();
                    transaction.add(R.id.id_content, arewardFragment);
                } else {
                    transaction.show(arewardFragment);
                }
                break;
            }


            case 2: {
                if (messageFragment == null) {
                    messageFragment = new MessageFragment();
                    transaction.add(R.id.id_content, messageFragment);
                } else {
                    transaction.show(messageFragment);
                }
                break;
            }

            case 3: {
                if (mineFragment == null) {
                    mineFragment = new MineFragment();
                    transaction.add(R.id.id_content, mineFragment);
                } else {
                    transaction.show(mineFragment);
                }
                break;
            }
        }
        transaction.commit();
    }

    private void hideFragment(FragmentTransaction transaction) {
        if (homeFragment != null) {
            transaction.hide(homeFragment);
        }

        if (arewardFragment != null) {
            transaction.hide(arewardFragment);
        }


        if (messageFragment != null) {
            transaction.hide(messageFragment);
        }

        if (mineFragment != null) {
            transaction.hide(mineFragment);
        }
    }
}
