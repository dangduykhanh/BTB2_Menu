package khanhdang.ueh.edu.vn.btbuoi2_menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ImageButton buttonpopup;
    private int [] arraytv = new int[]{R.id.tVDanhSachSP,R.id.tVMayTinh,R.id.tVDienThoai,R.id.tVTiVi,
                                        R.id.tVTuLanh,R.id.tVMayGiat,R.id.tVMayLanh};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ConnectView();
        buttonpopup.setOnClickListener(this::onClick);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_search:
            case R.id.action_favorite:
            case R.id.action_setting:
            case R.id.action_order:
                PerformAction(item.getTitle().toString());
                return true;
            default:
                return super.onOptionsItemSelected(item);
                // Do nothing
        }
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.context_menu,menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.context_edit:
            case R.id.context_delete:
            case R.id.context_share:
                PerformAction(item.getTitle().toString());
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }

    private void PerformAction(String Title)
    {
        Intent intent = new Intent(this,TargetActivity.class);
       intent.putExtra("value",Title);
        startActivity(intent);

    }
    private void ConnectView()
    {
        buttonpopup=findViewById(R.id.iBPopup);
        for (int i=0; i<arraytv.length;i++)
        {
            TextView textView=findViewById(arraytv[i]);
            registerForContextMenu(textView);

        }

    }

    @Override
    public void onClick(View v) {
        PopupMenu popupMenu = new PopupMenu(MainActivity.this,buttonpopup);
        popupMenu.getMenuInflater().inflate(R.menu.popup_menu,popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.popup_setting:
                    case R.id.popup_favorite:
                    case R.id.popup_share:
                        PerformAction(item.getTitle().toString());
                        return true;
                    default:
                        return false;
                }
            }
        });
        popupMenu.show();
    }
}