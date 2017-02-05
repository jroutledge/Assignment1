package routledge.jeffrey.assignment1;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AddNewRecordActivity extends AppCompatActivity {

    PersonList personList = new PersonList();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_new_record);

        Button addButton = (Button) findViewById(R.id.record_button);

        addButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                setResult(RESULT_OK);

                EditText edit = (EditText) findViewById(R.id.name);

                if (!edit.getText().toString().equals("")) {
                    Person p = new Person(edit.getText().toString());
                    //Toast toast = Toast.makeText(getApplicationContext(), edit.getText().toString(), Toast.LENGTH_SHORT);
                    // toast.show();

                    // accessed on feb 4, 2017
                    //code from:
                    //http://stackoverflow.com/questions/4229710/string-from-edittext-to-float
                    EditText edt = (EditText) findViewById(R.id.neck);
                    float neck = Float.valueOf(edt.getText().toString());
                    p.setNeck(neck);

                    edt = (EditText) findViewById(R.id.bust);
                    float bust = Float.valueOf(edt.getText().toString());
                    p.setBust(bust);

                    edt = (EditText) findViewById(R.id.waist);
                    float waist = Float.valueOf(edt.getText().toString());
                    p.setWaist(waist);

                    edt = (EditText) findViewById(R.id.hip);
                    float hip = Float.valueOf(edt.getText().toString());
                    p.setHip(hip);

                    edt = (EditText) findViewById(R.id.inseam);
                    float inseam = Float.valueOf(edt.getText().toString());
                    p.setInseam(inseam);

                    edt = (EditText) findViewById(R.id.record_comment);
                    String comment = edt.getText().toString();
                    p.setComment(comment);

                    personList.add_person(p);

                    Intent intent = new Intent(AddNewRecordActivity.this, MainActivity.class);
                    startActivity(intent);

                } else {
                    Toast.makeText(getApplicationContext(), "Please enter a name", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    @Override
    public void onStart() {
        super.onStart();

        int s = getIntent().getExtras().getInt("key");
        if (s != -1) {
            EditText edit = (EditText) findViewById(R.id.name);
            edit.setText(personList.getList().get(s).getName(), TextView.BufferType.EDITABLE);

            edit = (EditText) findViewById(R.id.neck);
            edit.setText(Float.toString(personList.getList().get(s).getNeck()), TextView.BufferType.EDITABLE);

            edit = (EditText) findViewById(R.id.bust);
            edit.setText(Float.toString(personList.getList().get(s).getBust()), TextView.BufferType.EDITABLE);

            edit = (EditText) findViewById(R.id.waist);
            edit.setText(Float.toString(personList.getList().get(s).getWaist()), TextView.BufferType.EDITABLE);

            edit = (EditText) findViewById(R.id.hip);
            edit.setText(Float.toString(personList.getList().get(s).getHip()), TextView.BufferType.EDITABLE);

            edit = (EditText) findViewById(R.id.inseam);
            edit.setText(Float.toString(personList.getList().get(s).getInseam()), TextView.BufferType.EDITABLE);

            edit = (EditText) findViewById(R.id.record_comment);
            edit.setText(personList.getList().get(s).getComment(), TextView.BufferType.EDITABLE);

            personList.delete_list(personList.getPerson(s));
        }

    }

    @Override
    public void onStop() {
        super.onStop();
    }
}
