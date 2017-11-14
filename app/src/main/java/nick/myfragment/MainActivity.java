package nick.myfragment;

import android.content.res.Configuration;
import android.net.Uri;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    FragmentManager fm;
    FragmentTransaction ft;
    Fragment1 frag1;
    Fragment2 frag2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fm=getSupportFragmentManager();//選擇Support 可以向下相容
        frag1 = (Fragment1) fm.findFragmentById(R.id.fragment);
        frag2 = (Fragment2) fm.findFragmentById(R.id.fragment2);
        decideDevice();                                           //一開始顯示Fragement1
    }
    public void showFragement1(){
        ft=fm.beginTransaction();       //控制需透過FragmentTransaction
        ft.hide(frag2).show(frag1).commit();        //把frag2隱藏 只顯示frag1
    }
    public void showFragement2(){
        ft=fm.beginTransaction();
        ft.hide(frag1).show(frag2).commit();
    }
    void decideDevice(){
        switch (getResources().getConfiguration().screenLayout& Configuration.SCREENLAYOUT_SIZE_MASK){
            case Configuration.SCREENLAYOUT_SIZE_SMALL:
            case Configuration.SCREENLAYOUT_SIZE_NORMAL:
                showFragement1();
                break;
        }
    }
}
