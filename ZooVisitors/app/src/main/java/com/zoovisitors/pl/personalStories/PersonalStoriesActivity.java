package com.zoovisitors.pl.personalStories;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.zoovisitors.GlobalVariables;
import com.zoovisitors.R;
import com.zoovisitors.backend.Animal;
import com.zoovisitors.bl.callbacks.GetObjectInterface;
import com.zoovisitors.pl.BaseActivity;
import com.zoovisitors.pl.customViews.CustomRelativeLayout;

public class PersonalStoriesActivity extends BaseActivity {

    private int layoutWidth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_stories);

        //set the action bar.
        setActionBar(R.color.lightGreenIcon);

        //calculate the screen width.
        int screenSize = getResources().getDisplayMetrics().widthPixels;
        layoutWidth = screenSize/2;

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(layoutWidth, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.width = layoutWidth;

        LinearLayout firstCol = findViewById(R.id.first_column_story);
        firstCol.setLayoutParams(params);

        LinearLayout secondCol = findViewById(R.id.second_column_story);
        secondCol.setLayoutParams(params);

        GlobalVariables.bl.getPersonalStories(new GetObjectInterface() {

            @Override
            public void onSuccess(Object response) {
                Animal.PersonalStories[] stories = ((Animal.PersonalStories[]) response);
                CustomRelativeLayout card;
                for (int i = 0; i < stories.length/2; i++){
                    card = getCard(stories[i]);
                    firstCol.addView(card);
                }

                for (int i = stories.length/2; i < stories.length; i++){
                    card = getCard(stories[i]);
                    secondCol.addView(card);
                }
            }

            @Override
            public void onFailure(Object response) {
                ((TextView) findViewById(R.id.personal_text_no_data)).setText((String) response);
            }
        });
    }

    private CustomRelativeLayout getCard(Animal.PersonalStories story) {
        CustomRelativeLayout card = new CustomRelativeLayout(getBaseContext(),story.getPictureUrl(), story.getName(), layoutWidth);
        card.init();

        card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GlobalVariables.appCompatActivity, PersonalPopUp.class);
                Bundle clickedAnimal = new Bundle();
                clickedAnimal.putSerializable("animal", story);
                intent.putExtra("url", story.getPictureUrl());
                intent.putExtras(clickedAnimal);
                GlobalVariables.appCompatActivity.startActivity(intent);
            }
        });

        return card;
    }
}
