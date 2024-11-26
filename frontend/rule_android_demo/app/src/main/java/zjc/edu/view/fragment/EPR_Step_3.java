package zjc.edu.view.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import zjc.edu.R;
import zjc.edu.view.activity.EPR.EnvironmentActivity;


public class EPR_Step_3 extends Fragment {
    private View fragment_eprstep3;
    private Button tijiao;


    public EPR_Step_3() {

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragment_eprstep3= inflater.inflate(R.layout.fragment_eprstep3, container, false);
        tijiao=fragment_eprstep3.findViewById(R.id.tijiao);
        tijiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), EnvironmentActivity.class);
                startActivity(intent);
            }
        });
        return fragment_eprstep3;
    }
}