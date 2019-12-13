package com.thetehnocafe.gurleensethi.twopane;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements Fragment1.OnOptionClickListener {

    private boolean isTwoPane;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();

        if (findViewById(R.id.detailContainer) != null) {
            isTwoPane = true;

        }
        else{
            isTwoPane=false;
        }

        if (savedInstanceState == null) {
            fragmentManager.beginTransaction()
                    .add(R.id.container, new Fragment1())
                    .commit();
        }



        }

        @Override
        public void onOptionSelected (String option)
        {

            if (isTwoPane) {
                switch (option) {
                    case "prabhaharan": {
                        fragmentManager.beginTransaction()
                                .replace(R.id.detailContainer, new Network())
                                .commit();
                        break;
                    }
                    case "santhosh": {
                        fragmentManager.beginTransaction()
                                .replace(R.id.detailContainer, new Display())
                                .commit();
                        break;
                    }
                    case "sathish": {
                        fragmentManager.beginTransaction()
                                .replace(R.id.detailContainer, new Fragment2())
                                .commit();
                        break;
                    }
                }
            } else {
                Intent intent = new Intent(this, DetailsActivity.class);
                intent.putExtra(DetailsActivity.EXTRA_SETTING_OPTION, option);
                startActivity(intent);
            }
        }
    }
