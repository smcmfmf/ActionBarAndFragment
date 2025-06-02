package kr.ac.kopo.actionbarandfragment;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity implements ActionBar.TabListener {
    ActionBar.Tab tab1, tab2, tab3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar bar = getSupportActionBar();
        bar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        tab1 = bar.newTab();
        tab1.setText("Spring");
        tab1.setTabListener(this); // 자신의 리스너를 참조값으로 리턴함
        bar.addTab(tab1); // 탭을 추가함

        tab2 = bar.newTab();
        tab2.setText("Summer");
        tab2.setTabListener(this); // 자신의 리스너를 참조값으로 리턴함
        bar.addTab(tab2); // 탭을 추가함

        tab3 = bar.newTab();
        tab3.setText("Fall");
        tab3.setTabListener(this); // 자신의 리스너를 참조값으로 리턴함
        bar.addTab(tab3); // 탭을 추가함

        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    MyTabFragment[] myTabFragments = new MyTabFragment[3]; // 배열 생성
    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
        MyTabFragment myTabFragment = null;

        if(myTabFragments[tab.getPosition()] == null) // myTabFragments의 내용이 없다면 (myTabFragment 객체가 생성되지 않은 상태)
        {
            myTabFragment = new MyTabFragment(); // 객체 생성!
            Bundle data = new Bundle();
            data.putString("tabName", tab.getText().toString());
            myTabFragment.setArguments(data);
            myTabFragments[tab.getPosition()] = myTabFragment;
        }
        else
        {
            myTabFragment = myTabFragments[tab.getPosition()];
        }

        ft.replace(android.R.id.content, myTabFragment); // 터치한 해당 탭의 내용으로 변경됨
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }
}