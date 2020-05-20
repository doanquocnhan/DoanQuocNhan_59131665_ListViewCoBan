package vn.edu.ntu.doanquocnhan_59131665_listviewcoban;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lvMonHoc;
    Button btnthem, btnCapNhat;
    EditText editMonHoc;
    ArrayList<String> arrayCoure;
    int vitri   = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvMonHoc = (ListView) findViewById(R.id.ListViewMonhoc);
        editMonHoc = (EditText) findViewById(R.id.edtMonHoc);
        btnthem = (Button) findViewById(R.id.btnthem);
        btnCapNhat =(Button) findViewById(R.id.btnCapNhat);
        arrayCoure = new ArrayList<>();

        arrayCoure.add("Androi");
        arrayCoure.add("Design Patten");
        arrayCoure.add("MVC");
        arrayCoure.add("CNPM");
        arrayCoure.add("XML");

        final ArrayAdapter adapter = new ArrayAdapter(MainActivity.this,
                android.R.layout.simple_dropdown_item_1line,
                arrayCoure);
        lvMonHoc.setAdapter(adapter);

        lvMonHoc.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //i tra ve vi tri click tren lít view - > 0
                Toast.makeText(MainActivity.this, arrayCoure.get(position), Toast.LENGTH_SHORT).show();
            }
        });
        lvMonHoc.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int i, long id) {
                Toast.makeText(MainActivity.this, "Long list"+i, Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        btnthem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 String monhoc =editMonHoc.getText().toString();
                 arrayCoure.add(monhoc);
                 adapter.notifyDataSetChanged();
            }
        });
        lvMonHoc.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                editMonHoc.setText(arrayCoure.get(position));
                vitri =position;
            }
        });
        btnCapNhat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrayCoure.set(vitri,editMonHoc.getText().toString());
                adapter.notifyDataSetChanged();
            }
        });



    }
}
