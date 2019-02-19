package uren.com.sqlitedeneme;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class PersonAdapter extends BaseAdapter {

    Activity activity;
    List<Person> personList;
    LayoutInflater layoutInflater;
    EditText edtId, edtName, edtEmail;

    public PersonAdapter(Activity activity, List<Person> personList, EditText edtId, EditText edtName, EditText edtEmail) {
        this.activity = activity;
        this.personList = personList;
        this.layoutInflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.edtId = edtId;
        this.edtName = edtName;
        this.edtEmail = edtEmail;
    }

    @Override
    public int getCount() {
        return personList.size();
    }

    @Override
    public Object getItem(int i) {
        return personList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return personList.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View rowView;
        rowView = layoutInflater.inflate(R.layout.raw, null);
        final TextView txtRowId, txtRowName, txtRowEmail;
        txtRowId = rowView.findViewById(R.id.txtRowId);
        txtRowName = rowView.findViewById(R.id.txtRowName);
        txtRowEmail = rowView.findViewById(R.id.txtRowEmail);

        txtRowId.setText(""+personList.get(i).getId());
        txtRowName.setText(""+personList.get(i).getName());
        txtRowEmail.setText(""+personList.get(i).getEmail());

        rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtId.setText(""+txtRowId.getText());
                edtName.setText(""+txtRowName.getText());
                edtEmail.setText(""+txtRowEmail.getText());
            }
        });

        return rowView;
    }
}
