package zjc.edu.view.fragment;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.io.IOException;

import zjc.edu.R;

public class EPR_Step_1 extends Fragment {
    private View fragment_eprstep1;
    private ImageView epredit1_img1;

    public EPR_Step_1() {
        // Required empty public constructor
    }
    private ImageView imageView1;
    Bitmap bitmap_yl = null;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragment_eprstep1=inflater.inflate(R.layout.fragment_eprstep1, container, false);
        imageView1=fragment_eprstep1.findViewById(R.id.epr_example1);
        epredit1_img1=fragment_eprstep1.findViewById(R.id.epredit_img);
        epredit1_img1.setOnClickListener(v -> {
            openGallery(1);
        });
        imageView1.setOnClickListener(v -> {
            bitmap_yl = ((BitmapDrawable)imageView1.getDrawable()).getBitmap();
            bigImageLoader(bitmap_yl);
        });
        return fragment_eprstep1;
    }
    private void bigImageLoader(Bitmap bitmap){
        final Dialog dialog = new Dialog(getActivity());
        ImageView image = new ImageView(getContext());
        image.setImageBitmap(bitmap);
        dialog.setContentView(image);
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        dialog.show();
        image.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                dialog.cancel();
            }
        });
    }
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
                    Glide.with(this).load(data.getData()).skipMemoryCache(true).diskCacheStrategy(DiskCacheStrategy.NONE).into(epredit1_img1);
                    break;
                default:
                    break;
            }
        }

    }
}