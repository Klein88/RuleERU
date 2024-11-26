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

public class Step2Fragment extends Fragment {
    private SharedTaxViewModel sharedTaxViewModel;
    private View fragment_step2;
    private EditText CompanyName;
    private EditText phone;
    private EditText email_contact;
    private RadioGroup radioGroup;
    private EditText register_id;
    private EditText establish;
    private EditText company_address;
    private EditText post_code;
    private ImageView license_img;
    private ImageView yl1;
    byte[] license =null;
    String selectedOptionText;
    Bitmap bitmap_yl = null;
    public Step2Fragment() {
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
        fragment_step2=inflater.inflate(R.layout.fragment_step_2, container, false);
        //共享数据模型
        sharedTaxViewModel=new ViewModelProvider(requireActivity()).get(SharedTaxViewModel.class);
        //绑定控件
        radioGroup=fragment_step2.findViewById(R.id.rg_company);
        CompanyName=fragment_step2.findViewById(R.id.company_name);
        phone=fragment_step2.findViewById(R.id.phone);
        email_contact=fragment_step2.findViewById(R.id.email_contact);
        register_id=fragment_step2.findViewById(R.id.register_id);
        establish=fragment_step2.findViewById(R.id.establish);
        company_address=fragment_step2.findViewById(R.id.company_address);
        post_code=fragment_step2.findViewById(R.id.post_code);
        license_img=fragment_step2.findViewById(R.id.license_img);
        yl1=fragment_step2.findViewById(R.id.vat_img1);
        //查询RadioButton选中的公司类型
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int selectedRadioButtonId = radioGroup.getCheckedRadioButtonId();
                if (selectedRadioButtonId != -1) {
                    RadioButton selectedRadioButton = fragment_step2.findViewById(selectedRadioButtonId);
                    selectedOptionText = selectedRadioButton.getText().toString();
                    sharedTaxViewModel.setCompanyregistrationlocation(selectedOptionText);
                }
            }
        });


        //共享数据
        sharedTaxViewModel.setCompanyname(String.valueOf(CompanyName.getText()));
        sharedTaxViewModel.setCompanyphonenumber(String.valueOf(phone.getText()));
        sharedTaxViewModel.setCompanycontactemail(String.valueOf(email_contact.getText()));
        sharedTaxViewModel.setBusinesslicensenumber(String.valueOf(register_id.getText()));
        sharedTaxViewModel.setCompanyestablishmentdate(String.valueOf(establish.getText()));
        sharedTaxViewModel.setCompanyoperationaladdress(String.valueOf(company_address));
        sharedTaxViewModel.setPostalcode(String.valueOf(post_code));

        //上传图片
        requestPermissions(new String[]{Manifest.permission.CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 0);
        license_img.setOnClickListener(v -> {
            openGallery();
        });

        yl1.setOnClickListener(v -> {
            bitmap_yl = ((BitmapDrawable)yl1.getDrawable()).getBitmap();
            bigImageLoader(bitmap_yl);
        });
        //返回视图
        return fragment_step2;
    }

    //选择上传类型
    private void choosePictureDialog() {
        View chooseTypeView = LayoutInflater.from(requireActivity()).inflate(R.layout.dialog_choose_pic_type, null);
        AlertDialog selectDialog = new AlertDialog.Builder(requireActivity()).setView(chooseTypeView).setCancelable(false).create();
        selectDialog.show();
        Objects.requireNonNull(selectDialog.getWindow()).setBackgroundDrawableResource(R.color.transparent);
        TextView gallery = chooseTypeView.findViewById(R.id.tv_choose_pic_gallery);
        TextView cancel = chooseTypeView.findViewById(R.id.tv_choose_pic_cancel);
        gallery.setOnClickListener(v -> {
            selectDialog.dismiss();
            openGallery();
        });
        cancel.setOnClickListener(v -> selectDialog.dismiss());
    }
    //打开相册
    private void openGallery() {
        Intent gallery = new Intent(Intent.ACTION_PICK);
        gallery.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
        startActivityForResult(gallery, 10);
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
            Glide.with(this).load(data.getData()).skipMemoryCache(true).diskCacheStrategy(DiskCacheStrategy.NONE).into(license_img);
            license=bitmapToByte(bitmap);
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
        sharedTaxViewModel.setCompanyregistrationlocation(selectedOptionText);
        sharedTaxViewModel.setCompanyregistrationproof(license);
        sharedTaxViewModel.setCompanyname(String.valueOf(CompanyName.getText()));
        sharedTaxViewModel.setCompanyphonenumber(String.valueOf(phone.getText()));
        sharedTaxViewModel.setCompanycontactemail(String.valueOf(email_contact.getText()));
        sharedTaxViewModel.setBusinesslicensenumber(String.valueOf(register_id.getText()));
        sharedTaxViewModel.setCompanyestablishmentdate(String.valueOf(establish.getText()));
        sharedTaxViewModel.setCompanyoperationaladdress(String.valueOf(company_address));
        sharedTaxViewModel.setPostalcode(String.valueOf(post_code));
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
