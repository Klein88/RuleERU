package zjc.edu.view.fragment;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.io.IOException;

import zjc.edu.R;


public class EPR_Step_2 extends Fragment {
    private View fragment_eprstep2;
    private ImageView epredit2_img1;
    private ImageView epredit2_img2;
    private ImageView epredit2_img3;


    public EPR_Step_2() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragment_eprstep2=inflater.inflate(R.layout.fragment_eprstep2, container, false);
        epredit2_img1=fragment_eprstep2.findViewById(R.id.epredit2_img1);
        epredit2_img2=fragment_eprstep2.findViewById(R.id.epredit2_img2);
        epredit2_img3=fragment_eprstep2.findViewById(R.id.epredit2_img3);
        epredit2_img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGallery(1);
            }
        });
        epredit2_img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGallery(2);
            }
        });
        epredit2_img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGallery(3);
            }
        });
        return fragment_eprstep2;
    }
    //打开相册
    private void openGallery(int type) {
        Intent gallery = new Intent(Intent.ACTION_PICK);
        gallery.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
        startActivityForResult(gallery, type);
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        Bitmap bitmap;
        super.onActivityResult(requestCode, resultCode, data);
        if (data != null){
            try {
                bitmap = MediaStore.Images.Media.getBitmap(this.getActivity().getContentResolver(), data.getData());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            //上传图片到对应组件
            switch (requestCode){
                case 1:
                    Glide.with(this).load(data.getData()).skipMemoryCache(true).diskCacheStrategy(DiskCacheStrategy.NONE).into(epredit2_img1);
                    break;
                case 2:
                    Glide.with(this).load(data.getData()).skipMemoryCache(true).diskCacheStrategy(DiskCacheStrategy.NONE).into(epredit2_img2);
                    break;
                case 3:
                    Glide.with(this).load(data.getData()).skipMemoryCache(true).diskCacheStrategy(DiskCacheStrategy.NONE).into(epredit2_img3);
                    break;
                default:
                    break;
            }
        }

    }
}