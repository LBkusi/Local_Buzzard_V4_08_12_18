package com.lb.richardk.lbfour;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SentReceivedActivity extends AppCompatActivity {

    private DatabaseReference myRef;
    private RecyclerView alertList;
    private LinearLayoutManager mLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sent_received);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        String uid = user.getUid();

        myRef=FirebaseDatabase.getInstance().getReference().child("message").child(uid);
        myRef.keepSynced(true);

        mLayoutManager = new LinearLayoutManager(SentReceivedActivity.this);
        mLayoutManager.setReverseLayout(true);
        mLayoutManager.setStackFromEnd(true);

        alertList=(RecyclerView)findViewById(R.id.AlertView);
        alertList.setHasFixedSize(true);
        alertList.setLayoutManager(mLayoutManager);

    }

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseRecyclerAdapter<Alert,ReceivedActivity.AlertViewHolder> firebaseRecyclerAdapter=new FirebaseRecyclerAdapter<Alert, ReceivedActivity.AlertViewHolder>
                (Alert.class,R.layout.alert_row,ReceivedActivity.AlertViewHolder.class,myRef) {

            @Override
            protected void populateViewHolder(ReceivedActivity.AlertViewHolder viewHolder, Alert model, int position)
            {
                final String alertId = getRef(position).getKey();

                viewHolder.setReg(model.getReg());
                viewHolder.setSubject(model.getSubject());

                viewHolder.deleteBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String vReg = null;
                        String sub = null;
                        String uid = null;

                        Alert alert = new Alert(vReg, sub, uid);

                        myRef.child(alertId).setValue(alert);
                    }
                });
            }
        };

        alertList.setAdapter(firebaseRecyclerAdapter);
    }

    public static class AlertViewHolder extends RecyclerView.ViewHolder
    {
        View mView;
        Button deleteBtn;

        public AlertViewHolder(View itemView)
        {
            super(itemView);
            mView=itemView;
            deleteBtn = (Button)mView.findViewById(R.id.delete);
        }

        public void setReg(String reg)
        {
            TextView carReg=(TextView)mView.findViewById(R.id.carReg);
            carReg.setText(reg);
        }
        public void setSubject(String mess)
        {
            TextView message=(TextView)mView.findViewById(R.id.message);
            message.setText(mess);
        }
    }
}
