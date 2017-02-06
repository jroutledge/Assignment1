package routledge.jeffrey.assignment1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * This class handles creating new records for people.
 */
public class AddNewRecordActivity extends AppCompatActivity {

    private PersonList personList = new PersonList();
    @Override
    /** Called when the activity is first created. */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_new_record);

        Button addButton = (Button) findViewById(R.id.record_add_button);

        addButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                setResult(RESULT_OK);

                EditText edit = (EditText) findViewById(R.id.name);

                if (!edit.getText().toString().equals("")) {
                    Person p = new Person(edit.getText().toString());

                    // accessed on feb 4, 2017
                    // code from:
                    // http://stackoverflow.com/questions/4229710/string-from-edittext-to-float
                    EditText edt = (EditText) findViewById(R.id.neck);
                    if ( !edt.getText().toString().equals("") ) {
                        float neck = Float.valueOf(edt.getText().toString());
                        p.setNeck(neck);
                    }

                    edt = (EditText) findViewById(R.id.bust);
                    if ( !edt.getText().toString().equals("") ) {
                        float bust = Float.valueOf(edt.getText().toString());
                        p.setBust(bust);
                    }

                    edt = (EditText) findViewById(R.id.chest);
                    if ( !edt.getText().toString().equals("") ) {
                        float chest = Float.valueOf(edt.getText().toString());
                        p.setChest(chest);
                    }

                    edt = (EditText) findViewById(R.id.waist);
                    if ( !edt.getText().toString().equals("") ) {
                        float waist = Float.valueOf(edt.getText().toString());
                        p.setWaist(waist);
                    }

                    edt = (EditText) findViewById(R.id.hip);
                    if ( !edt.getText().toString().equals("") ) {
                        float hip = Float.valueOf(edt.getText().toString());
                        p.setHip(hip);
                    }

                    edt = (EditText) findViewById(R.id.inseam);
                    if ( !edt.getText().toString().equals("") ) {
                        float inseam = Float.valueOf(edt.getText().toString());
                        p.setInseam(inseam);
                    }

                    edt = (EditText) findViewById(R.id.record_comment);
                    String comment = edt.getText().toString();
                    p.setComment(comment);

                    personList.addPerson(p);

                    Intent intent = new Intent(AddNewRecordActivity.this, MainActivity.class);
                    startActivity(intent);

                } else {
                    Toast.makeText(getApplicationContext(), "Please enter a name", Toast.LENGTH_SHORT).show();
                }
            }
        });
        Button deleteButton = (Button) findViewById(R.id.record_delete_button);

        deleteButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                setResult(RESULT_OK);

                Intent intent = new Intent(AddNewRecordActivity.this, MainActivity.class);
                startActivity(intent);
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
            if ( personList.getList().get(s).getNeck() != 0.0f ) {
                edit.setText(Float.toString(personList.getList().get(s).getNeck()), TextView.BufferType.EDITABLE);
            }

            edit = (EditText) findViewById(R.id.bust);
            if ( personList.getList().get(s).getBust() != 0.0f ) {
                edit.setText(Float.toString(personList.getList().get(s).getBust()), TextView.BufferType.EDITABLE);
            }

            edit = (EditText) findViewById(R.id.chest);
            if ( personList.getList().get(s).getChest() != 0.0f ) {
                edit.setText(Float.toString(personList.getList().get(s).getChest()), TextView.BufferType.EDITABLE);
            }

            edit = (EditText) findViewById(R.id.waist);
            if ( personList.getList().get(s).getWaist() != 0.0f ) {
                edit.setText(Float.toString(personList.getList().get(s).getWaist()), TextView.BufferType.EDITABLE);
            }

            edit = (EditText) findViewById(R.id.hip);
            if ( personList.getList().get(s).getHip() != 0.0f ) {
                edit.setText(Float.toString(personList.getList().get(s).getHip()), TextView.BufferType.EDITABLE);
            }

            edit = (EditText) findViewById(R.id.inseam);
            if ( personList.getList().get(s).getInseam() != 0.0f ) {
                edit.setText(Float.toString(personList.getList().get(s).getInseam()), TextView.BufferType.EDITABLE);
            }

            edit = (EditText) findViewById(R.id.record_comment);
            edit.setText(personList.getList().get(s).getComment(), TextView.BufferType.EDITABLE);

            personList.deleteList(personList.getPerson(s));
        }

    }

    @Override
    public void onStop() {
        super.onStop();
    }
}
