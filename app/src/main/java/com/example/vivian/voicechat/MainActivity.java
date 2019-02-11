package com.example.vivian.voicechat;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private EditText inputText;
    private Button sendText, sendVoice;
    private List<Msg> msgList = new ArrayList<>();
    private MsgAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        inputText = (EditText) findViewById(R.id.input_text);
        sendText = (Button) findViewById(R.id.btn_sendtext);
        sendVoice = (Button) findViewById(R.id.btn_sendvoice);


        initMsg();

        LinearLayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new MsgAdapter(msgList);
        recyclerView.setAdapter(adapter);

        //點選輸入文字
        sendText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msgContent = inputText.getText().toString();
                if (!msgContent.equals("")) {
                    Msg msg = new Msg(msgContent, Msg.MSGTYPE_SENT);
                    msgList.add(msg);
                    //刷新RecyclerView
                    adapter.notifyItemInserted(msgList.size() - 1);
                    //定位至最後一行
                    recyclerView.scrollToPosition(msgList.size() - 1);
                    inputText.setText("");
                    //輸入後隱藏鍵盤
                    InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(inputText.getWindowToken(), 0);
                }
            }
        });

        //點選輸入語音
        sendVoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            //待補充
            }
        });
    }

    private void initMsg() {
        Msg msg1 = new Msg("我是小高，很高興為您服務！", Msg.MSGTYPE_RECEIVED);
        Msg msg2 = new Msg("請問如何線上訂票呢？", Msg.MSGTYPE_SENT);
        msgList.add(msg1);
        msgList.add(msg2);
    }
}
