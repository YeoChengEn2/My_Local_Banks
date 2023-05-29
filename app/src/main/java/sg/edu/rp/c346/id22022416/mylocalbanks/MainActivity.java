package sg.edu.rp.c346.id22022416.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btnDBS;
    Button btnOCBC;
    Button btnUOB;
    TextView tvIns;

    String btnClicked = "";
    String dbsColor = "black";
    String ocbcColor = "black";
    String uobColor = "black";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDBS = findViewById(R.id.buttonDBS);
        btnOCBC = findViewById(R.id.buttonOCBC);
        btnUOB = findViewById(R.id.buttonUOB);
        tvIns = findViewById(R.id.textViewInstructions);
        registerForContextMenu(btnDBS);
        registerForContextMenu(btnOCBC);
        registerForContextMenu(btnUOB);
        registerForContextMenu(tvIns);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        getMenuInflater().inflate(R.menu.menu_main, menu);

        if(v == btnDBS){
            btnClicked = "DBS";
        }
        else if (v == btnOCBC){
            btnClicked = "OCBC";
        }
        else if (v == btnUOB){
            btnClicked = "UOB";
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main2, menu);
        return true;
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        String dbs_url = getString(R.string.dbs_url);
        String dbs_no = getString(R.string.dbs_no);
        String ocbc_url = getString(R.string.ocbc_url);
        String ocbc_no = getString(R.string.ocbc_no);
        String uob_url = getString(R.string.uob_url);
        String uob_no = getString(R.string.uob_no);

        if(btnClicked.equalsIgnoreCase("DBS")){
            if(item.getItemId()==R.id.WebsiteSelection) {
                Intent intent = new Intent(Intent. ACTION_VIEW, Uri.parse(dbs_url));
                startActivity(intent);
                return true;
            }
            else if(item.getItemId()==R.id.ContactSelection) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+dbs_no));
                startActivity(intentCall);
                return true;
            }
            else if(item.getItemId()==R.id.FavouriteSelection) {
                if(dbsColor == "black") {
                    btnDBS.setTextColor(Color.RED);
                    dbsColor = "red";
                }
                else if(dbsColor == "red") {
                    btnDBS.setTextColor(Color.BLACK);
                    dbsColor = "black";
                }
            }
        }
        else if (btnClicked.equalsIgnoreCase("OCBC")){
            if(item.getItemId()==R.id.WebsiteSelection) {
                Intent intent = new Intent(Intent. ACTION_VIEW, Uri.parse(ocbc_url));
                startActivity(intent);
                return true;
            }
            else if(item.getItemId()==R.id.ContactSelection) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+ocbc_no));
                startActivity(intentCall);
                return true;
            }
            else if(item.getItemId()==R.id.FavouriteSelection) {
                if(ocbcColor == "black") {
                    btnOCBC.setTextColor(Color.RED);
                    ocbcColor = "red";
                }
                else if(ocbcColor == "red") {
                    btnOCBC.setTextColor(Color.BLACK);
                    ocbcColor = "black";
                }
            }
        }
        else if (btnClicked.equalsIgnoreCase("UOB")){
            if(item.getItemId()==R.id.WebsiteSelection) {
                Intent intent = new Intent(Intent. ACTION_VIEW, Uri.parse(uob_url));
                startActivity(intent);
                return true;
            }
            else if(item.getItemId()==R.id.ContactSelection) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+uob_no));
                startActivity(intentCall);
                return true;
            }
            else if(item.getItemId()==R.id.FavouriteSelection) {
                if(uobColor == "black") {
                    btnUOB.setTextColor(Color.RED);
                    uobColor = "red";
                }
                else if(uobColor == "red") {
                    btnUOB.setTextColor(Color.BLACK);
                    uobColor = "black";
                }
            }
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        String dbs_english = getString(R.string.dbs_english);
        String dbs_chinese = getString(R.string.dbs_chinese);
        String ocbc_english = getString(R.string.ocbc_english);
        String ocbc_chinese = getString(R.string.ocbc_chinese);
        String uob_english = getString(R.string.uob_english);
        String uob_chinese = getString(R.string.uob_chinese);
        String error = getString(R.string.error);

        if (id == R.id.EnglishSelection) {
            btnDBS.setText(dbs_english);
            btnOCBC.setText(ocbc_english);
            btnUOB.setText(uob_english);
            return true;
        }
        else if (id == R.id.ChineseSelection) {
            btnDBS.setText(dbs_chinese);
            btnOCBC.setText(ocbc_chinese);
            btnUOB.setText(uob_chinese);
            return true;
        }
        else {
            btnDBS.setText(error);
            btnOCBC.setText(error);
            btnUOB.setText(error);
        }

        return super.onOptionsItemSelected(item);
    }
}