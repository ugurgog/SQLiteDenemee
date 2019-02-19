package uren.com.sqlitedeneme;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText edtId, edtName, edtEmail;
    Button btnAdd, btnUpdate, btnDelete;
    ListView listView;

    List<Person> data = new ArrayList<>();
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new DatabaseHelper(this);
        btnAdd = findViewById(R.id.btnAdd);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnDelete = findViewById(R.id.btnDelete);

        listView = findViewById(R.id.list);

        edtId = findViewById(R.id.edtId);
        edtName = findViewById(R.id.edtName);
        edtEmail = findViewById(R.id.edtEmail);

        refreshData();

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Person person = new Person(Integer.parseInt(edtId.getText().toString()),
                        edtName.getText().toString(),
                        edtEmail.getText().toString());
                db.addPerson(person);
                refreshData();
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Person person = new Person(Integer.parseInt(edtId.getText().toString()),
                        edtName.getText().toString(),
                        edtEmail.getText().toString());
                db.updatePerson(person);
                refreshData();
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Person person = new Person(Integer.parseInt(edtId.getText().toString()),
                        edtName.getText().toString(),
                        edtEmail.getText().toString());
                db.deletePerson(person);
                refreshData();
            }
        });
    }

    private void refreshData(){
        data = db.getAllPerson();
        PersonAdapter personAdapter = new PersonAdapter(MainActivity.this, data, edtId, edtName, edtEmail);
        listView.setAdapter(personAdapter);
    }
}
