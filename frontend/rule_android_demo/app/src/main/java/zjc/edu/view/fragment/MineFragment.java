package zjc.edu.view.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import zjc.edu.R;
import zjc.edu.view.activity.LoginActivity;
import zjc.edu.view.activity.WordOrderActivity;


public class MineFragment extends Fragment {
    private View mineFragment;

    private Button exit;
    private Button workorder;
    public MineFragment() {

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mineFragment= inflater.inflate(R.layout.fragment_mine, container, false);
        exit=mineFragment.findViewById(R.id.button_exit);
        workorder=mineFragment.findViewById(R.id.workorder);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(requireActivity(), LoginActivity.class);
                startActivity(intent);
            }
        });
        workorder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(requireActivity(), WordOrderActivity.class);
                startActivity(intent);
            }
        });
        return mineFragment;
    }
}