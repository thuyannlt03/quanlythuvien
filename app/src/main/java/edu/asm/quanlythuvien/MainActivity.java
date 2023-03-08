package edu.asm.quanlythuvien;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

import edu.asm.quanlythuvien.Fragment.Fragment_DoanhThu;
import edu.asm.quanlythuvien.Fragment.Fragment_DoiMatKhau;
import edu.asm.quanlythuvien.Fragment.Fragment_LoaiSach;
import edu.asm.quanlythuvien.Fragment.Fragment_PhieuMuon;
import edu.asm.quanlythuvien.Fragment.Fragment_Sach;
import edu.asm.quanlythuvien.Fragment.Fragment_ThanhVien;
import edu.asm.quanlythuvien.Fragment.Fragment_ThemTaiKhoan;
import edu.asm.quanlythuvien.Fragment.Fragment_Thoat;
import edu.asm.quanlythuvien.Fragment.Fragment_ThongKe;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        drawerLayout = findViewById(R.id.DrawableLayout);
        navigationView = findViewById(R.id.nav_view);



        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeAsUpIndicator(R.drawable.ic_baseline_menu_24);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("Thu Vien Phuong Nam");

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                FragmentManager manager = getSupportFragmentManager();
                Fragment fragment;
                switch (item.getItemId()){
                    case  R.id.icPM:
                        fragment = new Fragment_PhieuMuon();
                        break;
                    case  R.id.icLS:
                        fragment = new Fragment_LoaiSach();
                        break;
                    case  R.id.icSach:
                        fragment = new Fragment_Sach();
                        break;
                    case  R.id.icTV:
                        fragment = new Fragment_ThanhVien();
                        break;
                    case  R.id.ictop:
                        fragment = new Fragment_ThongKe();
                        break;
                    case  R.id.icDT:
                        fragment = new Fragment_DoanhThu();
                        break;
                    case  R.id.icMK:
                        fragment = new Fragment_DoiMatKhau();
                        break;
                    case  R.id.icTTK:
                        fragment = new Fragment_ThemTaiKhoan();
                        break;
                    case  R.id.icDX:
                        fragment = new Fragment_Thoat();
                        break;
                    default:
                        fragment = new Fragment_PhieuMuon();
                }
                manager.beginTransaction()
                        .replace(R.id.Line,fragment)
                        .commit();
                drawerLayout.closeDrawer(GravityCompat.START);
                setTitle(item.getTitle());
                return false;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==android.R.id.home){
            drawerLayout.openDrawer(GravityCompat.START);
        }
        return super.onOptionsItemSelected(item);
    }
}