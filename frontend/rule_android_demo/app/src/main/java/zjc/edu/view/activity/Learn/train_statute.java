package zjc.edu.view.activity.Learn;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.widget.Toolbar;

import zjc.edu.R;
import zjc.edu.databinding.ActivityTrainStatuteBinding;
import zjc.edu.view.activity.MainActivity;


public class train_statute extends AppCompatActivity {
    private ActivityTrainStatuteBinding binding;
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_train_statute);
        binding=ActivityTrainStatuteBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        toolbar=findViewById(R.id.search_titlebar);
        //toolbar
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        binding.linear1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.content1.getVisibility() == View.GONE) {
                    binding.content1.setVisibility(View.VISIBLE);
                    binding.title1.setVisibility(View.GONE);
                    binding.linear1.setBackground(getDrawable(R.drawable.frame_statute2));
                }else {
                    binding.title1.setVisibility(View.VISIBLE);
                    binding.content1.setVisibility(View.GONE);
                    binding.linear1.setBackground(getDrawable(R.drawable.frame_statute1));
                }
            }
        });

        binding.linear2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.content2.getVisibility() == View.GONE) {
                    binding.content2.setVisibility(View.VISIBLE);
                    binding.title2.setVisibility(View.GONE);
                    binding.linear2.setBackground(getDrawable(R.drawable.frame_statute2));
                }else {
                    binding.title2.setVisibility(View.VISIBLE);
                    binding.content2.setVisibility(View.GONE);
                    binding.linear2.setBackground(getDrawable(R.drawable.frame_statute1));
                }
            }
        });

        binding.linear3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.content3.getVisibility() == View.GONE) {
                    binding.content3.setVisibility(View.VISIBLE);
                    binding.title3.setVisibility(View.GONE);
                    binding.linear3.setBackground(getDrawable(R.drawable.frame_statute2));
                }else {
                    binding.title3.setVisibility(View.VISIBLE);
                    binding.content3.setVisibility(View.GONE);
                    binding.linear3.setBackground(getDrawable(R.drawable.frame_statute1));
                }
            }
        });

        binding.linear4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.content4.getVisibility() == View.GONE) {
                    binding.content4.setVisibility(View.VISIBLE);
                    binding.title4.setVisibility(View.GONE);
                    binding.linear4.setBackground(getDrawable(R.drawable.frame_statute2));
                }else {
                    binding.title4.setVisibility(View.VISIBLE);
                    binding.content4.setVisibility(View.GONE);
                    binding.linear4.setBackground(getDrawable(R.drawable.frame_statute1));
                }
            }
        });

        binding.linear5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.content5.getVisibility() == View.GONE) {
                    binding.content5.setVisibility(View.VISIBLE);
                    binding.title5.setVisibility(View.GONE);
                    binding.linear5.setBackground(getDrawable(R.drawable.frame_statute2));
                }else {
                    binding.title5.setVisibility(View.VISIBLE);
                    binding.content5.setVisibility(View.GONE);
                    binding.linear5.setBackground(getDrawable(R.drawable.frame_statute1));
                }
            }
        });

        binding.linear6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.content6.getVisibility() == View.GONE) {
                    binding.content6.setVisibility(View.VISIBLE);
                    binding.title6.setVisibility(View.GONE);
                    binding.linear6.setBackground(getDrawable(R.drawable.frame_statute2));
                }else {
                    binding.title6.setVisibility(View.VISIBLE);
                    binding.content6.setVisibility(View.GONE);
                    binding.linear6.setBackground(getDrawable(R.drawable.frame_statute1));
                }
            }
        });

        binding.linear7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.content7.getVisibility() == View.GONE) {
                    binding.content7.setVisibility(View.VISIBLE);
                    binding.title7.setVisibility(View.GONE);
                    binding.linear7.setBackground(getDrawable(R.drawable.frame_statute2));
                }else {
                    binding.title7.setVisibility(View.VISIBLE);
                    binding.content7.setVisibility(View.GONE);
                    binding.linear7.setBackground(getDrawable(R.drawable.frame_statute1));
                }
            }
        });

        binding.linear8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.content8.getVisibility() == View.GONE) {
                    binding.content8.setVisibility(View.VISIBLE);
                    binding.title8.setVisibility(View.GONE);
                    binding.linear8.setBackground(getDrawable(R.drawable.frame_statute2));
                }else {
                    binding.title8.setVisibility(View.VISIBLE);
                    binding.content8.setVisibility(View.GONE);
                    binding.linear8.setBackground(getDrawable(R.drawable.frame_statute1));
                }
            }
        });

        binding.linear9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.content9.getVisibility() == View.GONE) {
                    binding.content9.setVisibility(View.VISIBLE);
                    binding.title9.setVisibility(View.GONE);
                    binding.linear9.setBackground(getDrawable(R.drawable.frame_statute2));
                }else {
                    binding.title9.setVisibility(View.VISIBLE);
                    binding.content9.setVisibility(View.GONE);
                    binding.linear9.setBackground(getDrawable(R.drawable.frame_statute1));
                }
            }
        });

        binding.linear10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.content10.getVisibility() == View.GONE) {
                    binding.content10.setVisibility(View.VISIBLE);
                    binding.title10.setVisibility(View.GONE);
                    binding.linear10.setBackground(getDrawable(R.drawable.frame_statute2));
                }else {
                    binding.title10.setVisibility(View.VISIBLE);
                    binding.content10.setVisibility(View.GONE);
                    binding.linear10.setBackground(getDrawable(R.drawable.frame_statute1));
                }
            }
        });

        binding.linear11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.content11.getVisibility() == View.GONE) {
                    binding.content11.setVisibility(View.VISIBLE);
                    binding.title11.setVisibility(View.GONE);
                    binding.linear11.setBackground(getDrawable(R.drawable.frame_statute2));
                }else {
                    binding.title11.setVisibility(View.VISIBLE);
                    binding.content11.setVisibility(View.GONE);
                    binding.linear11.setBackground(getDrawable(R.drawable.frame_statute1));
                }
            }
        });

        binding.linear12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.content12.getVisibility() == View.GONE) {
                    binding.content12.setVisibility(View.VISIBLE);
                    binding.title12.setVisibility(View.GONE);
                    binding.linear12.setBackground(getDrawable(R.drawable.frame_statute2));
                }else {
                    binding.title12.setVisibility(View.VISIBLE);
                    binding.content12.setVisibility(View.GONE);
                    binding.linear12.setBackground(getDrawable(R.drawable.frame_statute1));
                }
            }
        });

        binding.linear13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.content13.getVisibility() == View.GONE) {
                    binding.content13.setVisibility(View.VISIBLE);
                    binding.title13.setVisibility(View.GONE);
                    binding.linear13.setBackground(getDrawable(R.drawable.frame_statute2));
                }else {
                    binding.title13.setVisibility(View.VISIBLE);
                    binding.content13.setVisibility(View.GONE);
                    binding.linear13.setBackground(getDrawable(R.drawable.frame_statute1));
                }
            }
        });
    }
    //toolbar
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            Intent intent = new Intent(this, train_laws.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}