package zjc.edu.view.fragment;

import android.Manifest;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Objects;

import zjc.edu.R;
import zjc.edu.databinding.DialogChoosePicTypeBinding;
import zjc.edu.model.DateViewModel;
import zjc.edu.model.VAT.SharedTaxViewModel;
import zjc.edu.util.DateConverter;

public class Step1Fragment extends Fragment {
    private SharedTaxViewModel sharedTaxViewModel;
    private View fragment_step1;
    private EditText tax;
    private TextView effective;
    private Button effective_btn;
    private TextView last;
    private Button last_btn;
    private TextView next;
    private Button next_btn;

    private TextView end;
    private EditText GatewayID;

    private EditText GatewayPassword;
    private Switch kaiguan;
    private LinearLayout linearLayout_MTD;
    private EditText MTD_ID;
    private EditText MTD_password;
    private DateViewModel dateViewModel;
    private ImageView vat_upload;
    private ImageView upload1;
    private ImageView upload2;
    private ImageView upload3;
    private ImageView upload4;
    private ImageView yl1;
    byte[] up=null;
    byte[] up1=null;
    byte[] up2=null;
    byte[] up3=null;
    byte[] up4=null;
    String a=null;
    String b=null;
    String c=null;
    Bitmap bitmap_yl = null;
    String imgPath = "";
    Uri camera_uri = null;
    public Step1Fragment() {
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
        fragment_step1= inflater.inflate(R.layout.fragment_step_1, container, false);
        //共享数据模型
        sharedTaxViewModel=new ViewModelProvider(requireActivity()).get(SharedTaxViewModel.class);
        //绑定控件
        tax=fragment_step1.findViewById(R.id.tax);
        effective=fragment_step1.findViewById(R.id.effective);
        effective_btn=fragment_step1.findViewById(R.id.effective_btn);
        last=fragment_step1.findViewById(R.id.last);
        last_btn=fragment_step1.findViewById(R.id.last_btn);
        next=fragment_step1.findViewById(R.id.next);
        next_btn=fragment_step1.findViewById(R.id.next_btn);
        end=fragment_step1.findViewById(R.id.end);
        GatewayID=fragment_step1.findViewById(R.id.GatewayID);
        GatewayPassword=fragment_step1.findViewById(R.id.GatewayPassword);
        kaiguan=fragment_step1.findViewById(R.id.kaiguan);
        linearLayout_MTD=fragment_step1.findViewById(R.id.MTD);
        MTD_ID=fragment_step1.findViewById(R.id.MTD_ID);
        MTD_password=fragment_step1.findViewById(R.id.MTD_Password);
        vat_upload=fragment_step1.findViewById(R.id.vat_upload);
        upload1=fragment_step1.findViewById(R.id.upload1);
        upload2=fragment_step1.findViewById(R.id.upload2);
        upload3=fragment_step1.findViewById(R.id.upload3);
        upload4=fragment_step1.findViewById(R.id.upload4);
        yl1=fragment_step1.findViewById(R.id.vat_img1);
        //控制switch开关
        kaiguan.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (kaiguan.isChecked()){
                    linearLayout_MTD.setVisibility(linearLayout_MTD.VISIBLE);
                }else {
                    linearLayout_MTD.setVisibility(linearLayout_MTD.GONE);
                }
            }
        });



        //按钮监听日历选择
        dateViewModel = new ViewModelProvider(requireActivity()).get(DateViewModel.class);
        effective_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showEffectiveDatePickerDialog();
            }
        });
        last_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showLastDatePickerDialog();
            }
        });
        next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showNextDatePickerDialog();
            }
        });
        showSelectedDate();
        //共享模型层数据输入
        sharedTaxViewModel.setVatnumber(String.valueOf(tax.getText()));
        sharedTaxViewModel.setGatewayid(String.valueOf(GatewayID.getText()));
        sharedTaxViewModel.setGatewaypassword(String.valueOf(GatewayPassword.getText()));
        sharedTaxViewModel.setMtdusername(String.valueOf(MTD_ID.getText()));
        sharedTaxViewModel.setMtdpassword(String.valueOf(MTD_password.getText()));
        //上传按钮实现
        requestPermissions(new String[]{Manifest.permission.CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 0);
        vat_upload.setOnClickListener(v -> {
//            choosePictureDialog(10);
            openGallery(10);
        });
        upload1.setOnClickListener(v -> {
//            choosePictureDialog(11);
            openGallery(11);
        });
        upload2.setOnClickListener(v -> {
//            choosePictureDialog(12);
            openGallery(12);
        });
        upload3.setOnClickListener(v -> {
//            choosePictureDialog(13);
            openGallery(13);
        });
        upload4.setOnClickListener(v -> {
//            choosePictureDialog(14);
            openGallery(14);
        });
        yl1.setOnClickListener(v -> {
            bitmap_yl = ((BitmapDrawable)yl1.getDrawable()).getBitmap();
            bigImageLoader(bitmap_yl);
        });
        //返回视图
        return fragment_step1;

    }

    //日历对话框
    private void showEffectiveDatePickerDialog() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(
                requireContext(),
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        // 处理用户选择的日期
                        String selectedDate = year + "-" + (month + 1) + "-" + dayOfMonth;
                        try {
                            a=DateConverter.convertStringToFormattedDate(selectedDate);
                        } catch (ParseException e) {
                            throw new RuntimeException(e);
                        }
                        dateViewModel.setEffectiveDate(selectedDate);
                        sharedTaxViewModel.setTaxnumbereffectivedate(selectedDate);
                        effective.setText(selectedDate);
                        Log.i("dateback",effective.getText().toString());
                        // 在此处执行你的操作，如更新UI或保存日期。
                    }
                },
                year, month, day
        );

        datePickerDialog.show();
    }
    private void showLastDatePickerDialog() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(
                requireContext(),
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        // 处理用户选择的日期
                        String selectedDate = year + "-" + (month + 1) + "-" + dayOfMonth;
                        try {
                            b=DateConverter.convertStringToFormattedDate(selectedDate);
                        } catch (ParseException e) {
                            throw new RuntimeException(e);
                        }
                        dateViewModel.setLastDate(selectedDate);
                        sharedTaxViewModel.setLastdeclarationdate(selectedDate);
                        last.setText(selectedDate);
                        Log.i("dateback",last.getText().toString());
                        // 在此处执行你的操作，如更新UI或保存日期。
                    }
                },
                year, month, day
        );
        datePickerDialog.show();
    }
    private void showNextDatePickerDialog() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(
                requireContext(),
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        // 处理用户选择的日期
                        String selectedDate = year + "-" + (month + 1) + "-" + dayOfMonth;
                        dateViewModel.setNextDate(selectedDate);
                        try {
                            c=DateConverter.convertStringToFormattedDate(selectedDate);
                        } catch (ParseException e) {
                            throw new RuntimeException(e);
                        }
                        String endDate;
                        next.setText(selectedDate);
                        if(1<= month+1 && month+1<=3){
                            endDate=year + "-" + "3" + "-" + "31";
                        } else if (month+1<=6) {
                            endDate=year + "-" + "6" + "-" + "30";
                        } else if (month+1<=9) {
                            endDate=year + "-" + "9" + "-" + "30";
                        }else {
                            endDate=year + "-" + "12" + "-" + "31";
                        }
                        dateViewModel.setEndDate(endDate);
                        sharedTaxViewModel.setLastreporteddate(endDate);
                        end.setText(endDate);
                        Log.i("dateback",next.getText().toString());
                        // 在此处执行你的操作，如更新UI或保存日期。
                    }
                },
                year, month, day
        );

        datePickerDialog.show();
    }

    //数据保存
    private void showSelectedDate() {
        String EffectiveDate = dateViewModel.getEffectiveDate();
        if (EffectiveDate != null) {
            effective.setText(EffectiveDate);
        }
        String LastDate = dateViewModel.getLastDate();
        if (LastDate != null) {
            last.setText(LastDate);
        }
        String NextDate = dateViewModel.getNextDate();
        if (NextDate != null) {
            next.setText(NextDate);
        }
        String EndDate = dateViewModel.getEndDate();
        if (EndDate != null) {
           end.setText(EndDate);
        }
    }
    //点击上传按钮，显示对话框选择
    private void choosePictureDialog(int type) {
        View chooseTypeView = LayoutInflater.from(requireActivity()).inflate(R.layout.dialog_choose_pic_type, null);
        AlertDialog selectDialog = new AlertDialog.Builder(requireActivity()).setView(chooseTypeView).setCancelable(false).create();
        selectDialog.show();
        Objects.requireNonNull(selectDialog.getWindow()).setBackgroundDrawableResource(R.color.transparent);
        TextView camera =chooseTypeView.findViewById(R.id.tv_choose_pic_camera);
        TextView gallery = chooseTypeView.findViewById(R.id.tv_choose_pic_gallery);
        TextView cancel = chooseTypeView.findViewById(R.id.tv_choose_pic_cancel);
        gallery.setOnClickListener(v -> {
            selectDialog.dismiss();
            openGallery(type);
        });
        camera.setOnClickListener(v -> {
            selectDialog.dismiss();
            openCamera(type);
        });
        cancel.setOnClickListener(v -> selectDialog.dismiss());
    }
    //打开相册
    private void openGallery(int type) {
        Intent gallery = new Intent(Intent.ACTION_PICK);
        gallery.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
        startActivityForResult(gallery, type);
    }
    private void openCamera(int type) {
        // 创建照片存储目录
        File imgDir = new File(getFilePath(null));
        // 创建照片
        String photoName = System.currentTimeMillis() + ".png";
        File picture = new File(imgDir, photoName);
        if (!picture.exists()) {
            try {
                picture.createNewFile();
            } catch (IOException e) {
                Log.i("创建图片失败", String.valueOf(e));
            }
        }
//        if (Build.VERSION.SDK_INT < 24) {
//            camera_uri = Uri.fromFile(picture);
//        } else {
//            camera_uri = FileProvider.getUriForFile(this, AUTHORITY, picture);
//
//        }
        imgPath = picture.getAbsolutePath();
        // 调用相机拍照
        Intent camera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        camera.putExtra(MediaStore.EXTRA_OUTPUT, FileProvider.getUriForFile(requireActivity(), "zjc.edu.fileprovider", picture));
        startActivityForResult(camera, type);
    }
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        Bitmap bitmap = null;
        super.onActivityResult(requestCode, resultCode, data);
        if (data != null){
            try {
                bitmap = MediaStore.Images.Media.getBitmap(this.requireActivity().getContentResolver(), data.getData());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            switch (requestCode){
                case 10:
                    Glide.with(this).load(data.getData()).skipMemoryCache(true).diskCacheStrategy(DiskCacheStrategy.NONE).into(vat_upload);
                    up=bitmapToByte(bitmap);
                    break;
                case 11:
                    Glide.with(this).load(data.getData()).skipMemoryCache(true).diskCacheStrategy(DiskCacheStrategy.NONE).into(upload1);
                    up1=bitmapToByte(bitmap);
                    break;
                case 12:
                    Glide.with(this).load(data.getData()).skipMemoryCache(true).diskCacheStrategy(DiskCacheStrategy.NONE).into(upload2);
                    up2=bitmapToByte(bitmap);
                    break;
                case 13:
                    Glide.with(this).load(data.getData()).skipMemoryCache(true).diskCacheStrategy(DiskCacheStrategy.NONE).into(upload3);
                    up3=bitmapToByte(bitmap);
                    break;
                case 14:
                    Glide.with(this).load(data.getData()).skipMemoryCache(true).diskCacheStrategy(DiskCacheStrategy.NONE).into(upload4);
                    up4=bitmapToByte(bitmap);
                    break;
                default:
                    break;
            }
        }
//        else if (data == null && !imgPath.isEmpty()){
//            try {
//                bitmap = MediaStore.Images.Media.getBitmap(this.requireActivity().getContentResolver(), Uri.parse(imgPath));
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//            switch (requestCode){
//                case 10:
//                    Glide.with(this).load(imgPath).skipMemoryCache(true).diskCacheStrategy(DiskCacheStrategy.NONE).into(vat_upload);
//                    up=bitmapToByte(bitmap);
//                    break;
//                case 11:
//                    Glide.with(this).load(imgPath).skipMemoryCache(true).diskCacheStrategy(DiskCacheStrategy.NONE).into(upload1);
//                    up1=bitmapToByte(bitmap);
//                    break;
//                case 12:
//                    Glide.with(this).load(imgPath).skipMemoryCache(true).diskCacheStrategy(DiskCacheStrategy.NONE).into(upload2);
//                    up2=bitmapToByte(bitmap);
//                    break;
//                case 13:
//                    Glide.with(this).load(imgPath).skipMemoryCache(true).diskCacheStrategy(DiskCacheStrategy.NONE).into(upload3);
//                    up3=bitmapToByte(bitmap);
//                    break;
//                case 14:
//                    Glide.with(this).load(imgPath).skipMemoryCache(true).diskCacheStrategy(DiskCacheStrategy.NONE).into(upload4);
//                    up4=bitmapToByte(bitmap);
//                    break;
//                default:
//                    break;
//            }
//        }
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
        sharedTaxViewModel.setVatcertificate(up);
        sharedTaxViewModel.setVatdeclarationdocument(up1);
        sharedTaxViewModel.setProxycommitmentdocument(up4);
        sharedTaxViewModel.setVatnumber(String.valueOf(tax.getText()));
        sharedTaxViewModel.setGatewayid(String.valueOf(GatewayID.getText()));
        sharedTaxViewModel.setGatewaypassword(String.valueOf(GatewayPassword.getText()));
        sharedTaxViewModel.setMtdusername(String.valueOf(MTD_ID.getText()));
        sharedTaxViewModel.setMtdpassword(String.valueOf(MTD_password.getText()));
        sharedTaxViewModel.setTaxnumbereffectivedate(a);
        sharedTaxViewModel.setLastdeclarationdate(b);
        sharedTaxViewModel.setLastreporteddate(c);
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
    public String getFilePath(String dir) {
        String path;
        // 判断是否有外部存储，是否可用
        if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) {
            path = requireContext().getExternalFilesDir(dir).getAbsolutePath();
        } else {
            // 使用内部储存
            path = requireContext().getFilesDir() + File.separator + dir;
        }
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
        return path;
    }
}
