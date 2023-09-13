package kr.foryou.uyong2;

import android.Manifest;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.normal.TedPermission;

import java.util.List;

/*
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.FirebaseMessaging;*/

public class SplashActivity extends AppCompatActivity {
    //private static final int APP_PERMISSION_STORAGE = 9787;
    private final int APPS_PERMISSION_REQUEST=1000;
    final int SEC = 3000;//다음 화면에 넘어가기 전에 머물 수 있는 시간(초)
    String permissions[] = {
            Manifest.permission.WRITE_EXTERNAL_STORAGE, // 기기, 사진, 미디어, 파일 엑세스 권한
            Manifest.permission.READ_EXTERNAL_STORAGE
            //Manifest.permission.ACTIVITY_RECOGNITION
    };
    private static final int MULTIPLE_PERMISSIONS = 101;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        //퍼미션 설정
        TedPermission.create()
                .setPermissions(permissions)
                .setRationaleMessage("이 앱은 권한설정을 하셔야 사용하실 수 있습니다.")
                .setDeniedMessage("권한설정에 거부하시면 앱설정에서 직접하셔야 합니다.")
                .setPermissions(permissions)
                .setPermissionListener(permissionListener)
                .check();
    }
    PermissionListener permissionListener = new PermissionListener() {
        //퍼미션 설정을 하면
        @Override
        public void onPermissionGranted() {
            try{
                goHandler();

                /*LocationPosition.act= mActivity;
                LocationPosition.setPosition(mActivity);
                if(LocationPosition.lng==0.0){
                    LocationPosition.setPosition(mActivity);
                }*/
            }catch(Exception e){

            }

        }
        //퍼미션 설정을 하지 않으면
        @Override
        public void onPermissionDenied(List<String> deniedPermissions) {

        }
    };

    //핸들러로 이용해서 1초간 머물고 이동이 됨
    public void goHandler() {
        Handler mHandler = new Handler();
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                /*Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);*/

                finish();

            }
        }, SEC);
    }

}
