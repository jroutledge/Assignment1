package routledge.jeffrey.assignment1;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * This class is the main view class of the program.
 * It displays the record that the user has created.
 */
public class MainActivity extends AppCompatActivity {

    private ArrayList<Person> personList;
    private ArrayAdapter<Person> adapter;
    private PersonList pl = new PersonList();
    private ListView oldPersonList;

    /** Called when the activity is first created */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button newButton = (Button) findViewById(R.id.new_record);
        oldPersonList = (ListView) findViewById(R.id.record_list);


        newButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                setResult(RESULT_OK);
                Intent intent = new Intent(MainActivity.this, AddNewRecordActivity.class);
                intent.putExtra("key", -1);
                startActivity(intent);
            }
        });

        oldPersonList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent i = new Intent(MainActivity.this, AddNewRecordActivity.class);
                i.putExtra("key", position);
                startActivity(i);
            }
        });
    }


    protected void onStart() {
        super.onStart();

        personList = pl.getList();

        adapter = new ArrayAdapter<Person>(this,
                R.layout.list_item, personList);
        oldPersonList.setAdapter(adapter);
    }

    protected void onResume() {
        super.onResume();

        adapter.notifyDataSetChanged();
    }
}
