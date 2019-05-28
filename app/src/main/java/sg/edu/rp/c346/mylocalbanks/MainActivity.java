package sg.edu.rp.c346.mylocalbanks;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnDBS, btnOCBC, btnUOB;
    int id = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDBS = findViewById(R.id.btnDBS);

        btnOCBC = findViewById(R.id.btnOCBC);

        btnUOB = findViewById(R.id.btnUOB);

        registerForContextMenu(btnDBS);
        registerForContextMenu(btnOCBC);
        registerForContextMenu(btnUOB);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.add(0, 0, 0, "Website");
        menu.add(0, 1, 1, "Contact the bank");
        Toast.makeText(this, "" + v.getId(), Toast.LENGTH_SHORT).show();


    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (item.getItemId() == 0) { //check whether the selected menu item ID is 0
            //code for action
            if (id == R.id.btnDBS) {
                Intent intentCall = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.dbs.com.sg"));
                startActivity(intentCall);

                return true; //menu item successfully handled

            } else if (id == R.id.btnOCBC) {
                Intent intentCall = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ocbc.com"));
                startActivity(intentCall);

                return true; //menu item successfully handled

            } else if (id == R.id.btnUOB) {
                Intent intentCall = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.uob.com.sg"));
                startActivity(intentCall);

                return true; //menu item successfully handled
            }

        } else if (item.getItemId() == 1) { //check if the selected menu item ID is 1
            if (id == R.id.btnDBS) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: 18001111111"));
                startActivity(intentCall);

                return true; //menu item successfully handled

            } else if (id == R.id.btnOCBC) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: 18003633333"));
                startActivity(intentCall);

                return true; //menu item successfully handled

            } else if (id == R.id.btnUOB) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: 18002222121"));
                startActivity(intentCall);

                return true; //menu item successfully handled
            }
        }
        return super.onContextItemSelected(item); //pass menu item to the superclass implementation
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {
                btnDBS.setText("DBS");
                btnOCBC.setText("OCBC");
                btnUOB.setText("UOB");

        }else if (id == R.id.ChineseSelection) {
                btnDBS.setText("星展银行");
                btnOCBC.setText("华侨银行");
                btnUOB.setText("大华银行");

            }
        return super.onOptionsItemSelected(item);
        }

    }







