package zjc.edu.view.fragment;

import android.Manifest;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Objects;

import zjc.edu.R;
import zjc.edu.model.VAT.SharedTaxViewModel;

public class Step3Fragment extends Fragment {

    private SharedTaxViewModel sharedTaxViewModel;
    View fragment_step3;
    private EditText Legal_Name;
    String juridical1 = "";
    String juridical2 = "";
    private ImageView view1;
    private ImageView view2;
    private ImageView view3;
    private ImageView view4;
    private ImageView yl1;
    private ImageView yl2;
    private ImageView yl4;
    byte[] img1 = null;
    byte[] img2 = null;
    byte[] img3 = null;
    byte[] img4 = null;
    Bitmap bitmap_yl = null;
    public Step3Fragment() {
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
        fragment_step3=inflater.inflate(R.layout.fragment_step_3, container, false);
        //共享数据模型
        sharedTaxViewModel=new ViewModelProvider(requireActivity()).get(SharedTaxViewModel.class);
        //控件绑定
        RadioButton radioButton2 = fragment_step3.findViewById(R.id.rb_2);
        RadioButton radioButton1 = fragment_step3.findViewById(R.id.rb_1);
        RadioGroup radioGroup = fragment_step3.findViewById(R.id.rg_juridical);
        LinearLayout linearLayout = fragment_step3.findViewById(R.id.identity_card);
        LinearLayout linearLayout1 = fragment_step3.findViewById(R.id.passport_layout);
        Legal_Name=fragment_step3.findViewById(R.id.Legal_Name);
        view1=fragment_step3.findViewById(R.id.idcard_front);
        view2=fragment_step3.findViewById(R.id.idcard_back);
        view3=fragment_step3.findViewById(R.id.passport);
        view4=fragment_step3.findViewById(R.id.signature);
        yl1=fragment_step3.findViewById(R.id.vat_img1);
        yl2=fragment_step3.findViewById(R.id.vat_img2);
        yl4=fragment_step3.findViewById(R.id.vat_img4);
        //radiobutton控制视图
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId==R.id.rb_1){
                    juridical1=radioButton1.getText().toString();
                    linearLayout.setVisibility(View.VISIBLE);
                    linearLayout1.setVisibility(View.GONE);
                }
                else {
                    juridical2=radioButton2.getText().toString();
                    linearLayout1.setVisibility(View.VISIBLE);
                    linearLayout.setVisibility(View.GONE);
                }

            }
        });
        //共享数据
        sharedTaxViewModel.setLegalrepresentativename(String.valueOf(Legal_Name));
        //上传图片
        requestPermissions(new String[]{Manifest.permission.CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 0);
        view1.setOnClickListener(v -> {
            openGallery(11);
        });
        view2.setOnClickListener(v -> {
            openGallery(12);
        });
        view3.setOnClickListener(v -> {
            openGallery(13);
        });
        view4.setOnClickListener(v -> {
            openGallery(14);
        });
        yl1.setOnClickListener(v -> {
            bitmap_yl = ((BitmapDrawable)yl1.getDrawable()).getBitmap();
            bigImageLoader(bitmap_yl);
        });
        yl2.setOnClickListener(v -> {
            bitmap_yl = ((BitmapDrawable)yl2.getDrawable()).getBitmap();
            bigImageLoader(bitmap_yl);
        });
        yl4.setOnClickListener(v -> {
            bitmap_yl = ((BitmapDrawable)yl4.getDrawable()).getBitmap();
            bigImageLoader(bitmap_yl);
        });
        //返回视图
        return fragment_step3;
    }
    //选择上传类型
    private void choosePictureDialog(int type) {
        View chooseTypeView = LayoutInflater.from(requireActivity()).inflate(R.layout.dialog_choose_pic_type, null);
        AlertDialog selectDialog = new AlertDialog.Builder(requireActivity()).setView(chooseTypeView).setCancelable(false).create();
        selectDialog.show();
        Objects.requireNonNull(selectDialog.getWindow()).setBackgroundDrawableResource(R.color.transparent);
        TextView gallery = chooseTypeView.findViewById(R.id.tv_choose_pic_gallery);
        TextView cancel = chooseTypeView.findViewById(R.id.tv_choose_pic_cancel);
        gallery.setOnClickListener(v -> {
            selectDialog.dismiss();
            openGallery(type);
        });
        cancel.setOnClickListener(v -> selectDialog.dismiss());
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
                case 11:
                    Glide.with(this).load(data.getData()).skipMemoryCache(true).diskCacheStrategy(DiskCacheStrategy.NONE).into(view1);
                    img1=bitmapToByte(bitmap);
                    break;
                case 12:
                    Glide.with(this).load(data.getData()).skipMemoryCache(true).diskCacheStrategy(DiskCacheStrategy.NONE).into(view2);
                    img2=bitmapToByte(bitmap);
                    break;
                case 13:
                    Glide.with(this).load(data.getData()).skipMemoryCache(true).diskCacheStrategy(DiskCacheStrategy.NONE).into(view3);
                    img3=bitmapToByte(bitmap);
                    break;
                case 14:
                    Glide.with(this).load(data.getData()).skipMemoryCache(true).diskCacheStrategy(DiskCacheStrategy.NONE).into(view4);
                    img4=bitmapToByte(bitmap);
                    break;
                default:
                    break;
            }
        }

    }
    public String bitmapToString(Bitmap bitmap){
        //将Bitmap转换成字符串
        String string=null;
        ByteArrayOutputStream bStream=new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG,100,bStream);
        byte[]bytes=bStream.toByteArray();
        string= Base64.encodeToString(bytes, Base64.DEFAULT);
        return string;
    }
    public byte[] bitmapToByte(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] imageData = byteArrayOutputStream.toByteArray();
        return imageData;
    }

    @Override
    public void onPause() {
        super.onPause();
        sharedTaxViewModel.setLegalrepresentativename(String.valueOf(Legal_Name));
        sharedTaxViewModel.setIdcardfront(img1);
        sharedTaxViewModel.setIdcardback(img2);
        sharedTaxViewModel.setSignature(img4);
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
}
